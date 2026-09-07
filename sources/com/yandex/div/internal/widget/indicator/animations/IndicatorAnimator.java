package com.yandex.div.internal.widget.indicator.animations;

import android.graphics.RectF;
import com.json.b9;
import com.yandex.div.internal.widget.indicator.IndicatorParams;
import kotlin.Metadata;

/* JADX INFO: compiled from: IndicatorAnimator.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H&J*\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0006H&J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0006H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001bÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/internal/widget/indicator/animations/IndicatorAnimator;", "", "getBorderColorAt", "", b9.h.L, "getBorderWidthAt", "", "getColorAt", "getItemSizeAt", "Lcom/yandex/div/internal/widget/indicator/IndicatorParams$ItemSize;", "getSelectedItemRect", "Landroid/graphics/RectF;", "xOffset", "yOffset", "viewportWidth", "isLayoutRtl", "", "onPageScrolled", "", "positionOffset", "onPageSelected", "overrideItemWidth", "width", "setItemsCount", "count", "updateSpaceBetweenCenters", "spaceBetweenCenters", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface IndicatorAnimator {
    int getBorderColorAt(int position);

    float getBorderWidthAt(int position);

    int getColorAt(int position);

    IndicatorParams.ItemSize getItemSizeAt(int position);

    RectF getSelectedItemRect(float xOffset, float yOffset, float viewportWidth, boolean isLayoutRtl);

    void onPageScrolled(int position, float positionOffset);

    default void onPageSelected(int position) {
    }

    default void overrideItemWidth(float width) {
    }

    default void setItemsCount(int count) {
    }

    default void updateSpaceBetweenCenters(float spaceBetweenCenters) {
    }
}
