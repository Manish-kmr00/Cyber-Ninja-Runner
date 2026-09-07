package com.bytedance.adsdk.Og.ML;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes7.dex */
class lT {
    static com.bytedance.adsdk.Og.KZx.Og.BSW pA(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd) throws IOException {
        String strNextString = null;
        com.bytedance.adsdk.Og.KZx.pA.Wx<PointF, PointF> wxOg = null;
        com.bytedance.adsdk.Og.KZx.pA.JG jgKZx = null;
        com.bytedance.adsdk.Og.KZx.pA.Og ogPA = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "p":
                    wxOg = pA.Og(jsonReader, sd);
                    break;
                case "r":
                    ogPA = ZZv.pA(jsonReader, sd);
                    break;
                case "s":
                    jgKZx = ZZv.KZx(jsonReader, sd);
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
        return new com.bytedance.adsdk.Og.KZx.Og.BSW(strNextString, wxOg, jgKZx, ogPA, zNextBoolean);
    }
}
