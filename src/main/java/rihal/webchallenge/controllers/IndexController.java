package rihal.webchallenge.controllers;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import rihal.webchallenge.entities.Country;
import rihal.webchallenge.entities.Student;
import rihal.webchallenge.repo.ClassRepository;
import rihal.webchallenge.repo.CountryRepository;
import rihal.webchallenge.repo.StudentRepository;

@Controller
public class IndexController {
	
	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	ClassRepository classRepo;
	
	@Autowired
	CountryRepository countryRepo;
	
	
	@GetMapping("/") 
	public String getPage(Model model) {
		Iterable<Student> students = studentRepo.findAll();
		
		Map<rihal.webchallenge.entities.Class, Integer> classMap = new HashMap<>();
		Map<Country,Integer> countiresMap = new HashMap<>();
		Double avgAge = 0.0;
		for(Student currentStudent: students) {
			
			// get counts per class
			for(rihal.webchallenge.entities.Class currentClass: currentStudent.getClasses()) {
				if (classMap.containsKey(currentClass)){
					classMap.put(currentClass,classMap.get(currentClass) + 1);
				}else {
					classMap.put(currentClass, 1);
				}
			}
			
			//get count per country
			for(Country currentCountry: currentStudent.getCountries()) {
				if(countiresMap.containsKey(currentCountry)) {
					countiresMap.put(currentCountry, countiresMap.get(currentCountry) + 1);
				}else {
					countiresMap.put(currentCountry, 1);
				}
			}
			
			//get current student age
			LocalDate localDate = currentStudent.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			LocalDate curDate = LocalDate.now();  
			avgAge += Period.between(localDate, curDate).getYears();
			
		}
		avgAge /= ((Collection<Student>) students).size();
		
		model.addAttribute("classMap", classMap);
		model.addAttribute("countriesMap", countiresMap);
		model.addAttribute("avgAge", avgAge);
		model.addAttribute("numStudents", ((Collection<Student>) students).size());
		return "index";
	}
}
