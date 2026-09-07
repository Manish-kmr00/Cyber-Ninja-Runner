package com.iab.omid.library.ogury.utils;

import android.app.UiModeManager;
import android.content.Context;
import com.iab.omid.library.ogury.adsession.DeviceCategory;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static UiModeManager f2816a;

    public static DeviceCategory a() {
        int currentModeType = f2816a.getCurrentModeType();
        if (currentModeType != 1) {
            return currentModeType != 4 ? DeviceCategory.OTHER : DeviceCategory.CTV;
        }
        return DeviceCategory.MOBILE;
    }

    public static void a(Context context) {
        if (context != null) {
            f2816a = (UiModeManager) context.getSystemService("uimode");
        }
    }
}
