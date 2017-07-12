package com.connect.rh.domain.interactor.common;

import com.connect.rh.domain.executor.Executor;
import com.connect.rh.domain.executor.MainThread;
import com.connect.rh.domain.interactor.Interactor;
import com.connect.rh.domain.interactor.ResponseSubscriber;

/**
 * Created by Ali on 5/21/2017.
 */

public class LogOutInteractor extends Interactor
{

    public LogOutInteractor(Executor threadExecutor, MainThread mainThread, ResponseSubscriber callback) {
        super(threadExecutor, mainThread, callback);
    }

    @Override
    public void run() throws Exception {

    }
}
