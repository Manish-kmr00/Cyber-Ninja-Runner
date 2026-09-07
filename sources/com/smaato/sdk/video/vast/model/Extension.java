package com.smaato.sdk.video.vast.model;

import com.smaato.sdk.video.vast.utils.VastModels;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class Extension {
    public static final String NAME = "Extension";
    public static final String TYPE = "type";
    public final List<Verification> adVerifications;
    public final String type;

    public Extension(String str, List<Verification> list) {
        this.type = str;
        this.adVerifications = list;
    }

    public static class Builder {
        private List adVerifications;
        private String type;

        public Builder setType(String str) {
            this.type = str;
            return this;
        }

        public Builder setAdVerifications(List<Verification> list) {
            this.adVerifications = list;
            return this;
        }

        public Extension build() {
            List immutableList = VastModels.toImmutableList(this.adVerifications);
            this.adVerifications = immutableList;
            return new Extension(this.type, immutableList);
        }
    }
}
