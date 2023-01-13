import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Account {
    private String username,password;
    Connection conn;
    PreparedStatement insertnewAccount;
    PreparedStatement findAccount;
    PreparedStatement checkUsername;
      
    //o xrhsths eisagei to username tou    
    public void setUsername() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your username:");
        this.username = input.nextLine();
        while(username.length()>20) {
        System.out.println("Your username should contain only 20 characters ");
        this.username = input.nextLine();
        }

        
    }
    //o xrhsths eisagei ton kwdiko tou
    public void setPassword() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your password:");
            this.password= input.nextLine();

            while (password.length()>15) {
            System.out.println("Your password should contain only 15 characters ");
            this.password= input.nextLine();
            }
    }
    // epistefei to username 
    public String getUsername() {
        return username;
    }
    //epistrefei ton kwdiko
        public String getPassword() {
            return password;
        }
        
    
/*   periexei ta queries gia mia kainourgia eggrafh(Insert sth bash),gia thn syndesh sthn efarmogh(briskei an yparxei
sth bash yparxon logariasmo) kai elegxei na mhn eisax8ei sth bash kapoio hdh yparxon logariasmos */
    public Account() {
        try {
            conn = DriverManager.getConnection(
                "jdbc:sqlserver://DESKTOP-NVDOEDC:1433;"
                + "DatabaseName=Codecom;encrypt=true;trustServerCertificate=true;", "Progr2", "programmatismos2");
        
                checkUsername=conn.prepareStatement("Select * from Users where username=?");
                insertnewAccount = conn.prepareStatement("Insert into Users" + "(username,password)" + "values (?,?)");
                findAccount = conn.prepareStatement("Select username,password from Users where username=? and password=?");
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                System.exit(1);
            }
    }
//elegxos gia na mhn yparxei idio username kai ara logariasmos    
    public boolean checkUsername(String Username) {
        ResultSet res = null;
        boolean checkUser = false;
        try {
            checkUsername.setString(1, Username);
            res =checkUsername.executeQuery();
            if (res.next()) {
                checkUser = true;
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
            close();
        }
        return checkUser;
    }
//ginetai mia nea eggrafh
    public int addAccount(String username,String password) {
        
        int result = 0;

        try {
            insertnewAccount.setString(1, username);
            insertnewAccount.setString(2, password);
        result = insertnewAccount.executeUpdate();
        } catch (SQLException  sqlException) {
            sqlException.printStackTrace();
            close();  
        }
        return result;
    }
//ginetai eisodos efoson yparxei aytos o logariasmos

    public boolean verifyAccount(String username,String password) {
        ResultSet rs=null;
        boolean checkAccount = false;

        try {
         findAccount.setString(1, username);
         findAccount.setString(2, password);   
            rs=findAccount.executeQuery();

           // int count=0;

    if(rs.next()) {
        //count = count + 1;
        checkAccount=true;
    }
} catch (SQLException sqlException) {
    System.out.println(sqlException);
    close();
}
return checkAccount;
    }
    /*if (count==1) {

        String ur=getUsername(); 
        System.out.println("Sign In Successfull");
        System.out.println("Hello " + ur);
    }else if(count>1){
        System.out.println("Access denied douplicate account");
    
    } else {
        System.out.println("Account not found");
    } 
} catch(Exception x) {
    System.out.println("DB Connection Exception " + x);
} finally  {
    try {
        rs.close();
    } catch (SQLException sqlException) {
        sqlException.printStackTrace();
        close();
    }
}


        }*/

    

        public void close() {
            try {
                conn.close();

            } catch (SQLException sqlException)
            {
                sqlException.printStackTrace();
            }
        }


}

     