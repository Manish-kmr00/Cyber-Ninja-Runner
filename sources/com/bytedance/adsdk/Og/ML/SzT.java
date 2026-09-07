package com.bytedance.adsdk.Og.ML;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes13.dex */
class SzT {
    static com.bytedance.adsdk.Og.KZx.Og.aBv pA(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd) throws IOException {
        String strNextString = null;
        com.bytedance.adsdk.Og.KZx.pA.omh omhVarML = null;
        int iNextInt = 0;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "ks":
                    omhVarML = ZZv.ML(jsonReader, sd);
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "ind":
                    iNextInt = jsonReader.nextInt();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.Og.KZx.Og.aBv(strNextString, iNextInt, omhVarML, zNextBoolean);
    }
}
