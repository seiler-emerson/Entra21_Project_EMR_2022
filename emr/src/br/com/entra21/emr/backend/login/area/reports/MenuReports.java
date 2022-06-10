package br.com.entra21.emr.backend.login.area.reports;

import java.util.ArrayList;

import br.com.entra21.emr.backend.Menu;

public class MenuReports extends Menu {

	public MenuReports(String title, ArrayList<String> options) {
		super(title, options);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public byte captureOption() {

		byte opcao = super.captureOption();
		switch (opcao) {
		case 1:  
			//numero de pacientes
			break;
		case 2: 
			//numero de atendimentos
			break;
		case 3: 
			//dados pacientes
			break;
		case 4: 
			// lista de pacientes
			break; 
		default:
			System.out.println("Select a valid option for menu " + super.getTitle());
			break;
		}
		return opcao;
	}

}