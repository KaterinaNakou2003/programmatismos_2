package com.CodeCom.app;

import static org.junit.Assert.*;

import org.junit.Test;

public class LogoutTest {

	@Test
	public void testGetLogout() {
		Logout logout = new Logout();
		boolean actual = logout.getLogout("Y");
		boolean expected = true;
		assertTrue( actual==expected);
		actual = logout.getLogout("y");
		expected = true;
		assertTrue( actual==expected);
		actual = logout.getLogout("N");
		expected = false;
		assertTrue( actual==expected);
		actual = logout.getLogout("n");
		expected = false;
		assertTrue( actual==expected);
	}

}