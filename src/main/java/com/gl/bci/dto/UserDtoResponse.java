package com.gl.bci.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gl.bci.entity.User;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class UserDtoResponse {

  private UUID id;
  @JsonFormat(pattern = "MMM dd, yyyy hh:mm:ss a")
  private LocalDateTime created;
  @JsonFormat(pattern = "MMM dd, yyyy hh:mm:ss a")
  private LocalDateTime lastLogin;
  private Jwt token;
  private boolean isActive;
  private String name;
  private String email;
  private String password;
  private List<PhoneDto> phones;

  public static UserDtoResponse fromEntity(User user) {
    return UserDtoResponse.builder()
        .id(user.getId())
        .created(user.getCreated())
        .lastLogin(user.getLastLogin())
        .isActive(user.isActive())
        .name(user.getName())
        .email(user.getEmail())
        .password(user.getPassword())
        .phones(PhoneDto.fromEntities(user.getPhones()))
        .build();
  }
}
