package com.bytedance.adsdk.Og.ML;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.JsonReader;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.google.common.base.Ascii;
import com.mbridge.msdk.foundation.entity.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes11.dex */
public class BF {
    public static com.bytedance.adsdk.Og.KZx.KZx.ML pA(com.bytedance.adsdk.Og.SD sd) {
        Rect rectZZv = sd.ZZv();
        return new com.bytedance.adsdk.Og.KZx.KZx.ML(Collections.emptyList(), sd, "__container", -1L, com.bytedance.adsdk.Og.KZx.KZx.ML.pA.PRE_COMP, -1L, null, Collections.emptyList(), new com.bytedance.adsdk.Og.KZx.pA.WV(), 0, 0, 0, 0.0f, 0.0f, rectZZv.width(), rectZZv.height(), null, null, Collections.emptyList(), com.bytedance.adsdk.Og.KZx.KZx.ML.Og.NONE, null, false, null, null);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static com.bytedance.adsdk.Og.KZx.KZx.ML pA(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd) throws IOException {
        com.bytedance.adsdk.Og.KZx.KZx.ML.Og og = com.bytedance.adsdk.Og.KZx.KZx.ML.Og.NONE;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        jsonReader.beginObject();
        Float fValueOf = Float.valueOf(0.0f);
        Float fValueOf2 = Float.valueOf(1.0f);
        com.bytedance.adsdk.Og.KZx.KZx.ML.Og og2 = og;
        com.bytedance.adsdk.Og.KZx.KZx.ML.pA pAVar = null;
        String strNextString = null;
        com.bytedance.adsdk.Og.KZx.pA.WV wvPA = null;
        com.bytedance.adsdk.Og.KZx.pA.SGo sGoJG = null;
        com.bytedance.adsdk.Og.KZx.pA.BSW bswPA = null;
        com.bytedance.adsdk.Og.KZx.pA.Og ogPA = null;
        com.bytedance.adsdk.Og.KZx.Og.pA pAVarPA = null;
        SGo sGoPA = null;
        long jNextInt = 0;
        int iNextInt = 0;
        int iNextInt2 = 0;
        int color = 0;
        boolean zNextBoolean = false;
        float fNextDouble = 0.0f;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        float fSD = 0.0f;
        long jNextInt2 = -1;
        float fNextDouble4 = 1.0f;
        String strNextString2 = "UNSET";
        String strNextString3 = null;
        float fNextDouble5 = 0.0f;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            byte b = -1;
            switch (strNextName.hashCode()) {
                case -995424086:
                    if (strNextName.equals("parent")) {
                        b = 0;
                    }
                    break;
                case -903568142:
                    if (strNextName.equals("shapes")) {
                        b = 1;
                    }
                    break;
                case 104:
                    if (strNextName.equals("h")) {
                        b = 2;
                    }
                    break;
                case 116:
                    if (strNextName.equals(ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP)) {
                        b = 3;
                    }
                    break;
                case JSON_ENCODE_ERROR_VALUE:
                    if (strNextName.equals("w")) {
                        b = 4;
                    }
                    break;
                case 3177:
                    if (strNextName.equals("cl")) {
                        b = 5;
                    }
                    break;
                case 3233:
                    if (strNextName.equals("ef")) {
                        b = 6;
                    }
                    break;
                case 3324:
                    if (strNextName.equals("hd")) {
                        b = 7;
                    }
                    break;
                case 3367:
                    if (strNextName.equals("ip")) {
                        b = 8;
                    }
                    break;
                case 3432:
                    if (strNextName.equals("ks")) {
                        b = 9;
                    }
                    break;
                case 3519:
                    if (strNextName.equals("nm")) {
                        b = 10;
                    }
                    break;
                case 3553:
                    if (strNextName.equals("op")) {
                        b = Ascii.VT;
                    }
                    break;
                case 3664:
                    if (strNextName.equals("sc")) {
                        b = Ascii.FF;
                    }
                    break;
                case 3669:
                    if (strNextName.equals(b.JSON_KEY_SH)) {
                        b = Ascii.CR;
                    }
                    break;
                case 3679:
                    if (strNextName.equals("sr")) {
                        b = Ascii.SO;
                    }
                    break;
                case 3681:
                    if (strNextName.equals("st")) {
                        b = Ascii.SI;
                    }
                    break;
                case 3684:
                    if (strNextName.equals("sw")) {
                        b = Ascii.DLE;
                    }
                    break;
                case 3705:
                    if (strNextName.equals("tm")) {
                        b = 17;
                    }
                    break;
                case 3712:
                    if (strNextName.equals("tt")) {
                        b = Ascii.DC2;
                    }
                    break;
                case 3717:
                    if (strNextName.equals("ty")) {
                        b = 19;
                    }
                    break;
                case 104415:
                    if (strNextName.equals("ind")) {
                        b = Ascii.DC4;
                    }
                    break;
                case 108390670:
                    if (strNextName.equals("refId")) {
                        b = Ascii.NAK;
                    }
                    break;
                case 1441620890:
                    if (strNextName.equals("masksProperties")) {
                        b = Ascii.SYN;
                    }
                    break;
            }
            switch (b) {
                case 0:
                    jNextInt2 = jsonReader.nextInt();
                    break;
                case 1:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        com.bytedance.adsdk.Og.KZx.Og.KZx kZxPA = omh.pA(jsonReader, sd);
                        if (kZxPA != null) {
                            arrayList2.add(kZxPA);
                        }
                    }
                    jsonReader.endArray();
                    break;
                case 2:
                    fNextDouble3 = (float) (jsonReader.nextDouble() * ((double) com.bytedance.adsdk.Og.JG.JG.pA()));
                    break;
                case 3:
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.hashCode();
                        if (strNextName2.equals("a")) {
                            jsonReader.beginArray();
                            if (jsonReader.hasNext()) {
                                bswPA = Og.pA(jsonReader, sd);
                            }
                            while (jsonReader.hasNext()) {
                                jsonReader.skipValue();
                            }
                            jsonReader.endArray();
                        } else if (strNextName2.equals("d")) {
                            sGoJG = ZZv.JG(jsonReader, sd);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case 4:
                    fNextDouble2 = (float) (jsonReader.nextDouble() * ((double) com.bytedance.adsdk.Og.JG.JG.pA()));
                    break;
                case 5:
                    strNextString3 = jsonReader.nextString();
                    break;
                case 6:
                    jsonReader.beginArray();
                    ArrayList arrayList3 = new ArrayList();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String strNextName3 = jsonReader.nextName();
                            strNextName3.hashCode();
                            if (strNextName3.equals("nm")) {
                                arrayList3.add(jsonReader.nextString());
                            } else if (strNextName3.equals("ty")) {
                                int iNextInt3 = jsonReader.nextInt();
                                if (iNextInt3 == 29) {
                                    pAVarPA = ML.pA(jsonReader, sd);
                                } else if (iNextInt3 == 25) {
                                    sGoPA = new BSW().pA(jsonReader, sd);
                                }
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        jsonReader.endObject();
                    }
                    jsonReader.endArray();
                    sd.pA("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: ".concat(String.valueOf(arrayList3)));
                    break;
                case 7:
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case 8:
                    fNextDouble5 = (float) jsonReader.nextDouble();
                    break;
                case 9:
                    wvPA = KZx.pA(jsonReader, sd);
                    break;
                case 10:
                    strNextString2 = jsonReader.nextString();
                    break;
                case 11:
                    fSD = (float) jsonReader.nextDouble();
                    break;
                case 12:
                    color = Color.parseColor(jsonReader.nextString());
                    break;
                case 13:
                    iNextInt2 = (int) (jsonReader.nextInt() * com.bytedance.adsdk.Og.JG.JG.pA());
                    break;
                case 14:
                    fNextDouble4 = (float) jsonReader.nextDouble();
                    break;
                case 15:
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case 16:
                    iNextInt = (int) (jsonReader.nextInt() * com.bytedance.adsdk.Og.JG.JG.pA());
                    break;
                case 17:
                    ogPA = ZZv.pA(jsonReader, sd, false);
                    break;
                case 18:
                    int iNextInt4 = jsonReader.nextInt();
                    if (iNextInt4 >= com.bytedance.adsdk.Og.KZx.KZx.ML.Og.values().length) {
                        sd.pA("Unsupported matte type: ".concat(String.valueOf(iNextInt4)));
                    } else {
                        og2 = com.bytedance.adsdk.Og.KZx.KZx.ML.Og.values()[iNextInt4];
                        int i = AnonymousClass1.pA[og2.ordinal()];
                        if (i == 1) {
                            sd.pA("Unsupported matte type: Luma");
                        } else if (i == 2) {
                            sd.pA("Unsupported matte type: Luma Inverted");
                        }
                        sd.pA(1);
                    }
                    break;
                case 19:
                    int iNextInt5 = jsonReader.nextInt();
                    if (iNextInt5 < com.bytedance.adsdk.Og.KZx.KZx.ML.pA.UNKNOWN.ordinal()) {
                        pAVar = com.bytedance.adsdk.Og.KZx.KZx.ML.pA.values()[iNextInt5];
                    } else {
                        pAVar = com.bytedance.adsdk.Og.KZx.KZx.ML.pA.UNKNOWN;
                    }
                    break;
                case 20:
                    jNextInt = jsonReader.nextInt();
                    break;
                case 21:
                    strNextString = jsonReader.nextString();
                    break;
                case 22:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        arrayList.add(TV.pA(jsonReader, sd));
                    }
                    sd.pA(arrayList.size());
                    jsonReader.endArray();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        ArrayList arrayList4 = new ArrayList();
        if (fNextDouble5 > 0.0f) {
            arrayList4.add(new com.bytedance.adsdk.Og.SD.pA(sd, fValueOf, fValueOf, null, 0.0f, Float.valueOf(fNextDouble5)));
        }
        if (fSD <= 0.0f) {
            fSD = sd.SD();
        }
        arrayList4.add(new com.bytedance.adsdk.Og.SD.pA(sd, fValueOf2, fValueOf2, null, fNextDouble5, Float.valueOf(fSD)));
        arrayList4.add(new com.bytedance.adsdk.Og.SD.pA(sd, fValueOf, fValueOf, null, fSD, Float.valueOf(Float.MAX_VALUE)));
        if (strNextString2.endsWith(".ai") || "ai".equals(strNextString3)) {
            sd.pA("Convert your Illustrator layers to shape layers.");
        }
        return new com.bytedance.adsdk.Og.KZx.KZx.ML(arrayList2, sd, strNextString2, jNextInt, pAVar, jNextInt2, strNextString, arrayList, wvPA, iNextInt, iNextInt2, color, fNextDouble4, fNextDouble, fNextDouble2, fNextDouble3, sGoJG, bswPA, arrayList4, og2, ogPA, zNextBoolean, pAVarPA, sGoPA);
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.Og.ML.BF$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] pA;

        static {
            int[] iArr = new int[com.bytedance.adsdk.Og.KZx.KZx.ML.Og.values().length];
            pA = iArr;
            try {
                iArr[com.bytedance.adsdk.Og.KZx.KZx.ML.Og.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                pA[com.bytedance.adsdk.Og.KZx.KZx.ML.Og.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
