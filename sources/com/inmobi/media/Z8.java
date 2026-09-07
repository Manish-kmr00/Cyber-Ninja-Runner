package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
public final class Z8 extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3300a9 f3257a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z8(C3300a9 c3300a9) {
        super(1);
        this.f3257a = c3300a9;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        T8 it = (T8) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        L4 l4 = this.f3257a.b;
        if (l4 != null) {
            ((M4) l4).a("NovatiqDataHandler", "Novatiq hyper id synced");
        }
        return Unit.INSTANCE;
    }
}
