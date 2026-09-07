package com.smaato.sdk.richmedia.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: classes11.dex */
public final class ActivityHelper {
    public boolean isDestroyedOnOrientationChange(Activity activity) {
        try {
            int i = activity.getPackageManager().getActivityInfo(new ComponentName(activity, activity.getClass()), 0).configChanges;
            return (((i & 128) != 0) && ((i & 1024) != 0)) ? false : true;
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }

    public boolean isLockedByUserOrDeveloper(Activity activity) {
        return DeviceUtils.isAutoRotateLocked(activity) || OrientationLockedCompat.isLockedInManifest(activity);
    }
}
