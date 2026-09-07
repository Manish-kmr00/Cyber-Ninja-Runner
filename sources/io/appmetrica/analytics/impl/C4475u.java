package io.appmetrica.analytics.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C4475u extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C4450t f11788a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4475u(C4450t c4450t) {
        super(1);
        this.f11788a = c4450t;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        this.f11788a.e = (byte[]) obj;
        return Unit.INSTANCE;
    }
}
