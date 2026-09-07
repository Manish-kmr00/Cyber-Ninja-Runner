package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.util.LruCache;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes10.dex */
public final class ed1 {
    public static final a c = new a(0);
    private static volatile ed1 d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final cz1 f8787a;
    private final h82 b;

    public interface c {
        void a(String str, Bitmap bitmap);
    }

    /* synthetic */ ed1(Context context) {
        this(context, new ej0());
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0026  */
    private static bq1 b(Context context) {
        int iIntValue;
        Integer numY;
        Intrinsics.checkNotNullParameter(context, "context");
        int i = iw1.l;
        cu1 cu1VarA = iw1.a.a().a(context);
        if (cu1VarA == null || (numY = cu1VarA.y()) == null) {
            iIntValue = 4;
        } else {
            if (numY.intValue() == 0) {
                numY = null;
            }
            if (numY != null) {
                iIntValue = numY.intValue();
            } else {
                iIntValue = 4;
            }
        }
        bq1 bq1VarA = cq1.a(context, iIntValue);
        bq1VarA.a();
        return bq1VarA;
    }

    public final h82 c() {
        return this.b;
    }

    private static fd1 a(Context context) {
        int iCoerceAtMost;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            int iMaxMemory = (int) (Runtime.getRuntime().maxMemory() / ((long) 1024));
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            iCoerceAtMost = RangesKt.coerceAtMost(iMaxMemory / 8, ((int) (((displayMetrics.widthPixels * displayMetrics.heightPixels) * displayMetrics.density) / 1024)) * 3);
        } catch (IllegalArgumentException unused) {
            Object[] args = new Object[0];
            int i = op0.b;
            Intrinsics.checkNotNullParameter(args, "args");
            iCoerceAtMost = 5120;
        }
        return new fd1(RangesKt.coerceAtLeast(iCoerceAtMost, 5120));
    }

    private ed1(Context context, ej0 ej0Var) {
        fd1 fd1VarA = a(context);
        bq1 bq1VarB = b(context);
        b bVar = new b(fd1VarA);
        this.b = new h82(fd1VarA, ej0Var);
        this.f8787a = new cz1(bq1VarB, bVar, ej0Var);
    }

    public final cz1 b() {
        return this.f8787a;
    }

    public static final class b implements lj0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LruCache<String, Bitmap> f8788a;

        public b(fd1 imageCache) {
            Intrinsics.checkNotNullParameter(imageCache, "imageCache");
            this.f8788a = imageCache;
        }

        @Override // com.yandex.mobile.ads.impl.lj0.b
        public final Bitmap a(String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return this.f8788a.get(key);
        }

        @Override // com.yandex.mobile.ads.impl.lj0.b
        public final void a(String key, Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            this.f8788a.put(key, bitmap);
        }
    }

    public static final class a {
        @JvmStatic
        public final ed1 a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            ed1 ed1Var = ed1.d;
            if (ed1Var == null) {
                synchronized (this) {
                    ed1Var = ed1.d;
                    if (ed1Var == null) {
                        ed1Var = new ed1(context);
                        ed1.d = ed1Var;
                    }
                }
            }
            return ed1Var;
        }

        private a() {
        }

        public /* synthetic */ a(int i) {
            this();
        }
    }
}
