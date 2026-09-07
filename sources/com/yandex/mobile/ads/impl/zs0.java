package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class zs0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final xs0 f10848a;
    private final pg1 b;
    private ys0 c;

    public /* synthetic */ zs0(Context context, String str) {
        this(context, str, new xs0(context, str), new pg1(context), null);
    }

    public zs0(Context context, String locationServicesClassName, xs0 locationServices, pg1 permissionExtractor, ys0 ys0Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(locationServicesClassName, "locationServicesClassName");
        Intrinsics.checkNotNullParameter(locationServices, "locationServices");
        Intrinsics.checkNotNullParameter(permissionExtractor, "permissionExtractor");
        this.f10848a = locationServices;
        this.b = permissionExtractor;
        this.c = ys0Var;
    }

    private final ys0 a() {
        ee0 ee0VarA = this.f10848a.a();
        if (ee0VarA != null) {
            boolean zA = this.b.a();
            boolean zB = this.b.b();
            if (zA || zB) {
                return ee0VarA.a();
            }
        }
        return null;
    }

    public final ys0 b() {
        ys0 ys0Var = this.c;
        return ys0Var != null ? ys0Var : a();
    }

    public final void c() {
        this.c = a();
        this.c = a();
    }
}
