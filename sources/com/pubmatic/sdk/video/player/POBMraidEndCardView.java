package com.pubmatic.sdk.video.player;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.pubmatic.sdk.common.POBError;
import com.pubmatic.sdk.common.POBInstanceProvider;
import com.pubmatic.sdk.common.base.POBAdDescriptor;
import com.pubmatic.sdk.common.base.POBAdRendererListener;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.log.POBLogConstants;
import com.pubmatic.sdk.common.network.POBNetworkMonitor;
import com.pubmatic.sdk.common.utility.POBCountdownTimer;
import com.pubmatic.sdk.common.utility.POBTimeoutHandler;
import com.pubmatic.sdk.common.utility.POBUtils;
import com.pubmatic.sdk.video.POBVastError;
import com.pubmatic.sdk.video.POBVideoLogConstants;
import com.pubmatic.sdk.webrendering.POBUIUtil;
import com.pubmatic.sdk.webrendering.mraid.POBMraidRenderer;
import com.pubmatic.sdk.webrendering.mraid.POBUseCustomCloseListener;
import com.pubmatic.sdk.webrendering.ui.POBCountdownView;
import com.pubmatic.sdk.webrendering.ui.POBOnSkipOptionUpdateListener;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes9.dex */
public class POBMraidEndCardView extends FrameLayout implements POBEndCardRendering, POBAdRendererListener, POBUseCustomCloseListener, View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.pubmatic.sdk.video.player.a f7820a;
    private String b;
    private POBMraidRenderer c;
    private int d;
    private final ImageView e;
    private final boolean f;
    private POBOnSkipOptionUpdateListener g;
    private POBCountdownView h;
    private View i;
    private POBTimeoutHandler j;
    private POBCountdownTimer k;
    private boolean l;
    private long m;
    private boolean n;
    private boolean o;
    private int p;

    class a implements POBTimeoutHandler.POBTimeoutHandlerListener {
        a() {
        }

        @Override // com.pubmatic.sdk.common.utility.POBTimeoutHandler.POBTimeoutHandlerListener
        public void onTimeout() {
            POBLog.debug("POBMraidEndCardView", "Custom close delay timer exhausted", new Object[0]);
            POBMraidEndCardView pOBMraidEndCardView = POBMraidEndCardView.this;
            pOBMraidEndCardView.a(pOBMraidEndCardView.l, 2000L);
        }
    }

    class b extends POBCountdownTimer {
        b(long j, long j2, Looper looper) {
            super(j, j2, looper);
        }

        @Override // com.pubmatic.sdk.common.utility.POBCountdownTimer
        public void onFinish() {
            POBMraidEndCardView.this.g();
            POBLog.debug("POBMraidEndCardView", "Skip button timer exhausted, Skip button is shown", new Object[0]);
        }

        @Override // com.pubmatic.sdk.common.utility.POBCountdownTimer
        public void onTick(long j) {
        }
    }

    class c implements POBCountdownView.OnTimerExhaustedListener {
        c() {
        }

        @Override // com.pubmatic.sdk.webrendering.ui.POBCountdownView.OnTimerExhaustedListener
        public void onTimerExhausted() {
            POBMraidEndCardView.this.c();
            POBLog.debug("POBMraidEndCardView", "Countdown view timer exhausted, Skip button is shown", new Object[0]);
        }
    }

    public POBMraidEndCardView(Context context, boolean z) {
        super(context);
        this.f = z;
        setBackgroundColor(getResources().getColor(R.color.black));
        if (z) {
            this.e = POBUIUtil.createSkipButton(context, com.pubmatic.sdk.common.R.id.pob_forward_btn, com.pubmatic.sdk.webrendering.R.drawable.pob_ic_forward_24);
        } else {
            this.e = POBUIUtil.createSkipButton(context, com.pubmatic.sdk.common.R.id.pob_close_btn, com.pubmatic.sdk.common.R.drawable.pob_ic_close_black_24dp);
        }
        this.e.setOnClickListener(this);
        this.e.setVisibility(8);
    }

    private void d() {
        setBackgroundColor(Color.argb(204, 0, 0, 0));
    }

    private void e() {
        POBTimeoutHandler pOBTimeoutHandler = this.j;
        if (pOBTimeoutHandler != null) {
            pOBTimeoutHandler.cancel();
            this.j = null;
        }
    }

    private void f() {
        POBCountdownTimer pOBCountdownTimer = this.k;
        if (pOBCountdownTimer != null) {
            pOBCountdownTimer.cancel();
            this.k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.e.setVisibility(0);
        a(true);
    }

    private void h() {
        POBTimeoutHandler pOBTimeoutHandler = new POBTimeoutHandler(new a());
        this.j = pOBTimeoutHandler;
        pOBTimeoutHandler.start(2000L);
        this.m = System.currentTimeMillis();
        POBLog.debug("POBMraidEndCardView", "Custom close delay timer started with 2 sec delay", new Object[0]);
    }

    private void i() {
        POBCountdownTimer pOBCountdownTimer = this.k;
        if (pOBCountdownTimer != null) {
            this.o = true;
            pOBCountdownTimer.start();
            POBLog.debug("POBMraidEndCardView", "Skip button timer started", new Object[0]);
        }
    }

    public void destroy() {
        invalidateRenderer();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.F, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.pubmatic.sdk.video.player.POBEndCardRendering
    public FrameLayout getView() {
        return this;
    }

    public void invalidateRenderer() {
        POBMraidRenderer pOBMraidRenderer = this.c;
        if (pOBMraidRenderer != null) {
            pOBMraidRenderer.destroy();
            this.c = null;
        }
    }

    @Override // com.pubmatic.sdk.common.base.POBAdRendererListener
    public void onAdExpired() {
    }

    @Override // com.pubmatic.sdk.common.base.POBAdRendererListener
    public void onAdImpression() {
    }

    @Override // com.pubmatic.sdk.common.base.POBAdRendererListener
    public void onAdInteractionStarted() {
        this.p++;
    }

    @Override // com.pubmatic.sdk.common.base.POBAdRendererListener
    public void onAdInteractionStopped() {
        int i = this.p - 1;
        this.p = i;
        com.pubmatic.sdk.video.player.a aVar = this.f7820a;
        if (aVar == null || i != 0) {
            return;
        }
        if (this.c != null && this.f) {
            aVar.d();
        } else {
            destroy();
            this.f7820a.onClose();
        }
    }

    @Override // com.pubmatic.sdk.common.base.POBAdRendererListener
    public void onAdReadyToRefresh(int i) {
    }

    @Override // com.pubmatic.sdk.common.base.POBAdRendererListener
    public void onAdRender(View view, POBAdDescriptor pOBAdDescriptor) {
        this.i = view;
        if (view.getParent() != null || pOBAdDescriptor == null) {
            return;
        }
        com.pubmatic.sdk.video.player.a aVar = this.f7820a;
        if (aVar != null) {
            aVar.a();
        }
        POBEndCardUtil.updateEndCardView(view, this, pOBAdDescriptor);
        addView(view, 0);
    }

    @Override // com.pubmatic.sdk.common.base.POBAdRendererListener
    public void onAdRenderingFailed(POBError pOBError) {
        a(new POBVastError(602, POBVideoLogConstants.MSG_END_CARD_RENDERING_ERROR));
    }

    @Override // com.pubmatic.sdk.common.base.POBAdRendererListener
    public void onAdUnload() {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.c == null) {
            a(false, 0L);
        } else {
            h();
            onAdInteractionStarted();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.pubmatic.sdk.common.R.id.pob_close_btn) {
            com.pubmatic.sdk.video.player.a aVar = this.f7820a;
            if (aVar != null) {
                aVar.onClose();
                return;
            }
            return;
        }
        if (view.getId() == com.pubmatic.sdk.common.R.id.pob_forward_btn) {
            com.pubmatic.sdk.video.player.a aVar2 = this.f7820a;
            if (aVar2 != null) {
                aVar2.d();
                return;
            }
            return;
        }
        if (view.getId() == com.pubmatic.sdk.video.R.id.pob_learn_more_btn) {
            c();
            com.pubmatic.sdk.video.player.a aVar3 = this.f7820a;
            if (aVar3 != null) {
                aVar3.b();
                return;
            }
            return;
        }
        if (view instanceof POBMraidEndCardView) {
            c();
            com.pubmatic.sdk.video.player.a aVar4 = this.f7820a;
            if (aVar4 != null) {
                aVar4.c();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.c != null) {
            e();
            f();
        }
        super.onDetachedFromWindow();
    }

    @Override // com.pubmatic.sdk.common.base.POBAdRendererListener
    public void onLeavingApplication() {
        c();
        com.pubmatic.sdk.video.player.a aVar = this.f7820a;
        if (aVar != null) {
            aVar.onEndCardWillLeaveApp();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // com.pubmatic.sdk.common.base.POBAdRendererListener
    public void onRenderAdClick() {
        c();
        com.pubmatic.sdk.video.player.a aVar = this.f7820a;
        if (aVar != null) {
            aVar.a(null, true);
        }
    }

    @Override // com.pubmatic.sdk.common.base.POBAdRendererListener
    public void onRenderProcessGone() {
        View view = this.i;
        if (view != null) {
            removeView(view);
            this.i = null;
        }
        a(new POBVastError(602, POBVideoLogConstants.MSG_END_CARD_RENDERING_ERROR));
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        POBCountdownTimer pOBCountdownTimer = this.k;
        if (pOBCountdownTimer == null) {
            return;
        }
        if (!z) {
            pOBCountdownTimer.pause();
        } else if (this.o) {
            pOBCountdownTimer.resume();
        } else {
            i();
        }
    }

    @Override // com.pubmatic.sdk.video.player.POBEndCardRendering
    public void render(POBAdDescriptor pOBAdDescriptor) {
        if (pOBAdDescriptor == null) {
            b();
            return;
        }
        POBLog.debug("POBMraidEndCardView", POBVideoLogConstants.MSG_END_CARD_FOUND, new Object[0]);
        if (!POBNetworkMonitor.isNetworkAvailable(getContext())) {
            a(new POBVastError(602, POBVideoLogConstants.MSG_END_CARD_NETWORK_ERROR));
        } else {
            if (renderMRAIDView(pOBAdDescriptor)) {
                return;
            }
            a(new POBVastError(604, POBVideoLogConstants.MSG_END_CARD_NO_SUPPORTED_RESOURCE));
        }
    }

    protected boolean renderMRAIDView(POBAdDescriptor pOBAdDescriptor) {
        if (POBUtils.isNullOrEmpty(pOBAdDescriptor.getRenderableContent())) {
            POBLog.error("POBMraidEndCardView", POBLogConstants.MSG_RENDERERABLE_CONTENTS_NOT_AVAILABLE, new Object[0]);
            return false;
        }
        POBMraidRenderer pOBMraidRendererCreateInstance = POBMraidRenderer.createInstance(getContext(), "interstitial", hashCode());
        this.c = pOBMraidRendererCreateInstance;
        if (pOBMraidRendererCreateInstance == null) {
            POBLog.error("POBMraidEndCardView", POBLogConstants.MSG_FAILED_TO_CREATE_MRAID_RENDERER, new Object[0]);
            return false;
        }
        pOBMraidRendererCreateInstance.setAdRendererListener(this);
        this.c.setBaseURL(POBInstanceProvider.getSdkConfig().isRequestSecureCreative() ? "https://ow.pubmatic.com/openrtb/2.5" : "http://ow.pubmatic.com/openrtb/2.5");
        this.c.setCustomCloseListener(this);
        this.c.renderAd(pOBAdDescriptor);
        return true;
    }

    void setFSCEnabled(boolean z) {
        setOnClickListener(z ? this : null);
    }

    @Override // com.pubmatic.sdk.video.player.POBEndCardRendering
    public void setLearnMoreTitle(String str) {
        this.b = str;
    }

    @Override // com.pubmatic.sdk.video.player.POBEndCardRendering
    public void setListener(com.pubmatic.sdk.video.player.a aVar) {
        this.f7820a = aVar;
    }

    @Override // com.pubmatic.sdk.video.player.POBEndCardRendering
    public void setOnSkipOptionUpdateListener(POBOnSkipOptionUpdateListener pOBOnSkipOptionUpdateListener) {
        this.g = pOBOnSkipOptionUpdateListener;
    }

    @Override // com.pubmatic.sdk.video.player.POBEndCardRendering
    public void setSkipAfter(int i) {
        this.d = i;
    }

    @Override // com.pubmatic.sdk.webrendering.mraid.POBUseCustomCloseListener
    public void useCustomClose(boolean z) {
        this.l = z;
        e();
        long jMax = Math.max(0L, System.currentTimeMillis() - this.m);
        this.m = jMax;
        a(z, jMax);
    }

    private void b() {
        a();
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        POBCountdownView pOBCountdownView = this.h;
        if (pOBCountdownView == null || pOBCountdownView.getParent() != this) {
            return;
        }
        removeView(this.h);
        g();
        this.h = null;
    }

    private void a() {
        POBLog.debug("POBMraidEndCardView", POBVideoLogConstants.MSG_RENDERING_LEARN_MORE, new Object[0]);
        Resources resources = getResources();
        View viewA = com.pubmatic.sdk.video.player.b.a(getContext(), com.pubmatic.sdk.video.R.id.pob_learn_more_btn, this.b, resources.getColor(com.pubmatic.sdk.webrendering.R.color.pob_controls_background_color));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, resources.getDimensionPixelOffset(com.pubmatic.sdk.webrendering.R.dimen.pob_control_height));
        layoutParams.gravity = 17;
        addView(viewA, layoutParams);
        viewA.setOnClickListener(this);
    }

    private void a(POBVastError pOBVastError) {
        com.pubmatic.sdk.video.player.a aVar = this.f7820a;
        if (aVar != null) {
            aVar.a(pOBVastError);
        }
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, long j) {
        if (this.n) {
            return;
        }
        this.n = true;
        POBLog.debug("POBMraidEndCardView", "EndCard skipOffset: " + this.d, new Object[0]);
        if (z) {
            this.k = new b(a(j), 1L, Looper.getMainLooper());
            if (hasWindowFocus()) {
                i();
            }
        } else {
            int seconds = this.d - ((int) TimeUnit.MILLISECONDS.toSeconds(j));
            if (seconds > 0) {
                this.h = new POBCountdownView(getContext(), seconds);
                a(false);
                this.h.setTimerExhaustedListener(new c());
                addView(this.h);
                POBLog.debug("POBMraidEndCardView", "Countdown view timer started", new Object[0]);
            } else {
                g();
            }
        }
        addView(this.e);
    }

    private long a(long j) {
        return TimeUnit.MILLISECONDS.toSeconds(Math.max(TimeUnit.SECONDS.toMillis(this.d), 20000L) - j);
    }

    private void a(boolean z) {
        POBOnSkipOptionUpdateListener pOBOnSkipOptionUpdateListener = this.g;
        if (pOBOnSkipOptionUpdateListener != null) {
            pOBOnSkipOptionUpdateListener.onSkipOptionUpdate(z);
        }
    }
}
