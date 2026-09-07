package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class u91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final lp1 f10368a;
    private final Executor b;
    private final Context c;

    public final void a(o8<String> adResponse, wq1 responseConverterListener) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(responseConverterListener, "responseConverterListener");
        Context appContext = this.c;
        Intrinsics.checkNotNullExpressionValue(appContext, "appContext");
        lp1 lp1Var = this.f10368a;
        this.b.execute(new a(appContext, lp1Var, adResponse, responseConverterListener, new w91(appContext, lp1Var)));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u91(Context context, lp1 lp1Var) {
        this(context, lp1Var, is0.a.a().c());
        int i = is0.f;
    }

    public u91(Context context, lp1 reporter, Executor executor) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.f10368a = reporter;
        this.b = executor;
        this.c = context.getApplicationContext();
    }

    private static final class a implements Runnable {
        private final o8<String> b;
        private final wq1 c;
        private final w91 d;

        public a(Context context, lp1 reporter, o8<String> adResponse, wq1 responseConverterListener, w91 nativeResponseParser) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(reporter, "reporter");
            Intrinsics.checkNotNullParameter(adResponse, "adResponse");
            Intrinsics.checkNotNullParameter(responseConverterListener, "responseConverterListener");
            Intrinsics.checkNotNullParameter(nativeResponseParser, "nativeResponseParser");
            this.b = adResponse;
            this.c = responseConverterListener;
            this.d = nativeResponseParser;
        }

        @Override // java.lang.Runnable
        public final void run() {
            u61 u61VarA = this.d.a(this.b);
            if (u61VarA != null) {
                this.c.a(u61VarA);
            } else {
                this.c.a(w7.k());
            }
        }
    }
}
