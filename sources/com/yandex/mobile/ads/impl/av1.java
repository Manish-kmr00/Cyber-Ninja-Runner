package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class av1 implements bv1<zu1> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8442a;
    private final uu1 b;
    private final o3 c;
    private zu1 d;

    public av1(Context context, uu1 sdkEnvironmentModule, o3 adConfiguration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        this.f8442a = context;
        this.b = sdkEnvironmentModule;
        this.c = adConfiguration;
    }

    public static final void a(av1 av1Var) {
        zu1 zu1Var = av1Var.d;
        if (zu1Var != null) {
            zu1Var.a((cs) null);
        }
        av1Var.d = null;
    }

    @Override // com.yandex.mobile.ads.impl.bv1
    public final void a() {
        zu1 zu1Var = this.d;
        if (zu1Var != null) {
            zu1Var.d();
        }
        zu1 zu1Var2 = this.d;
        if (zu1Var2 != null) {
            zu1Var2.a((cs) null);
        }
        this.d = null;
    }

    @Override // com.yandex.mobile.ads.impl.bv1
    public final void a(o8<String> adResponse, zy1 sizeInfo, String htmlResponse, dv1<zu1> creationListener) throws lj2 {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(sizeInfo, "sizeInfo");
        Intrinsics.checkNotNullParameter(htmlResponse, "htmlResponse");
        Intrinsics.checkNotNullParameter(creationListener, "creationListener");
        Context context = this.f8442a;
        uu1 uu1Var = this.b;
        o3 o3Var = this.c;
        t8 t8Var = new t8();
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        ed0 ed0Var = new ed0(applicationContext, uu1Var, o3Var, adResponse, t8Var);
        Context applicationContext2 = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
        zu1 zu1Var = new zu1(context, uu1Var, o3Var, adResponse, htmlResponse, t8Var, ed0Var, new id0(applicationContext2, o3Var, adResponse, t8Var), new uc0(), new wg0(), new pd0(uu1Var, uu1Var.c(), new od0(uu1Var.e())));
        this.d = zu1Var;
        zu1Var.a(new a(this, zu1Var, creationListener));
        zu1Var.h();
    }

    private final class a implements cs {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final zu1 f8443a;
        private final dv1<zu1> b;
        final /* synthetic */ av1 c;

        public a(av1 av1Var, zu1 fullscreenHtmlAd, dv1<zu1> creationListener) {
            Intrinsics.checkNotNullParameter(fullscreenHtmlAd, "fullscreenHtmlAd");
            Intrinsics.checkNotNullParameter(creationListener, "creationListener");
            this.c = av1Var;
            this.f8443a = fullscreenHtmlAd;
            this.b = creationListener;
        }

        @Override // com.yandex.mobile.ads.impl.cs
        public final void a(w3 adFetchRequestError) {
            Intrinsics.checkNotNullParameter(adFetchRequestError, "adFetchRequestError");
            av1.a(this.c);
            this.b.a(adFetchRequestError);
        }

        @Override // com.yandex.mobile.ads.impl.cs
        public final void a() {
            av1.a(this.c);
            this.b.a(this.f8443a);
        }
    }
}
