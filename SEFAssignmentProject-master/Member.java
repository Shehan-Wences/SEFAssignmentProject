
public class Member extends User {
	
	private double memberPoints;
	private String memberEmail;
	private String memberAddress;

	public Member(int userID, String userName, String userPassword,String memberEmail,String memberAddress,double memberPoints) {
		super(userID, userName, userPassword);
		this.memberPoints=memberPoints;
		this.memberEmail=memberEmail;
		this.memberAddress=memberAddress;
		

	}
	public String[] getMenuOptions() {
		String listArray[]= {"Check Loyalty Points","New Shopping Cart","Log Out"};
		return listArray;
	}

}
