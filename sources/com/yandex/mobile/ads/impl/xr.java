package com.yandex.mobile.ads.impl;

import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class xr<V extends ViewGroup> implements y00<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o8<?> f10673a;
    private final e1 b;
    private final k3 c;
    private final j91 d;
    private final y42 e;
    private final y20 f;
    private final zr g;
    private final qr0 h;
    private vc0 i;
    private f1 j;

    public /* synthetic */ xr(o8 o8Var, e1 e1Var, k3 k3Var, j91 j91Var, y42 y42Var, y20 y20Var) {
        this(o8Var, e1Var, k3Var, j91Var, y42Var, y20Var, new zr(), new qr0(0));
    }

    public xr(o8<?> adResponse, e1 adActivityEventController, k3 adCompleteListener, j91 nativeMediaContent, y42 timeProviderContainer, y20 y20Var, zr contentCompleteControllerProvider, qr0 progressListener) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adActivityEventController, "adActivityEventController");
        Intrinsics.checkNotNullParameter(adCompleteListener, "adCompleteListener");
        Intrinsics.checkNotNullParameter(nativeMediaContent, "nativeMediaContent");
        Intrinsics.checkNotNullParameter(timeProviderContainer, "timeProviderContainer");
        Intrinsics.checkNotNullParameter(contentCompleteControllerProvider, "contentCompleteControllerProvider");
        Intrinsics.checkNotNullParameter(progressListener, "progressListener");
        this.f10673a = adResponse;
        this.b = adActivityEventController;
        this.c = adCompleteListener;
        this.d = nativeMediaContent;
        this.e = timeProviderContainer;
        this.f = y20Var;
        this.g = contentCompleteControllerProvider;
        this.h = progressListener;
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void a(V container) {
        Intrinsics.checkNotNullParameter(container, "container");
        a aVar = new a();
        this.b.a(aVar);
        this.j = aVar;
        this.h.a(container);
        zr zrVar = this.g;
        o8<?> adResponse = this.f10673a;
        k3 adCompleteListener = this.c;
        j91 nativeMediaContent = this.d;
        y42 timeProviderContainer = this.e;
        y20 y20Var = this.f;
        qr0 progressListener = this.h;
        zrVar.getClass();
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adCompleteListener, "adCompleteListener");
        Intrinsics.checkNotNullParameter(nativeMediaContent, "nativeMediaContent");
        Intrinsics.checkNotNullParameter(timeProviderContainer, "timeProviderContainer");
        Intrinsics.checkNotNullParameter(progressListener, "progressListener");
        vc0 vc0VarA = new yr(adResponse, adCompleteListener, nativeMediaContent, timeProviderContainer, y20Var, progressListener).a();
        vc0VarA.start();
        this.i = vc0VarA;
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void c() {
        f1 f1Var = this.j;
        if (f1Var != null) {
            this.b.b(f1Var);
        }
        vc0 vc0Var = this.i;
        if (vc0Var != null) {
            vc0Var.invalidate();
        }
        this.h.b();
    }

    private final class a implements f1 {
        public a() {
        }

        @Override // com.yandex.mobile.ads.impl.f1
        public final void a() {
            vc0 vc0Var = ((xr) xr.this).i;
            if (vc0Var != null) {
                vc0Var.resume();
            }
        }

        @Override // com.yandex.mobile.ads.impl.f1
        public final void b() {
            vc0 vc0Var = ((xr) xr.this).i;
            if (vc0Var != null) {
                vc0Var.pause();
            }
        }
    }
}
