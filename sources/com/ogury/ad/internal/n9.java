package com.ogury.ad.internal;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class n9 {
    public static void a(ViewGroup viewGroup, ArrayList arrayList) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (!(childAt instanceof h)) {
                Intrinsics.checkNotNull(childAt);
                arrayList.add(childAt);
            }
            if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt, arrayList);
            }
        }
    }
}
