package br.ufc.crateus.npds.sevice;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.crateus.npds.exception.ConflitoException;
import br.ufc.crateus.npds.model.Usuario;
import br.ufc.crateus.npds.repository.UserRepository;

@Service
public class LoginService {
	private Usuario usuario;
	@Autowired
	private UserRepository ur;

	public Usuario verificaLogin(String name, String password) {
		Usuario u = ur.getByUserName(name);

		if (u != null) {
			return u;
		}
		return null;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void add(Usuario usuario) throws ConflitoException {
		if (ur.getByUserName(usuario.getUserName()) != null) {
			throw new ConflitoException("Login existente");
		} else {
			ur.save(usuario);
		}
	}

	public Iterable<Usuario> getUsuarios() {
		return ur.findAll();
	}

	public Collection<Usuario> search(String name, String password) {

		return ur.findByUserNameContainingAndUserPassword(name == null ? "" : name, password == null ? "" : password);
	}

}
