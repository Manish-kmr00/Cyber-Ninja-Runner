package com.yandex.div.core;

import android.view.View;
import com.yandex.div.core.expression.local.RuntimeStore;
import com.yandex.div.core.state.DivStatePath;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.Div;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivCustomContainerChildFactory.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0001¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J*\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007J*\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007¨\u0006\u0013"}, d2 = {"Lcom/yandex/div/core/DivCustomContainerChildFactory;", "", "()V", "bindChildView", "", "childView", "Landroid/view/View;", "childIndex", "", "div", "Lcom/yandex/div2/Div;", "divStatePath", "Lcom/yandex/div/core/state/DivStatePath;", "divView", "Lcom/yandex/div/core/view2/Div2View;", "expressionResolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "createChildView", "createUnboundChildView", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivCustomContainerChildFactory {
    public final View createChildView(Div div, DivStatePath divStatePath, Div2View divView) {
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(divStatePath, "divStatePath");
        Intrinsics.checkNotNullParameter(divView, "divView");
        return createChildView$default(this, div, divStatePath, divView, null, 8, null);
    }

    public final View createUnboundChildView(Div div, DivStatePath divStatePath, Div2View divView) {
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(divStatePath, "divStatePath");
        Intrinsics.checkNotNullParameter(divView, "divView");
        return createUnboundChildView$default(this, div, divStatePath, divView, null, 8, null);
    }

    @Inject
    public DivCustomContainerChildFactory() {
    }

    public static /* synthetic */ View createChildView$default(DivCustomContainerChildFactory divCustomContainerChildFactory, Div div, DivStatePath divStatePath, Div2View div2View, ExpressionResolver expressionResolver, int i, Object obj) {
        if ((i & 8) != 0) {
            expressionResolver = div2View.getExpressionResolver();
        }
        return divCustomContainerChildFactory.createChildView(div, divStatePath, div2View, expressionResolver);
    }

    public final View createChildView(Div div, DivStatePath divStatePath, Div2View divView, ExpressionResolver expressionResolver) {
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(divStatePath, "divStatePath");
        Intrinsics.checkNotNullParameter(divView, "divView");
        Intrinsics.checkNotNullParameter(expressionResolver, "expressionResolver");
        return divView.getDiv2Component().getDiv2Builder().buildView(div, divView.getBindingContext().getFor(expressionResolver), divStatePath);
    }

    public static /* synthetic */ View createUnboundChildView$default(DivCustomContainerChildFactory divCustomContainerChildFactory, Div div, DivStatePath divStatePath, Div2View div2View, ExpressionResolver expressionResolver, int i, Object obj) {
        if ((i & 8) != 0) {
            expressionResolver = div2View.getExpressionResolver();
        }
        return divCustomContainerChildFactory.createUnboundChildView(div, divStatePath, div2View, expressionResolver);
    }

    public final View createUnboundChildView(Div div, DivStatePath divStatePath, Div2View divView, ExpressionResolver expressionResolver) {
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(divStatePath, "divStatePath");
        Intrinsics.checkNotNullParameter(divView, "divView");
        Intrinsics.checkNotNullParameter(expressionResolver, "expressionResolver");
        return divView.getDiv2Component().getDiv2Builder().createView(div, divView.getBindingContext().getFor(expressionResolver), divStatePath);
    }

    public final void bindChildView(View childView, int childIndex, Div div, DivStatePath divStatePath, Div2View divView, ExpressionResolver expressionResolver) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(divStatePath, "divStatePath");
        Intrinsics.checkNotNullParameter(divView, "divView");
        Intrinsics.checkNotNullParameter(expressionResolver, "expressionResolver");
        divView.getDiv2Component().getDivBinder().bind(divView.getBindingContext().getFor(expressionResolver), childView, div, BaseDivViewExtensionsKt.resolvePath(div.value(), childIndex, divStatePath));
        RuntimeStore runtimeStore = divView.getRuntimeStore();
        if (runtimeStore != null) {
            runtimeStore.showWarningIfNeeded$div_release(div.value());
        }
    }
}
