package com.yandex.div.core.actions;

import com.yandex.div.core.view2.Div2View;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivActionShowTooltip;
import com.yandex.div2.DivActionTyped;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivActionTypedShowTooltipHandler.kt */
/* JADX INFO: loaded from: classes13.dex */
@Singleton
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\u0010"}, d2 = {"Lcom/yandex/div/core/actions/DivActionTypedShowTooltipHandler;", "Lcom/yandex/div/core/actions/DivActionTypedHandler;", "()V", "handleAction", "", "scopeId", "", "action", "Lcom/yandex/div2/DivActionTyped;", "view", "Lcom/yandex/div/core/view2/Div2View;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "handleShowTooltip", "", "Lcom/yandex/div2/DivActionShowTooltip;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivActionTypedShowTooltipHandler implements DivActionTypedHandler {
    @Inject
    public DivActionTypedShowTooltipHandler() {
    }

    @Override // com.yandex.div.core.actions.DivActionTypedHandler
    public boolean handleAction(String scopeId, DivActionTyped action, Div2View view, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        if (!(action instanceof DivActionTyped.ShowTooltip)) {
            return false;
        }
        handleShowTooltip(((DivActionTyped.ShowTooltip) action).getValue(), view, resolver);
        return true;
    }

    private final void handleShowTooltip(DivActionShowTooltip action, Div2View view, ExpressionResolver resolver) {
        String strEvaluate = action.id.evaluate(resolver);
        Expression<Boolean> expression = action.multiple;
        Boolean boolEvaluate = expression != null ? expression.evaluate(resolver) : null;
        if (boolEvaluate != null) {
            view.showTooltip(strEvaluate, boolEvaluate.booleanValue());
        } else {
            view.showTooltip(strEvaluate);
        }
    }
}
