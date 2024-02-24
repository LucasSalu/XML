package com.service.nanodataxml.service;

import com.service.nanodataxml.model.entity.BinarioDTO;
import com.service.nanodataxml.model.util.entity.NfeProcDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface BinarioService {

    BinarioDTO save(MultipartFile fileXML) throws IOException;

    Optional<BinarioDTO> findById(Long id);

    void deleteById(Long id);



}
