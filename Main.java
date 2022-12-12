import java.util.Scanner;

public class Main {
     public static void main(String[] args) {
        
            Person person = new Person();
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
                person.setUsername();
                person.setPassword();


                if (person.checkUsername(person.getUsername())) {
                  System.out.println ("This username already exists");
                  System.out.println ("Try again");
                  person.setUsername();
                  person.setPassword();
                } else {
                
              int result = person.addPerson(person.getUsername(),person.getPassword());
                
              
              if (result==1) {
                String username = person.getUsername();
                System.out.println("Welcome " + username);
              } else {
                System.out.println("Person not added:Error");
              } }

            } else {
                person.setUsername();
                person.setPassword();
                person.verifyPerson(person.getUsername(),person.getPassword());
            }  
            }
          }
            
            
            
             
    

    

