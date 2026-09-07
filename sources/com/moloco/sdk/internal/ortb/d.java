package com.moloco.sdk.internal.ortb;

import com.moloco.sdk.internal.ortb.model.e;
import com.moloco.sdk.internal.ortb.model.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes12.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Regex f6113a = new Regex("\\$\\{AUCTION_PRICE\\}");

    public static final e a(e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        List<r> listB = eVar.b();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listB, 10));
        Iterator<T> it = listB.iterator();
        while (it.hasNext()) {
            List<com.moloco.sdk.internal.ortb.model.c> listB2 = ((r) it.next()).b();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listB2, 10));
            for (com.moloco.sdk.internal.ortb.model.c cVar : listB2) {
                float fG = cVar.g();
                String strA = a(cVar.a(), Float.valueOf(fG));
                String strC = cVar.c();
                arrayList2.add(new com.moloco.sdk.internal.ortb.model.c(strA, fG, strC != null ? a(strC, Float.valueOf(fG)) : null, cVar.e()));
            }
            arrayList.add(new r(arrayList2));
        }
        return new e(arrayList);
    }

    public static final String a(String str, Float f) {
        String string;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Regex regex = f6113a;
        if (f == null || (string = f.toString()) == null) {
            string = "";
        }
        return regex.replace(str, string);
    }
}
