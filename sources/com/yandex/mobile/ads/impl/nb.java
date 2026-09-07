package com.yandex.mobile.ads.impl;

import android.app.Dialog;
import android.os.Handler;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class nb {
    private static final long f = TimeUnit.SECONDS.toMillis(5);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Dialog f9714a;
    private final bc b;
    private final u50 c;
    private final bf1 d;
    private final Handler e;

    public nb(Dialog dialog, bc adtuneWebView, u50 eventListenerController, bf1 openUrlHandler, Handler handler) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Intrinsics.checkNotNullParameter(adtuneWebView, "adtuneWebView");
        Intrinsics.checkNotNullParameter(eventListenerController, "eventListenerController");
        Intrinsics.checkNotNullParameter(openUrlHandler, "openUrlHandler");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.f9714a = dialog;
        this.b = adtuneWebView;
        this.c = eventListenerController;
        this.d = openUrlHandler;
        this.e = handler;
    }

    public static final void d(nb nbVar) {
        nbVar.e.removeCallbacksAndMessages(null);
    }

    public final void a(String url, String optOutUrl) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(optOutUrl, "optOutUrl");
        this.b.setAdtuneWebViewListener(new a());
        this.b.setOptOutUrl(optOutUrl);
        this.b.loadUrl(url);
        this.e.postDelayed(new b(), f);
        this.f9714a.show();
    }

    private final class a implements ec {
        @Override // com.yandex.mobile.ads.impl.ec
        public final void a(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            nb.this.d.a(url);
        }

        public a() {
        }

        @Override // com.yandex.mobile.ads.impl.ec
        public final void b() {
            nb.this.c.a();
            k10.a(nb.this.f9714a);
        }

        @Override // com.yandex.mobile.ads.impl.ec
        public final void a() {
            nb.d(nb.this);
        }
    }

    private final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            k10.a(nb.this.f9714a);
        }
    }
}
