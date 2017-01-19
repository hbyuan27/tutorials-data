package hbyuan.tutorials.data.dao;

import hbyuan.tutorials.data.entity.PositionEO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionDao extends JpaRepository<PositionEO, Long> {

	PositionEO findByCode(String code);

}