package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class g31 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o8<?> f8962a;
    private final o01 b;
    private boolean c;
    private boolean d;
    private boolean e;

    public g31(Context context, o8<?> adResponse, o3 adConfiguration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        this.f8962a = adResponse;
        adConfiguration.q().f();
        this.b = nd.a(context, bn2.f8524a, adConfiguration.q().b());
        this.c = true;
        this.d = true;
        this.e = true;
    }

    public final void b() {
        if (this.c) {
            a("first_click_on_controls");
            this.c = false;
        }
    }

    public final void c() {
        if (this.d) {
            a("first_user_swipe");
            this.d = false;
        }
    }

    public final void a() {
        if (this.e) {
            a("first_auto_swipe");
            this.e = false;
        }
    }

    private final void a(String str) {
        hp1.b reportType = hp1.b.P;
        HashMap reportData = MapsKt.hashMapOf(TuplesKt.to("event_type", str));
        f fVarA = this.f8962a.a();
        Intrinsics.checkNotNullParameter(reportType, "reportType");
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        this.b.a(new hp1(reportType.a(), (Map<String, Object>) MapsKt.toMutableMap(reportData), fVarA));
    }
}
