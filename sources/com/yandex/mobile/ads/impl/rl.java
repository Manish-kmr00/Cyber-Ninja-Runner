package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class rl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f10117a;

    public interface b {
        void a(Bitmap bitmap);
    }

    public final void a(Bitmap bitmap, yo1 listener) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f10117a.execute(new a(bitmap, listener, new Handler(Looper.getMainLooper()), new xl()));
    }

    public rl() {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        this.f10117a = executorServiceNewSingleThreadExecutor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class a implements Runnable {
        private final Bitmap b;
        private final b c;
        private final Handler d;
        private final xl e;

        public a(Bitmap originalBitmap, yo1 listener, Handler handler, xl blurredBitmapProvider) {
            Intrinsics.checkNotNullParameter(originalBitmap, "originalBitmap");
            Intrinsics.checkNotNullParameter(listener, "listener");
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(blurredBitmapProvider, "blurredBitmapProvider");
            this.b = originalBitmap;
            this.c = listener;
            this.d = handler;
            this.e = blurredBitmapProvider;
        }

        @Override // java.lang.Runnable
        public final void run() {
            xl xlVar = this.e;
            Bitmap bitmap = this.b;
            xlVar.getClass();
            a(xl.a(bitmap, 0.1d));
        }

        private final void a(final Bitmap bitmap) {
            this.d.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.rl$a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    rl.a.a(this.f$0, bitmap);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(a this$0, Bitmap blurredBitmap) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(blurredBitmap, "$blurredBitmap");
            this$0.c.a(blurredBitmap);
        }
    }
}
