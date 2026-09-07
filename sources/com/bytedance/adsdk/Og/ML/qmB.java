package com.bytedance.adsdk.Og.ML;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes11.dex */
public class qmB implements HSv<com.bytedance.adsdk.Og.SD.KZx> {
    public static final qmB pA = new qmB();

    private qmB() {
    }

    @Override // com.bytedance.adsdk.Og.ML.HSv
    /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.Og.SD.KZx Og(JsonReader jsonReader, float f) throws IOException {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        float fNextDouble = (float) jsonReader.nextDouble();
        float fNextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        if (z) {
            jsonReader.endArray();
        }
        return new com.bytedance.adsdk.Og.SD.KZx((fNextDouble / 100.0f) * f, (fNextDouble2 / 100.0f) * f);
    }
}
