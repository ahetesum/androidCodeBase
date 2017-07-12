package com.connect.rh.domain.executor;

public interface MainThread {
    void post(final Runnable runnable);
}
