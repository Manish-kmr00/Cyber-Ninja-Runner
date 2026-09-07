package com.bytedance.adsdk.Og.ML;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes14.dex */
class Gx {
    static com.bytedance.adsdk.Og.KZx.Og.yFO pA(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd) throws IOException {
        String strNextString = null;
        com.bytedance.adsdk.Og.KZx.Og.yFO.pA pAVarPA = null;
        com.bytedance.adsdk.Og.KZx.pA.Og ogPA = null;
        com.bytedance.adsdk.Og.KZx.pA.Og ogPA2 = null;
        com.bytedance.adsdk.Og.KZx.pA.Og ogPA3 = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "e":
                    ogPA2 = ZZv.pA(jsonReader, sd, false);
                    break;
                case "m":
                    pAVarPA = com.bytedance.adsdk.Og.KZx.Og.yFO.pA.pA(jsonReader.nextInt());
                    break;
                case "o":
                    ogPA3 = ZZv.pA(jsonReader, sd, false);
                    break;
                case "s":
                    ogPA = ZZv.pA(jsonReader, sd, false);
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.Og.KZx.Og.yFO(strNextString, pAVarPA, ogPA, ogPA2, ogPA3, zNextBoolean);
    }
}
