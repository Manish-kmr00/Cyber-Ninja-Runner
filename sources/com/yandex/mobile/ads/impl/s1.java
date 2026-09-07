package com.yandex.mobile.ads.impl;

import android.app.Activity;
import android.content.Intent;
import android.view.Window;
import android.widget.RelativeLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class s1 implements n1 {
    @Override // com.yandex.mobile.ads.impl.n1
    public final m1 a(Activity activity, RelativeLayout rootLayout, v1 listener, e1 eventController, Intent intent, Window window, c1 c1Var) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(rootLayout, "rootLayout");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(eventController, "eventController");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(window, "window");
        if (c1Var == null) {
            return null;
        }
        return new r1(activity, c1Var, new u0(c1Var.b().q().c()));
    }
}
