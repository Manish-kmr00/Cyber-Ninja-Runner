package com.pubmatic.sdk.openwrap.core;

import com.pubmatic.sdk.common.POBError;

/* JADX INFO: loaded from: classes9.dex */
public class POBBidEventHelper {

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7727a;

        static {
            int[] iArr = new int[POBBidEvent.BidEventError.values().length];
            f7727a = iArr;
            try {
                iArr[POBBidEvent.BidEventError.CLIENT_SIDE_AUCTION_LOSS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7727a[POBBidEvent.BidEventError.BID_EXPIRED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7727a[POBBidEvent.BidEventError.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static POBError convertToPOBError(POBBidEvent.BidEventError bidEventError) {
        int i = a.f7727a[bidEventError.ordinal()];
        if (i != 1) {
            return i != 2 ? new POBError(1006, bidEventError.getErrorMessage()) : new POBError(1011, bidEventError.getErrorMessage());
        }
        return new POBError(3001, bidEventError.getErrorMessage());
    }
}
