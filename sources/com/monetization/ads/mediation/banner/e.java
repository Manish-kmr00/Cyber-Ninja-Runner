package com.monetization.ads.mediation.banner;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import com.yandex.mobile.ads.impl.op0;
import com.yandex.mobile.ads.impl.rg2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f7224a;
    final /* synthetic */ d.a b;
    final /* synthetic */ d c;

    e(d dVar, View view, d.a aVar) {
        this.f7224a = view;
        this.b = aVar;
        this.c = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        rg2.a(d.a(this$0), false);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        String str = "onPreDraw(), clazz = " + this;
        op0.d(new Object[0]);
        if (!this.f7224a.isShown()) {
            return true;
        }
        this.f7224a.getViewTreeObserver().removeOnPreDrawListener(this);
        this.b.a();
        Handler handler = this.c.b;
        final d dVar = this.c;
        handler.postDelayed(new Runnable() { // from class: com.monetization.ads.mediation.banner.e$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                e.a(dVar);
            }
        }, 50L);
        return true;
    }
}
