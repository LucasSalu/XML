package com.service.nanodataxml.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.service.nanodataxml.model.entity.NfeProc;
import com.service.nanodataxml.service.NfeProcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.service.nanodataxml.model.util.entity.NfeProcDTO;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/nfe")
@CrossOrigin(origins = "*")
public class NfeProcController {

    @Autowired
    private NfeProcService nfeProcService;

    @GetMapping
    public ResponseEntity<List<NfeProcDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(nfeProcService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<NfeProcDTO>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(nfeProcService.findById(id));
    }

    @PostMapping
    public ResponseEntity<List<List<String>>> create(@RequestParam("files[]") List<MultipartFile> fileXML) throws IOException {
        return ResponseEntity.status(HttpStatus.CREATED).body(nfeProcService.saveAll(fileXML));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        nfeProcService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }



}
