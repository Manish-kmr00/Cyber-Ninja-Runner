package com.pubmatic.sdk.video.renderer;

import android.content.Context;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.common.POBDataType;
import com.pubmatic.sdk.common.POBError;
import com.pubmatic.sdk.common.base.POBAdDescriptor;
import com.pubmatic.sdk.common.base.POBAdRendererListener;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.log.POBLogConstants;
import com.pubmatic.sdk.common.utility.POBTimeoutHandler;
import com.pubmatic.sdk.common.utility.POBUrlHandler;
import com.pubmatic.sdk.common.utility.POBUtils;
import com.pubmatic.sdk.common.viewability.POBVideoMeasurementProvider;
import com.pubmatic.sdk.video.POBVideoLogConstants;
import com.pubmatic.sdk.video.player.POBVastPlayer;
import com.pubmatic.sdk.video.player.POBVastPlayerListener;
import com.pubmatic.sdk.video.vastmodels.POBVastAd;
import com.pubmatic.sdk.video.vastmodels.POBVastCreative;
import com.pubmatic.sdk.webrendering.dsa.POBDsaHtmlContent;
import com.pubmatic.sdk.webrendering.dsa.POBDsaInfoPresenterHelper;
import com.pubmatic.sdk.webrendering.ui.POBOnSkipOptionUpdateListener;
import com.pubmatic.sdk.webrendering.ui.POBViewabilityTracker;
import java.io.UnsupportedEncodingException;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class POBVideoRenderer implements POBVideoRendering, POBVastPlayerListener, POBViewabilityTracker.OnViewabilityChangedListener, POBOnSkipOptionUpdateListener {
    public static final float VIEWABILITY_THRESHOLD_PERCENT_FOR_BANNER = 50.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7846a;
    private POBAdRendererListener b;
    private POBVideoRenderingListener c;
    private POBVideoSkipEventListener d;
    private long e;
    private POBTimeoutHandler f;
    private final POBVastPlayer g;
    private POBVideoMeasurementProvider h;
    private final POBViewabilityTracker i;
    private POBAdDescriptor j;
    private POBUrlHandler k;
    private POBUrlHandler l;

    class a implements POBTimeoutHandler.POBTimeoutHandlerListener {
        a() {
        }

        @Override // com.pubmatic.sdk.common.utility.POBTimeoutHandler.POBTimeoutHandlerListener
        public void onTimeout() {
            POBVideoRenderer.this.a();
        }
    }

    class b implements POBUrlHandler.UrlHandlerListener {
        b() {
        }

        @Override // com.pubmatic.sdk.common.utility.POBUrlHandler.UrlHandlerListener
        public void onErrorOpenUrl(String str) {
            POBLog.warn("POBVideoRenderer", "Unable to open icon click url :" + str, new Object[0]);
        }

        @Override // com.pubmatic.sdk.common.utility.POBUrlHandler.UrlHandlerListener
        public void onInternalBrowserClose(String str) {
            POBVideoRenderer.this.c();
        }

        @Override // com.pubmatic.sdk.common.utility.POBUrlHandler.UrlHandlerListener
        public void onInternalBrowserOpen(String str) {
            POBVideoRenderer.this.b();
        }

        @Override // com.pubmatic.sdk.common.utility.POBUrlHandler.UrlHandlerListener
        public void onLeaveApp(String str) {
            POBVideoRenderer.this.d();
        }
    }

    class c implements POBDsaHtmlContent.OnContentListener {
        c() {
        }

        @Override // com.pubmatic.sdk.webrendering.dsa.POBDsaHtmlContent.OnContentListener
        public void onPageContentReceived(String str) throws UnsupportedEncodingException {
            POBDsaInfoPresenterHelper.show(POBVideoRenderer.this.g.getContext(), POBVideoRenderer.this.j, str);
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f7850a;
        final /* synthetic */ float b;

        d(float f, float f2) {
            this.f7850a = f;
            this.b = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (POBVideoRenderer.this.h != null) {
                POBVideoRenderer.this.h.setTrackView(POBVideoRenderer.this.g);
                POBVideoRenderer.this.h.impressionOccurred();
                POBVideoRenderer.this.h.start(this.f7850a, this.b);
                POBVideoRenderer.this.h.signalPlayerStateChange(POBCommonConstants.BANNER_PLACEMENT_TYPE.equals(POBVideoRenderer.this.f7846a) ? POBVideoMeasurementProvider.POBVideoPlayerState.NORMAL : POBVideoMeasurementProvider.POBVideoPlayerState.FULLSCREEN);
            }
        }
    }

    class e implements POBUrlHandler.UrlHandlerListener {
        e() {
        }

        @Override // com.pubmatic.sdk.common.utility.POBUrlHandler.UrlHandlerListener
        public void onErrorOpenUrl(String str) {
            POBLog.warn("POBVideoRenderer", "Unable to open " + str, new Object[0]);
        }

        @Override // com.pubmatic.sdk.common.utility.POBUrlHandler.UrlHandlerListener
        public void onInternalBrowserClose(String str) {
            POBVideoRenderer.this.c();
        }

        @Override // com.pubmatic.sdk.common.utility.POBUrlHandler.UrlHandlerListener
        public void onInternalBrowserOpen(String str) {
            POBVideoRenderer.this.b();
        }

        @Override // com.pubmatic.sdk.common.utility.POBUrlHandler.UrlHandlerListener
        public void onLeaveApp(String str) {
            POBVideoRenderer.this.d();
        }
    }

    class f implements POBVideoMeasurementProvider.POBOmidSessionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f7852a;

        f(float f) {
            this.f7852a = f;
        }

        @Override // com.pubmatic.sdk.common.viewability.POBVideoMeasurementProvider.POBOmidSessionListener
        public void onOmidSessionInitialized() {
            if (POBVideoRenderer.this.h != null) {
                POBVideoRenderer.this.h.loaded(POBVideoRenderer.this.g.getVastPlayerConfig().getSkip() == 1 && POBVideoRenderer.this.g.getSkipabilityEnabled(), this.f7852a);
            }
        }
    }

    static /* synthetic */ class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7853a;

        static {
            int[] iArr = new int[POBVastCreative.POBEventTypes.values().length];
            f7853a = iArr;
            try {
                iArr[POBVastCreative.POBEventTypes.FIRST_QUARTILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7853a[POBVastCreative.POBEventTypes.MID_POINT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7853a[POBVastCreative.POBEventTypes.THIRD_QUARTILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7853a[POBVastCreative.POBEventTypes.COMPLETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7853a[POBVastCreative.POBEventTypes.UNMUTE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7853a[POBVastCreative.POBEventTypes.MUTE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7853a[POBVastCreative.POBEventTypes.SKIP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f7853a[POBVastCreative.POBEventTypes.RESUME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f7853a[POBVastCreative.POBEventTypes.PAUSE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public POBVideoRenderer(POBVastPlayer pOBVastPlayer, POBViewabilityTracker pOBViewabilityTracker, String str) {
        this.g = pOBVastPlayer;
        this.f7846a = str;
        pOBVastPlayer.setVastPlayerListener(this);
        pOBVastPlayer.setOnSkipOptionUpdateListener(this);
        this.i = pOBViewabilityTracker;
        pOBViewabilityTracker.setOnExposureChangeWithThresholdListener(this);
    }

    private int a(int i, int i2) {
        int i3 = i2 - i;
        if (i3 <= 0) {
            return 0;
        }
        return i3;
    }

    private void i() {
        if (this.e > 0) {
            POBTimeoutHandler pOBTimeoutHandler = new POBTimeoutHandler(new a());
            this.f = pOBTimeoutHandler;
            pOBTimeoutHandler.start(this.e);
        }
    }

    private void j() {
        POBTimeoutHandler pOBTimeoutHandler = this.f;
        if (pOBTimeoutHandler != null) {
            pOBTimeoutHandler.cancel();
            this.f = null;
        }
    }

    @Override // com.pubmatic.sdk.video.renderer.POBVideoRendering, com.pubmatic.sdk.common.ui.POBBannerRendering
    public void destroy() {
        j();
        this.g.destroy();
        this.i.setOnExposureChangeWithThresholdListener(null);
        this.i.destroy();
        POBVideoMeasurementProvider pOBVideoMeasurementProvider = this.h;
        if (pOBVideoMeasurementProvider != null) {
            pOBVideoMeasurementProvider.finishAdSession();
            this.h = null;
        }
        this.l = null;
    }

    @Override // com.pubmatic.sdk.common.ui.POBBannerRendering
    public void invalidateExpiration() {
        j();
    }

    @Override // com.pubmatic.sdk.video.player.POBVastPlayerListener
    public void onClose() {
        POBAdRendererListener pOBAdRendererListener;
        if (this.c == null || (pOBAdRendererListener = this.b) == null) {
            return;
        }
        pOBAdRendererListener.onAdInteractionStopped();
    }

    @Override // com.pubmatic.sdk.video.player.POBVastPlayerListener
    public void onDsaInfoIconClick() {
        POBDsaHtmlContent.getHtmlContent(this.g.getContext(), new c());
    }

    @Override // com.pubmatic.sdk.video.player.POBVastPlayerListener
    public void onEndCardWillLeaveApp() {
        d();
    }

    @Override // com.pubmatic.sdk.video.player.POBVastPlayerListener
    public void onFailedToPlay(POBError pOBError) {
        j();
        POBAdRendererListener pOBAdRendererListener = this.b;
        if (pOBAdRendererListener != null) {
            pOBAdRendererListener.onAdRenderingFailed(pOBError);
        }
        if (this.h == null || pOBError.getErrorMessage() == null) {
            return;
        }
        this.h.signalError(POBVideoMeasurementProvider.POBVideoAdErrorType.VIDEO, pOBError.getErrorMessage());
    }

    @Override // com.pubmatic.sdk.video.player.POBVastPlayerListener
    public void onIndustryIconClick(String str) {
        if (POBUtils.isNullOrEmpty(str)) {
            POBLog.warn("POBVideoRenderer", POBVideoLogConstants.MSG_VAST_ICON_MISSING_CLICKTHROUGH, new Object[0]);
        } else {
            if (this.l == null) {
                this.l = new POBUrlHandler(this.g.getContext().getApplicationContext(), new b());
            }
            this.l.open(str);
        }
        POBVideoMeasurementProvider pOBVideoMeasurementProvider = this.h;
        if (pOBVideoMeasurementProvider != null) {
            pOBVideoMeasurementProvider.signalAdEvent(POBDataType.POBVideoAdEventType.ICON_CLICKED);
        }
    }

    @Override // com.pubmatic.sdk.video.player.POBVastPlayerListener
    public void onOpenLandingPage(String str) {
        a(str);
        h();
    }

    @Override // com.pubmatic.sdk.video.player.POBVastPlayerListener
    public void onPlaybackCompleted(float f2) {
        POBAdDescriptor pOBAdDescriptor;
        if (this.b != null && (pOBAdDescriptor = this.j) != null) {
            this.b.onAdReadyToRefresh(a((int) f2, pOBAdDescriptor.getRefreshInterval()));
        }
        POBVideoRenderingListener pOBVideoRenderingListener = this.c;
        if (pOBVideoRenderingListener != null) {
            pOBVideoRenderingListener.notifyAdEvent(POBDataType.POBVideoAdEventType.COMPLETE);
        }
    }

    @Override // com.pubmatic.sdk.video.player.POBVastPlayerListener
    public void onReadyToPlay(POBVastAd pOBVastAd, float f2) {
        Context context = this.g.getContext();
        if (context != null) {
            a(context);
        }
        a(pOBVastAd, f2);
        POBAdRendererListener pOBAdRendererListener = this.b;
        if (pOBAdRendererListener != null) {
            pOBAdRendererListener.onAdRender(this.g, null);
        }
    }

    @Override // com.pubmatic.sdk.video.player.POBVastPlayerListener
    public void onSkip() {
        POBVideoSkipEventListener pOBVideoSkipEventListener;
        if (this.c == null || (pOBVideoSkipEventListener = this.d) == null) {
            return;
        }
        pOBVideoSkipEventListener.onAdAboutToSkip();
    }

    @Override // com.pubmatic.sdk.webrendering.ui.POBOnSkipOptionUpdateListener
    public void onSkipOptionUpdate(boolean z) {
        if (this.c == null || !this.g.getVastPlayerConfig().isBackButtonEnabled()) {
            return;
        }
        this.c.onSkipOptionUpdate(z);
    }

    @Override // com.pubmatic.sdk.video.player.POBVastPlayerListener
    public void onVideoEventOccurred(POBVastCreative.POBEventTypes pOBEventTypes) {
        if (this.h != null) {
            switch (g.f7853a[pOBEventTypes.ordinal()]) {
                case 1:
                    this.h.signalAdEvent(POBDataType.POBVideoAdEventType.FIRST_QUARTILE);
                    break;
                case 2:
                    this.h.signalAdEvent(POBDataType.POBVideoAdEventType.MID_POINT);
                    break;
                case 3:
                    this.h.signalAdEvent(POBDataType.POBVideoAdEventType.THIRD_QUARTILE);
                    break;
                case 4:
                    this.h.signalAdEvent(POBDataType.POBVideoAdEventType.COMPLETE);
                    break;
                case 5:
                    this.h.signalAdEvent(POBDataType.POBVideoAdEventType.UNMUTE);
                    break;
                case 6:
                    this.h.signalAdEvent(POBDataType.POBVideoAdEventType.MUTE);
                    break;
                case 7:
                    this.h.signalAdEvent(POBDataType.POBVideoAdEventType.SKIPPED);
                    break;
                case 8:
                    this.h.signalAdEvent(POBDataType.POBVideoAdEventType.RESUME);
                    break;
                case 9:
                    this.h.signalAdEvent(POBDataType.POBVideoAdEventType.PAUSE);
                    break;
            }
        }
    }

    @Override // com.pubmatic.sdk.video.player.POBVastPlayerListener
    public void onVideoStarted(float f2, float f3) {
        if (this.h != null) {
            this.g.postDelayed(new d(f2, f3), 1000L);
        }
        POBAdRendererListener pOBAdRendererListener = this.b;
        if (pOBAdRendererListener != null) {
            pOBAdRendererListener.onAdImpression();
        }
    }

    @Override // com.pubmatic.sdk.webrendering.ui.POBViewabilityTracker.OnViewabilityChangedListener
    public void onViewabilityChanged(boolean z) {
        if (z) {
            g();
        } else {
            f();
        }
    }

    @Override // com.pubmatic.sdk.video.renderer.POBVideoRendering
    public void proceedAdSkip(boolean z) {
        POBAdRendererListener pOBAdRendererListener = this.b;
        if (pOBAdRendererListener != null) {
            if (z) {
                pOBAdRendererListener.onAdInteractionStopped();
            } else {
                this.g.play();
            }
        }
    }

    @Override // com.pubmatic.sdk.common.ui.POBBannerRendering
    public void renderAd(POBAdDescriptor pOBAdDescriptor) {
        i();
        this.j = pOBAdDescriptor;
        String renderableContent = pOBAdDescriptor.getRenderableContent();
        if (renderableContent != null) {
            this.g.load(renderableContent);
            return;
        }
        POBAdRendererListener pOBAdRendererListener = this.b;
        if (pOBAdRendererListener != null) {
            pOBAdRendererListener.onAdRenderingFailed(new POBError(1009, POBLogConstants.MSG_RENDERING_FAILED_ERROR + pOBAdDescriptor));
        }
    }

    @Override // com.pubmatic.sdk.common.ui.POBBannerRendering
    public void setAdRendererListener(POBAdRendererListener pOBAdRendererListener) {
        this.b = pOBAdRendererListener;
        if (pOBAdRendererListener instanceof POBVideoRenderingListener) {
            setVideoRenderingListener((POBVideoRenderingListener) pOBAdRendererListener);
        }
    }

    public void setExpirationTimeout(long j) {
        this.e = j;
    }

    public void setMeasurementProvider(POBVideoMeasurementProvider pOBVideoMeasurementProvider) {
        this.h = pOBVideoMeasurementProvider;
    }

    @Override // com.pubmatic.sdk.video.renderer.POBVideoRendering
    public void setVideoRenderingListener(POBVideoRenderingListener pOBVideoRenderingListener) {
        this.c = pOBVideoRenderingListener;
    }

    @Override // com.pubmatic.sdk.video.renderer.POBVideoRendering
    public void setVideoSkipEventListener(POBVideoSkipEventListener pOBVideoSkipEventListener) {
        this.d = pOBVideoSkipEventListener;
    }

    @Override // com.pubmatic.sdk.video.player.POBVastPlayerListener
    public void shouldForwardClickEvent() {
        h();
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        POBAdRendererListener pOBAdRendererListener = this.b;
        if (pOBAdRendererListener != null) {
            pOBAdRendererListener.onAdInteractionStarted();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        POBAdRendererListener pOBAdRendererListener = this.b;
        if (pOBAdRendererListener != null) {
            pOBAdRendererListener.onAdInteractionStopped();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        POBAdRendererListener pOBAdRendererListener = this.b;
        if (pOBAdRendererListener != null) {
            pOBAdRendererListener.onLeavingApplication();
        }
    }

    private void e() {
        POBAdRendererListener pOBAdRendererListener = this.b;
        if (pOBAdRendererListener != null) {
            pOBAdRendererListener.onRenderAdClick();
        }
    }

    private void f() {
        this.g.setAutoPlayOnForeground(false);
        this.g.pause();
    }

    private void g() {
        this.g.setAutoPlayOnForeground(true);
        this.g.play();
    }

    private void h() {
        POBVideoMeasurementProvider pOBVideoMeasurementProvider = this.h;
        if (pOBVideoMeasurementProvider != null) {
            pOBVideoMeasurementProvider.signalAdEvent(POBDataType.POBVideoAdEventType.CLICKED);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        POBAdRendererListener pOBAdRendererListener = this.b;
        if (pOBAdRendererListener != null) {
            pOBAdRendererListener.onAdExpired();
        }
    }

    private void a(String str) {
        if (POBUtils.isNullOrEmpty(str)) {
            POBLog.warn("POBVideoRenderer", POBVideoLogConstants.MSG_VAST_VIDEO_MISSING_CLICKTHROUGH, new Object[0]);
        } else {
            POBLog.debug("POBVideoRenderer", "Opening landing page with url: %s", str);
            POBUrlHandler pOBUrlHandler = this.k;
            if (pOBUrlHandler != null) {
                pOBUrlHandler.open(str);
            }
        }
        e();
    }

    private void a(Context context) {
        this.k = new POBUrlHandler(context, new e());
    }

    private void a(POBVastAd pOBVastAd, float f2) {
        if (this.h == null || pOBVastAd == null) {
            return;
        }
        a(pOBVastAd.getCombinedVerificationList(), f2);
    }

    private void a(List list, float f2) {
        POBVideoMeasurementProvider pOBVideoMeasurementProvider = this.h;
        if (pOBVideoMeasurementProvider != null) {
            pOBVideoMeasurementProvider.startAdSession(this.g, list, new f(f2));
            POBLog.debug("POBVideoRenderer", "Video viewability measurement provider initialised", new Object[0]);
        } else {
            POBLog.debug("POBVideoRenderer", "Video viewability measurement provider not initialised", new Object[0]);
        }
    }
}
