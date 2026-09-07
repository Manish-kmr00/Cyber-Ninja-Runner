package com.pubmatic.sdk.common.models;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.pubmatic.sdk.common.log.POBLog;

/* JADX INFO: loaded from: classes7.dex */
public class POBAppInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f7575a;
    private String b;
    private String c;

    public POBAppInfo(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            this.f7575a = packageInfo.applicationInfo.loadLabel(packageManager).toString();
            this.b = context.getPackageName();
            this.c = packageInfo.versionName;
        } catch (Exception e) {
            POBLog.error("POBAppInfo", "Failed to retrieve app info: %s", e.getLocalizedMessage());
        }
    }

    public String getAppName() {
        return this.f7575a;
    }

    public String getAppVersion() {
        return this.c;
    }

    public String getPackageName() {
        return this.b;
    }
}
