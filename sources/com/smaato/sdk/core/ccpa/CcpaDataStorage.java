package com.smaato.sdk.core.ccpa;

import android.content.SharedPreferences;
import com.smaato.sdk.core.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public final class CcpaDataStorage {
    private final SharedPreferences defaultSharedPreferences;

    public CcpaDataStorage(SharedPreferences sharedPreferences) {
        this.defaultSharedPreferences = (SharedPreferences) Objects.requireNonNull(sharedPreferences);
    }

    public String getUsPrivacyString() {
        return this.defaultSharedPreferences.getString("IABUSPrivacy_String", "");
    }
}
