package io.appmetrica.analytics.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C4550x extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C4450t f11835a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4550x(C4450t c4450t) {
        super(1);
        this.f11835a = c4450t;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        this.f11835a.f = (byte[]) obj;
        return Unit.INSTANCE;
    }
}
