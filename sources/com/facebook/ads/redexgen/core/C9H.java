package com.facebook.ads.redexgen.core;

import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9H, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class C9H extends AbstractC2010Ws<C14308s, AbstractC14288q, TP> implements TQ {
    public static byte[] A01;
    public static String[] A02 = {"6qGto4Mu1KprSvsbmVYTvCLW7PL7nz4j", "XlOTzX0TGzTynhC0hgXPwT10EFz15vPS", "WbkM4S1K", "PsyIw6p1ZmHgZ2mMC7nf60", "rYNf", "r5FFICR2yLzUZPLEKflUDJmwQQtZdVuS", "CmbHiMSlwerjdu1QrBWT5PHBWFMPiv71", "mmyKCIkyofnR0xFe3rEnZHGbDK63jPPG"};
    public final String A00;

    public static String A0L(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            byte b = bArrCopyOfRange[i4];
            if (A02[4].length() == 7) {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[5] = "E4AV6ssyudXhlb20fuQmQKl7G2uypsdS";
            strArr[1] = "WTxRsHNPrGrXXkhqew0qtvaYAuLu9qge";
            bArrCopyOfRange[i4] = (byte) ((b - i3) - 7);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0M() {
        A01 = new byte[]{-86, -61, -70, -51, -59, -70, -72, -55, -70, -71, 117, -71, -70, -72, -60, -71, -70, 117, -70, -57, -57, -60, -57};
    }

    public abstract InterfaceC2013Wv A0g(byte[] bArr, int i, boolean z) throws TP;

    static {
        A0M();
    }

    public C9H(String str) {
        super(new C14308s[2], new AbstractC14288q[2]);
        this.A00 = str;
        A0d(1024);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.facebook.ads.redexgen.X.1H] */
    @Override // com.facebook.ads.redexgen.core.AbstractC2010Ws
    /* JADX INFO: renamed from: A0H, reason: merged with bridge method [inline-methods] */
    public final C1H A0c() {
        return new AbstractC14288q(this) { // from class: com.facebook.ads.redexgen.X.1H
            public final C9H A00;

            {
                this.A00 = this;
            }

            @Override // com.facebook.ads.redexgen.core.AbstractC14288q, com.facebook.ads.redexgen.core.AbstractC2012Wu
            public final void A0B() {
                this.A00.A0h(this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC2010Ws
    /* JADX INFO: renamed from: A0I, reason: merged with bridge method [inline-methods] */
    public final TP A0Y(C14308s c14308s, AbstractC14288q abstractC14288q, boolean z) {
        try {
            ByteBuffer inputData = (ByteBuffer) AbstractC2388es.A01(c14308s.A02);
            abstractC14288q.A0C(c14308s.A01, A0g(inputData.array(), inputData.limit(), z), c14308s.A00);
            abstractC14288q.A01(Integer.MIN_VALUE);
            return null;
        } catch (TP e) {
            return e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC2010Ws
    /* JADX INFO: renamed from: A0J, reason: merged with bridge method [inline-methods] */
    public final TP A0Z(Throwable th) {
        return new TP(A0L(0, 23, 78), th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC2010Ws
    /* JADX INFO: renamed from: A0K, reason: merged with bridge method [inline-methods] */
    public final C14308s A0a() {
        return new C14308s();
    }

    public final void A0h(AbstractC14288q abstractC14288q) {
        super.A0f(abstractC14288q);
    }

    @Override // com.facebook.ads.redexgen.core.TQ
    public final void AIn(long j) {
    }
}
