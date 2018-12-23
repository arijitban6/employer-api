package com.wipro.java.fullstack.employer.mapper;

import com.wipro.java.fullstack.employer.entity.JobEntity;
import com.wipro.java.fullstack.employer.entity.SkillEntity;
import com.wipro.java.fullstack.employer.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityMapper implements TwoWayMapper<JobEntity, JobTopLevel> {

    @Autowired
    HttpServletRequest httpServletRequest;
    @Override
    public JobEntity mapTo(JobTopLevel from) {
        Skills[] skills = new Skills[2];
        skills[0] = from.getData().getAttributes().getOptionalSkills();
        skills[1] = from.getData().getAttributes().getPrimarySkills();
        JobEntity jobEntity = new JobEntity();
        jobEntity.setJobName(from.getData().getAttributes().getJobName());
        jobEntity.setJobDescription(from.getData().getAttributes().getJobDescription());
        jobEntity.setProjectName(from.getData().getAttributes().getProjectName());
        jobEntity.setLocation(from.getData().getAttributes().getLocation());
        jobEntity.setEmployeeBand(from.getData().getAttributes().getEmployeeBand());
        jobEntity.setExperienceInMonths(from.getData().getAttributes().getExperienceInMonths());
        jobEntity.setNoOfOpenings(from.getData().getAttributes().getNumberOfOpenings());
        jobEntity.setCreationDate(new Date());
        jobEntity.setEmailId("testEmail@xyz.com");
        jobEntity.setSkillEntityList(getSkills(jobEntity ,from));

        return jobEntity;
    }

    private List<SkillEntity> getSkills(JobEntity jobEntity, JobTopLevel from) {
        List<SkillEntity> collect = new ArrayList<>();
        Skills primarySkills = from.getData().getAttributes().getPrimarySkills();
        for (String s: primarySkills) {
            SkillEntity skillEntity =  new SkillEntity();
            skillEntity.setJobEntity(jobEntity);
            skillEntity.setSkillName(s);
            skillEntity.setSkillType("primary");
            collect.add(skillEntity);
        }
        Skills optionalSkills = from.getData().getAttributes().getOptionalSkills();
        for (String s: optionalSkills) {
            SkillEntity skillEntity =  new SkillEntity();
            skillEntity.setJobEntity(jobEntity);
            skillEntity.setSkillName(s);
            skillEntity.setSkillType("optional");
            collect.add(skillEntity);
        }
        return collect;
    }

    @Override
    public JobTopLevel mapFrom(JobEntity to) {
        return JobTopLevel.builder()
                .data(Data.builder()
                        .id(String.valueOf(to.getId()))
                        .type("Job")
                        .attributes(Attributes.builder()
                                .jobName(to.getJobName())
                                .jobDescription(to.getJobDescription())
                                .projectName(to.getProjectName())
                                .location(to.getLocation())
                                .employeeBand(to.getEmployeeBand())
                                .experienceInMonths((int) to.getExperienceInMonths())
                                .numberOfOpenings((int) to.getNoOfOpenings())
                                .creationDate(to.getCreationDate().toString())
                                .optionalSkills(getSkill(to.getSkillEntityList(), "optional"))
                                .primarySkills(getSkill(to.getSkillEntityList(), "primary"))
                                .build())
                        .build())
                .links(Links.builder().self(httpServletRequest.getRequestURI()).build())
                .build();
    }

    private Skills getSkill(List<SkillEntity> skillEntities, String skillType) {
        Skills strings = new Skills();
        List<String> collect = skillEntities.stream()
                .filter(skillEntity -> skillEntity.getSkillType().equals(skillType))
                .map(SkillEntity::getSkillName).collect(Collectors.toList());
        strings.addAll(collect);
        return strings;
    }
}
