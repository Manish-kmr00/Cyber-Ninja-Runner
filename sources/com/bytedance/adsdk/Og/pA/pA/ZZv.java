package com.bytedance.adsdk.Og.pA.pA;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class ZZv implements com.bytedance.adsdk.Og.pA.Og.pA.InterfaceC0167pA, ML, Wx {
    private com.bytedance.adsdk.Og.pA.Og.oX BSW;
    private final com.bytedance.adsdk.Og.Bzk Bzk;
    private final String JG;
    private final Matrix KZx;
    private final RectF ML;
    private final RectF Og;
    private final boolean SD;
    private List<Wx> SGo;
    private final Path ZZv;
    private final List<KZx> omh;
    private final Paint pA;

    private static List<KZx> pA(com.bytedance.adsdk.Og.Bzk bzk, com.bytedance.adsdk.Og.SD sd, com.bytedance.adsdk.Og.KZx.KZx.pA pAVar, List<com.bytedance.adsdk.Og.KZx.Og.KZx> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            KZx kZxPA = list.get(i).pA(bzk, sd, pAVar);
            if (kZxPA != null) {
                arrayList.add(kZxPA);
            }
        }
        return arrayList;
    }

    static com.bytedance.adsdk.Og.KZx.pA.WV pA(List<com.bytedance.adsdk.Og.KZx.Og.KZx> list) {
        for (int i = 0; i < list.size(); i++) {
            com.bytedance.adsdk.Og.KZx.Og.KZx kZx = list.get(i);
            if (kZx instanceof com.bytedance.adsdk.Og.KZx.pA.WV) {
                return (com.bytedance.adsdk.Og.KZx.pA.WV) kZx;
            }
        }
        return null;
    }

    public ZZv(com.bytedance.adsdk.Og.Bzk bzk, com.bytedance.adsdk.Og.KZx.KZx.pA pAVar, com.bytedance.adsdk.Og.KZx.Og.oX oXVar, com.bytedance.adsdk.Og.SD sd) {
        this(bzk, pAVar, oXVar.pA(), oXVar.KZx(), pA(bzk, sd, pAVar, oXVar.Og()), pA(oXVar.Og()));
    }

    ZZv(com.bytedance.adsdk.Og.Bzk bzk, com.bytedance.adsdk.Og.KZx.KZx.pA pAVar, String str, boolean z, List<KZx> list, com.bytedance.adsdk.Og.KZx.pA.WV wv) {
        this.pA = new com.bytedance.adsdk.Og.pA.pA();
        this.Og = new RectF();
        this.KZx = new Matrix();
        this.ZZv = new Path();
        this.ML = new RectF();
        this.JG = str;
        this.Bzk = bzk;
        this.SD = z;
        this.omh = list;
        if (wv != null) {
            com.bytedance.adsdk.Og.pA.Og.oX oXVarSGo = wv.SGo();
            this.BSW = oXVarSGo;
            oXVarSGo.pA(pAVar);
            this.BSW.pA(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            KZx kZx = list.get(size);
            if (kZx instanceof SGo) {
                arrayList.add((SGo) kZx);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((SGo) arrayList.get(size2)).pA(list.listIterator(list.size()));
        }
    }

    @Override // com.bytedance.adsdk.Og.pA.Og.pA.InterfaceC0167pA
    public void pA() {
        this.Bzk.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.Og.pA.pA.KZx
    public void pA(List<KZx> list, List<KZx> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.omh.size());
        arrayList.addAll(list);
        for (int size = this.omh.size() - 1; size >= 0; size--) {
            KZx kZx = this.omh.get(size);
            kZx.pA(arrayList, this.omh.subList(0, size));
            arrayList.add(kZx);
        }
    }

    List<Wx> Og() {
        if (this.SGo == null) {
            this.SGo = new ArrayList();
            for (int i = 0; i < this.omh.size(); i++) {
                KZx kZx = this.omh.get(i);
                if (kZx instanceof Wx) {
                    this.SGo.add((Wx) kZx);
                }
            }
        }
        return this.SGo;
    }

    Matrix KZx() {
        com.bytedance.adsdk.Og.pA.Og.oX oXVar = this.BSW;
        if (oXVar != null) {
            return oXVar.ZZv();
        }
        this.KZx.reset();
        return this.KZx;
    }

    @Override // com.bytedance.adsdk.Og.pA.pA.Wx
    public Path ZZv() {
        this.KZx.reset();
        com.bytedance.adsdk.Og.pA.Og.oX oXVar = this.BSW;
        if (oXVar != null) {
            this.KZx.set(oXVar.ZZv());
        }
        this.ZZv.reset();
        if (this.SD) {
            return this.ZZv;
        }
        for (int size = this.omh.size() - 1; size >= 0; size--) {
            KZx kZx = this.omh.get(size);
            if (kZx instanceof Wx) {
                this.ZZv.addPath(((Wx) kZx).ZZv(), this.KZx);
            }
        }
        return this.ZZv;
    }

    @Override // com.bytedance.adsdk.Og.pA.pA.ML
    public void pA(Canvas canvas, Matrix matrix, int i) {
        if (this.SD) {
            return;
        }
        this.KZx.set(matrix);
        com.bytedance.adsdk.Og.pA.Og.oX oXVar = this.BSW;
        if (oXVar != null) {
            this.KZx.preConcat(oXVar.ZZv());
            i = (int) (((((this.BSW.pA() == null ? 100 : this.BSW.pA().SD().intValue()) / 100.0f) * i) / 255.0f) * 255.0f);
        }
        boolean z = this.Bzk.Bzk() && ML() && i != 255;
        if (z) {
            this.Og.set(0.0f, 0.0f, 0.0f, 0.0f);
            pA(this.Og, this.KZx, true);
            this.pA.setAlpha(i);
            com.bytedance.adsdk.Og.JG.JG.pA(canvas, this.Og, this.pA);
        }
        if (z) {
            i = 255;
        }
        for (int size = this.omh.size() - 1; size >= 0; size--) {
            KZx kZx = this.omh.get(size);
            if (kZx instanceof ML) {
                ((ML) kZx).pA(canvas, this.KZx, i);
            }
        }
        if (z) {
            canvas.restore();
        }
    }

    private boolean ML() {
        int i = 0;
        for (int i2 = 0; i2 < this.omh.size(); i2++) {
            if ((this.omh.get(i2) instanceof ML) && (i = i + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.adsdk.Og.pA.pA.ML
    public void pA(RectF rectF, Matrix matrix, boolean z) {
        this.KZx.set(matrix);
        com.bytedance.adsdk.Og.pA.Og.oX oXVar = this.BSW;
        if (oXVar != null) {
            this.KZx.preConcat(oXVar.ZZv());
        }
        this.ML.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.omh.size() - 1; size >= 0; size--) {
            KZx kZx = this.omh.get(size);
            if (kZx instanceof ML) {
                ((ML) kZx).pA(this.ML, this.KZx, z);
                rectF.union(this.ML);
            }
        }
    }
}
