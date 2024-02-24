package com.service.nanodataxml.model.entity;

import lombok.Data;

@Data
public class Ide {
    private String dhEmi;
    private String nNF;
    private String cUF;

    public String getDhEmi() {
        return dhEmi;
    }

    public String getnNF() {
        return nNF;
    }

    public String getcUF() {
        return cUF;
    }

    public void setDhEmi(String dhEmi) {
        this.dhEmi = dhEmi;
    }

    public void setnNF(String nNF) {
        this.nNF = nNF;
    }

    public void setcUF(String cUF) {
        this.cUF = cUF;
    }
}
