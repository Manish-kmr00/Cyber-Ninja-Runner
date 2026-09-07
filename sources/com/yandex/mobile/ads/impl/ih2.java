package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class ih2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f9221a;
    private final gh2 b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ih2(Context context) {
        this(ux1.a(new ux1(), context, "ViewSizeInfoStorage"), new gh2());
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final String a(kh2 viewSizeKey) {
        Intrinsics.checkNotNullParameter(viewSizeKey, "viewSizeKey");
        return this.f9221a.getString(b(viewSizeKey), null);
    }

    private static String b(kh2 kh2Var) {
        return kh2Var.a() + "-" + kh2Var.b();
    }

    public ih2(SharedPreferences preferences, gh2 viewSizeInfoParser) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        Intrinsics.checkNotNullParameter(viewSizeInfoParser, "viewSizeInfoParser");
        this.f9221a = preferences;
        this.b = viewSizeInfoParser;
    }

    public final void a(kh2 viewSizeKey, fh2 viewSizeInfo) throws JSONException {
        Intrinsics.checkNotNullParameter(viewSizeKey, "viewSizeKey");
        Intrinsics.checkNotNullParameter(viewSizeInfo, "viewSizeInfo");
        String strB = b(viewSizeKey);
        this.b.getClass();
        Intrinsics.checkNotNullParameter(viewSizeInfo, "viewSizeInfo");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("width", viewSizeInfo.d().b());
        jSONObject2.put("height", viewSizeInfo.d().a());
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("width", viewSizeInfo.b().b());
        jSONObject3.put("height", viewSizeInfo.b().a());
        JSONObject jSONObject4 = new JSONObject();
        JSONObject jSONObject5 = new JSONObject();
        JSONObject jSONObject6 = new JSONObject();
        jSONObject4.put("value", viewSizeInfo.c().b().b());
        String strName = viewSizeInfo.c().b().a().name();
        Locale locale = Locale.ROOT;
        String lowerCase = strName.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        jSONObject4.put(com.ironsource.b9.a.t, lowerCase);
        jSONObject5.put("value", viewSizeInfo.c().a().b());
        String lowerCase2 = viewSizeInfo.c().a().a().name().toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        jSONObject5.put(com.ironsource.b9.a.t, lowerCase2);
        jSONObject6.put("width", jSONObject4);
        jSONObject6.put("height", jSONObject5);
        JSONObject jSONObject7 = new JSONObject(viewSizeInfo.a());
        jSONObject.put("view", jSONObject2);
        jSONObject.put("layout_params", jSONObject3);
        jSONObject.put("measured", jSONObject6);
        jSONObject.put("additional_info", jSONObject7);
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        this.f9221a.edit().putString(strB, string).apply();
    }
}
