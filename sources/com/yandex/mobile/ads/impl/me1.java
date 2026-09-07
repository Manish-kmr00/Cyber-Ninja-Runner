package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.TimeUnit;
import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class me1 {
    public static final a g = new a(0);
    private static final long h = TimeUnit.SECONDS.toMillis(1);
    private static volatile me1 i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f9633a;
    private final Handler b;
    private final le1 c;
    private final je1 d;
    private boolean e;
    private boolean f;

    public static final void a(me1 me1Var) {
        synchronized (me1Var.f9633a) {
            me1Var.f = true;
            Unit unit = Unit.INSTANCE;
        }
        me1Var.d();
        me1Var.d.b();
    }

    private me1(Context context) {
        this.f9633a = new Object();
        this.b = new Handler(Looper.getMainLooper());
        this.c = new le1(context);
        this.d = new je1();
    }

    public final void a(ua2 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.f9633a) {
            this.d.b(listener);
            if (!this.d.a()) {
                this.c.a();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public /* synthetic */ me1(Context context, int i2) {
        this(context);
    }

    /* synthetic */ class b implements ua2, FunctionAdapter {
        b() {
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof ua2) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return new FunctionReferenceImpl(0, me1.this, me1.class, "onOmSdkJsControllerLoaded", "onOmSdkJsControllerLoaded()V", 0);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // com.yandex.mobile.ads.impl.ua2
        public final void a() {
            me1.a(me1.this);
        }
    }

    private final void b() {
        boolean z;
        synchronized (this.f9633a) {
            if (this.e) {
                z = false;
            } else {
                z = true;
                this.e = true;
            }
            Unit unit = Unit.INSTANCE;
        }
        if (z) {
            c();
            this.c.a(new b());
        }
    }

    private final void c() {
        this.b.postDelayed(new Runnable() { // from class: com.yandex.mobile.ads.impl.me1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                me1.c(this.f$0);
            }
        }, h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(me1 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.c.a();
        synchronized (this$0.f9633a) {
            this$0.f = true;
            Unit unit = Unit.INSTANCE;
        }
        this$0.d();
        this$0.d.b();
    }

    private final void d() {
        synchronized (this.f9633a) {
            this.b.removeCallbacksAndMessages(null);
            this.e = false;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void b(ua2 listener) {
        boolean z;
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.f9633a) {
            z = this.f;
            if (!z) {
                this.d.a(listener);
            }
            Unit unit = Unit.INSTANCE;
        }
        if (!z) {
            b();
        } else {
            listener.a();
        }
    }

    public static final class a {
        public final me1 a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            me1 me1Var = me1.i;
            if (me1Var == null) {
                synchronized (this) {
                    me1Var = me1.i;
                    if (me1Var == null) {
                        me1Var = new me1(context, 0);
                        me1.i = me1Var;
                    }
                }
            }
            return me1Var;
        }

        private a() {
        }

        public /* synthetic */ a(int i) {
            this();
        }
    }
}
