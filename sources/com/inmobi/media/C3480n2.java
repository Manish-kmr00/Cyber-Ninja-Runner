package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.inmobi.media.n2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3480n2 extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C3480n2 f3379a = new C3480n2();

    public C3480n2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        N1 it = (N1) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        Intrinsics.checkNotNullExpressionValue(C3578u2.f(), "access$getTAG$cp(...)");
        C3578u2.d.set(false);
        return Unit.INSTANCE;
    }
}
