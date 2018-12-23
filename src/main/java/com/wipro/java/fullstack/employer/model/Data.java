package com.wipro.java.fullstack.employer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.springframework.validation.annotation.Validated;

@Validated
@lombok.Data
@Builder
public class Data {
    @JsonProperty("type")
    private String type = null;

    @JsonProperty("id")
    private String id = null;

    @JsonProperty("attributes")
    private Attributes attributes = null;
}
