package com.smaato.sdk.iahb;

import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;

/* JADX INFO: loaded from: classes9.dex */
public abstract class IahbBid {
    abstract String adm();

    abstract String bundleId();

    abstract IahbExt ext();

    static Builder builder() {
        return new AutoValue_IahbBid.Builder();
    }

    static abstract class Builder {
        abstract Builder adm(String str);

        abstract IahbBid autoBuild();

        abstract Builder bundleId(String str);

        abstract Builder ext(IahbExt iahbExt);

        Builder() {
        }

        IahbBid build(Logger logger) {
            try {
                return autoBuild();
            } catch (IllegalStateException e) {
                if (e.getMessage() != null) {
                    logger.error(LogDomain.INAPP_BIDDING, e.getMessage(), new Object[0]);
                    return null;
                }
                logger.error(LogDomain.INAPP_BIDDING, "Error building IahbBid", new Object[0]);
                return null;
            }
        }
    }
}
