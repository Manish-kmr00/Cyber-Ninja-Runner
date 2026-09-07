package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class mo1 implements jo1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s4 f9661a;
    private final vo1 b;
    private final po1 c;
    private final lo1 d;
    private final jo1 e;
    private boolean f;

    public mo1(Context context, u7 renderingValidator, o8 adResponse, o3 adConfiguration, s9 adStructureType, s4 adIdStorageManager, vo1 renderingImpressionTrackingListener, po1 po1Var, lo1 renderTracker) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(renderingValidator, "renderingValidator");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adStructureType, "adStructureType");
        Intrinsics.checkNotNullParameter(adIdStorageManager, "adIdStorageManager");
        Intrinsics.checkNotNullParameter(renderingImpressionTrackingListener, "renderingImpressionTrackingListener");
        Intrinsics.checkNotNullParameter(renderTracker, "renderTracker");
        this.f9661a = adIdStorageManager;
        this.b = renderingImpressionTrackingListener;
        this.c = po1Var;
        this.d = renderTracker;
        this.e = new jo1(renderingValidator, this);
    }

    public /* synthetic */ mo1(Context context, u7 u7Var, o8 o8Var, o3 o3Var, s9 s9Var, s4 s4Var, vo1 vo1Var, po1 po1Var, List list) {
        this(context, u7Var, o8Var, o3Var, s9Var, s4Var, vo1Var, po1Var, new lo1(context, o8Var, o3Var, s9Var, list));
    }

    public final void b() {
        if (this.f) {
            return;
        }
        this.f = true;
        this.e.a();
    }

    public final void c() {
        this.f = false;
        this.e.b();
    }

    @Override // com.yandex.mobile.ads.impl.jo1.b
    public final void a() {
        po1 po1Var = this.c;
        if (po1Var != null) {
            po1Var.a();
        }
        this.d.a();
        this.f9661a.b();
        this.b.f();
    }

    public final void a(q91 reportParameterManager) {
        Intrinsics.checkNotNullParameter(reportParameterManager, "reportParameterManager");
        this.d.a(reportParameterManager);
    }
}
