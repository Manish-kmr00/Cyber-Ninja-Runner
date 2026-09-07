package com.five_corp.ad.internal.tracking_data;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;

/* JADX INFO: loaded from: classes11.dex */
public final class e implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f1554a = new Object();
    public final Context b;

    public e(Context context, d dVar) {
        this.b = context;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str == null || "IABTCF_TCString".equals(str) || "IABTCF_gdprApplies".equals(str)) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.b);
            if (defaultSharedPreferences.contains("IABTCF_TCString")) {
                defaultSharedPreferences.getString("IABTCF_TCString", "");
            }
            if (defaultSharedPreferences.contains("IABTCF_gdprApplies")) {
                defaultSharedPreferences.getInt("IABTCF_gdprApplies", 0);
            }
            synchronized (this.f1554a) {
            }
        }
    }
}
