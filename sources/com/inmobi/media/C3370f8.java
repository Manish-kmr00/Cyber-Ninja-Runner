package com.inmobi.media;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.f8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3370f8 implements Yc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3398h8 f3314a;

    public C3370f8(C3398h8 c3398h8) {
        this.f3314a = c3398h8;
    }

    @Override // com.inmobi.media.Yc
    public final void a(View view, boolean z) {
        L0 l0;
        Intrinsics.checkNotNullParameter(view, "view");
        C3398h8 c3398h8 = this.f3314a;
        if (z) {
            c3398h8.p();
        } else {
            L7 l7H = c3398h8.h();
            if (l7H != null && (l0 = l7H.l) != null) {
                l0.a();
            }
        }
        this.f3314a.a(view, z);
    }
}
