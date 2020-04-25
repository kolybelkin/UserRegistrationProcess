package com.kolybelkin.registrationprocess.model;

import org.camunda.bpm.engine.delegate.VariableScope;

public class UserRegistrationRequest {
  private static final String NAME_VAR = "username";
  private static final String EMAIL_VAR = "email";
  private static final String PASSWORD_VAR = "email";

  private final VariableScope variableScope;

  public UserRegistrationRequest(VariableScope variableScope) {
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

  @Override
  public String toString() {
    return "UserRegistrationRequest{" +
        "username=" + getUsername() +
        "email=" + getEmail() +
        "password=" + getPassword() +
        '}';
  }
}
