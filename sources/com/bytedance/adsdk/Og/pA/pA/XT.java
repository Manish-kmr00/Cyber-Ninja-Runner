package com.bytedance.adsdk.Og.pA.pA;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class XT implements com.bytedance.adsdk.Og.pA.Og.pA.InterfaceC0167pA, Wx {
    private boolean JG;
    private final boolean KZx;
    private final com.bytedance.adsdk.Og.pA.Og.Wx ML;
    private final String Og;
    private final com.bytedance.adsdk.Og.Bzk ZZv;
    private final Path pA = new Path();
    private final Og SD = new Og();

    public XT(com.bytedance.adsdk.Og.Bzk bzk, com.bytedance.adsdk.Og.KZx.KZx.pA pAVar, com.bytedance.adsdk.Og.KZx.Og.aBv abv) {
        this.Og = abv.pA();
        this.KZx = abv.KZx();
        this.ZZv = bzk;
        com.bytedance.adsdk.Og.pA.Og.Wx wxPA = abv.Og().pA();
        this.ML = wxPA;
        pAVar.pA(wxPA);
        wxPA.pA(this);
    }

    @Override // com.bytedance.adsdk.Og.pA.Og.pA.InterfaceC0167pA
    public void pA() {
        Og();
    }

    private void Og() {
        this.JG = false;
        this.ZZv.invalidateSelf();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    /* JADX WARN: Code duplicated, block: B:12:0x002a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:13:0x002c  */
    /* JADX WARN: Code duplicated, block: B:21:0x0036 A[SYNTHETIC] */
    @Override // com.bytedance.adsdk.Og.pA.pA.KZx
    public void pA(List<KZx> list, List<KZx> list2) {
        ArrayList arrayList = null;
        for (int i = 0; i < list.size(); i++) {
            KZx kZx = list.get(i);
            if (kZx instanceof TX) {
                TX tx = (TX) kZx;
                if (tx.Og() == com.bytedance.adsdk.Og.KZx.Og.yFO.pA.SIMULTANEOUSLY) {
                    this.SD.pA(tx);
                    tx.pA(this);
                } else if (!(kZx instanceof yFO)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((yFO) kZx);
                }
            } else if (!(kZx instanceof yFO)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add((yFO) kZx);
            }
        }
        this.ML.pA((List<yFO>) arrayList);
    }

    @Override // com.bytedance.adsdk.Og.pA.pA.Wx
    public Path ZZv() {
        if (this.JG) {
            return this.pA;
        }
        this.pA.reset();
        if (this.KZx) {
            this.JG = true;
            return this.pA;
        }
        Path pathSD = this.ML.SD();
        if (pathSD == null) {
            return this.pA;
        }
        this.pA.set(pathSD);
        this.pA.setFillType(Path.FillType.EVEN_ODD);
        this.SD.pA(this.pA);
        this.JG = true;
        return this.pA;
    }
}
