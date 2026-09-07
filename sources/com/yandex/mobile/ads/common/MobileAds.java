package com.yandex.mobile.ads.common;

import android.content.Context;
import android.content.Intent;
import com.google.android.exoplayer2.C;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import com.yandex.mobile.ads.features.debugpanel.ui.IntegrationInspectorActivity;
import com.yandex.mobile.ads.impl.iw1;
import com.yandex.mobile.ads.impl.m11;
import com.yandex.mobile.ads.impl.rl2;
import com.yandex.mobile.ads.impl.wm2;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000bH\u0007J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u000bH\u0007J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u000bH\u0007J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u000bH\u0007J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007R\u001a\u0010\u0003\u001a\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/yandex/mobile/ads/common/MobileAds;", "", "()V", "libraryVersion", "", "getLibraryVersion$annotations", "getLibraryVersion", "()Ljava/lang/String;", "enableDebugErrorIndicator", "", "enableIndicator", "", "enableLogging", MobileAdsBridgeBase.initializeMethodName, "context", "Landroid/content/Context;", "initializationListener", "Lcom/yandex/mobile/ads/common/InitializationListener;", "setAgeRestrictedUser", "ageRestrictedUser", "setAppAdAnalyticsReporting", "reportingEnabled", "setLocationConsent", "locationConsent", "setUserConsent", "consent", "showDebugPanel", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MobileAds {
    public static final MobileAds INSTANCE = new MobileAds();

    private MobileAds() {
    }

    @JvmStatic
    public static final void enableDebugErrorIndicator(boolean enableIndicator) {
        int i = m11.f9588a;
        int i2 = iw1.l;
        iw1.a.a().a(enableIndicator);
    }

    @JvmStatic
    public static final void enableLogging(boolean enableLogging) {
        m11.a(enableLogging);
    }

    public static final String getLibraryVersion() {
        int i = m11.f9588a;
        return "7.12.1";
    }

    @JvmStatic
    public static /* synthetic */ void getLibraryVersion$annotations() {
    }

    @JvmStatic
    public static final void initialize(Context context, InitializationListener initializationListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initializationListener, "initializationListener");
        m11.a(context, new wm2(context), new rl2(initializationListener));
    }

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, h.y);
        p0.startActivity(p1);
    }

    @JvmStatic
    public static final void setAgeRestrictedUser(boolean ageRestrictedUser) {
        int i = m11.f9588a;
        int i2 = iw1.l;
        iw1.a.a().c(ageRestrictedUser);
    }

    @JvmStatic
    public static final void setAppAdAnalyticsReporting(boolean reportingEnabled) {
        int i = m11.f9588a;
        int i2 = iw1.l;
        iw1.a.a().d(reportingEnabled);
    }

    @JvmStatic
    public static final void setLocationConsent(boolean locationConsent) {
        int i = m11.f9588a;
        int i2 = iw1.l;
        iw1.a.a().e(locationConsent);
    }

    @JvmStatic
    public static final void setUserConsent(boolean consent) {
        int i = m11.f9588a;
        int i2 = iw1.l;
        iw1.a.a().f(consent);
    }

    @JvmStatic
    public static final void showDebugPanel(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(context, (Class<?>) IntegrationInspectorActivity.class);
        intent.addFlags(C.ENCODING_PCM_32BIT);
        safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intent);
    }
}
