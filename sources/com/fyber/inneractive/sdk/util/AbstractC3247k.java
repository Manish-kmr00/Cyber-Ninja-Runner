package com.fyber.inneractive.sdk.util;

import android.os.Build;
import android.telephony.TelephonyManager;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.util.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public abstract class AbstractC3247k extends AbstractC3251o {
    public static String j() {
        try {
            return ((TelephonyManager) AbstractC3251o.f2370a.getSystemService("phone")).getNetworkCountryIso();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String k() {
        return Build.MANUFACTURER + " " + Build.MODEL;
    }

    public static int l() {
        try {
            if (AbstractC3251o.a("android.permission.READ_PHONE_STATE")) {
                return ((TelephonyManager) AbstractC3251o.f2370a.getSystemService("phone")).getDataNetworkType();
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static String m() {
        try {
            return AbstractC3251o.f2370a.getPackageManager().getPackageInfo(AbstractC3251o.f2370a.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean n() {
        boolean z = (AbstractC3251o.f2370a.getResources().getConfiguration().screenLayout & 15) == 4;
        IAlog.e("This device has a tablet resolution? %s", Boolean.valueOf(z));
        return z;
    }

    public static boolean o() {
        TelephonyManager telephonyManager = (TelephonyManager) AbstractC3251o.f2370a.getSystemService("phone");
        return telephonyManager != null && telephonyManager.getSimState() == 5;
    }
}
