package com.ogury.ad.internal;

import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g3 f7304a = new g3();
    public static final LinkedHashMap b = new LinkedHashMap();

    public static void a(final h adLayout, final String adUnitId) {
        Intrinsics.checkNotNullParameter(adLayout, "adLayout");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        adLayout.setOnOverlayPositionChanged(new Function0() { // from class: com.ogury.ad.internal.g3$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return g3.b(adLayout, adUnitId);
            }
        });
    }

    public static final Unit b(h hVar, String str) {
        b.put(str, z9.b(hVar));
        return Unit.INSTANCE;
    }
}
