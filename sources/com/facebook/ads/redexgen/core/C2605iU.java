package com.facebook.ads.redexgen.core;

import com.facebook.ads.internal.protocol.AdErrorType;
import com.google.common.base.Ascii;
import java.util.Arrays;
import kotlin.io.encoding.Base64;
import org.json.JSONException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.iU, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2605iU implements JS {
    public static byte[] A03;
    public static String[] A04 = {"vUQacvUb1jgaOB1nXCILUaEr4ItZ5QEs", "N", "ozPzI", "iemFS7qx3ItQSdDQeBrvuJ9y9CMkfIqY", "EwROMxnfRd6F7268i4EpvPtVg3hQf", "a", "qVu8", "3RxrE6NsEsLt8TXu"};
    public final /* synthetic */ long A00;
    public final /* synthetic */ B6 A01;
    public final /* synthetic */ B9 A02;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 120);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{85, 4, 87, 3, 80, 5, 7, 3, 62, 62, 57, 56, 50, 110, 62, 104, 44, 53, 41, 40, 35, Ascii.RS, 5, 3, Ascii.SYN, Ascii.DC2, Ascii.SI, 9, 8, 92, 70, 78, 120, 111, 107, 120, 111, Base64.padSymbol, 120, 111, 111, 114, 111, Base64.padSymbol, 114, 126, 126, 104, 111, 111, 120, 121, 124, 74, 93, 89, 74, 93, Ascii.SI, 93, 74, 95, 67, 70, 74, 75, Ascii.SI, 92, 90, 76, 76, 74, 92, 92, 73, 90, 67, 67, 86, 63, 62, 19, 63, Base64.padSymbol, 32, 60, 53, 36, 53, Ascii.DLE, 17, 58, Ascii.CR, Ascii.CR, Ascii.DLE, Ascii.CR};
    }

    static {
        A01();
    }

    public C2605iU(B9 b9, B6 b6, long j) {
        this.A02 = b9;
        this.A01 = b6;
        this.A00 = j;
    }

    private final void A02(C1683Je c1683Je) {
        B5.A06(this.A01);
        try {
            JQ response = c1683Je.A00();
            if (response != null) {
                String strA6t = response.A6t();
                BC serverResponse = this.A02.A06.A07(this.A02.A05, strA6t, this.A00);
                if (serverResponse.A01() == BB.A03) {
                    C2601iQ c2601iQ = (C2601iQ) serverResponse;
                    String strA04 = c2601iQ.A04();
                    AdErrorType adErrorTypeAdErrorTypeFromCode = AdErrorType.adErrorTypeFromCode(c2601iQ.A03(), AdErrorType.ERROR_MESSAGE);
                    if (strA04 != null) {
                        strA6t = strA04;
                    }
                    this.A02.A05.A0F().A3M(C1517Cu.A01(this.A02.A01), adErrorTypeAdErrorTypeFromCode.getErrorCode(), strA6t, adErrorTypeAdErrorTypeFromCode.isPublicError());
                    this.A02.A0E(C1468Ag.A01(adErrorTypeAdErrorTypeFromCode, strA6t));
                    return;
                }
            }
            AdErrorType adErrorType = AdErrorType.NETWORK_ERROR;
            String message = c1683Je.getMessage();
            InterfaceC12391f interfaceC12391fA0F = this.A02.A05.A0F();
            long jA01 = C1517Cu.A01(this.A02.A01);
            int errorCode = adErrorType.getErrorCode();
            boolean zIsPublicError = adErrorType.isPublicError();
            if (A04[2].length() == 29) {
                throw new RuntimeException();
            }
            A04[4] = "NZ18w";
            interfaceC12391fA0F.A3M(jA01, errorCode, message, zIsPublicError);
            this.A02.A0E(C1468Ag.A01(adErrorType, message));
        } catch (JSONException e) {
            AdErrorType adErrorType2 = AdErrorType.NETWORK_ERROR;
            String errorMessage = c1683Je.getMessage();
            this.A02.A05.A0F().A3M(C1517Cu.A01(this.A02.A01), adErrorType2.getErrorCode(), A00(16, 15, 30) + e.getMessage(), adErrorType2.isPublicError());
            this.A02.A0E(C1468Ag.A01(adErrorType2, errorMessage));
        }
    }

    @Override // com.facebook.ads.redexgen.core.JS
    public final void ACh(JQ jq) {
        AbstractC1477Au.A05(A00(79, 10, 40), A00(52, 27, 87), A00(8, 8, 114));
        if (jq != null) {
            String strA6t = jq.A6t();
            int iA02 = C14499m.A02(this.A02.A05);
            String[] strArr = A04;
            String str = strArr[5];
            String response = strArr[1];
            if (str.length() != response.length()) {
                throw new RuntimeException();
            }
            A04[2] = "kblvpkFa8oUK1ItVGqcsW93nH";
            if (iA02 > 0) {
                C1485Bh.A00(this.A02.A05).A0C(strA6t);
            }
            B5.A06(this.A01);
            this.A02.A0O(strA6t, this.A00, this.A01);
        }
    }

    @Override // com.facebook.ads.redexgen.core.JS
    public final void AD5(Exception exc) {
        AbstractC1477Au.A05(A00(89, 7, 7), A00(31, 21, 101), A00(0, 8, 30));
        if (C1683Je.class.equals(exc.getClass())) {
            A02((C1683Je) exc);
            return;
        }
        AdErrorType adErrorType = AdErrorType.NETWORK_ERROR;
        String errorMessage = exc.getMessage();
        this.A02.A05.A0F().A3M(C1517Cu.A01(this.A02.A01), adErrorType.getErrorCode(), errorMessage, adErrorType.isPublicError());
        this.A02.A0E(C1468Ag.A01(adErrorType, errorMessage));
    }
}
