package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0011\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/chartboost/sdk/impl/i9;", "Lcom/chartboost/sdk/impl/h3;", "Landroid/content/Context;", "context", "", "html", "Lcom/chartboost/sdk/impl/t3;", "callback", "Lcom/chartboost/sdk/impl/i6;", "impressionInterface", "baseExternalPathURL", "Lcom/chartboost/sdk/impl/g7;", "nativeBridgeCommand", "Lcom/chartboost/sdk/impl/xb;", "webViewCorsErrorHandler", "Lcom/chartboost/sdk/impl/l4;", "eventTracker", "Lkotlin/Function1;", "Lcom/chartboost/sdk/impl/p2;", "cbWebViewFactory", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/chartboost/sdk/impl/t3;Lcom/chartboost/sdk/impl/i6;Ljava/lang/String;Lcom/chartboost/sdk/impl/g7;Lcom/chartboost/sdk/impl/xb;Lcom/chartboost/sdk/impl/l4;Lkotlin/jvm/functions/Function1;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public class i9 extends h3 {

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

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "container", "Landroid/webkit/WebChromeClient;", "a", "(Landroid/view/View;)Landroid/webkit/WebChromeClient;"}, k = 3, mv = {1, 8, 0})
    public static final class b extends Lambda implements Function1<View, WebChromeClient> {
        public final /* synthetic */ g7 b;
        public final /* synthetic */ xb c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(g7 g7Var, xb xbVar) {
            super(1);
            this.b = g7Var;
            this.c = xbVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final WebChromeClient invoke(View container) {
            Intrinsics.checkNotNullParameter(container, "container");
            return new j2(container, this.b, this.c);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i9(Context context, String html, t3 callback, i6 impressionInterface, String str, g7 nativeBridgeCommand, xb webViewCorsErrorHandler, l4 eventTracker, Function1<? super Context, ? extends p2> cbWebViewFactory) {
        super(context, html, callback, impressionInterface, str, eventTracker, cbWebViewFactory, new b(nativeBridgeCommand, webViewCorsErrorHandler), null, 256, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(html, "html");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(impressionInterface, "impressionInterface");
        Intrinsics.checkNotNullParameter(nativeBridgeCommand, "nativeBridgeCommand");
        Intrinsics.checkNotNullParameter(webViewCorsErrorHandler, "webViewCorsErrorHandler");
        Intrinsics.checkNotNullParameter(eventTracker, "eventTracker");
        Intrinsics.checkNotNullParameter(cbWebViewFactory, "cbWebViewFactory");
    }

    @Override // com.chartboost.sdk.impl.h3, com.chartboost.sdk.impl.vb, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.c, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.chartboost.sdk.impl.h3, com.chartboost.sdk.impl.vb, android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public /* synthetic */ i9(Context context, String str, t3 t3Var, i6 i6Var, String str2, g7 g7Var, xb xbVar, l4 l4Var, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, t3Var, i6Var, str2, g7Var, (i & 64) != 0 ? new xb() : xbVar, l4Var, (i & 256) != 0 ? a.b : function1);
    }
}
