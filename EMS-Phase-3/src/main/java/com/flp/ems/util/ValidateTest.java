package com.flp.ems.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidateTest {
	
	@Test
	public void testValidateDate() {
		assertTrue(Validate.validateDate("1994-05-02"));
		assertFalse(Validate.validateDate("1994/05/02"));
		assertFalse(Validate.validateDate("19940205"));
		assertFalse(Validate.validateDate("02/05/2016"));
		assertFalse(Validate.validateDate(""));
		assertFalse(Validate.validateDate("on-feb-2016"));
	}

	@Test
	public void testValidatePhone() {
		assertTrue(Validate.validatePhone("9176452394"));
		assertFalse(Validate.validatePhone("123456"));
		assertFalse(Validate.validatePhone("asdfghjklp"));
		assertFalse(Validate.validatePhone("123/2542+"));
		assertFalse(Validate.validatePhone(""));
	}

	@Test
	public void testValidateKinid() {
		assertTrue(Validate.validateKinid("71903_FS"));
		assertFalse(Validate.validateKinid(""));
	}

	@Test
	public void testValidateemailid() {
		assertTrue(Validate.validateemailid("anitageorge@gmai.com"));
		assertFalse(Validate.validateemailid(""));
		assertFalse(Validate.validateemailid("anitageorge"));
	}

	@Test
	public void testValidatename() {
		assertTrue(Validate.validatename("anita"));
		assertFalse(Validate.validatename(""));
		assertTrue(Validate.validatename("anita123"));
	}

}
