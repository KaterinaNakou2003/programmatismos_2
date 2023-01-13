import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AccountTest {
    @Test
    public void testAddAccount() {
        // setup
        Account account = new Account();

        // exercise
        int result = account.addAccount("testuser", "testpass");

        // verify
        assertEquals(1, result);
    }
}