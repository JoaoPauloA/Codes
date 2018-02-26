package br.ufc.crateus.npds.repository;

import java.util.ArrayList;
import java.util.List;

import br.ufc.crateus.npds.model.Student;

public class StudentRepository extends AbstractRepository<Student> {

	public List<Student> search(String name) {
		List<Student> students = new ArrayList<Student>();
		for (Student s : getAll()) {
			if (s.getName().contains(name))
				students.add(s);
		}

		return students;
	}
	
}
