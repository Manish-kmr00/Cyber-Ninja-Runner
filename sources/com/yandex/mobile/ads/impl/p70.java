package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.yandex.mobile.ads.impl.qh2.a;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes5.dex */
public final class p70<T extends View & qh2.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f9900a;
    private final n70 b;
    private final we1 c;
    private final Handler d;
    private a e;

    public static final class a<T extends View & qh2.a> implements Runnable {
        static final /* synthetic */ KProperty<Object>[] f = {ta.a(a.class, "exposureUpdateListenerReference", "getExposureUpdateListenerReference()Lcom/monetization/ads/base/webview/mraid/exposure/OnExposureUpdateListener;", 0), ta.a(a.class, "viewReference", "getViewReference()Landroid/view/View;", 0)};
        private final Handler b;
        private final n70 c;
        private final zn1 d;
        private final zn1 e;

        public a(Handler handler, View view, n70 exposureProvider, we1 exposureUpdateListener) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(exposureUpdateListener, "exposureUpdateListener");
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(exposureProvider, "exposureProvider");
            this.b = handler;
            this.c = exposureProvider;
            this.d = ao1.a(exposureUpdateListener);
            this.e = ao1.a(view);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            zn1 zn1Var = this.e;
            KProperty<?>[] kPropertyArr = f;
            View view = (View) zn1Var.getValue(this, kPropertyArr[1]);
            we1 we1Var = (we1) this.d.getValue(this, kPropertyArr[0]);
            if (view == null || we1Var == null) {
                return;
            }
            we1Var.a(this.c.a(view));
            this.b.postDelayed(this, 200L);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public p70(Handler handler, View view, n70 exposureProvider, we1 listener) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(exposureProvider, "exposureProvider");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.f9900a = view;
        this.b = exposureProvider;
        this.c = listener;
        this.d = handler;
    }

    public /* synthetic */ p70(View view, n70 n70Var, we1 we1Var) {
        this(new Handler(Looper.getMainLooper()), view, n70Var, we1Var);
    }

    public final void a() {
        if (this.e == null) {
            a aVar = new a(this.d, this.f9900a, this.b, this.c);
            this.e = aVar;
            this.d.post(aVar);
        }
    }

    public final void b() {
        this.d.removeCallbacksAndMessages(null);
        this.e = null;
    }
}
