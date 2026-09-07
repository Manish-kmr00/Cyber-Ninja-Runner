package com.google.unity.ads;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* JADX INFO: loaded from: classes3.dex */
public final class UnityApplicationPreferences {
    private final SharedPreferences defaultSharedPreferences;

    public UnityApplicationPreferences(final Activity activity) {
        this.defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity);
    }

    public void setInt(String key, int value) {
        SharedPreferences.Editor editorEdit = this.defaultSharedPreferences.edit();
        editorEdit.putInt(key, value);
        editorEdit.apply();
    }

    public void setString(String key, String value) {
        SharedPreferences.Editor editorEdit = this.defaultSharedPreferences.edit();
        editorEdit.putString(key, value);
        editorEdit.apply();
    }

    public int getInt(String key) {
        return this.defaultSharedPreferences.getInt(key, 0);
    }

    public String getString(String key) {
        return this.defaultSharedPreferences.getString(key, null);
    }
}
