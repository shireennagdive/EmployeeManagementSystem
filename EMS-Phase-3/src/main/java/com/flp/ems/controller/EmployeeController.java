package com.flp.ems.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.flp.ems.dao.EmployeeSupportDetails;
import com.flp.ems.domain.Department;
import com.flp.ems.domain.Employee;
import com.flp.ems.domain.Project;
import com.flp.ems.domain.Role;
import com.flp.ems.service.IEmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;
	
	@Autowired
	private EmployeeSupportDetails details;
	
	Employee emp;
	
	@ModelAttribute("emp")
	public Employee getEmployee(){
		return new Employee();
	}
	
	@RequestMapping("/")
	public String welcomefile(){
		return "index";
	}
	
	@RequestMapping("/showEmp")
	String viewAllCars(ModelMap map){
		map.put("employees", employeeService.getAllEmployee());
		
		return "viewAllEmp";
	}
	
	@RequestMapping(value={"/employeeForm","/edit"})
	public String showEmployeeForm(@RequestParam(value="id",required=false) String empId,ModelMap map){
		
		int id;
		if(empId!=null)
		 id=Integer.parseInt(empId);
		else
			id=-1;
		if(id!=-1){
			emp=employeeService.SearchEmployee(id);
			map.put("emp",emp);
		}
		System.out.println( employeeService.getAllEmployee());
		map.put("deps", details.getDepartmentName());
		map.put("roles",details.getRoles());
		map.put("projects", details.getProjects());
		
		return "addEmp";
	}
	
	@RequestMapping(value="/empSave",method=RequestMethod.POST)
	public String saveEmployee(@RequestParam("department")String deptname,@RequestParam(value="project")String proname,@RequestParam("role")String rolename,@Valid @ModelAttribute("emp")Employee employee,BindingResult results,ModelMap map){
		map.put("deps", details.getDepartmentName());
		map.put("roles",details.getRoles());
		map.put("projects", details.getProjects());
		map.put("employees", employeeService.getAllEmployee());
		
		System.out.println("Project Selected="+proname);
		
		employee.setRole(details.getRole(rolename));
		employee.setDepartment(details.getDepartment(deptname));
		employee.setProject(details.getProject(proname));
		
		System.out.println(employee);
	
		if(results.hasErrors()){
			System.out.println("errros: "+results.getAllErrors());
			return "addEmp";
		}else{
		if(employee.getEmpId()==-1)
			employeeService.AddEmployee(employee);
		else
			employeeService.ModifyEmployee(employee);
		return "redirect:showEmp";
		}
	
	}

	@RequestMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("id") int[] employeeId){
		employeeService.RemoveEmployee(employeeId);
		return "redirect:showEmp";
	}

	
	@RequestMapping(value="/searchEmp", method=RequestMethod.POST)
	public String searchEmp(@RequestParam("searchval") String id, ModelMap map){
		map.put("deps", details.getDepartmentName());
		map.put("roles",details.getRoles());
		map.put("projects", details.getProjects());
		Employee e=employeeService.SearchEmployee(Integer.parseInt(id));
		System.out.println(e);
		List<Employee> em=new ArrayList<>();
		em.add(e);
		System.out.println(em);
		map.addAttribute("semp", em);
		return "viewAllEmp";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    binder.registerCustomEditor(Department.class, new DepartmentEditor(details));
	    binder.registerCustomEditor(Role.class, new RoleEditor(details));
	    binder.registerCustomEditor(Project.class, new ProjectEditor(details));
	}
	
	@RequestMapping("/showpro")
	public String getPro(@RequestParam("q") String dept,ModelMap map){
		List<Project> prolist=details.getProjectID(Integer.parseInt(dept));
		map.addAttribute("projectli",prolist);
		return "projectlist";
	}
}
	
	

