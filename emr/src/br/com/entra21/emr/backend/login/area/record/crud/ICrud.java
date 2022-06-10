package br.com.entra21.emr.backend.login.area.record.crud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import br.com.entra21.emr.backend.anottations.NotImplemented;

public interface ICrud<T> {
	
	@NotImplemented
	ArrayList<String> options = new ArrayList<String>(
			Arrays.asList("List", "Create", "Search", "Update", "Delete"));

	public void listar(HashMap<String,T> list);

	public void create();

	public T search(T chave);

	public void update(T chave);

	public void detele(T chave);

	public T captureKey();

	public T captureValues();
	
}
