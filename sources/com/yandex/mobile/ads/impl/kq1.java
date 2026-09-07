package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;

/* JADX INFO: loaded from: classes10.dex */
public final class kq1 implements Parcelable {
    public static final Parcelable.Creator<kq1> CREATOR = new a();
    private final int b;

    final class a implements Parcelable.Creator<kq1> {
        @Override // android.os.Parcelable.Creator
        public final kq1 createFromParcel(Parcel parcel) {
            return new kq1(parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final kq1[] newArray(int i) {
            return new kq1[i];
        }

        a() {
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0048  */
    public final int a(Context context) {
        int i;
        Intent intentRegisterReceiver;
        int intExtra;
        if (e()) {
            Object systemService = context.getSystemService("connectivity");
            systemService.getClass();
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                i = this.b & 3;
            } else {
                if (x82.f10629a >= 24) {
                    Network activeNetwork = connectivityManager.getActiveNetwork();
                    if (activeNetwork != null) {
                        try {
                            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
                            if (networkCapabilities == null || !networkCapabilities.hasCapability(16)) {
                            }
                        } catch (SecurityException unused) {
                        }
                    }
                    i = this.b & 3;
                }
                if ((this.b & 2) == 0 || !connectivityManager.isActiveNetworkMetered()) {
                    i = 0;
                } else {
                    i = 2;
                }
            }
        } else {
            i = 0;
        }
        if (c() && ((intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"))) == null || ((intExtra = intentRegisterReceiver.getIntExtra("status", -1)) != 2 && intExtra != 5))) {
            i |= 8;
        }
        if (d()) {
            Object systemService2 = context.getSystemService("power");
            systemService2.getClass();
            PowerManager powerManager = (PowerManager) systemService2;
            int i2 = x82.f10629a;
            if (i2 < 23 ? i2 < 20 ? powerManager.isScreenOn() : powerManager.isInteractive() : !powerManager.isDeviceIdleMode()) {
                i |= 4;
            }
        }
        return (!f() || context.registerReceiver(null, new IntentFilter("android.intent.action.DEVICE_STORAGE_LOW")) == null) ? i : i | 16;
    }

    public kq1(int i) {
        this.b = (i & 2) != 0 ? i | 1 : i;
    }

    public final boolean e() {
        return (this.b & 1) != 0;
    }

    public final boolean c() {
        return (this.b & 8) != 0;
    }

    public final boolean d() {
        return (this.b & 4) != 0;
    }

    public final boolean f() {
        return (this.b & 16) != 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && kq1.class == obj.getClass() && this.b == ((kq1) obj).b;
    }

    public final int hashCode() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.b);
    }
}
