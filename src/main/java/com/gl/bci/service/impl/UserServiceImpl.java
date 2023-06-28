package com.gl.bci.service.impl;

import com.gl.bci.dto.UserDtoCreate;
import com.gl.bci.dto.UserDtoResponse;
import com.gl.bci.entity.User;
import com.gl.bci.repository.UserRepository;
import com.gl.bci.service.UserService;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDtoResponse create(UserDtoCreate userDto) {
    UUID id = UUID.randomUUID();
    User user = UserDtoCreate.toEntity(userDto, id);
    return UserDtoResponse.fromEntity(this.userRepository.save(user));
  }
}
