package com.facebook.ads.redexgen.core;

import android.content.ContentResolver;
import android.database.Cursor;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7X, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class C7X {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 15);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{Base64.padSymbol, 53, 56, 79, SignedBytes.MAX_POWER_OF_TWO, 74, 92, 65, 71, 74, 71, 74, 127, 115, 114, 104, 121, 114, 104, 38, 51, 51, 127, 115, 113, 50, 122, 125, 127, 121, 126, 115, 115, 119, 50, 119, 125, 104, 125, 114, 125, 50, 108, 110, 115, 106, 117, 120, 121, 110, 50, 93, 104, 104, 110, 117, 126, 105, 104, 117, 115, 114, 85, 120, 76, 110, 115, 106, 117, 120, 121, 110, Ascii.DC2, Ascii.ETB, 19, Ascii.ETB, 10, 33, 10, Ascii.FF, Ascii.US, Ascii.GS, Ascii.NAK, Ascii.ETB, Ascii.DLE, Ascii.EM};
    }

    public static C7W A00(ContentResolver contentResolver) {
        String strA01 = A01(72, 14, 113);
        String strA02 = A01(3, 9, 33);
        String strA03 = A01(0, 3, 83);
        Cursor c = null;
        try {
            c = contentResolver.query(C5.A00(A01(12, 60, 19)), new String[]{strA03, strA02, strA01}, null, null, null);
            if (c == null || !c.moveToFirst()) {
                return new C7W(null, null, false);
            }
            String string = c.getString(c.getColumnIndex(strA03));
            String attributionId = c.getString(c.getColumnIndex(strA02));
            return new C7W(string, attributionId, Boolean.valueOf(c.getString(c.getColumnIndex(strA01))).booleanValue());
        } finally {
            if (c != null) {
                c.close();
            }
        }
    }
}
