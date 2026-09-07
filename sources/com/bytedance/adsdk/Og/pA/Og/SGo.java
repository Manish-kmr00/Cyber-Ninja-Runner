package com.bytedance.adsdk.Og.pA.Og;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class SGo extends SD<PointF> {
    private final PathMeasure JG;
    private final float[] ML;
    private Bzk SD;
    private final PointF ZZv;

    public SGo(List<? extends com.bytedance.adsdk.Og.SD.pA<PointF>> list) {
        super(list);
        this.ZZv = new PointF();
        this.ML = new float[2];
        this.JG = new PathMeasure();
    }

    @Override // com.bytedance.adsdk.Og.pA.Og.pA
    /* JADX INFO: renamed from: Og, reason: merged with bridge method [inline-methods] */
    public PointF pA(com.bytedance.adsdk.Og.SD.pA<PointF> pAVar, float f) {
        Bzk bzk = (Bzk) pAVar;
        Path pathOg = bzk.Og();
        if (pathOg == null) {
            return pAVar.pA;
        }
        if (this.KZx != null) {
            bzk.SD.floatValue();
            ZZv();
            omh();
            throw null;
        }
        if (this.SD != bzk) {
            this.JG.setPath(pathOg, false);
            this.SD = bzk;
        }
        PathMeasure pathMeasure = this.JG;
        pathMeasure.getPosTan(f * pathMeasure.getLength(), this.ML, null);
        PointF pointF = this.ZZv;
        float[] fArr = this.ML;
        pointF.set(fArr[0], fArr[1]);
        return this.ZZv;
    }
}
