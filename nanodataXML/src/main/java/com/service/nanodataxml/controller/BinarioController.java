package com.service.nanodataxml.controller;

import com.service.nanodataxml.model.entity.BinarioDTO;
import com.service.nanodataxml.model.util.entity.NfeProcDTO;
import com.service.nanodataxml.service.BinarioService;
import com.service.nanodataxml.service.NfeProcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/binario")
@CrossOrigin(origins = "*")
public class BinarioController {

    @Autowired
    private BinarioService binarioService;

    @GetMapping("/download/{id}")
    public ResponseEntity<Optional<BinarioDTO>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(binarioService.findById(id));
    }




}
