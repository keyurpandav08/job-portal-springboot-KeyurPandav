package com.keyurpandav.jobber.dto;

import com.keyurpandav.jobber.entity.User;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String roleName;

    public static UserDto toDto(User u){
        return UserDto.builder()
                .id(u.getId())
                .username(u.getUsername())
                .email(u.getEmail())
                .roleName(u.getRole().getName())
                .build();
    }
}