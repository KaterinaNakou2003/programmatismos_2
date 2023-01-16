package net.codejava.sql;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import org.junit.Test;

public class TestMessage {
	@Test
	public void testReply() {
		Message tester = new Message();
		String actual = tester.reply("lambriniarv", "whats wrong?",7);
		String expected = "lambriniarv replied to ughhhhhhhh  : whats wrong?";
		assertTrue( actual.equals(expected) );
		actual = tester.reply("katerinanakou", "exit",1);
		expected = "ACTION CANCELLED";
		assertTrue( actual.equals(expected) );
	}

	@Test
	public void testFindLastMessage() {
		Message tester = new Message();
		boolean actual = tester.findLastMessage(6);
		boolean expected = true;
		assertTrue( actual == expected );
		actual = tester.findLastMessage(1000);
		expected = false;
		assertTrue( actual == expected );
	}
}
