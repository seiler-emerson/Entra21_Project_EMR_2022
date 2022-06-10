package emr.emr;

import java.util.Scanner;
import emr.Main;

public class Emr {

	static Scanner input = new Scanner(System.in);

	public static void emr() {

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
				System.exit(1);
				break;
			case 1:
				System.out.println("NOVO ATENDIMENTO SELECIONADO");
				break;
			case 2:
				System.out.println("CONSULTA DE PRONTUARIO SELECIONADA");
				break;
			default:
				System.out.println("Select a valid option!");
				break;
			}

		} while (option != 0);

	}

	public static String displayMenu() {
		String menu = "||====================================||";
		menu += "\n||             PRONTUARIO             ||";
		menu += "\n||-1 - Return                         ||";
		menu += "\n|| 0 - Exit                           ||";
		menu += "\n|| 1 - New Appointment                ||";
		menu += "\n|| 2 - Consult EMR                    ||";
		menu += "\n||                                    ||";
		menu += "\n||====================================||";
		menu += "\nSelect an option:";

		return menu;
	}

}