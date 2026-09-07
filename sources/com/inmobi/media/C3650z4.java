package com.inmobi.media;

import android.widget.RelativeLayout;
import com.inmobi.ads.rendering.InMobiAdActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.z4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3650z4 implements xd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InMobiAdActivity f3494a;
    public final /* synthetic */ RelativeLayout.LayoutParams b;

    public C3650z4(InMobiAdActivity inMobiAdActivity, RelativeLayout.LayoutParams layoutParams) {
        this.f3494a = inMobiAdActivity;
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
        return AbstractC3420j2.a(this.f3494a);
    }
}
