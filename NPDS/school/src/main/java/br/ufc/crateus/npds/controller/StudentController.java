package br.ufc.crateus.npds.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.crateus.npds.model.Student;
import br.ufc.crateus.npds.repository.StudentRepository;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	StudentRepository repository = new StudentRepository();

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Student> getStudents() {
		return repository.getAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Student addStudent(@RequestBody Student student) {
		repository.add(student);
		return student;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Student viewStudent(@PathVariable int id) {
		return repository.getbyID(id);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void removeStudent(@PathVariable("id") int id) {
		repository.delete(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void editStudent(@RequestBody Student student, @PathVariable int id) {
		repository.update(id, student);
	}
	

	@RequestMapping(params = "name" ,method = RequestMethod.GET)
	public List<Student> searchStudent(@RequestParam("name") String name) {
		return repository.search(name);

	}

}
