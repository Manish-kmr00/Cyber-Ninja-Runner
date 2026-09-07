package com.ogury.ad.interstitial.ui;

import android.app.Application;
import com.ogury.ad.internal.q5;
import com.ogury.ad.internal.s8;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements s8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterstitialActivity.a f7480a;

    public c() {
        InterstitialActivity.a interstitialStartCommand = InterstitialActivity.d;
        Intrinsics.checkNotNullParameter(interstitialStartCommand, "interstitialStartCommand");
        this.f7480a = interstitialStartCommand;
    }

    @Override // com.ogury.ad.internal.s8
    public final boolean a(Application application, List<com.ogury.ad.internal.c> ads, String nextAdId) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(ads, "ads");
        Intrinsics.checkNotNullParameter(nextAdId, "nextAdId");
        com.ogury.ad.internal.c cVarA = q5.a(ads, nextAdId);
        if (cVarA == null) {
            return false;
        }
        this.f7480a.a(application, cVarA, ads);
        return true;
    }
}
