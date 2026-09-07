package com.yandex.div.core.view2.divs.pager;

import android.view.View;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.json.b9;
import com.yandex.div.core.ScrollDirection;
import com.yandex.div.core.util.ViewsKt;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import com.yandex.div.core.view2.divs.widgets.DivPagerView;
import com.yandex.div.internal.core.DivItemBuilderResult;
import com.yandex.div2.Div;
import com.yandex.div2.DivPager;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: DivPagerPageChangeCallback.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0011H\u0017J \u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0011H\u0016J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0011H\u0016J\b\u0010\u001d\u001a\u00020\u0015H\u0002J\b\u0010\u001e\u001a\u00020\u0015H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/yandex/div/core/view2/divs/pager/DivPagerPageChangeCallback;", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "divPager", "Lcom/yandex/div2/DivPager;", FirebaseAnalytics.Param.ITEMS, "", "Lcom/yandex/div/internal/core/DivItemBuilderResult;", "bindingContext", "Lcom/yandex/div/core/view2/BindingContext;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "pagerView", "Lcom/yandex/div/core/view2/divs/widgets/DivPagerView;", "(Lcom/yandex/div2/DivPager;Ljava/util/List;Lcom/yandex/div/core/view2/BindingContext;Landroidx/recyclerview/widget/RecyclerView;Lcom/yandex/div/core/view2/divs/widgets/DivPagerView;)V", "divView", "Lcom/yandex/div/core/view2/Div2View;", "minimumSignificantDx", "", "prevPosition", "totalDelta", "onPageScrollStateChanged", "", "state", "onPageScrolled", b9.h.L, "positionOffset", "", "positionOffsetPixels", "onPageSelected", "trackVisibleChildren", "trackVisibleViews", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivPagerPageChangeCallback extends ViewPager2.OnPageChangeCallback {
    private final BindingContext bindingContext;
    private final DivPager divPager;
    private final Div2View divView;
    private final List<DivItemBuilderResult> items;
    private final int minimumSignificantDx;
    private final DivPagerView pagerView;
    private int prevPosition;
    private final RecyclerView recyclerView;
    private int totalDelta;

    public DivPagerPageChangeCallback(DivPager divPager, List<DivItemBuilderResult> items, BindingContext bindingContext, RecyclerView recyclerView, DivPagerView pagerView) {
        Intrinsics.checkNotNullParameter(divPager, "divPager");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(bindingContext, "bindingContext");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(pagerView, "pagerView");
        this.divPager = divPager;
        this.items = items;
        this.bindingContext = bindingContext;
        this.recyclerView = recyclerView;
        this.pagerView = pagerView;
        this.prevPosition = -1;
        Div2View divView = bindingContext.getDivView();
        this.divView = divView;
        this.minimumSignificantDx = divView.getConfig().getLogCardScrollSignificantThreshold();
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int state) {
        super.onPageScrollStateChanged(state);
        if (state == 0) {
            trackVisibleViews();
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int position) {
        super.onPageSelected(position);
        trackVisibleViews();
        int i = this.prevPosition;
        if (position == i) {
            return;
        }
        if (i != -1) {
            this.divView.unbindViewFromDiv$div_release(this.pagerView);
        }
        if (position == -1) {
            this.prevPosition = position;
            return;
        }
        int i2 = this.prevPosition;
        if (i2 != -1) {
            this.divView.getDiv2Component().getDiv2Logger().logPagerChangePage(this.divView, this.items.get(position).getExpressionResolver(), this.divPager, position, position > i2 ? "next" : ScrollDirection.BACK);
        }
        Div div = this.items.get(position).getDiv();
        if (BaseDivViewExtensionsKt.getHasSightActions(div.value())) {
            this.divView.bindViewToDiv$div_release(this.pagerView, div);
        }
        this.prevPosition = position;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        super.onPageScrolled(position, positionOffset, positionOffsetPixels);
        int width = this.minimumSignificantDx;
        if (width <= 0) {
            RecyclerView.LayoutManager layoutManager = this.recyclerView.getLayoutManager();
            width = (layoutManager != null ? layoutManager.getWidth() : 0) / 20;
        }
        int i = this.totalDelta + positionOffsetPixels;
        this.totalDelta = i;
        if (i > width) {
            this.totalDelta = 0;
            trackVisibleViews();
        }
    }

    private final void trackVisibleViews() {
        if (SequencesKt.count(ViewGroupKt.getChildren(this.recyclerView)) > 0) {
            trackVisibleChildren();
            return;
        }
        RecyclerView recyclerView = this.recyclerView;
        if (ViewsKt.isActuallyLaidOut(recyclerView) && !recyclerView.isLayoutRequested()) {
            trackVisibleChildren();
        } else {
            recyclerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.yandex.div.core.view2.divs.pager.DivPagerPageChangeCallback$trackVisibleViews$$inlined$doOnActualLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    view.removeOnLayoutChangeListener(this);
                    this.this$0.trackVisibleChildren();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackVisibleChildren() {
        View next;
        int childAdapterPosition;
        Iterator<View> it = ViewGroupKt.getChildren(this.recyclerView).iterator();
        while (it.hasNext() && (childAdapterPosition = this.recyclerView.getChildAdapterPosition((next = it.next()))) != -1) {
            DivItemBuilderResult divItemBuilderResult = this.items.get(childAdapterPosition);
            this.divView.getDiv2Component().getVisibilityActionTracker().startTrackingViewsHierarchy(this.bindingContext.getFor(divItemBuilderResult.getExpressionResolver()), next, divItemBuilderResult.getDiv());
        }
    }
}
