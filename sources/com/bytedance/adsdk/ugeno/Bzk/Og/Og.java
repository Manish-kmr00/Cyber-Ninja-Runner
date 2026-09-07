package com.bytedance.adsdk.ugeno.Bzk.Og;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes11.dex */
public class Og extends com.bytedance.adsdk.ugeno.Og.pA<com.bytedance.adsdk.ugeno.Bzk.Og.pA> {
    private com.bytedance.adsdk.ugeno.Bzk.Og.pA Og;

    public Og(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.Og.KZx
    /* JADX INFO: renamed from: fN, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.ugeno.Bzk.Og.pA ZZv() {
        com.bytedance.adsdk.ugeno.Bzk.Og.pA pAVar = new com.bytedance.adsdk.ugeno.Bzk.Og.pA(this.ML);
        this.Og = pAVar;
        pAVar.pA(this);
        return this.Og;
    }

    @Override // com.bytedance.adsdk.ugeno.Og.pA, com.bytedance.adsdk.ugeno.Og.KZx
    public void Og() {
        this.Og.setEventMap(this.Lm);
        super.Og();
    }

    @Override // com.bytedance.adsdk.ugeno.Og.pA
    public com.bytedance.adsdk.ugeno.Og.pA.C0174pA KZx() {
        return new pA(this);
    }

    public static class pA extends com.bytedance.adsdk.ugeno.Og.pA.C0174pA {
        protected int du;

        public pA(com.bytedance.adsdk.ugeno.Og.pA pAVar) {
            super(pAVar);
            this.du = -1;
        }

        @Override // com.bytedance.adsdk.ugeno.Og.pA.C0174pA
        public void pA(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            super.pA(context, str, str2);
            if (TextUtils.equals(str, "layoutGravity")) {
                this.du = pA(str2);
            }
        }

        private int pA(String str) {
            String[] strArrSplit;
            if (TextUtils.isEmpty(str) || (strArrSplit = str.split("\\|")) == null || strArrSplit.length <= 0) {
                return -1;
            }
            int iOg = 0;
            for (String str2 : strArrSplit) {
                iOg |= Og(str2);
            }
            return iOg;
        }

        private int Og(String str) {
            str.hashCode();
            switch (str) {
                case "bottom":
                    return 80;
                case "center":
                    return 17;
                case "center_vertical":
                    return 16;
                case "top":
                    return 48;
                case "left":
                    return 3;
                case "right":
                    return 5;
                case "center_horizontal":
                    return 1;
                default:
                    return -1;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.Og.pA.C0174pA
        /* JADX INFO: renamed from: Og, reason: merged with bridge method [inline-methods] */
        public FrameLayout.LayoutParams pA() {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.pA, (int) this.Og);
            layoutParams.leftMargin = (int) this.JG;
            layoutParams.rightMargin = (int) this.SD;
            layoutParams.topMargin = (int) this.omh;
            layoutParams.bottomMargin = (int) this.Bzk;
            layoutParams.gravity = this.du;
            return layoutParams;
        }
    }
}
