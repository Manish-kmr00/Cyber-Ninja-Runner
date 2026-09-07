package com.yandex.div.core.view2.divs;

import com.yandex.div.core.dagger.DivScope;
import com.yandex.div.core.expression.variables.TwoWayBooleanVariableBinder;
import com.yandex.div.core.state.DivStatePath;
import com.yandex.div.core.view2.BindingContext;
import com.yandex.div.core.view2.DivViewBinder;
import com.yandex.div.core.view2.divs.widgets.DivSwitchView;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div.json.expressions.ExpressionsKt;
import com.yandex.div2.DivSwitch;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivSwitchBinder.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\n*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001c\u0010\u0014\u001a\u00020\n*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J&\u0010\u0015\u001a\u00020\n*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J&\u0010\u0017\u001a\u00020\n*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J$\u0010\u0018\u001a\u00020\n*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/yandex/div/core/view2/divs/DivSwitchBinder;", "Lcom/yandex/div/core/view2/DivViewBinder;", "Lcom/yandex/div2/DivSwitch;", "Lcom/yandex/div/core/view2/divs/widgets/DivSwitchView;", "baseBinder", "Lcom/yandex/div/core/view2/divs/DivBaseBinder;", "variableBinder", "Lcom/yandex/div/core/expression/variables/TwoWayBooleanVariableBinder;", "(Lcom/yandex/div/core/view2/divs/DivBaseBinder;Lcom/yandex/div/core/expression/variables/TwoWayBooleanVariableBinder;)V", "bindView", "", "context", "Lcom/yandex/div/core/view2/BindingContext;", "view", "div", "path", "Lcom/yandex/div/core/state/DivStatePath;", "applyIsEnabled", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "applyOnColor", "bindIsEnabled", "oldDiv", "bindOnColor", "observeVariable", "bindingContext", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@DivScope
public final class DivSwitchBinder implements DivViewBinder<DivSwitch, DivSwitchView> {
    private final DivBaseBinder baseBinder;
    private final TwoWayBooleanVariableBinder variableBinder;

    @Inject
    public DivSwitchBinder(DivBaseBinder baseBinder, TwoWayBooleanVariableBinder variableBinder) {
        Intrinsics.checkNotNullParameter(baseBinder, "baseBinder");
        Intrinsics.checkNotNullParameter(variableBinder, "variableBinder");
        this.baseBinder = baseBinder;
        this.variableBinder = variableBinder;
    }

    @Override // com.yandex.div.core.view2.DivViewBinder
    public void bindView(BindingContext context, DivSwitchView view, DivSwitch div, DivStatePath path) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(div, "div");
        Intrinsics.checkNotNullParameter(path, "path");
        DivSwitch div2 = view.getDiv();
        if (div == div2) {
            return;
        }
        this.baseBinder.bindView(context, view, div, div2);
        bindIsEnabled(view, div, div2, context.getExpressionResolver());
        bindOnColor(view, div, div2, context.getExpressionResolver());
        observeVariable(view, div, context, path);
    }

    private final void bindIsEnabled(final DivSwitchView divSwitchView, final DivSwitch divSwitch, DivSwitch divSwitch2, final ExpressionResolver expressionResolver) {
        if (ExpressionsKt.equalsToConstant(divSwitch.isEnabled, divSwitch2 != null ? divSwitch2.isEnabled : null)) {
            return;
        }
        applyIsEnabled(divSwitchView, divSwitch, expressionResolver);
        if (ExpressionsKt.isConstant(divSwitch.isEnabled)) {
            return;
        }
        divSwitchView.addSubscription(divSwitch.isEnabled.observe(expressionResolver, new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivSwitchBinder$bindIsEnabled$callback$1
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
                this.this$0.applyIsEnabled(divSwitchView, divSwitch, expressionResolver);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyIsEnabled(DivSwitchView divSwitchView, DivSwitch divSwitch, ExpressionResolver expressionResolver) {
        divSwitchView.setEnabled(divSwitch.isEnabled.evaluate(expressionResolver).booleanValue());
    }

    private final void bindOnColor(final DivSwitchView divSwitchView, final DivSwitch divSwitch, DivSwitch divSwitch2, final ExpressionResolver expressionResolver) {
        if (ExpressionsKt.equalsToConstant(divSwitch.onColor, divSwitch2 != null ? divSwitch2.onColor : null)) {
            return;
        }
        applyOnColor(divSwitchView, divSwitch, expressionResolver);
        if (ExpressionsKt.isConstantOrNull(divSwitch.onColor)) {
            return;
        }
        Function1<? super Integer, Unit> function1 = new Function1<Object, Unit>() { // from class: com.yandex.div.core.view2.divs.DivSwitchBinder$bindOnColor$callback$1
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
                this.this$0.applyOnColor(divSwitchView, divSwitch, expressionResolver);
            }
        };
        Expression<Integer> expression = divSwitch.onColor;
        divSwitchView.addSubscription(expression != null ? expression.observe(expressionResolver, function1) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyOnColor(DivSwitchView divSwitchView, DivSwitch divSwitch, ExpressionResolver expressionResolver) {
        Expression<Integer> expression = divSwitch.onColor;
        divSwitchView.setColorOn(expression != null ? expression.evaluate(expressionResolver) : null);
    }

    private final void observeVariable(final DivSwitchView divSwitchView, DivSwitch divSwitch, BindingContext bindingContext, DivStatePath divStatePath) {
        divSwitchView.addSubscription(this.variableBinder.bindVariable(bindingContext, divSwitch.isOnVariable, new TwoWayBooleanVariableBinder.Callbacks() { // from class: com.yandex.div.core.view2.divs.DivSwitchBinder$observeVariable$callbacks$1
            @Override // com.yandex.div.core.expression.variables.TwoWayVariableBinder.Callbacks
            public void onVariableChanged(Boolean value) {
                if (value != null) {
                    divSwitchView.setChecked(value.booleanValue());
                }
            }

            @Override // com.yandex.div.core.expression.variables.TwoWayVariableBinder.Callbacks
            public void setViewStateChangeListener(Function1<? super Boolean, Unit> valueUpdater) {
                Intrinsics.checkNotNullParameter(valueUpdater, "valueUpdater");
                divSwitchView.setOnCheckedChangeListener(valueUpdater);
            }
        }, divStatePath));
    }
}
