package com.inmobi.media;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class W6 implements Yc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3313b7 f3226a;

    public W6(C3313b7 c3313b7) {
        this.f3226a = c3313b7;
    }

    @Override // com.inmobi.media.Yc
    public final void a(View view, boolean z) {
        L0 l0;
        Intrinsics.checkNotNullParameter(view, "view");
        C3313b7 c3313b7 = this.f3226a;
        if (z) {
            c3313b7.p();
            return;
        }
        L7 l7H = c3313b7.h();
        if (l7H == null || (l0 = l7H.l) == null) {
            return;
        }
        l0.a();
    }
}
