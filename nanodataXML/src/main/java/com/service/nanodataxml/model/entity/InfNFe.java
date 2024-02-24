package com.service.nanodataxml.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class InfNFe {

    @JsonProperty("Id")
    private String id;
    private Ide ide;
    private Emit emit;
    private Dest dest;

    private Total total;

    public Ide getIde() {
        return ide;
    }

    public Emit getEmit() {
        return emit;
    }

    public Dest getDest() {
        return dest;
    }

    public void setIde(Ide ide) {
        this.ide = ide;
    }

    public void setEmit(Emit emit) {
        this.emit = emit;
    }

    public void setDest(Dest dest) {
        this.dest = dest;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
