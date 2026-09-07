package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class es1<V extends ViewGroup> implements y00<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o8<?> f8826a;
    private final e1 b;
    private final wr c;
    private final x41 d;
    private final j91 e;
    private final y42 f;
    private final y20 g;
    private final up h;
    private vc0 i;
    private es1<V>.b j;

    public es1(o8 adResponse, e1 adActivityEventController, wr contentCloseListener, z41 nativeAdControlViewProvider, j91 nativeMediaContent, y42 timeProviderContainer, y20 y20Var, up closeControllerProvider) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adActivityEventController, "adActivityEventController");
        Intrinsics.checkNotNullParameter(contentCloseListener, "contentCloseListener");
        Intrinsics.checkNotNullParameter(nativeAdControlViewProvider, "nativeAdControlViewProvider");
        Intrinsics.checkNotNullParameter(nativeMediaContent, "nativeMediaContent");
        Intrinsics.checkNotNullParameter(timeProviderContainer, "timeProviderContainer");
        Intrinsics.checkNotNullParameter(closeControllerProvider, "closeControllerProvider");
        this.f8826a = adResponse;
        this.b = adActivityEventController;
        this.c = contentCloseListener;
        this.d = nativeAdControlViewProvider;
        this.e = nativeMediaContent;
        this.f = timeProviderContainer;
        this.g = y20Var;
        this.h = closeControllerProvider;
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void a(V container) {
        vc0 k81Var;
        Intrinsics.checkNotNullParameter(container, "container");
        View viewC = this.d.c(container);
        if (viewC != null) {
            es1<V>.b bVar = new b();
            this.b.a(bVar);
            this.j = bVar;
            Context context = viewC.getContext();
            int i = iw1.l;
            iw1 iw1VarA = iw1.a.a();
            Intrinsics.checkNotNull(context);
            cu1 cu1VarA = iw1VarA.a(context);
            boolean z = false;
            boolean z2 = cu1VarA != null && cu1VarA.x0();
            if (Intrinsics.areEqual(d10.DIV_KIT.a(), this.f8826a.w()) && z2) {
                z = true;
            }
            if (!z) {
                viewC.setOnClickListener(new a(this.c));
            }
            viewC.setVisibility(8);
            c closeShowListener = new c(viewC, new WeakReference(viewC));
            up upVar = this.h;
            o8<?> adResponse = this.f8826a;
            j91 nativeMediaContent = this.e;
            y42 timeProviderContainer = this.f;
            y20 y20Var = this.g;
            upVar.getClass();
            Intrinsics.checkNotNullParameter(adResponse, "adResponse");
            Intrinsics.checkNotNullParameter(closeShowListener, "closeShowListener");
            Intrinsics.checkNotNullParameter(nativeMediaContent, "nativeMediaContent");
            Intrinsics.checkNotNullParameter(timeProviderContainer, "timeProviderContainer");
            za1 za1VarA = nativeMediaContent.a();
            ec1 ec1VarB = nativeMediaContent.b();
            vc0 vc0Var = null;
            if (Intrinsics.areEqual(y20Var != null ? y20Var.e() : null, e10.d.a()) && timeProviderContainer.b().a()) {
                k81Var = new k81(adResponse, closeShowListener, timeProviderContainer);
            } else if (za1VarA != null) {
                k81Var = new xa1(adResponse, za1VarA, closeShowListener, timeProviderContainer, adResponse.u(), timeProviderContainer.c(), timeProviderContainer.b());
            } else if (ec1VarB != null) {
                k81Var = new cc1(ec1VarB, closeShowListener);
            } else {
                k81Var = timeProviderContainer.b().a() ? new k81(adResponse, closeShowListener, timeProviderContainer) : null;
            }
            if (k81Var != null) {
                k81Var.start();
                vc0Var = k81Var;
            }
            this.i = vc0Var;
        }
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void c() {
        es1<V>.b bVar = this.j;
        if (bVar != null) {
            this.b.b(bVar);
        }
        vc0 vc0Var = this.i;
        if (vc0Var != null) {
            vc0Var.invalidate();
        }
    }

    private final class b implements f1 {
        public b() {
        }

        @Override // com.yandex.mobile.ads.impl.f1
        public final void a() {
            vc0 vc0Var = ((es1) es1.this).i;
            if (vc0Var != null) {
                vc0Var.resume();
            }
        }

        @Override // com.yandex.mobile.ads.impl.f1
        public final void b() {
            vc0 vc0Var = ((es1) es1.this).i;
            if (vc0Var != null) {
                vc0Var.pause();
            }
        }
    }

    private static final class c implements xp {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<View> f8829a;

        public c(View closeView, WeakReference<View> closeViewReference) {
            Intrinsics.checkNotNullParameter(closeView, "closeView");
            Intrinsics.checkNotNullParameter(closeViewReference, "closeViewReference");
            this.f8829a = closeViewReference;
        }

        @Override // com.yandex.mobile.ads.impl.xp
        public final void a() {
            View view = this.f8829a.get();
            if (view != null) {
                view.setVisibility(0);
            }
        }
    }

    private static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final wr f8827a;

        public a(wr contentCloseListener) {
            Intrinsics.checkNotNullParameter(contentCloseListener, "contentCloseListener");
            this.f8827a = contentCloseListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f8827a.f();
        }
    }
}
