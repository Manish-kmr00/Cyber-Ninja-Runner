package com.smaato.sdk.video.vast.model;

/* JADX INFO: loaded from: classes12.dex */
public class Advertiser {
    public static final String ID = "id";
    public static final String NAME = "Advertiser";
    public final String id;
    public final String name;

    Advertiser(String str, String str2) {
        this.id = str;
        this.name = str2;
    }

    public static class Builder {
        private String id;
        private String name;

        public Builder setId(String str) {
            this.id = str;
            return this;
        }

        public Builder setName(String str) {
            this.name = str;
            return this;
        }

        public Advertiser build() {
            return new Advertiser(this.id, this.name);
        }
    }
}
