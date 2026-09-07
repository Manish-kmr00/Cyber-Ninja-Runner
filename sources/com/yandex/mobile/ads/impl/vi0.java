package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class vi0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l50 f10482a;
    private final n4 b;

    public vi0(l50 environmentConfiguration, n4 adHostConfigurator) {
        Intrinsics.checkNotNullParameter(environmentConfiguration, "environmentConfiguration");
        Intrinsics.checkNotNullParameter(adHostConfigurator, "adHostConfigurator");
        this.f10482a = environmentConfiguration;
        this.b = adHostConfigurator;
    }

    public final void a(Context context, ui0 identifiers) {
        String strA;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(identifiers, "identifiers");
        df identifiers2 = identifiers.a();
        String strC = identifiers.c();
        zi0 identifiersType = identifiers.b();
        n4 n4Var = this.b;
        n4Var.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(identifiers2, "identifiers");
        Intrinsics.checkNotNullParameter(identifiersType, "identifiersType");
        int iOrdinal = identifiersType.ordinal();
        if (iOrdinal == 0) {
            strA = n4Var.a(context);
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            strA = identifiers2.a();
            if (strA == null) {
                strA = n4Var.a(context);
            }
        }
        this.f10482a.a(strA);
        this.f10482a.b(identifiers2.b());
        this.f10482a.d(identifiers2.c());
        this.f10482a.c(strC);
    }
}
