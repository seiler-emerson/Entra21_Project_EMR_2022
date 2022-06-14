package br.com.entra21.emr.backend.login.area.reports;

import java.util.ArrayList;
import java.util.HashMap;

import br.com.entra21.emr.backend.Menu;
import br.com.entra21.emr.backend.Repository;
import br.com.entra21.emr.backend.anottations.Description;
import br.com.entra21.emr.backend.anottations.Implemented;
import br.com.entra21.emr.backend.login.area.emr.crud.PatientCRUD;
import br.com.entra21.emr.backend.models.Patient;

public class MenuReports extends Menu {
	private HashMap<String, Patient> patients = Repository.patients;
	public MenuReports(String title, ArrayList<String> options) {
		super(title, options);
	}
	
	@Override
	public byte captureOption() {

		byte opcao = super.captureOption();
		switch (opcao) {
		case 1:  
			System.out.println("TOTAL PATIENTS");
			totalPatients();
			break;
		case 2: 
			System.out.println("TOTAL APPOINTMENTS");
			totalAppointments(patients);
			break;
		case 3: 
			System.out.println("PATIENTS LIST");
			new PatientCRUD().list(patients);
			break;
		case 4: 
		default:
			System.out.println("Select a valid option for menu " + super.getTitle());
			break;
		}
		return opcao;
	}
	
	@Description(value = "Metode list total patients")
	@Implemented
	public void totalPatients() {
		byte patientsNumber=0;
		for(byte count=0;count<patients.size();count++) {
			patientsNumber+=1;
		}
		
		System.out.println("Number of registered patients: "+patientsNumber);
	}
	
	@Description(value = "Metode list total appointments")
	@Implemented
	public void totalAppointments(HashMap<String, Patient> patients) {
		byte totalAppointments = 0;
		for (Patient patient : patients.values()) {
			for(byte count=0;count<patient.getAppointments().size();count++) {
				totalAppointments+=1;
			}
		}
		System.out.println("Number of registered appointment: "+ totalAppointments);
	}
	
}