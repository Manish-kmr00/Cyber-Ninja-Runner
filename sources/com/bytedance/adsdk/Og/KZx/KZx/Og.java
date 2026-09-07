package com.bytedance.adsdk.Og.KZx.KZx;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.LongSparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class Og extends pA {
    private final Paint BSW;
    private final RectF Bzk;
    private com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> SD;
    private final RectF SGo;
    private boolean WV;
    private final List<pA> omh;

    public Og(com.bytedance.adsdk.Og.Bzk bzk, ML ml, List<ML> list, com.bytedance.adsdk.Og.SD sd, Context context) {
        int i;
        pA pAVar;
        ML.Og ogWV;
        int i2;
        super(bzk, ml);
        this.omh = new ArrayList();
        this.Bzk = new RectF();
        this.SGo = new RectF();
        this.BSW = new Paint();
        this.WV = true;
        com.bytedance.adsdk.Og.KZx.pA.Og ogSd = ml.Sd();
        if (ogSd != null) {
            com.bytedance.adsdk.Og.pA.Og.pA<Float, Float> pAVarPA = ogSd.pA();
            this.SD = pAVarPA;
            pA(pAVarPA);
            this.SD.pA(this);
        } else {
            this.SD = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(sd.Wx().size());
        int size = list.size() - 1;
        pA pAVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            ML ml2 = list.get(size);
            pA pAVarPA2 = pA.pA(this, ml2, bzk, sd, context);
            if (pAVarPA2 != null) {
                longSparseArray.put(pAVarPA2.Og().ML(), pAVarPA2);
                if (pAVar2 != null) {
                    pAVar2.pA(pAVarPA2);
                    pAVar2 = null;
                } else {
                    this.omh.add(0, pAVarPA2);
                    if (ml2 != null && (ogWV = ml2.WV()) != null && ((i2 = AnonymousClass1.pA[ogWV.ordinal()]) == 1 || i2 == 2)) {
                        pAVar2 = pAVarPA2;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < longSparseArray.size(); i++) {
            pA pAVar3 = (pA) longSparseArray.get(longSparseArray.keyAt(i));
            if (pAVar3 != null && (pAVar = (pA) longSparseArray.get(pAVar3.Og().Wx())) != null) {
                pAVar3.Og(pAVar);
            }
        }
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.Og.KZx.KZx.Og$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] pA;

        static {
            int[] iArr = new int[ML.Og.values().length];
            pA = iArr;
            try {
                iArr[ML.Og.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                pA[ML.Og.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public void Og(boolean z) {
        this.WV = z;
    }

    @Override // com.bytedance.adsdk.Og.KZx.KZx.pA
    public void pA(boolean z) {
        super.pA(z);
        Iterator<pA> it = this.omh.iterator();
        while (it.hasNext()) {
            it.next().pA(z);
        }
    }

    @Override // com.bytedance.adsdk.Og.KZx.KZx.pA
    public void Og(Canvas canvas, Matrix matrix, int i) {
        super.Og(canvas, matrix, i);
        com.bytedance.adsdk.Og.ML.pA("CompositionLayer#draw");
        this.SGo.set(0.0f, 0.0f, this.KZx.omh(), this.KZx.Bzk());
        matrix.mapRect(this.SGo);
        boolean z = this.Og.Bzk() && this.omh.size() > 1 && i != 255;
        if (z) {
            this.BSW.setAlpha(i);
            com.bytedance.adsdk.Og.JG.JG.pA(canvas, this.SGo, this.BSW);
        } else {
            canvas.save();
        }
        if (z) {
            i = 255;
        }
        for (int size = this.omh.size() - 1; size >= 0; size--) {
            if (((this.WV || !"__container".equals(this.KZx.JG())) && !this.SGo.isEmpty()) ? canvas.clipRect(this.SGo) : true) {
                this.omh.get(size).pA(canvas, matrix, i);
            }
        }
        canvas.restore();
        com.bytedance.adsdk.Og.ML.Og("CompositionLayer#draw");
    }

    @Override // com.bytedance.adsdk.Og.KZx.KZx.pA, com.bytedance.adsdk.Og.pA.pA.ML
    public void pA(RectF rectF, Matrix matrix, boolean z) {
        super.pA(rectF, matrix, z);
        for (int size = this.omh.size() - 1; size >= 0; size--) {
            this.Bzk.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.omh.get(size).pA(this.Bzk, this.pA, true);
            rectF.union(this.Bzk);
        }
    }

    public List<pA> WV() {
        return this.omh;
    }

    @Override // com.bytedance.adsdk.Og.KZx.KZx.pA
    public void pA(float f) {
        super.pA(f);
        if (this.SD != null) {
            f = ((this.SD.SD().floatValue() * this.KZx.pA().WV()) - this.KZx.pA().JG()) / (this.Og.du().aBv() + 0.01f);
        }
        if (this.SD == null) {
            f -= this.KZx.KZx();
        }
        if (this.KZx.Og() != 0.0f && !"__container".equals(this.KZx.JG())) {
            f /= this.KZx.Og();
        }
        for (int size = this.omh.size() - 1; size >= 0; size--) {
            this.omh.get(size).pA(f);
        }
    }
}
