package com.yandex.div.internal.widget.indicator.animations;

import android.graphics.RectF;
import com.json.b9;
import com.yandex.div.internal.widget.indicator.IndicatorParams;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: WormIndicatorAnimator.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J(\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\nH\u0016J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\f\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/yandex/div/internal/widget/indicator/animations/WormIndicatorAnimator;", "Lcom/yandex/div/internal/widget/indicator/animations/IndicatorAnimator;", "styleParams", "Lcom/yandex/div/internal/widget/indicator/IndicatorParams$Style;", "(Lcom/yandex/div/internal/widget/indicator/IndicatorParams$Style;)V", "inactiveItemSizeWithBorders", "Lcom/yandex/div/internal/widget/indicator/IndicatorParams$ItemSize;", "itemRect", "Landroid/graphics/RectF;", "itemWidthOverride", "", "selectedPositionOffset", "spaceBetweenCenters", "getBorderColorAt", "", b9.h.L, "getBorderWidthAt", "getColorAt", "getItemSizeAt", "getSelectedItemRect", "xOffset", "yOffset", "viewportWidth", "isLayoutRtl", "", "onPageScrolled", "", "positionOffset", "overrideItemWidth", "width", "updateSpaceBetweenCenters", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class WormIndicatorAnimator implements IndicatorAnimator {
    private final IndicatorParams.ItemSize inactiveItemSizeWithBorders;
    private final RectF itemRect;
    private float itemWidthOverride;
    private float selectedPositionOffset;
    private float spaceBetweenCenters;
    private final IndicatorParams.Style styleParams;

    public WormIndicatorAnimator(IndicatorParams.Style styleParams) {
        IndicatorParams.ItemSize.RoundedRect roundedRectCopy$default;
        Intrinsics.checkNotNullParameter(styleParams, "styleParams");
        this.styleParams = styleParams;
        this.itemRect = new RectF();
        IndicatorParams.Shape inactiveShape = styleParams.getInactiveShape();
        if (inactiveShape instanceof IndicatorParams.Shape.Circle) {
            roundedRectCopy$default = ((IndicatorParams.Shape.Circle) inactiveShape).getItemSize();
        } else if (inactiveShape instanceof IndicatorParams.Shape.RoundedRect) {
            IndicatorParams.Shape.RoundedRect roundedRect = (IndicatorParams.Shape.RoundedRect) inactiveShape;
            roundedRectCopy$default = IndicatorParams.ItemSize.RoundedRect.copy$default(roundedRect.getItemSize(), roundedRect.getItemSize().getItemWidth() + roundedRect.getStrokeWidth(), roundedRect.getItemSize().getItemHeight() + roundedRect.getStrokeWidth(), 0.0f, 4, null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.inactiveItemSizeWithBorders = roundedRectCopy$default;
    }

    @Override // com.yandex.div.internal.widget.indicator.animations.IndicatorAnimator
    public int getColorAt(int position) {
        return this.styleParams.getInactiveShape().getColor();
    }

    @Override // com.yandex.div.internal.widget.indicator.animations.IndicatorAnimator
    public void onPageScrolled(int position, float positionOffset) {
        this.selectedPositionOffset = positionOffset;
    }

    @Override // com.yandex.div.internal.widget.indicator.animations.IndicatorAnimator
    public void updateSpaceBetweenCenters(float spaceBetweenCenters) {
        this.spaceBetweenCenters = spaceBetweenCenters;
    }

    @Override // com.yandex.div.internal.widget.indicator.animations.IndicatorAnimator
    public void overrideItemWidth(float width) {
        this.itemWidthOverride = width;
    }

    @Override // com.yandex.div.internal.widget.indicator.animations.IndicatorAnimator
    public RectF getSelectedItemRect(float xOffset, float yOffset, float viewportWidth, boolean isLayoutRtl) {
        float width = this.itemWidthOverride;
        if (width == 0.0f) {
            width = this.styleParams.getActiveShape().getItemSize().getWidth();
        }
        this.itemRect.top = yOffset - (this.styleParams.getActiveShape().getItemSize().getHeight() / 2.0f);
        if (isLayoutRtl) {
            float f = width / 2.0f;
            this.itemRect.right = (xOffset - RangesKt.coerceAtLeast((this.spaceBetweenCenters * (this.selectedPositionOffset - 0.5f)) * 2.0f, 0.0f)) + f;
            RectF rectF = this.itemRect;
            float f2 = this.spaceBetweenCenters;
            rectF.left = (xOffset - RangesKt.coerceAtMost((this.selectedPositionOffset * f2) * 2.0f, f2)) - f;
        } else {
            RectF rectF2 = this.itemRect;
            float f3 = this.spaceBetweenCenters;
            float f4 = width / 2.0f;
            rectF2.right = RangesKt.coerceAtMost(this.selectedPositionOffset * f3 * 2.0f, f3) + xOffset + f4;
            this.itemRect.left = (xOffset + RangesKt.coerceAtLeast((this.spaceBetweenCenters * (this.selectedPositionOffset - 0.5f)) * 2.0f, 0.0f)) - f4;
        }
        this.itemRect.bottom = yOffset + (this.styleParams.getActiveShape().getItemSize().getHeight() / 2.0f);
        if (this.itemRect.left < 0.0f) {
            RectF rectF3 = this.itemRect;
            rectF3.offset(-rectF3.left, 0.0f);
        }
        if (this.itemRect.right > viewportWidth) {
            RectF rectF4 = this.itemRect;
            rectF4.offset(-(rectF4.right - viewportWidth), 0.0f);
        }
        return this.itemRect;
    }

    @Override // com.yandex.div.internal.widget.indicator.animations.IndicatorAnimator
    public IndicatorParams.ItemSize getItemSizeAt(int position) {
        return this.inactiveItemSizeWithBorders;
    }

    @Override // com.yandex.div.internal.widget.indicator.animations.IndicatorAnimator
    public int getBorderColorAt(int position) {
        return this.styleParams.getInactiveShape().getBorderColor();
    }

    @Override // com.yandex.div.internal.widget.indicator.animations.IndicatorAnimator
    public float getBorderWidthAt(int position) {
        return this.styleParams.getInactiveShape().getBorderWidth();
    }
}
