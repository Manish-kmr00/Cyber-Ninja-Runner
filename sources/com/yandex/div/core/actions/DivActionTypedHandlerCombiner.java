package com.yandex.div.core.actions;

import com.yandex.div.core.view2.Div2View;
import com.yandex.div.internal.KLog;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div.logging.Severity;
import com.yandex.div2.DivActionTyped;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivActionTypedHandlerCombiner.kt */
/* JADX INFO: loaded from: classes12.dex */
@Singleton
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u001a\b\u0007\u0012\u0011\u0010\u0002\u001a\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\u0003¢\u0006\u0002\u0010\u0006J(\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u0019\u0010\u0002\u001a\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/yandex/div/core/actions/DivActionTypedHandlerCombiner;", "", "handlers", "", "Lcom/yandex/div/core/actions/DivActionTypedHandler;", "Lkotlin/jvm/JvmSuppressWildcards;", "(Ljava/util/Set;)V", "handleAction", "", "scopeId", "", "action", "Lcom/yandex/div2/DivActionTyped;", "div2View", "Lcom/yandex/div/core/view2/Div2View;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivActionTypedHandlerCombiner {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String TAG = "DivTypedActionHandlerCombiner";
    private final Set<DivActionTypedHandler> handlers;

    @Inject
    public DivActionTypedHandlerCombiner(Set<DivActionTypedHandler> handlers) {
        Intrinsics.checkNotNullParameter(handlers, "handlers");
        this.handlers = handlers;
    }

    public final boolean handleAction(String scopeId, DivActionTyped action, Div2View div2View, ExpressionResolver resolver) {
        Object next;
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(div2View, "div2View");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Iterator<T> it = this.handlers.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((DivActionTypedHandler) next).handleAction(scopeId, action, div2View, resolver));
        boolean z = next != null;
        if (!z) {
            KLog kLog = KLog.INSTANCE;
            if (kLog.isAtLeast(Severity.DEBUG)) {
                kLog.print(3, TAG, "Unexpected " + action.getClass() + " was not handled");
            }
        }
        return z;
    }

    /* JADX INFO: compiled from: DivActionTypedHandlerCombiner.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/core/actions/DivActionTypedHandlerCombiner$Companion;", "", "()V", "TAG", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
