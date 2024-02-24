package com.service.nanodataxml.model.entity;

import lombok.Data;

@Data
public class NFe {
    InfNFe infNFe;

    public InfNFe getInfNFe() {
        return infNFe;
    }

    public void setInfNFe(InfNFe infNFe) {
        this.infNFe = infNFe;
    }
}
