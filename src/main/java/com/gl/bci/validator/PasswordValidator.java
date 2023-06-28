package com.gl.bci.validator;

import static com.gl.bci.utils.RegexUtils.PATTERN_MATCHES;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Objects;

public class PasswordValidator implements ConstraintValidator<Password, Object> {

  private static final String PATTERN = "^(?=.*[A-Z])(?=(?:.*[a-z]){8,12})(?=(?:.*\\d){2})(?!.*[^a-zA-Z0-9]).{8,12}$";

  @Override
  public void initialize(Password constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Override
  public boolean isValid(Object value, ConstraintValidatorContext context) {
    if (Objects.isNull(value)) {
      return false;
    }
    return PATTERN_MATCHES(value.toString(), PATTERN);
  }
}