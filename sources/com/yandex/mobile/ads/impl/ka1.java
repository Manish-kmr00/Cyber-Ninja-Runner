package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ka1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final cx0 f9399a = new cx0();

    public final boolean a(o41 nativeAdBlock) {
        Intrinsics.checkNotNullParameter(nativeAdBlock, "nativeAdBlock");
        List<c41> listE = nativeAdBlock.c().e();
        ArrayList arrayList = new ArrayList();
        for (c41 c41Var : listE) {
            this.f9399a.getClass();
            CollectionsKt.addAll(arrayList, cx0.a(c41Var));
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            db2 db2VarC = ((ax0) it.next()).c();
            List<rb2<gb1>> listC = db2VarC != null ? db2VarC.c() : null;
            if (listC == null) {
                listC = CollectionsKt.emptyList();
            }
            CollectionsKt.addAll(arrayList2, listC);
        }
        if (!arrayList2.isEmpty()) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                if (!((rb2) it2.next()).g().d().isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }
}
