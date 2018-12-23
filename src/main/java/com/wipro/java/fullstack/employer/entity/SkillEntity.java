package com.wipro.java.fullstack.employer.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "SKILL", schema = "JAVA_USER", catalog = "")
@Data
public class SkillEntity {

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    @GeneratedValue(generator="SKILL_ID_SEQ")
    @SequenceGenerator(name="SKILL_ID_SEQ",sequenceName="SKILL_ID_SEQ", allocationSize=1)
    private long id;

    @Basic
    @Column(name = "SKILL_NAME", nullable = true, length = 20)
    private String skillName;
    @Basic
    @Column(name = "SKILL_TYPE", nullable = true, length = 20)
    private String skillType;


    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "JOB_ID")
    JobEntity jobEntity;

}
