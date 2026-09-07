package com.ogury.ad.internal;

import android.content.Context;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class i9 extends h3 {
    public final d8 b;

    public i9(Context context) {
        b0 app = new b0(context);
        m1 coreWrapper = new m1(context);
        d8 permissionsHandler = new d8(context, i7.TRACKERS);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(coreWrapper, "coreWrapper");
        Intrinsics.checkNotNullParameter(permissionsHandler, "permissionsHandler");
        super(context, app, coreWrapper);
        this.b = permissionsHandler;
    }

    @Override // com.ogury.ad.internal.h3, com.ogury.ad.internal.n1, com.ogury.core.internal.network.HeadersLoader
    public Map<String, String> loadHeaders() {
        Map<String, String> mapLoadHeaders = super.loadHeaders();
        String strD = this.b.d();
        if (strD == null) {
            strD = "00000000-0000-0000-0000-000000000000";
        }
        mapLoadHeaders.put("User", strD);
        String strI = this.b.i();
        if (strI != null) {
            mapLoadHeaders.put("Instance-Token", strI);
        }
        return mapLoadHeaders;
    }
}
