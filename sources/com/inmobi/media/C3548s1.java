package com.inmobi.media;

import com.inmobi.ads.AdMetaInfo;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiBanner;
import com.inmobi.ads.listeners.BannerAdEventListener;
import io.bidmachine.unified.UnifiedMediationParams;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.s1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3548s1 extends AbstractC3534r1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BannerAdEventListener f3422a;

    public C3548s1(BannerAdEventListener adEventListener) {
        Intrinsics.checkNotNullParameter(adEventListener, "adEventListener");
        this.f3422a = adEventListener;
    }

    @Override // com.inmobi.media.AbstractC3561t
    public final void a(Object obj, Map params) {
        InMobiBanner ad = (InMobiBanner) obj;
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(params, "params");
        this.f3422a.onAdClicked(ad, params);
    }

    @Override // com.inmobi.media.AbstractC3561t
    public final void b(Object obj, AdMetaInfo info) {
        InMobiBanner ad = (InMobiBanner) obj;
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(info, "info");
        this.f3422a.onAdLoadSucceeded(ad, info);
    }

    @Override // com.inmobi.media.AbstractC3561t
    public final void a(Object obj, AdMetaInfo info) {
        InMobiBanner ad = (InMobiBanner) obj;
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(info, "info");
        this.f3422a.onAdFetchSuccessful(ad, info);
    }

    @Override // com.inmobi.media.AbstractC3561t
    public final void a(Object obj) {
        InMobiBanner ad = (InMobiBanner) obj;
        Intrinsics.checkNotNullParameter(ad, "ad");
        this.f3422a.onAdImpression(ad);
    }

    @Override // com.inmobi.media.AbstractC3561t
    public final void a(Object obj, InMobiAdRequestStatus status) {
        InMobiBanner ad = (InMobiBanner) obj;
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullExpressionValue(UnifiedMediationParams.KEY_R1, "getSimpleName(...)");
        this.f3422a.onAdLoadFailed(ad, status);
    }

    @Override // com.inmobi.media.AbstractC3561t
    public final void a(Object obj, String data) {
        InMobiBanner ad = (InMobiBanner) obj;
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            Class<?> cls = Class.forName("IMraidLog");
            Method declaredMethod = cls.getDeclaredMethod("imraidLog", BannerAdEventListener.class, InMobiBanner.class, String.class);
            Intrinsics.checkNotNullExpressionValue(declaredMethod, "getDeclaredMethod(...)");
            declaredMethod.invoke(cls.newInstance(), this.f3422a, ad, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
