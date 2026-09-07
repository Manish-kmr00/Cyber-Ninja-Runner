package com.bytedance.adsdk.Og.ML;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes13.dex */
public class roi implements HSv<PointF> {
    public static final roi pA = new roi();

    private roi() {
    }

    @Override // com.bytedance.adsdk.Og.ML.HSv
    /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
    public PointF Og(JsonReader jsonReader, float f) throws IOException {
        return yFO.Og(jsonReader, f);
    }
}
