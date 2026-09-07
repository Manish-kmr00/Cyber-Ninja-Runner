package com.pubmatic.sdk.openwrap.core;

import android.content.Context;
import android.view.View;
import com.pubmatic.sdk.common.POBAdSize;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.common.POBInstanceProvider;
import com.pubmatic.sdk.common.base.POBAdDescriptor;
import com.pubmatic.sdk.common.ui.POBBannerRendering;
import com.pubmatic.sdk.common.utility.POBUtils;
import com.pubmatic.sdk.common.viewability.POBHTMLMeasurementProvider;
import com.pubmatic.sdk.common.viewability.POBVideoMeasurementProvider;
import com.pubmatic.sdk.openwrap.core.banner.POBBannerRenderer;
import com.pubmatic.sdk.openwrap.core.interstitial.POBInterstitialRenderer;
import com.pubmatic.sdk.video.POBVastPlayerConfig;
import com.pubmatic.sdk.video.player.POBVastPlayer;
import com.pubmatic.sdk.video.renderer.POBVideoRenderer;
import com.pubmatic.sdk.video.renderer.POBVideoRendering;
import com.pubmatic.sdk.webrendering.mraid.POBMraidRenderer;
import com.pubmatic.sdk.webrendering.ui.POBViewabilityTracker;
import com.safedk.android.analytics.brandsafety.l;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class POBRenderer {

    class a implements POBBannerRenderer.RendererBuilder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f7731a;
        final /* synthetic */ int b;

        a(Context context, int i) {
            this.f7731a = context;
            this.b = i;
        }

        @Override // com.pubmatic.sdk.openwrap.core.banner.POBBannerRenderer.RendererBuilder
        public POBBannerRendering build(POBAdDescriptor pOBAdDescriptor, int i) {
            if (pOBAdDescriptor.isVideo()) {
                return POBRenderer.videoRenderer(this.f7731a, pOBAdDescriptor, POBCommonConstants.BANNER_PLACEMENT_TYPE, this.b, false);
            }
            return POBRenderer.b(this.f7731a, POBCommonConstants.BANNER_PLACEMENT_TYPE, Math.max(pOBAdDescriptor.getRefreshInterval(), 15), i);
        }
    }

    class b implements POBInterstitialRenderer.RendererBuilder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f7732a;
        final /* synthetic */ POBBid b;

        b(Context context, POBBid pOBBid) {
            this.f7732a = context;
            this.b = pOBBid;
        }

        @Override // com.pubmatic.sdk.openwrap.core.interstitial.POBInterstitialRenderer.RendererBuilder
        public POBBannerRendering build(POBAdDescriptor pOBAdDescriptor, int i) {
            return pOBAdDescriptor.isVideo() ? POBRenderer.videoRenderer(this.f7732a, pOBAdDescriptor, "interstitial", this.b.getRemainingExpirationTime(), false) : POBRenderer.b(this.f7732a, "interstitial", 15, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static POBBannerRendering b(Context context, String str, int i, int i2) {
        POBMraidRenderer pOBMraidRendererCreateInstance = POBMraidRenderer.createInstance(context.getApplicationContext(), str, i2);
        if (pOBMraidRendererCreateInstance != null) {
            pOBMraidRendererCreateInstance.setTrackerHandler(POBInstanceProvider.getTrackerHandler(POBInstanceProvider.getNetworkHandler(context)));
            pOBMraidRendererCreateInstance.setRenderingTimeout(i);
            pOBMraidRendererCreateInstance.setBaseURL(a());
            POBHTMLMeasurementProvider pOBHTMLMeasurementProvider = (POBHTMLMeasurementProvider) POBInstanceProvider.getSdkConfig().getMeasurementProvider(POBCommonConstants.HTML_MEASUREMENT_PROVIDER_CLASS);
            if (pOBHTMLMeasurementProvider != null) {
                pOBMraidRendererCreateInstance.setHTMLMeasurementListener(pOBHTMLMeasurementProvider);
            }
        }
        return pOBMraidRendererCreateInstance;
    }

    public static POBBannerRendering getBannerRenderer(Context context, int i) {
        return new POBBannerRenderer(new a(context, i));
    }

    public static POBInterstitialRenderer getInterstitialRenderer(Context context, POBBid pOBBid) {
        POBInterstitialRenderer pOBInterstitialRenderer = new POBInterstitialRenderer(context.getApplicationContext(), new b(context, pOBBid));
        if (!pOBBid.isVideo()) {
            pOBInterstitialRenderer.setTrackerHandler(POBInstanceProvider.getTrackerHandler(POBInstanceProvider.getNetworkHandler(context)));
        }
        return pOBInterstitialRenderer;
    }

    public static POBVideoRendering videoRenderer(Context context, POBAdDescriptor pOBAdDescriptor, String str, int i, boolean z) {
        POBViewabilityTracker pOBViewabilityTracker;
        POBAdSize pOBAdSize;
        boolean zEquals = "interstitial".equals(str);
        POBVastPlayer pOBVastPlayerCreateInstance = POBVastPlayer.createInstance(context, POBVastPlayerConfig.ConfigBuilder.createVastConfig(pOBAdDescriptor.getRawBid(), zEquals, z, !z, str));
        pOBVastPlayerCreateInstance.enableDsaInfoIcon(pOBAdDescriptor.enableDsaInfoIcon());
        pOBVastPlayerCreateInstance.setPlacementType(str);
        pOBVastPlayerCreateInstance.setDeviceInfo(POBInstanceProvider.getDeviceInfo(context.getApplicationContext()));
        pOBVastPlayerCreateInstance.setMaxWrapperThreshold(3);
        pOBVastPlayerCreateInstance.setLinearity(POBVastPlayer.Linearity.LINEAR);
        pOBVastPlayerCreateInstance.setSkipabilityEnabled(zEquals);
        pOBVastPlayerCreateInstance.setShowEndCardOnSkip(!z && zEquals);
        boolean zA = a(pOBAdDescriptor.getRawBid());
        pOBVastPlayerCreateInstance.setFSCEnabled(!zEquals || zA);
        pOBVastPlayerCreateInstance.setEnableLearnMoreButton((zEquals && zA) ? false : true);
        pOBVastPlayerCreateInstance.setBidBundleId(pOBAdDescriptor.getBundle());
        if (zEquals) {
            pOBViewabilityTracker = new POBViewabilityTracker(pOBVastPlayerCreateInstance);
        } else {
            pOBViewabilityTracker = new POBViewabilityTracker((View) pOBVastPlayerCreateInstance, 50.0f);
            pOBViewabilityTracker.setAllowViewTreeObserverRegistration(true);
        }
        POBVideoRenderer pOBVideoRenderer = new POBVideoRenderer(pOBVastPlayerCreateInstance, pOBViewabilityTracker, str);
        pOBVideoRenderer.setMeasurementProvider((POBVideoMeasurementProvider) POBInstanceProvider.getSdkConfig().getMeasurementProvider(POBCommonConstants.VIDEO_MEASUREMENT_PROVIDER_CLASS));
        if (zEquals) {
            pOBAdSize = POBUtils.getInterstitialAdSize(context);
            pOBVideoRenderer.setExpirationTimeout(i);
        } else {
            pOBAdSize = new POBAdSize(pOBAdDescriptor.getContentWidth(), pOBAdDescriptor.getContentHeight());
        }
        pOBVastPlayerCreateInstance.setEndCardSize(pOBAdSize);
        return pOBVideoRenderer;
    }

    private static String a() {
        return POBInstanceProvider.getSdkConfig().isRequestSecureCreative() ? "https://ow.pubmatic.com/openrtb/2.5" : "http://ow.pubmatic.com/openrtb/2.5";
    }

    private static boolean a(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        return (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("ext")) == null || jSONObjectOptJSONObject.optInt(l.D) != 1) ? false : true;
    }
}
