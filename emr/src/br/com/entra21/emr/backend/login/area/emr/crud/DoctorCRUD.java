package br.com.entra21.emr.backend.login.area.emr.crud;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;


import br.com.entra21.emr.backend.Menu;
import br.com.entra21.emr.backend.Repository;
import br.com.entra21.emr.backend.anottations.Description;
import br.com.entra21.emr.backend.models.Doctor;
import br.com.entra21.emr.backend.models.Patient;

//TODO - 02 - POO - Implements
public class DoctorCRUD extends Menu implements ICrud<Doctor> {	

	private HashMap<String, Doctor> doctors = Repository.doctors;
	private HashMap<String, Patient> patients = Repository.patients;
	private static HashSet<String> states = Repository.states;
	
	private static ArrayList<String> options = new ArrayList<String>(
			Arrays.asList("Create Doctor", "List Doctors", "Update Doctor", "Delete Doctor", "Details Doctor"));
	
	public DoctorCRUD() {
		super("DOCTOR", options);
	}
	
	@Override
	public String captureOption() {
		String opcao = super.captureOption();
		switch (opcao) {
		case "1":
			System.out.println("CREATING DOCTOR");
			create();
			break;
		case "2":
			System.out.println("LISTING DOCTOR");
			list(doctors);
			break;
		case "3":
			System.out.println("UPDATING DOCTOR");
			update(captureKey());
			break;
		case "4":
			System.out.println("DELETING DOCTOR");
			delete(captureKey());
			break;
		case "5":
			System.out.println("DETAILING DOCTOR");
			details(doctors);
			break;
		default:
			System.out.println("Invalid option " + super.getTitle());
			break;
		}
		return opcao;
	}

	@Description(value = "Scans the HashMap of doctor and lists it.")
	@Override
	public void list(HashMap<String, Doctor> doctors) {
		System.out.println("========================================================");
		System.out.println("DOCTOR LIST");
		for (Doctor doctor : doctors.values()) {
			System.out.println("\t" + doctor.getName() + " - CPF: "+doctor.getCpf());
		}
		System.out.println("\nDOCTORS TOTAL: " + doctors.size() + " doctors ");
	}
	
	@Description(value = "Checks if the doctors exists, if not, creates a new doctor.")
	@Override
	public void create() {
		Doctor newDoctor = captureValues();
		if (search(newDoctor) == null) {
			doctors.put(newDoctor.getCpf(), newDoctor);
			Doctor.createMessage(newDoctor.getName());
		} else {
			System.out.println("The doctor with cpf "+newDoctor.getCpf()+" is already registered");
		}
	}
	
	@Description(value = "Receives a doctor and returns his key, in this case his CPF.")
	@Override
	public Doctor search(Doctor key) {
		return doctors.get(key.getCpf());
	}
	
	@Description(value = "Checks if the doctor exists, if it exists, it calls the editValues() method, sending the cpf and the list of doctor. As a result, personal data is changed.")
	@Override
	public void update(Doctor key) {
		Doctor currentDoctor = search(key);
		if (currentDoctor == null) {
			System.out.println("The selected doctors does not exist: "+ key.getCpf());
		} else {
			doctors.put(key.getCpf(), editValues(key.getCpf()));
			System.out.println("Updated data...");
			Doctor.editMessage(currentDoctor.getName());
			Doctor.editMessage();
		}
	}
	
	@Description(value = "Checks if the doctor exists, if it exists, if it exists, removes the doctor from the HashMap, through its key, in this case the CPF.")
	@Override
	public void delete(Doctor key) {
		Doctor currentDoctor = search(key);
		if (currentDoctor == null) {
			System.out.println("The selected doctor does not exist: " + key.getCpf());
		} else {
			doctors.remove(key.getCpf());
			System.out.println("Deleted data...");
			Doctor.deleteMessage(currentDoctor.getName());
		}
	}
	
	@Description(value = "Lists patients for consultation, creates a temporary patient, asks the user for the cpf of the patient that he wants to manipulate and sets this cpf in the temporary patient.")
	@Override
	public Doctor captureKey() {
		list(doctors);
		Doctor captureDoctor = new Doctor();
		
		System.out.println("Inform the doctor CPF:");
		captureDoctor.setCpf(super.getInput().next());
		return captureDoctor;
	}
	
