package com.yandex.mobile.ads.impl;

import com.yandex.div.core.DivActionHandler;
import com.yandex.div.core.view2.Div2View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class r10 {
    public static final tx1 a(Div2View div2View) {
        Intrinsics.checkNotNullParameter(div2View, "<this>");
        DivActionHandler actionHandler = div2View.getActionHandler();
        tx1 tx1Var = actionHandler instanceof tx1 ? (tx1) actionHandler : null;
        if (tx1Var == null) {
            tx1Var = new tx1(0);
        }
        div2View.setActionHandler(tx1Var);
        return tx1Var;
    }
}
