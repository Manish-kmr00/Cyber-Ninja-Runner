package com.ogury.ad.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h1 implements q1 {
    public static final a d = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f7311a;
    public boolean b;
    public Function1<? super Throwable, Unit> c;

    public static final class a {
        public static h1 a(Function0 action) {
            Intrinsics.checkNotNullParameter(action, "action");
            return new h1(action);
        }
    }

    public h1(Function0 function0) {
        this.f7311a = function0;
    }

    public final void a(final Function0<Unit> function0) {
        ((h8) i8.b.getValue()).a(new Runnable() { // from class: com.ogury.ad.internal.h1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                h1.a(this.f$0, function0);
            }
        });
    }

    public final void b(final Function0 subscribedAction) {
        Intrinsics.checkNotNullParameter(subscribedAction, "subscribedAction");
        ((h8) i8.f7323a.getValue()).a(new Runnable() { // from class: com.ogury.ad.internal.h1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                h1.b(this.f$0, subscribedAction);
            }
        });
    }

    public static final void b(h1 h1Var, Function0 function0) {
        try {
            h1Var.f7311a.invoke();
            h1Var.a((Function0<Unit>) function0);
        } catch (Throwable th) {
            Function1<? super Throwable, Unit> function1 = h1Var.c;
            if (function1 == null) {
                return;
            }
            h1Var.a(function1, th);
        }
    }

    public final void a(final Function1 function1, final Throwable th) {
        ((h8) i8.b.getValue()).a(new Runnable() { // from class: com.ogury.ad.internal.h1$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                h1.a(this.f$0, function1, th);
            }
        });
    }

    @Override // com.ogury.ad.internal.q1
    public final void a() {
        this.c = null;
        this.b = true;
    }

    public final h1 a(Function1<? super Throwable, Unit> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        this.c = consumer;
        return this;
    }

    public static final void a(h1 h1Var, Function0 function0) {
        if (h1Var.b) {
            return;
        }
        function0.invoke();
    }

    public static final void a(h1 h1Var, Function1 function1, Object obj) {
        if (h1Var.b) {
            return;
        }
        function1.invoke(obj);
    }
}
