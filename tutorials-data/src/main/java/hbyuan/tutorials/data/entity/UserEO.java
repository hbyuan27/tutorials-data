package hbyuan.tutorials.data.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class UserEO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private Long userId;

	@Column(name = "USER_NAME")
	private String userName;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_DEPARTMENT_ID")
	private DepartmentEO department;

	// user must has a position
	// the owning side, means the entity owns the association in JoinColumn
	@OneToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_POSITION_ID")
	private PositionEO position;

	@OneToOne
	@PrimaryKeyJoinColumn
	private PersonEO person;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public DepartmentEO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEO department) {
		this.department = department;
	}

	public PositionEO getPosition() {
		return position;
	}

	public void setPosition(PositionEO position) {
		this.position = position;
	}

	public PersonEO getPerson() {
		return person;
	}

	public void setPerson(PersonEO person) {
		this.person = person;
	}

}
