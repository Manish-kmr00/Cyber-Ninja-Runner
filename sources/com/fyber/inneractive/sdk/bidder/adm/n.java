package com.fyber.inneractive.sdk.bidder.adm;

import com.fyber.inneractive.sdk.protobuf.InterfaceC3181e0;
import com.fyber.inneractive.sdk.protobuf.InterfaceC3184f0;

/* JADX INFO: loaded from: classes12.dex */
public enum n implements InterfaceC3181e0 {
    NONE(0),
    SINGLETAP(1),
    TRUESINGLETAP(2),
    UNRECOGNIZED(-1);

    public static final int NONE_VALUE = 0;
    public static final int SINGLETAP_VALUE = 1;
    public static final int TRUESINGLETAP_VALUE = 2;
    private static final InterfaceC3184f0 internalValueMap = new InterfaceC3184f0() { // from class: com.fyber.inneractive.sdk.bidder.adm.m
        @Override // com.fyber.inneractive.sdk.protobuf.InterfaceC3184f0
        public final InterfaceC3181e0 a(int i) {
            if (i == 0) {
                return n.NONE;
            }
            if (i == 1) {
                return n.SINGLETAP;
            }
            if (i != 2) {
                return null;
            }
            return n.TRUESINGLETAP;
        }
    };
    private final int value;

    n(int i) {
        this.value = i;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.InterfaceC3181e0
    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
