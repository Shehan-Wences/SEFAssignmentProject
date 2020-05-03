import java.util.Scanner;

abstract public class User {

	protected int userID;
	protected String userName;
	protected String userPassword;

	public User(int userID, String userName, String userPassword) {
		this.userID = userID;
		this.userName = userName;
		this.userPassword = userPassword;
	}
	
	abstract public String[] getMenuOptions();
	
	public int getuserID() {
		return this.userID;
	}
	
	public String getuserName() {
		return this.userName;
	}

	public String getuserPassword() {
		return this.userPassword;
	}
	public void changeuserName() {
		Scanner myObj = new Scanner(System.in);
	    System.out.println("Enter new Username");
	    String userName = myObj.nextLine(); 
	    this.userName=userName;
	}
	public void changeuserPassword() {
		Scanner myObj = new Scanner(System.in);
	    System.out.println("Enter new Password");
	    String userPassword = myObj.nextLine(); 
	    this.userPassword=userPassword;
	}
}
