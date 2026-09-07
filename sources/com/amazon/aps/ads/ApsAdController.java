package com.amazon.aps.ads;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import com.amazon.aps.ads.activity.ApsInterstitialActivity;
import com.amazon.aps.ads.listeners.ApsAdListener;
import com.amazon.aps.ads.model.ApsAdFormat;
import com.amazon.aps.shared.APSAnalytics;
import com.amazon.aps.shared.analytics.APSEventSeverity;
import com.amazon.aps.shared.analytics.APSEventType;
import com.amazon.device.ads.AdType;
import com.amazon.device.ads.DTBAdMRAIDController;
import com.amazon.device.ads.DtbOmSdkSessionManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.json.m5;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: ApsAdController.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0010\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\rJ\u001e\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u001e\u0010\u001f\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\b2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#J\u000e\u0010&\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!J\u0010\u0010&\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010&\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\bJ\u000e\u0010'\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\bJ\u0014\u0010(\u001a\u00020\u001b2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001b0*J\u0006\u0010+\u001a\u00020\u001bJ\b\u0010,\u001a\u00020\u001bH\u0002R\u0014\u0010\u0007\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0017@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006-"}, d2 = {"Lcom/amazon/aps/ads/ApsAdController;", "", "context", "Landroid/content/Context;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/amazon/aps/ads/listeners/ApsAdListener;", "(Landroid/content/Context;Lcom/amazon/aps/ads/listeners/ApsAdListener;)V", "HTTPS_WEB_URL", "", "getHTTPS_WEB_URL", "()Ljava/lang/String;", "TAG", "apsAd", "Lcom/amazon/aps/ads/ApsAd;", "apsAdListener", "apsAdListenerInternal", "com/amazon/aps/ads/ApsAdController$apsAdListenerInternal$1", "Lcom/amazon/aps/ads/ApsAdController$apsAdListenerInternal$1;", "<set-?>", "Lcom/amazon/aps/ads/ApsAdView;", "apsAdView", "getApsAdView", "()Lcom/amazon/aps/ads/ApsAdView;", "", "isAdAvailable", "()Z", "addInViewGroup", "", "parent", "Landroid/view/ViewGroup;", "fetchAd", "fetchBannerAd", "extraInfo", "Landroid/os/Bundle;", "width", "", "height", "extraInfoAsString", "fetchInterstitialAd", "fetchRewardedAd", "safeCall", "action", "Lkotlin/Function0;", m5.v, "startOMSDKSession", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ApsAdController {
    private final String HTTPS_WEB_URL;
    private final String TAG;
    private ApsAd apsAd;
    private final ApsAdListener apsAdListener;
    private final ApsAdController$apsAdListenerInternal$1 apsAdListenerInternal;
    private ApsAdView apsAdView;
    private final Context context;
    private boolean isAdAvailable;

    /* JADX INFO: compiled from: ApsAdController.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ApsAdFormat.values().length];
            iArr[ApsAdFormat.LEADERBOARD.ordinal()] = 1;
            iArr[ApsAdFormat.MREC.ordinal()] = 2;
            iArr[ApsAdFormat.BANNER_SMART.ordinal()] = 3;
            iArr[ApsAdFormat.BANNER.ordinal()] = 4;
            iArr[ApsAdFormat.REWARDED_VIDEO.ordinal()] = 5;
            iArr[ApsAdFormat.INTERSTITIAL.ordinal()] = 6;
            iArr[ApsAdFormat.INSTREAM_VIDEO.ordinal()] = 7;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, h.A);
        p0.startActivity(p1);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.amazon.aps.ads.ApsAdController$apsAdListenerInternal$1] */
    public ApsAdController(Context context, ApsAdListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.context = context;
        this.HTTPS_WEB_URL = "https://c.amazon-adsystem.com/";
        this.TAG = Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
        this.apsAdListener = listener;
        ApsAdUtils.checkNullAndLogInvalidArg(context, listener);
        this.apsAdListenerInternal = new ApsAdListener() { // from class: com.amazon.aps.ads.ApsAdController$apsAdListenerInternal$1
            @Override // com.amazon.aps.ads.listeners.ApsAdListener
            public void onAdLoaded(final ApsAd apsAd) {
                ApsAdController apsAdController = this.this$0;
                final ApsAdController apsAdController2 = this.this$0;
                apsAdController.safeCall(new Function0<Unit>() { // from class: com.amazon.aps.ads.ApsAdController$apsAdListenerInternal$1$onAdLoaded$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ApsLog.d(apsAdController2.TAG, "onAdLoaded called");
                        apsAdController2.apsAdListener.onAdLoaded(apsAd);
                    }
                });
            }

            @Override // com.amazon.aps.ads.listeners.ApsAdListener
            public void onAdFailedToLoad(final ApsAd apsAd) {
                ApsAdController apsAdController = this.this$0;
                final ApsAdController apsAdController2 = this.this$0;
                apsAdController.safeCall(new Function0<Unit>() { // from class: com.amazon.aps.ads.ApsAdController$apsAdListenerInternal$1$onAdFailedToLoad$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ApsLog.d(apsAdController2.TAG, "onAdFailedToLoad called");
                        apsAdController2.apsAdListener.onAdFailedToLoad(apsAd);
                    }
                });
            }

            @Override // com.amazon.aps.ads.listeners.ApsAdListener
            public void onAdClicked(final ApsAd apsAd) {
                ApsAdController apsAdController = this.this$0;
                final ApsAdController apsAdController2 = this.this$0;
                apsAdController.safeCall(new Function0<Unit>() { // from class: com.amazon.aps.ads.ApsAdController$apsAdListenerInternal$1$onAdClicked$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ApsLog.d(apsAdController2.TAG, "onAdClicked called");
                        apsAdController2.apsAdListener.onAdClicked(apsAd);
                    }
                });
            }

            @Override // com.amazon.aps.ads.listeners.ApsAdListener
            public void onImpressionFired(final ApsAd apsAd) {
                ApsAdController apsAdController = this.this$0;
                final ApsAdController apsAdController2 = this.this$0;
                apsAdController.safeCall(new Function0<Unit>() { // from class: com.amazon.aps.ads.ApsAdController$apsAdListenerInternal$1$onImpressionFired$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ApsLog.d(apsAdController2.TAG, "onImpressionFired called");
                        apsAdController2.apsAdListener.onImpressionFired(apsAd);
                    }
                });
            }

            @Override // com.amazon.aps.ads.listeners.ApsAdListener
            public void onAdError(final ApsAd apsAd) {
                ApsAdController apsAdController = this.this$0;
                final ApsAdController apsAdController2 = this.this$0;
                apsAdController.safeCall(new Function0<Unit>() { // from class: com.amazon.aps.ads.ApsAdController$apsAdListenerInternal$1$onAdError$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ApsLog.d(apsAdController2.TAG, "onAdError called");
                        apsAdController2.apsAdListener.onAdError(apsAd);
                    }
                });
            }

            @Override // com.amazon.aps.ads.listeners.ApsAdListener
            public void onAdOpen(final ApsAd apsAd) {
                ApsAdController apsAdController = this.this$0;
                final ApsAdController apsAdController2 = this.this$0;
                apsAdController.safeCall(new Function0<Unit>() { // from class: com.amazon.aps.ads.ApsAdController$apsAdListenerInternal$1$onAdOpen$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ApsLog.d(apsAdController2.TAG, "onAdOpen called");
                        apsAdController2.apsAdListener.onAdOpen(apsAd);
                    }
                });
            }

            @Override // com.amazon.aps.ads.listeners.ApsAdListener
            public void onAdClosed(final ApsAd apsAd) {
                ApsAdController apsAdController = this.this$0;
                final ApsAdController apsAdController2 = this.this$0;
                apsAdController.safeCall(new Function0<Unit>() { // from class: com.amazon.aps.ads.ApsAdController$apsAdListenerInternal$1$onAdClosed$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ApsLog.d(apsAdController2.TAG, "onAdClosed called");
                        apsAdController2.apsAdListener.onAdClosed(apsAd);
                    }
                });
            }

            @Override // com.amazon.aps.ads.listeners.ApsAdListener
            public void onVideoCompleted(final ApsAd apsAd) {
                ApsAdController apsAdController = this.this$0;
                final ApsAdController apsAdController2 = this.this$0;
                apsAdController.safeCall(new Function0<Unit>() { // from class: com.amazon.aps.ads.ApsAdController$apsAdListenerInternal$1$onVideoCompleted$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ApsLog.d(apsAdController2.TAG, "onVideoCompleted called");
                        apsAdController2.apsAdListener.onVideoCompleted(apsAd);
                    }
                });
            }
        };
    }

    public final String getHTTPS_WEB_URL() {
        return this.HTTPS_WEB_URL;
    }

    public final ApsAdView getApsAdView() {
        ApsAdView apsAdView = this.apsAdView;
        if (apsAdView != null) {
            return apsAdView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("apsAdView");
        return null;
    }

    /* JADX INFO: renamed from: isAdAvailable, reason: from getter */
    public final boolean getIsAdAvailable() {
        return this.isAdAvailable;
    }

    public final void fetchAd(ApsAd apsAd) {
        Intrinsics.checkNotNullParameter(apsAd, "apsAd");
        ApsAdUtils.checkNullAndLogInvalidArg(apsAd);
        try {
            this.apsAd = apsAd;
            ApsAdFormat apsAdFormat = apsAd.getApsAdFormat();
            switch (apsAdFormat == null ? -1 : WhenMappings.$EnumSwitchMapping$0[apsAdFormat.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    fetchBannerAd(apsAd);
                    break;
                case 5:
                case 6:
                    fetchInterstitialAd(apsAd);
                    break;
                case 7:
                    ApsAdUtils.throwExceptionOrRemoteLog("InStream video adFormat not supported");
                    break;
                default:
                    break;
            }
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "API failure:ApsAdController - fetchAd", e);
        }
    }

    public final void show() {
        try {
            if (getApsAdView().getMraidHandler() == null) {
                APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "There is no controller before showing the interstitial ad");
                return;
            }
            DTBAdMRAIDController mraidHandler = getApsAdView().getMraidHandler();
            if (mraidHandler != null) {
                mraidHandler.startOMSDKSession();
            }
            ApsLog.d(this.TAG, "Starting the Aps interstitial activity");
            ApsInterstitialActivity.INSTANCE.setAdViewRefPassed(new WeakReference<>(getApsAdView()));
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(this.context, new Intent(this.context, (Class<?>) ApsInterstitialActivity.class));
            ApsLog.d(this.TAG, "Sending the ApsAdView in live data");
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "API failure:ApsAdController - show", e);
        }
    }

    private final void startOMSDKSession() {
        try {
            DtbOmSdkSessionManager omSdkManager = getApsAdView().getOmSdkManager();
            if (omSdkManager == null) {
                return;
            }
            if (!getApsAdView().getIsVideo()) {
                omSdkManager.initHtmlDisplayOmAdSession(getApsAdView(), getHTTPS_WEB_URL());
            } else {
                omSdkManager.initJavaScriptOmAdSession(getApsAdView(), getHTTPS_WEB_URL());
            }
            omSdkManager.registerAdView(getApsAdView());
            omSdkManager.startAdSession();
            omSdkManager.displayAdEventLoaded();
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Unable to start OM SDK session for Interstitial ad", e);
        }
    }

    public final void addInViewGroup(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        try {
            ApsAd apsAd = this.apsAd;
            if (apsAd != null) {
                if (apsAd == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("apsAd");
                }
                ApsAd apsAd2 = this.apsAd;
                ApsAd apsAd3 = null;
                if (apsAd2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("apsAd");
                    apsAd2 = null;
                }
                if (apsAd2.getAdView() != null) {
                    ApsAd apsAd4 = this.apsAd;
                    if (apsAd4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("apsAd");
                    } else {
                        apsAd3 = apsAd4;
                    }
                    parent.addView(apsAd3.getAdView());
                }
            }
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "API failure:ApsAdController - addInViewGroup", e);
        }
    }

    private final void fetchInterstitialAd(ApsAd apsAd) {
        this.apsAdView = new ApsAdView(this.context, ApsAdFormat.INTERSTITIAL, this.apsAdListenerInternal);
        getApsAdView().setApsAd(apsAd);
        getApsAdView().fetchAd(apsAd.getBidInfo(), apsAd.getRenderingBundle());
        apsAd.setAdView(getApsAdView());
    }

    private final void fetchBannerAd(ApsAd apsAd) {
        this.apsAdView = new ApsAdView(this.context, ApsAdFormat.BANNER, this.apsAdListenerInternal);
        getApsAdView().fetchAd(apsAd);
    }

    public final void fetchBannerAd(Bundle extraInfo, int width, int height) {
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        this.apsAd = new ApsAd(extraInfo, ApsAdFormatUtils.getAdFormat(AdType.DISPLAY, height, width));
        this.apsAdView = new ApsAdView(this.context, ApsAdFormat.BANNER, this.apsAdListenerInternal);
        ApsAd apsAd = this.apsAd;
        ApsAd apsAd2 = null;
        if (apsAd == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apsAd");
            apsAd = null;
        }
        apsAd.setAdView(getApsAdView());
        ApsAdView apsAdView = getApsAdView();
        ApsAd apsAd3 = this.apsAd;
        if (apsAd3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apsAd");
        } else {
            apsAd2 = apsAd3;
        }
        apsAdView.setApsAd(apsAd2);
        getApsAdView().fetchAd(extraInfo);
    }

    public final void fetchBannerAd(String extraInfoAsString, int width, int height) {
        Intrinsics.checkNotNullParameter(extraInfoAsString, "extraInfoAsString");
        this.apsAd = new ApsAd(extraInfoAsString, ApsAdFormatUtils.getAdFormat(AdType.DISPLAY, height, width));
        this.apsAdView = new ApsAdView(this.context, ApsAdFormat.BANNER, this.apsAdListenerInternal);
        ApsAd apsAd = this.apsAd;
        ApsAd apsAd2 = null;
        if (apsAd == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apsAd");
            apsAd = null;
        }
        apsAd.setAdView(getApsAdView());
        ApsAdView apsAdView = getApsAdView();
        ApsAd apsAd3 = this.apsAd;
        if (apsAd3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apsAd");
        } else {
            apsAd2 = apsAd3;
        }
        apsAdView.setApsAd(apsAd2);
        getApsAdView().fetchAd(extraInfoAsString);
    }

    public final void fetchInterstitialAd(Bundle extraInfo) {
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        this.apsAd = new ApsAd(extraInfo, ApsAdFormatUtils.getAdFormat(AdType.INTERSTITIAL, 9999, 9999));
        this.apsAdView = new ApsAdView(this.context, ApsAdFormat.INTERSTITIAL, this.apsAdListenerInternal);
        ApsAd apsAd = this.apsAd;
        ApsAd apsAd2 = null;
        if (apsAd == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apsAd");
            apsAd = null;
        }
        apsAd.setAdView(getApsAdView());
        ApsAdView apsAdView = getApsAdView();
        ApsAd apsAd3 = this.apsAd;
        if (apsAd3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apsAd");
        } else {
            apsAd2 = apsAd3;
        }
        apsAdView.setApsAd(apsAd2);
        getApsAdView().fetchAd(extraInfo);
    }

    public final void fetchInterstitialAd(String extraInfoAsString) {
        Intrinsics.checkNotNullParameter(extraInfoAsString, "extraInfoAsString");
        this.apsAd = new ApsAd(extraInfoAsString, ApsAdFormatUtils.getAdFormat(AdType.INTERSTITIAL, 9999, 9999));
        this.apsAdView = new ApsAdView(this.context, ApsAdFormat.INTERSTITIAL, this.apsAdListenerInternal);
        ApsAd apsAd = this.apsAd;
        ApsAd apsAd2 = null;
        if (apsAd == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apsAd");
            apsAd = null;
        }
        apsAd.setAdView(getApsAdView());
        ApsAdView apsAdView = getApsAdView();
        ApsAd apsAd3 = this.apsAd;
        if (apsAd3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apsAd");
        } else {
            apsAd2 = apsAd3;
        }
        apsAdView.setApsAd(apsAd2);
        getApsAdView().fetchAd(extraInfoAsString);
    }

    public final void fetchRewardedAd(String extraInfoAsString) {
        Intrinsics.checkNotNullParameter(extraInfoAsString, "extraInfoAsString");
        this.apsAd = new ApsAd(extraInfoAsString, ApsAdFormatUtils.getAdFormat(AdType.VIDEO, 9999, 9999));
        this.apsAdView = new ApsAdView(this.context, ApsAdFormat.REWARDED_VIDEO, this.apsAdListenerInternal);
        ApsAd apsAd = this.apsAd;
        ApsAd apsAd2 = null;
        if (apsAd == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apsAd");
            apsAd = null;
        }
        apsAd.setAdView(getApsAdView());
        ApsAdView apsAdView = getApsAdView();
        ApsAd apsAd3 = this.apsAd;
        if (apsAd3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apsAd");
        } else {
            apsAd2 = apsAd3;
        }
        apsAdView.setApsAd(apsAd2);
        getApsAdView().fetchAd(extraInfoAsString);
    }

    public final void safeCall(Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        try {
            action.invoke();
        } catch (AbstractMethodError unused) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "AbstractMethodError listener method not implemented:ApsAdController - safeCall");
        } catch (Exception e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Unexpected exception:ApsAdController - safeCall", e);
        }
    }
}
