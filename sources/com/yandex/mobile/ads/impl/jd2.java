package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class jd2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9307a;

    public jd2(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.f9307a = applicationContext;
    }

    public final Map a(LinkedHashMap rawEvents, rh2 rh2Var) {
        Map map;
        Intrinsics.checkNotNullParameter(rawEvents, "rawEvents");
        int i = iw1.l;
        cu1 cu1VarA = iw1.a.a().a(this.f9307a);
        if (cu1VarA == null || !cu1VarA.i0()) {
            map = rawEvents;
            Map mutableMap = MapsKt.toMutableMap(rawEvents);
            List<String> listA = rh2Var != null ? rh2Var.a() : null;
            List list = (List) mutableMap.get("impression");
            if (listA != null) {
                mutableMap.put("impression", listA);
            } else {
                mutableMap.remove("impression");
            }
            if (list != null) {
                mutableMap.put("render_impression", list);
                map = mutableMap;
            } else {
                mutableMap.remove("render_impression");
                map = mutableMap;
            }
        }
        map = rawEvents;
        return map;
    }
}
