package com.yandex.mobile.ads.impl;

import com.monetization.ads.core.utils.CallbackStackTraceMarker;
import com.yandex.mobile.ads.common.InitializationListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
public final class rl2 implements at {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InitializationListener f10120a;

    static final class a extends Lambda implements Function0<Unit> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            rl2.this.f10120a.onInitializationCompleted();
            return Unit.INSTANCE;
        }
    }

    public rl2(InitializationListener initializationListener) {
        Intrinsics.checkNotNullParameter(initializationListener, "initializationListener");
        this.f10120a = initializationListener;
    }

    @Override // com.yandex.mobile.ads.impl.at
    public final void onInitializationCompleted() {
        new CallbackStackTraceMarker(new a());
    }

    public final boolean equals(Object obj) {
        return (obj instanceof rl2) && Intrinsics.areEqual(((rl2) obj).f10120a, this.f10120a);
    }

    public final int hashCode() {
        return this.f10120a.hashCode();
    }
}
