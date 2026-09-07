package com.bytedance.adsdk.Og.ML;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class xy {
    static com.bytedance.adsdk.Og.KZx.Og.Wx pA(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd) throws IOException {
        String strNextString = null;
        com.bytedance.adsdk.Og.KZx.pA.Og ogPA = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "r":
                    ogPA = ZZv.pA(jsonReader, sd, true);
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
        if (zNextBoolean) {
            return null;
        }
        return new com.bytedance.adsdk.Og.KZx.Og.Wx(strNextString, ogPA);
    }
}
