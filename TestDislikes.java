 import static org.junit.Assert.*;
 import org.junit.Test;

 public class TestDislikes {

     @Test
     public void testDislikedUser() {
         Dislikes dislike = new Dislikes();
         String expected = "Anna";
         String actual = dislike.dislikedUser(1);
         assertEquals(expected, actual);
	 }

	 @Test
	 	 public void testMessageBody() {
	 	 Dislikes dislike = new Dislikes();
	 	 String expected = "Hi People!";
	 	 String actual = dislike.messageBody(1);
	 	 assertEquals(expected, actual);
    }

     @Test
     public void testDislikeCounter() {
         Dislikes dislike = new Dislikes();
         int expected = 3;
         int actual = dislike.dislikeCounter(1);
         assertEquals(expected, actual);
     }

     @Test
 	 public void testUpdateDislikes() {
 		 Dislikes dislike = new Dislikes();
 		 String username = "Maria";
   		 String dislikedname = "Anna";
         int y = 1;
 	     int expected = 4;
 	     dislike.updateDislikes(username, dislikedname, y);
 		 int actual = dislike.dislikeCounter(1);
 		 assertEquals(expected, actual);
 	}
}