package com.bytedance.sdk.openadsdk.Sn.pA;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.Og.pA.Sn;

/* JADX INFO: loaded from: classes11.dex */
public class ML {
    public static int pA = -10;
    private String Bzk;
    private int JG;
    private String KZx;
    private long ML;
    private final int Og;
    private int SD;
    private int SGo;
    private long ZZv;
    private boolean omh;

    public static void KZx() {
    }

    public ML(int i) {
        this.Og = i;
    }

    public ML pA(String str) {
        this.KZx = str;
        return this;
    }

    public ML Og(String str) {
        byte[] bytes;
        if (!TextUtils.isEmpty(str) && (bytes = str.getBytes()) != null) {
            this.JG = bytes.length;
        }
        return this;
    }

    public ML pA(Sn sn) {
        if (sn != null) {
            if (sn.JG == Sn.pA.STRING_TYPE && !TextUtils.isEmpty(sn.pA())) {
                this.JG = sn.pA().getBytes().length;
            }
            if (sn.JG == Sn.pA.BYTE_ARRAY_TYPE && sn.ML != null) {
                this.JG = sn.ML.length;
            }
        }
        return this;
    }

    public void pA() {
        this.ZZv = SystemClock.elapsedRealtime();
    }

    public ML KZx(String str) {
        byte[] bytes;
        if (!TextUtils.isEmpty(str) && (bytes = str.getBytes()) != null) {
            this.SD = bytes.length;
        }
        return this;
    }

    public ML pA(int i) {
        this.SGo = i;
        return this;
    }

    public void Og() {
        this.ML = SystemClock.elapsedRealtime() - this.ZZv;
    }

    public ML ZZv(String str) {
        this.Bzk = str;
        return this;
    }

    public ML pA(boolean z) {
        this.omh = z;
        return this;
    }
}
