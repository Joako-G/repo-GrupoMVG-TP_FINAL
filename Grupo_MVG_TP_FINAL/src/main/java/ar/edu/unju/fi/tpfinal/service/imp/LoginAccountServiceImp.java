package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Account;
import ar.edu.unju.fi.tpfinal.repository.IAccountRepository;

@Service
public class LoginAccountServiceImp implements UserDetailsService {

	@Autowired
	IAccountRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Account usuarioEncontrado = usuarioRepository.findByNombreUsuario(username);
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(usuarioEncontrado.getRol());
		roles.add(grantedAuthority);
		UserDetails user = (UserDetails) new User(username, usuarioEncontrado.getPassword(),roles);
		
		return user;
	}

}
