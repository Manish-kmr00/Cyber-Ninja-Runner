package com.yandex.mobile.ads.impl;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class eo {
    public static final eo c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<c> f8816a;
    private final Cdo b;

    public static final class b {
        @JvmStatic
        public static String a(X509Certificate certificate) {
            Intrinsics.checkNotNullParameter(certificate, "certificate");
            if (!(certificate instanceof X509Certificate)) {
                throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
            }
            return "sha256/" + c(certificate).base64();
        }

        @JvmStatic
        public static ByteString b(X509Certificate x509Certificate) {
            Intrinsics.checkNotNullParameter(x509Certificate, "<this>");
            ByteString.Companion companion = ByteString.INSTANCE;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            Intrinsics.checkNotNullExpressionValue(encoded, "getEncoded(...)");
            return ByteString.Companion.of$default(companion, encoded, 0, 0, 3, null).sha1();
        }

        @JvmStatic
        public static ByteString c(X509Certificate x509Certificate) {
            Intrinsics.checkNotNullParameter(x509Certificate, "<this>");
            ByteString.Companion companion = ByteString.INSTANCE;
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            Intrinsics.checkNotNullExpressionValue(encoded, "getEncoded(...)");
            return ByteString.Companion.of$default(companion, encoded, 0, 0, 3, null).sha256();
        }
    }

    static final class d extends Lambda implements Function0<List<? extends X509Certificate>> {
        final /* synthetic */ List<Certificate> c;
        final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(List<? extends Certificate> list, String str) {
            super(0);
            this.c = list;
            this.d = str;
        }

        /* JADX WARN: Code duplicated, block: B:6:0x0012  */
        @Override // kotlin.jvm.functions.Function0
        public final List<? extends X509Certificate> invoke() throws SSLPeerUnverifiedException {
            List<Certificate> listA;
            Cdo cdoA = eo.this.a();
            if (cdoA != null) {
                listA = cdoA.a(this.d, this.c);
                if (listA == null) {
                    listA = this.c;
                }
            } else {
                listA = this.c;
            }
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listA, 10));
            for (Certificate certificate : listA) {
                Intrinsics.checkNotNull(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                arrayList.add((X509Certificate) certificate);
            }
            return arrayList;
        }
    }

    public eo(Set<c> pins, Cdo cdo) {
        Intrinsics.checkNotNullParameter(pins, "pins");
        this.f8816a = pins;
        this.b = cdo;
    }

    public final void a(String hostname, List<? extends Certificate> peerCertificates) throws SSLPeerUnverifiedException {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        Intrinsics.checkNotNullParameter(peerCertificates, "peerCertificates");
        a(hostname, new d(peerCertificates, hostname));
    }

    public final void a(String hostname, Function0<? extends List<? extends X509Certificate>> cleanedPeerCertificatesFn) throws SSLPeerUnverifiedException {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        Intrinsics.checkNotNullParameter(cleanedPeerCertificatesFn, "cleanedPeerCertificatesFn");
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        Set<c> set = this.f8816a;
        List<c> listEmptyList = CollectionsKt.emptyList();
        for (Object obj : set) {
            ((c) obj).getClass();
            Intrinsics.checkNotNullParameter(hostname, "hostname");
            if (!StringsKt.startsWith$default((String) null, "**.", false, 2, (Object) null)) {
                if (!StringsKt.startsWith$default((String) null, "*.", false, 2, (Object) null)) {
                    if (Intrinsics.areEqual(hostname, (Object) null)) {
                        if (listEmptyList.isEmpty()) {
                            listEmptyList = new ArrayList();
                        }
                        Intrinsics.checkNotNull(listEmptyList, "null cannot be cast to non-null type kotlin.collections.MutableList<T of com.monetization.ads.embedded.okhttp.src.main.kotlin.okhttp3.internal.Util.filterList>");
                        TypeIntrinsics.asMutableList(listEmptyList).add(obj);
                    }
                } else {
                    throw null;
                }
            } else {
                throw null;
            }
        }
        if (listEmptyList.isEmpty()) {
            return;
        }
        List<? extends X509Certificate> listInvoke = cleanedPeerCertificatesFn.invoke();
        for (X509Certificate x509Certificate : listInvoke) {
            Iterator it = listEmptyList.iterator();
            ByteString byteStringC = null;
            ByteString byteStringB = null;
            while (it.hasNext()) {
                ((c) it.next()).getClass();
                if (Intrinsics.areEqual((Object) null, "sha256")) {
                    if (byteStringC == null) {
                        byteStringC = b.c(x509Certificate);
                    }
                    if (Intrinsics.areEqual((Object) null, byteStringC)) {
                        return;
                    }
                } else if (Intrinsics.areEqual((Object) null, "sha1")) {
                    if (byteStringB == null) {
                        byteStringB = b.b(x509Certificate);
                    }
                    if (Intrinsics.areEqual((Object) null, byteStringB)) {
                        return;
                    }
                } else {
                    throw new AssertionError("unsupported hashAlgorithm: null");
                }
            }
        }
        StringBuilder sb = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
        for (X509Certificate x509Certificate2 : listInvoke) {
            sb.append("\n    ");
            sb.append(b.a(x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(hostname);
        sb.append(":");
        for (c cVar : listEmptyList) {
            sb.append("\n    ");
            sb.append(cVar);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        throw new SSLPeerUnverifiedException(string);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof eo) {
            eo eoVar = (eo) obj;
            if (Intrinsics.areEqual(eoVar.f8816a, this.f8816a) && Intrinsics.areEqual(eoVar.b, this.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f8816a.hashCode() + 1517) * 41;
        Cdo cdo = this.b;
        return iHashCode + (cdo != null ? cdo.hashCode() : 0);
    }

    public static final class c {
        public final String toString() {
            throw null;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            cVar.getClass();
            if (!Intrinsics.areEqual((Object) null, (Object) null)) {
                return false;
            }
            cVar.getClass();
            if (!Intrinsics.areEqual((Object) null, (Object) null)) {
                return false;
            }
            cVar.getClass();
            return Intrinsics.areEqual((Object) null, (Object) null);
        }

        public final int hashCode() {
            throw null;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ArrayList f8817a = new ArrayList();

        public final eo a() {
            return new eo(CollectionsKt.toSet(this.f8817a), null);
        }
    }

    public final Cdo a() {
        return this.b;
    }

    public final eo a(Cdo certificateChainCleaner) {
        Intrinsics.checkNotNullParameter(certificateChainCleaner, "certificateChainCleaner");
        return Intrinsics.areEqual(this.b, certificateChainCleaner) ? this : new eo(this.f8816a, certificateChainCleaner);
    }
}
