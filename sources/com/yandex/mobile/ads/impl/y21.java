package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class y21 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final at1 f10694a;
    private final dt0 b;

    public interface a {
        void a();
    }

    public final void a(final Context context, final su0 media, final a listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(media, "media");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.b.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.y21$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                y21.a(context, media, listener, this);
            }
        });
    }

    public /* synthetic */ y21() {
        this(new at1());
    }

    public y21(at1 safeMraidWebViewFactory) {
        Intrinsics.checkNotNullParameter(safeMraidWebViewFactory, "safeMraidWebViewFactory");
        this.f10694a = safeMraidWebViewFactory;
        this.b = new dt0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Context context, su0 media, a listener, y21 this$0) {
        s21 s21Var;
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(media, "$media");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        z21 z21VarA = z21.c.a(context);
        String strB = media.b();
        if (!z21VarA.b() && !z21VarA.a(media) && strB != null) {
            this$0.f10694a.getClass();
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                s21Var = new s21(context);
            } catch (Throwable unused) {
                s21Var = null;
            }
            if (s21Var != null) {
                s21Var.setPreloadListener(new b(z21VarA, listener, media));
                z21VarA.a(s21Var, media);
                s21Var.c(strB);
                return;
            }
            listener.a();
            return;
        }
        listener.a();
    }

    public static final class b implements s21.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final z21 f10695a;
        private final a b;
        private final su0 c;

        public b(z21 mraidWebViewPool, a listener, su0 media) {
            Intrinsics.checkNotNullParameter(mraidWebViewPool, "mraidWebViewPool");
            Intrinsics.checkNotNullParameter(listener, "listener");
            Intrinsics.checkNotNullParameter(media, "media");
            this.f10695a = mraidWebViewPool;
            this.b = listener;
            this.c = media;
        }

        @Override // com.yandex.mobile.ads.impl.s21.a
        public final void b() {
            this.b.a();
        }

        @Override // com.yandex.mobile.ads.impl.s21.a
        public final void a() {
            this.f10695a.b(this.c);
            this.b.a();
        }
    }
}
