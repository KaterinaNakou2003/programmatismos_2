package net.codejava.sql;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AccountTest {
    @Test
    public void testAddAccount() {
        // setup
        Account account = new Account();

        // exercise
        int result = account.addAccount("eri", "12345");

        // verify
        assertEquals(1, result);
    }
}