package com.wipro.java.fullstack.employer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Validated
@Data
@Builder
public class Attributes {
    @JsonProperty("jobName")
    private String jobName = null;

    @JsonProperty("jobDescription")
    private String jobDescription = null;

    @JsonProperty("projectName")
    private String projectName = null;

    @JsonProperty("location")
    private String location = null;

    @JsonProperty("employeeBand")
    private String employeeBand = null;

    @JsonProperty("experienceInMonths")
    private Integer experienceInMonths = null;

    @JsonProperty("numberOfOpenings")
    private Integer numberOfOpenings = null;

    @JsonProperty("creationDate")
    private String creationDate = null;

    @JsonProperty("primarySkills")
    private Skills primarySkills = null;

    @JsonProperty("optionalSkills")
    private Skills optionalSkills = null;
}
