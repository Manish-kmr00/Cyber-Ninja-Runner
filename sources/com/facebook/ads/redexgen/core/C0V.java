package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0V, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0V extends AnonymousClass10 implements PD {
    public static byte[] A0K;
    public static String[] A0L = {"ny53PTW1IsCIZ3DiXpxVoy2OGjDVNtvg", "x3Bg", "TF", "Z18MDGIuZ", "CLtjM6Bnt", "gZ4biLrifjy8Dh7ee7UfMIwOBD0EnNqu", "9CDMd8lzBVhcXdpKHhmzaEFyjHNSA5Q8", "7D1ov"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public long A04;
    public long A05;

    @MetaExoPlayerCustomization
    public AudioManager A06;
    public MediaFormat A07;
    public ZM A08;
    public InterfaceC1846Qa A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public boolean A0D;
    public boolean A0E;
    public final Context A0F;
    public final C1885Ro A0G;
    public final boolean A0H;
    public final boolean A0I;
    public final InterfaceC1896Rz A0J;

    public static String A07(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0K, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 65);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A09() {
        A0K = new byte[]{58, Ascii.DC2, 19, Ascii.RS, Ascii.SYN, 52, Ascii.CAN, 19, Ascii.DC2, Ascii.DC4, 54, 2, 19, Ascii.RS, Ascii.CAN, 37, Ascii.DC2, Ascii.EM, 19, Ascii.DC2, 5, Ascii.DC2, 5, 62, 60, 41, 95, 34, 52, 50, 95, Ascii.DLE, Ascii.DLE, Ascii.DC2, 95, Ascii.NAK, Ascii.DC4, Ascii.DC2, 45, 47, 58, 76, 5, Ascii.CR, Ascii.CR, 5, Ascii.SO, 7, 76, Ascii.DLE, 3, Ascii.NAK, 76, 6, 7, 1, Ascii.CR, 6, 7, Ascii.DLE, 1, 1, 3, 77, 4, Ascii.DC2, 3, 77, 5, 6, 6, 5, 3, Ascii.DC4, 77, Ascii.DC4, Ascii.EM, Ascii.DLE, 5, 112, 112, 114, 60, 101, 112, 99, 118, 116, 101, 60, 99, 116, 119, 60, 125, 116, 103, 116, 125, 48, 36, 53, 56, 62, 94, 74, 91, 86, 80, Ascii.DLE, 77, 94, 72, 79, 68, 77, 66, 66, 73, SignedBytes.MAX_POWER_OF_TWO, 1, 79, 67, 89, 66, 88, 35, 46, 57, 36, 39, 63, 46, 94, 83, 68, 89, 71, 90, 66, 83, 40, 36, Base64.padSymbol, 104, 44, 43, 53, 48, 49, 104, 54, 44, 63, 32, 37, 33, 37, 45, 109, 112, 52, 97, 46, 52, 48, 46, 52, 50, 70, 68, 95, 89, 68, 95, 66, 79, 34, 48, 60, 33, Base64.padSymbol, 52, 124, 35, 48, 37, 52, 79, 93, 81, 79, 73, 82, 91, 118, 105, 126, 99, 106, 96, 120, 105};
    }

    static {
        A09();
    }

    public C0V(Context context, C1760Mg c1760Mg, MediaCodecRendererMetaParameters mediaCodecRendererMetaParameters, ZS zs, TO to, boolean z, boolean z2, boolean z3, Handler handler, InterfaceC1886Rp interfaceC1886Rp, RN rn, RV... rvArr) {
        this(context, c1760Mg, mediaCodecRendererMetaParameters, zs, to, z, z2, z3, handler, interfaceC1886Rp, new XM(rn, rvArr));
    }

    public C0V(Context context, C1760Mg c1760Mg, MediaCodecRendererMetaParameters mediaCodecRendererMetaParameters, ZS zs, TO to, boolean z, boolean z2, boolean z3, Handler handler, InterfaceC1886Rp interfaceC1886Rp, InterfaceC1896Rz interfaceC1896Rz) {
        super(1, c1760Mg, mediaCodecRendererMetaParameters, zs, to, z, false, 0, 0);
        this.A01 = 0;
        this.A02 = 0;
        this.A05 = 0L;
        this.A0F = context.getApplicationContext();
        this.A0J = interfaceC1896Rz;
        this.A0H = z2;
        this.A0I = z3;
        this.A0G = new C1885Ro(handler, interfaceC1886Rp);
        interfaceC1896Rz.AIb(new XG(this));
        interfaceC1896Rz.AIW(c1760Mg.A0B);
    }

    @MetaExoPlayerCustomization("Added in D36293647 for DRC")
    private int A00() {
        int i = this.A11.A07;
        if (this.A11.A0D) {
            int i2 = this.A11.A02;
            int i3 = this.A11.A03;
            String[] strArr = A0L;
            String str = strArr[2];
            String str2 = strArr[7];
            int length = str.length();
            int xHEAACEffectType = str2.length();
            if (length != xHEAACEffectType) {
                String[] strArr2 = A0L;
                strArr2[5] = "w7j9MOjZih5C6Q3ro0cf7Apy33T5GWMs";
                strArr2[6] = "zR8tNafmogO2J3qMPAhJAiMTJMir5YNQ";
                int iA00 = ContextAwareXHEAACDRCTypeUtil.A00(i2, i3);
                if (this.A11.A0E) {
                    AudioManager audioManager = this.A06;
                    String[] strArr3 = A0L;
                    String str3 = strArr3[5];
                    String str4 = strArr3[6];
                    int iCharAt = str3.charAt(16);
                    int xHEAACEffectType2 = str4.charAt(16);
                    if (iCharAt == xHEAACEffectType2) {
                        throw new RuntimeException();
                    }
                    String[] strArr4 = A0L;
                    strArr4[5] = "QWOsPQ9mk5cpxQayyci1WtukI0C3JnRL";
                    strArr4[6] = "meGrPLaBwLl10L2kp1Xzhd02rgbcoCwf";
                    if (audioManager == null) {
                        Context context = this.A0F;
                        String[] strArr5 = A0L;
                        String str5 = strArr5[3];
                        String str6 = strArr5[4];
                        int length2 = str5.length();
                        int xHEAACEffectType3 = str6.length();
                        if (length2 == xHEAACEffectType3) {
                            String[] strArr6 = A0L;
                            strArr6[5] = "nxKRVCe6n1QeWkUFQr3O22SeJ2UrRm4w";
                            strArr6[6] = "MUmkhwzTWlAEBhvi3gO6sbbVsI6qpGWn";
                            this.A06 = (AudioManager) context.getSystemService(A07(99, 5, 16));
                        }
                    }
                    int DRCTypeFromHeadset = ContextAwareXHEAACDRCTypeUtil.A01(this.A06);
                    if (DRCTypeFromHeadset != 3) {
                        return DRCTypeFromHeadset;
                    }
                    return iA00;
                }
                return iA00;
            }
            throw new RuntimeException();
        }
        return i;
    }

    public static int A01(ZM zm) {
        if (A07(104, 9, 126).equals(zm.A0W)) {
            return zm.A0C;
        }
        return 2;
    }

    private int A02(Z2 z2, ZM zm) {
        if (A07(38, 22, 35).equals(z2.A03) && AbstractC2471gE.A02 < 24 && (AbstractC2471gE.A02 != 23 || !AbstractC2471gE.A18(this.A0F))) {
            return -1;
        }
        return zm.A0B;
    }

    private final int A03(Z2 z2, ZM zm, ZM[] zmArr) {
        int maxInputSize = A02(z2, zm);
        return maxInputSize;
    }

    private final MediaFormat A04(ZM zm, String str, int i) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString(A07(155, 4, 9), str);
        mediaFormat.setInteger(A07(113, 13, 109), zm.A06);
        mediaFormat.setInteger(A07(177, 11, 16), zm.A0G);
        AbstractC2434fd.A06(mediaFormat, zm.A0X);
        AbstractC2434fd.A04(mediaFormat, A07(141, 14, 4), i);
        if (AbstractC2471gE.A02 >= 23) {
            mediaFormat.setInteger(A07(169, 8, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE), 0);
        }
        if (zm.A0R != null && zm.A0R.equals(A07(159, 10, 65)) && this.A11.A0F) {
            mediaFormat.setInteger(A07(60, 19, 33), A00());
            mediaFormat.setInteger(A07(79, 20, 80), this.A11.A08);
        }
        return mediaFormat;
    }

    public static /* synthetic */ InterfaceC1846Qa A05(C0V c0v) {
        return null;
    }

    private void A08() {
        long jA7V = this.A0J.A7V(AAE());
        if (jA7V != Long.MIN_VALUE) {
            if (!this.A0B) {
                long newCurrentPositionUs = this.A04;
                jA7V = Math.max(newCurrentPositionUs, jA7V);
            }
            this.A04 = jA7V;
            this.A0B = false;
        }
    }

    private boolean A0A(ZM zm) {
        String str = zm.A0W;
        String mimeType = A07(104, 9, 126);
        if (mimeType.equals(str)) {
            return false;
        }
        return this.A0J.AJS(zm);
    }

    public static boolean A0B(String str) {
        if (AbstractC2471gE.A02 < 24 && A07(23, 15, 48).equals(str)) {
            if (A07(188, 7, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE).equals(AbstractC2471gE.A05)) {
                String str2 = AbstractC2471gE.A03;
                if (A0L[0].charAt(19) != 'V') {
                    throw new RuntimeException();
                }
                String[] strArr = A0L;
                strArr[5] = "Ja8X7lPIgQ719WOyS99SHG6mtluHwCw7";
                strArr[6] = "WL93SWX2ueh3mCL2llUu3t1G0xsIbb1j";
                if (str2.startsWith(A07(195, 8, 77)) || AbstractC2471gE.A03.startsWith(A07(126, 7, 10)) || AbstractC2471gE.A03.startsWith(A07(Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE, 8, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE))) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass10, com.facebook.ads.redexgen.core.AbstractC1568Et
    public final void A1X() {
        super.A1X();
        this.A0J.AG8();
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass10, com.facebook.ads.redexgen.core.AbstractC1568Et
    public final void A1Y() {
        A08();
        this.A0J.pause();
        super.A1Y();
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass10, com.facebook.ads.redexgen.core.AbstractC1568Et
    public final void A1Z() {
        try {
            this.A0J.flush();
            try {
                super.A1Z();
            } finally {
                this.A0i.A02();
                this.A0G.A05(this.A0i);
            }
        } catch (Throwable th) {
            try {
                super.A1Z();
                throw th;
            } finally {
                this.A0i.A02();
                this.A0G.A05(this.A0i);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass10, com.facebook.ads.redexgen.core.AbstractC1568Et
    public final void A1a(long j, boolean z) throws EK {
        super.A1a(j, z);
        if (this.A0D) {
            this.A0J.A6J();
        } else {
            this.A0J.flush();
        }
        this.A04 = j;
        this.A0A = true;
        this.A0B = true;
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass10, com.facebook.ads.redexgen.core.AbstractC1568Et
    public final void A1b(boolean z, boolean z2) throws EK {
        super.A1b(z, z2);
        this.A0G.A06(this.A0i);
        if (A1V().A00) {
            this.A0J.A6C();
        } else {
            this.A0J.A5p();
        }
        this.A0J.AIm(A1W());
        if (A0L[1].length() == 10) {
            throw new RuntimeException();
        }
        A0L[1] = "yvKVkLQNXZhZ3z5ZR";
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass10
    public final int A1g(InterfaceC2068Yz interfaceC2068Yz, Z2 z2, ZM zm, ZM zm2) {
        if (this.A11.A0N && A02(z2, zm2) <= this.A00 && z2.A0U(zm, zm2, true) && zm.A08 == 0 && zm.A09 == 0 && zm2.A08 == 0 && zm2.A09 == 0) {
            return 1;
        }
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0086  */
    /* JADX WARN: Code duplicated, block: B:32:0x0092  */
    /* JADX WARN: Code duplicated, block: B:34:0x009c  */
    /* JADX WARN: Code duplicated, block: B:36:0x00a1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:37:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:39:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:41:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:53:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:61:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:62:0x00fc  */
    @Override // com.facebook.ads.redexgen.core.AnonymousClass10
    public final int A1h(ZS zs, TO to, ZM zm) throws ZW {
        List<Z2> listA1l;
        int i;
        String mimeType;
        int tunnelingSupport;
        int i2;
        String str = zm.A0W;
        int adaptiveSupport = 0;
        if (!Q2.A0C(str)) {
            return 0;
        }
        int i3 = AbstractC2471gE.A02 >= 21 ? 32 : 0;
        boolean zA1G = AnonymousClass10.A1G(zm);
        int i4 = 4;
        if (zA1G && A0A(zm)) {
            Z2 z2A0I = ZZ.A0I();
            String mimeType2 = A0L[1];
            int tunnelingSupport2 = mimeType2.length();
            if (tunnelingSupport2 == 10) {
                throw new RuntimeException();
            }
            A0L[1] = "ZSBu";
            if (z2A0I != null) {
                int i5 = i3 | 8 | 4;
                String[] strArr = A0L;
                String str2 = strArr[2];
                String mimeType3 = strArr[7];
                int tunnelingSupport3 = str2.length();
                if (tunnelingSupport3 == mimeType3.length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0L;
                strArr2[3] = "aOGkKtxBZ";
                strArr2[4] = "mc5kqxdkM";
                return i5;
            }
        }
        String mimeType4 = A07(104, 9, 126);
        if (mimeType4.equals(str)) {
            InterfaceC1896Rz interfaceC1896Rz = this.A0J;
            int tunnelingSupport4 = zm.A06;
            if (interfaceC1896Rz.AJU(tunnelingSupport4, zm.A0C)) {
                if (this.A0J.AJU(zm.A06, 2)) {
                    listA1l = A1l(zs, zm, false);
                    if (listA1l.isEmpty()) {
                        return AbstractC1847Qb.A00(1);
                    }
                    if (!zA1G) {
                        return AbstractC1847Qb.A00(2);
                    }
                    Z2 z2 = listA1l.get(0);
                    i = AbstractC2471gE.A02;
                    String[] strArr3 = A0L;
                    String str3 = strArr3[3];
                    mimeType = strArr3[4];
                    tunnelingSupport = str3.length();
                    if (tunnelingSupport != mimeType.length()) {
                        throw new RuntimeException();
                    }
                    A0L[1] = "PUBLZJpPnf0Wr7";
                    if (i >= 21 || ((zm.A0G == -1 || z2.A0Q(zm.A0G)) && (zm.A06 == -1 || z2.A0P(zm.A06)))) {
                        adaptiveSupport = 1;
                    }
                    if (adaptiveSupport == 0 && z2.A0T(zm)) {
                        i2 = 16;
                    } else {
                        i2 = 8;
                    }
                    if (adaptiveSupport == 0) {
                        i4 = 3;
                    }
                    return i2 | i3 | i4;
                }
            }
        } else if (this.A0J.AJU(zm.A06, 2)) {
            listA1l = A1l(zs, zm, false);
            if (listA1l.isEmpty()) {
                return AbstractC1847Qb.A00(1);
            }
            if (!zA1G) {
                return AbstractC1847Qb.A00(2);
            }
            Z2 z3 = listA1l.get(0);
            i = AbstractC2471gE.A02;
            String[] strArr4 = A0L;
            String str4 = strArr4[3];
            mimeType = strArr4[4];
            tunnelingSupport = str4.length();
            if (tunnelingSupport != mimeType.length()) {
                throw new RuntimeException();
            }
            A0L[1] = "PUBLZJpPnf0Wr7";
            if (i >= 21) {
                adaptiveSupport = 1;
            } else {
                adaptiveSupport = 1;
            }
            if (adaptiveSupport == 0) {
                i2 = 8;
            } else {
                i2 = 8;
            }
            if (adaptiveSupport == 0) {
                i4 = 3;
            }
            return i2 | i3 | i4;
        }
        return 1;
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass10
    public final List<Z2> A1l(ZS zs, ZM zm, boolean z) throws ZW {
        Z2 z2A0I;
        String mimeType = zm.A0W;
        if (mimeType == null) {
            return Collections.emptyList();
        }
        if (A0A(zm) && (z2A0I = ZZ.A0I()) != null) {
            return Collections.singletonList(z2A0I);
        }
        return Collections.unmodifiableList(zs.A7e(zm.A0W, z, false));
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass10
    public final void A1o() throws EK {
        try {
            this.A0J.AGA();
        } catch (C1895Ry e) {
            throw A1T(e, e.A01, e.A02, 5002);
        }
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass10
    public final void A1s(ZM zm) throws EK {
        super.A1s(zm);
        this.A08 = zm;
        this.A0G.A09(this.A08, null);
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass10
    public final void A1u(C2014Ww c2014Ww) {
        if (this.A0A && !c2014Ww.A04()) {
            if (Math.abs(c2014Ww.A01 - this.A04) > 500000) {
                this.A04 = c2014Ww.A01;
            }
            this.A0A = false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x005f  */
    @Override // com.facebook.ads.redexgen.core.AnonymousClass10
    public final void A1v(InterfaceC2068Yz interfaceC2068Yz, MediaFormat mediaFormat) throws EK {
        int i;
        MediaFormat mediaFormat2;
        int[] iArr;
        if (this.A07 != null) {
            i = Q2.A00(this.A07.getString(A07(155, 4, 9)));
            mediaFormat2 = this.A07;
        } else {
            i = A01(this.A08);
            mediaFormat2 = mediaFormat;
        }
        String strA07 = A07(113, 13, 109);
        int channelCount = mediaFormat2.getInteger(strA07);
        String strA08 = A07(177, 11, 16);
        int encoding = mediaFormat2.getInteger(strA08);
        this.A03 = encoding * channelCount;
        if (this.A0C && channelCount == 6) {
            int encoding2 = this.A08.A06;
            if (encoding2 < 6) {
                int encoding3 = this.A08.A06;
                iArr = new int[encoding3];
                for (int i2 = 0; i2 < encoding; i2++) {
                    iArr[i2] = i2;
                }
            } else {
                iArr = null;
            }
        } else {
            iArr = null;
        }
        P5 p5A0i = new P5().A11(A07(104, 9, 126)).A0i(i);
        int encoding4 = mediaFormat.getInteger(strA07);
        P5 p5A0b = p5A0i.A0b(encoding4);
        int encoding5 = mediaFormat.getInteger(strA08);
        ZM audioSinkInputFormat = p5A0b.A0m(encoding5).A14();
        try {
            this.A0J.A4z(audioSinkInputFormat, 0, iArr);
        } catch (C1889Rs e) {
            throw A1S(e, e.A00, 5001);
        }
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass10
    public final void A1w(Z2 z2, InterfaceC2068Yz interfaceC2068Yz, ZM zm, MediaCrypto mediaCrypto) {
        this.A00 = A03(z2, zm, A1e());
        this.A0C = A0B(z2.A03);
        String str = z2.A02;
        String strA07 = A07(104, 9, 126);
        this.A0E = strA07.equals(str) && !strA07.equals(zm.A0W);
        MediaFormat mediaFormatA04 = A04(zm, z2.A01, this.A00);
        interfaceC2068Yz.A4y(mediaFormatA04, null, mediaCrypto, 0, null);
        if (this.A0E) {
            this.A07 = mediaFormatA04;
            this.A07.setString(A07(155, 4, 9), zm.A0W);
            return;
        }
        String[] strArr = A0L;
        if (strArr[2].length() == strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0L;
        strArr2[5] = "gZFfaLOsUERu0i8cGXvckXpWY5Utglis";
        strArr2[6] = "xJNbTRfoiGyTPD2CHclvMe0TgvhmQQCR";
        this.A07 = null;
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass10
    @MetaExoPlayerCustomization("D45988204: [FBLite][Video] Add Codec Hooks for Logging")
    public final void A1x(String str) {
        this.A0G.A0F(str);
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass10
    public final void A1y(String str, long j, long j2) {
        this.A0G.A0G(str, j, j2);
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass10
    @MetaExoPlayerCustomization("Added in D6142814")
    public final boolean A22() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass10
    public final boolean A23(long j, long j2, InterfaceC2068Yz interfaceC2068Yz, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z, boolean z2) throws EK {
        if (this.A0E && (i2 & 2) != 0) {
            interfaceC2068Yz.AGq(i, false);
            return true;
        }
        if (z) {
            interfaceC2068Yz.AGq(i, false);
            this.A0i.A0B++;
            this.A0J.A9X();
            return true;
        }
        if (this.A0I && A01(this.A08) == 2 && i2 == 0 && this.A03 > 0 && byteBuffer.limit() - byteBuffer.position() >= 12) {
            int iPosition = byteBuffer.position();
            int iLimit = byteBuffer.limit();
            byteBuffer.position(10);
            short s = byteBuffer.getShort();
            byteBuffer.position(iPosition);
            byteBuffer.limit(iLimit);
            int i3 = this.A01;
            int iLimit2 = byteBuffer.limit();
            int originalPosition = byteBuffer.position();
            this.A01 = i3 + (iLimit2 - originalPosition);
            int originalPosition2 = this.A02;
            this.A02 = originalPosition2 + 1;
            this.A05 += (long) Math.abs((int) s);
            int i4 = this.A01;
            int originalPosition3 = this.A03;
            if (i4 >= originalPosition3 * 2) {
                C1885Ro c1885Ro = this.A0G;
                long j4 = this.A05;
                int originalPosition4 = this.A02;
                c1885Ro.A00((int) (j4 / ((long) originalPosition4)));
                this.A01 = 0;
                this.A02 = 0;
                this.A05 = 0L;
            }
        }
        if (this.A0H) {
            int iLimit3 = byteBuffer.limit();
            int originalPosition5 = byteBuffer.position();
            if (iLimit3 > originalPosition5) {
                int iPosition2 = byteBuffer.position();
                int iLimit4 = byteBuffer.limit();
                int originalPosition6 = iLimit4 - iPosition2;
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(originalPosition6);
                byteBufferAllocate.put(byteBuffer);
                byteBufferAllocate.flip();
                byteBuffer.position(iPosition2);
                byteBuffer.limit(iLimit4);
                this.A0G.A0K(byteBufferAllocate.array(), j3 / 1000);
            }
        }
        try {
            if (!this.A0J.A9U(byteBuffer, j3, 1)) {
                return false;
            }
            interfaceC2068Yz.AGq(i, false);
            this.A0i.A09++;
            return true;
        } catch (C1890Rt e) {
            throw A1T(e, this.A08, e.A02, 5001);
        } catch (C1895Ry e2) {
            throw A1T(e2, this.A0j, e2.A02, 5002);
        }
    }

    public final void A26() {
        this.A0B = true;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1568Et, com.facebook.ads.redexgen.core.InterfaceC2059Yq
    public final PD A8J() {
        return this;
    }

    @Override // com.facebook.ads.redexgen.core.PD
    public final C2064Yv A8c() {
        return this.A0J.A8c();
    }

    @Override // com.facebook.ads.redexgen.core.PD
    public final long A8f() {
        if (A90() == 2) {
            A08();
        }
        long j = this.A04;
        String[] strArr = A0L;
        if (strArr[3].length() != strArr[4].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0L;
        strArr2[2] = "qG";
        strArr2[7] = "wmfqP";
        return j;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1568Et, com.facebook.ads.redexgen.core.QS
    public final void A9Y(int i, Object obj) throws EK {
        switch (i) {
            case 2:
                this.A0J.setVolume(((Float) obj).floatValue());
                return;
            case 3:
                C2080Zm c2080Zm = (C2080Zm) obj;
                if (A0L[1].length() == 10) {
                    throw new RuntimeException();
                }
                String[] strArr = A0L;
                strArr[5] = "CZ4wjKRnqD7opuv8WqT2cVOXIH7mEh9Z";
                strArr[6] = "fCOytc0KevpGl3ysj2Q787tNWhoFoaGa";
                this.A0J.AIM(c2080Zm);
                return;
            case 4:
            case 5:
            case 7:
            case 8:
            default:
                super.A9Y(i, obj);
                return;
            case 6:
                NY ny = (NY) obj;
                InterfaceC1896Rz interfaceC1896Rz = this.A0J;
                String[] strArr2 = A0L;
                if (strArr2[3].length() != strArr2[4].length()) {
                    interfaceC1896Rz.AIO(ny);
                    return;
                } else {
                    A0L[0] = "TPqsn1TvSfs1dbuRYVXV1uVXwUQc5bUD";
                    interfaceC1896Rz.AIO(ny);
                    return;
                }
            case 9:
                this.A0J.AIu(((Boolean) obj).booleanValue());
                return;
            case 10:
                this.A0J.AIN(((Integer) obj).intValue());
                return;
            case 11:
                this.A09 = null;
                return;
            case 12:
                if (AbstractC2471gE.A02 < 23) {
                    return;
                }
                InterfaceC1896Rz interfaceC1896Rz2 = this.A0J;
                if (A0L[1].length() != 10) {
                    String[] strArr3 = A0L;
                    strArr3[2] = "Z4";
                    strArr3[7] = "ThLkK";
                    SS.A00(interfaceC1896Rz2, obj);
                    return;
                }
                throw new RuntimeException();
        }
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass10, com.facebook.ads.redexgen.core.InterfaceC2059Yq
    public final boolean AAE() {
        return super.AAE() && this.A0J.AAE();
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass10, com.facebook.ads.redexgen.core.InterfaceC2059Yq
    public final boolean AAT() {
        return this.A0J.A9e() || super.AAT();
    }

    @Override // com.facebook.ads.redexgen.core.PD
    public final void AIj(C2064Yv c2064Yv) {
        this.A0J.AIj(c2064Yv);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2059Yq, com.facebook.ads.redexgen.core.InterfaceC1854Qi
    public final String getName() {
        return A07(0, 23, 54);
    }
}
