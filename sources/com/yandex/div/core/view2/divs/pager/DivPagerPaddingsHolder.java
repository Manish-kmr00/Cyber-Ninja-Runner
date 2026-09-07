package com.yandex.div.core.view2.divs.pager;

import android.util.DisplayMetrics;
import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.yandex.div.core.util.ViewsKt;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivEdgeInsets;
import com.yandex.div2.DivPager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: DivPagerPaddingsHolder.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\b\u0000\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0014\u0010)\u001a\u00020\u001b*\n\u0012\u0004\u0012\u00020+\u0018\u00010*H\u0002R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0012R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0017\u0010\u0012R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u000e\u0010 \u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010#\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0011\u0010%\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0011\u0010'\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001d¨\u0006,"}, d2 = {"Lcom/yandex/div/core/view2/divs/pager/DivPagerPaddingsHolder;", "", "paddings", "Lcom/yandex/div2/DivEdgeInsets;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "parent", "Landroid/view/View;", "metrics", "Landroid/util/DisplayMetrics;", "isHorizontal", "", "alignment", "Lcom/yandex/div2/DivPager$ItemAlignment;", "(Lcom/yandex/div2/DivEdgeInsets;Lcom/yandex/div/json/expressions/ExpressionResolver;Landroid/view/View;Landroid/util/DisplayMetrics;ZLcom/yandex/div2/DivPager$ItemAlignment;)V", "alignedBottom", "", "getAlignedBottom", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "alignedLeft", "getAlignedLeft", "alignedRight", "getAlignedRight", "alignedTop", "getAlignedTop", "bottom", "", "getBottom", "()F", "end", "getEnd", "hasRelativePaddings", "left", "getLeft", "right", "getRight", "start", "getStart", ViewHierarchyConstants.DIMENSION_TOP_KEY, "getTop", "toPadding", "Lcom/yandex/div/json/expressions/Expression;", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivPagerPaddingsHolder {
    private final Integer alignedBottom;
    private final Integer alignedLeft;
    private final Integer alignedRight;
    private final Integer alignedTop;
    private final float bottom;
    private final float end;
    private final boolean hasRelativePaddings;
    private final float left;
    private final DisplayMetrics metrics;
    private final ExpressionResolver resolver;
    private final float right;
    private final float start;
    private final float top;

    /* JADX WARN: Code duplicated, block: B:13:0x002f  */
    /* JADX WARN: Code duplicated, block: B:18:0x0039  */
    /* JADX WARN: Code duplicated, block: B:33:0x0063  */
    public DivPagerPaddingsHolder(DivEdgeInsets divEdgeInsets, ExpressionResolver resolver, View parent, DisplayMetrics metrics, boolean z, DivPager.ItemAlignment alignment) {
        boolean z2;
        Expression<Long> expression;
        Expression<Long> expression2;
        float f;
        float f2;
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        this.resolver = resolver;
        this.metrics = metrics;
        if ((divEdgeInsets != null ? divEdgeInsets.start : null) != null) {
            z2 = true;
        } else {
            if ((divEdgeInsets != null ? divEdgeInsets.end : null) != null) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        this.hasRelativePaddings = z2;
        if (z2) {
            if (ViewsKt.isLayoutRtl(parent)) {
                if (divEdgeInsets != null) {
                    expression = divEdgeInsets.end;
                } else {
                    expression = null;
                }
            } else if (divEdgeInsets != null) {
                expression = divEdgeInsets.start;
            } else {
                expression = null;
            }
        } else if (divEdgeInsets != null) {
            expression = divEdgeInsets.left;
        } else {
            expression = null;
        }
        float padding = toPadding(expression);
        this.left = padding;
        float padding2 = toPadding(divEdgeInsets != null ? divEdgeInsets.top : null);
        this.top = padding2;
        if (z2) {
            if (ViewsKt.isLayoutRtl(parent)) {
                if (divEdgeInsets != null) {
                    expression2 = divEdgeInsets.start;
                } else {
                    expression2 = null;
                }
            } else if (divEdgeInsets != null) {
                expression2 = divEdgeInsets.end;
            } else {
                expression2 = null;
            }
        } else if (divEdgeInsets != null) {
            expression2 = divEdgeInsets.right;
        } else {
            expression2 = null;
        }
        float padding3 = toPadding(expression2);
        this.right = padding3;
        float padding4 = toPadding(divEdgeInsets != null ? divEdgeInsets.bottom : null);
        this.bottom = padding4;
        if (z) {
            f = ViewsKt.isLayoutRtl(parent) ? padding3 : padding;
        } else {
            f = padding2;
        }
        this.start = f;
        if (z) {
            f2 = ViewsKt.isLayoutRtl(parent) ? padding : padding3;
        } else {
            f2 = padding4;
        }
        this.end = f2;
        this.alignedLeft = (!z || (alignment == DivPager.ItemAlignment.START && !ViewsKt.isLayoutRtl(parent)) || (alignment == DivPager.ItemAlignment.END && ViewsKt.isLayoutRtl(parent))) ? Integer.valueOf(MathKt.roundToInt(padding)) : null;
        this.alignedTop = (z || alignment == DivPager.ItemAlignment.START) ? Integer.valueOf(MathKt.roundToInt(padding2)) : null;
        this.alignedRight = (!z || (alignment == DivPager.ItemAlignment.START && ViewsKt.isLayoutRtl(parent)) || (alignment == DivPager.ItemAlignment.END && !ViewsKt.isLayoutRtl(parent))) ? Integer.valueOf(MathKt.roundToInt(padding3)) : null;
        this.alignedBottom = (z || alignment == DivPager.ItemAlignment.END) ? Integer.valueOf(MathKt.roundToInt(padding4)) : null;
    }

    public final float getLeft() {
        return this.left;
    }

    public final float getTop() {
        return this.top;
    }

    public final float getRight() {
        return this.right;
    }

    public final float getBottom() {
        return this.bottom;
    }

    private final float toPadding(Expression<Long> expression) {
        if (expression != null) {
            return BaseDivViewExtensionsKt.dpToPxF(Long.valueOf(expression.evaluate(this.resolver).longValue()), this.metrics);
        }
        return 0.0f;
    }

    public final float getStart() {
        return this.start;
    }

    public final float getEnd() {
        return this.end;
    }

    public final Integer getAlignedLeft() {
        return this.alignedLeft;
    }

    public final Integer getAlignedTop() {
        return this.alignedTop;
    }

    public final Integer getAlignedRight() {
        return this.alignedRight;
    }

    public final Integer getAlignedBottom() {
        return this.alignedBottom;
    }
}
