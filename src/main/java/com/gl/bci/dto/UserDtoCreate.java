package com.gl.bci.dto;

import com.gl.bci.entity.User;
import com.gl.bci.validator.Email;
import com.gl.bci.validator.Password;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UserDtoCreate {

  private String name;
  @Email()
  private String email;
  @Password
  private String password;
  private List<PhoneDto> phones;

  public static User toEntity(UserDtoCreate dto, UUID id) {
    User user = User.builder()
        .id(id)
        .name(dto.getName())
        .email(dto.getEmail())
        .password(dto.getPassword())
        .build();
    user.setPhones(PhoneDto.toEntities(dto.getPhones(), user));
    return user;
  }

}
