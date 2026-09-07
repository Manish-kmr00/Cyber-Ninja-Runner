package com.bytedance.adsdk.Og.ML;

import android.graphics.Rect;
import android.util.JsonReader;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.google.common.base.Ascii;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import com.smaato.sdk.core.dns.DnsName;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class WQf {
    public static com.bytedance.adsdk.Og.SD pA(JsonReader jsonReader) throws IOException {
        int i;
        byte b;
        float fPA = com.bytedance.adsdk.Og.JG.JG.pA();
        LongSparseArray<com.bytedance.adsdk.Og.KZx.KZx.ML> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        SparseArray<com.bytedance.adsdk.Og.KZx.ZZv> sparseArray = new SparseArray<>();
        com.bytedance.adsdk.Og.SD.KZx kZx = new com.bytedance.adsdk.Og.SD.KZx();
        com.bytedance.adsdk.Og.SD.pA pAVar = new com.bytedance.adsdk.Og.SD.pA();
        com.bytedance.adsdk.Og.SD.Og og = new com.bytedance.adsdk.Og.SD.Og();
        com.bytedance.adsdk.Og.SD sd = new com.bytedance.adsdk.Og.SD();
        jsonReader.beginObject();
        float fNextDouble = 0.0f;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        String strNextString = null;
        int iNextInt = 0;
        int iNextInt2 = 0;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            byte b2 = -1;
            switch (strNextName.hashCode()) {
                case -1408207997:
                    i = iNextInt2;
                    if (strNextName.equals(POBNativeConstants.NATIVE_ASSETS)) {
                        b2 = 0;
                    }
                    break;
                case -1109732030:
                    i = iNextInt2;
                    if (strNextName.equals("layers")) {
                        b2 = 1;
                    }
                    break;
                case -865448777:
                    i = iNextInt2;
                    if (strNextName.equals("globalEvent")) {
                        b2 = 2;
                    }
                    break;
                case 104:
                    i = iNextInt2;
                    if (strNextName.equals("h")) {
                        b = 3;
                        b2 = b;
                    }
                    break;
                case PROTOBUF_SERIALIZATION_ERROR_VALUE:
                    i = iNextInt2;
                    if (strNextName.equals("v")) {
                        b = 4;
                        b2 = b;
                    }
                    break;
                case JSON_ENCODE_ERROR_VALUE:
                    i = iNextInt2;
                    if (strNextName.equals("w")) {
                        b = 5;
                        b2 = b;
                    }
                    break;
                case 3208:
                    i = iNextInt2;
                    if (strNextName.equals("dl")) {
                        b = 6;
                        b2 = b;
                    }
                    break;
                case 3276:
                    i = iNextInt2;
                    if (strNextName.equals("fr")) {
                        b = 7;
                        b2 = b;
                    }
                    break;
                case 3292:
                    i = iNextInt2;
                    if (strNextName.equals("gc")) {
                        b = 8;
                        b2 = b;
                    }
                    break;
                case 3367:
                    i = iNextInt2;
                    if (strNextName.equals("ip")) {
                        b = 9;
                        b2 = b;
                    }
                    break;
                case 3553:
                    i = iNextInt2;
                    if (strNextName.equals("op")) {
                        b = 10;
                        b2 = b;
                    }
                    break;
                case 94623709:
                    i = iNextInt2;
                    if (strNextName.equals("chars")) {
                        b = Ascii.VT;
                        b2 = b;
                    }
                    break;
                case 97615364:
                    i = iNextInt2;
                    if (strNextName.equals("fonts")) {
                        b = Ascii.FF;
                        b2 = b;
                    }
                    break;
                case 110364485:
                    i = iNextInt2;
                    if (strNextName.equals("timer")) {
                        b = Ascii.CR;
                        b2 = b;
                    }
                    break;
                case 839250809:
                    i = iNextInt2;
                    if (strNextName.equals("markers")) {
                        b = Ascii.SO;
                        b2 = b;
                    }
                    break;
                default:
                    i = iNextInt2;
                    break;
            }
            switch (b2) {
                case 0:
                    pA(jsonReader, sd, map, map2);
                    break;
                case 1:
                    pA(jsonReader, sd, arrayList, longSparseArray);
                    break;
                case 2:
                    pA(jsonReader, og);
                    break;
                case 3:
                    iNextInt2 = jsonReader.nextInt();
                    continue;
                case 4:
                    String[] strArrSplit = jsonReader.nextString().split(DnsName.ESCAPED_DOT);
                    if (!com.bytedance.adsdk.Og.JG.JG.pA(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), 4, 4, 0)) {
                        sd.pA("Lottie only supports bodymovin >= 4.4.0");
                    }
                    break;
                case 5:
                    iNextInt = jsonReader.nextInt();
                    break;
                case 6:
                    strNextString = jsonReader.nextString();
                    break;
                case 7:
                    fNextDouble3 = (float) jsonReader.nextDouble();
                    break;
                case 8:
                    pA(jsonReader, pAVar);
                    break;
                case 9:
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case 10:
                    fNextDouble2 = ((float) jsonReader.nextDouble()) - 0.01f;
                    break;
                case 11:
                    pA(jsonReader, sd, sparseArray);
                    break;
                case 12:
                    pA(jsonReader, map3);
                    break;
                case 13:
                    pA(jsonReader, kZx);
                    break;
                case 14:
                    pA(jsonReader, arrayList2);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
            iNextInt2 = i;
        }
        jsonReader.endObject();
        sd.pA(new Rect(0, 0, (int) (iNextInt * fPA), (int) (iNextInt2 * fPA)), fNextDouble, fNextDouble2, fNextDouble3, arrayList, longSparseArray, map, map2, sparseArray, map3, arrayList2, kZx, strNextString, pAVar, og);
        return sd;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0042  */
    private static void pA(JsonReader jsonReader, com.bytedance.adsdk.Og.SD.Og og) {
        byte b;
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                int iHashCode = strNextName.hashCode();
                if (iHashCode != 3239) {
                    if (iHashCode != 107027) {
                        if (iHashCode == 3237004 && strNextName.equals("inel")) {
                            b = 0;
                        } else {
                            b = -1;
                        }
                    } else if (strNextName.equals("lel")) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                } else if (strNextName.equals("el")) {
                    b = 1;
                } else {
                    b = -1;
                }
                if (b == 0) {
                    og.Og = new int[][]{new int[]{-1, -1}};
                    jsonReader.beginArray();
                    if (jsonReader.hasNext()) {
                        jsonReader.beginArray();
                        for (int i = 0; i < 2; i++) {
                            if (jsonReader.hasNext()) {
                                og.Og[0][i] = jsonReader.nextInt();
                            }
                        }
                        jsonReader.endArray();
                    }
                    jsonReader.endArray();
                } else if (b == 1) {
                    og.pA = jsonReader.nextString();
                } else if (b == 2) {
                    og.KZx = KZx(jsonReader);
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    private static void pA(JsonReader jsonReader, com.bytedance.adsdk.Og.SD.pA pAVar) {
        byte b;
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                int iHashCode = strNextName.hashCode();
                if (iHashCode != 3139) {
                    if (iHashCode != 3232) {
                        if (iHashCode != 3571) {
                            if (iHashCode != 3666) {
                                if (iHashCode == 98713 && strNextName.equals("cpf")) {
                                    b = 4;
                                } else {
                                    b = -1;
                                }
                            } else if (strNextName.equals("se")) {
                                b = 0;
                            } else {
                                b = -1;
                            }
                        } else if (strNextName.equals(ApsMetricsDataMap.APSMETRICS_FIELD_PLATFORMCATEGORY)) {
                            b = 3;
                        } else {
                            b = -1;
                        }
                    } else if (strNextName.equals("ee")) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                } else if (strNextName.equals(ApsMetricsDataMap.APSMETRICS_FIELD_BIDEVENT)) {
                    b = 1;
                } else {
                    b = -1;
                }
                if (b == 0) {
                    pAVar.pA = jsonReader.nextInt();
                } else if (b == 1) {
                    pAVar.Og = Og(jsonReader);
                } else if (b == 2) {
                    pAVar.KZx = Og(jsonReader);
                } else if (b == 3) {
                    pAVar.ZZv = jsonReader.nextInt();
                } else if (b == 4) {
                    Og(jsonReader, pAVar);
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x003f  */
    private static void Og(JsonReader jsonReader, com.bytedance.adsdk.Og.SD.pA pAVar) {
        byte b;
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                int iHashCode = strNextName.hashCode();
                if (iHashCode != 3239) {
                    if (iHashCode != 3276) {
                        if (iHashCode == 107027 && strNextName.equals("lel")) {
                            b = 2;
                        } else {
                            b = -1;
                        }
                    } else if (strNextName.equals("fr")) {
                        b = 0;
                    } else {
                        b = -1;
                    }
                } else if (strNextName.equals("el")) {
                    b = 1;
                } else {
                    b = -1;
                }
                if (b == 0) {
                    pAVar.ML = jsonReader.nextInt();
                } else if (b == 1) {
                    pAVar.JG = jsonReader.nextString();
                } else if (b == 2) {
                    pAVar.SD = KZx(jsonReader);
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
        } catch (IOException unused) {
        }
    }

    private static Map<String, Object> Og(JsonReader jsonReader) throws IOException {
        HashMap map = new HashMap();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("lel")) {
                map.put("lel", KZx(jsonReader));
            } else if (strNextName.equals("lottie_back")) {
                JSONObject jSONObject = new JSONObject();
                map.put("lottie_back", jSONObject);
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName2 = jsonReader.nextName();
                    strNextName2.hashCode();
                    if (strNextName2.equals("hd")) {
                        try {
                            jSONObject.putOpt("hd", Integer.valueOf(jsonReader.nextInt()));
                            jSONObject.putOpt("vid", "lottie_back");
                        } catch (JSONException unused) {
                        }
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        Object objRemove = map.remove("lottie_back");
        if (objRemove instanceof JSONObject) {
            Object obj = map.get("lel");
            if (obj instanceof JSONArray) {
                ((JSONArray) obj).put(objRemove);
            } else {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(objRemove);
                map.put("lel", jSONArray);
            }
        }
        return map;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0079  */
    private static void pA(JsonReader jsonReader, com.bytedance.adsdk.Og.SD.KZx kZx) {
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                switch (jsonReader.nextName()) {
                    case "ke":
                        kZx.pA = jsonReader.nextInt();
                        break;
                    case "id":
                        kZx.Og = jsonReader.nextString();
                        break;
                    case "tl":
                        kZx.KZx = jsonReader.nextString();
                        break;
                    case "at":
                        kZx.ZZv = jsonReader.nextString();
                        break;
                    case "inel":
                        kZx.ML = new int[]{-1, -1};
                        jsonReader.beginArray();
                        for (int i = 0; i < 2; i++) {
                            if (jsonReader.hasNext()) {
                                kZx.ML[i] = jsonReader.nextInt();
                            }
                        }
                        jsonReader.endArray();
                        break;
                    case "el":
                        kZx.JG = jsonReader.nextString();
                        break;
                    case "lel":
                        kZx.SD = KZx(jsonReader);
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
        } catch (Exception unused) {
        }
    }

    private static void pA(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd, List<com.bytedance.adsdk.Og.KZx.KZx.ML> list, LongSparseArray<com.bytedance.adsdk.Og.KZx.KZx.ML> longSparseArray) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            com.bytedance.adsdk.Og.KZx.KZx.ML mlPA = BF.pA(jsonReader, sd);
            mlPA.BSW();
            com.bytedance.adsdk.Og.KZx.KZx.ML.pA pAVar = com.bytedance.adsdk.Og.KZx.KZx.ML.pA.IMAGE;
            list.add(mlPA);
            longSparseArray.put(mlPA.ML(), mlPA);
        }
        jsonReader.endArray();
    }

    private static void pA(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd, Map<String, List<com.bytedance.adsdk.Og.KZx.KZx.ML>> map, Map<String, com.bytedance.adsdk.Og.SGo> map2) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            jsonReader.beginObject();
            String strNextString = null;
            String strNextString2 = null;
            String strNextString3 = null;
            String strNextString4 = null;
            List<com.bytedance.adsdk.Og.SGo.pA> listZZv = null;
            String strNextString5 = null;
            int[][] iArr = null;
            JSONArray jSONArrayKZx = null;
            int iNextInt = 0;
            int iNextInt2 = 0;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                strNextName.hashCode();
                switch (strNextName) {
                    case "layers":
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            com.bytedance.adsdk.Og.KZx.KZx.ML mlPA = BF.pA(jsonReader, sd);
                            longSparseArray.put(mlPA.ML(), mlPA);
                            arrayList.add(mlPA);
                        }
                        jsonReader.endArray();
                        break;
                    case "h":
                        iNextInt2 = jsonReader.nextInt();
                        break;
                    case "p":
                        strNextString2 = jsonReader.nextString();
                        break;
                    case "u":
                        strNextString3 = jsonReader.nextString();
                        break;
                    case "w":
                        iNextInt = jsonReader.nextInt();
                        break;
                    case "el":
                        strNextString5 = jsonReader.nextString();
                        break;
                    case "id":
                        strNextString = jsonReader.nextString();
                        break;
                    case "tc":
                        jsonReader.beginArray();
                        listZZv = ZZv(jsonReader);
                        jsonReader.endArray();
                        break;
                    case "lel":
                        jSONArrayKZx = KZx(jsonReader);
                        break;
                    case "rel":
                        strNextString4 = jsonReader.nextString();
                        break;
                    case "inel":
                        iArr = new int[][]{new int[]{-1, -1}};
                        jsonReader.beginArray();
                        if (jsonReader.hasNext()) {
                            jsonReader.beginArray();
                            for (int i = 0; i < 2; i++) {
                                if (jsonReader.hasNext()) {
                                    iArr[0][i] = jsonReader.nextInt();
                                }
                            }
                            jsonReader.endArray();
                        }
                        jsonReader.endArray();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            if (strNextString2 != null) {
                com.bytedance.adsdk.Og.SGo sGo = new com.bytedance.adsdk.Og.SGo(iNextInt, iNextInt2, strNextString, strNextString2, strNextString3, strNextString4, listZZv, strNextString5, iArr, jSONArrayKZx);
                map2.put(sGo.omh(), sGo);
            } else {
                map.put(strNextString, arrayList);
            }
        }
        jsonReader.endArray();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0046  */
    private static JSONArray KZx(JsonReader jsonReader) {
        byte b;
        JSONArray jSONArray = new JSONArray();
        try {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                JSONObject jSONObject = new JSONObject();
                jSONArray.put(jSONObject);
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName = jsonReader.nextName();
                    int iHashCode = strNextName.hashCode();
                    if (iHashCode != 3324) {
                        if (iHashCode == 116753 && strNextName.equals("vid")) {
                            b = 0;
                        } else {
                            b = -1;
                        }
                    } else if (strNextName.equals("hd")) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                    if (b == 0) {
                        jSONObject.put("vid", jsonReader.nextString());
                    } else if (b == 1) {
                        try {
                            jSONObject.put("hd", jsonReader.nextInt());
                        } catch (JSONException unused) {
                        }
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
            }
            jsonReader.endArray();
        } catch (Exception unused2) {
        }
        return jSONArray;
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0085  */
    private static List<com.bytedance.adsdk.Og.SGo.pA> ZZv(JsonReader jsonReader) {
        try {
            ArrayList arrayList = new ArrayList();
            while (jsonReader.hasNext()) {
                com.bytedance.adsdk.Og.SGo.pA pAVar = new com.bytedance.adsdk.Og.SGo.pA();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    switch (jsonReader.nextName()) {
                        case "l":
                            pAVar.pA = jsonReader.nextInt();
                            break;
                        case "le":
                            pAVar.Og = jsonReader.nextInt();
                            break;
                        case "s":
                            pAVar.ML = jsonReader.nextInt();
                            break;
                        case "c":
                            pAVar.KZx = jsonReader.nextString();
                            break;
                        case "f":
                            pAVar.ZZv = jsonReader.nextString();
                            break;
                        case "bs":
                            pAVar.JG = jsonReader.nextInt();
                            break;
                        case "ali":
                            pAVar.SD = jsonReader.nextString();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
                jsonReader.endObject();
                arrayList.add(pAVar);
            }
            return arrayList;
        } catch (Exception unused) {
            return null;
        }
    }

    private static void pA(JsonReader jsonReader, Map<String, com.bytedance.adsdk.Og.KZx.KZx> map) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("list")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.bytedance.adsdk.Og.KZx.KZx kZxPA = Sn.pA(jsonReader);
                    map.put(kZxPA.Og(), kZxPA);
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }

    private static void pA(JsonReader jsonReader, com.bytedance.adsdk.Og.SD sd, SparseArray<com.bytedance.adsdk.Og.KZx.ZZv> sparseArray) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            com.bytedance.adsdk.Og.KZx.ZZv zZvPA = Wx.pA(jsonReader, sd);
            sparseArray.put(zZvPA.hashCode(), zZvPA);
        }
        jsonReader.endArray();
    }

    private static void pA(JsonReader jsonReader, List<com.bytedance.adsdk.Og.KZx.JG> list) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            float fNextDouble = 0.0f;
            String strNextString = null;
            float fNextDouble2 = 0.0f;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                strNextName.hashCode();
                switch (strNextName) {
                    case "cm":
                        strNextString = jsonReader.nextString();
                        break;
                    case "dr":
                        fNextDouble2 = (float) jsonReader.nextDouble();
                        break;
                    case "tm":
                        fNextDouble = (float) jsonReader.nextDouble();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            list.add(new com.bytedance.adsdk.Og.KZx.JG(strNextString, fNextDouble, fNextDouble2));
        }
        jsonReader.endArray();
    }
}
