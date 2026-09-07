package net.pubnative.lite.sdk;

/* JADX INFO: loaded from: classes10.dex */
public class HyBidError extends Exception {
    private HyBidErrorCode errorCode;

    public HyBidError() {
        this.errorCode = HyBidErrorCode.INTERNAL_ERROR;
    }

    public HyBidError(HyBidErrorCode hyBidErrorCode) {
        super(hyBidErrorCode.getMessage());
        HyBidErrorCode hyBidErrorCode2 = HyBidErrorCode.INTERNAL_ERROR;
        this.errorCode = hyBidErrorCode;
    }

    public HyBidError(String str) {
        super(str);
        this.errorCode = HyBidErrorCode.INTERNAL_ERROR;
    }

    public HyBidError(HyBidErrorCode hyBidErrorCode, String str) {
        super(str);
        HyBidErrorCode hyBidErrorCode2 = HyBidErrorCode.INTERNAL_ERROR;
        this.errorCode = hyBidErrorCode;
    }

    public HyBidError(HyBidErrorCode hyBidErrorCode, Throwable th) {
        super(hyBidErrorCode.getMessage(), th);
        HyBidErrorCode hyBidErrorCode2 = HyBidErrorCode.INTERNAL_ERROR;
        this.errorCode = hyBidErrorCode;
    }

    public HyBidError(String str, Throwable th) {
        super(str, th);
        this.errorCode = HyBidErrorCode.INTERNAL_ERROR;
    }

    public HyBidError(Throwable th) {
        super(th);
        this.errorCode = HyBidErrorCode.INTERNAL_ERROR;
    }

    public HyBidError(String str, Throwable th, boolean z, boolean z2) {
        super(str, th, z, z2);
        this.errorCode = HyBidErrorCode.INTERNAL_ERROR;
    }

    public HyBidErrorCode getErrorCode() {
        return this.errorCode;
    }
}
