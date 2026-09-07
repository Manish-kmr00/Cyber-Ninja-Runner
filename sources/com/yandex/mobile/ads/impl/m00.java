package com.yandex.mobile.ads.impl;

import android.view.View;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes13.dex */
public final class m00 {
    static final /* synthetic */ KProperty<Object>[] e = {ta.a(m00.class, "weakSkipButton", "getWeakSkipButton()Landroid/view/View;", 0)};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ez1 f9584a;
    private final long b;
    private final ig1 c;
    private final zn1 d;

    public m00(View skipButton, ez1 skipAppearanceController, long j, ig1 pausableTimer) {
        Intrinsics.checkNotNullParameter(skipButton, "skipButton");
        Intrinsics.checkNotNullParameter(skipAppearanceController, "skipAppearanceController");
        Intrinsics.checkNotNullParameter(pausableTimer, "pausableTimer");
        this.f9584a = skipAppearanceController;
        this.b = j;
        this.c = pausableTimer;
        this.d = ao1.a(skipButton);
        skipAppearanceController.a(skipButton);
    }

    public final void b() {
        View view = (View) this.d.getValue(this, e[0]);
        if (view != null) {
            a aVar = new a(view, this.f9584a);
            long j = this.b;
            if (j == 0) {
                this.f9584a.b(view);
            } else {
                this.c.a(j, aVar);
            }
        }
    }

    public final void c() {
        this.c.pause();
    }

    public final void d() {
        this.c.resume();
    }

    public final void a() {
        this.c.invalidate();
    }

    private static final class a implements kg1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ez1 f9585a;
        private final WeakReference<View> b;

        public a(View view, ez1 skipAppearanceController) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(skipAppearanceController, "skipAppearanceController");
            this.f9585a = skipAppearanceController;
            this.b = new WeakReference<>(view);
        }

        @Override // com.yandex.mobile.ads.impl.kg1
        public final void a() {
            View view = this.b.get();
            if (view != null) {
                this.f9585a.b(view);
            }
        }
    }
}
