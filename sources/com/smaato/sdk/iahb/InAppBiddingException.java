package com.smaato.sdk.iahb;

/* JADX INFO: loaded from: classes9.dex */
public final class InAppBiddingException extends Exception {
    private final InApBiddingError reason;

    InAppBiddingException(InApBiddingError inApBiddingError) {
        super(inApBiddingError.description);
        this.reason = inApBiddingError;
    }

    InAppBiddingException(InApBiddingError inApBiddingError, Throwable th) {
        super(th);
        this.reason = inApBiddingError;
    }

    public InApBiddingError getReason() {
        return this.reason;
    }

    public enum InApBiddingError {
        NOT_INITIALISED("The module is not initialised. Forgot to call SmaatoSdk.init()?"),
        INVALID_JSON("An invalid JSON was provided inside of InAppBid object."),
        INTERNAL_ERROR("An internal error happened.");

        private final String description;

        InApBiddingError(String str) {
            this.description = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "InApBiddingError{description='" + this.description + "'}";
        }
    }
}
