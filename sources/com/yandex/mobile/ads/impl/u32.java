package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import java.util.HashSet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class u32 {
    private static final HashSet c = new HashSet(CollectionsKt.listOf("gps"));
    private static final HashSet d = new HashSet(CollectionsKt.listOf((Object[]) new String[]{"gps", "passive"}));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LocationManager f10354a;
    private final pg1 b;

    public final Location a(String locationProvider) {
        Intrinsics.checkNotNullParameter(locationProvider, "locationProvider");
        boolean zA = this.b.a();
        boolean zB = this.b.b();
        boolean zContains = c.contains(locationProvider);
        if (d.contains(locationProvider)) {
            if (zContains || !zA || !zB) {
                return null;
            }
        } else if (zContains || !zA) {
            return null;
        }
        try {
            LocationManager locationManager = this.f10354a;
            if (locationManager == null) {
                return null;
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation(locationProvider);
            op0.a(locationProvider, lastKnownLocation);
            return lastKnownLocation;
        } catch (Throwable unused) {
            op0.b(new Object[0]);
            return null;
        }
    }

    public /* synthetic */ u32(Context context, LocationManager locationManager) {
        this(context, locationManager, new pg1(context));
    }

    public u32(Context context, LocationManager locationManager, pg1 permissionExtractor) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(permissionExtractor, "permissionExtractor");
        this.f10354a = locationManager;
        this.b = permissionExtractor;
    }
}
