package com.bytedance.adsdk.Og.ML;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class gbA implements HSv<com.bytedance.adsdk.Og.KZx.Og.Sn> {
    public static final gbA pA = new gbA();

    private gbA() {
    }

    @Override // com.bytedance.adsdk.Og.ML.HSv
    /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.Og.KZx.Og.Sn Og(JsonReader jsonReader, float f) throws IOException {
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
        }
        jsonReader.beginObject();
        List<PointF> listPA = null;
        List<PointF> listPA2 = null;
        List<PointF> listPA3 = null;
        boolean zNextBoolean = false;
        while (true) {
            if (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                strNextName.hashCode();
                switch (strNextName) {
                    case "c":
                        zNextBoolean = jsonReader.nextBoolean();
                        break;
                    case "i":
                        listPA2 = yFO.pA(jsonReader, f);
                        break;
                    case "o":
                        listPA3 = yFO.pA(jsonReader, f);
                        break;
                    case "v":
                        listPA = yFO.pA(jsonReader, f);
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            } else {
                jsonReader.endObject();
                if (jsonReader.peek() == JsonToken.END_ARRAY) {
                    jsonReader.endArray();
                }
                if (listPA == null || listPA2 == null || listPA3 == null) {
                    throw new IllegalArgumentException("Shape data was missing information.");
                }
                if (listPA.isEmpty()) {
                    return new com.bytedance.adsdk.Og.KZx.Og.Sn(new PointF(), false, Collections.emptyList());
                }
                int size = listPA.size();
                PointF pointF = listPA.get(0);
                ArrayList arrayList = new ArrayList(size);
                for (int i = 1; i < size; i++) {
                    PointF pointF2 = listPA.get(i);
                    int i2 = i - 1;
                    arrayList.add(new com.bytedance.adsdk.Og.KZx.pA(com.bytedance.adsdk.Og.JG.ML.pA(listPA.get(i2), listPA3.get(i2)), com.bytedance.adsdk.Og.JG.ML.pA(pointF2, listPA2.get(i)), pointF2));
                }
                if (zNextBoolean) {
                    PointF pointF3 = listPA.get(0);
                    int i3 = size - 1;
                    arrayList.add(new com.bytedance.adsdk.Og.KZx.pA(com.bytedance.adsdk.Og.JG.ML.pA(listPA.get(i3), listPA3.get(i3)), com.bytedance.adsdk.Og.JG.ML.pA(pointF3, listPA2.get(0)), pointF3));
                }
                return new com.bytedance.adsdk.Og.KZx.Og.Sn(pointF, zNextBoolean, arrayList);
            }
        }
    }
}
