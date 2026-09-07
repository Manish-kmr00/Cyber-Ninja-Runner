package com.yandex.mobile.ads.impl;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class is implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g31 f9254a;
    private final c31 b;

    private is(g31 g31Var, c31 c31Var) {
        this.f9254a = g31Var;
        this.b = c31Var;
    }

    public /* synthetic */ is(g31 g31Var, c31 c31Var, int i) {
        this(g31Var, c31Var);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c31 c31Var = this.b;
        if (c31Var != null) {
            c31Var.a();
        }
        this.f9254a.b();
    }

    public static final class a extends is {
        private final n31 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(n31 multiBannerSwiper, g31 multiBannerEventTracker, c31 c31Var) {
            super(multiBannerEventTracker, c31Var, 0);
            Intrinsics.checkNotNullParameter(multiBannerSwiper, "multiBannerSwiper");
            Intrinsics.checkNotNullParameter(multiBannerEventTracker, "multiBannerEventTracker");
            this.c = multiBannerSwiper;
        }

        @Override // com.yandex.mobile.ads.impl.is, android.view.View.OnClickListener
        public final void onClick(View view) {
            this.c.b();
            super.onClick(view);
        }
    }

    public static final class b extends is {
        private final n31 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(n31 multiBannerSwiper, g31 multiBannerEventTracker, c31 c31Var) {
            super(multiBannerEventTracker, c31Var, 0);
            Intrinsics.checkNotNullParameter(multiBannerSwiper, "multiBannerSwiper");
            Intrinsics.checkNotNullParameter(multiBannerEventTracker, "multiBannerEventTracker");
            this.c = multiBannerSwiper;
        }

        @Override // com.yandex.mobile.ads.impl.is, android.view.View.OnClickListener
        public final void onClick(View view) {
            this.c.a();
            super.onClick(view);
        }
    }
}
