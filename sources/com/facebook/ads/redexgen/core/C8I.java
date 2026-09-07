package com.facebook.ads.redexgen.core;

import android.database.sqlite.SQLiteDatabase;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8I, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class C8I {
    public static byte[] A01;
    public final C8E A00;

    static {
        A04();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 3);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A01 = new byte[]{85, 93, 87, 74, 87, 72, 54, 80, 68, 89, 91, 54, 84, 35, 60, 49, 38, 49, 84, 95, 4, 8, 79, 94, 73, 77, 88, 73, 44, 88, 77, 78, SignedBytes.MAX_POWER_OF_TWO, 73, 44, 6, Ascii.DLE, Ascii.CR, Ascii.DC2, 98, Ascii.SYN, 3, 0, Ascii.SO, 7, 98, Ascii.VT, 4, 98, 7, Ascii.SUB, Ascii.VT, 17, Ascii.SYN, 17, 98, 34, 52, Base64.padSymbol, 52, 50, 37, 81};
    }

    public abstract String A06();

    public abstract C8C[] A0A();

    public C8I(C8E c8e) {
        this.A00 = c8e;
    }

    private String A00() {
        C8C[] c8cArrA0A = A0A();
        if (c8cArrA0A.length < 1) {
            return null;
        }
        String result = A01(0, 0, 12);
        for (int i = 0; i < c8cArrA0A.length - 1; i++) {
            result = result + c8cArrA0A[i].A02() + A01(20, 2, 43);
        }
        return result + c8cArrA0A[c8cArrA0A.length - 1].A02();
    }

    public static String A02(String str, C8C[] c8cArr) {
        StringBuilder sb = new StringBuilder(A01(56, 7, 114));
        for (int i = 0; i < c8cArr.length - 1; i++) {
            sb.append(c8cArr[i].A01);
            sb.append(A01(20, 2, 43));
        }
        sb.append(c8cArr[c8cArr.length - 1].A01);
        sb.append(A01(6, 6, 21));
        sb.append(str);
        return sb.toString();
    }

    public static String A03(String str, C8C[] c8cArr, C8C c8c) {
        return A02(str, c8cArr) + A01(12, 7, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) + c8c.A01 + A01(2, 4, 116);
    }

    public final SQLiteDatabase A05() {
        return this.A00.A0E();
    }

    public final void A07(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(A01(22, 13, 15) + A06() + A01(0, 2, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE) + A00() + A01(19, 1, 117));
    }

    public final void A08(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(A01(35, 21, 65) + A06());
    }

    public final boolean A09() {
        return A05().delete(A06(), null, null) > 0;
    }
}
