package com.yandex.mobile.ads.impl;

import android.location.Location;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class ss0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f10234a = TimeUnit.MINUTES.toMillis(2);

    public static boolean a(Location updatedLocation, Location location) {
        Intrinsics.checkNotNullParameter(updatedLocation, "updatedLocation");
        if (location == null) {
            return true;
        }
        long time = updatedLocation.getTime() - location.getTime();
        long j = f10234a;
        boolean z = time > j;
        boolean z2 = time < (-j);
        boolean z3 = time > 0;
        int accuracy = (int) (updatedLocation.getAccuracy() - location.getAccuracy());
        boolean z4 = accuracy > 0;
        boolean z5 = accuracy < 0;
        boolean z6 = ((long) accuracy) > 200;
        boolean zAreEqual = Intrinsics.areEqual(updatedLocation.getProvider(), location.getProvider());
        if (z) {
            return true;
        }
        if (!z2) {
            if (z5) {
                return true;
            }
            if (z3 && !z4) {
                return true;
            }
            if (z3 && !z6 && zAreEqual) {
                return true;
            }
        }
        return false;
    }
}
