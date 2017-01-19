package hbyuan.tutorials.data.dao;

import hbyuan.tutorials.data.entity.UserAuthenticationEO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthenticationDao extends JpaRepository<UserAuthenticationEO, Long> {

}