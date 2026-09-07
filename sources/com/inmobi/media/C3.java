package com.inmobi.media;

import android.view.ViewParent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
public final class C3 extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ E3 f3039a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3(E3 e3) {
        super(0);
        this.f3039a = e3;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        InterfaceC3649z3 interfaceC3649z3;
        ViewParent parent = this.f3039a.getParent();
        C3607w3 c3607w3 = parent instanceof C3607w3 ? (C3607w3) parent : null;
        if (c3607w3 != null && (interfaceC3649z3 = c3607w3.d) != null) {
            r rVar = ((C3580u4) interfaceC3649z3).f3442a.b;
            Ba ba = rVar instanceof Ba ? (Ba) rVar : null;
            if (ba != null) {
                ba.m();
            }
        }
        return Unit.INSTANCE;
    }
}
