package com.flp.ems.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.flp.ems.domain.Employee;

@Repository
public class EmployeeDaoImplforJPA implements IemployeeDao {

	@PersistenceContext
	private EntityManager entitymanager;
	
	@Override
	@Transactional
	public void AddEmployee(Employee emp) {
		try{
			entitymanager.persist(emp);
		}catch(RuntimeException exception){
			throw exception;
		}finally{
			entitymanager.close();
		}
	}

	@Override
	@Transactional
	public void ModifyEmployee(Employee emp) {
		try {
			entitymanager.merge(emp);
		} catch (RuntimeException e) {
			throw e;
		} finally {
			entitymanager.close();
		}

	}

	@Override
	@Transactional
	public void RemoveEmployee(int[] id) {
		try {
			for(int sID : id){
				Employee emp=entitymanager.find(Employee.class, sID);
				entitymanager.remove(emp);
			}
		} catch (RuntimeException e) {
			throw e;
		} finally {
			entitymanager.close();
		}	
	}

	@Override
	@Transactional
	public Employee SearchEmployee(String id) {
		Employee emp=(Employee) entitymanager.find(Employee.class, Integer.parseInt(id));
		return emp;
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployee() {
		try {
			Query query = entitymanager.createQuery("select emp from Employee emp");
			return query.getResultList();
		} finally {
		entitymanager.close();
		}
	}

}
