package com.service.nanodataxml.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Total {

    @JsonProperty("ICMSTot")
    ICMSTot iCMSTot;

}
