package com.kolybelkin.registrationprocess;

import com.kolybelkin.registrationprocess.model.UserRegistrationRequest;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserValidatorService implements JavaDelegate {
  private static final Logger LOGGER = LoggerFactory.getLogger(UserValidatorService.class);
  private static final String USER_EXIST_CAM_VARIABLE = "userExist";

  @Autowired
  private UserRepository userRepository;

  @Override
  public void execute(final DelegateExecution execution) {
    final UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest(execution);
    boolean userExist = userRepository.isUserExist(userRegistrationRequest);
    execution.setVariable(USER_EXIST_CAM_VARIABLE, userExist);
    LOGGER.debug("{} has been validated with outcome '{}'.", userRegistrationRequest, userExist);
  }
}
