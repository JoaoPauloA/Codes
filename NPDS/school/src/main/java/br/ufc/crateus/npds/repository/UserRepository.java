package br.ufc.crateus.npds.repository;

import org.springframework.data.repository.CrudRepository;

import br.ufc.crateus.npds.model.Usuario;

public interface UserRepository extends CrudRepository<Usuario, Integer>{
	
	Usuario getByName(String name);
	
}
