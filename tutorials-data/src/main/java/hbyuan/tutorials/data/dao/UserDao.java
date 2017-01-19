package hbyuan.tutorials.data.dao;

import hbyuan.tutorials.data.entity.UserEO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserEO, Long> {

}