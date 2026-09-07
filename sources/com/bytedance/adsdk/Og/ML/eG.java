package com.bytedance.adsdk.Og.ML;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
class eG {
    static com.bytedance.adsdk.Og.pA.Og.Bzk pA(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd) throws IOException {
        return new com.bytedance.adsdk.Og.pA.Og.Bzk(sd, vZF.pA(jsonReader, sd, com.bytedance.adsdk.Og.JG.JG.pA(), roi.pA, jsonReader.peek() == JsonToken.BEGIN_OBJECT, false));
    }
}
