package com.yandex.div.core.view2.items;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import com.yandex.div.core.view2.divs.widgets.DivPagerView;
import com.yandex.div.core.view2.divs.widgets.DivRecyclerView;
import com.yandex.div.core.view2.divs.widgets.DivTabsLayout;
import com.yandex.div.internal.Assert;
import com.yandex.div.internal.KAssert;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivGallery;
import com.yandex.div2.DivSizeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivViewWithItems.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u001d2\u00020\u0001:\u0005\u001d\u001e\u001f !B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u0004H\u0016R\u0018\u0010\u0003\u001a\u00020\u0004X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006\u0082\u0001\u0004\"#$%¨\u0006&"}, d2 = {"Lcom/yandex/div/core/view2/items/DivViewWithItems;", "", "()V", "currentItem", "", "getCurrentItem", "()I", "setCurrentItem", "(I)V", "itemCount", "getItemCount", "metrics", "Landroid/util/DisplayMetrics;", "getMetrics", "()Landroid/util/DisplayMetrics;", "scrollOffset", "getScrollOffset", "scrollRange", "getScrollRange", "scrollTo", "", "value", "sizeUnit", "Lcom/yandex/div2/DivSizeUnit;", "animated", "", "scrollToTheEnd", "setCurrentItemNoAnimation", "index", "Companion", "Gallery", "Pager", "PagingGallery", "Tabs", "Lcom/yandex/div/core/view2/items/DivViewWithItems$Gallery;", "Lcom/yandex/div/core/view2/items/DivViewWithItems$Pager;", "Lcom/yandex/div/core/view2/items/DivViewWithItems$PagingGallery;", "Lcom/yandex/div/core/view2/items/DivViewWithItems$Tabs;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class DivViewWithItems {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static DivViewWithItems viewForTests;
    private final int scrollOffset;
    private final int scrollRange;

    public /* synthetic */ DivViewWithItems(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract int getCurrentItem();

    public abstract int getItemCount();

    public abstract DisplayMetrics getMetrics();

    public void scrollTo(int value, DivSizeUnit sizeUnit, boolean animated) {
        Intrinsics.checkNotNullParameter(sizeUnit, "sizeUnit");
    }

    public void scrollToTheEnd(boolean animated) {
    }

    public abstract void setCurrentItem(int i);

    public void setCurrentItemNoAnimation(int index) {
    }

    private DivViewWithItems() {
    }

    public int getScrollRange() {
        return this.scrollRange;
    }

    public int getScrollOffset() {
        return this.scrollOffset;
    }

    public static /* synthetic */ void scrollTo$default(DivViewWithItems divViewWithItems, int i, DivSizeUnit divSizeUnit, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scrollTo");
        }
        if ((i2 & 2) != 0) {
            divSizeUnit = DivSizeUnit.PX;
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        divViewWithItems.scrollTo(i, divSizeUnit, z);
    }

    public static /* synthetic */ void scrollToTheEnd$default(DivViewWithItems divViewWithItems, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scrollToTheEnd");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        divViewWithItems.scrollToTheEnd(z);
    }

    /* JADX INFO: compiled from: DivViewWithItems.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\bH\u0016R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000bR\u0014\u0010\u0017\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/yandex/div/core/view2/items/DivViewWithItems$PagingGallery;", "Lcom/yandex/div/core/view2/items/DivViewWithItems;", "view", "Lcom/yandex/div/core/view2/divs/widgets/DivRecyclerView;", "direction", "Lcom/yandex/div/core/view2/items/Direction;", "(Lcom/yandex/div/core/view2/divs/widgets/DivRecyclerView;Lcom/yandex/div/core/view2/items/Direction;)V", "value", "", "currentItem", "getCurrentItem", "()I", "setCurrentItem", "(I)V", "itemCount", "getItemCount", "metrics", "Landroid/util/DisplayMetrics;", "kotlin.jvm.PlatformType", "getMetrics", "()Landroid/util/DisplayMetrics;", "scrollOffset", "getScrollOffset", "scrollRange", "getScrollRange", "scrollTo", "", "sizeUnit", "Lcom/yandex/div2/DivSizeUnit;", "animated", "", "scrollToTheEnd", "setCurrentItemNoAnimation", "index", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class PagingGallery extends DivViewWithItems {
        private final Direction direction;
        private final DisplayMetrics metrics;
        private final DivRecyclerView view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PagingGallery(DivRecyclerView view, Direction direction) {
            super(null);
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(direction, "direction");
            this.view = view;
            this.direction = direction;
            this.metrics = view.getResources().getDisplayMetrics();
        }

        @Override // com.yandex.div.core.view2.items.DivViewWithItems
        public DisplayMetrics getMetrics() {
            return this.metrics;
        }

        @Override // com.yandex.div.core.view2.items.DivViewWithItems
        public int getCurrentItem() {
            return DivViewWithItemsKt.currentItem(this.view, this.direction);
        }

        @Override // com.yandex.div.core.view2.items.DivViewWithItems
        public void setCurrentItem(int i) {
            int itemCount = getItemCount();
            if (i >= 0 && i < itemCount) {
                this.view.smoothScrollToPosition(i);
                return;
            }
            KAssert kAssert = KAssert.INSTANCE;
            if (Assert.isEnabled()) {
                Assert.fail(i + " is not in range [0, " + itemCount + ')');
            }
        }

        @Override // com.yandex.div.core.view2.items.DivViewWithItems
        public int getItemCount() {
            return DivViewWithItemsKt.getItemCount(this.view);
        }

        @Override // com.yandex.div.core.view2.items.DivViewWithItems
        public int getScrollRange() {
            return DivViewWithItemsKt.scrollRange(this.view);
        }

        @Override // com.yandex.div.core.view2.items.DivViewWithItems
        public int getScrollOffset() {
            return DivViewWithItemsKt.scrollOffset(this.view);
        }

        @Override // com.yandex.div.core.view2.items.DivViewWithItems
        public void scrollTo(int value, DivSizeUnit sizeUnit, boolean animated) {
            Intrinsics.checkNotNullParameter(sizeUnit, "sizeUnit");
            DivRecyclerView divRecyclerView = this.view;
            DisplayMetrics metrics = getMetrics();
            Intrinsics.checkNotNullExpressionValue(metrics, "metrics");
            DivViewWithItemsKt.scrollTo(divRecyclerView, value, sizeUnit, metrics, animated);
        }

        @Override // com.yandex.div.core.view2.items.DivViewWithItems
        public void scrollToTheEnd(boolean animated) {
            DivRecyclerView divRecyclerView = this.view;
            DisplayMetrics metrics = getMetrics();
            Intrinsics.checkNotNullExpressionValue(metrics, "metrics");
            DivViewWithItemsKt.scrollToTheEnd(divRecyclerView, metrics, animated);
        }

        @Override // com.yandex.div.core.view2.items.DivViewWithItems
        public void setCurrentItemNoAnimation(int index) {
            int itemCount = getItemCount();
            if (index >= 0 && index < itemCount) {
                this.view.scrollToPosition(index);
                return;
            }
            KAssert kAssert = KAssert.INSTANCE;
            if (Assert.isEnabled()) {
                Assert.fail(index + " is not in range [0, " + itemCount + ')');
            }
        }
    }

    /* JADX INFO: compiled from: DivViewWithItems.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\bH\u0016R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000bR\u0014\u0010\u0017\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/yandex/div/core/view2/items/DivViewWithItems$Gallery;", "Lcom/yandex/div/core/view2/items/DivViewWithItems;", "view", "Lcom/yandex/div/core/view2/divs/widgets/DivRecyclerView;", "direction", "Lcom/yandex/div/core/view2/items/Direction;", "(Lcom/yandex/div/core/view2/divs/widgets/DivRecyclerView;Lcom/yandex/div/core/view2/items/Direction;)V", "value", "", "currentItem", "getCurrentItem", "()I", "setCurrentItem", "(I)V", "itemCount", "getItemCount", "metrics", "Landroid/util/DisplayMetrics;", "kotlin.jvm.PlatformType", "getMetrics", "()Landroid/util/DisplayMetrics;", "scrollOffset", "getScrollOffset", "scrollRange", "getScrollRange", "scrollTo", "", "sizeUnit", "Lcom/yandex/div2/DivSizeUnit;", "animated", "", "scrollToTheEnd", "setCurrentItemNoAnimation", "index", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Gallery extends DivViewWithItems {
        private final Direction direction;
        private final DisplayMetrics metrics;
        private final DivRecyclerView view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Gallery(DivRecyclerView view, Direction direction) {
            super(null);
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(direction, "direction");
            this.view = view;
            this.direction = direction;
            this.metrics = view.getResources().getDisplayMetrics();
        }

        @Override // com.yandex.div.core.view2.items.DivViewWithItems
        public DisplayMetrics getMetrics() {
            return this.metrics;
        }

        @Override // com.yandex.div.core.view2.items.DivViewWithItems
        public int getCurrentItem() {
            return DivViewWithItemsKt.currentItem(this.view, this.direction);
        }

        @Override // com.yandex.div.core.view2.items.DivViewWithItems
        public void setCurrentItem(int i) {
            int itemCount = getItemCount();
            if (i >= 0 && i < itemCount) {
                final Context context = this.view.getContext();
                LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(context) { // from class: com.yandex.div.core.view2.items.DivViewWithItems$Gallery$currentItem$1$smoothScroller$1
                    private final float MILLISECONDS_PER_INCH = 50.0f;

                    @Override // androidx.recyclerview.widget.LinearSmoothScroller
                    protected int getHorizontalSnapPreference() {
                        return -1;
                    }

                    @Override // androidx.recyclerview.widget.LinearSmoothScroller
                    protected int getVerticalSnapPreference() {
                        return -1;
                    }

                    @Override // androidx.recyclerview.widget.LinearSmoothScroller
                    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                        Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
                        return this.MILLISECONDS_PER_INCH / displayMetrics.densityDpi;
                    }
                };
                linearSmoothScroller.setTargetPosition(i);
                RecyclerView.LayoutManager layoutManager = this.view.getLayoutManager();
                if (layoutManager != null) {
                    layoutManager.startSmoothScroll(linearSmoothScroller);
                    return;
                }
                return;
            }
            KAssert kAssert = KAssert.INSTANCE;
            if (Assert.isEnabled()) {
                Assert.fail(i + " is not in range [0, " + itemCount + ')');
            }
        }

        @Override // com.yandex.div.core.view2.items.DivViewWithItems
        public int getItemCount() {
            return DivViewWithItemsKt.getItemCount(this.view);
        }

        @Override // com.yandex.div.core.view2.items.DivViewWithItems
        public int getScrollRange() {
            return DivViewWithItemsKt.scrollRange(this.view);
        }

        @Override // com.yandex.div.core.view2.items.DivViewWithItems
        public int getScrollOffset() {
            return DivViewWithItemsKt.scrollOffset(this.view);
        }

        @Override // com.yandex.div.core.view2.items.DivViewWithItems
        public void scrollTo(int value, DivSizeUnit sizeUnit, boolean animated) {
            Intrinsics.checkNotNullParameter(sizeUnit, "sizeUnit");
            DivRecyclerView divRecyclerView = this.view;
            DisplayMetrics metrics = getMetrics();
            Intrinsics.checkNotNullExpressionValue(metrics, "metrics");
            DivViewWithItemsKt.scrollTo(divRecyclerView, value, sizeUnit, metrics, animated);
        }

        @Override // com.yandex.div.core.view2.items.DivViewWithItems
        public void scrollToTheEnd(boolean animated) {
            DivRecyclerView divRecyclerView = this.view;
            DisplayMetrics metrics = getMetrics();
            Intrinsics.checkNotNullExpressionValue(metrics, "metrics");
            DivViewWithItemsKt.scrollToTheEnd(divRecyclerView, metrics, animated);
        }

        @Override // com.yandex.div.core.view2.items.DivViewWithItems
        public void setCurrentItemNoAnimation(int index) {
            int itemCount = getItemCount();
            if (index >= 0 && index < itemCount) {
                this.view.scrollToPosition(index);
                return;
            }
            KAssert kAssert = KAssert.INSTANCE;
            if (Assert.isEnabled()) {
                Assert.fail(index + " is not in range [0, " + itemCount + ')');
            }
        }
    }

    /* JADX INFO: compiled from: DivViewWithItems.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0006H\u0016R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u001c\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/yandex/div/core/view2/items/DivViewWithItems$Pager;", "Lcom/yandex/div/core/view2/items/DivViewWithItems;", "view", "Lcom/yandex/div/core/view2/divs/widgets/DivPagerView;", "(Lcom/yandex/div/core/view2/divs/widgets/DivPagerView;)V", "value", "", "currentItem", "getCurrentItem", "()I", "setCurrentItem", "(I)V", "itemCount", "getItemCount", "metrics", "Landroid/util/DisplayMetrics;", "kotlin.jvm.PlatformType", "getMetrics", "()Landroid/util/DisplayMetrics;", "scrollToTheEnd", "", "animated", "", "setCurrentItemNoAnimation", "index", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Pager extends DivViewWithItems {
        private final DisplayMetrics metrics;
        private final DivPagerView view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Pager(DivPagerView view) {
            super(null);
            Intrinsics.checkNotNullParameter(view, "view");
            this.view = view;
            this.metrics = view.getResources().getDisplayMetrics();
        }

        @Override // com.yandex.div.core.view2.items.DivViewWithItems
        public DisplayMetrics getMetrics() {
            return this.metrics;
        }

        @Override // com.yandex.div.core.view2.items.DivViewWithItems
        public int getCurrentItem() {
            return this.view.getViewPager().getCurrentItem();
        }

        @Override // com.yandex.div.core.view2.items.DivViewWithItems
        public void setCurrentItem(int i) {
            int itemCount = getItemCount();
            if (i >= 0 && i < itemCount) {
                this.view.getViewPager().setCurrentItem(i, true);
                return;
            }
            KAssert kAssert = KAssert.INSTANCE;
            if (Assert.isEnabled()) {
                Assert.fail(i + " is not in range [0, " + itemCount + ')');
            }
        }

        @Override // com.yandex.div.core.view2.items.DivViewWithItems
        public int getItemCount() {
            RecyclerView.Adapter adapter = this.view.getViewPager().getAdapter();
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        @Override // com.yandex.div.core.view2.items.DivViewWithItems
        public void scrollToTheEnd(boolean animated) {
            this.view.getViewPager().setCurrentItem(getItemCount() - 1, animated);
        }

        @Override // com.yandex.div.core.view2.items.DivViewWithItems
        public void setCurrentItemNoAnimation(int index) {
            int itemCount = getItemCount();
            if (index >= 0 && index < itemCount) {
                this.view.getViewPager().setCurrentItem(index, false);
                return;
            }
            KAssert kAssert = KAssert.INSTANCE;
            if (Assert.isEnabled()) {
                Assert.fail(index + " is not in range [0, " + itemCount + ')');
            }
        }
    }

    /* JADX INFO: compiled from: DivViewWithItems.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0006H\u0016R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u001c\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/yandex/div/core/view2/items/DivViewWithItems$Tabs;", "Lcom/yandex/div/core/view2/items/DivViewWithItems;", "view", "Lcom/yandex/div/core/view2/divs/widgets/DivTabsLayout;", "(Lcom/yandex/div/core/view2/divs/widgets/DivTabsLayout;)V", "value", "", "currentItem", "getCurrentItem", "()I", "setCurrentItem", "(I)V", "itemCount", "getItemCount", "metrics", "Landroid/util/DisplayMetrics;", "kotlin.jvm.PlatformType", "getMetrics", "()Landroid/util/DisplayMetrics;", "scrollToTheEnd", "", "animated", "", "setCurrentItemNoAnimation", "index", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Tabs extends DivViewWithItems {
        private final DisplayMetrics metrics;
        private final DivTabsLayout view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Tabs(DivTabsLayout view) {
            super(null);
            Intrinsics.checkNotNullParameter(view, "view");
            this.view = view;
            this.metrics = view.getResources().getDisplayMetrics();
        }

        @Override // com.yandex.div.core.view2.items.DivViewWithItems
        public DisplayMetrics getMetrics() {
            return this.metrics;
        }

        @Override // com.yandex.div.core.view2.items.DivViewWithItems
        public int getCurrentItem() {
            return this.view.getViewPager().getCurrentItem();
        }

        @Override // com.yandex.div.core.view2.items.DivViewWithItems
        public void setCurrentItem(int i) {
            int itemCount = getItemCount();
            if (i >= 0 && i < itemCount) {
                this.view.getViewPager().setCurrentItem(i, true);
                return;
            }
            KAssert kAssert = KAssert.INSTANCE;
            if (Assert.isEnabled()) {
                Assert.fail(i + " is not in range [0, " + itemCount + ')');
            }
        }

        @Override // com.yandex.div.core.view2.items.DivViewWithItems
        public int getItemCount() {
            PagerAdapter adapter = this.view.getViewPager().getAdapter();
            if (adapter != null) {
                return adapter.getCount();
            }
            return 0;
        }

        @Override // com.yandex.div.core.view2.items.DivViewWithItems
        public void scrollToTheEnd(boolean animated) {
            this.view.getViewPager().setCurrentItem(getItemCount() - 1, animated);
        }

        @Override // com.yandex.div.core.view2.items.DivViewWithItems
        public void setCurrentItemNoAnimation(int index) {
            int itemCount = getItemCount();
            if (index >= 0 && index < itemCount) {
                this.view.getViewPager().setCurrentItem(index, false);
                return;
            }
            KAssert kAssert = KAssert.INSTANCE;
            if (Assert.isEnabled()) {
                Assert.fail(index + " is not in range [0, " + itemCount + ')');
            }
        }
    }

    /* JADX INFO: compiled from: DivViewWithItems.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0080\bø\u0001\u0000¢\u0006\u0002\b\u0012R(\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@AX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, d2 = {"Lcom/yandex/div/core/view2/items/DivViewWithItems$Companion;", "", "()V", "<set-?>", "Lcom/yandex/div/core/view2/items/DivViewWithItems;", "viewForTests", "getViewForTests$div_release", "()Lcom/yandex/div/core/view2/items/DivViewWithItems;", "setViewForTests$div_release", "(Lcom/yandex/div/core/view2/items/DivViewWithItems;)V", "create", "view", "Landroid/view/View;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "direction", "Lkotlin/Function0;", "Lcom/yandex/div/core/view2/items/Direction;", "create$div_release", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: DivViewWithItems.kt */
        @Metadata(k = 3, mv = {1, 5, 1}, xi = 176)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[DivGallery.ScrollMode.values().length];
                try {
                    iArr[DivGallery.ScrollMode.DEFAULT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[DivGallery.ScrollMode.PAGING.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DivViewWithItems getViewForTests$div_release() {
            return DivViewWithItems.viewForTests;
        }

        public final void setViewForTests$div_release(DivViewWithItems divViewWithItems) {
            DivViewWithItems.viewForTests = divViewWithItems;
        }

        public final DivViewWithItems create$div_release(View view, ExpressionResolver resolver, Function0<? extends Direction> direction) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(resolver, "resolver");
            Intrinsics.checkNotNullParameter(direction, "direction");
            DivViewWithItems viewForTests$div_release = getViewForTests$div_release();
            if (viewForTests$div_release != null) {
                return viewForTests$div_release;
            }
            if (view instanceof DivRecyclerView) {
                DivRecyclerView divRecyclerView = (DivRecyclerView) view;
                DivGallery div = divRecyclerView.getDiv();
                Intrinsics.checkNotNull(div);
                int i = WhenMappings.$EnumSwitchMapping$0[div.scrollMode.evaluate(resolver).ordinal()];
                if (i == 1) {
                    return new Gallery(divRecyclerView, direction.invoke());
                }
                if (i == 2) {
                    return new PagingGallery(divRecyclerView, direction.invoke());
                }
                throw new NoWhenBranchMatchedException();
            }
            if (view instanceof DivPagerView) {
                return new Pager((DivPagerView) view);
            }
            if (view instanceof DivTabsLayout) {
                return new Tabs((DivTabsLayout) view);
            }
            return null;
        }
    }
}
