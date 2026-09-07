package com.yandex.div.core.view2.divs;

import com.yandex.div.R;
import com.yandex.div.core.Disposable;
import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.DivViewBinder;
import com.yandex.div.core.view2.divs.widgets.DivSeparatorView;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div.json.expressions.ExpressionsKt;
import com.yandex.div2.DivSeparator;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivSeparatorBinder.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u001e\u0010\r\u001a\u00020\b*\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J(\u0010\u0012\u001a\u00020\b*\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivSeparatorBinder;", "Lcom/yandex/div/core/view2/DivViewBinder;", "Lcom/yandex/div2/DivSeparator;", "Lcom/yandex/div/core/view2/divs/widgets/DivSeparatorView;", "baseBinder", "Lcom/yandex/div/core/view2/divs/DivBaseBinder;", "(Lcom/yandex/div/core/view2/divs/DivBaseBinder;)V", "bindView", "", "context", "Lcom/yandex/div/core/view2/BindingContext;", "view", "div", "applyStyle", "style", "Lcom/yandex/div2/DivSeparator$DelimiterStyle;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "bindStyle", "newStyle", "oldStyle", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public final class DivSeparatorBinder implements DivViewBinder<DivSeparator, DivSeparatorView> {
    private final DivBaseBinder baseBinder;

    @Inject
    public DivSeparatorBinder(DivBaseBinder baseBinder) {
        Intrinsics.checkNotNullParameter(baseBinder, "baseBinder");
        this.baseBinder = baseBinder;
    }

    @Override // com.yandex.div.core.view2.DivViewBinder
    public void bindView(BindingContext context, DivSeparatorView view, DivSeparator div) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(div, "div");
        DivSeparator div2 = view.getDiv();
        if (div == div2) {
            return;
        }
        DivSeparatorView divSeparatorView = view;
        this.baseBinder.bindView(context, divSeparatorView, div, div2);
        BaseDivViewExtensionsKt.applyDivActions(divSeparatorView, context, div.action, div.actions, div.longtapActions, div.doubletapActions, div.hoverStartActions, div.hoverEndActions, div.pressStartActions, div.pressEndActions, div.actionAnimation, div.getAccessibility());
        bindStyle(view, div.delimiterStyle, div2 != null ? div2.delimiterStyle : null, context.getExpressionResolver());
        view.setDividerHeightResource(R.dimen.div_separator_delimiter_height);
        view.setDividerGravity(17);
    }

    private final void bindStyle(final DivSeparatorView divSeparatorView, final DivSeparator.DelimiterStyle delimiterStyle, DivSeparator.DelimiterStyle delimiterStyle2, final ExpressionResolver expressionResolver) {
        Expression<DivSeparator.DelimiterStyle.Orientation> expression;
        Expression<Integer> expression2;
        Disposable disposableObserve = null;
        if (ExpressionsKt.equalsToConstant(delimiterStyle != null ? delimiterStyle.color : null, delimiterStyle2 != null ? delimiterStyle2.color : null)) {
            if (ExpressionsKt.equalsToConstant(delimiterStyle != null ? delimiterStyle.orientation : null, delimiterStyle2 != null ? delimiterStyle2.orientation : null)) {
                return;
            }
        }
        applyStyle(divSeparatorView, delimiterStyle, expressionResolver);
        if (ExpressionsKt.isConstantOrNull(delimiterStyle != null ? delimiterStyle.color : null)) {
            if (ExpressionsKt.isConstantOrNull(delimiterStyle != null ? delimiterStyle.orientation : null)) {
                return;
            }
        }
        Function1<? super DivSeparator.DelimiterStyle.Orientation, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivSeparatorBinder$bindStyle$callback$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                Intrinsics.checkNotNullParameter(obj, "<anonymous parameter 0>");
                this.this$0.applyStyle(divSeparatorView, delimiterStyle, expressionResolver);
            }
        };
        divSeparatorView.addSubscription((delimiterStyle == null || (expression2 = delimiterStyle.color) == null) ? null : expression2.observe(expressionResolver, function1));
        if (delimiterStyle != null && (expression = delimiterStyle.orientation) != null) {
            disposableObserve = expression.observe(expressionResolver, function1);
        }
        divSeparatorView.addSubscription(disposableObserve);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyStyle(DivSeparatorView divSeparatorView, DivSeparator.DelimiterStyle delimiterStyle, ExpressionResolver expressionResolver) {
        if (delimiterStyle == null) {
            divSeparatorView.setDividerColor(DivSeparatorView.DEFAULT_DIVIDER_COLOR);
            divSeparatorView.setHorizontal(true);
        } else {
            divSeparatorView.setDividerColor(delimiterStyle.color.evaluate(expressionResolver).intValue());
            divSeparatorView.setHorizontal(delimiterStyle.orientation.evaluate(expressionResolver) == DivSeparator.DelimiterStyle.Orientation.HORIZONTAL);
        }
    }
}
