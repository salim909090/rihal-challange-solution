package rihal.webchallenge.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private Date createdDate;

	private Date modifiedDate;

	private Country() {}
	public Country(String name) {
		this.name = name;
		this.createdDate = new Date();
		this.modifiedDate = new Date();

	}

	public void setName(String newName) {
		this.name = newName;
		this.modifiedDate = new Date();
	}

	public String getName() {
		return this.name;
	}

	public Long getId() {
		return this.id;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public Date getModifiedDate() {
		return this.modifiedDate;
	}
}
