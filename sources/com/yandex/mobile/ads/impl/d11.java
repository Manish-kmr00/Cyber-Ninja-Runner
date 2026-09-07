package com.yandex.mobile.ads.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
public abstract class d11 {
    protected abstract void a(Function1<? super xo0, Unit> function1);

    static final class a extends Lambda implements Function1<xo0, Unit> {
        public static final a b = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(xo0 xo0Var) {
            xo0 it = xo0Var;
            Intrinsics.checkNotNullParameter(it, "it");
            throw it;
        }
    }

    public final void a() {
        a(a.b);
    }
}
