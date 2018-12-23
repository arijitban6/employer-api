package com.wipro.java.fullstack.employer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Validated
@Data
@Builder
public class Links {
    @JsonProperty("self")
    private String self = null;

    @JsonProperty("uri2")
    private String uri2 = null;
}
