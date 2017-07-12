package com.connect.rh.presenter.abstractions;

/**
 * Created by 80056 on 2/22/2017.
 */

public interface IPresenter {
    void resume();

    void pause();

    void stop();

    void destroy();

    void onError(String message);
}
