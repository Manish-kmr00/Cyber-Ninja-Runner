package com.bytedance.adsdk.Og.ML;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes13.dex */
class CIG {
    static com.bytedance.adsdk.Og.KZx.Og.oX pA(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd) throws IOException {
        ArrayList arrayList = new ArrayList();
        String strNextString = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "it":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        com.bytedance.adsdk.Og.KZx.Og.KZx kZxPA = omh.pA(jsonReader, sd);
                        if (kZxPA != null) {
                            arrayList.add(kZxPA);
                        }
                    }
                    jsonReader.endArray();
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.Og.KZx.Og.oX(strNextString, arrayList, zNextBoolean);
    }
}
