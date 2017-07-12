package com.connect.rh.presenter.abstractions;


import com.connect.rh.data.net.base.SessionManager;
import com.connect.rh.domain.interactor.Interactor;
import com.connect.rh.utils.AuthenticationHandler;

/**
 * Created by 80056 on 2/22/2017.
 */

public abstract class Presenter implements IPresenter
{
    protected final AuthenticationHandler authenticationHandler;
    protected Interactor interactor;
    protected RHView view = null;

    public Presenter(RHView view)
    {
        this.view = view;
        authenticationHandler = new AuthenticationHandler(SessionManager.getInstance(view.getViewContext()));
    }


}
