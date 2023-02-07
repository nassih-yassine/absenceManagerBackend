package com.emsi.studentservice.utils;

import com.emsi.studentservice.entities.Student;
import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

public class KeycloakUtils {
    private static Keycloak getAdminKeycloakUser() {
        return KeycloakBuilder.builder()
                .serverUrl("http://localhost:8100/")
                .grantType("password")
                .realm("absence-manager")
                .clientId("student-service")
                .clientSecret("vGF3Hj26pTZ4gusx3hGT3oHKitJ9Auud")
                .username("admin")
                .password("Admin123")
                .build();
    }
    private static RealmResource getRealm() {
        return getAdminKeycloakUser().realm("absence-manager");
    }

    public static void createKeycloakUserWithRole(Student student, String password){
        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setLastName(student.getLastName());
        userRepresentation.setFirstName(student.getFirstName());
        userRepresentation.setUsername(student.getEmail());
        userRepresentation.setEnabled(true);
        userRepresentation.setEmail(student.getEmail());
        Response response = getRealm().users().create(userRepresentation);
        String userId = CreatedResponseUtil.getCreatedId(response);
        setCredentials(userId, password);
        addStudentRole(userId);
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
        List<RoleRepresentation> roles = new ArrayList<>();
        RoleRepresentation role = getRealm().roles().get("STUDENT").toRepresentation();

        UserResource userResource = getRealm().users().get(userId);
        userResource.roles().realmLevel().add(List.of(role));
    }
}
