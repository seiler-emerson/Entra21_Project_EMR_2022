package br.com.entra21.emr.backend.login.area.appointments;

import java.util.ArrayList;

import br.com.entra21.emr.backend.Menu;

public class MenuAppointments extends Menu {

	public MenuAppointments(String title, ArrayList<String> options) {
		super(title, options);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public byte captureOption() {

		byte opcao = super.captureOption();
		switch (opcao) {
		case 1:  
			// novo atendimento 
			break;
		case 2: 
			// consulta de prontuario
			break;
		default:
			System.out.println("Select a valid option for menu " + super.getTitle());
			break;
		}
		return opcao;
	}

}