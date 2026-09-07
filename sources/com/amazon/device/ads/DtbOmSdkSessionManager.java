package com.amazon.device.ads;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.amazon.aps.shared.APSAnalytics;
import com.amazon.aps.shared.analytics.APSEventSeverity;
import com.amazon.aps.shared.analytics.APSEventType;
import com.iab.omid.library.amazon.Omid;
import com.iab.omid.library.amazon.adsession.AdEvents;
import com.iab.omid.library.amazon.adsession.AdSession;
import com.iab.omid.library.amazon.adsession.AdSessionConfiguration;
import com.iab.omid.library.amazon.adsession.AdSessionContext;
import com.iab.omid.library.amazon.adsession.CreativeType;
import com.iab.omid.library.amazon.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.amazon.adsession.ImpressionType;
import com.iab.omid.library.amazon.adsession.Owner;
import com.iab.omid.library.amazon.adsession.Partner;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public class DtbOmSdkSessionManager {
    private static final String APS_OMSDK_ACTIVATION_NOT_INITIALIZED_MESSAGE = "OMIDSDK Activation failed to initialize";
    private static final String APS_OM_SDK_ACTIVATION_ERROR_MESSAGE = "OMIDSDK Failed to activate";
    private static final String APS_OM_SDK_ADD_FRIENDLY_OBSTRUCTION_ERROR_MESSAGE = "OMIDSDK Failed to add friendly obstruction";
    private static final String APS_OM_SDK_AD_EVENTS_CREATION_ERROR_MESSAGE = "OMIDSDK Failed to create ad event";
    private static final String APS_OM_SDK_AD_SESSION_CONFIG_ERROR_MESSAGE = "OMIDSDK Failed to initialize config for ";
    private static final String APS_OM_SDK_AD_SESSION_CREATION_ERROR_MESSAGE = "OMIDSDK Failed to create ad session";
    private static final String APS_OM_SDK_IMPRESSION_ERROR_MESSAGE = "OMIDSDK Failed to trigger impression event";
    private static final String APS_OM_SDK_LOAD_EVENT_ERROR_MESSAGE = "OMIDSDK Failed to load ad event";
    private static final String APS_OM_SDK_PARTNER_OBJECT_ERROR_MESSAGE = "OMIDSDK Failed to create partner object";
    private static final String APS_OM_SDK_REGISTER_AD_VIEW_ERROR_MESSAGE = "OMIDSDK Failed to register ad view";
    private static final String APS_OM_SDK_START_AD_SESSION_ERROR_MESSAGE = "OMIDSDK Failed to start ad session";
    private static final String APS_OM_SDK_STOP_AD_SESSION_ERROR_MESSAGE = "OMIDSDK Failed to stop ad session";
    private static final String LOGTAG = "DtbOmSdkSessionManager";
    private static boolean featureEnabled;
    private static boolean isOmSdkActive;
    private AdSessionConfiguration adSessionConfiguration;
    private AdSessionContext adSessionContext;
    private AdEvents dtbOmSdkAdEvents;
    private AdSession dtbOmSdkAdSession;
    private Partner dtbOmSdkPartner;

    private DtbOmSdkSessionManager() {
        computeFeatureEnabledFlag();
        if (featureEnabled) {
            DtbThreadService.executeOnMainThread(new Runnable() { // from class: com.amazon.device.ads.DtbOmSdkSessionManager$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m4424lambda$new$0$comamazondeviceadsDtbOmSdkSessionManager();
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$new$0$com-amazon-device-ads-DtbOmSdkSessionManager, reason: not valid java name */
    /* synthetic */ void m4424lambda$new$0$comamazondeviceadsDtbOmSdkSessionManager() {
        try {
            this.dtbOmSdkPartner = Partner.createPartner(DTBMetricsConfiguration.getClientConfigVal("partner_name", "Amazon1", "om_sdk_feature"), DtbCommonUtils.getSDKVersion());
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.ERROR, APSEventType.EXCEPTION, APS_OM_SDK_PARTNER_OBJECT_ERROR_MESSAGE, e);
        }
    }

    private void computeFeatureEnabledFlag() {
        List<String> deniedOmSdkVersionList = DTBMetricsConfiguration.getDeniedOmSdkVersionList("denied_version_list");
        if (deniedOmSdkVersionList.isEmpty()) {
            featureEnabled = true;
        } else {
            featureEnabled = !deniedOmSdkVersionList.contains(DtbConstants.INTEGRATED_OM_VERSION.replaceAll("_", "."));
        }
    }

    protected static void activateOMSDK(final Context context) {
        DtbThreadService.executeOnMainThread(new Runnable() { // from class: com.amazon.device.ads.DtbOmSdkSessionManager$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                DtbOmSdkSessionManager.lambda$activateOMSDK$1(context);
            }
        });
    }

    static /* synthetic */ void lambda$activateOMSDK$1(Context context) {
        try {
            Class.forName("com.iab.omid.library.amazon.Omid");
            Omid.activate(context);
            isOmSdkActive = Omid.isActive();
        } catch (Throwable th) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, APS_OM_SDK_ACTIVATION_ERROR_MESSAGE, th);
        }
    }

    public static DtbOmSdkSessionManager getNewInstance() {
        if (!isOmSdkActive) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.LOG, APS_OMSDK_ACTIVATION_NOT_INITIALIZED_MESSAGE);
            return null;
        }
        return new DtbOmSdkSessionManager();
    }

    public void initHtmlDisplayOmAdSession(WebView webView, String str) {
        initOmAdSession(webView, str, CreativeType.HTML_DISPLAY, Owner.NATIVE, Owner.NONE, false);
    }

    public void initJavaScriptOmAdSession(WebView webView, String str) {
        initOmAdSession(webView, str, CreativeType.DEFINED_BY_JAVASCRIPT, Owner.JAVASCRIPT, Owner.JAVASCRIPT, true);
    }

    private void initOmAdSession(final WebView webView, final String str, final CreativeType creativeType, final Owner owner, final Owner owner2, final boolean z) {
        if (!featureEnabled) {
            DtbLog.error(LOGTAG, "OM SDK Feature Turned Off");
        } else {
            DtbThreadService.executeOnMainThread(new Runnable() { // from class: com.amazon.device.ads.DtbOmSdkSessionManager$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m4423xd08b5f46(creativeType, owner, owner2, z, webView, str);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$initOmAdSession$2$com-amazon-device-ads-DtbOmSdkSessionManager, reason: not valid java name */
    /* synthetic */ void m4423xd08b5f46(CreativeType creativeType, Owner owner, Owner owner2, boolean z, WebView webView, String str) {
        if (this.dtbOmSdkPartner == null) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.LOG, APS_OM_SDK_PARTNER_OBJECT_ERROR_MESSAGE);
            return;
        }
        try {
            this.adSessionConfiguration = AdSessionConfiguration.createAdSessionConfiguration(creativeType, ImpressionType.BEGIN_TO_RENDER, owner, owner2, z);
            AdSessionContext adSessionContextCreateHtmlAdSessionContext = AdSessionContext.createHtmlAdSessionContext(this.dtbOmSdkPartner, webView, str, "");
            this.adSessionContext = adSessionContextCreateHtmlAdSessionContext;
            createOmAdSession(this.adSessionConfiguration, adSessionContextCreateHtmlAdSessionContext);
            if (CreativeType.HTML_DISPLAY.equals(creativeType)) {
                createOmAdEvents();
            }
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, APS_OM_SDK_AD_SESSION_CONFIG_ERROR_MESSAGE + creativeType, e);
        }
    }

    private void createOmAdSession(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        if (adSessionConfiguration == null || adSessionContext == null) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.LOG, APS_OM_SDK_AD_SESSION_CREATION_ERROR_MESSAGE);
        } else {
            this.dtbOmSdkAdSession = AdSession.createAdSession(adSessionConfiguration, adSessionContext);
            DtbLog.info(LOGTAG, "OMSDK : Open measurement ad Session Created");
        }
    }

    private void createOmAdEvents() {
        AdSession adSession = this.dtbOmSdkAdSession;
        if (adSession == null) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.LOG, "OMIDSDK Failed to create ad event on create Ad Event");
        } else {
            this.dtbOmSdkAdEvents = AdEvents.createAdEvents(adSession);
            DtbLog.info(LOGTAG, "OMSDK : Open measurement ad Event created");
        }
    }

    public void registerAdView(final WebView webView) {
        DtbThreadService.executeOnMainThread(new Runnable() { // from class: com.amazon.device.ads.DtbOmSdkSessionManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m4425x3feec725(webView);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$registerAdView$3$com-amazon-device-ads-DtbOmSdkSessionManager, reason: not valid java name */
    /* synthetic */ void m4425x3feec725(WebView webView) {
        AdSession adSession = this.dtbOmSdkAdSession;
        if (adSession == null) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.LOG, "OMIDSDK Failed to create ad session on register Ad View");
            return;
        }
        try {
            adSession.registerAdView(webView);
            DtbLog.info(LOGTAG, "OMSDK : Open measurement ad view registered");
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, APS_OM_SDK_REGISTER_AD_VIEW_ERROR_MESSAGE, e);
        }
    }

    public void startAdSession() {
        DtbThreadService.executeOnMainThread(new Runnable() { // from class: com.amazon.device.ads.DtbOmSdkSessionManager$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m4426x5935733e();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$startAdSession$4$com-amazon-device-ads-DtbOmSdkSessionManager, reason: not valid java name */
    /* synthetic */ void m4426x5935733e() {
        AdSession adSession = this.dtbOmSdkAdSession;
        if (adSession == null) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.LOG, "OMIDSDK Failed to create ad session on start Ad Session");
            return;
        }
        try {
            adSession.start();
            DtbLog.info(LOGTAG, "OMSDK : Open measurement ad session id: " + this.dtbOmSdkAdSession.getAdSessionId());
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, APS_OM_SDK_START_AD_SESSION_ERROR_MESSAGE, e);
        }
    }

    public void displayAdEventLoaded() {
        DtbThreadService.executeOnMainThread(new Runnable() { // from class: com.amazon.device.ads.DtbOmSdkSessionManager$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m4421x5c6bb0b4();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$displayAdEventLoaded$5$com-amazon-device-ads-DtbOmSdkSessionManager, reason: not valid java name */
    /* synthetic */ void m4421x5c6bb0b4() {
        AdEvents adEvents = this.dtbOmSdkAdEvents;
        if (adEvents == null) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.LOG, "OMIDSDK Failed to create ad event on adLoaded event");
            return;
        }
        try {
            adEvents.loaded();
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, APS_OM_SDK_LOAD_EVENT_ERROR_MESSAGE, e);
        }
    }

    protected AdSession getCurrentAdSession() {
        return this.dtbOmSdkAdSession;
    }

    protected AdEvents getCurrentAdEvents() {
        return this.dtbOmSdkAdEvents;
    }

    protected void impressionOccured() {
        DtbThreadService.executeOnMainThread(new Runnable() { // from class: com.amazon.device.ads.DtbOmSdkSessionManager$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m4422xc1e8f325();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$impressionOccured$6$com-amazon-device-ads-DtbOmSdkSessionManager, reason: not valid java name */
    /* synthetic */ void m4422xc1e8f325() {
        AdEvents adEvents = this.dtbOmSdkAdEvents;
        if (adEvents == null) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.LOG, "OMIDSDK Failed to create ad event on impressionOccured");
            return;
        }
        try {
            adEvents.impressionOccurred();
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, APS_OM_SDK_IMPRESSION_ERROR_MESSAGE, e);
        }
    }

    public synchronized void stopOmAdSession() {
        DtbThreadService.executeOnMainThread(new Runnable() { // from class: com.amazon.device.ads.DtbOmSdkSessionManager$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m4427x7a52d3d3();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$stopOmAdSession$7$com-amazon-device-ads-DtbOmSdkSessionManager, reason: not valid java name */
    /* synthetic */ void m4427x7a52d3d3() {
        AdSession adSession = this.dtbOmSdkAdSession;
        if (adSession == null || !isOmSdkActive) {
            DtbLog.error(LOGTAG, "OMSDK : Open measurement ad Session not active");
            return;
        }
        try {
            adSession.finish();
            this.adSessionContext = null;
            this.dtbOmSdkAdSession = null;
            this.dtbOmSdkAdEvents = null;
            this.adSessionConfiguration = null;
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, APS_OM_SDK_STOP_AD_SESSION_ERROR_MESSAGE, e);
        }
    }

    public void addFriendlyObstruction(final View view, final FriendlyObstructionPurpose friendlyObstructionPurpose) {
        DtbThreadService.executeOnMainThread(new Runnable() { // from class: com.amazon.device.ads.DtbOmSdkSessionManager$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m4420xd189d377(view, friendlyObstructionPurpose);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$addFriendlyObstruction$8$com-amazon-device-ads-DtbOmSdkSessionManager, reason: not valid java name */
    /* synthetic */ void m4420xd189d377(View view, FriendlyObstructionPurpose friendlyObstructionPurpose) {
        AdSession adSession = this.dtbOmSdkAdSession;
        if (adSession == null) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.LOG, "OMIDSDK Failed to create ad session on add Friendly Obstruction");
            return;
        }
        try {
            adSession.addFriendlyObstruction(view, friendlyObstructionPurpose, null);
        } catch (RuntimeException unused) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, APS_OM_SDK_ADD_FRIENDLY_OBSTRUCTION_ERROR_MESSAGE);
        }
    }

    public static boolean getFeatureEnableFlag() {
        return featureEnabled;
    }

    protected static boolean isOmSdkActive() {
        return isOmSdkActive;
    }
}
