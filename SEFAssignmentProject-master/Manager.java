import java.util.Scanner;

public class Manager extends User {

	public Manager(int userID, String userName, String userPassword) {
		super(userID, userName, userPassword);

	}

	public String[] getMenuOptions() {
		String listArray[]= {"User Management","Report Generation","Supplier Management","View Product List","Set Discounts","Log Out"};
		return listArray;
	}

}
