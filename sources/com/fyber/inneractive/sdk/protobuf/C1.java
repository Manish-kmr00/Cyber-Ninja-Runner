package com.fyber.inneractive.sdk.protobuf;

/* JADX INFO: loaded from: classes12.dex */
public final class C1 extends IllegalArgumentException {
    public C1(int i, int i2) {
        super("Unpaired surrogate at index " + i + " of " + i2);
    }
}
