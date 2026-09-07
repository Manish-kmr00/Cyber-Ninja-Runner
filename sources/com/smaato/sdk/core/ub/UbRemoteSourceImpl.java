package com.smaato.sdk.core.ub;

import com.smaato.sdk.core.SmaatoSdk;
import com.smaato.sdk.core.ad.AdFormat;
import com.smaato.sdk.core.errorreport.ErrorReporter;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.mvvm.model.AdResponse;
import com.smaato.sdk.core.mvvm.model.AdResponseParser;
import com.smaato.sdk.core.mvvm.model.ub.UbRemoteSource;
import com.smaato.sdk.core.network.SomaException;
import com.smaato.sdk.core.ub.cacheerror.UbCacheError;
import com.smaato.sdk.core.ub.cacheerror.UbCacheErrorReportFactory;
import com.smaato.sdk.core.ub.cacheerror.UbCacheErrorReportingParams;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class UbRemoteSourceImpl implements UbRemoteSource {
    Map<AdFormat, AdResponseParser> adResponseParsers = new HashMap();
    private final ErrorReporter errorReporter;
    private final Logger logger;
    private final UbCache ubCache;
    private final UbCacheErrorReportFactory ubCacheErrorReportFactory;

    public UbRemoteSourceImpl(UbCache ubCache, ErrorReporter errorReporter, UbCacheErrorReportFactory ubCacheErrorReportFactory, Logger logger) {
        this.ubCache = ubCache;
        this.errorReporter = errorReporter;
        this.ubCacheErrorReportFactory = ubCacheErrorReportFactory;
        this.logger = logger;
    }

    @Override // com.smaato.sdk.core.mvvm.model.ub.UbRemoteSource
    public void setAdResponseParsers(Map<AdFormat, AdResponseParser> map) {
        this.adResponseParsers = map;
        this.logger.debug(LogDomain.UNIFIED_BIDDING, "Received adResponseParsers: " + map, new Object[0]);
    }

    @Override // com.smaato.sdk.core.mvvm.model.ub.UbRemoteSource
    public boolean isUbRequest(String str, String str2) {
        return UbId.create(str, str2) != null;
    }

    @Override // com.smaato.sdk.core.mvvm.model.ub.UbRemoteSource
    public AdResponse loadAd(String str, String str2) throws IOException {
        String publisherId = SmaatoSdk.getPublisherId();
        UbId ubIdCreate = UbId.create(str, str2);
        if (ubIdCreate == null) {
            this.logger.error(LogDomain.UNIFIED_BIDDING, "Invalid UB request, adSpaceId = " + str + " id = " + str2, new Object[0]);
            reportNoAdUbError(str, publisherId);
            throw new SomaException(SomaException.Type.NO_CONTENT, "Invalid UB request, adSpaceId = " + str + " id = " + str2);
        }
        AdMarkup adMarkup = this.ubCache.get(ubIdCreate);
        if (adMarkup == null) {
            this.logger.error(LogDomain.UNIFIED_BIDDING, "No ad markup found for ubId: " + ubIdCreate, new Object[0]);
            reportNoAdUbError(str, publisherId);
            throw new SomaException(SomaException.Type.NO_CONTENT, "Cached Ad Response not found.");
        }
        if (adMarkup.expiresAt().isExpired()) {
            this.errorReporter.report(this.ubCacheErrorReportFactory.create(UbCacheError.TTL_EXPIRED, UbCacheErrorReportingParams.builder().setAdSpaceId(str).setPublisherId(publisherId).setSessionId(adMarkup.sessionId()).build()));
            throw new SomaException(SomaException.Type.CREATIVE_EXPIRED, "Cached Ad Response expired.");
        }
        AdFormat adFormatConvertFromUnifiedBiddingFormat = convertFromUnifiedBiddingFormat(adMarkup.adFormat());
        AdResponseParser adResponseParser = this.adResponseParsers.get(adFormatConvertFromUnifiedBiddingFormat);
        if (adResponseParser == null) {
            Logger logger = this.logger;
            LogDomain logDomain = LogDomain.UNIFIED_BIDDING;
            logger.error(logDomain, "Illegal ad format: " + adFormatConvertFromUnifiedBiddingFormat, new Object[0]);
            this.logger.error(logDomain, "Supported ad formats: " + this.adResponseParsers, new Object[0]);
            throw new SomaException(SomaException.Type.BAD_RESPONSE, "Illegal ad format: " + adFormatConvertFromUnifiedBiddingFormat);
        }
        return adResponseParser.parseUbBid(adMarkup.sessionId(), adMarkup.impressionCountingType(), adMarkup.expiresAt(), adMarkup.markup(), adMarkup.creativeId(), adMarkup.bundleId());
    }

    private AdFormat convertFromUnifiedBiddingFormat(String str) {
        return AdFormat.valueOf(str);
    }

    private void reportNoAdUbError(String str, String str2) {
        this.errorReporter.report(this.ubCacheErrorReportFactory.create(UbCacheError.NO_AD, UbCacheErrorReportingParams.builder().setAdSpaceId(str).setPublisherId(str2).build()));
    }
}
