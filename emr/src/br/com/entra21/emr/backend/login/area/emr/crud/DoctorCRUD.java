package br.com.entra21.emr.backend.login.area.emr.crud;

import java.util.ArrayList;
import java.util.HashMap;

import br.com.entra21.emr.backend.Menu;
import br.com.entra21.emr.backend.Repository;
import br.com.entra21.emr.backend.models.Doctor;

public class DoctorCRUD extends Menu implements ICrud<Doctor> {

	private HashMap<String, Doctor> doctors = Repository.doctors;
	
	public DoctorCRUD(String title, ArrayList<String> options) {
		super(title, options);
		// TODO Auto-generated constructor stub
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
			System.out.println("Op��o inv�lida para o menu de " + super.getTitle());
			break;
		}
		return opcao;
	}

	@Override
	public void list(HashMap<String, Doctor> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Doctor search(Doctor chave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Doctor chave) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detele(Doctor chave) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Doctor captureKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Doctor captureValues() {
		// TODO Auto-generated method stub
		return null;
	}

}
