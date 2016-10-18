package com.flp.ems.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "proid")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String desc;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="deptid")
	private Department department;
	
	@OneToMany(mappedBy="project",cascade=CascadeType.ALL)
	private Set<Employee> employees;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	

	public Project() {
	}

	
	public Project(int id, String name, String desc, Department department) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.department = department;
	}

	@Override
	public String toString() {
		return getName();
	}
}
