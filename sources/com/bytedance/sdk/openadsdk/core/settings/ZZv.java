package com.bytedance.sdk.openadsdk.core.settings;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.OnSuccessListener;

/* JADX INFO: loaded from: classes7.dex */
public class ZZv {
    private static String KZx = null;
    private static volatile String Og = "";
    private static volatile int ZZv = 0;
    private static volatile String pA = "";

    public static void pA() {
        try {
            AppSet.getClient(aBv.pA()).getAppSetIdInfo().addOnSuccessListener(new OnSuccessListener<AppSetIdInfo>() { // from class: com.bytedance.sdk.openadsdk.core.settings.AppSetIdAndScope$1
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public void onSuccess(AppSetIdInfo appSetIdInfo) {
                    String unused = ZZv.pA = Integer.toString(appSetIdInfo.getScope());
                    String unused2 = ZZv.Og = appSetIdInfo.getId();
                    int unused3 = ZZv.ZZv = 1;
                }
            });
        } catch (Throwable unused) {
            ZZv = 2;
        }
    }

    public static String Og() {
        if (ZZv != 0) {
            return pA;
        }
        pA();
        return pA;
    }

    public static String KZx() {
        if (ZZv != 0) {
            return Og;
        }
        pA();
        return Og;
    }

    public static String ZZv() {
        if (TextUtils.isEmpty(KZx)) {
            KZx = aBv.pA().getPackageManager().getInstallerPackageName(gbA.ML());
        }
        if (KZx == null) {
            KZx = "";
        }
        return KZx;
    }
}
