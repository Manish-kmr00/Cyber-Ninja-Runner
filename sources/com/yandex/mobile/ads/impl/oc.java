package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class oc implements sc {
    private static final Object f = new Object();
    private static volatile oc g;
    public static final /* synthetic */ int h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f9806a;
    private final tc b;
    private final uc c;
    private boolean d;
    private final zy e;

    public static final class a {
        @JvmStatic
        public static oc a(Context context) {
            oc ocVar;
            Intrinsics.checkNotNullParameter(context, "context");
            oc ocVar2 = oc.g;
            if (ocVar2 != null) {
                return ocVar2;
            }
            synchronized (oc.f) {
                ocVar = oc.g;
                if (ocVar == null) {
                    ocVar = new oc(context);
                    oc.g = ocVar;
                }
            }
            return ocVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(oc this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e();
        this$0.b.a();
    }

    private final void e() {
        synchronized (f) {
            this.f9806a.removeCallbacksAndMessages(null);
            this.d = false;
            Unit unit = Unit.INSTANCE;
        }
    }

    /* synthetic */ oc(Context context) {
        this(new Handler(Looper.getMainLooper()), new tc(), new uc(context), new wc());
    }

    public final void b(vc listener) {
        boolean z;
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.b.a(listener);
        synchronized (f) {
            if (this.d) {
                z = false;
            } else {
                z = true;
                this.d = true;
            }
            Unit unit = Unit.INSTANCE;
        }
        if (z) {
            d();
            this.c.a(this);
        }
    }

    private oc(Handler handler, tc tcVar, uc ucVar, wc wcVar) {
        this.f9806a = handler;
        this.b = tcVar;
        this.c = ucVar;
        wcVar.getClass();
        this.e = wc.a();
    }

    public final void a(vc listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.b.b(listener);
    }

    @Override // com.yandex.mobile.ads.impl.sc
    public final void a(nc advertisingInfoHolder) {
        Intrinsics.checkNotNullParameter(advertisingInfoHolder, "advertisingInfoHolder");
        e();
        this.b.b(advertisingInfoHolder);
    }

    private final void d() {
        this.f9806a.postDelayed(new Runnable() { // from class: com.yandex.mobile.ads.impl.oc$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                oc.b(this.f$0);
            }
        }, this.e.a());
    }

    @Override // com.yandex.mobile.ads.impl.sc
    public final void a() {
        e();
        this.b.a();
    }
}
