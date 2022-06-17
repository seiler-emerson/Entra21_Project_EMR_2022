package br.com.entra21.emr.backend.login.area.emr.crud;

public class DateFutureExeption extends Exception {

	public DateFutureExeption() {
		super("It is not allowed to enter a future date");
	}
	public DateFutureExeption(String mensagem) {
		super(mensagem);
	}
}
