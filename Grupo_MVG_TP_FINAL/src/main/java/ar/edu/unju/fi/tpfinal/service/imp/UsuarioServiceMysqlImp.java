package ar.edu.unju.fi.tpfinal.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Usuario;
import ar.edu.unju.fi.tpfinal.repository.IUsuarioRepository;
import ar.edu.unju.fi.tpfinal.service.IUsuarioService;

@Service
public class UsuarioServiceMysqlImp implements IUsuarioService {

	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Override
	public void guardarUsuario(Usuario usuario) {
		String password = usuario.getPassword();
		BCryptPasswordEncoder passwordEnconder = new BCryptPasswordEncoder(4);
		usuario.setPassword(passwordEnconder.encode(password));
		usuarioRepository.save(usuario);
	}

	@Override
	public Usuario findByNombreUsuario(String nombreUsuario) {
		Usuario usuario = usuarioRepository.findByNombreUsuario(nombreUsuario);
		return usuario;
	}
	
}
