package hbyuan.tutorials.data.dao;

import hbyuan.tutorials.data.entity.DepartmentEO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDao extends JpaRepository<DepartmentEO, Long> {

	DepartmentEO findByName(String name);

}