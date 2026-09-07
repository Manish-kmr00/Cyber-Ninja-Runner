package com.facebook.ads.redexgen.core;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class XF implements RV {
    public static String[] A0F = {"64Y01eiq9F3wZpA", "1H", "NkQGmALLm5y5O9xtCMyW0C1Q4gk2kTac", "El", "Bo9m1plskAR", "Pv8h82", "6YqkY2q4SFEg1mfIoOUgVxUHLpYvBtpE", "RCtsEl9Sla98gt5KuR9mkh5SSkkB1mOx"};
    public long A03;
    public long A04;
    public SY A09;
    public boolean A0D;
    public boolean A0E;
    public float A01 = 1.0f;
    public float A00 = 1.0f;
    public RT A07 = RT.A05;
    public RT A08 = RT.A05;
    public RT A05 = RT.A05;
    public RT A06 = RT.A05;
    public ByteBuffer A0A = RV.A00;
    public ShortBuffer A0C = this.A0A.asShortBuffer();
    public ByteBuffer A0B = RV.A00;
    public int A02 = -1;

    public final long A00(long j) {
        if (this.A04 >= 1024) {
            long jA0I = this.A03 - ((long) ((SY) AbstractC2388es.A01(this.A09)).A0I());
            if (this.A06.A03 == this.A05.A03) {
                long j2 = this.A04;
                if (A0F[5].length() == 23) {
                    throw new RuntimeException();
                }
                A0F[3] = "4b";
                long processedInputBytes = AbstractC2471gE.A0U(j, jA0I, j2);
                return processedInputBytes;
            }
            long processedInputBytes2 = this.A06.A03;
            long j3 = jA0I * processedInputBytes2;
            long j4 = this.A04;
            long processedInputBytes3 = this.A05.A03;
            return AbstractC2471gE.A0U(j, j3, j4 * processedInputBytes3);
        }
        return (long) (((double) this.A01) * j);
    }

    public final void A01(float f) {
        if (this.A00 != f) {
            this.A00 = f;
            this.A0E = true;
        }
    }

    public final void A02(float f) {
        if (this.A01 != f) {
            this.A01 = f;
            String[] strArr = A0F;
            if (strArr[0].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            A0F[3] = "HH";
            this.A0E = true;
        }
    }

    @Override // com.facebook.ads.redexgen.core.RV
    public final RT A4x(RT rt) throws RU {
        int i;
        if (rt.A02 == 2) {
            if (this.A02 == -1) {
                i = rt.A03;
            } else {
                i = this.A02;
            }
            this.A07 = rt;
            this.A08 = new RT(i, rt.A01, 2);
            this.A0E = true;
            return this.A08;
        }
        throw new RU(rt);
    }

    @Override // com.facebook.ads.redexgen.core.RV
    public final ByteBuffer A8T() {
        int iA0H;
        SY sy = this.A09;
        if (sy != null && (iA0H = sy.A0H()) > 0) {
            if (this.A0A.capacity() < iA0H) {
                this.A0A = ByteBuffer.allocateDirect(iA0H).order(ByteOrder.nativeOrder());
                this.A0C = this.A0A.asShortBuffer();
            } else {
                this.A0A.clear();
                this.A0C.clear();
            }
            sy.A0L(this.A0C);
            this.A04 += (long) iA0H;
            this.A0A.limit(iA0H);
            this.A0B = this.A0A;
        }
        ByteBuffer outputBuffer = this.A0B;
        this.A0B = RV.A00;
        return outputBuffer;
    }

    @Override // com.facebook.ads.redexgen.core.RV
    public final boolean AAA() {
        return this.A08.A03 != -1 && (Math.abs(this.A01 - 1.0f) >= 1.0E-4f || Math.abs(this.A00 - 1.0f) >= 1.0E-4f || this.A08.A03 != this.A07.A03);
    }

    @Override // com.facebook.ads.redexgen.core.RV
    public final boolean AAE() {
        return this.A0D && (this.A09 == null || this.A09.A0H() == 0);
    }

    @Override // com.facebook.ads.redexgen.core.RV
    public final void AGO() {
        if (this.A09 != null) {
            this.A09.A0K();
        }
        this.A0D = true;
    }

    @Override // com.facebook.ads.redexgen.core.RV
    public final void AGP(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            return;
        }
        SY sy = (SY) AbstractC2388es.A01(this.A09);
        ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
        int iRemaining = byteBuffer.remaining();
        this.A03 += (long) iRemaining;
        sy.A0M(shortBufferAsShortBuffer);
        byteBuffer.position(byteBuffer.position() + iRemaining);
    }

    @Override // com.facebook.ads.redexgen.core.RV
    public final void flush() {
        if (AAA()) {
            this.A05 = this.A07;
            this.A06 = this.A08;
            boolean z = this.A0E;
            if (A0F[5].length() == 23) {
                throw new RuntimeException();
            }
            A0F[6] = "nABkzj0ONUgYqIiLmATRDflypjLu9m6H";
            if (z) {
                this.A09 = new SY(this.A05.A03, this.A05.A01, this.A01, this.A00, this.A06.A03);
            } else if (this.A09 != null) {
                this.A09.A0J();
            }
        }
        this.A0B = RV.A00;
        this.A03 = 0L;
        this.A04 = 0L;
        this.A0D = false;
    }
}
