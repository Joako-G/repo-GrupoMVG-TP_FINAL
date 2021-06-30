package ar.edu.unju.fi.tpfinal.service;

import ar.edu.unju.fi.tpfinal.model.Account;

public interface IAccountService {
	
	public void guardarUsuario(Account cuenta);
	public Account getUsuarioPorNombreUsuario(String nombre);
}
