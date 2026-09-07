package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c2 {
    private static final Object f = new Object();
    private static volatile c2 g;
    public static final /* synthetic */ int h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wf0 f8560a;
    private final h2 b;
    private final f2 c;
    private boolean d;
    private final e2 e;

    public static final class a {
        @JvmStatic
        public static c2 a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (c2.g == null) {
                synchronized (c2.f) {
                    if (c2.g == null) {
                        c2.g = new c2(context, new wf0(context), new h2(context), new f2());
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            c2 c2Var = c2.g;
            if (c2Var != null) {
                return c2Var;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
    }

    public c2(Context context, wf0 hostAccessAdBlockerDetectionController, h2 adBlockerDetectorRequestPolicyChecker, f2 adBlockerDetectorListenerRegistry) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(hostAccessAdBlockerDetectionController, "hostAccessAdBlockerDetectionController");
        Intrinsics.checkNotNullParameter(adBlockerDetectorRequestPolicyChecker, "adBlockerDetectorRequestPolicyChecker");
        Intrinsics.checkNotNullParameter(adBlockerDetectorListenerRegistry, "adBlockerDetectorListenerRegistry");
        this.f8560a = hostAccessAdBlockerDetectionController;
        this.b = adBlockerDetectorRequestPolicyChecker;
        this.c = adBlockerDetectorListenerRegistry;
        this.e = new e2() { // from class: com.yandex.mobile.ads.impl.c2$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.e2
            public final void a() {
                c2.b(this.f$0);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(c2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        synchronized (f) {
            this$0.d = false;
            Unit unit = Unit.INSTANCE;
        }
        this$0.c.a();
    }

    public final void a(e2 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (f) {
            this.c.b(listener);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void b(e2 listener) {
        boolean z;
        Intrinsics.checkNotNullParameter(listener, "listener");
        g2 g2VarA = this.b.a();
        if (g2VarA != null) {
            synchronized (f) {
                if (this.d) {
                    z = false;
                } else {
                    z = true;
                    this.d = true;
                }
                this.c.a(listener);
                Unit unit = Unit.INSTANCE;
            }
            if (z) {
                this.f8560a.a(this.e, g2VarA);
                return;
            }
            return;
        }
        ((b2.a.b) listener).a();
    }
}
