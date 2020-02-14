package com.spiralforge.udaan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spiralforge.udaan.entity.Donation;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

}
