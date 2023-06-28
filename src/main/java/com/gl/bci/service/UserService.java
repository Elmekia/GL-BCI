package com.gl.bci.service;

import com.gl.bci.dto.UserDtoCreate;
import com.gl.bci.dto.UserDtoResponse;

public interface UserService {

  UserDtoResponse create(UserDtoCreate userDto);

}
