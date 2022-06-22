package br.com.entra21.emr.backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	private static Scanner input = new Scanner(System.in);
	private static ArrayList<String> options;
	
	public static void main(String[] args) {
	
		String option;
		do {
			System.out.println(displayMenu());
			
			//metode generate Database //TODO - 01 - Logica - Comentarios
			Repository.generateDataBase();  
			
			option = input.next();

			switch (option) {	//TODO - 01 - Logica - switch
			case "0":
				System.out.println("Exiting...");
				break;
			case "1": 
				Principal.login();
				break;
			case "2": 
				Principal.record();
				break;
			case "3": 
				Principal.recoverPassword();
				break;
			case "4": 
				Principal.viewAboutInfo();
				break; 
			default:
				System.out.println("Select a valid option!");
				break;
			}

		} while (!option.equals("0"));
		System.out.println("Thanks! ");

	}

	private static String displayMenu() {
		
		if(options==null) {
			options = new ArrayList<>(Arrays.asList("Login","Create User","I forgot my password","About"));
		}
		
 
		String menu = "========================================================";
		menu += "\n========================================================";
		menu += "\nWelcome to Electronic Medical Record";
		menu += "\n\t0 - Exit";
		for (int option = 0; option < options.size(); option++) {
			menu += "\n\t"+(option+1)+" - "+options.get(option);
		} 
		menu += "\n========================================================";
		menu += "\nSelect an option: ";
		menu += "\n========================================================";

		return menu;
	}

}



