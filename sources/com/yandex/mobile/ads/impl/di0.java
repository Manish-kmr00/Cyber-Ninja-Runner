package com.yandex.mobile.ads.impl;

import androidx.autofill.HintConstants;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.io.EOFException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okio.Buffer;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes4.dex */
public final class di0 {
    private static final char[] j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8696a;
    private final String b;
    private final String c;
    private final String d;
    private final int e;
    private final List<String> f;
    private final String g;
    private final String h;
    private final boolean i;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f8697a;
        private String d;
        private final ArrayList f;
        private ArrayList g;
        private String h;
        private String b = "";
        private String c = "";
        private int e = -1;

        /* JADX INFO: renamed from: com.yandex.mobile.ads.impl.di0$a$a, reason: collision with other inner class name */
        public static final class C0739a {
            public static final int a(String str, int i, int i2) {
                try {
                    int i3 = Integer.parseInt(b.a(str, i, i2, "", false, false, false, false, 248));
                    if (1 > i3 || i3 >= 65536) {
                        return -1;
                    }
                    return i3;
                } catch (NumberFormatException unused) {
                }
            }

            public static final int b(String str, int i, int i2) {
                while (i < i2) {
                    char cCharAt = str.charAt(i);
                    if (cCharAt == '[') {
                        do {
                            i++;
                            if (i >= i2) {
                                break;
                            }
                        } while (str.charAt(i) != ']');
                    } else if (cCharAt == ':') {
                        return i;
                    }
                    i++;
                }
                return i2;
            }

