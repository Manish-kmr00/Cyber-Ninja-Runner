package com.fyber.inneractive.sdk.bidder.adm;

import com.fyber.inneractive.sdk.protobuf.InterfaceC3181e0;
import com.fyber.inneractive.sdk.protobuf.InterfaceC3184f0;

/* JADX INFO: loaded from: classes12.dex */
public enum j implements InterfaceC3181e0 {
    MANUAL(0),
    AUTOMATIC(1),
    UNRECOGNIZED(-1);

    public static final int AUTOMATIC_VALUE = 1;
    public static final int MANUAL_VALUE = 0;
    private static final InterfaceC3184f0 internalValueMap = new InterfaceC3184f0() { // from class: com.fyber.inneractive.sdk.bidder.adm.i
        @Override // com.fyber.inneractive.sdk.protobuf.InterfaceC3184f0
        public final InterfaceC3181e0 a(int i) {
            if (i == 0) {
                return j.MANUAL;
            }
            if (i != 1) {
                return null;
            }
            return j.AUTOMATIC;
        }
    };
    private final int value;

    j(int i) {
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
