package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.inmobi.media.u1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3577u1 extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3605w1 f3439a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3577u1(C3605w1 c3605w1) {
        super(0);
        this.f3439a = c3605w1;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        C3605w1 c3605w1 = this.f3439a;
        L4 l4 = c3605w1.j;
        if (l4 != null) {
            String str = c3605w1.M;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((M4) l4).a(str, "loadWithRetry success");
        }
        this.f3439a.H0();
        return Unit.INSTANCE;
    }
}
