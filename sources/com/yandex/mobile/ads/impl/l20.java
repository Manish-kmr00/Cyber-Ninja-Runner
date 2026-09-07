package com.yandex.mobile.ads.impl;

import android.net.Uri;
import com.yandex.div.core.DivActionHandler;
import com.yandex.div.core.DivViewFacade;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class l20 extends DivActionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wr f9471a;

    public l20(j10 contentCloseListener) {
        Intrinsics.checkNotNullParameter(contentCloseListener, "contentCloseListener");
        this.f9471a = contentCloseListener;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0040 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:9:0x0038  */
    @Override // com.yandex.div.core.DivActionHandler
    public final boolean handleAction(DivAction action, DivViewFacade view, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Expression<Uri> expression = action.url;
        if (expression != null) {
            Uri uriEvaluate = expression.evaluate(resolver);
            if (Intrinsics.areEqual(uriEvaluate.getScheme(), "mobileads") && Intrinsics.areEqual(uriEvaluate.getHost(), "closeDialog")) {
                this.f9471a.f();
            } else if (super.handleAction(action, view, resolver)) {
                return false;
            }
        } else if (super.handleAction(action, view, resolver)) {
            return false;
        }
        return true;
    }
}
