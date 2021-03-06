package fr.an.tests.eclipselink.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import fr.an.persistence.ManyToOne;
import lombok.Data;

@Data // lombok getter, setter... override hashcode using id field!
@Entity
@Table(name="employees")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="employees_seq")	
	@SequenceGenerator(name="employees_seq", sequenceName="employees_seq", allocationSize=10)
	@Column(name="employee_id")
	private int id;
	
	@Version
	private int version;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	private String email;
	
	private String address;

	@ManyToOne()
	@JoinColumn(name="department_id")
	private Department department;

	@ManyToOne
	@JoinColumn(name="manager_id")
	private Employee manager;

	
	
	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
