package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class fa {
    public static List a(fy.g adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        listCreateListBuilder.add(fy.d.f8946a);
        listCreateListBuilder.add(new fy.e("Info"));
        if (adapter.i() == pw.c && adapter.a() != null) {
            String strG = adapter.g();
            listCreateListBuilder.add(new fy.f((strG == null || StringsKt.isBlank(strG)) ? "ID" : adapter.g(), adapter.a()));
        }
        listCreateListBuilder.add(new fy.f("Type", adapter.i().a()));
        List<mx> listH = adapter.h();
        if (listH != null) {
            for (mx mxVar : listH) {
                listCreateListBuilder.add(new fy.f(mxVar.a(), mxVar.b()));
            }
        }
        List<iy> listB = adapter.b();
        if (listB != null && !listB.isEmpty()) {
            listCreateListBuilder.add(fy.d.f8946a);
            listCreateListBuilder.add(new fy.e("CPM floors"));
            String strG2 = adapter.g();
            String str = (strG2 == null || StringsKt.isBlank(strG2)) ? "" : adapter.g() + ": ";
            for (iy iyVar : adapter.b()) {
                listCreateListBuilder.add(new fy.f(str + iyVar.b(), "cpm: " + iyVar.a()));
            }
        }
        return CollectionsKt.build(listCreateListBuilder);
    }
}
