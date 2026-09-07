package com.yandex.div.core.view2.divs.pager;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.yandex.div.core.widget.ViewsKt;
import com.yandex.div2.DivPager;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: WrapContentPageSizeItemDecoration.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ(\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\u00020\u0003*\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u00020\u0003*\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0018\u0010\u000f\u001a\u00020\u0003*\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/yandex/div/core/view2/divs/pager/WrapContentPageSizeItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "parentSize", "", "paddings", "Lcom/yandex/div/core/view2/divs/pager/DivPagerPaddingsHolder;", "alignment", "Lcom/yandex/div2/DivPager$ItemAlignment;", "(ILcom/yandex/div/core/view2/divs/pager/DivPagerPaddingsHolder;Lcom/yandex/div2/DivPager$ItemAlignment;)V", "bottomOffset", "Landroid/view/View;", "getBottomOffset", "(Landroid/view/View;)I", "horizontalOffset", "getHorizontalOffset", "topOffset", "getTopOffset", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class WrapContentPageSizeItemDecoration extends RecyclerView.ItemDecoration {
    private final DivPager.ItemAlignment alignment;
    private final DivPagerPaddingsHolder paddings;
    private final int parentSize;

    /* JADX INFO: compiled from: WrapContentPageSizeItemDecoration.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DivPager.ItemAlignment.values().length];
            try {
                iArr[DivPager.ItemAlignment.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DivPager.ItemAlignment.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DivPager.ItemAlignment.END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public WrapContentPageSizeItemDecoration(int i, DivPagerPaddingsHolder paddings, DivPager.ItemAlignment alignment) {
        Intrinsics.checkNotNullParameter(paddings, "paddings");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        this.parentSize = i;
        this.paddings = paddings;
        this.alignment = alignment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        View child;
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        int width = parent.getWidth();
        DivPagerPaddingsHolder divPagerPaddingsHolder = this.paddings;
        int iRoundToInt = width - MathKt.roundToInt(divPagerPaddingsHolder.getLeft() + divPagerPaddingsHolder.getRight());
        int height = parent.getHeight();
        DivPagerPaddingsHolder divPagerPaddingsHolder2 = this.paddings;
        view.measure(ViewsKt.makeExactSpec(iRoundToInt), ViewsKt.makeExactSpec(height - MathKt.roundToInt(divPagerPaddingsHolder2.getTop() + divPagerPaddingsHolder2.getBottom())));
        DivPagerPageLayout divPagerPageLayout = view instanceof DivPagerPageLayout ? (DivPagerPageLayout) view : null;
        if (divPagerPageLayout == null || (child = divPagerPageLayout.getChild()) == null) {
            return;
        }
        Integer alignedLeft = this.paddings.getAlignedLeft();
        int iIntValue = alignedLeft != null ? alignedLeft.intValue() : getHorizontalOffset(child);
        Integer alignedTop = this.paddings.getAlignedTop();
        int iIntValue2 = alignedTop != null ? alignedTop.intValue() : getTopOffset(child);
        Integer alignedRight = this.paddings.getAlignedRight();
        int iIntValue3 = alignedRight != null ? alignedRight.intValue() : getHorizontalOffset(child);
        Integer alignedBottom = this.paddings.getAlignedBottom();
        outRect.set(iIntValue, iIntValue2, iIntValue3, alignedBottom != null ? alignedBottom.intValue() : getBottomOffset(child));
    }

    private final int getHorizontalOffset(View view) {
        float start;
        int measuredWidth;
        float measuredWidth2;
        int i = WhenMappings.$EnumSwitchMapping$0[this.alignment.ordinal()];
        if (i == 1) {
            start = this.parentSize - this.paddings.getStart();
            measuredWidth = view.getMeasuredWidth();
        } else {
            if (i == 2) {
                measuredWidth2 = (this.parentSize - view.getMeasuredWidth()) / 2.0f;
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                start = this.parentSize - this.paddings.getEnd();
                measuredWidth = view.getMeasuredWidth();
            }
            return MathKt.roundToInt(measuredWidth2);
        }
        measuredWidth2 = start - measuredWidth;
        return MathKt.roundToInt(measuredWidth2);
    }

    private final int getTopOffset(View view) {
        float start;
        int i = WhenMappings.$EnumSwitchMapping$0[this.alignment.ordinal()];
        if (i == 1) {
            start = this.paddings.getStart();
        } else if (i == 2) {
            start = (this.parentSize - view.getMeasuredHeight()) / 2.0f;
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            start = (this.parentSize - this.paddings.getEnd()) - view.getMeasuredHeight();
        }
        return MathKt.roundToInt(start);
    }

    private final int getBottomOffset(View view) {
        float start;
        int i = WhenMappings.$EnumSwitchMapping$0[this.alignment.ordinal()];
        if (i == 1) {
            start = (this.parentSize - this.paddings.getStart()) - view.getMeasuredHeight();
        } else if (i == 2) {
            start = (this.parentSize - view.getMeasuredHeight()) / 2.0f;
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            start = this.paddings.getEnd();
        }
        return MathKt.roundToInt(start);
    }
}
