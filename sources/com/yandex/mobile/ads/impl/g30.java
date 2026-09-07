package com.yandex.mobile.ads.impl;

import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class g30 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o8<?> f8961a;
    private final lp1 b;
    private final qq0 c;

    /* JADX WARN: Code duplicated, block: B:11:0x0028  */
    public final void a(Uri uri, JSONObject jSONObject) {
        Map map;
        Intrinsics.checkNotNullParameter(uri, "uri");
        String queryParameter = uri.getQueryParameter(com.ironsource.b9.h.j0);
        if (queryParameter != null) {
            if (queryParameter.length() == 0) {
                queryParameter = null;
            }
            if (queryParameter != null) {
                if (jSONObject != null) {
                    this.c.getClass();
                    map = MapsKt.toMutableMap(qq0.a(jSONObject));
                    if (map == null) {
                        map = new HashMap();
                    }
                } else {
                    map = new HashMap();
                }
                this.b.a(new hp1(queryParameter, (Map<String, Object>) map, this.f8961a.a()));
            }
        }
    }

    public /* synthetic */ g30(o3 o3Var, o8 o8Var) {
        this(o3Var, o8Var, o3Var.q().c(), new qq0());
    }

    public g30(o3 adConfiguration, o8<?> adResponse, lp1 reporter, qq0 jsonConvertor) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(jsonConvertor, "jsonConvertor");
        this.f8961a = adResponse;
        this.b = reporter;
        this.c = jsonConvertor;
    }
}
