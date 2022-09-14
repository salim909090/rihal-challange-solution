package rihal.webchallenge;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import rihal.webchallenge.entities.Class;
import rihal.webchallenge.entities.Country;
import rihal.webchallenge.entities.Student;
import rihal.webchallenge.repo.ClassRepository;
import rihal.webchallenge.repo.CountryRepository;
import rihal.webchallenge.repo.StudentRepository;

@Component
public class DataLoader implements CommandLineRunner{

	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	ClassRepository classRepo;
	
	@Autowired
	CountryRepository countryRepo;
	
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("executed1");
		if(studentRepo.count() != 0)
			return;
		
		
		// create classes
		Class class1 = new Class("Chem");
		Class class2 = new Class("Phy");
		Class class3 = new Class("Bio");
		Class class4 = new Class("Arabic");
		Class class5 = new Class("Soc");
		Class class6 = new Class("Islamic");
		Class class7 = new Class("PE");
		Class class8 = new Class("Fre");
		
		classRepo.save(class1); 
		classRepo.save(class2);
		classRepo.save(class3);
		classRepo.save(class4); 
		classRepo.save(class5);
		classRepo.save(class6);
		classRepo.save(class7);
		classRepo.save(class8);
		
		// create countries
		Country country1 = new Country("Oman");
		Country country2 = new Country("Qatar");
		Country country3 = new Country("USA");
		Country country4 = new Country("UK");
		countryRepo.save(country1);
		countryRepo.save(country2);
		countryRepo.save(country3); 
		countryRepo.save(country4);
		
		//students
		Student student1 = new Student("salim",new Date(2000-1900,4,11));
		student1.addClass(class1);
		student1.addClass(class2);
		student1.addCountry(country1);
		student1.addCountry(country2);
		studentRepo.save(student1);

		Student student2 = new Student("abdull",new Date(1980-1900,5,20));
		student2.addClass(class3);
		student2.addClass(class8);
		student2.addClass(class2);
		student2.addCountry(country3);
		student2.addCountry(country2);
		studentRepo.save(student2);
		
		Iterable<Student> all = studentRepo.findAll();
		System.out.println(all.toString());
		
	}

}
