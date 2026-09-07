package com.yandex.mobile.ads.impl;

import android.net.Uri;
import android.webkit.URLUtil;
import androidx.core.net.MailTo;
import java.net.URI;
import java.util.regex.Pattern;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class o82 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9793a = new a(0);

    public static final class a {
        @JvmStatic
        public static String a(String url) {
            Object objM7904constructorimpl;
            Intrinsics.checkNotNullParameter(url, "url");
            try {
                Result.Companion companion = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(Uri.parse(d(url)).getHost());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m7910isFailureimpl(objM7904constructorimpl)) {
                objM7904constructorimpl = null;
            }
            return (String) objM7904constructorimpl;
        }

        @JvmStatic
        public static boolean b(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(url, "url");
            if (url.length() != 0) {
                String strReplaceFirst = new Regex("http(s?)://").replaceFirst(url, "");
                for (b bVar : b.values()) {
                    if (StringsKt.startsWith$default(strReplaceFirst, bVar.a(), false, 2, (Object) null)) {
                        return false;
                    }
                }
            }
            return URLUtil.isNetworkUrl(url);
        }

        @JvmStatic
        public static boolean c(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            if (url.length() == 0) {
                return false;
            }
            String strReplaceFirst = new Regex("http(s?)://").replaceFirst(url, "");
            b.c.getClass();
            b[] bVarArr = {b.d, b.e, b.f, b.g};
            for (int i = 0; i < 4; i++) {
                if (StringsKt.startsWith$default(strReplaceFirst, bVarArr[i].a(), false, 2, (Object) null)) {
                    return true;
                }
            }
            return false;
        }

        private static String d(String str) {
            return (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) ? str : "https://" + str;
        }

        private a() {
        }

        public /* synthetic */ a(int i) {
            this();
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v17 com.yandex.mobile.ads.impl.o82$b[], still in use, count: 1, list:
  (r0v17 com.yandex.mobile.ads.impl.o82$b[]) from 0x016c: INVOKE (r0v17 com.yandex.mobile.ads.impl.o82$b[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
    	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class b {
        /* JADX INFO: Fake field, exist only in values array */
        EF1("sms:"),
        /* JADX INFO: Fake field, exist only in values array */
        EF2(MailTo.MAILTO_SCHEME),
        /* JADX INFO: Fake field, exist only in values array */
        EF3("voicemail:"),
        /* JADX INFO: Fake field, exist only in values array */
        EF4("tel:"),
        /* JADX INFO: Fake field, exist only in values array */
        EF5("callto:"),
        /* JADX INFO: Fake field, exist only in values array */
        EF6("fax:"),
        /* JADX INFO: Fake field, exist only in values array */
        EF7("geo:"),
        /* JADX INFO: Fake field, exist only in values array */
        EF8("map:"),
        /* JADX INFO: Fake field, exist only in values array */
        EF9("maps:"),
        d("market:"),
        e("play:"),
        /* JADX INFO: Fake field, exist only in values array */
        EF12("google.streetview:"),
        f("market.android"),
        g("play.google"),
        /* JADX INFO: Fake field, exist only in values array */
        EF189("map"),
        /* JADX INFO: Fake field, exist only in values array */
        EF204("maps"),
        /* JADX INFO: Fake field, exist only in values array */
        EF217("mobile.maps"),
        /* JADX INFO: Fake field, exist only in values array */
        EF230("m.maps"),
        /* JADX INFO: Fake field, exist only in values array */
        EF243("maps.yandex.ru"),
        /* JADX INFO: Fake field, exist only in values array */
        EF256("message:"),
        /* JADX INFO: Fake field, exist only in values array */
        EF269("sip:"),
        /* JADX INFO: Fake field, exist only in values array */
        EF282("skype:"),
        /* JADX INFO: Fake field, exist only in values array */
        EF293("sms:"),
        /* JADX INFO: Fake field, exist only in values array */
        EF306("gtalk:"),
        /* JADX INFO: Fake field, exist only in values array */
        EF319("spotify:"),
        /* JADX INFO: Fake field, exist only in values array */
        EF332("lastfm:"),
        /* JADX INFO: Fake field, exist only in values array */
        EF345("yastore:");

        public static final a c;
        private final String b;

        static {
            EnumEntriesKt.enumEntries(bVarArr);
            c = new a(0);
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) h.clone();
        }

        private b(String str) {
            super(str, i);
            this.b = str;
        }

        public final String a() {
            return this.b;
        }

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(int i) {
                this();
            }
        }
    }

    static {
        Pattern.compile("maps.yandex");
    }

    public static boolean a(String str) {
        Object objM7904constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            new URI(str);
            objM7904constructorimpl = Result.m7904constructorimpl(Boolean.valueOf((str == null || str.length() == 0) ? false : true));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.m7910isFailureimpl(objM7904constructorimpl)) {
            objM7904constructorimpl = bool;
        }
        return ((Boolean) objM7904constructorimpl).booleanValue();
    }
}
