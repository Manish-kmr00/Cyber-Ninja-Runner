package com.yandex.div.core.view2.divs.pager;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.yandex.div.core.view2.divs.widgets.DivPagerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: WrapContentPageSizeOffScreenPagesController.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0017\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\f\u0010\u0015\u001a\u00020\u0014*\u00020\u0003H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/yandex/div/core/view2/divs/pager/WrapContentPageSizeOffScreenPagesController;", "", "parent", "Lcom/yandex/div/core/view2/divs/widgets/DivPagerView;", "itemSpacing", "", "pageSizeProvider", "Lcom/yandex/div/core/view2/divs/pager/DivPagerPageSizeProvider;", "paddings", "Lcom/yandex/div/core/view2/divs/pager/DivPagerPaddingsHolder;", "adapter", "Lcom/yandex/div/core/view2/divs/pager/DivPagerAdapter;", "(Lcom/yandex/div/core/view2/divs/widgets/DivPagerView;FLcom/yandex/div/core/view2/divs/pager/DivPagerPageSizeProvider;Lcom/yandex/div/core/view2/divs/pager/DivPagerPaddingsHolder;Lcom/yandex/div/core/view2/divs/pager/DivPagerAdapter;)V", "sidePagesCount", "", "calcSidePagesCount", "pageSize", "page", "(I)Ljava/lang/Float;", "updateOffScreenPages", "", "setOffScreenPages", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class WrapContentPageSizeOffScreenPagesController {
    private final DivPagerAdapter adapter;
    private final float itemSpacing;
    private final DivPagerPaddingsHolder paddings;
    private final DivPagerPageSizeProvider pageSizeProvider;
    private final DivPagerView parent;
    private int sidePagesCount;

    public WrapContentPageSizeOffScreenPagesController(DivPagerView parent, float f, DivPagerPageSizeProvider pageSizeProvider, DivPagerPaddingsHolder paddings, DivPagerAdapter adapter) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(pageSizeProvider, "pageSizeProvider");
        Intrinsics.checkNotNullParameter(paddings, "paddings");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.parent = parent;
        this.itemSpacing = f;
        this.pageSizeProvider = pageSizeProvider;
        this.paddings = paddings;
        this.adapter = adapter;
        this.sidePagesCount = 1;
        this.sidePagesCount = calcSidePagesCount();
        setOffScreenPages(parent);
        parent.setChangePageCallbackForOffScreenPages$div_release(new DivPagerView.OffScreenPagesUpdateCallback() { // from class: com.yandex.div.core.view2.divs.pager.WrapContentPageSizeOffScreenPagesController.1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int position) {
                WrapContentPageSizeOffScreenPagesController.this.updateOffScreenPages();
            }

            @Override // com.yandex.div.core.view2.divs.widgets.DivPagerView.OffScreenPagesUpdateCallback, android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                WrapContentPageSizeOffScreenPagesController.this.updateOffScreenPages();
            }
        });
    }

    private final int calcSidePagesCount() {
        Float prevNeighbourSize = this.pageSizeProvider.getPrevNeighbourSize(this.parent.getCurrentItem$div_release());
        if (prevNeighbourSize == null) {
            return 1;
        }
        float fFloatValue = prevNeighbourSize.floatValue();
        int currentItem$div_release = this.parent.getCurrentItem$div_release() - 1;
        int i = 0;
        int i2 = 0;
        while (fFloatValue > 0.0f && currentItem$div_release > 0) {
            i2++;
            Float fPageSize = pageSize(currentItem$div_release);
            if (fPageSize == null) {
                break;
            }
            fFloatValue -= fPageSize.floatValue();
            currentItem$div_release--;
        }
        if (fFloatValue > this.paddings.getStart() && currentItem$div_release == 0) {
            i2++;
            Float fPageSize2 = pageSize(currentItem$div_release);
            fFloatValue -= fPageSize2 != null ? fPageSize2.floatValue() : 0.0f;
        }
        Float nextNeighbourSize = this.pageSizeProvider.getNextNeighbourSize(this.parent.getCurrentItem$div_release());
        if (nextNeighbourSize == null) {
            return RangesKt.coerceAtLeast(i2, 1);
        }
        float fFloatValue2 = nextNeighbourSize.floatValue();
        if (fFloatValue > this.paddings.getStart()) {
            fFloatValue2 += fFloatValue;
        }
        int currentItem$div_release2 = this.parent.getCurrentItem$div_release() + 1;
        while (fFloatValue2 > 0.0f && currentItem$div_release2 < this.adapter.getItemCount() - 1) {
            i++;
            Float fPageSize3 = pageSize(currentItem$div_release2);
            if (fPageSize3 == null) {
                break;
            }
            fFloatValue2 -= fPageSize3.floatValue();
            currentItem$div_release2++;
        }
        if (fFloatValue2 > this.paddings.getEnd() && currentItem$div_release2 == this.adapter.getItemCount() - 1) {
            i++;
            Float fPageSize4 = pageSize(currentItem$div_release2);
            fFloatValue2 -= fPageSize4 != null ? fPageSize4.floatValue() : 0.0f;
        }
        while (fFloatValue2 > 0.0f && currentItem$div_release >= 0) {
            i2++;
            Float fPageSize5 = pageSize(currentItem$div_release);
            if (fPageSize5 == null) {
                break;
            }
            fFloatValue2 -= fPageSize5.floatValue();
            currentItem$div_release--;
        }
        return RangesKt.coerceAtLeast(Math.max(i2, i), 1);
    }

    private final Float pageSize(int page) {
        Float itemSize = this.pageSizeProvider.getItemSize(page);
        if (itemSize != null) {
            return Float.valueOf(itemSize.floatValue() + this.itemSpacing);
        }
        return null;
    }

    private final void setOffScreenPages(DivPagerView divPagerView) {
        RecyclerView recyclerView = divPagerView.getRecyclerView();
        if (recyclerView != null) {
            recyclerView.setItemViewCacheSize((this.sidePagesCount * 2) + 3);
        }
        divPagerView.getViewPager().setOffscreenPageLimit(this.sidePagesCount);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateOffScreenPages() {
        int iCalcSidePagesCount = calcSidePagesCount();
        if (iCalcSidePagesCount <= this.sidePagesCount) {
            return;
        }
        this.sidePagesCount = iCalcSidePagesCount;
        setOffScreenPages(this.parent);
    }
}
