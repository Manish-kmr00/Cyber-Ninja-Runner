package com.ogury.ad.internal;

import android.app.Application;
import com.ogury.ad.interstitial.ui.InterstitialActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h0 {
    public h0() {
        InterstitialActivity.a interstitialShowCommand = InterstitialActivity.d;
        Intrinsics.checkNotNullParameter(interstitialShowCommand, "interstitialShowCommand");
    }

    public static g0 a(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        InterstitialActivity.a aVar = InterstitialActivity.d;
        return new g0(application);
    }
}
