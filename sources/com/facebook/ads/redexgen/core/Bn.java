package com.facebook.ads.redexgen.core;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class Bn extends XP {
    public static String[] A07 = {"ETuOwlYjYul9zkA4fGtfF", "aBK55jqhoYPI6tBlBGZYtxPyfwORMvr1", "Tyi8uYfz0kT0njieIfg0GIa5yh3S", "hjKekpZ4HHcVQsarVLOH9n7l26qbTdm5", "qnSO7AN547oeh1mrlvOUF4IGCPV3xu2X", "ilSzySB9shWP2y3EEj0bsnfKUaBWveMD", "sRiZjNrcupZhfbe47sVeyZEscMAwLRsr", "qcRY9ff8fQWXilSHsvES5W6L15S7peac"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public long A04;
    public boolean A05;
    public byte[] A06 = AbstractC2471gE.A07;

    @Override // com.facebook.ads.redexgen.core.XP
    public final RT A09(RT rt) throws RU {
        if (rt.A02 == 2) {
            this.A05 = true;
            return (this.A03 == 0 && this.A02 == 0) ? RT.A05 : rt;
        }
        throw new RU(rt);
    }

    @Override // com.facebook.ads.redexgen.core.XP
    public final void A0A() {
        if (this.A05) {
            this.A05 = false;
            this.A06 = new byte[this.A02 * super.A05.A00];
            this.A01 = this.A03 * super.A05.A00;
        }
        this.A00 = 0;
        if (A07[4].charAt(22) == 'l') {
            throw new RuntimeException();
        }
        A07[1] = "NBpmV7a1Qv9CVABZrqH3PQnawFgATwie";
    }

    @Override // com.facebook.ads.redexgen.core.XP
    public final void A0B() {
        if (this.A05) {
            if (this.A00 > 0) {
                this.A04 += (long) (this.A00 / super.A05.A00);
            }
            this.A00 = 0;
        }
    }

    public final long A0C() {
        return this.A04;
    }

    public final void A0D() {
        this.A04 = 0L;
    }

    public final void A0E(int i, int i2) {
        this.A03 = i;
        this.A02 = i2;
    }

    @Override // com.facebook.ads.redexgen.core.XP, com.facebook.ads.redexgen.core.RV
    public final ByteBuffer A8T() {
        if (super.AAE() && this.A00 > 0) {
            A00(this.A00).put(this.A06, 0, this.A00).flip();
            this.A00 = 0;
        }
        return super.A8T();
    }

    @Override // com.facebook.ads.redexgen.core.XP, com.facebook.ads.redexgen.core.RV
    public final boolean AAE() {
        return super.AAE() && this.A00 == 0;
    }

    @Override // com.facebook.ads.redexgen.core.RV
    public final void AGP(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int remaining = byteBuffer.limit();
        int i = remaining - iPosition;
        if (i == 0) {
            return;
        }
        int position = this.A01;
        int iMin = Math.min(i, position);
        long j = this.A04;
        int position2 = super.A05.A00;
        this.A04 = j + ((long) (iMin / position2));
        int position3 = this.A01;
        this.A01 = position3 - iMin;
        byteBuffer.position(iPosition + iMin);
        int position4 = this.A01;
        if (position4 > 0) {
            return;
        }
        int endBufferBytesToOutput = i - iMin;
        int limit = this.A00;
        int position5 = this.A06.length;
        int limit2 = (limit + endBufferBytesToOutput) - position5;
        ByteBuffer buffer = A00(limit2);
        int position6 = this.A00;
        int trimBytes = AbstractC2471gE.A07(limit2, 0, position6);
        buffer.put(this.A06, 0, trimBytes);
        int limit3 = AbstractC2471gE.A07(limit2 - trimBytes, 0, endBufferBytesToOutput);
        int position7 = byteBuffer.position();
        byteBuffer.limit(position7 + limit3);
        buffer.put(byteBuffer);
        byteBuffer.limit(remaining);
        int endBufferBytesToOutput2 = endBufferBytesToOutput - limit3;
        int position8 = this.A00;
        this.A00 = position8 - trimBytes;
        byte[] bArr = this.A06;
        byte[] bArr2 = this.A06;
        int position9 = this.A00;
        System.arraycopy(bArr, trimBytes, bArr2, 0, position9);
        byte[] bArr3 = this.A06;
        int position10 = this.A00;
        byteBuffer.get(bArr3, position10, endBufferBytesToOutput2);
        int position11 = this.A00;
        this.A00 = position11 + endBufferBytesToOutput2;
        buffer.flip();
    }
}
