package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class X5 extends SQLiteOpenHelper implements InterfaceC1898Sb {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 5);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{112, Ascii.EM, Ascii.SYN, 112, Ascii.NAK, 8, Ascii.EM, 3, 4, 3, 112, 74, 92, 65, 94, 46, 89, 110, 110, 115, 110, 60, 121, 100, 121, 127, 105, 104, 117, 114, 123, 60, 86, 68, 65, 100, 113, 100, 103, 100, 118, 96, 85, 119, 106, 115, 108, 97, 96, 119, 51, 46, 57, 38, 58, 55, 47, 51, 36, 9, 63, 56, 34, 51, 36, 56, 55, 58, 120, 50, 52, 72, 71, 75, 67, Ascii.DLE, Ascii.DC2, Ascii.SI, 10, Ascii.ETB, 6, 60, Ascii.SO, 2, Ascii.DLE, Ascii.ETB, 6, 17, 67, 65, 92, 89, 68, 85, 111, 67, 85, 65, 69, 85, 94, 83, 85, Ascii.ESC, Ascii.SYN, Ascii.US, 10};
    }

    public X5(Context context) {
        super(context.getApplicationContext(), A00(50, 21, 83), (SQLiteDatabase.CursorFactory) null, 1);
    }

    public static void A02(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorQuery = sQLiteDatabase.query(A00(75, 13, 102), new String[]{A00(103, 4, 106), A00(71, 4, 35)}, null, null, null, null, null);
        while (cursorQuery.moveToNext()) {
            try {
                String string = cursorQuery.getString(0);
                String string2 = cursorQuery.getString(1);
                if (!A00(88, 15, 53).equals(string2)) {
                    String str = A00(11, 5, 11) + string + A00(0, 11, 85) + string2;
                    try {
                        sQLiteDatabase.execSQL(str);
                    } catch (SQLException e) {
                        String type = A00(32, 18, 0);
                        AbstractC2432fb.A08(type, A00(16, 16, 25) + str, e);
                    }
                }
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        A02(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
