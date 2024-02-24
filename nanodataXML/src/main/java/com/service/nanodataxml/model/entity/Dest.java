package com.service.nanodataxml.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Dest {

    @JsonProperty("CNPJ")
    private String cnpj;
    private String xNome;

    public String getCnpj() {
        return cnpj;
    }

    public String getxNome() {
        return xNome;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setxNome(String xNome) {
        this.xNome = xNome;
    }
}
