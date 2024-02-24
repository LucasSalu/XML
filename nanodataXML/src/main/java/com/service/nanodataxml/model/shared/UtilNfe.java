package com.service.nanodataxml.model.shared;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.service.nanodataxml.model.entity.NfeProc;
import com.service.nanodataxml.model.util.entity.NfeProcDTO;
import lombok.SneakyThrows;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UtilNfe {

    public static NfeProcDTO fromNfeProc(NfeProc nfeProc) {
        NfeProcDTO dto = new NfeProcDTO();
        dto.setCodigo(nfeProc.getnFe().getInfNFe().getId());
        dto.setDhEmi(convertStringToTimestamp(nfeProc.getnFe().getInfNFe().getIde().getDhEmi()));
        dto.setNNF(nfeProc.getnFe().getInfNFe().getIde().getnNF());
        dto.setCUF(nfeProc.getnFe().getInfNFe().getIde().getcUF());
        dto.setEmmitCnpj(nfeProc.getnFe().getInfNFe().getEmit().getCnpj());
        dto.setXFant(nfeProc.getnFe().getInfNFe().getEmit().getCnpj());
        dto.setDestCnpj(nfeProc.getnFe().getInfNFe().getDest().getCnpj());
        dto.setXNome(nfeProc.getnFe().getInfNFe().getDest().getxNome());
        dto.setVTotTrib(nfeProc.getnFe().getInfNFe().getTotal().getICMSTot().getvTotTrib());
        dto.setVNF(nfeProc.getnFe().getInfNFe().getTotal().getICMSTot().getvNF());
        return dto;
    }

    public static Timestamp convertStringToTimestamp(String dhEmiString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
        LocalDateTime dateTime = LocalDateTime.parse(dhEmiString, formatter);
        return Timestamp.valueOf(dateTime);
    }

    public static File convertMultipartFileToFile(MultipartFile fileXML) throws IOException {
        File file = new File(fileXML.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(fileXML.getBytes());
        fos.close();
        return file;
    }


    @SneakyThrows
    public static NfeProc convertFiletoNfeProc(MultipartFile fileXML) throws IOException {
        byte[] xmlBytes = fileXML.getBytes();
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return xmlMapper.readValue(new ByteArrayInputStream(xmlBytes), NfeProc.class);
    }



}
