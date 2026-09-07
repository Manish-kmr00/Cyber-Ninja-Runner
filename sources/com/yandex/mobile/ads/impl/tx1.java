package com.yandex.mobile.ads.impl;

import com.yandex.div.core.DivActionHandler;
import com.yandex.div.core.DivViewFacade;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivAction;
import com.yandex.div2.DivSightAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class tx1 extends DivActionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uo f10337a;
    private h20 b;

    public tx1() {
        this(0);
    }

    @Override // com.yandex.div.core.DivActionHandler
    public final boolean handleAction(DivAction action, DivViewFacade view, ExpressionResolver expressionResolver) {
        h20 h20Var;
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(expressionResolver, "expressionResolver");
        return super.handleAction(action, view, expressionResolver) || ((h20Var = this.b) != null && h20Var.handleAction(action, view, expressionResolver));
    }

    public /* synthetic */ tx1(int i) {
        this(new uo());
    }

    public tx1(uo clickConnectorAggregator) {
        Intrinsics.checkNotNullParameter(clickConnectorAggregator, "clickConnectorAggregator");
        this.f10337a = clickConnectorAggregator;
    }

    @Override // com.yandex.div.core.DivActionHandler
    public final boolean handleAction(DivSightAction action, DivViewFacade view, ExpressionResolver resolver) {
        h20 h20Var;
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return super.handleAction(action, view, resolver) || ((h20Var = this.b) != null && h20Var.handleAction(action, view, resolver));
    }

    public final to a(int i) {
        to toVar = (to) this.f10337a.a().get(Integer.valueOf(i));
        if (toVar != null) {
            return toVar;
        }
        to toVar2 = new to();
        this.f10337a.a(i, toVar2);
        return toVar2;
    }

    public final void a(h20 h20Var) {
        h20 h20Var2 = this.b;
        if (h20Var2 != null) {
            h20Var2.a(null);
        }
        if (h20Var != null) {
            h20Var.a(this.f10337a);
        }
        this.b = h20Var;
    }
}
