package io.appmetrica.analytics.impl;

import android.content.Context;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
public final class P extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Q f11287a;
    public final /* synthetic */ InterfaceC4544wi b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public P(Q q, InterfaceC4544wi interfaceC4544wi) {
        super(0);
        this.f11287a = q;
        this.b = interfaceC4544wi;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Q q = this.f11287a;
        K k = q.h;
        Context context = q.f11302a;
        InterfaceC4544wi interfaceC4544wi = this.b;
        k.getClass();
        return K.a(new J(k, context, interfaceC4544wi));
    }
}
