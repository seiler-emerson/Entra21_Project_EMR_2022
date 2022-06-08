package emr.records;

import java.util.Scanner;
import emr.Main;

public class Records {

	static Scanner input = new Scanner(System.in);

	public static void record() {
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
				System.out.println("PATIENT RECORD");
				break;
			case 2:
				System.out.println("DOCTOR RECORD");
				break;
			default:
				System.out.println("Select a valid option!");
				break;
			}

		} while (option != 0);

	}

	public static String displayMenu() {
		String menu = "||====================================||";
		menu += "\n||               RECORDS              ||";
		menu += "\n||-1 - Return                         ||";
		menu += "\n|| 0 - Exit                           ||";
		menu += "\n|| 1 - Record Patient                 ||";
		menu += "\n|| 2 - Record Doctor                  ||";
		menu += "\n||                                    ||";
		menu += "\n||====================================||";
		menu += "\nSelect an option:";

		return menu;
	}

	

}