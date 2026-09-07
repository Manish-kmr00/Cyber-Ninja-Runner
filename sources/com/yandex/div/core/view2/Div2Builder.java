package com.yandex.div.core.view2;

import android.view.View;
import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.expression.ExpressionFallbacksHelperKt;
import com.yandex.div.core.expression.local.DivRuntimeVisitor;
import com.yandex.div.core.state.DivStatePath;
import com.yandex.div.internal.widget.DivLayoutParams;
import com.yandex.div.json.ParsingException;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.Div;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Div2Builder.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0011\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J \u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/yandex/div/core/view2/Div2Builder;", "", "viewCreator", "Lcom/yandex/div/core/view2/DivViewCreator;", "viewBinder", "Lcom/yandex/div/core/view2/DivBinder;", "runtimeVisitor", "Lcom/yandex/div/core/expression/local/DivRuntimeVisitor;", "(Lcom/yandex/div/core/view2/DivViewCreator;Lcom/yandex/div/core/view2/DivBinder;Lcom/yandex/div/core/expression/local/DivRuntimeVisitor;)V", "buildView", "Landroid/view/View;", "data", "Lcom/yandex/div2/Div;", "context", "Lcom/yandex/div/core/view2/BindingContext;", "path", "Lcom/yandex/div/core/state/DivStatePath;", "createView", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public class Div2Builder {
    private final DivRuntimeVisitor runtimeVisitor;
    private final DivBinder viewBinder;
    private final DivViewCreator viewCreator;

    @Inject
    public Div2Builder(DivViewCreator viewCreator, DivBinder viewBinder, DivRuntimeVisitor runtimeVisitor) {
        Intrinsics.checkNotNullParameter(viewCreator, "viewCreator");
        Intrinsics.checkNotNullParameter(viewBinder, "viewBinder");
        Intrinsics.checkNotNullParameter(runtimeVisitor, "runtimeVisitor");
        this.viewCreator = viewCreator;
        this.viewBinder = viewBinder;
        this.runtimeVisitor = runtimeVisitor;
    }

    public View buildView(Div data, BindingContext context, DivStatePath path) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        View viewCreateView = createView(data, context, path);
        try {
            this.viewBinder.bind(context, viewCreateView, data, path);
        } catch (ParsingException e) {
            if (!ExpressionFallbacksHelperKt.isExpressionResolveFail(e)) {
                throw e;
            }
        }
        return viewCreateView;
    }

    public View createView(Div data, BindingContext context, DivStatePath path) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        ExpressionResolver expressionResolver = context.getExpressionResolver();
        this.runtimeVisitor.createAndAttachRuntimes(data, path, context.getDivView());
        View viewCreate = this.viewCreator.create(data, expressionResolver);
        viewCreate.setLayoutParams(new DivLayoutParams(-1, -2));
        return viewCreate;
    }
}
