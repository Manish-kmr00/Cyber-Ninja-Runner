package com.facebook.ads.redexgen.core;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.73, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class AnonymousClass73 extends AsyncTask<AnonymousClass75, Void, Drawable> {
    public static byte[] A03;
    public static String[] A04 = {"Er5x4Nf8UA9tVLePD2EX", "DtYF9X90t5u", "I941X6fzqWLmgCmjxes", "iBgQ7OI2DFUGAw4NUel9vSUdaaiAzSqO", "QcmiodlDN7oY3kgnmckrDpvdiERsjn9V", "z", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "KLyCCmbDECCjA8c7XM6gY8wQDdZdMwfW"};
    public final AnonymousClass74 A00;
    public final C2699k1 A01;
    public final boolean A02;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private final Drawable A00(AnonymousClass75... anonymousClass75Arr) throws Throwable {
        if (!BQ.A02(this) && anonymousClass75Arr != null) {
            try {
                if (anonymousClass75Arr.length >= 1) {
                    String str = anonymousClass75Arr[0].A01;
                    String str2 = anonymousClass75Arr[0].A00;
                    Bitmap bitmapA0N = null;
                    try {
                        bitmapA0N = new C14067t(this.A01).A0N(str, -1, -1);
                    } catch (Throwable th) {
                        this.A01.A08().AAu(A01(0, 7, 4), AbstractC14128a.A1V, new C14138b(th));
                    }
                    if (bitmapA0N != null) {
                        return C2615ie.A05(this.A01, bitmapA0N, this.A02, str2);
                    }
                    return null;
                }
            } catch (Throwable th2) {
                BQ.A00(th2, this);
                return null;
            }
        }
        return null;
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            int i5 = (bArrCopyOfRange[i4] ^ i3) ^ 36;
            String[] strArr = A04;
            if (strArr[6].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            A04[2] = "XzO4PGfz9rpTObXE3Krp6";
            bArrCopyOfRange[i4] = (byte) i5;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{71, 69, 78, 69, 82, 73, 67};
    }

    static {
        A02();
    }

    public AnonymousClass73(C2699k1 c2699k1, AnonymousClass74 anonymousClass74, boolean z) {
        this.A01 = c2699k1;
        this.A00 = anonymousClass74;
        this.A02 = z;
    }

    public /* synthetic */ AnonymousClass73(C2699k1 c2699k1, AnonymousClass74 anonymousClass74, boolean z, C2721kN c2721kN) {
        this(c2699k1, anonymousClass74, z);
    }

    private final void A03(Drawable drawable) throws Throwable {
        if (BQ.A02(this)) {
            return;
        }
        try {
            this.A00.ADN(drawable);
        } catch (Throwable th) {
            BQ.A00(th, this);
        }
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ Drawable doInBackground(AnonymousClass75[] anonymousClass75Arr) throws Throwable {
        if (BQ.A02(this)) {
            return null;
        }
        try {
            return A00(anonymousClass75Arr);
        } catch (Throwable th) {
            BQ.A00(th, this);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onPostExecute(Drawable drawable) throws Throwable {
        if (BQ.A02(this)) {
            return;
        }
        try {
            A03(drawable);
        } catch (Throwable th) {
            BQ.A00(th, this);
        }
    }
}
