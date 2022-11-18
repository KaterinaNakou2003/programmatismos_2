import java.util.HashMap;
import java.util.Scanner;

public class Login {
String username,password;
Scanner input = new Scanner(System.in);

HashMap<String,String> signininfo = new HashMap<String,String>();
    
Login(HashMap<String,String> signinoriginal){
    signininfo = signinoriginal;
}
public void againEnterdata(){
    System.out.println("Enter Username");
    username = input.nextLine();
    System.out.println("Enter Password");
    password = input.nextLine();
}
public void againPass() {
    System.out.println("Enter Password Again");
    password = input.nextLine();
}

public void enterdata() {
    System.out.println("Enter Username");
    username = input.nextLine();
    System.out.println("Enter Password");
    password = input.nextLine();

    if(signininfo.containsKey(username)) {
        if(signininfo.get(username).equals(password)) {
            System.out.println("login successful");
            System.out.println("Welcome " +username);
        }
        else {
            System.out.println("Wrong Password");
            againPass();
        }
    }
    else {
        System.out.println("Username not found");
        againEnterdata();
    
    }
}
}
