package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public class oX {
    /* JADX WARN: Code duplicated, block: B:41:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:44:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static void pA() {
        Context contextPA = com.bytedance.sdk.openadsdk.core.aBv.pA();
        if (contextPA != null && com.bytedance.sdk.component.utils.WV.ZZv()) {
            com.bytedance.sdk.component.utils.WV.pA("TTAdSdk-InitChecker", "The pangolin sdk access, the environment is debug, the initial configuration detection starts");
            String packageName = contextPA.getPackageName();
            int i = contextPA.getApplicationInfo().targetSdkVersion;
            boolean z = true;
            try {
                String[] strArr = contextPA.getPackageManager().getPackageInfo(packageName, 4096).requestedPermissions;
                if (strArr != null && strArr.length > 0) {
                    List<String> listOg = Og();
                    for (String str : strArr) {
                        if (str != null) {
                            listOg.remove(str);
                        }
                    }
                    if (listOg.isEmpty()) {
                        com.bytedance.sdk.component.utils.WV.pA("TTAdSdk-InitChecker", "AndroidManifest.xml permissions configuration is normal");
                    } else {
                        Iterator<String> it = listOg.iterator();
                        while (it.hasNext()) {
                            try {
                                com.bytedance.sdk.component.utils.WV.pA("TTAdSdk-InitChecker", "    May be missing permissions：" + it.next() + "，Please refer to the access documentation");
                                z = false;
                            } catch (Throwable th) {
                                th = th;
                                z = false;
                                com.bytedance.sdk.component.utils.WV.pA("TTAdSdk-InitChecker", "The usage-permission configuration error in AndroidManifest.xml, please refer to the access documentation", th);
                                if (i < 23) {
                                    try {
                                        com.bytedance.sdk.component.utils.WV.pA("TTAdSdk-InitChecker", "No adaptation required for dynamic permissions：target=" + i + "&phone=" + Build.VERSION.SDK_INT + ", require=23");
                                    } catch (Throwable th2) {
                                        com.bytedance.sdk.component.utils.WV.pA("TTAdSdk-InitChecker", "The dynamic permission is abnormal. Please check and read the access document in detail： ", th2);
                                    }
                                }
                                if (!z) {
                                    com.bytedance.sdk.component.utils.WV.pA("TTAdSdk-InitChecker", "You have not configured permission, please refer to the access documentation, otherwise it will affect the conversion");
                                }
                                com.bytedance.sdk.component.utils.WV.pA("TTAdSdk-InitChecker", "End of pangolin sdk initial configuration test");
                            }
                        }
                    }
                } else {
                    com.bytedance.sdk.component.utils.WV.pA("TTAdSdk-InitChecker", "The uses-permission configuration in AndroidManifest.xml is missing, please refer to the access documentation");
                }
            } catch (Throwable th3) {
                th = th3;
            }
            if (i < 23) {
                com.bytedance.sdk.component.utils.WV.pA("TTAdSdk-InitChecker", "No adaptation required for dynamic permissions：target=" + i + "&phone=" + Build.VERSION.SDK_INT + ", require=23");
            }
            if (!z) {
                com.bytedance.sdk.component.utils.WV.pA("TTAdSdk-InitChecker", "You have not configured permission, please refer to the access documentation, otherwise it will affect the conversion");
            }
            com.bytedance.sdk.component.utils.WV.pA("TTAdSdk-InitChecker", "End of pangolin sdk initial configuration test");
        }
    }

    private static List<String> Og() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.INTERNET");
        arrayList.add("android.permission.ACCESS_NETWORK_STATE");
        arrayList.add("android.permission.WAKE_LOCK");
        return arrayList;
    }
}
