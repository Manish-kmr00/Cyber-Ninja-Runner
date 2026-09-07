package com.amazon.aps.shared.util;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes7.dex */
public class ApsAsyncUtil {
    private static ApsAsyncUtil INSTANCE = null;
    private static final String TAG = "ApsAsyncUtil";
    private final ExecutorService executorService = Executors.newFixedThreadPool(1);
    private boolean shutdownInProgress = false;

    public interface ApsExecutionListener<T> {
        void onExecutionCompleted(ApsResult apsResult, T t);
    }

    public interface ApsReturnRunnable<T> {
        T run();
    }

    static /* synthetic */ Object lambda$runOnUiThreadAndAsyncCallback$0(Object obj) {
        return obj;
    }

    private ApsAsyncUtil() {
        Runtime.getRuntime().addShutdownHook(new Thread() { // from class: com.amazon.aps.shared.util.ApsAsyncUtil.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    ApsAsyncUtil.this.shutdownInProgress = true;
                    Log.d(ApsAsyncUtil.TAG, "App is shutting down, terminating the thread executor");
                    ApsAsyncUtil.this.executorService.shutdown();
                } catch (RuntimeException e) {
                    Log.e(ApsAsyncUtil.TAG, "Error in stopping the executor", e);
                }
            }
        });
    }

    public static ApsAsyncUtil getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ApsAsyncUtil();
        }
        return INSTANCE;
    }

    public <T> void runOnUiThreadAndAsyncCallback(final ApsReturnRunnable<T> apsReturnRunnable, final ApsExecutionListener<T> apsExecutionListener) {
        APSSharedUtil.checkNullAndThrowException(apsReturnRunnable);
        try {
            if (this.shutdownInProgress) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.amazon.aps.shared.util.ApsAsyncUtil$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    ApsAsyncUtil.lambda$runOnUiThreadAndAsyncCallback$1(apsReturnRunnable, apsExecutionListener);
                }
            });
        } catch (RuntimeException e) {
            Log.e(TAG, "Error running the thread", e);
        }
    }

    static /* synthetic */ void lambda$runOnUiThreadAndAsyncCallback$1(ApsReturnRunnable apsReturnRunnable, ApsExecutionListener apsExecutionListener) {
        final Object objRun;
        try {
            objRun = apsReturnRunnable.run();
        } catch (RuntimeException unused) {
            objRun = null;
        }
        if (apsExecutionListener != null) {
            getInstance().runAsyncAndCallback(new ApsReturnRunnable() { // from class: com.amazon.aps.shared.util.ApsAsyncUtil$$ExternalSyntheticLambda1
                @Override // com.amazon.aps.shared.util.ApsAsyncUtil.ApsReturnRunnable
                public final Object run() {
                    return ApsAsyncUtil.lambda$runOnUiThreadAndAsyncCallback$0(objRun);
                }
            }, apsExecutionListener);
        }
    }

    public synchronized <T> void runAsyncAndCallbackOnUiThread(final ApsReturnRunnable<T> apsReturnRunnable, final ApsExecutionListener<T> apsExecutionListener) {
        APSSharedUtil.checkNullAndThrowException(apsReturnRunnable, apsExecutionListener);
        try {
            if (!this.shutdownInProgress) {
                this.executorService.execute(new Runnable() { // from class: com.amazon.aps.shared.util.ApsAsyncUtil$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        ApsAsyncUtil.lambda$runAsyncAndCallbackOnUiThread$3(apsReturnRunnable, apsExecutionListener);
                    }
                });
            }
        } catch (RuntimeException e) {
            Log.e(TAG, "Error running the thread", e);
        }
    }

    static /* synthetic */ void lambda$runAsyncAndCallbackOnUiThread$3(ApsReturnRunnable apsReturnRunnable, final ApsExecutionListener apsExecutionListener) {
        final ApsResult apsResult = ApsResult.FAILURE;
        final Object objRun = null;
        try {
            try {
                objRun = apsReturnRunnable.run();
                final ApsResult apsResult2 = ApsResult.SUCCESS;
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.amazon.aps.shared.util.ApsAsyncUtil$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        ApsAsyncUtil.lambda$runAsyncAndCallbackOnUiThread$2(apsExecutionListener, apsResult2, objRun);
                    }
                });
            } catch (Exception e) {
                Log.e(TAG, "Error running the thread", e);
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.amazon.aps.shared.util.ApsAsyncUtil$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        ApsAsyncUtil.lambda$runAsyncAndCallbackOnUiThread$2(apsExecutionListener, apsResult, objRun);
                    }
                });
            }
        } catch (Throwable th) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.amazon.aps.shared.util.ApsAsyncUtil$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    ApsAsyncUtil.lambda$runAsyncAndCallbackOnUiThread$2(apsExecutionListener, apsResult, objRun);
                }
            });
            throw th;
        }
    }

    static /* synthetic */ void lambda$runAsyncAndCallbackOnUiThread$2(ApsExecutionListener apsExecutionListener, ApsResult apsResult, Object obj) {
        if (apsExecutionListener != null) {
            apsExecutionListener.onExecutionCompleted(apsResult, obj);
        }
    }

    public synchronized <T> void runAsyncAndCallback(final ApsReturnRunnable<T> apsReturnRunnable, final ApsExecutionListener<T> apsExecutionListener) {
        APSSharedUtil.checkNullAndThrowException(apsReturnRunnable);
        try {
            if (!this.shutdownInProgress) {
                this.executorService.execute(new Runnable() { // from class: com.amazon.aps.shared.util.ApsAsyncUtil$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ApsAsyncUtil.lambda$runAsyncAndCallback$4(apsReturnRunnable, apsExecutionListener);
                    }
                });
            }
        } catch (RuntimeException e) {
            Log.e(TAG, "Error running the thread", e);
        }
    }

    static /* synthetic */ void lambda$runAsyncAndCallback$4(ApsReturnRunnable apsReturnRunnable, ApsExecutionListener apsExecutionListener) {
        ApsResult apsResult = ApsResult.FAILURE;
        Object objRun = null;
        try {
            try {
                objRun = apsReturnRunnable.run();
                ApsResult apsResult2 = ApsResult.SUCCESS;
                if (apsExecutionListener != null) {
                    apsExecutionListener.onExecutionCompleted(apsResult2, objRun);
                }
            } catch (Exception e) {
                Log.e(TAG, "Error running the thread", e);
                if (apsExecutionListener != null) {
                    apsExecutionListener.onExecutionCompleted(apsResult, objRun);
                }
            }
        } catch (Throwable th) {
            if (apsExecutionListener != null) {
                apsExecutionListener.onExecutionCompleted(apsResult, objRun);
            }
            throw th;
        }
    }
}
