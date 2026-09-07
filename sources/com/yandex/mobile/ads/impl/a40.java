package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a40 implements sl<Drawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ft1 f8362a;
    private final vl b;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f8363a;
        private final int b;
        private final int c;
        private final int d;
        private final int e;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f8363a == aVar.f8363a && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d && this.e == aVar.e;
        }

        public final int hashCode() {
            return Integer.hashCode(this.e) + wx1.a(this.d, wx1.a(this.c, wx1.a(this.b, Integer.hashCode(this.f8363a) * 31, 31), 31), 31);
        }

        public final String toString() {
            return "BitmapPixel(color=" + this.f8363a + ", alpha=" + this.b + ", red=" + this.c + ", green=" + this.d + ", blue=" + this.e + ")";
        }

        public /* synthetic */ a(int i) {
            this(i, Color.alpha(i), Color.red(i), Color.green(i), Color.blue(i));
        }

        public final int a() {
            return this.b;
        }

        public final int d() {
            return this.c;
        }

        public final int c() {
            return this.d;
        }

        public final int b() {
            return this.e;
        }

        public a(int i, int i2, int i3, int i4, int i5) {
            this.f8363a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
        }
    }

    public a40(ft1 scaledDrawableBitmapProvider, vl bitmapProvider) {
        Intrinsics.checkNotNullParameter(scaledDrawableBitmapProvider, "scaledDrawableBitmapProvider");
        Intrinsics.checkNotNullParameter(bitmapProvider, "bitmapProvider");
        this.f8362a = scaledDrawableBitmapProvider;
        this.b = bitmapProvider;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0021  */
    @Override // com.yandex.mobile.ads.impl.sl
    public final boolean a(Drawable drawable, Bitmap src) {
        Bitmap src2;
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Intrinsics.checkNotNullParameter(src, "bitmap");
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                src2 = bitmapDrawable.getBitmap();
                Intrinsics.checkNotNullExpressionValue(src2, "getBitmap(...)");
            } else {
                src2 = this.f8362a.a(drawable);
            }
        } else {
            src2 = this.f8362a.a(drawable);
        }
        this.b.getClass();
        Intrinsics.checkNotNullParameter(src2, "src");
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(src2, 1, 1, true);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
        this.b.getClass();
        Intrinsics.checkNotNullParameter(src, "src");
        Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(src, 1, 1, true);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap2, "createScaledBitmap(...)");
        a aVar = new a(bitmapCreateScaledBitmap.getPixel(0, 0));
        a aVar2 = new a(bitmapCreateScaledBitmap2.getPixel(0, 0));
        return Math.abs(aVar.a() - aVar2.a()) <= 20 && Math.abs(aVar.d() - aVar2.d()) <= 20 && Math.abs(aVar.c() - aVar2.c()) <= 20 && Math.abs(aVar.b() - aVar2.b()) <= 20;
    }
}
