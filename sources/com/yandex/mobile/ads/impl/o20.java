package com.yandex.mobile.ads.impl;

import android.app.Dialog;
import android.content.Context;
import com.yandex.div.core.view2.Div2View;
import com.yandex.mobile.ads.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class o20 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j10 f9773a;
    private final n20 b;

    public o20(j10 contentCloseListener, l20 actionHandler, n20 binder) {
        Intrinsics.checkNotNullParameter(contentCloseListener, "contentCloseListener");
        Intrinsics.checkNotNullParameter(actionHandler, "actionHandler");
        Intrinsics.checkNotNullParameter(binder, "binder");
        this.f9773a = contentCloseListener;
        this.b = binder;
    }

    public final void a(Context context, k20 action) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(action, "action");
        Div2View div2ViewA = this.b.a(context, action);
        Dialog dialog = new Dialog(div2ViewA.getContext(), R.style.MonetizationAdsInternal_FullscreenDialog);
        this.f9773a.a(dialog);
        dialog.setContentView(div2ViewA);
        dialog.show();
    }
}
