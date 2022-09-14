package rihal.webchallenge;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import rihal.webchallenge.entities.Class;
import rihal.webchallenge.entities.Country;
import rihal.webchallenge.entities.Student;
import rihal.webchallenge.repo.ClassRepository;
import rihal.webchallenge.repo.CountryRepository;
import rihal.webchallenge.repo.StudentRepository;

@SpringBootTest
class RihalChallengeApplicationTests {

	@Autowired
	StudentRepository studentRepo;

	@Autowired
	ClassRepository classRepo;

	@Autowired
	CountryRepository countryRepo;
	
	@Test
	void testClassCreation() {
		Class new_class = new rihal.webchallenge.entities.Class("IT");
		new_class = classRepo.save(new_class);
		
		Optional<Class> classFound = classRepo.findById(new_class.getId());
		assert(classFound.isPresent());
		assert(classFound.get().getClassName() == "IT");
	}
	
	@Test
	void testCountryCreation() {
		Country newCountry = new Country("Oman");
		newCountry = countryRepo.save(newCountry);
		
		Optional<Country> countryFound = countryRepo.findById(newCountry.getId());
		assert(countryFound.isPresent());
		assert(countryFound.get().getName() == "Oman");
	}
	
	@Test
	void testStudentCreation() {
		Class new_class = new rihal.webchallenge.entities.Class("IT");
		new_class = classRepo.save(new_class);
		
		Country newCountry = new Country("Oman");
		newCountry = countryRepo.save(newCountry);
		
		Student newStudent = new Student("Salim",new Date(2000-1900,11,04));
		newStudent.addClass(new_class);
		newStudent.addCountry(newCountry);
		newStudent = studentRepo.save(newStudent);
		
		Optional<Student> studentFound = studentRepo.findById(newStudent.getId());
		assert(studentFound.isPresent());
		assert(studentFound.get().getName() == "Salim");
	}
	
}
