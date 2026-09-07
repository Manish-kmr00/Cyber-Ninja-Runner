package com.smaato.sdk.video.vast.model;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes8.dex */
public class UniversalAdId {
    public static final UniversalAdId DEFAULT = new UniversalAdId("unknown", "unknown", "unknown");
    static final String DEFAULT_VALUE = "unknown";
    public static final String ID_REGISTRY = "idRegistry";
    public static final String ID_VALUE = "idValue";
    public static final String NAME = "UniversalAdId";
    public final String idRegistry;
    public final String idValue;
    public final String value;

    public UniversalAdId(String str, String str2, String str3) {
        this.idRegistry = str;
        this.idValue = str2;
        this.value = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UniversalAdId universalAdId = (UniversalAdId) obj;
        if (this.idRegistry.equals(universalAdId.idRegistry) && this.idValue.equals(universalAdId.idValue)) {
            return this.value.equals(universalAdId.value);
        }
        return false;
    }

    public int hashCode() {
        return (((this.idRegistry.hashCode() * 31) + this.idValue.hashCode()) * 31) + this.value.hashCode();
    }

    public static class Builder {
        private String idRegistry;
        private String idValue;
        private String value;

        public Builder setIdRegistry(String str) {
            this.idRegistry = str;
            return this;
        }

        public Builder setIdValue(String str) {
            this.idValue = str;
            return this;
        }

        public Builder setValue(String str) {
            this.value = str;
            return this;
        }

        public UniversalAdId build() {
            if (TextUtils.isEmpty(this.value) && TextUtils.isEmpty(this.idValue) && TextUtils.isEmpty(this.idRegistry)) {
                return UniversalAdId.DEFAULT;
            }
            if (TextUtils.isEmpty(this.idRegistry)) {
                this.idRegistry = "unknown";
            }
            if (TextUtils.isEmpty(this.idValue)) {
                this.idValue = "unknown";
            }
            if (TextUtils.isEmpty(this.value)) {
                this.value = "unknown";
            }
            return new UniversalAdId(this.idRegistry, this.idValue, this.value);
        }
    }
}
