package br.com.entra21.emr.backend.login.area.record.crud;

import java.util.HashMap;

import br.com.entra21.emr.backend.Repository;
import br.com.entra21.emr.backend.models.Patient;

public class PatientCRUD implements ICrud<Patient> {
	
	private HashMap<String, Patient> patients = Repository.patients;

	@Override
	public void list(HashMap<String, Patient> patients) {
		for(byte count=0;count<patients.size();count++) {
			System.out.println("Contando "+count);
		}
		
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
