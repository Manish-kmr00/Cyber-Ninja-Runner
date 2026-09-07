package com.yandex.div.core.actions;

import android.view.View;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.ViewLocator;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivActionTyped;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivAnimatorTypedActionHandler.kt */
/* JADX INFO: loaded from: classes10.dex */
@Singleton
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/yandex/div/core/actions/DivAnimatorTypedActionHandler;", "Lcom/yandex/div/core/actions/DivActionTypedHandler;", "()V", "handleAction", "", "scopeId", "", "action", "Lcom/yandex/div2/DivActionTyped;", "view", "Lcom/yandex/div/core/view2/Div2View;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivAnimatorTypedActionHandler implements DivActionTypedHandler {
    @Inject
    public DivAnimatorTypedActionHandler() {
    }

    @Override // com.yandex.div.core.actions.DivActionTypedHandler
    public boolean handleAction(String scopeId, DivActionTyped action, Div2View view, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        if (!(action instanceof DivActionTyped.AnimatorStart)) {
            if (!(action instanceof DivActionTyped.AnimatorStop)) {
                return false;
            }
            if (scopeId == null) {
                return true;
            }
            view.getViewComponent().getAnimatorController().stopAnimator(scopeId, ((DivActionTyped.AnimatorStop) action).getValue().animatorId);
            return true;
        }
        if (scopeId == null) {
            return true;
        }
        List<View> listFindViewsWithTag = ViewLocator.findViewsWithTag(view, scopeId);
        if (listFindViewsWithTag.size() != 1) {
            return true;
        }
        view.getViewComponent().getAnimatorController().startAnimator(scopeId, (View) CollectionsKt.first((List) listFindViewsWithTag), ((DivActionTyped.AnimatorStart) action).getValue(), resolver);
        return true;
    }
}
