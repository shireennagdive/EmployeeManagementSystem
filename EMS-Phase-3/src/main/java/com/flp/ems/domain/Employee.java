package com.flp.ems.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue
	private int empId;
	
	@NotEmpty(message="* Please Enter Name.")
	@Column(unique=true)
	private String name;
	@NotEmpty(message="* Please Enter KinID.")
	@Column(unique=true)
	private String kinid;
	@Range(min=1000000000,message="* Phone Number should atleast be 10 disgits")
	private long phoneno;
	@Past(message="* please enter the date of birth as a past date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date empDob;
	@Past(message="* please enter the date of joining as the future date to Date of birth")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date empDoj;
	private String address;
	@Email(message="* Please enter a valid EmailID")
	@NotEmpty(message="* Please Enter EmailID")
	@Column(unique=true)
	private String emailid;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="roleid")
	private Department department;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="proid")
	private Project project;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="deptid")
	private Role role;
	
	public Employee(){
		empId=-1;
	}
	
	

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", kinid=" + kinid + ", phoneno=" + phoneno + ", empDob="
				+ empDob + ", empDoj=" + empDoj + ", department=" + department + ", project=" + project + ", address="
				+ address + ", emailid=" + emailid + ", role=" + role + "]";
	}



	public Employee(int empId, String name, String kinid, long phoneno, Date empDob, Date empDoj, String address,
			String emailid, Department department, Project project, Role role) {
		super();
		this.empId = empId;
		this.name = name;
		this.kinid = kinid;
		this.phoneno = phoneno;
		this.empDob = empDob;
		this.empDoj = empDoj;
		this.address = address;
		this.emailid = emailid;
		this.department = department;
		this.project = project;
		this.role = role;
	}



	public int getEmpId() {
		return empId;
	}



	public void setEmpId(int empId) {
		this.empId = empId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getKinid() {
		return kinid;
	}



	public void setKinid(String kinid) {
		this.kinid = kinid;
	}



	public long getPhoneno() {
		return phoneno;
	}



	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}



	public Date getEmpDob() {
		return empDob;
	}



	public void setEmpDob(Date empDob) {
		this.empDob = empDob;
	}



	public Date getEmpDoj() {
		return empDoj;
	}



	public void setEmpDoj(Date empDoj) {
		this.empDoj = empDoj;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getEmailid() {
		return emailid;
	}



	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}



	public Department getDepartment() {
		return department;
	}



	public void setDepartment(Department department) {
		this.department = department;
	}



	public Project getProject() {
		return project;
	}



	public void setProject(Project project) {
		this.project = project;
	}



	public Role getRole() {
		return role;
	}



	public void setRole(Role role) {
		this.role = role;
	}

	

}
