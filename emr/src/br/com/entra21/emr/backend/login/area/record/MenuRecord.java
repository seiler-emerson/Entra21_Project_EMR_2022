package br.com.entra21.emr.backend.login.area.record;

import java.util.ArrayList;

import br.com.entra21.emr.backend.Menu;

public class MenuRecord extends Menu {

	public MenuRecord(String title, ArrayList<String> options) {
		super(title, options);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public byte captureOption() {

		byte opcao = super.captureOption();
		switch (opcao) {
		case 1:  
			// cadastrar paciente
			break;
		case 2: 
			// cadastrar medico
			break;
		default:
			System.out.println("Select a valid option for menu " + super.getTitle());
			break;
		}
		return opcao;
	}

}