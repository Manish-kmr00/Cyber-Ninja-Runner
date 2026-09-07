package com.inmobi.media;

import android.widget.RelativeLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.v3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C3593v3 implements xd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3607w3 f3453a;
    public final /* synthetic */ RelativeLayout.LayoutParams b;

    public C3593v3(C3607w3 c3607w3, RelativeLayout.LayoutParams layoutParams) {
        this.f3453a = c3607w3;
        this.b = layoutParams;
    }

    @Override // com.inmobi.media.xd
    public final void a(EnumC3501o9 orientation, zd finalInsets) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(finalInsets, "finalInsets");
        AbstractC3420j2.a(finalInsets, this.b, orientation);
    }

    @Override // com.inmobi.media.xd
    public final boolean f() {
        return AbstractC3420j2.a(this.f3453a.f3464a);
    }
}
