package com.service.nanodataxml.service;

import com.service.nanodataxml.model.util.entity.NfeProcDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface NfeProcService {

    List<List<String>> saveAll(List<MultipartFile> product) throws IOException;

    List<NfeProcDTO> findAll();

    Optional<NfeProcDTO> findById(Long id);

    void deleteById(Long id);
}
