import java.util.Scanner;

public class Start {
  public static void main(String[] args) {
        
    
        SignIn signininpage = new SignIn();
        
        Login loginpage = new Login(signininpage.getSignininfo());
    

    System.out.println("welcome to Codecom");
    System.out.println("Press 1 to SignIn or 2 to Login");
    Scanner input = new Scanner(System.in);
    int x = input.nextInt();

    if(x==1) {
      signininpage.setdata();
    }
    else {
      loginpage.enterdata();
    }



    
}

}