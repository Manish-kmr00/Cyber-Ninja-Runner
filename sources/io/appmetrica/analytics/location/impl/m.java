package io.appmetrica.analytics.location.impl;

import android.location.Location;
import io.appmetrica.analytics.coreutils.internal.cache.SynchronizedDataCache;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes13.dex */
public final class m extends SynchronizedDataCache {
    public static final long d = 200;
    public static final long e = 50;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f11900a;
    public static final long b = TimeUnit.SECONDS.toMillis(10);
    public static final long c = TimeUnit.MINUTES.toMillis(2);
    public static final List<String> f = Arrays.asList("gps", "network");

    public m() {
        l lVar = new l(c);
        long j = b;
        this(lVar, j, 2 * j);
    }

    @Override // io.appmetrica.analytics.coreutils.internal.cache.DataCache
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final boolean shouldUpdate(Location location) {
        return f.contains(location.getProvider()) && (this.mCachedData.isEmpty() || this.mCachedData.shouldUpdateData() || a(location, (Location) this.mCachedData.getData(), this.f11900a.f11899a, 200L));
    }

    public m(l lVar, long j, long j2) {
        super(j, j2, "location");
        this.f11900a = lVar;
    }

    public static boolean a(Location location, Location location2, long j, long j2) {
        boolean zEquals;
        if (location2 == null) {
            return true;
        }
        if (location == null) {
            return false;
        }
        long time = location.getTime() - location2.getTime();
        boolean z = time > j;
        boolean z2 = time < (-j);
        boolean z3 = time > 0;
        if (z) {
            return true;
        }
        if (z2) {
            return false;
        }
        int accuracy = (int) (location.getAccuracy() - location2.getAccuracy());
        boolean z4 = accuracy > 0;
        boolean z5 = accuracy < 0;
        boolean z6 = ((long) accuracy) > j2;
        String provider = location.getProvider();
        String provider2 = location2.getProvider();
        if (provider == null) {
            zEquals = provider2 == null;
        } else {
            zEquals = provider.equals(provider2);
        }
        if (z5) {
            return true;
        }
        if (!z3 || z4) {
            return z3 && !z6 && zEquals;
        }
        return true;
    }
}
