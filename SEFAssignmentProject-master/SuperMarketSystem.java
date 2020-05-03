import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class SuperMarketSystem {

	ArrayList<User> userList = new ArrayList<User>();

	private User currentUser;
	private int currentNumberofUsers;

	public SuperMarketSystem() {

		this.currentNumberofUsers = 0;
		userDataLoad();
		

		login();

	}

	public void userDataLoad() {

		String line = "";

		try (BufferedReader br = new BufferedReader(new FileReader("users.csv"))) {
			while ((line = br.readLine()) != null) {
				String[] userArray = line.split(",");
				int id = Integer.parseInt(userArray[1]);
				if (userArray[0].equals("manager")) {
					userList.add(new Manager(id, userArray[2], userArray[3]));
				} else if (userArray[0].equals("warehousestaff")) {
					userList.add(new WarehouseStaff(id, userArray[2], userArray[3]));
				} else if (userArray[0].equals("salesstaff")) {
					userList.add(new SalesStaff(id, userArray[2], userArray[3]));
				} else if (userArray[0].equals("member")) {
					userList.add(new Member(id, userArray[2], userArray[3], userArray[4], userArray[5],
							Double.parseDouble(userArray[6])));
				}

				this.currentNumberofUsers++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
	}

	public boolean validateLogin(String username, String password) {
		boolean found = false;
		int index = 0;
		while (index < this.currentNumberofUsers) {
			if (userList.get(index).getuserName().equals(username)
					&& userList.get(index).getuserPassword().equals(password)) {
				found = true;
				this.currentUser = userList.get(index);
			}
			index++;
		}
		return found;
	}

	public void login() {
		String loginusername = "";
		String loginuserpassword = "";
		int attempt = 3;
		while (attempt > 0 && loginusername != null && loginuserpassword != null) {
			attempt--;
			Scanner myObj = new Scanner(System.in);
			System.out.println("Enter Username");
			loginusername = myObj.nextLine();
			System.out.println("Enter Password");
			loginuserpassword = myObj.nextLine();
			if (validateLogin(loginusername, loginuserpassword) == true) {
				attempt = 3;
				showMenu();
				break;
			} else {
				System.out.println("Username/Password is incorrect (" + attempt + "attempt's remaining)");
			}
		}
		if (attempt == 0) {
			System.out.println("Contact Administrator for help");
		}
	}
	
	public void logOut() {
		
		this.currentUser=null;
		login();
				
		
	}

	public void showMenu() {

		Scanner myObj = new Scanner(System.in);
		System.out.println("Logged in as : " + currentUser.getuserName() + "");
		String listArray[] = currentUser.getMenuOptions();
		System.out.println("\nMain Menu\n");
		for (int i = 0; i < listArray.length; i++) {
			System.out.println((i + 1) + ". " + listArray[i]);
		}
		System.out.println("");
		System.out.println("Enter Option : ");
		String option = myObj.nextLine();

		if (currentUser instanceof Manager) {
			while (true) {
				if (option.equals("1")) {
					// userManagement() method show another menu
					break;
				} else if (option.equals("2")) {
					// reportGeneration() method show another menu
					break;
				} else if (option.equals("3")) {
					// supplierManagement() method show another menu
					break;
				} else if (option.equals("4")) {
					// viewProductList() method
					break;
				} else if (option.equals("5")) {
					// setDiscounts() method
					break;
				} else if (option.equals("6")) {
					logOut();
					break;
				} else {
					System.err.println("Please Enter a valid Option");
					System.out.println("Enter Option : ");
					option = myObj.nextLine();
				}
			}
		} else if (currentUser instanceof SalesStaff) {
			while (true) {
				if (option.equals("1")) {
					// returnProduct() method
					break;
				} else if (option.equals("2")) {
					// viewProductList() method
					break;
				} else if (option.equals("3")) {
					// changeUsername() method
					break;
				} else if (option.equals("4")) {
					// changePassword() method
					break;
				} else if (option.equals("5")) {
					logOut();
					break;
				} else {
					System.err.println("Please Enter a valid Option");
					System.out.println("Enter Option : ");
					option = myObj.nextLine();
				}
			}

		} else if (currentUser instanceof WarehouseStaff) {
			while (true) {
				if (option.equals("1")) {
					// replenishStock() method
					break;
				} else if (option.equals("2")) {
					// viewProductList() method
					break;
				} else if (option.equals("3")) {
					// changeUsername() method
					break;
				} else if (option.equals("4")) {
					// changePassword() method
					break;
				} else if (option.equals("5")) {
					logOut();
					break;
				} else {
					System.err.println("Please Enter a valid Option");
					System.out.println("Enter Option : ");
					option = myObj.nextLine();
				}
			}

		} else if (currentUser instanceof Member) {
			while (true) {
				if (option.equals("1")) {
					// checkLoyaltyPoint() method
					break;

				} else if (option.equals("2")) {
					// createShoppingCart() method
					break;
				} else if (option.equals("3")) {
					logOut();
					break;
				} else {
					System.err.println("Please Enter a valid Option");
					System.out.println("Enter Option : ");
					option = myObj.nextLine();
				}
			}

		}

	}

	public static void main(String[] args) {

		SuperMarketSystem obj = new SuperMarketSystem();

	}

}
