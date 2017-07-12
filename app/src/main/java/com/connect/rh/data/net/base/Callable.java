package com.connect.rh.data.net.base;

public interface Callable<T> {
    T call(SessionManager sessionManager) throws Exception;
}
