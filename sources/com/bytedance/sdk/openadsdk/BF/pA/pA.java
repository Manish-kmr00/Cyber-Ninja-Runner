package com.bytedance.sdk.openadsdk.BF.pA;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: classes2.dex */
public class pA {
    private static HandlerThread Og;
    private static Handler pA;

    public static Handler pA() {
        try {
            HandlerThread handlerThread = Og;
            if (handlerThread == null || !handlerThread.isAlive()) {
                synchronized (pA.class) {
                    HandlerThread handlerThread2 = Og;
                    if (handlerThread2 == null || !handlerThread2.isAlive()) {
                        HandlerThread handlerThread3 = new HandlerThread("csj_ev");
                        Og = handlerThread3;
                        handlerThread3.start();
                        pA = new Handler(Og.getLooper());
                    }
                }
            } else if (pA == null) {
                synchronized (pA.class) {
                    if (pA == null) {
                        pA = new Handler(Og.getLooper());
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return pA;
    }
}
