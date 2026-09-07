package com.yandex.div.core.view2.divs.tabs;

import com.yandex.div.internal.widget.tabs.ScrollableViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivTabsAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yandex/div/core/view2/divs/tabs/PagerController;", "", "scrollableViewPager", "Lcom/yandex/div/internal/widget/tabs/ScrollableViewPager;", "(Lcom/yandex/div/internal/widget/tabs/ScrollableViewPager;)V", "currentItemIndex", "", "getCurrentItemIndex", "()I", "smoothScrollTo", "", "itemIndex", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PagerController {
    private final ScrollableViewPager scrollableViewPager;

    public PagerController(ScrollableViewPager scrollableViewPager) {
        Intrinsics.checkNotNullParameter(scrollableViewPager, "scrollableViewPager");
        this.scrollableViewPager = scrollableViewPager;
    }

    public final void smoothScrollTo(int itemIndex) {
        this.scrollableViewPager.setCurrentItem(itemIndex, true);
    }

    public final int getCurrentItemIndex() {
        return this.scrollableViewPager.getCurrentItem();
    }
}
