package com.applovin.impl;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import android.widget.ImageView;
import com.applovin.impl.sdk.utils.ImageViewUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class r7 implements n4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f605a = new HashSet();
    public final Set b = new HashSet();
    private Uri c;
    private Uri d;
    private int e;
    private int f;

    public static r7 a(m8 m8Var, com.applovin.impl.sdk.k kVar) {
        if (m8Var == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (kVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        m8 m8VarC = m8Var.c("StaticResource");
        if (m8VarC == null || !URLUtil.isValidUrl(m8VarC.d())) {
            kVar.O();
            if (!com.applovin.impl.sdk.o.a()) {
                return null;
            }
            kVar.O().b("VastIndustryIcon", "Unable to create industry icon.  No valid image URL found.");
            return null;
        }
        r7 r7Var = new r7();
        r7Var.c = Uri.parse(m8VarC.d());
        m8 m8VarB = m8Var.b("IconClickThrough");
        if (m8VarB != null && URLUtil.isValidUrl(m8VarB.d())) {
            r7Var.d = Uri.parse(m8VarB.d());
        }
        String str = (String) m8Var.a().get("width");
        int i = 0;
        int i2 = (str == null || Integer.parseInt(str) <= 0) ? 0 : Integer.parseInt(str);
        String str2 = (String) m8Var.a().get("height");
        if (str2 != null && Integer.parseInt(str2) > 0) {
            i = Integer.parseInt(str2);
        }
        int iIntValue = ((Integer) kVar.a(v4.M4)).intValue();
        if (i2 <= 0 || i <= 0) {
            r7Var.f = iIntValue;
            r7Var.e = iIntValue;
        } else {
            double d = i2 / i;
            int iMin = Math.min(Math.max(i2, i), iIntValue);
            if (i2 >= i) {
                r7Var.e = iMin;
                r7Var.f = (int) (((double) iMin) / d);
            } else {
                r7Var.f = iMin;
                r7Var.e = (int) (((double) iMin) * d);
            }
        }
        return r7Var;
    }

    public Set b() {
        return this.f605a;
    }

    public Uri c() {
        return this.d;
    }

    public int d() {
        return this.f;
    }

    public Uri e() {
        return this.c;
    }

    public Set f() {
        return this.b;
    }

    public int g() {
        return this.e;
    }

    public String toString() {
        return "VastIndustryIcon{imageUri='" + e() + "', clickUri='" + c() + "', width=" + g() + ", height=" + d() + "}";
    }

    public static ImageView a(Uri uri, Context context, com.applovin.impl.sdk.k kVar) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setClickable(true);
        imageView.setVisibility(8);
        ImageViewUtils.setImageUri(imageView, uri, kVar);
        return imageView;
    }

    public static r7 a(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        v7 v7VarA;
        v7 v7VarA2;
        if (jSONObject == null) {
            return null;
        }
        r7 r7Var = new r7();
        String string = JsonUtils.getString(jSONObject, "image_uri", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        r7Var.c = Uri.parse(string);
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "click_trackers", new JSONArray());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            if (jSONObject2 != null && (v7VarA2 = v7.a(jSONObject2, kVar)) != null) {
                r7Var.f605a.add(v7VarA2);
            }
        }
        JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject, "view_trackers", new JSONArray());
        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
            JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONArray2, i2, (JSONObject) null);
            if (jSONObject3 != null && (v7VarA = v7.a(jSONObject3, kVar)) != null) {
                r7Var.b.add(v7VarA);
            }
        }
        String string2 = JsonUtils.getString(jSONObject, "click_uri", null);
        r7Var.d = StringUtils.isValidString(string2) ? Uri.parse(string2) : null;
        r7Var.e = JsonUtils.getInt(jSONObject, "width", 0);
        r7Var.f = JsonUtils.getInt(jSONObject, "height", 0);
        return r7Var;
    }

    @Override // com.applovin.impl.n4
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator it = this.f605a.iterator();
        while (it.hasNext()) {
            jSONArray.put(((v7) it.next()).a());
        }
        JsonUtils.putJsonArray(jSONObject, "click_trackers", jSONArray);
        JSONArray jSONArray2 = new JSONArray();
        Iterator it2 = this.b.iterator();
        while (it2.hasNext()) {
            jSONArray.put(((v7) it2.next()).a());
        }
        JsonUtils.putJsonArray(jSONObject, "view_trackers", jSONArray2);
        Uri uri = this.c;
        JsonUtils.putString(jSONObject, "image_uri", uri == null ? null : uri.toString());
        Uri uri2 = this.d;
        JsonUtils.putString(jSONObject, "click_uri", uri2 != null ? uri2.toString() : null);
        JsonUtils.putInt(jSONObject, "width", this.e);
        JsonUtils.putInt(jSONObject, "height", this.f);
        return jSONObject;
    }
}
