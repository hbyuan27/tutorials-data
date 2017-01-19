package hbyuan.tutorials.data.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON")
public class PersonEO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PERSON_ID")
	private Long personId;

	@Column(name = "MOBILE")
	private String mobile;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@ManyToOne(cascade = CascadeType.ALL)
	private PersonEO employee;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private Set<PersonEO> emergencyContacts = new HashSet<PersonEO>();

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public PersonEO getEmployee() {
		return employee;
	}

	public void setEmployee(PersonEO employee) {
		this.employee = employee;
	}

	public Set<PersonEO> getEmergencyContacts() {
		return emergencyContacts;
	}

	public void setEmergencyContacts(Set<PersonEO> emergencyContacts) {
		this.emergencyContacts = emergencyContacts;
	}

}
