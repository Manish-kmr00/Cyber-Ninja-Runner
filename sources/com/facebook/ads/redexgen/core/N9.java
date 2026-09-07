package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.Map;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class N9 extends AbstractC2894nG {
    public static byte[] A03;
    public Map<String, String> A00;
    public boolean A01;
    public final Uri A02;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 77);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{88, 93, 90, 95, 59, 60, 39, 58, 45, Ascii.ETB, Base64.padSymbol, 58, 36, Ascii.ETB, 63, 45, 42, Ascii.ETB, 46, 41, 36, 36, 42, 41, 43, 35};
    }

    public N9(C2699k1 c2699k1, A7 a7, String str, Uri uri, Map<String, String> mExtraData) {
        super(c2699k1, a7, str, null, true, true);
        this.A02 = uri;
        this.A00 = mExtraData;
    }

    public N9(C2699k1 c2699k1, A7 a7, String str, Uri uri, Map<String, String> mExtraData, boolean z) {
        this(c2699k1, a7, str, uri, mExtraData);
        this.A01 = z;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2894nG
    public final EnumC12541u A0D() {
        A0E(this.A00, null);
        return EnumC12541u.A09;
    }

    public final Uri A0G() {
        String queryParameter = this.A02.getQueryParameter(A00(4, 22, 5));
        if (this.A01 && !TextUtils.isEmpty(queryParameter)) {
            return C5.A00(queryParameter);
        }
        Uri uri = this.A02;
        String url = A00(0, 4, Sdk.SDKError.Reason.TPAT_ERROR_VALUE);
        return C5.A00(uri.getQueryParameter(url));
    }
}
