package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f449a;
    private final String b;
    private final boolean c;

    j1(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        this.f449a = JsonUtils.getString(jSONObject, "name", "");
        this.b = JsonUtils.getString(jSONObject, "description", "");
        List list = JsonUtils.getList(jSONObject, "existence_classes", null);
        if (list != null) {
            this.c = k7.a(list);
        } else {
            this.c = k7.a(JsonUtils.getString(jSONObject, "existence_class", ""));
        }
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.f449a;
    }

    public boolean c() {
        return this.c;
    }

    public static boolean a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (str2 == null || k7.a(str2, str) != 1) {
            return str3 == null || k7.a(str3, str) != -1;
        }
        return false;
    }
}
