package com.kolybelkin.registrationprocess;

import com.kolybelkin.registrationprocess.model.UserRegistrationRequest;

public interface UserRepository {
  void registerUser(UserRegistrationRequest userRegistrationRequest);

  boolean isUserExist(UserRegistrationRequest userRegistrationRequest);
}
