package com.bytedance.adsdk.Og.ML;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.SparseArray;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes11.dex */
class vZF {
    private static SparseArray<WeakReference<Interpolator>> Og;
    private static final Interpolator pA = new LinearInterpolator();

    vZF() {
    }

    private static SparseArray<WeakReference<Interpolator>> pA() {
        if (Og == null) {
            Og = new SparseArray<>();
        }
        return Og;
    }

    private static WeakReference<Interpolator> pA(int i) {
        WeakReference<Interpolator> weakReference;
        synchronized (vZF.class) {
            weakReference = pA().get(i);
        }
        return weakReference;
    }

    private static void pA(int i, WeakReference<Interpolator> weakReference) {
        synchronized (vZF.class) {
            Og.put(i, weakReference);
        }
    }

    static <T> com.bytedance.adsdk.Og.SD.pA<T> pA(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd, float f, HSv<T> hSv, boolean z, boolean z2) throws IOException {
        if (z && z2) {
            return Og(sd, jsonReader, f, hSv);
        }
        if (z) {
            return pA(sd, jsonReader, f, hSv);
        }
        return pA(jsonReader, f, hSv);
    }

    private static <T> com.bytedance.adsdk.Og.SD.pA<T> pA(com.bytedance.adsdk.Og.SD sd, JsonReader jsonReader, float f, HSv<T> hSv) throws IOException {
        Interpolator interpolatorPA;
        jsonReader.beginObject();
        PointF pointFOg = null;
        T tOg = null;
        T tOg2 = null;
        PointF pointFOg2 = null;
        PointF pointFOg3 = null;
        float fNextDouble = 0.0f;
        boolean z = false;
        PointF pointFOg4 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "e":
                    tOg = hSv.Og(jsonReader, f);
                    break;
                case "h":
                    if (jsonReader.nextInt() != 1) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                    break;
                case "i":
                    pointFOg4 = yFO.Og(jsonReader, 1.0f);
                    break;
                case "o":
                    pointFOg = yFO.Og(jsonReader, 1.0f);
                    break;
                case "s":
                    tOg2 = hSv.Og(jsonReader, f);
                    break;
                case "t":
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case "ti":
                    pointFOg3 = yFO.Og(jsonReader, f);
                    break;
                case "to":
                    pointFOg2 = yFO.Og(jsonReader, f);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (!z) {
            if (pointFOg != null && pointFOg4 != null) {
                interpolatorPA = pA(pointFOg, pointFOg4);
            }
            com.bytedance.adsdk.Og.SD.pA<T> pAVar = new com.bytedance.adsdk.Og.SD.pA<>(sd, tOg2, tOg, interpolatorPA, fNextDouble, null);
            pAVar.omh = pointFOg2;
            pAVar.Bzk = pointFOg3;
            return pAVar;
        }
        tOg = tOg2;
        interpolatorPA = pA;
        com.bytedance.adsdk.Og.SD.pA<T> pAVar2 = new com.bytedance.adsdk.Og.SD.pA<>(sd, tOg2, tOg, interpolatorPA, fNextDouble, null);
        pAVar2.omh = pointFOg2;
        pAVar2.Bzk = pointFOg3;
        return pAVar2;
    }

