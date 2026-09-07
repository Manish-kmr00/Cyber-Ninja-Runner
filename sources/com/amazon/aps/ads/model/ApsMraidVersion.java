package com.amazon.aps.ads.model;

import com.smaato.sdk.richmedia.mraid.dataprovider.MraidEnvironmentProperties;

/* JADX INFO: loaded from: classes8.dex */
public enum ApsMraidVersion {
    MRAID_V1("1.0"),
    MRAID_V2("2.0"),
    MRAID_V3(MraidEnvironmentProperties.VERSION);

    private String version;

    ApsMraidVersion(String str) {
        this.version = str;
    }

    public String getString() {
        return this.version;
    }
}
