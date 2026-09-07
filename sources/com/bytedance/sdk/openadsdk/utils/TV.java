package com.bytedance.sdk.openadsdk.utils;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes6.dex */
public class TV {
    public static boolean pA = pA();

    private static boolean pA() {
        SharedPreferences sharedPreferences;
        try {
            return com.bytedance.sdk.openadsdk.core.aBv.pA() == null || (sharedPreferences = com.bytedance.sdk.openadsdk.core.aBv.pA().getSharedPreferences("pag_sp_prop_switch", 0)) == null || sharedPreferences.getInt("perf_con_use_prop", 1) == 1;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.Og(th.getMessage());
        }
        return true;
    }

    public static void pA(int i) {
        try {
            SharedPreferences.Editor editorEdit = com.bytedance.sdk.openadsdk.core.aBv.pA().getSharedPreferences("pag_sp_prop_switch", 0).edit();
            editorEdit.putInt("perf_con_use_prop", i);
            editorEdit.apply();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.Og(th.getMessage());
        }
    }
}
