package com.yandex.mobile.ads.impl;

import android.app.Activity;
import android.content.res.Configuration;
import android.widget.RelativeLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f8464a;
    private final RelativeLayout b;
    private final m1 c;
    private final e1 d;
    private final mh2 e;

    public b1(Activity activity, RelativeLayout rootLayout, m1 adActivityPresentController, e1 adActivityEventController, mh2 tagCreator) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(rootLayout, "rootLayout");
        Intrinsics.checkNotNullParameter(adActivityPresentController, "adActivityPresentController");
        Intrinsics.checkNotNullParameter(adActivityEventController, "adActivityEventController");
        Intrinsics.checkNotNullParameter(tagCreator, "tagCreator");
        this.f8464a = activity;
        this.b = rootLayout;
        this.c = adActivityPresentController;
        this.d = adActivityEventController;
        this.e = tagCreator;
    }

    public final void a(Configuration config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.d.a(config);
    }

    public final void b() {
        this.c.g();
        this.c.c();
        RelativeLayout relativeLayout = this.b;
        this.e.getClass();
        relativeLayout.setTag(mh2.a("root_layout"));
        this.f8464a.setContentView(this.b);
    }

    public final void d() {
        this.c.b();
        this.d.a();
    }

    public final void e() {
        this.c.a();
        this.d.b();
    }

    public final boolean c() {
        return this.c.e();
    }

    public final void a() {
        this.c.onAdClosed();
        this.c.d();
        this.b.removeAllViews();
    }
}
