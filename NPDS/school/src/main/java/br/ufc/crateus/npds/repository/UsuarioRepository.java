package br.ufc.crateus.npds.repository;

import org.springframework.stereotype.Repository;

import br.ufc.crateus.npds.model.Usuario;

@Repository
public class UsuarioRepository extends AbstractRepository<Usuario> {

	public Usuario getByName(String name) {
		for (Usuario u : getAll()) {
			if (u.getUserName().equals(name))
				return u;
		}
		return null;
	}

}
