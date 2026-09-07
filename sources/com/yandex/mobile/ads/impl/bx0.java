package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class bx0 implements tg<ax0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kw0 f8543a;
    private final qe2 b;
    private final mj0 c;
    private final ak0 d;

    public bx0(Context context, lp1 reporter, wj base64EncodingParameters, kw0 mediaParser, qe2 videoParser, mj0 imageParser, ak0 imageValuesParser) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(base64EncodingParameters, "base64EncodingParameters");
        Intrinsics.checkNotNullParameter(mediaParser, "mediaParser");
        Intrinsics.checkNotNullParameter(videoParser, "videoParser");
        Intrinsics.checkNotNullParameter(imageParser, "imageParser");
        Intrinsics.checkNotNullParameter(imageValuesParser, "imageValuesParser");
        this.f8543a = mediaParser;
        this.b = videoParser;
        this.c = imageParser;
        this.d = imageValuesParser;
    }

    @Override // com.yandex.mobile.ads.impl.tg
    public final ax0 a(JSONObject jsonAsset) throws JSONException, p61 {
        Object objA;
        Object objB;
        Object objA2;
        Intrinsics.checkNotNullParameter(jsonAsset, "jsonAsset");
        if (!jsonAsset.has("value") || jsonAsset.isNull("value")) {
            op0.b(new Object[0]);
            throw new p61("Native Ad json has not required attributes");
        }
        JSONObject jSONObject = jsonAsset.getJSONObject("value");
        Intrinsics.checkNotNull(jSONObject);
        kw0 kw0Var = this.f8543a;
        if (!jSONObject.has("media") || jSONObject.isNull("media")) {
            objA = null;
        } else {
            JSONObject jSONObject2 = jSONObject.getJSONObject("media");
            Intrinsics.checkNotNull(jSONObject2);
            objA = kw0Var.a(jSONObject2);
        }
        su0 su0Var = (su0) objA;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("images");
        List listA = jSONArrayOptJSONArray != null ? this.d.a(jSONArrayOptJSONArray) : null;
        mj0 mj0Var = this.c;
        if (!jSONObject.has("image") || jSONObject.isNull("image")) {
            objB = null;
        } else {
            JSONObject jSONObject3 = jSONObject.getJSONObject("image");
            Intrinsics.checkNotNull(jSONObject3);
            objB = mj0Var.b(jSONObject3);
        }
        uj0 uj0Var = (uj0) objB;
        if ((listA == null || listA.isEmpty()) && uj0Var != null) {
            listA = CollectionsKt.mutableListOf(uj0Var);
        }
        qe2 qe2Var = this.b;
        if (!jSONObject.has("video") || jSONObject.isNull("video")) {
            objA2 = null;
        } else {
            JSONObject jSONObject4 = jSONObject.getJSONObject("video");
            Intrinsics.checkNotNull(jSONObject4);
            objA2 = qe2Var.a(jSONObject4);
        }
        db2 db2Var = (db2) objA2;
        if (su0Var != null || ((listA != null && !listA.isEmpty()) || db2Var != null)) {
            return new ax0(su0Var, db2Var, listA != null ? CollectionsKt.toMutableList((Collection) listA) : null);
        }
        op0.b(new Object[0]);
        throw new p61("Native Ad json has not required attributes");
    }
}
