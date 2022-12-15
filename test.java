import java.util.Scanner;

public class TEST {
     public static void main(String[] args) {
        
            Account account = new Account();
            int x;
            while(true) {
            System.out.println("welcome to Codecom");
            System.out.println("Press 1 to SignUp or 2 to SignIn");
            Scanner input = new Scanner(System.in);
            try {
             x = input.nextInt();
            break;
            } catch(Exception wException) {
              System.out.println("There was mismatch"); 
            input.nextLine();
            }
            }
        
            if(x==1) {
                account.setUsername();
                account.setPassword();


                if (account.checkUsername(account.getUsername())) {
                  System.out.println ("This username already exists");
                  System.out.println ("Try again");
                  account.setUsername();
                  account.setPassword();
                } else {
                
              int result = account.addAccount(account.getUsername(),account.getPassword());
                
              
              if (result==1) {
                String username = account.getUsername();
                System.out.println("Welcome " + username);
              } else {
                System.out.println("Person not added:Error");
              } }

            } else {
                account.setUsername();
                account.setPassword();
                account.verifyAccount(account.getUsername(),account.getPassword());
            }  
            }
          }
            
            
            
             
    

    

