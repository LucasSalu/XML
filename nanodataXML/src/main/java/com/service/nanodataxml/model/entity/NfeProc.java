package com.service.nanodataxml.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NfeProc {

    @JsonProperty("NFe")
    private NFe nFe;

    public NFe getnFe() {
        return nFe;
    }

    public void setnFe(NFe nFe) {
        this.nFe = nFe;
    }
}
