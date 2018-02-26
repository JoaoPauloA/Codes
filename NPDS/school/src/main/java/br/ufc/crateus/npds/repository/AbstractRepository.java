package br.ufc.crateus.npds.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.ufc.crateus.npds.model.Identificavel;

public class AbstractRepository<T extends Identificavel> {

	protected Map<Integer, T> repository = new HashMap<Integer, T>();
	private int id = 1;

	public void add(T obj) {
		obj.setId(id++);
		repository.put(obj.getId(), obj);
	}

	public T getbyID(int id) {
		return repository.get(id);
	}

	public Collection<T> getAll() {
		return repository.values();
	}
	
	public void delete(int id) {
		repository.remove(id);
	}
	
	public void update(int id,T student) {
		repository.put(id,student);
	}
	
}