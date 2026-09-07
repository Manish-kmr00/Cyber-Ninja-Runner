package com.yandex.div.core.actions;

import android.view.View;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import com.yandex.div.core.view2.divs.widgets.DivInputView;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivActionFocusElement;
import com.yandex.div2.DivActionTyped;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivActionTypedFocusElementHandler.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\u0010"}, d2 = {"Lcom/yandex/div/core/actions/DivActionTypedFocusElementHandler;", "Lcom/yandex/div/core/actions/DivActionTypedHandler;", "()V", "handleAction", "", "scopeId", "", "action", "Lcom/yandex/div2/DivActionTyped;", "view", "Lcom/yandex/div/core/view2/Div2View;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "handleRequestFocus", "", "Lcom/yandex/div2/DivActionFocusElement;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivActionTypedFocusElementHandler implements DivActionTypedHandler {
    @Inject
    public DivActionTypedFocusElementHandler() {
    }

    @Override // com.yandex.div.core.actions.DivActionTypedHandler
    public boolean handleAction(String scopeId, DivActionTyped action, Div2View view, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        if (!(action instanceof DivActionTyped.FocusElement)) {
            return false;
        }
        handleRequestFocus(((DivActionTyped.FocusElement) action).getValue(), view, resolver);
        return true;
    }

    private final void handleRequestFocus(DivActionFocusElement action, Div2View view, ExpressionResolver resolver) {
        String strEvaluate = action.elementId.evaluate(resolver);
        View viewFindViewWithTag = view.findViewWithTag(strEvaluate);
        if (viewFindViewWithTag == null && (viewFindViewWithTag = view.getViewComponent().getDivTooltipController().findViewWithTag(strEvaluate)) == null) {
            return;
        }
        viewFindViewWithTag.requestFocus();
        BaseDivViewExtensionsKt.gainAccessibilityFocus(viewFindViewWithTag);
        if (viewFindViewWithTag instanceof DivInputView) {
            DivActionTypedUtilsKt.openKeyboard((DivInputView) viewFindViewWithTag);
        }
    }
}
