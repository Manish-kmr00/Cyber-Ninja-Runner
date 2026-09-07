package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class ty0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10339a;
    private final nx0<?, ?> b;
    private final Map<String, Object> c;

    public ty0(Context context, nx0 mediatedAdController, LinkedHashMap mediatedReportData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediatedAdController, "mediatedAdController");
        Intrinsics.checkNotNullParameter(mediatedReportData, "mediatedReportData");
        this.f10339a = context;
        this.b = mediatedAdController;
        this.c = mediatedReportData;
    }

    public final void a() {
        this.b.e(this.f10339a, this.c);
    }
}
