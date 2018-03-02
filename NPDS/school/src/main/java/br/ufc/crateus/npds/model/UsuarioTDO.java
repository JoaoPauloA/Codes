package br.ufc.crateus.npds.model;

public class UsuarioTDO {
	private int id;
	private String userName;

	public UsuarioTDO(int id, String userName) {
		this.id = id;
		this.userName = userName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
