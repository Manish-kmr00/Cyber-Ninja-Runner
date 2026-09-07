package com.smaato.sdk.core.ub;

import com.smaato.sdk.core.ad.Expiration;
import com.smaato.sdk.core.api.ImpressionCountingType;

/* JADX INFO: loaded from: classes8.dex */
public abstract class AdMarkup {

    public static abstract class Builder {
        public abstract Builder adFormat(String str);

        public abstract Builder adSpaceId(String str);

        public abstract AdMarkup build();

        public abstract Builder bundleId(String str);

        public abstract Builder creativeId(String str);

        public abstract Builder expiresAt(Expiration expiration);

        public abstract Builder impressionCountingType(ImpressionCountingType impressionCountingType);

        public abstract Builder markup(String str);

        public abstract Builder sessionId(String str);
    }

    public abstract String adFormat();

    public abstract String adSpaceId();

    public abstract String bundleId();

    public abstract String creativeId();

    public abstract Expiration expiresAt();

    public abstract ImpressionCountingType impressionCountingType();

    public abstract String markup();

    public abstract String sessionId();

    AdMarkup() {
    }

    public static Builder builder() {
        return new AutoValue_AdMarkup.Builder().impressionCountingType(ImpressionCountingType.STANDARD);
    }
}
