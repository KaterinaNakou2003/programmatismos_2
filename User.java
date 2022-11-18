import java.util.Scanner;

public class User {
	protected  static String username = "yeah";
	private static String password;

	public static void main(String[] args) {

		System.out.println("Welcome to Codecom " + username + " !");
		System.out.println( "\n What do you want to do \n 1.Post something \n 2.Like a message \n 3.Like a message \n 4.Reply \n 5.Settings \n 6.Logout");
		Scanner input = new Scanner(System.in);
		int action = input.nextInt();
		Message message = new Message(); // syndesh me class Message
		boolean flag = false ;
		try{
			while (action!=6 || flag!= true) {
				if (action==1)
					message.sendMessage(username);
				else if (action==2) {
					System.out.print("Type the number of the message you want to like: ");
					message.likeMessage(); // username autou pou to kanei & username autoy pou to stelnei mesw bd
					System.out.println();
				} else if (action==3) {
					System.out.print("Type the number of the message you want to like: ");
					message.dislikeMessage(); // username autou pou to kanei & username autoy pou to stelnei mesw bd
					System.out.println();
				} else if (action==4) {
					// moliw mpei h vash
					//briskv to y se poio username antistoixei kai to reply tha ginei typou (string, string)
					System.out.print("Type the number of the message you want to reply to: ");
					int y = input.nextInt();
					message.reply(username, y);
				} else if (action == 6) {
					System.out.println(username+" Are you sure you want to leave;(Y/N) ");
					String answer = input.next();
					if (answer == "Y" || answer == "y")
						flag = true;
					else if (answer != "Y" && answer != "N" && answer != "y" && answer != "n") {
						System.out.println("Please type correctly!! (Y/N)");
						answer = input.next();
						if (answer == "Y" || answer== "Y")
							flag = true;
					}
				}
				System.out.println("What do you want to do next");
				action = input.nextInt();

			}
		} catch (Exception E) {
				 System.err.println("User input was not a number.");
		}


	}

}