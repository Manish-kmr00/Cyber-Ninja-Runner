package com.inmobi.media;

import java.util.Calendar;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.m4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractC3466m4 {
    public static HashMap a() {
        String str;
        HashMap map = new HashMap();
        try {
            map.put("mk-version", C3531qb.a());
            Boolean boolC = C3532qc.f3412a.c();
            if (boolC != null) {
                map.put("u-id-adt", boolC.booleanValue() ? "1" : "0");
            }
            map.put("ts", String.valueOf(Calendar.getInstance().getTimeInMillis()));
            Calendar calendar = Calendar.getInstance();
            map.put("tz", String.valueOf(calendar.get(16) + calendar.get(15)));
            C3587ub.f3446a.getClass();
            HashMap map2 = new HashMap();
            if (C3587ub.e && (str = C3587ub.d) != null) {
                map2.put("u-s-id", str);
            }
            map.putAll(map2);
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue("m4", "TAG");
        }
        return map;
    }
}
