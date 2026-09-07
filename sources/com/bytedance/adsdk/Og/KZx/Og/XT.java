package com.bytedance.adsdk.Og.KZx.Og;

import android.graphics.Paint;
import com.bytedance.adsdk.Og.pA.pA.vZF;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class XT implements KZx {
    private final float Bzk;
    private final com.bytedance.adsdk.Og.KZx.pA.Og JG;
    private final List<com.bytedance.adsdk.Og.KZx.pA.Og> KZx;
    private final com.bytedance.adsdk.Og.KZx.pA.ZZv ML;
    private final com.bytedance.adsdk.Og.KZx.pA.Og Og;
    private final pA SD;
    private final boolean SGo;
    private final com.bytedance.adsdk.Og.KZx.pA.pA ZZv;
    private final Og omh;
    private final String pA;

    public enum pA {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap pA() {
            int i = AnonymousClass1.pA[ordinal()];
            if (i == 1) {
                return Paint.Cap.BUTT;
            }
            if (i == 2) {
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.SQUARE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.Og.KZx.Og.XT$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Og;
        static final /* synthetic */ int[] pA;

        static {
            int[] iArr = new int[Og.values().length];
            Og = iArr;
            try {
                iArr[Og.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Og[Og.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Og[Og.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[pA.values().length];
            pA = iArr2;
            try {
                iArr2[pA.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                pA[pA.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                pA[pA.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public enum Og {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join pA() {
            int i = AnonymousClass1.Og[ordinal()];
            if (i == 1) {
                return Paint.Join.BEVEL;
            }
            if (i == 2) {
                return Paint.Join.MITER;
            }
            if (i != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    public XT(String str, com.bytedance.adsdk.Og.KZx.pA.Og og, List<com.bytedance.adsdk.Og.KZx.pA.Og> list, com.bytedance.adsdk.Og.KZx.pA.pA pAVar, com.bytedance.adsdk.Og.KZx.pA.ZZv zZv, com.bytedance.adsdk.Og.KZx.pA.Og og2, pA pAVar2, Og og3, float f, boolean z) {
        this.pA = str;
        this.Og = og;
        this.KZx = list;
        this.ZZv = pAVar;
        this.ML = zZv;
        this.JG = og2;
        this.SD = pAVar2;
        this.omh = og3;
        this.Bzk = f;
        this.SGo = z;
    }

    @Override // com.bytedance.adsdk.Og.KZx.Og.KZx
    public com.bytedance.adsdk.Og.pA.pA.KZx pA(com.bytedance.adsdk.Og.Bzk bzk, com.bytedance.adsdk.Og.SD sd, com.bytedance.adsdk.Og.KZx.KZx.pA pAVar) {
        return new vZF(bzk, pAVar, this);
    }

    public String pA() {
        return this.pA;
    }

    public com.bytedance.adsdk.Og.KZx.pA.pA Og() {
        return this.ZZv;
    }

    public com.bytedance.adsdk.Og.KZx.pA.ZZv KZx() {
        return this.ML;
    }

    public com.bytedance.adsdk.Og.KZx.pA.Og ZZv() {
        return this.JG;
    }

    public List<com.bytedance.adsdk.Og.KZx.pA.Og> ML() {
        return this.KZx;
    }

    public com.bytedance.adsdk.Og.KZx.pA.Og JG() {
        return this.Og;
    }

    public pA SD() {
        return this.SD;
    }

    public Og omh() {
        return this.omh;
    }

    public float Bzk() {
        return this.Bzk;
    }

    public boolean SGo() {
        return this.SGo;
    }
}
