package com.cg;

import java.util.List;

public class MyServiceImpl implements IService {
	
	private IDao daoRef;
	public MyServiceImpl(IDao daoRef) {
		this.daoRef = daoRef;
	}
	@Override
	public List<String> getMessages() {
		// TODO Auto-generated method stub
		return daoRef.getMessages();
	}
	
	public void setDaoRef(IDao daoRef) {
		this.daoRef = daoRef;
	}

}
