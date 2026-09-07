package com.yandex.div.internal.widget.tabs;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import com.json.b9;
import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewPagerFixedSizeLayout.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001%B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007H\u0014J\u0010\u0010 \u001a\u00020\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0016\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/yandex/div/internal/widget/tabs/ViewPagerFixedSizeLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_collapsiblePaddingBottom", "animateOnScroll", "", "getAnimateOnScroll", "()Z", "setAnimateOnScroll", "(Z)V", VastAttributes.PADDING, "collapsiblePaddingBottom", "getCollapsiblePaddingBottom", "()I", "setCollapsiblePaddingBottom", "(I)V", "heightCalculator", "Lcom/yandex/div/internal/widget/tabs/ViewPagerFixedSizeLayout$HeightCalculator;", "lastHeightMeasureSpec", "Ljava/lang/Integer;", "visibleRect", "Landroid/graphics/Rect;", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "setHeightCalculator", "shouldRequestLayoutOnScroll", b9.h.L, "positionOffset", "", "HeightCalculator", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ViewPagerFixedSizeLayout extends FrameLayout {
    private int _collapsiblePaddingBottom;
    private boolean animateOnScroll;
    private HeightCalculator heightCalculator;
    private Integer lastHeightMeasureSpec;
    private Rect visibleRect;

    /* JADX INFO: compiled from: ViewPagerFixedSizeLayout.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0016\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J\u0016\u0010\f\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0001"}, d2 = {"Lcom/yandex/div/internal/widget/tabs/ViewPagerFixedSizeLayout$HeightCalculator;", "", "dropMeasureCache", "", "measureHeight", "", "widthMeasureSpec", "heightMeasureSpec", "restoreInstanceState", "container", "Landroid/util/SparseArray;", "Landroid/os/Parcelable;", "saveInstanceState", "setPositionAndOffsetForMeasure", b9.h.L, "positionOffset", "", "shouldRequestLayoutOnScroll", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface HeightCalculator {
        void dropMeasureCache();

        int measureHeight(int widthMeasureSpec, int heightMeasureSpec);

        void restoreInstanceState(SparseArray<Parcelable> container);

        void saveInstanceState(SparseArray<Parcelable> container);

        void setPositionAndOffsetForMeasure(int position, float positionOffset);

        boolean shouldRequestLayoutOnScroll(int position, float positionOffset);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewPagerFixedSizeLayout(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewPagerFixedSizeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ViewPagerFixedSizeLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewPagerFixedSizeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.animateOnScroll = true;
    }

    public final boolean getAnimateOnScroll() {
        return this.animateOnScroll;
    }

    public final void setAnimateOnScroll(boolean z) {
        this.animateOnScroll = z;
    }

    /* JADX INFO: renamed from: getCollapsiblePaddingBottom, reason: from getter */
    public final int get_collapsiblePaddingBottom() {
        return this._collapsiblePaddingBottom;
    }

    public final void setCollapsiblePaddingBottom(int i) {
        if (this._collapsiblePaddingBottom != i) {
            this._collapsiblePaddingBottom = i;
        }
    }

    public final void setHeightCalculator(HeightCalculator heightCalculator) {
        this.heightCalculator = heightCalculator;
    }

    public final boolean shouldRequestLayoutOnScroll(int position, float positionOffset) {
        HeightCalculator heightCalculator;
        if (!this.animateOnScroll || (heightCalculator = this.heightCalculator) == null || !heightCalculator.shouldRequestLayoutOnScroll(position, positionOffset)) {
            return false;
        }
        Rect rect = this.visibleRect;
        if (rect == null) {
            rect = new Rect();
            this.visibleRect = rect;
        }
        getLocalVisibleRect(rect);
        if (rect.height() == getHeight()) {
            return true;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824);
        Integer num = this.lastHeightMeasureSpec;
        int iMeasureHeight = heightCalculator.measureHeight(iMakeMeasureSpec, num != null ? num.intValue() : View.MeasureSpec.makeMeasureSpec(0, 0));
        if (iMeasureHeight != getHeight()) {
            return iMeasureHeight <= rect.bottom && rect.top <= iMeasureHeight;
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        this.lastHeightMeasureSpec = Integer.valueOf(heightMeasureSpec);
        HeightCalculator heightCalculator = this.heightCalculator;
        if (heightCalculator != null) {
            Intrinsics.checkNotNull(heightCalculator);
            heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(heightCalculator.measureHeight(widthMeasureSpec, heightMeasureSpec), 1073741824);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
