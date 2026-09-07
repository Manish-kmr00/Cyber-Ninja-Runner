package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.ViewTreeObserver;
import com.monetization.ads.nativeads.CustomizableMediaView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class kx0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f9457a;
    private final lx0 b;
    private boolean c;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ kx0(Context context, o3 o3Var) {
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this(context, o3Var, new lx0(applicationContext, o3Var));
    }

    public kx0(Context context, o3 adConfiguration, lx0 mediaViewSizeInfoController) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(mediaViewSizeInfoController, "mediaViewSizeInfoController");
        this.f9457a = adConfiguration;
        this.b = mediaViewSizeInfoController;
        this.c = true;
    }

    public final void a(CustomizableMediaView mediaView, dx0.a type) {
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
        Intrinsics.checkNotNullParameter(type, "type");
        if (this.c) {
            if (this.f9457a.b() == qs.g) {
                oh2.a(mediaView, new a(mediaView, type));
            }
            this.c = false;
        }
    }

    public static final class a implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ CustomizableMediaView b;
        final /* synthetic */ dx0.a c;

        a(CustomizableMediaView customizableMediaView, dx0.a aVar) {
            this.b = customizableMediaView;
            this.c = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            kx0.this.b.a(this.b, this.c.a());
            return false;
        }
    }
}
