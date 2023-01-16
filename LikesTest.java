package net.codejava.sql;

import static org.junit.Assert.*;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import org.junit.Test;

public class LikesTest {

	@Test
	public void testLikeCounter() {
		Likes likes = new Likes();
		int expected = 1;
		int actual = likes.likeCounter(2);
		assertEquals(expected, actual);
	}
}
