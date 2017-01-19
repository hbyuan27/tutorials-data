package hbyuan.tutorials.data.service;

import hbyuan.tutorials.data.bean.Department;
import hbyuan.tutorials.data.bean.EmergencyContact;
import hbyuan.tutorials.data.bean.Employee;
import hbyuan.tutorials.data.bean.Position;
import hbyuan.tutorials.data.dao.DepartmentDao;
import hbyuan.tutorials.data.dao.PersonDao;
import hbyuan.tutorials.data.dao.PositionDao;
import hbyuan.tutorials.data.dao.UserAuthenticationDao;
import hbyuan.tutorials.data.dao.UserDao;
import hbyuan.tutorials.data.entity.DepartmentEO;
import hbyuan.tutorials.data.entity.PersonEO;
import hbyuan.tutorials.data.entity.PositionEO;
import hbyuan.tutorials.data.entity.UserAuthenticationEO;
import hbyuan.tutorials.data.entity.UserEO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DataService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserAuthenticationDao userAuthDao;

	@Autowired
	private PersonDao personDao;

	@Autowired
	private PositionDao positionDao;

	@Autowired
	private DepartmentDao departmentDao;

	public Long saveDepartment(Department department) {
		DepartmentEO entity = new DepartmentEO();
		entity.setName(department.getName());
		entity = departmentDao.save(entity);
		return entity.getDeptId();
	}

	public List<Long> savePositions(String departmentName, List<Position> positions) {
		DepartmentEO dept = departmentDao.findByName(departmentName);
		if (dept == null) {
			logger.error("department not exists, name: " + departmentName);
			return null;
		}

		List<PositionEO> entities = new ArrayList<PositionEO>();
		for (Position position : positions) {
			PositionEO entity = new PositionEO();
			entity.setCode(position.getCode());
			entity.setDepartment(dept);
			entities.add(entity);
		}
		entities = positionDao.save(entities);

		List<Long> positionIds = new ArrayList<Long>();
		for (PositionEO entity : entities) {
			positionIds.add(entity.getPositionId());
		}
		return positionIds;
	}

	@Transactional
	public Long saveEmployeeInfo(Employee employee) {
		// init person entities
		PersonEO eePerson = new PersonEO();
		eePerson.setFirstName(employee.getFirstName());
		eePerson.setLastName(employee.getLastName());
		eePerson.setMobile(employee.getMobile());
		// build emergency contact list
		Set<PersonEO> ecSet = new HashSet<PersonEO>();
		List<EmergencyContact> emContacts = employee.getEmergencyContacts();
		for (EmergencyContact ec : emContacts) {
			PersonEO ecPerson = new PersonEO();
			ecPerson.setFirstName(ec.getFirstName());
			ecPerson.setLastName(ec.getLastName());
			ecPerson.setMobile(ec.getMobile());
			ecPerson.setEmployee(eePerson);
			ecPerson = personDao.save(ecPerson);
			ecSet.add(ecPerson);
		}
		eePerson.setEmergencyContacts(ecSet);
		eePerson = personDao.save(eePerson);
		// build user entity
		UserEO user = new UserEO();
		user.setUserName(employee.getUserName());
		String deptName = employee.getDepartment();
		DepartmentEO department = departmentDao.findByName(deptName);
		if (department == null) {
			throw new RuntimeException("Department not exists!");
		}
		user.setDepartment(department);
		String positionCode = employee.getPosition();
		PositionEO position = positionDao.findByCode(positionCode);
		if (position == null) {
			throw new RuntimeException("Position not exists!");
		}
		user.setPosition(position);
		user.setPerson(eePerson);
		user = userDao.save(user);
		// build auth
		UserAuthenticationEO auth = new UserAuthenticationEO();
		auth.setAccount(employee.getUserName());
		auth.setPassword(employee.getPassword());
		auth.setUser(user);
		auth = userAuthDao.save(auth);

		return user.getUserId();
	}
}
