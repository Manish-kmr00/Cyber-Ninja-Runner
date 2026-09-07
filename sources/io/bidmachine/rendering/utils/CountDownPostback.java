package io.bidmachine.rendering.utils;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes13.dex */
public class CountDownPostback implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Runnable f12427a;
    private final AtomicInteger b;

    public CountDownPostback(int count, Runnable runnable) {
        this.f12427a = runnable;
        this.b = new AtomicInteger(count);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.b.decrementAndGet() > 0) {
            return;
        }
        this.f12427a.run();
    }
}
