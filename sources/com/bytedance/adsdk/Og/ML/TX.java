package com.bytedance.adsdk.Og.ML;

import android.util.JsonReader;
import android.util.JsonToken;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
class TX {
    static <T> List<com.bytedance.adsdk.Og.SD.pA<T>> pA(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd, float f, HSv<T> hSv, boolean z) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.STRING) {
            sd.pA("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals(CampaignEx.JSON_KEY_AD_K)) {
                if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                    jsonReader.beginArray();
                    if (jsonReader.peek() == JsonToken.NUMBER) {
                        arrayList.add(vZF.pA(jsonReader, sd, f, hSv, false, z));
                    } else {
                        while (jsonReader.hasNext()) {
                            arrayList.add(vZF.pA(jsonReader, sd, f, hSv, true, z));
                        }
                    }
                    jsonReader.endArray();
                } else {
                    arrayList.add(vZF.pA(jsonReader, sd, f, hSv, false, z));
                }
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        pA(arrayList);
        return arrayList;
    }

    public static <T> void pA(List<? extends com.bytedance.adsdk.Og.SD.pA<T>> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            com.bytedance.adsdk.Og.SD.pA<T> pAVar = list.get(i2);
            i2++;
            com.bytedance.adsdk.Og.SD.pA<T> pAVar2 = list.get(i2);
            pAVar.SD = Float.valueOf(pAVar2.JG);
            if (pAVar.Og == null && pAVar2.pA != null) {
                pAVar.Og = pAVar2.pA;
                if (pAVar instanceof com.bytedance.adsdk.Og.pA.Og.Bzk) {
                    ((com.bytedance.adsdk.Og.pA.Og.Bzk) pAVar).pA();
                }
            }
        }
        com.bytedance.adsdk.Og.SD.pA<T> pAVar3 = list.get(i);
        if ((pAVar3.pA == null || pAVar3.Og == null) && list.size() > 1) {
            list.remove(pAVar3);
        }
    }
}
