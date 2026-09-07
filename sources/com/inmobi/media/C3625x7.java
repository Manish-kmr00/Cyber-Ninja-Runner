package com.inmobi.media;

import android.graphics.Point;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.compose.material.OutlinedTextFieldKt;
import com.adjust.sdk.Constants;
import com.facebook.share.internal.ShareConstants;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.google.firebase.ktx.BuildConfig;
import com.inmobi.commons.core.configs.AdConfig;
import io.bidmachine.iab.vast.tags.VastTagName;
import io.bidmachine.unified.UnifiedMediationParams;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import net.pubnative.lite.sdk.vpaid.enums.EventConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.inmobi.media.x7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3625x7 {
    public static final /* synthetic */ int u = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f3475a;
    public final byte b;
    public final boolean c;
    public final JSONObject d;
    public final C3513p7 e;
    public final JSONArray f;
    public C3625x7 g;
    public final HashMap h;
    public final HashMap i;
    public final HashMap j;
    public final HashMap k;
    public Qc l;
    public final AdConfig m;
    public final L4 n;
    public final int o;
    public final C3611w7 p;
    public boolean q;
    public M8 r;
    public final boolean s;
    public final Map t;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C3625x7(int i, JSONObject pubContent, AdConfig adConfig, HashMap map, Qc qc, L4 l4) {
        this(i, pubContent, null, false, adConfig, map, qc, l4);
        Intrinsics.checkNotNullParameter(pubContent, "pubContent");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
    }

    public static int a(int i) {
        return (int) (AbstractC3565t3.b() * i);
    }

    public final C3513p7 b(int i) {
        C3513p7 c3513p7 = this.e;
        if (c3513p7 != null) {
            int i2 = 0;
            while (i2 < c3513p7.B) {
                try {
                    int i3 = i2 + 1;
                    C3455l7 c3455l7 = (C3455l7) c3513p7.A.get(i2);
                    Intrinsics.checkNotNull(c3455l7);
                    if (StringsKt.equals(c3455l7.b, "card_scrollable", true)) {
                        C3513p7 c3513p8 = c3455l7 instanceof C3513p7 ? (C3513p7) c3455l7 : null;
                        if (i >= (c3513p8 != null ? c3513p8.B : 0)) {
                            return null;
                        }
                        C3455l7 c3455l8 = (c3513p8 == null || i < 0 || i >= c3513p8.B) ? null : (C3455l7) c3513p8.A.get(i);
                        if (c3455l8 instanceof C3513p7) {
                            return (C3513p7) c3455l8;
                        }
                        return null;
                    }
                    i2 = i3;
                } catch (IndexOutOfBoundsException e) {
                    throw new NoSuchElementException(e.getMessage());
                }
            }
        }
        return null;
    }

    public final ArrayList c() {
        HashMap map = this.i;
        return new ArrayList(map != null ? map.keySet() : null);
    }

    public final int d() {
        C3513p7<C3455l7> c3513p7 = this.e;
        if (c3513p7 == null) {
            return 0;
        }
        for (C3455l7 c3455l7 : c3513p7) {
            if (StringsKt.equals(c3455l7.b, "card_scrollable", true)) {
                if (c3455l7 instanceof C3513p7) {
                    return ((C3513p7) c3455l7).B;
                }
                return 0;
            }
        }
        return 0;
    }

    public final JSONObject e() {
        try {
            JSONArray jSONArray = this.f;
            if (jSONArray != null) {
                return jSONArray.getJSONObject(0);
            }
        } catch (JSONException e) {
            L4 l4 = this.n;
            if (l4 != null) {
                ((M4) l4).b("x7", AbstractC3506p0.a(e, O5.a("x7", "TAG", "Exception while getting Pages - ")));
            }
        }
        return null;
    }

    public final boolean f() {
        C3513p7 c3513p7;
        C3513p7 c3513p8 = this.e;
        if (c3513p8 == null) {
            L4 l4 = this.n;
            if (l4 != null) {
                Intrinsics.checkNotNullExpressionValue("x7", "TAG");
                ((M4) l4).b("x7", "Invalid Data Model: No Root Container");
            }
        } else {
            if (c3513p8 == null) {
                c3513p7 = null;
                break;
            }
            Iterator it = c3513p8.iterator();
            while (true) {
                C3499o7 c3499o7 = (C3499o7) it;
                if (c3499o7.hasNext()) {
                    C3455l7 c3455l7 = (C3455l7) c3499o7.next();
                    if (StringsKt.equals(c3455l7.b, "card_scrollable", true)) {
                        if (c3455l7 instanceof C3513p7) {
                            c3513p7 = (C3513p7) c3455l7;
                            break;
                        }
                    }
                }
                c3513p7 = null;
                break;
            }
            if (c3513p7 == null) {
                L4 l5 = this.n;
                if (l5 != null) {
                    Intrinsics.checkNotNullExpressionValue("x7", "TAG");
                    ((M4) l5).b("x7", "No Card Scrollable in the data model");
                }
                return g();
            }
            if (d() > 0) {
                return g();
            }
            L4 l6 = this.n;
            if (l6 != null) {
                Intrinsics.checkNotNullExpressionValue("x7", "TAG");
                ((M4) l6).b("x7", "Invalid Data Model: No Cards in Card Scrollable");
            }
        }
        return false;
    }

    public final boolean g() {
        L4 l4;
        List<C3455l7> listN = n(ShareConstants.VIDEO_URL);
        if (listN != null && !listN.isEmpty()) {
            for (C3455l7 c3455l7 : listN) {
                if (c3455l7.f3369a.length() == 0 && (l4 = this.n) != null) {
                    Intrinsics.checkNotNullExpressionValue("x7", "TAG");
                    ((M4) l4).b("x7", "Video asset has invalid ID! CTA link resolution may not work");
                }
                C3426j8 c3426j8 = c3455l7 instanceof C3426j8 ? (C3426j8) c3455l7 : null;
                if ((c3426j8 != null ? c3426j8.d() : null) == null) {
                    L4 l5 = this.n;
                    if (l5 != null) {
                        Intrinsics.checkNotNullExpressionValue("x7", "TAG");
                        ((M4) l5).b("x7", "No Vast XML. Discarding DataModel");
                    }
                    return false;
                }
                Rc rcD = c3426j8.d();
                ArrayList arrayList = rcD != null ? ((Qc) rcD).e : null;
                if (arrayList == null || arrayList.isEmpty()) {
                    L4 l6 = this.n;
                    if (l6 != null) {
                        Intrinsics.checkNotNullExpressionValue("x7", "TAG");
                        ((M4) l6).b("x7", "No Media files. Discarding DataModel");
                    }
                    return false;
                }
                Rc rcD2 = c3426j8.d();
                String strB = rcD2 != null ? ((Qc) rcD2).b() : null;
                if (strB == null || strB.length() == 0) {
                    L4 l7 = this.n;
                    if (l7 != null) {
                        Intrinsics.checkNotNullExpressionValue("x7", "TAG");
                        ((M4) l7).b("x7", "Invalid Media URL.Discarding the model");
                    }
                    c3426j8.a("error", MapsKt.hashMapOf(TuplesKt.to("[ERRORCODE]", "403")), (T6) null, this.n);
                    return false;
                }
            }
        }
        return true;
    }

    public final void h() {
        C3611w7 c3611w7;
        C3611w7 c3611w8;
        try {
            JSONObject jSONObject = this.f3475a;
            if (jSONObject == null) {
                C3611w7 c3611w9 = this.p;
                if (c3611w9 == null) {
                    return;
                }
                c3611w9.c = new C3455l7((String) null, (String) null, (String) null, (C3471m7) null, 31);
                return;
            }
            if (!jSONObject.isNull("passThroughJson") && (c3611w8 = this.p) != null) {
                c3611w8.f3466a = jSONObject.getJSONObject("passThroughJson");
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("adContent");
            if (jSONObjectOptJSONObject != null && (c3611w7 = this.p) != null) {
                C3597v7 c3597v7 = c3611w7.b;
                c3597v7.f3457a = jSONObjectOptJSONObject.optString("title", null);
                c3597v7.b = jSONObjectOptJSONObject.optString("description", null);
                c3597v7.d = jSONObjectOptJSONObject.optString("ctaText", null);
                c3597v7.c = jSONObjectOptJSONObject.optString(UnifiedMediationParams.KEY_ICON_URL, null);
                c3597v7.e = jSONObjectOptJSONObject.optLong("rating", 0L);
                c3597v7.f = jSONObjectOptJSONObject.optString("landingPageUrl", null);
                c3597v7.g = jSONObjectOptJSONObject.optBoolean("isApp");
            }
            C3455l7 c3455l7 = new C3455l7((String) null, (String) null, (String) null, (C3471m7) null, 31);
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("onClick");
            if (jSONObjectOptJSONObject2 != null) {
                try {
                    a(c3455l7, jSONObjectOptJSONObject2);
                } catch (JSONException unused) {
                    L4 l4 = this.n;
                    if (l4 != null) {
                        Intrinsics.checkNotNullExpressionValue("x7", "TAG");
                        ((M4) l4).b("x7", "JSONException in parsing click params for publisher CTA");
                    }
                }
                if (!jSONObjectOptJSONObject2.isNull("openMode")) {
                    String string = jSONObjectOptJSONObject2.getString("openMode");
                    Intrinsics.checkNotNull(string);
                    String strB = b(string);
                    Intrinsics.checkNotNullParameter(strB, "<set-?>");
                    c3455l7.g = strB;
                    String strOptString = jSONObjectOptJSONObject2.optString("fallbackUrl");
                    Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                    c3455l7.a(strOptString);
                }
                c3455l7.i = jSONObjectOptJSONObject2.optBoolean("supportLockScreen", false);
            }
            ArrayList trackers = j(jSONObject);
            if (trackers != null) {
                Intrinsics.checkNotNullParameter(trackers, "trackers");
                c3455l7.s.addAll(trackers);
            }
            C3611w7 c3611w10 = this.p;
            if (c3611w10 == null) {
                return;
            }
            c3611w10.c = c3455l7;
        } catch (JSONException unused2) {
            L4 l5 = this.n;
            if (l5 != null) {
                Intrinsics.checkNotNullExpressionValue("x7", "TAG");
                ((M4) l5).b("x7", "Exception in getting publisher values from JSON");
            }
        }
    }

    public final JSONObject i(JSONObject jSONObject) {
        JSONObject jSONObject2;
        try {
            JSONObject jSONObject3 = jSONObject.isNull("assetStyle") ? null : jSONObject.getJSONObject("assetStyle");
            if (jSONObject3 != null) {
                return jSONObject3;
            }
            if (jSONObject.isNull("assetStyleRef")) {
                jSONObject2 = new JSONObject();
            } else {
                String string = jSONObject.getString("assetStyleRef");
                JSONObject jSONObject4 = this.d;
                JSONObject jSONObjectOptJSONObject = jSONObject4 != null ? jSONObject4.optJSONObject(string) : null;
                if (jSONObjectOptJSONObject != null) {
                    return jSONObjectOptJSONObject;
                }
                jSONObject2 = new JSONObject();
            }
            return jSONObject2;
        } catch (JSONException e) {
            L4 l4 = this.n;
            if (l4 != null) {
                ((M4) l4).b("x7", AbstractC3506p0.a(e, O5.a("x7", "TAG", "Exception while getting assetStyle - ")));
            }
            return new JSONObject();
        }
    }

    public final ArrayList j(JSONObject jSONObject) {
        if (jSONObject.isNull(Constants.ADJUST_PREINSTALL_CONTENT_URI_PATH)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(Constants.ADJUST_PREINSTALL_CONTENT_URI_PATH);
            Intrinsics.checkNotNull(jSONArray);
            if (AbstractC3420j2.a(jSONArray)) {
                return arrayList;
            }
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (!jSONObject2.isNull("trackerType")) {
                    String string = jSONObject2.getString("trackerType");
                    Intrinsics.checkNotNull(string);
                    if (Intrinsics.areEqual("url_ping", k(string))) {
                        int iOptInt = jSONObject2.optInt("eventId", 0);
                        if (!jSONObject2.isNull("uiEvent")) {
                            String string2 = jSONObject2.getString("uiEvent");
                            Intrinsics.checkNotNull(string2);
                            String strG = g(string2);
                            if (!Intrinsics.areEqual("unknown", strG)) {
                                if (Intrinsics.areEqual("OMID_VIEWABILITY", strG)) {
                                    Intrinsics.checkNotNull(jSONObject2);
                                    arrayList.addAll(o(jSONObject2));
                                } else {
                                    Intrinsics.checkNotNull(jSONObject2);
                                    C3328c8 c3328c8A = a(iOptInt, strG, jSONObject2);
                                    if (c3328c8A != null) {
                                        arrayList.add(c3328c8A);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (JSONException e) {
            L4 l4 = this.n;
            if (l4 != null) {
                ((M4) l4).b("x7", AbstractC3506p0.a(e, O5.a("x7", "TAG", "Exception while getting assetTrackers - ")));
            }
        }
        return arrayList;
    }

    public final String k(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("assetType");
            Intrinsics.checkNotNull(string);
            return string;
        } catch (JSONException e) {
            L4 l4 = this.n;
            if (l4 != null) {
                ((M4) l4).b("x7", AbstractC3506p0.a(e, O5.a("x7", "TAG", "Exception while getting assetType - ")));
            }
            return "";
        }
    }

    public final String l(JSONObject jSONObject) {
        try {
            if (!StringsKt.equals(k(jSONObject), "ICON", true) && !StringsKt.equals(k(jSONObject), ShareConstants.IMAGE_URL, true) && !StringsKt.equals(k(jSONObject), "GIF", true)) {
                return "";
            }
            String string = jSONObject.getJSONArray("assetValue").getString(0);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            if (string.length() <= 0) {
                return "";
            }
            String string2 = jSONObject.getJSONArray("assetValue").getString(0);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        } catch (JSONException e) {
            L4 l4 = this.n;
            if (l4 == null) {
                return "";
            }
            ((M4) l4).b("x7", AbstractC3506p0.a(e, O5.a("x7", "TAG", "Exception while getting assetUrl - ")));
            return "";
        }
    }

    public final C3455l7 m(String str) {
        HashMap map;
        C3455l7 c3455l7;
        if (str == null || str.length() == 0) {
            return null;
        }
        HashMap map2 = this.j;
        if (map2 != null && (c3455l7 = (C3455l7) map2.get(str)) != null) {
            return c3455l7;
        }
        C3625x7 c3625x7 = this.g;
        if (c3625x7 == null || (map = c3625x7.j) == null) {
            return null;
        }
        return (C3455l7) map.get(str);
    }

    public final List n(String assetType) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(assetType, "assetType");
        HashMap map = this.i;
        return (map == null || (arrayList = (ArrayList) map.get(assetType)) == null) ? CollectionsKt.emptyList() : arrayList;
    }

    public final ArrayList o(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        try {
            HashMap map = new HashMap();
            if (!jSONObject.isNull("macros")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("macros");
                Iterator<String> itKeys = jSONObject2.keys();
                Intrinsics.checkNotNull(itKeys);
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    String string = jSONObject2.getString(next);
                    Intrinsics.checkNotNull(next);
                    Intrinsics.checkNotNull(string);
                    map.put(next, string);
                }
            }
            JSONArray jSONArray = jSONObject.getJSONArray("adVerifications");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                if (!jSONObject3.isNull("url")) {
                    String strOptString = jSONObject3.optString("vendor");
                    String strOptString2 = jSONObject3.optString("verificationParams");
                    String string2 = jSONObject3.getString("url");
                    Intrinsics.checkNotNull(strOptString);
                    Intrinsics.checkNotNull(string2);
                    arrayList.add(new C3385g9(strOptString, strOptString2, string2, map));
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.add(new C3328c8("", 0, "OMID_VIEWABILITY", map));
            }
        } catch (Exception e) {
            L4 l4 = this.n;
            if (l4 != null) {
                ((M4) l4).b("x7", ld.a(e, O5.a("x7", "TAG", "Failed to parse OMID tracker : ")));
            }
        }
        return arrayList;
    }

    public final String p(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("dataType");
            Intrinsics.checkNotNull(string);
            return string;
        } catch (JSONException e) {
            L4 l4 = this.n;
            if (l4 != null) {
                ((M4) l4).b("x7", AbstractC3506p0.a(e, O5.a("x7", "TAG", "Exception while getting webViewAssetValue - ")));
            }
            return "";
        }
    }

    public final W7 q(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        long jOptLong = jSONObject.optLong(com.facebook.appevents.codeless.internal.Constants.PATH_TYPE_ABSOLUTE);
        long jOptLong2 = jSONObject.optLong("percentage");
        String strOptString = jSONObject.optString("reference");
        Intrinsics.checkNotNull(strOptString);
        return new W7(jOptLong, jOptLong2, strOptString, this);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C3625x7(int i, JSONObject pubContent, C3625x7 c3625x7, boolean z, AdConfig adConfig, L4 l4) {
        this(i, pubContent, c3625x7, z, adConfig, c3625x7.t, null, l4);
        Intrinsics.checkNotNullParameter(pubContent, "pubContent");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
    }

    public final C3455l7 a(C3625x7 c3625x7, C3455l7 c3455l7) {
        Object obj = c3455l7.e;
        String str = obj instanceof String ? (String) obj : null;
        if (str == null || str.length() == 0) {
            return null;
        }
        String[] strArr = (String[]) new Regex("\\|").split(str, 0).toArray(new String[0]);
        C3455l7 c3455l7M = c3625x7.m(strArr[0]);
        if (c3455l7M == null) {
            C3625x7 c3625x8 = c3625x7.g;
            if (c3625x8 == null) {
                return null;
            }
            return a(c3625x8, c3455l7);
        }
        if (Intrinsics.areEqual(c3455l7M, c3455l7)) {
            return null;
        }
        if (strArr.length == 1) {
            c3455l7M.l = (byte) 1;
            return c3455l7M;
        }
        c3455l7M.l = AbstractC3583u7.a(strArr[1]);
        L4 l4 = this.n;
        if (l4 != null) {
            ((M4) l4).a("x7", O5.a("x7", "TAG", "Referenced asset ( ").append(c3455l7M.b).append(" )").toString());
        }
        return c3455l7M;
    }

    public final JSONObject c(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.isNull("display") ? new JSONObject() : jSONObject.getJSONObject("display");
            Intrinsics.checkNotNull(jSONObject2);
            return jSONObject2;
        } catch (JSONException e) {
            L4 l4 = this.n;
            if (l4 != null) {
                ((M4) l4).b("x7", AbstractC3506p0.a(e, O5.a("x7", "TAG", "Exception while getting assetDisplayOnProperties - ")));
            }
            return new JSONObject();
        }
    }

    public final String n(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("valueType");
            Intrinsics.checkNotNull(string);
            return string;
        } catch (JSONException e) {
            L4 l4 = this.n;
            if (l4 != null) {
                ((M4) l4).b("x7", AbstractC3506p0.a(e, O5.a("x7", "TAG", "Exception while getting assetValueType - ")));
            }
            return "";
        }
    }

    public C3625x7(int i, JSONObject pubContent, C3625x7 c3625x7, boolean z, AdConfig adConfig, Map map, Qc qc, L4 l4) {
        byte bH;
        HashMap map2;
        C3455l7 asset;
        C3455l7 c3455l7;
        Rc rcD;
        int iA;
        HashMap map3;
        this.o = i;
        this.g = c3625x7;
        this.m = adConfig;
        this.f3475a = pubContent;
        this.b = (byte) 0;
        this.c = false;
        this.l = qc;
        this.j = new HashMap();
        HashMap map4 = new HashMap();
        this.k = map4;
        this.i = new HashMap();
        this.p = new C3611w7();
        this.s = z;
        this.t = map;
        this.n = l4;
        try {
            this.d = pubContent.optJSONObject("styleRefs");
            if (pubContent.isNull("orientation")) {
                bH = 0;
            } else {
                String string = pubContent.getString("orientation");
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                bH = h(string);
            }
            this.b = bH;
            this.q = pubContent.optBoolean("shouldAutoOpenLandingPage", true);
            this.c = pubContent.optBoolean("disableBackButton");
            JSONObject jSONObject = pubContent.getJSONObject("rootContainer");
            Intrinsics.checkNotNull(jSONObject);
            C3455l7 c3455l7A = a(jSONObject, "CONTAINER", "/rootContainer");
            this.e = c3455l7A instanceof C3513p7 ? (C3513p7) c3455l7A : null;
            h();
            if (pubContent.has("rewards")) {
                this.h = new HashMap();
            }
            C3389h.Companion.getClass();
            Intrinsics.checkNotNullParameter(pubContent, "pubContent");
            if (pubContent.has("rewards")) {
                map2 = new HashMap();
                JSONObject jSONObjectOptJSONObject = pubContent.optJSONObject("rewards");
                if (jSONObjectOptJSONObject != null) {
                    Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        String string2 = jSONObjectOptJSONObject.getString(next);
                        Intrinsics.checkNotNull(next);
                        Intrinsics.checkNotNull(string2);
                        map2.put(next, string2);
                    }
                }
            } else {
                map2 = null;
            }
            if (map2 != null && (map3 = this.h) != null) {
                map3.putAll(map2);
            }
            a();
            b();
            for (Map.Entry entry : map4.entrySet()) {
                HashMap map5 = this.j;
                if (map5 != null && (asset = (C3455l7) map5.get(entry.getKey())) != null && 4 == asset.m && (asset.n != -1 || asset.o != -1)) {
                    HashMap map6 = this.j;
                    if (map6 != null && (c3455l7 = (C3455l7) map6.get(entry.getValue())) != null && Intrinsics.areEqual(ShareConstants.VIDEO_URL, c3455l7.c)) {
                        C3426j8 c3426j8 = c3455l7 instanceof C3426j8 ? (C3426j8) c3455l7 : null;
                        if (c3426j8 != null && (rcD = c3426j8.d()) != null) {
                            Qc qc2 = rcD instanceof Qc ? (Qc) rcD : null;
                            if (qc2 != null) {
                                try {
                                    iA = qc2.a();
                                } catch (ArrayIndexOutOfBoundsException unused) {
                                    L4 l5 = this.n;
                                    if (l5 != null) {
                                        Intrinsics.checkNotNullExpressionValue("x7", "TAG");
                                        ((M4) l5).b("x7", "ArrayIndexOutOfBoundsException in getting media duration");
                                    }
                                    iA = 0;
                                }
                                if (iA == 0) {
                                    asset.n = 0;
                                } else {
                                    asset.n = a(asset.n, iA);
                                    asset.o = a(asset.o, iA);
                                }
                                Intrinsics.checkNotNullParameter(asset, "asset");
                                ((C3426j8) c3455l7).y.add(asset);
                            }
                        }
                    }
                }
            }
            JSONArray jSONArrayOptJSONArray = pubContent.optJSONArray("pages");
            this.f = jSONArrayOptJSONArray == null ? new JSONArray() : jSONArrayOptJSONArray;
        } catch (JSONException e) {
            L4 l6 = this.n;
            if (l6 != null) {
                ((M4) l6).b("x7", AbstractC3506p0.a(e, O5.a("x7", "TAG", "Exception while getting pagesArray - ")));
            }
        }
    }

    public final JSONArray m(JSONObject jSONObject) {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("assetValue");
            Intrinsics.checkNotNullExpressionValue(jSONArray, "getJSONArray(...)");
            return jSONArray;
        } catch (JSONException e) {
            L4 l4 = this.n;
            if (l4 != null) {
                ((M4) l4).b("x7", AbstractC3506p0.a(e, O5.a("x7", "TAG", "Exception while getting assetValue - ")));
            }
            return new JSONArray();
        }
    }

    public final byte e(JSONObject jSONObject) {
        try {
            JSONObject jSONObjectC = c(jSONObject);
            if (!jSONObjectC.isNull("type")) {
                String string = jSONObjectC.getString("type");
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                return f(string);
            }
        } catch (JSONException e) {
            L4 l4 = this.n;
            if (l4 != null) {
                ((M4) l4).b("x7", AbstractC3506p0.a(e, O5.a("x7", "TAG", "Exception while getting assetDisplay - ")));
            }
        }
        return (byte) 2;
    }

    /* JADX WARN: Code duplicated, block: B:56:0x0109  */
    public final void b() {
        String str;
        ArrayList arrayList;
        for (C3455l7 c3455l7 : n("WEBVIEW")) {
            M8 m8 = c3455l7 instanceof M8 ? (M8) c3455l7 : null;
            if (m8 != null && !Intrinsics.areEqual("URL", m8.y) && !Intrinsics.areEqual("HTML", m8.y)) {
                C3455l7 c3455l7A = a(this, c3455l7);
                if (c3455l7A == null) {
                    L4 l4 = this.n;
                    if (l4 != null) {
                        ((M4) l4).b("x7", O5.a("x7", "TAG", "Could not find referenced asset for asset (").append(c3455l7.b).append(')').toString());
                    }
                } else if (Intrinsics.areEqual(c3455l7A.c, c3455l7.c)) {
                    c3455l7.e = c3455l7A.e;
                } else if (Intrinsics.areEqual(c3455l7A.c, ShareConstants.VIDEO_URL)) {
                    if (2 == c3455l7A.l) {
                        C3426j8 c3426j8 = c3455l7A instanceof C3426j8 ? (C3426j8) c3455l7A : null;
                        if (c3426j8 != null) {
                            Rc rcD = c3426j8.d();
                            Hc companionAd = Fc.a(c3426j8, c3455l7);
                            if (companionAd == null) {
                                str = null;
                            } else if (Intrinsics.areEqual("REF_HTML", m8.y)) {
                                ArrayList arrayListA = companionAd.a(2);
                                if (!arrayListA.isEmpty()) {
                                    str = ((Gc) arrayListA.get(0)).b;
                                } else {
                                    ArrayList arrayListA2 = companionAd.a(3);
                                    if (arrayListA2.isEmpty()) {
                                        str = null;
                                    } else {
                                        str = ((Gc) arrayListA2.get(0)).b;
                                        if (URLUtil.isValidUrl(str)) {
                                            m8.y = "REF_IFRAME";
                                        } else {
                                            str = null;
                                        }
                                    }
                                }
                            } else if (Intrinsics.areEqual("REF_IFRAME", m8.y)) {
                                ArrayList arrayListA3 = companionAd.a(3);
                                if (!arrayListA3.isEmpty()) {
                                    str = ((Gc) arrayListA3.get(0)).b;
                                    if (!URLUtil.isValidUrl(str)) {
                                        str = null;
                                    }
                                } else {
                                    ArrayList arrayListA4 = companionAd.a(2);
                                    if (arrayListA4.isEmpty()) {
                                        str = null;
                                    } else {
                                        m8.y = "REF_HTML";
                                        str = ((Gc) arrayListA4.get(0)).b;
                                    }
                                }
                            } else {
                                str = null;
                            }
                            boolean zAreEqual = Intrinsics.areEqual("REF_IFRAME", m8.y);
                            boolean zAreEqual2 = Intrinsics.areEqual("REF_HTML", m8.y);
                            if ((!zAreEqual || URLUtil.isValidUrl(str)) && companionAd != null && (!zAreEqual2 || str != null)) {
                                if (rcD != null) {
                                    Intrinsics.checkNotNullParameter(companionAd, "companionAd");
                                    ((Qc) rcD).j = companionAd;
                                }
                                L4 l5 = this.n;
                                if (l5 != null) {
                                    ((M4) l5).a("x7", P5.a("x7", "TAG", "Setting asset value: ", str));
                                }
                                c3455l7.e = str;
                                ArrayList trackers = companionAd.a(EventConstants.CREATIVE_VIEW);
                                Intrinsics.checkNotNullParameter(trackers, "trackers");
                                c3455l7.s.addAll(trackers);
                            } else {
                                if (((rcD == null || (arrayList = ((Qc) rcD).i) == null) ? -1 : arrayList.size()) > 0) {
                                    c3426j8.v = 8;
                                    c3426j8.a("error", MapsKt.hashMapOf(TuplesKt.to("[ERRORCODE]", "601")), (T6) null, this.n);
                                    L4 l6 = this.n;
                                    if (l6 != null) {
                                        Intrinsics.checkNotNullExpressionValue("x7", "TAG");
                                        ((M4) l6).b("x7", "Unable to find the best-fit companion ad! Returning ...");
                                    }
                                }
                                m8.y = "UNKNOWN";
                            }
                        }
                    } else {
                        L4 l7 = this.n;
                        if (l7 != null) {
                            Intrinsics.checkNotNullExpressionValue("x7", "TAG");
                            ((M4) l7).b("x7", "Unknown creative type reference for webView asset! Returning ...");
                        }
                    }
                }
            }
        }
    }

    public final String f(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("assetId");
            Intrinsics.checkNotNull(string);
            return string;
        } catch (JSONException e) {
            L4 l4 = this.n;
            if (l4 != null) {
                ((M4) l4).b("x7", AbstractC3506p0.a(e, O5.a("x7", "TAG", "Exception while getting assetId - ")));
            }
            return String.valueOf(jSONObject.hashCode());
        }
    }

    public static String j(String str) {
        String str2;
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = str.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        int length = lowerCase.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) lowerCase.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String strA = Q6.a(length, 1, lowerCase, i);
        switch (strA.hashCode()) {
            case -1178781136:
                str2 = "italic";
                if (!strA.equals("italic")) {
                    return "none";
                }
                break;
            case -1026963764:
                str2 = "underline";
                if (!strA.equals("underline")) {
                    return "none";
                }
                break;
            case -891985998:
                str2 = "strike";
                if (!strA.equals("strike")) {
                    return "none";
                }
                break;
            case 3029637:
                str2 = "bold";
                if (!strA.equals("bold")) {
                    return "none";
                }
                break;
            case 3387192:
                strA.equals("none");
                return "none";
            default:
                return "none";
        }
        return str2;
    }

    public final Point h(JSONObject jSONObject) {
        Point point = new Point();
        try {
            JSONObject jSONObjectI = i(jSONObject);
            if (jSONObjectI.isNull("geometry")) {
                return point;
            }
            JSONArray jSONArray = jSONObjectI.getJSONArray("geometry");
            point.x = a(jSONArray.getInt(0));
            point.y = a(jSONArray.getInt(1));
        } catch (JSONException e) {
            L4 l4 = this.n;
            if (l4 != null) {
                ((M4) l4).b("x7", AbstractC3506p0.a(e, O5.a("x7", "TAG", "Exception while getting assetPosition - ")));
            }
        }
        return point;
    }

    public final String g(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("assetName");
            Intrinsics.checkNotNull(string);
            return string;
        } catch (JSONException e) {
            L4 l4 = this.n;
            if (l4 != null) {
                ((M4) l4).b("x7", AbstractC3506p0.a(e, O5.a("x7", "TAG", "Exception while getting assetName - ")));
            }
            return "";
        }
    }

    public static byte l(String str) {
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String strA = Q6.a(length, 1, str, i);
        return (!Intrinsics.areEqual(strA, com.facebook.appevents.codeless.internal.Constants.PATH_TYPE_ABSOLUTE) && Intrinsics.areEqual(strA, "reference")) ? (byte) 1 : (byte) 0;
    }

    public static byte f(String str) {
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String strA = Q6.a(length, 1, str, i);
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = strA.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        int iHashCode = lowerCase.hashCode();
        if (iHashCode == -921832806) {
            return !lowerCase.equals("percentage") ? (byte) 1 : (byte) 4;
        }
        if (iHashCode != -284840886) {
            return (iHashCode == 1728122231 && lowerCase.equals(com.facebook.appevents.codeless.internal.Constants.PATH_TYPE_ABSOLUTE)) ? (byte) 3 : (byte) 1;
        }
        lowerCase.equals("unknown");
        return (byte) 1;
    }

    public static String k(String str) {
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String upperCase = str.toUpperCase(US);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        int length = upperCase.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) upperCase.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String strA = Q6.a(length, 1, upperCase, i);
        int iHashCode = strA.hashCode();
        if (iHashCode != -1430070305) {
            if (iHashCode != -158113182) {
                if (iHashCode == 1110926088 && strA.equals("URL_WEBVIEW_PING")) {
                    return "webview_ping";
                }
            } else if (strA.equals("URL_PING")) {
                return "url_ping";
            }
        } else if (strA.equals("HTML_SCRIPT")) {
            return "html_script";
        }
        return "unknown";
    }

    public static byte i(String str) {
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String strA = Q6.a(length, 1, str, i);
        return (!Intrinsics.areEqual(strA, "paged") && Intrinsics.areEqual(strA, "free")) ? (byte) 1 : (byte) 0;
    }

    public static String e(String str) {
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = str.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        int length = lowerCase.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) lowerCase.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String strA = Q6.a(length, 1, lowerCase, i);
        if (Intrinsics.areEqual(strA, "none") || !Intrinsics.areEqual(strA, "line")) {
            return "none";
        }
        return "line";
    }

    public static String c(String str) {
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = str.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        int length = lowerCase.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) lowerCase.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String strA = Q6.a(length, 1, lowerCase, i);
        switch (strA.hashCode()) {
            case -938102371:
                return !strA.equals("rating") ? "CONTAINER" : "RATING";
            case -410956671:
                strA.equals("container");
                return "CONTAINER";
            case 98832:
                return !strA.equals("cta") ? "CONTAINER" : VastTagName.CTA;
            case 102340:
                return !strA.equals("gif") ? "CONTAINER" : "GIF";
            case 3226745:
                return !strA.equals("icon") ? "CONTAINER" : "ICON";
            case 3556653:
                return !strA.equals("text") ? "CONTAINER" : "TEXT";
            case 100313435:
                return !strA.equals("image") ? "CONTAINER" : ShareConstants.IMAGE_URL;
            case 110364485:
                return !strA.equals("timer") ? "CONTAINER" : "TIMER";
            case 112202875:
                return !strA.equals("video") ? "CONTAINER" : ShareConstants.VIDEO_URL;
            case 1224424441:
                return !strA.equals(com.ironsource.b9.h.K) ? "CONTAINER" : "WEBVIEW";
            default:
                return "CONTAINER";
        }
    }

    public final void a() {
        Gc gc;
        ArrayList arrayList;
        for (C3455l7 c3455l7 : n(ShareConstants.IMAGE_URL)) {
            Object obj = c3455l7.e;
            if (!URLUtil.isValidUrl(obj instanceof String ? (String) obj : null)) {
                C3455l7 c3455l7A = a(this, c3455l7);
                if (c3455l7A == null) {
                    L4 l4 = this.n;
                    if (l4 != null) {
                        ((M4) l4).b("x7", O5.a("x7", "TAG", "Could not find referenced asset for asset (").append(c3455l7.b).append(')').toString());
                    }
                } else if (Intrinsics.areEqual(c3455l7A.c, c3455l7.c)) {
                    c3455l7.e = c3455l7A.e;
                } else if (Intrinsics.areEqual(c3455l7A.c, ShareConstants.VIDEO_URL) && c3455l7A.l == 1) {
                    L4 l5 = this.n;
                    if (l5 != null) {
                        Intrinsics.checkNotNullExpressionValue("x7", "TAG");
                        ((M4) l5).b("x7", "Image asset cannot reference a linear creative in a video element!");
                    }
                } else if (Intrinsics.areEqual(c3455l7A.c, ShareConstants.VIDEO_URL) && c3455l7A.l == 2) {
                    C3426j8 c3426j8 = c3455l7A instanceof C3426j8 ? (C3426j8) c3455l7A : null;
                    if (c3426j8 != null) {
                        Rc rcD = c3426j8.d();
                        Hc companionAd = Fc.a(c3426j8, c3455l7);
                        ArrayList arrayListA = companionAd != null ? companionAd.a(1) : null;
                        if (arrayListA == null) {
                            gc = null;
                            break;
                        }
                        Iterator it = arrayListA.iterator();
                        do {
                            if (!it.hasNext()) {
                                gc = null;
                                break;
                            }
                            gc = (Gc) it.next();
                        } while (!URLUtil.isValidUrl(gc.b));
                        if (companionAd != null && gc != null) {
                            if (rcD != null) {
                                Intrinsics.checkNotNullParameter(companionAd, "companionAd");
                                ((Qc) rcD).j = companionAd;
                            }
                            L4 l6 = this.n;
                            if (l6 != null) {
                                ((M4) l6).a("x7", O5.a("x7", "TAG", "Setting image asset value: ").append(gc.b).toString());
                            }
                            c3455l7.e = gc.b;
                            ArrayList trackers = companionAd.a(EventConstants.CREATIVE_VIEW);
                            Intrinsics.checkNotNullParameter(trackers, "trackers");
                            c3455l7.s.addAll(trackers);
                            ArrayList<C3328c8> trackers2 = c3426j8.s;
                            Intrinsics.checkNotNullParameter(trackers2, "trackers");
                            Intrinsics.checkNotNullParameter("error", "eventType");
                            for (C3328c8 c3328c8 : trackers2) {
                                if (Intrinsics.areEqual("error", c3328c8.b)) {
                                    c3455l7.s.add(c3328c8);
                                }
                            }
                        } else if (((rcD == null || (arrayList = ((Qc) rcD).i) == null) ? -1 : arrayList.size()) > 0) {
                            c3426j8.v = 8;
                            c3426j8.a("error", MapsKt.hashMapOf(TuplesKt.to("[ERRORCODE]", "601")), (T6) null, this.n);
                            L4 l7 = this.n;
                            if (l7 != null) {
                                Intrinsics.checkNotNullExpressionValue("x7", "TAG");
                                ((M4) l7).b("x7", "Unable to find the best-fit companion ad! Returning ...");
                            }
                        }
                    }
                }
            }
        }
    }

    public final String d(JSONObject jSONObject) {
        try {
            JSONObject jSONObjectC = c(jSONObject);
            String string = jSONObjectC.isNull("reference") ? "" : jSONObjectC.getString("reference");
            Intrinsics.checkNotNull(string);
            return string;
        } catch (JSONException e) {
            L4 l4 = this.n;
            if (l4 == null) {
                return "";
            }
            ((M4) l4).b("x7", AbstractC3506p0.a(e, O5.a("x7", "TAG", "Exception while getting assetDisplayOnReference - ")));
            return "";
        }
    }

    public static byte h(String str) {
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = str.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        int length = lowerCase.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) lowerCase.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String strA = Q6.a(length, 1, lowerCase, i);
        int iHashCode = strA.hashCode();
        if (iHashCode == -1626174665) {
            strA.equals(BuildConfig.VERSION_NAME);
        } else if (iHashCode != 729267099) {
            if (iHashCode == 1430647483 && strA.equals("landscape")) {
                return (byte) 2;
            }
        } else if (strA.equals("portrait")) {
            return (byte) 1;
        }
        return (byte) 0;
    }

    public final void b(C3455l7 c3455l7, JSONObject jSONObject) throws JSONException {
        String string;
        String string2 = "";
        boolean z = false;
        if (jSONObject.isNull("assetOnclick")) {
            string = "";
        } else {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("assetOnclick");
            if (jSONObjectOptJSONObject != null && !jSONObjectOptJSONObject.isNull("itemUrl")) {
                string = jSONObject.getJSONObject("assetOnclick").getString("itemUrl");
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                z = true;
            } else {
                L4 l4 = this.n;
                if (l4 != null) {
                    Intrinsics.checkNotNullExpressionValue("x7", "TAG");
                    ((M4) l4).b("x7", "Missing itemUrl on asset " + jSONObject);
                }
                string = "";
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("assetOnclick");
            if (jSONObjectOptJSONObject2 == null || !jSONObjectOptJSONObject2.isNull("action")) {
                string2 = jSONObject.getJSONObject("assetOnclick").getString("action");
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                z = true;
            }
        }
        c3455l7.b(string);
        Intrinsics.checkNotNullParameter(string2, "<set-?>");
        c3455l7.h = string2;
        c3455l7.f = z;
    }

    /* JADX WARN: Code duplicated, block: B:129:0x021c  */
    public final U7 c(Point point, Point point2, Point point3, Point point4, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        String strA;
        String str;
        String str2;
        String str3;
        String strA2;
        String strA3;
        int length;
        byte b;
        String strD = "straight";
        String str4 = "#ff000000";
        if (jSONObject.isNull(OutlinedTextFieldKt.BorderId) || (jSONObjectOptJSONObject = jSONObject.optJSONObject(OutlinedTextFieldKt.BorderId)) == null || jSONObjectOptJSONObject.isNull("style")) {
            str3 = "straight";
            str = "#ff000000";
            str2 = "none";
        } else {
            String string = jSONObjectOptJSONObject.getString("style");
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String strE = e(string);
            if (!jSONObjectOptJSONObject.isNull("corner")) {
                String string2 = jSONObjectOptJSONObject.getString("corner");
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                strD = d(string2);
            }
            if (jSONObjectOptJSONObject.isNull("color")) {
                strE = strE;
                strD = strD;
                strA = "#ff000000";
            } else {
                String string3 = jSONObjectOptJSONObject.getString("color");
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                int length2 = string3.length() - 1;
                int i = 0;
                boolean z = false;
                while (true) {
                    strE = strE;
                    if (i > length2) {
                        strD = strD;
                        break;
                    }
                    strD = strD;
                    boolean z2 = Intrinsics.compare((int) string3.charAt(!z ? i : length2), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length2--;
                    } else if (z2) {
                        i++;
                    } else {
                        z = true;
                    }
                }
                strA = Q6.a(length2, 1, string3, i);
            }
            str = strA;
            str2 = strE;
            str3 = strD;
        }
        if (jSONObject.isNull("backgroundColor")) {
            strA2 = "#00000000";
            str4 = "#ff000000";
        } else {
            String string4 = jSONObject.getString("backgroundColor");
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            int length3 = string4.length() - 1;
            boolean z3 = false;
            int i2 = 0;
            while (true) {
                if (i2 > length3) {
                    str4 = str4;
                    break;
                }
                str4 = str4;
                boolean z4 = Intrinsics.compare((int) string4.charAt(!z3 ? i2 : length3), 32) <= 0;
                if (z3) {
                    if (!z4) {
                        break;
                    }
                    length3--;
                } else if (z4) {
                    i2++;
                } else {
                    z3 = true;
                }
            }
            strA2 = Q6.a(length3, 1, string4, i2);
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("text");
        try {
            String string5 = jSONObject2.getString(ContentDisposition.Parameters.Size);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            int i3 = (int) Double.parseDouble(string5);
            if (!jSONObject2.isNull(SessionDescription.ATTR_LENGTH)) {
                String string6 = jSONObject2.getString(SessionDescription.ATTR_LENGTH);
                Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                Integer.parseInt(string6);
            }
            if (jSONObject2.isNull("color")) {
                strA3 = str4;
                i3 = i3;
            } else {
                String string7 = jSONObject2.getString("color");
                Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                int length4 = string7.length() - 1;
                boolean z5 = false;
                int i4 = 0;
                while (true) {
                    if (i4 > length4) {
                        i3 = i3;
                        break;
                    }
                    i3 = i3;
                    boolean z6 = Intrinsics.compare((int) string7.charAt(!z5 ? i4 : length4), 32) <= 0;
                    if (z5) {
                        if (!z6) {
                            break;
                        }
                        length4--;
                    } else if (z6) {
                        i4++;
                    } else {
                        z5 = true;
                    }
                }
                strA3 = Q6.a(length4, 1, string7, i4);
            }
            ArrayList arrayList = new ArrayList();
            if (jSONObject2.isNull("style") || (length = jSONObject2.getJSONArray("style").length()) == 0) {
                arrayList.add("none");
            } else {
                for (int i5 = 0; i5 < length; i5++) {
                    String string8 = jSONObject2.getJSONArray("style").getString(i5);
                    Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
                    arrayList.add(j(string8));
                }
            }
            if (jSONObject2.isNull("align")) {
                b = 0;
            } else {
                String string9 = jSONObject2.getString("align");
                Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
                int length5 = string9.length() - 1;
                boolean z7 = false;
                int i6 = 0;
                while (i6 <= length5) {
                    boolean z8 = Intrinsics.compare((int) string9.charAt(!z7 ? i6 : length5), 32) <= 0;
                    if (z7) {
                        if (!z8) {
                            break;
                        }
                        length5--;
                    } else if (z8) {
                        i6++;
                    } else {
                        z7 = true;
                    }
                }
                String strA4 = Q6.a(length5, 1, string9, i6);
                int iHashCode = strA4.hashCode();
                if (iHashCode != -1364013605) {
                    if (iHashCode == 3317767) {
                        strA4.equals("left");
                    } else if (iHashCode == 108511772 && strA4.equals("right")) {
                        b = 1;
                    }
                    b = 0;
                } else if (strA4.equals("centre")) {
                    b = 2;
                } else {
                    b = 0;
                }
            }
            return new U7(point.x, point.y, point2.x, point2.y, point3.x, point3.y, point4.x, point4.y, str2, str3, str, strA2, i3, b, strA3, arrayList, new X7(q(jSONObject.optJSONObject("startOffset")), q(jSONObject.optJSONObject("timerDuration"))));
        } catch (NumberFormatException e) {
            L4 l4 = this.n;
            if (l4 != null) {
                Intrinsics.checkNotNullExpressionValue("x7", "TAG");
                ((M4) l4).b("x7", "Failure in building text asset! Text size should be an integer");
            }
            JSONException jSONException = new JSONException(e.getMessage());
            C3339d5 c3339d5 = C3339d5.f3292a;
            P1 event = new P1(e);
            Intrinsics.checkNotNullParameter(event, "event");
            C3339d5.c.a(event);
            throw jSONException;
        }
    }

    public final Point b(JSONObject jSONObject, Point point) {
        try {
            JSONObject jSONObjectI = i(jSONObject);
            if (jSONObjectI.isNull("finalGeometry")) {
                return point;
            }
            JSONArray jSONArray = jSONObjectI.getJSONArray("finalGeometry");
            Point point2 = new Point();
            point2.x = a(jSONArray.getInt(0));
            point2.y = a(jSONArray.getInt(1));
            return point2;
        } catch (JSONException unused) {
            return point;
        }
    }

    public final Point b(JSONObject jSONObject) {
        Point point = new Point();
        try {
            JSONObject jSONObjectI = i(jSONObject);
            if (jSONObjectI.isNull("geometry")) {
                return point;
            }
            JSONArray jSONArray = jSONObjectI.getJSONArray("geometry");
            point.x = a(jSONArray.getInt(2));
            point.y = a(jSONArray.getInt(3));
        } catch (JSONException e) {
            L4 l4 = this.n;
            if (l4 != null) {
                ((M4) l4).b("x7", AbstractC3506p0.a(e, O5.a("x7", "TAG", "Exception while getting assetDimensions - ")));
            }
        }
        return point;
    }

    /* JADX WARN: Code duplicated, block: B:71:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:73:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:75:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:81:0x010c  */
    /* JADX WARN: Code duplicated, block: B:84:0x0115 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x0118  */
    /* JADX WARN: Code duplicated, block: B:88:0x0121 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x0124  */
    /* JADX WARN: Code duplicated, block: B:92:0x012f A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static String g(String str) {
        String strA;
        int iHashCode;
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String upperCase = str.toUpperCase(US);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        int length = upperCase.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) upperCase.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String strA2 = Q6.a(length, 1, upperCase, i);
        switch (strA2.hashCode()) {
            case -1881262698:
                if (strA2.equals("RENDER")) {
                    return "Impression";
                }
                break;
            case -825499301:
                if (strA2.equals("FALLBACK_URL_CLICK")) {
                    return "TRACKER_EVENT_TYPE_FALLBACK_URL";
                }
                break;
            case 2342118:
                if (strA2.equals("LOAD")) {
                    return "load";
                }
                break;
            case 2634405:
                if (strA2.equals("VIEW")) {
                    return "page_view";
                }
                break;
            case 64212328:
                if (strA2.equals("CLICK")) {
                    return "click";
                }
                break;
            case 368426751:
                if (strA2.equals("OMID_VIEWABILITY")) {
                    return "OMID_VIEWABILITY";
                }
                break;
            case 1963885793:
                if (strA2.equals("VIDEO_VIEWABILITY")) {
                    return "VideoImpression";
                }
                break;
            case 2008409463:
                if (strA2.equals("CLIENT_FILL")) {
                    return "client_fill";
                }
                break;
        }
        Locale US2 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US2, "US");
        String upperCase2 = str.toUpperCase(US2);
        Intrinsics.checkNotNullExpressionValue(upperCase2, "this as java.lang.String).toUpperCase(locale)");
        int length2 = upperCase2.length() - 1;
        int i2 = 0;
        boolean z3 = false;
        while (i2 <= length2) {
            boolean z4 = Intrinsics.compare((int) upperCase2.charAt(!z3 ? i2 : length2), 32) <= 0;
            if (z3) {
                if (!z4) {
                    strA = Q6.a(length2, 1, upperCase2, i2);
                    iHashCode = strA.hashCode();
                    if (iHashCode != -1836567951) {
                        if (iHashCode != -1099027408) {
                            if (iHashCode != 1331888222) {
                                if (iHashCode == 1346121898 && strA.equals("DOWNLOADER_INITIALIZED")) {
                                    return "TRACKER_EVENT_TYPE_FALLBACK_URL";
                                }
                            } else if (!strA.equals("DOWNLOADER_ERROR")) {
                                return "TRACKER_EVENT_TYPE_DOWNLOADER_ERROR";
                            }
                        } else if (!strA.equals("DOWNLOADER_DOWNLOADING")) {
                            return "TRACKER_EVENT_TYPE_DOWNLOADER_DOWNLOADING";
                        }
                    } else if (!strA.equals("DOWNLOADER_DOWNLOADED")) {
                        return "TRACKER_EVENT_TYPE_DOWNLOADER_DOWNLOADED";
                    }
                    return "unknown";
                }
                length2--;
            } else if (z4) {
                i2++;
            } else {
                z3 = true;
            }
        }
        strA = Q6.a(length2, 1, upperCase2, i2);
        iHashCode = strA.hashCode();
        if (iHashCode != -1836567951) {
            if (iHashCode != -1099027408) {
                if (iHashCode != 1331888222) {
                    if (iHashCode == 1346121898) {
                        return "TRACKER_EVENT_TYPE_FALLBACK_URL";
                    }
                } else if (!strA.equals("DOWNLOADER_ERROR")) {
                    return "TRACKER_EVENT_TYPE_DOWNLOADER_ERROR";
                }
            } else if (!strA.equals("DOWNLOADER_DOWNLOADING")) {
                return "TRACKER_EVENT_TYPE_DOWNLOADER_DOWNLOADING";
            }
        } else if (!strA.equals("DOWNLOADER_DOWNLOADED")) {
            return "TRACKER_EVENT_TYPE_DOWNLOADER_DOWNLOADED";
        }
        return "unknown";
    }

    public static String d(String str) {
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = str.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        int length = lowerCase.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) lowerCase.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String strA = Q6.a(length, 1, lowerCase, i);
        if (Intrinsics.areEqual(strA, "straight") || !Intrinsics.areEqual(strA, "curved")) {
            return "straight";
        }
        return "curved";
    }

    public static String b(String str) {
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String upperCase = str.toUpperCase(US);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        int length = upperCase.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) upperCase.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String strA = Q6.a(length, 1, upperCase, i);
        switch (strA.hashCode()) {
            case -2084521848:
                return strA.equals("DOWNLOAD") ? strA : "EXTERNAL";
            case -1038134325:
                return !strA.equals("EXTERNAL") ? "EXTERNAL" : strA;
            case 69805756:
                return !strA.equals("INAPP") ? "EXTERNAL" : strA;
            case 1411860198:
                return !strA.equals("DEEPLINK") ? "EXTERNAL" : strA;
            case 1568475786:
                return !strA.equals("EMBEDDED") ? "EXTERNAL" : strA;
            default:
                return "EXTERNAL";
        }
    }

    public final C3555s7 b(Point point, Point point2, Point point3, Point point4, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        String strA;
        String str;
        String str2;
        String str3;
        String strA2;
        String strA3;
        int length;
        String strD = "straight";
        String str4 = "#ff000000";
        if (jSONObject.isNull(OutlinedTextFieldKt.BorderId) || (jSONObjectOptJSONObject = jSONObject.optJSONObject(OutlinedTextFieldKt.BorderId)) == null || jSONObjectOptJSONObject.isNull("style")) {
            str3 = "straight";
            str = "#ff000000";
            str2 = "none";
        } else {
            String string = jSONObjectOptJSONObject.getString("style");
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String strE = e(string);
            if (!jSONObjectOptJSONObject.isNull("corner")) {
                String string2 = jSONObjectOptJSONObject.getString("corner");
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                strD = d(string2);
            }
            if (jSONObjectOptJSONObject.isNull("color")) {
                strE = strE;
                strD = strD;
                strA = "#ff000000";
            } else {
                String string3 = jSONObjectOptJSONObject.getString("color");
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                int length2 = string3.length() - 1;
                int i = 0;
                boolean z = false;
                while (true) {
                    strE = strE;
                    if (i > length2) {
                        strD = strD;
                        break;
                    }
                    strD = strD;
                    boolean z2 = Intrinsics.compare((int) string3.charAt(!z ? i : length2), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length2--;
                    } else if (z2) {
                        i++;
                    } else {
                        z = true;
                    }
                }
                strA = Q6.a(length2, 1, string3, i);
            }
            str = strA;
            str2 = strE;
            str3 = strD;
        }
        if (jSONObject.isNull("backgroundColor")) {
            strA2 = "#00000000";
            str4 = "#ff000000";
        } else {
            String string4 = jSONObject.getString("backgroundColor");
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            int length3 = string4.length() - 1;
            boolean z3 = false;
            int i2 = 0;
            while (true) {
                if (i2 > length3) {
                    str4 = str4;
                    break;
                }
                str4 = str4;
                boolean z4 = Intrinsics.compare((int) string4.charAt(!z3 ? i2 : length3), 32) <= 0;
                if (z3) {
                    if (!z4) {
                        break;
                    }
                    length3--;
                } else if (z4) {
                    i2++;
                } else {
                    z3 = true;
                }
            }
            strA2 = Q6.a(length3, 1, string4, i2);
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("text");
        try {
            String string5 = jSONObject2.getString(ContentDisposition.Parameters.Size);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            int i3 = (int) Double.parseDouble(string5);
            if (jSONObject2.isNull("color")) {
                strA3 = str4;
                i3 = i3;
            } else {
                String string6 = jSONObject2.getString("color");
                Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                int length4 = string6.length() - 1;
                boolean z5 = false;
                int i4 = 0;
                while (true) {
                    if (i4 > length4) {
                        i3 = i3;
                        break;
                    }
                    i3 = i3;
                    boolean z6 = Intrinsics.compare((int) string6.charAt(!z5 ? i4 : length4), 32) <= 0;
                    if (z5) {
                        if (!z6) {
                            break;
                        }
                        length4--;
                    } else if (z6) {
                        i4++;
                    } else {
                        z5 = true;
                    }
                }
                strA3 = Q6.a(length4, 1, string6, i4);
            }
            ArrayList arrayList = new ArrayList();
            if (jSONObject2.isNull("style") || (length = jSONObject2.getJSONArray("style").length()) == 0) {
                arrayList.add("none");
            } else {
                for (int i5 = 0; i5 < length; i5++) {
                    String string7 = jSONObject2.getJSONArray("style").getString(i5);
                    Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                    arrayList.add(j(string7));
                }
            }
            return new C3555s7(point.x, point.y, point2.x, point2.y, point3.x, point3.y, point4.x, point4.y, str2, str3, str, strA2, i3, strA3, arrayList, new X7(q(jSONObject.optJSONObject("startOffset")), q(jSONObject.optJSONObject("timerDuration"))));
        } catch (NumberFormatException e) {
            L4 l4 = this.n;
            if (l4 != null) {
                Intrinsics.checkNotNullExpressionValue("x7", "TAG");
                ((M4) l4).b("x7", "Failure in building text asset! Text size should be an integer");
            }
            JSONException jSONException = new JSONException(e.getMessage());
            C3339d5 c3339d5 = C3339d5.f3292a;
            P1 event = new P1(e);
            Intrinsics.checkNotNullParameter(event, "event");
            C3339d5.c.a(event);
            throw jSONException;
        }
    }

    public static int a(int i, int i2) {
        if (i == -1 || i == 0) {
            return i;
        }
        if (i == 25) {
            return i2 / 4;
        }
        if (i == 50) {
            return i2 / 2;
        }
        if (i != 75) {
            return i != 100 ? i2 / 4 : i2;
        }
        return (i2 * 3) / 4;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 25301. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public final com.inmobi.media.C3455l7 a(org.json.JSONObject r51, java.lang.String r52, java.lang.String r53) {
        /*
            Method dump skipped, instruction units count: 2530
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.media.C3625x7.a(org.json.JSONObject, java.lang.String, java.lang.String):com.inmobi.media.l7");
    }

    public final void a(C3455l7 c3455l7, JSONObject jSONObject) throws JSONException {
        String string;
        boolean z;
        boolean z2 = true;
        String string2 = "";
        if (jSONObject.isNull("itemUrl")) {
            L4 l4 = this.n;
            if (l4 != null) {
                Intrinsics.checkNotNullExpressionValue("x7", "TAG");
                ((M4) l4).b("x7", "Missing itemUrl on publisher onClick");
            }
            z = false;
            string = "";
        } else {
            string = jSONObject.getString("itemUrl");
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            z = true;
        }
        if (jSONObject.isNull("action")) {
            z2 = z;
        } else {
            string2 = jSONObject.getString("action");
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        }
        c3455l7.b(string);
        String strOptString = jSONObject.optString("fallbackUrl");
        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
        c3455l7.a(strOptString);
        Intrinsics.checkNotNullParameter(string2, "<set-?>");
        c3455l7.h = string2;
        c3455l7.f = z2;
        c3455l7.u = jSONObject.optString("appBundleId");
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0086 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:0x0087 A[Catch: JSONException -> 0x00eb, TRY_LEAVE, TryCatch #2 {JSONException -> 0x00eb, blocks: (B:5:0x0012, B:10:0x0027, B:11:0x002b, B:13:0x0030, B:16:0x003a, B:19:0x0044, B:22:0x004e, B:25:0x0058, B:37:0x0080, B:40:0x0087, B:41:0x008b, B:46:0x009f, B:48:0x00a3, B:49:0x00ad, B:28:0x0062, B:31:0x006c, B:34:0x0076, B:51:0x00bf, B:56:0x00cb, B:58:0x00cf, B:7:0x001a), top: B:69:0x0012, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:79:? A[RETURN, SYNTHETIC] */
    public final boolean a(String str, JSONObject jSONObject) {
        String string;
        if (jSONObject.isNull("geometry")) {
            return false;
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("geometry");
            Intrinsics.checkNotNull(jSONArray);
            try {
                int i = jSONArray.getInt(2);
                int i2 = jSONArray.getInt(3);
                if (i > 0 && i2 > 0) {
                    switch (str.hashCode()) {
                        case -1919329183:
                            if (!str.equals("CONTAINER")) {
                                return false;
                            }
                        case 67056:
                            if (!str.equals(VastTagName.CTA)) {
                                return false;
                            }
                            if (jSONObject.isNull("text")) {
                                return false;
                            }
                            try {
                                string = jSONObject.getJSONObject("text").getString(ContentDisposition.Parameters.Size);
                                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                if (((int) Double.parseDouble(string)) <= 0) {
                                    return false;
                                }
                            } catch (NumberFormatException e) {
                                L4 l4 = this.n;
                                if (l4 != null) {
                                    Intrinsics.checkNotNullExpressionValue("x7", "TAG");
                                    ((M4) l4).b("x7", "Failure in validating text asset! Text size should be an integer");
                                }
                                C3339d5 c3339d5 = C3339d5.f3292a;
                                P1 event = new P1(e);
                                Intrinsics.checkNotNullParameter(event, "event");
                                C3339d5.c.a(event);
                                return false;
                            }
                        case 70564:
                            if (!str.equals("GIF")) {
                                return false;
                            }
                        case 2241657:
                            if (!str.equals("ICON")) {
                                return false;
                            }
                        case 2571565:
                            if (!str.equals("TEXT")) {
                                return false;
                            }
                            if (jSONObject.isNull("text")) {
                                return false;
                            }
                            string = jSONObject.getJSONObject("text").getString(ContentDisposition.Parameters.Size);
                            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                            if (((int) Double.parseDouble(string)) <= 0) {
                                return false;
                            }
                        case 69775675:
                            if (!str.equals(ShareConstants.IMAGE_URL)) {
                                return false;
                            }
                        case 79826725:
                            if (!str.equals("TIMER")) {
                                return false;
                            }
                        case 81665115:
                            if (!str.equals(ShareConstants.VIDEO_URL)) {
                                return false;
                            }
                        case 1942407129:
                            return str.equals("WEBVIEW");
                        default:
                            return false;
                    }
                }
            } catch (JSONException e2) {
                L4 l5 = this.n;
                if (l5 != null) {
                    Intrinsics.checkNotNullExpressionValue("x7", "TAG");
                    ((M4) l5).b("x7", "Exception while getting geometry - " + e2.getMessage());
                }
            }
            return false;
        } catch (JSONException e3) {
            L4 l6 = this.n;
            if (l6 == null) {
                return false;
            }
            ((M4) l6).b("x7", AbstractC3506p0.a(e3, O5.a("x7", "TAG", "Exception while getting assetStyle - ")));
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:123:0x01a3 A[PHI: r12
  0x01a3: PHI (r12v9 java.lang.String) = 
  (r12v2 java.lang.String)
  (r12v3 java.lang.String)
  (r12v4 java.lang.String)
  (r12v5 java.lang.String)
  (r12v6 java.lang.String)
  (r12v7 java.lang.String)
  (r12v8 java.lang.String)
  (r12v10 java.lang.String)
 binds: [B:121:0x01a0, B:118:0x0197, B:115:0x018e, B:112:0x0185, B:109:0x017b, B:105:0x016d, B:102:0x0164, B:99:0x015b] A[DONT_GENERATE, DONT_INLINE]] */
    public final C3328c8 a(int i, String str, JSONObject jSONObject) throws JSONException {
        String strA;
        String str2;
        int i2 = 0;
        if (jSONObject.isNull("url")) {
            strA = "";
        } else {
            String string = jSONObject.getString("url");
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            int length = string.length() - 1;
            int i3 = 0;
            boolean z = false;
            while (i3 <= length) {
                boolean z2 = Intrinsics.compare((int) string.charAt(!z ? i3 : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    }
                    length--;
                } else if (z2) {
                    i3++;
                } else {
                    z = true;
                }
            }
            strA = Q6.a(length, 1, string, i3);
        }
        HashMap map = new HashMap();
        if (Intrinsics.areEqual("VideoImpression", str)) {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("events");
            if ((strA.length() == 0 || ((StringsKt.startsWith$default(strA, "http", false, 2, (Object) null) && !URLUtil.isValidUrl(strA)) || !StringsKt.startsWith$default(strA, "http", false, 2, (Object) null))) && jSONArrayOptJSONArray == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (jSONArrayOptJSONArray != null) {
                int length2 = jSONArrayOptJSONArray.length();
                while (i2 < length2) {
                    String string2 = jSONArrayOptJSONArray.getString(i2);
                    JSONArray jSONArray = jSONArrayOptJSONArray;
                    String str3 = "unknown";
                    if (!TextUtils.isEmpty(string2) && string2 != null) {
                        switch (string2.hashCode()) {
                            case -1638835128:
                                str2 = "midpoint";
                                if (string2.equals("midpoint")) {
                                    str3 = str2;
                                }
                                break;
                            case -1337830390:
                                str2 = EventConstants.THIRD_QUARTILE;
                                if (string2.equals(EventConstants.THIRD_QUARTILE)) {
                                    str3 = str2;
                                }
                                break;
                            case -934426579:
                                str2 = "resume";
                                if (string2.equals("resume")) {
                                    str3 = str2;
                                }
                                break;
                            case -840405966:
                                str2 = "unmute";
                                if (string2.equals("unmute")) {
                                    str3 = str2;
                                }
                                break;
                            case -599445191:
                                str2 = "complete";
                                if (string2.equals("complete")) {
                                    str3 = str2;
                                }
                                break;
                            case -284840886:
                                string2.equals("unknown");
                                break;
                            case -174104201:
                                str2 = "client_fill";
                                if (string2.equals("client_fill")) {
                                    str3 = str2;
                                }
                                break;
                            case 3327206:
                                str2 = "load";
                                if (string2.equals("load")) {
                                    str3 = str2;
                                }
                                break;
                            case 3363353:
                                str2 = "mute";
                                if (string2.equals("mute")) {
                                    str3 = str2;
                                }
                                break;
                            case 94750088:
                                if (string2.equals("click")) {
                                    str3 = "click";
                                }
                                break;
                            case 96784904:
                                if (string2.equals("error")) {
                                    str3 = "error";
                                }
                                break;
                            case 106440182:
                                if (string2.equals("pause")) {
                                    str3 = "pause";
                                }
                                break;
                            case 109757538:
                                if (string2.equals("start")) {
                                    str3 = "start";
                                }
                                break;
                            case 110066619:
                                if (string2.equals("fullscreen")) {
                                    str3 = "fullscreen";
                                }
                                break;
                            case 113951609:
                                if (string2.equals("exitFullscreen")) {
                                    str3 = "exitFullscreen";
                                }
                                break;
                            case 354294980:
                                if (string2.equals("VideoImpression")) {
                                    str3 = "VideoImpression";
                                }
                                break;
                            case 368426751:
                                if (string2.equals("OMID_VIEWABILITY")) {
                                    str3 = "OMID_VIEWABILITY";
                                }
                                break;
                            case 560220243:
                                if (string2.equals(EventConstants.FIRST_QUARTILE)) {
                                    str3 = EventConstants.FIRST_QUARTILE;
                                }
                                break;
                            case 883937877:
                                if (string2.equals("page_view")) {
                                    str3 = "page_view";
                                }
                                break;
                            case 1342121331:
                                if (string2.equals("closeEndCard")) {
                                    str3 = "closeEndCard";
                                }
                                break;
                            case 1778167540:
                                if (string2.equals(EventConstants.CREATIVE_VIEW)) {
                                    str3 = EventConstants.CREATIVE_VIEW;
                                }
                                break;
                            case 2114088489:
                                if (string2.equals("Impression")) {
                                    str3 = "Impression";
                                }
                                break;
                        }
                    }
                    if (Intrinsics.areEqual(EventConstants.CREATIVE_VIEW, str3) || Intrinsics.areEqual("start", str3) || Intrinsics.areEqual("Impression", str3)) {
                        arrayList.add(str3);
                    }
                    i2++;
                    jSONArrayOptJSONArray = jSONArray;
                }
            }
            map.put("referencedEvents", arrayList);
        } else if (!URLUtil.isValidUrl(strA)) {
            return null;
        }
        HashMap map2 = new HashMap();
        try {
            if (!jSONObject.isNull("params")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("params");
                Iterator<String> itKeys = jSONObject2.keys();
                Intrinsics.checkNotNull(itKeys);
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    Intrinsics.checkNotNull(next);
                    String string3 = jSONObject2.getString(next);
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    map2.put(next, string3);
                }
            }
        } catch (JSONException e) {
            L4 l4 = this.n;
            if (l4 != null) {
                Intrinsics.checkNotNullExpressionValue("x7", "TAG");
                ((M4) l4).a("x7", "Failed to parser tracker.params", e);
            }
        }
        C3328c8 c3328c8 = new C3328c8(strA, i, str, map2);
        c3328c8.e = new HashMap(map);
        return c3328c8;
    }

    public final Rc a(JSONObject jSONObject, String str, C3455l7 c3455l7) {
        AdConfig.VastVideoConfig vastVideo;
        if (StringsKt.equals(k(jSONObject), ShareConstants.VIDEO_URL, true)) {
            try {
                if (jSONObject.isNull("assetValue")) {
                    return null;
                }
                if (c3455l7 instanceof C3426j8) {
                    Object obj = ((C3426j8) c3455l7).e;
                    if (obj instanceof Rc) {
                        return (Rc) obj;
                    }
                    return null;
                }
                AdConfig adConfig = this.m;
                if (adConfig == null || (vastVideo = adConfig.getVastVideo()) == null) {
                    return null;
                }
                return new Lc(vastVideo, this.n).a(str);
            } catch (JSONException e) {
                L4 l4 = this.n;
                if (l4 != null) {
                    ((M4) l4).b("x7", AbstractC3506p0.a(e, O5.a("x7", "TAG", "Exception while getting videoDescriptor - ")));
                }
            }
        }
        return null;
    }

    public final Point a(JSONObject jSONObject, Point point) {
        try {
            JSONObject jSONObjectI = i(jSONObject);
            if (jSONObjectI.isNull("finalGeometry")) {
                return point;
            }
            JSONArray jSONArray = jSONObjectI.getJSONArray("finalGeometry");
            Point point2 = new Point();
            point2.x = a(jSONArray.getInt(2));
            point2.y = a(jSONArray.getInt(3));
            return point2;
        } catch (JSONException unused) {
            return point;
        }
    }

    public final int a(JSONObject jSONObject, boolean z) {
        try {
            JSONObject jSONObjectC = c(jSONObject);
            String str = z ? "delay" : "hideAfterDelay";
            if (jSONObjectC.isNull(str)) {
                return -1;
            }
            int i = jSONObjectC.getInt(str);
            if (3 != e(jSONObject)) {
                if (4 != e(jSONObject)) {
                    return -1;
                }
                if (i != 0) {
                    if (1 > i || i >= 101) {
                        return -1;
                    }
                    int[] iArr = {25, 50, 75, 100};
                    double d = Double.MAX_VALUE;
                    int i2 = -1;
                    for (int i3 = 0; i3 < 4; i3++) {
                        int i4 = i - iArr[i3];
                        double d2 = i4 * i4;
                        if (d2 < d) {
                            i2 = i3;
                            d = d2;
                        }
                    }
                    return iArr[i2];
                }
            }
            return i;
        } catch (JSONException e) {
            L4 l4 = this.n;
            if (l4 == null) {
                return -1;
            }
            ((M4) l4).b("x7", AbstractC3506p0.a(e, O5.a("x7", "TAG", "Exception while getting assetDisplayOnDelay - ")));
            return -1;
        }
    }

    public static byte a(String str) {
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String upperCase = str.toUpperCase(US);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        int length = upperCase.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) upperCase.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String strA = Q6.a(length, 1, upperCase, i);
        return (!Intrinsics.areEqual(strA, "NONE") && Intrinsics.areEqual(strA, "EXIT")) ? (byte) 1 : (byte) 0;
    }

    /* JADX WARN: Code duplicated, block: B:56:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:91:0x0150 A[PHI: r7
  0x0150: PHI (r7v24 java.lang.String) = (r7v23 java.lang.String), (r7v25 java.lang.String) binds: [B:89:0x014d, B:83:0x013d] A[DONT_GENERATE, DONT_INLINE]] */
    public final C3471m7 a(Point point, Point point2, Point point3, Point point4, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        String strA;
        String str;
        String str2;
        String strE = "none";
        String strA2 = "#ff000000";
        String strD = "straight";
        if (!jSONObject.isNull(OutlinedTextFieldKt.BorderId) && (jSONObjectOptJSONObject = jSONObject.optJSONObject(OutlinedTextFieldKt.BorderId)) != null && !jSONObjectOptJSONObject.isNull("style")) {
            String string = jSONObjectOptJSONObject.getString("style");
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            strE = e(string);
            if (!jSONObjectOptJSONObject.isNull("corner")) {
                String string2 = jSONObjectOptJSONObject.getString("corner");
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                strD = d(string2);
            }
            if (!jSONObjectOptJSONObject.isNull("color")) {
                String string3 = jSONObjectOptJSONObject.getString("color");
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                int length = string3.length() - 1;
                int i = 0;
                boolean z = false;
                while (i <= length) {
                    boolean z2 = Intrinsics.compare((int) string3.charAt(!z ? i : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length--;
                    } else if (z2) {
                        i++;
                    } else {
                        z = true;
                    }
                }
                strA2 = Q6.a(length, 1, string3, i);
            }
        }
        String str3 = strE;
        String str4 = strA2;
        String str5 = strD;
        if (jSONObject.isNull("backgroundColor")) {
            strA = "#00000000";
        } else {
            String string4 = jSONObject.getString("backgroundColor");
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            int length2 = string4.length() - 1;
            int i2 = 0;
            boolean z3 = false;
            while (i2 <= length2) {
                boolean z4 = Intrinsics.compare((int) string4.charAt(!z3 ? i2 : length2), 32) <= 0;
                if (z3) {
                    if (!z4) {
                        break;
                    }
                    length2--;
                } else if (z4) {
                    i2++;
                } else {
                    z3 = true;
                }
            }
            strA = Q6.a(length2, 1, string4, i2);
        }
        String str6 = strA;
        if (jSONObject.isNull("contentMode")) {
            str = "fill";
        } else {
            String string5 = jSONObject.getString("contentMode");
            Intrinsics.checkNotNull(string5);
            int length3 = string5.length() - 1;
            int i3 = 0;
            boolean z5 = false;
            while (i3 <= length3) {
                boolean z6 = Intrinsics.compare((int) string5.charAt(!z5 ? i3 : length3), 32) <= 0;
                if (z5) {
                    if (!z6) {
                        break;
                    }
                    length3--;
                } else if (z6) {
                    i3++;
                } else {
                    z5 = true;
                }
            }
            String strA3 = Q6.a(length3, 1, string5, i3);
            int iHashCode = strA3.hashCode();
            if (iHashCode == -1626174665) {
                strA3.equals(BuildConfig.VERSION_NAME);
            } else if (iHashCode == -1362001767) {
                str2 = "aspectFit";
                if (strA3.equals("aspectFit")) {
                    str = str2;
                }
            } else if (iHashCode != 3143043) {
                if (iHashCode == 727618043) {
                    str2 = "aspectFill";
                    if (strA3.equals("aspectFill")) {
                        str = str2;
                    }
                }
            } else if (strA3.equals("fill")) {
                str = "fill";
            }
            str = BuildConfig.VERSION_NAME;
        }
        return new C3471m7(point.x, point.y, point2.x, point2.y, point3.x, point3.y, point4.x, point4.y, str, str3, str5, str4, str6, new X7(q(jSONObject.optJSONObject("startOffset")), q(jSONObject.optJSONObject("timerDuration"))));
    }

    public final X7 a(JSONObject jSONObject) {
        return new X7(q(jSONObject.optJSONObject("startOffset")), q(jSONObject.optJSONObject("timerDuration")));
    }
}
