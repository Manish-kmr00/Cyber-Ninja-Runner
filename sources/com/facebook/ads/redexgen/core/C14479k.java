package com.facebook.ads.redexgen.core;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9k, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C14479k {
    public static byte[] A06;
    public static String[] A07 = {"6qWdP8UnAqk2", "MP5OshbzeeKQXWypFydZHFaUVi2SMaBY", "YZOrpgpjnThYhZrbQ", "9FBJpZQghCKG6mC2kMssKZrg31bKkWn0", "1igNFrY6lER43", "wq7phLHZ3BH2hfkM7", "H4ZPtJlAPqOhXadVzSXMAib", "ZeuNk8rzE4mqHJK5cCc2mdI2UMeFjq1Z"};

    @Nullable
    public Messenger A00;
    public boolean A01 = false;
    public final ServiceConnection A02 = new ServiceConnection() { // from class: com.facebook.ads.redexgen.X.9j
        public static byte[] A01;
        public static String[] A02 = {"Vw4807oGxAdaHl5Al", "61OeIm55zagm9eF8TwwypJ2x", "EMmzBhTNP4w9g", "EYH0yzb9nIvkx5HKrwnVnQphst8", "oJpEUQYv6dauwAdzygMcXKep8asdjHHS", "ZEL", "ZTCWoVSxq9DuX", "VaiI"};

        public static String A00(int i, int i2, int i3) {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
            for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
                byte b = (byte) ((bArrCopyOfRange[i4] - i3) - 13);
                if (A02[7].length() != 4) {
                    throw new RuntimeException();
                }
                String[] strArr = A02;
                strArr[6] = "dt08HEEvYnWJr";
                strArr[2] = "T3OITLjrwLx4m";
                bArrCopyOfRange[i4] = b;
            }
            return new String(bArrCopyOfRange);
        }

        public static void A01() {
            A01 = new byte[]{98, 116, -127, -123, 120, 114, 116, 47, 114, 126, 125, 125, 116, 114, -125, 116, 115, -66, -48, -35, -31, -44, -50, -48, -117, -49, -44, -34, -50, -38, -39, -39, -48, -50, -33, -48, -49};
        }

        static {
            A01();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.A00.A08(AbstractC14128a.A1r, new C14138b(A00(0, 17, 2)));
            this.A00.A01 = true;
            this.A00.A00 = new Messenger(iBinder);
            Message messageObtain = Message.obtain((Handler) null, 1);
            messageObtain.setData(this.A00.A00());
            try {
                this.A00.A00.send(messageObtain);
            } catch (RemoteException e) {
                this.A00.A07(AbstractC14128a.A1q, new C14138b(e));
            }
            this.A00.A03.unbindService(this);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            this.A00.A08(AbstractC14128a.A1s, new C14138b(A00(17, 20, 94)));
            try {
                this.A00.A03.unbindService(this);
            } catch (IllegalArgumentException unused) {
            }
            this.A00.A00 = null;
            this.A00.A01 = false;
        }
    };
    public final C2699k1 A03;
    public final String A04;
    public final String A05;

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 84);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        byte[] bArr = {-32, -47, -30, -47, -35, -17, -47, -34, -17, -27, -27, -39, -44, -4, -19, -2, -19, -7, Ascii.VT, -4, -2, -5, 0, -5, -17, -5, -8, Ascii.VT, 2, -15, -2, -1, -11, -5, -6, -63, -78, -61, -78, -66, -48, -61, -74, -62, -58, -74, -60, -59, -48, -70, -75, Ascii.SO, Ascii.US, 33, 41, Ascii.US, 37, 35, -19, 33, 45, 43, 46, 45, 44, 35, 44, 50, -34, 44, 45, 50, -34, 36, 45, 51, 44, 34, -34, 45, 48, -34, 43, 39, 49, 49, 39, 44, 37, -34, 46, 35, 48, 43, 39, 49, 49, 39, 45, 44, 49, -69, -35, -38, -50, -48, -34, -34, -44, -39, -46, -117, -35, -48, -36, -32, -48, -34, -33, 1, Ascii.CR, Ascii.VT, -52, 4, -1, 1, 3, 0, Ascii.CR, Ascii.CR, 9, -52, -1, 19, 2, 7, 3, Ascii.FF, 1, 3, Ascii.FF, 3, Ascii.DC2, Ascii.NAK, Ascii.CR, Ascii.DLE, 9, -52, -33, 19, 2, 7, 3, Ascii.FF, 1, 3, -20, 3, Ascii.DC2, Ascii.NAK, Ascii.CR, Ascii.DLE, 9, -15, 3, Ascii.DLE, Ascii.DC4, 7, 1, 3, 2, Ascii.SO, Ascii.FF, -51, 5, 0, 2, 4, 1, Ascii.SO, Ascii.SO, 10, -51, 10, 0, 19, 0, Ascii.CR, 0, 43, 50, 37, 33, 56, 35, 46, 43, 38, 35, 54, 43, 49, 48};
        String[] strArr = A07;
        if (strArr[0].length() == strArr[4].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A07;
        strArr2[0] = "tkHV67jO43cW";
        strArr2[4] = "7eV9Uq8jXNAYU";
        A06 = bArr;
    }

    static {
        A06();
    }

    public C14479k(C2699k1 c2699k1, String str, String str2) {
        this.A03 = c2699k1;
        this.A05 = str;
        this.A04 = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle A00() {
        Bundle bundle = new Bundle();
        bundle.putInt(A05(13, 22, 88), 1);
        bundle.putString(A05(0, 13, 60), this.A04);
        bundle.putString(A05(35, 16, 29), this.A05);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07(int i, C14138b c14138b) {
        this.A03.A08().AAu(A05(189, 14, 110), i, c14138b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A08(int i, C14138b c14138b) {
        c14138b.A05(1);
        this.A03.A08().AAv(A05(189, 14, 110), i, c14138b);
    }

    public final void A0C() {
        A08(AbstractC14128a.A1t, new C14138b(A05(101, 18, 23), this.A05));
        Intent intent = new Intent();
        intent.setClassName(A05(170, 19, 75), A05(Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE, 51, 74));
        try {
            if (!this.A03.bindService(intent, this.A02, 1)) {
                A08(AbstractC14128a.A1p, new C14138b(A05(51, 50, 106)));
                this.A03.unbindService(this.A02);
            }
        } catch (Exception e) {
            A07(AbstractC14128a.A1o, new C14138b(e));
        }
    }
}
