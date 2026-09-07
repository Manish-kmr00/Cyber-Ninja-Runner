package com.bytedance.sdk.component.SD;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.component.Og.pA.BSW;
import com.bytedance.sdk.component.Og.pA.omh;
import com.bytedance.sdk.component.SD.KZx.SD;
import com.bytedance.sdk.component.SD.Og.ZZv;
import com.bytedance.sdk.component.SD.ZZv.KZx;
import com.bytedance.sdk.component.utils.aBv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes8.dex */
public class pA {
    private int KZx;
    private SD Og;
    private BSW pA;

    private pA(C0196pA c0196pA) {
        BSW.pA pAVarOg = new BSW.pA().pA(c0196pA.pA, TimeUnit.MILLISECONDS).KZx(c0196pA.KZx, TimeUnit.MILLISECONDS).Og(c0196pA.Og, TimeUnit.MILLISECONDS);
        if (c0196pA.ZZv) {
            SD sd = new SD();
            this.Og = sd;
            pAVarOg.pA(sd);
        }
        if (c0196pA.ML != null && c0196pA.ML.size() > 0) {
            Iterator<omh> it = c0196pA.ML.iterator();
            while (it.hasNext()) {
                pAVarOg.pA(it.next());
            }
        }
        if (c0196pA.SD != null) {
            Bundle unused = c0196pA.SD;
        }
        Set unused2 = c0196pA.JG;
        this.pA = pAVarOg.pA();
    }

    public void pA(Context context, boolean z, com.bytedance.sdk.component.SD.KZx.Og og) {
        if (context == null) {
            throw new IllegalArgumentException("tryInitAdTTNet context is null");
        }
        if (og == null) {
            throw new IllegalArgumentException("tryInitAdTTNet ITTAdNetDepend is null");
        }
        int iPA = og.pA();
        this.KZx = iPA;
        SD sd = this.Og;
        if (sd != null) {
            sd.pA(iPA);
        }
        com.bytedance.sdk.component.SD.KZx.omh.pA().pA(this.KZx).pA(z);
        com.bytedance.sdk.component.SD.KZx.omh.pA().pA(this.KZx).pA(og);
        com.bytedance.sdk.component.SD.KZx.omh.pA().pA(this.KZx).pA(context, aBv.pA(context));
    }

    public void pA(Context context, boolean z) {
        com.bytedance.sdk.component.SD.KZx.pA.Og(true);
        if (pA(context) || (!aBv.pA(context) && z)) {
            com.bytedance.sdk.component.SD.KZx.omh.pA().pA(this.KZx, context).ZZv();
            com.bytedance.sdk.component.SD.KZx.omh.pA().pA(this.KZx, context).pA();
        }
        if (aBv.pA(context)) {
            com.bytedance.sdk.component.SD.KZx.omh.pA().pA(this.KZx, context).ZZv();
            com.bytedance.sdk.component.SD.KZx.omh.pA().pA(this.KZx, context).pA();
        }
    }

    public static void pA() {
        KZx.pA(KZx.pA.DEBUG);
    }

    public ZZv Og() {
        return new ZZv(this.pA);
    }

    public com.bytedance.sdk.component.SD.Og.Og KZx() {
        return new com.bytedance.sdk.component.SD.Og.Og(this.pA);
    }

    public com.bytedance.sdk.component.SD.Og.pA ZZv() {
        return new com.bytedance.sdk.component.SD.Og.pA(this.pA);
    }

    private static boolean pA(Context context) {
        String strOg = aBv.Og(context);
        if (strOg != null) {
            return strOg.endsWith(":push") || strOg.endsWith(":pushservice");
        }
        return false;
    }

    public BSW ML() {
        return this.pA;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.SD.pA$pA, reason: collision with other inner class name */
    public static final class C0196pA {
        private Set<String> JG;
        private Bundle SD;
        boolean ZZv = true;
        final List<omh> ML = new ArrayList();
        int pA = 10000;
        int Og = 10000;
        int KZx = 10000;

        public C0196pA pA(long j, TimeUnit timeUnit) {
            this.pA = pA("timeout", j, timeUnit);
            return this;
        }

        public C0196pA Og(long j, TimeUnit timeUnit) {
            this.Og = pA("timeout", j, timeUnit);
            return this;
        }

        public C0196pA KZx(long j, TimeUnit timeUnit) {
            this.KZx = pA("timeout", j, timeUnit);
            return this;
        }

        public C0196pA pA(boolean z) {
            this.ZZv = z;
            return this;
        }

        private static int pA(String str, long j, TimeUnit timeUnit) {
            if (j < 0) {
                throw new IllegalArgumentException(str + " < 0");
            }
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            long millis = timeUnit.toMillis(j);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException(str + " too large.");
            }
            if (millis != 0 || j <= 0) {
                return (int) millis;
            }
            throw new IllegalArgumentException(str + " too small.");
        }

        public pA pA() {
            return new pA(this);
        }
    }
}
