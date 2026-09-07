package com.safedk.android.analytics.brandsafety.creatives;

import android.os.Bundle;

/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Bundle f8061a = new Bundle();

    public boolean a(AdNetworkConfiguration adNetworkConfiguration) {
        return this.f8061a.containsKey(adNetworkConfiguration.name());
    }

    public boolean b(AdNetworkConfiguration adNetworkConfiguration) {
        return this.f8061a.getBoolean(adNetworkConfiguration.name());
    }

    public boolean a(AdNetworkConfiguration adNetworkConfiguration, boolean z) {
        return this.f8061a.getBoolean(adNetworkConfiguration.name(), z);
    }

    public String c(AdNetworkConfiguration adNetworkConfiguration) {
        return this.f8061a.getString(adNetworkConfiguration.name());
    }

    public String a(AdNetworkConfiguration adNetworkConfiguration, String str) {
        return this.f8061a.getString(adNetworkConfiguration.name(), str);
    }

    public float d(AdNetworkConfiguration adNetworkConfiguration) {
        return this.f8061a.getFloat(adNetworkConfiguration.name());
    }

    public long e(AdNetworkConfiguration adNetworkConfiguration) {
        return this.f8061a.getLong(adNetworkConfiguration.name());
    }

    public void b(AdNetworkConfiguration adNetworkConfiguration, boolean z) {
        this.f8061a.putBoolean(adNetworkConfiguration.name(), z);
    }

    public void b(AdNetworkConfiguration adNetworkConfiguration, String str) {
        this.f8061a.putString(adNetworkConfiguration.name(), str);
    }

    public void a(AdNetworkConfiguration adNetworkConfiguration, float f) {
        this.f8061a.putFloat(adNetworkConfiguration.name(), f);
    }

    public void a(AdNetworkConfiguration adNetworkConfiguration, long j) {
        this.f8061a.putLong(adNetworkConfiguration.name(), j);
    }

    public String toString() {
        return this.f8061a.toString();
    }
}
