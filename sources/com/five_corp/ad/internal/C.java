package com.five_corp.ad.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;

/* JADX INFO: loaded from: classes11.dex */
public final class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1263a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    public C(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f1263a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
    }

    public static C a(Context context) {
        String packageName;
        TelephonyManager telephonyManager;
        String simOperatorName = "";
        String str = "0";
        try {
            packageName = context.getPackageName();
            try {
                PackageManager packageManager = context.getPackageManager();
                try {
                    str = com.five_corp.ad.internal.system.i.a(context, packageName).versionName;
                } catch (PackageManager.NameNotFoundException unused) {
                }
                if (packageManager.checkPermission("android.permission.READ_PHONE_STATE", packageName) == 0 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                    simOperatorName = telephonyManager.getSimOperatorName();
                }
            } catch (Exception unused2) {
            }
        } catch (Exception unused3) {
            packageName = "";
        }
        return new C(Build.VERSION.RELEASE, Build.MODEL, Build.MANUFACTURER, simOperatorName, packageName, str);
    }
}
