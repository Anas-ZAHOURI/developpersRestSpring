package com.anas.zahouri.model;

import org.hibernate.validator.constraints.NotEmpty;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="DEVELOPPERS")
public class Developper implements Serializable{

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Column(name="FIRST_NAME", nullable = false)
	private String name;

	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;

	@Column(name="SALARY")
	private double salary;

	// FIXME: 14/03/2017, FetchType.EAGER Should be removed -> Solution Lazy mode with @Transactional
	@ManyToMany(targetEntity=ProgrammingLanguage.class, fetch = FetchType.EAGER)
	@JoinTable(
			name="DEVELOPPERS_PROGRAMMING_LANGUAGE",
			joinColumns={ @JoinColumn(name="DEV_ID", referencedColumnName="ID") },
			inverseJoinColumns={ @JoinColumn(name="PL_ID", referencedColumnName="ID", unique=true) }
	)
	private List<ProgrammingLanguage> programmingLanguages;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Developper that = (Developper) o;

		if (Double.compare(that.salary, salary) != 0) return false;
		if (id != null ? !id.equals(that.id) : that.id != null) return false;
		if (name != null ? !name.equals(that.name) : that.name != null) return false;
		if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
		return programmingLanguages != null ? programmingLanguages.equals(that.programmingLanguages) : that.programmingLanguages == null;
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		temp = Double.doubleToLongBits(salary);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		result = 31 * result + (programmingLanguages != null ? programmingLanguages.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Developper{" +
				"id=" + id +
				", name='" + name + '\'' +
				", lastName='" + lastName + '\'' +
				", salary=" + salary +
				", programmingLanguages=" + programmingLanguages +
				'}';
	}
}
