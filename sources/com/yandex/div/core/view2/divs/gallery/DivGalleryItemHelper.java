package com.yandex.div.core.view2.divs.gallery;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.json.b9;
import com.yandex.div.R;
import com.yandex.div.core.util.ViewsKt;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.divs.widgets.DivHolderView;
import com.yandex.div.internal.core.DivItemBuilderResult;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.Div;
import com.yandex.div2.DivAlignmentHorizontal;
import com.yandex.div2.DivAlignmentVertical;
import com.yandex.div2.DivBase;
import com.yandex.div2.DivGallery;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: DivGalleryItemHelper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u0000 G2\u00020\u0001:\u0001GJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bH\u0016J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\bH&J0\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0018H\u0016J:\u0010 \u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u00182\b\b\u0002\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010$\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\n\u0010%\u001a\u00060&R\u00020\u0010H\u0016J\u0012\u0010'\u001a\u00020\u00142\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0014\u0010*\u001a\u00020\u00142\n\u0010%\u001a\u00060&R\u00020\u0010H\u0016J\u0010\u0010+\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bH\u0016J\u0010\u0010,\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010-\u001a\u00020\u0018H&J\b\u0010.\u001a\u00020\u0018H&J8\u0010/\u001a\u00020\u00182\u0006\u00100\u001a\u00020\u00182\u0006\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u00020\u00182\u0006\u00104\u001a\u00020\u00182\u0006\u00105\u001a\u00020\"H\u0016J\u0012\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u00020\u0018H&J\b\u00109\u001a\u00020\u0018H&J$\u0010:\u001a\u00020\u00142\u0006\u00108\u001a\u00020\u00182\b\b\u0002\u0010;\u001a\u00020<2\b\b\u0002\u0010=\u001a\u00020\u0018H\u0016J\u0018\u0010>\u001a\u00020\u00142\u0006\u00108\u001a\u00020\u00182\u0006\u0010;\u001a\u00020<H&J \u0010?\u001a\u00020\u00142\u0006\u00108\u001a\u00020\u00182\u0006\u0010=\u001a\u00020\u00182\u0006\u0010;\u001a\u00020<H&J\b\u0010@\u001a\u00020\u0018H&J0\u0010A\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0018H&J\b\u0010B\u001a\u00020CH&J\u001a\u0010D\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010E\u001a\u00020\"H\u0016J\b\u0010F\u001a\u00020\u0018H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006HÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/view2/divs/gallery/DivGalleryItemHelper;", "", "bindingContext", "Lcom/yandex/div/core/view2/BindingContext;", "getBindingContext", "()Lcom/yandex/div/core/view2/BindingContext;", "childrenToRelayout", "", "Landroid/view/View;", "getChildrenToRelayout", "()Ljava/util/Set;", "div", "Lcom/yandex/div2/DivGallery;", "getDiv", "()Lcom/yandex/div2/DivGallery;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "getView", "()Landroidx/recyclerview/widget/RecyclerView;", "_detachView", "", "child", "_detachViewAt", "index", "", "_getChildAt", "_getPosition", "_layoutDecorated", "left", ViewHierarchyConstants.DIMENSION_TOP_KEY, "right", "bottom", "_layoutDecoratedWithMargins", "isRelayoutingChildren", "", "_onAttachedToWindow", "_onDetachedFromWindow", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "_onLayoutCompleted", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "_removeAndRecycleAllViews", "_removeView", "_removeViewAt", "firstCompletelyVisibleItemPosition", "firstVisibleItemPosition", "getChildMeasureSpec", "parentSize", "parentMode", VastAttributes.PADDING, "childDimension", SDKConstants.PARAM_CONTEXT_MAX_SIZE, "canScroll", "getItemDiv", "Lcom/yandex/div/internal/core/DivItemBuilderResult;", b9.h.L, "getLayoutManagerOrientation", "instantScroll", "scrollPosition", "Lcom/yandex/div/core/view2/divs/gallery/ScrollPosition;", "offset", "instantScrollToPosition", "instantScrollToPositionWithOffset", "lastVisibleItemPosition", "superLayoutDecoratedWithMargins", "toLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "trackVisibilityAction", "clear", "width", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface DivGalleryItemHelper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: DivGalleryItemHelper.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ScrollPosition.values().length];
            try {
                iArr[ScrollPosition.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ScrollPosition.DEFAULT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    View _getChildAt(int index);

    int _getPosition(View child);

    int firstCompletelyVisibleItemPosition();

    int firstVisibleItemPosition();

    BindingContext getBindingContext();

    Set<View> getChildrenToRelayout();

    DivGallery getDiv();

    DivItemBuilderResult getItemDiv(int position);

    int getLayoutManagerOrientation();

    RecyclerView getView();

    void instantScrollToPosition(int position, ScrollPosition scrollPosition);

    void instantScrollToPositionWithOffset(int position, int offset, ScrollPosition scrollPosition);

    int lastVisibleItemPosition();

    void superLayoutDecoratedWithMargins(View child, int left, int top, int right, int bottom);

    RecyclerView.LayoutManager toLayoutManager();

    int width();

    default void _layoutDecorated(View child, int left, int top, int right, int bottom) {
        Intrinsics.checkNotNullParameter(child, "child");
        trackVisibilityAction$default(this, child, false, 2, null);
    }

    default void _onLayoutCompleted(RecyclerView.State state) {
        for (View view : getChildrenToRelayout()) {
            _layoutDecoratedWithMargins(view, view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), true);
        }
        getChildrenToRelayout().clear();
    }

    static /* synthetic */ void _layoutDecoratedWithMargins$default(DivGalleryItemHelper divGalleryItemHelper, View view, int i, int i2, int i3, int i4, boolean z, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: _layoutDecoratedWithMargins");
        }
        if ((i5 & 32) != 0) {
            z = false;
        }
        divGalleryItemHelper._layoutDecoratedWithMargins(view, i, i2, i3, i4, z);
    }

    default void _layoutDecoratedWithMargins(View child, int left, int top, int right, int bottom, boolean isRelayoutingChildren) {
        ExpressionResolver expressionResolver;
        int iCalculateOffset;
        int iCalculateOffset2;
        DivGallery.CrossContentAlignment crossContentAlignmentEvaluate;
        DivAlignmentVertical divAlignmentVerticalEvaluate;
        DivGallery.CrossContentAlignment crossContentAlignmentEvaluate2;
        DivAlignmentHorizontal divAlignmentHorizontalEvaluate;
        Div div;
        Intrinsics.checkNotNullParameter(child, "child");
        int layoutManagerOrientation = getLayoutManagerOrientation();
        if (layoutManagerOrientation == 0 ? getView().getMeasuredHeight() == 0 || child.getMeasuredHeight() == 0 : layoutManagerOrientation == 1 && (getView().getMeasuredWidth() == 0 || child.getMeasuredWidth() == 0)) {
            superLayoutDecoratedWithMargins(child, left, top, right, bottom);
            if (isRelayoutingChildren) {
                return;
            }
            getChildrenToRelayout().add(child);
            return;
        }
        Integer num = (Integer) child.getTag(R.id.div_gallery_item_index);
        DivItemBuilderResult itemDiv = num != null ? getItemDiv(num.intValue()) : null;
        DivBase divBaseValue = (itemDiv == null || (div = itemDiv.getDiv()) == null) ? null : div.value();
        if (itemDiv == null || (expressionResolver = itemDiv.getExpressionResolver()) == null) {
            expressionResolver = getBindingContext().getExpressionResolver();
        }
        Expression<DivGallery.CrossContentAlignment> expression = getDiv().crossContentAlignment;
        if (layoutManagerOrientation == 1) {
            Companion companion = INSTANCE;
            Expression<DivAlignmentHorizontal> alignmentHorizontal = divBaseValue != null ? divBaseValue.getAlignmentHorizontal() : null;
            if (alignmentHorizontal == null || (divAlignmentHorizontalEvaluate = alignmentHorizontal.evaluate(expressionResolver)) == null || (crossContentAlignmentEvaluate2 = companion.asCrossContentAlignment(divAlignmentHorizontalEvaluate)) == null) {
                crossContentAlignmentEvaluate2 = expression.evaluate(expressionResolver);
            }
            iCalculateOffset = companion.calculateOffset((getView().getMeasuredWidth() - getView().getPaddingLeft()) - getView().getPaddingRight(), right - left, crossContentAlignmentEvaluate2);
        } else {
            iCalculateOffset = 0;
        }
        if (layoutManagerOrientation == 0) {
            Companion companion2 = INSTANCE;
            Expression<DivAlignmentVertical> alignmentVertical = divBaseValue != null ? divBaseValue.getAlignmentVertical() : null;
            if (alignmentVertical == null || (divAlignmentVerticalEvaluate = alignmentVertical.evaluate(expressionResolver)) == null || (crossContentAlignmentEvaluate = companion2.asCrossContentAlignment(divAlignmentVerticalEvaluate)) == null) {
                crossContentAlignmentEvaluate = expression.evaluate(expressionResolver);
            }
            iCalculateOffset2 = companion2.calculateOffset((getView().getMeasuredHeight() - getView().getPaddingTop()) - getView().getPaddingBottom(), bottom - top, crossContentAlignmentEvaluate);
        } else {
            iCalculateOffset2 = 0;
        }
        superLayoutDecoratedWithMargins(child, left + iCalculateOffset, top + iCalculateOffset2, right + iCalculateOffset, bottom + iCalculateOffset2);
        trackVisibilityAction$default(this, child, false, 2, null);
        if (isRelayoutingChildren) {
            return;
        }
        getChildrenToRelayout().remove(child);
    }

    static /* synthetic */ void instantScroll$default(DivGalleryItemHelper divGalleryItemHelper, int i, ScrollPosition scrollPosition, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: instantScroll");
        }
        if ((i3 & 2) != 0) {
            scrollPosition = ScrollPosition.DEFAULT;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        divGalleryItemHelper.instantScroll(i, scrollPosition, i2);
    }

    default void instantScroll(final int position, final ScrollPosition scrollPosition, final int offset) {
        Intrinsics.checkNotNullParameter(scrollPosition, "scrollPosition");
        RecyclerView view = getView();
        if (!ViewsKt.isActuallyLaidOut(view) || view.isLayoutRequested()) {
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.yandex.div.core.view2.divs.gallery.DivGalleryItemHelper$instantScroll$$inlined$doOnActualLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view2, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    view2.removeOnLayoutChangeListener(this);
                    if (position == 0) {
                        RecyclerView view3 = this.getView();
                        int i = offset;
                        view3.scrollBy(-i, -i);
                        return;
                    }
                    this.getView().scrollBy(-this.getView().getScrollX(), -this.getView().getScrollY());
                    RecyclerView.LayoutManager layoutManager = this.getView().getLayoutManager();
                    View viewFindViewByPosition = layoutManager != null ? layoutManager.findViewByPosition(position) : null;
                    OrientationHelper orientationHelperCreateOrientationHelper = OrientationHelper.createOrientationHelper(this.getView().getLayoutManager(), this.getLayoutManagerOrientation());
                    while (viewFindViewByPosition == null && (this.getView().canScrollVertically(1) || this.getView().canScrollHorizontally(1))) {
                        RecyclerView.LayoutManager layoutManager2 = this.getView().getLayoutManager();
                        if (layoutManager2 != null) {
                            layoutManager2.requestLayout();
                        }
                        RecyclerView.LayoutManager layoutManager3 = this.getView().getLayoutManager();
                        viewFindViewByPosition = layoutManager3 != null ? layoutManager3.findViewByPosition(position) : null;
                        if (viewFindViewByPosition != null) {
                            break;
                        } else {
                            this.getView().scrollBy(this.getView().getWidth(), this.getView().getHeight());
                        }
                    }
                    if (viewFindViewByPosition != null) {
                        int i2 = DivGalleryItemHelper.WhenMappings.$EnumSwitchMapping$0[scrollPosition.ordinal()];
                        if (i2 == 1) {
                            int[] iArr = {0, 0};
                            int[] iArr2 = {0, 0};
                            this.getView().getLocationOnScreen(iArr2);
                            viewFindViewByPosition.getLocationOnScreen(iArr);
                            this.getView().scrollBy(((viewFindViewByPosition.getWidth() - this.getView().getWidth()) / 2) + (iArr[0] - iArr2[0]), ((viewFindViewByPosition.getHeight() - this.getView().getHeight()) / 2) + (iArr[1] - iArr2[1]));
                            return;
                        }
                        if (i2 != 2) {
                            return;
                        }
                        int decoratedStart = orientationHelperCreateOrientationHelper.getDecoratedStart(viewFindViewByPosition) - offset;
                        ViewGroup.LayoutParams layoutParams = viewFindViewByPosition.getLayoutParams();
                        int marginStart = decoratedStart + (layoutParams instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) layoutParams).getMarginStart() : 0);
                        if (this.getView().getClipToPadding()) {
                            marginStart -= orientationHelperCreateOrientationHelper.getStartAfterPadding();
                        }
                        this.getView().scrollBy(marginStart, marginStart);
                    }
                }
            });
            return;
        }
        if (position == 0) {
            int i = -offset;
            getView().scrollBy(i, i);
            return;
        }
        getView().scrollBy(-getView().getScrollX(), -getView().getScrollY());
        RecyclerView.LayoutManager layoutManager = getView().getLayoutManager();
        View viewFindViewByPosition = layoutManager != null ? layoutManager.findViewByPosition(position) : null;
        OrientationHelper orientationHelperCreateOrientationHelper = OrientationHelper.createOrientationHelper(getView().getLayoutManager(), getLayoutManagerOrientation());
        while (viewFindViewByPosition == null && (getView().canScrollVertically(1) || getView().canScrollHorizontally(1))) {
            RecyclerView.LayoutManager layoutManager2 = getView().getLayoutManager();
            if (layoutManager2 != null) {
                layoutManager2.requestLayout();
            }
            RecyclerView.LayoutManager layoutManager3 = getView().getLayoutManager();
            viewFindViewByPosition = layoutManager3 != null ? layoutManager3.findViewByPosition(position) : null;
            if (viewFindViewByPosition != null) {
                break;
            } else {
                getView().scrollBy(getView().getWidth(), getView().getHeight());
            }
        }
        if (viewFindViewByPosition != null) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[scrollPosition.ordinal()];
            if (i2 == 1) {
                int[] iArr = {0, 0};
                int[] iArr2 = {0, 0};
                getView().getLocationOnScreen(iArr2);
                viewFindViewByPosition.getLocationOnScreen(iArr);
                getView().scrollBy(((viewFindViewByPosition.getWidth() - getView().getWidth()) / 2) + (iArr[0] - iArr2[0]), ((viewFindViewByPosition.getHeight() - getView().getHeight()) / 2) + (iArr[1] - iArr2[1]));
                return;
            }
            if (i2 != 2) {
                return;
            }
            int decoratedStart = orientationHelperCreateOrientationHelper.getDecoratedStart(viewFindViewByPosition) - offset;
            ViewGroup.LayoutParams layoutParams = viewFindViewByPosition.getLayoutParams();
            int marginStart = decoratedStart + (layoutParams instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) layoutParams).getMarginStart() : 0);
            if (getView().getClipToPadding()) {
                marginStart -= orientationHelperCreateOrientationHelper.getStartAfterPadding();
            }
            getView().scrollBy(marginStart, marginStart);
        }
    }

    default void _removeAndRecycleAllViews(RecyclerView.Recycler recycler) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        RecyclerView view = getView();
        int childCount = view.getChildCount();
        for (int i = 0; i < childCount; i++) {
            trackVisibilityAction(view.getChildAt(i), true);
        }
    }

    default void _onAttachedToWindow(RecyclerView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        RecyclerView recyclerView = view;
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            trackVisibilityAction$default(this, recyclerView.getChildAt(i), false, 2, null);
        }
    }

    default void _onDetachedFromWindow(RecyclerView view, RecyclerView.Recycler recycler) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        RecyclerView recyclerView = view;
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            trackVisibilityAction(recyclerView.getChildAt(i), true);
        }
    }

    default void _detachView(View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        trackVisibilityAction(child, true);
    }

    default void _detachViewAt(int index) {
        View view_getChildAt = _getChildAt(index);
        if (view_getChildAt == null) {
            return;
        }
        trackVisibilityAction(view_getChildAt, true);
    }

    default void _removeView(View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        trackVisibilityAction(child, true);
    }

    default void _removeViewAt(int index) {
        View view_getChildAt = _getChildAt(index);
        if (view_getChildAt == null) {
            return;
        }
        trackVisibilityAction(view_getChildAt, true);
    }

    static /* synthetic */ void trackVisibilityAction$default(DivGalleryItemHelper divGalleryItemHelper, View view, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackVisibilityAction");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        divGalleryItemHelper.trackVisibilityAction(view, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    default void trackVisibilityAction(View child, boolean clear) {
        View view;
        BindingContext bindingContext;
        Intrinsics.checkNotNullParameter(child, "child");
        int i_getPosition = _getPosition(child);
        if (i_getPosition == -1) {
            return;
        }
        ViewGroup viewGroup = child instanceof ViewGroup ? (ViewGroup) child : null;
        if (viewGroup == null || (view = (View) SequencesKt.firstOrNull(ViewGroupKt.getChildren(viewGroup))) == 0) {
            return;
        }
        Div2View divView = getBindingContext().getDivView();
        if (clear) {
            Div divTakeBindingDiv$div_release = divView.takeBindingDiv$div_release(view);
            if (divTakeBindingDiv$div_release == null) {
                return;
            }
            DivHolderView divHolderView = view instanceof DivHolderView ? (DivHolderView) view : null;
            if (divHolderView == null || (bindingContext = divHolderView.getBindingContext()) == null) {
                return;
            }
            divView.getDiv2Component().getVisibilityActionTracker().cancelTrackingViewsHierarchy(bindingContext, view, divTakeBindingDiv$div_release);
            divView.unbindViewFromDiv$div_release(view);
            return;
        }
        DivItemBuilderResult itemDiv = getItemDiv(i_getPosition);
        if (itemDiv == null) {
            return;
        }
        divView.getDiv2Component().getVisibilityActionTracker().startTrackingViewsHierarchy(getBindingContext().getFor(itemDiv.getExpressionResolver()), view, itemDiv.getDiv());
        divView.bindViewToDiv$div_release(view, itemDiv.getDiv());
    }

    /* JADX INFO: compiled from: DivGalleryItemHelper.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\f\u0010\t\u001a\u00020\b*\u00020\nH\u0002J\f\u0010\t\u001a\u00020\b*\u00020\u000bH\u0002JN\u0010\f\u001a\u00020\b\"\b\b\u0000\u0010\r*\u00020\u0001*\n\u0012\u0004\u0012\u0002H\r\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u000e2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\b0\u0012¢\u0006\u0002\b\u0013H\u0082\b¨\u0006\u0014"}, d2 = {"Lcom/yandex/div/core/view2/divs/gallery/DivGalleryItemHelper$Companion;", "", "()V", "calculateOffset", "", "totalSpace", "decoratedMeasurement", "crossContentAlignment", "Lcom/yandex/div2/DivGallery$CrossContentAlignment;", "asCrossContentAlignment", "Lcom/yandex/div2/DivAlignmentHorizontal;", "Lcom/yandex/div2/DivAlignmentVertical;", "evaluateAlignment", "T", "Lcom/yandex/div/json/expressions/Expression;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "parentAlignment", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* JADX INFO: compiled from: DivGalleryItemHelper.kt */
        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;
            public static final /* synthetic */ int[] $EnumSwitchMapping$2;

            static {
                int[] iArr = new int[DivGallery.CrossContentAlignment.values().length];
                try {
                    iArr[DivGallery.CrossContentAlignment.START.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[DivGallery.CrossContentAlignment.CENTER.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[DivGallery.CrossContentAlignment.END.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
                int[] iArr2 = new int[DivAlignmentHorizontal.values().length];
                try {
                    iArr2[DivAlignmentHorizontal.LEFT.ordinal()] = 1;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr2[DivAlignmentHorizontal.CENTER.ordinal()] = 2;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr2[DivAlignmentHorizontal.RIGHT.ordinal()] = 3;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr2[DivAlignmentHorizontal.START.ordinal()] = 4;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr2[DivAlignmentHorizontal.END.ordinal()] = 5;
                } catch (NoSuchFieldError unused8) {
                }
                $EnumSwitchMapping$1 = iArr2;
                int[] iArr3 = new int[DivAlignmentVertical.values().length];
                try {
                    iArr3[DivAlignmentVertical.TOP.ordinal()] = 1;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    iArr3[DivAlignmentVertical.BASELINE.ordinal()] = 2;
                } catch (NoSuchFieldError unused10) {
                }
                try {
                    iArr3[DivAlignmentVertical.CENTER.ordinal()] = 3;
                } catch (NoSuchFieldError unused11) {
                }
                try {
                    iArr3[DivAlignmentVertical.BOTTOM.ordinal()] = 4;
                } catch (NoSuchFieldError unused12) {
                }
                $EnumSwitchMapping$2 = iArr3;
            }
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int calculateOffset(int totalSpace, int decoratedMeasurement, DivGallery.CrossContentAlignment crossContentAlignment) {
            int i = totalSpace - decoratedMeasurement;
            int i2 = WhenMappings.$EnumSwitchMapping$0[crossContentAlignment.ordinal()];
            if (i2 == 1) {
                return 0;
            }
            if (i2 == 2) {
                return i / 2;
            }
            if (i2 == 3) {
                return i;
            }
            throw new NoWhenBranchMatchedException();
        }

        private final <T> DivGallery.CrossContentAlignment evaluateAlignment(Expression<T> expression, ExpressionResolver expressionResolver, Expression<DivGallery.CrossContentAlignment> expression2, Function1<? super T, ? extends DivGallery.CrossContentAlignment> function1) {
            T tEvaluate;
            DivGallery.CrossContentAlignment crossContentAlignmentInvoke;
            return (expression == null || (tEvaluate = expression.evaluate(expressionResolver)) == null || (crossContentAlignmentInvoke = function1.invoke(tEvaluate)) == null) ? expression2.evaluate(expressionResolver) : crossContentAlignmentInvoke;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DivGallery.CrossContentAlignment asCrossContentAlignment(DivAlignmentHorizontal divAlignmentHorizontal) {
            int i = WhenMappings.$EnumSwitchMapping$1[divAlignmentHorizontal.ordinal()];
            if (i == 1) {
                return DivGallery.CrossContentAlignment.START;
            }
            if (i == 2) {
                return DivGallery.CrossContentAlignment.CENTER;
            }
            if (i == 3) {
                return DivGallery.CrossContentAlignment.END;
            }
            if (i == 4) {
                return DivGallery.CrossContentAlignment.START;
            }
            if (i == 5) {
                return DivGallery.CrossContentAlignment.END;
            }
            throw new NoWhenBranchMatchedException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DivGallery.CrossContentAlignment asCrossContentAlignment(DivAlignmentVertical divAlignmentVertical) {
            int i = WhenMappings.$EnumSwitchMapping$2[divAlignmentVertical.ordinal()];
            if (i == 1 || i == 2) {
                return DivGallery.CrossContentAlignment.START;
            }
            if (i == 3) {
                return DivGallery.CrossContentAlignment.CENTER;
            }
            if (i == 4) {
                return DivGallery.CrossContentAlignment.END;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    default int getChildMeasureSpec(int parentSize, int parentMode, int padding, int childDimension, int maxSize, boolean canScroll) {
        int iCoerceAtLeast = RangesKt.coerceAtLeast(parentSize - padding, 0);
        if (childDimension >= 0 && childDimension <= Integer.MAX_VALUE) {
            return com.yandex.div.core.widget.ViewsKt.makeExactSpec(childDimension);
        }
        if (childDimension == -1) {
            if (canScroll && parentMode == 0) {
                return com.yandex.div.core.widget.ViewsKt.makeUnspecifiedSpec();
            }
            return View.MeasureSpec.makeMeasureSpec(iCoerceAtLeast, parentMode);
        }
        if (childDimension == -2) {
            return maxSize == Integer.MAX_VALUE ? com.yandex.div.core.widget.ViewsKt.makeUnspecifiedSpec() : com.yandex.div.core.widget.ViewsKt.makeAtMostSpec(maxSize);
        }
        if (childDimension != -3) {
            return com.yandex.div.core.widget.ViewsKt.makeUnspecifiedSpec();
        }
        if (parentMode == Integer.MIN_VALUE || parentMode == 1073741824) {
            return com.yandex.div.core.widget.ViewsKt.makeAtMostSpec(Math.min(iCoerceAtLeast, maxSize));
        }
        return maxSize == Integer.MAX_VALUE ? com.yandex.div.core.widget.ViewsKt.makeUnspecifiedSpec() : com.yandex.div.core.widget.ViewsKt.makeAtMostSpec(maxSize);
    }
}
