package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class rn0 implements dk0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ qn0 f10125a;
    final /* synthetic */ List<ig<?>> b;
    final /* synthetic */ pj0 c;
    final /* synthetic */ qn0.a d;
    final /* synthetic */ rb2<do0> e;

    rn0(qn0 qn0Var, List list, pj0 pj0Var, bo0 bo0Var, rb2 rb2Var) {
        this.f10125a = qn0Var;
        this.b = list;
        this.c = pj0Var;
        this.d = bo0Var;
        this.e = rb2Var;
    }

    @Override // com.yandex.mobile.ads.impl.dk0
    public final void a(String url, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
    }

    @Override // com.yandex.mobile.ads.impl.dk0
    public final void a(Map<String, Bitmap> images) {
        Intrinsics.checkNotNullParameter(images, "images");
        this.f10125a.b.a(f5.q);
        this.f10125a.d.a(this.f10125a.c.a(this.b, images), images);
        this.c.a(images);
        this.d.h(this.e);
    }
}
