package com.fyber.inneractive.sdk.bidder;

import com.fyber.inneractive.sdk.protobuf.InterfaceC3181e0;
import com.fyber.inneractive.sdk.protobuf.InterfaceC3184f0;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.bidder.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public enum EnumC3069q implements InterfaceC3181e0 {
    NATIVE(0),
    UNITY3D(1),
    UNRECOGNIZED(-1);

    public static final int NATIVE_VALUE = 0;
    public static final int UNITY3D_VALUE = 1;
    private static final InterfaceC3184f0 internalValueMap = new InterfaceC3184f0() { // from class: com.fyber.inneractive.sdk.bidder.p
        @Override // com.fyber.inneractive.sdk.protobuf.InterfaceC3184f0
        public final InterfaceC3181e0 a(int i) {
            if (i == 0) {
                return EnumC3069q.NATIVE;
            }
            if (i != 1) {
                return null;
            }
            return EnumC3069q.UNITY3D;
        }
    };
    private final int value;

    EnumC3069q(int i) {
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
