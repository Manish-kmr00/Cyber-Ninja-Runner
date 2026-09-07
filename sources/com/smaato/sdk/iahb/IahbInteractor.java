package com.smaato.sdk.iahb;

import android.util.JsonReader;
import com.smaato.sdk.core.ad.AdFormat;
import com.smaato.sdk.core.api.ExpirationTimestampFactory;
import com.smaato.sdk.core.api.ImpressionCountingType;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.ub.AdMarkup;
import com.smaato.sdk.core.ub.UbCache;
import com.smaato.sdk.core.ub.UbId;
import com.smaato.sdk.core.util.HeaderValueUtils;
import com.smaato.sdk.core.util.fi.Consumer;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes11.dex */
final class IahbInteractor {
    private final ExpirationTimestampFactory expirationTimestampFactory;
    private final HeaderValueUtils headerValueUtils;
    private final IahbJsonAdapter iahbJsonAdapter;
    private final Logger logger;
    private final UbCache ubCache;

    IahbInteractor(UbCache ubCache, IahbJsonAdapter iahbJsonAdapter, ExpirationTimestampFactory expirationTimestampFactory, HeaderValueUtils headerValueUtils, Logger logger) {
        this.ubCache = ubCache;
        this.iahbJsonAdapter = iahbJsonAdapter;
        this.expirationTimestampFactory = expirationTimestampFactory;
        this.headerValueUtils = headerValueUtils;
        this.logger = logger;
    }

    void saveBid(InAppBid inAppBid, Consumer consumer, Consumer consumer2) {
        if (inAppBid == null) {
            throw new NullPointerException("'inAppBid' specified as non-null is null");
        }
        if (consumer == null) {
            throw new NullPointerException("'onSaved' specified as non-null is null");
        }
        if (consumer2 == null) {
            throw new NullPointerException("'onFailedToSave' specified as non-null is null");
        }
        try {
            consumer.accept(saveAdMarkup(inAppBid.getJson()).toString());
        } catch (Exception e) {
            InAppBiddingException inAppBiddingExceptionCreateInAppBiddingException = createInAppBiddingException(e);
            logException(inAppBiddingExceptionCreateInAppBiddingException);
            consumer2.accept(inAppBiddingExceptionCreateInAppBiddingException);
        }
    }

    private UbId saveAdMarkup(String str) throws InAppBiddingException {
        if (str == null) {
            throw new NullPointerException("'json' specified as non-null is null");
        }
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new ByteArrayInputStream(str.getBytes()));
            try {
                IahbResponse iahbResponseFromJson = this.iahbJsonAdapter.fromJson(new JsonReader(inputStreamReader));
                String strBidId = iahbResponseFromJson.bidId();
                IahbBid iahbBidBid = iahbResponseFromJson.bid();
                UbId ubIdPut = this.ubCache.put(createAdMarkup(strBidId, iahbBidBid, getAdFormat(iahbBidBid)));
                inputStreamReader.close();
                return ubIdPut;
            } catch (Throwable th) {
                try {
                    inputStreamReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (InAppBiddingException | IOException e) {
            throw new InAppBiddingException(InAppBiddingException.InApBiddingError.INVALID_JSON, e);
        }
    }

    private AdMarkup createAdMarkup(String str, IahbBid iahbBid, AdFormat adFormat) {
        return AdMarkup.builder().markup(iahbBid.adm()).adFormat(adFormat.toString()).impressionCountingType(iahbBid.ext().impressionMeasurement() != null ? iahbBid.ext().impressionMeasurement() : ImpressionCountingType.STANDARD).expiresAt(this.expirationTimestampFactory.createExpirationTimestampFor(iahbBid.ext().expiresAt(), null)).sessionId(str).bundleId(iahbBid.bundleId()).adSpaceId(iahbBid.ext().adspaceid()).build();
    }

    private AdFormat getAdFormat(IahbBid iahbBid) throws InAppBiddingException {
        AdFormat adFormatForAdFormatHeaderField = this.headerValueUtils.getAdFormatForAdFormatHeaderField(iahbBid.ext().adtype());
        if (adFormatForAdFormatHeaderField != null) {
            return adFormatForAdFormatHeaderField;
        }
        throw new InAppBiddingException(InAppBiddingException.InApBiddingError.INVALID_JSON, new Exception("Invalid Ad Type: " + iahbBid.ext().adtype()));
    }

    private void logException(InAppBiddingException inAppBiddingException) {
        if (inAppBiddingException.getMessage() != null) {
            this.logger.error(LogDomain.INAPP_BIDDING, inAppBiddingException.getMessage(), new Object[0]);
        } else {
            this.logger.error(LogDomain.INAPP_BIDDING, "Error saving bid", new Object[0]);
        }
    }

    private InAppBiddingException createInAppBiddingException(Exception exc) {
        return exc instanceof InAppBiddingException ? (InAppBiddingException) exc : new InAppBiddingException(InAppBiddingException.InApBiddingError.INTERNAL_ERROR, exc);
    }
}
