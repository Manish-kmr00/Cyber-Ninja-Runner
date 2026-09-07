package com.yandex.mobile.ads.impl;

import com.json.mediationsdk.logger.IronSourceError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.Deprecated;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class or {
    public static final or e;
    public static final or f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f9851a;
    private final boolean b;
    private final String[] c;
    private final String[] d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f9852a;
        private String[] b;
        private String[] c;
        private boolean d;

        public a(or connectionSpec) {
            Intrinsics.checkNotNullParameter(connectionSpec, "connectionSpec");
            this.f9852a = connectionSpec.a();
            this.b = connectionSpec.c;
            this.c = connectionSpec.d;
            this.d = connectionSpec.b();
        }

        public final a a(oo... cipherSuites) {
            Intrinsics.checkNotNullParameter(cipherSuites, "cipherSuites");
            if (!this.f9852a) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
            }
            ArrayList arrayList = new ArrayList(cipherSuites.length);
            for (oo ooVar : cipherSuites) {
                arrayList.add(ooVar.c());
            }
            String[] strArr = (String[]) arrayList.toArray(new String[0]);
            return a((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        @Deprecated(message = "since OkHttp 3.13 all TLS-connections are expected to support TLS extensions.\nIn a future release setting this to true will be unnecessary and setting it to false\nwill have no effect.")
        public final a b() {
            if (!this.f9852a) {
                throw new IllegalArgumentException("no TLS extensions for cleartext connections".toString());
            }
            this.d = true;
            return this;
        }

        public final a b(String... tlsVersions) {
            Intrinsics.checkNotNullParameter(tlsVersions, "tlsVersions");
            if (this.f9852a) {
                if (!(tlsVersions.length == 0)) {
                    this.c = (String[]) tlsVersions.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one TLS version is required".toString());
            }
            throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
        }

        public a(boolean z) {
            this.f9852a = z;
        }

        public final a a(String... cipherSuites) {
            Intrinsics.checkNotNullParameter(cipherSuites, "cipherSuites");
            if (this.f9852a) {
                if (!(cipherSuites.length == 0)) {
                    this.b = (String[]) cipherSuites.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one cipher suite is required".toString());
            }
            throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
        }

        public final a a(j52... tlsVersions) {
            Intrinsics.checkNotNullParameter(tlsVersions, "tlsVersions");
            if (this.f9852a) {
                ArrayList arrayList = new ArrayList(tlsVersions.length);
                for (j52 j52Var : tlsVersions) {
                    arrayList.add(j52Var.a());
                }
                String[] strArr = (String[]) arrayList.toArray(new String[0]);
                return b((String[]) Arrays.copyOf(strArr, strArr.length));
            }
            throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
        }

        public final or a() {
            return new or(this.f9852a, this.d, this.b, this.c);
        }
    }

    static {
        oo ooVar = oo.r;
        oo ooVar2 = oo.s;
        oo ooVar3 = oo.t;
        oo ooVar4 = oo.l;
        oo ooVar5 = oo.n;
        oo ooVar6 = oo.m;
        oo ooVar7 = oo.o;
        oo ooVar8 = oo.q;
        oo ooVar9 = oo.p;
        oo[] ooVarArr = {ooVar, ooVar2, ooVar3, ooVar4, ooVar5, ooVar6, ooVar7, ooVar8, ooVar9, oo.j, oo.k, oo.h, oo.i, oo.f, oo.g, oo.e};
        a aVarA = new a(true).a((oo[]) Arrays.copyOf(new oo[]{ooVar, ooVar2, ooVar3, ooVar4, ooVar5, ooVar6, ooVar7, ooVar8, ooVar9}, 9));
        j52 j52Var = j52.d;
        j52 j52Var2 = j52.e;
        aVarA.a(j52Var, j52Var2).b().a();
        e = new a(true).a((oo[]) Arrays.copyOf(ooVarArr, 16)).a(j52Var, j52Var2).b().a();
        new a(true).a((oo[]) Arrays.copyOf(ooVarArr, 16)).a(j52Var, j52Var2, j52.f, j52.g).b().a();
        f = new a(false).a();
    }

    public or(boolean z, boolean z2, String[] strArr, String[] strArr2) {
        this.f9851a = z;
        this.b = z2;
        this.c = strArr;
        this.d = strArr2;
    }

    public final void a(SSLSocket sslSocket, boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        List list;
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        if (this.c != null) {
            String[] enabledCipherSuites2 = sslSocket.getEnabledCipherSuites();
            Intrinsics.checkNotNullExpressionValue(enabledCipherSuites2, "getEnabledCipherSuites(...)");
            enabledCipherSuites = y82.b(enabledCipherSuites2, this.c, oo.c);
        } else {
            enabledCipherSuites = sslSocket.getEnabledCipherSuites();
        }
        if (this.d != null) {
            String[] enabledProtocols2 = sslSocket.getEnabledProtocols();
            Intrinsics.checkNotNullExpressionValue(enabledProtocols2, "getEnabledProtocols(...)");
            enabledProtocols = y82.b(enabledProtocols2, this.d, (Comparator<? super String>) ComparisonsKt.naturalOrder());
        } else {
            enabledProtocols = sslSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sslSocket.getSupportedCipherSuites();
        Intrinsics.checkNotNull(supportedCipherSuites);
        oo.a comparator = oo.c;
        byte[] bArr = y82.f10712a;
        Intrinsics.checkNotNullParameter(supportedCipherSuites, "<this>");
        Intrinsics.checkNotNullParameter("TLS_FALLBACK_SCSV", "value");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int length = supportedCipherSuites.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (comparator.compare(supportedCipherSuites[i], "TLS_FALLBACK_SCSV") == 0) {
                break;
            } else {
                i++;
            }
        }
        if (z && i != -1) {
            Intrinsics.checkNotNull(enabledCipherSuites);
            String value = supportedCipherSuites[i];
            Intrinsics.checkNotNullExpressionValue(value, "get(...)");
            Intrinsics.checkNotNullParameter(enabledCipherSuites, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            Object[] objArrCopyOf = Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length + 1);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
            enabledCipherSuites = (String[]) objArrCopyOf;
            enabledCipherSuites[ArraysKt.getLastIndex(enabledCipherSuites)] = value;
        }
        a aVar = new a(this);
        Intrinsics.checkNotNull(enabledCipherSuites);
        a aVarA = aVar.a((String[]) Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length));
        Intrinsics.checkNotNull(enabledProtocols);
        or orVarA = aVarA.b((String[]) Arrays.copyOf(enabledProtocols, enabledProtocols.length)).a();
        String[] strArr = orVarA.d;
        List list2 = null;
        if (strArr != null) {
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                j52.c.getClass();
                arrayList.add(j52.a.a(str));
            }
            list = CollectionsKt.toList(arrayList);
        } else {
            list = null;
        }
        if (list != null) {
            sslSocket.setEnabledProtocols(orVarA.d);
        }
        String[] strArr2 = orVarA.c;
        if (strArr2 != null) {
            ArrayList arrayList2 = new ArrayList(strArr2.length);
            for (String str2 : strArr2) {
                arrayList2.add(oo.b.a(str2));
            }
            list2 = CollectionsKt.toList(arrayList2);
        }
        if (list2 != null) {
            sslSocket.setEnabledCipherSuites(orVarA.c);
        }
    }

    public final boolean b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof or)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        boolean z = this.f9851a;
        or orVar = (or) obj;
        if (z != orVar.f9851a) {
            return false;
        }
        return !z || (Arrays.equals(this.c, orVar.c) && Arrays.equals(this.d, orVar.d) && this.b == orVar.b);
    }

    public final int hashCode() {
        if (!this.f9851a) {
            return 17;
        }
        String[] strArr = this.c;
        int iHashCode = ((strArr != null ? Arrays.hashCode(strArr) : 0) + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31;
        String[] strArr2 = this.d;
        return ((iHashCode + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31) + (!this.b ? 1 : 0);
    }

    public final String toString() {
        List list;
        if (!this.f9851a) {
            return "ConnectionSpec()";
        }
        String[] strArr = this.c;
        List list2 = null;
        if (strArr != null) {
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                arrayList.add(oo.b.a(str));
            }
            list = CollectionsKt.toList(arrayList);
        } else {
            list = null;
        }
        String string = Objects.toString(list, "[all enabled]");
        String[] strArr2 = this.d;
        if (strArr2 != null) {
            ArrayList arrayList2 = new ArrayList(strArr2.length);
            for (String str2 : strArr2) {
                j52.c.getClass();
                arrayList2.add(j52.a.a(str2));
            }
            list2 = CollectionsKt.toList(arrayList2);
        }
        return "ConnectionSpec(cipherSuites=" + string + ", tlsVersions=" + Objects.toString(list2, "[all enabled]") + ", supportsTlsExtensions=" + this.b + ")";
    }

    public final boolean a(SSLSocket socket) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        if (!this.f9851a) {
            return false;
        }
        String[] strArr = this.d;
        if (strArr != null && !y82.a(strArr, socket.getEnabledProtocols(), (Comparator<? super String>) ComparisonsKt.naturalOrder())) {
            return false;
        }
        String[] strArr2 = this.c;
        return strArr2 == null || y82.a(strArr2, socket.getEnabledCipherSuites(), oo.c);
    }

    public final boolean a() {
        return this.f9851a;
    }
}
