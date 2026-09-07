package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes7.dex */
public final class of1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final qf1 f9812a;
    private final pf1 b;
    private final nf1 c;

    public final int a(View view, Rect viewRect) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(viewRect, "viewRect");
        int i = iw1.l;
        iw1 iw1VarA = iw1.a.a();
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        cu1 cu1VarA = iw1VarA.a(context);
        if (cu1VarA == null || !cu1VarA.s0()) {
            return 0;
        }
        this.f9812a.getClass();
        ArrayList<View> overlappingViews = qf1.a(view);
        this.b.getClass();
        Intrinsics.checkNotNullParameter(viewRect, "viewRect");
        Intrinsics.checkNotNullParameter(overlappingViews, "overlappingViews");
        ArrayList<Rect> arrayList = new ArrayList();
        for (View view2 : overlappingViews) {
            Rect rect = new Rect();
            if (view2.getGlobalVisibleRect(rect)) {
                arrayList.add(rect);
            }
        }
        for (Rect rect2 : arrayList) {
            int i2 = rect2.left;
            int i3 = viewRect.left;
            rect2.left = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(i2, i3), viewRect.right);
            int i4 = rect2.top;
            int i5 = viewRect.top;
            rect2.top = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(i4, i5), viewRect.bottom);
            int i6 = rect2.right;
            int i7 = viewRect.left;
            rect2.right = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(i6, i7), viewRect.right);
            int i8 = rect2.bottom;
            int i9 = viewRect.top;
            rect2.bottom = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(i8, i9), viewRect.bottom);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            Rect rect3 = (Rect) obj;
            if (rect3.width() > 0 && rect3.height() > 0) {
                arrayList2.add(obj);
            }
        }
        int size = arrayList2.size();
        List listSubList = arrayList2;
        if (size > 100) {
            listSubList = arrayList2.subList(0, 100);
        }
        this.c.getClass();
        return nf1.a(viewRect, listSubList);
    }

    public /* synthetic */ of1() {
        this(new qf1(), new pf1(), new nf1());
    }

    public of1(qf1 overlappingViewsProvider, pf1 overlappingRectsProvider, nf1 overlappingAreaEvaluator) {
        Intrinsics.checkNotNullParameter(overlappingViewsProvider, "overlappingViewsProvider");
        Intrinsics.checkNotNullParameter(overlappingRectsProvider, "overlappingRectsProvider");
        Intrinsics.checkNotNullParameter(overlappingAreaEvaluator, "overlappingAreaEvaluator");
        this.f9812a = overlappingViewsProvider;
        this.b = overlappingRectsProvider;
        this.c = overlappingAreaEvaluator;
    }
}
