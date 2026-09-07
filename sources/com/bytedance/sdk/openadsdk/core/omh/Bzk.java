package com.bytedance.sdk.openadsdk.core.omh;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class Bzk extends com.bytedance.sdk.openadsdk.core.Og.Og {
    public Bzk(Context context, com.bytedance.sdk.openadsdk.core.model.yFO yfo, String str, int i) {
        super(context, yfo, str, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Og.Og
    protected com.bytedance.sdk.openadsdk.core.model.SGo pA(float f, float f2, float f3, float f4, SparseArray<com.bytedance.sdk.openadsdk.core.Og.KZx.pA> sparseArray, long j, long j2, View view, View view2, String str, float f5, int i, float f6, int i2, JSONObject jSONObject, JSONObject jSONObject2) {
        float f7;
        float f8;
        float f9;
        float fKZx;
        int i3;
        int i4;
        int i5;
        long j3;
        long j4;
        char c;
        int iKZx;
        int iKZx2;
        int[] iArrPA = Vgu.pA(view);
        int i6 = 0;
        if (iArrPA == null || iArrPA.length != 2) {
            f7 = f;
            f8 = f2;
            f9 = f3;
            fKZx = f4;
            i3 = 0;
            i4 = 0;
        } else {
            i3 = iArrPA[0];
            i4 = iArrPA[1];
            if (this.vZF == 0) {
                float fKZx2 = (Vgu.KZx(this.ZZv, f) + i3) - 0.5f;
                float fKZx3 = (Vgu.KZx(this.ZZv, f2) + i4) - 0.5f;
                float fKZx4 = (Vgu.KZx(this.ZZv, f3) + i3) - 0.5f;
                fKZx = (Vgu.KZx(this.ZZv, f4) + i4) - 0.5f;
                f9 = fKZx4;
                f7 = fKZx2;
                f8 = fKZx3;
            } else {
                f7 = f;
                f8 = f2;
                f9 = f3;
                fKZx = f4;
            }
        }
        int[] iArrPA2 = new int[2];
        int[] iArrKZx = new int[2];
        if (this.ML != null) {
            j3 = this.ML.ML;
            j4 = this.ML.JG;
            if (this.vZF == 0) {
                iArrPA2[0] = Vgu.KZx(this.ZZv, this.ML.SD) + i3;
                iArrPA2[1] = Vgu.KZx(this.ZZv, this.ML.omh) + i4;
                iKZx = Vgu.KZx(this.ZZv, this.ML.Bzk);
                iKZx2 = Vgu.KZx(this.ZZv, this.ML.SGo);
                c = 0;
                i5 = 1;
            } else {
                c = 0;
                iArrPA2[0] = this.ML.SD;
                i5 = 1;
                iArrPA2[1] = this.ML.omh;
                iKZx = this.ML.Bzk;
                iKZx2 = this.ML.SGo;
            }
            iArrKZx[c] = iKZx;
            iArrKZx[i5] = iKZx2;
            if (iKZx == 0 && iKZx2 == 0 && view2 != null) {
                iArrPA2 = Vgu.pA(view2);
                iArrKZx = Vgu.KZx(view2);
            }
            i6 = 0;
        } else {
            i5 = 1;
            j3 = j;
            j4 = j2;
        }
        this.vZF = i6;
        return new com.bytedance.sdk.openadsdk.core.model.SGo.pA().JG(f7).ML(f8).ZZv(f9).KZx(fKZx).Og(j3).pA(j4).Og(iArrPA).pA(iArrPA2).KZx(Vgu.KZx(view)).ZZv(iArrKZx).ZZv(this.eG).ML(this.roi).JG(this.Mc).Og(com.bytedance.sdk.openadsdk.core.Bzk.Og().pA() ? i5 : 2).pA(sparseArray).pA(str).pA(i2).pA(jSONObject).Og(jSONObject2).pA();
    }

    public void pA(com.bytedance.sdk.openadsdk.core.model.Sn sn) {
        this.ML = sn;
    }
}
