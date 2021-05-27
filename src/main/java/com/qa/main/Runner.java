package com.qa.main;


import java.sql.SQLException;
import java.util.Scanner;

public class Runner {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		
		DBConnection dbCon = new DBConnection();
		
		String action;
		action = getAction();
		try {
			do {
				switch (action){
				case "create":
					System.out.println("Please enter a name");
					String name = scan.nextLine();
					String gender = scan.nextLine();
					dbCon.create(name, gender);
					break;
					
					
				case "read":
					System.out.println("displaying data");
					dbCon.read();
					break;
				case "read one":
					System.out.println("Please enter id");
					int id = scan.nextInt();
					scan.nextLine();
					dbCon.readOne(id);
					break;
				case "update":
					System.out.println("Please enter an id to update");
					int uId = scan.nextInt();
					System.out.println("please enter name");
					String Uname = scan.nextLine();
					dbCon.update(uId, Uname);
					break;
				case "delete":
					System.out.println("Please enter an id");
					int id2 = scan.nextInt();
					dbCon.delete(id2);
								
					defualt:
						System.out.println("no match found");
					break;
				
				}
				action = getAction();
			} while (!action.equals("exit"));
			System.out.println("Cya");
		}finally {
			scan.close();
		}
	}

	private static String getAction() {
		String menuMsg = "==================================================\n" + "IMS System:\n"
				+ "==================================================\n" + "\t- Create\t create a new customer" + "\n"
				+ "\t- Read\t\t Read all customers" + "\n" + "\t- Read one\t Read one customers" + "\n"
				+ "\t- Update\t Update a customer" + "\n" + "\t- Delete\t Delete a customer" + "\n" + "\t=====\n"
				+ "\t- Exit\t\t Exit Application\n" + "==================================================\n";
		System.out.println(menuMsg + "What do you want to do next?");
		return scan.nextLine().toLowerCase();
	}
}