    /* JADX WARN: Code duplicated, block: B:130:0x0273  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static <T> com.bytedance.adsdk.Og.SD.pA<T> Og(com.bytedance.adsdk.Og.SD sd, JsonReader jsonReader, float f, HSv<T> hSv) throws IOException {
        Interpolator interpolatorPA;
        Interpolator interpolatorPA2;
        T t;
        Interpolator interpolatorPA3;
        com.bytedance.adsdk.Og.SD.pA<T> pAVar;
        float f2;
        PointF pointF;
        PointF pointF2;
        T t2;
        String str;
        String str2;
        jsonReader.beginObject();
        PointF pointFOg = null;
        boolean z = false;
        PointF pointFOg2 = null;
        PointF pointFOg3 = null;
        PointF pointF3 = null;
        T tOg = null;
        PointF pointF4 = null;
        PointF pointF5 = null;
        PointF pointF6 = null;
        float fNextDouble = 0.0f;
        PointF pointFOg4 = null;
        T tOg2 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            byte b = -1;
            switch (strNextName.hashCode()) {
                case 101:
                    if (strNextName.equals("e")) {
                        b = 0;
                    }
                    break;
                case 104:
                    if (strNextName.equals("h")) {
                        b = 1;
                    }
                    break;
                case 105:
                    if (strNextName.equals("i")) {
                        b = 2;
                    }
                    break;
                case 111:
                    if (strNextName.equals("o")) {
                        b = 3;
                    }
                    break;
                case 115:
                    if (strNextName.equals("s")) {
                        b = 4;
                    }
                    break;
                case 116:
                    if (strNextName.equals(ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP)) {
                        b = 5;
                    }
                    break;
                case 3701:
                    if (strNextName.equals("ti")) {
                        b = 6;
                    }
                    break;
                case 3707:
                    if (strNextName.equals("to")) {
                        b = 7;
                    }
                    break;
            }
            String str3 = VastAttributes.VERTICAL_POSITION;
            String str4 = VastAttributes.HORIZONTAL_POSITION;
            switch (b) {
                case 0:
                    f2 = fNextDouble;
                    tOg2 = hSv.Og(jsonReader, f);
                    fNextDouble = f2;
                    break;
                case 1:
                    pointF = pointFOg;
                    f2 = fNextDouble;
                    pointF2 = pointFOg4;
                    t2 = tOg;
                    z = jsonReader.nextInt() == 1;
                    tOg = t2;
                    pointFOg4 = pointF2;
                    pointFOg = pointF;
                    fNextDouble = f2;
                    break;
                case 2:
                    pointF = pointFOg;
                    f2 = fNextDouble;
                    pointF2 = pointFOg4;
                    t2 = tOg;
                    if (jsonReader.peek() == JsonToken.BEGIN_OBJECT) {
                        jsonReader.beginObject();
                        float fNextDouble2 = 0.0f;
                        float fNextDouble3 = 0.0f;
                        float fNextDouble4 = 0.0f;
                        float fNextDouble5 = 0.0f;
                        while (jsonReader.hasNext()) {
                            String strNextName2 = jsonReader.nextName();
                            strNextName2.hashCode();
                            if (strNextName2.equals(str4)) {
                                str = str3;
                                str2 = str4;
                                if (jsonReader.peek() == JsonToken.NUMBER) {
                                    fNextDouble4 = (float) jsonReader.nextDouble();
                                    fNextDouble2 = fNextDouble4;
                                } else {
                                    jsonReader.beginArray();
                                    fNextDouble2 = (float) jsonReader.nextDouble();
                                    fNextDouble4 = jsonReader.peek() == JsonToken.NUMBER ? (float) jsonReader.nextDouble() : fNextDouble2;
                                    jsonReader.endArray();
                                }
                            } else if (strNextName2.equals(str3)) {
                                if (jsonReader.peek() == JsonToken.NUMBER) {
                                    str = str3;
                                    str2 = str4;
                                    fNextDouble5 = (float) jsonReader.nextDouble();
                                    fNextDouble3 = fNextDouble5;
                                } else {
                                    str = str3;
                                    str2 = str4;
                                    jsonReader.beginArray();
                                    fNextDouble3 = (float) jsonReader.nextDouble();
                                    fNextDouble5 = jsonReader.peek() == JsonToken.NUMBER ? (float) jsonReader.nextDouble() : fNextDouble3;
                                    jsonReader.endArray();
                                }
                            } else {
                                jsonReader.skipValue();
                            }
                            str3 = str;
                            str4 = str2;
                        }
                        PointF pointF7 = new PointF(fNextDouble2, fNextDouble3);
                        PointF pointF8 = new PointF(fNextDouble4, fNextDouble5);
                        jsonReader.endObject();
                        pointF6 = pointF8;
                        pointF5 = pointF7;
                    } else {
                        pointFOg3 = yFO.Og(jsonReader, f);
                    }
                    tOg = t2;
                    pointFOg4 = pointF2;
                    pointFOg = pointF;
                    fNextDouble = f2;
                    break;
                case 3:
                    pointF2 = pointFOg4;
                    pointF = pointFOg;
                    if (jsonReader.peek() == JsonToken.BEGIN_OBJECT) {
                        jsonReader.beginObject();
                        float fNextDouble6 = 0.0f;
                        float fNextDouble7 = 0.0f;
                        float fNextDouble8 = 0.0f;
                        float fNextDouble9 = 0.0f;
                        while (jsonReader.hasNext()) {
                            float f3 = fNextDouble;
                            String strNextName3 = jsonReader.nextName();
                            strNextName3.hashCode();
                            if (strNextName3.equals(VastAttributes.HORIZONTAL_POSITION)) {
                                if (jsonReader.peek() == JsonToken.NUMBER) {
                                    fNextDouble8 = (float) jsonReader.nextDouble();
                                    fNextDouble6 = fNextDouble8;
                                } else {
                                    jsonReader.beginArray();
                                    fNextDouble6 = (float) jsonReader.nextDouble();
                                    fNextDouble8 = jsonReader.peek() == JsonToken.NUMBER ? (float) jsonReader.nextDouble() : fNextDouble6;
                                    jsonReader.endArray();
                                }
                                tOg = tOg;
                            } else if (strNextName3.equals(VastAttributes.VERTICAL_POSITION)) {
                                if (jsonReader.peek() == JsonToken.NUMBER) {
                                    fNextDouble9 = (float) jsonReader.nextDouble();
                                    fNextDouble7 = fNextDouble9;
                                } else {
                                    jsonReader.beginArray();
                                    fNextDouble7 = (float) jsonReader.nextDouble();
                                    fNextDouble9 = jsonReader.peek() == JsonToken.NUMBER ? (float) jsonReader.nextDouble() : fNextDouble7;
                                    jsonReader.endArray();
                                }
                            } else {
                                jsonReader.skipValue();
                            }
                            fNextDouble = f3;
                        }
                        f2 = fNextDouble;
                        PointF pointF9 = new PointF(fNextDouble6, fNextDouble7);
                        PointF pointF10 = new PointF(fNextDouble8, fNextDouble9);
                        jsonReader.endObject();
                        pointF4 = pointF10;
                        pointF3 = pointF9;
                    } else {
                        f2 = fNextDouble;
                        pointFOg2 = yFO.Og(jsonReader, f);
                    }
                    pointFOg4 = pointF2;
                    pointFOg = pointF;
                    fNextDouble = f2;
                    break;
                case 4:
                    tOg = hSv.Og(jsonReader, f);
                    break;
                case 5:
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case 6:
                    pointFOg = yFO.Og(jsonReader, f);
                    break;
                case 7:
                    pointFOg4 = yFO.Og(jsonReader, f);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        PointF pointF11 = pointFOg;
        float f4 = fNextDouble;
        PointF pointF12 = pointFOg4;
        T t3 = tOg;
        jsonReader.endObject();
        if (!z) {
            if (pointFOg2 != null && pointFOg3 != null) {
                interpolatorPA3 = pA(pointFOg2, pointFOg3);
                t = tOg2;
                interpolatorPA = null;
                interpolatorPA2 = null;
            } else if (pointF3 != null && pointF4 != null && pointF5 != null && pointF6 != null) {
                interpolatorPA = pA(pointF3, pointF5);
                interpolatorPA2 = pA(pointF4, pointF6);
                t = tOg2;
                interpolatorPA3 = null;
            }
            if (interpolatorPA == null && interpolatorPA2 != null) {
                pAVar = new com.bytedance.adsdk.Og.SD.pA<>(sd, t3, t, interpolatorPA, interpolatorPA2, f4, null);
            } else {
                pAVar = new com.bytedance.adsdk.Og.SD.pA<>(sd, t3, t, interpolatorPA3, f4, null);
            }
            pAVar.omh = pointF12;
            pAVar.Bzk = pointF11;
            return pAVar;
        }
        tOg2 = t3;
        interpolatorPA3 = pA;
        t = tOg2;
        interpolatorPA = null;
        interpolatorPA2 = null;
        if (interpolatorPA == null) {
            pAVar = new com.bytedance.adsdk.Og.SD.pA<>(sd, t3, t, interpolatorPA3, f4, null);
        } else {
            pAVar = new com.bytedance.adsdk.Og.SD.pA<>(sd, t3, t, interpolatorPA3, f4, null);
        }
        pAVar.omh = pointF12;
        pAVar.Bzk = pointF11;
        return pAVar;
    }

    private static Interpolator pA(PointF pointF, PointF pointF2) {
        Interpolator linearInterpolator;
        pointF.x = com.bytedance.adsdk.Og.JG.ML.Og(pointF.x, -1.0f, 1.0f);
        pointF.y = com.bytedance.adsdk.Og.JG.ML.Og(pointF.y, -100.0f, 100.0f);
        pointF2.x = com.bytedance.adsdk.Og.JG.ML.Og(pointF2.x, -1.0f, 1.0f);
        pointF2.y = com.bytedance.adsdk.Og.JG.ML.Og(pointF2.y, -100.0f, 100.0f);
        int iPA = com.bytedance.adsdk.Og.JG.JG.pA(pointF.x, pointF.y, pointF2.x, pointF2.y);
        WeakReference<Interpolator> weakReferencePA = com.bytedance.adsdk.Og.ML.pA() ? null : pA(iPA);
        Interpolator interpolator = weakReferencePA != null ? weakReferencePA.get() : null;
        if (weakReferencePA == null || interpolator == null) {
            try {
                linearInterpolator = com.bytedance.adsdk.Og.aBv.pA(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e) {
                if ("The Path cannot loop back on itself.".equals(e.getMessage())) {
                    linearInterpolator = com.bytedance.adsdk.Og.aBv.pA(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
                } else {
                    linearInterpolator = new LinearInterpolator();
                }
            }
            interpolator = linearInterpolator;
            if (!com.bytedance.adsdk.Og.ML.pA()) {
                try {
                    pA(iPA, (WeakReference<Interpolator>) new WeakReference(interpolator));
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
            }
        }
        return interpolator;
    }

    private static <T> com.bytedance.adsdk.Og.SD.pA<T> pA(JsonReader jsonReader, float f, HSv<T> hSv) throws IOException {
        return new com.bytedance.adsdk.Og.SD.pA<>(hSv.Og(jsonReader, f));
    }
}
