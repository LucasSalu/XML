package com.service.nanodataxml.repository;


import com.service.nanodataxml.model.util.entity.NfeProcDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NfeProcRepository extends JpaRepository<NfeProcDTO, Long> {

}
