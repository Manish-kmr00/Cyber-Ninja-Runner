package com.facebook.ads.redexgen.core;

import com.google.android.exoplayer2.Metadata;
import com.google.android.exoplayer2.extractor.metadata.icy.IcyInfo;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class BT extends V4 {
    public static byte[] A02;
    public static String[] A03 = {"YAZ11", "yuuZExJFo5xDYmIScEYRiBhSTxCVyxA5", "34EzuySigAKtUUageJOSWfSF22bag92r", "oZpbHvv9l0FuX31xY", "cioy8VfyPMJlLYx4Hx9l1nQbmZiIZnM2", "wBuvaKPA0Xld3lJMF98Y4veGuviBi5wB", "sCnVmEJhEomX1m2A7h0t6mhxYUB5gbCg", "vBBtJx5dH6La2WFcTEBhE3l3Mnm8AgsS"};
    public static final Pattern A04;
    public final CharsetDecoder A01 = AbstractC2557hd.A06.newDecoder();
    public final CharsetDecoder A00 = AbstractC2557hd.A01.newDecoder();

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 8);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{2, 4, 1, Ascii.NAK, 3, Ascii.ETB, Ascii.CR, 2, 4, 0, Ascii.NAK, 3, Ascii.CR, 17, 120, 127, 121, 110, 106, 102, 127, 98, 127, 103, 110, 55, 48, 54, 33, 37, 41, 49, 54, 40};
    }

    static {
        A02();
        A04 = Pattern.compile(A00(0, 14, 34), 32);
    }

    private String A01(ByteBuffer byteBuffer) {
        try {
            String string = this.A01.decode(byteBuffer).toString();
            this.A01.reset();
            byteBuffer.rewind();
            return string;
        } catch (CharacterCodingException unused) {
            this.A01.reset();
            byteBuffer.rewind();
            try {
                return this.A00.decode(byteBuffer).toString();
            } catch (CharacterCodingException unused2) {
                return null;
            } finally {
                this.A00.reset();
                byteBuffer.rewind();
            }
        } catch (Throwable th) {
            this.A01.reset();
            byteBuffer.rewind();
            throw th;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:15:0x0061  */
    @Override // com.facebook.ads.redexgen.core.V4
    public final Metadata A0R(Bi bi, ByteBuffer byteBuffer) {
        byte b;
        String strA01 = A01(byteBuffer);
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        if (strA01 == null) {
            return new Metadata(new IcyInfo(bArr, null, null));
        }
        String url = null;
        String str = null;
        Matcher matcher = A04.matcher(strA01);
        for (int iEnd = 0; matcher.find(iEnd); iEnd = matcher.end()) {
            String strGroup = matcher.group(1);
            String strGroup2 = matcher.group(2);
            if (strGroup != null) {
                String key = AbstractC2555hb.A01(strGroup);
                int iHashCode = key.hashCode();
                String[] strArr = A03;
                if (strArr[2].charAt(19) == strArr[4].charAt(19)) {
                    throw new RuntimeException();
                }
                A03[7] = "hH4UDShpXMHOmMzORRWNzKcCIyC855UI";
                switch (iHashCode) {
                    case -315603473:
                        String icyString = A00(25, 9, 76);
                        if (key.equals(icyString)) {
                            b = 1;
                        } else {
                            b = -1;
                        }
                        break;
                    case 1646559960:
                        String icyString2 = A00(14, 11, 3);
                        if (key.equals(icyString2)) {
                            b = 0;
                        } else {
                            b = -1;
                        }
                        break;
                    default:
                        b = -1;
                        break;
                }
                switch (b) {
                    case 0:
                        url = strGroup2;
                        break;
                    case 1:
                        str = strGroup2;
                        break;
                }
            }
        }
        return new Metadata(new IcyInfo(bArr, url, str));
    }
}
