package com.yandex.mobile.ads.impl;

import io.ktor.http.LinkHeader;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class mj0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j82 f9644a;
    private final l02 b;

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final uj0 b(JSONObject imageObject) throws JSONException, p61 {
        k02 k02VarA;
        Intrinsics.checkNotNullParameter(imageObject, "imageObject");
        int i = imageObject.getInt("w");
        int i2 = imageObject.getInt("h");
        this.f9644a.getClass();
        String strA = j82.a("url", imageObject);
        if (imageObject.has("smartCenterSettings")) {
            l02 l02Var = this.b;
            JSONObject jSONObject = imageObject.getJSONObject("smartCenterSettings");
            Intrinsics.checkNotNullExpressionValue(jSONObject, "getJSONObject(...)");
            k02VarA = l02Var.a(jSONObject);
        } else {
            k02VarA = null;
        }
        String strOptString = imageObject.optString("sizeType");
        Intrinsics.checkNotNull(strOptString);
        if (strOptString.length() <= 0) {
            strOptString = null;
        }
        boolean zOptBoolean = imageObject.optBoolean(LinkHeader.Rel.PreLoad, true);
        String strOptString2 = imageObject.optString("preview");
        Intrinsics.checkNotNull(strOptString2);
        return new uj0(i, i2, strA, strOptString, k02VarA, zOptBoolean, strOptString2.length() > 0 ? strOptString2 : null);
    }

    public /* synthetic */ mj0() {
        this(new j82(), new l02());
    }

    public mj0(j82 urlJsonParser, l02 smartCenterSettingsParser) {
        Intrinsics.checkNotNullParameter(urlJsonParser, "urlJsonParser");
        Intrinsics.checkNotNullParameter(smartCenterSettingsParser, "smartCenterSettingsParser");
        this.f9644a = urlJsonParser;
        this.b = smartCenterSettingsParser;
    }
}
