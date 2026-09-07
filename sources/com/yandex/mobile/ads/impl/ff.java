package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
public final class ff implements nf {
    private static final long g = TimeUnit.SECONDS.toMillis(30);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ef f8889a;
    private final ue b;
    private final Handler c;
    private final bf d;
    private boolean e;
    private final Object f;

    static final class a extends Lambda implements Function0<Unit> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            ff.this.b();
            ff.this.d.getClass();
            bf.a();
            ff.b(ff.this);
            return Unit.INSTANCE;
        }
    }

    public ff(ef appMetricaIdentifiersChangedObservable, ue appMetricaAdapter) {
        Intrinsics.checkNotNullParameter(appMetricaIdentifiersChangedObservable, "appMetricaIdentifiersChangedObservable");
        Intrinsics.checkNotNullParameter(appMetricaAdapter, "appMetricaAdapter");
        this.f8889a = appMetricaIdentifiersChangedObservable;
        this.b = appMetricaAdapter;
        this.c = new Handler(Looper.getMainLooper());
        this.d = new bf();
        this.f = new Object();
    }

    public static final void b(ff ffVar) {
        ffVar.getClass();
        op0.b(new Object[0]);
        ffVar.f8889a.a();
    }

    public final void a(Context context, xi0 observer) {
        boolean z;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.f8889a.a(observer);
        try {
            synchronized (this.f) {
                if (this.e) {
                    z = false;
                } else {
                    z = true;
                    this.e = true;
                }
                Unit unit = Unit.INSTANCE;
            }
            if (z) {
                op0.a(new Object[0]);
                a();
                this.b.a(context, this);
            }
        } catch (Throwable unused) {
            b();
            op0.c(new Object[0]);
        }
    }

    @Override // com.yandex.mobile.ads.impl.nf
    public final void a(mf error) {
        Intrinsics.checkNotNullParameter(error, "error");
        b();
        this.d.a(error);
        op0.b(new Object[0]);
        this.f8889a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        synchronized (this.f) {
            this.c.removeCallbacksAndMessages(null);
            this.e = false;
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.yandex.mobile.ads.impl.nf
    public final void a(lf params) {
        Intrinsics.checkNotNullParameter(params, "params");
        op0.d(params);
        b();
        ef efVar = this.f8889a;
        String strC = params.c();
        efVar.a(new df(params.b(), params.a(), strC));
    }

    private final void a() {
        final a aVar = new a();
        this.c.postDelayed(new Runnable() { // from class: com.yandex.mobile.ads.impl.ff$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ff.a(aVar);
            }
        }, g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }
}
