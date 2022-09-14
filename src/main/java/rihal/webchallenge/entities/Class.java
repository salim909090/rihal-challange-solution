package rihal.webchallenge.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Class {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String className;
	
	private Date createdDate;
	
	private Date modifiedDate;
	private Class() {}
	public Class(String class_name) {
		this.className = class_name;
		this.createdDate = new Date();
		this.modifiedDate = new Date();

	}

	public void setClassName(String newClassName) {
		this.className = newClassName;
		this.modifiedDate = new Date();
	}	
	
	public String getClassName() {
		return this.className;
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
	
	public String toString() {
		return this.id + " " + this.className;
	}
}
