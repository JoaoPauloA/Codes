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
@RequestMapping("/api/usuario")
public class UsuarioController {
	@Autowired
	private LoginService ur;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Usuario> login(@RequestBody Usuario usuario) {
		Usuario u = ur.verificaLogin(usuario.getUserName(), usuario.getUserPassword());
		if (u != null) {
			Usuario us = new Usuario();
			us.setId(u.getId());
			us.setUserName(u.getUserName());

			return new ResponseEntity<Usuario>(us, HttpStatus.OK);
		} else {
			return new ResponseEntity<Usuario>(u, HttpStatus.UNAUTHORIZED);
		}

	}
	
	

}
