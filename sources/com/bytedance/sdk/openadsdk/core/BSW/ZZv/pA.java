package com.bytedance.sdk.openadsdk.core.BSW.ZZv;

import com.bytedance.adsdk.ugeno.core.DX;
import com.bytedance.sdk.component.adexpress.Og.Wx;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class pA extends Wx {
    private float KZx;
    private DX Og;
    private float ZZv;
    private JSONObject pA;

    public pA(C0228pA c0228pA) {
        super(c0228pA);
        this.pA = c0228pA.pA;
        this.Og = c0228pA.Og;
        this.KZx = c0228pA.KZx;
        this.ZZv = c0228pA.ZZv;
    }

    public float du() {
        return this.KZx;
    }

    public float eG() {
        return this.ZZv;
    }

    public JSONObject roi() {
        return this.pA;
    }

    public DX Mc() {
        return this.Og;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.BSW.ZZv.pA$pA, reason: collision with other inner class name */
    public static class C0228pA extends Wx.pA {
        private float KZx;
        private DX Og;
        private float ZZv;
        private JSONObject pA;

        public C0228pA pA(JSONObject jSONObject) {
            this.pA = jSONObject;
            return this;
        }

        public C0228pA pA(DX dx) {
            this.Og = dx;
            return this;
        }

        public C0228pA pA(float f) {
            this.KZx = f;
            return this;
        }

        public C0228pA Og(float f) {
            this.ZZv = f;
            return this;
        }

        @Override // com.bytedance.sdk.component.adexpress.Og.Wx.pA
        /* JADX INFO: renamed from: Og, reason: merged with bridge method [inline-methods] */
        public pA pA() {
            return new pA(this);
        }
    }
}
