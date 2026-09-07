package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
public final class jw1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final it0 f9358a;
    private final uu1 b;
    private final r80 c;

    static final class a extends Lambda implements Function0<Unit> {
        final /* synthetic */ Context c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context) {
            super(0);
            this.c = context;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            jw1.this.b(this.c);
            return Unit.INSTANCE;
        }
    }

    public jw1(et0 mainThreadHandler, it0 manifestAnalyzer, wm2 sdkEnvironmentModule) {
        Intrinsics.checkNotNullParameter(mainThreadHandler, "mainThreadHandler");
        Intrinsics.checkNotNullParameter(manifestAnalyzer, "manifestAnalyzer");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        this.f9358a = manifestAnalyzer;
        this.b = sdkEnvironmentModule;
        this.c = new r80(mainThreadHandler);
    }

    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i = iw1.l;
        cu1 cu1VarA = iw1.a.a().a(context);
        if (cu1VarA != null && cu1VarA.X()) {
            this.c.a(new a(context));
        } else {
            b(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(Context context) {
        this.f9358a.getClass();
        if (it0.e(context)) {
            m11.a(context, this.b, new at() { // from class: com.yandex.mobile.ads.impl.jw1$$ExternalSyntheticLambda0
                @Override // com.yandex.mobile.ads.impl.at
                public final void onInitializationCompleted() {
                    jw1.a();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a() {
        op0.a(new Object[0]);
    }
}
