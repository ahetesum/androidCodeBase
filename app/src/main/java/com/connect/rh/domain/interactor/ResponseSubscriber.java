package com.connect.rh.domain.interactor;


import com.connect.rh.data.entities.entities.Entity;
import com.connect.rh.utils.AuthenticationHandler;

public abstract class ResponseSubscriber<T extends Entity> {

    private final AuthenticationHandler authenticationHandler;

    protected ResponseSubscriber(AuthenticationHandler authenticationHandler) {
        this.authenticationHandler = authenticationHandler;
    }

    public void failed(String error) {
        onFailure(error);
    }

    protected abstract void onSuccess(T entity);

    protected abstract void onFailure(String error);

    protected abstract void onAuthFailure();

    public void onResponse(T entity) {
        if (entity == null) {
            onFailure("Request failed!");
        } else if (!authenticationHandler.authenticate(entity)) {
            onAuthFailure();
        } else if (entity.status.equalsIgnoreCase("success")) {
            onSuccess(entity);
        } else if (!entity.status.isEmpty()) {
            onFailure(entity.dispMessage);
        } else {
            onSuccess(entity);
        }
    }
}