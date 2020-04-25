package com.kolybelkin.registrationprocess.keycloak;

import com.kolybelkin.registrationprocess.UserRepository;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfiguration {

  @Value("${keycloak.serverUrl}")
  private String keycloakServerUrl;
  @Value("${keycloak.realm}")
  private String keycloakRealm;
  @Value("${keycloak.usersRealm}")
  private String usersRealm;
  @Value("${keycloak.clientId}")
  private String keycloakClientId;
  @Value("${keycloak.username}")
  private String keycloakUsername;
  @Value("${keycloak.password}")
  private String keycloakPassword;

  @Bean
  public Keycloak keycloak() {
    return KeycloakBuilder.builder()
        .serverUrl(keycloakServerUrl)
        .realm(keycloakRealm)
        .clientId(keycloakClientId)
        .username(keycloakUsername)
        .password(keycloakPassword)
        .build();
  }

  @Bean
  public UsersResource usersResource(final Keycloak keycloak) {
    RealmResource realm = keycloak.realm(usersRealm);
    return realm.users();
  }

  @Bean
  public UserRepository userValidator() {
    return new KeycloakUserRepository();
  }
}
