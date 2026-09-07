package com.ogury.ad.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import com.ogury.ad.common.OnAdsInitListener;
import com.ogury.core.internal.IntegrationLogger;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridge;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\tH\u0007J\u0017\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/ogury/ad/internal/InternalAds;", "", "<init>", "()V", "start", "", "context", "Landroid/content/Context;", "assetKey", "", "onAdsInitListener", "Lcom/ogury/ad/common/OnAdsInitListener;", MobileAdsBridge.versionMethodName, "setChildUnderCoppaTreatment", "isChildUnderCoppa", "", "(Ljava/lang/Boolean;)V", "setUnderAgeOfGdprConsentTreatment", "isUnderAgeOfGdprConsent", "sdk-ads_prodRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InternalAds {
    static {
        new InternalAds();
    }

    private InternalAds() {
    }

    @JvmStatic
    public static final String getVersion() {
        a6.b.getClass();
        return "5.0.1";
    }

    @JvmStatic
    public static final void setChildUnderCoppaTreatment(Boolean isChildUnderCoppa) {
        e2 e2Var = e2.f7288a;
        Intrinsics.checkNotNullParameter("IS_CHILD_UNDER_COPPA", "key");
        if (isChildUnderCoppa != null) {
            e2.b.putBoolean("IS_CHILD_UNDER_COPPA", isChildUnderCoppa.booleanValue());
        } else {
            Intrinsics.checkNotNullParameter("IS_CHILD_UNDER_COPPA", "configurationKey");
            e2.b.remove("IS_CHILD_UNDER_COPPA");
        }
    }

    @JvmStatic
    public static final void setUnderAgeOfGdprConsentTreatment(Boolean isUnderAgeOfGdprConsent) {
        e2 e2Var = e2.f7288a;
        Intrinsics.checkNotNullParameter("IS_UNDER_AGE_OF_GDPR_CONSENT", "key");
        if (isUnderAgeOfGdprConsent != null) {
            e2.b.putBoolean("IS_UNDER_AGE_OF_GDPR_CONSENT", isUnderAgeOfGdprConsent.booleanValue());
        } else {
            Intrinsics.checkNotNullParameter("IS_UNDER_AGE_OF_GDPR_CONSENT", "configurationKey");
            e2.b.remove("IS_UNDER_AGE_OF_GDPR_CONSENT");
        }
    }

    @JvmStatic
    public static final void start(Context context, String assetKey, OnAdsInitListener onAdsInitListener) throws PackageManager.NameNotFoundException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(assetKey, "assetKey");
        Intrinsics.checkNotNullParameter(onAdsInitListener, "onAdsInitListener");
        IntegrationLogger.d("[Ads] Module started");
        a6 a6Var = a6.f7259a;
        v adsConfig = new v(context, assetKey, onAdsInitListener);
        Intrinsics.checkNotNullParameter(adsConfig, "adsConfig");
        IntegrationLogger.d("[Ads] Setting up...");
        a6.b.a(adsConfig);
    }
}
