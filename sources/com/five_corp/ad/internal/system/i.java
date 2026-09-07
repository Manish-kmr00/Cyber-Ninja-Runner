package com.five_corp.ad.internal.system;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

/* JADX INFO: loaded from: classes12.dex */
public abstract class i {
    public static PackageInfo a(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        return Build.VERSION.SDK_INT < 33 ? packageManager.getPackageInfo(str, 128) : packageManager.getPackageInfo(str, PackageManager.PackageInfoFlags.of(128L));
    }
}
