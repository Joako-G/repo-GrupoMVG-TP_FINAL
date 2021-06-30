package ar.edu.unju.fi.tpfinal.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Account;
import ar.edu.unju.fi.tpfinal.repository.IAccountRepository;
import ar.edu.unju.fi.tpfinal.service.IAccountService;

@Service
public class AccountServiceMysqlImp implements IAccountService {

	@Autowired
	IAccountRepository usuarioRepository;
	
	@Override
	public void guardarUsuario(Account cuenta) {
		String password = cuenta.getPassword();
		BCryptPasswordEncoder enconder = new BCryptPasswordEncoder(4);
		cuenta.setPassword(enconder.encode(password));
		usuarioRepository.save(cuenta);
	}

	@Override
	public Account getUsuarioPorNombreUsuario(String nombre) {
	Account cuenta = usuarioRepository.findByNombreUsuario(nombre);
		return cuenta;
	}

}
