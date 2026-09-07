package com.bytedance.adsdk.Og.ML;

import android.graphics.Path;
import android.util.JsonReader;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
class oX {
    static com.bytedance.adsdk.Og.KZx.Og.ML pA(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd) throws IOException {
        com.bytedance.adsdk.Og.KZx.pA.ZZv zZvOg = null;
        Path.FillType fillType = Path.FillType.WINDING;
        String strNextString = null;
        com.bytedance.adsdk.Og.KZx.Og.SD sd2 = null;
        com.bytedance.adsdk.Og.KZx.pA.KZx kZxPA = null;
        com.bytedance.adsdk.Og.KZx.pA.JG jgKZx = null;
        com.bytedance.adsdk.Og.KZx.pA.JG jgKZx2 = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            int iNextInt = -1;
            switch (strNextName) {
                case "e":
                    jgKZx2 = ZZv.KZx(jsonReader, sd);
                    break;
                case "g":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.hashCode();
                        if (strNextName2.equals(CampaignEx.JSON_KEY_AD_K)) {
                            kZxPA = ZZv.pA(jsonReader, sd, iNextInt);
                        } else if (strNextName2.equals("p")) {
                            iNextInt = jsonReader.nextInt();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "o":
                    zZvOg = ZZv.Og(jsonReader, sd);
                    break;
                case "r":
                    fillType = jsonReader.nextInt() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case "s":
                    jgKZx = ZZv.KZx(jsonReader, sd);
                    break;
                case "t":
                    sd2 = jsonReader.nextInt() == 1 ? com.bytedance.adsdk.Og.KZx.Og.SD.LINEAR : com.bytedance.adsdk.Og.KZx.Og.SD.RADIAL;
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
        return new com.bytedance.adsdk.Og.KZx.Og.ML(strNextString, sd2, fillType, kZxPA, zZvOg == null ? new com.bytedance.adsdk.Og.KZx.pA.ZZv(Collections.singletonList(new com.bytedance.adsdk.Og.SD.pA(100))) : zZvOg, jgKZx, jgKZx2, null, null, zNextBoolean);
    }
}
