package com.emsi.staffservice.utils;

import com.emsi.staffservice.entities.Staff;
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
                .clientId("staff-service")
                .clientSecret("rYCG5lHdvr5LeyH4AyH3tKRgJkRQGiPG")
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

    private static void addStaffRole(String userId){
        RoleRepresentation role = getRealm().roles().get("STAFF").toRepresentation();
        UserResource userResource = getRealm().users().get(userId);
        userResource.roles().realmLevel().add(List.of(role));
    }

    public static void createKeycloakUserWithRole(Staff staff, String password){
        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setLastName(staff.getLastname());
        userRepresentation.setFirstName(staff.getFirstname());
        userRepresentation.setUsername(staff.getEmail());
        userRepresentation.setEnabled(true);
        userRepresentation.setEmail(staff.getEmail());
        Response response = getRealm().users().create(userRepresentation);
        String userId = CreatedResponseUtil.getCreatedId(response);
        setCredentials(userId, password);
        addStaffRole(userId);
    }
}
