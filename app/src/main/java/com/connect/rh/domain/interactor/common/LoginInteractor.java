package com.connect.rh.domain.interactor.common;

import com.connect.rh.data.repository.NetworkRepository;
import com.connect.rh.data.repository.Repository;
import com.connect.rh.domain.executor.Executor;
import com.connect.rh.domain.executor.MainThread;
import com.connect.rh.domain.interactor.Interactor;
import com.connect.rh.domain.interactor.ResponseSubscriber;

/**
 * Created by Ali on 2/26/2017.
 */

public class LoginInteractor extends Interactor {
    private String body;

    public LoginInteractor(Executor threadExecutor, MainThread mainThread, ResponseSubscriber callback, Repository repository) {
        super(threadExecutor, mainThread, callback);
        this.repository = repository;
    }

    @Override
    public void run() throws Exception {
        entity = ((NetworkRepository) this.repository).performLogIn(body);
    }

    @Override
    public void execute() {
        super.execute();
    }

    public void performLogIn(String body) {
        this.body = body;
        execute();
    }


}
