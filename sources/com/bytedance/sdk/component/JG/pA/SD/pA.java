package com.bytedance.sdk.component.JG.pA.SD;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: classes7.dex */
public class pA {
    private static int KZx = 3000;
    private static volatile Handler Og;
    private static volatile HandlerThread pA;

    static {
        HandlerThread handlerThread = new HandlerThread("csj_ad_log", 10);
        pA = handlerThread;
        handlerThread.start();
    }

    public static Handler pA() {
        if (pA == null || !pA.isAlive()) {
            synchronized (pA.class) {
                if (pA == null || !pA.isAlive()) {
                    HandlerThread handlerThread = new HandlerThread("csj_init_handle", -1);
                    pA = handlerThread;
                    handlerThread.start();
                    Og = new Handler(pA.getLooper());
                }
            }
        } else if (Og == null) {
            synchronized (pA.class) {
                if (Og == null) {
                    Og = new Handler(pA.getLooper());
                }
            }
        }
        return Og;
    }

    public static int Og() {
        if (KZx <= 0) {
            KZx = 3000;
        }
        return KZx;
    }
}
