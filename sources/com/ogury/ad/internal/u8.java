package com.ogury.ad.internal;

import android.app.Application;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class u8 implements s8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<c, List<c>, Unit> f7414a;

    public u8(o6.b showNextAd) {
        Intrinsics.checkNotNullParameter(showNextAd, "showNextAd");
        this.f7414a = showNextAd;
    }

    @Override // com.ogury.ad.internal.s8
    public final boolean a(Application application, List<c> ads, String nextAdId) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(ads, "ads");
        Intrinsics.checkNotNullParameter(nextAdId, "nextAdId");
        c cVarA = q5.a(ads, nextAdId);
        if (cVarA == null) {
            return false;
        }
        this.f7414a.invoke(cVarA, ads);
        return true;
    }
}
