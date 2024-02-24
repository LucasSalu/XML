package com.service.nanodataxml.model.util.entity;

import jakarta.persistence.*;
import lombok.Data;
import com.service.nanodataxml.model.entity.BinarioDTO;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "nfe_proc")
public class NfeProcDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nfe_proc_seq")
    @SequenceGenerator(name = "nfe_proc_seq", sequenceName = "nfe_proc_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "dh_emi")
    private Timestamp dhEmi;

    @Column(name = "n_nf")
    private String nNF;

    @Column(name = "c_uf")
    private String cUF;

    @Column(name = "emmit_cnpj")
    private String emmitCnpj;

    @Column(name = "x_fant")
    private String xFant;

    @Column(name = "dest_cnpj")
    private String destCnpj;

    @Column(name = "x_nome")
    private String xNome;

    @Column(name = "v_tot_trib")
    private String vTotTrib;

    @Column(name = "v_nf")
    private String vNF;

    @OneToOne
    @JoinColumn(name = "id_binario")
    private BinarioDTO binario;


    // Construtor com todos os campos
    public NfeProcDTO(Long id, String codigo, Timestamp dhEmi, String nNF, String cUF, String emmitCnpj,
                      String xFant, String destCnpj, String xNome, String vTotTrib, String vNF) {
        this.id = id;
        this.codigo = codigo;
        this.dhEmi = dhEmi;
        this.nNF = nNF;
        this.cUF = cUF;
        this.emmitCnpj = emmitCnpj;
        this.xFant = xFant;
        this.destCnpj = destCnpj;
        this.xNome = xNome;
        this.vTotTrib = vTotTrib;
        this.vNF = vNF;
    }

    public NfeProcDTO() {

    }

}