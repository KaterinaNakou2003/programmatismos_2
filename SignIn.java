import java.util.HashMap;
import java.util.Scanner;

public class SignIn {

String username,password;

Scanner input = new Scanner(System.in);

HashMap<String,String> signininfo = new HashMap<>();

public void setdata() {
    System.out.println("Enter Username");
    username = input.nextLine();
    System.out.println("Enter Password");
    password = input.nextLine();
    
    System.out.println("Welcome " +username);
}
SignIn(){
signininfo.put(username,password);
}
protected HashMap getSignininfo(){
    return signininfo;
}








}