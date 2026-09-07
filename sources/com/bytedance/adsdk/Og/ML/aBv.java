package com.bytedance.adsdk.Og.ML;

import android.util.JsonReader;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.google.common.base.Ascii;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes12.dex */
class aBv {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    static com.bytedance.adsdk.Og.KZx.Og.JG pA(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd) throws IOException {
        byte b;
        com.bytedance.adsdk.Og.KZx.Og.XT.pA pAVar;
        com.bytedance.adsdk.Og.KZx.Og.XT.Og og;
        ArrayList arrayList = new ArrayList();
        float fNextDouble = 0.0f;
        String strNextString = null;
        com.bytedance.adsdk.Og.KZx.Og.SD sd2 = null;
        com.bytedance.adsdk.Og.KZx.pA.KZx kZxPA = null;
        com.bytedance.adsdk.Og.KZx.pA.JG jgKZx = null;
        com.bytedance.adsdk.Og.KZx.pA.JG jgKZx2 = null;
        com.bytedance.adsdk.Og.KZx.pA.Og ogPA = null;
        com.bytedance.adsdk.Og.KZx.Og.XT.pA pAVar2 = null;
        com.bytedance.adsdk.Og.KZx.Og.XT.Og og2 = null;
        com.bytedance.adsdk.Og.KZx.pA.Og og3 = null;
        boolean zNextBoolean = false;
        com.bytedance.adsdk.Og.KZx.pA.ZZv zZv = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            zNextBoolean = zNextBoolean;
            com.bytedance.adsdk.Og.KZx.pA.Og og4 = og3;
            float f = fNextDouble;
            switch (strNextName.hashCode()) {
                case 100:
                    b = !strNextName.equals("d") ? (byte) -1 : (byte) 0;
                    break;
                case 101:
                    b = !strNextName.equals("e") ? (byte) -1 : (byte) 1;
                    break;
                case 103:
                    b = !strNextName.equals("g") ? (byte) -1 : (byte) 2;
                    break;
                case 111:
                    b = !strNextName.equals("o") ? (byte) -1 : (byte) 3;
                    break;
                case 115:
                    b = !strNextName.equals("s") ? (byte) -1 : (byte) 4;
                    break;
                case 116:
                    b = !strNextName.equals(ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP) ? (byte) -1 : (byte) 5;
                    break;
                case JSON_ENCODE_ERROR_VALUE:
                    b = !strNextName.equals("w") ? (byte) -1 : (byte) 6;
                    break;
                case 3324:
                    b = !strNextName.equals("hd") ? (byte) -1 : (byte) 7;
                    break;
                case 3447:
                    b = !strNextName.equals("lc") ? (byte) -1 : (byte) 8;
                    break;
                case 3454:
                    b = !strNextName.equals("lj") ? (byte) -1 : (byte) 9;
                    break;
                case 3487:
                    b = !strNextName.equals("ml") ? (byte) -1 : (byte) 10;
                    break;
                case 3519:
                    b = !strNextName.equals("nm") ? (byte) -1 : Ascii.VT;
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        String strNextString2 = null;
                        com.bytedance.adsdk.Og.KZx.pA.Og ogPA2 = null;
                        while (jsonReader.hasNext()) {
                            com.bytedance.adsdk.Og.KZx.Og.XT.Og og5 = og2;
                            String strNextName2 = jsonReader.nextName();
                            strNextName2.hashCode();
                            com.bytedance.adsdk.Og.KZx.Og.XT.pA pAVar3 = pAVar2;
                            if (strNextName2.equals("n")) {
                                strNextString2 = jsonReader.nextString();
                            } else if (strNextName2.equals("v")) {
                                ogPA2 = ZZv.pA(jsonReader, sd);
                            } else {
                                jsonReader.skipValue();
                            }
                            og2 = og5;
                            pAVar2 = pAVar3;
                        }
                        pAVar2 = pAVar2;
                        og2 = og2;
                        jsonReader.endObject();
                        if (strNextString2.equals("o")) {
                            og4 = ogPA2;
                        } else if (strNextString2.equals("d") || strNextString2.equals("g")) {
                            sd.pA(true);
                            arrayList.add(ogPA2);
                        }
                    }
                    pAVar = pAVar2;
                    og = og2;
                    jsonReader.endArray();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                        og3 = og4;
                    } else {
                        og3 = og4;
                    }
                    og2 = og;
                    fNextDouble = f;
                    pAVar2 = pAVar;
                    break;
                case 1:
                    jgKZx2 = ZZv.KZx(jsonReader, sd);
                    zNextBoolean = zNextBoolean;
                    og3 = og4;
                    fNextDouble = f;
                    break;
                case 2:
                    jsonReader.beginObject();
                    int iNextInt = -1;
                    while (jsonReader.hasNext()) {
                        String strNextName3 = jsonReader.nextName();
                        strNextName3.hashCode();
                        if (strNextName3.equals(CampaignEx.JSON_KEY_AD_K)) {
                            kZxPA = ZZv.pA(jsonReader, sd, iNextInt);
                        } else if (strNextName3.equals("p")) {
                            iNextInt = jsonReader.nextInt();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    zNextBoolean = zNextBoolean;
                    og3 = og4;
                    fNextDouble = f;
                    break;
                case 3:
                    zZv = ZZv.Og(jsonReader, sd);
                    zNextBoolean = zNextBoolean;
                    og3 = og4;
                    fNextDouble = f;
                    break;
                case 4:
                    jgKZx = ZZv.KZx(jsonReader, sd);
                    zNextBoolean = zNextBoolean;
                    og3 = og4;
                    fNextDouble = f;
                    break;
                case 5:
                    sd2 = jsonReader.nextInt() == 1 ? com.bytedance.adsdk.Og.KZx.Og.SD.LINEAR : com.bytedance.adsdk.Og.KZx.Og.SD.RADIAL;
                    zNextBoolean = zNextBoolean;
                    og3 = og4;
                    fNextDouble = f;
                    break;
                case 6:
                    ogPA = ZZv.pA(jsonReader, sd);
                    zNextBoolean = zNextBoolean;
                    og3 = og4;
                    fNextDouble = f;
                    break;
                case 7:
                    zNextBoolean = jsonReader.nextBoolean();
                    og3 = og4;
                    fNextDouble = f;
                    break;
                case 8:
                    pAVar2 = com.bytedance.adsdk.Og.KZx.Og.XT.pA.values()[jsonReader.nextInt() - 1];
                    zNextBoolean = zNextBoolean;
                    og3 = og4;
                    fNextDouble = f;
                    break;
                case 9:
                    og2 = com.bytedance.adsdk.Og.KZx.Og.XT.Og.values()[jsonReader.nextInt() - 1];
                    zNextBoolean = zNextBoolean;
                    og3 = og4;
                    fNextDouble = f;
                    break;
                case 10:
                    fNextDouble = (float) jsonReader.nextDouble();
                    zNextBoolean = zNextBoolean;
                    og3 = og4;
                    break;
                case 11:
                    strNextString = jsonReader.nextString();
                    zNextBoolean = zNextBoolean;
                    og3 = og4;
                    fNextDouble = f;
                    break;
                default:
                    jsonReader.skipValue();
                    pAVar = pAVar2;
                    og = og2;
                    og3 = og4;
                    og2 = og;
                    fNextDouble = f;
                    pAVar2 = pAVar;
                    break;
            }
        }
        com.bytedance.adsdk.Og.KZx.Og.XT.pA pAVar4 = pAVar2;
        com.bytedance.adsdk.Og.KZx.Og.XT.Og og6 = og2;
        float f2 = fNextDouble;
        com.bytedance.adsdk.Og.KZx.pA.Og og7 = og3;
        boolean z = zNextBoolean;
        if (zZv == null) {
            zZv = new com.bytedance.adsdk.Og.KZx.pA.ZZv(Collections.singletonList(new com.bytedance.adsdk.Og.SD.pA(100)));
        }
        return new com.bytedance.adsdk.Og.KZx.Og.JG(strNextString, sd2, kZxPA, zZv, jgKZx, jgKZx2, ogPA, pAVar4, og6, f2, arrayList, og7, z);
    }
}
