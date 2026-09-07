package com.yandex.mobile.ads.nativeads;

import com.yandex.mobile.ads.common.AdTheme;
import com.yandex.mobile.ads.impl.gq1;
import com.yandex.mobile.ads.impl.hq1;
import com.yandex.mobile.ads.impl.s61;
import com.yandex.mobile.ads.impl.v7;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final hq1 f10891a;
    private final s61 b;

    public f(hq1 requestedAdThemeFactory, s61 adRequestReadyResponseProvider) {
        Intrinsics.checkNotNullParameter(requestedAdThemeFactory, "requestedAdThemeFactory");
        Intrinsics.checkNotNullParameter(adRequestReadyResponseProvider, "adRequestReadyResponseProvider");
        this.f10891a = requestedAdThemeFactory;
        this.b = adRequestReadyResponseProvider;
    }

    public final v7 a(NativeAdRequestConfiguration adRequestConfiguration) {
        gq1 gq1VarA;
        Intrinsics.checkNotNullParameter(adRequestConfiguration, "nativeAdConfiguration");
        AdTheme preferredTheme = adRequestConfiguration.getPreferredTheme();
        if (preferredTheme != null) {
            this.f10891a.getClass();
            gq1VarA = hq1.a(preferredTheme);
        } else {
            gq1VarA = null;
        }
        this.b.getClass();
        Intrinsics.checkNotNullParameter(adRequestConfiguration, "adRequestConfiguration");
        return new v7.a(adRequestConfiguration.getAdUnitId()).a(adRequestConfiguration.getAge()).d(adRequestConfiguration.getBiddingData()).c(adRequestConfiguration.getGender()).b(adRequestConfiguration.getContextQuery()).a(adRequestConfiguration.getContextTags()).a(adRequestConfiguration.getLocation()).a(adRequestConfiguration.getParameters()).a(gq1VarA).a(adRequestConfiguration.getShouldLoadImagesAutomatically()).b().a();
    }

    public /* synthetic */ f() {
        this(new hq1(), new s61());
    }
}
