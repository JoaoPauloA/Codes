package br.ufc.crateus.npds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Usuario> autentica(@RequestBody Usuario usuario) {
		Usuario u = ur.verificaLogin(usuario.getUserName(), usuario.getUserPassword());
		if (u != null)
			return new ResponseEntity<Usuario>(u, HttpStatus.OK);
		return new ResponseEntity<Usuario>(u, HttpStatus.UNAUTHORIZED);
	}

}
