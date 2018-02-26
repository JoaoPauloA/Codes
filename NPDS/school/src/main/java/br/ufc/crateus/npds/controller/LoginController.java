package br.ufc.crateus.npds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.crateus.npds.model.Usuario;
import br.ufc.crateus.npds.sevice.LoginService;

@RestController
@RequestMapping("/api/login")
public class LoginController {
	@Autowired
	private LoginService ur;

	@RequestMapping(method = RequestMethod.POST)
	public void addUsuario(@RequestBody Usuario usuario) {
		ur.putUser(usuario);

	}
	
}
