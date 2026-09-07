package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdExtendedListener;
import com.facebook.ads.InterstitialAdListener;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2809lr implements C3Q {
    public static byte[] A06;
    public static String[] A07 = {"41kFMkgYcMqjBdEAHWyZzQ9Q1YQDMkZo", "a1qrqbdzoLKte5dp2TdqsHV2Btmo8HIO", "VlRnhGghZyM7Xz", "WVmrs7jRPAo6ieNv", "abQhu9SgesOIRxLkCU6L7yAdrfeNFYXV", "iVqBhi5IkesALAcr", "e6wMTa30i0R6i9", "GTVyj1NjpD4uWxM1mBTnBnh1LH0X6W6g"};
    public boolean A00;
    public final AbstractC2822m5 A01;
    public final C3E A02;
    public final C2812lu A03;
    public final C3L A04;
    public final C2699k1 A05;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 112);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A06 = new byte[]{110, 75, Ascii.SI, SignedBytes.MAX_POWER_OF_TWO, 77, 69, 74, 76, 91, Ascii.SI, 70, 92, Ascii.SI, 65, 90, 67, 67, 9, Ascii.RS, 5, Ascii.SI, 7, Ascii.SO, Ascii.DC4, Ascii.SO, 19, Ascii.US, Ascii.EM, 10, Ascii.CAN, Ascii.DC4, 0, Ascii.SO, Ascii.DC2, 47, 43, 40, Ascii.FS, Ascii.CR, 0, Ascii.FF, 7, 10, Ascii.FF, 39, Ascii.FF, Ascii.GS, Ascii.RS, 6, Ascii.ESC, 2, 87, 80, 74, 65, 91, 76, 76, 81, 76, 65, 93, 81, 90, 91, 65, 85, 91, 71, Ascii.SO, Ascii.CR, Ascii.FF, 5, Ascii.GS, Ascii.VT, Ascii.FF, Ascii.DC4, 3, Ascii.SO, Ascii.VT, 6, 3, Ascii.SYN, Ascii.VT, Ascii.CR, Ascii.FF, Ascii.GS, Ascii.SYN, Ascii.VT, Ascii.SI, 7, Ascii.GS, 9, 7, Ascii.ESC, 39, Ascii.SI, Ascii.EM, Ascii.EM, Ascii.VT, Ascii.CR, Ascii.SI, 80, 74, 118, 82, 72, 72, 82, 85, 92, Ascii.ESC, 89, 78, 85, 95, 87, 94, Ascii.ESC, 93, 84, 73, Ascii.ESC, 86, 94, 72, 72, 90, 92, 94, Ascii.NAK, 35, 36, 34, 47, 53, 34, 34, 63, 34, 47, Base64.padSymbol, 53, 35, 35, 49, 55, 53, 47, 59, 53, 41, 72, 89, SignedBytes.MAX_POWER_OF_TWO};
    }

    static {
        A01();
    }

    public C2809lr(C2699k1 c2699k1, C2812lu c2812lu, C3E c3e, AbstractC2822m5 abstractC2822m5, C3L c3l) {
        this.A05 = c2699k1;
        this.A03 = c2812lu;
        this.A02 = c3e;
        this.A01 = abstractC2822m5;
        this.A04 = c3l;
    }

    @Override // com.facebook.ads.redexgen.core.C3Q
    public final Bundle A5H(String str) {
        return C3X.A02(str, this.A03);
    }

    @Override // com.facebook.ads.redexgen.core.C3Q
    public final void A5l() {
        this.A04.A0F(1012, null);
        this.A04.A0C();
        this.A03.A0D(null);
    }

    @Override // com.facebook.ads.redexgen.core.C3Q
    public final int A8F() {
        return 1010;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:25:0x00db A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:0x0111  */
    /* JADX WARN: Code duplicated, block: B:34:0x0125  */
    /* JADX WARN: Code duplicated, block: B:35:0x0128 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x0129  */
    /* JADX WARN: Code duplicated, block: B:39:0x0139  */
    /* JADX WARN: Code duplicated, block: B:40:0x0143  */
    /* JADX WARN: Code duplicated, block: B:42:0x014d  */
    /* JADX WARN: Code duplicated, block: B:71:? A[RETURN, SYNTHETIC] */
    @Override // com.facebook.ads.redexgen.core.C3Q
    public final void A9Z(Message message) {
        int i;
        String[] strArr;
        InterstitialAd interstitialAdA6a = this.A03.A6a();
        String strA00 = A00(152, 3, 89);
        if (interstitialAdA6a == null) {
            this.A05.A08().AAu(strA00, AbstractC14128a.A0K, new C14138b(A00(0, 17, 95)));
            return;
        }
        int i2 = message.what;
        String strA01 = A00(95, 9, 26);
        String strA02 = A00(104, 27, 75);
        String strA03 = A00(17, 17, 59);
        switch (i2) {
            case 10:
            case 1023:
                Bundle bundle = message.getData().getBundle(strA03);
                if (bundle != null) {
                    int i3 = bundle.getInt(A00(51, 18, 110));
                    String string = bundle.getString(A00(Sdk.SDKError.Reason.MRAID_JS_WRITE_FAILED_VALUE, 21, 0));
                    AdError adError = new AdError(i3, string);
                    this.A02.AIX(adError);
                    if (this.A03.A6e() != null) {
                        InterstitialAdListener interstitialAdListenerA6e = this.A03.A6e();
                        String[] strArr2 = A07;
                        String str = strArr2[1];
                        String str2 = strArr2[0];
                        int errorCode = str.charAt(1);
                        if (errorCode != str2.charAt(1)) {
                            throw new RuntimeException();
                        }
                        String[] strArr3 = A07;
                        strArr3[2] = "mejJWXlfs8BbYc";
                        strArr3[6] = "mZxW76dM1wQ3lj";
                        interstitialAdListenerA6e.onError(interstitialAdA6a, adError);
                    } else {
                        Log.e(A00(34, 17, 25), string);
                    }
                } else {
                    this.A02.AIS(C3D.A04);
                    this.A05.A08().AAu(strA00, AbstractC14128a.A0V, new C14138b(strA02, strA01 + message));
                }
                this.A03.A0D(null);
                return;
            case 1020:
                this.A02.AIc();
                Bundle bundle2 = message.getData().getBundle(strA03);
                if (bundle2 != null) {
                    this.A03.A0C(bundle2.getLong(A00(69, 26, 50)));
                } else {
                    this.A05.A08().AAu(strA00, AbstractC14128a.A0V, new C14138b(strA02, strA01 + message));
                }
                this.A03.A0D(null);
                break;
            case 1022:
                this.A02.AIs();
                break;
        }
        if (this.A03.A6e() == null) {
            return;
        }
        int i4 = message.what;
        String[] strArr4 = A07;
        if (strArr4[4].charAt(13) == strArr4[7].charAt(13)) {
            String[] strArr5 = A07;
            strArr5[1] = "311XYum1gU07qORRQ11S6l3eVKorNtDz";
            strArr5[0] = "91xN7y0ETPjwD6LsGrgnzhnoOTtOTKl3";
            switch (i4) {
                case 1020:
                    if (!this.A00) {
                        this.A03.A6e().onAdLoaded(interstitialAdA6a);
                        return;
                    } else {
                        this.A00 = false;
                        return;
                    }
                case 1021:
                    this.A03.A6e().onInterstitialDisplayed(interstitialAdA6a);
                    return;
                case 1022:
                    this.A03.A6e().onInterstitialDismissed(interstitialAdA6a);
                    return;
                case 1023:
                default:
                    if (this.A03.A04() == null) {
                        return;
                    }
                    i = message.what;
                    strArr = A07;
                    if (strArr[5].length() != strArr[3].length()) {
                        switch (i) {
                            case 3000:
                                this.A03.A04().onRewardedAdCompleted();
                                return;
                            case 3001:
                                this.A03.A04().onRewardedAdServerSucceeded();
                                return;
                            case 3002:
                                this.A03.A04().onRewardedAdServerFailed();
                                return;
                            default:
                                return;
                        }
                    }
                    String[] strArr6 = A07;
                    strArr6[4] = "s5jamizIFVbotxZqKkKlcngcWbLxgQvF";
                    strArr6[7] = "aiBjTIjz8RGRWx4VpHoYFj9LDTOMQV9R";
                    switch (i) {
                        case 3000:
                            this.A03.A04().onRewardedAdCompleted();
                            return;
                        case 3001:
                            this.A03.A04().onRewardedAdServerSucceeded();
                            return;
                        case 3002:
                            this.A03.A04().onRewardedAdServerFailed();
                            return;
                        default:
                            return;
                    }
                case 1024:
                    this.A03.A6e().onAdClicked(interstitialAdA6a);
                    return;
                case 1025:
                    this.A03.A6e().onLoggingImpression(interstitialAdA6a);
                    return;
                case 1026:
                    boolean z = this.A03.A6e() instanceof InterstitialAdExtendedListener;
                    String[] strArr7 = A07;
                    if (strArr7[2].length() == strArr7[6].length()) {
                        String[] strArr8 = A07;
                        strArr8[2] = "qw7ApZ7ipfHbwj";
                        strArr8[6] = "LJsV5SavG50yIX";
                        if (z) {
                            ((InterstitialAdExtendedListener) this.A03.A6e()).onInterstitialActivityDestroyed();
                        }
                        if (this.A03.A04() == null) {
                            return;
                        }
                        i = message.what;
                        strArr = A07;
                        if (strArr[5].length() != strArr[3].length()) {
                            switch (i) {
                                case 3000:
                                    this.A03.A04().onRewardedAdCompleted();
                                    return;
                                case 3001:
                                    this.A03.A04().onRewardedAdServerSucceeded();
                                    return;
                                case 3002:
                                    this.A03.A04().onRewardedAdServerFailed();
                                    return;
                                default:
                                    return;
                            }
                        }
                        String[] strArr9 = A07;
                        strArr9[4] = "s5jamizIFVbotxZqKkKlcngcWbLxgQvF";
                        strArr9[7] = "aiBjTIjz8RGRWx4VpHoYFj9LDTOMQV9R";
                        switch (i) {
                            case 3000:
                                this.A03.A04().onRewardedAdCompleted();
                                return;
                            case 3001:
                                this.A03.A04().onRewardedAdServerSucceeded();
                                return;
                            case 3002:
                                this.A03.A04().onRewardedAdServerFailed();
                                return;
                            default:
                                return;
                        }
                    }
                    break;
            }
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.core.C3Q
    public final void AIt(boolean z) {
        this.A00 = z;
    }
}
