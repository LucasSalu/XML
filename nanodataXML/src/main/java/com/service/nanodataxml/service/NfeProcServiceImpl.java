package com.service.nanodataxml.service;

import com.service.nanodataxml.model.entity.BinarioDTO;
import com.service.nanodataxml.model.shared.UtilNfe;
import com.service.nanodataxml.repository.BinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.service.nanodataxml.repository.NfeProcRepository;
import com.service.nanodataxml.model.entity.NfeProc;
import com.service.nanodataxml.model.util.entity.NfeProcDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NfeProcServiceImpl implements NfeProcService{

    @Autowired
    private NfeProcRepository repository;
    @Autowired
    private BinarioService binarioService;

    @Override
    public List<List<String>> saveAll(List<MultipartFile> fileXML) {
        List<List<String>> results = new ArrayList<>();
        List<String> listOK = new ArrayList<String>();
        List<String> listError = new ArrayList<String>();

        for(MultipartFile xml: fileXML) {
            try{
                BinarioDTO binarioDTO = binarioService.save(xml);
                NfeProc nfeProc = UtilNfe.convertFiletoNfeProc(xml);
                NfeProcDTO nfeProcDTO = UtilNfe.fromNfeProc(nfeProc);
                nfeProcDTO.setBinario(binarioDTO);
                repository.save(nfeProcDTO);
                listOK.add(xml.getOriginalFilename());
            }catch (Exception e){
                listError.add(xml.getOriginalFilename());
            }
        }
        results.add(listOK);
        results.add(listError);
        return results;
    }

    @Override
    public List<NfeProcDTO> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<NfeProcDTO> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        NfeProcDTO nfeProcDTO = repository.getReferenceById(id);
        repository.deleteById(id);
        binarioService.deleteById(nfeProcDTO.getBinario().getId());
    }
}
