package com.pubmatic.sdk.common.models;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/pubmatic/sdk/common/models/POBDSAComplianceStatus;", "", "", "value", "<init>", "(Ljava/lang/String;II)V", "a", "I", "getValue", "()I", "NOT_REQUIRED", "OPTIONAL", "REQUIRED", "REQUIRED_PUB_ONLINE_PLATFORM", "common_release"}, k = 1, mv = {1, 7, 1})
public enum POBDSAComplianceStatus {
    NOT_REQUIRED(0),
    OPTIONAL(1),
    REQUIRED(2),
    REQUIRED_PUB_ONLINE_PLATFORM(3);


    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int value;

    POBDSAComplianceStatus(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
