import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Person {
    private String username,password;
    Connection conn;
    PreparedStatement insertnewperson;
    PreparedStatement findperson;
    PreparedStatement checkUsername;
      
    //o xrhsths eisagei to username tou    
    public void setUsername() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your username:");
        this.username = input.nextLine();
        if(username.length()>20)
        System.out.println("Your username should contain only 20 characters ");
        setUsername();
        
    }
    //o xrhsths eisagei ton kwdiko tou
    public void setPassword() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your password:");
            this.password= input.nextLine();
            if(password.length()>15)
            System.out.println("Your password should contain only 15 characters ");
            setPassword();
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
    public Person() {
        try {
            conn = DriverManager.getConnection(
                "jdbc:sqlserver://DESKTOP-NVDOEDC:1433;"
                + "DatabaseName=Codecom;encrypt=true;trustServerCertificate=true;", "Progr2", "programmatismos2");
        
                checkUsername=conn.prepareStatement("Select * from Users where username=?");
                insertnewperson = conn.prepareStatement("Insert into Users" + "(username,password)" + "values (?,?)");
                findperson = conn.prepareStatement("Select username,password from Users where username=? and password=?");
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
    public int addPerson(String username,String password) {
        
        int result = 0;

        try {
            insertnewperson.setString(1, username);
            insertnewperson.setString(2, password);
        result = insertnewperson.executeUpdate();
        } catch (SQLException  sqlException) {
            sqlException.printStackTrace();
            close();  
        }
        return result;
    }
//ginetai eisodos efoson yparxei aytos o logariasmos
    public void verifyPerson(String username,String password) {
        
        ResultSet rs=null;
        try {
         findperson.setString(1, username);
         findperson.setString(2, password);   
            rs=findperson.executeQuery();
            int count=0;

    while(rs.next()) {
        count = count + 1;
    }
    if (count==1) {
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

        }
    

        public void close() {
            try {
                conn.close();

            } catch (SQLException sqlException)
            {
                sqlException.printStackTrace();
            }
        }


}

     