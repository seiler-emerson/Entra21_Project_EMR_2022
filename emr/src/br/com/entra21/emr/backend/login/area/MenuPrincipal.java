package br.com.entra21.emr.backend.login.area;

import java.util.ArrayList;
import java.util.Arrays;

import br.com.entra21.emr.backend.Menu;
import br.com.entra21.emr.backend.login.area.appointments.MenuAppointments;
import br.com.entra21.emr.backend.login.area.record.MenuRecord;
import br.com.entra21.emr.backend.login.area.reports.MenuReports;

public class MenuPrincipal extends Menu {

	public MenuPrincipal(String title, ArrayList<String> options) {
		super(title, options);
	}

	
	@Override
	public byte captureOption() {

		byte opcao = super.captureOption();
		switch (opcao) {
		case 1: 
			new MenuAppointments("ELECTRONIC MEDICAL RECORD", new ArrayList<String>(Arrays.asList("New Appointment", "Consult EMR"))).playMenu(); 
			break;
		case 2:  
			new MenuRecord("RECORDS", new ArrayList<String>(Arrays.asList("Record Patient", "Record Doctor"))).playMenu();
			break; 
		case 3:  
			new MenuReports("REPORTS", new ArrayList<String>(Arrays.asList("Number of Patients", "Number of Appointments", "Data Patients", "List Patients"))).playMenu();
			break;
		
		default:
			System.out.println("Select a valid option for menu " + super.getTitle());
			break;
		}
		return opcao;
	}

}