package com.bytedance.adsdk.Og.ML;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes13.dex */
class ML {
    static com.bytedance.adsdk.Og.KZx.Og.pA pA(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd) throws IOException {
        com.bytedance.adsdk.Og.KZx.Og.pA pAVar = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("ef")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.bytedance.adsdk.Og.KZx.Og.pA pAVarOg = Og(jsonReader, sd);
                    if (pAVarOg != null) {
                        pAVar = pAVarOg;
                    }
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        return pAVar;
    }

    private static com.bytedance.adsdk.Og.KZx.Og.pA Og(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.Og.KZx.Og.pA pAVar = null;
        while (true) {
            boolean z = false;
            while (true) {
                if (jsonReader.hasNext()) {
                    String strNextName = jsonReader.nextName();
                    strNextName.hashCode();
                    if (strNextName.equals("v")) {
                        if (z) {
                            pAVar = new com.bytedance.adsdk.Og.KZx.Og.pA(ZZv.pA(jsonReader, sd));
                        } else {
                            jsonReader.skipValue();
                        }
                    } else if (strNextName.equals("ty")) {
                        if (jsonReader.nextInt() == 0) {
                            z = true;
                        }
                    } else {
                        jsonReader.skipValue();
                    }
                } else {
                    jsonReader.endObject();
                    return pAVar;
                }
            }
        }
    }
}
