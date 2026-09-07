package com.fyber.inneractive.sdk.bidder;

import com.fyber.inneractive.sdk.protobuf.InterfaceC3181e0;
import com.fyber.inneractive.sdk.protobuf.InterfaceC3184f0;

/* JADX INFO: loaded from: classes9.dex */
public enum J implements InterfaceC3181e0 {
    UNITCONTENTTYPEUNKNOWN(0),
    DISPLAY(1),
    VIDEO(2),
    UNRECOGNIZED(-1);

    public static final int DISPLAY_VALUE = 1;
    public static final int UNITCONTENTTYPEUNKNOWN_VALUE = 0;
    public static final int VIDEO_VALUE = 2;
    private static final InterfaceC3184f0 internalValueMap = new InterfaceC3184f0() { // from class: com.fyber.inneractive.sdk.bidder.I
        @Override // com.fyber.inneractive.sdk.protobuf.InterfaceC3184f0
        public final InterfaceC3181e0 a(int i) {
            if (i == 0) {
                return J.UNITCONTENTTYPEUNKNOWN;
            }
            if (i == 1) {
                return J.DISPLAY;
            }
            if (i != 2) {
                return null;
            }
            return J.VIDEO;
        }
    };
    private final int value;

    J(int i) {
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
