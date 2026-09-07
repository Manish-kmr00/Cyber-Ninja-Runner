package com.ogury.sdk;

import android.content.Context;
import com.amazon.aps.shared.util.APSSharedUtil;
import com.ogury.ad.common.OnAdsInitListener;
import com.ogury.ad.internal.InternalAds;
import com.ogury.core.OguryError;
import com.ogury.core.internal.IntegrationLogger;
import com.ogury.core.internal.InternalCore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Ogury.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0007J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002J\b\u0010\u0014\u001a\u00020\bH\u0002J\b\u0010\u0015\u001a\u00020\u000eH\u0007J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0012H\u0007J \u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\bH\u0007J \u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000eH\u0007J \u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0012H\u0007J\b\u0010\u001b\u001a\u00020\nH\u0002J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/ogury/sdk/Ogury;", "", "<init>", "()V", "oguryOnStartListeners", "", "Lcom/ogury/sdk/OguryOnStartListener;", "alreadyStartedWithSuccess", "", "start", "", "context", "Landroid/content/Context;", "assetKey", "", "oguryOnStartListener", "handleFailedSdkStart", "oguryStartErrorCode", "", "coreIsPresent", "adIsPresent", "getSdkVersion", "applyChildPrivacy", "childPrivacyTreatment", "setPrivacyData", "key", "value", "sendOnStart", "sendOnFailed", "error", "Lcom/ogury/core/OguryError;", "getCurrentApplicationVersionName", "sdk-wrapper_prodRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Ogury {
    private static boolean alreadyStartedWithSuccess;
    public static final Ogury INSTANCE = new Ogury();
    private static final List<OguryOnStartListener> oguryOnStartListeners = new ArrayList();

    private Ogury() {
    }

    private final boolean adIsPresent() {
        try {
            String version = InternalAds.getVersion();
            IntegrationLogger.d("[Ogury] Ads module " + version + " detected");
            if (Intrinsics.areEqual(version, "5.0.1")) {
                return true;
            }
            IntegrationLogger.i("[Ogury] Unexpected Ad version: " + version + " (5.0.1 expected)");
            return true;
        } catch (NoClassDefFoundError unused) {
            IntegrationLogger.e("[Ogury] Ad module is missing!");
            return false;
        } catch (Throwable th) {
            IntegrationLogger.e(th);
            return false;
        }
    }

    @JvmStatic
    public static final void applyChildPrivacy(int childPrivacyTreatment) {
        Boolean bool;
        Boolean bool2;
        Boolean bool3 = null;
        if (childPrivacyTreatment == 1) {
            bool = Boolean.FALSE;
        } else if (childPrivacyTreatment != 2) {
            if (childPrivacyTreatment == 4) {
                bool2 = Boolean.FALSE;
            } else if (childPrivacyTreatment != 8) {
                bool = null;
            } else {
                bool2 = Boolean.TRUE;
            }
            bool3 = bool2;
            bool = null;
        } else {
            bool = Boolean.TRUE;
        }
        InternalAds.setChildUnderCoppaTreatment(bool);
        InternalAds.setUnderAgeOfGdprConsentTreatment(bool3);
    }

    private final boolean coreIsPresent() {
        try {
            String version = InternalCore.getVersion();
            IntegrationLogger.d("[Ogury] Core module " + version + " detected");
            if (Intrinsics.areEqual(version, BuildConfig.CORE_VERSION)) {
                return true;
            }
            IntegrationLogger.i("[Ogury] Unexpected Core version: " + version + " (2.0.0 expected)");
            return true;
        } catch (NoClassDefFoundError unused) {
            IntegrationLogger.e("[Ogury] Core module is missing!");
            return false;
        } catch (Throwable th) {
            IntegrationLogger.e(th);
            return false;
        }
    }

    private final String getCurrentApplicationVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "";
        }
    }

    @JvmStatic
    public static final String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleFailedSdkStart(int oguryStartErrorCode) {
        if (oguryStartErrorCode == 1000) {
            sendOnFailed(new OguryError(oguryStartErrorCode, "The SDK could not be started because a required SDK module is missing."));
        } else {
            if (oguryStartErrorCode != 1001) {
                return;
            }
            sendOnFailed(new OguryError(oguryStartErrorCode, "The SDK could not be started because one of the required SDK modules failed to start."));
        }
    }

    private final void sendOnFailed(OguryError error) {
        Iterator<OguryOnStartListener> it = oguryOnStartListeners.iterator();
        while (it.hasNext()) {
            it.next().onFailed(error);
            it.remove();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendOnStart() {
        alreadyStartedWithSuccess = true;
        Iterator<OguryOnStartListener> it = oguryOnStartListeners.iterator();
        while (it.hasNext()) {
            it.next().onStarted();
            it.remove();
        }
    }

    @JvmStatic
    public static final void setPrivacyData(Context context, String key, boolean value) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        InternalCore.storePrivacyData(context, key, value);
    }

    @JvmStatic
    public static final synchronized void start(Context context, String assetKey, OguryOnStartListener oguryOnStartListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(assetKey, "assetKey");
        Intrinsics.checkNotNullParameter(oguryOnStartListener, "oguryOnStartListener");
        if (alreadyStartedWithSuccess) {
            IntegrationLogger.d("[Ogury] Ogury SDK is already started");
            oguryOnStartListener.onStarted();
            return;
        }
        oguryOnStartListeners.add(oguryOnStartListener);
        IntegrationLogger.d("[Ogury] Starting Ogury SDK " + getSdkVersion() + APSSharedUtil.TRUNCATE_SEPARATOR);
        String packageName = context.getPackageName();
        Ogury ogury = INSTANCE;
        IntegrationLogger.d("[Ogury][start] Package name: " + packageName + " ; version name: " + ogury.getCurrentApplicationVersionName(context) + " ; asset key: " + assetKey);
        Context applicationContext = context.getApplicationContext();
        IntegrationLogger.d("[Ogury] Starting modules...");
        if (ogury.coreIsPresent() && ogury.adIsPresent()) {
            Intrinsics.checkNotNull(applicationContext);
            InternalAds.start(applicationContext, assetKey, new OnAdsInitListener() { // from class: com.ogury.sdk.Ogury.start.1
                @Override // com.ogury.ad.common.OnAdsInitListener
                public void onFailed(OguryError error) {
                    Ogury.INSTANCE.handleFailedSdkStart(1001);
                }

                @Override // com.ogury.ad.common.OnAdsInitListener
                public void onInit() {
                    IntegrationLogger.d("[Ogury] Ogury SDK is started");
                    Ogury.INSTANCE.sendOnStart();
                }
            });
            return;
        }
        ogury.handleFailedSdkStart(1000);
    }

    @JvmStatic
    public static final void setPrivacyData(Context context, String key, String value) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        InternalCore.storePrivacyData(context, key, value);
    }

    @JvmStatic
    public static final void setPrivacyData(Context context, String key, int value) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        InternalCore.storePrivacyData(context, key, value);
    }
}
