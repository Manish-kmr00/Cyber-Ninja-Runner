package com.yandex.mobile.ads.impl;

import android.app.Dialog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class sb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Dialog f10192a;
    private final vb b;

    public sb(Dialog dialog, vb adtuneOptOutWebView) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Intrinsics.checkNotNullParameter(adtuneOptOutWebView, "adtuneOptOutWebView");
        this.f10192a = dialog;
        this.b = adtuneOptOutWebView;
    }

    public final void a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.b.setAdtuneWebViewListener(new a());
        this.b.loadUrl(url);
        this.f10192a.show();
    }

    private final class a implements xb {
        public a() {
        }

        @Override // com.yandex.mobile.ads.impl.xb
        public final void a() {
            k10.a(sb.this.f10192a);
        }
    }
}
