package com.bytedance.adsdk.Og.pA.pA;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class aBv implements com.bytedance.adsdk.Og.pA.Og.pA.InterfaceC0167pA, yFO {
    private final com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> KZx;
    private final String Og;
    private com.bytedance.adsdk.Og.KZx.Og.Sn ZZv;
    private final com.bytedance.adsdk.Og.Bzk pA;

    @Override // com.bytedance.adsdk.Og.pA.pA.KZx
    public void pA(List<KZx> list, List<KZx> list2) {
    }

    public aBv(com.bytedance.adsdk.Og.Bzk bzk, com.bytedance.adsdk.Og.KZx.KZx.pA pAVar, com.bytedance.adsdk.Og.KZx.Og.Wx wx) {
        this.pA = bzk;
        this.Og = wx.pA();
        com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> pAVarPA = wx.Og().pA();
        this.KZx = pAVarPA;
        pAVar.pA(pAVarPA);
        pAVarPA.pA(this);
    }

    @Override // com.bytedance.adsdk.Og.pA.Og.pA.InterfaceC0167pA
    public void pA() {
        this.pA.invalidateSelf();
    }

    public com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> Og() {
        return this.KZx;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x009f  */
    @Override // com.bytedance.adsdk.Og.pA.pA.yFO
    public com.bytedance.adsdk.Og.KZx.Og.Sn pA(com.bytedance.adsdk.Og.KZx.Og.Sn sn) {
        boolean z;
        List<com.bytedance.adsdk.Og.KZx.pA> listKZx = sn.KZx();
        if (listKZx.size() <= 2) {
            return sn;
        }
        float fFloatValue = this.KZx.SD().floatValue();
        if (fFloatValue == 0.0f) {
            return sn;
        }
        com.bytedance.adsdk.Og.KZx.Og.Sn snOg = Og(sn);
        snOg.pA(sn.pA().x, sn.pA().y);
        List<com.bytedance.adsdk.Og.KZx.pA> listKZx2 = snOg.KZx();
        boolean zOg = sn.Og();
        int i = 0;
        int i2 = 0;
        while (i < listKZx.size()) {
            com.bytedance.adsdk.Og.KZx.pA pAVar = listKZx.get(i);
            com.bytedance.adsdk.Og.KZx.pA pAVar2 = listKZx.get(pA(i - 1, listKZx.size()));
            com.bytedance.adsdk.Og.KZx.pA pAVar3 = listKZx.get(pA(i - 2, listKZx.size()));
            PointF pointFKZx = (i != 0 || zOg) ? pAVar2.KZx() : sn.pA();
            PointF pointFOg = (i != 0 || zOg) ? pAVar2.Og() : pointFKZx;
            PointF pointFPA = pAVar.pA();
            PointF pointFKZx2 = pAVar3.KZx();
            PointF pointFKZx3 = pAVar.KZx();
            if (!sn.Og() && i == 0) {
                z = i == listKZx.size() + (-1);
            }
            if (pointFOg.equals(pointFKZx) && pointFPA.equals(pointFKZx) && !z) {
                float f = pointFKZx.x - pointFKZx2.x;
                float f2 = pointFKZx.y - pointFKZx2.y;
                float f3 = pointFKZx3.x - pointFKZx.x;
                float f4 = pointFKZx3.y - pointFKZx.y;
                float fHypot = (float) Math.hypot(f, f2);
                float fHypot2 = (float) Math.hypot(f3, f4);
                float fMin = Math.min(fFloatValue / fHypot, 0.5f);
                float fMin2 = Math.min(fFloatValue / fHypot2, 0.5f);
                float f5 = pointFKZx.x + ((pointFKZx2.x - pointFKZx.x) * fMin);
                float f6 = pointFKZx.y + ((pointFKZx2.y - pointFKZx.y) * fMin);
                float f7 = pointFKZx.x + ((pointFKZx3.x - pointFKZx.x) * fMin2);
                float f8 = pointFKZx.y + ((pointFKZx3.y - pointFKZx.y) * fMin2);
                float f9 = f5 - ((f5 - pointFKZx.x) * 0.5519f);
                float f10 = f6 - ((f6 - pointFKZx.y) * 0.5519f);
                float f11 = f7 - ((f7 - pointFKZx.x) * 0.5519f);
                float f12 = f8 - ((f8 - pointFKZx.y) * 0.5519f);
                com.bytedance.adsdk.Og.KZx.pA pAVar4 = listKZx2.get(pA(i2 - 1, listKZx2.size()));
                com.bytedance.adsdk.Og.KZx.pA pAVar5 = listKZx2.get(i2);
                pAVar4.Og(f5, f6);
                pAVar4.KZx(f5, f6);
                if (i == 0) {
                    snOg.pA(f5, f6);
                }
                pAVar5.pA(f9, f10);
                com.bytedance.adsdk.Og.KZx.pA pAVar6 = listKZx2.get(i2 + 1);
                pAVar5.Og(f11, f12);
                pAVar5.KZx(f7, f8);
                pAVar6.pA(f7, f8);
                i2 += 2;
            } else {
                com.bytedance.adsdk.Og.KZx.pA pAVar7 = listKZx2.get(pA(i2 - 1, listKZx2.size()));
                com.bytedance.adsdk.Og.KZx.pA pAVar8 = listKZx2.get(i2);
                pAVar7.Og(pAVar2.Og().x, pAVar2.Og().y);
                pAVar7.KZx(pAVar2.KZx().x, pAVar2.KZx().y);
                pAVar8.pA(pAVar.pA().x, pAVar.pA().y);
                i2++;
            }
            i++;
            listKZx = listKZx;
            zOg = zOg;
        }
        return snOg;
    }

    private com.bytedance.adsdk.Og.KZx.Og.Sn Og(com.bytedance.adsdk.Og.KZx.Og.Sn sn) {
        List<com.bytedance.adsdk.Og.KZx.pA> listKZx = sn.KZx();
        boolean zOg = sn.Og();
        int size = listKZx.size() - 1;
        int i = 0;
        while (size >= 0) {
            com.bytedance.adsdk.Og.KZx.pA pAVar = listKZx.get(size);
            com.bytedance.adsdk.Og.KZx.pA pAVar2 = listKZx.get(pA(size - 1, listKZx.size()));
            PointF pointFKZx = (size != 0 || zOg) ? pAVar2.KZx() : sn.pA();
            i = (((size != 0 || zOg) ? pAVar2.Og() : pointFKZx).equals(pointFKZx) && pAVar.pA().equals(pointFKZx) && !(!sn.Og() && size == 0 && size == listKZx.size() - 1)) ? i + 2 : i + 1;
            size--;
        }
        com.bytedance.adsdk.Og.KZx.Og.Sn sn2 = this.ZZv;
        if (sn2 == null || sn2.KZx().size() != i) {
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(new com.bytedance.adsdk.Og.KZx.pA());
            }
            this.ZZv = new com.bytedance.adsdk.Og.KZx.Og.Sn(new PointF(0.0f, 0.0f), false, arrayList);
        }
        this.ZZv.pA(zOg);
        return this.ZZv;
    }

    private static int pA(int i, int i2) {
        return i - (Og(i, i2) * i2);
    }

    private static int Og(int i, int i2) {
        int i3 = i / i2;
        return ((i ^ i2) >= 0 || i2 * i3 == i) ? i3 : i3 - 1;
    }
}
