package hbyuan.tutorials.data.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "POSITION")
public class PositionEO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "POSITION_ID")
	private Long positionId;

	@Column(name = "CODE")
	private String code;

	@Column(name = "DEPT_ID")
	private Long deptId;

	// the inverse side - identify who is using the table via an association
	@OneToOne(mappedBy = "position", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	private UserEO user;

	// optional is false means position must has a department
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH }, optional = false)
	// foreign key name in Position table
	// note, if you don't want to add this column in position table
	// you can remove the property, and remove mappedBy field in OneToMany
	// annotation of property 'positions' in Department.
	// There will be an intermediate table instead of a foreign key column
	@JoinColumn(name = "FK_DEPT_ID", nullable = false)
	private DepartmentEO department;

	public Long getPositionId() {
		return positionId;
	}

	public void setPositionId(Long positionId) {
		this.positionId = positionId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public UserEO getUser() {
		return user;
	}

	public void setUser(UserEO user) {
		this.user = user;
	}

	public DepartmentEO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEO department) {
		this.department = department;
	}

}
