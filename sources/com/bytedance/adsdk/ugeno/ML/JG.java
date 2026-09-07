package com.bytedance.adsdk.ugeno.ML;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes6.dex */
public class JG extends com.bytedance.adsdk.ugeno.Og.pA<ML> {
    private int KZx;
    private int Og;
    private int ZZv;
    private int guZ;
    private int npn;

    public JG(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.Og.KZx
    /* JADX INFO: renamed from: fN, reason: merged with bridge method [inline-methods] */
    public ML ZZv() {
        ML ml = new ML(this.ML);
        ml.pA(this);
        return ml;
    }

    @Override // com.bytedance.adsdk.ugeno.Og.pA, com.bytedance.adsdk.ugeno.Og.KZx
    public void Og() {
        super.Og();
        ((ML) this.omh).setFlexDirection(this.Og);
        ((ML) this.omh).setFlexWrap(this.KZx);
        ((ML) this.omh).setJustifyContent(this.ZZv);
        ((ML) this.omh).setAlignItems(this.guZ);
        ((ML) this.omh).setAlignContent(this.npn);
    }

    @Override // com.bytedance.adsdk.ugeno.Og.pA
    public com.bytedance.adsdk.ugeno.Og.pA.C0174pA KZx() {
        return new pA(this);
    }

    public static class pA extends com.bytedance.adsdk.ugeno.Og.pA.C0174pA {
        public float IG;
        public int Mc;
        public int du;
        public float eG;
        public int lT;
        public int qmB;
        public int rB;
        public float roi;
        public int xy;

        public pA(com.bytedance.adsdk.ugeno.Og.pA pAVar) {
            super(pAVar);
            this.du = 1;
            this.eG = 0.0f;
            this.roi = 0.0f;
            this.Mc = -1;
            this.IG = -1.0f;
            this.lT = -1;
            this.rB = -1;
            this.xy = ViewCompat.MEASURED_SIZE_MASK;
            this.qmB = ViewCompat.MEASURED_SIZE_MASK;
        }

        @Override // com.bytedance.adsdk.ugeno.Og.pA.C0174pA
        public void pA(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
            }
            super.pA(context, str, str2);
            str.hashCode();
            switch (str) {
                case "flexBasisPercent":
                    this.IG = ZZv(str2);
                    break;
                case "order":
                    this.du = pA(str2);
                    break;
                case "flexShrink":
                    this.roi = KZx(str2);
                    break;
                case "flexGrow":
                    this.eG = Og(str2);
                    break;
                case "alignSelf":
                    this.Mc = ML(str2);
                    break;
            }
        }

        private int pA(String str) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return 1;
            }
        }

        private float Og(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception unused) {
                return 0.0f;
            }
        }

        private float KZx(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception unused) {
                return 0.0f;
            }
        }

        private float ZZv(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception unused) {
                return -1.0f;
            }
        }

        private int ML(String str) {
            str.hashCode();
            switch (str) {
                case "stretch":
                    return 4;
                case "baseline":
                    return 3;
                case "center":
                    return 2;
                case "flex_start":
                    return 0;
                case "flex_end":
                    return 1;
                default:
                    return -1;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.Og.pA.C0174pA
        /* JADX INFO: renamed from: Og, reason: merged with bridge method [inline-methods] */
        public ML.pA pA() {
            ML.pA pAVar = new ML.pA((int) this.pA, (int) this.Og);
            pAVar.leftMargin = (int) this.JG;
            pAVar.rightMargin = (int) this.SD;
            pAVar.topMargin = (int) this.omh;
            pAVar.bottomMargin = (int) this.Bzk;
            pAVar.KZx(this.du);
            pAVar.ZZv(this.Mc);
            pAVar.pA(this.eG);
            pAVar.Og(this.roi);
            pAVar.KZx(this.IG);
            return pAVar;
        }

        @Override // com.bytedance.adsdk.ugeno.Og.pA.C0174pA
        public String toString() {
            return "LayoutParams{mWidth=" + this.pA + ", mHeight=" + this.Og + ", mMargin=" + this.ML + ", mMarginLeft=" + this.JG + ", mMarginRight=" + this.SD + ", mMarginTop=" + this.omh + ", mMarginBottom=" + this.Bzk + ", mParams=" + this.WQf + ", mOrder=" + this.du + ", mFlexGrow=" + this.eG + ", mFlexShrink=" + this.roi + ", mAlignSelf=" + this.Mc + ", mFlexBasisPercent=" + this.IG + ", mMinWidth=" + this.lT + ", mMinHeight=" + this.rB + ", mMaxWidth=" + this.xy + ", mMaxHeight=" + this.qmB + "} " + super.toString();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.Og.KZx
    public void pA(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.pA(str, str2);
        str.hashCode();
        switch (str) {
            case "alignItems":
                this.guZ = SGo(str2);
                break;
            case "flexDirection":
                this.Og = SD(str2);
                break;
            case "alignContent":
                this.npn = BSW(str2);
                break;
            case "flexWrap":
                this.KZx = omh(str2);
                break;
            case "justifyContent":
                this.ZZv = Bzk(str2);
                break;
        }
    }

    int SD(String str) {
        str.hashCode();
        switch (str) {
            case "column_reverse":
                return 3;
            case "column":
                return 2;
            case "row_reverse":
                return 1;
            default:
                return 0;
        }
    }

    private int omh(String str) {
        str.hashCode();
        return !str.equals("wrap") ? 0 : 1;
    }

    private int Bzk(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                return 2;
            case "space_around":
                return 4;
            case "space_between":
                return 3;
            case "flex_end":
                return 1;
            default:
                return 0;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x003f  */
    private int SGo(String str) {
        byte b;
        switch (str) {
            case "stretch":
                b = 4;
                break;
            case "baseline":
                b = 3;
                break;
            case "center":
                b = 2;
                break;
            case "flex_start":
                b = 0;
                break;
            case "flex_end":
                b = 1;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            return 0;
        }
        if (b == 1) {
            return 1;
        }
        if (b != 2) {
            return b != 3 ? 4 : 3;
        }
        return 2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:23:0x004a  */
    private int BSW(String str) {
        byte b;
        switch (str) {
            case "stretch":
                b = 5;
                break;
            case "center":
                b = 2;
                break;
            case "space_around":
                b = 3;
                break;
            case "flex_start":
                b = 0;
                break;
            case "space_between":
                b = 4;
                break;
            case "flex_end":
                b = 1;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            return 0;
        }
        if (b == 1) {
            return 1;
        }
        if (b == 2) {
            return 2;
        }
        if (b != 3) {
            return b != 4 ? 5 : 3;
        }
        return 4;
    }
}
