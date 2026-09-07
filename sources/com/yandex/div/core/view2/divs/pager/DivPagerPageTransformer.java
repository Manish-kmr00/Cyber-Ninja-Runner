package com.yandex.div.core.view2.divs.pager;

import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.json.b9;
import com.yandex.div.core.util.DivUtilKt;
import com.yandex.div.core.util.ViewsKt;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivAnimationInterpolator;
import com.yandex.div2.DivPageTransformation;
import com.yandex.div2.DivPageTransformationOverlap;
import com.yandex.div2.DivPageTransformationSlide;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: DivPagerPageTransformer.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\bH\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\bH\u0016J\u001c\u0010\u001c\u001a\u00020\u0018*\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\bH\u0002J\u001c\u0010\u001c\u001a\u00020\u0018*\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\bH\u0002JZ\u0010\u001f\u001a\u00020\u0018*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00130!2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00130!2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00130!2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00130!H\u0002J\u001c\u0010'\u001a\u00020\u0018*\u00020\u001a2\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\bH\u0002J\u001e\u0010*\u001a\u00020\u0018*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010+\u001a\u00020\u0010H\u0002J\u001c\u0010,\u001a\u00020\u0018*\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u0013H\u0002J\u001c\u0010.\u001a\u00020\u0018*\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u0013H\u0002R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/yandex/div/core/view2/divs/pager/DivPagerPageTransformer;", "Landroidx/viewpager2/widget/ViewPager2$PageTransformer;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "pageTranslations", "Landroid/util/SparseArray;", "", "parentSize", "", "pageTransformation", "Lcom/yandex/div2/DivPageTransformation;", "offsetProvider", "Lcom/yandex/div/core/view2/divs/pager/DivPagerPageOffsetProvider;", "isHorizontal", "", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/yandex/div/json/expressions/ExpressionResolver;Landroid/util/SparseArray;ILcom/yandex/div2/DivPageTransformation;Lcom/yandex/div/core/view2/divs/pager/DivPagerPageOffsetProvider;Z)V", "getInterpolation", "", "value1", "value2", "interpolatedValue", "transformPage", "", "page", "Landroid/view/View;", b9.h.L, "apply", "Lcom/yandex/div2/DivPageTransformationOverlap;", "Lcom/yandex/div2/DivPageTransformationSlide;", "applyAlphaAndScale", "interpolator", "Lcom/yandex/div/json/expressions/Expression;", "Lcom/yandex/div2/DivAnimationInterpolator;", "nextPageAlpha", "nextPageScale", "previousPageAlpha", "previousPageScale", "applyEvaluatedOffset", "pagePosition", "offset", "applyOffset", "overlap", "applyPageAlpha", "cornerAlpha", "applyPageScale", "cornerScale", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivPagerPageTransformer implements ViewPager2.PageTransformer {
    private final boolean isHorizontal;
    private final DivPagerPageOffsetProvider offsetProvider;
    private final DivPageTransformation pageTransformation;
    private final SparseArray<Float> pageTranslations;
    private final int parentSize;
    private final RecyclerView recyclerView;
    private final ExpressionResolver resolver;

    public DivPagerPageTransformer(RecyclerView recyclerView, ExpressionResolver resolver, SparseArray<Float> pageTranslations, int i, DivPageTransformation divPageTransformation, DivPagerPageOffsetProvider offsetProvider, boolean z) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(pageTranslations, "pageTranslations");
        Intrinsics.checkNotNullParameter(offsetProvider, "offsetProvider");
        this.recyclerView = recyclerView;
        this.resolver = resolver;
        this.pageTranslations = pageTranslations;
        this.parentSize = i;
        this.pageTransformation = divPageTransformation;
        this.offsetProvider = offsetProvider;
        this.isHorizontal = z;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(View page, float position) {
        Intrinsics.checkNotNullParameter(page, "page");
        DivPageTransformation divPageTransformation = this.pageTransformation;
        Object objValue = divPageTransformation != null ? divPageTransformation.value() : null;
        if (objValue instanceof DivPageTransformationSlide) {
            apply((DivPageTransformationSlide) objValue, page, position);
        } else if (objValue instanceof DivPageTransformationOverlap) {
            apply((DivPageTransformationOverlap) objValue, page, position);
        } else {
            applyOffset$default(this, page, position, false, 2, null);
        }
    }

    private final void apply(DivPageTransformationSlide divPageTransformationSlide, View view, float f) {
        applyAlphaAndScale(view, f, divPageTransformationSlide.interpolator, divPageTransformationSlide.nextPageAlpha, divPageTransformationSlide.nextPageScale, divPageTransformationSlide.previousPageAlpha, divPageTransformationSlide.previousPageScale);
        applyOffset$default(this, view, f, false, 2, null);
    }

    private final void apply(DivPageTransformationOverlap divPageTransformationOverlap, View view, float f) {
        applyAlphaAndScale(view, f, divPageTransformationOverlap.interpolator, divPageTransformationOverlap.nextPageAlpha, divPageTransformationOverlap.nextPageScale, divPageTransformationOverlap.previousPageAlpha, divPageTransformationOverlap.previousPageScale);
        if (f > 0.0f || (f < 0.0f && divPageTransformationOverlap.reversedStackingOrder.evaluate(this.resolver).booleanValue())) {
            applyOffset$default(this, view, f, false, 2, null);
            view.setTranslationZ(0.0f);
        } else {
            applyOffset(view, f, true);
            view.setTranslationZ(-Math.abs(f));
        }
    }

    private final void applyAlphaAndScale(View view, float f, Expression<DivAnimationInterpolator> expression, Expression<Double> expression2, Expression<Double> expression3, Expression<Double> expression4, Expression<Double> expression5) {
        float interpolation = 1 - DivUtilKt.getAndroidInterpolator(expression.evaluate(this.resolver)).getInterpolation(Math.abs(RangesKt.coerceAtMost(RangesKt.coerceAtLeast(f, -1.0f), 1.0f)));
        if (f > 0.0f) {
            applyPageAlpha(view, interpolation, expression2.evaluate(this.resolver).doubleValue());
            applyPageScale(view, interpolation, expression3.evaluate(this.resolver).doubleValue());
        } else {
            applyPageAlpha(view, interpolation, expression4.evaluate(this.resolver).doubleValue());
            applyPageScale(view, interpolation, expression5.evaluate(this.resolver).doubleValue());
        }
    }

    static /* synthetic */ void applyOffset$default(DivPagerPageTransformer divPagerPageTransformer, View view, float f, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        divPagerPageTransformer.applyOffset(view, f, z);
    }

    private final void applyOffset(View view, float f, boolean z) {
        float pageOffset;
        int childAdapterPosition = this.recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition == -1) {
            return;
        }
        if (z) {
            pageOffset = this.parentSize * f;
        } else {
            pageOffset = this.offsetProvider.getPageOffset(f, childAdapterPosition, this.pageTransformation instanceof DivPageTransformation.Overlap);
        }
        float f2 = -pageOffset;
        if (this.isHorizontal && ViewsKt.isLayoutRtl(this.recyclerView)) {
            f2 = -f2;
        }
        applyEvaluatedOffset(view, childAdapterPosition, f2);
    }

    private final void applyEvaluatedOffset(View view, int i, float f) {
        this.pageTranslations.put(i, Float.valueOf(f));
        if (this.isHorizontal) {
            view.setTranslationX(f);
        } else {
            view.setTranslationY(f);
        }
    }

    private final void applyPageAlpha(View view, float f, double d) {
        int childAdapterPosition = this.recyclerView.getChildAdapterPosition(view);
        RecyclerView.Adapter adapter = this.recyclerView.getAdapter();
        DivPagerAdapter divPagerAdapter = adapter instanceof DivPagerAdapter ? (DivPagerAdapter) adapter : null;
        if (divPagerAdapter == null) {
            return;
        }
        view.setAlpha((float) getInterpolation(divPagerAdapter.getItemsToShow().get(childAdapterPosition).getDiv().value().getAlpha().evaluate(this.resolver).doubleValue(), d, f));
    }

    private final void applyPageScale(View view, float f, double d) {
        if (d == 1.0d) {
            return;
        }
        float interpolation = (float) getInterpolation(1.0d, d, f);
        view.setScaleX(interpolation);
        view.setScaleY(interpolation);
    }

    private final double getInterpolation(double value1, double value2, float interpolatedValue) {
        return Math.min(value1, value2) + (Math.abs(value2 - value1) * ((double) interpolatedValue));
    }
}
