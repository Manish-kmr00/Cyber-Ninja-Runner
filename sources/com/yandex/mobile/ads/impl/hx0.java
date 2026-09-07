package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.widget.FrameLayout;
import com.monetization.ads.nativeads.CustomizableMediaView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class hx0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final xw0 f9145a;
    private final x21 b;

    public final tv1 a(CustomizableMediaView mediaView, su0 media, mk0 impressionEventsObservable, ec1 nativeWebViewController, kx0 mediaViewRenderController) throws lj2 {
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
        Intrinsics.checkNotNullParameter(media, "media");
        Intrinsics.checkNotNullParameter(impressionEventsObservable, "impressionEventsObservable");
        Intrinsics.checkNotNullParameter(nativeWebViewController, "nativeWebViewController");
        Intrinsics.checkNotNullParameter(mediaViewRenderController, "mediaViewRenderController");
        Context context = mediaView.getContext();
        x21 x21Var = this.b;
        Intrinsics.checkNotNull(context);
        x21Var.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(media, "media");
        Intrinsics.checkNotNullParameter(impressionEventsObservable, "impressionEventsObservable");
        Intrinsics.checkNotNullParameter(nativeWebViewController, "nativeWebViewController");
        s21 mraidWebView = z21.c.a(context).b(media);
        if (mraidWebView == null) {
            try {
                mraidWebView = new s21(context);
            } catch (Throwable unused) {
                throw new lj2();
            }
        }
        j21 j21VarK = mraidWebView.k();
        j21VarK.a(impressionEventsObservable);
        j21VarK.a((o11) nativeWebViewController);
        j21VarK.a((ve1) nativeWebViewController);
        this.f9145a.getClass();
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
        Intrinsics.checkNotNullParameter(mraidWebView, "mraidWebView");
        Context context2 = mediaView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        if (!u80.a(context2, t80.e)) {
            mediaView.removeAllViews();
        }
        mediaView.addView(mraidWebView, new FrameLayout.LayoutParams(-1, -1));
        u21 u21Var = new u21(mraidWebView);
        return new tv1(mediaView, u21Var, mediaViewRenderController, new og2(u21Var));
    }

    public /* synthetic */ hx0() {
        this(new xw0(), new x21());
    }

    public hx0(xw0 mediaSubViewBinder, x21 mraidWebViewFactory) {
        Intrinsics.checkNotNullParameter(mediaSubViewBinder, "mediaSubViewBinder");
        Intrinsics.checkNotNullParameter(mraidWebViewFactory, "mraidWebViewFactory");
        this.f9145a = mediaSubViewBinder;
        this.b = mraidWebViewFactory;
    }
}
