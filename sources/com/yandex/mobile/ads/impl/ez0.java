package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class ez0 implements ar1<dz0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final vc1 f8853a;
    private final qz0 b;

    @Override // com.yandex.mobile.ads.impl.ar1
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final dz0 a(pq1 networkResponse) {
        Intrinsics.checkNotNullParameter(networkResponse, "networkResponse");
        String strA = this.f8853a.a(networkResponse);
        if (strA == null || strA.length() <= 0) {
            return null;
        }
        try {
            JSONObject parent = new JSONObject(strA);
            try {
                rq0 rq0Var = rq0.f10131a;
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter("passback_parameters", "name");
                JSONObject jSONObject = parent.getJSONObject("passback_parameters");
                Map mapCreateMapBuilder = MapsKt.createMapBuilder();
                Iterator<String> itKeys = jSONObject.keys();
                Intrinsics.checkNotNullExpressionValue(itKeys, "keys(...)");
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    Intrinsics.checkNotNull(next);
                    String string = jSONObject.getString(next);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    mapCreateMapBuilder.put(next, string);
                }
                Map mapBuild = MapsKt.build(mapCreateMapBuilder);
                if (mapBuild.isEmpty()) {
                    return null;
                }
                JSONArray jSONArray = parent.getJSONArray("networks");
                ArrayList arrayList = new ArrayList();
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    qz0 qz0Var = this.b;
                    Intrinsics.checkNotNull(jSONObject2);
                    hz0 hz0VarA = qz0Var.a(jSONObject2);
                    if (hz0VarA != null) {
                        arrayList.add(hz0VarA);
                    }
                }
                if (arrayList.isEmpty()) {
                    return null;
                }
                return new dz0(arrayList, mapBuild);
            } catch (JSONException e) {
                op0.c(new Object[0]);
                throw new JSONException(e.getMessage());
            }
        } catch (JSONException unused) {
            op0.c(new Object[0]);
            return null;
        }
    }

    public /* synthetic */ ez0() {
        this(new wc1(), new qz0());
    }

    public ez0(vc1 networkResponseDecoder, qz0 mediationNetworkParser) {
        Intrinsics.checkNotNullParameter(networkResponseDecoder, "networkResponseDecoder");
        Intrinsics.checkNotNullParameter(mediationNetworkParser, "mediationNetworkParser");
        this.f8853a = networkResponseDecoder;
        this.b = mediationNetworkParser;
    }
}
