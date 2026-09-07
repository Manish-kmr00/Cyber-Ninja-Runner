package com.applovin.impl;

import android.net.Uri;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class o7 implements n4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f571a;
    private int b;
    private Uri c;
    private t7 d;
    private final Set e = new HashSet();
    private final Map f = new HashMap();

    private o7() {
    }

    public static o7 a(m8 m8Var, o7 o7Var, p7 p7Var, com.applovin.impl.sdk.k kVar) {
        m8 m8VarC;
        if (m8Var == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (kVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        if (o7Var == null) {
            try {
                o7Var = new o7();
            } catch (Throwable th) {
                kVar.O();
                if (com.applovin.impl.sdk.o.a()) {
                    kVar.O().a("VastCompanionAd", "Error occurred while initializing", th);
                }
                kVar.E().a("VastCompanionAd", th);
                return null;
            }
        }
        if (o7Var.f571a == 0 && o7Var.b == 0) {
            int i = StringUtils.parseInt((String) m8Var.a().get("width"));
            int i2 = StringUtils.parseInt((String) m8Var.a().get("height"));
            if (i > 0 && i2 > 0) {
                o7Var.f571a = i;
                o7Var.b = i2;
            }
        }
        o7Var.d = t7.a(m8Var, o7Var.d, kVar);
        if (o7Var.c == null && (m8VarC = m8Var.c("CompanionClickThrough")) != null) {
            String strD = m8VarC.d();
            if (StringUtils.isValidString(strD)) {
                o7Var.c = Uri.parse(strD);
            }
        }
        x7.a(m8Var.a("CompanionClickTracking"), o7Var.e, p7Var, kVar);
        x7.a(m8Var, o7Var.f, p7Var, kVar);
        return o7Var;
    }

    public Set b() {
        return this.e;
    }

    public Uri c() {
        return this.c;
    }

    public Map d() {
        return this.f;
    }

    public t7 e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o7)) {
            return false;
        }
        o7 o7Var = (o7) obj;
        if (this.f571a != o7Var.f571a || this.b != o7Var.b) {
            return false;
        }
        Uri uri = this.c;
        if (uri == null ? o7Var.c != null : !uri.equals(o7Var.c)) {
            return false;
        }
        t7 t7Var = this.d;
        if (t7Var == null ? o7Var.d != null : !t7Var.equals(o7Var.d)) {
            return false;
        }
        Set set = this.e;
        if (set == null ? o7Var.e != null : !set.equals(o7Var.e)) {
            return false;
        }
        Map map = this.f;
        Map map2 = o7Var.f;
        if (map != null) {
            return map.equals(map2);
        }
        return map2 == null;
    }

    public int hashCode() {
        int i = ((this.f571a * 31) + this.b) * 31;
        Uri uri = this.c;
        int iHashCode = (i + (uri != null ? uri.hashCode() : 0)) * 31;
        t7 t7Var = this.d;
        int iHashCode2 = (iHashCode + (t7Var != null ? t7Var.hashCode() : 0)) * 31;
        Set set = this.e;
        int iHashCode3 = (iHashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        Map map = this.f;
        return iHashCode3 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "VastCompanionAd{width=" + this.f571a + ", height=" + this.b + ", destinationUri=" + this.c + ", nonVideoResource=" + this.d + ", clickTrackers=" + this.e + ", eventTrackers=" + this.f + AbstractJsonLexerKt.END_OBJ;
    }

    public static o7 a(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        if (jSONObject == null) {
            return null;
        }
        int i = JsonUtils.getInt(jSONObject, "width", 0);
        int i2 = JsonUtils.getInt(jSONObject, "height", 0);
        String string = JsonUtils.getString(jSONObject, "destination_uri", null);
        Uri uri = StringUtils.isValidString(string) ? Uri.parse(string) : null;
        t7 t7VarA = t7.a(JsonUtils.getJSONObject(jSONObject, "non_video_resource", (JSONObject) null), kVar);
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "click_trackers", new JSONArray());
        HashSet hashSet = new HashSet();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            v7 v7VarA = v7.a(JsonUtils.getJSONObject(jSONArray, i3, (JSONObject) null), kVar);
            if (v7VarA != null) {
                hashSet.add(v7VarA);
            }
        }
        o7 o7Var = new o7();
        o7Var.f571a = i;
        o7Var.b = i2;
        o7Var.c = uri;
        o7Var.d = t7VarA;
        o7Var.e.addAll(hashSet);
        return o7Var;
    }

    @Override // com.applovin.impl.n4
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putInt(jSONObject, "width", this.f571a);
        JsonUtils.putInt(jSONObject, "height", this.b);
        Uri uri = this.c;
        JsonUtils.putString(jSONObject, "destination_uri", uri == null ? null : uri.toString());
        t7 t7Var = this.d;
        JsonUtils.putJSONObject(jSONObject, "non_video_resource", t7Var != null ? t7Var.a() : null);
        JSONArray jSONArray = new JSONArray();
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            jSONArray.put(((v7) it.next()).a());
        }
        JsonUtils.putJsonArray(jSONObject, "click_trackers", jSONArray);
        return jSONObject;
    }
}
