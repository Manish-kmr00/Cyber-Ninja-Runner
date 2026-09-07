package com.bytedance.adsdk.Og.ML;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes13.dex */
class JG {
    static com.bytedance.adsdk.Og.KZx.Og.Og pA(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd, int i) throws IOException {
        boolean z = i == 3;
        boolean zNextBoolean = false;
        String strNextString = null;
        com.bytedance.adsdk.Og.KZx.pA.Wx<PointF, PointF> wxOg = null;
        com.bytedance.adsdk.Og.KZx.pA.JG jgKZx = null;
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
        return new com.bytedance.adsdk.Og.KZx.Og.Og(strNextString, wxOg, jgKZx, z, zNextBoolean);
    }
}
