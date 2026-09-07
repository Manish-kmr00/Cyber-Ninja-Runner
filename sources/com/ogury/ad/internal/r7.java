package com.ogury.ad.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Process;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class r7 {
    public static final boolean a(Context context) {
        String str;
        Intrinsics.checkNotNullParameter(context, "<this>");
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
            int iMyPid = Process.myPid();
            Object systemService = context.getSystemService("activity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) systemService).getRunningAppProcesses().iterator();
            while (true) {
                if (!it.hasNext()) {
                    str = null;
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.pid == iMyPid) {
                    str = next.processName;
                    break;
                }
            }
            String str2 = packageInfo.applicationInfo.processName;
            if (str == null) {
                return true;
            }
            return Intrinsics.areEqual(str, str2);
        } catch (Exception unused) {
            return true;
        }
    }
}
