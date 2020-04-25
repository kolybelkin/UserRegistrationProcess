package com.kolybelkin.registrationprocess.keycloak;

import com.kolybelkin.registrationprocess.UserRepository;
import com.kolybelkin.registrationprocess.model.UserRegistrationRequest;
import java.util.List;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;

public class KeycloakUserRepository implements UserRepository {

  @Autowired
  private UsersResource usersResource;

  @Override
  public void registerUser(final UserRegistrationRequest userRegistrationRequest) {
    final UserRepresentation userRepresentation = createUserRepresentation(userRegistrationRequest);
    usersResource.create(userRepresentation);
  }

  @Override
  public boolean isUserExist(UserRegistrationRequest userRegistrationRequest) {
    List<UserRepresentation> foundUsers = usersResource.search(userRegistrationRequest.getUsername());
    return !foundUsers.isEmpty();
  }

  private UserRepresentation createUserRepresentation(final UserRegistrationRequest userRegistrationRequest) {
    final UserRepresentation userRepresentation = new UserRepresentation();
    userRepresentation.setUsername(userRegistrationRequest.getUsername());
    userRepresentation.setEmail(userRegistrationRequest.getEmail());
    userRepresentation.setEmailVerified(true);
    userRepresentation.setEnabled(true);
    final CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
    credentialRepresentation.setType(CredentialRepresentation.PASSWORD);
    credentialRepresentation.setValue(userRegistrationRequest.getPassword());
    userRepresentation.setCredentials(List.of(credentialRepresentation));
    return userRepresentation;
  }
}
