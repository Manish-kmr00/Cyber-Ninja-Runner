package com.yandex.div.internal.widget.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.yandex.div.core.view2.divs.pager.DivPagerAdapter;
import com.yandex.div.core.view2.divs.widgets.DivPagerView;
import com.yandex.div.internal.widget.indicator.animations.IndicatorAnimatorKt;
import com.yandex.div.internal.widget.indicator.forms.SingleIndicatorDrawerKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PagerIndicatorView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nJ\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007H\u0014J\u000e\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010J\f\u0010\u001b\u001a\u00020\u0012*\u00020\u000eH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/yandex/div/internal/widget/indicator/PagerIndicatorView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "divPager", "Lcom/yandex/div/core/view2/divs/widgets/DivPagerView;", "onPageChangeListener", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "stripDrawer", "Lcom/yandex/div/internal/widget/indicator/IndicatorsStripDrawer;", "style", "Lcom/yandex/div/internal/widget/indicator/IndicatorParams$Style;", "attachPager", "", "newDivPager", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setStyle", "update", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class PagerIndicatorView extends View {
    private DivPagerView divPager;
    private final ViewPager2.OnPageChangeCallback onPageChangeListener;
    private IndicatorsStripDrawer stripDrawer;
    private IndicatorParams.Style style;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PagerIndicatorView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PagerIndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PagerIndicatorView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerIndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.onPageChangeListener = new ViewPager2.OnPageChangeCallback() { // from class: com.yandex.div.internal.widget.indicator.PagerIndicatorView$onPageChangeListener$1
            /* JADX WARN: Code duplicated, block: B:6:0x000f A[PHI: r1
  0x000f: PHI (r1v2 float) = (r1v0 float), (r1v1 float) binds: [B:5:0x000d, B:8:0x0015] A[DONT_GENERATE, DONT_INLINE]] */
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                IndicatorsStripDrawer indicatorsStripDrawer = this.this$0.stripDrawer;
                if (indicatorsStripDrawer != null) {
                    PagerIndicatorView pagerIndicatorView = this.this$0;
                    float f = 0.0f;
                    if (positionOffset < 0.0f) {
                        positionOffset = f;
                    } else {
                        f = 1.0f;
                        if (positionOffset > 1.0f) {
                            positionOffset = f;
                        }
                    }
                    indicatorsStripDrawer.onPageScrolled(toRealPosition(position), positionOffset);
                    pagerIndicatorView.invalidate();
                }
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int position) {
                IndicatorsStripDrawer indicatorsStripDrawer = this.this$0.stripDrawer;
                if (indicatorsStripDrawer != null) {
                    PagerIndicatorView pagerIndicatorView = this.this$0;
                    indicatorsStripDrawer.onPageSelected(toRealPosition(position));
                    pagerIndicatorView.invalidate();
                }
            }

            private final int toRealPosition(int i2) {
                ViewPager2 viewPager;
                DivPagerView divPagerView = this.this$0.divPager;
                RecyclerView.Adapter adapter = (divPagerView == null || (viewPager = divPagerView.getViewPager()) == null) ? null : viewPager.getAdapter();
                DivPagerAdapter divPagerAdapter = adapter instanceof DivPagerAdapter ? (DivPagerAdapter) adapter : null;
                if (divPagerAdapter == null) {
                    return i2;
                }
                int size = divPagerAdapter.getVisibleItems().size();
                return (divPagerAdapter.getRealPosition(i2) + size) % size;
            }
        };
    }

    public final void setStyle(IndicatorParams.Style style) {
        Intrinsics.checkNotNullParameter(style, "style");
        this.style = style;
        IndicatorsStripDrawer indicatorsStripDrawer = new IndicatorsStripDrawer(style, SingleIndicatorDrawerKt.getIndicatorDrawer(style), IndicatorAnimatorKt.getIndicatorAnimator(style), this);
        indicatorsStripDrawer.calculateMaximumVisibleItems((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        update(indicatorsStripDrawer);
        this.stripDrawer = indicatorsStripDrawer;
        requestLayout();
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00a3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:45:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:46:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:49:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:53:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int paddingLeft;
        int paddingRight;
        int i;
        IndicatorsStripDrawer indicatorsStripDrawer;
        ViewPager2 viewPager;
        RecyclerView.Adapter adapter;
        IndicatorParams.Shape activeShape;
        IndicatorParams.ItemSize itemSize;
        IndicatorParams.Shape activeShape2;
        IndicatorParams.ItemSize itemSize2;
        int mode = View.MeasureSpec.getMode(heightMeasureSpec);
        int size = View.MeasureSpec.getSize(heightMeasureSpec);
        IndicatorParams.Style style = this.style;
        float width = 0.0f;
        int height = (int) (((style == null || (activeShape2 = style.getActiveShape()) == null || (itemSize2 = activeShape2.getItemSize()) == null) ? 0.0f : itemSize2.getHeight()) + getPaddingTop() + getPaddingBottom());
        if (mode == Integer.MIN_VALUE) {
            size = Math.min(height, size);
        } else if (mode != 1073741824) {
            size = height;
        }
        int mode2 = View.MeasureSpec.getMode(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(widthMeasureSpec);
        IndicatorParams.Style style2 = this.style;
        if (style2 != null && (activeShape = style2.getActiveShape()) != null && (itemSize = activeShape.getItemSize()) != null) {
            width = itemSize.getWidth();
        }
        IndicatorParams.Style style3 = this.style;
        IndicatorParams.ItemPlacement itemsPlacement = style3 != null ? style3.getItemsPlacement() : null;
        if (itemsPlacement instanceof IndicatorParams.ItemPlacement.Default) {
            float spaceBetweenCenters = ((IndicatorParams.ItemPlacement.Default) itemsPlacement).getSpaceBetweenCenters();
            DivPagerView divPagerView = this.divPager;
            paddingLeft = ((int) ((spaceBetweenCenters * ((divPagerView == null || (viewPager = divPagerView.getViewPager()) == null || (adapter = viewPager.getAdapter()) == null) ? 0 : adapter.getItemCount())) + width)) + getPaddingLeft();
            paddingRight = getPaddingRight();
        } else {
            if (itemsPlacement instanceof IndicatorParams.ItemPlacement.Stretch) {
                i = size2;
            } else if (itemsPlacement == null) {
                paddingLeft = ((int) width) + getPaddingLeft();
                paddingRight = getPaddingRight();
            } else {
                throw new NoWhenBranchMatchedException();
            }
            if (mode2 != Integer.MIN_VALUE) {
                size2 = Math.min(i, size2);
            } else if (mode2 != 1073741824) {
                size2 = i;
            }
            setMeasuredDimension(size2, size);
            indicatorsStripDrawer = this.stripDrawer;
            if (indicatorsStripDrawer != null) {
                indicatorsStripDrawer.calculateMaximumVisibleItems((size2 - getPaddingLeft()) - getPaddingRight(), (size - getPaddingTop()) - getPaddingBottom());
            }
        }
        i = paddingLeft + paddingRight;
        if (mode2 != Integer.MIN_VALUE) {
            size2 = Math.min(i, size2);
        } else if (mode2 != 1073741824) {
            size2 = i;
        }
        setMeasuredDimension(size2, size);
        indicatorsStripDrawer = this.stripDrawer;
        if (indicatorsStripDrawer != null) {
            indicatorsStripDrawer.calculateMaximumVisibleItems((size2 - getPaddingLeft()) - getPaddingRight(), (size - getPaddingTop()) - getPaddingBottom());
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        canvas.translate(getPaddingLeft(), getPaddingTop());
        IndicatorsStripDrawer indicatorsStripDrawer = this.stripDrawer;
        if (indicatorsStripDrawer != null) {
            indicatorsStripDrawer.onDraw(canvas);
        }
    }

    public final void attachPager(DivPagerView newDivPager) {
        Intrinsics.checkNotNullParameter(newDivPager, "newDivPager");
        DivPagerView divPagerView = this.divPager;
        if (divPagerView != null) {
            divPagerView.removeChangePageCallbackForIndicators(this.onPageChangeListener);
        }
        newDivPager.addChangePageCallbackForIndicators(this.onPageChangeListener);
        if (newDivPager == this.divPager) {
            return;
        }
        this.divPager = newDivPager;
        if (newDivPager.getViewPager().getAdapter() == null) {
            throw new IllegalArgumentException("Attached pager adapter is null!".toString());
        }
        IndicatorsStripDrawer indicatorsStripDrawer = this.stripDrawer;
        if (indicatorsStripDrawer != null) {
            update(indicatorsStripDrawer);
        }
        newDivPager.setPagerOnItemsCountChange$div_release(new DivPagerView.OnItemsUpdatedCallback() { // from class: com.yandex.div.internal.widget.indicator.PagerIndicatorView$$ExternalSyntheticLambda0
            @Override // com.yandex.div.core.view2.divs.widgets.DivPagerView.OnItemsUpdatedCallback
            public final void onItemsUpdated() {
                PagerIndicatorView.attachPager$lambda$3(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void attachPager$lambda$3(PagerIndicatorView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IndicatorsStripDrawer indicatorsStripDrawer = this$0.stripDrawer;
        if (indicatorsStripDrawer != null) {
            this$0.update(indicatorsStripDrawer);
        }
    }

    private final void update(IndicatorsStripDrawer indicatorsStripDrawer) {
        ViewPager2 viewPager;
        DivPagerView divPagerView = this.divPager;
        RecyclerView.Adapter adapter = (divPagerView == null || (viewPager = divPagerView.getViewPager()) == null) ? null : viewPager.getAdapter();
        DivPagerAdapter divPagerAdapter = adapter instanceof DivPagerAdapter ? (DivPagerAdapter) adapter : null;
        if (divPagerAdapter != null) {
            indicatorsStripDrawer.setItemsCount(divPagerAdapter.getVisibleItems().size());
            indicatorsStripDrawer.onPageSelected(divPagerAdapter.getCurrentRealItem());
            invalidate();
        }
    }
}
