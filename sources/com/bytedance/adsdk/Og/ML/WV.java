package com.bytedance.adsdk.Og.ML;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes13.dex */
public class WV implements HSv<Float> {
    public static final WV pA = new WV();

    private WV() {
    }

    @Override // com.bytedance.adsdk.Og.ML.HSv
    /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
    public Float Og(JsonReader jsonReader, float f) throws IOException {
        return Float.valueOf(yFO.Og(jsonReader) * f);
    }
}
