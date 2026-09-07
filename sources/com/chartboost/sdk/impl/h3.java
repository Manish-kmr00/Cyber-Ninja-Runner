package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.internal.partials.ChartboostNetworkBridge;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0011\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\r\u0012\u001a\b\u0002\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/chartboost/sdk/impl/h3;", "Lcom/chartboost/sdk/impl/vb;", "Landroid/content/Context;", "context", "", "html", "Lcom/chartboost/sdk/impl/t3;", "callback", "Lcom/chartboost/sdk/impl/i6;", "impressionInterface", "baseExternalPathURL", "Lcom/chartboost/sdk/impl/l4;", "eventTracker", "Lkotlin/Function1;", "Lcom/chartboost/sdk/impl/p2;", "cbWebViewFactory", "Landroid/view/View;", "Landroid/webkit/WebChromeClient;", "cbWebChromeClientFactory", "Lkotlin/Function2;", "Lcom/chartboost/sdk/impl/s3;", "cbWebViewClientFactory", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/chartboost/sdk/impl/t3;Lcom/chartboost/sdk/impl/i6;Ljava/lang/String;Lcom/chartboost/sdk/impl/l4;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public class h3 extends vb {

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/content/Context;", "it", "Lcom/chartboost/sdk/impl/p2;", "a", "(Landroid/content/Context;)Lcom/chartboost/sdk/impl/p2;"}, k = 3, mv = {1, 8, 0})
    public static final class a extends Lambda implements Function1<Context, p2> {
        public static final a b = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final p2 invoke(Context it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new p2(it);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "Landroid/webkit/WebChromeClient;", "a", "(Landroid/view/View;)Landroid/webkit/WebChromeClient;"}, k = 3, mv = {1, 8, 0})
    public static final class b extends Lambda implements Function1<View, WebChromeClient> {
        public static final b b = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final WebChromeClient invoke(View it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new WebChromeClient();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/chartboost/sdk/impl/t3;", "cb", "Lcom/chartboost/sdk/impl/l4;", ApsMetricsDataMap.APSMETRICS_FIELD_ENDTIME, "Lcom/chartboost/sdk/impl/s3;", "a", "(Lcom/chartboost/sdk/impl/t3;Lcom/chartboost/sdk/impl/l4;)Lcom/chartboost/sdk/impl/s3;"}, k = 3, mv = {1, 8, 0})
    public static final class c extends Lambda implements Function2<t3, l4, s3> {
        public final /* synthetic */ i6 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(i6 i6Var) {
            super(2);
            this.b = i6Var;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final s3 invoke(t3 cb, l4 et) {
            Intrinsics.checkNotNullParameter(cb, "cb");
            Intrinsics.checkNotNullParameter(et, "et");
            return new s3(cb, et, this.b, y2.b.d().b().get());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h3(Context context, String html, t3 callback, i6 impressionInterface, String str, l4 eventTracker, Function1<? super Context, ? extends p2> cbWebViewFactory, Function1<? super View, ? extends WebChromeClient> cbWebChromeClientFactory, Function2<? super t3, ? super l4, ? extends s3> cbWebViewClientFactory) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(html, "html");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(impressionInterface, "impressionInterface");
        Intrinsics.checkNotNullParameter(eventTracker, "eventTracker");
        Intrinsics.checkNotNullParameter(cbWebViewFactory, "cbWebViewFactory");
        Intrinsics.checkNotNullParameter(cbWebChromeClientFactory, "cbWebChromeClientFactory");
        Intrinsics.checkNotNullParameter(cbWebViewClientFactory, "cbWebViewClientFactory");
        setFocusable(false);
        d5 d5VarA = d5.a();
        setWebViewContainer((RelativeLayout) d5VarA.a(new RelativeLayout(context)));
        setWebView(cbWebViewFactory.invoke(context));
        ab.b.a(context);
        try {
            WebView.setWebContentsDebuggingEnabled(false);
        } catch (RuntimeException e) {
            b7.e("Exception while enabling webview debugging", e);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        p2 webView = getWebView();
        if (webView != null) {
            webView.getSettings().setSupportZoom(false);
            webView.setLayoutParams(layoutParams);
            webView.setBackgroundColor(0);
            webView.setWebViewClient((WebViewClient) d5VarA.a(cbWebViewClientFactory.invoke(callback, eventTracker)));
            RelativeLayout webViewContainer = getWebViewContainer();
            if (webViewContainer != null) {
                webViewContainer.setLayoutParams(layoutParams);
                webView.setWebChromeClient(cbWebChromeClientFactory.invoke(webViewContainer));
                webViewContainer.addView(webView);
            }
            ChartboostNetworkBridge.webviewLoadDataWithBaseURL(webView, str, html, POBCommonConstants.CONTENT_TYPE_HTML, com.json.cc.N, null);
        }
    }

    @Override // com.chartboost.sdk.impl.vb, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.c, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.chartboost.sdk.impl.vb, android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public /* synthetic */ h3(Context context, String str, t3 t3Var, i6 i6Var, String str2, l4 l4Var, Function1 function1, Function1 function2, Function2 function3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, t3Var, i6Var, str2, l4Var, (i & 64) != 0 ? a.b : function1, (i & 128) != 0 ? b.b : function2, (i & 256) != 0 ? new c(i6Var) : function3);
    }
}
