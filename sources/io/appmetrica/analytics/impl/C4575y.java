package io.appmetrica.analytics.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C4575y extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C4450t f11848a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4575y(C4450t c4450t) {
        super(1);
        this.f11848a = c4450t;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        this.f11848a.g = (byte[]) obj;
        return Unit.INSTANCE;
    }
}
