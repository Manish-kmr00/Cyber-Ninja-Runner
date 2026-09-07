package io.appmetrica.analytics.impl;

import android.content.Context;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
public final class N extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Q f11261a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N(Q q) {
        super(0);
        this.f11261a = q;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Q q = this.f11261a;
        K k = q.f;
        Context context = q.f11302a;
        k.getClass();
        return K.a(new I(k, context));
    }
}
