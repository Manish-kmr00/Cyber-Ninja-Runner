package com.ogury.ad.internal;

import android.content.Context;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class m7 extends h3 {
    public final z b;

    public m7(Context context) {
        b0 app = new b0(context);
        m1 coreWrapper = new m1(context);
        z androidDevice = new z(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(coreWrapper, "coreWrapper");
        Intrinsics.checkNotNullParameter(androidDevice, "androidDevice");
        super(context, app, coreWrapper);
        this.b = androidDevice;
    }

    @Override // com.ogury.ad.internal.h3, com.ogury.ad.internal.n1, com.ogury.core.internal.network.HeadersLoader
    public Map<String, String> loadHeaders() {
        Map<String, String> mapLoadHeaders = super.loadHeaders();
        mapLoadHeaders.put("Api-Key", com.ironsource.b9.i.d + a().a() + com.ironsource.b9.i.e);
        mapLoadHeaders.put("Sdk-Version", "[5.0.1]");
        mapLoadHeaders.put("Timezone", this.b.c());
        mapLoadHeaders.put("Connectivity", this.b.a());
        mapLoadHeaders.put("Sdk-Version-Type", "ads");
        return mapLoadHeaders;
    }
}
