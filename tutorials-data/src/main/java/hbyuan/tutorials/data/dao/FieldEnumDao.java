package hbyuan.tutorials.data.dao;

import hbyuan.tutorials.data.entity.FieldEnumOptionEO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldEnumDao extends JpaRepository<FieldEnumOptionEO, Long> {

}