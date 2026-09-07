package com.smaato.sdk.core.ub;

import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.fi.Predicate;

/* JADX INFO: loaded from: classes.dex */
public final class UbCache {
    private final AdCache adCache;
    private final Logger logger;

    static /* synthetic */ boolean lambda$put$0(AdMarkup adMarkup) {
        return true;
    }

    public UbCache(AdCache<AdMarkup> adCache, Logger logger) {
        this.adCache = adCache;
        this.logger = logger;
    }

    public UbId put(AdMarkup adMarkup) {
        this.logger.debug(LogDomain.UNIFIED_BIDDING, "Saving an ad: adFormat = \"%1$s\", adSpaceId = \"%2$s\", sessionId = \"%3$s\"", adMarkup.adFormat(), adMarkup.adSpaceId(), adMarkup.sessionId());
        while (!this.adCache.put(adMarkup.adSpaceId(), adMarkup)) {
            AdMarkup adMarkup2 = (AdMarkup) this.adCache.getAndRemove(adMarkup.adSpaceId(), new Predicate() { // from class: com.smaato.sdk.core.ub.UbCache$$ExternalSyntheticLambda0
                @Override // com.smaato.sdk.core.util.fi.Predicate
                public final boolean test(Object obj) {
                    return UbCache.lambda$put$0((AdMarkup) obj);
                }
            });
            if (adMarkup2 != null) {
                this.logger.info(LogDomain.UNIFIED_BIDDING, "Removed an ad: adFormat = \"%1$s\", adSpaceId = \"%2$s\", sessionId = \"%3$s\"", adMarkup2.adFormat(), adMarkup2.adSpaceId(), adMarkup2.sessionId());
            }
        }
        this.logger.info(LogDomain.UNIFIED_BIDDING, "Successfully saved an ad: adFormat = \"%1$s\", adSpaceId = \"%2$s\", sessionId = \"%3$s\"", adMarkup.adFormat(), adMarkup.adSpaceId(), adMarkup.sessionId());
        return UbId.builder().sessionId(adMarkup.sessionId()).adSpaceId(adMarkup.adSpaceId()).build();
    }

    public AdMarkup get(final UbId ubId) {
        AdMarkup adMarkup = (AdMarkup) this.adCache.getAndRemove(ubId.adSpaceId(), new Predicate() { // from class: com.smaato.sdk.core.ub.UbCache$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Predicate
            public final boolean test(Object obj) {
                return ((AdMarkup) obj).sessionId().equals(ubId.sessionId());
            }
        });
        this.logger.info(LogDomain.UNIFIED_BIDDING, "Found %s for uuId %s", adMarkup, ubId);
        return adMarkup;
    }
}
