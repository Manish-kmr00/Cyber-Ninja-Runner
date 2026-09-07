package com.bytedance.adsdk.Og.ML;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes12.dex */
public class BSW {
    private com.bytedance.adsdk.Og.KZx.pA.Og KZx;
    private com.bytedance.adsdk.Og.KZx.pA.Og ML;
    private com.bytedance.adsdk.Og.KZx.pA.Og Og;
    private com.bytedance.adsdk.Og.KZx.pA.Og ZZv;
    private com.bytedance.adsdk.Og.KZx.pA.pA pA;

    SGo pA(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd) throws IOException {
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("ef")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    Og(jsonReader, sd);
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        if (this.pA == null || this.Og == null || this.KZx == null || this.ZZv == null || this.ML == null) {
            return null;
        }
        return new SGo(this.pA, this.Og, this.KZx, this.ZZv, this.ML);
    }

    private void Og(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd) throws IOException {
        jsonReader.beginObject();
        String strNextString = "";
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("v")) {
                strNextString.hashCode();
                switch (strNextString) {
                    case "Distance":
                        this.ZZv = ZZv.pA(jsonReader, sd);
                        break;
                    case "Opacity":
                        this.Og = ZZv.pA(jsonReader, sd, false);
                        break;
                    case "Direction":
                        this.KZx = ZZv.pA(jsonReader, sd, false);
                        break;
                    case "Shadow Color":
                        this.pA = ZZv.SD(jsonReader, sd);
                        break;
                    case "Softness":
                        this.ML = ZZv.pA(jsonReader, sd);
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            } else if (strNextName.equals("nm")) {
                strNextString = jsonReader.nextString();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }
}
