package com.wipro.java.fullstack.employer.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "JOB", schema = "java_user", catalog = "")
@Data
public class JobEntity {

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    @GeneratedValue(generator="JOB_ID_SEQ")
    @SequenceGenerator(name="JOB_ID_SEQ",sequenceName="JOB_ID_SEQ", allocationSize=1)
    private long id;
    @Basic
    @Column(name = "JOB_NAME", nullable = false, length = 20)
    private String jobName;
    @Basic
    @Column(name = "JOB_DESCRIPTION", nullable = true)
    private String jobDescription;
    @Basic
    @Column(name = "PROJECT_NAME", nullable = true, length = 20)
    private String projectName;
    @Basic
    @Column(name = "LOCATION", nullable = true, length = 20)
    private String location;
    @Basic
    @Column(name = "EMPLOYEE_BAND", nullable = true, length = 20)
    private String employeeBand;
    @Basic
    @Column(name = "EXPERIENCE_IN_MONTHS", nullable = false, precision = 0)
    private long experienceInMonths;
    @Basic
    @Column(name = "NO_OF_OPENINGS", nullable = false, precision = 0)
    private long noOfOpenings;
    @Basic
    @Column(name = "CREATION_DATE", nullable = false)
    private Date creationDate;
    @Basic
    @Column(name = "EMAIL_ID", nullable = false, length = 20)
    private String emailId;

    @Basic
    @Column(name = "CONTACT_NUMBER", nullable = true, precision = 0)
    private Long contactNumber;

    @OneToMany(
            mappedBy = "jobEntity",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    List<SkillEntity> skillEntityList;
}