	@Description(value = "Method for capturing the doctor's personal data.")
	@Override
	public Doctor captureValues() {
		Doctor doctor = new Doctor();
		System.out.println("Enter the doctor's name:");
		doctor.setName(getInput().nextLine());
		doctor.setName(getInput().nextLine());
		System.out.println("Enter the doctor's CPF:");
		doctor.setCpf(getInput().next());			
		System.out.println("Enter the name of the doctor's mother:");
		doctor.setNameMother(getInput().nextLine());
		doctor.setNameMother(getInput().nextLine());
		System.out.println("Enter the name of the doctor's father:");
		doctor.setNameFather(getInput().nextLine());
		System.out.println("Enter the doctor's address:");
		doctor.setAddress(getInput().nextLine());
		System.out.println("Enter the doctor's gender:");
		doctor.setGenre(getInput().next());
		System.out.println("Enter doctor's date of birth in yyyy-mm-dd format");
		doctor.setBirth(captureDate());
		System.out.println("Enter the doctor's medical specialty:");
		doctor.setSpecialty(getInput().nextLine());
		doctor.setSpecialty(getInput().nextLine());
		System.out.println("Enter the doctor's medical license:");
		doctor.setMedicalLicense(getInput().nextLine());
		System.out.println("Enter you state initials license. Ex: SC: ");
		String stateLicense = getInput().next();
		if(states.contains(stateLicense)) {
			doctor.setStateLicense(stateLicense);
		} else {
			System.out.println("State not found. Try again.");
		}
		return doctor;
	}

	@Description(value = "Method for capturing the doctor's personal data for edit. Receives the cpf, coming from the temporary patient created in the consultation (data transition form).")
	public Doctor editValues(String cpf) {
		Doctor doctor = new Doctor();
		doctor.setCpf(cpf);
		
		System.out.println("Enter the doctor's name:");
		doctor.setName(getInput().nextLine());		
		doctor.setName(getInput().nextLine());
		
		System.out.println("Enter the name of the doctor's mother:");
		doctor.setNameMother(getInput().nextLine());
		
		System.out.println("Enter the name of the doctor's father:");
		doctor.setNameFather(getInput().nextLine());
		
		System.out.println("Enter the doctor's address:");
		doctor.setAddress(getInput().nextLine());
		
		System.out.println("Enter the doctor's gender:");
		doctor.setGenre(getInput().next());
		
		System.out.println("Enter your date of birth in yyyy-mm-dd format");
		doctor.setBirth(captureDate());
		
		System.out.println("Enter the doctor's medical specialty:");
		doctor.setSpecialty(getInput().nextLine());
		doctor.setSpecialty(getInput().nextLine());
		
		System.out.println("Enter the doctor's medical license:");
		doctor.setMedicalLicense(getInput().nextLine());
		
		System.out.println("Enter you state initials license. Ex: SC: ");
		String stateLicense = getInput().nextLine();
		if(states.contains(stateLicense)) {
			doctor.setStateLicense(stateLicense);
		} else {
			System.out.println("State not found. Try again.");
		}
		return doctor;
	}
	
	@Description(value = "Method for listing the doctor's personal data.")
	@Override
	public void details(HashMap<String, Doctor> doctors) {
		list(doctors);
		System.out.println("Select a doctor for CPF: ");
		String option = getInput().next();
		if(doctors.get(option) == null) {
			System.out.println("Insert a CPF for list!");
			details(doctors);
		} else {
		
			System.out.println("Full name: "+doctors.get(option).getName());
			System.out.println("CPF: "+doctors.get(option).getCpf());
			System.out.println("Mother name: "+doctors.get(option).getNameMother());
			System.out.println("Name Father: "+doctors.get(option).getNameFather());
			System.out.println("Adress: "+doctors.get(option).getAddress());
			System.out.println("Genre: "+doctors.get(option).getGenre());
			System.out.println("Birth date: "+doctors.get(option).getBirth().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			System.out.println("Medical specialty: "+doctors.get(option).getSpecialty());
			System.out.println("Medical license:: "+doctors.get(option).getMedicalLicense()+"-"+doctors.get(option).getStateLicense().toUpperCase());
			appointmentsNumber(patients, option);
		}
	}
	
	public void appointmentsNumber(HashMap<String, Patient> patients, String option) {
		byte totalAppointments = 0;
		for (Patient patient : patients.values()) {
			for(byte count=0;count<patient.getAppointments().size();count++) {
				if(patient.appointments.get(count).getDoctor().getCpf() == doctors.get(option).getCpf())
				totalAppointments+=1;
			}
		}
		System.out.println("Number of appointments: "+ totalAppointments);
	}
	
	public LocalDate captureDate() {
		LocalDate birthDate = null;
		try {
			birthDate = LocalDate.parse(getInput().next());
			
		} catch (DateTimeParseException e) {
			System.out.println("Insert a valid format for date!");
			System.out.println("Enter doctor's date of birth in yyyy-mm-dd format");
			captureDate();	//TODO - 01 - Logica - Recursividade
		}
		
		return birthDate;
	}
}