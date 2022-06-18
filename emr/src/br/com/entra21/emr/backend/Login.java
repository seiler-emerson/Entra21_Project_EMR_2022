package br.com.entra21.emr.backend;

import java.util.HashMap;
import java.util.Scanner;

import br.com.entra21.emr.backend.anottations.Description;
import br.com.entra21.emr.backend.anottations.Implemented;
import br.com.entra21.emr.backend.models.Doctor;

public class Login {
	
	@Implemented
	@Description(value = "Scans the HashMap of patients and lists it.")
	public static void list(HashMap<String, Doctor> doctors) {
		
	}
	
	public static void access() {
		HashMap<String, Doctor> doctors = Repository.doctors;
		
		list(doctors);
		
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("Senha Padrão: 123456");
            System.out.print("Login: ");
            String userName = input.nextLine();

            System.out.print("Password: ");
            String password = input.nextLine();

            if (doctors.get(userName).getCpf().equals(userName) && doctors.get(userName).getPassword().equals(password)) {
                Principal.menu();
            } else {
                System.out.printf("\n ***** Senha inválida. *****\n", password);
                
                access();
                
            }
            
            
        }

	}
}
