package com.smaato.sdk.core.util;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.util.fi.NullableSupplier;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes9.dex */
public final class Threads {
    private static Executor bgExecutor;
    private static ScheduledExecutorService delayExecutor;
    static volatile Handler uiHandler;

    public static void ensureMainThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("This method should be called only on MainThread");
        }
    }

    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static void ensureNotMainThread() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("This method should NOT be called on MainThread");
        }
    }

    public static boolean isHandlerThread(Handler handler) {
        return handler.getLooper().getThread() == Thread.currentThread();
    }

    public static void ensureInvokedOnHandlerThread(Handler handler, Runnable runnable) {
        if (isHandlerThread(handler)) {
            runnable.run();
        } else {
            handler.post(runnable);
        }
    }

    public static void ensureHandlerThread(Handler handler) {
        if (!isHandlerThread(handler)) {
            throw new IllegalStateException("This method should be called only from a thread bound to the handler");
        }
    }

    public static Handler newUiHandler() {
        return new Handler(Looper.getMainLooper());
    }

    public static boolean runOnUi(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
            return true;
        }
        return getUiHandler().post(runnable);
    }

    public static boolean runOnNextUiFrame(Runnable runnable) {
        return getUiHandler().post(runnable);
    }

    public static boolean runOnHandlerThreadBlocking(Handler handler, final Runnable runnable) {
        if (isHandlerThread(handler)) {
            runnable.run();
            return true;
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        boolean zPost = handler.post(new Runnable() { // from class: com.smaato.sdk.core.util.Threads$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                Threads.lambda$runOnHandlerThreadBlocking$0(runnable, atomicBoolean);
            }
        });
        if (zPost) {
            while (!atomicBoolean.get()) {
            }
        }
        return zPost;
    }

    static /* synthetic */ void lambda$runOnHandlerThreadBlocking$0(Runnable runnable, AtomicBoolean atomicBoolean) {
        runnable.run();
        atomicBoolean.set(true);
    }

    public static <T> T runOnHandlerThreadBlocking(Handler handler, final com.smaato.sdk.core.util.fi.Supplier<T> supplier) {
        if (isHandlerThread(handler)) {
            return supplier.get();
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final AtomicReference atomicReference = new AtomicReference();
        if (handler.post(new Runnable() { // from class: com.smaato.sdk.core.util.Threads$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                Threads.lambda$runOnHandlerThreadBlocking$1(atomicReference, supplier, atomicBoolean);
            }
        })) {
            while (!atomicBoolean.get()) {
            }
        }
        return (T) atomicReference.get();
    }

    static /* synthetic */ void lambda$runOnHandlerThreadBlocking$1(AtomicReference atomicReference, com.smaato.sdk.core.util.fi.Supplier supplier, AtomicBoolean atomicBoolean) {
        atomicReference.set(supplier.get());
        atomicBoolean.set(true);
    }

    public static boolean runOnUiBlocking(final Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
            return true;
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        boolean zPost = getUiHandler().post(new Runnable() { // from class: com.smaato.sdk.core.util.Threads$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                Threads.lambda$runOnUiBlocking$2(runnable, atomicBoolean);
            }
        });
        if (zPost) {
            while (!atomicBoolean.get()) {
            }
        }
        return zPost;
    }

    static /* synthetic */ void lambda$runOnUiBlocking$2(Runnable runnable, AtomicBoolean atomicBoolean) {
        runnable.run();
        atomicBoolean.set(true);
    }

    public static <T> T runOnUiBlocking(final NullableSupplier<T> nullableSupplier) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return nullableSupplier.get();
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final AtomicReference atomicReference = new AtomicReference();
        if (getUiHandler().post(new Runnable() { // from class: com.smaato.sdk.core.util.Threads$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Threads.lambda$runOnUiBlocking$3(atomicReference, nullableSupplier, countDownLatch);
            }
        })) {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                Log.e(LogDomain.CORE.name(), "Internal error while executing on MainThread: " + e.getMessage());
                return null;
            }
        }
        return (T) atomicReference.get();
    }

    static /* synthetic */ void lambda$runOnUiBlocking$3(AtomicReference atomicReference, NullableSupplier nullableSupplier, CountDownLatch countDownLatch) {
        atomicReference.set(nullableSupplier.get());
        countDownLatch.countDown();
    }

    public static void scheduleDelayed(Long l, Runnable runnable) {
        getDelayExecutor().schedule(runnable, l.longValue(), TimeUnit.MILLISECONDS);
    }

    public static void runOnBackgroundThread(Runnable runnable) {
        getBackgroundExecutor().execute(runnable);
    }

    private static Handler getUiHandler() {
        if (uiHandler == null) {
            synchronized (Threads.class) {
                if (uiHandler == null) {
                    uiHandler = newUiHandler();
                }
            }
        }
        return uiHandler;
    }

    private static synchronized ScheduledExecutorService getDelayExecutor() {
        if (delayExecutor == null) {
            delayExecutor = Executors.newSingleThreadScheduledExecutor();
        }
        return delayExecutor;
    }

    private static synchronized Executor getBackgroundExecutor() {
        if (bgExecutor == null) {
            bgExecutor = Executors.newCachedThreadPool();
        }
        return bgExecutor;
    }
}
