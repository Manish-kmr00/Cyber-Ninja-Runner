package com.inmobi.media;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.qa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3530qa implements Yc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ba f3410a;

    public C3530qa(Ba ba) {
        this.f3410a = ba;
    }

    @Override // com.inmobi.media.Yc
    public final void a(View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof Ba) {
            if (this.f3410a.hasWindowFocus()) {
                this.f3410a.c(z);
            } else {
                this.f3410a.c(false);
            }
        }
    }
}
