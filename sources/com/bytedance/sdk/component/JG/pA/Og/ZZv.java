package com.bytedance.sdk.component.JG.pA.Og;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.component.JG.pA.ML;
import com.bytedance.sdk.component.JG.pA.omh;
import com.safedk.android.analytics.events.CrashEvent;
import java.util.Comparator;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes8.dex */
public class ZZv {
    private final Comparator<com.bytedance.sdk.component.JG.pA.ZZv.pA> BSW;
    private volatile com.bytedance.sdk.component.JG.pA.Og.KZx.KZx Bzk;
    private volatile Handler SGo;
    private final PriorityBlockingQueue<com.bytedance.sdk.component.JG.pA.ZZv.pA> WV;
    public static final ZZv pA = new ZZv();
    public static final com.bytedance.sdk.component.JG.pA.Og.pA.pA ZZv = new com.bytedance.sdk.component.JG.pA.Og.pA.pA();
    public static final AtomicLong ML = new AtomicLong(0);
    public static final AtomicLong JG = new AtomicLong(0);
    public static final long SD = System.currentTimeMillis();
    public static long omh = 0;
    public volatile boolean Og = false;
    public volatile boolean KZx = false;

    public PriorityBlockingQueue<com.bytedance.sdk.component.JG.pA.ZZv.pA> pA() {
        return this.WV;
    }

    private ZZv() {
        Comparator<com.bytedance.sdk.component.JG.pA.ZZv.pA> comparator = new Comparator<com.bytedance.sdk.component.JG.pA.ZZv.pA>() { // from class: com.bytedance.sdk.component.JG.pA.Og.ZZv.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
            public int compare(com.bytedance.sdk.component.JG.pA.ZZv.pA pAVar, com.bytedance.sdk.component.JG.pA.ZZv.pA pAVar2) {
                return ZZv.this.pA(pAVar, pAVar2);
            }
        };
        this.BSW = comparator;
        this.WV = new PriorityBlockingQueue<>(8, comparator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int pA(com.bytedance.sdk.component.JG.pA.ZZv.pA pAVar, com.bytedance.sdk.component.JG.pA.ZZv.pA pAVar2) {
        long jPA;
        long jOg;
        long jOg2;
        long jPA2;
        if (pAVar == null) {
            return pAVar2 == null ? 0 : -1;
        }
        if (pAVar2 == null) {
            return 1;
        }
        if (pAVar.ML() == pAVar2.ML()) {
            if (pAVar.pA() != null) {
                jPA = pAVar.pA().pA();
                jOg = pAVar.pA().Og();
            } else {
                jPA = 0;
                jOg = 0;
            }
            if (pAVar2.pA() != null) {
                jPA2 = pAVar2.pA().pA();
                jOg2 = pAVar2.pA().Og();
            } else {
                jOg2 = 0;
                jPA2 = 0;
            }
            if (jPA == 0 || jPA2 == 0) {
                return 0;
            }
            long j = jPA - jPA2;
            if (Math.abs(j) > 2147483647L) {
                return 0;
            }
            if (j != 0) {
                return (int) j;
            }
            if (jOg == 0 || jOg2 == 0) {
                return 0;
            }
            return (int) (jOg - jOg2);
        }
        return pAVar.ML() - pAVar2.ML();
    }

    public void Og() {
        ZZv();
        ML();
    }

    public void pA(Handler handler) {
        this.SGo = handler;
    }

    public void KZx() {
        if (this.Bzk == null || !this.Bzk.isAlive()) {
            return;
        }
        synchronized (this) {
            if (this.Bzk != null && this.Bzk.isAlive()) {
                if (this.SGo != null) {
                    this.SGo.removeCallbacksAndMessages(null);
                }
                this.Bzk.pA(false);
                this.Bzk.quitSafely();
                this.Bzk = null;
            }
        }
    }

    public boolean ZZv() {
        try {
            if (this.Bzk != null || com.bytedance.sdk.component.JG.pA.Og.Og()) {
                return false;
            }
            synchronized (this) {
                if (this.Bzk != null) {
                    return false;
                }
                this.Bzk = new com.bytedance.sdk.component.JG.pA.Og.KZx.KZx(this.WV);
                this.Bzk.start();
                return true;
            }
        } catch (Throwable th) {
            th.getMessage();
            return false;
        }
    }

    public void pA(com.bytedance.sdk.component.JG.pA.ZZv.pA pAVar, int i) {
        ZZv();
        ML mlOX = omh.SD().oX();
        com.bytedance.sdk.component.JG.pA.Og.KZx.KZx kZx = this.Bzk;
        if (kZx != null) {
            pA(mlOX, pAVar);
            kZx.pA(pAVar, pAVar.ML() == 4);
        }
    }

    private void pA(final ML ml, com.bytedance.sdk.component.JG.pA.ZZv.pA pAVar) {
        if (ml != null) {
            try {
                if (ml.SD()) {
                    final long jOg = (pAVar == null || pAVar.pA() == null) ? 0L : pAVar.pA().Og();
                    if (jOg == 1) {
                        omh = System.currentTimeMillis();
                    }
                    AtomicLong atomicLongCFQ = ZZv.cFQ();
                    com.bytedance.sdk.component.JG.pA.KZx.Og.pA(atomicLongCFQ, 1);
                    if (atomicLongCFQ.get() == 200) {
                        if (Looper.getMainLooper() == Looper.myLooper()) {
                            Executor executorZZv = ml.ZZv();
                            if (executorZZv == null) {
                                executorZZv = ml.ML();
                            }
                            if (executorZZv != null) {
                                executorZZv.execute(new com.bytedance.sdk.component.JG.pA.ML.ML(CrashEvent.e) { // from class: com.bytedance.sdk.component.JG.pA.Og.ZZv.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        ZZv.this.pA(ml, jOg);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        pA(ml, jOg);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(ML ml, long j) {
        com.bytedance.sdk.component.JG.pA.Og.KZx.KZx kZx = this.Bzk;
        if (ml == null || kZx == null) {
            return;
        }
        com.bytedance.sdk.component.JG.pA.Og.pA.pA pAVar = ZZv;
        kZx.pA(ml.pA(pAVar.Og(j)), true);
        pAVar.HSv();
    }

    public void ML() {
        com.bytedance.sdk.component.JG.pA.KZx.Og.pA(ZZv.qmB(), 1);
        final com.bytedance.sdk.component.JG.pA.Og.KZx.KZx kZx = this.Bzk;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            if (kZx != null) {
                kZx.KZx(2);
                return;
            }
            return;
        }
        ML mlOX = omh.SD().oX();
        if (mlOX != null) {
            Executor executorZZv = mlOX.ZZv();
            if (executorZZv == null) {
                executorZZv = mlOX.ML();
            }
            if (executorZZv != null) {
                executorZZv.execute(new com.bytedance.sdk.component.JG.pA.ML.ML("flush") { // from class: com.bytedance.sdk.component.JG.pA.Og.ZZv.3
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bytedance.sdk.component.JG.pA.Og.KZx.KZx kZx2 = kZx;
                        if (kZx2 != null) {
                            kZx2.KZx(2);
                        }
                    }
                });
            }
        }
    }
}
