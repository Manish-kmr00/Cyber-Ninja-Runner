package com.yandex.mobile.ads.impl;

import com.json.mediationsdk.logger.IronSourceError;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
public final class ff0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j52 f8890a;
    private final oo b;
    private final List<Certificate> c;
    private final Lazy d;

    public static final class a {

        /* JADX INFO: renamed from: com.yandex.mobile.ads.impl.ff0$a$a, reason: collision with other inner class name */
        static final class C0744a extends Lambda implements Function0<List<? extends Certificate>> {
            final /* synthetic */ List<Certificate> b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C0744a(List<? extends Certificate> list) {
                super(0);
                this.b = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends Certificate> invoke() {
                return this.b;
            }
        }

        @JvmStatic
        public static ff0 a(SSLSession sSLSession) throws IOException {
            List listEmptyList;
            Intrinsics.checkNotNullParameter(sSLSession, "<this>");
            String cipherSuite = sSLSession.getCipherSuite();
            if (cipherSuite == null) {
                throw new IllegalStateException("cipherSuite == null".toString());
            }
            if (Intrinsics.areEqual(cipherSuite, "TLS_NULL_WITH_NULL_NULL") || Intrinsics.areEqual(cipherSuite, "SSL_NULL_WITH_NULL_NULL")) {
                throw new IOException("cipherSuite == " + cipherSuite);
            }
            oo ooVarA = oo.b.a(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null".toString());
            }
            if (Intrinsics.areEqual("NONE", protocol)) {
                throw new IOException("tlsVersion == NONE");
            }
            j52.c.getClass();
            j52 j52VarA = j52.a.a(protocol);
            try {
                Certificate[] peerCertificates = sSLSession.getPeerCertificates();
                listEmptyList = peerCertificates != null ? y82.a(Arrays.copyOf(peerCertificates, peerCertificates.length)) : CollectionsKt.emptyList();
            } catch (SSLPeerUnverifiedException unused) {
                listEmptyList = CollectionsKt.emptyList();
            }
            Certificate[] localCertificates = sSLSession.getLocalCertificates();
            return new ff0(j52VarA, ooVarA, localCertificates != null ? y82.a(Arrays.copyOf(localCertificates, localCertificates.length)) : CollectionsKt.emptyList(), new C0744a(listEmptyList));
        }
    }

    static final class b extends Lambda implements Function0<List<? extends Certificate>> {
        final /* synthetic */ Function0<List<Certificate>> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(Function0<? extends List<? extends Certificate>> function0) {
            super(0);
            this.b = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends Certificate> invoke() {
            try {
                return this.b.invoke();
            } catch (SSLPeerUnverifiedException unused) {
                return CollectionsKt.emptyList();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ff0(j52 tlsVersion, oo cipherSuite, List<? extends Certificate> localCertificates, Function0<? extends List<? extends Certificate>> peerCertificatesFn) {
        Intrinsics.checkNotNullParameter(tlsVersion, "tlsVersion");
        Intrinsics.checkNotNullParameter(cipherSuite, "cipherSuite");
        Intrinsics.checkNotNullParameter(localCertificates, "localCertificates");
        Intrinsics.checkNotNullParameter(peerCertificatesFn, "peerCertificatesFn");
        this.f8890a = tlsVersion;
        this.b = cipherSuite;
        this.c = localCertificates;
        this.d = LazyKt.lazy(new b(peerCertificatesFn));
    }

    public final String toString() {
        String type;
        String type2;
        List<Certificate> list = (List) this.d.getValue();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (Certificate certificate : list) {
            if (certificate instanceof X509Certificate) {
                type2 = ((X509Certificate) certificate).getSubjectDN().toString();
            } else {
                type2 = certificate.getType();
                Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
            }
            arrayList.add(type2);
        }
        String string = arrayList.toString();
        j52 j52Var = this.f8890a;
        oo ooVar = this.b;
        List<Certificate> list2 = this.c;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (Certificate certificate2 : list2) {
            if (certificate2 instanceof X509Certificate) {
                type = ((X509Certificate) certificate2).getSubjectDN().toString();
            } else {
                type = certificate2.getType();
                Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
            }
            arrayList2.add(type);
        }
        return "Handshake{tlsVersion=" + j52Var + " cipherSuite=" + ooVar + " peerCertificates=" + string + " localCertificates=" + arrayList2 + "}";
    }

    public final j52 d() {
        return this.f8890a;
    }

    public final oo a() {
        return this.b;
    }

    public final List<Certificate> b() {
        return this.c;
    }

    public final List<Certificate> c() {
        return (List) this.d.getValue();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ff0) {
            ff0 ff0Var = (ff0) obj;
            if (ff0Var.f8890a == this.f8890a && Intrinsics.areEqual(ff0Var.b, this.b) && Intrinsics.areEqual((List) ff0Var.d.getValue(), (List) this.d.getValue()) && Intrinsics.areEqual(ff0Var.c, this.c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.c.hashCode() + aa.a((List) this.d.getValue(), (this.b.hashCode() + ((this.f8890a.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31)) * 31, 31);
    }
}
