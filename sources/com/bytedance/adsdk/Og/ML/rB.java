package com.bytedance.adsdk.Og.ML;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
class rB {
    static com.bytedance.adsdk.Og.KZx.Og.WV pA(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd) throws IOException {
        String strNextString = null;
        com.bytedance.adsdk.Og.KZx.pA.Og ogPA = null;
        com.bytedance.adsdk.Og.KZx.pA.Og ogPA2 = null;
        com.bytedance.adsdk.Og.KZx.pA.WV wvPA = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "c":
                    ogPA = ZZv.pA(jsonReader, sd, false);
                    break;
                case "o":
                    ogPA2 = ZZv.pA(jsonReader, sd, false);
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "tr":
                    wvPA = KZx.pA(jsonReader, sd);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.Og.KZx.Og.WV(strNextString, ogPA, ogPA2, wvPA, zNextBoolean);
    }
}
