package com.facebook.ads.redexgen.core;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class XP implements RV {
    public static String[] A07 = {"ruhWoUaLaO991pCwp8Q64L06bE174V55", "CU2hGCokDcshNCtjB65kDrvL95VwyteK", "XA6ewC3SdyRaEKjLivSIpGfmNHH", "Op6VY0C6tqczjMiGf7nzAIhuGjEwaU0x", "B5tDmbYtdcfN", "gf5zuUSe0LhuI9LyZZsMFocI5MScSBF9", "IiHpaZ0CBff0R3mfjwAHEUFm7", "sYXnkdGQKHPEuw2c5w0RYqY2CcuaCO6X"};
    public boolean A04;
    public ByteBuffer A02 = RV.A00;
    public ByteBuffer A03 = RV.A00;
    public RT A00 = RT.A05;
    public RT A01 = RT.A05;
    public RT A05 = RT.A05;
    public RT A06 = RT.A05;

    public abstract RT A09(RT rt) throws RU;

    public final ByteBuffer A00(int i) {
        if (this.A02.capacity() < i) {
            this.A02 = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            ByteBuffer byteBuffer = this.A02;
            String[] strArr = A07;
            if (strArr[3].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[2] = "6sTvUFb20f9xLOujz9YP2suWRvR";
            strArr2[4] = "taS9uueghdvw";
            byteBuffer.clear();
        }
        this.A03 = this.A02;
        return this.A02;
    }

    public final boolean A01() {
        return this.A03.hasRemaining();
    }

    public void A0A() {
    }

    public void A0B() {
    }

    @Override // com.facebook.ads.redexgen.core.RV
    public final RT A4x(RT rt) throws RU {
        this.A00 = rt;
        this.A01 = A09(rt);
        return AAA() ? this.A01 : RT.A05;
    }

    @Override // com.facebook.ads.redexgen.core.RV
    public ByteBuffer A8T() {
        ByteBuffer byteBuffer = this.A03;
        ByteBuffer outputBuffer = RV.A00;
        this.A03 = outputBuffer;
        return byteBuffer;
    }

    @Override // com.facebook.ads.redexgen.core.RV
    public boolean AAA() {
        return this.A01 != RT.A05;
    }

    @Override // com.facebook.ads.redexgen.core.RV
    public boolean AAE() {
        return this.A04 && this.A03 == RV.A00;
    }

    @Override // com.facebook.ads.redexgen.core.RV
    public final void AGO() {
        this.A04 = true;
        A0B();
    }

    @Override // com.facebook.ads.redexgen.core.RV
    public final void flush() {
        this.A03 = RV.A00;
        this.A04 = false;
        this.A05 = this.A00;
        this.A06 = this.A01;
        A0A();
    }
}
