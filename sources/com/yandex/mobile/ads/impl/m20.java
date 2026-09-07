package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class m20 implements b0<x> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c10 f9591a;
    private final d30 b;
    private final t62 c;
    private final boolean d;

    public m20(c10 designJsonParser, d30 divKitDesignParser, t62 trackingUrlsParser, boolean z) {
        Intrinsics.checkNotNullParameter(designJsonParser, "designJsonParser");
        Intrinsics.checkNotNullParameter(divKitDesignParser, "divKitDesignParser");
        Intrinsics.checkNotNullParameter(trackingUrlsParser, "trackingUrlsParser");
        this.f9591a = designJsonParser;
        this.b = divKitDesignParser;
        this.c = trackingUrlsParser;
        this.d = z;
    }

    @Override // com.yandex.mobile.ads.impl.b0
    public final x a(JSONObject jsonObject) throws JSONException, p61 {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        String strA = f91.a(jsonObject, "jsonAsset", "type", "jsonAttribute", "type");
        if (strA == null || strA.length() == 0 || Intrinsics.areEqual(strA, "null")) {
            throw new p61("Native Ad json has not required attributes");
        }
        Intrinsics.checkNotNull(strA);
        this.c.getClass();
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        JSONArray jSONArray = jsonObject.getJSONArray("trackingUrls");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            String string = jSONArray.getString(i);
            Intrinsics.checkNotNull(string);
            arrayList.add(string);
        }
        JSONObject jSONObjectOptJSONObject = jsonObject.optJSONObject("design");
        x00 x00VarA = jSONObjectOptJSONObject != null ? this.f9591a.a(jSONObjectOptJSONObject) : null;
        y20 y20VarA = x00VarA != null ? this.b.a(x00VarA, this.d) : null;
        if (y20VarA != null) {
            return new k20(strA, y20VarA, arrayList);
        }
        throw new p61("Native Ad json has not required attributes");
    }
}
