package com.bytedance.sdk.component.JG.pA.JG;

import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class ZZv {
    private boolean BSW;
    private final String JG;
    private final boolean KZx;
    private final int ML;
    private final String Og;
    private String SD;
    private String omh;
    private final String pA;
    private int ZZv = -1;
    private int Bzk = 0;
    private String SGo = null;

    ZZv(String str, String str2, boolean z, int i, String str3) {
        this.pA = str;
        this.Og = str2;
        this.KZx = z;
        this.ML = i;
        this.JG = str3;
    }

    public String pA() {
        return this.pA;
    }

    public String Og() {
        return this.Og;
    }

    public boolean KZx() {
        return this.KZx;
    }

    public int ZZv() {
        return this.ZZv;
    }

    public void pA(int i) {
        this.ZZv = i;
    }

    public int ML() {
        return this.ML;
    }

    public String JG() {
        return this.JG;
    }

    public void pA(String str) {
        this.SD = str;
    }

    public String SD() {
        return this.SD;
    }

    public void Og(int i) {
        this.Bzk = i;
        if (i == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.SD)) {
            this.SD = String.valueOf(this.Bzk);
        } else {
            this.SD += StringUtils.COMMA + this.Bzk;
        }
    }

    public int omh() {
        return this.Bzk;
    }

    public void Og(String str) {
        this.omh = str;
    }

    public String Bzk() {
        return this.omh;
    }

    public void KZx(String str) {
        this.SGo = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(this.omh)) {
            this.omh = String.valueOf(this.SGo);
        } else {
            this.omh += StringUtils.COMMA + this.SGo;
        }
    }

    public void pA(boolean z) {
        this.BSW = z;
    }

    public boolean SGo() {
        return this.BSW;
    }

    public Runnable pA(String str, Map<String, String> map) {
        return pA.pA().pA(this, str, map);
    }

    public boolean BSW() {
        return this.ZZv == -1;
    }
}
