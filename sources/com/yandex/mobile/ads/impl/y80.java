package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class y80 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final dt0 f10711a;
    private final Handler b;
    private final LinkedHashMap c;
    private boolean d;

    public /* synthetic */ y80() {
        this(new dt0(), new Handler(Looper.getMainLooper()));
    }

    public y80(dt0 mainThreadExecutor, Handler handler) {
        Intrinsics.checkNotNullParameter(mainThreadExecutor, "mainThreadExecutor");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.f10711a = mainThreadExecutor;
        this.b = handler;
        this.c = new LinkedHashMap();
    }

    public final void a(View feedAdView, int i) {
        Intrinsics.checkNotNullParameter(feedAdView, "feedAdView");
        this.c.put(feedAdView, Integer.valueOf(i));
    }

    public static final class a implements Runnable {
        final /* synthetic */ x80 c;

        a(x80 x80Var) {
            this.c = x80Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LinkedHashMap linkedHashMap = y80.this.c;
            x80 x80Var = this.c;
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                View view = (View) entry.getKey();
                int iIntValue = ((Number) entry.getValue()).intValue();
                if (oh2.a(view) >= 1) {
                    x80Var.a(iIntValue);
                }
            }
            y80.this.b.postDelayed(this, 200L);
        }
    }

    public final void a(View feedAdView) {
        Intrinsics.checkNotNullParameter(feedAdView, "feedAdView");
        this.c.remove(feedAdView);
    }

    public final void a(x80 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.d) {
            return;
        }
        this.d = true;
        this.f10711a.a(new a(listener));
    }

    public final void a() {
        this.c.clear();
        this.b.removeCallbacksAndMessages(null);
        this.d = false;
    }
}
