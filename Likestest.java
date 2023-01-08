import static org.junit.Assert.*;

import org.junit.Test;

public class LikesTest {

	@Test
	public void testLikedUser() {
		Likes likes = new Likes();
		String expected = "John Doe";
		String actual = likes.likedUser(1);
		assertEquals(expected, actual);
	}

	@Test
	public void testMessageBody() {
		Likes likes = new Likes();
		String expected = "This is a test message";
		String actual = likes.messageBody(1);
		assertEquals(expected, actual);
	}

	@Test
	public void testLikeCounter() {
		Likes likes = new Likes();
		int expected = 10;
		int actual = likes.likeCounter(1);
		assertEquals(expected, actual);
	}

	@Test
	public void testUpdateLikes() {
		Likes likes = new Likes();

	        String username = "John Doe";
		String likedname = "Jane Doe";
		int y = 1;
		int expected = 11;
		likes.updateLikes(username, likedname, y);
		int actual = likes.likeCounter(1);
		assertEquals(expected, actual);
	}


}

