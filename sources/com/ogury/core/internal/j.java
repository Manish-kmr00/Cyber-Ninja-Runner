package com.ogury.core.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SharedPreferencesHandler.kt */
/* JADX INFO: loaded from: classes12.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f7492a;

    public j(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        PreferenceManager.getDefaultSharedPreferences(context);
        this.f7492a = context.getSharedPreferences("ogury_privacy_data", 0);
    }

    public final void a(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        if (StringsKt.isBlank(key)) {
            throw new IllegalArgumentException("Key cannot be blank".toString());
        }
        SharedPreferences.Editor editorEdit = this.f7492a.edit();
        if (value instanceof Boolean) {
            editorEdit.putBoolean(key + "_bool", ((Boolean) value).booleanValue());
        } else if (value instanceof String) {
            editorEdit.putString(key + "_string", (String) value);
        } else {
            if (!(value instanceof Integer)) {
                throw new IllegalArgumentException("Unsupported data type");
            }
            editorEdit.putInt(key + "_int", ((Number) value).intValue());
        }
        editorEdit.apply();
    }
}
