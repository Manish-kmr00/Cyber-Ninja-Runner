package com.playon.bridge.common;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AsyncTaskExecutor<Params> {
    public static final String TAG = "AsyncTaskRunner";
    private static final Executor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private static final ScheduledThreadPoolExecutor scheduledExecutor = new ScheduledThreadPoolExecutor(5);
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean mIsInterrupted = false;

    protected abstract void doInBackground(Params... paramsArr);

    protected void onCancelled() {
    }

    protected void onPostExecute() {
    }

    protected void onPreExecute() {
    }

    public final void executeAsyncWithDelay(int i, Runnable runnable) {
        scheduledExecutor.schedule(runnable, i, TimeUnit.SECONDS);
    }

    @SafeVarargs
    public final void executeAsync(final Params... paramsArr) {
        THREAD_POOL_EXECUTOR.execute(new Runnable() { // from class: com.playon.bridge.common.AsyncTaskExecutor$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5490lambda$executeAsync$0$complayonbridgecommonAsyncTaskExecutor(paramsArr);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: lambda$executeAsync$0$com-playon-bridge-common-AsyncTaskExecutor, reason: not valid java name */
    /* synthetic */ void m5490lambda$executeAsync$0$complayonbridgecommonAsyncTaskExecutor(Object[] objArr) {
        try {
            checkInterrupted();
            this.mHandler.post(new Runnable() { // from class: com.playon.bridge.common.AsyncTaskExecutor$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.onPreExecute();
                }
            });
            checkInterrupted();
            doInBackground(objArr);
            checkInterrupted();
            this.mHandler.post(new Runnable() { // from class: com.playon.bridge.common.AsyncTaskExecutor$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.onPostExecute();
                }
            });
        } catch (InterruptedException unused) {
            this.mHandler.post(new Runnable() { // from class: com.playon.bridge.common.AsyncTaskExecutor$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.onCancelled();
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "executeAsync: " + e.getMessage() + "\n" + e.getMessage());
        }
    }

    private void checkInterrupted() throws InterruptedException {
        if (isInterrupted()) {
            throw new InterruptedException();
        }
    }

    public void cancel(boolean z) {
        setInterrupted(z);
    }

    public boolean isInterrupted() {
        return this.mIsInterrupted;
    }

    public void setInterrupted(boolean z) {
        this.mIsInterrupted = z;
    }
}
