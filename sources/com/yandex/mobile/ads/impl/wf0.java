package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class wf0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final yf0 f10561a;
    private final n2 b;
    private final dg0 c;

    public final void a(final e2 adBlockerDetectorListener, final g2 requestPolicy) {
        Intrinsics.checkNotNullParameter(adBlockerDetectorListener, "adBlockerDetectorListener");
        Intrinsics.checkNotNullParameter(requestPolicy, "requestPolicy");
        this.f10561a.a(new zf0() { // from class: com.yandex.mobile.ads.impl.wf0$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.zf0
            public final void a(Boolean bool) {
                wf0.a(this.f$0, requestPolicy, adBlockerDetectorListener, bool);
            }
        }, this.c.a(requestPolicy));
    }

    public /* synthetic */ wf0(Context context) {
        yf0 yf0Var = new yf0();
        int i = n2.e;
        this(context, yf0Var, n2.a.a(context), new dg0(context));
    }

    public wf0(Context context, yf0 hostAccessAdBlockerDetector, n2 adBlockerStateStorageManager, dg0 hostAccessCheckerFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(hostAccessAdBlockerDetector, "hostAccessAdBlockerDetector");
        Intrinsics.checkNotNullParameter(adBlockerStateStorageManager, "adBlockerStateStorageManager");
        Intrinsics.checkNotNullParameter(hostAccessCheckerFactory, "hostAccessCheckerFactory");
        this.f10561a = hostAccessAdBlockerDetector;
        this.b = adBlockerStateStorageManager;
        this.c = hostAccessCheckerFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(wf0 this$0, g2 requestPolicy, e2 adBlockerDetectorListener, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(requestPolicy, "$requestPolicy");
        Intrinsics.checkNotNullParameter(adBlockerDetectorListener, "$adBlockerDetectorListener");
        this$0.b.a(bool, requestPolicy);
        adBlockerDetectorListener.a();
    }
}
