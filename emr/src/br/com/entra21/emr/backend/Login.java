package br.com.entra21.emr.backend;

import java.util.HashMap;
import java.util.Scanner;

import br.com.entra21.emr.backend.anottations.Description;
import br.com.entra21.emr.backend.anottations.Implemented;
import br.com.entra21.emr.backend.models.Patient;

public class Login {
	
	@Implemented
	@Description(value = "Scans the HashMap of patients and lists it.")
	public static void list(HashMap<String, Patient> patients) {
		
	}
	
	public static void access() {
		HashMap<String, Patient> patients = Repository.patients;
		
		list(patients);
		
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("Senha Padrão: 123");
            System.out.print(" Enter CPF => ");
            String userName = input.nextLine();

            System.out.print(" Enter password => ");
            String password = input.nextLine();

            if (patients.get(userName).getCpf().equals(userName) && patients.get(userName).getPassword().equals(password)) {
                Principal.menu();
            } else {
                System.out.println(" Usuário Inválido ");
            }
        }

	}
}
