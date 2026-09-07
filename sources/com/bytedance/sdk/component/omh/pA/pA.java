package com.bytedance.sdk.component.omh.pA;

import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.sdk.component.utils.TV;

/* JADX INFO: loaded from: classes6.dex */
public class pA {
    private Handler Og;
    private final ZZv<Og> pA;

    private pA() {
        this.pA = ZZv.pA(2);
    }

    public static pA pA() {
        return C0207pA.pA;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.omh.pA.pA$pA, reason: collision with other inner class name */
    private static class C0207pA {
        private static final pA pA = new pA();
    }

    public Handler Og() {
        if (this.Og == null) {
            synchronized (pA.class) {
                if (this.Og == null) {
                    this.Og = pA("csj_io_handler");
                }
            }
        }
        return this.Og;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(final Handler handler, final Handler handler2) {
        if (handler.getLooper().getQueue().isIdle()) {
            handler.removeCallbacksAndMessages(null);
            handler.getLooper().quit();
        } else {
            handler2.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.omh.pA.pA.1
                @Override // java.lang.Runnable
                public void run() {
                    pA.this.pA(handler, handler2);
                }
            }, 1000L);
        }
    }

    public TV pA(TV.pA pAVar, final String str) {
        Og og = (Og) this.pA.pA();
        if (og != null) {
            og.pA(pAVar);
            og.post(new Runnable() { // from class: com.bytedance.sdk.component.omh.pA.pA.2
                @Override // java.lang.Runnable
                public void run() {
                    Thread.currentThread().setName(str);
                }
            });
            return og;
        }
        return Og(pAVar, str);
    }

    public TV pA(String str) {
        return pA((TV.pA) null, str);
    }

    private Og Og(TV.pA pAVar, String str) {
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        return new Og(handlerThread, pAVar);
    }

    public boolean pA(TV tv) {
        if (!(tv instanceof Og)) {
            return false;
        }
        Og og = (Og) tv;
        if (this.pA.pA(og)) {
            return true;
        }
        og.Og();
        return true;
    }
}
