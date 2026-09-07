package com.pubmatic.sdk.webrendering.mraid;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.pubmatic.sdk.common.R;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.utility.POBUtils;
import com.pubmatic.sdk.common.view.POBWebView;
import com.pubmatic.sdk.webrendering.POBUIUtil;
import com.pubmatic.sdk.webrendering.ui.POBAdViewContainer;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;

/* JADX INFO: loaded from: classes3.dex */
class p extends RelativeLayout implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewGroup f7918a;
    private Context b;
    private POBAdViewContainer c;
    private POBWebView d;
    private d e;
    private ImageView f;
    private RelativeLayout g;
    private int h;
    private boolean i;
    private final ViewTreeObserver.OnGlobalLayoutListener j;
    private final POBWebView.WebViewBackPress k;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int deviceOrientation = POBUtils.getDeviceOrientation(p.this.b);
            POBLog.debug("POBResizeView", "currentOrientation :" + p.this.h + ", changedOrientation:" + deviceOrientation, new Object[0]);
            if (deviceOrientation == p.this.h || !p.this.i) {
                return;
            }
            p.this.b();
        }
    }

    class b implements POBWebView.WebViewBackPress {
        b() {
        }

        @Override // com.pubmatic.sdk.common.view.POBWebView.WebViewBackPress
        public void onBackPress() {
            p.this.b();
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            p.this.b();
        }
    }

    interface d {
        void a(POBAdViewContainer pOBAdViewContainer);
    }

    p(Context context) {
        super(context);
        this.i = true;
        this.j = new a();
        this.k = new b();
        this.b = context;
    }

    void d() {
        ViewGroup viewGroup = this.f7918a;
        if (viewGroup != null) {
            viewGroup.bringChildToFront(this);
            this.f7918a.requestFocus();
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.F, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return !(view instanceof POBWebView);
    }

    void a(ViewGroup viewGroup, POBAdViewContainer pOBAdViewContainer, int i, int i2, int i3, int i4, d dVar) {
        this.c = pOBAdViewContainer;
        this.d = pOBAdViewContainer.getAdView();
        this.b = pOBAdViewContainer.getContext();
        this.f7918a = viewGroup;
        this.e = dVar;
        a(pOBAdViewContainer, i, i2, i3, i4);
        this.h = POBUtils.getDeviceOrientation(this.b);
    }

    public void b() {
        POBAdViewContainer pOBAdViewContainer;
        RelativeLayout relativeLayout = this.g;
        if (relativeLayout != null && this.c != null && this.d != null) {
            relativeLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this.j);
            this.g.removeView(this.f);
            this.g.removeView(this.c);
            this.d.setWebViewBackPress(null);
        }
        setOnTouchListener(null);
        removeAllViews();
        d dVar = this.e;
        if (dVar == null || (pOBAdViewContainer = this.c) == null) {
            return;
        }
        dVar.a(pOBAdViewContainer);
    }

    ImageView c() {
        return this.f;
    }

    private void a(ViewGroup viewGroup, int i, int i2, int i3, int i4) {
        this.f = POBUIUtil.createSkipButton(getContext(), R.id.pob_close_btn, com.pubmatic.sdk.webrendering.R.drawable.pob_ic_close_black_24dp);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        this.f.setOnClickListener(new c());
        this.g = new RelativeLayout(this.b);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, i2);
        layoutParams2.setMargins(i3, i4, Integer.MIN_VALUE, Integer.MIN_VALUE);
        this.g.addView(viewGroup, new RelativeLayout.LayoutParams(-1, -1));
        this.g.addView(this.f, layoutParams);
        addView(this.g, layoutParams2);
        a(true);
        setOnTouchListener(this);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        ViewGroup viewGroup2 = this.f7918a;
        if (viewGroup2 != null) {
            viewGroup2.addView(this, 0, layoutParams3);
        }
    }

    void a(boolean z) {
        POBWebView pOBWebView = this.d;
        if (pOBWebView != null) {
            if (z) {
                pOBWebView.setWebViewBackPress(this.k);
            } else {
                pOBWebView.setWebViewBackPress(null);
            }
        }
    }

    void a(int i, int i2, int i3, int i4) {
        if (this.g != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i2);
            layoutParams.setMargins(i3, i4, Integer.MIN_VALUE, Integer.MIN_VALUE);
            updateViewLayout(this.g, layoutParams);
        }
    }

    void a() {
        this.i = false;
    }
}
