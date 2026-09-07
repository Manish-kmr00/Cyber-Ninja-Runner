package io.appmetrica.analytics.impl;

import android.content.Context;
import android.location.LocationManager;

/* JADX INFO: loaded from: classes13.dex */
public final class B2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LocationManager f11068a;

    public B2(Context context) {
        this((LocationManager) context.getSystemService("location"));
    }

    public B2(LocationManager locationManager) {
        this.f11068a = locationManager;
    }
}
