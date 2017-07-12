package com.connect.rh.domain.executor;

import com.connect.rh.domain.interactor.Interactor;

public interface Executor {
    void execute(final Interactor interactor);
}
