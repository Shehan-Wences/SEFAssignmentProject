
public class SalesStaff extends User {

	public SalesStaff(int userID, String userName, String userPassword) {
		super(userID, userName, userPassword);

	}
	public String[] getMenuOptions() {
		String listArray[]= {"Return Product","View Product List","Change Username","Change Password","Log Out"};
		return listArray;
	}

}
