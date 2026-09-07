package com.facebook.ads.redexgen.core;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nG, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC2894nG extends AbstractC12551v {
    public static String A04;
    public static String A05;
    public static String A06;
    public static byte[] A07;
    public static String[] A08 = {"yKsrGZvRhlHO", "9EputwQvm", "xy4ysuU", "7AjoeEFyRFUmAcGguWz5skIE39kXLiT8", "yw7hkrjnug4F5v8JlqxYlpspwNYrqeOP", "YdvcKbM", "Mv5W7ZjuxpjDlIvwBIaHg3eS9AlP", "wZHnfIG7rJSoOb"};
    public int A00;
    public final boolean A01;
    public final AnonymousClass22 A02;
    public final boolean A03;

    public static String A0A(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 48);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0B() {
        byte[] bArr = {60, 19, Ascii.SYN, Ascii.FS, Ascii.DC4, 95, 19, Ascii.DLE, Ascii.CAN, Ascii.CAN, Ascii.SUB, Ascii.ESC, Ascii.CAN, Ascii.ETB, Ascii.GS, Ascii.VT, Ascii.SYN, Ascii.DLE, Ascii.GS, 87, Ascii.DLE, Ascii.ETB, Ascii.CR, Ascii.FS, Ascii.ETB, Ascii.CR, 87, Ascii.CAN, Ascii.SUB, Ascii.CR, Ascii.DLE, Ascii.SYN, Ascii.ETB, 87, 47, 48, 60, 46, 17, Ascii.DC2, Ascii.DLE, Ascii.CAN, 44, 7, Ascii.SUB, Ascii.RS, Ascii.SYN, 44, 35, 38, 44, 36, Ascii.DLE, 60, 32, 58, Base64.padSymbol, 44, 42, 33, 40, 44, 59, 40, Ascii.DC2, 57, 36, 32, 40, 53, 47, 46, 57, 53, 55, 63, 71, 65, 87, 87, 81, 71, 71, Ascii.DC4, Ascii.SI, 8, Ascii.ETB, 4, 19, Ascii.DC2, 0, Ascii.CR, 62, Ascii.CR, 8, Ascii.SI, 10, 7, 1, Ascii.ETB, 0, 45, 6, 0, 19, 17, Ascii.EM, Ascii.ETB, 0, 45, Ascii.ESC, 1, 45, Ascii.FS, Ascii.GS, 6, 45, Ascii.FS, 7, Ascii.RS, Ascii.RS, 109, 107, 125, 106, 123, 116, 113, 123, 115, 106, 124, 105, 126, 117, 66, 124, 115, 121, 66, 127, 111, 114, 106, 110, 120};
        if (A08[1].length() != 9) {
            throw new RuntimeException();
        }
        A08[7] = "E0qxoPtldo8saq";
        A07 = bArr;
    }

    public abstract EnumC12541u A0D();

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final void A0E(Map<String, String> map, EnumC12541u enumC12541u) {
        if (!TextUtils.isEmpty(super.A02)) {
            if (this instanceof NA) {
                super.A01.ABS(super.A02, map);
            } else {
                super.A01.AB3(super.A02, map);
            }
            boolean zA02 = EnumC12541u.A02(enumC12541u);
            boolean z = this.A02 != null;
            if (C14499m.A2L(super.A00)) {
                HashMap map2 = new HashMap();
                map2.put(A04, Boolean.toString(!zA02));
                map2.put(A05, Boolean.toString(z));
                map2.put(A06, Boolean.toString(this.A01));
                super.A01.ABC(super.A02, map2);
            }
            if (this.A02 != null) {
                this.A02.A07(enumC12541u);
                if (zA02) {
                    this.A02.A06();
                }
                String str = map == null ? null : map.get(A0A(47, 12, 127));
                if (this.A02.A05() < 2000 && str != null && !str.equals(A0A(Sdk.SDKError.Reason.TPAT_ERROR_VALUE, 9, 40))) {
                    this.A00++;
                }
            } else {
                HashMap map3 = new HashMap();
                map3.put(A0A(59, 10, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE), Long.toString(-1L));
                map3.put(A0A(38, 9, 67), Long.toString(-1L));
                map3.put(A0A(69, 7, 106), EnumC12541u.A05.name());
                super.A01.ABT(super.A02, map3);
            }
        }
        CC.A04(super.A00, A0A(0, 12, 79));
    }

    static {
        A0B();
        A04 = A0A(76, 7, 4);
        A05 = A0A(97, 24, 66);
        A06 = A0A(130, 16, 45);
    }

    public AbstractC2894nG(C2699k1 c2699k1, A7 a7, String str, AnonymousClass22 anonymousClass22, boolean z) {
        this(c2699k1, a7, str, anonymousClass22, z, false);
    }

    public AbstractC2894nG(C2699k1 c2699k1, A7 a7, String str, AnonymousClass22 anonymousClass22, boolean z, boolean z2) {
        super(c2699k1, a7, str);
        this.A00 = 0;
        this.A02 = anonymousClass22;
        this.A03 = z;
        this.A01 = z2;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC12551v
    public final EnumC12541u A0C(String str) {
        if (this.A02 != null) {
            this.A02.A08(super.A02);
        }
        if (FQ.A03(super.A00)) {
            return EnumC12541u.A06;
        }
        if (this.A00 >= C14499m.A0H(super.A00) && str != null && !str.equals(A0A(Sdk.SDKError.Reason.TPAT_ERROR_VALUE, 9, 40))) {
            return EnumC12541u.A06;
        }
        EnumC12541u enumC12541uA0D = A0D();
        String[] strArr = A08;
        if (strArr[5].length() != strArr[2].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A08;
        strArr2[5] = "J3wlmKx";
        strArr2[2] = "XHU2KPo";
        return enumC12541uA0D;
    }

    public final boolean A0F(Uri uri) {
        try {
            String queryParameter = uri.getQueryParameter(A0A(83, 14, 81));
            boolean redirectedToApp = TextUtils.isEmpty(queryParameter);
            if (redirectedToApp) {
                return false;
            }
            Intent intent = new Intent(A0A(12, 26, 73), C5.A00(queryParameter));
            intent.addFlags(268435456);
            if (Build.VERSION.SDK_INT >= 30) {
                intent.addFlags(1024);
            }
            return C1491Bq.A0D(super.A00, intent);
        } catch (C1489Bo unused) {
            return false;
        }
    }
}
