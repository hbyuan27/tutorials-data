package hbyuan.tutorials.data.dao;

import hbyuan.tutorials.data.entity.FieldEO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldDao extends JpaRepository<FieldEO, Long> {

	FieldEO findByFieldName(String fieldName);

}