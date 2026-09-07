package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class x0 implements m1, h3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10609a;
    private final RelativeLayout b;
    private final j1 c;
    private final Window d;
    private final String e;
    private h3 f;
    private final LinearLayout g;
    private final TextView h;
    private final ProgressBar i;
    private final q82 j;

    public x0(Context context, RelativeLayout rootLayout, v1 adActivityListener, Window window, String browserUrl, h3 adBrowserView, LinearLayout controlPanel, TextView browserTitle, ProgressBar browserProgressBar, q82 urlViewerLauncher) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootLayout, "rootLayout");
        Intrinsics.checkNotNullParameter(adActivityListener, "adActivityListener");
        Intrinsics.checkNotNullParameter(window, "window");
        Intrinsics.checkNotNullParameter(browserUrl, "browserUrl");
        Intrinsics.checkNotNullParameter(adBrowserView, "adBrowserView");
        Intrinsics.checkNotNullParameter(controlPanel, "controlPanel");
        Intrinsics.checkNotNullParameter(browserTitle, "browserTitle");
        Intrinsics.checkNotNullParameter(browserProgressBar, "browserProgressBar");
        Intrinsics.checkNotNullParameter(urlViewerLauncher, "urlViewerLauncher");
        this.f10609a = context;
        this.b = rootLayout;
        this.c = adActivityListener;
        this.d = window;
        this.e = browserUrl;
        this.f = adBrowserView;
        this.g = controlPanel;
        this.h = browserTitle;
        this.i = browserProgressBar;
        this.j = urlViewerLauncher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(x0 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.c.a();
    }

    @Override // com.yandex.mobile.ads.impl.m1
    public final void g() {
        this.d.requestFeature(1);
        if (pa.a(16)) {
            this.d.getDecorView().setSystemUiVisibility(256);
        }
    }

    @Override // com.yandex.mobile.ads.impl.m1
    public final void c() {
        this.b.setBackgroundDrawable(g8.f8976a);
        LinearLayout linearLayout = this.g;
        ImageView imageViewB = h8.b(this.f10609a);
        ImageView imageViewA = h8.a(this.f10609a);
        a(imageViewB, imageViewA);
        linearLayout.addView(this.h, new LinearLayout.LayoutParams(0, -1, 1.0f));
        linearLayout.addView(imageViewB, new LinearLayout.LayoutParams(-2, -1));
        linearLayout.addView(imageViewA, new LinearLayout.LayoutParams(-2, -1));
        RelativeLayout relativeLayout = this.b;
        LinearLayout linearLayout2 = this.g;
        Context context = this.f10609a;
        Intrinsics.checkNotNullParameter(context, "context");
        i8 i8Var = i8.d;
        Intrinsics.checkNotNullParameter(context, "context");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, oh2.a(context, i8Var.a(context)));
        layoutParams.addRule(10);
        relativeLayout.addView(linearLayout2, layoutParams);
        Context context2 = this.f10609a;
        LinearLayout anchorView = this.g;
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, oh2.a(context2, 2.0f));
        layoutParams2.addRule(3, anchorView.getId());
        this.b.addView(this.i, layoutParams2);
        a(8);
        RelativeLayout relativeLayout2 = this.b;
        h3 h3Var = this.f;
        LinearLayout anchorView2 = this.g;
        Intrinsics.checkNotNullParameter(anchorView2, "anchorView");
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams3.addRule(3, anchorView2.getId());
        relativeLayout2.addView(h3Var, layoutParams3);
        this.f.loadUrl(this.e);
        this.c.a(6, null);
        op0.d(new Object[0]);
    }

    @Override // com.yandex.mobile.ads.impl.m1
    public final boolean e() {
        boolean z;
        if (this.f.canGoBack()) {
            h3 h3Var = this.f;
            if (h3Var.canGoBack()) {
                h3Var.goBack();
            }
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    @Override // com.yandex.mobile.ads.impl.m1
    public final void onAdClosed() {
        this.c.a(8, null);
    }

    @Override // com.yandex.mobile.ads.impl.m1
    public final void d() {
        this.f.d();
    }

    private final void a(ImageView imageView, ImageView imageView2) {
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.yandex.mobile.ads.impl.x0$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                x0.a(this.f$0, view);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.yandex.mobile.ads.impl.x0$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                x0.b(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(x0 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String url = this$0.f.getUrl();
        if (url != null) {
            this$0.j.a(this$0.f10609a, url);
        }
    }

    @Override // com.yandex.mobile.ads.impl.h3.c
    public final void b(WebView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        a(8);
    }

    @Override // com.yandex.mobile.ads.impl.m1
    public final void b() {
        this.f.e();
    }

    @Override // com.yandex.mobile.ads.impl.h3.c
    public final void a(WebView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        a(0);
    }

    @Override // com.yandex.mobile.ads.impl.h3.c
    public final void a(WebView view, int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        int i2 = i * 100;
        this.i.setProgress(i2);
        if (10000 > i2) {
            a(0);
        } else {
            this.h.setText(view.getTitle());
            a(8);
        }
    }

    @Override // com.yandex.mobile.ads.impl.m1
    public final void a() {
        this.f.f();
    }

    private final void a(int i) {
        if (i == 0 && this.i.getVisibility() != 0) {
            this.i.bringToFront();
            this.b.requestLayout();
            this.b.invalidate();
        }
        this.i.setVisibility(i);
    }
}
