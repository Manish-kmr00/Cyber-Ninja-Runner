package com.bytedance.sdk.openadsdk.yFO;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes10.dex */
public class Og {
    private pA ML;
    private omh Og;
    private int ZZv;
    private ScheduledExecutorService pA = null;
    private long KZx = 0;

    public interface pA {
    }

    public Og(omh omhVar, int i) {
        this.Og = omhVar;
        this.ZZv = i;
    }

    public void pA(long j) {
        this.KZx = j;
    }

    public void pA(int i) {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1);
        this.pA = scheduledExecutorServiceNewScheduledThreadPool;
        scheduledExecutorServiceNewScheduledThreadPool.scheduleAtFixedRate(new Runnable() { // from class: com.bytedance.sdk.openadsdk.yFO.Og.1
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                long unused = Og.this.KZx;
                if (System.currentTimeMillis() - Og.this.KZx > Og.this.ZZv) {
                    Og.this.pA.shutdown();
                    if (Og.this.Og != null) {
                        Og.this.Og.Og(0, "Automatic detection of stuck");
                    }
                    if (Og.this.ML != null) {
                        pA unused2 = Og.this.ML;
                    }
                }
            }
        }, 0L, i, TimeUnit.MILLISECONDS);
    }

    public void pA() {
        ScheduledExecutorService scheduledExecutorService = this.pA;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
        }
    }

    public boolean Og() {
        ScheduledExecutorService scheduledExecutorService = this.pA;
        if (scheduledExecutorService != null) {
            return scheduledExecutorService.isShutdown();
        }
        return true;
    }
}
