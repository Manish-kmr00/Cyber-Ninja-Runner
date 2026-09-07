package com.bytedance.sdk.openadsdk.Sn.pA;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.gbA;

/* JADX INFO: loaded from: classes10.dex */
public class Og {
    private String JG;
    private String KZx;
    private boolean ML;
    private yFO Og;
    private int SD;
    private int ZZv;
    private String pA;
    private int omh = 0;
    private int Bzk = 0;

    public String pA() {
        return this.pA;
    }

    public void pA(String str) {
        this.pA = str;
    }

    public yFO Og() {
        return this.Og;
    }

    public void pA(yFO yfo) {
        this.Og = yfo;
    }

    public String KZx() {
        yFO yfo;
        if (TextUtils.isEmpty(this.KZx) && (yfo = this.Og) != null) {
            this.KZx = gbA.pA(yfo);
        }
        return this.KZx;
    }

    public void Og(String str) {
        this.KZx = str;
    }

    public int ZZv() {
        return this.ZZv;
    }

    public void pA(int i) {
        this.ZZv = i;
    }

    public boolean ML() {
        return this.ML;
    }

    public void pA(boolean z) {
        this.ML = z;
    }

    public String JG() {
        return this.JG;
    }

    public void KZx(String str) {
        this.JG = str;
    }

    public int SD() {
        return this.SD;
    }

    public void Og(int i) {
        this.SD = i;
    }

    public int omh() {
        return this.omh;
    }

    public void KZx(int i) {
        this.omh = i;
    }

    public int Bzk() {
        return this.Bzk;
    }

    public void ZZv(int i) {
        this.Bzk = i;
    }
}
