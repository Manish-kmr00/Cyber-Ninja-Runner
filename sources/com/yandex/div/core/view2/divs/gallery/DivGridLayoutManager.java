package com.yandex.div.core.view2.divs.gallery;

import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.json.b9;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.KAssert;
import com.yandex.div.internal.core.DivItemBuilderResult;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div2.DivBase;
import com.yandex.div2.DivGallery;
import com.yandex.div2.DivSize;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: DivGridLayoutManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001e\u001a\u00020\nH\u0016J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u0010H\u0016J\u0018\u0010!\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u0010H\u0016J\u0010\u0010&\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\nH\u0016J\b\u0010'\u001a\u00020\nH\u0016J\b\u0010(\u001a\u00020\nH\u0016J\u0012\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\nH\u0016J\b\u0010,\u001a\u00020\nH\u0016J\b\u0010-\u001a\u00020\nH\u0016J\b\u0010.\u001a\u00020\nH\u0016J\b\u0010/\u001a\u00020\nH\u0016J\b\u00100\u001a\u00020\nH\u0016J\b\u00101\u001a\u00020\nH\u0016J\b\u00102\u001a\u00020\nH\u0016J\u0018\u00103\u001a\u00020\"2\u0006\u0010+\u001a\u00020\n2\u0006\u00104\u001a\u000205H\u0016J \u00106\u001a\u00020\"2\u0006\u0010+\u001a\u00020\n2\u0006\u00107\u001a\u00020\n2\u0006\u00104\u001a\u000205H\u0016J\b\u00108\u001a\u00020\nH\u0016J0\u00109\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010:\u001a\u00020\n2\u0006\u0010;\u001a\u00020\n2\u0006\u0010<\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nH\u0016J0\u0010>\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010:\u001a\u00020\n2\u0006\u0010;\u001a\u00020\n2\u0006\u0010<\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nH\u0016J\u0010\u0010?\u001a\u00020\"2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010@\u001a\u00020\"2\u0006\u0010\u0005\u001a\u00020\u00062\n\u0010A\u001a\u00060BR\u00020\u0006H\u0016J\u0012\u0010C\u001a\u00020\"2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\u0014\u0010F\u001a\u00020\"2\n\u0010A\u001a\u00060BR\u00020\u0006H\u0016J\u0010\u0010G\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u0010H\u0016J\u0010\u0010H\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\nH\u0016J\u0010\u0010I\u001a\u00020\n2\u0006\u0010J\u001a\u00020\nH\u0002J0\u0010K\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010:\u001a\u00020\n2\u0006\u0010;\u001a\u00020\n2\u0006\u0010<\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nH\u0016J\b\u0010L\u001a\u00020\u0000H\u0016J\b\u0010M\u001a\u00020\nH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006N"}, d2 = {"Lcom/yandex/div/core/view2/divs/gallery/DivGridLayoutManager;", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "Lcom/yandex/div/core/view2/divs/gallery/DivGalleryItemHelper;", "bindingContext", "Lcom/yandex/div/core/view2/BindingContext;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "div", "Lcom/yandex/div2/DivGallery;", "orientation", "", "(Lcom/yandex/div/core/view2/BindingContext;Landroidx/recyclerview/widget/RecyclerView;Lcom/yandex/div2/DivGallery;I)V", "getBindingContext", "()Lcom/yandex/div/core/view2/BindingContext;", "childrenToRelayout", "Ljava/util/HashSet;", "Landroid/view/View;", "Lkotlin/collections/HashSet;", "getChildrenToRelayout", "()Ljava/util/HashSet;", "crossSpacing", "getCrossSpacing", "()I", "getDiv", "()Lcom/yandex/div2/DivGallery;", "itemSpacing", "getItemSpacing", "getView", "()Landroidx/recyclerview/widget/RecyclerView;", "_getChildAt", "index", "_getPosition", "child", "calculateItemDecorationsForChild", "", "outRect", "Landroid/graphics/Rect;", "detachView", "detachViewAt", "firstCompletelyVisibleItemPosition", "firstVisibleItemPosition", "getItemDiv", "Lcom/yandex/div/internal/core/DivItemBuilderResult;", b9.h.L, "getLayoutManagerOrientation", "getPaddingBottom", "getPaddingEnd", "getPaddingLeft", "getPaddingRight", "getPaddingStart", "getPaddingTop", "instantScrollToPosition", "scrollPosition", "Lcom/yandex/div/core/view2/divs/gallery/ScrollPosition;", "instantScrollToPositionWithOffset", "offset", "lastVisibleItemPosition", "layoutDecorated", "left", ViewHierarchyConstants.DIMENSION_TOP_KEY, "right", "bottom", "layoutDecoratedWithMargins", "onAttachedToWindow", "onDetachedFromWindow", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "onLayoutCompleted", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "removeAndRecycleAllViews", "removeView", "removeViewAt", "spacingByOrientation", "alongOrientation", "superLayoutDecoratedWithMargins", "toLayoutManager", "width", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivGridLayoutManager extends StaggeredGridLayoutManager implements DivGalleryItemHelper {
    private final BindingContext bindingContext;
    private final HashSet<View> childrenToRelayout;
    private final DivGallery div;
    private final RecyclerView view;

    @Override // com.yandex.div.core.view2.divs.gallery.DivGalleryItemHelper
    public DivGridLayoutManager toLayoutManager() {
        return this;
    }

    public /* synthetic */ DivGridLayoutManager(BindingContext bindingContext, RecyclerView recyclerView, DivGallery divGallery, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
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

    /* JADX WARN: Illegal instructions before constructor call */
    public DivGridLayoutManager(BindingContext bindingContext, RecyclerView view, DivGallery div, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(bindingContext, "bindingContext");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(div, "div");
        Expression<Long> expression = div.columnCount;
        if (expression != null) {
            long jLongValue = expression.evaluate(bindingContext.getExpressionResolver()).longValue();
            long j = jLongValue >> 31;
            if (j == 0 || j == -1) {
                i2 = (int) jLongValue;
            } else {
                KAssert kAssert = KAssert.INSTANCE;
                if (Assert.isEnabled()) {
                    Assert.fail("Unable convert '" + jLongValue + "' to Int");
                }
                i2 = jLongValue > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        } else {
            i2 = 1;
        }
        super(i2, i);
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

    private final int getItemSpacing() {
        Long lEvaluate = getDiv().itemSpacing.evaluate(getBindingContext().getExpressionResolver());
        DisplayMetrics displayMetrics = getView().getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "view.resources.displayMetrics");
        return BaseDivViewExtensionsKt.dpToPx(lEvaluate, displayMetrics);
    }

    private final int getCrossSpacing() {
        Expression<Long> expression = getDiv().crossSpacing;
        if (expression == null) {
            return getItemSpacing();
        }
        Long lValueOf = Long.valueOf(expression.evaluate(getBindingContext().getExpressionResolver()).longValue());
        DisplayMetrics displayMetrics = getView().getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "view.resources.displayMetrics");
        return BaseDivViewExtensionsKt.dpToPx(lValueOf, displayMetrics);
    }

    private final int spacingByOrientation(int alongOrientation) {
        return alongOrientation == getOrientation() ? getItemSpacing() : getCrossSpacing();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getPaddingStart() {
        return super.getPaddingStart() - (getItemSpacing() / 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getPaddingEnd() {
        return super.getPaddingEnd() - (getItemSpacing() / 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getPaddingLeft() {
        return super.getPaddingLeft() - (spacingByOrientation(0) / 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getPaddingTop() {
        return super.getPaddingTop() - (spacingByOrientation(1) / 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getPaddingRight() {
        return super.getPaddingRight() - (spacingByOrientation(0) / 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getPaddingBottom() {
        return super.getPaddingBottom() - (spacingByOrientation(1) / 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void layoutDecorated(View child, int left, int top, int right, int bottom) {
        Intrinsics.checkNotNullParameter(child, "child");
        super.layoutDecorated(child, left, top, right, bottom);
        _layoutDecorated(child, left, top, right, bottom);
    }

    @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        _onLayoutCompleted(state);
        super.onLayoutCompleted(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void calculateItemDecorationsForChild(View child, Rect outRect) {
        DivItemBuilderResult itemDiv;
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        super.calculateItemDecorationsForChild(child, outRect);
        int i_getPosition = _getPosition(child);
        if (i_getPosition == -1 || (itemDiv = getItemDiv(i_getPosition)) == null) {
            return;
        }
        DivBase divBaseValue = itemDiv.getDiv().value();
        boolean z = divBaseValue.getHeight() instanceof DivSize.Fixed;
        boolean z2 = divBaseValue.getWidth() instanceof DivSize.Fixed;
        int iSpacingByOrientation = 0;
        boolean z3 = getSpanCount() > 1;
        int iSpacingByOrientation2 = (z && z3) ? spacingByOrientation(1) / 2 : 0;
        if (z2 && z3) {
            iSpacingByOrientation = spacingByOrientation(0) / 2;
        }
        outRect.set(outRect.left - iSpacingByOrientation, outRect.top - iSpacingByOrientation2, outRect.right - iSpacingByOrientation, outRect.bottom - iSpacingByOrientation2);
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

    @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
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
        int[] iArr = new int[RangesKt.coerceAtLeast(getItemCount(), getSpanCount())];
        findFirstCompletelyVisibleItemPositions(iArr);
        return ArraysKt.first(iArr);
    }

    @Override // com.yandex.div.core.view2.divs.gallery.DivGalleryItemHelper
    public int firstVisibleItemPosition() {
        int[] iArr = new int[RangesKt.coerceAtLeast(getItemCount(), getSpanCount())];
        findFirstVisibleItemPositions(iArr);
        return ArraysKt.first(iArr);
    }

    @Override // com.yandex.div.core.view2.divs.gallery.DivGalleryItemHelper
    public int lastVisibleItemPosition() {
        int[] iArr = new int[RangesKt.coerceAtLeast(getItemCount(), getSpanCount())];
        findLastVisibleItemPositions(iArr);
        return ArraysKt.last(iArr);
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
}
