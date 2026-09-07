package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
public final class Qa extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Qa f3176a = new Qa();

    public Qa() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Pa _request = (Pa) obj;
        long jLongValue = ((Number) obj2).longValue();
        Intrinsics.checkNotNullParameter(_request, "_request");
        Ra.a(_request, jLongValue);
        return Unit.INSTANCE;
    }
}
