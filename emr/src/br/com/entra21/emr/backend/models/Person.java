package br.com.entra21.emr.backend.models;

import java.time.LocalDate;

public class Person {
	private String name;
	private String cpf;
	private String nameMother;
	private String nameFather;
	private String address;
	private String genre;
	private LocalDate birth;
	
	public Person() {
		super();
	}

	public Person(String name, String cpf, String nameMother, String nameFather, String address, String genre,
			LocalDate birth) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.nameMother = nameMother;
		this.nameFather = nameFather;
		this.address = address;
		this.genre = genre;
		this.birth = birth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNameMother() {
		return nameMother;
	}

	public void setNameMother(String nameMother) {
		this.nameMother = nameMother;
	}

	public String getNameFather() {
		return nameFather;
	}

	public void setNameFather(String nameFather) {
		this.nameFather = nameFather;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public LocalDate getBirth() {
		return birth;
	}

	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}
	
	public static void createMessage() { 
		System.out.println("The registration was successful!");
	}
	
	public static void editMessage() {	//TODO - 02 - POO - Polimorfismo - Apenas aproveitar os metodos
		System.out.println("The selected was successful!");
	}
	
	public static void deleteMessage() {
		System.out.println("The selected was successfully deleted!");
	}
	
}
