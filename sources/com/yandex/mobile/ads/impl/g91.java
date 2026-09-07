package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.util.Log;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import com.smaato.sdk.video.vast.model.Ad;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import net.pubnative.lite.sdk.vpaid.enums.EventConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class g91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final sr0 f8980a;
    private final ch b;
    private final j82 c;
    private final kk0 d;
    private final d30 e;
    private final c10 f;
    private final z91 g;
    private final zx1 h;
    private final yu0 i;

    /* JADX WARN: Code duplicated, block: B:70:0x01b3  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v12, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v13, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v14, types: [java.util.ArrayList] */
    public final u61 a(String response, wj base64EncodingParameters) throws JSONException, p61 {
        String str;
        boolean z;
        String str2;
        String str3;
        String str4;
        zq1 zq1Var;
        Iterator<String> it;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        yy1 yy1Var;
        ?? EmptyList;
        String str10;
        n6 n6Var;
        o6 o6Var;
        nz1 nz1Var;
        pz1 pz1Var;
        base64EncodingParameters = base64EncodingParameters;
        Intrinsics.checkNotNullParameter(response, "response");
        String str11 = "base64EncodingParameters";
        Intrinsics.checkNotNullParameter(base64EncodingParameters, "base64EncodingParameters");
        JSONObject jsonResponse = new JSONObject(response);
        Intrinsics.checkNotNullParameter(jsonResponse, "jsonResponse");
        Intrinsics.checkNotNullParameter(base64EncodingParameters, "base64EncodingParameters");
        JSONObject jsonAsset = jsonResponse.getJSONObject("native");
        Intrinsics.checkNotNull(jsonAsset);
        boolean z2 = true;
        String str12 = "ads";
        String str13 = "Native Ad json has not required attributes";
        if (!h91.a(jsonAsset, "ads")) {
            throw new p61("Native Ad json has not required attributes");
        }
        List listEmptyList = CollectionsKt.emptyList();
        List listEmptyList2 = CollectionsKt.emptyList();
        List listEmptyList3 = CollectionsKt.emptyList();
        List listEmptyList4 = CollectionsKt.emptyList();
        List listEmptyList5 = CollectionsKt.emptyList();
        Iterator<String> itKeys = jsonAsset.keys();
        String str14 = "keys(...)";
        Intrinsics.checkNotNullExpressionValue(itKeys, "keys(...)");
        List listA = listEmptyList;
        List list = listEmptyList2;
        List list2 = listEmptyList3;
        List list3 = listEmptyList4;
        List list4 = listEmptyList5;
        t4 t4Var = null;
        String str15 = null;
        rx1 rx1Var = null;
        g6 g6Var = null;
        while (itKeys.hasNext()) {
            String jsonAttribute = itKeys.next();
            if (jsonAttribute != null) {
                int iHashCode = jsonAttribute.hashCode();
                String str16 = POBNativeConstants.NATIVE_ASSETS;
                String str17 = "jsonObject";
                String str18 = "renderTrackingUrls";
                itKeys = itKeys;
                String str19 = "showNotices";
                String str20 = "attributeName";
                switch (iHashCode) {
                    case -1777460514:
                        str = str11;
                        str2 = str12;
                        str3 = str13;
                        str4 = str14;
                        z = true;
                        if (jsonAttribute.equals(str19)) {
                            ArrayList arrayList = new ArrayList();
                            JSONArray jSONArray = jsonAsset.getJSONArray(str19);
                            int length = jSONArray.length();
                            for (int i = 0; i < length; i++) {
                                JSONObject jSONObject = jSONArray.getJSONObject(i);
                                Intrinsics.checkNotNull(jSONObject);
                                arrayList.add(a(jSONObject));
                            }
                            list4 = arrayList;
                        }
                        str13 = str3;
                        z2 = z;
                        itKeys = itKeys;
                        str12 = str2;
                        str11 = str;
                        str14 = str4;
                        break;
                    case -1422646231:
                        str = str11;
                        str2 = str12;
                        str3 = str13;
                        str4 = str14;
                        z = true;
                        if (jsonAttribute.equals("ad_pod")) {
                            JSONObject adPod = jsonAsset.getJSONObject("ad_pod");
                            Intrinsics.checkNotNull(adPod);
                            Intrinsics.checkNotNullParameter(adPod, "adPod");
                            JSONArray jsonArray = adPod.optJSONArray(FirebaseAnalytics.Param.ITEMS);
                            if (jsonArray != null) {
                                Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
                                int length2 = jsonArray.length();
                                EmptyList = new ArrayList(length2);
                                int i2 = 0;
                                while (i2 < length2) {
                                    JSONObject jSONObjectOptJSONObject = jsonArray.optJSONObject(i2);
                                    Intrinsics.checkNotNull(jSONObjectOptJSONObject);
                                    long jOptLong = jSONObjectOptJSONObject.optLong("duration");
                                    JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(EventConstants.SKIP);
                                    if (jSONObjectOptJSONObject2 != null) {
                                        Intrinsics.checkNotNullParameter(jSONObjectOptJSONObject2, str17);
                                        String strOptString = jSONObjectOptJSONObject2.optString("transition_strategy");
                                        nz1[] nz1VarArrValues = nz1.values();
                                        int length3 = nz1VarArrValues.length;
                                        int i3 = 0;
                                        while (true) {
                                            if (i3 < length3) {
                                                nz1 nz1Var2 = nz1VarArrValues[i3];
                                                int i4 = length3;
                                                if (Intrinsics.areEqual(nz1Var2.a(), strOptString)) {
                                                    nz1Var = nz1Var2;
                                                } else {
                                                    i3++;
                                                    length3 = i4;
                                                }
                                            } else {
                                                nz1Var = null;
                                            }
                                        }
                                        String strOptString2 = jSONObjectOptJSONObject2.optString("visibility");
                                        pz1[] pz1VarArrValues = pz1.values();
                                        int length4 = pz1VarArrValues.length;
                                        int i5 = 0;
                                        while (true) {
                                            if (i5 < length4) {
                                                pz1 pz1Var2 = pz1VarArrValues[i5];
                                                str10 = str17;
                                                if (Intrinsics.areEqual(pz1Var2.a(), strOptString2)) {
                                                    pz1Var = pz1Var2;
                                                } else {
                                                    i5++;
                                                    str17 = str10;
                                                }
                                            } else {
                                                str10 = str17;
                                                pz1Var = null;
                                            }
                                        }
                                        n6Var = new n6(nz1Var, pz1Var, jSONObjectOptJSONObject2.optLong("delay"));
                                    } else {
                                        str10 = str17;
                                        n6Var = null;
                                    }
                                    String strOptString3 = jSONObjectOptJSONObject.optString("transition_policy");
                                    o6[] o6VarArrValues = o6.values();
                                    int length5 = o6VarArrValues.length;
                                    int i6 = 0;
                                    while (true) {
                                        if (i6 >= length5) {
                                            o6Var = null;
                                        }
                                        o6Var = o6VarArrValues[i6];
                                        if (Intrinsics.areEqual(o6Var.a(), strOptString3)) {
                                        }
                                        i6++;
                                        break;
                                        break;
                                    }
                                    EmptyList.add(new m6(jOptLong, n6Var, o6Var));
                                    i2++;
                                    jsonArray = jsonArray;
                                    length2 = length2;
                                    str17 = str10;
                                }
                            } else {
                                EmptyList = CollectionsKt.emptyList();
                            }
                            base64EncodingParameters = base64EncodingParameters;
                            str13 = str3;
                            g6Var = new g6(adPod.optInt("closable_ad_position"), adPod.optInt("reward_ad_position", RangesKt.coerceAtLeast(CollectionsKt.getLastIndex(EmptyList), 0)), EmptyList);
                        }
                        z2 = z;
                        itKeys = itKeys;
                        str12 = str2;
                        str11 = str;
                        str14 = str4;
                        break;
                    case -1408207997:
                        str = str11;
                        str2 = str12;
                        str3 = str13;
                        str4 = str14;
                        z = true;
                        if (jsonAttribute.equals(POBNativeConstants.NATIVE_ASSETS)) {
                            listA = this.b.a(jsonAsset, base64EncodingParameters);
                            str13 = str3;
                            z2 = z;
                            str12 = str2;
                            str11 = str;
                            str14 = str4;
                        }
                        break;
                    case -113850029:
                        str = str11;
                        JSONObject jSONObject2 = jsonAsset;
                        str2 = str12;
                        str3 = str13;
                        str4 = str14;
                        z = true;
                        if (!jsonAttribute.equals("impressionData")) {
                            jsonAsset = jSONObject2;
                            break;
                        } else {
                            this.d.getClass();
                            jsonAsset = jSONObject2;
                            Intrinsics.checkNotNullParameter(jsonAsset, "jsonObject");
                            Intrinsics.checkNotNullParameter("impressionData", str20);
                            try {
                                rq0 rq0Var = rq0.f10131a;
                                Intrinsics.checkNotNullParameter(jsonAsset, "jsonAsset");
                                Intrinsics.checkNotNullParameter("impressionData", "jsonAttribute");
                                String string = jsonAsset.getString("impressionData");
                                Intrinsics.checkNotNull(string);
                                if (string.length() == 0 || Intrinsics.areEqual("null", string)) {
                                    throw new JSONException("Json has not required attributes");
                                }
                                str13 = str3;
                                t4Var = new t4(string);
                                z2 = z;
                                str12 = str2;
                                str11 = str;
                                str14 = str4;
                            } catch (Exception e) {
                                Log.e("ImpressionDataParser", String.valueOf(e.getMessage()));
                                str13 = str3;
                                z2 = true;
                                itKeys = itKeys;
                                str12 = str2;
                                str11 = str;
                                str14 = str4;
                                t4Var = null;
                            }
                        }
                        break;
                    case 96432:
                        if (jsonAttribute.equals(str12)) {
                            ArrayList arrayList2 = new ArrayList();
                            String str21 = str13;
                            JSONArray jSONArray2 = jsonAsset.getJSONArray(str12);
                            String str22 = str12;
                            int length6 = jSONArray2.length();
                            JSONObject jSONObject3 = jsonAsset;
                            int i7 = 0;
                            while (i7 < length6) {
                                int i8 = length6;
                                JSONObject jsonAsset2 = jSONArray2.getJSONObject(i7);
                                Intrinsics.checkNotNull(jsonAsset2);
                                Intrinsics.checkNotNullParameter(jsonAsset2, "jsonNativeAd");
                                Intrinsics.checkNotNullParameter(base64EncodingParameters, str11);
                                String str23 = str11;
                                JSONArray jSONArray3 = jSONArray2;
                                String str24 = str16;
                                String str25 = "link";
                                if (!h91.a(jsonAsset2, Ad.AD_TYPE, str16, "link")) {
                                    throw new p61(str21);
                                }
                                this.g.getClass();
                                Intrinsics.checkNotNullParameter(jsonAsset2, "jsonNativeAd");
                                Intrinsics.checkNotNullParameter(jsonAsset2, "jsonAsset");
                                Intrinsics.checkNotNullParameter(Ad.AD_TYPE, "jsonAttribute");
                                String strOptString4 = jsonAsset2.optString(Ad.AD_TYPE);
                                if (strOptString4 == null || strOptString4.length() == 0 || Intrinsics.areEqual(strOptString4, "null")) {
                                    throw new p61(str21);
                                }
                                Intrinsics.checkNotNull(strOptString4);
                                zq1[] zq1VarArrValues = zq1.values();
                                int length7 = zq1VarArrValues.length;
                                int i9 = i7;
                                int i10 = 0;
                                while (true) {
                                    if (i10 < length7) {
                                        zq1 zq1Var2 = zq1VarArrValues[i10];
                                        zq1[] zq1VarArr = zq1VarArrValues;
                                        if (Intrinsics.areEqual(zq1Var2.a(), strOptString4)) {
                                            zq1Var = zq1Var2;
                                        } else {
                                            i10++;
                                            zq1VarArrValues = zq1VarArr;
                                        }
                                    } else {
                                        zq1Var = null;
                                    }
                                }
                                if (zq1Var == null) {
                                    throw new p61(str21);
                                }
                                ArrayList arrayListA = this.b.a(jsonAsset2, base64EncodingParameters);
                                HashSet hashSet = new HashSet();
                                HashSet hashSet2 = new HashSet();
                                Iterator<String> itKeys2 = jsonAsset2.keys();
                                Intrinsics.checkNotNullExpressionValue(itKeys2, str14);
                                String strOptString5 = null;
                                String strOptString6 = null;
                                rr0 rr0VarA = null;
                                t4 t4Var2 = null;
                                fb0 fb0VarA = null;
                                fb0 fb0VarA2 = null;
                                while (itKeys2.hasNext()) {
                                    String next = itKeys2.next();
                                    if (next != null) {
                                        switch (next.hashCode()) {
                                            case -1798519398:
                                                it = itKeys2;
                                                str5 = str14;
                                                str6 = str18;
                                                str9 = str20;
                                                str7 = str19;
                                                str8 = str25;
                                                if (next.equals("hideConditions")) {
                                                    fr frVar = new fr();
                                                    Intrinsics.checkNotNull(next);
                                                    fb0VarA = frVar.a(next, jsonAsset2);
                                                }
                                                str25 = str8;
                                                str19 = str7;
                                                str14 = str5;
                                                str18 = str6;
                                                str20 = str9;
                                                itKeys2 = it;
                                                break;
                                            case -1777460514:
                                                it = itKeys2;
                                                str5 = str14;
                                                str6 = str18;
                                                String str26 = str19;
                                                str9 = str20;
                                                if (next.equals(str26)) {
                                                    ArrayList arrayList3 = new ArrayList();
                                                    JSONArray jSONArray4 = jsonAsset2.getJSONArray(str26);
                                                    str8 = str25;
                                                    int length8 = jSONArray4.length();
                                                    str7 = str26;
                                                    int i11 = 0;
                                                    while (i11 < length8) {
                                                        int i12 = length8;
                                                        JSONObject jSONObject4 = jSONArray4.getJSONObject(i11);
                                                        Intrinsics.checkNotNull(jSONObject4);
                                                        arrayList3.add(a(jSONObject4));
                                                        i11++;
                                                        length8 = i12;
                                                    }
                                                    hashSet2.addAll(arrayList3);
                                                } else {
                                                    str8 = str25;
                                                    str7 = str26;
                                                }
                                                str25 = str8;
                                                str19 = str7;
                                                str14 = str5;
                                                str18 = str6;
                                                str20 = str9;
                                                itKeys2 = it;
                                                break;
                                            case -113850029:
                                                it = itKeys2;
                                                str5 = str14;
                                                str6 = str18;
                                                if (next.equals("impressionData")) {
                                                    this.d.getClass();
                                                    Intrinsics.checkNotNullParameter(jsonAsset2, "jsonObject");
                                                    String str27 = str20;
                                                    Intrinsics.checkNotNullParameter("impressionData", str27);
                                                    try {
                                                        rq0 rq0Var2 = rq0.f10131a;
                                                        Intrinsics.checkNotNullParameter(jsonAsset2, "jsonAsset");
                                                        Intrinsics.checkNotNullParameter("impressionData", "jsonAttribute");
                                                        String string2 = jsonAsset2.getString("impressionData");
                                                        Intrinsics.checkNotNull(string2);
                                                        if (string2.length() == 0 || Intrinsics.areEqual("null", string2)) {
                                                            throw new JSONException("Json has not required attributes");
                                                        }
                                                        str20 = str27;
                                                        t4Var2 = new t4(string2);
                                                        itKeys2 = it;
                                                        str14 = str5;
                                                        str18 = str6;
                                                    } catch (Exception e2) {
                                                        Log.e("ImpressionDataParser", String.valueOf(e2.getMessage()));
                                                        str20 = str27;
                                                        itKeys2 = it;
                                                        str14 = str5;
                                                        str18 = str6;
                                                        t4Var2 = null;
                                                    }
                                                } else {
                                                    str9 = str20;
                                                    str7 = str19;
                                                    str8 = str25;
                                                    str25 = str8;
                                                    str19 = str7;
                                                    str14 = str5;
                                                    str18 = str6;
                                                    str20 = str9;
                                                    itKeys2 = it;
                                                }
                                                break;
                                            case 3355:
                                                it = itKeys2;
                                                str5 = str14;
                                                str6 = str18;
                                                if (next.equals("id")) {
                                                    strOptString5 = jsonAsset2.optString("id", "");
                                                    Intrinsics.checkNotNull(strOptString5);
                                                    if (strOptString5.length() > 0) {
                                                        itKeys2 = it;
                                                        str14 = str5;
                                                        str18 = str6;
                                                    } else {
                                                        itKeys2 = it;
                                                        str14 = str5;
                                                        str18 = str6;
                                                        strOptString5 = null;
                                                    }
                                                } else {
                                                    str9 = str20;
                                                    str7 = str19;
                                                    str8 = str25;
                                                    str25 = str8;
                                                    str19 = str7;
                                                    str14 = str5;
                                                    str18 = str6;
                                                    str20 = str9;
                                                    itKeys2 = it;
                                                }
                                                break;
                                            case 3237038:
                                                it = itKeys2;
                                                str5 = str14;
                                                str6 = str18;
                                                if (next.equals("info")) {
                                                    strOptString6 = jsonAsset2.optString(next, "");
                                                    Intrinsics.checkNotNull(strOptString6);
                                                    if (strOptString6.length() > 0) {
                                                        itKeys2 = it;
                                                        str14 = str5;
                                                        str18 = str6;
                                                    } else {
                                                        itKeys2 = it;
                                                        str14 = str5;
                                                        str18 = str6;
                                                        strOptString6 = null;
                                                    }
                                                } else {
                                                    str9 = str20;
                                                    str7 = str19;
                                                    str8 = str25;
                                                    str25 = str8;
                                                    str19 = str7;
                                                    str14 = str5;
                                                    str18 = str6;
                                                    str20 = str9;
                                                    itKeys2 = it;
                                                }
                                                break;
                                            case 3321850:
                                                it = itKeys2;
                                                str5 = str14;
                                                str6 = str18;
                                                if (next.equals(str25)) {
                                                    JSONObject jSONObject5 = jsonAsset2.getJSONObject(next);
                                                    sr0 sr0Var = this.f8980a;
                                                    Intrinsics.checkNotNull(jSONObject5);
                                                    rr0VarA = sr0Var.a(jSONObject5, base64EncodingParameters);
                                                    itKeys2 = it;
                                                    str14 = str5;
                                                    str18 = str6;
                                                } else {
                                                    str9 = str20;
                                                    str7 = str19;
                                                    str8 = str25;
                                                    str25 = str8;
                                                    str19 = str7;
                                                    str14 = str5;
                                                    str18 = str6;
                                                    str20 = str9;
                                                    itKeys2 = it;
                                                }
                                                break;
                                            case 458247106:
                                                it = itKeys2;
                                                str5 = str14;
                                                str6 = str18;
                                                if (next.equals("renderTrackingUrl")) {
                                                    j82 j82Var = this.c;
                                                    Intrinsics.checkNotNull(next);
                                                    j82Var.getClass();
                                                    hashSet.add(j82.a(next, jsonAsset2));
                                                }
                                                str9 = str20;
                                                str7 = str19;
                                                str8 = str25;
                                                str25 = str8;
                                                str19 = str7;
                                                str14 = str5;
                                                str18 = str6;
                                                str20 = str9;
                                                itKeys2 = it;
                                                break;
                                            case 635399221:
                                                it = itKeys2;
                                                str5 = str14;
                                                str6 = str18;
                                                if (next.equals("showNotice")) {
                                                    JSONObject jSONObject6 = jsonAsset2.getJSONObject(next);
                                                    Intrinsics.checkNotNull(jSONObject6);
                                                    hashSet2.add(a(jSONObject6));
                                                }
                                                str9 = str20;
                                                str7 = str19;
                                                str8 = str25;
                                                str25 = str8;
                                                str19 = str7;
                                                str14 = str5;
                                                str18 = str6;
                                                str20 = str9;
                                                itKeys2 = it;
                                                break;
                                            case 663229845:
                                                it = itKeys2;
                                                str5 = str14;
                                                str6 = str18;
                                                if (next.equals("showConditions")) {
                                                    fr frVar2 = new fr();
                                                    Intrinsics.checkNotNull(next);
                                                    fb0VarA2 = frVar2.a(next, jsonAsset2);
                                                    itKeys2 = it;
                                                    str14 = str5;
                                                    str18 = str6;
                                                } else {
                                                    str9 = str20;
                                                    str7 = str19;
                                                    str8 = str25;
                                                    str25 = str8;
                                                    str19 = str7;
                                                    str14 = str5;
                                                    str18 = str6;
                                                    str20 = str9;
                                                    itKeys2 = it;
                                                }
                                                break;
                                            case 1320758513:
                                                if (next.equals(str18)) {
                                                    ArrayList arrayList4 = new ArrayList();
                                                    it = itKeys2;
                                                    JSONArray jSONArray5 = jsonAsset2.getJSONArray(str18);
                                                    str5 = str14;
                                                    int length9 = jSONArray5.length();
                                                    str6 = str18;
                                                    int i13 = 0;
                                                    while (i13 < length9) {
                                                        int i14 = length9;
                                                        String string3 = jSONArray5.getString(i13);
                                                        Intrinsics.checkNotNull(string3);
                                                        arrayList4.add(string3);
                                                        i13++;
                                                        length9 = i14;
                                                    }
                                                    hashSet.addAll(arrayList4);
                                                }
                                                str9 = str20;
                                                str7 = str19;
                                                str8 = str25;
                                                str25 = str8;
                                                str19 = str7;
                                                str14 = str5;
                                                str18 = str6;
                                                str20 = str9;
                                                itKeys2 = it;
                                                break;
                                            default:
                                                break;
                                        }
                                    }
                                    it = itKeys2;
                                    str5 = str14;
                                    str6 = str18;
                                    str9 = str20;
                                    str7 = str19;
                                    str8 = str25;
                                    str25 = str8;
                                    str19 = str7;
                                    str14 = str5;
                                    str18 = str6;
                                    str20 = str9;
                                    itKeys2 = it;
                                }
                                String str28 = str14;
                                String str29 = str18;
                                String str30 = str20;
                                String str31 = str19;
                                c41 c41Var = new c41(zq1Var, arrayListA, strOptString5, strOptString6, rr0VarA, t4Var2, fb0VarA, fb0VarA2, CollectionsKt.toList(hashSet), CollectionsKt.toList(hashSet2));
                                List<ig<?>> listB = c41Var.b();
                                rr0 rr0VarE = c41Var.e();
                                if (listB.isEmpty() || rr0VarE == null) {
                                    throw new p61(str21);
                                }
                                arrayList2.add(c41Var);
                                i7 = i9 + 1;
                                length6 = i8;
                                str19 = str31;
                                str11 = str23;
                                str16 = str24;
                                str14 = str28;
                                str18 = str29;
                                str20 = str30;
                                jSONArray2 = jSONArray3;
                            }
                            list = arrayList2;
                            z2 = true;
                            str13 = str21;
                            str12 = str22;
                            jsonAsset = jSONObject3;
                        } else {
                            str = str11;
                            str2 = str12;
                            str3 = str13;
                            str4 = str14;
                            z = true;
                        }
                        break;
                    case 116643:
                        if (!jsonAttribute.equals("ver")) {
                            str = str11;
                            str2 = str12;
                            str3 = str13;
                            str4 = str14;
                            z = true;
                        } else {
                            Intrinsics.checkNotNull(jsonAttribute);
                            Intrinsics.checkNotNullParameter(jsonAsset, "jsonAsset");
                            Intrinsics.checkNotNullParameter(jsonAttribute, "jsonAttribute");
                            String strOptString7 = jsonAsset.optString(jsonAttribute);
                            if (strOptString7 == null || strOptString7.length() == 0 || Intrinsics.areEqual(strOptString7, "null")) {
                                throw new p61(str13);
                            }
                            Intrinsics.checkNotNull(strOptString7);
                            str15 = strOptString7;
                            z2 = true;
                        }
                        break;
                    case 1320758513:
                        if (jsonAttribute.equals("renderTrackingUrls")) {
                            ArrayList arrayList5 = new ArrayList();
                            JSONArray jSONArray6 = jsonAsset.getJSONArray("renderTrackingUrls");
                            int length10 = jSONArray6.length();
                            for (int i15 = 0; i15 < length10; i15++) {
                                String string4 = jSONArray6.getString(i15);
                                Intrinsics.checkNotNull(string4);
                                arrayList5.add(string4);
                            }
                            list2 = arrayList5;
                            z2 = true;
                        } else {
                            str = str11;
                            str2 = str12;
                            str3 = str13;
                            str4 = str14;
                            z = true;
                        }
                        break;
                    case 1434631203:
                        if (jsonAttribute.equals("settings")) {
                            JSONObject jsonAsset3 = jsonAsset.getJSONObject("settings");
                            Iterator<String> itKeys3 = jsonAsset3.keys();
                            Intrinsics.checkNotNullExpressionValue(itKeys3, str14);
                            JSONObject jsonObject = null;
                            String str32 = null;
                            Long lValueOf = null;
                            boolean z3 = false;
                            boolean zOptBoolean = false;
                            while (itKeys3.hasNext()) {
                                String jsonAttribute2 = itKeys3.next();
                                if (jsonAttribute2 != null) {
                                    switch (jsonAttribute2.hashCode()) {
                                        case -975961388:
                                            if (!jsonAttribute2.equals("templateType")) {
                                                continue;
                                            } else {
                                                Intrinsics.checkNotNull(jsonAsset3);
                                                Intrinsics.checkNotNull(jsonAttribute2);
                                                Intrinsics.checkNotNullParameter(jsonAsset3, "jsonAsset");
                                                Intrinsics.checkNotNullParameter(jsonAttribute2, "jsonAttribute");
                                                String strOptString8 = jsonAsset3.optString(jsonAttribute2);
                                                if (strOptString8 == null || strOptString8.length() == 0 || Intrinsics.areEqual(strOptString8, "null")) {
                                                    throw new p61(str13);
                                                }
                                                Intrinsics.checkNotNull(strOptString8);
                                                str32 = strOptString8;
                                            }
                                            break;
                                        case 370967731:
                                            if (jsonAttribute2.equals("highlightingEnabled")) {
                                                z3 = jsonAsset3.getBoolean(jsonAttribute2);
                                            }
                                            break;
                                        case 1352271078:
                                            if (jsonAttribute2.equals("multiBannerAutoScrollInterval")) {
                                                lValueOf = Long.valueOf(jsonAsset3.getLong(jsonAttribute2));
                                            }
                                            break;
                                        case 1971060391:
                                            if (jsonAttribute2.equals("isLoopingVideo")) {
                                                zOptBoolean = jsonAsset3.optBoolean(jsonAttribute2);
                                            }
                                            break;
                                        case 2028941137:
                                            if (jsonAttribute2.equals("mediaAssetImageFallback")) {
                                                jsonObject = jsonAsset3.getJSONObject(jsonAttribute2);
                                            }
                                            break;
                                    }
                                }
                            }
                            if (jsonObject != null) {
                                this.i.getClass();
                                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                                if (jsonObject.has("width") && jsonObject.has("height")) {
                                    yy1Var = new yy1(jsonObject.getInt("width"), jsonObject.getInt("height"));
                                } else {
                                    yy1Var = null;
                                }
                            } else {
                                yy1Var = null;
                            }
                            rx1Var = new rx1(str32, lValueOf, z3, zOptBoolean, yy1Var);
                            z2 = true;
                        } else {
                            str = str11;
                            str2 = str12;
                            str3 = str13;
                            str4 = str14;
                            z = true;
                        }
                        break;
                    case 1557034613:
                        if (jsonAttribute.equals("designs")) {
                            boolean zA = base64EncodingParameters.a();
                            ArrayList arrayList6 = new ArrayList();
                            JSONArray jSONArray7 = jsonAsset.getJSONArray("designs");
                            int length11 = jSONArray7.length();
                            for (int i16 = 0; i16 < length11; i16++) {
                                JSONObject jSONObject7 = jSONArray7.getJSONObject(i16);
                                c10 c10Var = this.f;
                                Intrinsics.checkNotNull(jSONObject7);
                                x00 x00VarA = c10Var.a(jSONObject7);
                                y20 y20VarA = x00VarA != null ? this.e.a(x00VarA, zA) : null;
                                if (y20VarA != null) {
                                    arrayList6.add(y20VarA);
                                }
                            }
                            list3 = arrayList6;
                            z2 = true;
                        } else {
                            str = str11;
                            str2 = str12;
                            str3 = str13;
                            str4 = str14;
                            z = true;
                        }
                        break;
                    default:
                        str = str11;
                        str2 = str12;
                        str3 = str13;
                        str4 = str14;
                        z = true;
                        break;
                }
            } else {
                str = str11;
                z = z2;
                str2 = str12;
                str3 = str13;
                itKeys = itKeys;
                str4 = str14;
            }
            str13 = str3;
            z2 = z;
            itKeys = itKeys;
            str12 = str2;
            str11 = str;
            str14 = str4;
        }
        String str33 = str13;
        if (list.isEmpty()) {
            throw new p61(str33);
        }
        return new u61(list, listA, list2, t4Var, MapsKt.mapOf(TuplesKt.to("status", hp1.c.c)), list3, list4, str15, rx1Var, g6Var);
    }

    public /* synthetic */ g91(Context context, lp1 lp1Var) {
        sr0 sr0Var = new sr0(lp1Var);
        this(context, lp1Var, sr0Var, new ch(context, lp1Var, sr0Var, 8), new j82(), new kk0(), new d30(lp1Var), new c10(), new z91(), new zx1(), new yu0());
    }

    public g91(Context context, lp1 reporter, sr0 linkJsonParser, ch assetsJsonParser, j82 urlJsonParser, kk0 impressionDataParser, d30 divKitDesignParser, c10 designJsonParser, z91 nativeResponseTypeParser, zx1 showNoticeTypeProvider, yu0 mediaAssetImageFallbackSizeParser) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(linkJsonParser, "linkJsonParser");
        Intrinsics.checkNotNullParameter(assetsJsonParser, "assetsJsonParser");
        Intrinsics.checkNotNullParameter(urlJsonParser, "urlJsonParser");
        Intrinsics.checkNotNullParameter(impressionDataParser, "impressionDataParser");
        Intrinsics.checkNotNullParameter(divKitDesignParser, "divKitDesignParser");
        Intrinsics.checkNotNullParameter(designJsonParser, "designJsonParser");
        Intrinsics.checkNotNullParameter(nativeResponseTypeParser, "nativeResponseTypeParser");
        Intrinsics.checkNotNullParameter(showNoticeTypeProvider, "showNoticeTypeProvider");
        Intrinsics.checkNotNullParameter(mediaAssetImageFallbackSizeParser, "mediaAssetImageFallbackSizeParser");
        this.f8980a = linkJsonParser;
        this.b = assetsJsonParser;
        this.c = urlJsonParser;
        this.d = impressionDataParser;
        this.e = divKitDesignParser;
        this.f = designJsonParser;
        this.g = nativeResponseTypeParser;
        this.h = showNoticeTypeProvider;
        this.i = mediaAssetImageFallbackSizeParser;
    }

    public final xx1 a(JSONObject jsonShowNotice) throws JSONException, p61 {
        Object objM7904constructorimpl;
        Object objM7904constructorimpl2;
        Object objM7904constructorimpl3;
        Object objM7904constructorimpl4;
        Object objM7904constructorimpl5;
        yx1 yx1Var;
        Intrinsics.checkNotNullParameter(jsonShowNotice, "jsonShowNotice");
        if (h91.a(jsonShowNotice, "delay", "url")) {
            try {
                Result.Companion companion = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(Long.valueOf(jsonShowNotice.getLong("delay")));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m7910isFailureimpl(objM7904constructorimpl)) {
                objM7904constructorimpl = null;
            }
            Long l = (Long) objM7904constructorimpl;
            long jLongValue = l != null ? l.longValue() : 0L;
            try {
                Result.Companion companion3 = Result.INSTANCE;
                this.c.getClass();
                objM7904constructorimpl2 = Result.m7904constructorimpl(j82.a("url", jsonShowNotice));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objM7904constructorimpl2 = Result.m7904constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m7910isFailureimpl(objM7904constructorimpl2)) {
                objM7904constructorimpl2 = null;
            }
            String url = (String) objM7904constructorimpl2;
            try {
                Result.Companion companion5 = Result.INSTANCE;
                objM7904constructorimpl3 = Result.m7904constructorimpl(Double.valueOf(jsonShowNotice.optInt("visibilityPercent", 0)));
            } catch (Throwable th3) {
                Result.Companion companion6 = Result.INSTANCE;
                objM7904constructorimpl3 = Result.m7904constructorimpl(ResultKt.createFailure(th3));
            }
            if (Result.m7910isFailureimpl(objM7904constructorimpl3)) {
                objM7904constructorimpl3 = null;
            }
            Double d = (Double) objM7904constructorimpl3;
            int iCoerceIn = (int) RangesKt.coerceIn(d != null ? d.doubleValue() : 0.0d, 0.0d, 100.0d);
            try {
                Result.Companion companion7 = Result.INSTANCE;
                objM7904constructorimpl4 = Result.m7904constructorimpl(jsonShowNotice.getString("type"));
            } catch (Throwable th4) {
                Result.Companion companion8 = Result.INSTANCE;
                objM7904constructorimpl4 = Result.m7904constructorimpl(ResultKt.createFailure(th4));
            }
            if (Result.m7910isFailureimpl(objM7904constructorimpl4)) {
                objM7904constructorimpl4 = null;
            }
            String str = (String) objM7904constructorimpl4;
            if (str != null) {
                try {
                    Result.Companion companion9 = Result.INSTANCE;
                    String upperCase = str.toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                    objM7904constructorimpl5 = Result.m7904constructorimpl(yx1.valueOf(upperCase));
                } catch (Throwable th5) {
                    Result.Companion companion10 = Result.INSTANCE;
                    objM7904constructorimpl5 = Result.m7904constructorimpl(ResultKt.createFailure(th5));
                }
                if (Result.m7910isFailureimpl(objM7904constructorimpl5)) {
                    objM7904constructorimpl5 = null;
                }
                yx1Var = (yx1) objM7904constructorimpl5;
            } else {
                yx1Var = null;
            }
            if (yx1Var == null) {
                if (url != null) {
                    this.h.getClass();
                    Intrinsics.checkNotNullParameter(url, "url");
                    if (StringsKt.contains$default((CharSequence) url, (CharSequence) "/rtbcount/", false, 2, (Object) null)) {
                        yx1Var = yx1.c;
                    } else if (StringsKt.contains$default((CharSequence) url, (CharSequence) "/count/", false, 2, (Object) null)) {
                        yx1Var = yx1.b;
                    } else {
                        yx1Var = yx1.d;
                    }
                } else {
                    yx1Var = yx1.d;
                }
            }
            return new xx1(iCoerceIn, jLongValue, yx1Var, url);
        }
        throw new p61("Native Ad json has not required attributes");
    }
}
