package hbyuan.tutorials.data.dao;

import hbyuan.tutorials.data.entity.PersonEO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDao extends JpaRepository<PersonEO, Long> {

}