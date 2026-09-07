package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Bitmap;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class gj0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f9009a;
    private final pj0 b;
    private final lj0 c;

    public interface a {
        boolean a();
    }

    public interface b {
        void a(Bitmap bitmap);
    }

    public /* synthetic */ gj0(Context context, a aVar, pj0 pj0Var) {
        this(context, aVar, pj0Var, ed1.c.a(context).b());
    }

    public gj0(Context context, a configuration, pj0 imageProvider, lj0 imageLoader) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        this.f9009a = configuration;
        this.b = imageProvider;
        this.c = imageLoader;
    }

    public final void a(uj0 imageValue, b listener) {
        Intrinsics.checkNotNullParameter(imageValue, "imageValue");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Bitmap bitmapB = this.b.b(imageValue);
        if (bitmapB != null) {
            listener.a(bitmapB);
            return;
        }
        listener.a(this.b.a(imageValue));
        if (this.f9009a.a()) {
            String strF = imageValue.f();
            int iA = imageValue.a();
            this.c.a(strF, new c(strF, listener), imageValue.g(), iA);
        }
    }

    public static final class c implements lj0.d {
        final /* synthetic */ String b;
        final /* synthetic */ b c;

        c(String str, b bVar) {
            this.b = str;
            this.c = bVar;
        }

        @Override // com.yandex.mobile.ads.impl.qq1.a
        public final void a(ki2 ki2Var) {
        }

        @Override // com.yandex.mobile.ads.impl.lj0.d
        public final void a(lj0.c cVar, boolean z) {
            Bitmap bitmapB = cVar.b();
            if (bitmapB != null) {
                gj0 gj0Var = gj0.this;
                String str = this.b;
                b bVar = this.c;
                gj0Var.b.a(MapsKt.mapOf(TuplesKt.to(str, bitmapB)));
                bVar.a(bitmapB);
            }
        }
    }
}
