package com.gl.bci.controller;

import com.gl.bci.dto.UserDtoCreate;
import com.gl.bci.dto.UserDtoResponse;
import com.gl.bci.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/sign-up")
  @ResponseStatus(HttpStatus.CREATED)
  public UserDtoResponse create(@RequestBody @Valid UserDtoCreate user) {
    return userService.create(user);
  }

}
