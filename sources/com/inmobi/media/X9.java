package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class X9 extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3330ca f3237a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public X9(C3330ca c3330ca) {
        super(1);
        this.f3237a = c3330ca;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        M9 data = (M9) obj;
        Intrinsics.checkNotNullParameter(data, "data");
        int iIncrementAndGet = this.f3237a.c.incrementAndGet();
        C3330ca c3330ca = this.f3237a;
        if (iIncrementAndGet == c3330ca.e) {
            if (data.f3136a == 0 && data.b == 0) {
                c3330ca.a(new O9((short) 2234), (M9) null);
            } else {
                StringsKt.trimMargin$default("No of In-App Purchases: " + data.f3136a + "\n                                    | and No of Subscriptions: " + data.b, null, 1, null);
                this.f3237a.a(P9.f3169a, data);
            }
        }
        return Unit.INSTANCE;
    }
}
