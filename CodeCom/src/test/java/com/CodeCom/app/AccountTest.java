package com.CodeCom.app;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AccountTest {
    @Test
    public void testAddAccount() {
        // setup
        Account account = new Account();

        // exercise
        int result = account.addAccount("testuser5", "testpass5");

        // verify
        assertEquals(1, result);
    }
}
