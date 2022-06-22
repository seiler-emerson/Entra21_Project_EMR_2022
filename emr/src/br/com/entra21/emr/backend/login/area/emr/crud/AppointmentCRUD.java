package br.com.entra21.emr.backend.login.area.emr.crud;  //TODO - 01 - Logica - Packages / sub-packages

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import br.com.entra21.emr.backend.Menu;
import br.com.entra21.emr.backend.Repository;
import br.com.entra21.emr.backend.anottations.Description;
import br.com.entra21.emr.backend.anottations.Implemented;
import br.com.entra21.emr.backend.models.Appointment;
import br.com.entra21.emr.backend.models.Doctor;
import br.com.entra21.emr.backend.models.Patient;

public class AppointmentCRUD extends Menu {	//TODO - 02 - POO - Extends
	
	private HashMap<String, Patient> patients = Repository.patients;
	public static HashMap<String, Doctor> doctors = Repository.doctors;
	
	private static ArrayList<String> options = new ArrayList<String>(	//TODO - 03 - Java Avancado - ArrayList
			Arrays.asList("Create Appointment", "List Appointment", "Update Appointment", "Delete Appointment", "Details Appointment"));
	
	public AppointmentCRUD() {
		super("APPOINTMENTS", options);
	}
	
	@Override
	public String captureOption() {
		String opcao = super.captureOption();
		switch (opcao) {
		case "1":
			create(patients);
			break;
		case "2":
			listAppointments(patients);
			break;
		case "3":
			update(patients);
			break;
		case "4":
			delete(patients);
			break;
		case "5":
			details(patients);
			break;
		default:
			System.out.println("Invalid option " + super.getTitle());
			break;
		}
		return opcao;
	}
	
	@Implemented
	public void listAppointments(HashMap<String, Patient> patients) {	//TODO - 01 - Logica - Nomenclatura
		System.out.println("========================================================");
		System.out.println("APPOINTMENTS LIST");
		
		byte totalAppointments = 0;
		System.out.println("\tNo -    Date   -  Hour - Patient Name - CPF");
		for (Patient patient : patients.values()) {	//TODO - 01 - Logica - for
			for(byte count=0;count<patient.getAppointments().size();count++) {
				System.out.println("\t"+count+" - "+patient.getAppointments().get(count).getDate()+" - "+ patient.getAppointments().get(count).getHour().format(DateTimeFormatter.ofPattern("HH:mm"))+" - "+patient.getName()+" - "+patient.getCpf() );
				totalAppointments+=1;
			}
		}
		System.out.println("\nAPPOINTMENTS TOTAL: " + totalAppointments + " appointments ");
	}
	
	@Implemented
	public void listPatients(HashMap<String, Patient> patients) {
		System.out.println("========================================================");
		System.out.println("PATIENTS LIST");
		for (Patient patient : patients.values()) {
			System.out.println("\t" + patient.getName() + " - "+((patient.appointments) != null? (patient.appointments.size()):"0")+" appointment(s) - CPF: "+patient.getCpf());
		}
		System.out.println("\nPATIENTS TOTAL: " + patients.size() + " patients ");
	}
	
	@Implemented
	public void create(HashMap<String, Patient> patients) {
		listPatients(patients);	//TODO - 01 - Logica - Recursividade
		System.out.println("Select the patient CPF:");
		String key = getInput().next();
		System.out.println("You selected the patient "+patients.get(key).getName());
		
		Appointment newAppointment = new Appointment();
		captureValues(newAppointment);
		patients.get(key).appointments.add(newAppointment);	
		Appointment.createMessage(patients.get(key).getName());
	}
	
	public void update(HashMap<String, Patient> patients) {
		listAppointments(patients);
		System.out.println("Select the patient CPF:");
		String keyPatient = getInput().next();
		System.out.println("You selected the patient "+patients.get(keyPatient).getName());
		System.out.println("Select the patient APPOINTMENT of patient selected:");
		byte keyAppointment = getInput().nextByte();
		captureValues(patients.get(keyPatient).getAppointments().get(keyAppointment)); 
		System.out.println("Updated data...");
		Appointment.editMessage(patients.get(keyPatient).getName());
	}
	
	public void delete(HashMap<String, Patient> patients) {
		listAppointments(patients);
		System.out.println("Select the patient CPF:");
		String keyPatient = getInput().next();
		System.out.println("You selected the patient "+patients.get(keyPatient).getName());
		System.out.println("Select the patient APPOINTMENT of patient deleted:");
		byte keyAppointment = getInput().nextByte();
		patients.get(keyPatient).getAppointments().remove(keyAppointment);
		System.out.println("Deleted data...");
		Appointment.deleteMessage(patients.get(keyPatient).getName());
	}
	
