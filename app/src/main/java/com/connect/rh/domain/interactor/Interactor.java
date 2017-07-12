package com.connect.rh.domain.interactor;


import com.connect.rh.data.entities.entities.Entity;
import com.connect.rh.data.repository.Repository;
import com.connect.rh.domain.executor.Executor;
import com.connect.rh.domain.executor.MainThread;

public abstract class Interactor implements IInteractor {

    protected ResponseSubscriber mCallback;
    protected Executor mThreadExecutor;
    protected MainThread mMainThread;
    protected Repository repository;
    protected Entity entity;

    protected volatile boolean mIsCanceled;
    protected volatile boolean mIsRunning;

    public Interactor(Executor threadExecutor, MainThread mainThread, ResponseSubscriber callback) {
        mThreadExecutor = threadExecutor;
        mMainThread = mainThread;
        mCallback = callback;
    }

    public abstract void run() throws Exception;

    public void onException(Exception e) {
        postError(e.getMessage());
    }

    public void postError(final String error) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                if (mCallback != null)
                    mCallback.failed(error);
            }
        });
    }

    public void cancel() {
        mIsCanceled = true;
        mIsRunning = false;
    }

    public boolean isRunning() {
        return mIsRunning;
    }

    public void onFinished() {
        mIsRunning = false;
        mIsCanceled = false;
        postResponse(entity);
    }

    protected void postResponse(final Entity entity) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                if (mCallback != null)
                    mCallback.onResponse(entity);
            }
        });
    }

    @Override
    public void execute() {
        this.mIsRunning = true;
        mThreadExecutor.execute(this);
    }

    @Override
    public void execute(String body) {
        this.mIsRunning = true;
        mThreadExecutor.execute(this);
    }

    @Override
    public void execute(String url, String object) {
        this.mIsRunning = true;
        mThreadExecutor.execute(this);
    }
}