package com.fyber.inneractive.sdk.measurement;

/* JADX INFO: loaded from: classes12.dex */
public enum j {
    VERIFICATION_RESOURCE_REJECTED(1),
    VERIFICATION_NOT_SUPPORTED(2),
    ERROR_DURING_RESOURCE_LOAD(3);

    int mReason;

    j(int i) {
        this.mReason = i;
    }
}
