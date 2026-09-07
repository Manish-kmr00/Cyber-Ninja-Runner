package com.yandex.mobile.ads.impl;

import android.net.Uri;
import android.view.View;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class s20 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final to f10163a;
    private uo b;

    public s20(to mainClickConnector) {
        Intrinsics.checkNotNullParameter(mainClickConnector, "mainClickConnector");
        this.f10163a = mainClickConnector;
    }

    public final void a(Uri uri, View clickView) {
        Integer intOrNull;
        Map mapEmptyMap;
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(clickView, "clickView");
        String queryParameter = uri.getQueryParameter("assetName");
        if (queryParameter != null) {
            String queryParameter2 = uri.getQueryParameter(com.ironsource.b9.h.L);
            if (queryParameter2 != null) {
                Intrinsics.checkNotNull(queryParameter2);
                intOrNull = StringsKt.toIntOrNull(queryParameter2);
            } else {
                intOrNull = null;
            }
            if (intOrNull == null) {
                this.f10163a.a(clickView, queryParameter);
                return;
            }
            uo uoVar = this.b;
            if (uoVar == null || (mapEmptyMap = uoVar.a()) == null) {
                mapEmptyMap = MapsKt.emptyMap();
            }
            to toVar = (to) mapEmptyMap.get(intOrNull);
            if (toVar != null) {
                toVar.a(clickView, queryParameter);
            }
        }
    }

    public final void a(uo uoVar) {
        this.b = uoVar;
    }
}
