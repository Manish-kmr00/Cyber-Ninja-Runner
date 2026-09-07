package com.yandex.mobile.ads.impl;

import android.app.Activity;
import android.content.Intent;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class y0 implements n1 {
    @Override // com.yandex.mobile.ads.impl.n1
    public final m1 a(Activity context, RelativeLayout rootLayout, v1 listener, e1 eventController, Intent intent, Window window, c1 c1Var) {
        Intrinsics.checkNotNullParameter(context, "activity");
        Intrinsics.checkNotNullParameter(rootLayout, "rootLayout");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(eventController, "eventController");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(window, "window");
        String stringExtra = intent.getStringExtra("extra_browser_url");
        if (stringExtra != null && stringExtra.length() > 0) {
            try {
                try {
                    h3 h3Var = new h3(context);
                    Intrinsics.checkNotNullParameter(context, "context");
                    LinearLayout linearLayout = new LinearLayout(context);
                    linearLayout.setId(1);
                    linearLayout.setOrientation(0);
                    linearLayout.setBackgroundColor(f8.b());
                    return new x0(context, rootLayout, listener, window, stringExtra, h3Var, linearLayout, h8.c(context), h8.d(context), new q82(new p82()));
                } catch (Throwable unused) {
                    throw new lj2();
                }
            } catch (lj2 unused2) {
            }
        }
        return null;
    }
}
