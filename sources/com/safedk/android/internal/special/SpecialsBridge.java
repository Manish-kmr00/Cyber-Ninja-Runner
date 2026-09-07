package com.safedk.android.internal.special;

import android.view.Surface;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.fyber.inneractive.sdk.external.ImpressionData;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener;
import com.fyber.inneractive.sdk.external.OnGlobalImpressionDataListener;
import com.inmobi.ads.AdMetaInfo;
import com.inmobi.ads.InMobiInterstitial;
import com.inmobi.ads.InMobiNative;
import com.inmobi.ads.listeners.InterstitialAdEventListener;
import com.json.b9;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.video.module.MBridgeContainerView;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.b;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.analytics.brandsafety.creatives.discoveries.k;
import com.safedk.android.analytics.brandsafety.l;
import com.safedk.android.analytics.events.BrandSafetyEvent;
import com.safedk.android.analytics.events.RedirectEvent;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import com.safedk.android.utils.n;

/* JADX INFO: loaded from: classes11.dex */
public class SpecialsBridge {
    /* JADX WARN: Multi-variable type inference failed */
    public static void appLovinAdViewRenderAd(AppLovinAdView targetInstance, AppLovinAd appLovinAd) {
        Logger.d("SafeDK-Special|SafeDK: Special-Specials> Lcom/safedk/android/internal/special/SpecialsBridge;->appLovinAdViewRenderAd(Lcom/applovin/adview/AppLovinAdView;Lcom/applovin/sdk/AppLovinAd;)V");
        if (SafeDK.ae()) {
            Logger.d("SafeDK-Special", "appLovinAdViewRenderAd started, ad: " + appLovinAd);
            try {
                if (AppLovinAdSize.INTERSTITIAL.equals(appLovinAd.getSize())) {
                    String clCode = ((AppLovinAdBase) appLovinAd).getClCode();
                    BrandSafetyEvent.AdFormatType adFormatType = BrandSafetyEvent.AdFormatType.INTER;
                    Logger.d("SafeDK-Special", "appLovinAdViewRenderAd clcode:" + clCode + " ad: " + appLovinAd + " formatType: " + adFormatType);
                    CreativeInfoManager.a(h.f8160a, "clcode=" + clCode + b9.i.c, adFormatType, targetInstance);
                }
            } catch (Throwable th) {
                Logger.d("SafeDK-Special", "appLovinAdViewRenderAd failed");
            }
        }
        targetInstance.renderAd(appLovinAd);
    }

    public static void maxAdViewDestroy(MaxAdView targetInstance) {
        Logger.d("SafeDK-Special|SafeDK: Special-Specials> Lcom/safedk/android/internal/special/SpecialsBridge;->maxAdViewDestroy(Lcom/applovin/mediation/ads/MaxAdView;)V");
        if (SafeDK.ae()) {
            try {
                Logger.d("SafeDK-Special", "maxAdViewDestroy started , isOnUiThread = " + n.c());
                CreativeInfoManager.a(targetInstance);
            } catch (Throwable th) {
                Logger.d("SafeDK-Special", "maxAdViewDestroy failed");
            }
        }
        targetInstance.destroy();
    }

    public static void maxNativeAdListenerOnNativeAdLoaded(MaxNativeAdListener targetInstance, MaxNativeAdView nativeAdView, MaxAd ad) {
        Logger.d("SafeDK-Special|SafeDK: Special-Specials> Lcom/safedk/android/internal/special/SpecialsBridge;->maxNativeAdListenerOnNativeAdLoaded(Lcom/applovin/mediation/nativeAds/MaxNativeAdListener;Lcom/applovin/mediation/nativeAds/MaxNativeAdView;Lcom/applovin/mediation/MaxAd;)V");
        targetInstance.onNativeAdLoaded(nativeAdView, ad);
        if (SafeDK.ae()) {
            try {
                Logger.d("SafeDK-Special", "maxNativeAdListenerOnNativeAdLoaded Impl started, nativeAdView: " + nativeAdView + ", ad: " + ad + ", isOnUiThread = " + n.c());
                CreativeInfoManager.onMaxNativeAdLoaded(nativeAdView, ad);
            } catch (Throwable th) {
                Logger.d("SafeDK-Special", "maxNativeAdListenerOnNativeAdLoaded failed", th);
            }
        }
    }