	@Implemented
	public void details(HashMap<String, Patient> patients) {
		listAppointments(patients);
		System.out.println("Select the patient CPF:");
		String keyPatient = getInput().next();
		System.out.println("You selected the patient "+patients.get(keyPatient).getName());
		System.out.println("Select the patient APPOINTMENT of patient appointments detais:");
		byte keyAppointment = getInput().nextByte();
		
		System.out.println("\nAPPOINTMENTS");
		System.out.println("Doctor responsible: "+patients.get(keyPatient).getAppointments().get(keyAppointment).getDoctor().getName());
		System.out.println("Patient Name: "+patients.get(keyPatient).getName());
		System.out.println("Patient CPF: "+patients.get(keyPatient).getCpf());
		System.out.println("Service date: "+patients.get(keyPatient).getAppointments().get(keyAppointment).getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		System.out.println("Service time: "+patients.get(keyPatient).getAppointments().get(keyAppointment).getHour().format(DateTimeFormatter.ofPattern("HH:mm")));
		System.out.println("Anamnesi: "+patients.get(keyPatient).getAppointments().get(keyAppointment).getAnamnesis());
		System.out.println("Prescription: "+patients.get(keyPatient).getAppointments().get(keyAppointment).getPrescription());
		System.out.println("Certificate/Declaration: "+patients.get(keyPatient).getAppointments().get(keyAppointment).getCertificate());
		System.out.println("Forwarding: "+patients.get(keyPatient).getAppointments().get(keyAppointment).getForwarding());
		System.out.println("Medical release: "+patients.get(keyPatient).getAppointments().get(keyAppointment).getMedicalRelease());
	}
	
	public void captureValues(Appointment newAppointment) {
		//TODO - 02 - POO - Encapsulamento
		newAppointment.setDoctor(captureDoctor());
		newAppointment.setDate(LocalDate.now());	//TODO - 03 - Java Avancado - Dates
		newAppointment.setHour(LocalTime.now());
		System.out.println("Describe the patient's anamnesi:");
		newAppointment.setAnamnesis(getInput().nextLine());
		newAppointment.setAnamnesis(getInput().nextLine());
		newAppointment.setPrescription(prescription());
		newAppointment.setCertificate(certificate());
		newAppointment.setForwarding(forwarding());
		newAppointment.setMedicalRelease(medicalRelease());
	}
	
	@Description(value = "Method for capturing the patient's prescription.")
	public String prescription() {
		System.out.println("Medical prescription required?");
		System.out.println("1 - YES");
		System.out.println("2 - NO");
		byte option = getInput().nextByte();
		String prescription = null;
		final byte OPTION_ONE = 1;	//TODO - 01 - Logica - CONSTANTE
		final byte OPTION_TWO = 2;  
		if(option == OPTION_ONE) {
			System.out.println("Report Medical prescription:");
			prescription = getInput().nextLine();	//Two because nextLine Bug.
			prescription = getInput().nextLine();
		} else if(option == OPTION_TWO) {
			prescription = "There is no prescription";
		} else {
			System.out.println("Please select a valid option!");
			prescription();
		}
		return prescription;
	}
	
	@Description(value = "Method for capturing the patient's certificate.")
	public String certificate() {
		System.out.println("Certificate/declaration required?");
		System.out.println("1 - YES");
		System.out.println("2 - NO");
		byte option = getInput().nextByte();
		String certificate = null;
		final byte OPTION_ONE = 1;	//TODO - 01 - Logica - CONSTANTE
		final byte OPTION_TWO = 2; 
		if(option == OPTION_ONE) {
			System.out.println("Report the certificate:");
			certificate = getInput().nextLine();	//Two because nextLine Bug.
			certificate = getInput().nextLine();
		} else if(option == OPTION_TWO) {
			certificate = "There is no certificate";
		} else {
			System.out.println("Please select a valid option!");
			certificate();
		}
		return certificate;
	}
	
	@Description(value = "Method for capturing the patient's forwarding.")
	public String forwarding() {
		System.out.println("Forwarding require?");
		System.out.println("1 - YES");
		System.out.println("2 - NO");
		byte option = getInput().nextByte();
		String forwarding = null;
		final byte OPTION_ONE = 1;	//TODO - 01 - Logica - CONSTANTE
		final byte OPTION_TWO = 2; 
		if(option == OPTION_ONE) {
			System.out.println("Report the forwarding:");
			forwarding = getInput().nextLine();	//Two because nextLine Bug.
			forwarding = getInput().nextLine();
		} else if(option == OPTION_TWO) {
			forwarding = "There is no forwarding";
		} else {
			System.out.println("Please select a valid option!");
			forwarding();
		}
		return forwarding;
	}
	
	@Description(value = "Method for capturing the patient's medical release.")
	@Implemented
	public String medicalRelease() {
		System.out.println("Report the medical release: ");
		String medicalRelease = getInput().nextLine();
		return medicalRelease;
	}
	
	public Doctor captureDoctor() {
		new DoctorCRUD().list(doctors);
		System.out.println("Inform the doctor CPF:");
		Doctor captureDoctor = doctors.get(super.getInput().next());
		return captureDoctor;
	}
}