package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class lp0 {

    public static final class a implements kp0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final zi f9551a;

        public a(zi viewController) {
            Intrinsics.checkNotNullParameter(viewController, "viewController");
            this.f9551a = viewController;
        }

        @Override // com.yandex.mobile.ads.impl.kp0
        public final void a(Context context, View view) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(view, "view");
        }

        @Override // com.yandex.mobile.ads.impl.kp0
        public final void b(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            int i = oa.b;
            if (oa.a((qo) this.f9551a)) {
                return;
            }
            this.f9551a.v();
        }

        @Override // com.yandex.mobile.ads.impl.kp0
        public final void a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            int i = oa.b;
            if (oa.a((qo) this.f9551a)) {
                return;
            }
            this.f9551a.w();
        }
    }

    public static kp0 a(View view, zi controller) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(controller, "controller");
        return view.isInEditMode() ? new b() : new a(controller);
    }

    public static final class b implements kp0 {
        @Override // com.yandex.mobile.ads.impl.kp0
        public final void a(Context context, View view) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(view, "view");
            view.setVisibility(0);
            view.setMinimumHeight(oh2.a(context, 50.0f));
        }

        @Override // com.yandex.mobile.ads.impl.kp0
        public final void b(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
        }

        @Override // com.yandex.mobile.ads.impl.kp0
        public final void a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
        }
    }
}
