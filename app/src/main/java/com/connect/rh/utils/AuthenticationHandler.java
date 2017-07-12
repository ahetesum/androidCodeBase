package com.connect.rh.utils;


import com.connect.rh.data.entities.entities.Entity;
import com.connect.rh.data.net.base.SessionManager;

/**
 * Created by Ahetesum on 7/29/16.
 */
public class AuthenticationHandler  {

    private final SessionManager sessionManager;

    public AuthenticationHandler(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    public boolean authenticate(Entity entity) {
        boolean authenticated = true;
        if (entity != null && entity.status != null)
            authenticated = !entity.status.equalsIgnoreCase("402");
        if (!authenticated) {
            sessionManager.sessionExpired();
        }

        return authenticated;
    }
}
