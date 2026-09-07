package com.pubmatic.sdk.openwrap.core;

/* JADX INFO: loaded from: classes5.dex */
public interface POBBidEvent {

    public enum BidEventError {
        CLIENT_SIDE_AUCTION_LOSS("BidEventErrorClientSideAuctionLoss"),
        BID_EXPIRED("BidEventErrorBidExpired"),
        OTHER("BidEventErrorOther");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f7726a;

        BidEventError(String str) {
            this.f7726a = str;
        }

        public String getErrorMessage() {
            return this.f7726a;
        }
    }

    POBBid getBid();

    void proceedOnError(BidEventError bidEventError, String str);

    boolean proceedToLoadAd();

    void setBidEventListener(POBBidEventListener pOBBidEventListener);
}
