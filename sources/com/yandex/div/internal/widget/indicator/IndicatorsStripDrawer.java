package com.yandex.div.internal.widget.indicator;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.View;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.json.b9;
import com.yandex.div.core.util.ViewsKt;
import com.yandex.div.internal.widget.indicator.animations.IndicatorAnimator;
import com.yandex.div.internal.widget.indicator.forms.SingleIndicatorDrawer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: IndicatorsStripDrawer.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001:\u0002)*B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\fH\u0002J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\u0016\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000fJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0002J\u0006\u0010 \u001a\u00020\u000fJ\u000e\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020#J\u0016\u0010$\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\fJ\u000e\u0010&\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u000fJ\u000e\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00060\u0012R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/yandex/div/internal/widget/indicator/IndicatorsStripDrawer;", "", "styleParams", "Lcom/yandex/div/internal/widget/indicator/IndicatorParams$Style;", "singleIndicatorDrawer", "Lcom/yandex/div/internal/widget/indicator/forms/SingleIndicatorDrawer;", "animator", "Lcom/yandex/div/internal/widget/indicator/animations/IndicatorAnimator;", "view", "Landroid/view/View;", "(Lcom/yandex/div/internal/widget/indicator/IndicatorParams$Style;Lcom/yandex/div/internal/widget/indicator/forms/SingleIndicatorDrawer;Lcom/yandex/div/internal/widget/indicator/animations/IndicatorAnimator;Landroid/view/View;)V", "baseYOffset", "", "itemWidthMultiplier", "itemsCount", "", "maxVisibleCount", "ribbon", "Lcom/yandex/div/internal/widget/indicator/IndicatorsStripDrawer$IndicatorsRibbon;", "selectedItemFraction", "selectedItemPosition", "spaceBetweenCenters", "viewportHeight", "viewportWidth", "adjustItemsPlacement", "", "adjustVisibleItems", b9.h.L, "positionOffset", "calculateMaximumVisibleItems", "getItemSizeAt", "Lcom/yandex/div/internal/widget/indicator/IndicatorParams$ItemSize;", "getMaxVisibleItems", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onPageScrolled", "positionFraction", "onPageSelected", "setItemsCount", "count", "Indicator", "IndicatorsRibbon", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class IndicatorsStripDrawer {
    private final IndicatorAnimator animator;
    private float baseYOffset;
    private float itemWidthMultiplier;
    private int itemsCount;
    private int maxVisibleCount;
    private final IndicatorsRibbon ribbon;
    private float selectedItemFraction;
    private int selectedItemPosition;
    private final SingleIndicatorDrawer singleIndicatorDrawer;
    private float spaceBetweenCenters;
    private final IndicatorParams.Style styleParams;
    private final View view;
    private int viewportHeight;
    private int viewportWidth;

    public IndicatorsStripDrawer(IndicatorParams.Style styleParams, SingleIndicatorDrawer singleIndicatorDrawer, IndicatorAnimator animator, View view) {
        Intrinsics.checkNotNullParameter(styleParams, "styleParams");
        Intrinsics.checkNotNullParameter(singleIndicatorDrawer, "singleIndicatorDrawer");
        Intrinsics.checkNotNullParameter(animator, "animator");
        Intrinsics.checkNotNullParameter(view, "view");
        this.styleParams = styleParams;
        this.singleIndicatorDrawer = singleIndicatorDrawer;
        this.animator = animator;
        this.view = view;
        this.ribbon = new IndicatorsRibbon();
        this.baseYOffset = styleParams.getInactiveShape().getItemSize().getWidth();
        this.itemWidthMultiplier = 1.0f;
    }

    public final void onPageScrolled(int position, float positionFraction) {
        this.selectedItemPosition = position;
        this.selectedItemFraction = positionFraction;
        this.animator.onPageScrolled(position, positionFraction);
        adjustVisibleItems(position, positionFraction);
    }

    public final void onPageSelected(int position) {
        this.selectedItemPosition = position;
        this.selectedItemFraction = 0.0f;
        this.animator.onPageSelected(position);
        adjustVisibleItems(position, 0.0f);
    }

    public final void onDraw(Canvas canvas) {
        Object next;
        RectF selectedItemRect;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        for (Indicator indicator : this.ribbon.getVisibleItems()) {
            this.singleIndicatorDrawer.draw(canvas, indicator.getCenterOffset(), this.baseYOffset, indicator.getItemSize(), this.animator.getColorAt(indicator.getPosition()), this.animator.getBorderWidthAt(indicator.getPosition()), this.animator.getBorderColorAt(indicator.getPosition()));
        }
        Iterator<T> it = this.ribbon.getVisibleItems().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((Indicator) next).getActive());
        Indicator indicator2 = (Indicator) next;
        if (indicator2 == null || (selectedItemRect = this.animator.getSelectedItemRect(indicator2.getCenterOffset(), this.baseYOffset, this.viewportWidth, ViewsKt.isLayoutRtl(this.view))) == null) {
            return;
        }
        this.singleIndicatorDrawer.drawSelected(canvas, selectedItemRect);
    }

    public final void setItemsCount(int count) {
        this.itemsCount = count;
        this.animator.setItemsCount(count);
        calculateMaximumVisibleItems();
        this.baseYOffset = this.viewportHeight / 2.0f;
    }

    public final void calculateMaximumVisibleItems(int viewportWidth, int viewportHeight) {
        if (viewportWidth == 0 || viewportHeight == 0) {
            return;
        }
        this.viewportWidth = viewportWidth;
        this.viewportHeight = viewportHeight;
        calculateMaximumVisibleItems();
        adjustItemsPlacement();
        this.baseYOffset = viewportHeight / 2.0f;
        adjustVisibleItems(this.selectedItemPosition, this.selectedItemFraction);
    }

    /* JADX INFO: renamed from: getMaxVisibleItems, reason: from getter */
    public final int getMaxVisibleCount() {
        return this.maxVisibleCount;
    }

    private final void calculateMaximumVisibleItems() {
        int maxVisibleItems;
        IndicatorParams.ItemPlacement itemsPlacement = this.styleParams.getItemsPlacement();
        if (itemsPlacement instanceof IndicatorParams.ItemPlacement.Default) {
            maxVisibleItems = (int) (this.viewportWidth / ((IndicatorParams.ItemPlacement.Default) itemsPlacement).getSpaceBetweenCenters());
        } else {
            if (!(itemsPlacement instanceof IndicatorParams.ItemPlacement.Stretch)) {
                throw new NoWhenBranchMatchedException();
            }
            maxVisibleItems = ((IndicatorParams.ItemPlacement.Stretch) itemsPlacement).getMaxVisibleItems();
        }
        this.maxVisibleCount = RangesKt.coerceAtMost(maxVisibleItems, this.itemsCount);
    }

    private final void adjustVisibleItems(int position, float positionOffset) {
        this.ribbon.relayout(position, positionOffset);
    }

    private final void adjustItemsPlacement() {
        IndicatorParams.ItemPlacement itemsPlacement = this.styleParams.getItemsPlacement();
        if (itemsPlacement instanceof IndicatorParams.ItemPlacement.Default) {
            this.spaceBetweenCenters = ((IndicatorParams.ItemPlacement.Default) itemsPlacement).getSpaceBetweenCenters();
            this.itemWidthMultiplier = 1.0f;
        } else if (itemsPlacement instanceof IndicatorParams.ItemPlacement.Stretch) {
            IndicatorParams.ItemPlacement.Stretch stretch = (IndicatorParams.ItemPlacement.Stretch) itemsPlacement;
            float itemSpacing = (this.viewportWidth + stretch.getItemSpacing()) / this.maxVisibleCount;
            this.spaceBetweenCenters = itemSpacing;
            this.itemWidthMultiplier = (itemSpacing - stretch.getItemSpacing()) / this.styleParams.getActiveShape().getItemSize().getWidth();
        }
        this.animator.updateSpaceBetweenCenters(this.spaceBetweenCenters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IndicatorParams.ItemSize getItemSizeAt(int position) {
        IndicatorParams.ItemSize itemSizeAt = this.animator.getItemSizeAt(position);
        if (this.itemWidthMultiplier == 1.0f || !(itemSizeAt instanceof IndicatorParams.ItemSize.RoundedRect)) {
            return itemSizeAt;
        }
        IndicatorParams.ItemSize.RoundedRect roundedRect = (IndicatorParams.ItemSize.RoundedRect) itemSizeAt;
        IndicatorParams.ItemSize.RoundedRect roundedRectCopy$default = IndicatorParams.ItemSize.RoundedRect.copy$default(roundedRect, roundedRect.getItemWidth() * this.itemWidthMultiplier, 0.0f, 0.0f, 6, null);
        this.animator.overrideItemWidth(roundedRectCopy$default.getItemWidth());
        return roundedRectCopy$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: IndicatorsStripDrawer.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J;\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006$"}, d2 = {"Lcom/yandex/div/internal/widget/indicator/IndicatorsStripDrawer$Indicator;", "", b9.h.L, "", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "", "centerOffset", "", "itemSize", "Lcom/yandex/div/internal/widget/indicator/IndicatorParams$ItemSize;", "scaleFactor", "(IZFLcom/yandex/div/internal/widget/indicator/IndicatorParams$ItemSize;F)V", "getActive", "()Z", "getCenterOffset", "()F", "getItemSize", "()Lcom/yandex/div/internal/widget/indicator/IndicatorParams$ItemSize;", "left", "getLeft", "getPosition", "()I", "right", "getRight", "getScaleFactor", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    static final /* data */ class Indicator {
        private final boolean active;
        private final float centerOffset;
        private final IndicatorParams.ItemSize itemSize;
        private final int position;
        private final float scaleFactor;

        public static /* synthetic */ Indicator copy$default(Indicator indicator, int i, boolean z, float f, IndicatorParams.ItemSize itemSize, float f2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = indicator.position;
            }
            if ((i2 & 2) != 0) {
                z = indicator.active;
            }
            boolean z2 = z;
            if ((i2 & 4) != 0) {
                f = indicator.centerOffset;
            }
            float f3 = f;
            if ((i2 & 8) != 0) {
                itemSize = indicator.itemSize;
            }
            IndicatorParams.ItemSize itemSize2 = itemSize;
            if ((i2 & 16) != 0) {
                f2 = indicator.scaleFactor;
            }
            return indicator.copy(i, z2, f3, itemSize2, f2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getPosition() {
            return this.position;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getActive() {
            return this.active;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final float getCenterOffset() {
            return this.centerOffset;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final IndicatorParams.ItemSize getItemSize() {
            return this.itemSize;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final float getScaleFactor() {
            return this.scaleFactor;
        }

        public final Indicator copy(int position, boolean active, float centerOffset, IndicatorParams.ItemSize itemSize, float scaleFactor) {
            Intrinsics.checkNotNullParameter(itemSize, "itemSize");
            return new Indicator(position, active, centerOffset, itemSize, scaleFactor);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Indicator)) {
                return false;
            }
            Indicator indicator = (Indicator) other;
            return this.position == indicator.position && this.active == indicator.active && Float.compare(this.centerOffset, indicator.centerOffset) == 0 && Intrinsics.areEqual(this.itemSize, indicator.itemSize) && Float.compare(this.scaleFactor, indicator.scaleFactor) == 0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r1v9 */
        public int hashCode() {
            int iHashCode = Integer.hashCode(this.position) * 31;
            boolean z = this.active;
            ?? r1 = z;
            if (z) {
                r1 = 1;
            }
            return ((((((iHashCode + r1) * 31) + Float.hashCode(this.centerOffset)) * 31) + this.itemSize.hashCode()) * 31) + Float.hashCode(this.scaleFactor);
        }

        public String toString() {
            return "Indicator(position=" + this.position + ", active=" + this.active + ", centerOffset=" + this.centerOffset + ", itemSize=" + this.itemSize + ", scaleFactor=" + this.scaleFactor + ')';
        }

        public Indicator(int i, boolean z, float f, IndicatorParams.ItemSize itemSize, float f2) {
            Intrinsics.checkNotNullParameter(itemSize, "itemSize");
            this.position = i;
            this.active = z;
            this.centerOffset = f;
            this.itemSize = itemSize;
            this.scaleFactor = f2;
        }

        public /* synthetic */ Indicator(int i, boolean z, float f, IndicatorParams.ItemSize itemSize, float f2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, z, f, itemSize, (i2 & 16) != 0 ? 1.0f : f2);
        }

        public final int getPosition() {
            return this.position;
        }

        public final boolean getActive() {
            return this.active;
        }

        public final float getCenterOffset() {
            return this.centerOffset;
        }

        public final IndicatorParams.ItemSize getItemSize() {
            return this.itemSize;
        }

        public final float getScaleFactor() {
            return this.scaleFactor;
        }

        public final float getLeft() {
            return this.centerOffset - (this.itemSize.getWidth() / 2.0f);
        }

        public final float getRight() {
            return this.centerOffset + (this.itemSize.getWidth() / 2.0f);
        }
    }

    /* JADX INFO: compiled from: IndicatorsStripDrawer.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u0016\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0016\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nJ\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00152\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0002J5\u0010\u0016\u001a\u00020\u0011\"\b\b\u0000\u0010\u0017*\u00020\u00012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00042\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00170\u001aH\u0082\bJ\u0018\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\nH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/yandex/div/internal/widget/indicator/IndicatorsStripDrawer$IndicatorsRibbon;", "", "(Lcom/yandex/div/internal/widget/indicator/IndicatorsStripDrawer;)V", "allItems", "", "Lcom/yandex/div/internal/widget/indicator/IndicatorsStripDrawer$Indicator;", "visibleItems", "getVisibleItems", "()Ljava/util/List;", "calcOffsetShiftFor", "", "activePosition", "", "positionFraction", "calcScaleFraction", "absOffset", "downscaleAndDisperse", "", "viewportItems", "relayout", "relayoutVisibleItems", "", "replaceAll", "T", "list", "operator", "Lkotlin/Function1;", "scaleItem", "item", "scaleFraction", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private final class IndicatorsRibbon {
        private final List<Indicator> allItems = new ArrayList();
        private final List<Indicator> visibleItems = new ArrayList();

        public IndicatorsRibbon() {
        }

        public final List<Indicator> getVisibleItems() {
            return this.visibleItems;
        }

        public final void relayout(int activePosition, float positionFraction) {
            float centerOffset;
            this.allItems.clear();
            this.visibleItems.clear();
            if (IndicatorsStripDrawer.this.itemsCount <= 0) {
                return;
            }
            IntProgression indices = ViewsKt.getIndices(IndicatorsStripDrawer.this.view, 0, IndicatorsStripDrawer.this.itemsCount);
            int first = indices.getFirst();
            IndicatorsStripDrawer indicatorsStripDrawer = IndicatorsStripDrawer.this;
            Iterator<Integer> it = indices.iterator();
            while (it.hasNext()) {
                int iNextInt = ((IntIterator) it).nextInt();
                IndicatorParams.ItemSize itemSizeAt = indicatorsStripDrawer.getItemSizeAt(iNextInt);
                if (iNextInt != first) {
                    centerOffset = ((Indicator) CollectionsKt.last((List) this.allItems)).getCenterOffset() + indicatorsStripDrawer.spaceBetweenCenters;
                } else {
                    centerOffset = itemSizeAt.getWidth() / 2.0f;
                }
                this.allItems.add(new Indicator(iNextInt, iNextInt == activePosition, centerOffset, itemSizeAt, 0.0f, 16, null));
            }
            this.visibleItems.addAll(relayoutVisibleItems(activePosition, positionFraction));
        }

        private final List<Indicator> relayoutVisibleItems(int activePosition, float positionFraction) {
            float fCalcOffsetShiftFor = calcOffsetShiftFor(activePosition, positionFraction);
            List<Indicator> list = this.allItems;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Indicator indicator : list) {
                arrayList.add(Indicator.copy$default(indicator, 0, false, indicator.getCenterOffset() + fCalcOffsetShiftFor, null, 0.0f, 27, null));
            }
            List<Indicator> mutableList = CollectionsKt.toMutableList((Collection) arrayList);
            if (mutableList.size() <= IndicatorsStripDrawer.this.maxVisibleCount) {
                return mutableList;
            }
            final ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, IndicatorsStripDrawer.this.viewportWidth);
            int i = 0;
            if (closedFloatingPointRangeRangeTo.contains(Float.valueOf(((Indicator) CollectionsKt.first((List) mutableList)).getLeft()))) {
                float f = -((Indicator) CollectionsKt.first((List) mutableList)).getLeft();
                for (Object obj : mutableList) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    Indicator indicator2 = (Indicator) obj;
                    mutableList.set(i, Indicator.copy$default(indicator2, 0, false, indicator2.getCenterOffset() + f, null, 0.0f, 27, null));
                    i = i2;
                }
            } else if (closedFloatingPointRangeRangeTo.contains(Float.valueOf(((Indicator) CollectionsKt.last((List) mutableList)).getRight()))) {
                float right = IndicatorsStripDrawer.this.viewportWidth - ((Indicator) CollectionsKt.last((List) mutableList)).getRight();
                for (Object obj2 : mutableList) {
                    int i3 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    Indicator indicator3 = (Indicator) obj2;
                    mutableList.set(i, Indicator.copy$default(indicator3, 0, false, indicator3.getCenterOffset() + right, null, 0.0f, 27, null));
                    i = i3;
                }
            }
            CollectionsKt.removeAll((List) mutableList, (Function1) new Function1<Indicator, Boolean>() { // from class: com.yandex.div.internal.widget.indicator.IndicatorsStripDrawer$IndicatorsRibbon$relayoutVisibleItems$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(IndicatorsStripDrawer.Indicator it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(!closedFloatingPointRangeRangeTo.contains(Float.valueOf(it.getCenterOffset())));
                }
            });
            downscaleAndDisperse(mutableList);
            return mutableList;
        }

        private final float calcOffsetShiftFor(int activePosition, float positionFraction) {
            float centerOffset;
            if (this.allItems.size() <= IndicatorsStripDrawer.this.maxVisibleCount) {
                return (IndicatorsStripDrawer.this.viewportWidth / 2.0f) - (((Indicator) CollectionsKt.last((List) this.allItems)).getRight() / 2);
            }
            float f = IndicatorsStripDrawer.this.viewportWidth / 2.0f;
            float centerOffset2 = 0.0f;
            if (ViewsKt.isLayoutRtl(IndicatorsStripDrawer.this.view)) {
                if (activePosition != -1) {
                    List<Indicator> list = this.allItems;
                    centerOffset2 = list.get((list.size() - 1) - activePosition).getCenterOffset();
                }
                centerOffset = (f - centerOffset2) + (IndicatorsStripDrawer.this.spaceBetweenCenters * positionFraction);
            } else {
                centerOffset = (f - (activePosition != -1 ? this.allItems.get(activePosition).getCenterOffset() : 0.0f)) - (IndicatorsStripDrawer.this.spaceBetweenCenters * positionFraction);
            }
            return IndicatorsStripDrawer.this.maxVisibleCount % 2 == 0 ? centerOffset + (IndicatorsStripDrawer.this.spaceBetweenCenters / 2) : centerOffset;
        }

        private final void downscaleAndDisperse(List<Indicator> viewportItems) {
            int iNextIndex;
            Indicator indicator;
            Indicator indicatorCopy$default;
            IndicatorsStripDrawer indicatorsStripDrawer = IndicatorsStripDrawer.this;
            List<Indicator> list = viewportItems;
            int i = 0;
            int i2 = 0;
            for (Object obj : list) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Indicator indicator2 = (Indicator) obj;
                float fCalcScaleFraction = calcScaleFraction(indicator2.getCenterOffset());
                if (indicator2.getPosition() == 0 || indicator2.getPosition() == indicatorsStripDrawer.itemsCount - 1 || indicator2.getActive()) {
                    indicatorCopy$default = Indicator.copy$default(indicator2, 0, false, 0.0f, null, fCalcScaleFraction, 15, null);
                } else {
                    indicatorCopy$default = scaleItem(indicator2, fCalcScaleFraction);
                }
                viewportItems.set(i2, indicatorCopy$default);
                i2 = i3;
            }
            Iterator<Indicator> it = viewportItems.iterator();
            int i4 = 0;
            while (true) {
                iNextIndex = -1;
                if (!it.hasNext()) {
                    i4 = -1;
                    break;
                } else if (it.next().getScaleFactor() == 1.0f) {
                    break;
                } else {
                    i4++;
                }
            }
            Integer numValueOf = Integer.valueOf(i4);
            if (numValueOf.intValue() < 0) {
                numValueOf = null;
            }
            if (numValueOf != null) {
                int iIntValue = numValueOf.intValue();
                ListIterator<Indicator> listIterator = viewportItems.listIterator(viewportItems.size());
                while (listIterator.hasPrevious()) {
                    if (listIterator.previous().getScaleFactor() == 1.0f) {
                        iNextIndex = listIterator.nextIndex();
                        break;
                    }
                }
                Integer numValueOf2 = Integer.valueOf(iNextIndex);
                Integer num = numValueOf2.intValue() >= 0 ? numValueOf2 : null;
                if (num != null) {
                    int i5 = iIntValue - 1;
                    int iIntValue2 = num.intValue() + 1;
                    IndicatorsStripDrawer indicatorsStripDrawer2 = IndicatorsStripDrawer.this;
                    for (Object obj2 : list) {
                        int i6 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        Indicator indicator3 = (Indicator) obj2;
                        if (i < i5) {
                            Indicator indicator4 = (Indicator) CollectionsKt.getOrNull(viewportItems, i5);
                            if (indicator4 != null) {
                                viewportItems.set(i, Indicator.copy$default(indicator3, 0, false, indicator3.getCenterOffset() - (indicatorsStripDrawer2.spaceBetweenCenters * (1.0f - indicator4.getScaleFactor())), null, 0.0f, 27, null));
                                if (i <= iIntValue2) {
                                }
                            }
                        } else if (i <= iIntValue2 && (indicator = (Indicator) CollectionsKt.getOrNull(viewportItems, iIntValue2)) != null) {
                            viewportItems.set(i, Indicator.copy$default(indicator3, 0, false, indicator3.getCenterOffset() + (indicatorsStripDrawer2.spaceBetweenCenters * (1.0f - indicator.getScaleFactor())), null, 0.0f, 27, null));
                        }
                        i = i6;
                    }
                }
            }
        }

        private final float calcScaleFraction(float absOffset) {
            float f = IndicatorsStripDrawer.this.spaceBetweenCenters + 0.0f;
            if (absOffset > f) {
                absOffset = RangesKt.coerceAtMost(IndicatorsStripDrawer.this.viewportWidth - absOffset, f);
            }
            if (absOffset > f) {
                return 1.0f;
            }
            return RangesKt.coerceIn(absOffset / (f - 0.0f), 0.0f, 1.0f);
        }

        private final Indicator scaleItem(Indicator item, float scaleFraction) {
            IndicatorParams.ItemSize itemSize = item.getItemSize();
            float width = itemSize.getWidth() * scaleFraction;
            if (width <= IndicatorsStripDrawer.this.styleParams.getMinimumShape().getItemSize().getWidth()) {
                return Indicator.copy$default(item, 0, false, 0.0f, IndicatorsStripDrawer.this.styleParams.getMinimumShape().getItemSize(), scaleFraction, 7, null);
            }
            if (width >= itemSize.getWidth()) {
                return item;
            }
            if (itemSize instanceof IndicatorParams.ItemSize.RoundedRect) {
                IndicatorParams.ItemSize.RoundedRect roundedRect = (IndicatorParams.ItemSize.RoundedRect) itemSize;
                return Indicator.copy$default(item, 0, false, 0.0f, IndicatorParams.ItemSize.RoundedRect.copy$default(roundedRect, width, roundedRect.getItemHeight() * (width / roundedRect.getItemWidth()), 0.0f, 4, null), scaleFraction, 7, null);
            }
            if (itemSize instanceof IndicatorParams.ItemSize.Circle) {
                return Indicator.copy$default(item, 0, false, 0.0f, ((IndicatorParams.ItemSize.Circle) itemSize).copy((itemSize.getWidth() * scaleFraction) / 2.0f), scaleFraction, 7, null);
            }
            throw new NoWhenBranchMatchedException();
        }

        private final <T> void replaceAll(List<T> list, Function1<? super T, ? extends T> operator) {
            int i = 0;
            for (T t : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                list.set(i, operator.invoke(t));
                i = i2;
            }
        }
    }
}
