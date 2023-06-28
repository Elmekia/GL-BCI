package com.gl.bci.utils;

import java.util.regex.Pattern;

public final class RegexUtils {

  private RegexUtils(){
    throw new IllegalStateException("utility class");
  }

  public static boolean PATTERN_MATCHES(String emailAddress, String regexPattern) {
    return Pattern.compile(regexPattern)
        .matcher(emailAddress)
        .matches();
  }

}
