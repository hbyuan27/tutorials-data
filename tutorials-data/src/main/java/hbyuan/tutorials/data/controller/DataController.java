package hbyuan.tutorials.data.controller;

import hbyuan.tutorials.data.bean.Department;
import hbyuan.tutorials.data.bean.Employee;
import hbyuan.tutorials.data.bean.Position;
import hbyuan.tutorials.data.service.DataService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/data")
public class DataController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DataService service;

	@GetMapping(value = "/greeting")
	public String sayHello() {
		return "你好!";
	}

	@PostMapping(value = "/department")
	public Long saveDepartment(@RequestBody Department dept) {
		logger.info("start saving department...");
		return service.saveDepartment(dept);
	}

	@PostMapping(value = "/positions")
	public List<Long> savePositions(@RequestParam(value = "deptName") String departmentName,
			@RequestBody List<Position> positions) {
		logger.info("start saving department...");
		return service.savePositions(departmentName, positions);
	}

	/**
	 * employee is a user + person in the system
	 * 
	 * @return
	 */
	@PostMapping(value = "/employee")
	public Long saveEmployeeInfo(@RequestBody Employee employee) {
		logger.info("Start saving employee data...");
		Long userId = null;
		try {
			userId = service.saveEmployeeInfo(employee);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return userId;
	}

}
