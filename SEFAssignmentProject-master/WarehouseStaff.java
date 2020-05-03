
public class WarehouseStaff extends User {

	public WarehouseStaff(int userID, String userName, String userPassword) {
		super(userID, userName, userPassword);
		
	}
	public String[] getMenuOptions() {
		String listArray[]= {"Replenish Stock","View Product List","Change Username","Change Password","Log Out"};
		return listArray;
	}

}
