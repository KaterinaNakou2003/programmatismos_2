import java.util.Scanner;

public class Message {


	private Scanner input;


	public String setMessage() {
		input = new Scanner(System.in);
		return input.next();

	}
	// stelnei mhnyma
	public void sendMessage(String username){
		System.out.println("Type your message");
		System.out.println(username + ":" +setMessage()); // na fainetai poiow to egrapse
		// me multithreading vgainei
	}
	//dexetai mhnyma
	public void getMessage(String username) {
		System.out.println(username +"You have x new Messages"); // kapws tha syndeetai me vaseis kai tha dixnei ta posa nea
		//mhnymata exei
	}
	public void reply(String username, int numberOfMessage) {
		System.out.println("Type your message");
		System.out.println(username + " replied to " + numberOfMessage + " Message :" + setMessage() );

	}
	//tou xrhstou
	public void likeMessage() {};

	public void dislikeMessage() {};

	public void problem(int numberOfMessage) {
		System.err.println(numberOfMessage + "Message not sent");
	}
}
