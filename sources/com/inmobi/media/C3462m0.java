package com.inmobi.media;

import android.os.Build;
import android.os.SystemClock;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.inmobi.ads.InMobiAdRequestStatus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.inmobi.media.m0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3462m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0 f3372a;
    public final C0 b;
    public final J c;
    public final String d;
    public long e;
    public L4 f;
    public final C3446l0 g;
    public final C3432k0 h;

    public C3462m0(C0 mAdStoreListener, C0 mTelemetryListener, J mAdPlacement) {
        Intrinsics.checkNotNullParameter(mAdStoreListener, "mAdStoreListener");
        Intrinsics.checkNotNullParameter(mTelemetryListener, "mTelemetryListener");
        Intrinsics.checkNotNullParameter(mAdPlacement, "mAdPlacement");
        this.f3372a = mAdStoreListener;
        this.b = mTelemetryListener;
        this.c = mAdPlacement;
        this.d = "m0";
        this.g = new C3446l0(this);
        this.h = new C3432k0(this);
    }

    public final C3418j0 a(D mRequest, Integer num) {
        F adNetworkResponse;
        Intrinsics.checkNotNullParameter(mRequest, "networkRequest");
        if (num != null && SystemClock.elapsedRealtime() - this.e < num.intValue() * 1000) {
            throw new C3603w(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.EARLY_REFRESH_REQUEST), (short) 2009);
        }
        if (mRequest != null) {
            Map map = mRequest.D;
            if (map == null) {
                map = new HashMap();
            }
            mRequest.D = map;
        }
        this.e = SystemClock.elapsedRealtime();
        Intrinsics.checkNotNullParameter(mRequest, "mAdNetworkRequest");
        try {
            Intrinsics.checkNotNullParameter(mRequest, "mRequest");
            T8 t8B = mRequest.b();
            adNetworkResponse = new F(t8B);
            try {
                if (t8B.b()) {
                    Intrinsics.checkNotNullExpressionValue("C", "TAG");
                }
            } catch (Exception unused) {
                Intrinsics.checkNotNullExpressionValue("C", "TAG");
            }
        } catch (Exception unused2) {
            adNetworkResponse = null;
        }
        P8 p8 = adNetworkResponse != null ? adNetworkResponse.f3063a.c : null;
        if (adNetworkResponse == null) {
            a(MapsKt.mutableMapOf(TuplesKt.to("errorCode", (short) 2108)));
            throw new C3603w(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), (short) 0);
        }
        if (p8 != null) {
            a(MapsKt.mutableMapOf(TuplesKt.to("errorCode", p8.f3168a.toString())));
            InMobiAdRequestStatus inMobiAdRequestStatus = adNetworkResponse.b;
            if (inMobiAdRequestStatus == null) {
                return null;
            }
            throw new C3603w(inMobiAdRequestStatus, (short) 0);
        }
        Intrinsics.checkNotNullParameter(adNetworkResponse, "adNetworkResponse");
        this.f3372a.g0();
        try {
            return a(new JSONObject(adNetworkResponse.f3063a.a()));
        } catch (JSONException e) {
            a(MapsKt.mutableMapOf(TuplesKt.to("errorCode", (short) 2113)));
            L4 l4 = this.f;
            if (l4 != null) {
                String TAG = this.d;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((M4) l4).a(TAG, "Error while parsing ad response.", e);
            }
            throw new C3603w(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), (short) 0);
        }
    }

    public static String a() throws JSONException {
        String strB = C3517pb.b();
        if (strB == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        LinkedHashMap linkedHashMap = C3578u2.f3440a;
        jSONObject.put("root", C3549s2.a("root", strB, null).getLastUpdateTimeStamp());
        jSONObject.put("ads", C3549s2.a("ads", strB, null).getLastUpdateTimeStamp());
        jSONObject.put("telemetry", C3549s2.a("telemetry", strB, null).getLastUpdateTimeStamp());
        jSONObject.put("crashReporting", C3549s2.a("crashReporting", strB, null).getLastUpdateTimeStamp());
        jSONObject.put("signals", C3549s2.a("signals", strB, null).getLastUpdateTimeStamp());
        return jSONObject.toString();
    }

    /* JADX WARN: Code duplicated, block: B:122:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:126:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:127:0x02d2 A[Catch: JSONException -> 0x0304, TryCatch #4 {JSONException -> 0x0304, blocks: (B:124:0x02cb, B:127:0x02d2, B:129:0x02e3, B:130:0x02fa, B:132:0x02fe), top: B:210:0x02cb }] */
    /* JADX WARN: Code duplicated, block: B:129:0x02e3 A[Catch: JSONException -> 0x0304, TryCatch #4 {JSONException -> 0x0304, blocks: (B:124:0x02cb, B:127:0x02d2, B:129:0x02e3, B:130:0x02fa, B:132:0x02fe), top: B:210:0x02cb }] */
    /* JADX WARN: Code duplicated, block: B:132:0x02fe A[Catch: JSONException -> 0x0304, TRY_LEAVE, TryCatch #4 {JSONException -> 0x0304, blocks: (B:124:0x02cb, B:127:0x02d2, B:129:0x02e3, B:130:0x02fa, B:132:0x02fe), top: B:210:0x02cb }] */
    /* JADX WARN: Code duplicated, block: B:144:0x0327 A[Catch: JSONException -> 0x0444, TryCatch #3 {JSONException -> 0x0444, blocks: (B:142:0x0323, B:144:0x0327, B:145:0x0333, B:147:0x0341, B:149:0x0345, B:150:0x0351, B:152:0x0359, B:156:0x0386, B:158:0x038a, B:159:0x0396), top: B:208:0x0323 }] */
    /* JADX WARN: Code duplicated, block: B:147:0x0341 A[Catch: JSONException -> 0x0444, TryCatch #3 {JSONException -> 0x0444, blocks: (B:142:0x0323, B:144:0x0327, B:145:0x0333, B:147:0x0341, B:149:0x0345, B:150:0x0351, B:152:0x0359, B:156:0x0386, B:158:0x038a, B:159:0x0396), top: B:208:0x0323 }] */
    /* JADX WARN: Code duplicated, block: B:149:0x0345 A[Catch: JSONException -> 0x0444, TryCatch #3 {JSONException -> 0x0444, blocks: (B:142:0x0323, B:144:0x0327, B:145:0x0333, B:147:0x0341, B:149:0x0345, B:150:0x0351, B:152:0x0359, B:156:0x0386, B:158:0x038a, B:159:0x0396), top: B:208:0x0323 }] */
    /* JADX WARN: Code duplicated, block: B:152:0x0359 A[Catch: JSONException -> 0x0444, TryCatch #3 {JSONException -> 0x0444, blocks: (B:142:0x0323, B:144:0x0327, B:145:0x0333, B:147:0x0341, B:149:0x0345, B:150:0x0351, B:152:0x0359, B:156:0x0386, B:158:0x038a, B:159:0x0396), top: B:208:0x0323 }] */
    /* JADX WARN: Code duplicated, block: B:153:0x037e  */
    /* JADX WARN: Code duplicated, block: B:155:0x0381  */
    /* JADX WARN: Code duplicated, block: B:156:0x0386 A[Catch: JSONException -> 0x0444, TryCatch #3 {JSONException -> 0x0444, blocks: (B:142:0x0323, B:144:0x0327, B:145:0x0333, B:147:0x0341, B:149:0x0345, B:150:0x0351, B:152:0x0359, B:156:0x0386, B:158:0x038a, B:159:0x0396), top: B:208:0x0323 }] */
    /* JADX WARN: Code duplicated, block: B:158:0x038a A[Catch: JSONException -> 0x0444, TryCatch #3 {JSONException -> 0x0444, blocks: (B:142:0x0323, B:144:0x0327, B:145:0x0333, B:147:0x0341, B:149:0x0345, B:150:0x0351, B:152:0x0359, B:156:0x0386, B:158:0x038a, B:159:0x0396), top: B:208:0x0323 }] */
    /* JADX WARN: Code duplicated, block: B:163:0x03bc A[Catch: JSONException -> 0x0442, TryCatch #1 {JSONException -> 0x0442, blocks: (B:161:0x039e, B:162:0x03bb, B:163:0x03bc, B:165:0x03c2, B:166:0x03d9, B:168:0x041b, B:169:0x0420, B:171:0x0428, B:172:0x042d, B:173:0x0441), top: B:205:0x033f }] */
    /* JADX WARN: Code duplicated, block: B:165:0x03c2 A[Catch: JSONException -> 0x0442, TryCatch #1 {JSONException -> 0x0442, blocks: (B:161:0x039e, B:162:0x03bb, B:163:0x03bc, B:165:0x03c2, B:166:0x03d9, B:168:0x041b, B:169:0x0420, B:171:0x0428, B:172:0x042d, B:173:0x0441), top: B:205:0x033f }] */
    /* JADX WARN: Code duplicated, block: B:168:0x041b A[Catch: JSONException -> 0x0442, TryCatch #1 {JSONException -> 0x0442, blocks: (B:161:0x039e, B:162:0x03bb, B:163:0x03bc, B:165:0x03c2, B:166:0x03d9, B:168:0x041b, B:169:0x0420, B:171:0x0428, B:172:0x042d, B:173:0x0441), top: B:205:0x033f }] */
    /* JADX WARN: Code duplicated, block: B:171:0x0428 A[Catch: JSONException -> 0x0442, TryCatch #1 {JSONException -> 0x0442, blocks: (B:161:0x039e, B:162:0x03bb, B:163:0x03bc, B:165:0x03c2, B:166:0x03d9, B:168:0x041b, B:169:0x0420, B:171:0x0428, B:172:0x042d, B:173:0x0441), top: B:205:0x033f }] */
    /* JADX WARN: Code duplicated, block: B:180:0x044b  */
    /* JADX WARN: Code duplicated, block: B:182:0x0459  */
    /* JADX WARN: Code duplicated, block: B:184:0x045d  */
    /* JADX WARN: Code duplicated, block: B:187:0x0499  */
    /* JADX WARN: Code duplicated, block: B:189:0x04a0  */
    /* JADX WARN: Code duplicated, block: B:191:0x04a6  */
    /* JADX WARN: Code duplicated, block: B:193:0x04be  */
    /* JADX WARN: Code duplicated, block: B:196:0x04d4  */
    /* JADX WARN: Code duplicated, block: B:198:0x04df  */
    /* JADX WARN: Code duplicated, block: B:201:0x04ef  */
    /* JADX WARN: Code duplicated, block: B:202:0x04f5  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v4, types: [int] */
    /* JADX WARN: Type inference failed for: r5v8 */
    public final C3418j0 a(JSONObject jSONObject) {
        Object obj;
        String str;
        L4 l4;
        C3418j0 c3418j0;
        ?? length;
        L4 l5;
        ?? r5;
        L4 l6;
        L4 l7;
        Map mapMutableMapOf;
        Boolean boolO;
        L4 l8;
        L4 l9;
        JSONArray jSONArray;
        String string;
        L4 l10;
        Map<String, Object> mapMutableMapOf2;
        String strM;
        String strB;
        L4 l11;
        C3418j0 c3418j0A;
        L4 l12;
        boolean zOptBoolean;
        L4 l13;
        L4 l14;
        JSONArray jSONArray2;
        JSONArray jSONArray3;
        L4 l15;
        String str2 = "errorCode";
        try {
            try {
                try {
                    L4 l16 = this.f;
                    if (l16 != null) {
                        String TAG = this.d;
                        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                        ((M4) l16).c(TAG, "response - " + jSONObject);
                    }
                    JSONArray jSONArray4 = jSONObject.getJSONArray("adSets");
                    Intrinsics.checkNotNullExpressionValue(jSONArray4, "getJSONArray(...)");
                    try {
                        if (AbstractC3420j2.a(jSONArray4)) {
                            obj = "networkType";
                            str = com.smaato.sdk.video.vast.model.Ad.AD_TYPE;
                        } else {
                            JSONObject jSONObject2 = jSONObject.getJSONArray("adSets").getJSONObject(0);
                            L4 l17 = this.f;
                            if (l17 != null) {
                                String strOptString = jSONObject.optString(C3418j0.KEY_REQUEST_ID);
                                Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                                ((M4) l17).e(SDKConstants.REQUEST_ID, strOptString);
                            }
                            L4 l18 = this.f;
                            if (l18 != null) {
                                String strOptString2 = jSONObject.optString("placementId");
                                Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                                ((M4) l18).e(SDKConstants.PARAM_PLACEMENT_ID, strOptString2);
                            }
                            L4 l19 = this.f;
                            if (l19 != null) {
                                ((M4) l19).e(com.smaato.sdk.video.vast.model.Ad.AD_TYPE, String.valueOf(this.c.b()));
                            }
                            L4 l20 = this.f;
                            if (l20 != null) {
                                ((M4) l20).e("placementType", String.valueOf(this.c.m()));
                            }
                            L4 l21 = this.f;
                            if (l21 != null) {
                                ((M4) l21).e("bundleID", String.valueOf(O0.f3153a));
                            }
                            L4 l22 = this.f;
                            if (l22 != null) {
                                ((M4) l22).e(com.ironsource.b9.i.n, C3435k3.f3355a.c().getSecond());
                            }
                            L4 l23 = this.f;
                            if (l23 != null) {
                                ((M4) l23).e("networkType", C3435k3.q());
                            }
                            L4 l24 = this.f;
                            if (l24 != null) {
                                String MODEL = Build.MODEL;
                                Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                                ((M4) l24).e(com.ironsource.b9.i.l, MODEL);
                            }
                            L4 l25 = this.f;
                            if (l25 != null) {
                                ((M4) l25).e("publisherID", String.valueOf(C3517pb.b()));
                            }
                            L4 l26 = this.f;
                            if (l26 != null) {
                                ((M4) l26).e("sdkAdPod", String.valueOf(jSONObject2.optBoolean("isPod")));
                            }
                            L4 l27 = this.f;
                            if (l27 != null) {
                                ((M4) l27).e("sdkVersion", "10.8.2");
                            }
                            L4 l28 = this.f;
                            if (l28 != null) {
                                ((M4) l28).e("tpName", String.valueOf(C3531qb.d()));
                            }
                            L4 l29 = this.f;
                            if (l29 != null) {
                                ((M4) l29).e("tpVersion", String.valueOf(C3531qb.f()));
                            }
                            L4 l30 = this.f;
                            if (l30 != null) {
                                ((M4) l30).e("source", "sdk_android");
                            }
                            L4 l31 = this.f;
                            if (l31 != null) {
                                ((M4) l31).e("mkVersion", C3531qb.a());
                            }
                            L4 l32 = this.f;
                            if (l32 != null) {
                                ((M4) l32).e("isServerSideLogging", String.valueOf(jSONObject2.optBoolean("logEnabled", false)));
                            }
                            L4 l33 = this.f;
                            if (l33 != null) {
                                String strOptString3 = jSONObject2.optString("transactionId", "Not Set");
                                Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
                                ((M4) l33).e("transactionID", strOptString3);
                            }
                            L4 l34 = this.f;
                            if (l34 != null) {
                                ((M4) l34).e("webViewUserAgent", C3517pb.k());
                            }
                            String strA = a();
                            if (strA != null && (l15 = this.f) != null) {
                                ((M4) l15).e("configData", strA);
                            }
                            boolean zOptBoolean2 = jSONObject2.optBoolean("isPod");
                            str = com.smaato.sdk.video.vast.model.Ad.AD_TYPE;
                            obj = "networkType";
                            try {
                                if (zOptBoolean2) {
                                    ArrayList arrayList = new ArrayList();
                                    ArrayList arrayList2 = new ArrayList();
                                    if (jSONObject2.has("ads") && (jSONArray3 = jSONObject2.getJSONArray("ads")) != null && !AbstractC3420j2.a(jSONArray3)) {
                                        JSONArray jSONArray5 = jSONObject2.getJSONArray("ads");
                                        int i = 0;
                                        for (int length2 = jSONArray5.length(); i < length2; length2 = length2) {
                                            arrayList.add(i, jSONArray5.getJSONObject(i).optString("creativeId"));
                                            arrayList2.add(i, jSONArray5.getJSONObject(i).optString("impressionId"));
                                            i++;
                                        }
                                        L4 l35 = this.f;
                                        if (l35 != null) {
                                            ((M4) l35).e("creativeID", CollectionsKt.joinToString$default(arrayList, " , ", null, null, 0, null, null, 62, null));
                                        }
                                        L4 l36 = this.f;
                                        if (l36 != null) {
                                            ((M4) l36).e("impressionID", CollectionsKt.joinToString$default(arrayList2, " , ", null, null, 0, null, null, 62, null));
                                        }
                                    } else {
                                        L4 l37 = this.f;
                                        if (l37 != null) {
                                            String TAG2 = this.d;
                                            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                                            ((M4) l37).b(TAG2, "no ads. cannot update vitals");
                                        }
                                    }
                                } else {
                                    try {
                                        if (jSONObject2.has("ads") && (jSONArray2 = jSONObject2.getJSONArray("ads")) != null && !AbstractC3420j2.a(jSONArray2)) {
                                            L4 l38 = this.f;
                                            if (l38 != null) {
                                                String strOptString4 = jSONObject2.getJSONArray("ads").getJSONObject(0).optString("creativeId");
                                                Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
                                                ((M4) l38).e("creativeID", strOptString4);
                                            }
                                            L4 l39 = this.f;
                                            if (l39 != null) {
                                                String strOptString5 = jSONObject2.getJSONArray("ads").getJSONObject(0).optString("impressionId");
                                                Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
                                                ((M4) l39).e("impressionID", strOptString5);
                                            }
                                        } else {
                                            str2 = "errorCode";
                                            L4 l40 = this.f;
                                            if (l40 != null) {
                                                String TAG3 = this.d;
                                                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                                                ((M4) l40).b(TAG3, "no ads. cannot update vitals");
                                            }
                                        }
                                    } catch (JSONException e) {
                                        e = e;
                                        l4 = this.f;
                                        if (l4 != null) {
                                            String TAG4 = this.d;
                                            Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
                                            ((M4) l4).a(TAG4, "error while update vitals", e);
                                        }
                                    }
                                }
                            } catch (JSONException e2) {
                                e = e2;
                                str2 = "errorCode";
                                l4 = this.f;
                                if (l4 != null) {
                                    String TAG5 = this.d;
                                    Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
                                    ((M4) l4).a(TAG5, "error while update vitals", e);
                                }
                                if (jSONObject.optJSONArray("adSets") != null) {
                                    zOptBoolean = jSONObject.getJSONArray("adSets").getJSONObject(0).optBoolean("logEnabled", false);
                                    l13 = this.f;
                                    if (l13 != null) {
                                        String TAG6 = this.d;
                                        Intrinsics.checkNotNullExpressionValue(TAG6, "TAG");
                                        ((M4) l13).a(TAG6, "server side logger lever - " + zOptBoolean);
                                    }
                                    l14 = this.f;
                                    if (l14 != null) {
                                        ((M4) l14).a(zOptBoolean);
                                    }
                                }
                                c3418j0 = null;
                                l9 = this.f;
                                if (l9 != null) {
                                    String TAG7 = this.d;
                                    Intrinsics.checkNotNullExpressionValue(TAG7, "TAG");
                                    ((M4) l9).c(TAG7, "parseAdResponse called");
                                }
                                jSONArray = jSONObject.getJSONArray("adSets");
                                string = jSONObject.getString(C3418j0.KEY_REQUEST_ID);
                                length = jSONArray.length();
                                if (length != 0) {
                                    l11 = this.f;
                                    if (l11 != null) {
                                        String TAG8 = this.d;
                                        Intrinsics.checkNotNullExpressionValue(TAG8, "TAG");
                                        ((M4) l11).a(TAG8, "parseAdResponse responses available");
                                    }
                                    if (this.c.b() != null) {
                                        C3404i0 c3404i0 = C3418j0.Companion;
                                        JSONObject jSONObject3 = jSONArray.getJSONObject(0);
                                        Intrinsics.checkNotNullExpressionValue(jSONObject3, "getJSONObject(...)");
                                        long jL = this.c.l();
                                        String strB2 = this.c.b();
                                        Intrinsics.checkNotNull(string);
                                        L4 l41 = this.f;
                                        c3404i0.getClass();
                                        c3418j0A = C3404i0.a(jSONObject3, jL, strB2, string, l41);
                                    } else {
                                        c3418j0A = null;
                                    }
                                    if (c3418j0A == null) {
                                        l12 = this.f;
                                        if (l12 != null) {
                                            String TAG9 = this.d;
                                            Intrinsics.checkNotNullExpressionValue(TAG9, "TAG");
                                            ((M4) l12).b(TAG9, "adSet is null");
                                        }
                                        a(MapsKt.mutableMapOf(TuplesKt.to(str2, (short) 2114)));
                                        throw new C3603w(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), (short) 0);
                                    }
                                    c3418j0 = c3418j0A;
                                    r5 = str2;
                                    if (c3418j0 == null) {
                                        r5 = length;
                                        l8 = this.f;
                                        if (l8 != null) {
                                            String TAG10 = this.d;
                                            Intrinsics.checkNotNullExpressionValue(TAG10, "TAG");
                                            ((M4) l8).b(TAG10, "Could not parse ad response:" + jSONObject);
                                        }
                                        a(MapsKt.mutableMapOf(TuplesKt.to(r5, (short) 2115)));
                                        throw new C3603w(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), (short) 0);
                                    }
                                    r5 = length;
                                    if (c3418j0.m()) {
                                        if (c3418j0.p() == null) {
                                            mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(r5, (short) 2116));
                                            boolO = c3418j0.o();
                                            if (boolO != null) {
                                                mapMutableMapOf.put("isRewarded", boolO);
                                            }
                                            a(mapMutableMapOf);
                                            throw new C3603w(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), (short) 0);
                                        }
                                        a(c3418j0.o());
                                        l6 = this.f;
                                        if (l6 != null) {
                                            String TAG11 = this.d;
                                            Intrinsics.checkNotNullExpressionValue(TAG11, "TAG");
                                            ((M4) l6).a(TAG11, "==== CHECKPOINT REACHED - PARSING COMPLETE ====");
                                        }
                                        l7 = this.f;
                                        if (l7 != null) {
                                            ((M4) l7).b();
                                        }
                                    } else {
                                        a(c3418j0.o());
                                    }
                                    return c3418j0;
                                }
                                l10 = this.f;
                                if (l10 != null) {
                                    String TAG12 = this.d;
                                    Intrinsics.checkNotNullExpressionValue(TAG12, "TAG");
                                    ((M4) l10).b(TAG12, "Ad response received but no ad available:" + jSONObject);
                                }
                                mapMutableMapOf2 = MapsKt.mutableMapOf(TuplesKt.to("latency", Long.valueOf(SystemClock.elapsedRealtime() - this.e)), TuplesKt.to(obj, C3435k3.q()), TuplesKt.to("plId", Long.valueOf(this.c.l())));
                                strM = this.c.m();
                                if (strM != null) {
                                    mapMutableMapOf2.put("plType", strM);
                                }
                                strB = this.c.b();
                                if (strB != null) {
                                    mapMutableMapOf2.put(str, strB);
                                }
                                this.b.b("ServerNoFill", mapMutableMapOf2);
                                throw new C3603w(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.NO_FILL), (short) 0);
                                l5 = this.f;
                                r5 = length;
                                if (l5 != null) {
                                    String TAG13 = this.d;
                                    Intrinsics.checkNotNullExpressionValue(TAG13, "TAG");
                                    ((M4) l5).a(TAG13, "Error while parsing ad response.", e);
                                }
                                if (c3418j0 == null) {
                                    r5 = length;
                                    l8 = this.f;
                                    if (l8 != null) {
                                        String TAG14 = this.d;
                                        Intrinsics.checkNotNullExpressionValue(TAG14, "TAG");
                                        ((M4) l8).b(TAG14, "Could not parse ad response:" + jSONObject);
                                    }
                                    a(MapsKt.mutableMapOf(TuplesKt.to(r5, (short) 2115)));
                                    throw new C3603w(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), (short) 0);
                                }
                                r5 = length;
                                if (c3418j0.m()) {
                                    if (c3418j0.p() == null) {
                                        mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(r5, (short) 2116));
                                        boolO = c3418j0.o();
                                        if (boolO != null) {
                                            mapMutableMapOf.put("isRewarded", boolO);
                                        }
                                        a(mapMutableMapOf);
                                        throw new C3603w(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), (short) 0);
                                    }
                                    a(c3418j0.o());
                                    l6 = this.f;
                                    if (l6 != null) {
                                        String TAG15 = this.d;
                                        Intrinsics.checkNotNullExpressionValue(TAG15, "TAG");
                                        ((M4) l6).a(TAG15, "==== CHECKPOINT REACHED - PARSING COMPLETE ====");
                                    }
                                    l7 = this.f;
                                    if (l7 != null) {
                                        ((M4) l7).b();
                                    }
                                } else {
                                    a(c3418j0.o());
                                }
                                return c3418j0;
                            }
                            if (jSONObject.optJSONArray("adSets") != null) {
                                zOptBoolean = jSONObject.getJSONArray("adSets").getJSONObject(0).optBoolean("logEnabled", false);
                                l13 = this.f;
                                if (l13 != null) {
                                    String TAG16 = this.d;
                                    Intrinsics.checkNotNullExpressionValue(TAG16, "TAG");
                                    ((M4) l13).a(TAG16, "server side logger lever - " + zOptBoolean);
                                }
                                l14 = this.f;
                                if (l14 != null) {
                                    ((M4) l14).a(zOptBoolean);
                                }
                            }
                            c3418j0 = null;
                            l9 = this.f;
                            if (l9 != null) {
                                String TAG17 = this.d;
                                Intrinsics.checkNotNullExpressionValue(TAG17, "TAG");
                                ((M4) l9).c(TAG17, "parseAdResponse called");
                            }
                            jSONArray = jSONObject.getJSONArray("adSets");
                            string = jSONObject.getString(C3418j0.KEY_REQUEST_ID);
                            length = jSONArray.length();
                            if (length != 0) {
                                l11 = this.f;
                                if (l11 != null) {
                                    String TAG18 = this.d;
                                    Intrinsics.checkNotNullExpressionValue(TAG18, "TAG");
                                    ((M4) l11).a(TAG18, "parseAdResponse responses available");
                                }
                                if (this.c.b() != null) {
                                    C3404i0 c3404i1 = C3418j0.Companion;
                                    JSONObject jSONObject4 = jSONArray.getJSONObject(0);
                                    Intrinsics.checkNotNullExpressionValue(jSONObject4, "getJSONObject(...)");
                                    long jL2 = this.c.l();
                                    String strB3 = this.c.b();
                                    Intrinsics.checkNotNull(string);
                                    L4 l42 = this.f;
                                    c3404i1.getClass();
                                    c3418j0A = C3404i0.a(jSONObject4, jL2, strB3, string, l42);
                                } else {
                                    c3418j0A = null;
                                }
                                if (c3418j0A == null) {
                                    l12 = this.f;
                                    if (l12 != null) {
                                        String TAG19 = this.d;
                                        Intrinsics.checkNotNullExpressionValue(TAG19, "TAG");
                                        ((M4) l12).b(TAG19, "adSet is null");
                                    }
                                    a(MapsKt.mutableMapOf(TuplesKt.to(str2, (short) 2114)));
                                    throw new C3603w(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), (short) 0);
                                }
                                c3418j0 = c3418j0A;
                                r5 = str2;
                                if (c3418j0 == null) {
                                    r5 = length;
                                    l8 = this.f;
                                    if (l8 != null) {
                                        String TAG110 = this.d;
                                        Intrinsics.checkNotNullExpressionValue(TAG110, "TAG");
                                        ((M4) l8).b(TAG110, "Could not parse ad response:" + jSONObject);
                                    }
                                    a(MapsKt.mutableMapOf(TuplesKt.to(r5, (short) 2115)));
                                    throw new C3603w(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), (short) 0);
                                }
                                r5 = length;
                                if (c3418j0.m()) {
                                    if (c3418j0.p() == null) {
                                        mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(r5, (short) 2116));
                                        boolO = c3418j0.o();
                                        if (boolO != null) {
                                            mapMutableMapOf.put("isRewarded", boolO);
                                        }
                                        a(mapMutableMapOf);
                                        throw new C3603w(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), (short) 0);
                                    }
                                    a(c3418j0.o());
                                    l6 = this.f;
                                    if (l6 != null) {
                                        String TAG111 = this.d;
                                        Intrinsics.checkNotNullExpressionValue(TAG111, "TAG");
                                        ((M4) l6).a(TAG111, "==== CHECKPOINT REACHED - PARSING COMPLETE ====");
                                    }
                                    l7 = this.f;
                                    if (l7 != null) {
                                        ((M4) l7).b();
                                    }
                                } else {
                                    a(c3418j0.o());
                                }
                                return c3418j0;
                            }
                            l10 = this.f;
                            if (l10 != null) {
                                String TAG112 = this.d;
                                Intrinsics.checkNotNullExpressionValue(TAG112, "TAG");
                                ((M4) l10).b(TAG112, "Ad response received but no ad available:" + jSONObject);
                            }
                            mapMutableMapOf2 = MapsKt.mutableMapOf(TuplesKt.to("latency", Long.valueOf(SystemClock.elapsedRealtime() - this.e)), TuplesKt.to(obj, C3435k3.q()), TuplesKt.to("plId", Long.valueOf(this.c.l())));
                            strM = this.c.m();
                            if (strM != null) {
                                mapMutableMapOf2.put("plType", strM);
                            }
                            strB = this.c.b();
                            if (strB != null) {
                                mapMutableMapOf2.put(str, strB);
                            }
                            this.b.b("ServerNoFill", mapMutableMapOf2);
                            throw new C3603w(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.NO_FILL), (short) 0);
                        }
                        if (length != 0) {
                            l11 = this.f;
                            if (l11 != null) {
                                String TAG113 = this.d;
                                Intrinsics.checkNotNullExpressionValue(TAG113, "TAG");
                                ((M4) l11).a(TAG113, "parseAdResponse responses available");
                            }
                            if (this.c.b() != null) {
                                C3404i0 c3404i2 = C3418j0.Companion;
                                JSONObject jSONObject5 = jSONArray.getJSONObject(0);
                                Intrinsics.checkNotNullExpressionValue(jSONObject5, "getJSONObject(...)");
                                long jL3 = this.c.l();
                                String strB4 = this.c.b();
                                Intrinsics.checkNotNull(string);
                                L4 l43 = this.f;
                                c3404i2.getClass();
                                c3418j0A = C3404i0.a(jSONObject5, jL3, strB4, string, l43);
                            } else {
                                c3418j0A = null;
                            }
                            if (c3418j0A == null) {
                                l12 = this.f;
                                if (l12 != null) {
                                    String TAG114 = this.d;
                                    Intrinsics.checkNotNullExpressionValue(TAG114, "TAG");
                                    ((M4) l12).b(TAG114, "adSet is null");
                                }
                                a(MapsKt.mutableMapOf(TuplesKt.to(str2, (short) 2114)));
                                throw new C3603w(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), (short) 0);
                            }
                            c3418j0 = c3418j0A;
                            r5 = str2;
                            if (c3418j0 == null) {
                                r5 = length;
                                l8 = this.f;
                                if (l8 != null) {
                                    String TAG115 = this.d;
                                    Intrinsics.checkNotNullExpressionValue(TAG115, "TAG");
                                    ((M4) l8).b(TAG115, "Could not parse ad response:" + jSONObject);
                                }
                                a(MapsKt.mutableMapOf(TuplesKt.to(r5, (short) 2115)));
                                throw new C3603w(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), (short) 0);
                            }
                            r5 = length;
                            if (c3418j0.m()) {
                                if (c3418j0.p() == null) {
                                    mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(r5, (short) 2116));
                                    boolO = c3418j0.o();
                                    if (boolO != null) {
                                        mapMutableMapOf.put("isRewarded", boolO);
                                    }
                                    a(mapMutableMapOf);
                                    throw new C3603w(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), (short) 0);
                                }
                                a(c3418j0.o());
                                l6 = this.f;
                                if (l6 != null) {
                                    String TAG116 = this.d;
                                    Intrinsics.checkNotNullExpressionValue(TAG116, "TAG");
                                    ((M4) l6).a(TAG116, "==== CHECKPOINT REACHED - PARSING COMPLETE ====");
                                }
                                l7 = this.f;
                                if (l7 != null) {
                                    ((M4) l7).b();
                                }
                            } else {
                                a(c3418j0.o());
                            }
                            return c3418j0;
                        }
                        l10 = this.f;
                        if (l10 != null) {
                            String TAG117 = this.d;
                            Intrinsics.checkNotNullExpressionValue(TAG117, "TAG");
                            ((M4) l10).b(TAG117, "Ad response received but no ad available:" + jSONObject);
                        }
                        mapMutableMapOf2 = MapsKt.mutableMapOf(TuplesKt.to("latency", Long.valueOf(SystemClock.elapsedRealtime() - this.e)), TuplesKt.to(obj, C3435k3.q()), TuplesKt.to("plId", Long.valueOf(this.c.l())));
                        strM = this.c.m();
                        if (strM != null) {
                            mapMutableMapOf2.put("plType", strM);
                        }
                        strB = this.c.b();
                        if (strB != null) {
                            mapMutableMapOf2.put(str, strB);
                        }
                        this.b.b("ServerNoFill", mapMutableMapOf2);
                        throw new C3603w(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.NO_FILL), (short) 0);
                    } catch (JSONException e3) {
                        e = e3;
                        l5 = this.f;
                        r5 = length;
                        if (l5 != null) {
                            String TAG118 = this.d;
                            Intrinsics.checkNotNullExpressionValue(TAG118, "TAG");
                            ((M4) l5).a(TAG118, "Error while parsing ad response.", e);
                        }
                    }
                    str2 = "errorCode";
                } catch (JSONException e4) {
                    e = e4;
                    obj = "networkType";
                    str = com.smaato.sdk.video.vast.model.Ad.AD_TYPE;
                }
                l9 = this.f;
                if (l9 != null) {
                    String TAG119 = this.d;
                    Intrinsics.checkNotNullExpressionValue(TAG119, "TAG");
                    ((M4) l9).c(TAG119, "parseAdResponse called");
                }
                jSONArray = jSONObject.getJSONArray("adSets");
                string = jSONObject.getString(C3418j0.KEY_REQUEST_ID);
                length = jSONArray.length();
            } catch (JSONException e5) {
                e = e5;
                length = str2;
            }
            if (jSONObject.optJSONArray("adSets") != null) {
                zOptBoolean = jSONObject.getJSONArray("adSets").getJSONObject(0).optBoolean("logEnabled", false);
                l13 = this.f;
                if (l13 != null) {
                    String TAG120 = this.d;
                    Intrinsics.checkNotNullExpressionValue(TAG120, "TAG");
                    ((M4) l13).a(TAG120, "server side logger lever - " + zOptBoolean);
                }
                l14 = this.f;
                if (l14 != null) {
                    ((M4) l14).a(zOptBoolean);
                }
            }
        } catch (JSONException e6) {
            L4 l44 = this.f;
            if (l44 != null) {
                String TAG20 = this.d;
                Intrinsics.checkNotNullExpressionValue(TAG20, "TAG");
                ((M4) l44).a(TAG20, "error while setting server-side logging lever", e6);
            }
            L4 l45 = this.f;
            if (l45 != null) {
                ((M4) l45).a(false);
            }
        }
        c3418j0 = null;
        l5 = this.f;
        r5 = length;
        if (l5 != null) {
            String TAG1110 = this.d;
            Intrinsics.checkNotNullExpressionValue(TAG1110, "TAG");
            ((M4) l5).a(TAG1110, "Error while parsing ad response.", e);
        }
        if (c3418j0 == null) {
            r5 = length;
            l8 = this.f;
            if (l8 != null) {
                String TAG1111 = this.d;
                Intrinsics.checkNotNullExpressionValue(TAG1111, "TAG");
                ((M4) l8).b(TAG1111, "Could not parse ad response:" + jSONObject);
            }
            a(MapsKt.mutableMapOf(TuplesKt.to(r5, (short) 2115)));
            throw new C3603w(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), (short) 0);
        }
        r5 = length;
        if (c3418j0.m()) {
            if (c3418j0.p() == null) {
                mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(r5, (short) 2116));
                boolO = c3418j0.o();
                if (boolO != null) {
                    mapMutableMapOf.put("isRewarded", boolO);
                }
                a(mapMutableMapOf);
                throw new C3603w(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), (short) 0);
            }
            a(c3418j0.o());
            l6 = this.f;
            if (l6 != null) {
                String TAG1112 = this.d;
                Intrinsics.checkNotNullExpressionValue(TAG1112, "TAG");
                ((M4) l6).a(TAG1112, "==== CHECKPOINT REACHED - PARSING COMPLETE ====");
            }
            l7 = this.f;
            if (l7 != null) {
                ((M4) l7).b();
            }
        } else {
            a(c3418j0.o());
        }
        return c3418j0;
    }

    public final void a(Boolean bool) {
        Map<String, Object> mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("latency", Long.valueOf(SystemClock.elapsedRealtime() - this.e)), TuplesKt.to("networkType", C3435k3.q()), TuplesKt.to("plId", Long.valueOf(this.c.l())));
        String strM = this.c.m();
        if (strM != null) {
            mapMutableMapOf.put("plType", strM);
        }
        if (bool != null) {
            mapMutableMapOf.put("isRewarded", bool);
        }
        String strB = this.c.b();
        if (strB != null) {
            mapMutableMapOf.put(com.smaato.sdk.video.vast.model.Ad.AD_TYPE, strB);
        }
        this.b.b("ServerFill", mapMutableMapOf);
    }

    public final void a(Map payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        payload.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - this.e));
        String strB = this.c.b();
        if (strB != null) {
            payload.put(com.smaato.sdk.video.vast.model.Ad.AD_TYPE, strB);
        }
        payload.put("networkType", C3435k3.q());
        payload.put("plId", Long.valueOf(this.c.l()));
        String strM = this.c.m();
        if (strM != null) {
            payload.put("plType", strM);
        }
        this.b.b("ServerError", (Map<String, Object>) payload);
    }
}
