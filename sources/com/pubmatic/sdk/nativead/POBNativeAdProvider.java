package com.pubmatic.sdk.nativead;

import android.content.Context;
import android.view.View;
import com.pubmatic.sdk.common.POBAdFormat;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.common.POBDataType;
import com.pubmatic.sdk.common.POBError;
import com.pubmatic.sdk.common.POBInstanceProvider;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.log.POBLogConstants;
import com.pubmatic.sdk.common.viewability.POBNativeMeasurementProvider;
import com.pubmatic.sdk.nativead.datatype.POBNativeTemplateType;
import com.pubmatic.sdk.nativead.renderer.POBNativeAdRenderer;
import com.pubmatic.sdk.nativead.renderer.POBNativeAdRendering;
import com.pubmatic.sdk.nativead.renderer.POBNativeRendererListener;
import com.pubmatic.sdk.nativead.response.POBNativeAdDataResponseAsset;
import com.pubmatic.sdk.nativead.response.POBNativeAdImageResponseAsset;
import com.pubmatic.sdk.nativead.response.POBNativeAdResponse;
import com.pubmatic.sdk.nativead.response.POBNativeAdResponseAsset;
import com.pubmatic.sdk.nativead.response.POBNativeAdTitleResponseAsset;
import com.pubmatic.sdk.nativead.views.POBNativeAdMediumTemplateView;
import com.pubmatic.sdk.nativead.views.POBNativeAdSmallTemplateView;
import com.pubmatic.sdk.nativead.views.POBNativeTemplateView;
import com.pubmatic.sdk.openwrap.core.POBAdsHelper;
import com.pubmatic.sdk.openwrap.core.POBBid;
import com.pubmatic.sdk.webrendering.dsa.POBDsaHtmlContent;
import com.pubmatic.sdk.webrendering.dsa.POBDsaInfoPresenterHelper;
import java.io.UnsupportedEncodingException;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class POBNativeAdProvider implements POBNativeAd, POBNativeRendererListener, POBNativeAdEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f7687a;
    private final POBNativeTemplateType b;
    private final POBNativeAdRendering c;
    private final POBNativeAdEventBridge d;
    private POBNativeAdResponse e;
    private POBNativeAdListener f;
    private POBBid g;
    private POBNativeAdView h;
    private POBDataType.POBAdState i;
    private boolean j;

    class a implements POBDsaHtmlContent.OnContentListener {
        a() {
        }

        @Override // com.pubmatic.sdk.webrendering.dsa.POBDsaHtmlContent.OnContentListener
        public void onPageContentReceived(String str) throws UnsupportedEncodingException {
            POBDsaInfoPresenterHelper.show(POBNativeAdProvider.this.f7687a, POBNativeAdProvider.this.g, str);
        }
    }

    class b extends POBNativeAdRenderer {
        b(Context context) {
            super(context);
        }

        @Override // com.pubmatic.sdk.nativead.renderer.POBNativeAdRenderer, com.pubmatic.sdk.nativead.POBNativeAdViewListener
        public void onRecordImpression(View view) {
            POBNativeAdProvider.this.d.trackImpression();
        }
    }

    static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7689a;

        static {
            int[] iArr = new int[POBDataType.POBAdState.values().length];
            f7689a = iArr;
            try {
                iArr[POBDataType.POBAdState.DESTROYED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7689a[POBDataType.POBAdState.SHOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public POBNativeAdProvider(Context context, POBNativeTemplateType pOBNativeTemplateType, POBNativeAdEventBridge pOBNativeAdEventBridge) {
        this.f7687a = context;
        this.b = pOBNativeTemplateType;
        this.d = pOBNativeAdEventBridge;
        pOBNativeAdEventBridge.setNativeAdEventListener(this);
        this.i = POBDataType.POBAdState.DEFAULT;
        this.c = a();
    }

    @Override // com.pubmatic.sdk.nativead.POBNativeAd
    public void destroy() {
        this.i = POBDataType.POBAdState.DESTROYED;
        this.h = null;
        this.c.destroy();
        this.f = null;
        this.d.destroy();
    }

    @Override // com.pubmatic.sdk.nativead.POBNativeAd
    public POBNativeAdView getAdView() {
        return this.h;
    }

    @Override // com.pubmatic.sdk.nativead.POBNativeAd
    public POBNativeAdDataResponseAsset getDataAssetForId(int i) {
        POBNativeAdResponse pOBNativeAdResponse = this.e;
        if (pOBNativeAdResponse == null) {
            POBLog.debug("POBNativeAdProvider", "NativeAdResponse is null.", new Object[0]);
            return null;
        }
        POBNativeAdResponseAsset asset = pOBNativeAdResponse.getAsset(i);
        if (asset instanceof POBNativeAdDataResponseAsset) {
            return (POBNativeAdDataResponseAsset) asset;
        }
        POBLog.warn("POBNativeAdProvider", POBNativeLogConstants.NATIVE_INVALID_ASSET_ID, Integer.valueOf(i), POBNativeAdDataResponseAsset.class.getName());
        return null;
    }

    @Override // com.pubmatic.sdk.nativead.POBNativeAd
    public POBNativeAdImageResponseAsset getImageAssetForId(int i) {
        POBNativeAdResponse pOBNativeAdResponse = this.e;
        if (pOBNativeAdResponse == null) {
            POBLog.debug("POBNativeAdProvider", "NativeAdResponse is null.", new Object[0]);
            return null;
        }
        POBNativeAdResponseAsset asset = pOBNativeAdResponse.getAsset(i);
        if (asset instanceof POBNativeAdImageResponseAsset) {
            return (POBNativeAdImageResponseAsset) asset;
        }
        POBLog.warn("POBNativeAdProvider", POBNativeLogConstants.NATIVE_INVALID_ASSET_ID, Integer.valueOf(i), POBNativeAdImageResponseAsset.class.getName());
        return null;
    }

    @Override // com.pubmatic.sdk.nativead.POBNativeAd
    public POBNativeAdTitleResponseAsset getTitleAssetForId(int i) {
        POBNativeAdResponse pOBNativeAdResponse = this.e;
        if (pOBNativeAdResponse == null) {
            POBLog.debug("POBNativeAdProvider", "NativeAdResponse is null.", new Object[0]);
            return null;
        }
        POBNativeAdResponseAsset asset = pOBNativeAdResponse.getAsset(i);
        if (asset instanceof POBNativeAdTitleResponseAsset) {
            return (POBNativeAdTitleResponseAsset) asset;
        }
        POBLog.warn("POBNativeAdProvider", POBNativeLogConstants.NATIVE_INVALID_ASSET_ID, Integer.valueOf(i), POBNativeAdTitleResponseAsset.class.getName());
        return null;
    }

    @Override // com.pubmatic.sdk.nativead.renderer.POBNativeRendererListener
    public void onAdClicked() {
        this.d.trackClick();
        POBNativeAdListener pOBNativeAdListener = this.f;
        if (pOBNativeAdListener != null) {
            pOBNativeAdListener.onNativeAdClicked(this);
        }
    }

    @Override // com.pubmatic.sdk.nativead.renderer.POBNativeRendererListener
    public void onAdClosed() {
        POBNativeAdListener pOBNativeAdListener = this.f;
        if (pOBNativeAdListener != null) {
            pOBNativeAdListener.onNativeAdClosed(this);
        }
    }

    @Override // com.pubmatic.sdk.nativead.renderer.POBNativeRendererListener
    public void onAdImpression() {
        this.i = POBDataType.POBAdState.SHOWN;
        this.d.trackImpression();
        POBAdsHelper.recordImpressionDepth(this.f7687a, POBAdFormat.NATIVE);
        POBNativeAdListener pOBNativeAdListener = this.f;
        if (pOBNativeAdListener != null) {
            pOBNativeAdListener.onNativeAdImpression(this);
        }
    }

    @Override // com.pubmatic.sdk.nativead.renderer.POBNativeRendererListener
    public void onAdLeavingApplication() {
        POBNativeAdListener pOBNativeAdListener = this.f;
        if (pOBNativeAdListener != null) {
            pOBNativeAdListener.onNativeAdLeavingApplication(this);
        }
    }

    @Override // com.pubmatic.sdk.nativead.renderer.POBNativeRendererListener
    public void onAdOpened() {
        POBNativeAdListener pOBNativeAdListener = this.f;
        if (pOBNativeAdListener != null) {
            pOBNativeAdListener.onNativeAdOpened(this);
        }
    }

    @Override // com.pubmatic.sdk.nativead.renderer.POBNativeRendererListener
    public void onAdRendered(View view) {
        this.i = POBDataType.POBAdState.READY;
        if (this.b != POBNativeTemplateType.CUSTOM) {
            this.h = (POBNativeAdView) view;
            POBNativeAdListener pOBNativeAdListener = this.f;
            if (pOBNativeAdListener != null) {
                pOBNativeAdListener.onNativeAdRendered(this);
            }
        }
    }

    @Override // com.pubmatic.sdk.nativead.renderer.POBNativeRendererListener
    public void onAdRenderingFailed(POBError pOBError) {
        POBNativeAdListener pOBNativeAdListener = this.f;
        if (pOBNativeAdListener == null || this.b == POBNativeTemplateType.CUSTOM) {
            return;
        }
        pOBNativeAdListener.onNativeAdRenderingFailed(this, pOBError);
    }

    @Override // com.pubmatic.sdk.nativead.renderer.POBNativeRendererListener
    public void onDsaInfoIconClicked() {
        POBDsaHtmlContent.getHtmlContent(this.f7687a, new a());
    }

    @Override // com.pubmatic.sdk.nativead.POBNativeAdEventListener
    public void onNativeAdClicked() {
        POBNativeAdListener pOBNativeAdListener = this.f;
        if (pOBNativeAdListener == null || this.j) {
            return;
        }
        pOBNativeAdListener.onNativeAdClicked(this);
    }

    @Override // com.pubmatic.sdk.nativead.POBNativeAdEventListener
    public void onNativeAdClosed() {
        POBNativeAdListener pOBNativeAdListener = this.f;
        if (pOBNativeAdListener != null) {
            pOBNativeAdListener.onNativeAdClosed(this);
        }
    }

    @Override // com.pubmatic.sdk.nativead.POBNativeAdEventListener
    public void onNativeAdImpression() {
        POBNativeAdListener pOBNativeAdListener = this.f;
        if (pOBNativeAdListener == null || this.j) {
            return;
        }
        this.i = POBDataType.POBAdState.SHOWN;
        pOBNativeAdListener.onNativeAdImpression(this);
    }

    @Override // com.pubmatic.sdk.nativead.POBNativeAdEventListener
    public void onNativeAdOpened() {
        POBNativeAdListener pOBNativeAdListener = this.f;
        if (pOBNativeAdListener != null) {
            pOBNativeAdListener.onNativeAdOpened(this);
        }
    }

    @Override // com.pubmatic.sdk.nativead.POBNativeAd
    public void registerViewForInteraction(View view, List<View> list, POBNativeAdListener pOBNativeAdListener) {
        this.f = pOBNativeAdListener;
        POBNativeAdResponse pOBNativeAdResponse = this.e;
        if (pOBNativeAdResponse != null) {
            this.c.registerView(pOBNativeAdResponse, view, list);
        } else {
            POBLog.debug("POBNativeAdProvider", "NativeAdResponse is null.", new Object[0]);
        }
    }

    @Override // com.pubmatic.sdk.nativead.POBNativeAd
    public void renderAd(POBNativeAdListener pOBNativeAdListener) {
        renderAd(b(), pOBNativeAdListener);
    }

    public void setBid(POBBid pOBBid) {
        this.g = pOBBid;
    }

    public void setNativeAdResponse(POBNativeAdResponse pOBNativeAdResponse) {
        this.e = pOBNativeAdResponse;
    }

    private void a(POBNativeTemplateView pOBNativeTemplateView) {
        POBBid pOBBid = this.g;
        if (pOBBid != null && pOBBid.getRawBid() != null) {
            POBInstanceProvider.getCacheManager(this.f7687a).saveRenderedBid(this.g.getRawBid());
        }
        POBNativeAdResponse pOBNativeAdResponse = this.e;
        if (pOBNativeAdResponse != null) {
            this.c.renderAd(pOBNativeAdResponse, pOBNativeTemplateView);
            return;
        }
        POBLog.debug("POBNativeAdProvider", "NativeAdResponse is null.", new Object[0]);
        POBNativeAdListener pOBNativeAdListener = this.f;
        if (pOBNativeAdListener != null) {
            pOBNativeAdListener.onNativeAdRenderingFailed(this, new POBError(1009, POBNativeLogConstants.MSG_INTERNAL_NATIVE_RENDER_ERROR));
        }
    }

    private POBNativeTemplateView b() {
        return this.b.equals(POBNativeTemplateType.SMALL) ? new POBNativeAdSmallTemplateView(this.f7687a) : new POBNativeAdMediumTemplateView(this.f7687a);
    }

    private void c() {
        View adServerView = this.d.getAdServerView();
        if (adServerView == null) {
            onAdRenderingFailed(new POBError(1009, POBNativeLogConstants.AD_SERVER_VIEW_MISSING_ERROR));
            return;
        }
        POBNativeAdView pOBNativeAdView = new POBNativeAdView(this.f7687a);
        pOBNativeAdView.setListener(new b(this.f7687a));
        pOBNativeAdView.addView(adServerView);
        onAdRendered(pOBNativeAdView);
    }

    @Override // com.pubmatic.sdk.nativead.POBNativeAd
    public void renderAd(POBNativeTemplateView pOBNativeTemplateView, POBNativeAdListener pOBNativeAdListener) {
        this.f = pOBNativeAdListener;
        POBBid pOBBid = this.g;
        if (pOBBid != null) {
            this.j = pOBBid.hasWon();
            this.c.enableDsaIcon(this.g.enableDsaInfoIcon());
        }
        int i = c.f7689a[this.i.ordinal()];
        if (i == 1) {
            POBLog.error("POBNativeAdProvider", POBNativeLogConstants.NATIVE_AD_DESTROYED_ERROR, new Object[0]);
            return;
        }
        if (i != 2) {
            POBBid pOBBid2 = this.g;
            if (pOBBid2 != null && pOBBid2.hasWon()) {
                if (!this.g.isExpired()) {
                    if (POBDataType.POBAdState.READY.equals(this.i)) {
                        this.f.onNativeAdRendered(this);
                        return;
                    }
                    if ((POBNativeTemplateType.SMALL.equals(this.b) && (pOBNativeTemplateView instanceof POBNativeAdSmallTemplateView)) || (POBNativeTemplateType.MEDIUM.equals(this.b) && (pOBNativeTemplateView instanceof POBNativeAdMediumTemplateView))) {
                        a(pOBNativeTemplateView);
                        return;
                    } else {
                        this.f.onNativeAdRenderingFailed(this, new POBError(1009, POBNativeLogConstants.NATIVE_TEMPLATE_MISMATCHING));
                        return;
                    }
                }
                this.f.onNativeAdRenderingFailed(this, new POBError(1011, POBLogConstants.MSG_AD_EXPIRED_ERROR));
                return;
            }
            if (POBDataType.POBAdState.READY.equals(this.i)) {
                this.f.onNativeAdRendered(this);
                return;
            } else {
                c();
                return;
            }
        }
        onAdRenderingFailed(new POBError(2001, POBLogConstants.MSG_AD_ALREADY_SHOWN_ERROR));
    }

    @Override // com.pubmatic.sdk.nativead.renderer.POBNativeRendererListener
    public void onAdClicked(int i) {
        this.d.trackClick();
        POBNativeAdListener pOBNativeAdListener = this.f;
        if (pOBNativeAdListener != null) {
            pOBNativeAdListener.onNativeAdClicked(this, String.valueOf(i));
        }
    }

    private POBNativeAdRenderer a() {
        POBNativeAdRenderer pOBNativeAdRenderer = new POBNativeAdRenderer(this.f7687a);
        pOBNativeAdRenderer.setNativeMeasurementProvider((POBNativeMeasurementProvider) POBInstanceProvider.getSdkConfig().getMeasurementProvider(POBCommonConstants.NATIVE_MEASUREMENT_PROVIDER_CLASS));
        pOBNativeAdRenderer.setAdRendererListener(this);
        return pOBNativeAdRenderer;
    }
}
