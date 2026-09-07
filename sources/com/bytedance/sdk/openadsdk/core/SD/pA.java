package com.bytedance.sdk.openadsdk.core.SD;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.settings.JG;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes5.dex */
public class pA {
    private static volatile long KZx;
    private static volatile boolean Og;
    private static volatile pA pA;
    private Handler ML;
    private final Queue<C0232pA> ZZv = new LinkedList();
    private final JG JG = aBv.ZZv();

    private pA() {
    }

    public static pA pA() {
        if (pA == null) {
            synchronized (pA.class) {
                if (pA == null) {
                    pA = new pA();
                }
            }
        }
        return pA;
    }

    private synchronized boolean Og(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iWQf = this.JG.WQf();
        long jBF = this.JG.BF();
        if (this.ZZv.size() > 0 && this.ZZv.size() >= iWQf) {
            long jAbs = Math.abs(jCurrentTimeMillis - this.ZZv.peek().pA);
            if (jAbs <= jBF) {
                Og(jBF - jAbs);
                return true;
            }
            this.ZZv.poll();
            this.ZZv.offer(new C0232pA(jCurrentTimeMillis, str));
        } else {
            this.ZZv.offer(new C0232pA(jCurrentTimeMillis, str));
        }
        return false;
    }

    public synchronized boolean pA(String str) {
        if (Og(str)) {
            pA(true);
            pA(KZx);
        } else {
            pA(false);
        }
        return Og;
    }

    private synchronized void pA(long j) {
        if (this.ML == null) {
            this.ML = new Handler(Looper.getMainLooper());
        }
        this.ML.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.SD.pA.1
            @Override // java.lang.Runnable
            public void run() {
                pA.this.pA(false);
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void pA(boolean z) {
        Og = z;
    }

    public synchronized boolean Og() {
        return Og;
    }

    private synchronized void Og(long j) {
        KZx = j;
    }

    public synchronized String KZx() {
        String str;
        HashMap map = new HashMap();
        for (C0232pA c0232pA : this.ZZv) {
            if (map.containsKey(c0232pA.Og)) {
                map.put(c0232pA.Og, Integer.valueOf(((Integer) map.get(c0232pA.Og)).intValue() + 1));
            } else {
                map.put(c0232pA.Og, 1);
            }
        }
        str = "";
        int i = Integer.MIN_VALUE;
        for (String str2 : map.keySet()) {
            int iIntValue = ((Integer) map.get(str2)).intValue();
            if (i < iIntValue) {
                str = str2;
                i = iIntValue;
            }
        }
        return str;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.SD.pA$pA, reason: collision with other inner class name */
    private static class C0232pA {
        private final String Og;
        private final long pA;

        private C0232pA(long j, String str) {
            this.pA = j;
            this.Og = str;
        }
    }
}
