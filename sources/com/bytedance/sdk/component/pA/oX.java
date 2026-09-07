package com.bytedance.sdk.component.pA;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes12.dex */
public class oX {
    public final String JG;
    public final String KZx;
    public final String ML;
    public final String Og;
    public final String SD;
    public final String ZZv;
    public final String omh;
    public final int pA;

    public static pA pA() {
        return new pA();
    }

    public static oX pA(String str, int i) {
        return new oX(str, i);
    }

    private oX(String str, int i) {
        this.Og = null;
        this.KZx = null;
        this.ZZv = null;
        this.ML = null;
        this.JG = str;
        this.SD = null;
        this.pA = i;
        this.omh = null;
    }

    private oX(pA pAVar) {
        this.Og = pAVar.pA;
        this.KZx = pAVar.Og;
        this.ZZv = pAVar.KZx;
        this.ML = pAVar.ZZv;
        this.JG = pAVar.ML;
        this.SD = pAVar.JG;
        this.pA = 1;
        this.omh = pAVar.SD;
    }

    public static boolean pA(oX oXVar) {
        return oXVar == null || oXVar.pA != 1 || TextUtils.isEmpty(oXVar.ZZv) || TextUtils.isEmpty(oXVar.ML);
    }

    public String toString() {
        return "methodName: " + this.ZZv + ", params: " + this.ML + ", callbackId: " + this.JG + ", type: " + this.KZx + ", version: " + this.Og + ", ";
    }

    public static final class pA {
        private String JG;
        private String KZx;
        private String ML;
        private String Og;
        private String SD;
        private String ZZv;
        private String pA;

        private pA() {
        }

        public pA pA(String str) {
            this.pA = str;
            return this;
        }

        public pA Og(String str) {
            this.Og = str;
            return this;
        }

        public pA KZx(String str) {
            this.KZx = str;
            return this;
        }

        public pA ZZv(String str) {
            this.ZZv = str;
            return this;
        }

        public pA ML(String str) {
            this.ML = str;
            return this;
        }

        public pA JG(String str) {
            this.JG = str;
            return this;
        }

        public pA SD(String str) {
            this.SD = str;
            return this;
        }

        public oX pA() {
            return new oX(this);
        }
    }
}
