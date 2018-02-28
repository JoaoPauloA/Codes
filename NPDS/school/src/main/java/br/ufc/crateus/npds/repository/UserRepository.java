package br.ufc.crateus.npds.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import br.ufc.crateus.npds.model.Usuario;

public interface UserRepository extends CrudRepository<Usuario, Integer>{
	
	Collection<Usuario> findByUserNameContainingAndUserPassword(String name, String password);

	Usuario getByUserName(String name);
	
}
