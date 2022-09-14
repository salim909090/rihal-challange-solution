package rihal.webchallenge.repo;

import org.springframework.data.repository.CrudRepository;

import rihal.webchallenge.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{
	
}
