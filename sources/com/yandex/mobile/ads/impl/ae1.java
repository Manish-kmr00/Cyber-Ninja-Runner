package com.yandex.mobile.ads.impl;

import io.ktor.util.date.GMTDateParser;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Utf8;

/* JADX INFO: loaded from: classes3.dex */
public final class ae1 implements HostnameVerifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ae1 f8398a = new ae1();

    public static List a(X509Certificate certificate) {
        Intrinsics.checkNotNullParameter(certificate, "certificate");
        return CollectionsKt.plus((Collection) a(certificate, 7), (Iterable) a(certificate, 2));
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String host, SSLSession session) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(session, "session");
        if (host.length() != ((int) Utf8.size$default(host, 0, 0, 3, null))) {
            return false;
        }
        try {
            Certificate certificate = session.getPeerCertificates()[0];
            Intrinsics.checkNotNull(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            return a(host, (X509Certificate) certificate);
        } catch (SSLException unused) {
            return false;
        }
    }

    private static List a(X509Certificate x509Certificate, int i) {
        Object obj;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && Intrinsics.areEqual(list.get(0), Integer.valueOf(i)) && (obj = list.get(1)) != null) {
                    arrayList.add((String) obj);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return CollectionsKt.emptyList();
        }
    }

    public static boolean a(String host, X509Certificate certificate) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(certificate, "certificate");
        if (y82.a(host)) {
            String strA = gg0.a(host);
            List listA = a(certificate, 7);
            if ((listA instanceof Collection) && listA.isEmpty()) {
                return false;
            }
            Iterator it = listA.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(strA, gg0.a((String) it.next()))) {
                }
            }
            return false;
        }
        if (host.length() == ((int) Utf8.size$default(host, 0, 0, 3, null))) {
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            host = host.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(host, "toLowerCase(...)");
        }
        List listA2 = a(certificate, 2);
        if ((listA2 instanceof Collection) && listA2.isEmpty()) {
            return false;
        }
        Iterator it2 = listA2.iterator();
        while (it2.hasNext()) {
            if (a(host, (String) it2.next())) {
            }
        }
        return false;
        return true;
    }

    private ae1() {
    }

    private static boolean a(String str, String str2) {
        if (str != null && str.length() != 0 && !StringsKt.startsWith$default(str, ".", false, 2, (Object) null) && !StringsKt.endsWith$default(str, "..", false, 2, (Object) null) && str2 != null && str2.length() != 0 && !StringsKt.startsWith$default(str2, ".", false, 2, (Object) null) && !StringsKt.endsWith$default(str2, "..", false, 2, (Object) null)) {
            if (!StringsKt.endsWith$default(str, ".", false, 2, (Object) null)) {
                str = str + ".";
            }
            String str3 = str;
            if (!StringsKt.endsWith$default(str2, ".", false, 2, (Object) null)) {
                str2 = str2 + ".";
            }
            if (str2.length() == ((int) Utf8.size$default(str2, 0, 0, 3, null))) {
                Locale US = Locale.US;
                Intrinsics.checkNotNullExpressionValue(US, "US");
                str2 = str2.toLowerCase(US);
                Intrinsics.checkNotNullExpressionValue(str2, "toLowerCase(...)");
            }
            if (!StringsKt.contains$default((CharSequence) str2, (CharSequence) "*", false, 2, (Object) null)) {
                return Intrinsics.areEqual(str3, str2);
            }
            if (!StringsKt.startsWith$default(str2, "*.", false, 2, (Object) null) || StringsKt.indexOf$default((CharSequence) str2, GMTDateParser.ANY, 1, false, 4, (Object) null) != -1 || str3.length() < str2.length() || Intrinsics.areEqual("*.", str2)) {
                return false;
            }
            String strSubstring = str2.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            if (!StringsKt.endsWith$default(str3, strSubstring, false, 2, (Object) null)) {
                return false;
            }
            int length = str3.length() - strSubstring.length();
            return length <= 0 || StringsKt.lastIndexOf$default((CharSequence) str3, '.', length + (-1), false, 4, (Object) null) == -1;
        }
        return false;
    }
}
