package com.ogury.ad.internal;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class v4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v4 f7421a = new v4();
    public static final Map<String, Function1<u4, Unit>> b = Collections.synchronizedMap(new LinkedHashMap());

    public static void a(String adId, x.d listener) {
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Map<String, Function1<u4, Unit>> listeners = b;
        Intrinsics.checkNotNullExpressionValue(listeners, "listeners");
        listeners.put(adId, listener);
    }

    public static void a(u4 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Function1<u4, Unit> function1 = b.get(event.f7412a);
        if (function1 != null) {
            function1.invoke(event);
        }
    }
}
