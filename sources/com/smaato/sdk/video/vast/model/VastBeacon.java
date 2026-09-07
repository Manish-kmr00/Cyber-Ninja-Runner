package com.smaato.sdk.video.vast.model;

import com.smaato.sdk.video.vast.exceptions.VastElementMissingException;
import com.smaato.sdk.video.vast.utils.VastModels;

/* JADX INFO: loaded from: classes2.dex */
public class VastBeacon {
    public static final String ID = "id";
    public final String id;
    public final String uri;

    VastBeacon(String str, String str2) {
        this.uri = str;
        this.id = str2;
    }

    public static class Builder {
        private String id;
        private String uri;

        public Builder setId(String str) {
            this.id = str;
            return this;
        }

        public Builder setUri(String str) {
            this.uri = str;
            return this;
        }

        public VastBeacon build() throws VastElementMissingException {
            VastModels.requireNonNull(this.uri, "Cannot build VastBeacon: uri is missing");
            return new VastBeacon(this.uri, this.id);
        }
    }
}
