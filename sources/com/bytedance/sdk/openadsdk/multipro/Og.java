package com.bytedance.sdk.openadsdk.multipro;

import com.bytedance.sdk.openadsdk.core.Sn;
import com.bytedance.sdk.openadsdk.multipro.aidl.BinderPoolService;

/* JADX INFO: loaded from: classes2.dex */
public class Og {
    public static Boolean pA;

    public static void pA() {
        pA = Boolean.TRUE;
        com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA("sp_multi_info", "is_support_multi_process", Boolean.TRUE);
    }

    public static void Og() {
        pA = Boolean.FALSE;
        BinderPoolService.pA = true;
    }

    public static boolean KZx() {
        Boolean bool = pA;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (!Sn.ML()) {
            return false;
        }
        if (pA == null) {
            pA = Boolean.valueOf(com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA("sp_multi_info", "is_support_multi_process", false));
        }
        return pA.booleanValue();
    }
}
