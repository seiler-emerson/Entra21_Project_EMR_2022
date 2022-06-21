package br.com.entra21.emr.backend.models;

import java.time.LocalDate;
import java.util.LinkedList;


public class Patient extends Person {
	public LinkedList<Appointment> appointments;

	public Patient() {
		super();
	}
	
	public Patient(String name, String cpf, String nameMother, String nameFather, String address, String genre,
			LocalDate birth) {
		super(name, cpf, nameMother, nameFather, address, genre, birth);
		setAppointments(new LinkedList<>());	//TODO - 03 - Java Avancado - LinkedList
	}

	public Patient(LinkedList<Appointment> appointments) {
		super();
		this.appointments = appointments;
	}

	public LinkedList<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(LinkedList<Appointment> appointments) {
		this.appointments = appointments;
	}

	
	public static void createMessage() {
		System.out.println("The patient registration was successful!");
	}
	
	public static void editMessage(String name) {
		System.out.println("The patient selected "+name+" was successful!");
	}
	
	public static void deleteMessage(String name) {
		System.out.println("The patient selected "+name+" was successfully deleted!");
	}
	
	
}
