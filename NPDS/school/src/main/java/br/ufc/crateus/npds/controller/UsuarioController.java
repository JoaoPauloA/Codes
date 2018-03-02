package br.ufc.crateus.npds.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.crateus.npds.exception.ConflitoException;
import br.ufc.crateus.npds.model.Usuario;
import br.ufc.crateus.npds.sevice.LoginService;

@RestController
@RequestMapping("/api/user")
public class UsuarioController {
	@Autowired
	private LoginService ur;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Usuario> addUser(@RequestBody Usuario usuario) {
		if (usuario != null && usuario.getUserName().length() <= 3 && usuario.getUserPassword().length() >= 6) {
			return new ResponseEntity<Usuario>(HttpStatus.BAD_REQUEST);
		}
		try {
			ur.add(usuario);
		} catch (ConflitoException e) {
			return new ResponseEntity<Usuario>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Usuario>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Usuario>> search(@RequestParam(required = false, value = "userName") String name,
			@RequestParam(required = false, value = "userPassword") String password) {
		return new ResponseEntity<Collection<Usuario>>(ur.search(name, password), HttpStatus.OK);

	}

}
