package com.facebook.ads.redexgen.core;

import android.net.TrafficStats;
import android.text.TextUtils;
import android.util.Log;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.HttpsURLConnection;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ae, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2130ae implements JR {
    public static byte[] A07;
    public static String[] A08 = {"QhNFYJC9gEUd0JRpeTZcIYaCPwaofmcY", "H7lFuH2c6lRKE1KzrEc8woYXA3m4qwgD", "VasthUCsKtAfJQ49O69n9k2VDB8sk6Ry", "CLNAbcda3kskZ9l1P61KK9o7E81JDy0P", "FTSbac7VR6oRDuoXxASKkUBG2ay4Jl1O", "oDWQMCtwqliv6oQHoqRk4BTd2HTxQUcC", "maa7C87UpzAlS2qduOc8uqrscl2NkhxH", ""};
    public static final String A09;
    public C8Z A00;
    public Executor A01;
    public boolean A02;
    public JW A03;
    public final InterfaceC1680Jb A04 = new C2136ak();
    public final InterfaceC1685Jg A05;
    public final InterfaceC1686Jh A06;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 15 out of bounds for length 11
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.restartVar(DebugInfoParser.java:193)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:141)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    private final JQ A01(AbstractC1682Jd abstractC1682Jd) throws C1683Je {
        C1683Je c1683Je;
        String strA07 = A07(Sdk.SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE, 7, 86);
        HttpURLConnection httpURLConnection = null;
        C2131af c2131afA05 = null;
        boolean z = false;
        try {
            try {
                this.A02 = false;
                HttpURLConnection httpURLConnectionA08 = A08(abstractC1682Jd.A05(), C7.A04() ? A09() : null);
                A0H(httpURLConnectionA08, abstractC1682Jd);
                A0G(httpURLConnectionA08, abstractC1682Jd);
                if (this.A06.AAO()) {
                    this.A06.ABI(httpURLConnectionA08, abstractC1682Jd.A06());
                }
                httpURLConnectionA08.connect();
                this.A02 = true;
                Set<String> setA01 = this.A03.A01();
                Set<String> setA02 = this.A03.A02();
                boolean z2 = (setA01 == null || setA01.isEmpty()) ? false : true;
                if (setA02 != null && !setA02.isEmpty()) {
                    z = true;
                }
                if ((httpURLConnectionA08 instanceof HttpsURLConnection) && (z2 || z)) {
                    try {
                        AbstractC1687Ji.A03((HttpsURLConnection) httpURLConnectionA08, setA01, setA02);
                    } catch (CertificateException e) {
                        this.A00.ABM(strA07, AbstractC14128a.A1z, new C14138b(e));
                    } catch (Exception e2) {
                        this.A00.ABM(strA07, AbstractC14128a.A1y, new C14138b(e2));
                    }
                }
                if (httpURLConnectionA08.getDoOutput() && abstractC1682Jd.A06() != null) {
                    A00(httpURLConnectionA08, abstractC1682Jd.A06());
                }
                C2131af c2131afA06 = httpURLConnectionA08.getDoInput() ? A06(httpURLConnectionA08) : new C2131af(httpURLConnectionA08, null);
                if (this.A06.AAO()) {
                    this.A06.ABJ(c2131afA06);
                }
                if (httpURLConnectionA08 != null) {
                    httpURLConnectionA08.disconnect();
                }
                return c2131afA06;
            } catch (Exception e3) {
                try {
                    try {
                        c2131afA05 = A05(null);
                        if (A08[7].length() == 19) {
                            throw new RuntimeException();
                        }
                        A08[5] = "6Q02gTcavt1J3D6llCgnQfsLExV7BLlB";
                        if (c2131afA05 == null || c2131afA05.A92() <= 0) {
                            c1683Je = new C1683Je(e3, c2131afA05);
                            throw c1683Je;
                        }
                        if (this.A06.AAO()) {
                            this.A06.ABJ(c2131afA05);
                        }
                        if (0 != 0) {
                            httpURLConnection.disconnect();
                        }
                        return c2131afA05;
                    } catch (Exception unused) {
                        Log.e(getClass().getSimpleName(), A07(117, 13, 98), e3);
                        if (0 != 0 && c2131afA05.A92() > 0) {
                            if (this.A06.AAO()) {
                                this.A06.ABJ(null);
                            }
                            if (0 != 0) {
                                httpURLConnection.disconnect();
                            }
                            return null;
                        }
                        c1683Je = new C1683Je(e3, null);
                    }
                } catch (Throwable unused2) {
                    if (c2131afA05 == null || c2131afA05.A92() <= 0) {
                        throw new C1683Je(e3, c2131afA05);
                    }
                    if (this.A06.AAO()) {
                        this.A06.ABJ(c2131afA05);
                    }
                    if (0 != 0) {
                        httpURLConnection.disconnect();
                    }
                    return c2131afA05;
                }
            }
        } catch (Throwable th) {
            if (this.A06.AAO()) {
                this.A06.ABJ(c2131afA05);
            }
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    public static String A07(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 17);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0A() {
        A07 = new byte[]{59, 57, 102, 107, Ascii.SO, 102, 100, 77, SignedBytes.MAX_POWER_OF_TWO, 9, 77, 79, Ascii.RS, 93, 75, 76, 82, Ascii.RS, 42, 99, 121, 42, 100, 101, 126, 42, 107, 42, 124, 107, 102, 99, 110, 42, 95, 88, 70, 80, Ascii.US, Ascii.SYN, 80, 75, 120, 116, Ascii.ETB, 0, 116, 105, 116, 55, 59, 73, 79, 59, 38, 59, 38, 42, 126, 120, 115, 99, 100, 109, 42, 94, 4, 34, 43, 38, 55, 52, 34, 35, 71, 51, 46, 42, 34, 71, 90, 71, 71, 101, 116, 116, 105, 110, 103, 32, 116, 104, 101, 32, 104, 116, 116, 112, 32, 114, 101, 115, 112, 111, 110, 115, 101, 32, 116, 105, 109, 101, 100, 32, 111, 117, 116, Base64.padSymbol, Ascii.SYN, 7, 4, Ascii.FS, 1, Ascii.CAN, 83, Ascii.SYN, 1, 1, Ascii.FS, 1, Ascii.ETB, Ascii.SYN, 4, 111, 122, Ascii.SYN, 7, 7, Ascii.ESC, Ascii.RS, Ascii.DC4, Ascii.SYN, 3, Ascii.RS, Ascii.CAN, Ascii.EM, 88, Ascii.SI, 90, 0, 0, 0, 90, 17, Ascii.CAN, 5, Ascii.SUB, 90, 2, 5, Ascii.ESC, Ascii.DC2, Ascii.EM, Ascii.DC4, Ascii.CAN, 19, Ascii.DC2, 19, 76, Ascii.DC4, Ascii.US, Ascii.SYN, 5, 4, Ascii.DC2, 3, 74, 34, 35, 49, 90, 79, 89, 79, 72, 86, Ascii.SUB, Ascii.ETB, 81, Ascii.SUB, Ascii.ETB, 83, 120, 100, 100, 96, 62, 96, 98, 127, 104, 105, 88, 127, 99, 100, Ascii.ESC, 7, 7, 3, 93, 3, 1, Ascii.FS, Ascii.VT, 10, 35, Ascii.FS, 1, 7, 41, 34, 51, 48, 40, 53, 44};
    }

    /* JADX WARN: Code duplicated, block: B:25:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:43:0x011a  */
    /* JADX WARN: Code duplicated, block: B:45:0x0123  */
    /* JADX WARN: Code duplicated, block: B:50:0x012f  */
    /* JADX WARN: Code duplicated, block: B:52:0x0133  */
    /* JADX WARN: Code duplicated, block: B:55:0x013f  */
    /* JADX WARN: Code duplicated, block: B:56:0x0144  */
    /* JADX WARN: Code duplicated, block: B:57:0x0149  */
    /* JADX WARN: Code duplicated, block: B:58:0x0150  */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 44 out of bounds for length 31
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public final JQ A0J(AbstractC1682Jd abstractC1682Jd) throws C1683Je {
        JQ jqA00;
        long length;
        long length2;
        int iA92;
        int i = 0;
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iA01 = abstractC1682Jd.A02().A01();
        long jA03 = abstractC1682Jd.A02().A03();
        long jCurrentTimeMillis2 = System.currentTimeMillis() + ((long) abstractC1682Jd.A02().A04());
        while (true) {
            if (i >= iA01 || jCurrentTimeMillis2 <= System.currentTimeMillis()) {
                break;
            }
            try {
                if (this.A06.AAO()) {
                    String str = (i + 1) + A07(37, 4, 97) + iA01 + A07(56, 9, 27) + abstractC1682Jd.A05();
                }
                jCurrentTimeMillis = System.currentTimeMillis();
                JQ jqA01 = A01(abstractC1682Jd);
                if (jqA01 != null) {
                    this.A00.ABD(jCurrentTimeMillis, System.currentTimeMillis() - jCurrentTimeMillis, jqA01.A6s().length, abstractC1682Jd.A04 == null ? 0L : abstractC1682Jd.A04.length, jqA01.A92(), null);
                    return jqA01;
                }
                continue;
            } catch (C1683Je e) {
                if (!A0I(e, jCurrentTimeMillis, abstractC1682Jd)) {
                    if (this.A05.AD7(e)) {
                    }
                    jqA00 = e.A00();
                    C8Z c8z = this.A00;
                    long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis;
                    if (A08[1].charAt(0) != 'l') {
                        A08[4] = "ETXEAYq6mx6OG4ZVoxEdED8XICrn9DEf";
                        if (jqA00 != null) {
                            if (jqA00.A6s() == null) {
                                length = jqA00.A6s().length;
                            }
                        }
                        if (abstractC1682Jd.A04 == null) {
                            length2 = 0;
                        } else {
                            length2 = abstractC1682Jd.A04.length;
                        }
                        if (jqA00 == null) {
                            iA92 = 0;
                        } else {
                            iA92 = jqA00.A92();
                        }
                        c8z.ABD(jCurrentTimeMillis, jCurrentTimeMillis3, length, length2, iA92, e);
                        throw e;
                    }
                    A08[1] = "GUaOJDLzyYCGW5Cxc7undAaXJNT5GVew";
                    if (jqA00 != null) {
                        if (jqA00.A6s() == null) {
                            length = jqA00.A6s().length;
                        }
                    }
                    if (abstractC1682Jd.A04 == null) {
                        length2 = 0;
                    } else {
                        length2 = abstractC1682Jd.A04.length;
                    }
                    if (jqA00 == null) {
                        iA92 = 0;
                    } else {
                        iA92 = jqA00.A92();
                    }
                    c8z.ABD(jCurrentTimeMillis, jCurrentTimeMillis3, length, length2, iA92, e);
                    throw e;
                    length = 0;
                    if (abstractC1682Jd.A04 == null) {
                        length2 = 0;
                    } else {
                        length2 = abstractC1682Jd.A04.length;
                    }
                    if (jqA00 == null) {
                        iA92 = 0;
                    } else {
                        iA92 = jqA00.A92();
                    }
                    c8z.ABD(jCurrentTimeMillis, jCurrentTimeMillis3, length, length2, iA92, e);
                    throw e;
                }
                int i2 = iA01 - 1;
                if (A08[1].charAt(0) == 'l') {
                    throw new RuntimeException();
                }
                A08[1] = "iDEOxz3pTPjJqVLmMx3mPs9K2XOoyKBI";
                if (i < i2) {
                    continue;
                } else {
                    if (this.A05.AD7(e) || i >= iA01 - 1) {
                        jqA00 = e.A00();
                        C8Z c8z2 = this.A00;
                        long jCurrentTimeMillis4 = System.currentTimeMillis() - jCurrentTimeMillis;
                        if (A08[1].charAt(0) != 'l') {
                            A08[4] = "ETXEAYq6mx6OG4ZVoxEdED8XICrn9DEf";
                            if (jqA00 != null) {
                                if (jqA00.A6s() == null) {
                                    length = jqA00.A6s().length;
                                }
                            }
                            if (abstractC1682Jd.A04 == null) {
                                length2 = 0;
                            } else {
                                length2 = abstractC1682Jd.A04.length;
                            }
                            if (jqA00 == null) {
                                iA92 = 0;
                            } else {
                                iA92 = jqA00.A92();
                            }
                            c8z2.ABD(jCurrentTimeMillis, jCurrentTimeMillis4, length, length2, iA92, e);
                            throw e;
                        }
                        A08[1] = "GUaOJDLzyYCGW5Cxc7undAaXJNT5GVew";
                        if (jqA00 != null) {
                            if (jqA00.A6s() == null) {
                                length = jqA00.A6s().length;
                            }
                        }
                        if (abstractC1682Jd.A04 == null) {
                            length2 = 0;
                        } else {
                            length2 = abstractC1682Jd.A04.length;
                        }
                        if (jqA00 == null) {
                            iA92 = 0;
                        } else {
                            iA92 = jqA00.A92();
                        }
                        c8z2.ABD(jCurrentTimeMillis, jCurrentTimeMillis4, length, length2, iA92, e);
                        throw e;
                        length = 0;
                        if (abstractC1682Jd.A04 == null) {
                            length2 = 0;
                        } else {
                            length2 = abstractC1682Jd.A04.length;
                        }
                        if (jqA00 == null) {
                            iA92 = 0;
                        } else {
                            iA92 = jqA00.A92();
                        }
                        c8z2.ABD(jCurrentTimeMillis, jCurrentTimeMillis4, length, length2, iA92, e);
                        throw e;
                    }
                    if (jA03 > 0) {
                        try {
                            Thread.sleep(jA03);
                        } catch (InterruptedException e2) {
                            this.A00.ABD(jCurrentTimeMillis, System.currentTimeMillis() - jCurrentTimeMillis, 0L, abstractC1682Jd.A04 != null ? abstractC1682Jd.A04.length : 0L, 0, e2);
                            throw e;
                        }
                    } else {
                        continue;
                    }
                }
            }
            i++;
        }
        this.A00.ABD(jCurrentTimeMillis, System.currentTimeMillis() - jCurrentTimeMillis, 0L, abstractC1682Jd.A04 == null ? 0L : abstractC1682Jd.A04.length, 0, new TimeoutException(A07(82, 35, 17)));
        return null;
    }

    static {
        A0A();
        A09 = JR.class.getSimpleName();
    }

    public C2130ae(JW jw, C8Z c8z, Executor executor) {
        A0B();
        this.A03 = jw;
        this.A06 = new C2128ac(jw.A04());
        this.A05 = new HY(this, this.A06);
        this.A01 = executor;
        this.A00 = c8z;
    }

    private final int A00(HttpURLConnection httpURLConnection, byte[] bArr) throws Exception {
        OutputStream outputStreamAFv = null;
        try {
            outputStreamAFv = this.A05.AFv(httpURLConnection);
            if (outputStreamAFv != null) {
                this.A05.AKD(outputStreamAFv, bArr);
            }
            return httpURLConnection.getResponseCode();
        } finally {
            if (outputStreamAFv != null) {
                try {
                    outputStreamAFv.close();
                } catch (Exception unused) {
                }
            }
        }
    }

    private final JQ A02(AbstractC1682Jd abstractC1682Jd) {
        if (this.A03.A04()) {
            A0C(abstractC1682Jd);
        }
        JQ jqA01 = null;
        try {
            jqA01 = A01(abstractC1682Jd);
            return jqA01;
        } catch (C1683Je hre) {
            this.A05.AD7(hre);
            return jqA01;
        } catch (Exception e) {
            this.A05.AD7(new C1683Je(e, jqA01));
            return jqA01;
        }
    }

    private final JQ A03(String str, C1684Jf c1684Jf, JZ jz) {
        return A02(new C2133ah(str, c1684Jf, jz));
    }

    private final JQ A04(String str, String str2, byte[] bArr, JZ jz) {
        return A02(new C2132ag(str, null, str2, bArr, jz));
    }

    private final C2131af A05(HttpURLConnection httpURLConnection) throws Exception {
        InputStream errorStream = null;
        byte[] responseBody = null;
        try {
            errorStream = httpURLConnection.getErrorStream();
            if (errorStream != null) {
                responseBody = this.A05.AGb(errorStream);
            }
            return new C2131af(httpURLConnection, responseBody);
        } finally {
            if (errorStream != null) {
                try {
                    errorStream.close();
                } catch (Exception unused) {
                }
            }
        }
    }

    private final C2131af A06(HttpURLConnection httpURLConnection) throws Exception {
        InputStream inputStreamAFu = null;
        byte[] responseBody = null;
        try {
            inputStreamAFu = this.A05.AFu(httpURLConnection);
            if (inputStreamAFu != null) {
                responseBody = this.A05.AGb(inputStreamAFu);
            }
            C2131af c2131af = new C2131af(httpURLConnection, responseBody);
            if (inputStreamAFu != null) {
                try {
                    inputStreamAFu.close();
                } catch (Exception unused) {
                }
            }
            return c2131af;
        } catch (Throwable th) {
            String[] strArr = A08;
            if (strArr[3].charAt(2) != strArr[0].charAt(2)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[3] = "UXNjV4lzV2ywD4tdDbD0LjxSkhTqZWDx";
            strArr2[0] = "ckNMQEffDKJwLTwRJSWHE7UL6GsW6bMO";
            if (inputStreamAFu != null) {
                try {
                    inputStreamAFu.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    private final HttpURLConnection A08(String str, Proxy proxy) throws IOException {
        try {
            new URL(str);
            TrafficStats.setThreadStatsTag(61453);
            return this.A05.AFt(str, proxy);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(str + A07(18, 19, 27), e);
        }
    }

    public static Proxy A09() {
        Proxy proxy = Proxy.NO_PROXY;
        String property = System.getProperty(A07(192, 14, 1));
        String proxyAddress = System.getProperty(A07(206, 14, 98));
        int port = -1;
        if (proxyAddress != null) {
            try {
                port = Integer.parseInt(proxyAddress);
            } catch (NumberFormatException unused) {
                return proxy;
            }
        }
        if (!TextUtils.isEmpty(property) && port > 0 && port <= 65535) {
            return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(property, port));
        }
        return proxy;
    }

    public static synchronized void A0B() {
        if (CookieHandler.getDefault() == null) {
            CookieHandler.setDefault(new CookieManager());
        }
    }

    private void A0C(AbstractC1682Jd abstractC1682Jd) {
        StringBuilder sb = new StringBuilder(A07(182, 10, 43));
        boolean zEquals = abstractC1682Jd.A03().equals(EnumC1681Jc.A06);
        String strA07 = A07(41, 1, 120);
        if (zEquals) {
            byte[] bArrA06 = abstractC1682Jd.A06();
            if (A08[1].charAt(0) == 'l') {
                throw new RuntimeException();
            }
            A08[4] = "MgpsgMtpOSh21D9UNcI3ZUtvoefc4JIC";
            if (bArrA06 != null) {
                sb.append(A07(7, 5, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE));
                sb.append(new String(abstractC1682Jd.A06(), Charset.forName(A07(130, 5, 83))));
                sb.append(strA07);
            }
        }
        for (Map.Entry<String, String> entry : abstractC1682Jd.A02().A06().entrySet()) {
            sb.append(A07(2, 5, 87));
            sb.append(entry.getKey());
            sb.append(A07(66, 1, 47));
            sb.append(entry.getValue());
            sb.append(strA07);
        }
        sb.append(A07(0, 2, 10));
        sb.append(abstractC1682Jd.A05());
        sb.append(strA07);
        String string = sb.toString();
        A0E(string, 1, (string.length() / 4000) + 1);
    }

    private void A0D(AbstractC1682Jd abstractC1682Jd, JS js) {
        this.A04.A6o(this, js, this.A01).A04(abstractC1682Jd);
        if (this.A03.A04()) {
            A0C(abstractC1682Jd);
        }
    }

    private void A0E(String str, int i, int i2) {
        String str2 = A09 + A07(12, 6, 47) + i + A07(65, 1, 96) + i2;
        if (str.length() > 4000) {
            str.substring(0, 4000);
            A0E(str.substring(4000), i + 1, i2);
        }
    }

    private void A0F(String str, String str2, byte[] bArr, JS js, JZ jz) {
        C2132ag req = new C2132ag(str, null, str2, bArr, jz);
        A0D(req, js);
    }

    private void A0G(HttpURLConnection httpURLConnection, AbstractC1682Jd abstractC1682Jd) {
        Map<String, String> mapA06 = abstractC1682Jd.A02().A06();
        JP jpA05 = abstractC1682Jd.A02().A05();
        for (String str : mapA06.keySet()) {
            httpURLConnection.setRequestProperty(str, mapA06.get(str));
        }
        if (jpA05 != null) {
            Map<String, String> mapA6W = jpA05.A6W(this.A03.A03());
            for (String str2 : mapA6W.keySet()) {
                httpURLConnection.setRequestProperty(str2, mapA6W.get(str2));
            }
        }
    }

    private final void A0H(HttpURLConnection httpURLConnection, AbstractC1682Jd abstractC1682Jd) throws IOException {
        JZ jzA02 = abstractC1682Jd.A02();
        httpURLConnection.setConnectTimeout(jzA02.A00());
        httpURLConnection.setReadTimeout(jzA02.A02());
        this.A05.AGE(httpURLConnection, abstractC1682Jd.A03(), abstractC1682Jd.A04());
    }

    private final boolean A0I(Throwable th, long j, AbstractC1682Jd abstractC1682Jd) {
        JZ jzA02 = abstractC1682Jd.A02();
        long jCurrentTimeMillis = (System.currentTimeMillis() - j) + 10;
        if (this.A06.AAO()) {
            String str = A07(67, 15, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE) + jCurrentTimeMillis + A07(42, 7, 69) + jzA02.A00() + A07(49, 7, 10) + jzA02.A02();
        }
        if (this.A02) {
            long jA02 = jzA02.A02();
            if (A08[4].charAt(1) == 'Y') {
                throw new RuntimeException();
            }
            A08[7] = "tgQXMymp9cIZW";
            return jCurrentTimeMillis >= jA02;
        }
        long elapsedTime = jzA02.A00();
        return jCurrentTimeMillis >= elapsedTime;
    }

    public final JW A0K() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.core.JR
    @Deprecated
    public final JQ AG4(String str, Map<String, String> parameters) {
        return A03(str, new C1684Jf(parameters), this.A03.A00());
    }

    @Override // com.facebook.ads.redexgen.core.JR
    @Deprecated
    public final JQ AG5(String str, byte[] bArr) {
        return A04(str, A07(135, 47, 102), bArr, this.A03.A00());
    }

    @Override // com.facebook.ads.redexgen.core.JR
    public final void AG6(String str, byte[] bArr, JS js) {
        A0F(str, A07(135, 47, 102), bArr, js, this.A03.A00());
    }
}
