package com.ogury.ad.internal;

import android.media.AudioManager;
import com.pubmatic.sdk.common.POBCommonConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class k3 implements x4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f7337a;
    public final x4 b;
    public final c c;

    public k3(z androidDevice, k6 orientationChangedCommand, c ad) {
        Intrinsics.checkNotNullParameter(androidDevice, "androidDevice");
        Intrinsics.checkNotNullParameter(orientationChangedCommand, "orientationChangedCommand");
        Intrinsics.checkNotNullParameter(ad, "ad");
        this.f7337a = androidDevice;
        this.b = orientationChangedCommand;
        this.c = ad;
    }

    @Override // com.ogury.ad.internal.x4
    public final void a(n4 mraidCommandExecutor) {
        Intrinsics.checkNotNullParameter(mraidCommandExecutor, "mraidCommandExecutor");
        d5 d5Var = mraidCommandExecutor.f7364a;
        int iB = j7.b(d5Var.getWidth());
        int iB2 = j7.b(d5Var.getHeight());
        int iA = j7.a(d5Var.getX());
        int iA2 = j7.a(d5Var.getY());
        this.b.a(mraidCommandExecutor);
        String placementType = q.a(this.c) ? "interstitial" : POBCommonConstants.BANNER_PLACEMENT_TYPE;
        Intrinsics.checkNotNullParameter(placementType, "placementType");
        h5.a(mraidCommandExecutor.f7364a, o4.b(placementType));
        h5.a(mraidCommandExecutor.f7364a, o4.a(false));
        Object systemService = this.f7337a.f7457a.getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        h5.a(mraidCommandExecutor.f7364a, o4.a(((AudioManager) systemService).getStreamVolume(3)));
        h5.a(mraidCommandExecutor.f7364a, "ogySdkMraidGateway.updateSupportFlags({sms: false, tel: false, calendar: false, storePicture: false, inlineVideo: false, vpaid: false, location: false})");
        h5.a(mraidCommandExecutor.f7364a, o4.b(iB, iB2, iA, iA2));
        h5.a(mraidCommandExecutor.f7364a, o4.a(iB, iB2, iA, iA2));
        h5.a(mraidCommandExecutor.f7364a, o4.c(iB, iB2, iA, iA2));
        h5.a(mraidCommandExecutor.f7364a, o4.a(iB, iB2));
        Intrinsics.checkNotNullParameter("default", "state");
        h5.a(mraidCommandExecutor.f7364a, o4.c("default"));
        mraidCommandExecutor.f7364a.setAdState("default");
    }
}
