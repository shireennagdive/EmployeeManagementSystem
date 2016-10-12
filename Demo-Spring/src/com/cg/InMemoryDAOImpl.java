package com.cg;

import java.util.LinkedList;
import java.util.List;

public class InMemoryDAOImpl implements IDao {

	@Override
	public List<String> getMessages() {
		// TODO Auto-generated method stub
		String m1="Heloo 1";
		String m2="Heloo 2";
		List<String> messages = new LinkedList<String>();
		messages.add(m1);
		messages.add(m2);
		return messages  ;
	}

}