    public static void appLovinAdViewEventListenerAdOpenedFullscreen(AppLovinAdViewEventListener targetInstance, AppLovinAd ad, AppLovinAdView adView) {
        Logger.d("SafeDK-Special|SafeDK: Special-Specials> Lcom/safedk/android/internal/special/SpecialsBridge;->appLovinAdViewEventListenerAdOpenedFullscreen(Lcom/applovin/adview/AppLovinAdViewEventListener;Lcom/applovin/sdk/AppLovinAd;Lcom/applovin/adview/AppLovinAdView;)V");
        if (SafeDK.ae()) {
            try {
                Logger.d("SafeDK-Special", "appLovinAdViewEventListenerAdOpenedFullscreen started, ad: " + ad + ", adView: " + adView + ", isOnUiThread = " + n.c());
                BrandSafetyUtils.a(h.f8160a, (String) null, (String) null, RedirectEvent.i);
            } catch (Throwable th) {
                Logger.d("SafeDK-Special", "appLovinAdViewEventListenerAdOpenedFullscreen failed", th);
            }
        }
        targetInstance.adOpenedFullscreen(ad, adView);
    }

    public static void appLovinMaxAdViewAdListenerOnAdExpanded(MaxAdViewAdListener targetInstance, MaxAd ad) {
        Logger.d("SafeDK-Special|SafeDK: Special-Specials> Lcom/safedk/android/internal/special/SpecialsBridge;->appLovinMaxAdViewAdListenerOnAdExpanded(Lcom/applovin/mediation/MaxAdViewAdListener;Lcom/applovin/mediation/MaxAd;)V");
        if (SafeDK.ae()) {
            try {
                Logger.d("SafeDK-Special", "appLovinMaxAdViewAdListenerOnAdExpanded started, ad: " + ad + ", isOnUiThread = " + n.c());
                BrandSafetyUtils.f();
            } catch (Throwable th) {
                Logger.d("SafeDK-Special", "appLovinMaxAdViewAdListenerOnAdExpanded failed", th);
            }
        }
        targetInstance.onAdExpanded(ad);
    }

    public static void MBridgeVideoView_videoOperate(MBridgeVideoView targetHandler, int var) {
        Logger.d("SafeDK-Special|SafeDK: Special-Specials> Lcom/safedk/android/internal/special/SpecialsBridge;->MBridgeVideoView_videoOperate(Lcom/mbridge/msdk/video/module/MBridgeVideoView;I)V");
        if (SafeDK.ae()) {
            try {
                Logger.d("SafeDK-Special", "MBridgeVideoView_videoOperate " + targetHandler + ", var = " + var + ", isOnUiThread = " + n.c());
                String strA = BrandSafetyUtils.a(targetHandler);
                if (var == 1) {
                    CampaignEx campaign = targetHandler.getCampaign();
                    Logger.d("SafeDK-Special", "MBridgeVideoView_videoOperate " + targetHandler + ", request id " + campaign.getImpressionURL());
                    CreativeInfoManager.a(h.o, k.B(campaign.getImpressionURL()), BrandSafetyEvent.AdFormatType.INTER, targetHandler);
                } else if (var == 3) {
                    CreativeInfoManager.a(h.o, strA, true, "video-view");
                }
            } catch (Throwable th) {
                Logger.d("SafeDK-Special", "MBridgeVideoView_videoOperate error " + th.getMessage());
            }
        }
        targetHandler.videoOperate(var);
    }

    public static void MintegralContainerView_showPlayableView(MBridgeContainerView targetHandler) {
        Logger.d("SafeDK-Special|SafeDK: Special-Specials> Lcom/safedk/android/internal/special/SpecialsBridge;->MintegralContainerView_showPlayableView(Lcom/mbridge/msdk/video/module/MBridgeContainerView;)V");
        targetHandler.showPlayableView();
        if (SafeDK.ae()) {
            try {
                CampaignEx campaign = targetHandler.getCampaign();
                Logger.d("SafeDK-Special", "MBridgeContainerView_showPlayableView " + targetHandler + ", request id " + campaign.getImpressionURL());
                CreativeInfoManager.a(h.o, k.B(campaign.getImpressionURL()), BrandSafetyEvent.AdFormatType.INTER, targetHandler);
            } catch (Throwable th) {
                Logger.d("SafeDK-Special", "MBridgeContainerView_showPlayableView error " + th.getMessage());
            }
        }
    }

    public static void MBridgeVideoView_showAlertView(MBridgeVideoView targetHandler) {
        Logger.d("SafeDK-Special|SafeDK: Special-Specials> Lcom/safedk/android/internal/special/SpecialsBridge;->MBridgeVideoView_showAlertView(Lcom/mbridge/msdk/video/module/MBridgeVideoView;)V");
        if (SafeDK.ae()) {
            try {
                String strA = BrandSafetyUtils.a(targetHandler);
                Logger.d("SafeDK-Special", "_AD_CAPTURE_ MBridgeVideoView_showAlertView " + targetHandler + ", address=" + strA + ", isOnUiThread=" + n.c());
                b.a(strA, l.q, new l.a[0]);
                CreativeInfoManager.b(h.o, strA);
            } catch (Throwable th) {
                Logger.d("SafeDK-Special", "MBridgeVideoView_showAlertView error " + th.getMessage());
            }
        }
        targetHandler.showAlertView();
    }

