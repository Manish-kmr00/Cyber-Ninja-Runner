package io.appmetrica.analytics.location.impl;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable;
import io.appmetrica.analytics.coreapi.internal.permission.PermissionResolutionStrategy;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import io.appmetrica.analytics.locationapi.internal.LastKnownLocationExtractor;

/* JADX INFO: loaded from: classes13.dex */
public class u implements LastKnownLocationExtractor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11906a;
    public final PermissionResolutionStrategy b;
    public final LocationListener c;
    public final String d;

    public u(Context context, PermissionResolutionStrategy permissionResolutionStrategy, LocationListener locationListener, String str) {
        this.f11906a = context;
        this.b = permissionResolutionStrategy;
        this.c = locationListener;
        this.d = str;
    }

    public final Context a() {
        return this.f11906a;
    }

    public final LocationListener b() {
        return this.c;
    }

    public final PermissionResolutionStrategy c() {
        return this.b;
    }

    public final String d() {
        return this.d;
    }

    @Override // io.appmetrica.analytics.locationapi.internal.LastKnownLocationExtractor
    public final void updateLastKnownLocation() {
        Location location;
        if (!this.b.hasNecessaryPermissions(this.f11906a) || (location = (Location) SystemServiceUtils.accessSystemServiceByNameSafely(this.f11906a, "location", "getting last known location for provider " + this.d, "location manager", new FunctionWithThrowable() { // from class: io.appmetrica.analytics.location.impl.u$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
            public final Object apply(Object obj) {
                return u.a(this.f$0, (LocationManager) obj);
            }
        })) == null) {
            return;
        }
        this.c.onLocationChanged(location);
    }

    public static final Location a(u uVar, LocationManager locationManager) {
        return locationManager.getLastKnownLocation(uVar.d);
    }
}
