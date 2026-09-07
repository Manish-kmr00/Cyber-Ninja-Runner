package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class hj0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final lj0 f9102a;
    private final ed1.c b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final lj0 f9103a;
        private final Set<uj0> b;
        private final dk0 c;
        private final Handler d;
        private final AtomicInteger e;
        private final f01 f;

        public a(lj0 imageLoader, Set<uj0> imageValues, dk0 imagesFetchListener, Handler handler, AtomicInteger imageCounter, f01 memoryUtils) {
            Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
            Intrinsics.checkNotNullParameter(imageValues, "imageValues");
            Intrinsics.checkNotNullParameter(imagesFetchListener, "imagesFetchListener");
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(imageCounter, "imageCounter");
            Intrinsics.checkNotNullParameter(memoryUtils, "memoryUtils");
            this.f9103a = imageLoader;
            this.b = imageValues;
            this.c = imagesFetchListener;
            this.d = handler;
            this.e = imageCounter;
            this.f = memoryUtils;
        }

        public static final void a(a aVar, Map map) {
            if (aVar.e.decrementAndGet() == 0) {
                aVar.c.a(map);
            }
        }

        /* JADX INFO: renamed from: com.yandex.mobile.ads.impl.hj0$a$a, reason: collision with other inner class name */
        public static final class C0746a implements lj0.d {
            final /* synthetic */ Map<String, Bitmap> b;
            final /* synthetic */ uj0 c;

            C0746a(Map<String, Bitmap> map, uj0 uj0Var) {
                this.b = map;
                this.c = uj0Var;
            }

            @Override // com.yandex.mobile.ads.impl.qq1.a
            public final void a(ki2 error) {
                Intrinsics.checkNotNullParameter(error, "error");
                op0.a(error);
                a.a(a.this, this.b);
            }

            @Override // com.yandex.mobile.ads.impl.lj0.d
            public final void a(lj0.c response, boolean z) {
                Intrinsics.checkNotNullParameter(response, "response");
                String strF = this.c.f();
                Bitmap bitmapB = response.b();
                if (bitmapB != null) {
                    if (strF != null) {
                        this.b.put(strF, bitmapB);
                        a.this.c.a(strF, bitmapB);
                    }
                    a.a(a.this, this.b);
                }
            }
        }

        private final boolean a(uj0 uj0Var) {
            int iA = uj0Var.a();
            int iG = uj0Var.g();
            this.f.getClass();
            long jA = f01.a();
            float f = (iA * iG * 4) + 1048576.0f;
            if (jA >= f) {
                return true;
            }
            String str = "Not enough free memory to create bitmap. FreeMemory = " + jA + ", RequiredMemory = " + f;
            op0.d(new Object[0]);
            return false;
        }

        public final void a() {
            final HashMap map = new HashMap();
            for (final uj0 uj0Var : this.b) {
                final String strF = uj0Var.f();
                final int iA = uj0Var.a();
                final int iG = uj0Var.g();
                op0.e(strF);
                if (a(uj0Var)) {
                    this.d.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.hj0$a$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            hj0.a.a(this.f$0, strF, iG, iA, map, uj0Var);
                        }
                    });
                } else if (this.e.decrementAndGet() == 0) {
                    this.c.a(map);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(a this$0, String fetchUrl, int i, int i2, Map loadedImages, uj0 imageValue) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(fetchUrl, "$fetchUrl");
            Intrinsics.checkNotNullParameter(loadedImages, "$loadedImages");
            Intrinsics.checkNotNullParameter(imageValue, "$imageValue");
            this$0.f9103a.a(fetchUrl, this$0.new C0746a(loadedImages, imageValue), i, i2);
        }
    }

    public final void a(Set<uj0> imageValuesToLoad, dk0 imagesFetchListener) {
        Intrinsics.checkNotNullParameter(imageValuesToLoad, "imageValuesToLoad");
        Intrinsics.checkNotNullParameter(imagesFetchListener, "imagesFetchListener");
        if (imageValuesToLoad.isEmpty()) {
            imagesFetchListener.a(MapsKt.emptyMap());
        } else {
            new a(this.f9102a, imageValuesToLoad, imagesFetchListener, new Handler(Looper.getMainLooper()), new AtomicInteger(imageValuesToLoad.size()), new f01()).a();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ hj0(Context context) {
        ed1 ed1VarA = ed1.c.a(context);
        this(context, ed1VarA, ed1VarA.b(), ed1VarA.c());
    }

    public hj0(Context context, ed1 networkingImage, lj0 imageLoader, ed1.c urlBitmapCache) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(networkingImage, "networkingImage");
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        Intrinsics.checkNotNullParameter(urlBitmapCache, "urlBitmapCache");
        this.f9102a = imageLoader;
        this.b = urlBitmapCache;
    }

    public final void a(LinkedHashMap images) {
        Intrinsics.checkNotNullParameter(images, "images");
        for (Map.Entry entry : images.entrySet()) {
            this.b.a((String) entry.getKey(), (Bitmap) entry.getValue());
        }
    }
}