    public static void fyberOnImpression(OnGlobalImpressionDataListener targetInstance, String spotId, String creativeId, ImpressionData impressionData) {
        Logger.d("SafeDK-Special|SafeDK: Special-Specials> Lcom/safedk/android/internal/special/SpecialsBridge;->fyberOnImpression(Lcom/fyber/inneractive/sdk/external/OnGlobalImpressionDataListener;Ljava/lang/String;Ljava/lang/String;Lcom/fyber/inneractive/sdk/external/ImpressionData;)V");
        if (SafeDK.ae()) {
            try {
                Logger.d("SafeDK-Special", "fyberOnImpression started, spotId=" + spotId + ", creativeId=" + creativeId + ", impressionData = " + impressionData.toString() + ", isOnUiThread=" + n.c());
                CreativeInfoManager.b(h.p, impressionData, (Object) null);
            } catch (Throwable th) {
                Logger.d("SafeDK-Special", "Error in fyberOnImpression", th);
            }
        }
        targetInstance.onImpression(spotId, creativeId, impressionData);
    }

    public static void fyberOnAdExpanded(InneractiveAdViewEventsListener targetInstance, InneractiveAdSpot adSpot) {
        Logger.d("SafeDK-Special|SafeDK: Special-Specials> Lcom/safedk/android/internal/special/SpecialsBridge;->fyberOnAdExpanded(Lcom/fyber/inneractive/sdk/external/InneractiveAdViewEventsListener;Lcom/fyber/inneractive/sdk/external/InneractiveAdSpot;)V");
        if (SafeDK.ae()) {
            try {
                Logger.d("SafeDK-Special", "fyberOnAdExpanded started, isOnUiThread = " + n.c());
                BrandSafetyUtils.a(h.p, (String) null, (String) null, RedirectEvent.i);
            } catch (Throwable th) {
                Logger.d("SafeDK-Special", "Error in fyberOnAdExpanded", th);
            }
        }
        targetInstance.onAdExpanded(adSpot);
    }

    public static void inmobiOnInterstitialAdDisplayed(InterstitialAdEventListener targetInstance, InMobiInterstitial inMobiInterstitial, AdMetaInfo adMetaInfo) {
        Logger.d("SafeDK-Special|SafeDK: Special-Specials> Lcom/safedk/android/internal/special/SpecialsBridge;->inmobiOnInterstitialAdDisplayed(Lcom/inmobi/ads/listeners/InterstitialAdEventListener;Lcom/inmobi/ads/InMobiInterstitial;Lcom/inmobi/ads/AdMetaInfo;)V");
        if (SafeDK.ae()) {
            try {
                Logger.d("SafeDK-Special", "inmobiOnInterstitialAdDisplayed triggered , isOnUiThread = " + n.c());
                CreativeInfoManager.b(h.i, adMetaInfo.getCreativeID(), (Object) null);
            } catch (Throwable th) {
                Logger.e("SafeDK-Special", "Exception in inmobiOnInterstitialAdDisplayed", th);
            }
        }
        targetInstance.onAdDisplayed(inMobiInterstitial, adMetaInfo);
    }

    public static void surfaceRelease(Surface targetInstance) {
        Logger.d("SafeDK-Special|SafeDK: Special-Specials> Lcom/safedk/android/internal/special/SpecialsBridge;->surfaceRelease(Landroid/view/Surface;)V");
        Logger.d("SafeDK-Special", "surfaceRelease triggered, targetInstance = " + targetInstance + ", type = " + targetInstance.getClass().getName() + ", isOnUiThread = " + n.c());
        if (SafeDK.ae()) {
            CreativeInfoManager.onVideoCompleted("com.five_corp.ad", "surface");
        }
        targetInstance.release();
    }

    public static void nativeAdEventListenerOnAdClicked(InMobiNative targetInstance) {
        Logger.d("SafeDK-Special|SafeDK: Special-Specials> Lcom/safedk/android/internal/special/SpecialsBridge;->nativeAdEventListenerOnAdClicked(Lcom/inmobi/ads/InMobiNative;)V");
        if (SafeDK.ae()) {
            Logger.d("SafeDK-Special", "nativeAdEventListenerOnAdClicked triggered, targetInstance = " + targetInstance + ", type = " + targetInstance.getClass().getName() + ", getAdCtaText = " + targetInstance.getAdCtaText() + ", getAdDescription = " + targetInstance.getAdDescription() + ", getAdIconUrl = " + targetInstance.getAdIconUrl() + ", getAdTitle = " + targetInstance.getAdTitle() + ", getAdLandingPageUrl = " + targetInstance.getAdLandingPageUrl() + ", isOnUiThread = " + n.c());
            DetectTouchUtils.b(null, h.i);
        }
        targetInstance.reportAdClickAndOpenLandingPage();
    }
}
