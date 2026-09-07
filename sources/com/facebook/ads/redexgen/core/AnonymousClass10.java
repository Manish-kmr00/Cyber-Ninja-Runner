package com.facebook.ads.redexgen.core;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.SystemClock;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomizations;
import com.google.common.base.Ascii;
import com.json.mediationsdk.logger.IronSourceError;
import com.vungle.ads.internal.protos.Sdk;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.10, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AnonymousClass10 extends AbstractC1568Et {
    public static byte[] A13;
    public static String[] A14 = {"OoD3hUQgPrFFrwO8ECHeD9ucUnIPwTWe", "q2VbVvwIahzZSPBh8sixElhn9uYPYz5C", "Pp53zOtr5gumwXoEargTAvad9TKjOEgM", "5qpQxKR2N4wfCYd38KbkjywhgnJ963hV", "9oxzTu4R5tJcMdmljo9bC2HK97CtRBfK", "Wth5rWysJIg0M3W02ZI4QKscogaIe9F4", "9M43VDTX2MMQLNxVkh2pOgl2SmRW93gu", "qHhlxrTPgn5CkjzgCo9tNZlnZBpXR"};
    public static final byte[] A15;
    public float A00;
    public float A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public long A07;
    public long A08;
    public long A09;
    public long A0A;
    public long A0B;
    public long A0C;
    public MediaFormat A0D;
    public TA A0E;
    public TA A0F;
    public InterfaceC2068Yz A0G;
    public Z2 A0H;
    public Z9 A0I;
    public ZB A0J;
    public String A0K;
    public ByteBuffer A0L;
    public ArrayDeque<Z2> A0M;
    public boolean A0N;
    public boolean A0O;
    public boolean A0P;
    public boolean A0Q;
    public boolean A0R;
    public boolean A0S;
    public boolean A0T;
    public boolean A0U;
    public boolean A0V;
    public boolean A0W;
    public boolean A0X;
    public boolean A0Y;
    public boolean A0Z;
    public boolean A0a;
    public boolean A0b;
    public boolean A0c;
    public boolean A0d;
    public boolean A0e;
    public boolean A0f;
    public boolean A0g;

    @MetaExoPlayerCustomization("Potentially can be removed. Added in D36797879")
    public long A0h;
    public OA A0i;
    public ZM A0j;

    @MetaExoPlayerCustomization(type = {"NEW_CLASS_ARG"}, value = "D57514060: Do not added Dav1dMediaCodecInfo to the list of MediaCodecInfos if it's already added, can be cleaned up after launch")
    public boolean A0k;
    public boolean A0l;
    public boolean A0m;
    public final int A0n;
    public final int A0o;
    public final MediaCodec.BufferInfo A0p;
    public final P6 A0q;
    public final C2014Ww A0r;
    public final C2014Ww A0s;
    public final TO A0t;
    public final ZS A0u;
    public final ArrayDeque<ZB> A0v;
    public final List<Long> A0w;
    public final boolean A0x;
    public final boolean A0y;
    public final boolean A0z;
    public final MediaCodecRendererMetaParameters A10;
    public final C1760Mg A11;

    @MetaExoPlayerCustomization(type = {"TEMPORARY"}, value = "D60404164: Merge init calls in the renderer")
    public final boolean A12;

    public static String A0x(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A13, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A14;
            if (strArr[0].charAt(23) != strArr[5].charAt(23)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A14;
            strArr2[6] = "9TORv4gsetTtojXGR5Ecdz5TvCF4O3Fr";
            strArr2[3] = "AfJj5G27xag0QDWQPIvdRithhIMyf3fV";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 43);
            i4++;
        }
    }

    public static void A15() {
        A13 = new byte[]{-127, 117, -73, -54, -55, 117, -61, -60, 117, -56, -70, -72, -54, -57, -70, 117, -71, -70, -72, -60, -71, -70, -57, 117, -74, -53, -74, -66, -63, -74, -73, -63, -70, -125, 117, -87, -57, -50, -66, -61, -68, 117, -55, -60, 117, -59, -57, -60, -72, -70, -70, -71, 117, -52, -66, -55, -67, 117, -107, -55, -22, -24, -12, -23, -22, -9, -91, -18, -13, -18, -7, -18, -26, -15, -18, -1, -26, -7, -18, -12, -13, -91, -21, -26, -18, -15, -22, -23, -79, -91, -9, -22, -7, -9, -2, -107, -74, -62, -58, -74, -58, -74, 113, -73, -78, -70, -67, -74, -75, 125, 113, -61, -74, -59, -61, -54, -47, -1, -6, -83, 0, -14, 0, 0, -10, -4, -5, -83, -1, -14, -2, 2, -10, -1, -14, 0, -83, 0, -14, -16, 2, -1, -14, -83, -15, -14, -16, -4, -15, -14, -1, -83, -13, -4, -1, -83, -47, -20, -12, -9, -16, -17, -85, -1, -6, -85, -12, -7, -12, -1, -12, -20, -9, -12, 5, -16, -85, -17, -16, -18, -6, -17, -16, -3, -59, -85, -57, -33, -34, -29, -37, -102, -20, -33, -21, -17, -29, -20, -33, -19, -102, -37, -102, -66, -20, -25, -51, -33, -19, -19, -29, -23, -24, -57, -37, -24, -37, -31, -33, -20, 123, -109, -110, -105, -113, 113, -99, -110, -109, -111, -128, -109, -100, -110, -109, -96, -109, -96, -38, -40, -29, -71, -48, 3, 4, -7, -6, -2, -71, -20, 1, -18, -71, -17, -16, -18, -114, -116, -105, 109, -124, -73, -72, -83, -82, -78, 109, -96, -75, -94, 109, -93, -92, -94, 109, -78, -92, -94, -76, -79, -92, -98, -100, -89, 125, -100, -93, -102, 125, -112, -92, -109, -104, -98, 125, -109, -108, -110, -98, -109, -108, -95, 125, -100, -97, -126, -41, -43, -32, -74, -43, -36, -45, -74, -34, -47, -52, -51, -41, -74, -52, -51, -53, -41, -52, -51, -38, -74, -55, -34, -53, -125, -127, -116, 98, -126, -86, -99, -104, -99, -107, 98, -100, 102, 106, 104, 98, -104, -103, -105, -93, -104, -103, -52, -54, -43, -85, -53, -13, -26, -31, -26, -34, -85, -27, -81, -77, -79, -85, -31, -30, -32, -20, -31, -30, -85, -16, -30, -32, -14, -17, -30, -79, -81, -70, -112, -75, -89, -91, -112, -61, -40, -59, -112, -58, -57, -59, -96, -98, -87, 127, -92, -106, -108, 127, -78, -57, -76, 127, -75, -74, -76, 127, -60, -74, -76, -58, -61, -74, -27, -29, -18, -60, -9, 2, 2, Ascii.CR, -1, 4, 4, -5, 8, -60, Ascii.FF, -1, -6, -5, 5, -60, -6, -5, -7, 5, -6, -5, 8, -60, -9, Ascii.FF, -7, -48, -50, -39, -81, -30, -18, -19, -16, -24, -22, -28, -81, -30, -9, -28, -81, -27, -26, -28, -16, -27, -26, -13, -81, -30, -8, -26, -12, -16, -18, -26, -41, -43, -32, -74, -23, -11, -12, -9, -17, -15, -21, -74, -23, -2, -21, -74, -20, -19, -21, -9, -20, -19, -6, -74, -23, -1, -19, -5, -9, -11, -19, -74, -5, -19, -21, -3, -6, -19, -67, -69, -58, -100, -43, -35, -35, -43, -38, -45, -100, -49, -49, -47, -100, -46, -45, -47, -35, -46, -45, -32, -24, -26, -15, -57, 0, 8, 8, 0, 5, -2, -57, Ascii.SI, 8, Ascii.VT, -5, 2, Ascii.FF, -57, -3, -2, -4, 8, -3, -2, Ascii.VT, -78, -80, -69, -111, -43, -50, -111, -39, -52, -57, -56, -46, -62, -57, -56, -58, -46, -57, -56, -43, -111, -60, -39, -58, -124, -90, -103, -102, -103, -90, -90, -103, -104, 84, -104, -103, -105, -93, -104, -103, -90, 84, -99, -94, -89, -88, -107, -94, -88, -99, -107, -88, -99, -93, -94, 84, -102, -107, -99, -96, -103, -104, 98, 84, -121, -96, -103, -103, -92, -99, -94, -101, 84, -88, -100, -103, -94, 84, -90, -103, -88, -90, -83, -99, -94, -101, 98, -100, -106, 118, -118, 126, 122, 121, -128, 122, 90, 110, 98, 95, 93, -35, -41, -73, -47, -62, -70, -70, -29, -35, -67, -38, -57, -64, -64, -35, -41, -73, -34, -65, -62, -65, -57, -52, -59, -46, -46, -55, -48, -111, -57, -45, -39, -46, -40, 8, Ascii.DC4, 19, Ascii.VT, Ascii.SO, Ascii.FF, Ascii.SUB, Ascii.ETB, 10, -24, Ascii.DC4, 9, 10, 8, -96, -81, -94, -98, -79, -94, -128, -84, -95, -94, -96, 119, -13, 1, -16, -8, -3, -48, -3, -13, -43, -12, -12, -13, -68, -62, -59, -53, -60, -70, -69, -56, -50, -44, -41, -35, -42, -52, -51, -38, -57, -44, -36, -51, -11, -13, 2, -27, 0, -17, -2, -2, -13, -14, -37, -13, -14, -9, -17, -47, 0, 7, -2, 2, -3, -18, -7, -10, -4, -9, -20, -7, -84, -90, 118, 116, 116, 116, -34, -37, -33, -35, -34, -22, 3, -5, 10, -9, -60, -6, -9, Ascii.FF, -57, -6, -60, -9, Ascii.FF, -57, -60, -6, -5, -7, 5, -6, -5, 8, -26, -25, -44, -27, -25, -74, -30, -41, -40, -42, Ascii.NAK, 10, Ascii.CR, 2, 17, 10, 2, Ascii.US, Ascii.DC2, Ascii.CR, Ascii.SO, Ascii.CAN, -40, 10, Ascii.US, -39, -38, Ascii.CR, 0, -5, -4, 6, -58, -5, 6, 3, -7, Ascii.DLE, -60, Ascii.CR, 0, 10, 0, 6, 5, Ascii.GS, Ascii.SI, 10, Ascii.SUB, Ascii.SO};
    }

    public abstract int A1g(InterfaceC2068Yz interfaceC2068Yz, Z2 z2, ZM zm, ZM zm2);

    public abstract int A1h(ZS zs, TO to, ZM zm) throws ZW;

    public abstract List<Z2> A1l(ZS zs, ZM zm, boolean z) throws ZW;

    public abstract void A1u(C2014Ww c2014Ww);

    public abstract void A1v(@MetaExoPlayerCustomization InterfaceC2068Yz interfaceC2068Yz, MediaFormat mediaFormat) throws EK;

    public abstract void A1w(Z2 z2, InterfaceC2068Yz interfaceC2068Yz, ZM zm, MediaCrypto mediaCrypto) throws ZW;

    @MetaExoPlayerCustomization("D45988204: [FBLite][Video] Add Codec Hooks for Logging")
    public abstract void A1x(String str);

    public abstract void A1y(String str, long j, long j2);

    public abstract boolean A22();

    public abstract boolean A23(long j, long j2, InterfaceC2068Yz interfaceC2068Yz, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z, boolean z2) throws EK;

    static {
        A15();
        A15 = new byte[]{0, 0, 1, 103, 66, -64, Ascii.VT, -38, 37, -112, 0, 0, 1, 104, -50, Ascii.SI, 19, 32, 0, 0, 1, 101, -120, -124, Ascii.CR, -50, 113, Ascii.CAN, -96, 0, 47, -65, Ascii.FS, 49, -61, 39, 93, 120};
    }

    public AnonymousClass10(int i, C1760Mg c1760Mg, MediaCodecRendererMetaParameters mediaCodecRendererMetaParameters, ZS zs, TO to, boolean z, boolean z2, int i2, int i3) {
        super(i);
        this.A09 = -9223372036854775807L;
        this.A08 = -9223372036854775807L;
        this.A0m = false;
        this.A0k = false;
        AbstractC2388es.A08(AbstractC2471gE.A02 >= 16);
        this.A11 = (C1760Mg) AbstractC2388es.A01(c1760Mg);
        this.A10 = (MediaCodecRendererMetaParameters) AbstractC2388es.A01(mediaCodecRendererMetaParameters);
        this.A0u = (ZS) AbstractC2388es.A01(zs);
        this.A0t = to;
        this.A0z = z;
        this.A0x = z2;
        this.A0o = i2;
        this.A0n = i3;
        this.A0r = new C2014Ww(0);
        this.A0s = C2014Ww.A02();
        this.A0q = new P6();
        this.A0w = new ArrayList();
        this.A0p = new MediaCodec.BufferInfo();
        this.A00 = 1.0f;
        this.A01 = 1.0f;
        this.A0v = new ArrayDeque<>();
        A18(ZB.A04);
        this.A03 = 0;
        this.A04 = 0;
        this.A0A = -9223372036854775807L;
        this.A0B = -9223372036854775807L;
        this.A0C = -9223372036854775807L;
        this.A0y = MetaExoPlayerUpgradeConfig.A03(EnumC1764Mn.A1j);
        this.A12 = MetaExoPlayerUpgradeConfig.A03(EnumC1764Mn.A1U);
    }

    private int A0w(String str) {
        if (AbstractC2471gE.A02 <= 25 && A0x(256, 25, 20).equals(str) && (AbstractC2471gE.A06.startsWith(A0x(681, 7, 95)) || AbstractC2471gE.A06.startsWith(A0x(653, 7, 30)) || AbstractC2471gE.A06.startsWith(A0x(660, 7, 2)) || AbstractC2471gE.A06.startsWith(A0x(674, 7, 101)))) {
            return 2;
        }
        if (AbstractC2471gE.A02 < 24) {
            if (!A0x(331, 22, 9).equals(str) && !A0x(353, 29, 82).equals(str)) {
                return 0;
            }
            String str2 = AbstractC2471gE.A03;
            if (A14[2].charAt(24) != '9') {
                throw new RuntimeException();
            }
            String[] strArr = A14;
            strArr[0] = "gnzJwAISQjMOqd2NpKTj0H6c1j3UUSfk";
            strArr[5] = "7RIPIFML4eYXrQIkUKlmvltc2OxxU33E";
            if (!A0x(739, 8, 43).equals(str2)) {
                if (!A0x(747, 12, 61).equals(AbstractC2471gE.A03)) {
                    if (!A0x(780, 7, 92).equals(AbstractC2471gE.A03)) {
                        if (A0x(831, 7, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE).equals(AbstractC2471gE.A03)) {
                            return 1;
                        }
                        return 0;
                    }
                    return 1;
                }
                return 1;
            }
            return 1;
        }
        return 0;
    }

    private ByteBuffer A0y(int i) {
        return this.A0G.A89(i);
    }

    private ByteBuffer A0z(int i) {
        return this.A0G.A8U(i);
    }

    private List<Z2> A10(boolean z) throws ZW {
        String alternativeMimeType;
        List<Z2> listA1l = A1l(this.A0u, this.A0j, z);
        if (listA1l.isEmpty() && z) {
            listA1l = A1l(this.A0u, this.A0j, false);
            if (!listA1l.isEmpty()) {
                AbstractC2432fb.A07(A0x(Sdk.SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE, 18, 3), A0x(116, 40, 98) + this.A0j.A0W + A0x(0, 58, 42) + listA1l + A0x(58, 1, 60));
            }
        }
        if (listA1l.isEmpty() && this.A0l && (alternativeMimeType = ZZ.A0P(this.A0j)) != null) {
            List<Z2> listA7e = this.A0u.A7e(alternativeMimeType, false, false);
            if (AbstractC2471gE.A02 >= 26) {
                if (A0x(848, 18, 108).equals(this.A0j.A0W) && !listA7e.isEmpty()) {
                    return listA7e;
                }
                return listA1l;
            }
            return listA1l;
        }
        return listA1l;
    }

    private void A11() throws EK {
        if (this.A04 == 2) {
            A1n();
            A1p();
        } else {
            this.A0b = true;
            A1o();
        }
    }

    private void A12() throws EK {
        MediaFormat mediaFormatA8V = this.A0G.A8V();
        if (this.A02 != 0 && mediaFormatA8V.getInteger(A0x(866, 5, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE)) == 32 && mediaFormatA8V.getInteger(A0x(793, 6, 75)) == 32) {
            this.A0c = true;
            return;
        }
        if (this.A0T) {
            mediaFormatA8V.setInteger(A0x(688, 13, 57), 1);
        }
        this.A0D = mediaFormatA8V;
        this.A0U = true;
        A1v(this.A0G, mediaFormatA8V);
    }

    private void A13() {
        this.A05 = -1;
        this.A0r.A02 = null;
    }

    private void A14() {
        this.A06 = -1;
        this.A0L = null;
    }

    @MetaExoPlayerCustomizations({@MetaExoPlayerCustomization("Call to 'forceDisableAsynchronous'"), @MetaExoPlayerCustomization("D45988204: [FBLite][Video] Add Codec Hooks for Logging"), @MetaExoPlayerCustomization(type = {"TEMPORARY"}, value = "D60404164: Merge init calls in the renderer")})
    private void A16(Z2 z2, MediaCrypto mediaCrypto) throws Exception {
        InterfaceC2068Yz interfaceC2068YzA0K = null;
        String str = z2.A03;
        try {
            if (this.A12) {
                A1z(str, this.A0j);
            } else {
                A1t(this.A0j);
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (!this.A12) {
                A1x(str);
            }
            AbstractC2462g5.A02(A0x(IronSourceError.ERROR_NT_LOAD_NO_CONFIG, 12, 18) + str);
            new C1881Rk().A00();
            interfaceC2068YzA0K = Z6.A04().A0K(A22(), this.A11, this.A10.getA00(), EnumC1757Mb.A05, str);
            try {
                this.A0K = str;
                AbstractC2462g5.A00();
                AbstractC2462g5.A02(A0x(701, 14, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE));
                try {
                    A1w(z2, interfaceC2068YzA0K, this.A0j, mediaCrypto);
                    AbstractC2462g5.A00();
                    AbstractC2462g5.A02(A0x(821, 10, 72));
                    interfaceC2068YzA0K.start();
                    AbstractC2462g5.A00();
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    this.A0G = interfaceC2068YzA0K;
                    this.A0H = z2;
                    A1y(str, jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
                } catch (Exception e) {
                    e = e;
                    if (interfaceC2068YzA0K != null) {
                        interfaceC2068YzA0K.AGj();
                    }
                    throw e;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "D53064452: Add decoder init time failure thread sleep")
    private void A17(Z2 z2, Z2 z3, MediaCrypto mediaCrypto) throws Exception {
        int iA00 = MetaExoPlayerUpgradeConfig.A00(EnumC1765Mo.A06);
        if (iA00 >= 0) {
            try {
                A16(z3, mediaCrypto);
                return;
            } catch (Exception e) {
                if (z3 == z2) {
                    AbstractC2432fb.A07(A0x(Sdk.SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE, 18, 3), A0x(590, 63, 9));
                    Thread.sleep(iA00);
                    A16(z3, mediaCrypto);
                    return;
                }
                throw e;
            }
        }
        A16(z3, mediaCrypto);
    }

    private void A18(ZB zb) {
        this.A0J = zb;
        if (zb.A02 != -9223372036854775807L) {
            this.A0a = true;
        }
    }

    private boolean A19() {
        if (this.A0n <= 0) {
            return false;
        }
        boolean z = this.A08 == -9223372036854775807L || System.currentTimeMillis() - this.A08 <= ((long) this.A0n);
        if (this.A08 == -9223372036854775807L) {
            AbstractC2432fb.A07(A0x(Sdk.SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE, 18, 3), A0x(95, 21, 38));
            try {
                this.A0M = null;
                A1n();
            } catch (IllegalStateException unused) {
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (A14[2].charAt(24) != '9') {
                throw new RuntimeException();
            }
            String[] strArr = A14;
            strArr[1] = "Q4MpamSuL85iJ4LieLOuDunWx78uflZU";
            strArr[4] = "LSkMpxDVSEyRzVZUteVftDEthtoIL7mt";
            this.A08 = jCurrentTimeMillis;
        }
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0054  */
    /* JADX WARN: Code duplicated, block: B:19:0x0060 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x006b  */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0262, code lost:
    
        if (r13.A0r.A02.position() == 0) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0264, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x027c, code lost:
    
        if (r13.A0r.A02.position() == 0) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x027f, code lost:
    
        r13.A0O = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A1A() throws com.facebook.ads.redexgen.core.EK {
        /*
            Method dump skipped, instruction units count: 744
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AnonymousClass10.A1A():boolean");
    }

    private boolean A1B() {
        return this.A06 >= 0;
    }

    private boolean A1C(int i) throws EK {
        P6 p6A1U = A1U();
        this.A0s.A0A();
        int iA1R = A1R(p6A1U, this.A0s, i | 4);
        if (iA1R == -5) {
            A1s(p6A1U.A00);
            return true;
        }
        if (iA1R == -4 && this.A0s.A05()) {
            this.A0Y = true;
            A11();
            return false;
        }
        return false;
    }

    private boolean A1D(long j) {
        int size = this.A0w.size();
        for (int i = 0; i < size; i++) {
            if (this.A0w.get(i).longValue() == j) {
                this.A0w.remove(i);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00b0  */
    private boolean A1E(long j, long j2) throws EK {
        boolean z;
        boolean processedOutputBuffer;
        int iA5k;
        if (!A1B()) {
            boolean z2 = this.A0Q;
            String[] strArr = A14;
            if (strArr[1].charAt(0) == strArr[4].charAt(0)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A14;
            strArr2[1] = "WX7DMTu3dXhbsd2sPnhTkUjPk51ExtdH";
            strArr2[4] = "zhVW06xX83MtOvzQTjNZl3oD0mRs55eP";
            if (!z2 || !this.A0W) {
                iA5k = this.A0G.A5k(this.A0p);
            } else {
                try {
                    iA5k = this.A0G.A5k(this.A0p);
                } catch (IllegalStateException unused) {
                    A11();
                    if (this.A0b) {
                        A1n();
                    }
                    return false;
                }
            }
            if (iA5k >= 0) {
                if (this.A0c) {
                    this.A0c = false;
                    this.A0G.AGq(iA5k, false);
                    return true;
                }
                int i = this.A0p.size;
                if (A14[2].charAt(24) != '9') {
                    throw new RuntimeException();
                }
                A14[7] = "g98vNDbvUiuhZ8EdyIUnWSUTev1Tr";
                if (i == 0) {
                    int outputIndex = this.A0p.flags;
                    if ((outputIndex & 4) != 0) {
                        A11();
                        return false;
                    }
                }
                this.A06 = iA5k;
                this.A0L = A0z(iA5k);
                if (this.A0L != null) {
                    ByteBuffer byteBuffer = this.A0L;
                    int outputIndex2 = this.A0p.offset;
                    byteBuffer.position(outputIndex2);
                    ByteBuffer byteBuffer2 = this.A0L;
                    int i2 = this.A0p.offset;
                    int outputIndex3 = this.A0p.size;
                    byteBuffer2.limit(i2 + outputIndex3);
                }
                this.A0d = A1D(this.A0p.presentationTimeUs);
                this.A0Z = this.A0B == this.A0p.presentationTimeUs;
            } else {
                if (iA5k == -2) {
                    A12();
                    return true;
                }
                if (iA5k == -3) {
                    return true;
                }
                if (this.A0R) {
                    boolean z3 = this.A0Y;
                    String[] strArr3 = A14;
                    String str = strArr3[0];
                    String str2 = strArr3[5];
                    int iCharAt = str.charAt(23);
                    int outputIndex4 = str2.charAt(23);
                    if (iCharAt == outputIndex4) {
                        A14[7] = "TZ0pgHXAE5E1yu9yE89qTbsh35nXk";
                        if (!z3) {
                            if (this.A04 == 2) {
                            }
                        }
                    } else if (!z3) {
                        if (this.A04 == 2) {
                        }
                    }
                    A11();
                }
                return false;
            }
        }
        if (this.A0Q && this.A0W) {
            try {
                z = false;
                try {
                    processedOutputBuffer = A23(j, j2, this.A0G, this.A0L, this.A06, this.A0p.flags, this.A0p.presentationTimeUs, this.A0d, this.A0Z);
                } catch (IllegalStateException unused2) {
                    A11();
                    if (this.A0b) {
                        A1n();
                    }
                    return z;
                }
            } catch (IllegalStateException unused3) {
                z = false;
            }
        } else {
            z = false;
            InterfaceC2068Yz interfaceC2068Yz = this.A0G;
            ByteBuffer byteBuffer3 = this.A0L;
            int i3 = this.A06;
            int i4 = this.A0p.flags;
            if (A14[2].charAt(24) == '9') {
                String[] strArr4 = A14;
                strArr4[6] = "d9dCJA0SI9NwiuRJ0PjYSXqCGui8O3dO";
                strArr4[3] = "E7OJBEPhyl2roEVmIM1xnaqF3kUL33xV";
                long j3 = this.A0p.presentationTimeUs;
                boolean isEndOfStream = this.A0d;
                boolean processedOutputBuffer2 = this.A0Z;
                processedOutputBuffer = A23(j, j2, interfaceC2068Yz, byteBuffer3, i3, i4, j3, isEndOfStream, processedOutputBuffer2);
            } else {
                processedOutputBuffer = A23(j, j2, interfaceC2068Yz, byteBuffer3, i3, i4, this.A0p.presentationTimeUs, this.A0d, this.A0Z);
            }
        }
        if (processedOutputBuffer) {
            A1q(this.A0p.presentationTimeUs);
            boolean processedOutputBuffer3 = (this.A0p.flags & 4) != 0;
            A14();
            if (!processedOutputBuffer3) {
                return true;
            }
            A11();
        }
        return z;
    }

    private boolean A1F(MediaCrypto mediaCrypto, boolean z) throws Z9 {
        if (this.A0M == null) {
            try {
                List<Z2> listA10 = A10(z);
                if (this.A0x) {
                    this.A0M = new ArrayDeque<>(listA10);
                } else {
                    this.A0M = new ArrayDeque<>(Collections.singletonList(listA10.get(0)));
                }
                this.A0I = null;
            } catch (ZW e) {
                throw new Z9(this.A0j, e, z, -49998);
            }
        }
        if (!this.A0k && A21()) {
            this.A0M.addFirst(Z2.A02(A0x(799, 22, 107), this.A0j.A0W, this.A0j.A0W, null, false, true, false, false, false));
        }
        if (!this.A0M.isEmpty()) {
            Z2 z2PeekFirst = this.A0M.peekFirst();
            do {
                Z2 z2PeekFirst2 = this.A0M.peekFirst();
                if (!A25(z2PeekFirst2)) {
                    return false;
                }
                try {
                    A17(z2PeekFirst, z2PeekFirst2, mediaCrypto);
                    return true;
                } catch (Exception e2) {
                    AbstractC2432fb.A0A(A0x(Sdk.SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE, 18, 3), A0x(156, 30, 96) + z2PeekFirst2, e2);
                    this.A0M.removeFirst();
                    Z9 z9 = new Z9(this.A0j, e2, z, z2PeekFirst2);
                    if (this.A0I == null) {
                        this.A0I = z9;
                    } else {
                        this.A0I = this.A0I.A00(z9);
                    }
                }
            } while (!this.A0M.isEmpty());
            throw this.A0I;
        }
        throw new Z9(this.A0j, (Throwable) null, z, -49999);
    }

    public static boolean A1G(ZM zm) {
        return zm.A07 == 0 || zm.A07 == 2;
    }

    public static boolean A1H(Z2 z2) {
        String str = z2.A03;
        if (AbstractC2471gE.A02 <= 17) {
            String[] strArr = A14;
            if (strArr[6].charAt(29) != strArr[3].charAt(29)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A14;
            strArr2[0] = "Dh5gFYVTv0cqWq9YiaFEkCLc3B9gYsdG";
            strArr2[5] = "bmSfnSe7jv5poQp2oZzmqzpcoNrfPftO";
            String name = A0x(566, 24, 56);
            if (!name.equals(str)) {
                String name2 = A0x(419, 31, 107);
                if (name2.equals(str)) {
                }
            }
            return true;
        }
        return false;
    }

    public static boolean A1I(String str) {
        if (AbstractC2471gE.A02 > 23 || !A0x(541, 25, 110).equals(str)) {
            if (AbstractC2471gE.A02 <= 19) {
                String str2 = AbstractC2471gE.A03;
                if (A14[2].charAt(24) != '9') {
                    throw new RuntimeException();
                }
                String[] strArr = A14;
                strArr[0] = "KmYu75IlDAU87UyZtW1ThwRcmAw5W1Np";
                strArr[5] = "U7cJbeNNmChJwVdWZhAYB9Mc4aX30Owk";
                if (!A0x(787, 6, 25).equals(str2) || (!A0x(450, 31, 86).equals(str) && !A0x(481, 38, 93).equals(str))) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean A1J(String str) {
        return AbstractC2471gE.A02 == 21 && A0x(519, 22, 67).equals(str);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x005a  */
    /* JADX WARN: Code duplicated, block: B:16:0x006a  */
    /* JADX WARN: Code duplicated, block: B:18:0x007b  */
    /* JADX WARN: Code duplicated, block: B:23:0x0094  */
    /* JADX WARN: Code duplicated, block: B:25:0x009f  */
    public static boolean A1K(String str) {
        int i;
        if (AbstractC2471gE.A02 >= 18) {
            int i2 = AbstractC2471gE.A02;
            if (A14[2].charAt(24) != '9') {
                throw new RuntimeException();
            }
            String[] strArr = A14;
            strArr[0] = "vlVT2N2U5T0gZH7fXy0w8egcpxlFLscz";
            strArr[5] = "6anGbGx0fx5RXUQkV3Jv7Focx8t8fygB";
            if (i2 != 18) {
                i = AbstractC2471gE.A02;
                if (A14[2].charAt(24) != '9') {
                    throw new RuntimeException();
                }
                A14[7] = "Sjifj9tgaQXcctvFEVu8PGQg30tAd";
                if (i == 19) {
                }
                return false;
            }
            String strA0x = A0x(382, 15, 55);
            String[] strArr2 = A14;
            if (strArr2[1].charAt(0) != strArr2[4].charAt(0)) {
                String[] strArr3 = A14;
                strArr3[1] = "8yjr9E9X5f2zWMVBajh0ju3thozfHrOE";
                strArr3[4] = "rlbJf9SuQAaRuV1arfQVXiP5yHX7Bris";
                if (!strA0x.equals(str)) {
                    if (!A0x(397, 22, 38).equals(str)) {
                        i = AbstractC2471gE.A02;
                        if (A14[2].charAt(24) != '9') {
                            throw new RuntimeException();
                        }
                        A14[7] = "Sjifj9tgaQXcctvFEVu8PGQg30tAd";
                        if (i == 19 || !AbstractC2471gE.A06.startsWith(A0x(667, 7, 95)) || (!A0x(238, 18, 96).equals(str) && !A0x(256, 25, 20).equals(str))) {
                            return false;
                        }
                    }
                }
            } else {
                String[] strArr4 = A14;
                strArr4[1] = "GdmiuaDAsM7j2OCsuvCB1oZTImGQHOLM";
                strArr4[4] = "b0J8rZ3bdGAHJkYyeQImmVgmbplkztxB";
                if (!strA0x.equals(str)) {
                    if (!A0x(397, 22, 38).equals(str)) {
                        i = AbstractC2471gE.A02;
                        if (A14[2].charAt(24) != '9') {
                            throw new RuntimeException();
                        }
                        A14[7] = "Sjifj9tgaQXcctvFEVu8PGQg30tAd";
                        if (i == 19) {
                        }
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean A1L(String str, ZM zm) {
        return AbstractC2471gE.A02 < 21 && zm.A0X.isEmpty() && A0x(306, 25, 93).equals(str);
    }

    public static boolean A1M(String str, ZM zm) {
        return AbstractC2471gE.A02 <= 18 && zm.A06 == 1 && A0x(281, 25, 36).equals(str);
    }

    private boolean A1N(boolean z) throws EK {
        if (this.A0E == null || (!z && this.A0z)) {
            return false;
        }
        int iA90 = this.A0E.A90();
        if (iA90 != 1) {
            return iA90 != 4;
        }
        T8 t8 = (T8) AbstractC2388es.A01(this.A0E.A7q());
        T8 t8A7q = this.A0E.A7q();
        ZM zm = this.A0j;
        int drmSessionState = t8.A00;
        throw A1S(t8A7q, zm, drmSessionState);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1568Et
    public void A1X() {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1568Et
    public void A1Y() {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1568Et
    public void A1Z() {
        this.A0j = null;
        A18(ZB.A04);
        this.A0v.clear();
        this.A0M = null;
        try {
            A1n();
            try {
                if (this.A0E != null) {
                    this.A0E.AGk(null);
                }
                try {
                    if (this.A0F != null && this.A0F != this.A0E) {
                        this.A0F.AGk(null);
                    }
                } finally {
                    this.A0E = null;
                    this.A0F = null;
                }
            } catch (Throwable th) {
                try {
                    if (this.A0F != null && this.A0F != this.A0E) {
                        this.A0F.AGk(null);
                    }
                    throw th;
                } finally {
                    this.A0E = null;
                    this.A0F = null;
                }
            }
        } catch (Throwable th2) {
            try {
                if (this.A0E != null) {
                    this.A0E.AGk(null);
                }
                try {
                    if (this.A0F != null && this.A0F != this.A0E) {
                        this.A0F.AGk(null);
                    }
                    throw th2;
                } finally {
                    this.A0E = null;
                    this.A0F = null;
                }
            } catch (Throwable th3) {
                try {
                    if (this.A0F != null && this.A0F != this.A0E) {
                        this.A0F.AGk(null);
                    }
                    throw th3;
                } finally {
                    this.A0E = null;
                    this.A0F = null;
                }
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1568Et
    public void A1a(long j, boolean z) throws EK {
        this.A0Y = false;
        this.A0b = false;
        if (this.A0G != null) {
            A1m();
        }
        if (this.A0J.A03.A01() > 0) {
            this.A0e = true;
        }
        this.A0J.A03.A02();
        this.A0v.clear();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1568Et
    @MetaExoPlayerCustomization("D36797879: Adding implementation for calculating avg render time")
    public void A1b(boolean z, boolean z2) throws EK {
        this.A0i = new OA();
        this.A0h = 0L;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1568Et
    public void A1c(ZM[] zmArr, long j, long j2) throws EK {
    }

    public final float A1f() {
        return this.A00;
    }

    public final long A1i() {
        return this.A0J.A02;
    }

    public final InterfaceC2068Yz A1j() {
        return this.A0G;
    }

    public final Z2 A1k() {
        return this.A0H;
    }

    public void A1m() throws EK {
        this.A07 = -9223372036854775807L;
        A13();
        A14();
        this.A0f = true;
        this.A0g = false;
        this.A0d = false;
        this.A0w.clear();
        this.A0N = false;
        this.A0c = false;
        this.A0Z = false;
        this.A0C = -9223372036854775807L;
        this.A0B = -9223372036854775807L;
        if (this.A0S) {
            A1n();
            A1p();
        } else {
            boolean z = this.A0P;
            if (A14[2].charAt(24) != '9') {
                throw new RuntimeException();
            }
            String[] strArr = A14;
            strArr[6] = "zoNignRVnifI3Zm4xgdJx0R81x7hJ3HR";
            strArr[3] = "d976PP5zRUwEFmO2pIQLdKGEi3eBb3N0";
            if ((z && this.A0W) || A20() || this.A04 != 0) {
                A1n();
                A1p();
            } else {
                this.A0G.flush();
                this.A0V = false;
            }
        }
        if (this.A0X && this.A0j != null) {
            this.A03 = 1;
        }
    }

    public void A1n() {
        this.A07 = -9223372036854775807L;
        this.A09 = -9223372036854775807L;
        this.A08 = -9223372036854775807L;
        A13();
        A14();
        this.A0D = null;
        this.A0U = false;
        this.A0g = false;
        this.A0d = false;
        this.A0w.clear();
        this.A0H = null;
        this.A0X = false;
        this.A0V = false;
        this.A0O = false;
        this.A0S = false;
        this.A02 = 0;
        this.A0R = false;
        this.A0P = false;
        this.A0T = false;
        this.A0N = false;
        this.A0c = false;
        this.A0W = false;
        this.A03 = 0;
        this.A04 = 0;
        if (this.A0G != null) {
            this.A0i.A03++;
            try {
                Z6.A04().A0L(A22(), this.A11, this.A10.getA00(), EnumC1757Mb.A05, this.A0K, this.A0G);
                this.A0G = null;
                if (this.A0E != null && this.A0F != this.A0E) {
                    try {
                        this.A0E.AGk(null);
                    } finally {
                        this.A0E = null;
                        this.A0K = null;
                    }
                }
            } catch (Throwable th) {
                this.A0G = null;
                if (this.A0E != null && this.A0F != this.A0E) {
                    try {
                        this.A0E.AGk(null);
                        this.A0E = null;
                        if (A14[7].length() != 29) {
                            throw new RuntimeException();
                        }
                        A14[2] = "ZV0ENIG6SxSATEXmI29uLGlE9g1IIFsN";
                        this.A0K = null;
                    } catch (Throwable th2) {
                        this.A0E = null;
                        this.A0K = null;
                        throw th2;
                    }
                }
                throw th;
            }
        }
    }

    public void A1o() throws EK {
    }

    public final void A1p() throws EK {
        long jElapsedRealtime;
        if (this.A0G != null || this.A0j == null) {
            return;
        }
        this.A0E = this.A0F;
        if (this.A0E != null) {
            this.A0E.A7L();
            if (0 == 0) {
                if (this.A0E.A7q() == null) {
                    return;
                }
            } else {
                throw new NullPointerException(A0x(759, 21, 99));
            }
        }
        try {
            if (!A1F(null, false)) {
                return;
            }
            String str = this.A0H.A03;
            this.A02 = A0w(str);
            this.A0O = A1L(str, this.A0j);
            this.A0S = A1K(str);
            this.A0R = A1H(this.A0H);
            this.A0P = A1I(str);
            this.A0Q = A1J(str);
            String[] strArr = A14;
            if (strArr[0].charAt(23) != strArr[5].charAt(23)) {
                throw new RuntimeException();
            }
            A14[2] = "v0D91NWRCj72UoKpAwpZitPy9fD0oWph";
            this.A0T = A1M(str, this.A0j);
            if (A90() == 2) {
                jElapsedRealtime = SystemClock.elapsedRealtime() + 1000;
            } else {
                jElapsedRealtime = -9223372036854775807L;
            }
            this.A07 = jElapsedRealtime;
            A13();
            A14();
            this.A09 = -9223372036854775807L;
            this.A0f = true;
            this.A0i.A02++;
            String[] strArr2 = A14;
            if (strArr2[0].charAt(23) != strArr2[5].charAt(23)) {
                return;
            }
            A14[7] = "d0gB5d3Rle0lrUWV3sYUunKuYNR67";
        } catch (Z9 e) {
            if (this.A0o > 0 && (this.A09 == -9223372036854775807L || System.currentTimeMillis() - this.A09 <= this.A0o)) {
                if (this.A09 == -9223372036854775807L) {
                    String strA0x = A0x(Sdk.SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE, 18, 3);
                    String mimeType = A0x(59, 36, 90);
                    AbstractC2432fb.A07(strA0x, mimeType);
                    this.A09 = System.currentTimeMillis();
                }
                if (this.A0M != null && this.A0M.isEmpty()) {
                    this.A0M = null;
                    return;
                }
                return;
            }
            throw A1S(e, this.A0j, 4001);
        }
    }

    public void A1q(long j) {
    }

    @MetaExoPlayerCustomization("Needed for sr video effects")
    public void A1r(ZM zm) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00cf, code lost:
    
        if (r7.A0V != false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00d1, code lost:
    
        r7.A04 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d3, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00dd, code lost:
    
        if (r7.A0V != false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e0, code lost:
    
        A1n();
        A1p();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A1s(com.facebook.ads.redexgen.core.ZM r8) throws com.facebook.ads.redexgen.core.EK {
        /*
            Method dump skipped, instruction units count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AnonymousClass10.A1s(com.facebook.ads.redexgen.X.ZM):void");
    }

    public void A1t(ZM zm) throws EK {
    }

    public void A1z(String str, ZM zm) throws EK {
        A1t(zm);
    }

    public boolean A20() {
        return false;
    }

    public final boolean A21() {
        return A24(this.A0j);
    }

    public final boolean A24(ZM zm) {
        if (zm == null || !this.A0m || !A0x(838, 10, 126).equalsIgnoreCase(zm.A0W)) {
            return false;
        }
        return true;
    }

    public boolean A25(Z2 z2) {
        return true;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2059Yq
    public boolean AAE() {
        return this.A0b;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2059Yq
    @MetaExoPlayerCustomization("D18870411: Adding start stall debug reason")
    public boolean AAT() {
        if (this.A0j == null) {
            super.A0B = MI.A07;
        } else {
            boolean z = this.A0g;
            String[] strArr = A14;
            if (strArr[6].charAt(29) == strArr[3].charAt(29)) {
                A14[7] = "RFgbLL7LsnviIscfhp0QOuOvBFSGb";
                if (z) {
                    MI mi = MI.A0A;
                    if (A14[7].length() == 29) {
                        String[] strArr2 = A14;
                        strArr2[6] = "ts0W2C1JQFOuLMCdKvVZ7al9Y4LXT3rb";
                        strArr2[3] = "o0XvOJavr7iwEI36oKR6gRzbuz2fc3Xx";
                        super.A0B = mi;
                    }
                } else if (!A1d() && !A1B()) {
                    super.A0B = MI.A06;
                }
            }
            throw new RuntimeException();
        }
        if (this.A0j != null && !this.A0g) {
            if (!A1d() && !A1B()) {
                if (this.A07 != -9223372036854775807L) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    long j = this.A07;
                    String[] strArr3 = A14;
                    if (strArr3[1].charAt(0) != strArr3[4].charAt(0)) {
                        String[] strArr4 = A14;
                        strArr4[1] = "4duWCqbcI26RTRGCnsQSheQjDKhqEP5z";
                        strArr4[4] = "x1WntWfuzjT8gW0yw38JomljRkRGj2XF";
                        if (jElapsedRealtime < j) {
                        }
                    }
                    throw new RuntimeException();
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2059Yq
    public void AHd(long j, long j2) throws EK {
        if (this.A0b) {
            A1o();
            return;
        }
        if (this.A0j == null && !A1C(2)) {
            return;
        }
        A1p();
        String[] strArr = A14;
        if (strArr[0].charAt(23) != strArr[5].charAt(23)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A14;
        strArr2[6] = "RrIuGbpVwBdCQnVAqzfbiwf9RJMol3Gl";
        strArr2[3] = "TDG5L5AVX1yJIELoGBHwsBDTbvGwy3kA";
        if (this.A0G != null) {
            try {
                try {
                    AbstractC2462g5.A02(A0x(727, 12, 100));
                    while (A1E(j, j2)) {
                    }
                    while (A1A()) {
                    }
                    this.A08 = -9223372036854775807L;
                } catch (IllegalStateException e) {
                    if (!A19()) {
                        throw A1S(e, this.A0j, 4003);
                    }
                }
                AbstractC2462g5.A00();
            } catch (Throwable e2) {
                AbstractC2462g5.A00();
                throw e2;
            }
        } else {
            this.A0i.A0A += A1Q(j);
            A1C(1);
        }
        this.A0i.A02();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1854Qi
    public final int AJR(ZM zm) throws EK {
        try {
            return A1h(this.A0u, this.A0t, zm);
        } catch (ZW e) {
            throw A1S(e, zm, 4002);
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1568Et, com.facebook.ads.redexgen.core.InterfaceC1854Qi
    public final int AJT() {
        return 8;
    }
}
