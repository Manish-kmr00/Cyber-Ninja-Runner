package com.bytedance.adsdk.Og.ML;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes13.dex */
public class Og {
    public static com.bytedance.adsdk.Og.KZx.pA.BSW pA(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.Og.KZx.pA.BSW bswOg = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("a")) {
                bswOg = Og(jsonReader, sd);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return bswOg == null ? new com.bytedance.adsdk.Og.KZx.pA.BSW(null, null, null, null) : bswOg;
    }

    private static com.bytedance.adsdk.Og.KZx.pA.BSW Og(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.Og.KZx.pA.pA pAVarSD = null;
        com.bytedance.adsdk.Og.KZx.pA.pA pAVarSD2 = null;
        com.bytedance.adsdk.Og.KZx.pA.Og ogPA = null;
        com.bytedance.adsdk.Og.KZx.pA.Og ogPA2 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "t":
                    ogPA2 = ZZv.pA(jsonReader, sd);
                    break;
                case "fc":
                    pAVarSD = ZZv.SD(jsonReader, sd);
                    break;
                case "sc":
                    pAVarSD2 = ZZv.SD(jsonReader, sd);
                    break;
                case "sw":
                    ogPA = ZZv.pA(jsonReader, sd);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.bytedance.adsdk.Og.KZx.pA.BSW(pAVarSD, pAVarSD2, ogPA, ogPA2);
    }
}
