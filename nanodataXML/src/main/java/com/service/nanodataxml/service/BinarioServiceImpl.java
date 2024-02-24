package com.service.nanodataxml.service;

import com.service.nanodataxml.model.entity.BinarioDTO;
import com.service.nanodataxml.model.util.entity.NfeProcDTO;
import com.service.nanodataxml.repository.BinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@Service
public class BinarioServiceImpl implements BinarioService {

    @Autowired
    private BinarioRepository binarioRepository;;

    public BinarioDTO save(MultipartFile file) throws IOException {
        String nomeArquivo = Objects.requireNonNull(file.getOriginalFilename());
        byte[] conteudoArquivo = file.getBytes();

        BinarioDTO binarioDTO = new BinarioDTO();
        binarioDTO.setNomeArquivo(nomeArquivo);
        binarioDTO.setConteudoArquivo(conteudoArquivo);

        return binarioRepository.save(binarioDTO);
    }

    @Override
    public Optional<BinarioDTO> findById(Long id) {
        return binarioRepository.findById(id);
    }

    public void deleteById(Long id){
        binarioRepository.deleteById(id);
    }
}
