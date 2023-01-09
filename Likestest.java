import static org.junit.Assert.*;
import org.junit.Test;

public class TestLikes {

    @Test
    public void testLikedUser() {
        Likes like = new Likes();
        String expected = "John";
        String actual = like.likedUser(1);
        assertEquals(expected, actual);
    }

    @Test
    public void testMessageBody() {
        Likes like = new Likes();
        String expected = "Hello World!";
        String actual = like.messageBody(1);
        assertEquals(expected, actual);
    }

    @Test
    public void testLikeCounter() {
        Likes like = new Likes();
        int expected = 3;
        int actual = like.likeCounter(1);
        assertEquals(expected, actual);
    }

    @Test
    public void testUpdateLikes() {
    Likes like = new Likes();
    String username = "Maria";
    String likedname = "John";
    int y = 1;
    int expected = 4;
    like.updateLikes(username, likedname, y);
    int actual = like.likeCounter(1);
    assertEquals(expected, actual);
    }
	
}
