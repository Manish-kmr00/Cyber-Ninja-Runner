package com.pubmatic.sdk.openwrap.core.interstitial;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.common.POBDataType;
import com.pubmatic.sdk.common.POBError;
import com.pubmatic.sdk.common.POBInstanceProvider;
import com.pubmatic.sdk.common.base.POBAdDescriptor;
import com.pubmatic.sdk.common.base.POBAdRendererListener;
import com.pubmatic.sdk.common.cache.POBAdViewCacheService;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.log.POBLogConstants;
import com.pubmatic.sdk.common.network.POBTrackerHandler;
import com.pubmatic.sdk.common.ui.POBBannerRendering;
import com.pubmatic.sdk.common.ui.POBFullScreenActivityListener;
import com.pubmatic.sdk.common.ui.POBInterstitialRendererListener;
import com.pubmatic.sdk.common.ui.POBInterstitialRendering;
import com.pubmatic.sdk.common.ui.POBVideoAdEventListener;
import com.pubmatic.sdk.common.utility.POBDeepLinkUtil;
import com.pubmatic.sdk.common.utility.POBTimeoutHandler;
import com.pubmatic.sdk.common.utility.POBUtils;
import com.pubmatic.sdk.common.viewability.POBObstructionUpdateListener;
import com.pubmatic.sdk.video.player.POBVastPlayer;
import com.pubmatic.sdk.video.renderer.POBVideoRenderingListener;
import com.pubmatic.sdk.webrendering.dsa.POBDsaHtmlContent;
import com.pubmatic.sdk.webrendering.dsa.POBDsaInfoPresenterHelper;
import com.pubmatic.sdk.webrendering.mraid.POBMraidRenderer;
import com.pubmatic.sdk.webrendering.mraid.POBUseCustomCloseListener;
import com.pubmatic.sdk.webrendering.ui.POBAdViewContainer;
import com.pubmatic.sdk.webrendering.ui.POBBannerConfig;
import com.pubmatic.sdk.webrendering.ui.POBCustomProductPageView;
import com.pubmatic.sdk.webrendering.ui.POBFullScreenActivity;
import com.pubmatic.sdk.webrendering.ui.POBMraidViewContainer;
import com.pubmatic.sdk.webrendering.ui.POBMraidViewContainerListener;
import com.pubmatic.sdk.webrendering.ui.POBOnSkipOptionUpdateListener;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes7.dex */
public class POBInterstitialRenderer implements POBInterstitialRendering, POBVideoRenderingListener, POBAdRendererListener, POBUseCustomCloseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private POBBannerRendering f7745a;
    private POBInterstitialRendererListener b;
    private POBVideoAdEventListener c;
    private int d;
    private POBAdDescriptor e;
    private final Context f;
    private View g;
    private final RendererBuilder h;
    private POBFullScreenActivityListener i;
    private POBBannerConfig j;
    private POBMraidViewContainer k;
    private POBTimeoutHandler l;
    private long m = 0;
    private POBTrackerHandler n;
    private POBMraidRenderer o;
    private Boolean p;
    private boolean q;

    public interface RendererBuilder {
        POBBannerRendering build(POBAdDescriptor pOBAdDescriptor, int i);
    }

    class a implements POBOnSkipOptionUpdateListener {
        a() {
        }

        @Override // com.pubmatic.sdk.webrendering.ui.POBOnSkipOptionUpdateListener
        public void onSkipOptionUpdate(boolean z) {
            if (POBInterstitialRenderer.this.j == null || !POBInterstitialRenderer.this.j.isBackButtonEnabled()) {
                return;
            }
            POBInterstitialRenderer.this.a(z);
        }
    }

    class b implements POBFullScreenActivityListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f7747a;

        b(View view) {
            this.f7747a = view;
        }

        @Override // com.pubmatic.sdk.common.ui.POBFullScreenActivityListener
        public void onCreate(Activity activity) {
            View view = this.f7747a;
            if (!(view instanceof POBAdViewContainer)) {
                if (view instanceof POBVastPlayer) {
                    ((POBVastPlayer) view).setBaseContext(activity);
                    return;
                }
                return;
            }
            ((POBAdViewContainer) view).getAdView().setBaseContext(activity);
            if (POBInterstitialRenderer.this.k != null) {
                POBInterstitialRenderer.this.m = System.currentTimeMillis();
                POBInterstitialRenderer pOBInterstitialRenderer = POBInterstitialRenderer.this;
                pOBInterstitialRenderer.a(pOBInterstitialRenderer.k);
            }
        }

        @Override // com.pubmatic.sdk.common.ui.POBFullScreenActivityListener
        public void onDestroy() {
            View view = this.f7747a;
            if (view instanceof POBAdViewContainer) {
                ((POBAdViewContainer) view).getAdView().setBaseContext(POBInterstitialRenderer.this.f.getApplicationContext());
            } else if (view instanceof POBVastPlayer) {
                ((POBVastPlayer) view).setBaseContext(POBInterstitialRenderer.this.f.getApplicationContext());
            }
            POBInterstitialRenderer.this.f();
            POBInterstitialRenderer.this.onAdInteractionStopped();
        }
    }

    class c implements POBMraidViewContainerListener {
        c() {
        }

        @Override // com.pubmatic.sdk.webrendering.ui.POBMraidViewContainerListener
        public void onClose() {
            POBInterstitialRenderer.this.b();
        }

        @Override // com.pubmatic.sdk.webrendering.ui.POBMraidViewContainerListener
        public void onForward() {
            POBInterstitialRenderer.this.h();
        }
    }

    class d implements POBTimeoutHandler.POBTimeoutHandlerListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ POBMraidViewContainer f7749a;

        d(POBMraidViewContainer pOBMraidViewContainer) {
            this.f7749a = pOBMraidViewContainer;
        }

        @Override // com.pubmatic.sdk.common.utility.POBTimeoutHandler.POBTimeoutHandlerListener
        public void onTimeout() {
            POBLog.debug("POBInterstitialRenderer", "Custom close delay timer exhausted", new Object[0]);
            POBInterstitialRenderer.this.b(this.f7749a, 2000L);
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (POBInterstitialRenderer.this.e != null) {
                POBDeepLinkUtil.triggerDeepLink(POBInterstitialRenderer.this.f, String.format(POBCommonConstants.PLAY_STORE_URL, POBInterstitialRenderer.this.e.getBundle()), true);
                POBInterstitialRenderer.this.c();
                POBInterstitialRenderer.this.onRenderAdClick();
            }
        }
    }

    class f implements View.OnClickListener {

        class a implements POBDsaHtmlContent.OnContentListener {
            a() {
            }

            @Override // com.pubmatic.sdk.webrendering.dsa.POBDsaHtmlContent.OnContentListener
            public void onPageContentReceived(String str) throws UnsupportedEncodingException {
                POBDsaInfoPresenterHelper.show(POBInterstitialRenderer.this.f, POBInterstitialRenderer.this.e, str);
            }
        }

        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            POBDsaHtmlContent.getHtmlContent(POBInterstitialRenderer.this.f, new a());
        }
    }

    public POBInterstitialRenderer(Context context, RendererBuilder rendererBuilder) {
        this.f = context;
        this.h = rendererBuilder;
    }

    @Override // com.pubmatic.sdk.common.ui.POBInterstitialRendering
    public void destroy() {
        f();
        d();
    }

    @Override // com.pubmatic.sdk.video.renderer.POBVideoRenderingListener
    public void notifyAdEvent(POBDataType.POBVideoAdEventType pOBVideoAdEventType) {
        POBVideoAdEventListener pOBVideoAdEventListener = this.c;
        if (pOBVideoAdEventListener != null) {
            pOBVideoAdEventListener.onVideoAdEvent(pOBVideoAdEventType);
        }
    }

    @Override // com.pubmatic.sdk.common.base.POBAdRendererListener
    public void onAdExpired() {
        POBInterstitialRendererListener pOBInterstitialRendererListener = this.b;
        if (pOBInterstitialRendererListener != null) {
            pOBInterstitialRendererListener.onAdExpired();
        }
    }

    @Override // com.pubmatic.sdk.common.base.POBAdRendererListener
    public void onAdImpression() {
        POBInterstitialRendererListener pOBInterstitialRendererListener = this.b;
        if (pOBInterstitialRendererListener != null) {
            pOBInterstitialRendererListener.onAdImpression();
        }
    }

    @Override // com.pubmatic.sdk.common.base.POBAdRendererListener
    public void onAdInteractionStarted() {
        if (this.b != null && this.d == 0) {
            e();
            this.b.onAdInteractionStarted();
        }
        this.d++;
    }

    @Override // com.pubmatic.sdk.common.base.POBAdRendererListener
    public void onAdInteractionStopped() {
        int i = this.d - 1;
        this.d = i;
        if (i == 0) {
            if ((this.f7745a instanceof POBMraidRenderer) && a() && this.k != null) {
                h();
                this.k.updateSkipButtonToCloseButton();
                this.d++;
            } else if (this.b != null) {
                destroy();
                this.b.onAdInteractionStopped();
            }
        }
    }

    @Override // com.pubmatic.sdk.common.base.POBAdRendererListener
    public void onAdReadyToRefresh(int i) {
    }

    @Override // com.pubmatic.sdk.common.base.POBAdRendererListener
    public void onAdRender(View view, POBAdDescriptor pOBAdDescriptor) {
        this.g = view;
        POBInterstitialRendererListener pOBInterstitialRendererListener = this.b;
        if (pOBInterstitialRendererListener != null) {
            pOBInterstitialRendererListener.onAdRender(pOBAdDescriptor);
        }
    }

    @Override // com.pubmatic.sdk.common.base.POBAdRendererListener
    public void onAdRenderingFailed(POBError pOBError) {
        POBInterstitialRendererListener pOBInterstitialRendererListener = this.b;
        if (pOBInterstitialRendererListener != null) {
            pOBInterstitialRendererListener.onAdRenderingFailed(pOBError);
        }
    }

    @Override // com.pubmatic.sdk.common.base.POBAdRendererListener
    public void onAdUnload() {
        POBInterstitialRendererListener pOBInterstitialRendererListener = this.b;
        if (pOBInterstitialRendererListener != null) {
            pOBInterstitialRendererListener.onAdUnload();
        }
    }

    @Override // com.pubmatic.sdk.common.base.POBAdRendererListener
    public void onLeavingApplication() {
        POBInterstitialRendererListener pOBInterstitialRendererListener = this.b;
        if (pOBInterstitialRendererListener != null) {
            pOBInterstitialRendererListener.onLeavingApplication();
        }
    }

    @Override // com.pubmatic.sdk.common.base.POBAdRendererListener
    public void onRenderAdClick() {
        Boolean bool;
        POBInterstitialRendererListener pOBInterstitialRendererListener = this.b;
        if (pOBInterstitialRendererListener != null) {
            pOBInterstitialRendererListener.onAdClicked();
        }
        if (this.k == null || (bool = this.p) == null || bool.booleanValue()) {
            return;
        }
        this.k.onAdViewClicked();
    }

    @Override // com.pubmatic.sdk.common.base.POBAdRendererListener
    public void onRenderProcessGone() {
        POBInterstitialRendererListener pOBInterstitialRendererListener = this.b;
        if (pOBInterstitialRendererListener != null) {
            pOBInterstitialRendererListener.onRenderProcessGone();
        }
        d();
    }

    @Override // com.pubmatic.sdk.video.renderer.POBVideoRenderingListener
    public void onSkipOptionUpdate(boolean z) {
        a(z);
    }

    @Override // com.pubmatic.sdk.common.ui.POBInterstitialRendering
    public void renderAd(POBAdDescriptor pOBAdDescriptor) {
        this.e = pOBAdDescriptor;
        POBLog.debug("POBInterstitialRenderer", POBLogConstants.MSG_RENDERING_ON_START, new Object[0]);
        if (pOBAdDescriptor.getRenderableContent() != null) {
            POBBannerRendering pOBBannerRenderingBuild = this.h.build(pOBAdDescriptor, hashCode());
            this.f7745a = pOBBannerRenderingBuild;
            if (pOBBannerRenderingBuild != null) {
                pOBBannerRenderingBuild.setAdRendererListener(this);
                this.f7745a.renderAd(pOBAdDescriptor);
                POBBannerRendering pOBBannerRendering = this.f7745a;
                if (pOBBannerRendering instanceof POBMraidRenderer) {
                    ((POBMraidRenderer) pOBBannerRendering).setCustomCloseListener(this);
                    return;
                }
                return;
            }
        }
        POBInterstitialRendererListener pOBInterstitialRendererListener = this.b;
        if (pOBInterstitialRendererListener != null) {
            pOBInterstitialRendererListener.onAdRenderingFailed(new POBError(1009, POBLogConstants.MSG_RENDERING_FAILED_ERROR + pOBAdDescriptor));
        }
    }

    @Override // com.pubmatic.sdk.common.ui.POBInterstitialRendering
    public void setAdRendererListener(POBInterstitialRendererListener pOBInterstitialRendererListener) {
        this.b = pOBInterstitialRendererListener;
    }

    public void setTrackerHandler(POBTrackerHandler pOBTrackerHandler) {
        this.n = pOBTrackerHandler;
    }

    @Override // com.pubmatic.sdk.common.ui.POBInterstitialRendering
    public void setVideoAdEventListener(POBVideoAdEventListener pOBVideoAdEventListener) {
        this.c = pOBVideoAdEventListener;
    }

    @Override // com.pubmatic.sdk.common.ui.POBInterstitialRendering
    public void show(int i) {
        a(i);
    }

    @Override // com.pubmatic.sdk.webrendering.mraid.POBUseCustomCloseListener
    public void useCustomClose(boolean z) {
        g();
        this.p = Boolean.valueOf(z);
        long jCurrentTimeMillis = System.currentTimeMillis() - this.m;
        this.m = jCurrentTimeMillis;
        POBMraidViewContainer pOBMraidViewContainer = this.k;
        if (pOBMraidViewContainer != null) {
            b(pOBMraidViewContainer, Math.max(0L, jCurrentTimeMillis));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(POBMraidViewContainer pOBMraidViewContainer, long j) {
        if (this.q) {
            return;
        }
        this.q = true;
        Boolean bool = this.p;
        Boolean boolValueOf = Boolean.valueOf(bool != null && bool.booleanValue());
        this.p = boolValueOf;
        pOBMraidViewContainer.setCustomCloseEnabled(boolValueOf.booleanValue());
        if (this.p.booleanValue()) {
            a(pOBMraidViewContainer, j);
        } else {
            pOBMraidViewContainer.handleSkipTimer(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        POBTrackerHandler pOBTrackerHandler;
        POBAdDescriptor pOBAdDescriptor = this.e;
        if (pOBAdDescriptor == null || (pOBTrackerHandler = this.n) == null) {
            return;
        }
        pOBTrackerHandler.sendTrackers(pOBAdDescriptor.getClickTrackers());
    }

    private void d() {
        POBInstanceProvider.getAdViewCacheService().popStoredAdView(Integer.valueOf(hashCode()));
        this.i = null;
        this.q = false;
        this.p = Boolean.FALSE;
        g();
        b();
    }

    private void e() {
        POBBannerRendering pOBBannerRendering = this.f7745a;
        if (pOBBannerRendering != null) {
            pOBBannerRendering.invalidateExpiration();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        POBBannerRendering pOBBannerRendering = this.f7745a;
        if (pOBBannerRendering != null) {
            pOBBannerRendering.destroy();
            this.f7745a = null;
        }
    }

    private void g() {
        POBTimeoutHandler pOBTimeoutHandler = this.l;
        if (pOBTimeoutHandler != null) {
            pOBTimeoutHandler.cancel();
            this.l = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        POBCustomProductPageView pOBCustomProductPageView = new POBCustomProductPageView(this.f);
        pOBCustomProductPageView.setInstallButtonClickListener(new e());
        POBAdDescriptor pOBAdDescriptor = this.e;
        if (pOBAdDescriptor != null && pOBAdDescriptor.enableDsaInfoIcon()) {
            pOBCustomProductPageView.enableDsaInfoBtn(new f());
        }
        POBMraidViewContainer pOBMraidViewContainer = this.k;
        if (pOBMraidViewContainer != null) {
            pOBMraidViewContainer.addView(pOBCustomProductPageView);
            POBMraidRenderer pOBMraidRenderer = this.o;
            if (pOBMraidRenderer != null) {
                pOBMraidRenderer.addFriendlyObstructions(pOBCustomProductPageView, POBObstructionUpdateListener.POBFriendlyObstructionPurpose.OTHER);
            }
        }
    }

    private void a(int i) {
        View view;
        POBLog.info("POBInterstitialRenderer", "showInterstitialAd", new Object[0]);
        POBAdDescriptor pOBAdDescriptor = this.e;
        if (pOBAdDescriptor != null && (view = this.g) != null) {
            a(pOBAdDescriptor, view);
            POBAdViewCacheService.AdViewConfig storedAdView = POBInstanceProvider.getAdViewCacheService().getStoredAdView(Integer.valueOf(hashCode()));
            if (storedAdView != null) {
                POBBannerRendering pOBBannerRendering = this.f7745a;
                if (pOBBannerRendering instanceof POBMraidRenderer) {
                    this.o = (POBMraidRenderer) pOBBannerRendering;
                    POBMraidViewContainer pOBMraidViewContainer = (POBMraidViewContainer) storedAdView.getAdView();
                    this.k = pOBMraidViewContainer;
                    pOBMraidViewContainer.setEnableSkipTimer(true);
                    this.k.setObstructionUpdateListener(this.o);
                    POBBannerConfig pOBBannerConfigCreateBannerConfig = POBBannerConfig.ConfigBuilder.createBannerConfig(this.e.getRawBid(), "interstitial");
                    this.j = pOBBannerConfigCreateBannerConfig;
                    int skipAfter = pOBBannerConfigCreateBannerConfig.getSkipAfter();
                    if (skipAfter > 0) {
                        this.k.configureSkippability(skipAfter);
                    }
                    this.k.setSkipOptionUpdateListener(new a());
                    this.o.signalImpressionEvent();
                }
                try {
                    POBFullScreenActivity.startFullScreenActivity(this.f, i, this.e, hashCode());
                    onAdInteractionStarted();
                    return;
                } catch (Exception e2) {
                    POBLog.error("POBInterstitialRenderer", "Unable to start full screen activity. Error: %s", e2.getMessage());
                    POBInterstitialRendererListener pOBInterstitialRendererListener = this.b;
                    if (pOBInterstitialRendererListener != null) {
                        pOBInterstitialRendererListener.onAdRenderingFailed(new POBError(1009, "Failed to show interstitial ad with error: " + e2.getMessage()));
                        return;
                    }
                    return;
                }
            }
            return;
        }
        String str = "Can not show interstitial for descriptor: " + this.e;
        POBLog.error("POBInterstitialRenderer", str, new Object[0]);
        POBInterstitialRendererListener pOBInterstitialRendererListener2 = this.b;
        if (pOBInterstitialRendererListener2 != null) {
            pOBInterstitialRendererListener2.onAdRenderingFailed(new POBError(1009, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        POBFullScreenActivity.closeActivity(this.f, hashCode());
    }

    private void a(POBAdDescriptor pOBAdDescriptor, View view) {
        ViewGroup viewGroup;
        this.i = new b(view);
        if (pOBAdDescriptor.isVideo()) {
            viewGroup = (ViewGroup) view;
        } else {
            POBMraidViewContainer pOBMraidViewContainer = new POBMraidViewContainer(this.f.getApplicationContext(), (ViewGroup) view, !POBUtils.isNullOrEmpty(pOBAdDescriptor.getBundle()));
            pOBMraidViewContainer.setMraidViewContainerListener(new c());
            viewGroup = pOBMraidViewContainer;
        }
        POBInstanceProvider.getAdViewCacheService().storeAdView(Integer.valueOf(hashCode()), new POBAdViewCacheService.AdViewConfig(viewGroup, this.i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(POBMraidViewContainer pOBMraidViewContainer) {
        if (this.q) {
            return;
        }
        Boolean bool = this.p;
        if (bool != null && bool.booleanValue()) {
            this.q = true;
            pOBMraidViewContainer.setCustomCloseEnabled(true);
            a(pOBMraidViewContainer, 0L);
        } else {
            g();
            POBTimeoutHandler pOBTimeoutHandler = new POBTimeoutHandler(new d(pOBMraidViewContainer));
            this.l = pOBTimeoutHandler;
            pOBTimeoutHandler.start(2000L);
            POBLog.debug("POBInterstitialRenderer", "Custom close delay timer started with 2 sec delay", new Object[0]);
        }
    }

    private void a(POBMraidViewContainer pOBMraidViewContainer, long j) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        POBBannerConfig pOBBannerConfig = this.j;
        pOBMraidViewContainer.handleSkipTimer(Math.max(timeUnit.toMillis(pOBBannerConfig != null ? pOBBannerConfig.getSkipAfter() : 0L), 20000L) - j);
    }

    private boolean a() {
        POBAdDescriptor pOBAdDescriptor = this.e;
        return (pOBAdDescriptor == null || POBUtils.isNullOrEmpty(pOBAdDescriptor.getBundle())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        POBFullScreenActivity.updateBackButtonState(this.f, hashCode(), z);
    }
}
