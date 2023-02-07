package com.emsi.professorservice.utils;

import com.emsi.professorservice.entities.Professor;
import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;

import javax.ws.rs.core.Response;
import java.util.List;

public class KeycloakUtils {
    private static Keycloak getAdminKeycloakUser() {
        return KeycloakBuilder.builder()
                .serverUrl("http://localhost:8100/")
                .grantType("password")
                .realm("absence-manager")
                .clientId("professor-service")
                .clientSecret("vLdabfKVk9e9R643N6CLqJTkfUPWfEAe")
                .username("admin")
                .password("Admin123")
                .build();
    }
    private static RealmResource getRealm() {
        return getAdminKeycloakUser().realm("absence-manager");
    }

    private static void setCredentials(String userId, String password){
        CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
        credentialRepresentation.setTemporary(false);
        credentialRepresentation.setType("password");
        credentialRepresentation.setValue(password);

        UserResource userResource = getRealm().users().get(userId);
        userResource.resetPassword(credentialRepresentation);
    }

    private static void addStudentRole(String userId){
        RoleRepresentation role = getRealm().roles().get("PROFESSOR").toRepresentation();

        UserResource userResource = getRealm().users().get(userId);
        userResource.roles().realmLevel().add(List.of(role));
    }

    public static void createKeycloakUserWithRole(Professor professor, String password){
        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setLastName(professor.getLastname());
        userRepresentation.setFirstName(professor.getFirstname());
        userRepresentation.setUsername(professor.getEmail());
        userRepresentation.setEnabled(true);
        userRepresentation.setEmail(professor.getEmail());
        Response response = getRealm().users().create(userRepresentation);
        String userId = CreatedResponseUtil.getCreatedId(response);
        setCredentials(userId, password);
        addStudentRole(userId);
    }
}
