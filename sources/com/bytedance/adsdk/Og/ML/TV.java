package com.bytedance.adsdk.Og.ML;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes12.dex */
class TV {
    static com.bytedance.adsdk.Og.KZx.Og.omh pA(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.Og.KZx.Og.omh.pA pAVar = null;
        com.bytedance.adsdk.Og.KZx.pA.omh omhVarML = null;
        com.bytedance.adsdk.Og.KZx.pA.ZZv zZvOg = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "o":
                    zZvOg = ZZv.Og(jsonReader, sd);
                    break;
                case "pt":
                    omhVarML = ZZv.ML(jsonReader, sd);
                    break;
                case "inv":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "mode":
                    String strNextString = jsonReader.nextString();
                    strNextString.hashCode();
                    switch (strNextString) {
                        case "a":
                            pAVar = com.bytedance.adsdk.Og.KZx.Og.omh.pA.MASK_MODE_ADD;
                            break;
                        case "i":
                            sd.pA("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            pAVar = com.bytedance.adsdk.Og.KZx.Og.omh.pA.MASK_MODE_INTERSECT;
                            break;
                        case "n":
                            pAVar = com.bytedance.adsdk.Og.KZx.Og.omh.pA.MASK_MODE_NONE;
                            break;
                        case "s":
                            pAVar = com.bytedance.adsdk.Og.KZx.Og.omh.pA.MASK_MODE_SUBTRACT;
                            break;
                        default:
                            pAVar = com.bytedance.adsdk.Og.KZx.Og.omh.pA.MASK_MODE_ADD;
                            break;
                    }
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.bytedance.adsdk.Og.KZx.Og.omh(pAVar, omhVarML, zZvOg, zNextBoolean);
    }
}