            public static final int c(String str, int i, int i2) {
                if (i2 - i >= 2) {
                    char cCharAt = str.charAt(i);
                    if ((Intrinsics.compare((int) cCharAt, 97) >= 0 && Intrinsics.compare((int) cCharAt, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE) <= 0) || (Intrinsics.compare((int) cCharAt, 65) >= 0 && Intrinsics.compare((int) cCharAt, 90) <= 0)) {
                        while (true) {
                            i++;
                            if (i >= i2) {
                                break;
                            }
                            char cCharAt2 = str.charAt(i);
                            if ('a' > cCharAt2 || cCharAt2 >= '{') {
                                if ('A' > cCharAt2 || cCharAt2 >= '[') {
                                    if ('0' > cCharAt2 || cCharAt2 >= ':') {
                                        if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                            if (cCharAt2 == ':') {
                                                return i;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return -1;
            }

            public static final int d(String str, int i, int i2) {
                int i3 = 0;
                while (i < i2) {
                    char cCharAt = str.charAt(i);
                    if (cCharAt != '\\' && cCharAt != '/') {
                        break;
                    }
                    i3++;
                    i++;
                }
                return i3;
            }

            private C0739a() {
            }

            public /* synthetic */ C0739a(int i) {
                this();
            }
        }

        public final a c() {
            Intrinsics.checkNotNullParameter("", HintConstants.AUTOFILL_HINT_PASSWORD);
            this.c = b.a("", 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, 251);
            return this;
        }

        public final void e(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.c = str;
        }

        public final void f(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.b = str;
        }

        public final ArrayList b() {
            return this.f;
        }

        public final a b(String host) {
            Intrinsics.checkNotNullParameter(host, "host");
            String strA = gg0.a(b.a(host, 0, 0, false, 7));
            if (strA != null) {
                this.d = strA;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + host);
        }

        public final a c(String scheme) {
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            if (StringsKt.equals(scheme, "http", true)) {
                this.f8697a = "http";
            } else if (StringsKt.equals(scheme, "https", true)) {
                this.f8697a = "https";
            } else {
                throw new IllegalArgumentException("unexpected scheme: " + scheme);
            }
            return this;
        }

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f = arrayList;
            arrayList.add("");
        }

        public final void h(String str) {
            this.f8697a = str;
        }

        public final a e() {
            Intrinsics.checkNotNullParameter("", "username");
            this.b = b.a("", 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, 251);
            return this;
        }

        public final void g(String str) {
            this.d = str;
        }

        public final a d() {
            String str = this.d;
            this.d = str != null ? new Regex("[\"<>^`{|}]").replace(str, "") : null;
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                ArrayList arrayList = this.f;
                arrayList.set(i, b.a((String) arrayList.get(i), 0, 0, "[]", true, true, false, false, 227));
            }
            ArrayList arrayList2 = this.g;
            if (arrayList2 != null) {
                int size2 = arrayList2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str2 = (String) arrayList2.get(i2);
                    arrayList2.set(i2, str2 != null ? b.a(str2, 0, 0, "\\^`{|}", true, true, true, false, 195) : null);
                }
            }
            String str3 = this.h;
            this.h = str3 != null ? b.a(str3, 0, 0, " \"#<>\\^`{|}", true, true, false, true, 163) : null;
            return this;
        }

        public final di0 a() {
            ArrayList arrayList;
            String str = this.f8697a;
            if (str != null) {
                String strA = b.a(this.b, 0, 0, false, 7);
                String strA2 = b.a(this.c, 0, 0, false, 7);
                String str2 = this.d;
                if (str2 != null) {
                    int i = this.e;
                    int i2 = -1;
                    if (i != -1) {
                        i2 = i;
                    } else {
                        String scheme = this.f8697a;
                        Intrinsics.checkNotNull(scheme);
                        Intrinsics.checkNotNullParameter(scheme, "scheme");
                        if (Intrinsics.areEqual(scheme, "http")) {
                            i = 80;
                        } else if (Intrinsics.areEqual(scheme, "https")) {
                            i = 443;
                        }
                        i2 = i;
                    }
                    ArrayList arrayList2 = this.f;
                    ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        arrayList3.add(b.a((String) it.next(), 0, 0, false, 7));
                    }
                    ArrayList<String> arrayList4 = this.g;
                    if (arrayList4 != null) {
                        arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
                        for (String str3 : arrayList4) {
                            arrayList.add(str3 != null ? b.a(str3, 0, 0, true, 3) : null);
                        }
                    } else {
                        arrayList = null;
                    }
                    String str4 = this.h;
                    return new di0(str, strA, strA2, str2, i2, arrayList3, arrayList, str4 != null ? b.a(str4, 0, 0, false, 7) : null, toString());
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        /* JADX WARN: Code duplicated, block: B:44:0x00b3  */
        public final String toString() {
            StringBuilder out = new StringBuilder();
            String str = this.f8697a;
            if (str != null) {
                out.append(str);
                out.append("://");
            } else {
                out.append("//");
            }
            if (this.b.length() > 0 || this.c.length() > 0) {
                out.append(this.b);
                if (this.c.length() > 0) {
                    out.append(AbstractJsonLexerKt.COLON);
                    out.append(this.c);
                }
                out.append('@');
            }
            String str2 = this.d;
            if (str2 != null) {
                Intrinsics.checkNotNull(str2);
                if (StringsKt.contains$default((CharSequence) str2, AbstractJsonLexerKt.COLON, false, 2, (Object) null)) {
                    out.append(AbstractJsonLexerKt.BEGIN_LIST);
                    out.append(this.d);
                    out.append(AbstractJsonLexerKt.END_LIST);
                } else {
                    out.append(this.d);
                }
            }
            int i = this.e;
            int i2 = -1;
            if (i != -1 || this.f8697a != null) {
                if (i == -1) {
                    String scheme = this.f8697a;
                    Intrinsics.checkNotNull(scheme);
                    Intrinsics.checkNotNullParameter(scheme, "scheme");
                    if (Intrinsics.areEqual(scheme, "http")) {
                        i = 80;
                    } else {
                        i = Intrinsics.areEqual(scheme, "https") ? 443 : -1;
                    }
                }
                String scheme2 = this.f8697a;
                if (scheme2 != null) {
                    Intrinsics.checkNotNull(scheme2);
                    Intrinsics.checkNotNullParameter(scheme2, "scheme");
                    if (Intrinsics.areEqual(scheme2, "http")) {
                        i2 = 80;
                    } else if (Intrinsics.areEqual(scheme2, "https")) {
                        i2 = 443;
                    }
                    if (i != i2) {
                        out.append(AbstractJsonLexerKt.COLON);
                        out.append(i);
                    }
                } else {
                    out.append(AbstractJsonLexerKt.COLON);
                    out.append(i);
                }
            }
            ArrayList arrayList = this.f;
            Intrinsics.checkNotNullParameter(arrayList, "<this>");
            Intrinsics.checkNotNullParameter(out, "out");
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                out.append('/');
                out.append((String) arrayList.get(i3));
            }
            if (this.g != null) {
                out.append('?');
                ArrayList arrayList2 = this.g;
                Intrinsics.checkNotNull(arrayList2);
                Intrinsics.checkNotNullParameter(arrayList2, "<this>");
                Intrinsics.checkNotNullParameter(out, "out");
                IntProgression intProgressionStep = RangesKt.step(RangesKt.until(0, arrayList2.size()), 2);
                int first = intProgressionStep.getFirst();
                int last = intProgressionStep.getLast();
                int step = intProgressionStep.getStep();
                if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                    while (true) {
                        String str3 = (String) arrayList2.get(first);
                        String str4 = (String) arrayList2.get(first + 1);
                        if (first > 0) {
                            out.append(Typography.amp);
                        }
                        out.append(str3);
                        if (str4 != null) {
                            out.append(com.json.cc.T);
                            out.append(str4);
                        }
                        if (first == last) {
                            break;
                        }
                        first += step;
                    }
                }
            }
            if (this.h != null) {
                out.append('#');
                out.append(this.h);
            }
            String string = out.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }

        public final void b(int i) {
            this.e = i;
        }

        public final void d(String str) {
            this.h = str;
        }

        public final void a(String str) {
            String strA;
            this.g = (str == null || (strA = b.a(str, 0, 0, " \"'<>#", true, false, true, false, 211)) == null) ? null : b.b(strA);
        }

        public final a a(di0 di0Var, String input) throws EOFException {
            int iA;
            int i;
            char c;
            Intrinsics.checkNotNullParameter(input, "input");
            int iA2 = y82.a(0, input.length(), input);
            int iB = y82.b(iA2, input.length(), input);
            int iC = C0739a.c(input, iA2, iB);
            boolean z = false;
            byte b = -1;
            if (iC != -1) {
                if (StringsKt.startsWith(input, "https:", iA2, true)) {
                    this.f8697a = "https";
                    iA2 += 6;
                } else if (StringsKt.startsWith(input, "http:", iA2, true)) {
                    this.f8697a = "http";
                    iA2 += 5;
                } else {
                    String strSubstring = input.substring(0, iC);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + strSubstring + "'");
                }
            } else if (di0Var != null) {
                this.f8697a = di0Var.k();
            } else {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            int iD = C0739a.d(input, iA2, iB);
            byte b2 = 63;
            byte b3 = 92;
            byte b4 = 47;
            byte b5 = 35;
            if (iD < 2 && di0Var != null && Intrinsics.areEqual(di0Var.k(), this.f8697a)) {
                this.b = di0Var.f();
                this.c = di0Var.b();
                this.d = di0Var.g();
                this.e = di0Var.i();
                this.f.clear();
                this.f.addAll(di0Var.d());
                if (iA2 == iB || input.charAt(iA2) == '#') {
                    a(di0Var.e());
                }
            } else {
                int i2 = iA2 + iD;
                boolean z2 = false;
                boolean z3 = false;
                while (true) {
                    iA = y82.a(i2, iB, input, "@/\\?#");
                    byte bCharAt = iA != iB ? input.charAt(iA) : b;
                    if (bCharAt == b || bCharAt == b5 || bCharAt == b4 || bCharAt == b3 || bCharAt == b2) {
                        break;
                    }
                    if (bCharAt == 64) {
                        if (!z2) {
                            int iA3 = y82.a(input, AbstractJsonLexerKt.COLON, i2, iA);
                            i = iA;
                            String strA = b.a(input, i2, iA3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 240);
                            if (z3) {
                                strA = this.b + "%40" + strA;
                            }
                            this.b = strA;
                            if (iA3 != i) {
                                this.c = b.a(input, iA3 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 240);
                                z2 = true;
                            }
                            z3 = true;
                        } else {
                            i = iA;
                            this.c += "%40" + b.a(input, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 240);
                        }
                        i2 = i + 1;
                        b5 = 35;
                        b4 = 47;
                        b3 = 92;
                        b2 = 63;
                        b = -1;
                    }
                }
                int iB2 = C0739a.b(input, i2, iA);
                int i3 = iB2 + 1;
                if (i3 < iA) {
                    this.d = gg0.a(b.a(input, i2, iB2, false, 4));
                    int iA4 = C0739a.a(input, i3, iA);
                    this.e = iA4;
                    if (iA4 == -1) {
                        String strSubstring2 = input.substring(i3, iA);
                        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                        throw new IllegalArgumentException(("Invalid URL port: \"" + strSubstring2 + "\"").toString());
                    }
                    z = false;
                } else {
                    z = false;
                    this.d = gg0.a(b.a(input, i2, iB2, false, 4));
                    String str = this.f8697a;
                    Intrinsics.checkNotNull(str);
                    this.e = b.a(str);
                }
                if (this.d == null) {
                    String strSubstring3 = input.substring(i2, iB2);
                    Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
                    throw new IllegalArgumentException(("Invalid URL host: \"" + strSubstring3 + "\"").toString());
                }
                iA2 = iA;
            }
            int iA5 = y82.a(iA2, iB, input, "?#");
            if (iA2 != iA5) {
                char cCharAt = input.charAt(iA2);
                if (cCharAt != '/' && cCharAt != '\\') {
                    ArrayList arrayList = this.f;
                    arrayList.set(arrayList.size() - 1, "");
                } else {
                    this.f.clear();
                    this.f.add("");
                    iA2++;
                }
                int i4 = iA2;
                while (i4 < iA5) {
                    int iA6 = y82.a(i4, iA5, input, "/\\");
                    boolean z4 = iA6 < iA5 ? true : z;
                    String strA2 = b.a(input, i4, iA6, " \"<>^`{}|/\\?#", true, false, false, false, 240);
                    if (!Intrinsics.areEqual(strA2, ".") && !StringsKt.equals(strA2, "%2e", true)) {
                        if (!Intrinsics.areEqual(strA2, "..") && !StringsKt.equals(strA2, "%2e.", true) && !StringsKt.equals(strA2, ".%2e", true) && !StringsKt.equals(strA2, "%2e%2e", true)) {
                            ArrayList arrayList2 = this.f;
                            if (((CharSequence) arrayList2.get(arrayList2.size() - 1)).length() == 0) {
                                ArrayList arrayList3 = this.f;
                                arrayList3.set(arrayList3.size() - 1, strA2);
                            } else {
                                this.f.add(strA2);
                            }
                            if (z4) {
                                this.f.add("");
                            }
                        } else {
                            ArrayList arrayList4 = this.f;
                            if (((String) arrayList4.remove(arrayList4.size() - 1)).length() == 0 && !this.f.isEmpty()) {
                                ArrayList arrayList5 = this.f;
                                arrayList5.set(arrayList5.size() - 1, "");
                            } else {
                                this.f.add("");
                            }
                        }
                    }
                    i4 = z4 ? iA6 + 1 : iA6;
                }
            }
            if (iA5 >= iB || input.charAt(iA5) != '?') {
                c = '#';
            } else {
                c = '#';
                int iA7 = y82.a(input, '#', iA5, iB);
                this.g = b.b(b.a(input, iA5 + 1, iA7, " \"'<>#", true, false, true, false, 208));
                iA5 = iA7;
            }
            if (iA5 < iB && input.charAt(iA5) == c) {
                this.h = b.a(input, iA5 + 1, iB, "", true, false, false, true, 176);
            }
            return this;
        }

        public final a a(int i) {
            if (1 <= i && i < 65536) {
                this.e = i;
                return this;
            }
            throw new IllegalArgumentException(("unexpected port: " + i).toString());
        }
    }

    public static final class b {
        public static ArrayList b(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i <= str.length()) {
                int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, Typography.amp, i, false, 4, (Object) null);
                if (iIndexOf$default == -1) {
                    iIndexOf$default = str.length();
                }
                int i2 = iIndexOf$default;
                int iIndexOf$default2 = StringsKt.indexOf$default((CharSequence) str, com.json.cc.T, i, false, 4, (Object) null);
                if (iIndexOf$default2 == -1 || iIndexOf$default2 > i2) {
                    String strSubstring = str.substring(i, i2);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    arrayList.add(strSubstring);
                    arrayList.add(null);
                } else {
                    String strSubstring2 = str.substring(i, iIndexOf$default2);
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                    arrayList.add(strSubstring2);
                    String strSubstring3 = str.substring(iIndexOf$default2 + 1, i2);
                    Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
                    arrayList.add(strSubstring3);
                }
                i = i2 + 1;
            }
            return arrayList;
        }

        /* JADX WARN: Code duplicated, block: B:101:0x0120 A[LOOP:2: B:99:0x011a->B:101:0x0120, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:92:0x0108  */
        /* JADX WARN: Code duplicated, block: B:95:0x010f  */
        /* JADX WARN: Code duplicated, block: B:97:0x0112  */
        public static String a(String str, int i, int i2, String encodeSet, boolean z, boolean z2, boolean z3, boolean z4, int i3) throws EOFException {
            int i4;
            boolean z5 = false;
            int i5 = (i3 & 1) != 0 ? 0 : i;
            int length = (i3 & 2) != 0 ? str.length() : i2;
            boolean z6 = (i3 & 8) != 0 ? false : z;
            boolean z7 = (i3 & 16) != 0 ? false : z2;
            boolean z8 = (i3 & 32) != 0 ? false : z3;
            boolean z9 = (i3 & 64) != 0 ? false : z4;
            Intrinsics.checkNotNullParameter(str, "<this>");
            Intrinsics.checkNotNullParameter(encodeSet, "encodeSet");
            int iCharCount = i5;
            while (iCharCount < length) {
                int iCodePointAt = str.codePointAt(iCharCount);
                int i6 = 127;
                if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && !z9) || StringsKt.contains$default(encodeSet, (char) iCodePointAt, z5, 2, (Object) null) || ((iCodePointAt == 37 && (!z6 || (z7 && ((i4 = iCharCount + 2) >= length || str.charAt(iCharCount) != '%' || y82.a(str.charAt(iCharCount + 1)) == -1 || y82.a(str.charAt(i4)) == -1)))) || (iCodePointAt == 43 && z8)))) {
                    Buffer buffer = new Buffer();
                    buffer.writeUtf8(str, i5, iCharCount);
                    Buffer buffer2 = null;
                    while (iCharCount < length) {
                        int iCodePointAt2 = str.codePointAt(iCharCount);
                        if (!z6 || (iCodePointAt2 != 9 && iCodePointAt2 != 10 && iCodePointAt2 != 12 && iCodePointAt2 != 13)) {
                            if (iCodePointAt2 == 43 && z8) {
                                buffer.writeUtf8(z6 ? Marker.ANY_NON_NULL_MARKER : "%2B");
                            } else if (iCodePointAt2 < 32 || iCodePointAt2 == i6 || ((iCodePointAt2 >= 128 && !z9) || StringsKt.contains$default((CharSequence) encodeSet, (char) iCodePointAt2, false, 2, (Object) null))) {
                                if (buffer2 == null) {
                                    buffer2 = new Buffer();
                                }
                                buffer2.writeUtf8CodePoint(iCodePointAt2);
                                while (!buffer2.exhausted()) {
                                    byte b = buffer2.readByte();
                                    buffer.writeByte(37);
                                    buffer.writeByte((int) di0.j[((b & 255) >> 4) & 15]);
                                    buffer.writeByte((int) di0.j[b & Ascii.SI]);
                                }
                            } else {
                                if (iCodePointAt2 == 37) {
                                    if (z6) {
                                        if (z7) {
                                            int i7 = iCharCount + 2;
                                            if (i7 < length && str.charAt(iCharCount) == '%') {
                                                if (y82.a(str.charAt(iCharCount + 1)) == -1 || y82.a(str.charAt(i7)) == -1) {
                                                }
                                            }
                                        }
                                    }
                                    if (buffer2 == null) {
                                        buffer2 = new Buffer();
                                    }
                                    buffer2.writeUtf8CodePoint(iCodePointAt2);
                                    while (!buffer2.exhausted()) {
                                        byte b2 = buffer2.readByte();
                                        buffer.writeByte(37);
                                        buffer.writeByte((int) di0.j[((b2 & 255) >> 4) & 15]);
                                        buffer.writeByte((int) di0.j[b2 & Ascii.SI]);
                                    }
                                }
                                buffer.writeUtf8CodePoint(iCodePointAt2);
                            }
                        }
                        iCharCount += Character.charCount(iCodePointAt2);
                        i6 = 127;
                    }
                    return buffer.readUtf8();
                }
                iCharCount += Character.charCount(iCodePointAt);
                z5 = false;
            }
            String strSubstring = str.substring(i5, length);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return strSubstring;
        }

        private b() {
        }

        public /* synthetic */ b(int i) {
            this();
        }

        @JvmStatic
        public static int a(String scheme) {
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            if (Intrinsics.areEqual(scheme, "http")) {
                return 80;
            }
            return Intrinsics.areEqual(scheme, "https") ? 443 : -1;
        }

        public static String a(String str, int i, int i2, boolean z, int i3) {
            int i4;
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = str.length();
            }
            if ((i3 & 4) != 0) {
                z = false;
            }
            Intrinsics.checkNotNullParameter(str, "<this>");
            int iCharCount = i;
            while (iCharCount < i2) {
                char cCharAt = str.charAt(iCharCount);
                if (cCharAt == '%' || (cCharAt == '+' && z)) {
                    Buffer buffer = new Buffer();
                    buffer.writeUtf8(str, i, iCharCount);
                    while (iCharCount < i2) {
                        int iCodePointAt = str.codePointAt(iCharCount);
                        if (iCodePointAt == 37 && (i4 = iCharCount + 2) < i2) {
                            int iA = y82.a(str.charAt(iCharCount + 1));
                            int iA2 = y82.a(str.charAt(i4));
                            if (iA != -1 && iA2 != -1) {
                                buffer.writeByte((iA << 4) + iA2);
                                iCharCount = Character.charCount(iCodePointAt) + i4;
                            } else {
                                buffer.writeUtf8CodePoint(iCodePointAt);
                                iCharCount += Character.charCount(iCodePointAt);
                            }
                        } else if (iCodePointAt == 43 && z) {
                            buffer.writeByte(32);
                            iCharCount++;
                        } else {
                            buffer.writeUtf8CodePoint(iCodePointAt);
                            iCharCount += Character.charCount(iCodePointAt);
                        }
                    }
                    return buffer.readUtf8();
                }
                iCharCount++;
            }
            String strSubstring = str.substring(i, i2);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return strSubstring;
        }
    }

    public di0(String scheme, String username, String password, String host, int i, ArrayList pathSegments, ArrayList arrayList, String str, String url) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(pathSegments, "pathSegments");
        Intrinsics.checkNotNullParameter(url, "url");
        this.f8696a = scheme;
        this.b = username;
        this.c = password;
        this.d = host;
        this.e = i;
        this.f = arrayList;
        this.g = str;
        this.h = url;
        this.i = Intrinsics.areEqual(scheme, "https");
    }

    public final URL m() {
        try {
            return new URL(this.h);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public final ArrayList d() {
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) this.h, '/', this.f8696a.length() + 3, false, 4, (Object) null);
        String str = this.h;
        int iA = y82.a(iIndexOf$default, str.length(), str, "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf$default < iA) {
            int i = iIndexOf$default + 1;
            int iA2 = y82.a(this.h, '/', i, iA);
            String strSubstring = this.h.substring(i, iA2);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            arrayList.add(strSubstring);
            iIndexOf$default = iA2;
        }
        return arrayList;
    }

    public final String j() throws EOFException {
        a aVarA;
        Intrinsics.checkNotNullParameter("/...", "link");
        try {
            aVarA = new a().a(this, "/...");
        } catch (IllegalArgumentException unused) {
            aVarA = null;
        }
        Intrinsics.checkNotNull(aVarA);
        return aVarA.e().c().a().h;
    }

    public final URI l() {
        String strSubstring;
        a aVar = new a();
        aVar.h(this.f8696a);
        aVar.f(f());
        aVar.e(b());
        aVar.g(this.d);
        aVar.b(this.e != b.a(this.f8696a) ? this.e : -1);
        aVar.b().clear();
        aVar.b().addAll(d());
        aVar.a(e());
        if (this.g == null) {
            strSubstring = null;
        } else {
            strSubstring = this.h.substring(StringsKt.indexOf$default((CharSequence) this.h, '#', 0, false, 6, (Object) null) + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        }
        aVar.d(strSubstring);
        String string = aVar.d().toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e) {
            try {
                URI uriCreate = URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").replace(string, ""));
                Intrinsics.checkNotNull(uriCreate);
                return uriCreate;
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public final String k() {
        return this.f8696a;
    }

    public final String g() {
        return this.d;
    }

    public final int i() {
        return this.e;
    }

    public final boolean h() {
        return this.i;
    }

    public final String f() {
        if (this.b.length() == 0) {
            return "";
        }
        int length = this.f8696a.length() + 3;
        String str = this.h;
        String strSubstring = this.h.substring(length, y82.a(length, str.length(), str, ":@"));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final String b() {
        if (this.c.length() == 0) {
            return "";
        }
        String strSubstring = this.h.substring(StringsKt.indexOf$default((CharSequence) this.h, AbstractJsonLexerKt.COLON, this.f8696a.length() + 3, false, 4, (Object) null) + 1, StringsKt.indexOf$default((CharSequence) this.h, '@', 0, false, 6, (Object) null));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final String c() {
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) this.h, '/', this.f8696a.length() + 3, false, 4, (Object) null);
        String str = this.h;
        String strSubstring = this.h.substring(iIndexOf$default, y82.a(iIndexOf$default, str.length(), str, "?#"));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final String e() {
        if (this.f == null) {
            return null;
        }
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) this.h, '?', 0, false, 6, (Object) null) + 1;
        String str = this.h;
        String strSubstring = this.h.substring(iIndexOf$default, y82.a(str, '#', iIndexOf$default, str.length()));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof di0) && Intrinsics.areEqual(((di0) obj).h, this.h);
    }

    public final int hashCode() {
        return this.h.hashCode();
    }

    public final String toString() {
        return this.h;
    }
}
