package br.ufc.crateus.npds.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.crateus.npds.model.Usuario;
import br.ufc.crateus.npds.repository.UsuarioRepository;

@Service
public class LoginService {
	private Usuario usuario;
	@Autowired
	private UsuarioRepository ur;

	public Usuario verificaLogin(String name, String password) {
		Usuario u = ur.getByName(name);
		if (u != null && u.getUserPassword().equals(password))
			return u;
		return null;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void putUser(Usuario usuario) {
		ur.add(usuario);
	}
	
	
}
