package com.inmobi.media;

import com.inmobi.ads.exceptions.VastException;
import com.inmobi.commons.core.configs.AdConfig;
import io.ktor.http.LinkHeader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.inmobi.media.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC3589v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f3449a = "h";

    public static void a(C3389h ad, JSONObject adJson, String str, long j, L4 l4) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(adJson, "adJson");
        ad.a();
        long jOptLong = adJson.optLong("expiry", TimeUnit.MILLISECONDS.toSeconds(j));
        ad.a(adJson, str, jOptLong <= 0 ? -1L : TimeUnit.SECONDS.toMillis(jOptLong));
        if (Intrinsics.areEqual("inmobiJson", ad.u())) {
            try {
                JSONObject jSONObject = adJson.getJSONObject("pubContent");
                if (l4 != null) {
                    String TAG = f3449a;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    String string = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    ((M4) l4).a(TAG, string);
                }
                if (jSONObject.isNull("rootContainer")) {
                    if (l4 != null) {
                        String TAG2 = f3449a;
                        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                        ((M4) l4).b(TAG2, "Missing key (rootContainer) in the ad markup");
                        return;
                    }
                    return;
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject("rootContainer");
                JSONArray jSONArray = new JSONArray();
                Intrinsics.checkNotNull(jSONObject2);
                Iterator it = b(jSONObject2, l4).iterator();
                while (it.hasNext()) {
                    a(jSONArray, (String) it.next(), (byte) 2);
                }
                Iterator it2 = a(jSONObject2, l4).iterator();
                while (it2.hasNext()) {
                    a(jSONArray, (String) it2.next(), (byte) 1);
                }
                boolean zD = d(jSONObject2, l4);
                ad.a(jSONArray);
                ad.a(zD);
            } catch (Exception e) {
                Intrinsics.checkNotNullExpressionValue(f3449a, "TAG");
                C3339d5 c3339d5 = C3339d5.f3292a;
                C3339d5.c.a(I4.a(e, "event"));
            }
        }
    }

    public static ArrayList b(JSONObject jSONObject, L4 l4) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("assetValue");
            Intrinsics.checkNotNull(jSONArray);
            if (AbstractC3420j2.a(jSONArray)) {
                return arrayList;
            }
            String string = jSONObject.getString("assetType");
            if (StringsKt.equals("image", string, true)) {
                if (!jSONObject.isNull(LinkHeader.Rel.PreLoad) && jSONObject.getBoolean(LinkHeader.Rel.PreLoad)) {
                    String string2 = jSONArray.getString(0);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    arrayList.add(string2);
                }
            } else if (StringsKt.equals("container", string, true)) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    Intrinsics.checkNotNull(jSONObject2);
                    arrayList.addAll(b(jSONObject2, l4));
                }
            }
            return arrayList;
        } catch (JSONException e) {
            if (l4 != null) {
                String str = f3449a;
                ((M4) l4).b(str, O5.a(str, "TAG", "Error getting getImageAssetUrls (").append(e.getMessage()).append(')').toString());
            }
        }
    }

    public static String c(JSONObject jSONObject, L4 l4) {
        String string;
        String strC;
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("assetValue");
            Intrinsics.checkNotNull(jSONArray);
            if (AbstractC3420j2.a(jSONArray)) {
                return "";
            }
            String string2 = jSONObject.getString("assetType");
            if (!StringsKt.equals("video", string2, true)) {
                if (StringsKt.equals("container", string2, true)) {
                    int length = jSONArray.length();
                    strC = "";
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        Intrinsics.checkNotNull(jSONObject2);
                        strC = c(jSONObject2, l4);
                        int length2 = strC.length() - 1;
                        int i2 = 0;
                        boolean z = false;
                        while (i2 <= length2) {
                            boolean z2 = Intrinsics.compare((int) strC.charAt(!z ? i2 : length2), 32) <= 0;
                            if (z) {
                                if (!z2) {
                                    break;
                                }
                                length2--;
                            } else if (z2) {
                                i2++;
                            } else {
                                z = true;
                            }
                        }
                        if (strC.subSequence(i2, length2 + 1).toString().length() > 0) {
                            break;
                        }
                    }
                } else {
                    string = "";
                }
                Intrinsics.checkNotNull(strC);
                return strC;
            }
            string = jSONArray.getString(0);
            strC = string;
            Intrinsics.checkNotNull(strC);
            return strC;
        } catch (JSONException e) {
            if (l4 != null) {
                String str = f3449a;
                ((M4) l4).b(str, O5.a(str, "TAG", "Error getting VAST video XML (").append(e.getMessage()).append(')').toString());
            }
            C3339d5 c3339d5 = C3339d5.f3292a;
            P1 event = new P1(e);
            Intrinsics.checkNotNullParameter(event, "event");
            C3339d5.c.a(event);
            return "";
        }
    }

    public static boolean d(JSONObject jSONObject, L4 l4) {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("assetValue");
            Intrinsics.checkNotNull(jSONArray);
            if (AbstractC3420j2.a(jSONArray)) {
                return false;
            }
            String string = jSONObject.getString("assetType");
            if (StringsKt.equals(com.ironsource.b9.h.K, string, true)) {
                return !jSONObject.isNull(LinkHeader.Rel.PreLoad) && jSONObject.getBoolean(LinkHeader.Rel.PreLoad);
            }
            if (!StringsKt.equals("container", string, true)) {
                return false;
            }
            int length = jSONArray.length();
            boolean zD = false;
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                Intrinsics.checkNotNull(jSONObject2);
                zD = d(jSONObject2, l4);
                if (zD) {
                    break;
                }
            }
            return zD;
        } catch (JSONException e) {
            if (l4 != null) {
                String str = f3449a;
                ((M4) l4).b(str, O5.a(str, "TAG", "Error getting preload webview flag (").append(e.getMessage()).append(')').toString());
            }
            C3339d5 c3339d5 = C3339d5.f3292a;
            P1 event = new P1(e);
            Intrinsics.checkNotNullParameter(event, "event");
            C3339d5.c.a(event);
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01f2 A[Catch: JSONException -> 0x0211, TryCatch #0 {JSONException -> 0x0211, blocks: (B:98:0x01e7, B:100:0x01f2, B:102:0x01fc), top: B:139:0x01e7 }] */
    /* JADX WARN: Code duplicated, block: B:102:0x01fc A[Catch: JSONException -> 0x0211, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0211, blocks: (B:98:0x01e7, B:100:0x01f2, B:102:0x01fc), top: B:139:0x01e7 }] */
    /* JADX WARN: Code duplicated, block: B:110:0x022b  */
    /* JADX WARN: Code duplicated, block: B:116:0x0248 A[Catch: JSONException -> 0x0267, TryCatch #2 {JSONException -> 0x0267, blocks: (B:114:0x023d, B:116:0x0248, B:118:0x0252), top: B:143:0x023d }] */
    /* JADX WARN: Code duplicated, block: B:118:0x0252 A[Catch: JSONException -> 0x0267, TRY_LEAVE, TryCatch #2 {JSONException -> 0x0267, blocks: (B:114:0x023d, B:116:0x0248, B:118:0x0252), top: B:143:0x023d }] */
    /* JADX WARN: Code duplicated, block: B:126:0x0280  */
    /* JADX WARN: Code duplicated, block: B:175:0x01dc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:177:0x01ce A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:181:0x020e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:183:0x0233 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:185:0x0225 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:189:0x0264 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:191:0x0288 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:193:0x027a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:94:0x01d4  */
    public static final C3389h a(C3389h ad, AdConfig adConfig, L4 l4) {
        ArrayList<String> arrayList;
        ArrayList<String> arrayList2;
        String strB;
        JSONArray jSONArray;
        int length;
        int i;
        JSONArray jSONArray2;
        int length2;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        if (!Intrinsics.areEqual("inmobiJson", ad.u())) {
            return ad;
        }
        JSONObject jSONObject = new JSONObject(ad.x());
        JSONObject jSONObject2 = jSONObject.getJSONObject("rootContainer");
        Intrinsics.checkNotNull(jSONObject2);
        String strC = c(jSONObject2, l4);
        int length3 = strC.length() - 1;
        int i4 = 0;
        boolean z = false;
        while (i4 <= length3) {
            boolean z2 = Intrinsics.compare((int) strC.charAt(!z ? i4 : length3), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length3--;
            } else if (z2) {
                i4++;
            } else {
                z = true;
            }
        }
        if (strC.subSequence(i4, length3 + 1).toString().length() == 0) {
            if (l4 != null) {
                String TAG = f3449a;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((M4) l4).b(TAG, "Missing VAST video XML in the ad markup");
            }
            return ad;
        }
        Qc qcA = new Lc(adConfig.getVastVideo(), l4).a(strC);
        JSONArray jSONArrayK = ad.k();
        if (qcA.l != 0) {
            if (l4 != null) {
                String TAG2 = f3449a;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((M4) l4).b(TAG2, "Processing VAST XML to build a video descriptor failed");
            }
            throw new VastException(qcA.l);
        }
        String strB2 = qcA.b();
        if (strB2 != null && strB2.length() != 0) {
            if (jSONArrayK != null) {
                a(jSONArrayK, strB2, (byte) 0);
            }
            AdConfig.VastVideoConfig vastVideo = adConfig.getVastVideo();
            ArrayList<String> arrayList3 = new ArrayList();
            try {
                JSONArray jSONArray3 = jSONObject.getJSONArray("pages");
                int length4 = jSONArray3.length();
                int i5 = 0;
                while (i5 < length4) {
                    if (jSONArray3.getJSONObject(i5).isNull("rootContainer")) {
                        qcA = qcA;
                        i3 = length4;
                        jSONArray3 = jSONArray3;
                    } else {
                        JSONObject jSONObject3 = jSONArray3.getJSONObject(i5).getJSONObject("rootContainer");
                        Intrinsics.checkNotNullExpressionValue(jSONObject3, "getJSONObject(...)");
                        String strC2 = c(jSONObject3, l4);
                        i3 = length4;
                        int length5 = strC2.length() - 1;
                        int i6 = 0;
                        boolean z3 = false;
                        while (true) {
                            if (i6 > length5) {
                                qcA = qcA;
                                jSONArray3 = jSONArray3;
                                break;
                            }
                            jSONArray3 = jSONArray3;
                            qcA = qcA;
                            try {
                                boolean z4 = Intrinsics.compare((int) strC2.charAt(!z3 ? i6 : length5), 32) <= 0;
                                if (z3) {
                                    if (!z4) {
                                        break;
                                    }
                                    length5--;
                                } else if (z4) {
                                    i6++;
                                } else {
                                    z3 = true;
                                }
                            } catch (JSONException e) {
                                e = e;
                                if (l4 != null) {
                                    String TAG3 = f3449a;
                                    Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                                    ((M4) l4).a(TAG3, "JSONException in getPagesVideo", e);
                                }
                                if (l4 != null) {
                                    String str = f3449a;
                                    ((M4) l4).a(str, O5.a(str, "TAG", "Media size for pages ").append(arrayList3.size()).toString());
                                }
                                for (String str2 : arrayList3) {
                                    if (jSONArrayK != null) {
                                        a(jSONArrayK, str2, (byte) 0);
                                    }
                                }
                                arrayList = new ArrayList();
                                jSONArray2 = jSONObject.getJSONArray("pages");
                                length2 = jSONArray2.length();
                                for (i2 = 0; i2 < length2; i2++) {
                                    if (!jSONArray2.getJSONObject(i2).isNull("rootContainer")) {
                                        JSONObject jSONObject4 = jSONArray2.getJSONObject(i2).getJSONObject("rootContainer");
                                        Intrinsics.checkNotNullExpressionValue(jSONObject4, "getJSONObject(...)");
                                        arrayList.addAll(b(jSONObject4, l4));
                                    }
                                }
                                for (String str3 : arrayList) {
                                    if (jSONArrayK != null) {
                                        a(jSONArrayK, str3, (byte) 2);
                                    }
                                }
                                arrayList2 = new ArrayList();
                                jSONArray = jSONObject.getJSONArray("pages");
                                length = jSONArray.length();
                                for (i = 0; i < length; i++) {
                                    if (!jSONArray.getJSONObject(i).isNull("rootContainer")) {
                                        JSONObject jSONObject5 = jSONArray.getJSONObject(i).getJSONObject("rootContainer");
                                        Intrinsics.checkNotNullExpressionValue(jSONObject5, "getJSONObject(...)");
                                        arrayList2.addAll(a(jSONObject5, l4));
                                    }
                                }
                                for (String str4 : arrayList2) {
                                    if (jSONArrayK != null) {
                                        a(jSONArrayK, str4, (byte) 1);
                                    }
                                }
                                strB = qcA.b();
                                Qc qc = qcA;
                                String str5 = qc.g;
                                if (strB != null) {
                                }
                                return null;
                            }
                        }
                        if (strC2.subSequence(i6, length5 + 1).toString().length() != 0) {
                            Qc qcA2 = new Lc(vastVideo, l4).a(strC2);
                            if (qcA2.l == 0) {
                                String strB3 = qcA2.b();
                                if (strB3 != null && !arrayList3.isEmpty()) {
                                    arrayList3.add(strB3);
                                }
                            } else if (l4 != null) {
                                String TAG4 = f3449a;
                                Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
                                ((M4) l4).b(TAG4, "No video present of error for video descriptor in pages array");
                            }
                        } else if (l4 != null) {
                            String TAG5 = f3449a;
                            Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
                            ((M4) l4).b(TAG5, "Missing VAST video XML in the ad markup");
                        }
                    }
                    i5++;
                    length4 = i3;
                    jSONArray3 = jSONArray3;
                    qcA = qcA;
                }
                qcA = qcA;
            } catch (JSONException e2) {
                e = e2;
                qcA = qcA;
            }
            if (l4 != null) {
                String str6 = f3449a;
                ((M4) l4).a(str6, O5.a(str6, "TAG", "Media size for pages ").append(arrayList3.size()).toString());
            }
            while (r0.hasNext()) {
                if (jSONArrayK != null) {
                    a(jSONArrayK, str2, (byte) 0);
                }
            }
            arrayList = new ArrayList();
            try {
                jSONArray2 = jSONObject.getJSONArray("pages");
                length2 = jSONArray2.length();
                while (i2 < length2) {
                    if (!jSONArray2.getJSONObject(i2).isNull("rootContainer")) {
                        JSONObject jSONObject6 = jSONArray2.getJSONObject(i2).getJSONObject("rootContainer");
                        Intrinsics.checkNotNullExpressionValue(jSONObject6, "getJSONObject(...)");
                        arrayList.addAll(b(jSONObject6, l4));
                    }
                }
            } catch (JSONException e3) {
                if (l4 != null) {
                    String TAG6 = f3449a;
                    Intrinsics.checkNotNullExpressionValue(TAG6, "TAG");
                    ((M4) l4).a(TAG6, "JSONException in getPagesImage", e3);
                }
            }
            while (r0.hasNext()) {
                if (jSONArrayK != null) {
                    a(jSONArrayK, str3, (byte) 2);
                }
            }
            arrayList2 = new ArrayList();
            try {
                jSONArray = jSONObject.getJSONArray("pages");
                length = jSONArray.length();
                while (i < length) {
                    if (!jSONArray.getJSONObject(i).isNull("rootContainer")) {
                        JSONObject jSONObject7 = jSONArray.getJSONObject(i).getJSONObject("rootContainer");
                        Intrinsics.checkNotNullExpressionValue(jSONObject7, "getJSONObject(...)");
                        arrayList2.addAll(a(jSONObject7, l4));
                    }
                }
            } catch (JSONException e4) {
                if (l4 != null) {
                    String TAG7 = f3449a;
                    Intrinsics.checkNotNullExpressionValue(TAG7, "TAG");
                    ((M4) l4).a(TAG7, "JSONException in getPagesGif", e4);
                }
            }
            while (r0.hasNext()) {
                if (jSONArrayK != null) {
                    a(jSONArrayK, str4, (byte) 1);
                }
            }
            strB = qcA.b();
            Qc qc2 = qcA;
            String str7 = qc2.g;
            if (strB != null || str7 == null) {
                return null;
            }
            return new C3356e8(ad, jSONArrayK, strB, str7, qc2.k, qc2.h, qc2.i);
        }
        if (l4 != null) {
            String TAG8 = f3449a;
            Intrinsics.checkNotNullExpressionValue(TAG8, "TAG");
            ((M4) l4).b(TAG8, "No Media URL to download.Returning..");
        }
        throw new VastException(401);
    }

    public static void a(JSONArray jSONArray, String str, byte b) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", (int) b);
        jSONObject.put("url", str);
        jSONArray.put(jSONObject);
    }

    public static ArrayList a(JSONObject jSONObject, L4 l4) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("assetValue");
            Intrinsics.checkNotNull(jSONArray);
            if (AbstractC3420j2.a(jSONArray)) {
                return arrayList;
            }
            String string = jSONObject.getString("assetType");
            if (StringsKt.equals("gif", string, true)) {
                String string2 = jSONArray.getString(0);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                arrayList.add(string2);
            } else if (StringsKt.equals("container", string, true)) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    Intrinsics.checkNotNull(jSONObject2);
                    arrayList.addAll(a(jSONObject2, l4));
                }
            }
            return arrayList;
        } catch (JSONException e) {
            if (l4 != null) {
                String str = f3449a;
                ((M4) l4).b(str, O5.a(str, "TAG", "Error getting getGifAssetUrls (").append(e.getMessage()).append(')').toString());
            }
        }
    }
}
