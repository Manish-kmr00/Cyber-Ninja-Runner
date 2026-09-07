package com.ogury.ad.internal;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes4.dex */
public final class d5 extends WebView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f7280a;
    public final MutableContextWrapper b;
    public boolean c;
    public p9 d;
    public String e;
    public boolean f;
    public n4 g;
    public boolean h;
    public b5 i;
    public g5 j;
    public boolean k;
    public boolean l;
    public f5 m;
    public m4 n;
    public g9 o;
    public w4 p;
    public final Regex q;
    public final Regex r;

    public d5(Context context, c ad) {
        MutableContextWrapper mutableContext = new MutableContextWrapper(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(mutableContext, "mutableContext");
        super(mutableContext);
        this.f7280a = ad;
        this.b = mutableContext;
        boolean z = true;
        this.c = true;
        this.e = "loading";
        this.g = new n4(this);
        this.i = new e0(context, this);
        this.j = new g5(this);
        this.n = m4.f7354a;
        this.o = g9.f7309a;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ad, "ad");
        z zVar = new z(context);
        r8 r8Var = new r8(zVar);
        Intrinsics.checkNotNullParameter(ad, "<this>");
        if (!Intrinsics.areEqual(ad.d, "portrait") && !Intrinsics.areEqual(ad.d, "landscape")) {
            z = false;
        }
        k6 k6Var = new k6(zVar, z);
        this.p = new w4(r8Var, new k3(zVar, k6Var, ad), new c1(), k6Var);
        this.q = new Regex("bunaZiua");
        this.r = new Regex("ogyOnAdLoaded");
        setAdUnit(ad.n);
        setWebViewClient(this.j);
    }

    private final void setAdUnit(p pVar) {
        this.j.f7289a = pVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch("io.presage", this, me);
        return super.dispatchTouchEvent(me);
    }

    public final String getAdState() {
        return this.e;
    }

    public final f5 getClientAdapter() {
        return this.m;
    }

    public final boolean getContainsMraid() {
        return this.h;
    }

    public final n4 getMraidCommandExecutor() {
        n4 n4Var = this.g;
        return n4Var == null ? new n4(this) : n4Var;
    }

    public final b5 getMraidUrlHandler() {
        return this.i;
    }

    public final g5 getMraidWebViewClient() {
        return this.j;
    }

    public final boolean getShowSdkCloseButton() {
        return this.c;
    }

    public final p9 getVisibilityChangedListener() {
        return this.d;
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.o.getClass();
        Activity activity = g9.b.get();
        if (activity == null) {
            return;
        }
        this.b.setBaseContext(activity);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MutableContextWrapper mutableContextWrapper = this.b;
        mutableContextWrapper.setBaseContext(mutableContextWrapper.getBaseContext().getApplicationContext());
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
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
        p9 p9Var = this.d;
        if (p9Var != null) {
            p9Var.a();
        }
        super.onVisibilityChanged(changedView, i);
    }

    public final void setAdState(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.e = str;
    }

    public final void setClientAdapter(f5 f5Var) {
        this.m = f5Var;
        this.j.f = f5Var;
    }

    public final void setContainsMraid(boolean z) {
        this.h = z;
    }

    public final void setDestroyed(boolean z) {
        this.f = z;
    }

    public final void setMraidCommandExecutor(n4 mraidCommandExecutor) {
        Intrinsics.checkNotNullParameter(mraidCommandExecutor, "mraidCommandExecutor");
        this.g = mraidCommandExecutor;
    }

    public final void setMraidUrlHandler(b5 b5Var) {
        Intrinsics.checkNotNullParameter(b5Var, "<set-?>");
        this.i = b5Var;
    }

    public final void setMultiBrowserOpened(boolean z) {
        this.l = z;
    }

    public final void setOnVisibilityChangedListener(p9 visibilityListener) {
        Intrinsics.checkNotNullParameter(visibilityListener, "visibilityListener");
        this.d = visibilityListener;
    }

    public final void setResumed(boolean z) {
        this.k = z;
    }

    public final void setShowSdkCloseButton(boolean z) {
        this.c = z;
    }

    public final void setTestCacheStore(m4 mraidCacheStore) {
        Intrinsics.checkNotNullParameter(mraidCacheStore, "mraidCacheStore");
        this.n = mraidCacheStore;
    }

    public final void setTestMraidLifecycle(w4 mraidLifecycle) {
        Intrinsics.checkNotNullParameter(mraidLifecycle, "mraidLifecycle");
        this.p = mraidLifecycle;
    }

    public final void setTestMraidViewClientWrapper(g5 mraidWebViewClientWrapper) {
        Intrinsics.checkNotNullParameter(mraidWebViewClientWrapper, "mraidWebViewClientWrapper");
        this.j = mraidWebViewClientWrapper;
    }

    public final void setTestTopActivityMonitor(g9 topActivityMonitor) {
        Intrinsics.checkNotNullParameter(topActivityMonitor, "topActivityMonitor");
        this.o = topActivityMonitor;
    }

    public final void setVisibilityChangedListener(p9 p9Var) {
        this.d = p9Var;
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        if (!Intrinsics.areEqual(this.j, client)) {
            new IllegalAccessError("Cannot change the webview client for MraidWebView");
            u3.f7411a.getClass();
        }
        super.setWebViewClient(client);
    }

    @Override // android.view.View
    public final String toString() {
        return "MraidWebView>> " + Integer.toHexString(System.identityHashCode(this));
    }
}
