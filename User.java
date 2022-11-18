import java.util.Scanner;

public class User {
	protected  static String username;
	private static String password;

	public static void main(String[] args) {
		//syndesh me to login kai signin part
		//Start start = new Start();  perimenw ton eri
		//username = getUsername();
		//password = getPassword();

		int action=0, y;
		String answer=null;
		System.out.println("Welcome to Codecom " + username + " !");
		System.out.println( "\n What do you want to do \n 1.Post something \n 2.Like a message \n 3.Like a message \n 4.Reply \n 5.Settings \n 6.Logout");
		Scanner input = new Scanner(System.in);
		try{
			action = input.nextInt();
		} catch (Exception E) {
			 System.err.println("User input was not a number.");
		}

		// sundesh me th message
		Message message = new Message();
		boolean flag = false ;

		while (action!=6 || flag!= true) {
			if (action==1)
				message.sendMessage(username);
			else if (action==2) {
				System.out.println("Type the number of the message you want to like: ");
				y = input.nextInt();
				message.likeMessage(y); // username autou pou to kanei & username autoy pou to stelnei mesw bd
				System.out.println();
			} else if (action==3) {
				System.out.println("Type the number of the message you want to dislike: ");
				y = input.nextInt();
				message.dislikeMessage(y); // username autou pou to kanei & username autoy pou to stelnei mesw bd
				System.out.println();
			} else if (action==4) {
				// moliw mpei h vash
				//briskv to y se poio username antistoixei kai to reply tha ginei typou (string, string)
				System.out.print("Type the number of the message you want to reply to: ");
				 y = input.nextInt();
				message.reply(username, y);
			} else if (action == 6) {
				System.out.println(" Are you sure you want to leave; (Yes/No) ");
				answer = input.next();
				System.out.println(answer);
				if (answer == "Yes" || answer == "yes") {
					flag = true;
				} else if (answer != "No" && answer != "no") {
					System.out.println("Please type correctly!! (Yes/No)");
					answer = input.next();
					if (answer == "Yes" || answer== "yes") {
						flag = true;
					}
				}

			}
			if (flag != true) { // mporei panv na egine true alla am janarvthsv ti na kanei kai allajei den tha teelivsei o vroxos
				System.out.println("What do you want to do next");
				action = input.nextInt();
			}
		} // telos while

	} // telos main

} // telos user

} // telos user
