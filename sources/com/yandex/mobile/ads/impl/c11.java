package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.Unit;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes5.dex */
public final class c11 {
    private static final Object f = new Object();
    private static volatile c11 g;
    public static final /* synthetic */ int h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final x01 f8558a;
    private final b11 b;
    private final gv1 c;
    private final uu1 d;
    private c e;

    public static final class a {
        @JvmStatic
        public static c11 a(uu1 sdkEnvironmentModule) {
            Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
            if (c11.g == null) {
                synchronized (c11.f) {
                    if (c11.g == null) {
                        c11.g = new c11(new x01(new y01()), new b11(), new gv1(), sdkEnvironmentModule);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            c11 c11Var = c11.g;
            if (c11Var != null) {
                return c11Var;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.yandex.mobile.ads.impl.c11$c[], still in use, count: 1, list:
  (r0v1 com.yandex.mobile.ads.impl.c11$c[]) from 0x0024: INVOKE (r0v1 com.yandex.mobile.ads.impl.c11$c[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
    	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    private static final class c {
        b,
        c,
        d;

        static {
            EnumEntriesKt.enumEntries(cVarArr);
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) e.clone();
        }

        private c() {
            super(str, i);
        }
    }

    /* synthetic */ c11(x01 x01Var, b11 b11Var, gv1 gv1Var, uu1 uu1Var) {
        this(x01Var, b11Var, gv1Var, uu1Var, c.b);
    }

    private c11(x01 x01Var, b11 b11Var, gv1 gv1Var, uu1 uu1Var, c cVar) {
        this.f8558a = x01Var;
        this.b = b11Var;
        this.c = gv1Var;
        this.d = uu1Var;
        this.e = cVar;
    }

    public final void a(final Context context, final at initializationListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initializationListener, "initializationListener");
        p0.a(context);
        this.f8558a.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.c11$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                c11.a(this.f$0, context, initializationListener);
            }
        });
    }

    private final void b(Context context, final at atVar) {
        boolean z;
        boolean z2;
        synchronized (f) {
            el0 el0Var = new el0(this.f8558a, atVar);
            z = false;
            if (this.e == c.d) {
                z2 = false;
                z = true;
            } else {
                this.b.a(el0Var);
                if (this.e == c.b) {
                    this.e = c.c;
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        if (z) {
            this.f8558a.b(new Runnable() { // from class: com.yandex.mobile.ads.impl.c11$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    c11.a(atVar);
                }
            });
        }
        if (z2) {
            b sdkInitializationListener = new b();
            gv1 gv1Var = this.c;
            uu1 sdkEnvironmentModule = this.d;
            gv1Var.getClass();
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
            Intrinsics.checkNotNullParameter(sdkInitializationListener, "sdkInitializationListener");
            this.f8558a.a(new fv1(context, sdkEnvironmentModule, CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(nu.a())), sdkInitializationListener));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(c11 this$0, Context context, at initializationListener) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(initializationListener, "$initializationListener");
        this$0.b(context, initializationListener);
    }

    private final class b implements hv1.a {
        @Override // com.yandex.mobile.ads.impl.hv1.a
        public final void a(w3 error) {
            Intrinsics.checkNotNullParameter(error, "error");
            Object obj = c11.f;
            c11 c11Var = c11.this;
            synchronized (obj) {
                c11Var.e = c.b;
                Unit unit = Unit.INSTANCE;
            }
            c11.this.b.a();
        }

        public b() {
        }

        @Override // com.yandex.mobile.ads.impl.hv1.a
        public final void a(jc advertisingConfiguration, l50 environmentConfiguration) {
            Intrinsics.checkNotNullParameter(advertisingConfiguration, "advertisingConfiguration");
            Intrinsics.checkNotNullParameter(environmentConfiguration, "environmentConfiguration");
            Object obj = c11.f;
            c11 c11Var = c11.this;
            synchronized (obj) {
                c11Var.e = c.d;
                Unit unit = Unit.INSTANCE;
            }
            c11.this.b.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(at initializationListener) {
        Intrinsics.checkNotNullParameter(initializationListener, "$initializationListener");
        initializationListener.onInitializationCompleted();
    }
}
