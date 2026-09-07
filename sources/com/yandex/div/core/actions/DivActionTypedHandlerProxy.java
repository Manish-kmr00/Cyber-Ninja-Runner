package com.yandex.div.core.actions;

import com.yandex.div.core.DivViewFacade;
import com.yandex.div.core.downloader.DivDownloadActionHandler;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.internal.Assert;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivAction;
import com.yandex.div2.DivActionTyped;
import com.yandex.div2.DivDownloadCallbacks;
import com.yandex.div2.DivSightAction;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivActionTypedHandlerProxy.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J8\u0010\u0003\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u0012"}, d2 = {"Lcom/yandex/div/core/actions/DivActionTypedHandlerProxy;", "", "()V", "handleAction", "", "action", "Lcom/yandex/div2/DivAction;", "view", "Lcom/yandex/div/core/DivViewFacade;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "scopeId", "", "Lcom/yandex/div2/DivActionTyped;", "downloadCallbacks", "Lcom/yandex/div2/DivDownloadCallbacks;", "handleVisibilityAction", "Lcom/yandex/div2/DivSightAction;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivActionTypedHandlerProxy {
    public static final DivActionTypedHandlerProxy INSTANCE = new DivActionTypedHandlerProxy();

    private DivActionTypedHandlerProxy() {
    }

    @JvmStatic
    public static final boolean handleVisibilityAction(DivSightAction action, DivViewFacade view, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return INSTANCE.handleAction(action.getScopeId(), action.getTyped(), view, resolver, action.getDownloadCallbacks());
    }

    @JvmStatic
    public static final boolean handleAction(DivAction action, DivViewFacade view, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return INSTANCE.handleAction(action.scopeId, action.typed, view, resolver, action.downloadCallbacks);
    }

    static /* synthetic */ boolean handleAction$default(DivActionTypedHandlerProxy divActionTypedHandlerProxy, String str, DivActionTyped divActionTyped, DivViewFacade divViewFacade, ExpressionResolver expressionResolver, DivDownloadCallbacks divDownloadCallbacks, int i, Object obj) {
        if ((i & 16) != 0) {
            divDownloadCallbacks = null;
        }
        return divActionTypedHandlerProxy.handleAction(str, divActionTyped, divViewFacade, expressionResolver, divDownloadCallbacks);
    }

    private final boolean handleAction(String scopeId, DivActionTyped action, DivViewFacade view, ExpressionResolver resolver, DivDownloadCallbacks downloadCallbacks) {
        if (action == null) {
            return false;
        }
        if (!(view instanceof Div2View)) {
            Assert.fail("Div2View should be used!");
            return false;
        }
        if (action instanceof DivActionTyped.Download) {
            return DivDownloadActionHandler.INSTANCE.handleAction(((DivActionTyped.Download) action).getValue(), downloadCallbacks, (Div2View) view, resolver);
        }
        Div2View div2View = (Div2View) view;
        return div2View.getDiv2Component().getActionTypedHandlerCombiner().handleAction(scopeId, action, div2View, resolver);
    }
}
