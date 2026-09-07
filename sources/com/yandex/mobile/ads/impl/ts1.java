package com.yandex.mobile.ads.impl;

import java.lang.Exception;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes14.dex */
public abstract class ts1<R, E extends Exception> implements RunnableFuture<R> {
    private final gr b = new gr();
    private final gr c = new gr();
    private final Object d = new Object();
    private Exception e;
    private Thread f;
    private boolean g;

    protected abstract void b();

    protected abstract void c() throws Exception;

    protected ts1() {
    }

    public final void a() {
        this.c.b();
    }

    @Override // java.util.concurrent.Future
    public final R get() throws ExecutionException, InterruptedException {
        this.c.a();
        if (!this.g) {
            if (this.e == null) {
                return null;
            }
            throw new ExecutionException(this.e);
        }
        throw new CancellationException();
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        synchronized (this.d) {
            if (!this.g && !this.c.d()) {
                this.g = true;
                b();
                Thread thread = this.f;
                if (thread == null) {
                    this.b.e();
                    this.c.e();
                } else if (z) {
                    thread.interrupt();
                }
                return true;
            }
            return false;
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.c.d();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.g;
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        synchronized (this.d) {
            if (this.g) {
                return;
            }
            this.f = Thread.currentThread();
            this.b.e();
            try {
                try {
                    c();
                    synchronized (this.d) {
                        this.c.e();
                        this.f = null;
                        Thread.interrupted();
                    }
                } catch (Exception e) {
                    this.e = e;
                    synchronized (this.d) {
                        this.c.e();
                        this.f = null;
                        Thread.interrupted();
                    }
                }
            } catch (Throwable th) {
                synchronized (this.d) {
                    this.c.e();
                    this.f = null;
                    Thread.interrupted();
                    throw th;
                }
            }
        }
    }

    @Override // java.util.concurrent.Future
    public final R get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.c.a(TimeUnit.MILLISECONDS.convert(j, timeUnit))) {
            if (!this.g) {
                if (this.e == null) {
                    return null;
                }
                throw new ExecutionException(this.e);
            }
            throw new CancellationException();
        }
        throw new TimeoutException();
    }
}
