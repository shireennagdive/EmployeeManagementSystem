package com.flp.ems.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.flp.ems.domain.Department;
import com.flp.ems.domain.Project;
import com.flp.ems.domain.Role;

@Repository
public class EmployeeSupportDetails {
	
	@PersistenceContext
	private EntityManager entitymanager;
	
	public EmployeeSupportDetails() {
		System.out.println("Employee Support Details instantiated");
	}
	@Transactional
	public List<Role> getRoles()
	{
		return entitymanager.createQuery("from Role").getResultList();
	}
	
	@Transactional
	public Role getRole(String name)
	{
		List <Role> role;
		Role r=new Role(5,"GM","General Manager");
		Query q= entitymanager.createQuery("select r from Role r where r.id= :rolename");
		q.setParameter("rolename", Integer.parseInt(name));
		role=q.getResultList();
		if(role.size()!=0)
			r=role.get(0);
		System.out.println("Role Selected: "+r);
		return r;
	}
	
	@Transactional
	public List<Department> getDepartmentName()
	{
		return entitymanager.createQuery("from Department").getResultList();
	}
	
	@Transactional
	public List<Project> getProjects()
	{
		return entitymanager.createQuery("from Project").getResultList();
	}
	
	@Transactional
	public Department getDepartment(String name)
	{
		List <Department> dept;
		Department dep=new Department("general", "general department", 5);
		System.out.println(entitymanager);
		Query q= entitymanager.createQuery("select r from Department r where r.id= :rolename");
		q.setParameter("rolename", Integer.parseInt(name));
		dept=q.getResultList();
		if(dept.size()!=0)
			dep=dept.get(0);
		System.out.println("Department Selected: "+dep);
		return dep;
	}
	
	@Transactional
	public Project getProject(String name)
	{
		List <Project> pro;
		Department dep=new Department("general", "general department", 5);
		Project p=new Project(9, "GEN", "General department", dep);
		Query q= entitymanager.createQuery("select r from Project r where r.id= :rolename");
		q.setParameter("rolename", Integer.parseInt(name));
		pro=q.getResultList();
		if(pro.size()!=0)
			p=pro.get(0);
		return p;
	}
	
	@Transactional
	public List<Project> getProjectID(int id)
	{
		Department dep=new Department("general", "general department", 5);
		Project p=new Project(9, "GEN", "General department", dep);
		
		List <Project> pro=entitymanager.createQuery("from Project p where p.department.id="+id).getResultList();
		
		System.out.println("Project Selected: "+pro);
		return pro;
	}

}
	
