package com.ogury.ad.internal;

import android.graphics.Rect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class k6 implements x4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f7340a;
    public final boolean b;

    public k6(z androidDevice, boolean z) {
        Intrinsics.checkNotNullParameter(androidDevice, "androidDevice");
        this.f7340a = androidDevice;
        this.b = z;
    }

    @Override // com.ogury.ad.internal.x4
    public final void a(n4 mraidCommandExecutor) {
        Intrinsics.checkNotNullParameter(mraidCommandExecutor, "mraidCommandExecutor");
        int iB = j7.b(this.f7340a.c.widthPixels);
        int iB2 = j7.b(this.f7340a.c.heightPixels);
        Rect rectA = this.f7340a.a(mraidCommandExecutor.f7364a);
        h5.a(mraidCommandExecutor.f7364a, o4.c(iB, iB2));
        h5.a(mraidCommandExecutor.f7364a, o4.b(j7.b(rectA.width()), j7.b(rectA.height())));
        String forceOrientation = this.f7340a.f7457a.getResources().getConfiguration().orientation == 2 ? "landscape" : "portrait";
        boolean z = this.b;
        Intrinsics.checkNotNullParameter(forceOrientation, "orientation");
        h5.a(mraidCommandExecutor.f7364a, o4.a(forceOrientation, z));
        boolean z2 = this.b;
        if (!z2) {
            forceOrientation = "none";
        }
        Intrinsics.checkNotNullParameter(forceOrientation, "forceOrientation");
        h5.a(mraidCommandExecutor.f7364a, o4.b(forceOrientation, !z2));
    }
}
