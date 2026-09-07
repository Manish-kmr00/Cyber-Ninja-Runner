package com.yandex.mobile.ads.impl;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class qf1 {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.view.View, android.view.ViewGroup, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v2, types: [android.view.View] */
    public static ArrayList a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ArrayList arrayList = new ArrayList();
        int i = oh2.b;
        Intrinsics.checkNotNullParameter(view, "view");
        ViewParent parent = view.getParent();
        ?? r3 = view;
        ?? view2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        while (view2 != 0) {
            int childCount = view2.getChildCount();
            for (int iIndexOfChild = view2.indexOfChild(r3) + 1; iIndexOfChild < childCount; iIndexOfChild++) {
                View childAt = view2.getChildAt(iIndexOfChild);
                Intrinsics.checkNotNull(childAt);
                arrayList.addAll(b(childAt));
            }
            Intrinsics.checkNotNullParameter(view2, "view");
            ViewParent parent2 = view2.getParent();
            ViewGroup viewGroup = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
            r3 = view2;
            view2 = viewGroup;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (view.getZ() <= ((View) obj).getZ()) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    private static List b(View view) {
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        if (!oh2.d(view)) {
            if (!(view instanceof ViewGroup) || oh2.e(view)) {
                listCreateListBuilder.add(view);
            } else {
                ViewGroup viewGroup = (ViewGroup) view;
                List listCreateListBuilder2 = CollectionsKt.createListBuilder();
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    Intrinsics.checkNotNull(childAt);
                    listCreateListBuilder2.addAll(b(childAt));
                }
                listCreateListBuilder.addAll(CollectionsKt.build(listCreateListBuilder2));
            }
        }
        return CollectionsKt.build(listCreateListBuilder);
    }
}
