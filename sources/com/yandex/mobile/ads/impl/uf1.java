package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public abstract class uf1 extends uk implements yg0, ch1.b, qh2.a {
    private static boolean j;
    private final Context b;
    private final qh2 c;
    private final ch1 d;
    private final wy1 e;
    private ah0 f;
    private zg0 g;
    private boolean h;
    private boolean i;

    protected void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(context, "context");
        setBackgroundColor(0);
        setVisibility(4);
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        setScrollBarStyle(0);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setSupportZoom(false);
        getSettings().setBuiltInZoomControls(false);
        getSettings().setTextZoom(100);
        getSettings().setMinimumFontSize(1);
        getSettings().setMinimumLogicalFontSize(1);
        WebSettings settings = getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "getSettings(...)");
        if (pa.a(21)) {
            settings.setMixedContentMode(2);
        }
        WebSettings settings2 = getSettings();
        Intrinsics.checkNotNullExpressionValue(settings2, "getSettings(...)");
        settings2.setMediaPlaybackRequiresUserGesture(false);
        setWebViewClient(new xg0(this, ws1.b()));
        setWebChromeClient(new sg0());
    }

    @Override // com.yandex.mobile.ads.impl.uk
    public String c() {
        return "<style type='text/css'> \n  * { \n      -webkit-tap-highlight-color: rgba(0, 0, 0, 0) !important; \n      -webkit-focus-ring-color: rgba(0, 0, 0, 0) !important; \n      outline: none !important; \n    } \n</style> \n" + jj2.a();
    }

    @Override // com.yandex.mobile.ads.impl.uk, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.y, this, me);
        return super.dispatchTouchEvent(me);
    }

    protected abstract void h();

    @Override // com.yandex.mobile.ads.impl.uk, android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onVisibilityChanged(View changedView, int i) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, i);
        this.c.getClass();
        a(qh2.a(this));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ uf1(Context context) {
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this(context, applicationContext, new qh2(), ch1.h.a(applicationContext));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uf1(Context context, Context appContext, qh2 viewableChecker, ch1 phoneStateTracker) {
        super(appContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(viewableChecker, "viewableChecker");
        Intrinsics.checkNotNullParameter(phoneStateTracker, "phoneStateTracker");
        this.b = appContext;
        this.c = viewableChecker;
        this.d = phoneStateTracker;
        this.e = new wy1();
        a(context);
        if (j) {
            return;
        }
        j = true;
    }

    public final Context i() {
        return this.b;
    }

    public ah0 j() {
        return this.f;
    }

    public void setHtmlWebViewListener(ah0 ah0Var) {
        this.f = ah0Var;
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.c.getClass();
        a(qh2.a(this));
    }

    public final void setHtmlWebViewErrorListener(zg0 zg0Var) {
        this.g = zg0Var;
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.i = true;
        this.d.a(this);
        this.c.getClass();
        a(qh2.a(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.i = false;
        this.c.getClass();
        a(qh2.a(this));
        this.d.b(this);
        super.onDetachedFromWindow();
    }

    @Override // com.yandex.mobile.ads.impl.qh2.a
    public final boolean b() {
        return this.i;
    }

    @Override // com.yandex.mobile.ads.impl.uk
    public void d() {
        setHtmlWebViewListener(null);
        super.d();
    }

    private final void a(boolean z) {
        if (this.h != z) {
            this.h = z;
            ah0 ah0VarJ = j();
            if (ah0VarJ != null) {
                ah0VarJ.a(this.h);
            }
        }
    }

    public void a(Context context, String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        ah0 ah0VarJ = j();
        if (ah0VarJ != null) {
            ah0VarJ.a(url);
        }
    }

    public void a() {
        this.e.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.uf1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                uf1.a(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(uf1 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001f  */
    @Override // com.yandex.mobile.ads.impl.ch1.b
    public final void a(zg1 phoneState) {
        boolean z;
        Intrinsics.checkNotNullParameter(phoneState, "phoneState");
        if (phoneState == zg1.c) {
            z = false;
        } else {
            this.c.getClass();
            if (qh2.a(this) && this.d.b()) {
                z = true;
            } else {
                z = false;
            }
        }
        a(z);
    }

    public void a(int i) {
        zg0 zg0Var = this.g;
        if (zg0Var != null) {
            zg0Var.a(i);
        }
    }
}
