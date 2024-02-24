package com.service.nanodataxml.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "binario")
public class BinarioDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "binario_seq")
    @SequenceGenerator(name = "binario_seq", sequenceName = "binario_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "nome_arquivo")
    private String nomeArquivo;

    @Column(name = "conteudo_arquivo", columnDefinition = "BLOB")
    private byte[] conteudoArquivo;

}
