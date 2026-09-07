package com.facebook.ads.redexgen.core;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Looper;
import android.text.TextUtils;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8E, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C8E {
    public static byte[] A04;
    public static final String A05;
    public static final Lock A06;
    public static final Lock A07;
    public static final ReentrantReadWriteLock A08;
    public SQLiteOpenHelper A00;
    public final C2698k0 A01;
    public final C2696jy A03 = new C2696jy(this);
    public final C2697jz A02 = new C2697jz(this);

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 17);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A04 = new byte[]{-82, -53, -82, 109, -117, 109, -116, 85, 118, -120, 120, -102, -64, -52, -55, -57, -102, 127, -87, -82, -88, -83, 127, 94, -118, -121, -117, -121, -110, 94, -93, -46, -47, -93, 87, -122, -119, 123, 124, -119, 87, 121, -112, 87, 85, -120, 122, -119, 85, -115, -60, -75, -78, -65, -78, -115, 110, 116, -82, -94, 94, 110, -101, -99, -55, -25, -12, -12, -11, -6, -90, -23, -25, -14, -14, -90, -19, -21, -6, -54, -25, -6, -25, -24, -25, -7, -21, -90, -20, -8, -11, -13, -90, -6, -18, -21, -90, -37, -49, -90, -6, -18, -8, -21, -25, -22, -89, -112, -126, -119, -126, -128, -111, 93, -79, -84, -88, -94, -85, -80, 107, -64, -69, -81, -84, -65, -80, -117, -29, -32, -13, -32, -31, -32, -14, -28, -112, -95, -112, -103, -97, -98, -116, -121, -125, 125, -122, -117};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final synchronized void A0J() {
        for (int i = 0; i < A0M().length; i++) {
        }
        if (this.A00 != null) {
            this.A00.close();
            this.A00 = null;
        }
    }

    static {
        A07();
        StringBuilder sbAppend = new StringBuilder().append(A05(107, 14, 44)).append(C2696jy.A03.A01);
        String strA05 = A05(58, 2, 113);
        StringBuilder sbAppend2 = sbAppend.append(strA05);
        String strA06 = A05(142, 6, 7);
        StringBuilder sbAppend3 = sbAppend2.append(strA06);
        String strA07 = A05(60, 1, 31);
        StringBuilder sbAppend4 = sbAppend3.append(strA07).append(C2696jy.A02.A01).append(strA05);
        String strA08 = A05(136, 6, 26);
        A05 = sbAppend4.append(strA08).append(strA07).append(C2697jz.A04.A01).append(strA05).append(strA08).append(strA07).append(C2697jz.A05.A01).append(strA05).append(strA08).append(strA07).append(C2697jz.A0A.A01).append(strA05).append(strA08).append(strA07).append(C2697jz.A08.A01).append(strA05).append(strA08).append(strA07).append(C2697jz.A07.A01).append(strA05).append(strA08).append(strA07).append(C2697jz.A06.A01).append(strA05).append(strA08).append(strA07).append(C2697jz.A03.A01).append(strA05).append(strA08).append(strA07).append(C2697jz.A02.A01).append(A05(11, 6, 105)).append(strA08).append(A05(17, 6, 78)).append(strA06).append(A05(30, 4, 114)).append(strA08).append(strA07).append(C2697jz.A09.A01).append(A05(0, 3, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE)).append(strA06).append(strA07).append(C2696jy.A03.A01).append(A05(34, 10, 38)).append(strA08).append(strA07).append(C2697jz.A08.A01).append(A05(7, 4, 36)).toString();
        A08 = new ReentrantReadWriteLock();
        A06 = A08.readLock();
        A07 = A08.writeLock();
    }

    public C8E(C2698k0 c2698k0) {
        this.A01 = c2698k0;
    }

    private synchronized SQLiteDatabase A00() {
        if (this.A00 == null) {
            final C2698k0 c2698k0 = this.A01;
            this.A00 = new SQLiteOpenHelper(c2698k0, this) { // from class: com.facebook.ads.redexgen.X.8F
                public static byte[] A01;
                public static String[] A02 = {"XfAyR2vU0BibGbkW5sl", "72EQRqCB7z", "pQj0Q1BmcNSJNmsLpeVJ6qN75i73IOus", "lsxje2C6xdGld5UPkxYO", "GgAbEVzt1AOENmbxI3KXH96Z5ccDQ2lY", "3OXRqiMUeM1s", "WQkJsHQStWfxe", "yOid3ecrxpkgxviYKYk6NUThnYl"};
                public static final String A03;
                public final C8E A00;

                public static String A00(int i, int i2, int i3) {
                    byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
                    for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
                        bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 67);
                    }
                    return new String(bArrCopyOfRange);
                }

                public static void A02() {
                    A01 = new byte[]{-105, 101, -119, -118, -117, -122, -102, -111, -103, 101, 117, 0, Ascii.VT, 19, 4, 17, -33, 19, 0, 1, Ascii.VT, 4, -33, 36, 53, 36, 45, 51, 50, -33, 0, 3, 3, -33, 2, Ascii.SO, Ascii.VT, Ascii.DC4, Ascii.FF, Ascii.CR, -33, -122, -87, -119, -90, -71, -90, -89, -90, -72, -86, -115, -86, -79, -75, -86, -73, 101, -88, -90, -77, 101, -77, -76, -71, 101, -89, -86, 101, -77, -70, -79, -79, -16, -2, -5, -4, -52, 0, -19, -18, -8, -15, -52, -11, -14, -52, -15, 4, -11, -1, 0, -1, -52, Ascii.SI, Ascii.RS, Ascii.CR, Ascii.US, Ascii.DC4, 17, Ascii.US, -10, -8, -25, -19, -13, -25, -58, Ascii.FF, Ascii.NAK, Ascii.CAN, Ascii.VT, Ascii.SI, Ascii.CR, Ascii.DC4, 5, 17, Ascii.VT, Ascii.US, Ascii.EM, -58, -29, -58, -11, -12, -31, -51, -48, -33, -111, -33, -102, -48, -50};
                    if (A02[7].length() == 23) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A02;
                    strArr[4] = "z4ETzKVSWwABxmvmOp0bWtQm6ZVGd83i";
                    strArr[2] = "IiBR5v01IEKLzmVqyabUzMw7zaZ4VOx3";
                }

                static {
                    A02();
                    A03 = C8F.class.getSimpleName();
                }

                {
                    super(c2698k0, A01(c2698k0), (SQLiteDatabase.CursorFactory) null, 4);
                    if (this != null) {
                        this.A00 = this;
                        return;
                    }
                    throw new IllegalArgumentException(A00(41, 32, 2));
                }

                public static String A01(C2698k0 c2698k1) {
                    Locale locale = Locale.US;
                    Object[] objArr = {A00(0, 0, 19)};
                    String strA00 = A00(126, 8, 41);
                    String str = String.format(locale, strA00, objArr);
                    if (!C14499m.A2a(c2698k1)) {
                        return str;
                    }
                    String defaultDbName = c2698k1.getPackageName();
                    String processName = ProcessUtils.getProcessName(c2698k1);
                    if (!defaultDbName.equals(processName) && !TextUtils.isEmpty(processName)) {
                        String defaultDbName2 = String.format(Locale.US, strA00, '_' + processName);
                        return defaultDbName2;
                    }
                    return str;
                }

                @Override // android.database.sqlite.SQLiteOpenHelper
                public final void onCreate(SQLiteDatabase sQLiteDatabase) {
                    for (C8I c8i : this.A00.A0M()) {
                        c8i.A07(sQLiteDatabase);
                    }
                }

                @Override // android.database.sqlite.SQLiteOpenHelper
                public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
                    for (C8I c8i : this.A00.A0M()) {
                        c8i.A08(sQLiteDatabase);
                        c8i.A07(sQLiteDatabase);
                    }
                }

                @Override // android.database.sqlite.SQLiteOpenHelper
                public final void onOpen(SQLiteDatabase sQLiteDatabase) {
                    super.onOpen(sQLiteDatabase);
                    if (!sQLiteDatabase.isReadOnly()) {
                        sQLiteDatabase.execSQL(A00(101, 25, 99));
                    }
                }

                @Override // android.database.sqlite.SQLiteOpenHelper
                public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
                    if (i == 2 && i2 >= 3) {
                        sQLiteDatabase.execSQL(A00(73, 28, 105));
                    }
                    if (i <= 3 && i2 >= 4) {
                        C8C c8c = C2697jz.A02;
                        sQLiteDatabase.execSQL(A00(11, 30, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE) + c8c.A01 + A00(0, 1, 52) + c8c.A02 + A00(1, 10, 2));
                    }
                }
            };
        }
        return this.A00.getWritableDatabase();
    }

    private synchronized SQLiteDatabase A01() {
        SQLiteException e = null;
        for (int i = 0; i < 10; i++) {
            try {
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException unused) {
                }
            }
        }
        this.A01.A08().AAu(A05(128, 8, 110), AbstractC14128a.A0v, new C14138b(e));
        throw e;
        return A00();
    }

    public final int A08(int i) {
        A07.lock();
        try {
            return A0E().delete(A05(136, 6, 26), C2697jz.A02.A01 + A05(3, 4, 60), new String[]{String.valueOf(i - 1)});
        } finally {
            A07.unlock();
        }
    }

    public final Cursor A09() {
        A06.lock();
        try {
            return this.A02.A0B();
        } finally {
            A06.unlock();
        }
    }

    public final Cursor A0A() {
        A06.lock();
        try {
            return this.A02.A0C();
        } finally {
            A06.unlock();
        }
    }

    public final Cursor A0B() {
        A06.lock();
        try {
            return this.A03.A0B();
        } finally {
            A06.unlock();
        }
    }

    public final Cursor A0C(int i) {
        A06.lock();
        try {
            return A0E().rawQuery(A05 + A05(23, 7, 45) + String.valueOf(i), null);
        } finally {
            A06.unlock();
        }
    }

    public final Cursor A0D(String str) {
        A06.lock();
        try {
            return this.A02.A0D(str);
        } finally {
            A06.unlock();
        }
    }

    public final SQLiteDatabase A0E() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return A01();
        }
        throw new IllegalStateException(A05(64, 43, 117));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.8H != com.facebook.ads.internal.database.AdDatabaseQuery<T> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.9L != com.facebook.ads.internal.eventstorage.AdEventStorageCallback<T> */
    public final <T> AsyncTask A0F(final C8H<T> c8h, final C9L<T> c9l) {
        Executor executor = D8.A07;
        final C2698k0 c2698k0 = this.A01;
        return D5.A00(executor, new AsyncTask<Void, Void, T>(c2698k0, c8h, c9l) { // from class: com.facebook.ads.redexgen.X.8D
            public static byte[] A04;
            public C8G A00;
            public final C2698k0 A01;
            public final C8H<T> A02;
            public final C9L<T> A03;

            static {
                A02();
            }

            public static String A01(int i, int i2, int i3) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
                for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
                    bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 72);
                }
                return new String(bArrCopyOfRange);
            }

            public static void A02() {
                A04 = new byte[]{5, 2, Ascii.NAK, 2, 3, 2, Ascii.DC4, 6};
            }

            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.8D != com.facebook.ads.internal.database.AdDatabaseHelper$DatabaseQueryAsyncTask<T> */
            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.8H != com.facebook.ads.internal.database.AdDatabaseQuery<T> */
            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.9L != com.facebook.ads.internal.eventstorage.AdEventStorageCallback<T> */
            {
                this.A02 = c8h;
                this.A03 = c9l;
                this.A01 = c2698k0;
            }

            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.8D != com.facebook.ads.internal.database.AdDatabaseHelper$DatabaseQueryAsyncTask<T> */
            private final T A00(Void... voidArr) throws Throwable {
                if (BQ.A02(this)) {
                    return null;
                }
                T tA03 = null;
                try {
                    try {
                        tA03 = this.A02.A03();
                        this.A00 = this.A02.A00();
                        return tA03;
                    } catch (Exception e) {
                        this.A01.A08().AAu(A01(0, 8, 89), AbstractC14128a.A0w, new C14138b(e));
                        this.A00 = C8G.A08;
                        return tA03;
                    }
                } catch (Throwable th) {
                    BQ.A00(th, this);
                    return null;
                }
            }

            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.8D != com.facebook.ads.internal.database.AdDatabaseHelper$DatabaseQueryAsyncTask<T> */
            @Override // android.os.AsyncTask
            public final /* bridge */ /* synthetic */ Object doInBackground(Void[] voidArr) throws Throwable {
                if (BQ.A02(this)) {
                    return null;
                }
                try {
                    return A00(voidArr);
                } catch (Throwable th) {
                    BQ.A00(th, this);
                    return null;
                }
            }

            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.8D != com.facebook.ads.internal.database.AdDatabaseHelper$DatabaseQueryAsyncTask<T> */
            @Override // android.os.AsyncTask
            public final void onPostExecute(T result) throws Throwable {
                if (BQ.A02(this)) {
                    return;
                }
                try {
                    if (this.A00 == null) {
                        this.A03.A02(result);
                    } else {
                        this.A03.A01(this.A00.A03(), this.A00.A04());
                    }
                } catch (Throwable th) {
                    BQ.A00(th, this);
                }
            }
        }, new Void[0]);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.9L != com.facebook.ads.internal.eventstorage.AdEventStorageCallback<java.lang.String> */
    public final AsyncTask A0G(String str, int i, String str2, double d, double d2, String str3, Map<String, String> data, C9L<String> c9l) {
        return A0F(new M4(this, str2, str, i, d, d2, str3, data), c9l);
    }

    public final void A0H() {
        A07.lock();
        try {
            this.A02.A09();
            this.A03.A09();
        } finally {
            A07.unlock();
        }
    }

    public final void A0I() {
        A07.lock();
        try {
            this.A03.A0D(this.A01);
        } finally {
            A07.unlock();
        }
    }

    public final boolean A0K(String str) {
        A07.lock();
        try {
            return this.A02.A0F(str);
        } finally {
            A07.unlock();
        }
    }

    public final boolean A0L(String str) {
        boolean z;
        A07.lock();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(A05(Sdk.SDKError.Reason.TPAT_ERROR_VALUE, 7, 90)).append(A05(136, 6, 26)).append(A05(44, 5, 36)).append(C2697jz.A02.A01).append(A05(61, 1, 32)).append(C2697jz.A02.A01).append(A05(56, 2, 50)).append(A05(49, 7, 92)).append(C2697jz.A04.A01).append(A05(62, 2, 77));
            A0E().execSQL(sb.toString(), new String[]{str});
            z = true;
        } catch (SQLiteException unused) {
            z = false;
        }
        A07.unlock();
        return z;
    }

    public final C8I[] A0M() {
        return new C8I[]{this.A03, this.A02};
    }
}
