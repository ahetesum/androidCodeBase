package com.connect.rh.domain.interactor;

public interface IInteractor {
    void execute();

    void execute(String body);

    void execute(String url, String body);

    void cancel();

    boolean isRunning();

    void onFinished();
}
