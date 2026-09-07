package com.ogury.ad.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class c1 implements x4 {
    @Override // com.ogury.ad.internal.x4
    public final void a(n4 mraidCommandExecutor) {
        Intrinsics.checkNotNullParameter(mraidCommandExecutor, "mraidCommandExecutor");
        h5.a(mraidCommandExecutor.f7364a, o4.a(false));
        Intrinsics.checkNotNullParameter("hidden", "state");
        h5.a(mraidCommandExecutor.f7364a, o4.c("hidden"));
        mraidCommandExecutor.f7364a.setAdState("hidden");
    }
}
