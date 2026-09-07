package com.smaato.sdk.core.gpp;

import android.content.SharedPreferences;
import com.smaato.sdk.core.util.Objects;

/* JADX INFO: loaded from: classes11.dex */
public class SomaGppData {
    private final SharedPreferences defaultSharedPreferences;

    public SomaGppData(SharedPreferences sharedPreferences) {
        this.defaultSharedPreferences = (SharedPreferences) Objects.requireNonNull(sharedPreferences, "defaultSharedPreferences must not be null for Gpp::new");
    }

    public String getGppString() {
        return this.defaultSharedPreferences.getString("IABGPP_HDR_GppString", null);
    }

    public String getGppSid() {
        return this.defaultSharedPreferences.getString("IABGPP_GppSID", null);
    }
}
