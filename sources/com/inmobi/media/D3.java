package com.inmobi.media;

import android.view.ViewParent;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
public final class D3 extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ E3 f3047a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D3(E3 e3) {
        super(2);
        this.f3047a = e3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        String trackerName = (String) obj;
        Map macros = (Map) obj2;
        Intrinsics.checkNotNullParameter(trackerName, "trackerName");
        Intrinsics.checkNotNullParameter(macros, "macros");
        ViewParent parent = this.f3047a.getParent();
        C3607w3 c3607w3 = parent instanceof C3607w3 ? (C3607w3) parent : null;
        if (c3607w3 != null) {
            Intrinsics.checkNotNullParameter(trackerName, "trackerName");
            Intrinsics.checkNotNullParameter(macros, "macros");
            InterfaceC3649z3 interfaceC3649z3 = c3607w3.d;
            if (interfaceC3649z3 != null) {
                Intrinsics.checkNotNullParameter(trackerName, "trackerName");
                Intrinsics.checkNotNullParameter(macros, "macros");
                r rVar = ((C3580u4) interfaceC3649z3).f3442a.b;
                Ba ba = rVar instanceof Ba ? (Ba) rVar : null;
                if (ba != null) {
                    ba.a(trackerName, macros);
                }
            }
        }
        return Unit.INSTANCE;
    }
}
