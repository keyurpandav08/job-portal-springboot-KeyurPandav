package com.keyurpandav.jobber.dto;

import com.keyurpandav.jobber.entity.Application;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ApplicationDto {
    private Long id;
    private String applicantName;
    private String jobTitle;
    private String resumeUrl;
    private String status; // enum string

    public static ApplicationDto toDto(Application a){
        return ApplicationDto.builder()
                .id(a.getId())
                .applicantName(a.getApplicant().getUsername())
                .jobTitle(a.getJob().getTitle())
                .resumeUrl(a.getResumeUrl())
                .status(a.getStatus().name())
                .build();
    }
}