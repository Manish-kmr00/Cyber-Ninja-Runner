package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class zj0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wj0 f10821a = new wj0();

    public final void a(List<? extends ig<?>> assets, Map<String, Bitmap> images) {
        List<uj0> listA;
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(images, "images");
        for (ig<?> igVar : assets) {
            Object objD = igVar.d();
            if (Intrinsics.areEqual(igVar.c(), "media") && (objD instanceof ax0) && (listA = ((ax0) objD).a()) != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : listA) {
                    this.f10821a.getClass();
                    if (wj0.a((uj0) obj, images)) {
                        arrayList.add(obj);
                    }
                }
                listA.retainAll(arrayList);
            }
        }
    }
}
