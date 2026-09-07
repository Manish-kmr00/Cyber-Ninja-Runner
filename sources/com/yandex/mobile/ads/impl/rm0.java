package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class rm0 implements pm0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f10121a;
    private final g5 b;
    private final qm0 c;
    private final Handler d;
    private final i5 e;
    private ft f;

    @Override // com.yandex.mobile.ads.impl.pm0.a
    public final void a(final String error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.b.a(f5.e);
        this.e.a(error);
        this.d.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.rm0$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                rm0.a(this.f$0, error);
            }
        });
    }

    public /* synthetic */ rm0(Context context, o3 o3Var, g5 g5Var, qm0 qm0Var) {
        this(context, o3Var, g5Var, qm0Var, new Handler(Looper.getMainLooper()), new i5(context, o3Var, g5Var));
    }

    public rm0(Context context, o3 adConfiguration, g5 adLoadingPhasesManager, qm0 requestFinishedListener, Handler handler, i5 adLoadingResultReporter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(requestFinishedListener, "requestFinishedListener");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(adLoadingResultReporter, "adLoadingResultReporter");
        this.f10121a = adConfiguration;
        this.b = adLoadingPhasesManager;
        this.c = requestFinishedListener;
        this.d = handler;
        this.e = adLoadingResultReporter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(rm0 this$0, String error) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(error, "$error");
        ft ftVar = this$0.f;
        if (ftVar != null) {
            ftVar.onInstreamAdFailedToLoad(error);
        }
        this$0.c.a();
    }

    @Override // com.yandex.mobile.ads.impl.pm0.a
    public final void a(final bt instreamAd) {
        Intrinsics.checkNotNullParameter(instreamAd, "instreamAd");
        a4.a(this.f10121a.b().a());
        this.b.a(f5.e);
        this.e.a();
        this.d.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.rm0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                rm0.a(this.f$0, instreamAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(rm0 this$0, bt instreamAd) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(instreamAd, "$instreamAd");
        ft ftVar = this$0.f;
        if (ftVar != null) {
            ftVar.a(instreamAd);
        }
        this$0.c.a();
    }

    public final void a(ft ftVar) {
        this.f = ftVar;
        this.e.a(ftVar);
    }

    public final void a(gi2 requestConfig) {
        Intrinsics.checkNotNullParameter(requestConfig, "requestConfig");
        this.e.a(new vo0(requestConfig));
    }
}
