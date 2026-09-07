package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class we0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bt1 f10559a;
    private final Context b;
    private final xe0 c;
    private final ye0 d;

    public /* synthetic */ we0(Context context) {
        this(context, new bt1());
    }

    public we0(Context context, bt1 safePackageManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(safePackageManager, "safePackageManager");
        this.f10559a = safePackageManager;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.b = applicationContext;
        this.c = new xe0();
        this.d = new ye0();
    }

    public final lc a() {
        ResolveInfo resolveInfoResolveService;
        this.d.getClass();
        Intent intent = ye0.a();
        bt1 bt1Var = this.f10559a;
        Context context = this.b;
        bt1Var.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        lc lcVar = null;
        try {
            resolveInfoResolveService = context.getPackageManager().resolveService(intent, 0);
        } catch (Throwable unused) {
            op0.c(new Object[0]);
            resolveInfoResolveService = null;
        }
        if (resolveInfoResolveService != null) {
            try {
                te0 te0Var = new te0();
                if (this.b.bindService(intent, te0Var, 1)) {
                    lc lcVarA = this.c.a(te0Var);
                    this.b.unbindService(te0Var);
                    lcVar = lcVarA;
                } else {
                    op0.a(new Object[0]);
                }
            } catch (Throwable unused2) {
                op0.c(new Object[0]);
            }
        }
        return lcVar;
    }
}
