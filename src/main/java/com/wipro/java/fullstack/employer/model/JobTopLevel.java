package com.wipro.java.fullstack.employer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.springframework.validation.annotation.Validated;

@Validated
@lombok.Data
@Builder
public class JobTopLevel {

    @JsonProperty("data")
    private Data data = null;

    @JsonProperty("links")
    private Links links = null;
}
