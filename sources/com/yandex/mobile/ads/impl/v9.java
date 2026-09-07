package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class v9 {
    private static final ExecutorService c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private o3 f10462a;
    private final Context b;

    static {
        String str = b41.c;
        c = Executors.newCachedThreadPool(new b41(b41.b));
    }

    public v9(Context context, o3 adConfiguration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        this.f10462a = adConfiguration;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.b = applicationContext;
    }

    public final void a(String str, o8 adResponse, u1 handler) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(handler, "handler");
        a(str, handler, new cp(this.b, adResponse, this.f10462a, null));
    }

    public final void a(String str, y32 handler, mp1 reporter) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Context context = this.b;
        ak1 ak1Var = new ak1(context, reporter, handler, new l82(context));
        if (str == null || str.length() <= 0) {
            return;
        }
        c.execute(new a(str, ak1Var));
    }

    public final void a(String str, s62 trackingUrlType) {
        Intrinsics.checkNotNullParameter(trackingUrlType, "trackingUrlType");
        hh1 hh1Var = new hh1(this.b, this.f10462a, trackingUrlType);
        if (str == null || str.length() <= 0) {
            return;
        }
        c.execute(new a(str, hh1Var));
    }

    private static final class a implements Runnable {
        private final String b;
        private final n82 c;

        public a(String url, n82 tracker) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(tracker, "tracker");
            this.b = url;
            this.c = tracker;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.b.length() > 0) {
                this.c.a(this.b);
            }
        }
    }
}
