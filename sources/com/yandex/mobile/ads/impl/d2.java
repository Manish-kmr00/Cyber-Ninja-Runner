package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d2 {
    private static final long b = TimeUnit.DAYS.toMillis(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8658a;

    public d2(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f8658a = context;
    }

    public final boolean a(i2 adBlockerState) {
        Integer numB;
        Intrinsics.checkNotNullParameter(adBlockerState, "adBlockerState");
        int i = iw1.l;
        cu1 cu1VarA = iw1.a.a().a(this.f8658a);
        if (cu1VarA != null && cu1VarA.a()) {
            return false;
        }
        if (!adBlockerState.d() || adBlockerState.c() != g2.c || System.currentTimeMillis() - adBlockerState.b() >= b) {
            if (adBlockerState.d()) {
                return false;
            }
            int iA = adBlockerState.a();
            cu1 cu1VarA2 = iw1.a.a().a(this.f8658a);
            if (iA < ((cu1VarA2 == null || (numB = cu1VarA2.b()) == null) ? 5 : numB.intValue())) {
                return false;
            }
        }
        return true;
    }
}
