package com.yandex.mobile.ads.impl;

import android.net.Uri;
import com.yandex.div.core.DivActionHandler;
import com.yandex.div.core.DivViewFacade;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class aq extends DivActionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final cq f8433a;

    public aq(zp closeVerificationListener) {
        Intrinsics.checkNotNullParameter(closeVerificationListener, "closeVerificationListener");
        this.f8433a = closeVerificationListener;
    }

    @Override // com.yandex.div.core.DivActionHandler
    public final boolean handleAction(DivAction action, DivViewFacade view, ExpressionResolver expressionResolver) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(expressionResolver, "expressionResolver");
        Expression<Uri> expression = action.url;
        boolean z = false;
        if (expression != null) {
            String string = expression.evaluate(expressionResolver).toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            if (Intrinsics.areEqual(string, "close_ad")) {
                this.f8433a.a();
            } else if (Intrinsics.areEqual(string, "close_dialog")) {
                this.f8433a.b();
            }
            z = true;
        }
        return z ? z : super.handleAction(action, view, expressionResolver);
    }
}
