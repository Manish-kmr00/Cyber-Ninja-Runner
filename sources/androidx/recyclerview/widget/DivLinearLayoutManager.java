package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.json.b9;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.divs.gallery.DivGalleryAdapter;
import com.yandex.div.core.view2.divs.gallery.DivGalleryItemHelper;
import com.yandex.div.core.view2.divs.gallery.ScrollPosition;
import com.yandex.div.internal.core.DivItemBuilderResult;
import com.yandex.div.internal.widget.DivLayoutParams;
import com.yandex.div2.DivGallery;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivLinearLayoutManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001MB'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0019\u001a\u00020\nH\u0016J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0010H\u0016J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\u0010H\u0016J\u0010\u0010\"\u001a\u00020!2\u0006\u0010\u0019\u001a\u00020\nH\u0016J\b\u0010#\u001a\u00020\nH\u0016J\b\u0010$\u001a\u00020\nH\u0016J\b\u0010%\u001a\u00020\u001fH\u0016J\u001c\u0010&\u001a\u00020\u001f2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0012\u0010&\u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010+H\u0016J\u0012\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\nH\u0016J\b\u0010/\u001a\u00020\nH\u0016J\u0018\u00100\u001a\u00020!2\u0006\u0010.\u001a\u00020\n2\u0006\u00101\u001a\u000202H\u0016J \u00103\u001a\u00020!2\u0006\u0010.\u001a\u00020\n2\u0006\u00104\u001a\u00020\n2\u0006\u00101\u001a\u000202H\u0016J\b\u00105\u001a\u00020\nH\u0016J0\u00106\u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020\nH\u0016J0\u0010;\u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020\nH\u0016J \u0010<\u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010=\u001a\u00020\n2\u0006\u0010>\u001a\u00020\nH\u0016J \u0010?\u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010=\u001a\u00020\n2\u0006\u0010>\u001a\u00020\nH\u0016J\u0010\u0010@\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010A\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020\u00062\n\u0010B\u001a\u00060CR\u00020\u0006H\u0016J\u0012\u0010D\u001a\u00020!2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u0014\u0010G\u001a\u00020!2\n\u0010B\u001a\u00060CR\u00020\u0006H\u0016J\u0010\u0010H\u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\u0010H\u0016J\u0010\u0010I\u001a\u00020!2\u0006\u0010\u0019\u001a\u00020\nH\u0016J0\u0010J\u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020\nH\u0016J\b\u0010K\u001a\u00020\u0000H\u0016J\b\u0010L\u001a\u00020\nH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006N"}, d2 = {"Landroidx/recyclerview/widget/DivLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Lcom/yandex/div/core/view2/divs/gallery/DivGalleryItemHelper;", "bindingContext", "Lcom/yandex/div/core/view2/BindingContext;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "div", "Lcom/yandex/div2/DivGallery;", "orientation", "", "(Lcom/yandex/div/core/view2/BindingContext;Landroidx/recyclerview/widget/RecyclerView;Lcom/yandex/div2/DivGallery;I)V", "getBindingContext", "()Lcom/yandex/div/core/view2/BindingContext;", "childrenToRelayout", "Ljava/util/HashSet;", "Landroid/view/View;", "Lkotlin/collections/HashSet;", "getChildrenToRelayout", "()Ljava/util/HashSet;", "getDiv", "()Lcom/yandex/div2/DivGallery;", "getView", "()Landroidx/recyclerview/widget/RecyclerView;", "_getChildAt", "index", "_getPosition", "child", "checkLayoutParams", "", "lp", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "detachView", "", "detachViewAt", "firstCompletelyVisibleItemPosition", "firstVisibleItemPosition", "generateDefaultLayoutParams", "generateLayoutParams", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "Landroid/view/ViewGroup$LayoutParams;", "getItemDiv", "Lcom/yandex/div/internal/core/DivItemBuilderResult;", b9.h.L, "getLayoutManagerOrientation", "instantScrollToPosition", "scrollPosition", "Lcom/yandex/div/core/view2/divs/gallery/ScrollPosition;", "instantScrollToPositionWithOffset", "offset", "lastVisibleItemPosition", "layoutDecorated", "left", ViewHierarchyConstants.DIMENSION_TOP_KEY, "right", "bottom", "layoutDecoratedWithMargins", "measureChild", "widthUsed", "heightUsed", "measureChildWithMargins", "onAttachedToWindow", "onDetachedFromWindow", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "onLayoutCompleted", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "removeAndRecycleAllViews", "removeView", "removeViewAt", "superLayoutDecoratedWithMargins", "toLayoutManager", "width", "DivRecyclerViewLayoutParams", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivLinearLayoutManager extends LinearLayoutManager implements DivGalleryItemHelper {
    private final BindingContext bindingContext;
    private final HashSet<View> childrenToRelayout;
    private final DivGallery div;
    private final RecyclerView view;

    @Override // com.yandex.div.core.view2.divs.gallery.DivGalleryItemHelper
    public DivLinearLayoutManager toLayoutManager() {
        return this;
    }

    public /* synthetic */ DivLinearLayoutManager(BindingContext bindingContext, RecyclerView recyclerView, DivGallery divGallery, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(bindingContext, recyclerView, divGallery, (i2 & 8) != 0 ? 0 : i);
    }

    @Override // com.yandex.div.core.view2.divs.gallery.DivGalleryItemHelper
    public BindingContext getBindingContext() {
        return this.bindingContext;
    }

    @Override // com.yandex.div.core.view2.divs.gallery.DivGalleryItemHelper
    public RecyclerView getView() {
        return this.view;
    }

    @Override // com.yandex.div.core.view2.divs.gallery.DivGalleryItemHelper
    public DivGallery getDiv() {
        return this.div;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DivLinearLayoutManager(BindingContext bindingContext, RecyclerView view, DivGallery div, int i) {
        super(view.getContext(), i, false);
        Intrinsics.checkNotNullParameter(bindingContext, "bindingContext");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(div, "div");
        this.bindingContext = bindingContext;
        this.view = view;
        this.div = div;
        this.childrenToRelayout = new HashSet<>();
    }

    @Override // com.yandex.div.core.view2.divs.gallery.DivGalleryItemHelper
    public HashSet<View> getChildrenToRelayout() {
        return this.childrenToRelayout;
    }

    @Override // com.yandex.div.core.view2.divs.gallery.DivGalleryItemHelper
    public DivItemBuilderResult getItemDiv(int position) {
        RecyclerView.Adapter adapter = getView().getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.yandex.div.core.view2.divs.gallery.DivGalleryAdapter");
        return (DivItemBuilderResult) CollectionsKt.getOrNull(((DivGalleryAdapter) adapter).getVisibleItems(), position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void measureChild(View child, int widthUsed, int heightUsed) {
        Intrinsics.checkNotNullParameter(child, "child");
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.DivLinearLayoutManager.DivRecyclerViewLayoutParams");
        DivRecyclerViewLayoutParams divRecyclerViewLayoutParams = (DivRecyclerViewLayoutParams) layoutParams;
        Rect itemDecorInsetsForChild = getView().getItemDecorInsetsForChild(child);
        int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + widthUsed + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right, divRecyclerViewLayoutParams.width, divRecyclerViewLayoutParams.getMaxWidth(), canScrollHorizontally());
        int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + heightUsed + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom, divRecyclerViewLayoutParams.height, divRecyclerViewLayoutParams.getMaxHeight(), canScrollVertically());
        if (shouldMeasureChild(child, childMeasureSpec, childMeasureSpec2, divRecyclerViewLayoutParams)) {
            child.measure(childMeasureSpec, childMeasureSpec2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void measureChildWithMargins(View child, int widthUsed, int heightUsed) {
        Intrinsics.checkNotNullParameter(child, "child");
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.DivLinearLayoutManager.DivRecyclerViewLayoutParams");
        DivRecyclerViewLayoutParams divRecyclerViewLayoutParams = (DivRecyclerViewLayoutParams) layoutParams;
        Rect itemDecorInsetsForChild = getView().getItemDecorInsetsForChild(child);
        int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + divRecyclerViewLayoutParams.leftMargin + divRecyclerViewLayoutParams.rightMargin + widthUsed + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right, divRecyclerViewLayoutParams.width, divRecyclerViewLayoutParams.getMaxWidth(), canScrollHorizontally());
        int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + divRecyclerViewLayoutParams.topMargin + divRecyclerViewLayoutParams.bottomMargin + heightUsed + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom, divRecyclerViewLayoutParams.height, divRecyclerViewLayoutParams.getMaxHeight(), canScrollVertically());
        if (shouldMeasureChild(child, childMeasureSpec, childMeasureSpec2, divRecyclerViewLayoutParams)) {
            child.measure(childMeasureSpec, childMeasureSpec2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void layoutDecorated(View child, int left, int top, int right, int bottom) {
        Intrinsics.checkNotNullParameter(child, "child");
        super.layoutDecorated(child, left, top, right, bottom);
        _layoutDecorated(child, left, top, right, bottom);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        _onLayoutCompleted(state);
        super.onLayoutCompleted(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void layoutDecoratedWithMargins(View child, int left, int top, int right, int bottom) {
        Intrinsics.checkNotNullParameter(child, "child");
        DivGalleryItemHelper._layoutDecoratedWithMargins$default(this, child, left, top, right, bottom, false, 32, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void removeAndRecycleAllViews(RecyclerView.Recycler recycler) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        _removeAndRecycleAllViews(recycler);
        super.removeAndRecycleAllViews(recycler);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onAttachedToWindow(view);
        _onAttachedToWindow(view);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView view, RecyclerView.Recycler recycler) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        super.onDetachedFromWindow(view, recycler);
        _onDetachedFromWindow(view, recycler);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void detachView(View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        super.detachView(child);
        _detachView(child);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void detachViewAt(int index) {
        super.detachViewAt(index);
        _detachViewAt(index);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void removeView(View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        super.removeView(child);
        _removeView(child);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void removeViewAt(int index) {
        super.removeViewAt(index);
        _removeViewAt(index);
    }

    @Override // com.yandex.div.core.view2.divs.gallery.DivGalleryItemHelper
    public void superLayoutDecoratedWithMargins(View child, int left, int top, int right, int bottom) {
        Intrinsics.checkNotNullParameter(child, "child");
        super.layoutDecoratedWithMargins(child, left, top, right, bottom);
    }

    @Override // com.yandex.div.core.view2.divs.gallery.DivGalleryItemHelper
    public int firstCompletelyVisibleItemPosition() {
        return findFirstCompletelyVisibleItemPosition();
    }

    @Override // com.yandex.div.core.view2.divs.gallery.DivGalleryItemHelper
    public int firstVisibleItemPosition() {
        return findFirstVisibleItemPosition();
    }

    @Override // com.yandex.div.core.view2.divs.gallery.DivGalleryItemHelper
    public int lastVisibleItemPosition() {
        return findLastVisibleItemPosition();
    }

    @Override // com.yandex.div.core.view2.divs.gallery.DivGalleryItemHelper
    public View _getChildAt(int index) {
        return getChildAt(index);
    }

    @Override // com.yandex.div.core.view2.divs.gallery.DivGalleryItemHelper
    public int _getPosition(View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        return getPosition(child);
    }

    @Override // com.yandex.div.core.view2.divs.gallery.DivGalleryItemHelper
    public int width() {
        return getWidth();
    }

    @Override // com.yandex.div.core.view2.divs.gallery.DivGalleryItemHelper
    public int getLayoutManagerOrientation() {
        return getOrientation();
    }

    @Override // com.yandex.div.core.view2.divs.gallery.DivGalleryItemHelper
    public void instantScrollToPosition(int position, ScrollPosition scrollPosition) {
        Intrinsics.checkNotNullParameter(scrollPosition, "scrollPosition");
        DivGalleryItemHelper.instantScroll$default(this, position, scrollPosition, 0, 4, null);
    }

    @Override // com.yandex.div.core.view2.divs.gallery.DivGalleryItemHelper
    public void instantScrollToPositionWithOffset(int position, int offset, ScrollPosition scrollPosition) {
        Intrinsics.checkNotNullParameter(scrollPosition, "scrollPosition");
        instantScroll(position, scrollPosition, offset);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams lp) {
        return lp instanceof DivRecyclerViewLayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context c, AttributeSet attrs) {
        return new DivRecyclerViewLayoutParams(c, attrs);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams lp) {
        if (lp instanceof DivRecyclerViewLayoutParams) {
            return new DivRecyclerViewLayoutParams((DivRecyclerViewLayoutParams) lp);
        }
        if (lp instanceof RecyclerView.LayoutParams) {
            return new DivRecyclerViewLayoutParams((RecyclerView.LayoutParams) lp);
        }
        if (lp instanceof DivLayoutParams) {
            return new DivRecyclerViewLayoutParams((DivLayoutParams) lp);
        }
        return lp instanceof ViewGroup.MarginLayoutParams ? new DivRecyclerViewLayoutParams((ViewGroup.MarginLayoutParams) lp) : new DivRecyclerViewLayoutParams(lp);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new DivRecyclerViewLayoutParams(-2, -2);
    }

    /* JADX INFO: compiled from: DivLinearLayoutManager.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nB\u0011\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rB\u0011\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fB\u0011\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0010B\u000f\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\u0000¢\u0006\u0002\u0010\u0011B\u000f\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018¨\u0006\u001c"}, d2 = {"Landroidx/recyclerview/widget/DivLinearLayoutManager$DivRecyclerViewLayoutParams;", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "width", "", "height", "(II)V", "source", "Landroid/view/ViewGroup$MarginLayoutParams;", "(Landroid/view/ViewGroup$MarginLayoutParams;)V", "Landroid/view/ViewGroup$LayoutParams;", "(Landroid/view/ViewGroup$LayoutParams;)V", "(Landroidx/recyclerview/widget/RecyclerView$LayoutParams;)V", "(Landroidx/recyclerview/widget/DivLinearLayoutManager$DivRecyclerViewLayoutParams;)V", "Lcom/yandex/div/internal/widget/DivLayoutParams;", "(Lcom/yandex/div/internal/widget/DivLayoutParams;)V", "maxHeight", "getMaxHeight", "()I", "setMaxHeight", "(I)V", "maxWidth", "getMaxWidth", "setMaxWidth", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class DivRecyclerViewLayoutParams extends RecyclerView.LayoutParams {
        private int maxHeight;
        private int maxWidth;

        public final int getMaxHeight() {
            return this.maxHeight;
        }

        public final void setMaxHeight(int i) {
            this.maxHeight = i;
        }

        public final int getMaxWidth() {
            return this.maxWidth;
        }

        public final void setMaxWidth(int i) {
            this.maxWidth = i;
        }

        public DivRecyclerViewLayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.maxHeight = Integer.MAX_VALUE;
            this.maxWidth = Integer.MAX_VALUE;
        }

        public DivRecyclerViewLayoutParams(int i, int i2) {
            super(i, i2);
            this.maxHeight = Integer.MAX_VALUE;
            this.maxWidth = Integer.MAX_VALUE;
        }

        public DivRecyclerViewLayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.maxHeight = Integer.MAX_VALUE;
            this.maxWidth = Integer.MAX_VALUE;
        }

        public DivRecyclerViewLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.maxHeight = Integer.MAX_VALUE;
            this.maxWidth = Integer.MAX_VALUE;
        }

        public DivRecyclerViewLayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
            this.maxHeight = Integer.MAX_VALUE;
            this.maxWidth = Integer.MAX_VALUE;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DivRecyclerViewLayoutParams(DivRecyclerViewLayoutParams source) {
            super((RecyclerView.LayoutParams) source);
            Intrinsics.checkNotNullParameter(source, "source");
            this.maxHeight = Integer.MAX_VALUE;
            this.maxWidth = Integer.MAX_VALUE;
            this.maxHeight = source.maxHeight;
            this.maxWidth = source.maxWidth;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DivRecyclerViewLayoutParams(DivLayoutParams source) {
            super((ViewGroup.MarginLayoutParams) source);
            Intrinsics.checkNotNullParameter(source, "source");
            this.maxHeight = Integer.MAX_VALUE;
            this.maxWidth = Integer.MAX_VALUE;
            this.maxHeight = source.getMaxHeight();
            this.maxWidth = source.getMaxWidth();
        }
    }
}
