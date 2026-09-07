package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.Proxy;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0p, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C12240p extends AbstractC13405e implements C5A {
    public static byte[] A0G;
    public static String[] A0H = {"AHTh3LA", "dz9dBpIjsUhtDgGieeCPe537sIDjFabE", "w2cOblChiabhIBK2wmaThN4UxbXYE62t", "xoeUGL4eue58TuIto061cWyCqVAw3O1z", "gq8eFqwTQJvrhbPMke", "RYAI5nESuWZ2rhTI63kEoTOBdt3hOueO", "RDHxxAAMbCEIS74NmBfQosd5J71Yw", "p9GjEcAytNVfsoqugLJlSuHeg4U"};

    @MetaExoPlayerCustomization
    public static final Pattern A0I;

    @MetaExoPlayerCustomization("Meta Specific, added in D30556310")
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public C2318dj A04;
    public InterfaceC2590iE<String> A05;
    public InputStream A06;
    public HttpURLConnection A07;
    public boolean A08;
    public final int A09;
    public final int A0A;
    public final C2328du A0B;
    public final C2328du A0C;
    public final String A0D;
    public final boolean A0E;
    public final boolean A0F;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0G, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 18);
        }
        return new String(bArrCopyOfRange);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @MetaExoPlayerCustomization("Meta Specific, added in D4001689 for 'Handling loopback Address'")
    private HttpURLConnection A05(URL url, int i, byte[] bArr, long j, long j2, boolean z, boolean z2, Map<String, String> map) throws IOException {
        HttpURLConnection httpURLConnectionA04;
        String strA02;
        if (InetAddress.getByName(url.getHost()).isLoopbackAddress()) {
            Proxy proxy = Proxy.NO_PROXY;
            if (A0H[4].length() == 18) {
                A0H[7] = "05ili6syMLXE64p9WlTtyQYQXmn";
                httpURLConnectionA04 = A06(url, proxy);
            }
            throw new RuntimeException();
        }
        httpURLConnectionA04 = A04(url);
        httpURLConnectionA04.setConnectTimeout(this.A09);
        httpURLConnectionA04.setReadTimeout(this.A0A);
        HashMap map2 = new HashMap();
        if (this.A0B != null) {
            map2.putAll(this.A0B.A00());
        }
        map2.putAll(this.A0C.A00());
        map2.putAll(map);
        for (Map.Entry entry : map2.entrySet()) {
            httpURLConnectionA04.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        String strA03 = AbstractC2329dv.A03(j, j2);
        if (strA03 != null) {
            httpURLConnectionA04.setRequestProperty(A02(172, 5, 112), strA03);
        }
        if (this.A0D != null) {
            if (A0H[0].length() != 7) {
                A0H[6] = "nUFvo5Fq7cIKliBrHLEx9u4WbPaUq";
                httpURLConnectionA04.setRequestProperty(A02(317, 0, 22), this.A0D);
            } else {
                A0H[5] = "SIgd87NqbA3VQEmghn03KStHVMo9tfsp";
                httpURLConnectionA04.setRequestProperty(A02(317, 10, 29), this.A0D);
            }
        }
        if (!z) {
            strA02 = A02(503, 8, 96);
        } else if (A0H[5].charAt(11) != 'P') {
            A0H[2] = "Uigxz3QATBDf8AixCgPxzMGxP4fMNuyH";
            strA02 = A02(490, 4, 64);
        } else {
            strA02 = A02(490, 4, 64);
        }
        httpURLConnectionA04.setRequestProperty(A02(5, 15, 103), strA02);
        httpURLConnectionA04.setInstanceFollowRedirects(z2);
        httpURLConnectionA04.setDoOutput(bArr != null);
        httpURLConnectionA04.setRequestMethod(C2318dj.A01(i));
        if (bArr != null) {
            int length = bArr.length;
            if (A0H[7].length() == 27) {
                A0H[6] = "vuHDFK0PP89aN4hQ5ZKf3JaHZS7DL";
                httpURLConnectionA04.setFixedLengthStreamingMode(length);
                httpURLConnectionA04.connect();
                OutputStream outputStream = httpURLConnectionA04.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
            }
            throw new RuntimeException();
        }
        httpURLConnectionA04.connect();
        return httpURLConnectionA04;
    }

    public static void A09() {
        A0G = new byte[]{104, 60, 39, 104, 77, 52, Ascii.SYN, Ascii.SYN, Ascii.DLE, 5, 1, 88, 48, Ascii.ESC, Ascii.SYN, Ascii.SUB, 17, Ascii.FS, Ascii.ESC, Ascii.DC2, 55, Ascii.ESC, Ascii.SUB, 0, 17, Ascii.SUB, 0, 89, 49, Ascii.SUB, Ascii.ETB, Ascii.ESC, Ascii.DLE, Ascii.GS, Ascii.SUB, 19, 49, Ascii.GS, Ascii.FS, 6, Ascii.ETB, Ascii.FS, 6, 95, 62, Ascii.ETB, Ascii.FS, Ascii.NAK, 6, Ascii.SUB, 8, 36, 37, 63, 46, 37, 63, 102, Ascii.EM, 42, 37, 44, 46, 97, SignedBytes.MAX_POWER_OF_TWO, 67, 68, 80, 73, 81, 109, 81, 81, 85, 97, 68, 81, 68, 118, 74, 80, 87, 70, SignedBytes.MAX_POWER_OF_TWO, Base64.padSymbol, Ascii.DLE, 10, Ascii.CAN, Ascii.NAK, Ascii.NAK, Ascii.SYN, Ascii.SO, Ascii.FS, Ascii.GS, 89, Ascii.SUB, Ascii.VT, Ascii.SYN, 10, 10, 84, 9, Ascii.VT, Ascii.SYN, Ascii.CR, Ascii.SYN, Ascii.SUB, Ascii.SYN, Ascii.NAK, 89, Ascii.VT, Ascii.FS, Ascii.GS, Ascii.DLE, Ascii.VT, Ascii.FS, Ascii.SUB, Ascii.CR, 89, 81, 123, 92, 81, 93, 92, 65, 91, 65, 70, 87, 92, 70, Ascii.DC2, 90, 87, 83, 86, 87, SignedBytes.MAX_POWER_OF_TWO, 65, Ascii.DC2, 105, 106, 73, 69, 71, 82, 79, 73, 72, 108, 87, 78, 78, 2, 78, 77, 65, 67, 86, 75, 77, 76, 2, 80, 71, 70, 75, 80, 71, 65, 86, 48, 3, Ascii.FF, 5, 7, 56, 3, 3, 76, 1, Ascii.CR, 2, Ascii.NAK, 76, Ascii.RS, 9, 8, 5, Ascii.RS, 9, Ascii.SI, Ascii.CAN, Ascii.US, 86, 76, 0, 59, 48, 45, 37, 48, 54, 33, 48, 49, 117, Ascii.SYN, 58, 59, 33, 48, 59, 33, 120, Ascii.EM, 48, 59, 50, 33, Base64.padSymbol, 117, Ascii.SO, 7, 60, 55, 42, 34, 55, 49, 38, 55, 54, 114, 17, Base64.padSymbol, 60, 38, 55, 60, 38, 127, 0, 51, 60, 53, 55, 114, 9, Ascii.SI, 52, 63, 34, 42, 63, 57, 46, 63, 62, 122, 63, 40, 40, 53, 40, 122, 45, 50, 51, 54, 63, 122, 62, 51, 41, 57, 53, 52, 52, 63, 57, 46, 51, 52, Base64.padSymbol, 127, 68, 89, 95, 90, 90, 69, 88, 94, 79, 78, 10, 90, 88, 69, 94, 69, 73, 69, 70, 10, 88, 79, 78, 67, 88, 79, 73, 94, Ascii.DLE, 10, 90, 124, 106, 125, 34, 78, 104, 106, 97, 123, 1, 48, 77, 54, 71, 123, 96, 109, 124, 106, 57, 49, 69, 125, 50, 48, 52, 49, 69, 125, 50, 48, 54, 49, 69, 125, 50, 48, Base64.padSymbol, 40, 36, 38, 101, 42, 37, 47, 57, 36, 34, 47, 101, 36, 32, 35, 63, 63, 59, 101, 34, 37, 63, 46, 57, 37, 42, 39, 101, 35, 63, 63, 59, 101, 3, 63, 63, 59, Ascii.US, 57, 42, 37, 56, 59, 36, 57, 63, 111, 8, 35, 62, 37, 32, 46, 47, 2, 37, 59, 62, 63, Ascii.CAN, 63, 57, 46, 42, 38, 117, 121, 123, 56, 119, 120, 114, 100, 121, 127, 114, 56, 121, 125, 126, 98, 98, 102, 56, 127, 120, 98, 115, 100, 120, 119, 122, 56, 126, 98, 98, 102, 56, 94, 98, 98, 102, 66, 100, 119, 120, 101, 102, 121, 100, 98, 50, 80, 127, 110, 115, 114, 90, 115, 120, 113, 98, 126, 95, 120, 102, 99, 98, 69, 98, 100, 115, 119, 123, 53, 40, 59, 34, 97, 125, 125, 121, 118, 106, 106, 110, 109, Ascii.ESC, Ascii.SYN, Ascii.ETB, Ascii.FS, 6, Ascii.ESC, 6, Ascii.VT, 53, 46, 37, 56, 48, 37, 35, 52, 37, 36, 5, 46, 36, Ascii.SI, 38, 9, 46, 48, 53, 52};
    }

    static {
        A09();
        A0I = Pattern.compile(A02(331, 25, 11));
    }

    @Deprecated
    public C12240p() {
        this(null, 8000, 8000);
    }

    @Deprecated
    public C12240p(String str, int i, int i2) {
        this(str, i, i2, false, null);
    }

    @Deprecated
    public C12240p(String str, int i, int i2, boolean z, C2328du c2328du) {
        this(str, i, i2, z, c2328du, null, false);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.iE != com.google.common.base.Predicate<java.lang.String> */
    public C12240p(String str, int i, int i2, boolean z, C2328du c2328du, InterfaceC2590iE<String> interfaceC2590iE, boolean z2) {
        super(true);
        this.A00 = -1;
        this.A0D = str;
        this.A09 = i;
        this.A0A = i2;
        this.A0E = z;
        this.A0B = c2328du;
        this.A05 = interfaceC2590iE;
        this.A0C = new C2328du();
        this.A0F = z2;
    }

    private int A00(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.A03;
        if (A0H[2].charAt(26) == 'c') {
            throw new RuntimeException();
        }
        String[] strArr = A0H;
        strArr[3] = "J6yI0Ooy9noLCilbQHXUkK5VbFrVOQMs";
        strArr[1] = "E23cNHplIFmbNtbK16bNfBaSwk52GYz5";
        if (j != -1) {
            long bytesRemaining = this.A03 - this.A02;
            if (bytesRemaining == 0) {
                return -1;
            }
            i2 = (int) Math.min(i2, bytesRemaining);
        }
        int i3 = ((InputStream) AbstractC2471gE.A0f(this.A06)).read(bArr, i, i2);
        if (i3 == -1) {
            return -1;
        }
        this.A02 += (long) i3;
        A0F(i3);
        return i3;
    }

    @MetaExoPlayerCustomization
    public static long A01(HttpURLConnection httpURLConnection) {
        long jMax = -1;
        String headerField = httpURLConnection.getHeaderField(A02(36, 14, 96));
        boolean zIsEmpty = TextUtils.isEmpty(headerField);
        String strA02 = A02(327, 1, 78);
        String strA03 = A02(63, 21, 55);
        if (!zIsEmpty) {
            try {
                jMax = Long.parseLong(headerField);
            } catch (NumberFormatException unused) {
                AbstractC2432fb.A05(strA03, A02(197, 27, 71) + headerField + strA02);
            }
        }
        String headerField2 = httpURLConnection.getHeaderField(A02(50, 13, 89));
        if (!TextUtils.isEmpty(headerField2)) {
            Matcher matcher = A0I.matcher(headerField2);
            if (matcher.find()) {
                try {
                    long j = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                    if (jMax < 0) {
                        return j;
                    }
                    if (jMax != j) {
                        AbstractC2432fb.A07(strA03, A02(120, 22, 32) + headerField + A02(328, 3, 127) + headerField2 + strA02);
                        jMax = Math.max(jMax, j);
                        return jMax;
                    }
                    return jMax;
                } catch (NumberFormatException unused2) {
                    AbstractC2432fb.A05(strA03, A02(224, 26, 64) + headerField2 + strA02);
                    return jMax;
                }
            }
            return jMax;
        }
        return jMax;
    }

    private HttpURLConnection A03(C2318dj c2318dj) throws IOException {
        URL url = new URL(c2318dj.A06.toString());
        int i = c2318dj.A01;
        byte[] bArr = c2318dj.A0A;
        long j = c2318dj.A04;
        long j2 = c2318dj.A03;
        boolean zA06 = c2318dj.A06(1);
        if (!this.A0E && !this.A0F) {
            return A05(url, i, bArr, j, j2, zA06, true, c2318dj.A09);
        }
        int responseCode = 0;
        while (true) {
            int i2 = responseCode + 1;
            if (responseCode > 20) {
                throw new C1833Pl(new NoRouteToHostException(A02(177, 20, 126) + i2), c2318dj, 2001, 1);
            }
            URL url2 = url;
            int redirectCount = i;
            HttpURLConnection httpURLConnectionA05 = A05(url, redirectCount, bArr, j, j2, zA06, false, c2318dj.A09);
            int responseCode2 = httpURLConnectionA05.getResponseCode();
            String headerField = httpURLConnectionA05.getHeaderField(A02(142, 8, 52));
            if ((i == 1 || i == 3) && (responseCode2 == 300 || responseCode2 == 301 || responseCode2 == 302 || responseCode2 == 303 || responseCode2 == 307 || responseCode2 == 308)) {
                httpURLConnectionA05.disconnect();
                url = A07(url2, headerField, c2318dj);
            } else if (i == 2 && (responseCode2 == 300 || responseCode2 == 301 || responseCode2 == 302 || responseCode2 == 303)) {
                httpURLConnectionA05.disconnect();
                if (!(this.A0F && responseCode2 == 302)) {
                    i = 1;
                    bArr = null;
                }
                url = A07(url2, headerField, c2318dj);
            } else {
                return httpURLConnectionA05;
            }
            responseCode = i2;
        }
    }

    private final HttpURLConnection A04(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    @MetaExoPlayerCustomization
    private final HttpURLConnection A06(URL url, Proxy proxy) throws IOException {
        return (HttpURLConnection) url.openConnection(proxy);
    }

    private URL A07(URL url, String str, C2318dj c2318dj) throws C1833Pl {
        if (str == null) {
            throw new C1833Pl(A02(150, 22, 48), c2318dj, 2001, 1);
        }
        try {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if (!A02(498, 5, 12).equals(protocol) && !A02(494, 4, 27).equals(protocol)) {
                throw new C1833Pl(A02(286, 31, 56) + protocol, c2318dj, 2001, 1);
            }
            if (!this.A0E && !protocol.equals(url.getProtocol())) {
                throw new C1833Pl(A02(84, 36, 107) + url.getProtocol() + A02(0, 4, 90) + protocol + A02(4, 1, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE), c2318dj, 2001, 1);
            }
            return url2;
        } catch (MalformedURLException e) {
            throw new C1833Pl(e, c2318dj, 2001, 1);
        }
    }

    private void A08() {
        if (this.A07 != null) {
            try {
                this.A07.disconnect();
            } catch (Exception e) {
                AbstractC2432fb.A08(A02(63, 21, 55), A02(250, 36, 72), e);
            }
            if (A0H[7].length() != 27) {
                throw new RuntimeException();
            }
            A0H[6] = "GyUr1AByEotWO4zvLC3vzlc3xeB6u";
            this.A07 = null;
        }
    }

    private void A0A(long j, C2318dj c2318dj) throws IOException {
        if (j == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j > 0) {
            int i = ((InputStream) AbstractC2471gE.A0f(this.A06)).read(bArr, 0, (int) Math.min(j, bArr.length));
            if (!Thread.currentThread().isInterrupted()) {
                if (i != -1) {
                    j -= (long) i;
                    A0F(i);
                } else {
                    throw new C1833Pl(c2318dj, 2008, 1);
                }
            } else {
                throw new C1833Pl(new InterruptedIOException(), c2318dj, 2000, 1);
            }
        }
    }

    public static void A0B(HttpURLConnection httpURLConnection, long j) {
        if (httpURLConnection == null || AbstractC2471gE.A02 < 19 || AbstractC2471gE.A02 > 20) {
            return;
        }
        try {
            InputStream inputStream = httpURLConnection.getInputStream();
            if (j == -1) {
                if (inputStream.read() == -1) {
                    return;
                }
            } else {
                if (A0H[6].length() != 29) {
                    throw new RuntimeException();
                }
                A0H[7] = "VEux1xEU6LE0nndVxLVDdVqeGR8";
                if (j <= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) {
                    return;
                }
            }
            String name = inputStream.getClass().getName();
            if (A02(356, 65, 89).equals(name) || A02(421, 69, 4).equals(name)) {
                Method declaredMethod = ((Class) AbstractC2388es.A01(inputStream.getClass().getSuperclass())).getDeclaredMethod(A02(511, 20, 82), new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(inputStream, new Object[0]);
            }
        } catch (Exception unused) {
        }
    }

    public static boolean A0C(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField(A02(20, 16, 102));
        String contentEncoding = A02(490, 4, 64);
        return contentEncoding.equalsIgnoreCase(headerField);
    }

    public final void A0I(String str, String str2) {
        AbstractC2388es.A01(str);
        AbstractC2388es.A01(str2);
        this.A0C.A01(str, str2);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC13405e, com.facebook.ads.redexgen.core.Q7
    public final Map<String, List<String>> A8j() {
        if (this.A07 == null) {
            return AbstractC2804lm.A04();
        }
        return new C5J(this.A07.getHeaderFields());
    }

    @Override // com.facebook.ads.redexgen.core.Q7
    public final Uri A9F() {
        if (this.A07 == null) {
            return null;
        }
        return Uri.parse(this.A07.getURL().toString());
    }

    /* JADX WARN: Code duplicated, block: B:50:0x011c  */
    /* JADX WARN: Code duplicated, block: B:52:0x0128  */
    /* JADX WARN: Code duplicated, block: B:54:0x012f  */
    /* JADX WARN: Code duplicated, block: B:56:0x0149  */
    /* JADX WARN: Code duplicated, block: B:61:0x015d  */
    @Override // com.facebook.ads.redexgen.core.Q7
    @MetaExoPlayerCustomization("customizations: (1) loop commented 'Append headers from data spec' (D6487388,D6506073) (2) ischunkedTransfer (D15078204)")
    public final long AFq(final C2318dj c2318dj) throws IOException {
        final byte[] bArrA1F;
        final C2311dc c2311dc;
        this.A04 = c2318dj;
        long j = 0;
        this.A02 = 0L;
        this.A03 = 0L;
        A0G(c2318dj);
        if (c2318dj.A07 != null) {
            for (Map.Entry<String, String> entry : c2318dj.A07.A0Q.entrySet()) {
                A0I(entry.getKey(), entry.getValue());
            }
        }
        try {
            this.A07 = A03(c2318dj);
            HttpURLConnection httpURLConnection = this.A07;
            this.A01 = httpURLConnection.getResponseCode();
            final String responseMessage = httpURLConnection.getResponseMessage();
            int i = this.A01;
            String contentType = A02(50, 13, 89);
            if (i >= 200) {
                int i2 = this.A01;
                if (A0H[5].charAt(11) == 'P') {
                    throw new RuntimeException();
                }
                A0H[6] = "Yx7OLaEVKg7px8lQCrnLwILzzrvbJ";
                if (i2 <= 299) {
                    final String contentType2 = httpURLConnection.getContentType();
                    if (this.A05 == null || this.A05.A42(contentType2)) {
                        if (this.A01 == 200 && c2318dj.A04 != 0) {
                            j = c2318dj.A04;
                        }
                        boolean zA0C = A0C(httpURLConnection);
                        if (A0H[2].charAt(26) != 'c') {
                            A0H[4] = "NoLcfuZUfNOnqVqSCN";
                            if (zA0C) {
                                this.A03 = c2318dj.A03;
                            } else {
                                int i3 = (A01(httpURLConnection) > (-1L) ? 1 : (A01(httpURLConnection) == (-1L) ? 0 : -1));
                                if (c2318dj.A03 != -1) {
                                    this.A03 = c2318dj.A03;
                                } else {
                                    long jA01 = AbstractC2329dv.A01(httpURLConnection.getHeaderField(A02(36, 14, 96)), httpURLConnection.getHeaderField(contentType));
                                    long bytesToSkip = jA01 != -1 ? jA01 - j : -1L;
                                    this.A03 = bytesToSkip;
                                }
                            }
                        } else {
                            String[] strArr = A0H;
                            strArr[3] = "iS9kPkY5auuYWdXhqiLxM0JtSbYBXF14";
                            strArr[1] = "3X4QoizuqrmngOJd41XC0XJLCatoBkAE";
                            if (zA0C) {
                                this.A03 = c2318dj.A03;
                            } else {
                                int i4 = (A01(httpURLConnection) > (-1L) ? 1 : (A01(httpURLConnection) == (-1L) ? 0 : -1));
                                if (c2318dj.A03 != -1) {
                                    this.A03 = c2318dj.A03;
                                } else {
                                    long jA02 = AbstractC2329dv.A01(httpURLConnection.getHeaderField(A02(36, 14, 96)), httpURLConnection.getHeaderField(contentType));
                                    if (jA02 != -1) {
                                    }
                                    this.A03 = bytesToSkip;
                                }
                            }
                        }
                        try {
                            this.A06 = httpURLConnection.getInputStream();
                            if (zA0C) {
                                this.A06 = new GZIPInputStream(this.A06);
                            }
                            this.A08 = true;
                            A0H(c2318dj);
                            try {
                                A0A(j, c2318dj);
                                return this.A03;
                            } catch (IOException e) {
                                A08();
                                if (!(e instanceof C1833Pl)) {
                                    throw new C1833Pl(e, c2318dj, 2000, 1);
                                }
                                throw ((C1833Pl) e);
                            }
                        } catch (IOException e2) {
                            A08();
                            throw new C1833Pl(e2, c2318dj, 2000, 1);
                        }
                    }
                    A08();
                    IOException e3 = new C1833Pl(contentType2, c2318dj) { // from class: com.facebook.ads.redexgen.X.5F
                        public static byte[] A01;
                        public static String[] A02 = {"TH2jfRJyeAeB8nmlEA26DBIiZcblDCUD", "FD1CD9uXQJsGpAkRU3bzLUn4Mk5AK4oN", "MGSMNh85R5O", "jW", "tz66aw9tVCwQwFAtEQHxaPE8zapt6bFR", "Y6d9CXP6oq3TNCs6FoXP", "w0z0M6ofNbcQBGlrV6OcnNNh4F6173fW", "OJQxdTk9eO0Noc5ZCZoI"};
                        public final String A00;

                        public static String A00(int i5, int i6, int i7) {
                            byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i5, i5 + i6);
                            for (int i8 = 0; i8 < bArrCopyOfRange.length; i8++) {
                                bArrCopyOfRange[i8] = (byte) ((bArrCopyOfRange[i8] ^ i7) ^ 75);
                            }
                            return new String(bArrCopyOfRange);
                        }

                        public static void A01() {
                            if (A02[6].charAt(20) == 'O') {
                                throw new RuntimeException();
                            }
                            A02[2] = "jskuf9jvaVMfqvebaigayb1Tk";
                            A01 = new byte[]{63, Ascii.CAN, 0, Ascii.ETB, Ascii.SUB, Ascii.US, Ascii.DC2, 86, Ascii.NAK, Ascii.EM, Ascii.CAN, 2, 19, Ascii.CAN, 2, 86, 2, Ascii.SI, 6, 19, 76, 86};
                        }

                        static {
                            A01();
                        }

                        {
                            super(A00(0, 22, 61) + contentType2, c2318dj, 2003, 1);
                            this.A00 = contentType2;
                        }
                    };
                    throw e3;
                }
            }
            final Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            if (this.A01 == 416) {
                if (c2318dj.A04 == AbstractC2329dv.A00(httpURLConnection.getHeaderField(contentType))) {
                    this.A08 = true;
                    A0H(c2318dj);
                    if (c2318dj.A03 != -1) {
                        return c2318dj.A03;
                    }
                    return 0L;
                }
            }
            InputStream errorStream = httpURLConnection.getErrorStream();
            try {
                bArrA1F = errorStream != null ? AbstractC2471gE.A1F(errorStream) : AbstractC2471gE.A07;
            } catch (IOException unused) {
                bArrA1F = AbstractC2471gE.A07;
                if (A0H[5].charAt(11) != 'P') {
                    A0H[7] = "Gf7CnjzMvovkc33EJKTNrOMCYHq";
                }
            }
            A08();
            if (this.A01 == 416) {
                c2311dc = new C2311dc(2008);
            } else {
                c2311dc = null;
            }
            final int i5 = this.A01;
            throw new C1833Pl(i5, responseMessage, c2311dc, headerFields, c2318dj, bArrA1F) { // from class: com.facebook.ads.redexgen.X.5B
                public static byte[] A04;
                public final int A00;
                public final String A01;
                public final Map<String, List<String>> A02;
                public final byte[] A03;

                static {
                    A01();
                }

                public static String A00(int i6, int i7, int i8) {
                    byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i6, i6 + i7);
                    for (int i9 = 0; i9 < bArrCopyOfRange.length; i9++) {
                        bArrCopyOfRange[i9] = (byte) ((bArrCopyOfRange[i9] ^ i8) ^ 92);
                    }
                    return new String(bArrCopyOfRange);
                }

                public static void A01() {
                    A04 = new byte[]{95, 104, 126, 125, 98, 99, 126, 104, 45, 110, 98, 105, 104, 55, 45};
                }

                {
                    super(A00(0, 15, 81) + i5, c2311dc, c2318dj, 2004, 1);
                    this.A00 = i5;
                    this.A01 = responseMessage;
                    this.A02 = headerFields;
                    this.A03 = bArrA1F;
                }
            };
        } catch (IOException e4) {
            A08();
            throw C1833Pl.A03(e4, c2318dj, 1);
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x003f */
    @Override // com.facebook.ads.redexgen.core.Q7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void close() throws com.facebook.ads.redexgen.core.C1833Pl {
        /*
            r9 = this;
            r5 = 0
            r6 = 0
            java.io.InputStream r4 = r9.A06     // Catch: java.lang.Throwable -> L3f
            if (r4 == 0) goto L30
            long r7 = r9.A03     // Catch: java.lang.Throwable -> L3f
            r2 = -1
            int r0 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r0 != 0) goto L14
        Le:
            java.net.HttpURLConnection r0 = r9.A07     // Catch: java.lang.Throwable -> L3f
            A0B(r0, r2)     // Catch: java.lang.Throwable -> L3f
            goto L1a
        L14:
            long r2 = r9.A03     // Catch: java.lang.Throwable -> L3f
            long r0 = r9.A02     // Catch: java.lang.Throwable -> L3f
            long r2 = r2 - r0
            goto Le
        L1a:
            r4.close()     // Catch: java.io.IOException -> L1e java.lang.Throwable -> L3f
            goto L30
        L1e:
            r4 = move-exception
            com.facebook.ads.redexgen.X.dj r0 = r9.A04     // Catch: java.lang.Throwable -> L3f
            java.lang.Object r3 = com.facebook.ads.redexgen.core.AbstractC2471gE.A0f(r0)     // Catch: java.lang.Throwable -> L3f
            com.facebook.ads.redexgen.X.dj r3 = (com.facebook.ads.redexgen.core.C2318dj) r3     // Catch: java.lang.Throwable -> L3f
            r2 = 2000(0x7d0, float:2.803E-42)
            r1 = 3
            com.facebook.ads.redexgen.X.Pl r0 = new com.facebook.ads.redexgen.X.Pl     // Catch: java.lang.Throwable -> L3f
            r0.<init>(r4, r3, r2, r1)     // Catch: java.lang.Throwable -> L3f
            throw r0     // Catch: java.lang.Throwable -> L3f
        L30:
            r9.A06 = r6
            r9.A08()
            boolean r0 = r9.A08
            if (r0 == 0) goto L3e
            r9.A08 = r5
            r9.A0E()
        L3e:
            return
        L3f:
            r3 = move-exception
            r9.A06 = r6
            r9.A08()
            boolean r0 = r9.A08
            if (r0 == 0) goto L64
            r9.A08 = r5
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.C12240p.A0H
            r0 = 2
            r1 = r1[r0]
            r0 = 26
            char r1 = r1.charAt(r0)
            r0 = 99
            if (r1 == r0) goto L65
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C12240p.A0H
            java.lang.String r1 = "KbhwiyEXQ1AE1rdlVyrO0sE4Wca7u4tn"
            r0 = 2
            r2[r0] = r1
            r9.A0E()
        L64:
            throw r3
        L65:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C12240p.close():void");
    }

    @Override // com.facebook.ads.redexgen.core.O9
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            return A00(bArr, i, i2);
        } catch (IOException e) {
            throw C1833Pl.A03(e, (C2318dj) AbstractC2471gE.A0f(this.A04), 2);
        }
    }
}
