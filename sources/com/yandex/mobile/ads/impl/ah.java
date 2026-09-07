package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wj0 f8406a;

    public final ArrayList a(List assets, Map images) {
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(images, "images");
        ArrayList arrayList = new ArrayList();
        Iterator it = assets.iterator();
        while (it.hasNext()) {
            ig igVar = (ig) it.next();
            Object objD = igVar.d();
            String strC = igVar.c();
            if (Intrinsics.areEqual("image", strC) && (objD instanceof uj0)) {
                this.f8406a.getClass();
                if (wj0.a((uj0) objD, images)) {
                    arrayList.add(igVar);
                }
            } else {
                if (Intrinsics.areEqual("media", strC) && (objD instanceof ax0)) {
                    ax0 ax0Var = (ax0) objD;
                    if (ax0Var.a() != null) {
                        Intrinsics.checkNotNull(objD, "null cannot be cast to non-null type com.monetization.ads.network.model.MediaValue");
                        List<uj0> listA = ax0Var.a();
                        uj0 uj0Var = listA != null ? (uj0) CollectionsKt.firstOrNull((List) listA) : null;
                        db2 db2VarC = ax0Var.c();
                        su0 su0VarB = ax0Var.b();
                        if (db2VarC == null && su0VarB == null) {
                            if (uj0Var != null) {
                                this.f8406a.getClass();
                                if (wj0.a(uj0Var, images)) {
                                }
                            }
                        }
                        arrayList.add(igVar);
                    }
                }
                arrayList.add(igVar);
            }
        }
        return arrayList;
    }

    public /* synthetic */ ah() {
        this(new wj0());
    }

    public ah(wj0 imageValueValidator) {
        Intrinsics.checkNotNullParameter(imageValueValidator, "imageValueValidator");
        this.f8406a = imageValueValidator;
    }
}
