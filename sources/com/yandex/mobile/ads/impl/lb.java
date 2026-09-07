package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class lb implements b0<x> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j82 f9496a;
    private final t62 b;

    public lb(j82 urlJsonParser, t62 trackingUrlsParser) {
        Intrinsics.checkNotNullParameter(urlJsonParser, "urlJsonParser");
        Intrinsics.checkNotNullParameter(trackingUrlsParser, "trackingUrlsParser");
        this.f9496a = urlJsonParser;
        this.b = trackingUrlsParser;
    }

    @Override // com.yandex.mobile.ads.impl.b0
    public final x a(JSONObject jsonObject) throws JSONException, p61 {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        String strA = f91.a(jsonObject, "jsonAsset", "type", "jsonAttribute", "type");
        if (strA == null || strA.length() == 0 || Intrinsics.areEqual(strA, "null")) {
            throw new p61("Native Ad json has not required attributes");
        }
        Intrinsics.checkNotNull(strA);
        this.f9496a.getClass();
        String strA2 = j82.a("url", jsonObject);
        String strA3 = sq0.a("optOutUrl", jsonObject);
        if (strA3 == null) {
            strA3 = "";
        }
        this.b.getClass();
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        JSONArray jSONArray = jsonObject.getJSONArray("trackingUrls");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            String string = jSONArray.getString(i);
            Intrinsics.checkNotNull(string);
            arrayList.add(string);
        }
        return new jb(strA, strA2, strA3, arrayList);
    }
}
