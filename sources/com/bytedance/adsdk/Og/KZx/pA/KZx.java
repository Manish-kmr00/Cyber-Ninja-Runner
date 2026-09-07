package com.bytedance.adsdk.Og.KZx.pA;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class KZx extends Sn<com.bytedance.adsdk.Og.KZx.Og.ZZv, com.bytedance.adsdk.Og.KZx.Og.ZZv> {
    @Override // com.bytedance.adsdk.Og.KZx.pA.Sn, com.bytedance.adsdk.Og.KZx.pA.Wx
    public /* bridge */ /* synthetic */ List KZx() {
        return super.KZx();
    }

    @Override // com.bytedance.adsdk.Og.KZx.pA.Sn, com.bytedance.adsdk.Og.KZx.pA.Wx
    public /* bridge */ /* synthetic */ boolean Og() {
        return super.Og();
    }

    @Override // com.bytedance.adsdk.Og.KZx.pA.Sn
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public KZx(List<com.bytedance.adsdk.Og.SD.pA<com.bytedance.adsdk.Og.KZx.Og.ZZv>> list) {
        super(pA(list));
    }

    private static List<com.bytedance.adsdk.Og.SD.pA<com.bytedance.adsdk.Og.KZx.Og.ZZv>> pA(List<com.bytedance.adsdk.Og.SD.pA<com.bytedance.adsdk.Og.KZx.Og.ZZv>> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, pA(list.get(i)));
        }
        return list;
    }

    private static com.bytedance.adsdk.Og.SD.pA<com.bytedance.adsdk.Og.KZx.Og.ZZv> pA(com.bytedance.adsdk.Og.SD.pA<com.bytedance.adsdk.Og.KZx.Og.ZZv> pAVar) {
        com.bytedance.adsdk.Og.KZx.Og.ZZv zZv = pAVar.pA;
        com.bytedance.adsdk.Og.KZx.Og.ZZv zZv2 = pAVar.Og;
        if (zZv == null || zZv2 == null || zZv.pA().length == zZv2.pA().length) {
            return pAVar;
        }
        float[] fArrPA = pA(zZv.pA(), zZv2.pA());
        return pAVar.pA(zZv.pA(fArrPA), zZv2.pA(fArrPA));
    }

    static float[] pA(float[] fArr, float[] fArr2) {
        int length = fArr.length + fArr2.length;
        float[] fArr3 = new float[length];
        System.arraycopy(fArr, 0, fArr3, 0, fArr.length);
        System.arraycopy(fArr2, 0, fArr3, fArr.length, fArr2.length);
        Arrays.sort(fArr3);
        float f = Float.NaN;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            float f2 = fArr3[i2];
            if (f2 != f) {
                fArr3[i] = f2;
                i++;
                f = fArr3[i2];
            }
        }
        return Arrays.copyOfRange(fArr3, 0, i);
    }

    @Override // com.bytedance.adsdk.Og.KZx.pA.Wx
    public com.bytedance.adsdk.Og.pA.Og.pA<com.bytedance.adsdk.Og.KZx.Og.ZZv, com.bytedance.adsdk.Og.KZx.Og.ZZv> pA() {
        return new com.bytedance.adsdk.Og.pA.Og.ML(this.pA);
    }
}
