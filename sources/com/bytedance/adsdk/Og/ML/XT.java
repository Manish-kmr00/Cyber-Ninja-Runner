package com.bytedance.adsdk.Og.ML;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes13.dex */
public class XT implements HSv<Integer> {
    public static final XT pA = new XT();

    private XT() {
    }

    @Override // com.bytedance.adsdk.Og.ML.HSv
    /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
    public Integer Og(JsonReader jsonReader, float f) throws IOException {
        return Integer.valueOf(Math.round(yFO.Og(jsonReader) * f));
    }
}
