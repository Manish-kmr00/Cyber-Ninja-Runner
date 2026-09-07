package com.bytedance.adsdk.Og.ML;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class pA {
    public static com.bytedance.adsdk.Og.KZx.pA.ML pA(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(eG.pA(jsonReader, sd));
            }
            jsonReader.endArray();
            TX.pA(arrayList);
        } else {
            arrayList.add(new com.bytedance.adsdk.Og.SD.pA(yFO.Og(jsonReader, com.bytedance.adsdk.Og.JG.JG.pA())));
        }
        return new com.bytedance.adsdk.Og.KZx.pA.ML(arrayList);
    }

    static com.bytedance.adsdk.Og.KZx.pA.Wx<PointF, PointF> Og(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd) throws IOException {
        jsonReader.beginObject();
        com.bytedance.adsdk.Og.KZx.pA.ML mlPA = null;
        com.bytedance.adsdk.Og.KZx.pA.Og ogPA = null;
        com.bytedance.adsdk.Og.KZx.pA.Og ogPA2 = null;
        boolean z = false;
        while (jsonReader.peek() != JsonToken.END_OBJECT) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "k":
                    mlPA = pA(jsonReader, sd);
                    break;
                case "x":
                    if (jsonReader.peek() != JsonToken.STRING) {
                        ogPA = ZZv.pA(jsonReader, sd);
                        break;
                    } else {
                        z = true;
                        jsonReader.skipValue();
                        break;
                    }
                    break;
                case "y":
                    if (jsonReader.peek() != JsonToken.STRING) {
                        ogPA2 = ZZv.pA(jsonReader, sd);
                        break;
                    } else {
                        z = true;
                        jsonReader.skipValue();
                        break;
                    }
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (z) {
            sd.pA("Lottie doesn't support expressions.");
        }
        return mlPA != null ? mlPA : new com.bytedance.adsdk.Og.KZx.pA.Bzk(ogPA, ogPA2);
    }
}
