package com.facebook.ads.redexgen.core;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7u, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C14077u {
    public static byte[] A02;
    public static String[] A03 = {"hUOGynEtmSUNsKdJkghkOGNAWtryygzy", "wzPRxUupX2XKUl6NSNI9kT750batbohw", "Jhw1FAiFO5yEDnp58HFyVFkAnHcYvwe5", "TOMeOtqGrF4uQ0cY9hasq1ESWlFY5vR9", "yYpnUvpVzVqKhRvrciBHRtLUwNGFzaUs", "hHaB", "31TBXmQRr4tlfWcucEg5Ko3P35yO7", "Q2"};
    public static final String A04;
    public static volatile C14077u A05;
    public final C2698k0 A00;
    public final Map<String, C14047r> A01 = Collections.synchronizedMap(new HashMap());

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private Bitmap A02(AnonymousClass85 anonymousClass85, C14047r c14047r, String str) throws Throwable {
        Bitmap bitmapA01;
        String str2 = c14047r.A07;
        int i = c14047r.A03;
        int i2 = c14047r.A04;
        long jCurrentTimeMillis = System.currentTimeMillis();
        IOException e = null;
        String strA08 = A08(Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 9, 68);
        boolean zStartsWith = str2.startsWith(strA08);
        String strA09 = A08(239, 22, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE);
        if (zStartsWith || str2.startsWith(strA09)) {
            String strSubstring = str2.startsWith(strA08) ? str2.substring(strA08.length()) : str2.substring(strA09.length());
            InputStream inputStreamOpen = null;
            try {
                try {
                    inputStreamOpen = this.A00.getAssets().open(strSubstring);
                    if (A0C(i, i2)) {
                        try {
                            bitmapA01 = AbstractC14117y.A01(inputStreamOpen, i, i2);
                        } catch (IOException e2) {
                            e = e2;
                            A0B(e);
                            if (inputStreamOpen != null) {
                                A0A(inputStreamOpen);
                            }
                            return null;
                        } catch (OutOfMemoryError e3) {
                            e = e3;
                            A0B(e);
                            if (inputStreamOpen != null) {
                                A0A(inputStreamOpen);
                            }
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            if (inputStreamOpen != null) {
                                A0A(inputStreamOpen);
                            }
                            throw th;
                        }
                    } else {
                        bitmapA01 = BitmapFactory.decodeStream(inputStreamOpen);
                    }
                    if (inputStreamOpen != null) {
                        A0A(inputStreamOpen);
                    }
                } catch (IOException e4) {
                    e = e4;
                } catch (OutOfMemoryError e5) {
                    e = e5;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } else if (A0C(i, i2)) {
            try {
                bitmapA01 = A05(str2, i, i2);
            } catch (IOException e6) {
                e = e6;
                A0B(e);
                bitmapA01 = A03(str2);
            }
        } else {
            bitmapA01 = A03(str2);
        }
        String string = e != null ? e.toString() : null;
        if (bitmapA01 == null) {
            C14097w.A03(anonymousClass85, c14047r, str, C14097w.A03, string, null, null);
            return null;
        }
        long jA00 = A00(str2, bitmapA01);
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (jA00 > 0) {
            C14097w.A03(anonymousClass85, c14047r, str, C14097w.A02, string, Long.valueOf(jA00), Long.valueOf(jCurrentTimeMillis2));
            return bitmapA01;
        }
        C14097w.A03(anonymousClass85, c14047r, str, C14097w.A01, string, null, null);
        if (C14499m.A10(anonymousClass85)) {
            return null;
        }
        return bitmapA01;
    }

    public static String A08(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 67);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A09() {
        A02 = new byte[]{3, 4, 119, 41, 55, 62, 58, Ascii.EM, Ascii.FS, 88, Ascii.ETB, Ascii.CR, Ascii.FF, 8, Ascii.CR, Ascii.FF, 88, Ascii.FS, Ascii.GS, Ascii.VT, Ascii.FF, 17, Ascii.SYN, Ascii.EM, Ascii.FF, 17, Ascii.ETB, Ascii.SYN, 88, 80, Ascii.RS, 17, Ascii.DC4, Ascii.GS, 69, 122, 81, 76, 85, 89, 72, Ascii.CAN, 75, 81, 66, 93, Ascii.CAN, 93, SignedBytes.MAX_POWER_OF_TWO, 91, 93, 93, 92, 75, Ascii.CAN, 85, 89, SignedBytes.MAX_POWER_OF_TWO, Ascii.CAN, 75, 81, 66, 93, Ascii.CAN, 94, 87, 74, Ascii.CAN, 75, 76, 87, 74, 89, 95, 93, 2, Ascii.CAN, Ascii.DC2, 48, 50, 57, 52, 113, 52, 35, 35, 62, 35, 127, 113, 19, 56, 37, 60, 48, 33, 113, 56, 34, 113, 63, 36, Base64.padSymbol, Base64.padSymbol, 127, 125, 90, 82, 87, 94, 95, Ascii.ESC, 79, 84, Ascii.ESC, 88, 84, 75, 66, Ascii.ESC, 87, 84, 88, 90, 87, Ascii.ESC, 82, 86, 90, 92, 94, Ascii.ESC, 82, 85, 79, 84, Ascii.ESC, 88, 90, 88, 83, 94, Ascii.ESC, 19, 78, 73, 87, 6, 38, Ascii.GS, Ascii.DC2, 17, Ascii.US, Ascii.SYN, 83, 7, Ascii.FS, 83, 4, 1, Ascii.SUB, 7, Ascii.SYN, 83, 17, Ascii.SUB, 7, Ascii.RS, Ascii.DC2, 3, 83, 7, Ascii.FS, 83, Ascii.NAK, Ascii.SUB, Ascii.US, Ascii.SYN, 83, 91, 6, 1, Ascii.US, 78, 70, 125, 114, 113, 127, 118, 51, 103, 124, 51, 100, 97, 122, 103, 118, 51, 113, 122, 103, 126, 114, 99, 51, 103, 124, 51, 124, 102, 103, 99, 102, 103, 51, 96, 103, 97, 118, 114, 126, 102, 116, 116, 98, 115, Base64.padSymbol, 40, 40, 40, 85, 90, 95, 86, 9, Ascii.FS, Ascii.FS, 82, 93, 88, 81, Ascii.SO, Ascii.ESC, Ascii.ESC, Ascii.ESC, 85, 90, 80, 70, 91, 93, 80, 107, 85, 71, 71, 81, SignedBytes.MAX_POWER_OF_TWO, Ascii.ESC, 115, 119, 123, 125, 127, 10, 9, 7, 2, 42, 49, 52, 49, 48, 40, 49};
    }

    static {
        A09();
        A04 = C14077u.class.getSimpleName();
    }

    public C14077u(C2698k0 c2698k0) {
        this.A00 = c2698k0;
    }

    private int A00(String str, Bitmap bitmap) {
        String strA08 = A08(0, 2, 105);
        if (bitmap == null) {
            A0B(null);
            return 0;
        }
        File file = new File(A07(this.A00), str.hashCode() + A08(2, 4, 26));
        ByteArrayOutputStream bOut = null;
        FileOutputStream fileOutputStream = null;
        try {
            bOut = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, bOut);
            int size = bOut.size();
            if (size >= C14499m.A0G(this.A00)) {
                A0B(new Throwable(A08(35, 42, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE) + size));
                return 0;
            }
            fileOutputStream = new FileOutputStream(file);
            bOut.writeTo(fileOutputStream);
            fileOutputStream.flush();
            return size;
        } catch (OutOfMemoryError e) {
            A0B(e);
            Log.e(A04, A08(184, 39, 80), e);
            return 0;
        } catch (FileNotFoundException e2) {
            Log.e(A04, A08(6, 29, 59) + file.getPath() + strA08, e2);
            A0B(e2);
            return 0;
        } catch (IOException e3) {
            A0B(e3);
            Log.e(A04, A08(148, 36, 48) + str + strA08, e3);
            return 0;
        } finally {
            A0A(bOut);
            A0A(fileOutputStream);
        }
    }

    private final Bitmap A01(AnonymousClass85 anonymousClass85, C14047r c14047r, int i, int i2, String str) {
        if (C14097w.A06(anonymousClass85) && A08(266, 4, 37).equals(str)) {
            this.A01.put(c14047r.A07, c14047r);
        }
        String str2 = c14047r.A07;
        C14087v c14087v = new C14087v(c14047r.A05, c14047r.A06, A08(261, 5, 89), str, str2);
        File fileA07 = A07(this.A00);
        StringBuilder sbAppend = new StringBuilder().append(str2.hashCode());
        String url = A08(2, 4, 26);
        File file = new File(fileA07, sbAppend.append(url).toString());
        if (!file.exists()) {
            C14097w.A04(anonymousClass85, c14087v, false);
            String url2 = A08(232, 7, 112);
            if (str2.startsWith(url2)) {
                if (A03[4].charAt(22) == 'U') {
                    throw new RuntimeException();
                }
                A03[4] = "1yvOkimt2rWPU4mmWW1HHQmjZRsiMbmk";
                String url3 = A08(239, 22, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE);
                if (!str2.startsWith(url3)) {
                    return A04(str2, i2, i);
                }
            }
            return A02(anonymousClass85, c14047r, str);
        }
        C14097w.A04(anonymousClass85, c14087v, true);
        try {
            if (A0C(i2, i)) {
                return AbstractC14117y.A02(file.getCanonicalPath(), i2, i, this.A00);
            }
            String url4 = file.getCanonicalPath();
            return BitmapFactory.decodeFile(url4);
        } catch (IOException e) {
            A0B(e);
            return null;
        }
    }

    private Bitmap A03(String str) {
        byte[] bArrA6s;
        JQ jqAG4 = C1688Jj.A00(this.A00).AG4(str, new C1684Jf());
        if (jqAG4 == null || (bArrA6s = jqAG4.A6s()) == null) {
            return null;
        }
        int length = bArrA6s.length;
        if (A03[4].charAt(22) == 'U') {
            throw new RuntimeException();
        }
        A03[2] = "99IwdndnBnCK07hgvsXqxjXsnHcettbD";
        return BitmapFactory.decodeByteArray(bArrA6s, 0, length);
    }

    private Bitmap A04(String str, int i, int i2) {
        Bitmap bitmapDecodeStream;
        try {
            boolean zA0C = A0C(i, i2);
            String strA08 = A08(232, 7, 112);
            if (zA0C) {
                bitmapDecodeStream = AbstractC14117y.A02(str.substring(strA08.length()), i, i2, this.A00);
            } else {
                bitmapDecodeStream = BitmapFactory.decodeStream(new FileInputStream(str.substring(strA08.length())), null, null);
            }
            int iA00 = A00(str, bitmapDecodeStream);
            if (C14499m.A10(this.A00) && iA00 <= 0) {
                return null;
            }
            return bitmapDecodeStream;
        } catch (IOException e) {
            Log.e(A04, A08(105, 43, 120) + str + A08(0, 2, 105), e);
        }
    }

    private Bitmap A05(String str, int i, int i2) throws IOException {
        URL urlObj = new URL(str);
        HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
        connection.setDoInput(true);
        connection.connect();
        InputStream inputStream = connection.getInputStream();
        Bitmap bitmapA01 = AbstractC14117y.A01(inputStream, i, i2);
        A0A(inputStream);
        return bitmapA01;
    }

    public static C14077u A06(C2698k0 c2698k0) {
        if (A05 == null) {
            synchronized (C14077u.class) {
                if (A05 == null) {
                    A05 = new C14077u(c2698k0);
                }
            }
        }
        return A05;
    }

    public static File A07(AnonymousClass85 anonymousClass85) {
        return anonymousClass85.getCacheDir();
    }

    public static void A0A(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    private void A0B(Throwable th) {
        String strA08 = A08(261, 5, 89);
        if (th != null) {
            this.A00.A08().AAu(strA08, AbstractC14128a.A1f, new C14138b(th));
        } else {
            this.A00.A08().AAu(strA08, AbstractC14128a.A1f, new C14138b(A08(77, 28, 18)));
        }
    }

    private boolean A0C(int i, int i2) {
        return i > 0 && i2 > 0;
    }

    public final Bitmap A0D(C14047r c14047r) {
        return A01(this.A00, c14047r, c14047r.A04, c14047r.A03, c14047r.A01);
    }

    public final Bitmap A0E(AnonymousClass85 anonymousClass85, String str, int i, int i2, String str2) {
        C14047r c14047r = this.A01.get(str);
        return (!C14097w.A06(anonymousClass85) || c14047r == null) ? A01(anonymousClass85, new C14047r(str, i, i2, A08(270, 7, 28), A08(270, 7, 28)), i2, i, str2) : A01(anonymousClass85, c14047r, i2, i, str2);
    }

    public final File A0F(String str) {
        File file = new File(A07(this.A00), str.hashCode() + A08(2, 4, 26));
        if (file.exists()) {
            return file;
        }
        return null;
    }

    public final String A0G(String str) {
        File file = new File(A07(this.A00), str.hashCode() + A08(2, 4, 26));
        return file.exists() ? file.getPath() : str;
    }
}
