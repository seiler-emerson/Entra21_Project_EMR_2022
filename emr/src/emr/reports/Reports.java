package emr.reports;

import java.util.Scanner;
import emr.Main;


public class Reports {

	static Scanner input = new Scanner(System.in);

	public static void report() {

		byte option;

		do {

			System.out.println(displayMenu());
			option = input.nextByte();
			System.out.println("");

			switch (option) {
			case -1:
				Main.main(null);
				break;
			case 0:
				System.out.println("Exiting...");
				System.exit(2);
				break;
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			default:
				System.out.println("Select a valid option!");
				break;
			}

		} while (option != 0);
	
}
	
	public static String displayMenu() {
		String menu = "||====================================||";
		menu += "\n||               REPORTS              ||";
		menu += "\n||-1 - Return                         ||";
		menu += "\n|| 0 - Exit                           ||";
		menu += "\n|| 1 - Number of Patients             ||";
		menu += "\n|| 2 - Number of Appointments         ||";
		menu += "\n|| 3 - Data Patients                  ||";
		menu += "\n|| 4 - List Patients                  ||";
		menu += "\n||                                    ||";
		menu += "\n||====================================||";
		menu += "\nSelect an option:";

		return menu;
	}
	
	
	
}
