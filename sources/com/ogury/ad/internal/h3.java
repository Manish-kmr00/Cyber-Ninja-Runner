package com.ogury.ad.internal;

import android.content.Context;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h3 extends n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f7313a;

    public h3(Context context, b0 app, m1 coreWrapper) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(coreWrapper, "coreWrapper");
        this.f7313a = app;
    }

    public final b0 a() {
        return this.f7313a;
    }

    @Override // com.ogury.ad.internal.n1, com.ogury.core.internal.network.HeadersLoader
    public Map<String, String> loadHeaders() {
        Map<String, String> mapLoadHeaders = super.loadHeaders();
        mapLoadHeaders.put("Device-OS", "android");
        mapLoadHeaders.put("User-Agent", this.f7313a.e());
        String packageName = this.f7313a.f7264a.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        mapLoadHeaders.put("Package-Name", packageName);
        return mapLoadHeaders;
    }
}
