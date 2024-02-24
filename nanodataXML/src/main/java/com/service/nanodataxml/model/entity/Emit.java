package com.service.nanodataxml.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Emit {

    @JsonProperty("CNPJ")
    private String cnpj;
    private String xFant;

    public String getCnpj() {
        return cnpj;
    }

    public String getxFant() {
        return xFant;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setxFant(String xFant) {
        this.xFant = xFant;
    }
}
