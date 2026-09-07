package com.ogury.ad.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class v8<T> implements q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<T> f7423a;
    public boolean b;
    public Function1<? super d9, Unit> c;

    /* JADX WARN: Multi-variable type inference failed */
    public v8(Function0<? extends T> function0) {
        this.f7423a = function0;
    }

    public final <R> void a(final Function1<? super R, Unit> function1, final R r) {
        ((h8) i8.b.getValue()).a(new Runnable() { // from class: com.ogury.ad.internal.v8$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                v8.a(this.f$0, function1, r);
            }
        });
    }

    public final v8 b(final Function1 consumer) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        ((h8) i8.f7323a.getValue()).a(new Runnable() { // from class: com.ogury.ad.internal.v8$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                v8.a(this.f$0, consumer);
            }
        });
        return this;
    }

    public v8(Function0 function0, int i) {
        this.f7423a = function0;
    }

    @Override // com.ogury.ad.internal.q1
    public final void a() {
        this.c = null;
        this.b = true;
    }

    public final <R> v8<R> a(final Function1<? super T, ? extends R> work) {
        Intrinsics.checkNotNullParameter(work, "work");
        return new v8<>(new Function0() { // from class: com.ogury.ad.internal.v8$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return v8.a(work, this);
            }
        });
    }

    public static final Object a(Function1 function1, v8 v8Var) {
        return function1.invoke(v8Var.f7423a.invoke());
    }

    public static final void a(v8 v8Var, Function1 function1) {
        try {
            v8Var.a((Function1<? super T, Unit>) function1, v8Var.f7423a.invoke());
        } catch (d9 e) {
            Function1<? super d9, Unit> function2 = v8Var.c;
            if (function2 == null) {
                return;
            }
            v8Var.a(function2, e);
        }
    }

    public static final void a(v8 v8Var, Function1 function1, Object obj) {
        if (v8Var.b) {
            return;
        }
        function1.invoke(obj);
    }
}
