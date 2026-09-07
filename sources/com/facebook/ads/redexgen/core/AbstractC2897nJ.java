package com.facebook.ads.redexgen.core;

import com.google.common.collect.ElementTypesAreNonnullByDefault;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nJ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractC2897nJ<K0, V0> {
    public static byte[] A00;

    static {
        A04();
    }

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 127);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{97, 116, 108, 97, 95, 112, 97, 96, 71, 97, 117, 111};
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nJ != com.google.common.collect.MultimapBuilder<K0, V0> */
    public AbstractC2897nJ() {
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nJ != com.google.common.collect.MultimapBuilder<K0, V0> */
    public /* synthetic */ AbstractC2897nJ(O0 o0) {
        this();
    }

    public static AbstractC2896nI<Object> A00(int expectedKeys) {
        AbstractC2748ko.A00(expectedKeys, A03(0, 12, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE));
        return new O0(expectedKeys);
    }

    public static <K0> AbstractC2896nI<K0> A01(Comparator<K0> comparator) {
        AbstractC2589iD.A04(comparator);
        return new C1797Nz(comparator);
    }

    public static AbstractC2896nI<Comparable> A02() {
        return A01(AbstractC2912nY.A03());
    }
}
