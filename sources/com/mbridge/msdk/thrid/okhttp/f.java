package com.mbridge.msdk.thrid.okhttp;

import com.json.mediationsdk.utils.IronSourceConstants;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: CipherSuite.java */
/* JADX INFO: loaded from: classes7.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f5505a;
    static final Comparator<String> b = new a();
    private static final Map<String, f> c = new LinkedHashMap();
    public static final f d = a("SSL_RSA_WITH_NULL_MD5", 1);
    public static final f e = a("SSL_RSA_WITH_NULL_SHA", 2);
    public static final f f = a("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
    public static final f g = a("SSL_RSA_WITH_RC4_128_MD5", 4);
    public static final f h = a("SSL_RSA_WITH_RC4_128_SHA", 5);
    public static final f i = a("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
    public static final f j = a("SSL_RSA_WITH_DES_CBC_SHA", 9);
    public static final f k = a("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
    public static final f l = a("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
    public static final f m = a("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
    public static final f n = a("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
    public static final f o = a("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
    public static final f p = a("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
    public static final f q = a("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
    public static final f r = a("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
    public static final f s = a("SSL_DH_anon_WITH_RC4_128_MD5", 24);
    public static final f t = a("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
    public static final f u = a("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
    public static final f v = a("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
    public static final f w = a("TLS_KRB5_WITH_DES_CBC_SHA", 30);
    public static final f x = a("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
    public static final f y = a("TLS_KRB5_WITH_RC4_128_SHA", 32);
    public static final f z = a("TLS_KRB5_WITH_DES_CBC_MD5", 34);
    public static final f A = a("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
    public static final f B = a("TLS_KRB5_WITH_RC4_128_MD5", 36);
    public static final f C = a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
    public static final f D = a("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
    public static final f E = a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
    public static final f F = a("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
    public static final f G = a("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
    public static final f H = a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
    public static final f I = a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
    public static final f J = a("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
    public static final f K = a("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
    public static final f L = a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
    public static final f M = a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
    public static final f N = a("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
    public static final f O = a("TLS_RSA_WITH_NULL_SHA256", 59);
    public static final f P = a("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
    public static final f Q = a("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
    public static final f R = a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
    public static final f S = a("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
    public static final f T = a("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
    public static final f U = a("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
    public static final f V = a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
    public static final f W = a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
    public static final f X = a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
    public static final f Y = a("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
    public static final f Z = a("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
    public static final f a0 = a("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", Sdk.SDKError.Reason.OMSDK_DOWNLOAD_JS_ERROR_VALUE);
    public static final f b0 = a("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
    public static final f c0 = a("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
    public static final f d0 = a("TLS_PSK_WITH_RC4_128_SHA", 138);
    public static final f e0 = a("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
    public static final f f0 = a("TLS_PSK_WITH_AES_128_CBC_SHA", IronSourceConstants.USING_CACHE_FOR_INIT_EVENT);
    public static final f g0 = a("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
    public static final f h0 = a("TLS_RSA_WITH_SEED_CBC_SHA", 150);
    public static final f i0 = a("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
    public static final f j0 = a("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
    public static final f k0 = a("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
    public static final f l0 = a("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
    public static final f m0 = a("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
    public static final f n0 = a("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
    public static final f o0 = a("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
    public static final f p0 = a("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
    public static final f q0 = a("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
    public static final f r0 = a("TLS_FALLBACK_SCSV", 22016);
    public static final f s0 = a("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
    public static final f t0 = a("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
    public static final f u0 = a("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
    public static final f v0 = a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
    public static final f w0 = a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
    public static final f x0 = a("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
    public static final f y0 = a("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
    public static final f z0 = a("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
    public static final f A0 = a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
    public static final f B0 = a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
    public static final f C0 = a("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
    public static final f D0 = a("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
    public static final f E0 = a("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
    public static final f F0 = a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
    public static final f G0 = a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
    public static final f H0 = a("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
    public static final f I0 = a("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
    public static final f J0 = a("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
    public static final f K0 = a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
    public static final f L0 = a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
    public static final f M0 = a("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
    public static final f N0 = a("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
    public static final f O0 = a("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
    public static final f P0 = a("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
    public static final f Q0 = a("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
    public static final f R0 = a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
    public static final f S0 = a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
    public static final f T0 = a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
    public static final f U0 = a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
    public static final f V0 = a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
    public static final f W0 = a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
    public static final f X0 = a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
    public static final f Y0 = a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
    public static final f Z0 = a("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
    public static final f a1 = a("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
    public static final f b1 = a("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
    public static final f c1 = a("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
    public static final f d1 = a("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
    public static final f e1 = a("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
    public static final f f1 = a("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
    public static final f g1 = a("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
    public static final f h1 = a("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
    public static final f i1 = a("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
    public static final f j1 = a("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
    public static final f k1 = a("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
    public static final f l1 = a("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);
    public static final f m1 = a("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
    public static final f n1 = a("TLS_AES_128_GCM_SHA256", 4865);
    public static final f o1 = a("TLS_AES_256_GCM_SHA384", 4866);
    public static final f p1 = a("TLS_CHACHA20_POLY1305_SHA256", 4867);
    public static final f q1 = a("TLS_AES_128_CCM_SHA256", 4868);
    public static final f r1 = a("TLS_AES_256_CCM_8_SHA256", 4869);

    /* JADX INFO: compiled from: CipherSuite.java */
    static class a implements Comparator<String> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            int iMin = Math.min(str.length(), str2.length());
            for (int i = 4; i < iMin; i++) {
                char cCharAt = str.charAt(i);
                char cCharAt2 = str2.charAt(i);
                if (cCharAt != cCharAt2) {
                    return cCharAt < cCharAt2 ? -1 : 1;
                }
            }
            int length = str.length();
            int length2 = str2.length();
            if (length != length2) {
                return length < length2 ? -1 : 1;
            }
            return 0;
        }
    }

    private f(String str) {
        str.getClass();
        this.f5505a = str;
    }

    public static synchronized f a(String str) {
        f fVar;
        Map<String, f> map = c;
        fVar = map.get(str);
        if (fVar == null) {
            fVar = map.get(b(str));
            if (fVar == null) {
                fVar = new f(str);
            }
            map.put(str, fVar);
        }
        return fVar;
    }

    private static String b(String str) {
        if (str.startsWith("TLS_")) {
            return "SSL_" + str.substring(4);
        }
        return str.startsWith("SSL_") ? "TLS_" + str.substring(4) : str;
    }

    public String toString() {
        return this.f5505a;
    }

    static List<f> a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(a(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static f a(String str, int i2) {
        f fVar = new f(str);
        c.put(str, fVar);
        return fVar;
    }
}
