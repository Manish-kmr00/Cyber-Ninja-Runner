package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
public final class Y9 extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3330ca f3246a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Y9(C3330ca c3330ca) {
        super(1);
        this.f3246a = c3330ca;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        V9 result = (V9) obj;
        Intrinsics.checkNotNullParameter(result, "result");
        if (result instanceof T9) {
            this.f3246a.a(new N9(String.valueOf(((T9) result).f3204a)), (M9) null);
        } else {
            C3330ca c3330ca = this.f3246a;
            c3330ca.a(new X9(c3330ca));
        }
        return Unit.INSTANCE;
    }
}
