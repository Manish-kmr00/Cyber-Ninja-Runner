package com.bytedance.adsdk.Og.ML;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes13.dex */
class IG {
    static com.bytedance.adsdk.Og.KZx.Og.SGo pA(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd, int i) throws IOException {
        boolean zNextBoolean = false;
        boolean z = i == 3;
        String strNextString = null;
        com.bytedance.adsdk.Og.KZx.Og.SGo.pA pAVarPA = null;
        com.bytedance.adsdk.Og.KZx.pA.Og ogPA = null;
        com.bytedance.adsdk.Og.KZx.pA.Wx<PointF, PointF> wxOg = null;
        com.bytedance.adsdk.Og.KZx.pA.Og ogPA2 = null;
        com.bytedance.adsdk.Og.KZx.pA.Og ogPA3 = null;
        com.bytedance.adsdk.Og.KZx.pA.Og ogPA4 = null;
        com.bytedance.adsdk.Og.KZx.pA.Og ogPA5 = null;
        com.bytedance.adsdk.Og.KZx.pA.Og ogPA6 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "d":
                    if (jsonReader.nextInt() != 3) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                    break;
                case "p":
                    wxOg = pA.Og(jsonReader, sd);
                    break;
                case "r":
                    ogPA2 = ZZv.pA(jsonReader, sd, false);
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "ir":
                    ogPA3 = ZZv.pA(jsonReader, sd);
                    break;
                case "is":
                    ogPA5 = ZZv.pA(jsonReader, sd, false);
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "or":
                    ogPA4 = ZZv.pA(jsonReader, sd);
                    break;
                case "os":
                    ogPA6 = ZZv.pA(jsonReader, sd, false);
                    break;
                case "pt":
                    ogPA = ZZv.pA(jsonReader, sd, false);
                    break;
                case "sy":
                    pAVarPA = com.bytedance.adsdk.Og.KZx.Og.SGo.pA.pA(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.Og.KZx.Og.SGo(strNextString, pAVarPA, ogPA, wxOg, ogPA2, ogPA3, ogPA4, ogPA5, ogPA6, zNextBoolean, z);
    }
}
