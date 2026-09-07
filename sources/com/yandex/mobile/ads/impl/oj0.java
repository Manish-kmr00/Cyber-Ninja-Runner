package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class oj0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final pj0 f9824a;
    private final nj0 b;

    public oj0(pj0 imageProvider, nj0 imagePreviewCreator) {
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(imagePreviewCreator, "imagePreviewCreator");
        this.f9824a = imageProvider;
        this.b = imagePreviewCreator;
    }

    public final void a(Set<uj0> imageValues) {
        Bitmap bitmapA;
        Intrinsics.checkNotNullParameter(imageValues, "imageValues");
        ArrayList<uj0> arrayList = new ArrayList();
        for (Object obj : imageValues) {
            String strC = ((uj0) obj).c();
            if (strC != null && (!StringsKt.isBlank(strC))) {
                arrayList.add(obj);
            }
        }
        for (uj0 uj0Var : arrayList) {
            if (this.f9824a.a(uj0Var) == null && this.f9824a.b(uj0Var) == null && (bitmapA = this.b.a(uj0Var)) != null) {
                this.f9824a.a(bitmapA, uj0Var);
            }
        }
    }
}
