package br.ufc.crateus.npds.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Departamento {
	@Id
	private int id;
	private String name;
	@OneToMany(mappedBy = "departamento")
	private List<Usuario> users;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Usuario> getUsers() {
		return users;
	}

	public void setUsers(List<Usuario> users) {
		this.users = users;
	}

}
