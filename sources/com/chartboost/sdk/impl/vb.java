package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.MotionEvent;
import android.webkit.WebChromeClient;
import android.widget.RelativeLayout;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.internal.partials.ChartboostNetworkBridge;
import com.unity3d.ads.adplayer.AndroidWebViewClient;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R$\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u001a\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006'"}, d2 = {"Lcom/chartboost/sdk/impl/vb;", "Landroid/widget/RelativeLayout;", "", "a", "()V", "Lcom/chartboost/sdk/impl/p2;", "Lcom/chartboost/sdk/impl/p2;", "getWebView", "()Lcom/chartboost/sdk/impl/p2;", "setWebView", "(Lcom/chartboost/sdk/impl/p2;)V", "webView", "Landroid/webkit/WebChromeClient;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Landroid/webkit/WebChromeClient;", "getWebChromeClient", "()Landroid/webkit/WebChromeClient;", "setWebChromeClient", "(Landroid/webkit/WebChromeClient;)V", "webChromeClient", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Landroid/widget/RelativeLayout;", "getWebViewContainer", "()Landroid/widget/RelativeLayout;", "setWebViewContainer", "(Landroid/widget/RelativeLayout;)V", "webViewContainer", "Lcom/chartboost/sdk/impl/a8;", "d", "Lcom/chartboost/sdk/impl/a8;", "getLastOrientation", "()Lcom/chartboost/sdk/impl/a8;", "setLastOrientation", "(Lcom/chartboost/sdk/impl/a8;)V", "lastOrientation", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public abstract class vb extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public p2 webView;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public WebChromeClient webChromeClient;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public RelativeLayout webViewContainer;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public a8 lastOrientation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vb(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setFocusableInTouchMode(true);
        requestFocus();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.c, this, me);
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

    public final p2 getWebView() {
        return this.webView;
    }

    public final void setWebView(p2 p2Var) {
        this.webView = p2Var;
    }

    public final WebChromeClient getWebChromeClient() {
        return this.webChromeClient;
    }

    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.webChromeClient = webChromeClient;
    }

    public final RelativeLayout getWebViewContainer() {
        return this.webViewContainer;
    }

    public final void setWebViewContainer(RelativeLayout relativeLayout) {
        this.webViewContainer = relativeLayout;
    }

    public final a8 getLastOrientation() {
        return this.lastOrientation;
    }

    public final void setLastOrientation(a8 a8Var) {
        this.lastOrientation = a8Var;
    }

    public void a() {
        Unit unit;
        p2 p2Var = this.webView;
        if (p2Var == null) {
            b7.a("Webview is null on destroyWebview", (Throwable) null, 2, (Object) null);
            return;
        }
        RelativeLayout relativeLayout = this.webViewContainer;
        if (relativeLayout != null) {
            relativeLayout.removeView(p2Var);
            removeView(relativeLayout);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            b7.a("webViewContainer is null destroyWebview", (Throwable) null, 2, (Object) null);
        }
        p2 p2Var2 = this.webView;
        if (p2Var2 != null) {
            ChartboostNetworkBridge.webviewLoadUrl(p2Var2, AndroidWebViewClient.BLANK_PAGE);
            p2Var2.onPause();
            p2Var2.removeAllViews();
            p2Var2.destroy();
        }
        removeAllViews();
    }
}
