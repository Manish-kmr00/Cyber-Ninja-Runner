package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class uk1 implements pj0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bn f10398a;
    private final LinkedHashMap b;
    private final LinkedHashMap c;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10399a;
        private final yy1 b;

        public a(String base64, yy1 size) {
            Intrinsics.checkNotNullParameter(base64, "base64");
            Intrinsics.checkNotNullParameter(size, "size");
            this.f10399a = base64;
            this.b = size;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.f10399a, aVar.f10399a) && Intrinsics.areEqual(this.b, aVar.b);
        }

        public final int hashCode() {
            return this.b.hashCode() + (this.f10399a.hashCode() * 31);
        }

        public final String toString() {
            return "Preview(base64=" + this.f10399a + ", size=" + this.b + ")";
        }
    }

    @Override // com.yandex.mobile.ads.impl.pj0
    public final void a(String key, Bitmap value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.b.put(key, value);
    }

    @Override // com.yandex.mobile.ads.impl.pj0
    public final Bitmap b(uj0 imageValue) {
        Intrinsics.checkNotNullParameter(imageValue, "imageValue");
        String strF = imageValue.f();
        Bitmap bitmap = (Bitmap) this.b.get(strF);
        if (bitmap != null) {
            return bitmap;
        }
        Bitmap bitmapA = this.f10398a.a(imageValue);
        if (bitmapA == null) {
            return null;
        }
        this.b.put(strF, bitmapA);
        return bitmapA;
    }

    public /* synthetic */ uk1(Context context) {
        this(context, new bn(context));
    }

    public uk1(Context context, bn cacheImageProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cacheImageProvider, "cacheImageProvider");
        this.f10398a = cacheImageProvider;
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
    }

    @Override // com.yandex.mobile.ads.impl.pj0
    public final void a(Map<String, Bitmap> images) {
        Intrinsics.checkNotNullParameter(images, "images");
        this.b.putAll(images);
    }

    @Override // com.yandex.mobile.ads.impl.pj0
    public final void a(Bitmap value, uj0 key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        String strC = key.c();
        a aVar = strC != null ? new a(strC, new yy1(key.g(), key.a())) : null;
        if (aVar != null) {
            this.c.put(aVar, value);
        }
    }

    @Override // com.yandex.mobile.ads.impl.pj0
    public final Bitmap a(uj0 imageValue) {
        Intrinsics.checkNotNullParameter(imageValue, "imageValue");
        String strC = imageValue.c();
        a aVar = strC != null ? new a(strC, new yy1(imageValue.g(), imageValue.a())) : null;
        if (aVar != null) {
            return (Bitmap) this.c.get(aVar);
        }
        return null;
    }
}
