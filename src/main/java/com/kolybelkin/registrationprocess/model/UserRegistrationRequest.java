package com.kolybelkin.registrationprocess.model;

import org.camunda.bpm.engine.delegate.VariableScope;

public class UserRegistrationRequest {
  private static final String NAME_VAR = "username";
  private static final String EMAIL_VAR = "email";
  private static final String PASSWORD_VAR = "password";
  private static final String USER_EXIST_VAR = "userExist";

  private final VariableScope variableScope;

  public UserRegistrationRequest(final VariableScope variableScope) {
    this.variableScope = variableScope;
  }

  public String getUsername() {
    return variableScope.getVariable(NAME_VAR).toString();
  }

  public String getEmail() {
    return variableScope.getVariable(EMAIL_VAR).toString();
  }

  public String getPassword() {
    return variableScope.getVariable(PASSWORD_VAR).toString();
  }

  public void setUserExist(final boolean userExist) {
    variableScope.setVariable(USER_EXIST_VAR, userExist);
  }

  public String getUserExist() {
    return variableScope.getVariable(USER_EXIST_VAR).toString();
  }

  @Override
  public String toString() {
    return "UserRegistrationRequest{"
        + "username=" + getUsername()
        + "email=" + getEmail()
        + "password=" + getPassword()
        + "userExist=" + getUserExist()
        + '}';
  }
}
