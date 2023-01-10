package com.CodeCom.app;

import java.util.Scanner;
public class Logout {

	Scanner input = new Scanner(System.in);
	boolean flag;

	public boolean getLogout(String answer) {
		if (answer.equals("y") || answer.equals("Y")) {
			System.out.println("Bye.. Hope you liked our app");
			flag = true;
		} else 	if (answer.equals("N") || answer.equals("n")) {
			flag = false;
		} else {
			falseInput();
		}
		return flag;
	} // close getLogout


	public boolean falseInput() {
		System.out.println("Please type correctly!! (Y/N)");
		 String ans = input.next();
		if (ans.equals("N") || ans.equals("n")) {
			flag = false;
		} else if (ans.equals("y") || ans.equals("Y")) {
			flag = true;
		} else {
			falseInput();
		} //close if
		return flag;
	} // close falseInput

} // close classs