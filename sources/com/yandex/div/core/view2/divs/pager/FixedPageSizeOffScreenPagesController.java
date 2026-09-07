package com.yandex.div.core.view2.divs.pager;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.yandex.div.core.view2.divs.widgets.DivPagerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FixedPageSizeOffScreenPagesController.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/yandex/div/core/view2/divs/pager/FixedPageSizeOffScreenPagesController;", "", "parent", "Lcom/yandex/div/core/view2/divs/widgets/DivPagerView;", "parentSize", "", "itemSpacing", "", "pageSizeProvider", "Lcom/yandex/div/core/view2/divs/pager/FixedPageSizeProvider;", "paddings", "Lcom/yandex/div/core/view2/divs/pager/DivPagerPaddingsHolder;", "infiniteScroll", "", "adapter", "Lcom/yandex/div/core/view2/divs/pager/DivPagerAdapter;", "(Lcom/yandex/div/core/view2/divs/widgets/DivPagerView;IFLcom/yandex/div/core/view2/divs/pager/FixedPageSizeProvider;Lcom/yandex/div/core/view2/divs/pager/DivPagerPaddingsHolder;ZLcom/yandex/div/core/view2/divs/pager/DivPagerAdapter;)V", "setOffScreenPages", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class FixedPageSizeOffScreenPagesController {
    private final DivPagerAdapter adapter;
    private final boolean infiniteScroll;
    private final float itemSpacing;
    private final DivPagerPaddingsHolder paddings;
    private final FixedPageSizeProvider pageSizeProvider;
    private final DivPagerView parent;
    private final int parentSize;

    public FixedPageSizeOffScreenPagesController(DivPagerView parent, int i, float f, FixedPageSizeProvider pageSizeProvider, DivPagerPaddingsHolder paddings, boolean z, DivPagerAdapter adapter) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(pageSizeProvider, "pageSizeProvider");
        Intrinsics.checkNotNullParameter(paddings, "paddings");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.parent = parent;
        this.parentSize = i;
        this.itemSpacing = f;
        this.pageSizeProvider = pageSizeProvider;
        this.paddings = paddings;
        this.infiniteScroll = z;
        this.adapter = adapter;
        setOffScreenPages();
    }

    private final void setOffScreenPages() {
        if (this.pageSizeProvider.getItemSize() == 0.0f) {
            return;
        }
        ViewPager2 viewPager = this.parent.getViewPager();
        float itemSize = this.parentSize / (this.pageSizeProvider.getItemSize() + this.itemSpacing);
        RecyclerView recyclerView = this.parent.getRecyclerView();
        if (recyclerView != null) {
            recyclerView.setItemViewCacheSize(((int) Math.ceil(itemSize)) + 2);
        }
        if (this.pageSizeProvider.getHasOffScreenPages()) {
            viewPager.setOffscreenPageLimit(Math.max((int) Math.ceil(itemSize - 1), 1));
            return;
        }
        float neighbourSize = this.pageSizeProvider.getNeighbourSize();
        if (neighbourSize > this.itemSpacing) {
            viewPager.setOffscreenPageLimit(1);
            return;
        }
        if (this.infiniteScroll || (this.paddings.getStart() >= neighbourSize && this.paddings.getEnd() >= neighbourSize)) {
            viewPager.setOffscreenPageLimit(-1);
            return;
        }
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.yandex.div.core.view2.divs.pager.FixedPageSizeOffScreenPagesController$setOffScreenPages$setOffScreenPages$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                ViewPager2 viewPager2 = this.this$0.parent.getViewPager();
                int i2 = 1;
                if (i != 0 && i != this.this$0.adapter.getItemCount() - 1) {
                    i2 = -1;
                }
                viewPager2.setOffscreenPageLimit(i2);
            }
        };
        function1.invoke(Integer.valueOf(viewPager.getCurrentItem()));
        this.parent.setChangePageCallbackForOffScreenPages$div_release(new DivPagerView.OffScreenPagesUpdateCallback() { // from class: com.yandex.div.core.view2.divs.pager.FixedPageSizeOffScreenPagesController.setOffScreenPages.1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int position) {
                function1.invoke(Integer.valueOf(position));
            }
        });
    }
}
