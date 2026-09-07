package com.yandex.div.core.tooltip;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.state.DivStatePath;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.Div2Builder;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.Div;
import com.yandex.div2.DivBase;
import com.yandex.div2.DivSize;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivTooltipViewBuilder.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0011\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J,\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0012R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/yandex/div/core/tooltip/DivTooltipViewBuilder;", "", "div2Builder", "Ljavax/inject/Provider;", "Lcom/yandex/div/core/view2/Div2Builder;", "(Ljavax/inject/Provider;)V", "buildTooltipView", "Lcom/yandex/div/core/tooltip/DivTooltipContainer;", "context", "Lcom/yandex/div/core/view2/BindingContext;", "div", "Lcom/yandex/div2/Div;", "width", "", "height", "prepareTooltipView", "Landroid/view/View;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public class DivTooltipViewBuilder {
    private final Provider<Div2Builder> div2Builder;

    @Inject
    public DivTooltipViewBuilder(Provider<Div2Builder> div2Builder) {
        Intrinsics.checkNotNullParameter(div2Builder, "div2Builder");
        this.div2Builder = div2Builder;
    }

    public static /* synthetic */ DivTooltipContainer buildTooltipView$default(DivTooltipViewBuilder divTooltipViewBuilder, BindingContext bindingContext, Div div, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildTooltipView");
        }
        if ((i3 & 4) != 0) {
            i = -2;
        }
        if ((i3 & 8) != 0) {
            i2 = -2;
        }
        return divTooltipViewBuilder.buildTooltipView(bindingContext, div, i, i2);
    }

    public DivTooltipContainer buildTooltipView(BindingContext context, Div div, int width, int height) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(div, "div");
        View viewPrepareTooltipView = prepareTooltipView(context, div);
        Context context2 = context.getDivView().getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context.divView.getContext()");
        DivTooltipContainer divTooltipContainer = new DivTooltipContainer(context2, null, 0, 6, null);
        divTooltipContainer.addView(viewPrepareTooltipView);
        divTooltipContainer.setLayoutParams(new ViewGroup.LayoutParams(width, height));
        return divTooltipContainer;
    }

    private View prepareTooltipView(BindingContext context, Div div) {
        DivBase divBaseValue = div.value();
        View viewBuildView = this.div2Builder.get().buildView(div, context, DivStatePath.INSTANCE.fromState(0L));
        ExpressionResolver expressionResolver = context.getExpressionResolver();
        DisplayMetrics displayMetrics = viewBuildView.getContext().getResources().getDisplayMetrics();
        DivSize width = divBaseValue.getWidth();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "displayMetrics");
        viewBuildView.setLayoutParams(new RelativeLayout.LayoutParams(BaseDivViewExtensionsKt.toLayoutParamsSize$default(width, displayMetrics, expressionResolver, null, 4, null), BaseDivViewExtensionsKt.toLayoutParamsSize$default(divBaseValue.getHeight(), displayMetrics, expressionResolver, null, 4, null)));
        viewBuildView.setFocusable(true);
        return viewBuildView;
    }
}
