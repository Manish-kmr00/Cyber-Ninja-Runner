package com.bytedance.adsdk.Og.ML;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
class du {
    static com.bytedance.adsdk.Og.KZx.Og.Bzk pA(JsonReader jsonReader) throws IOException {
        String strNextString = null;
        com.bytedance.adsdk.Og.KZx.Og.Bzk.pA pAVarPA = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "mm":
                    pAVarPA = com.bytedance.adsdk.Og.KZx.Og.Bzk.pA.pA(jsonReader.nextInt());
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.Og.KZx.Og.Bzk(strNextString, pAVarPA, zNextBoolean);
    }
}
