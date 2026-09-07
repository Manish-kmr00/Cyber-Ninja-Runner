package com.yandex.mobile.ads.impl;

import android.app.Activity;
import android.content.Intent;
import android.view.Window;
import android.widget.RelativeLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h1 implements n1 {
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
        o8<?> o8VarC = c1Var.c();
        o3 o3VarB = c1Var.b();
        m61 m61VarE = c1Var.e();
        zu1 zu1VarG = c1Var.g();
        o8<?> o8Var = o8VarC instanceof o8 ? o8VarC : null;
        String str = o8Var != null ? (String) o8Var.I() : null;
        if (zu1VarG != null && str != null && str.length() != 0) {
            cd0 cd0Var = new cd0(o8VarC, str, zu1VarG);
            return new g1(activity, rootLayout, listener, window, cd0Var, new hf1(activity, cd0Var.a(), listener), new tc0(activity), new fd0(cd0Var.a().n()));
        }
        if (m61VarE != null) {
            return new k1(activity, rootLayout, window, m61VarE, o8VarC, listener, eventController, o3VarB, c1Var.f(), new tc0(activity), new fd0(o3VarB.b()));
        }
        return null;
    }
}
