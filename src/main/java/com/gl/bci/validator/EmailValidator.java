package com.gl.bci.validator;

import static com.gl.bci.utils.RegexUtils.PATTERN_MATCHES;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Objects;

public class EmailValidator implements ConstraintValidator<Email, Object> {

  private static final String PATTERN = "[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z]{2,}";

  @Override
  public void initialize(Email constraintAnnotation) {
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
