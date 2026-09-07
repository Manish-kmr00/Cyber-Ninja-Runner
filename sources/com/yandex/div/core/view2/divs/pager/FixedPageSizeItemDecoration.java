package com.yandex.div.core.view2.divs.pager;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: FixedPageSizeItemDecoration.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0013\u0010\u0016\u001a\u00020\b*\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/yandex/div/core/view2/divs/pager/FixedPageSizeItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "paddings", "Lcom/yandex/div/core/view2/divs/pager/DivPagerPaddingsHolder;", "sizeProvider", "Lcom/yandex/div/core/view2/divs/pager/FixedPageSizeProvider;", "(Lcom/yandex/div/core/view2/divs/pager/DivPagerPaddingsHolder;Lcom/yandex/div/core/view2/divs/pager/FixedPageSizeProvider;)V", "offsetBottom", "", "offsetLeft", "offsetRight", "offsetTop", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "toOffset", "(Ljava/lang/Integer;)I", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class FixedPageSizeItemDecoration extends RecyclerView.ItemDecoration {
    private final int offsetBottom;
    private final int offsetLeft;
    private final int offsetRight;
    private final int offsetTop;
    private final FixedPageSizeProvider sizeProvider;

    public FixedPageSizeItemDecoration(DivPagerPaddingsHolder paddings, FixedPageSizeProvider sizeProvider) {
        Intrinsics.checkNotNullParameter(paddings, "paddings");
        Intrinsics.checkNotNullParameter(sizeProvider, "sizeProvider");
        this.sizeProvider = sizeProvider;
        this.offsetLeft = toOffset(paddings.getAlignedLeft());
        this.offsetTop = toOffset(paddings.getAlignedTop());
        this.offsetRight = toOffset(paddings.getAlignedRight());
        this.offsetBottom = toOffset(paddings.getAlignedBottom());
    }

    private final int toOffset(Integer num) {
        return num != null ? num.intValue() : MathKt.roundToInt(this.sizeProvider.getNeighbourSize());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        outRect.set(this.offsetLeft, this.offsetTop, this.offsetRight, this.offsetBottom);
    }
}
