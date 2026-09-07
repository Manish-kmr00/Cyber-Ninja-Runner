package com.bytedance.sdk.openadsdk.oX.KZx;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes13.dex */
public class pA {
    private final SharedPreferences pA;

    public pA(Context context) {
        this.pA = context.getSharedPreferences("pag_monitor_record", 0);
    }

    public long pA() {
        return this.pA.getLong("last_upload_time", 0L);
    }

    public void pA(long j) {
        SharedPreferences.Editor editorEdit = this.pA.edit();
        editorEdit.putLong("last_upload_time", j);
        editorEdit.apply();
    }
}
