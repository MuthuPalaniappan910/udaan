package com.spiralforge.udaan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spiralforge.udaan.entity.Scheme;

@Repository
public interface SchemeRepository extends JpaRepository<Scheme, Long> {

}
