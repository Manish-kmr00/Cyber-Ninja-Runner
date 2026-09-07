package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d91 implements dk0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ pj0 f8672a;

    d91(pj0 pj0Var) {
        this.f8672a = pj0Var;
    }

    @Override // com.yandex.mobile.ads.impl.dk0
    public final void a(String url, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.f8672a.a(url, bitmap);
    }

    @Override // com.yandex.mobile.ads.impl.dk0
    public final void a(Map<String, Bitmap> images) {
        Intrinsics.checkNotNullParameter(images, "images");
    }
}
