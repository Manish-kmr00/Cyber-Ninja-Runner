package com.bytedance.sdk.component.adexpress.theme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes7.dex */
public class ThemeStatusBroadcastReceiver extends BroadcastReceiver {
    private WeakReference<pA> pA;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("theme_status_change", 0);
        WeakReference<pA> weakReference = this.pA;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.pA.get().onThemeChanged(intExtra);
    }

    public void pA(pA pAVar) {
        this.pA = new WeakReference<>(pAVar);
    }
}
