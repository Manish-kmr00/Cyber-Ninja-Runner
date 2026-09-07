package com.yandex.div.core.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewPager2Wrapper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
/* synthetic */ class ViewPager2Wrapper$onMeasure$maxWidth$1 extends FunctionReferenceImpl implements Function2<RecyclerView.LayoutManager, View, Integer> {
    public static final ViewPager2Wrapper$onMeasure$maxWidth$1 INSTANCE = new ViewPager2Wrapper$onMeasure$maxWidth$1();

    ViewPager2Wrapper$onMeasure$maxWidth$1() {
        super(2, RecyclerView.LayoutManager.class, "getDecoratedMeasuredWidth", "getDecoratedMeasuredWidth(Landroid/view/View;)I", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Integer invoke(RecyclerView.LayoutManager p0, View p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return Integer.valueOf(p0.getDecoratedMeasuredWidth(p1));
    }
}
