package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class rf0 implements qc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bt1 f10103a;
    private final Context b;
    private final tf0 c;
    private final uf0 d;

    public /* synthetic */ rf0(Context context) {
        this(context, new bt1());
    }

    public rf0(Context context, bt1 safePackageManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(safePackageManager, "safePackageManager");
        this.f10103a = safePackageManager;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.b = applicationContext;
        this.c = new tf0();
        this.d = new uf0();
    }

    @Override // com.yandex.mobile.ads.impl.qc
    public final lc a() {
        ResolveInfo resolveInfoResolveService;
        this.d.getClass();
        Intent intent = uf0.a();
        bt1 bt1Var = this.f10103a;
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
                com.monetization.ads.core.identifiers.ad.huawei.a aVar = new com.monetization.ads.core.identifiers.ad.huawei.a();
                if (this.b.bindService(intent, aVar, 1)) {
                    lc lcVarA = this.c.a(aVar);
                    this.b.unbindService(aVar);
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
