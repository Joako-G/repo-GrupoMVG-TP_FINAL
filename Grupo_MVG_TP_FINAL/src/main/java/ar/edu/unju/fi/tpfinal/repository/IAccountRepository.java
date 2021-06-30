package ar.edu.unju.fi.tpfinal.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.Account;

public interface IAccountRepository extends CrudRepository<Account, Long> {

	public Account findByNombreUsuario(String nombre);
}
