package com.ogury.ad.internal;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f7403a;
    public final z b;

    public t0(h adLayout, Context context) {
        z androidDevice = new z(context);
        Intrinsics.checkNotNullParameter(adLayout, "adLayout");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(androidDevice, "androidDevice");
        this.f7403a = adLayout;
        this.b = androidDevice;
    }

    public final void a(w8 adSize, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(adSize, "adSize");
        int i = adSize.f7432a;
        if (z) {
            i = this.b.f7457a.getResources().getConfiguration().orientation == 1 ? -1 : this.b.c.heightPixels;
        }
        e8 e8Var = new e8(false, i, adSize.b, 0, 0);
        e8Var.f = 17;
        if (!z2) {
            this.f7403a.setInitialSizeWithoutResizing(e8Var);
            return;
        }
        this.f7403a.setLeft(0);
        this.f7403a.setTop(0);
        this.f7403a.setInitialSize(e8Var);
    }
}
