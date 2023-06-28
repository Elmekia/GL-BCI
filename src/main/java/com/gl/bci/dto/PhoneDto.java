package com.gl.bci.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gl.bci.entity.Phone;
import com.gl.bci.entity.User;
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
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class PhoneDto {

  private long number;
  @JsonProperty("citycode")
  private int cityCode;
  @JsonProperty("countrycode")
  private String countryCode;

  public static Phone toEntity(PhoneDto dto, User user) {
    return Phone.builder()
        .user(user)
        .cityCode(dto.getCityCode())
        .countryCode(dto.getCountryCode())
        .number(dto.getNumber())
        .build();
  }

  public static List<Phone> toEntities(List<PhoneDto> dto, User user) {
    return dto
        .stream()
        .map(p -> PhoneDto.toEntity(p, user)).toList();
  }

  public static PhoneDto fromEntity(Phone phone) {
    return PhoneDto.builder()
        .cityCode(phone.getCityCode())
        .countryCode(phone.getCountryCode())
        .number(phone.getNumber())
        .build();
  }

  public static List<PhoneDto> fromEntities(List<Phone> dto) {
    return dto
        .stream()
        .map(PhoneDto::fromEntity).toList();
  }

}
