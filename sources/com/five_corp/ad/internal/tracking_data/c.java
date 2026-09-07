package com.five_corp.ad.internal.tracking_data;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;
import java.util.UUID;

/* JADX INFO: loaded from: classes11.dex */
public abstract class c {
    public static String a(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        try {
            String string = defaultSharedPreferences.getString("com.five_corp.ad.user.id", null);
            if (string != null) {
                return string;
            }
        } catch (ClassCastException unused) {
        }
        String string2 = UUID.randomUUID().toString();
        SharedPreferences.Editor editorEdit = defaultSharedPreferences.edit();
        editorEdit.putString("com.five_corp.ad.user.id", string2);
        editorEdit.apply();
        return string2;
    }
}
