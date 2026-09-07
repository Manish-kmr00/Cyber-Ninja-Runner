package io.bidmachine.iab.utils;

import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public class SystemFeatureAvailability {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f12248a;

    public SystemFeatureAvailability(Context context) {
        this.f12248a = context.getApplicationContext();
    }

    public boolean hasTelephony() {
        return this.f12248a.getPackageManager().hasSystemFeature("android.hardware.telephony");
    }
}
