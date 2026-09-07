package com.fyber.inneractive.sdk.protobuf;

/* JADX INFO: loaded from: classes13.dex */
public enum P {
    SCALAR(false),
    VECTOR(true),
    PACKED_VECTOR(true),
    MAP(false);

    private final boolean isList;

    P(boolean z) {
        this.isList = z;
    }

    public final boolean a() {
        return this.isList;
    }
}
