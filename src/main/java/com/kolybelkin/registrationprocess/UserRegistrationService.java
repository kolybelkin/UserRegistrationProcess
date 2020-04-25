package com.kolybelkin.registrationprocess;

import com.kolybelkin.registrationprocess.model.UserRegistrationRequest;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationService implements JavaDelegate {
  private static final Logger LOGGER = LoggerFactory.getLogger(UserRegistrationService.class);

  @Autowired
  private UserRepository userRepository;

  @Override
  public void execute(final DelegateExecution execution) {
    final UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest(execution);
    userRepository.registerUser(userRegistrationRequest);
    LOGGER.debug("{} has been submitted.", userRegistrationRequest);
  }
}
