package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes4.dex */
public final class F5 extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ M f3068a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F5(M m) {
        super(1);
        this.f3068a = m;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        T8 it = (T8) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        this.f3068a.invoke(it.c);
        return Unit.INSTANCE;
    }
}
