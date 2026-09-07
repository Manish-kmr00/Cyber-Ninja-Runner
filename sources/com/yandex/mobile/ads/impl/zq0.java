package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class zq0 implements us0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ws0 f10846a;
    private final LocationManager b;
    private final u32 c;

    public zq0(Context context, ws0 locationSelector) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(locationSelector, "locationSelector");
        this.f10846a = locationSelector;
        Object systemService = context.getApplicationContext().getSystemService("location");
        LocationManager locationManager = systemService instanceof LocationManager ? (LocationManager) systemService : null;
        this.b = locationManager;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.c = new u32(applicationContext, locationManager);
    }

    @Override // com.yandex.mobile.ads.impl.us0
    public final Location a() {
        List<String> allProviders;
        try {
            LocationManager locationManager = this.b;
            allProviders = locationManager != null ? locationManager.getAllProviders() : null;
        } catch (Throwable unused) {
            op0.c(new Object[0]);
        }
        if (allProviders == null) {
            return null;
        }
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        Iterator<String> it = allProviders.iterator();
        while (it.hasNext()) {
            Location locationA = this.c.a(it.next());
            if (locationA != null) {
                listCreateListBuilder.add(locationA);
            }
        }
        return this.f10846a.a(CollectionsKt.build(listCreateListBuilder));
    }
}
