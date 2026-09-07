package com.bytedance.adsdk.Og.ML;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes14.dex */
class FQ {
    static com.bytedance.adsdk.Og.KZx.Og.XT pA(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd) throws IOException {
        int i;
        ArrayList arrayList = new ArrayList();
        float fNextDouble = 0.0f;
        String strNextString = null;
        com.bytedance.adsdk.Og.KZx.pA.Og og = null;
        com.bytedance.adsdk.Og.KZx.pA.pA pAVarSD = null;
        com.bytedance.adsdk.Og.KZx.pA.Og ogPA = null;
        com.bytedance.adsdk.Og.KZx.Og.XT.pA pAVar = null;
        com.bytedance.adsdk.Og.KZx.Og.XT.Og og2 = null;
        boolean zNextBoolean = false;
        com.bytedance.adsdk.Og.KZx.pA.ZZv zZv = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            int i2 = 1;
            switch (strNextName) {
                case "c":
                    pAVarSD = ZZv.SD(jsonReader, sd);
                    continue;
                    break;
                case "d":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        String strNextString2 = null;
                        com.bytedance.adsdk.Og.KZx.pA.Og ogPA2 = null;
                        while (jsonReader.hasNext()) {
                            String strNextName2 = jsonReader.nextName();
                            strNextName2.hashCode();
                            if (strNextName2.equals("n")) {
                                strNextString2 = jsonReader.nextString();
                            } else if (strNextName2.equals("v")) {
                                ogPA2 = ZZv.pA(jsonReader, sd);
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        jsonReader.endObject();
                        strNextString2.hashCode();
                        switch (strNextString2) {
                            case "d":
                            case "g":
                                i = 1;
                                sd.pA(true);
                                arrayList.add(ogPA2);
                                i2 = i;
                                break;
                            case "o":
                                og = ogPA2;
                                i2 = 1;
                                break;
                            default:
                                i = 1;
                                i2 = i;
                                break;
                        }
                    }
                    int i3 = i2;
                    jsonReader.endArray();
                    if (arrayList.size() != i3) {
                        break;
                    } else {
                        arrayList.add(arrayList.get(0));
                    }
                    break;
                case "o":
                    zZv = ZZv.Og(jsonReader, sd);
                    continue;
                    break;
                case "w":
                    ogPA = ZZv.pA(jsonReader, sd);
                    continue;
                    break;
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    continue;
                    break;
                case "lc":
                    pAVar = com.bytedance.adsdk.Og.KZx.Og.XT.pA.values()[jsonReader.nextInt() - 1];
                    continue;
                    break;
                case "lj":
                    og2 = com.bytedance.adsdk.Og.KZx.Og.XT.Og.values()[jsonReader.nextInt() - 1];
                    continue;
                    break;
                case "ml":
                    fNextDouble = (float) jsonReader.nextDouble();
                    continue;
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    continue;
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        if (zZv == null) {
            zZv = new com.bytedance.adsdk.Og.KZx.pA.ZZv(Collections.singletonList(new com.bytedance.adsdk.Og.SD.pA(100)));
        }
        return new com.bytedance.adsdk.Og.KZx.Og.XT(strNextString, og, arrayList, pAVarSD, zZv, ogPA, pAVar, og2, fNextDouble, zNextBoolean);
    }
}
