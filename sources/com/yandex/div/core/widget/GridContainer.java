package com.yandex.div.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.pubmatic.sdk.common.models.POBProfileInfo;
import com.safedk.android.analytics.reporters.b;
import com.vungle.ads.internal.protos.Sdk;
import com.yandex.div.R;
import com.yandex.div.internal.KLog;
import com.yandex.div.internal.widget.DivLayoutParams;
import com.yandex.div.internal.widget.DivViewGroup;
import com.yandex.div.logging.Severity;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: GridContainer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0011\u0018\u0000 K2\u00020\u0001:\u0007IJKLMNOB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ(\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J(\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\b\u0010#\u001a\u00020\u0007H\u0002J\b\u0010$\u001a\u00020\u0007H\u0002J\b\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020\u0007H\u0002J\b\u0010(\u001a\u00020&H\u0002J\b\u0010)\u001a\u00020&H\u0002J0\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0002J\u0018\u0010/\u001a\u00020&2\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0007H\u0002J@\u00102\u001a\u00020&2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H\u0002J0\u00103\u001a\u00020&2\u0006\u00104\u001a\u00020\u00122\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007H\u0014J\u0018\u00109\u001a\u00020&2\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u0007H\u0014J\u0010\u0010<\u001a\u00020&2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010=\u001a\u00020&2\u0006\u0010+\u001a\u00020,H\u0016J\u0018\u0010>\u001a\u00020&2\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0007H\u0002J\u0018\u0010?\u001a\u00020&2\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0007H\u0002J\b\u0010@\u001a\u00020&H\u0016J\b\u0010A\u001a\u00020&H\u0002J\u001b\u00108\u001a\u00020\u0007*\u00020B2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020E0DH\u0082\bJ\u001b\u0010F\u001a\u00020\u0007*\u00020B2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020E0DH\u0082\bJ\u001b\u00105\u001a\u00020\u0007*\u00020B2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020E0DH\u0082\bJ\u001b\u00107\u001a\u00020\u0007*\u00020B2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020E0DH\u0082\bJ\u001b\u00106\u001a\u00020\u0007*\u00020B2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020E0DH\u0082\bJ\u001b\u0010H\u001a\u00020\u0007*\u00020B2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020E0DH\u0082\bR$\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00060\u0010R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\fR\u0014\u0010\u0016\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\fR\u0011\u0010\u0018\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\f¨\u0006P"}, d2 = {"Lcom/yandex/div/core/widget/GridContainer;", "Lcom/yandex/div/internal/widget/DivViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "columnCount", "getColumnCount", "()I", "setColumnCount", "(I)V", "grid", "Lcom/yandex/div/core/widget/GridContainer$Grid;", "initialized", "", "lastLayoutHashCode", "paddingHorizontal", "getPaddingHorizontal", "paddingVertical", "getPaddingVertical", "rowCount", "getRowCount", "calculateChildHorizontalPosition", "cellLeft", "cellWidth", "childWidth", "gravity", "calculateChildVerticalPosition", "cellTop", "cellHeight", "childHeight", "calculateGridHorizontalPosition", "calculateGridVerticalPosition", "checkConsistency", "", "computeLayoutHashCode", "invalidateMeasurement", "invalidateStructure", "measureChild", "child", "Landroid/view/View;", "parentWidthSpec", "parentHeightSpec", "measureChildrenInitial", "widthSpec", "heightSpec", "measureMatchParentChild", "onLayout", "changed", "left", ViewHierarchyConstants.DIMENSION_TOP_KEY, "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onViewAdded", "onViewRemoved", "remeasureChildrenHeight", "remeasureChildrenWidth", "requestLayout", "validateLayoutParams", "Lcom/yandex/div/core/widget/GridContainer$Cell;", "rows", "", "Lcom/yandex/div/core/widget/GridContainer$Line;", "height", "columns", "width", "Cell", "CellProjection", "Companion", "Grid", "Line", "SizeConstraint", "SpannedCellComparator", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class GridContainer extends DivViewGroup {
    private static final int DEFAULT_COLUMN_COUNT = 1;
    private static final int MAX_SIZE = 32768;
    private static final String TAG = "GridContainer";
    private static final int UNINITIALIZED_HASH = 0;
    private final Grid grid;
    private boolean initialized;
    private int lastLayoutHashCode;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GridContainer(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GridContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GridContainer(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.grid = new Grid();
        if (isInEditMode()) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GridContainer, i, 0);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…ntainer, defStyleAttr, 0)");
            try {
                setColumnCount(typedArrayObtainStyledAttributes.getInt(R.styleable.GridContainer_android_columnCount, 1));
                setGravity(typedArrayObtainStyledAttributes.getInt(R.styleable.GridContainer_android_gravity, 8388659));
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        }
        this.initialized = true;
    }

    public final int getColumnCount() {
        return this.grid.getColumnCount();
    }

    public final void setColumnCount(int i) {
        this.grid.setColumnCount(i);
        invalidateStructure();
        requestLayout();
    }

    public final int getRowCount() {
        return this.grid.getRowCount();
    }

    private final int getPaddingHorizontal() {
        return getPaddingLeft() + getPaddingRight();
    }

    private final int getPaddingVertical() {
        return getPaddingTop() + getPaddingBottom();
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        super.onViewAdded(child);
        invalidateStructure();
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        super.onViewRemoved(child);
        invalidateStructure();
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        if (this.initialized) {
            invalidateMeasurement();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        checkConsistency();
        invalidateMeasurement();
        int paddingHorizontal = getPaddingHorizontal();
        int paddingVertical = getPaddingVertical();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec - paddingHorizontal), View.MeasureSpec.getMode(widthMeasureSpec));
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(heightMeasureSpec - paddingVertical), View.MeasureSpec.getMode(heightMeasureSpec));
        measureChildrenInitial(iMakeMeasureSpec, iMakeMeasureSpec2);
        int iMeasureWidth = this.grid.measureWidth(iMakeMeasureSpec);
        remeasureChildrenWidth(iMakeMeasureSpec, iMakeMeasureSpec2);
        int iMeasureHeight = this.grid.measureHeight(iMakeMeasureSpec2);
        remeasureChildrenHeight(iMakeMeasureSpec, iMakeMeasureSpec2);
        setMeasuredDimension(ViewGroup.resolveSizeAndState(Math.max(iMeasureWidth + paddingHorizontal, getSuggestedMinimumWidth()), widthMeasureSpec, 0), ViewGroup.resolveSizeAndState(Math.max(iMeasureHeight + paddingVertical, getSuggestedMinimumHeight()), heightMeasureSpec, 0));
        long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
        KLog kLog = KLog.INSTANCE;
        if (kLog.isAtLeast(Severity.INFO)) {
            kLog.print(4, TAG, "onMeasure() performed in " + jElapsedRealtime2 + " ms");
        }
    }

    private final void measureChildrenInitial(int widthSpec, int heightSpec) {
        GridContainer gridContainer = this;
        int childCount = gridContainer.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = gridContainer.getChildAt(i);
            if (child.getVisibility() != 8) {
                Intrinsics.checkNotNullExpressionValue(child, "child");
                DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
                ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
                DivLayoutParams divLayoutParams = (DivLayoutParams) layoutParams;
                measureChild(child, widthSpec, heightSpec, divLayoutParams.width == -1 ? 0 : divLayoutParams.width, divLayoutParams.height == -1 ? 0 : divLayoutParams.height);
            }
        }
    }

    private final void measureChild(View child, int parentWidthSpec, int parentHeightSpec, int childWidth, int childHeight) {
        DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
        int minimumWidth = child.getMinimumWidth();
        DivViewGroup.Companion companion2 = DivViewGroup.INSTANCE;
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
        int childMeasureSpec = companion.getChildMeasureSpec(parentWidthSpec, 0, childWidth, minimumWidth, ((DivLayoutParams) layoutParams).getMaxWidth());
        DivViewGroup.Companion companion3 = DivViewGroup.INSTANCE;
        int minimumHeight = child.getMinimumHeight();
        DivViewGroup.Companion companion4 = DivViewGroup.INSTANCE;
        ViewGroup.LayoutParams layoutParams2 = child.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
        child.measure(childMeasureSpec, companion3.getChildMeasureSpec(parentHeightSpec, 0, childHeight, minimumHeight, ((DivLayoutParams) layoutParams2).getMaxHeight()));
    }

    private final void remeasureChildrenWidth(int widthSpec, int heightSpec) {
        List<Cell> cells = this.grid.getCells();
        List<Line> columns = this.grid.getColumns();
        GridContainer gridContainer = this;
        int childCount = gridContainer.getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View child = gridContainer.getChildAt(i2);
            if (child.getVisibility() != 8) {
                Intrinsics.checkNotNullExpressionValue(child, "child");
                DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
                ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
                DivLayoutParams divLayoutParams = (DivLayoutParams) layoutParams;
                if (divLayoutParams.width == -1) {
                    Cell cell = cells.get(i);
                    Line line = columns.get((cell.getColumnIndex() + cell.getColumnSpan()) - 1);
                    measureMatchParentChild(child, widthSpec, heightSpec, divLayoutParams.width, divLayoutParams.height, ((line.getOffset() + line.getSize()) - columns.get(cell.getColumnIndex()).getOffset()) - divLayoutParams.getHorizontalMargins$div_release(), 0);
                }
                i++;
            }
        }
    }

    private final void remeasureChildrenHeight(int widthSpec, int heightSpec) {
        List<Cell> cells = this.grid.getCells();
        List<Line> columns = this.grid.getColumns();
        List<Line> rows = this.grid.getRows();
        GridContainer gridContainer = this;
        int childCount = gridContainer.getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View child = gridContainer.getChildAt(i2);
            if (child.getVisibility() != 8) {
                Intrinsics.checkNotNullExpressionValue(child, "child");
                DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
                ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
                DivLayoutParams divLayoutParams = (DivLayoutParams) layoutParams;
                if (divLayoutParams.height == -1) {
                    Cell cell = cells.get(i);
                    Line line = columns.get((cell.getColumnIndex() + cell.getColumnSpan()) - 1);
                    int offset = ((line.getOffset() + line.getSize()) - columns.get(cell.getColumnIndex()).getOffset()) - divLayoutParams.getHorizontalMargins$div_release();
                    Line line2 = rows.get((cell.getRowIndex() + cell.getRowSpan()) - 1);
                    measureMatchParentChild(child, widthSpec, heightSpec, divLayoutParams.width, divLayoutParams.height, offset, ((line2.getOffset() + line2.getSize()) - rows.get(cell.getRowIndex()).getOffset()) - divLayoutParams.getVerticalMargins$div_release());
                }
                i++;
            }
        }
    }

    private final void measureMatchParentChild(View child, int parentWidthSpec, int parentHeightSpec, int childWidth, int childHeight, int cellWidth, int cellHeight) {
        int childMeasureSpec;
        int childMeasureSpec2;
        if (childWidth == -1) {
            childMeasureSpec = View.MeasureSpec.makeMeasureSpec(cellWidth, 1073741824);
        } else {
            DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
            int minimumWidth = child.getMinimumWidth();
            DivViewGroup.Companion companion2 = DivViewGroup.INSTANCE;
            ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
            childMeasureSpec = companion.getChildMeasureSpec(parentWidthSpec, 0, childWidth, minimumWidth, ((DivLayoutParams) layoutParams).getMaxWidth());
        }
        if (childHeight == -1) {
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(cellHeight, 1073741824);
        } else {
            DivViewGroup.Companion companion3 = DivViewGroup.INSTANCE;
            int minimumHeight = child.getMinimumHeight();
            DivViewGroup.Companion companion4 = DivViewGroup.INSTANCE;
            ViewGroup.LayoutParams layoutParams2 = child.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
            childMeasureSpec2 = companion3.getChildMeasureSpec(parentHeightSpec, 0, childHeight, minimumHeight, ((DivLayoutParams) layoutParams2).getMaxHeight());
        }
        child.measure(childMeasureSpec, childMeasureSpec2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        checkConsistency();
        List<Line> columns = this.grid.getColumns();
        List<Line> rows = this.grid.getRows();
        List<Cell> cells = this.grid.getCells();
        int iCalculateGridHorizontalPosition = calculateGridHorizontalPosition();
        int iCalculateGridVerticalPosition = calculateGridVerticalPosition();
        GridContainer gridContainer = this;
        int childCount = gridContainer.getChildCount();
        int i = 0;
        int i2 = 0;
        while (i < childCount) {
            View child = gridContainer.getChildAt(i);
            if (child.getVisibility() != 8) {
                Intrinsics.checkNotNullExpressionValue(child, "child");
                DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
                ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
                DivLayoutParams divLayoutParams = (DivLayoutParams) layoutParams;
                Cell cell = cells.get(i2);
                int offset = columns.get(cell.getColumnIndex()).getOffset() + divLayoutParams.leftMargin;
                int offset2 = rows.get(cell.getRowIndex()).getOffset() + divLayoutParams.topMargin;
                Line line = columns.get((cell.getColumnIndex() + cell.getColumnSpan()) - 1);
                int offset3 = ((line.getOffset() + line.getSize()) - offset) - divLayoutParams.rightMargin;
                Line line2 = rows.get((cell.getRowIndex() + cell.getRowSpan()) - 1);
                int offset4 = ((line2.getOffset() + line2.getSize()) - offset2) - divLayoutParams.bottomMargin;
                int iCalculateChildHorizontalPosition = calculateChildHorizontalPosition(offset, offset3, child.getMeasuredWidth(), divLayoutParams.getGravity()) + iCalculateGridHorizontalPosition;
                int iCalculateChildVerticalPosition = calculateChildVerticalPosition(offset2, offset4, child.getMeasuredHeight(), divLayoutParams.getGravity()) + iCalculateGridVerticalPosition;
                child.layout(iCalculateChildHorizontalPosition, iCalculateChildVerticalPosition, child.getMeasuredWidth() + iCalculateChildHorizontalPosition, child.getMeasuredHeight() + iCalculateChildVerticalPosition);
                i2++;
            }
            i++;
            cells = cells;
            gridContainer = gridContainer;
            columns = columns;
            rows = rows;
        }
        long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
        KLog kLog = KLog.INSTANCE;
        if (kLog.isAtLeast(Severity.INFO)) {
            kLog.print(4, TAG, "onLayout() performed in " + jElapsedRealtime2 + " ms");
        }
    }

    private final int calculateGridHorizontalPosition() {
        int gravity = getGravity() & 7;
        int measuredWidth = this.grid.getMeasuredWidth();
        int measuredWidth2 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        if (gravity == 1) {
            return getPaddingLeft() + ((measuredWidth2 - measuredWidth) / 2);
        }
        if (gravity == 5) {
            return (getPaddingLeft() + measuredWidth2) - measuredWidth;
        }
        return getPaddingLeft();
    }

    private final int calculateGridVerticalPosition() {
        int gravity = getGravity() & 112;
        int measuredHeight = this.grid.getMeasuredHeight();
        int measuredHeight2 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        if (gravity == 16) {
            return getPaddingTop() + ((measuredHeight2 - measuredHeight) / 2);
        }
        if (gravity == 80) {
            return (getPaddingTop() + measuredHeight2) - measuredHeight;
        }
        return getPaddingTop();
    }

    private final int calculateChildHorizontalPosition(int cellLeft, int cellWidth, int childWidth, int gravity) {
        int i = gravity & 7;
        if (i != 1) {
            return i != 5 ? cellLeft : (cellLeft + cellWidth) - childWidth;
        }
        return cellLeft + ((cellWidth - childWidth) / 2);
    }

    private final int calculateChildVerticalPosition(int cellTop, int cellHeight, int childHeight, int gravity) {
        int i = gravity & 112;
        if (i != 16) {
            return i != 80 ? cellTop : (cellTop + cellHeight) - childHeight;
        }
        return cellTop + ((cellHeight - childHeight) / 2);
    }

    private final void invalidateStructure() {
        this.lastLayoutHashCode = 0;
        this.grid.invalidateStructure();
    }

    private final void invalidateMeasurement() {
        this.grid.invalidateMeasurement();
    }

    private final void checkConsistency() {
        int i = this.lastLayoutHashCode;
        if (i == 0) {
            validateLayoutParams();
            this.lastLayoutHashCode = computeLayoutHashCode();
        } else if (i != computeLayoutHashCode()) {
            invalidateStructure();
            checkConsistency();
        }
    }

    private final int computeLayoutHashCode() {
        GridContainer gridContainer = this;
        int childCount = gridContainer.getChildCount();
        int iHashCode = Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE;
        for (int i = 0; i < childCount; i++) {
            View child = gridContainer.getChildAt(i);
            if (child.getVisibility() != 8) {
                Intrinsics.checkNotNullExpressionValue(child, "child");
                DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
                ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
                iHashCode = (iHashCode * 31) + ((DivLayoutParams) layoutParams).hashCode();
            }
        }
        return iHashCode;
    }

    private final void validateLayoutParams() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(child, "child");
            ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
            DivLayoutParams divLayoutParams = (DivLayoutParams) layoutParams;
            if (divLayoutParams.getColumnSpan() < 0 || divLayoutParams.getRowSpan() < 0) {
                throw new IllegalStateException("Negative spans are not supported.");
            }
            if (GridContainerKt.getColumnWeight(divLayoutParams) < 0.0f || GridContainerKt.getRowWeight(divLayoutParams) < 0.0f) {
                throw new IllegalStateException("Negative weights are not supported.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: GridContainer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\n\"\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/yandex/div/core/widget/GridContainer$Cell;", "", "viewIndex", "", "columnIndex", "rowIndex", "columnSpan", "rowSpan", "(IIIII)V", "getColumnIndex", "()I", "getColumnSpan", "setColumnSpan", "(I)V", "getRowIndex", "getRowSpan", "setRowSpan", "getViewIndex", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    static final class Cell {
        private final int columnIndex;
        private int columnSpan;
        private final int rowIndex;
        private int rowSpan;
        private final int viewIndex;

        public Cell(int i, int i2, int i3, int i4, int i5) {
            this.viewIndex = i;
            this.columnIndex = i2;
            this.rowIndex = i3;
            this.columnSpan = i4;
            this.rowSpan = i5;
        }

        public final int getViewIndex() {
            return this.viewIndex;
        }

        public final int getColumnIndex() {
            return this.columnIndex;
        }

        public final int getRowIndex() {
            return this.rowIndex;
        }

        public final int getColumnSpan() {
            return this.columnSpan;
        }

        public final void setColumnSpan(int i) {
            this.columnSpan = i;
        }

        public final int getRowSpan() {
            return this.rowSpan;
        }

        public final void setRowSpan(int i) {
            this.rowSpan = i;
        }
    }

    private final int left(Cell cell, List<Line> list) {
        return list.get(cell.getColumnIndex()).getOffset();
    }

    private final int right(Cell cell, List<Line> list) {
        Line line = list.get((cell.getColumnIndex() + cell.getColumnSpan()) - 1);
        return line.getOffset() + line.getSize();
    }

    private final int top(Cell cell, List<Line> list) {
        return list.get(cell.getRowIndex()).getOffset();
    }

    private final int bottom(Cell cell, List<Line> list) {
        Line line = list.get((cell.getRowIndex() + cell.getRowSpan()) - 1);
        return line.getOffset() + line.getSize();
    }

    /* JADX INFO: compiled from: GridContainer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0011\u0010\u0013\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/yandex/div/core/widget/GridContainer$CellProjection;", "", "index", "", "contentSize", "marginStart", "marginEnd", "span", "weight", "", "(IIIIIF)V", "getContentSize", "()I", "getIndex", "getMarginEnd", "getMarginStart", ContentDisposition.Parameters.Size, "getSize", "getSpan", "specificSize", "getSpecificSize", "getWeight", "()F", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class CellProjection {
        private final int contentSize;
        private final int index;
        private final int marginEnd;
        private final int marginStart;
        private final int span;
        private final float weight;

        public CellProjection(int i, int i2, int i3, int i4, int i5, float f) {
            this.index = i;
            this.contentSize = i2;
            this.marginStart = i3;
            this.marginEnd = i4;
            this.span = i5;
            this.weight = f;
        }

        public final int getIndex() {
            return this.index;
        }

        public final int getContentSize() {
            return this.contentSize;
        }

        public final int getMarginStart() {
            return this.marginStart;
        }

        public final int getMarginEnd() {
            return this.marginEnd;
        }

        public final int getSpan() {
            return this.span;
        }

        public final float getWeight() {
            return this.weight;
        }

        public final int getSize() {
            return this.contentSize + this.marginStart + this.marginEnd;
        }

        public final int getSpecificSize() {
            return getSize() / this.span;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: GridContainer.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u0013R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\f\u0010\u0007R\u001a\u0010\r\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0007R\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/yandex/div/core/widget/GridContainer$Line;", "", "()V", "<set-?>", "", "contentSize", "getContentSize", "()I", "isFlexible", "", "()Z", "marginSize", "getMarginSize", "offset", "getOffset", "setOffset", "(I)V", ContentDisposition.Parameters.Size, "getSize", "", "weight", "getWeight", "()F", POBProfileInfo.COUNTRY_FILTERING_ALLOW_MODE, "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    static final class Line {
        private int contentSize;
        private int offset;
        private int size;
        private float weight;

        public final int getOffset() {
            return this.offset;
        }

        public final void setOffset(int i) {
            this.offset = i;
        }

        public final int getContentSize() {
            return this.contentSize;
        }

        public final int getSize() {
            return this.size;
        }

        public final float getWeight() {
            return this.weight;
        }

        public final int getMarginSize() {
            return this.size - this.contentSize;
        }

        public final boolean isFlexible() {
            return this.weight > 0.0f;
        }

        public static /* synthetic */ void include$default(Line line, int i, int i2, float f, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = 0;
            }
            if ((i3 & 4) != 0) {
                f = 0.0f;
            }
            line.include(i, i2, f);
        }

        public final void include(int contentSize, int size, float weight) {
            this.contentSize = Math.max(this.contentSize, contentSize);
            this.size = Math.max(this.size, size);
            this.weight = Math.max(this.weight, weight);
        }
    }

    /* JADX INFO: compiled from: GridContainer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/yandex/div/core/widget/GridContainer$SizeConstraint;", "", "min", "", "max", "(II)V", "getMax", "()I", "setMax", "(I)V", "getMin", "setMin", "set", "", "measureSpec", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class SizeConstraint {
        private int max;
        private int min;

        /* JADX WARN: Illegal instructions before constructor call */
        public SizeConstraint() {
            int i = 0;
            this(i, i, 3, null);
        }

        public SizeConstraint(int i, int i2) {
            this.min = i;
            this.max = i2;
        }

        public /* synthetic */ SizeConstraint(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 32768 : i2);
        }

        public final int getMin() {
            return this.min;
        }

        public final void setMin(int i) {
            this.min = i;
        }

        public final int getMax() {
            return this.max;
        }

        public final void setMax(int i) {
            this.max = i;
        }

        public final void set(int measureSpec) {
            int mode = View.MeasureSpec.getMode(measureSpec);
            int size = View.MeasureSpec.getSize(measureSpec);
            if (mode == Integer.MIN_VALUE) {
                this.min = 0;
                this.max = size;
            } else if (mode == 0) {
                this.min = 0;
                this.max = 32768;
            } else {
                if (mode != 1073741824) {
                    return;
                }
                this.min = size;
                this.max = size;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: GridContainer.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u0006\u0010(\u001a\u00020\u0019H\u0002J\u0016\u0010)\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u0002J?\u0010*\u001a\u00020&2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u0018\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0,H\u0082\bJ?\u0010/\u001a\u00020&2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u0018\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0,H\u0082\bJ\u0016\u00100\u001a\u00020\u000e2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u0002J\u000e\u00101\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u0006\u00102\u001a\u00020&J\u0006\u00103\u001a\u00020&J9\u00104\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u0006\u00105\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020\u00192\u0018\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0,H\u0082\bJ\u000e\u00106\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u0002J\u000e\u00107\u001a\u00020\u000e2\u0006\u00108\u001a\u00020\u000eJ\u000e\u00109\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u0002J\u000e\u0010:\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u000eJ\u0012\u0010\u001e\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00058F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\fR\u0014\u0010\u0016\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001a\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0011R\u0011\u0010\u001c\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0011R\u0011\u0010\u001e\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0011R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u00058F¢\u0006\u0006\u001a\u0004\b!\u0010\fR\u0014\u0010\"\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0011R\u000e\u0010$\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/yandex/div/core/widget/GridContainer$Grid;", "", "(Lcom/yandex/div/core/widget/GridContainer;)V", "_cells", "Lcom/yandex/div/core/widget/Resettable;", "", "Lcom/yandex/div/core/widget/GridContainer$Cell;", "_columns", "Lcom/yandex/div/core/widget/GridContainer$Line;", "_rows", "cells", "getCells", "()Ljava/util/List;", "value", "", "columnCount", "getColumnCount", "()I", "setColumnCount", "(I)V", "columns", "getColumns", "height", "getHeight", "heightConstraint", "Lcom/yandex/div/core/widget/GridContainer$SizeConstraint;", "measuredHeight", "getMeasuredHeight", "measuredWidth", "getMeasuredWidth", "rowCount", "getRowCount", "rows", "getRows", "width", "getWidth", "widthConstraint", "adjustWeightedLines", "", b.d, "constraint", "align", "applyFixedParamsToLines", "projection", "Lkotlin/Function2;", "Landroid/view/View;", "Lcom/yandex/div/core/widget/GridContainer$CellProjection;", "applySpansToLines", "calculateSize", "distributeCells", "invalidateMeasurement", "invalidateStructure", "measureAxis", "count", "measureColumns", "measureHeight", "heightSpec", "measureRows", "measureWidth", "widthSpec", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    final class Grid {
        private final SizeConstraint heightConstraint;
        private final SizeConstraint widthConstraint;
        private int columnCount = 1;
        private final Resettable<List<Cell>> _cells = new Resettable<>(new Function0<List<? extends Cell>>() { // from class: com.yandex.div.core.widget.GridContainer$Grid$_cells$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends GridContainer.Cell> invoke() {
                return this.this$0.distributeCells();
            }
        });
        private final Resettable<List<Line>> _columns = new Resettable<>(new Function0<List<? extends Line>>() { // from class: com.yandex.div.core.widget.GridContainer$Grid$_columns$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends GridContainer.Line> invoke() {
                return this.this$0.measureColumns();
            }
        });
        private final Resettable<List<Line>> _rows = new Resettable<>(new Function0<List<? extends Line>>() { // from class: com.yandex.div.core.widget.GridContainer$Grid$_rows$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends GridContainer.Line> invoke() {
                return this.this$0.measureRows();
            }
        });

        public Grid() {
            int i = 0;
            int i2 = 3;
            DefaultConstructorMarker defaultConstructorMarker = null;
            this.widthConstraint = new SizeConstraint(i, i, i2, defaultConstructorMarker);
            this.heightConstraint = new SizeConstraint(i, i, i2, defaultConstructorMarker);
        }

        public final int getColumnCount() {
            return this.columnCount;
        }

        public final void setColumnCount(int i) {
            if (i <= 0 || this.columnCount == i) {
                return;
            }
            this.columnCount = i;
            invalidateStructure();
        }

        public final int getRowCount() {
            return rowCount(getCells());
        }

        public final List<Cell> getCells() {
            return this._cells.get();
        }

        public final List<Line> getColumns() {
            return this._columns.get();
        }

        public final List<Line> getRows() {
            return this._rows.get();
        }

        public final int getMeasuredWidth() {
            if (this._columns.getInitialized()) {
                return calculateSize(this._columns.get());
            }
            return 0;
        }

        public final int getMeasuredHeight() {
            if (this._rows.getInitialized()) {
                return calculateSize(this._rows.get());
            }
            return 0;
        }

        private final int getWidth() {
            return calculateSize(getColumns());
        }

        private final int getHeight() {
            return calculateSize(getRows());
        }

        private final int rowCount(List<Cell> list) {
            if (list.isEmpty()) {
                return 0;
            }
            Cell cell = (Cell) kotlin.collections.CollectionsKt.last((List) list);
            return cell.getRowSpan() + cell.getRowIndex();
        }

        public final void invalidateStructure() {
            this._cells.reset();
            invalidateMeasurement();
        }

        public final void invalidateMeasurement() {
            this._columns.reset();
            this._rows.reset();
        }

        public final int measureWidth(int widthSpec) {
            this.widthConstraint.set(widthSpec);
            return Math.max(this.widthConstraint.getMin(), Math.min(getWidth(), this.widthConstraint.getMax()));
        }

        public final int measureHeight(int heightSpec) {
            this.heightConstraint.set(heightSpec);
            return Math.max(this.heightConstraint.getMin(), Math.min(getHeight(), this.heightConstraint.getMax()));
        }

        private final int calculateSize(List<Line> lines) {
            if (lines.isEmpty()) {
                return 0;
            }
            Line line = (Line) kotlin.collections.CollectionsKt.last((List) lines);
            return line.getOffset() + line.getSize();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Type inference failed for: r6v2, types: [kotlin.collections.IntIterator] */
        public final List<Cell> distributeCells() {
            int i;
            Integer numValueOf;
            if (GridContainer.this.getChildCount() == 0) {
                return kotlin.collections.CollectionsKt.emptyList();
            }
            int i2 = this.columnCount;
            ArrayList arrayList = new ArrayList(GridContainer.this.getChildCount());
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            GridContainer gridContainer = GridContainer.this;
            int childCount = gridContainer.getChildCount();
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i5 < childCount) {
                View child = gridContainer.getChildAt(i5);
                if (child.getVisibility() != 8) {
                    Intrinsics.checkNotNullExpressionValue(child, "child");
                    Integer numMinOrNull = ArraysKt.minOrNull(iArr2);
                    int iIntValue = numMinOrNull != null ? numMinOrNull.intValue() : i3;
                    int iIndexOf = ArraysKt.indexOf(iArr2, iIntValue);
                    int i6 = i4 + iIntValue;
                    IntRange intRangeUntil = RangesKt.until(i3, i2);
                    int first = intRangeUntil.getFirst();
                    int last = intRangeUntil.getLast();
                    if (first <= last) {
                        while (true) {
                            iArr2[first] = Math.max(i3, iArr2[first] - iIntValue);
                            if (first == last) {
                                break;
                            }
                            first++;
                        }
                    }
                    DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
                    ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
                    DivLayoutParams divLayoutParams = (DivLayoutParams) layoutParams;
                    int iMin = Math.min(divLayoutParams.getColumnSpan(), i2 - iIndexOf);
                    int rowSpan = divLayoutParams.getRowSpan();
                    arrayList.add(new Cell(i5, iIndexOf, i6, iMin, rowSpan));
                    int i7 = iIndexOf + iMin;
                    while (iIndexOf < i7) {
                        if (iArr2[iIndexOf] > 0) {
                            Object obj = arrayList.get(iArr[iIndexOf]);
                            Intrinsics.checkNotNullExpressionValue(obj, "cells[cellIndices[i]]");
                            Cell cell = (Cell) obj;
                            int columnIndex = cell.getColumnIndex();
                            int columnSpan = cell.getColumnSpan() + columnIndex;
                            while (columnIndex < columnSpan) {
                                int i8 = iArr2[columnIndex];
                                iArr2[columnIndex] = 0;
                                columnIndex++;
                            }
                            cell.setRowSpan(i6 - cell.getRowIndex());
                        }
                        iArr[iIndexOf] = i5;
                        iArr2[iIndexOf] = rowSpan;
                        iIndexOf++;
                    }
                    i4 = i6;
                }
                i5++;
                i3 = 0;
            }
            if (i2 == 0) {
                numValueOf = null;
                i = 0;
            } else {
                i = 0;
                int i9 = iArr2[0];
                int lastIndex = ArraysKt.getLastIndex(iArr2);
                if (lastIndex != 0) {
                    int iMax = Math.max(1, i9);
                    ?? it = new IntRange(1, lastIndex).iterator();
                    while (it.hasNext()) {
                        int i10 = iArr2[it.nextInt()];
                        int iMax2 = Math.max(1, i10);
                        if (iMax > iMax2) {
                            i9 = i10;
                            iMax = iMax2;
                        }
                    }
                    numValueOf = Integer.valueOf(i9);
                } else {
                    numValueOf = Integer.valueOf(i9);
                }
            }
            ArrayList arrayList2 = arrayList;
            int rowIndex = ((Cell) kotlin.collections.CollectionsKt.last((List) arrayList2)).getRowIndex() + (numValueOf != null ? numValueOf.intValue() : 1);
            int size = arrayList2.size();
            for (int i11 = i; i11 < size; i11++) {
                Cell cell2 = (Cell) arrayList2.get(i11);
                if (cell2.getRowIndex() + cell2.getRowSpan() > rowIndex) {
                    cell2.setRowSpan(rowIndex - cell2.getRowIndex());
                }
            }
            return arrayList2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<Line> measureColumns() {
            int i;
            int size;
            float weight;
            int i2;
            int i3;
            int i4 = this.columnCount;
            SizeConstraint sizeConstraint = this.widthConstraint;
            List<Cell> list = this._cells.get();
            ArrayList arrayList = new ArrayList(i4);
            for (int i5 = 0; i5 < i4; i5++) {
                arrayList.add(new Line());
            }
            ArrayList arrayList2 = arrayList;
            GridContainer gridContainer = GridContainer.this;
            int size2 = list.size();
            int i6 = 0;
            while (true) {
                i = 1;
                if (i6 >= size2) {
                    break;
                }
                Cell cell = list.get(i6);
                View child = gridContainer.getChildAt(cell.getViewIndex());
                Intrinsics.checkNotNullExpressionValue(child, "child");
                DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
                ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
                DivLayoutParams divLayoutParams = (DivLayoutParams) layoutParams;
                CellProjection cellProjection = new CellProjection(cell.getColumnIndex(), child.getMeasuredWidth(), divLayoutParams.leftMargin, divLayoutParams.rightMargin, cell.getColumnSpan(), GridContainerKt.getColumnWeight(divLayoutParams));
                if (cellProjection.getSpan() == 1) {
                    arrayList2.get(cellProjection.getIndex()).include(cellProjection.getContentSize(), cellProjection.getSize(), cellProjection.getWeight());
                } else {
                    int span = cellProjection.getSpan() - 1;
                    float weight2 = cellProjection.getWeight() / cellProjection.getSpan();
                    if (span >= 0) {
                        while (true) {
                            Line.include$default(arrayList2.get(cellProjection.getIndex() + i3), 0, 0, weight2, 3, null);
                            i3 = i3 != span ? i3 + 1 : 0;
                        }
                    }
                }
                i6++;
            }
            ArrayList arrayList3 = new ArrayList();
            GridContainer gridContainer2 = GridContainer.this;
            int size3 = list.size();
            for (int i7 = 0; i7 < size3; i7++) {
                Cell cell2 = list.get(i7);
                View child2 = gridContainer2.getChildAt(cell2.getViewIndex());
                Intrinsics.checkNotNullExpressionValue(child2, "child");
                DivViewGroup.Companion companion2 = DivViewGroup.INSTANCE;
                ViewGroup.LayoutParams layoutParams2 = child2.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
                DivLayoutParams divLayoutParams2 = (DivLayoutParams) layoutParams2;
                CellProjection cellProjection2 = new CellProjection(cell2.getColumnIndex(), child2.getMeasuredWidth(), divLayoutParams2.leftMargin, divLayoutParams2.rightMargin, cell2.getColumnSpan(), GridContainerKt.getColumnWeight(divLayoutParams2));
                if (cellProjection2.getSpan() > 1) {
                    arrayList3.add(cellProjection2);
                }
            }
            ArrayList arrayList4 = arrayList3;
            kotlin.collections.CollectionsKt.sortWith(arrayList4, SpannedCellComparator.INSTANCE);
            int size4 = arrayList4.size();
            int i8 = 0;
            while (i8 < size4) {
                CellProjection cellProjection3 = (CellProjection) arrayList4.get(i8);
                int index = cellProjection3.getIndex();
                int index2 = (cellProjection3.getIndex() + cellProjection3.getSpan()) - i;
                int size5 = cellProjection3.getSize();
                if (index <= index2) {
                    int i9 = index;
                    size = size5;
                    weight = 0.0f;
                    i2 = 0;
                    while (true) {
                        Line line = arrayList2.get(i9);
                        size5 -= line.getSize();
                        if (line.isFlexible()) {
                            weight += line.getWeight();
                        } else {
                            if (line.getContentSize() == 0) {
                                i2++;
                            }
                            size -= line.getSize();
                        }
                        if (i9 == index2) {
                            break;
                        }
                        i9++;
                    }
                } else {
                    size = size5;
                    weight = 0.0f;
                    i2 = 0;
                }
                if (weight > 0.0f) {
                    if (index <= index2) {
                        while (true) {
                            Line line2 = arrayList2.get(index);
                            if (line2.isFlexible()) {
                                int iCeil = (int) Math.ceil((line2.getWeight() / weight) * size);
                                Line.include$default(line2, iCeil - line2.getMarginSize(), iCeil, 0.0f, 4, null);
                            }
                            if (index != index2) {
                                index++;
                            }
                        }
                    }
                } else if (size5 > 0 && index <= index2) {
                    while (true) {
                        Line line3 = arrayList2.get(index);
                        if (i2 <= 0) {
                            int span2 = size5 / cellProjection3.getSpan();
                            Line.include$default(line3, line3.getContentSize() + span2, line3.getSize() + span2, 0.0f, 4, null);
                        } else if (line3.getContentSize() == 0 && !line3.isFlexible()) {
                            int i10 = size5 / i2;
                            Line.include$default(line3, line3.getContentSize() + i10, line3.getSize() + i10, 0.0f, 4, null);
                        }
                        if (index != index2) {
                            index++;
                        }
                    }
                }
                i8++;
                i = 1;
            }
            adjustWeightedLines(arrayList2, sizeConstraint);
            align(arrayList2);
            return arrayList2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<Line> measureRows() {
            int i;
            int size;
            float weight;
            int i2;
            int i3;
            int rowCount = getRowCount();
            SizeConstraint sizeConstraint = this.heightConstraint;
            List<Cell> list = this._cells.get();
            ArrayList arrayList = new ArrayList(rowCount);
            for (int i4 = 0; i4 < rowCount; i4++) {
                arrayList.add(new Line());
            }
            ArrayList arrayList2 = arrayList;
            GridContainer gridContainer = GridContainer.this;
            int size2 = list.size();
            int i5 = 0;
            while (true) {
                i = 1;
                if (i5 >= size2) {
                    break;
                }
                Cell cell = list.get(i5);
                View child = gridContainer.getChildAt(cell.getViewIndex());
                Intrinsics.checkNotNullExpressionValue(child, "child");
                DivViewGroup.Companion companion = DivViewGroup.INSTANCE;
                ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
                DivLayoutParams divLayoutParams = (DivLayoutParams) layoutParams;
                CellProjection cellProjection = new CellProjection(cell.getRowIndex(), child.getMeasuredHeight(), divLayoutParams.topMargin, divLayoutParams.bottomMargin, cell.getRowSpan(), GridContainerKt.getRowWeight(divLayoutParams));
                if (cellProjection.getSpan() == 1) {
                    arrayList2.get(cellProjection.getIndex()).include(cellProjection.getContentSize(), cellProjection.getSize(), cellProjection.getWeight());
                } else {
                    int span = cellProjection.getSpan() - 1;
                    float weight2 = cellProjection.getWeight() / cellProjection.getSpan();
                    if (span >= 0) {
                        while (true) {
                            Line.include$default(arrayList2.get(cellProjection.getIndex() + i3), 0, 0, weight2, 3, null);
                            i3 = i3 != span ? i3 + 1 : 0;
                        }
                    }
                }
                i5++;
            }
            ArrayList arrayList3 = new ArrayList();
            GridContainer gridContainer2 = GridContainer.this;
            int size3 = list.size();
            for (int i6 = 0; i6 < size3; i6++) {
                Cell cell2 = list.get(i6);
                View child2 = gridContainer2.getChildAt(cell2.getViewIndex());
                Intrinsics.checkNotNullExpressionValue(child2, "child");
                DivViewGroup.Companion companion2 = DivViewGroup.INSTANCE;
                ViewGroup.LayoutParams layoutParams2 = child2.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type com.yandex.div.internal.widget.DivLayoutParams");
                DivLayoutParams divLayoutParams2 = (DivLayoutParams) layoutParams2;
                CellProjection cellProjection2 = new CellProjection(cell2.getRowIndex(), child2.getMeasuredHeight(), divLayoutParams2.topMargin, divLayoutParams2.bottomMargin, cell2.getRowSpan(), GridContainerKt.getRowWeight(divLayoutParams2));
                if (cellProjection2.getSpan() > 1) {
                    arrayList3.add(cellProjection2);
                }
            }
            ArrayList arrayList4 = arrayList3;
            kotlin.collections.CollectionsKt.sortWith(arrayList4, SpannedCellComparator.INSTANCE);
            int size4 = arrayList4.size();
            int i7 = 0;
            while (i7 < size4) {
                CellProjection cellProjection3 = (CellProjection) arrayList4.get(i7);
                int index = cellProjection3.getIndex();
                int index2 = (cellProjection3.getIndex() + cellProjection3.getSpan()) - i;
                int size5 = cellProjection3.getSize();
                if (index <= index2) {
                    int i8 = index;
                    size = size5;
                    weight = 0.0f;
                    i2 = 0;
                    while (true) {
                        Line line = arrayList2.get(i8);
                        size5 -= line.getSize();
                        if (line.isFlexible()) {
                            weight += line.getWeight();
                        } else {
                            if (line.getContentSize() == 0) {
                                i2++;
                            }
                            size -= line.getSize();
                        }
                        if (i8 == index2) {
                            break;
                        }
                        i8++;
                    }
                } else {
                    size = size5;
                    weight = 0.0f;
                    i2 = 0;
                }
                if (weight > 0.0f) {
                    if (index <= index2) {
                        while (true) {
                            Line line2 = arrayList2.get(index);
                            if (line2.isFlexible()) {
                                int iCeil = (int) Math.ceil((line2.getWeight() / weight) * size);
                                Line.include$default(line2, iCeil - line2.getMarginSize(), iCeil, 0.0f, 4, null);
                            }
                            if (index != index2) {
                                index++;
                            }
                        }
                    }
                } else if (size5 > 0 && index <= index2) {
                    while (true) {
                        Line line3 = arrayList2.get(index);
                        if (i2 <= 0) {
                            int span2 = size5 / cellProjection3.getSpan();
                            Line.include$default(line3, line3.getContentSize() + span2, line3.getSize() + span2, 0.0f, 4, null);
                        } else if (line3.getContentSize() == 0 && !line3.isFlexible()) {
                            int i9 = size5 / i2;
                            Line.include$default(line3, line3.getContentSize() + i9, line3.getSize() + i9, 0.0f, 4, null);
                        }
                        if (index != index2) {
                            index++;
                        }
                    }
                }
                i7++;
                i = 1;
            }
            adjustWeightedLines(arrayList2, sizeConstraint);
            align(arrayList2);
            return arrayList2;
        }

        private final List<Line> measureAxis(int count, SizeConstraint constraint, Function2<? super Cell, ? super View, CellProjection> projection) {
            int size;
            float weight;
            int i;
            List<Cell> list = this._cells.get();
            ArrayList arrayList = new ArrayList(count);
            for (int i2 = 0; i2 < count; i2++) {
                arrayList.add(new Line());
            }
            ArrayList arrayList2 = arrayList;
            GridContainer gridContainer = GridContainer.this;
            int size2 = list.size();
            for (int i3 = 0; i3 < size2; i3++) {
                Cell cell = list.get(i3);
                View child = gridContainer.getChildAt(cell.getViewIndex());
                Intrinsics.checkNotNullExpressionValue(child, "child");
                CellProjection cellProjectionInvoke = projection.invoke(cell, child);
                if (cellProjectionInvoke.getSpan() == 1) {
                    arrayList2.get(cellProjectionInvoke.getIndex()).include(cellProjectionInvoke.getContentSize(), cellProjectionInvoke.getSize(), cellProjectionInvoke.getWeight());
                } else {
                    int span = cellProjectionInvoke.getSpan() - 1;
                    float weight2 = cellProjectionInvoke.getWeight() / cellProjectionInvoke.getSpan();
                    if (span >= 0) {
                        while (true) {
                            Line.include$default(arrayList2.get(cellProjectionInvoke.getIndex() + i), 0, 0, weight2, 3, null);
                            i = i != span ? i + 1 : 0;
                        }
                    }
                }
            }
            ArrayList arrayList3 = new ArrayList();
            GridContainer gridContainer2 = GridContainer.this;
            int size3 = list.size();
            for (int i4 = 0; i4 < size3; i4++) {
                Cell cell2 = list.get(i4);
                View child2 = gridContainer2.getChildAt(cell2.getViewIndex());
                Intrinsics.checkNotNullExpressionValue(child2, "child");
                CellProjection cellProjectionInvoke2 = projection.invoke(cell2, child2);
                if (cellProjectionInvoke2.getSpan() > 1) {
                    arrayList3.add(cellProjectionInvoke2);
                }
            }
            ArrayList arrayList4 = arrayList3;
            kotlin.collections.CollectionsKt.sortWith(arrayList4, SpannedCellComparator.INSTANCE);
            int size4 = arrayList4.size();
            for (int i5 = 0; i5 < size4; i5++) {
                CellProjection cellProjection = (CellProjection) arrayList4.get(i5);
                int index = cellProjection.getIndex();
                int index2 = (cellProjection.getIndex() + cellProjection.getSpan()) - 1;
                int size5 = cellProjection.getSize();
                int i6 = 0;
                if (index <= index2) {
                    int i7 = index;
                    size = size5;
                    weight = 0.0f;
                    while (true) {
                        Line line = arrayList2.get(i7);
                        size5 -= line.getSize();
                        if (line.isFlexible()) {
                            weight += line.getWeight();
                        } else {
                            if (line.getContentSize() == 0) {
                                i6++;
                            }
                            size -= line.getSize();
                        }
                        if (i7 == index2) {
                            break;
                        }
                        i7++;
                    }
                } else {
                    size = size5;
                    weight = 0.0f;
                }
                if (weight > 0.0f) {
                    if (index <= index2) {
                        while (true) {
                            Line line2 = arrayList2.get(index);
                            if (line2.isFlexible()) {
                                int iCeil = (int) Math.ceil((line2.getWeight() / weight) * size);
                                Line.include$default(line2, iCeil - line2.getMarginSize(), iCeil, 0.0f, 4, null);
                            }
                            if (index != index2) {
                                index++;
                            }
                        }
                    }
                } else if (size5 > 0 && index <= index2) {
                    while (true) {
                        Line line3 = arrayList2.get(index);
                        if (i6 > 0) {
                            if (line3.getContentSize() == 0 && !line3.isFlexible()) {
                                int i8 = size5 / i6;
                                Line.include$default(line3, line3.getContentSize() + i8, line3.getSize() + i8, 0.0f, 4, null);
                            }
                        } else {
                            int span2 = size5 / cellProjection.getSpan();
                            Line.include$default(line3, line3.getContentSize() + span2, line3.getSize() + span2, 0.0f, 4, null);
                        }
                        if (index != index2) {
                            index++;
                        }
                    }
                }
            }
            adjustWeightedLines(arrayList2, constraint);
            align(arrayList2);
            return arrayList2;
        }

        private final void applyFixedParamsToLines(List<Cell> cells, List<Line> lines, Function2<? super Cell, ? super View, CellProjection> projection) {
            int i;
            GridContainer gridContainer = GridContainer.this;
            int size = cells.size();
            for (int i2 = 0; i2 < size; i2++) {
                Cell cell = cells.get(i2);
                View child = gridContainer.getChildAt(cell.getViewIndex());
                Intrinsics.checkNotNullExpressionValue(child, "child");
                CellProjection cellProjectionInvoke = projection.invoke(cell, child);
                if (cellProjectionInvoke.getSpan() == 1) {
                    lines.get(cellProjectionInvoke.getIndex()).include(cellProjectionInvoke.getContentSize(), cellProjectionInvoke.getSize(), cellProjectionInvoke.getWeight());
                } else {
                    int span = cellProjectionInvoke.getSpan() - 1;
                    float weight = cellProjectionInvoke.getWeight() / cellProjectionInvoke.getSpan();
                    if (span >= 0) {
                        while (true) {
                            Line.include$default(lines.get(cellProjectionInvoke.getIndex() + i), 0, 0, weight, 3, null);
                            i = i != span ? i + 1 : 0;
                        }
                    }
                }
            }
        }

        private final void applySpansToLines(List<Cell> cells, List<Line> lines, Function2<? super Cell, ? super View, CellProjection> projection) {
            int size;
            float weight;
            ArrayList arrayList = new ArrayList();
            GridContainer gridContainer = GridContainer.this;
            int size2 = cells.size();
            for (int i = 0; i < size2; i++) {
                Cell cell = cells.get(i);
                View child = gridContainer.getChildAt(cell.getViewIndex());
                Intrinsics.checkNotNullExpressionValue(child, "child");
                CellProjection cellProjectionInvoke = projection.invoke(cell, child);
                if (cellProjectionInvoke.getSpan() > 1) {
                    arrayList.add(cellProjectionInvoke);
                }
            }
            ArrayList arrayList2 = arrayList;
            kotlin.collections.CollectionsKt.sortWith(arrayList2, SpannedCellComparator.INSTANCE);
            int size3 = arrayList2.size();
            for (int i2 = 0; i2 < size3; i2++) {
                CellProjection cellProjection = (CellProjection) arrayList2.get(i2);
                int index = cellProjection.getIndex();
                int index2 = (cellProjection.getIndex() + cellProjection.getSpan()) - 1;
                int size4 = cellProjection.getSize();
                int i3 = 0;
                if (index <= index2) {
                    int i4 = index;
                    size = size4;
                    weight = 0.0f;
                    while (true) {
                        Line line = lines.get(i4);
                        size4 -= line.getSize();
                        if (line.isFlexible()) {
                            weight += line.getWeight();
                        } else {
                            if (line.getContentSize() == 0) {
                                i3++;
                            }
                            size -= line.getSize();
                        }
                        if (i4 == index2) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                } else {
                    size = size4;
                    weight = 0.0f;
                }
                if (weight > 0.0f) {
                    if (index <= index2) {
                        while (true) {
                            Line line2 = lines.get(index);
                            if (line2.isFlexible()) {
                                int iCeil = (int) Math.ceil((line2.getWeight() / weight) * size);
                                Line.include$default(line2, iCeil - line2.getMarginSize(), iCeil, 0.0f, 4, null);
                            }
                            if (index != index2) {
                                index++;
                            }
                        }
                    }
                } else if (size4 > 0 && index <= index2) {
                    while (true) {
                        Line line3 = lines.get(index);
                        if (i3 > 0) {
                            if (line3.getContentSize() == 0 && !line3.isFlexible()) {
                                int i5 = size4 / i3;
                                Line.include$default(line3, line3.getContentSize() + i5, line3.getSize() + i5, 0.0f, 4, null);
                            }
                        } else {
                            int span = size4 / cellProjection.getSpan();
                            Line.include$default(line3, line3.getContentSize() + span, line3.getSize() + span, 0.0f, 4, null);
                        }
                        if (index != index2) {
                            index++;
                        }
                    }
                }
            }
        }

        private final void align(List<Line> lines) {
            int size = lines.size();
            int size2 = 0;
            for (int i = 0; i < size; i++) {
                Line line = lines.get(i);
                line.setOffset(size2);
                size2 += line.getSize();
            }
        }

        private final void adjustWeightedLines(List<Line> lines, SizeConstraint constraint) {
            int size;
            int size2 = lines.size();
            float weight = 0.0f;
            int size3 = 0;
            float fMax = 0.0f;
            for (int i = 0; i < size2; i++) {
                Line line = lines.get(i);
                if (line.isFlexible()) {
                    weight += line.getWeight();
                    fMax = Math.max(fMax, line.getSize() / line.getWeight());
                } else {
                    size3 += line.getSize();
                }
                line.getSize();
            }
            int size4 = lines.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size4; i3++) {
                Line line2 = lines.get(i3);
                if (line2.isFlexible()) {
                    size = (int) Math.ceil(line2.getWeight() * fMax);
                } else {
                    size = line2.getSize();
                }
                i2 += size;
            }
            float fMax2 = Math.max(0, Math.max(constraint.getMin(), i2) - size3) / weight;
            int size5 = lines.size();
            for (int i4 = 0; i4 < size5; i4++) {
                Line line3 = lines.get(i4);
                if (line3.isFlexible()) {
                    int iCeil = (int) Math.ceil(line3.getWeight() * fMax2);
                    Line.include$default(line3, iCeil - line3.getMarginSize(), iCeil, 0.0f, 4, null);
                }
            }
        }
    }

    /* JADX INFO: compiled from: GridContainer.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/yandex/div/core/widget/GridContainer$SpannedCellComparator;", "Ljava/util/Comparator;", "Lcom/yandex/div/core/widget/GridContainer$CellProjection;", "Lkotlin/Comparator;", "()V", "compare", "", "lhs", "rhs", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class SpannedCellComparator implements Comparator<CellProjection> {
        public static final SpannedCellComparator INSTANCE = new SpannedCellComparator();

        private SpannedCellComparator() {
        }

        @Override // java.util.Comparator
        public int compare(CellProjection lhs, CellProjection rhs) {
            Intrinsics.checkNotNullParameter(lhs, "lhs");
            Intrinsics.checkNotNullParameter(rhs, "rhs");
            if (lhs.getSpecificSize() < rhs.getSpecificSize()) {
                return 1;
            }
            return lhs.getSpecificSize() > rhs.getSpecificSize() ? -1 : 0;
        }
    }

    private final int width(Cell cell, List<Line> list) {
        Line line = list.get((cell.getColumnIndex() + cell.getColumnSpan()) - 1);
        return (line.getOffset() + line.getSize()) - list.get(cell.getColumnIndex()).getOffset();
    }

    private final int height(Cell cell, List<Line> list) {
        Line line = list.get((cell.getRowIndex() + cell.getRowSpan()) - 1);
        return (line.getOffset() + line.getSize()) - list.get(cell.getRowIndex()).getOffset();
    }
}
