package com.bytedance.sdk.openadsdk.core.model;

import android.util.SparseArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Sn implements com.bytedance.sdk.component.adexpress.KZx {
    public final String BSW;
    public final int Bzk;
    public final boolean DX;
    public final long JG;
    public final float KZx;
    public final long ML;
    public final float Og;
    public final int SD;
    public final int SGo;
    public SparseArray<com.bytedance.sdk.openadsdk.core.Og.KZx.pA> Sn;
    public int WV;
    public JSONObject Wx;
    public boolean XT;
    public final float ZZv;
    public JSONObject aBv;
    public int oX;
    public final int omh;
    public final float pA;

    private Sn(pA pAVar) {
        this.XT = false;
        this.pA = pAVar.SD;
        this.Og = pAVar.JG;
        this.KZx = pAVar.ML;
        this.ZZv = pAVar.ZZv;
        this.ML = pAVar.KZx;
        this.JG = pAVar.Og;
        this.SD = pAVar.omh;
        this.omh = pAVar.Bzk;
        this.Bzk = pAVar.SGo;
        this.SGo = pAVar.BSW;
        this.BSW = pAVar.WV;
        this.Sn = pAVar.pA;
        this.DX = pAVar.XT;
        this.WV = pAVar.Wx;
        this.Wx = pAVar.Sn;
        this.oX = pAVar.DX;
        this.aBv = pAVar.oX;
        this.XT = pAVar.aBv;
    }

    public static class pA {
        private int BSW;
        private int Bzk;
        private int DX;
        private float JG;
        private long KZx;
        private float ML;
        private long Og;
        private float SD;
        private int SGo;
        private JSONObject Sn;
        private String WV;
        private int Wx;
        private boolean XT;
        private float ZZv;
        private JSONObject oX;
        private int omh;
        private boolean aBv = false;
        protected SparseArray<com.bytedance.sdk.openadsdk.core.Og.KZx.pA> pA = new SparseArray<>();

        public pA pA(int i) {
            this.DX = i;
            return this;
        }

        public pA Og(int i) {
            this.Wx = i;
            return this;
        }

        public pA pA(JSONObject jSONObject) {
            this.Sn = jSONObject;
            return this;
        }

        public pA pA(boolean z) {
            this.XT = z;
            return this;
        }

        public pA pA(long j) {
            this.Og = j;
            return this;
        }

        public pA Og(long j) {
            this.KZx = j;
            return this;
        }

        public pA pA(float f) {
            this.ZZv = f;
            return this;
        }

        public pA Og(float f) {
            this.ML = f;
            return this;
        }

        public pA KZx(float f) {
            this.JG = f;
            return this;
        }

        public pA ZZv(float f) {
            this.SD = f;
            return this;
        }

        public pA KZx(int i) {
            this.omh = i;
            return this;
        }

        public pA ZZv(int i) {
            this.Bzk = i;
            return this;
        }

        public pA ML(int i) {
            this.SGo = i;
            return this;
        }

        public pA JG(int i) {
            this.BSW = i;
            return this;
        }

        public pA pA(String str) {
            this.WV = str;
            return this;
        }

        public pA pA(SparseArray<com.bytedance.sdk.openadsdk.core.Og.KZx.pA> sparseArray) {
            this.pA = sparseArray;
            return this;
        }

        public pA Og(JSONObject jSONObject) {
            this.oX = jSONObject;
            return this;
        }

        public pA Og(boolean z) {
            this.aBv = z;
            return this;
        }

        public Sn pA() {
            return new Sn(this);
        }
    }
}
