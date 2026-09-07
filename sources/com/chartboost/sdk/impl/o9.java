package com.chartboost.sdk.impl;

import com.pubmatic.sdk.openwrap.core.POBConstants;
import com.smaato.sdk.core.dns.DnsName;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class o9 {
    public final a A;
    public b B;
    public final String C;
    public final ia D;
    public final lb E;
    public final n7 F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1096a;
    public final boolean b;
    public final boolean c;
    public final List<String> d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final int m;
    public final int n;
    public final int o;
    public final List<String> p;
    public final boolean q;
    public final boolean r;
    public final boolean s;
    public final int t;
    public final boolean u;
    public final int v;
    public final boolean w;
    public final String x;
    public final String y;
    public final boolean z;

    public n3 k() {
        return new n3(this.f1096a, this.q, this.x);
    }

    public o9(JSONObject jSONObject) {
        this.f1096a = jSONObject.optString("configVariant");
        this.b = jSONObject.optBoolean("prefetchDisable");
        this.c = jSONObject.optBoolean("publisherDisable");
        this.A = a.a(jSONObject);
        try {
            this.B = b.a(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.C = jSONObject.optString("publisherWarning", null);
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("invalidateFolderList");
        if (jSONArrayOptJSONArray != null) {
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                String strOptString = jSONArrayOptJSONArray.optString(i);
                if (!strOptString.isEmpty()) {
                    arrayList.add(strOptString);
                }
            }
        }
        this.d = Collections.unmodifiableList(arrayList);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("trackingLevels");
        jSONObjectOptJSONObject = jSONObjectOptJSONObject == null ? new JSONObject() : jSONObjectOptJSONObject;
        this.e = jSONObjectOptJSONObject.optBoolean("critical", true);
        this.l = jSONObjectOptJSONObject.optBoolean("includeStackTrace", true);
        this.f = jSONObjectOptJSONObject.optBoolean("error");
        this.g = jSONObjectOptJSONObject.optBoolean("debug");
        this.h = jSONObjectOptJSONObject.optBoolean("session");
        this.i = jSONObjectOptJSONObject.optBoolean("system");
        this.j = jSONObjectOptJSONObject.optBoolean("timing");
        this.k = jSONObjectOptJSONObject.optBoolean(POBConstants.KEY_USER);
        this.D = ja.b(jSONObject);
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("videoPreCaching");
        this.E = lb.a(jSONObjectOptJSONObject2 == null ? new JSONObject() : jSONObjectOptJSONObject2);
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("omSdk");
        this.F = o7.b(jSONObjectOptJSONObject3 == null ? new JSONObject() : jSONObjectOptJSONObject3);
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject(com.ironsource.b9.h.K);
        jSONObjectOptJSONObject4 = jSONObjectOptJSONObject4 == null ? new JSONObject() : jSONObjectOptJSONObject4;
        this.m = jSONObjectOptJSONObject4.optInt("cacheMaxBytes", 104857600);
        int iOptInt = jSONObjectOptJSONObject4.optInt("cacheMaxUnits", 10);
        this.n = iOptInt > 0 ? iOptInt : 10;
        this.o = (int) TimeUnit.SECONDS.toDays(jSONObjectOptJSONObject4.optInt("cacheTTLs", r1.f1120a));
        ArrayList arrayList2 = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject4.optJSONArray("directories");
        if (jSONArrayOptJSONArray2 != null) {
            int length2 = jSONArrayOptJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                String strOptString2 = jSONArrayOptJSONArray2.optString(i2);
                if (!strOptString2.isEmpty()) {
                    arrayList2.add(strOptString2);
                }
            }
        }
        this.p = Collections.unmodifiableList(arrayList2);
        this.q = jSONObjectOptJSONObject4.optBoolean("enabled", i());
        this.r = jSONObjectOptJSONObject4.optBoolean("inplayEnabled", true);
        this.s = jSONObjectOptJSONObject4.optBoolean("interstitialEnabled", true);
        int iOptInt2 = jSONObjectOptJSONObject4.optInt("invalidatePendingImpression", 3);
        this.t = iOptInt2 <= 0 ? 3 : iOptInt2;
        this.u = jSONObjectOptJSONObject4.optBoolean("lockOrientation", true);
        this.v = jSONObjectOptJSONObject4.optInt("prefetchSession", 3);
        this.w = jSONObjectOptJSONObject4.optBoolean("rewardVideoEnabled", true);
        String strOptString3 = jSONObjectOptJSONObject4.optString("version", com.moloco.sdk.internal.services.bidtoken.s.f6343a);
        this.x = strOptString3;
        this.y = String.format("%s/%s%s", com.ironsource.b9.h.K, strOptString3, "/prefetch");
        this.z = jSONObjectOptJSONObject4.optBoolean("redirectOpenToNativeBrowser", false);
    }

    public a a() {
        return this.A;
    }

    public boolean e() {
        return this.c;
    }

    public boolean d() {
        return this.b;
    }

    public String f() {
        return this.C;
    }

    public ia g() {
        return this.D;
    }

    public lb c() {
        return this.E;
    }

    public n7 b() {
        return this.F;
    }

    public boolean h() {
        return this.q;
    }

    public boolean j() {
        return this.u;
    }

    public static boolean i() {
        int[] iArr = {4, 4, 2};
        String strA = v0.b().a();
        if (strA != null && strA.length() > 0) {
            String[] strArrSplit = strA.replaceAll("[^\\d.]", "").split(DnsName.ESCAPED_DOT);
            for (int i = 0; i < strArrSplit.length && i < 3; i++) {
                try {
                    if (Integer.parseInt(strArrSplit[i]) > iArr[i]) {
                        return true;
                    }
                    if (Integer.parseInt(strArrSplit[i]) < iArr[i]) {
                        return false;
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        return false;
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HashSet<String> f1098a;

        public static void a(HashSet<String> hashSet, int i) {
            if (i == 0) {
                hashSet.clear();
            }
        }

        public HashSet<String> a() {
            return this.f1098a;
        }

        public static void a(JSONArray jSONArray, HashSet<String> hashSet, int i) throws JSONException {
            for (int i2 = 0; i2 < i; i2++) {
                hashSet.add(jSONArray.getString(i2));
            }
        }

        public static b a(JSONObject jSONObject) throws JSONException {
            b bVar = new b();
            HashSet<String> hashSet = new HashSet<>();
            hashSet.add("us_privacy");
            hashSet.add("coppa");
            hashSet.add("lgpd");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("privacyStandards");
            if (jSONArrayOptJSONArray != null) {
                int length = jSONArrayOptJSONArray.length();
                a(jSONArrayOptJSONArray, hashSet, length);
                a(hashSet, length);
            }
            bVar.f1098a = hashSet;
            return bVar;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1097a;

        public boolean a() {
            return this.f1097a;
        }

        public static a a(JSONObject jSONObject) {
            a aVar = new a();
            aVar.f1097a = jSONObject.optBoolean("bannerEnable", true);
            return aVar;
        }
    }
}
