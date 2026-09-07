package com.smaato.sdk.core.locationaware;

import android.content.Context;
import android.provider.Settings;

/* JADX INFO: loaded from: classes12.dex */
public class TzSettingsImpl implements TzSettings {
    private final Context context;

    TzSettingsImpl(Context context) {
        this.context = context;
    }

    @Override // com.smaato.sdk.core.locationaware.TzSettings
    public boolean isAutoTimeZoneEnabled() {
        return Settings.Global.getInt(this.context.getContentResolver(), "auto_time_zone", 0) > 0;
    }
}
