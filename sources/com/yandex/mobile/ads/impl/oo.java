package com.yandex.mobile.ads.impl;

import java.util.Comparator;
import java.util.LinkedHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class oo {
    public static final b b;
    private static final a c = new a();
    private static final LinkedHashMap d = new LinkedHashMap();
    public static final oo e;
    public static final oo f;
    public static final oo g;
    public static final oo h;
    public static final oo i;
    public static final oo j;
    public static final oo k;
    public static final oo l;
    public static final oo m;
    public static final oo n;
    public static final oo o;
    public static final oo p;
    public static final oo q;
    public static final oo r;
    public static final oo s;
    public static final oo t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9838a;

    public static final class b {
        @JvmStatic
        public final synchronized oo a(String javaName) {
            oo ooVar;
            Intrinsics.checkNotNullParameter(javaName, "javaName");
            ooVar = (oo) ((LinkedHashMap) oo.d).get(javaName);
            if (ooVar == null) {
                ooVar = (oo) ((LinkedHashMap) oo.d).get(b(javaName));
                if (ooVar == null) {
                    ooVar = new oo(javaName, 0);
                }
                oo.d.put(javaName, ooVar);
            }
            return ooVar;
        }

        private static String b(String str) {
            if (StringsKt.startsWith$default(str, "TLS_", false, 2, (Object) null)) {
                String strSubstring = str.substring(4);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                return "SSL_" + strSubstring;
            }
            if (!StringsKt.startsWith$default(str, "SSL_", false, 2, (Object) null)) {
                return str;
            }
            String strSubstring2 = str.substring(4);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            return "TLS_" + strSubstring2;
        }

        private b() {
        }

        public /* synthetic */ b(int i) {
            this();
        }
    }

    static {
        int i2 = 0;
        b = new b(i2);
        oo ooVarA = no.a("SSL_RSA_WITH_DES_CBC_SHA", no.a("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", no.a("SSL_RSA_WITH_RC4_128_SHA", no.a("SSL_RSA_WITH_RC4_128_MD5", no.a("SSL_RSA_EXPORT_WITH_RC4_40_MD5", no.a("SSL_RSA_WITH_NULL_SHA", no.a("SSL_RSA_WITH_NULL_MD5", new oo("SSL_RSA_WITH_NULL_MD5", i2), "SSL_RSA_WITH_NULL_SHA", 0), "SSL_RSA_EXPORT_WITH_RC4_40_MD5", 0), "SSL_RSA_WITH_RC4_128_MD5", 0), "SSL_RSA_WITH_RC4_128_SHA", 0), "SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 0), "SSL_RSA_WITH_DES_CBC_SHA", 0), "SSL_RSA_WITH_3DES_EDE_CBC_SHA", 0);
        d.put("SSL_RSA_WITH_3DES_EDE_CBC_SHA", ooVarA);
        e = ooVarA;
        d.put("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", no.a("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", no.a("SSL_DHE_RSA_WITH_DES_CBC_SHA", no.a("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", no.a("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", no.a("SSL_DHE_DSS_WITH_DES_CBC_SHA", no.a("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", new oo("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", i2), "SSL_DHE_DSS_WITH_DES_CBC_SHA", 0), "SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 0), "SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 0), "SSL_DHE_RSA_WITH_DES_CBC_SHA", 0), "SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 0), "SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 0));
        oo ooVarA2 = no.a("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", no.a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", no.a("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", no.a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", no.a("TLS_KRB5_WITH_RC4_128_MD5", no.a("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", no.a("TLS_KRB5_WITH_DES_CBC_MD5", no.a("TLS_KRB5_WITH_RC4_128_SHA", no.a("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", no.a("TLS_KRB5_WITH_DES_CBC_SHA", no.a("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", no.a("SSL_DH_anon_WITH_DES_CBC_SHA", no.a("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", no.a("SSL_DH_anon_WITH_RC4_128_MD5", new oo("SSL_DH_anon_WITH_RC4_128_MD5", i2), "SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 0), "SSL_DH_anon_WITH_DES_CBC_SHA", 0), "SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 0), "TLS_KRB5_WITH_DES_CBC_SHA", 0), "TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 0), "TLS_KRB5_WITH_RC4_128_SHA", 0), "TLS_KRB5_WITH_DES_CBC_MD5", 0), "TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 0), "TLS_KRB5_WITH_RC4_128_MD5", 0), "TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 0), "TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 0), "TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 0), "TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 0), "TLS_RSA_WITH_AES_128_CBC_SHA", 0);
        d.put("TLS_RSA_WITH_AES_128_CBC_SHA", ooVarA2);
        f = ooVarA2;
        d.put("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", no.a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", new oo("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", i2), "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 0));
        oo ooVarA3 = no.a("TLS_DH_anon_WITH_AES_128_CBC_SHA", new oo("TLS_DH_anon_WITH_AES_128_CBC_SHA", i2), "TLS_RSA_WITH_AES_256_CBC_SHA", 0);
        d.put("TLS_RSA_WITH_AES_256_CBC_SHA", ooVarA3);
        g = ooVarA3;
        d.put("TLS_DH_anon_WITH_AES_256_CBC_SHA256", no.a("TLS_DH_anon_WITH_AES_128_CBC_SHA256", no.a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", no.a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", no.a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", no.a("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", no.a("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", no.a("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", no.a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", no.a("TLS_RSA_WITH_AES_256_CBC_SHA256", no.a("TLS_RSA_WITH_AES_128_CBC_SHA256", no.a("TLS_RSA_WITH_NULL_SHA256", no.a("TLS_DH_anon_WITH_AES_256_CBC_SHA", no.a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", no.a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", new oo("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", i2), "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 0), "TLS_DH_anon_WITH_AES_256_CBC_SHA", 0), "TLS_RSA_WITH_NULL_SHA256", 0), "TLS_RSA_WITH_AES_128_CBC_SHA256", 0), "TLS_RSA_WITH_AES_256_CBC_SHA256", 0), "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 0), "TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 0), "TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 0), "TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 0), "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 0), "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 0), "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 0), "TLS_DH_anon_WITH_AES_128_CBC_SHA256", 0), "TLS_DH_anon_WITH_AES_256_CBC_SHA256", 0));
        oo ooVarA4 = no.a("TLS_RSA_WITH_SEED_CBC_SHA", no.a("TLS_PSK_WITH_AES_256_CBC_SHA", no.a("TLS_PSK_WITH_AES_128_CBC_SHA", no.a("TLS_PSK_WITH_3DES_EDE_CBC_SHA", no.a("TLS_PSK_WITH_RC4_128_SHA", no.a("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", no.a("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", no.a("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", new oo("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", i2), "TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 0), "TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 0), "TLS_PSK_WITH_RC4_128_SHA", 0), "TLS_PSK_WITH_3DES_EDE_CBC_SHA", 0), "TLS_PSK_WITH_AES_128_CBC_SHA", 0), "TLS_PSK_WITH_AES_256_CBC_SHA", 0), "TLS_RSA_WITH_SEED_CBC_SHA", 0), "TLS_RSA_WITH_AES_128_GCM_SHA256", 0);
        d.put("TLS_RSA_WITH_AES_128_GCM_SHA256", ooVarA4);
        h = ooVarA4;
        oo ooVar = new oo("TLS_RSA_WITH_AES_256_GCM_SHA384", i2);
        d.put("TLS_RSA_WITH_AES_256_GCM_SHA384", ooVar);
        i = ooVar;
        d.put("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", no.a("TLS_DH_anon_WITH_AES_256_GCM_SHA384", no.a("TLS_DH_anon_WITH_AES_128_GCM_SHA256", no.a("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", no.a("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", no.a("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", no.a("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", new oo("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", i2), "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 0), "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 0), "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 0), "TLS_DH_anon_WITH_AES_128_GCM_SHA256", 0), "TLS_DH_anon_WITH_AES_256_GCM_SHA384", 0), "TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 0));
        d.put("TLS_ECDHE_RSA_WITH_NULL_SHA", no.a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", no.a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", no.a("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", no.a("TLS_ECDH_RSA_WITH_RC4_128_SHA", no.a("TLS_ECDH_RSA_WITH_NULL_SHA", no.a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", no.a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", no.a("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", no.a("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", no.a("TLS_ECDHE_ECDSA_WITH_NULL_SHA", no.a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", no.a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", no.a("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", no.a("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", no.a("TLS_ECDH_ECDSA_WITH_NULL_SHA", no.a("TLS_FALLBACK_SCSV", new oo("TLS_FALLBACK_SCSV", i2), "TLS_ECDH_ECDSA_WITH_NULL_SHA", 0), "TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 0), "TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 0), "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 0), "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 0), "TLS_ECDHE_ECDSA_WITH_NULL_SHA", 0), "TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 0), "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 0), "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 0), "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 0), "TLS_ECDH_RSA_WITH_NULL_SHA", 0), "TLS_ECDH_RSA_WITH_RC4_128_SHA", 0), "TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 0), "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 0), "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 0), "TLS_ECDHE_RSA_WITH_NULL_SHA", 0));
        oo ooVarA5 = no.a("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", no.a("TLS_ECDHE_RSA_WITH_RC4_128_SHA", new oo("TLS_ECDHE_RSA_WITH_RC4_128_SHA", i2), "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 0), "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 0);
        d.put("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", ooVarA5);
        j = ooVarA5;
        oo ooVar2 = new oo("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", i2);
        d.put("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", ooVar2);
        k = ooVar2;
        d.put("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", no.a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", no.a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", no.a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", no.a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", no.a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", no.a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", no.a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", no.a("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", no.a("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", no.a("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", no.a("TLS_ECDH_anon_WITH_RC4_128_SHA", no.a("TLS_ECDH_anon_WITH_NULL_SHA", new oo("TLS_ECDH_anon_WITH_NULL_SHA", i2), "TLS_ECDH_anon_WITH_RC4_128_SHA", 0), "TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 0), "TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 0), "TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 0), "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 0), "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 0), "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 0), "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 0), "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 0), "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 0), "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 0), "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 0));
        oo ooVar3 = new oo("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", i2);
        d.put("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", ooVar3);
        l = ooVar3;
        oo ooVar4 = new oo("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", i2);
        d.put("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", ooVar4);
        m = ooVar4;
        oo ooVarA6 = no.a("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", no.a("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", new oo("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", i2), "TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 0), "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 0);
        d.put("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", ooVarA6);
        n = ooVarA6;
        oo ooVar5 = new oo("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", i2);
        d.put("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", ooVar5);
        o = ooVar5;
        oo ooVarA7 = no.a("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", no.a("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", no.a("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", no.a("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", new oo("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", i2), "TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 0), "TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 0), "TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 0), "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 0);
        d.put("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", ooVarA7);
        p = ooVarA7;
        oo ooVar6 = new oo("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", i2);
        d.put("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", ooVar6);
        q = ooVar6;
        oo ooVarA8 = no.a("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", no.a("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", new oo("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", i2), "TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 0), "TLS_AES_128_GCM_SHA256", 0);
        d.put("TLS_AES_128_GCM_SHA256", ooVarA8);
        r = ooVarA8;
        oo ooVar7 = new oo("TLS_AES_256_GCM_SHA384", i2);
        d.put("TLS_AES_256_GCM_SHA384", ooVar7);
        s = ooVar7;
        oo ooVar8 = new oo("TLS_CHACHA20_POLY1305_SHA256", i2);
        d.put("TLS_CHACHA20_POLY1305_SHA256", ooVar8);
        t = ooVar8;
        d.put("TLS_AES_128_CCM_8_SHA256", no.a("TLS_AES_128_CCM_SHA256", new oo("TLS_AES_128_CCM_SHA256", i2), "TLS_AES_128_CCM_8_SHA256", 0));
    }

    private oo(String str) {
        this.f9838a = str;
    }

    public final String c() {
        return this.f9838a;
    }

    public /* synthetic */ oo(String str, int i2) {
        this(str);
    }

    public final String toString() {
        return this.f9838a;
    }

    public static final class a implements Comparator<String> {
        a() {
        }

        /* JADX WARN: Code duplicated, block: B:13:0x003d A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:14:0x003f A[RETURN, SYNTHETIC] */
        @Override // java.util.Comparator
        public final int compare(String str, String str2) {
            String a2 = str;
            String b = str2;
            Intrinsics.checkNotNullParameter(a2, "a");
            Intrinsics.checkNotNullParameter(b, "b");
            int iMin = Math.min(a2.length(), b.length());
            for (int i = 4; i < iMin; i++) {
                char cCharAt = a2.charAt(i);
                char cCharAt2 = b.charAt(i);
                if (cCharAt != cCharAt2) {
                    if (Intrinsics.compare((int) cCharAt, (int) cCharAt2) < 0) {
                        return -1;
                    }
                    return 1;
                }
            }
            int length = a2.length();
            int length2 = b.length();
            if (length == length2) {
                return 0;
            }
            if (length < length2) {
                return -1;
            }
            return 1;
        }
    }
}
