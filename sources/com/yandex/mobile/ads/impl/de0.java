package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.location.Location;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class de0 implements us0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zs0 f8685a;
    private final Object b;

    public /* synthetic */ de0(Context context, String str) {
        this(context, str, new zs0(context, str));
    }

    public de0(Context context, String locationServicesClassName, zs0 locationTaskManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(locationServicesClassName, "locationServicesClassName");
        Intrinsics.checkNotNullParameter(locationTaskManager, "locationTaskManager");
        this.f8685a = locationTaskManager;
        this.b = new Object();
    }

    @Override // com.yandex.mobile.ads.impl.us0
    public final Location a() {
        Location locationA;
        synchronized (this.b) {
            ys0 ys0VarB = this.f8685a.b();
            if (ys0VarB == null || !ys0VarB.b()) {
                locationA = null;
            } else {
                locationA = ys0VarB.a();
                this.f8685a.c();
            }
        }
        return locationA;
    }
}
