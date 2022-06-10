package br.com.entra21.emr.backend.login.area.emr.crud;

import java.util.ArrayList;
import java.util.HashMap;

import br.com.entra21.emr.backend.Menu;
import br.com.entra21.emr.backend.Repository;
import br.com.entra21.emr.backend.models.Patient;



public class PatientCRUD extends Menu implements ICrud<Patient>{

	private HashMap<String, Patient> patients = Repository.patients;
	
	public PatientCRUD(String title, ArrayList<String> options) {
		super("OPTIONS", options);
		
	}
	
	@Override
	public byte captureOption() {

		byte opcao = super.captureOption();
		switch (opcao) {
		case 1:
			// CREATE
			break;
		case 2:
			// READ
			break;
		case 3:
			// UPDATE
			break;
		case 4:
			// DETELE
			break;
		case 5:
			// DETAILS
			break;
		default:
			System.out.println("Opção inválida para o menu de " + super.getTitle());
			break;
		}
		return opcao;
	}

	@Override
	public void list(HashMap<String, Patient> patients) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Patient search(Patient chave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Patient chave) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detele(Patient chave) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Patient captureKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient captureValues() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
