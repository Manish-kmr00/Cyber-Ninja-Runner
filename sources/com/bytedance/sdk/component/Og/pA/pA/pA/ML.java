package com.bytedance.sdk.component.Og.pA.pA.pA;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public class ML extends com.bytedance.sdk.component.Og.pA.ZZv {
    private ExecutorService pA;
    private List<com.bytedance.sdk.component.Og.pA.Og> Og = new CopyOnWriteArrayList();
    private List<com.bytedance.sdk.component.Og.pA.Og> KZx = new CopyOnWriteArrayList();
    private AtomicInteger ZZv = new AtomicInteger(64);

    public ML() {
        if (this.pA == null) {
            this.pA = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 20L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactory() { // from class: com.bytedance.sdk.component.Og.pA.pA.pA.ML.1
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable, "systemHttp Dispatcher");
                    thread.setDaemon(false);
                    thread.setPriority(10);
                    return thread;
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.Og.pA.ZZv
    public ExecutorService Og() {
        return this.pA;
    }

    @Override // com.bytedance.sdk.component.Og.pA.ZZv
    public void pA(int i) {
        this.ZZv.set(i);
    }

    @Override // com.bytedance.sdk.component.Og.pA.ZZv
    public List<com.bytedance.sdk.component.Og.pA.Og> KZx() {
        return this.Og;
    }

    @Override // com.bytedance.sdk.component.Og.pA.ZZv
    public List<com.bytedance.sdk.component.Og.pA.Og> ZZv() {
        return this.KZx;
    }

    @Override // com.bytedance.sdk.component.Og.pA.ZZv
    public int pA() {
        return this.ZZv.get();
    }
}
