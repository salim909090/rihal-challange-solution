package rihal.webchallenge.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@ManyToMany
	private Set<Class> classes = new HashSet<>();


	@ManyToMany
	private Set<Country> countries = new HashSet<>();

	private String name;

	private Date dateOfBirth;

	private Date createdDate;

	private Date modifiedDate;
	private Student() {}
	public Student(String name, Date dateOfBirth) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.createdDate = new Date();
		this.modifiedDate = new Date();
		this.classes = new HashSet<>();
		this.countries = new HashSet<>();

	}

	public Long getId() {
		return this.id;
	}

	public void addClasses(Set<Class> classes) {
		this.classes.addAll(classes);
		this.modifiedDate = new Date();
	}

	public void addClass(Class newClass) {
		this.classes.add(newClass);
		this.modifiedDate = new Date();
	}

	public Set<Class> getClasses(){
		return this.classes;
	}

	public void addCountries(Set<Country> countries) {
		this.countries.addAll(countries);
		this.modifiedDate = new Date();
	}

	public void addCountry(Country newCountry) {
		this.countries.add(newCountry);
		this.modifiedDate = new Date();
	}

	public Set<Country> getCountries(){
		return this.countries;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String newName) {
		this.name = newName;
		this.modifiedDate = new Date();
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date newDateOfBirth) {
		this.dateOfBirth = newDateOfBirth;
		this.modifiedDate = new Date();
	}
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public Date getModifiedDate() {
		return this.modifiedDate;
	}
	@Override
	public String toString() {
		return this.id+"";
	}
}
