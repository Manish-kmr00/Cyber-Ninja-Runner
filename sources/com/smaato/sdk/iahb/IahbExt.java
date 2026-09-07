package com.smaato.sdk.iahb;

import com.smaato.sdk.core.api.ImpressionCountingType;

/* JADX INFO: loaded from: classes11.dex */
public abstract class IahbExt {
    abstract String adspaceid();

    abstract String adtype();

    abstract long expiresAt();

    abstract ImpressionCountingType impressionMeasurement();

    static Builder builder() {
        return new AutoValue_IahbExt.Builder().impressionMeasurement(ImpressionCountingType.STANDARD);
    }

    static abstract class Builder {
        abstract Builder adspaceid(String str);

        abstract Builder adtype(String str);

        abstract IahbExt autoBuild();

        abstract Builder expiresAt(long j);

        abstract Builder impressionMeasurement(ImpressionCountingType impressionCountingType);

        Builder() {
        }

        IahbExt build() {
            try {
                return autoBuild();
            } catch (IllegalStateException unused) {
                return null;
            }
        }
    }
}
