package com.pubmatic.sdk.webrendering.mraid;

import android.content.Context;
import android.os.Trace;
import android.view.View;
import android.widget.ImageButton;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.common.POBError;
import com.pubmatic.sdk.common.POBInstanceProvider;
import com.pubmatic.sdk.common.base.POBAdDescriptor;
import com.pubmatic.sdk.common.base.POBAdRendererListener;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.log.POBLogConstants;
import com.pubmatic.sdk.common.models.POBDeviceInfo;
import com.pubmatic.sdk.common.models.POBImpressionCountingMethod;
import com.pubmatic.sdk.common.network.POBTrackerHandler;
import com.pubmatic.sdk.common.ui.POBBannerRendering;
import com.pubmatic.sdk.common.ui.POBHtmlRendererListener;
import com.pubmatic.sdk.common.utility.POBUrlHandler;
import com.pubmatic.sdk.common.utility.POBUtils;
import com.pubmatic.sdk.common.view.POBWebView;
import com.pubmatic.sdk.common.viewability.POBHTMLMeasurementProvider;
import com.pubmatic.sdk.common.viewability.POBMeasurementProvider;
import com.pubmatic.sdk.common.viewability.POBObstructionUpdateListener;
import com.pubmatic.sdk.webrendering.dsa.POBDsaHtmlContent;
import com.pubmatic.sdk.webrendering.dsa.POBDsaInfoPresenterHelper;
import com.pubmatic.sdk.webrendering.ui.POBAdViewContainer;
import com.pubmatic.sdk.webrendering.ui.POBAdVisibilityListener;
import com.pubmatic.sdk.webrendering.ui.POBHTMLRenderer;
import com.pubmatic.sdk.webrendering.ui.POBHTMLViewClient;
import com.pubmatic.sdk.webrendering.ui.POBViewabilityTracker;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes7.dex */
public class POBMraidRenderer implements n, POBBannerRendering, POBHtmlRendererListener, POBObstructionUpdateListener, POBHTMLViewClient.OnRenderProcessGoneListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7901a;
    private final POBMraidController b;
    private final POBMraidBridge c;
    private final POBHTMLRenderer d;
    private POBAdRendererListener e;
    private POBUseCustomCloseListener f;
    private final POBAdViewContainer g;
    private boolean h;
    private View.OnLayoutChangeListener i;
    private POBAdVisibilityListener j;
    private POBHTMLMeasurementProvider k;
    private String l;
    private final Context m;
    private POBWebView n;
    private POBAdDescriptor o;
    private POBUrlHandler p;
    private POBTrackerHandler q;
    private boolean r;

    class a implements POBWebView.OnFocusChangedListener {
        a() {
        }

        @Override // com.pubmatic.sdk.common.view.POBWebView.OnFocusChangedListener
        public void onFocusChanged(boolean z) {
            if (POBMraidRenderer.this.j != null) {
                POBMraidRenderer.this.j.onVisibilityChange(z);
            }
        }
    }

    class b implements POBMeasurementProvider.POBScriptListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7903a;
        final /* synthetic */ boolean b;

        b(String str, boolean z) {
            this.f7903a = str;
            this.b = z;
        }

        @Override // com.pubmatic.sdk.common.viewability.POBMeasurementProvider.POBScriptListener
        public void onFailedToReceiveMeasurementScript(int i) {
            POBLog.error("POBMraidRenderer", POBLogConstants.OMID_JS_SCRIPT_FAILURE, new Object[0]);
            POBMraidRenderer.this.d.loadHTML(this.f7903a, POBMraidRenderer.this.l, this.b);
        }

        @Override // com.pubmatic.sdk.common.viewability.POBMeasurementProvider.POBScriptListener
        public void onMeasurementScriptReceived(String str) {
            POBMraidRenderer.this.d.loadHTML("<script>" + str + "</script>" + this.f7903a, POBMraidRenderer.this.l, this.b);
        }
    }

    class c implements POBViewabilityTracker.OnViewabilityChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ POBViewabilityTracker f7904a;

        c(POBViewabilityTracker pOBViewabilityTracker) {
            this.f7904a = pOBViewabilityTracker;
        }

        @Override // com.pubmatic.sdk.webrendering.ui.POBViewabilityTracker.OnViewabilityChangedListener
        public void onViewabilityChanged(boolean z) {
            if (z) {
                POBMraidRenderer.this.d();
                this.f7904a.destroy();
            }
        }
    }

    class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ POBAdDescriptor f7905a;

        class a implements POBDsaHtmlContent.OnContentListener {
            a() {
            }

            @Override // com.pubmatic.sdk.webrendering.dsa.POBDsaHtmlContent.OnContentListener
            public void onPageContentReceived(String str) throws UnsupportedEncodingException {
                POBDsaInfoPresenterHelper.show(POBMraidRenderer.this.m, d.this.f7905a, str);
            }
        }

        d(POBAdDescriptor pOBAdDescriptor) {
            this.f7905a = pOBAdDescriptor;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            POBDsaHtmlContent.getHtmlContent(POBMraidRenderer.this.m, new a());
        }
    }

    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (POBMraidRenderer.this.h) {
                POBMraidRenderer.this.c.setMraidState(com.pubmatic.sdk.webrendering.mraid.b.DEFAULT);
            }
            POBMraidRenderer.this.b.initProperties(POBMraidRenderer.this.c, POBMraidRenderer.this.h);
            POBMraidRenderer.this.h = false;
        }
    }

    class f implements View.OnLayoutChangeListener {
        f() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            POBMraidRenderer.this.h();
        }
    }

    class g implements POBUrlHandler.UrlHandlerListener {
        g() {
        }

        @Override // com.pubmatic.sdk.common.utility.POBUrlHandler.UrlHandlerListener
        public void onErrorOpenUrl(String str) {
            POBLog.warn("POBMraidRenderer", "Error opening url %s", str);
        }

        @Override // com.pubmatic.sdk.common.utility.POBUrlHandler.UrlHandlerListener
        public void onInternalBrowserClose(String str) {
            POBMraidRenderer.this.c();
        }

        @Override // com.pubmatic.sdk.common.utility.POBUrlHandler.UrlHandlerListener
        public void onInternalBrowserOpen(String str) {
            POBMraidRenderer.this.b();
        }

        @Override // com.pubmatic.sdk.common.utility.POBUrlHandler.UrlHandlerListener
        public void onLeaveApp(String str) {
            POBMraidRenderer.this.onLeavingApplication();
        }
    }

    class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (POBMraidRenderer.this.k != null) {
                POBMraidRenderer.this.k.signalAdEvent(POBHTMLMeasurementProvider.POBHTMLAdEventType.IMPRESSION);
            }
        }
    }

    protected POBMraidRenderer(Context context, String str, POBAdViewContainer pOBAdViewContainer, int i) {
        this.r = false;
        this.m = context;
        this.f7901a = str;
        this.g = pOBAdViewContainer;
        this.n = pOBAdViewContainer.getAdView();
        this.r = "interstitial".equals(str);
        this.n.getSettings().setJavaScriptEnabled(true);
        this.n.getSettings().setCacheMode(2);
        this.n.setScrollBarStyle(0);
        POBMraidWebClient pOBMraidWebClient = new POBMraidWebClient(this);
        pOBMraidWebClient.disableMultipleOnPageFinished(true);
        POBHTMLRenderer pOBHTMLRenderer = new POBHTMLRenderer(this.n, pOBMraidWebClient);
        this.d = pOBHTMLRenderer;
        pOBHTMLRenderer.setRendererViewListener(this);
        POBMraidBridge pOBMraidBridge = new POBMraidBridge(pOBAdViewContainer);
        this.c = pOBMraidBridge;
        POBMraidController pOBMraidController = new POBMraidController(context, pOBMraidBridge, str, i);
        this.b = pOBMraidController;
        pOBMraidController.setMraidControllerListener(this);
        pOBMraidController.addInlineVideoSupportToWebView(this.n);
        g();
        a(pOBMraidController);
    }

    public static POBMraidRenderer createInstance(Context context, String str, int i) {
        POBWebView pOBWebViewCreateInstance = POBWebView.createInstance(context);
        if (pOBWebViewCreateInstance != null) {
            return new POBMraidRenderer(context, str, new POBAdViewContainer(context, pOBWebViewCreateInstance), i);
        }
        return null;
    }

    @Override // com.pubmatic.sdk.common.viewability.POBObstructionUpdateListener
    public void addFriendlyObstructions(View view, POBObstructionUpdateListener.POBFriendlyObstructionPurpose pOBFriendlyObstructionPurpose) {
        POBHTMLMeasurementProvider pOBHTMLMeasurementProvider = this.k;
        if (pOBHTMLMeasurementProvider != null) {
            pOBHTMLMeasurementProvider.addFriendlyObstructions(view, pOBFriendlyObstructionPurpose);
        }
    }

    @Override // com.pubmatic.sdk.common.ui.POBBannerRendering
    public void destroy() {
        invalidate();
        this.d.destroy();
    }

    public void invalidate() {
        this.b.destroy();
        POBWebView pOBWebView = this.n;
        if (pOBWebView != null) {
            pOBWebView.removeOnLayoutChangeListener(this.i);
            this.n.setOnfocusChangedListener(null);
            this.n = null;
        }
        this.i = null;
        POBHTMLMeasurementProvider pOBHTMLMeasurementProvider = this.k;
        if (pOBHTMLMeasurementProvider != null) {
            pOBHTMLMeasurementProvider.finishAdSession();
            this.k = null;
        }
    }

    @Override // com.pubmatic.sdk.common.ui.POBBannerRendering
    public void invalidateExpiration() {
    }

    @Override // com.pubmatic.sdk.webrendering.mraid.n
    public boolean isUserInteracted(boolean z) {
        boolean zIsUserInteracted = this.d.isUserInteracted();
        if (z) {
            this.d.setUserInteracted(false);
        }
        return zIsUserInteracted;
    }

    @Override // com.pubmatic.sdk.webrendering.mraid.n
    public void onAdInteractionStarted() {
        if (!this.r) {
            this.g.resizeDsaIcon(true);
        }
        b();
    }

    @Override // com.pubmatic.sdk.webrendering.mraid.n
    public void onAdInteractionStopped() {
        if (!this.r) {
            this.g.resizeDsaIcon(false);
        }
        c();
    }

    @Override // com.pubmatic.sdk.webrendering.mraid.n
    public void onAdUnload() {
        POBAdRendererListener pOBAdRendererListener = this.e;
        if (pOBAdRendererListener != null) {
            pOBAdRendererListener.onAdUnload();
        }
    }

    @Override // com.pubmatic.sdk.webrendering.mraid.n
    public void onAdViewChanged(View view) {
        POBHTMLMeasurementProvider pOBHTMLMeasurementProvider = this.k;
        if (pOBHTMLMeasurementProvider != null) {
            pOBHTMLMeasurementProvider.setTrackView(view);
        }
    }

    @Override // com.pubmatic.sdk.webrendering.mraid.n
    public void onLeavingApplication() {
        POBAdRendererListener pOBAdRendererListener = this.e;
        if (pOBAdRendererListener != null) {
            pOBAdRendererListener.onLeavingApplication();
        }
    }

    @Override // com.pubmatic.sdk.webrendering.mraid.n
    public void onMRAIDAdClick() {
        a();
        POBAdRendererListener pOBAdRendererListener = this.e;
        if (pOBAdRendererListener != null) {
            pOBAdRendererListener.onRenderAdClick();
        }
    }

    @Override // com.pubmatic.sdk.webrendering.mraid.n
    public void onOpen(String str) {
        a(str);
    }

    @Override // com.pubmatic.sdk.common.ui.POBHtmlRendererListener, com.pubmatic.sdk.webrendering.ui.POBHTMLViewClient.OnRenderProcessGoneListener
    public void onRenderProcessGone() {
        POBAdRendererListener pOBAdRendererListener = this.e;
        if (pOBAdRendererListener != null) {
            pOBAdRendererListener.onRenderProcessGone();
        }
        invalidate();
        this.d.invalidateWebView();
    }

    @Override // com.pubmatic.sdk.common.ui.POBHtmlRendererListener
    public void onViewClicked(String str) {
        a(str);
    }

    @Override // com.pubmatic.sdk.common.ui.POBHtmlRendererListener
    public void onViewRendered(View view) {
        Trace.endSection();
        if (!this.r) {
            this.b.close();
        }
        this.c.resetPropertyMap();
        this.h = true;
        if (!this.r) {
            h();
        }
        f();
        i();
        POBAdDescriptor pOBAdDescriptor = this.o;
        if (pOBAdDescriptor != null && pOBAdDescriptor.enableDsaInfoIcon()) {
            a(this.o);
        }
        if (this.e != null) {
            a(this.m);
            this.e.onAdRender(this.g, this.o);
            POBAdDescriptor pOBAdDescriptor2 = this.o;
            if (pOBAdDescriptor2 != null && pOBAdDescriptor2.getImpressionCountingMethod() == POBImpressionCountingMethod.ON_LOAD) {
                d();
            }
            POBAdDescriptor pOBAdDescriptor3 = this.o;
            this.e.onAdReadyToRefresh(pOBAdDescriptor3 != null ? pOBAdDescriptor3.getRefreshInterval() : 0);
        }
    }

    @Override // com.pubmatic.sdk.common.ui.POBHtmlRendererListener
    public void onViewRenderingFailed(POBError pOBError) {
        Trace.endSection();
        POBAdRendererListener pOBAdRendererListener = this.e;
        if (pOBAdRendererListener != null) {
            pOBAdRendererListener.onAdRenderingFailed(pOBError);
        }
    }

    @Override // com.pubmatic.sdk.common.viewability.POBObstructionUpdateListener
    public void removeFriendlyObstructions(View view) {
        POBHTMLMeasurementProvider pOBHTMLMeasurementProvider = this.k;
        if (pOBHTMLMeasurementProvider != null) {
            pOBHTMLMeasurementProvider.removeFriendlyObstructions(view);
        }
    }

    @Override // com.pubmatic.sdk.common.ui.POBBannerRendering
    public void renderAd(POBAdDescriptor pOBAdDescriptor) {
        Trace.beginSection("POB Mraid Parsing");
        this.o = pOBAdDescriptor;
        if (pOBAdDescriptor.getImpressionCountingMethod() == POBImpressionCountingMethod.ONE_PX_VIEWABLE) {
            e();
        }
        this.b.addCommandHandlers(this.c, false, this.o.isCompanion());
        String renderableContent = pOBAdDescriptor.getRenderableContent();
        boolean zIsCompanion = pOBAdDescriptor.isCompanion();
        if (zIsCompanion && !POBUtils.isNullOrEmpty(renderableContent) && renderableContent.toLowerCase().startsWith("http")) {
            this.d.loadHTML(null, renderableContent, zIsCompanion);
            return;
        }
        Context applicationContext = this.m.getApplicationContext();
        POBDeviceInfo deviceInfo = POBInstanceProvider.getDeviceInfo(applicationContext);
        String str = POBMRAIDUtil.getMRAIDEnvironment(POBInstanceProvider.getAppInfo(applicationContext).getPackageName(), deviceInfo.getAdvertisingID(), deviceInfo.getLmtEnabled(), POBInstanceProvider.getSdkConfig().isCoppa()) + pOBAdDescriptor.getRenderableContent();
        POBHTMLMeasurementProvider pOBHTMLMeasurementProvider = this.k;
        if (pOBHTMLMeasurementProvider != null) {
            pOBHTMLMeasurementProvider.omidJsServiceScript(this.m.getApplicationContext(), new b(str, zIsCompanion));
        } else {
            this.d.loadHTML(str, this.l, zIsCompanion);
        }
    }

    @Override // com.pubmatic.sdk.common.ui.POBBannerRendering
    public void setAdRendererListener(POBAdRendererListener pOBAdRendererListener) {
        this.e = pOBAdRendererListener;
    }

    public void setBaseURL(String str) {
        this.l = str;
    }

    public void setCustomCloseListener(POBUseCustomCloseListener pOBUseCustomCloseListener) {
        this.f = pOBUseCustomCloseListener;
    }

    public void setHTMLMeasurementListener(POBHTMLMeasurementProvider pOBHTMLMeasurementProvider) {
        this.k = pOBHTMLMeasurementProvider;
    }

    public void setRenderingTimeout(int i) {
        this.d.setRenderingTimeout(i);
    }

    public void setTrackerHandler(POBTrackerHandler pOBTrackerHandler) {
        this.q = pOBTrackerHandler;
    }

    @Override // com.pubmatic.sdk.webrendering.mraid.n
    public void shouldUseCustomClose(boolean z) {
        POBLog.debug("POBMraidRenderer", "MRAID useCustomClose: %s", Boolean.valueOf(z));
        POBUseCustomCloseListener pOBUseCustomCloseListener = this.f;
        if (pOBUseCustomCloseListener != null) {
            pOBUseCustomCloseListener.useCustomClose(z);
        }
    }

    public void signalImpressionEvent() {
        POBWebView pOBWebView;
        if (this.k == null || (pOBWebView = this.n) == null) {
            return;
        }
        pOBWebView.postDelayed(new h(), 1000L);
    }

    private void b(String str) {
        if (this.p == null || POBUtils.isNullOrEmpty(str) || POBCommonConstants.PLACEHOLDER_CLICK_THROUGH.equals(str)) {
            POBLog.warn("POBMraidRenderer", "Click through url is missing.", new Object[0]);
        } else {
            this.p.open(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        POBAdRendererListener pOBAdRendererListener = this.e;
        if (pOBAdRendererListener != null) {
            pOBAdRendererListener.onAdInteractionStopped();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        POBAdRendererListener pOBAdRendererListener = this.e;
        if (pOBAdRendererListener != null) {
            pOBAdRendererListener.onAdImpression();
        }
    }

    private void e() {
        POBWebView pOBWebView = this.n;
        if (pOBWebView != null) {
            POBViewabilityTracker pOBViewabilityTracker = new POBViewabilityTracker((View) pOBWebView, 1);
            pOBViewabilityTracker.setAllowViewTreeObserverRegistration(true);
            pOBViewabilityTracker.setOnExposureChangeWithThresholdListener(new c(pOBViewabilityTracker));
        }
    }

    private void f() {
        if (this.i != null || this.n == null) {
            POBLog.debug("POBMraidRenderer", "layoutChangeListener null", new Object[0]);
            return;
        }
        f fVar = new f();
        this.i = fVar;
        this.n.addOnLayoutChangeListener(fVar);
    }

    private void g() {
        POBWebView pOBWebView = this.n;
        if (pOBWebView != null) {
            pOBWebView.setOnfocusChangedListener(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        POBWebView pOBWebView = this.n;
        if (pOBWebView != null) {
            pOBWebView.post(new e());
        }
    }

    private void i() {
        POBWebView pOBWebView;
        POBHTMLMeasurementProvider pOBHTMLMeasurementProvider = this.k;
        if (pOBHTMLMeasurementProvider == null || (pOBWebView = this.n) == null) {
            return;
        }
        pOBHTMLMeasurementProvider.startAdSession(pOBWebView);
        this.k.signalAdEvent(POBHTMLMeasurementProvider.POBHTMLAdEventType.LOADED);
        if (this.r) {
            return;
        }
        signalImpressionEvent();
    }

    private void a(POBAdVisibilityListener pOBAdVisibilityListener) {
        this.j = pOBAdVisibilityListener;
    }

    private void a(String str) {
        a();
        b(str);
        POBAdRendererListener pOBAdRendererListener = this.e;
        if (pOBAdRendererListener != null) {
            pOBAdRendererListener.onRenderAdClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        POBAdRendererListener pOBAdRendererListener = this.e;
        if (pOBAdRendererListener != null) {
            pOBAdRendererListener.onAdInteractionStarted();
        }
    }

    private void a() {
        POBAdDescriptor pOBAdDescriptor = this.o;
        if (pOBAdDescriptor == null || this.q == null) {
            return;
        }
        this.q.sendTrackers(pOBAdDescriptor.getClickTrackers());
    }

    private void a(POBAdDescriptor pOBAdDescriptor) {
        POBHTMLMeasurementProvider pOBHTMLMeasurementProvider;
        this.g.addDsaIcon(this.r, pOBAdDescriptor.isVideo(), new d(pOBAdDescriptor));
        ImageButton dsaIcon = this.g.getDsaIcon();
        if (dsaIcon == null || (pOBHTMLMeasurementProvider = this.k) == null) {
            return;
        }
        pOBHTMLMeasurementProvider.addFriendlyObstructions(dsaIcon, POBObstructionUpdateListener.POBFriendlyObstructionPurpose.OTHER);
    }

    private void a(Context context) {
        this.p = new POBUrlHandler(context, new g());
    }
}
