package com.smaato.sdk.video.vast.model;

/* JADX INFO: loaded from: classes9.dex */
public class AdSystem {
    public static final String NAME = "AdSystem";
    public static final String VERSION = "version";
    public final String adServerName;
    public final String version;

    AdSystem(String str, String str2) {
        this.adServerName = str;
        this.version = str2;
    }

    public static class Builder {
        private String adServerName;
        private String version;

        public Builder setServerName(String str) {
            this.adServerName = str;
            return this;
        }

        public Builder setVersion(String str) {
            this.version = str;
            return this;
        }

        public AdSystem build() {
            return new AdSystem(this.adServerName, this.version);
        }
    }
}
