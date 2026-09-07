package com.yandex.mobile.ads.impl;

import android.location.Location;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class ws0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ss0 f10587a = new ss0();

    public final Location a(List<? extends Location> locations) {
        Intrinsics.checkNotNullParameter(locations, "locations");
        Location location = null;
        for (Location location2 : locations) {
            this.f10587a.getClass();
            if (ss0.a(location2, location)) {
                location = location2;
            }
        }
        return location;
    }
}
