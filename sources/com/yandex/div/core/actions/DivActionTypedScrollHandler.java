package com.yandex.div.core.actions;

import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.items.DivViewWithItemsController;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivActionScrollBy;
import com.yandex.div2.DivActionScrollDestination;
import com.yandex.div2.DivActionScrollTo;
import com.yandex.div2.DivActionTyped;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivActionTypedScrollHandler.kt */
/* JADX INFO: loaded from: classes12.dex */
@Singleton
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J*\u0010\u0003\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u0010"}, d2 = {"Lcom/yandex/div/core/actions/DivActionTypedScrollHandler;", "Lcom/yandex/div/core/actions/DivActionTypedHandler;", "()V", "handleAction", "", "action", "Lcom/yandex/div2/DivActionScrollBy;", "view", "Lcom/yandex/div/core/view2/Div2View;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "Lcom/yandex/div2/DivActionScrollTo;", "", "scopeId", "", "Lcom/yandex/div2/DivActionTyped;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivActionTypedScrollHandler implements DivActionTypedHandler {
    @Inject
    public DivActionTypedScrollHandler() {
    }

    @Override // com.yandex.div.core.actions.DivActionTypedHandler
    public boolean handleAction(String scopeId, DivActionTyped action, Div2View view, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        if (action instanceof DivActionTyped.ScrollBy) {
            handleAction(((DivActionTyped.ScrollBy) action).getValue(), view, resolver);
            return true;
        }
        if (!(action instanceof DivActionTyped.ScrollTo)) {
            return false;
        }
        handleAction(((DivActionTyped.ScrollTo) action).getValue(), view, resolver);
        return true;
    }

    private final void handleAction(DivActionScrollBy action, Div2View view, ExpressionResolver resolver) {
        String strEvaluate = action.id.evaluate(resolver);
        int iLongValue = (int) action.offset.evaluate(resolver).longValue();
        int iLongValue2 = (int) action.itemCount.evaluate(resolver).longValue();
        String string = DivActionScrollBy.Overflow.INSTANCE.toString(action.overflow.evaluate(resolver));
        boolean zBooleanValue = action.animated.evaluate(resolver).booleanValue();
        DivViewWithItemsController divViewWithItemsControllerCreate$default = DivViewWithItemsController.Companion.create$default(DivViewWithItemsController.INSTANCE, strEvaluate, view, resolver, null, 8, null);
        if (divViewWithItemsControllerCreate$default == null) {
            return;
        }
        divViewWithItemsControllerCreate$default.changeCurrentItemByStep(string, iLongValue2, zBooleanValue);
        divViewWithItemsControllerCreate$default.scrollByOffset(string, iLongValue, zBooleanValue);
    }

    private final void handleAction(DivActionScrollTo action, Div2View view, ExpressionResolver resolver) {
        String strEvaluate = action.id.evaluate(resolver);
        boolean zBooleanValue = action.animated.evaluate(resolver).booleanValue();
        DivViewWithItemsController divViewWithItemsControllerCreate$default = DivViewWithItemsController.Companion.create$default(DivViewWithItemsController.INSTANCE, strEvaluate, view, resolver, null, 8, null);
        if (divViewWithItemsControllerCreate$default == null) {
            return;
        }
        DivActionScrollDestination divActionScrollDestination = action.destination;
        if (divActionScrollDestination instanceof DivActionScrollDestination.Offset) {
            divViewWithItemsControllerCreate$default.scrollTo((int) ((DivActionScrollDestination.Offset) divActionScrollDestination).getValue().value.evaluate(resolver).longValue(), zBooleanValue);
            return;
        }
        if (divActionScrollDestination instanceof DivActionScrollDestination.Index) {
            divViewWithItemsControllerCreate$default.setCurrentItem((int) ((DivActionScrollDestination.Index) divActionScrollDestination).getValue().value.evaluate(resolver).longValue(), zBooleanValue);
        } else if (divActionScrollDestination instanceof DivActionScrollDestination.End) {
            divViewWithItemsControllerCreate$default.scrollToEnd(zBooleanValue);
        } else if (divActionScrollDestination instanceof DivActionScrollDestination.Start) {
            divViewWithItemsControllerCreate$default.scrollToStart(zBooleanValue);
        }
    }
}
