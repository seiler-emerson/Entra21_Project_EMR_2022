package br.com.entra21.emr.backend.login.area.emr.crud;

import java.util.ArrayList;
import java.util.HashMap;

import br.com.entra21.emr.backend.Menu;
import br.com.entra21.emr.backend.models.Appointment;

public class AppointmentCRUD extends Menu implements ICrud<Appointment>  {

	public AppointmentCRUD(String title, ArrayList<String> options) {
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
		default:
			System.out.println("Op��o inv�lida para o menu de " + super.getTitle());
			break;
		}
		return opcao;
	}

	@Override
	public void list(HashMap<String, Appointment> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Appointment search(Appointment chave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Appointment chave) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detele(Appointment chave) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Appointment captureKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Appointment captureValues() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
