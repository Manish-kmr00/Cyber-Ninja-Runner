package com.bytedance.adsdk.Og.ML;

import android.graphics.Path;
import android.util.JsonReader;
import java.io.IOException;
import java.util.Collections;

/* JADX INFO: loaded from: classes9.dex */
class Vgu {
    static com.bytedance.adsdk.Og.KZx.Og.DX pA(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd) throws IOException {
        com.bytedance.adsdk.Og.KZx.pA.ZZv zZv = null;
        String strNextString = null;
        com.bytedance.adsdk.Og.KZx.pA.pA pAVarSD = null;
        boolean zNextBoolean = false;
        boolean zNextBoolean2 = false;
        int iNextInt = 1;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "fillEnabled":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "c":
                    pAVarSD = ZZv.SD(jsonReader, sd);
                    break;
                case "o":
                    zZv = ZZv.Og(jsonReader, sd);
                    break;
                case "r":
                    iNextInt = jsonReader.nextInt();
                    break;
                case "hd":
                    zNextBoolean2 = jsonReader.nextBoolean();
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        if (zZv == null) {
            zZv = new com.bytedance.adsdk.Og.KZx.pA.ZZv(Collections.singletonList(new com.bytedance.adsdk.Og.SD.pA(100)));
        }
        return new com.bytedance.adsdk.Og.KZx.Og.DX(strNextString, zNextBoolean, iNextInt == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, pAVarSD, zZv, zNextBoolean2);
    }
}
