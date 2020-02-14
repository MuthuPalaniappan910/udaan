package com.spiralforge.udaan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spiralforge.udaan.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

}
