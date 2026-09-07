package com.smaato.sdk.iahb;

import com.smaato.sdk.core.AndroidsInjector;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.Either;
import com.smaato.sdk.core.util.diinjection.Inject;
import com.smaato.sdk.core.util.fi.Consumer;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes9.dex */
public final class SmaatoSdkInAppBidding {

    @Inject
    private static IahbInteractor iahbInteractor;

    @Inject
    private static Logger logger;

    public static String saveBid(InAppBid inAppBid) throws InAppBiddingException {
        if (inAppBid == null) {
            throw new NullPointerException("'inAppBid' specified as non-null is null");
        }
        final AtomicReference atomicReference = new AtomicReference();
        if (iahbInteractor == null || logger == null) {
            AndroidsInjector.injectStatic(SmaatoSdkInAppBidding.class);
        }
        IahbInteractor iahbInteractor2 = iahbInteractor;
        if (iahbInteractor2 == null) {
            Logger logger2 = logger;
            if (logger2 != null) {
                logger2.error(LogDomain.INAPP_BIDDING, "InAppBidding module was not initialized", new Object[0]);
            }
            atomicReference.set(Either.right(new InAppBiddingException(InAppBiddingException.InApBiddingError.NOT_INITIALISED)));
        } else {
            iahbInteractor2.saveBid(inAppBid, new Consumer() { // from class: com.smaato.sdk.iahb.SmaatoSdkInAppBidding$$ExternalSyntheticLambda0
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    atomicReference.set(Either.left((String) obj));
                }
            }, new Consumer() { // from class: com.smaato.sdk.iahb.SmaatoSdkInAppBidding$$ExternalSyntheticLambda1
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    atomicReference.set(Either.right((InAppBiddingException) obj));
                }
            });
        }
        String str = (String) ((Either) atomicReference.get()).left();
        if (str != null) {
            return str;
        }
        InAppBiddingException inAppBiddingException = (InAppBiddingException) ((Either) atomicReference.get()).right();
        if (inAppBiddingException != null) {
            throw inAppBiddingException;
        }
        throw new InAppBiddingException(InAppBiddingException.InApBiddingError.INTERNAL_ERROR);
    }
}
