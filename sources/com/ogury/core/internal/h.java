package com.ogury.core.internal;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OguryTokenManager.kt */
/* JADX INFO: loaded from: classes12.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f7491a;

    public h(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f7491a = context.getSharedPreferences("ogury_core_token_file", 0);
    }

    public final String a(String keyName) {
        Intrinsics.checkNotNullParameter(keyName, "keyName");
        String string = this.f7491a.getString(keyName, null);
        if (string != null && string.length() != 0) {
            return string;
        }
        String keyValue = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(keyValue, "toString(...)");
        Intrinsics.checkNotNullParameter(keyName, "keyName");
        Intrinsics.checkNotNullParameter(keyValue, "keyValue");
        this.f7491a.edit().putString(keyName, keyValue).apply();
        return keyValue;
    }
}
