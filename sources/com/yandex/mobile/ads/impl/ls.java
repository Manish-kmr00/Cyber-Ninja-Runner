package com.yandex.mobile.ads.impl;

import com.google.firebase.sessions.settings.RemoteSettings;
import com.json.mediationsdk.logger.IronSourceError;
import com.monetization.ads.embedded.okhttp.src.main.kotlin.okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import io.ktor.client.utils.CacheControl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
public final class ls {
    private static final Pattern j = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern l = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    public static final /* synthetic */ int n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9564a;
    private final String b;
    private final long c;
    private final String d;
    private final String e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final boolean i;

    public static final class a {
        private static int a(int i, int i2, String str, boolean z) {
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || ('0' <= cCharAt && cCharAt < ':') || (('a' <= cCharAt && cCharAt < '{') || (('A' <= cCharAt && cCharAt < '[') || cCharAt == ':'))) == (!z)) {
                    return i;
                }
                i++;
            }
            return i2;
        }

        /* JADX WARN: Code duplicated, block: B:135:0x02b2 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:136:0x02b4  */
        /* JADX WARN: Code duplicated, block: B:155:0x02bc A[SYNTHETIC] */
        @JvmStatic
        public static List a(di0 di0Var, nf0 headers) {
            String str;
            List list;
            int i;
            int i2;
            String str2;
            ls lsVar;
            String strSubstring;
            String str3;
            di0 url = di0Var;
            String str4 = "url";
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(headers, "headers");
            List listD = headers.d();
            int size = listD.size();
            int i3 = 0;
            int i4 = 0;
            ArrayList arrayList = null;
            while (i4 < size) {
                String setCookie = (String) listD.get(i4);
                Intrinsics.checkNotNullParameter(url, str4);
                Intrinsics.checkNotNullParameter(setCookie, "setCookie");
                long jCurrentTimeMillis = System.currentTimeMillis();
                Intrinsics.checkNotNullParameter(url, str4);
                Intrinsics.checkNotNullParameter(setCookie, "setCookie");
                byte[] bArr = y82.f10712a;
                int iA = y82.a(setCookie, ';', i3, setCookie.length());
                int iA2 = y82.a(setCookie, com.json.cc.T, i3, iA);
                if (iA2 == iA) {
                    str = str4;
                    list = listD;
                    i = size;
                    i2 = i3;
                } else {
                    String str5 = "<this>";
                    Intrinsics.checkNotNullParameter(setCookie, "<this>");
                    int iA3 = y82.a(i3, iA2, setCookie);
                    String strSubstring2 = setCookie.substring(iA3, y82.b(iA3, iA2, setCookie));
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                    if (strSubstring2.length() == 0) {
                        str = str4;
                        list = listD;
                    } else {
                        Intrinsics.checkNotNullParameter(strSubstring2, "<this>");
                        int length = strSubstring2.length();
                        str = str4;
                        int i5 = 0;
                        while (true) {
                            list = listD;
                            if (i5 < length) {
                                char cCharAt = strSubstring2.charAt(i5);
                                if (Intrinsics.compare((int) cCharAt, 31) <= 0 || Intrinsics.compare((int) cCharAt, 127) >= 0) {
                                    if (i5 != -1) {
                                    }
                                    if (lsVar != null) {
                                        if (arrayList == null) {
                                            arrayList = new ArrayList();
                                        }
                                        arrayList.add(lsVar);
                                    }
                                    i4++;
                                    url = di0Var;
                                    i3 = i2;
                                    str4 = str;
                                    listD = list;
                                    size = i;
                                } else {
                                    i5++;
                                    listD = list;
                                }
                            }
                            Intrinsics.checkNotNullParameter(setCookie, "<this>");
                            int iA4 = y82.a(iA2 + 1, iA, setCookie);
                            String strSubstring3 = setCookie.substring(iA4, y82.b(iA4, iA, setCookie));
                            Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
                            Intrinsics.checkNotNullParameter(strSubstring3, "<this>");
                            int length2 = strSubstring3.length();
                            int i6 = 0;
                            while (true) {
                                if (i6 < length2) {
                                    char cCharAt2 = strSubstring3.charAt(i6);
                                    if (Intrinsics.compare((int) cCharAt2, 31) <= 0 || Intrinsics.compare((int) cCharAt2, 127) >= 0) {
                                        if (i6 != -1) {
                                        }
                                        i2 = 0;
                                    } else {
                                        i6++;
                                    }
                                }
                                int i7 = iA + 1;
                                int length3 = setCookie.length();
                                long j = 253402300799999L;
                                long j2 = -1;
                                long jA = 253402300799999L;
                                String str6 = null;
                                String str7 = null;
                                boolean z = false;
                                boolean z2 = false;
                                boolean z3 = false;
                                boolean z4 = true;
                                while (true) {
                                    if (i7 < length3) {
                                        int i8 = size;
                                        int iA5 = y82.a(setCookie, ';', i7, length3);
                                        int i9 = length3;
                                        int iA6 = y82.a(setCookie, com.json.cc.T, i7, iA5);
                                        Intrinsics.checkNotNullParameter(setCookie, str5);
                                        int iA7 = y82.a(i7, iA6, setCookie);
                                        String strSubstring4 = setCookie.substring(iA7, y82.b(iA7, iA6, setCookie));
                                        Intrinsics.checkNotNullExpressionValue(strSubstring4, "substring(...)");
                                        if (iA6 < iA5) {
                                            Intrinsics.checkNotNullParameter(setCookie, str5);
                                            int iA8 = y82.a(iA6 + 1, iA5, setCookie);
                                            strSubstring = setCookie.substring(iA8, y82.b(iA8, iA5, setCookie));
                                            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                                        } else {
                                            strSubstring = "";
                                        }
                                        String str8 = str5;
                                        if (StringsKt.equals(strSubstring4, "expires", true)) {
                                            try {
                                                jA = a(strSubstring.length(), strSubstring);
                                                str3 = setCookie;
                                                z3 = true;
                                            } catch (NumberFormatException | IllegalArgumentException unused) {
                                                str3 = setCookie;
                                            }
                                        } else if (StringsKt.equals(strSubstring4, CacheControl.MAX_AGE, true)) {
                                            try {
                                                long j3 = Long.parseLong(strSubstring);
                                                if (j3 <= 0) {
                                                    str3 = setCookie;
                                                    j2 = Long.MIN_VALUE;
                                                    z3 = true;
                                                } else {
                                                    j2 = j3;
                                                    str3 = setCookie;
                                                    z3 = true;
                                                }
                                            } catch (NumberFormatException e) {
                                                if (new Regex("-?\\d+").matches(strSubstring)) {
                                                    str3 = setCookie;
                                                    try {
                                                        if (!StringsKt.startsWith$default(strSubstring, "-", false, 2, (Object) null)) {
                                                            j2 = Long.MAX_VALUE;
                                                        }
                                                        z3 = true;
                                                    } catch (NumberFormatException | IllegalArgumentException unused2) {
                                                    }
                                                    i7 = iA5 + 1;
                                                    length3 = i9;
                                                    size = i8;
                                                    str5 = str8;
                                                    setCookie = str3;
                                                } else {
                                                    str3 = setCookie;
                                                    throw e;
                                                }
                                                i7 = iA5 + 1;
                                                length3 = i9;
                                                size = i8;
                                                str5 = str8;
                                                setCookie = str3;
                                            }
                                        } else {
                                            str3 = setCookie;
                                            if (StringsKt.equals(strSubstring4, "domain", true)) {
                                                if (!StringsKt.endsWith$default(strSubstring, ".", false, 2, (Object) null)) {
                                                    String strA = gg0.a(StringsKt.removePrefix(strSubstring, (CharSequence) "."));
                                                    if (strA == null) {
                                                        throw new IllegalArgumentException();
                                                    }
                                                    str6 = strA;
                                                    z4 = false;
                                                } else {
                                                    throw new IllegalArgumentException("Failed requirement.".toString());
                                                }
                                            } else if (StringsKt.equals(strSubstring4, "path", true)) {
                                                str7 = strSubstring;
                                            } else if (StringsKt.equals(strSubstring4, POBConstants.KEY_SECURE, true)) {
                                                z = true;
                                            } else if (StringsKt.equals(strSubstring4, "httponly", true)) {
                                                z2 = true;
                                            }
                                        }
                                        i7 = iA5 + 1;
                                        length3 = i9;
                                        size = i8;
                                        str5 = str8;
                                        setCookie = str3;
                                    } else {
                                        i = size;
                                        if (j2 == Long.MIN_VALUE) {
                                            j = Long.MIN_VALUE;
                                        } else if (j2 != -1) {
                                            long j4 = jCurrentTimeMillis + (j2 <= 9223372036854775L ? j2 * ((long) 1000) : Long.MAX_VALUE);
                                            if (j4 >= jCurrentTimeMillis && j4 <= 253402300799999L) {
                                                j = j4;
                                            }
                                        } else {
                                            j = jA;
                                        }
                                        String strG = di0Var.g();
                                        if (str6 == null) {
                                            str6 = strG;
                                        } else {
                                            if (Intrinsics.areEqual(strG, str6) || (StringsKt.endsWith$default(strG, str6, false, 2, (Object) null) && strG.charAt((strG.length() - str6.length()) - 1) == '.' && !y82.a(strG))) {
                                            }
                                            i2 = 0;
                                        }
                                        if (strG.length() == str6.length() || PublicSuffixDatabase.g.a(str6) != null) {
                                            String strSubstring5 = RemoteSettings.FORWARD_SLASH_STRING;
                                            if (str7 == null || !StringsKt.startsWith$default(str7, RemoteSettings.FORWARD_SLASH_STRING, false, 2, (Object) null)) {
                                                String strC = di0Var.c();
                                                int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) strC, '/', 0, false, 6, (Object) null);
                                                if (iLastIndexOf$default != 0) {
                                                    i2 = 0;
                                                    strSubstring5 = strC.substring(0, iLastIndexOf$default);
                                                    Intrinsics.checkNotNullExpressionValue(strSubstring5, "substring(...)");
                                                } else {
                                                    i2 = 0;
                                                }
                                                str2 = strSubstring5;
                                            } else {
                                                str2 = str7;
                                                i2 = 0;
                                            }
                                            lsVar = new ls(strSubstring2, strSubstring3, j, str6, str2, z, z2, z3, z4, 0);
                                        } else {
                                            i2 = 0;
                                        }
                                        if (lsVar != null) {
                                            if (arrayList == null) {
                                                arrayList = new ArrayList();
                                            }
                                            arrayList.add(lsVar);
                                        }
                                        i4++;
                                        url = di0Var;
                                        i3 = i2;
                                        str4 = str;
                                        listD = list;
                                        size = i;
                                    }
                                }
                            }
                        }
                    }
                    i = size;
                    i2 = 0;
                }
                lsVar = null;
                if (lsVar != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(lsVar);
                }
                i4++;
                url = di0Var;
                i3 = i2;
                str4 = str;
                listD = list;
                size = i;
            }
            if (arrayList != null) {
                List listUnmodifiableList = Collections.unmodifiableList(arrayList);
                Intrinsics.checkNotNull(listUnmodifiableList);
                return listUnmodifiableList;
            }
            return CollectionsKt.emptyList();
        }

        private static long a(int i, String str) {
            int iA = a(0, i, str, false);
            Matcher matcher = ls.m.matcher(str);
            int i2 = -1;
            int i3 = -1;
            int i4 = -1;
            int iIndexOf$default = -1;
            int i5 = -1;
            int i6 = -1;
            while (iA < i) {
                int iA2 = a(iA + 1, i, str, true);
                matcher.region(iA, iA2);
                if (i3 != -1 || !matcher.usePattern(ls.m).matches()) {
                    if (i4 != -1 || !matcher.usePattern(ls.l).matches()) {
                        if (iIndexOf$default != -1 || !matcher.usePattern(ls.k).matches()) {
                            if (i2 == -1 && matcher.usePattern(ls.j).matches()) {
                                String strGroup = matcher.group(1);
                                Intrinsics.checkNotNullExpressionValue(strGroup, "group(...)");
                                i2 = Integer.parseInt(strGroup);
                            }
                        } else {
                            String strGroup2 = matcher.group(1);
                            Intrinsics.checkNotNullExpressionValue(strGroup2, "group(...)");
                            Locale US = Locale.US;
                            Intrinsics.checkNotNullExpressionValue(US, "US");
                            String lowerCase = strGroup2.toLowerCase(US);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                            String strPattern = ls.k.pattern();
                            Intrinsics.checkNotNullExpressionValue(strPattern, "pattern(...)");
                            iIndexOf$default = StringsKt.indexOf$default((CharSequence) strPattern, lowerCase, 0, false, 6, (Object) null) / 4;
                        }
                    } else {
                        String strGroup3 = matcher.group(1);
                        Intrinsics.checkNotNullExpressionValue(strGroup3, "group(...)");
                        i4 = Integer.parseInt(strGroup3);
                    }
                } else {
                    String strGroup4 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(strGroup4, "group(...)");
                    i3 = Integer.parseInt(strGroup4);
                    String strGroup5 = matcher.group(2);
                    Intrinsics.checkNotNullExpressionValue(strGroup5, "group(...)");
                    i5 = Integer.parseInt(strGroup5);
                    String strGroup6 = matcher.group(3);
                    Intrinsics.checkNotNullExpressionValue(strGroup6, "group(...)");
                    i6 = Integer.parseInt(strGroup6);
                }
                iA = a(iA2 + 1, i, str, false);
            }
            if (70 <= i2 && i2 < 100) {
                i2 += 1900;
            }
            if (i2 >= 0 && i2 < 70) {
                i2 += 2000;
            }
            if (i2 < 1601) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (iIndexOf$default == -1) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (1 > i4 || i4 >= 32) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (i3 < 0 || i3 >= 24) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (i5 < 0 || i5 >= 60) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (i6 >= 0 && i6 < 60) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(y82.d);
                gregorianCalendar.setLenient(false);
                gregorianCalendar.set(1, i2);
                gregorianCalendar.set(2, iIndexOf$default - 1);
                gregorianCalendar.set(5, i4);
                gregorianCalendar.set(11, i3);
                gregorianCalendar.set(12, i5);
                gregorianCalendar.set(13, i6);
                gregorianCalendar.set(14, 0);
                return gregorianCalendar.getTimeInMillis();
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f9564a);
        sb.append(com.json.cc.T);
        sb.append(this.b);
        if (this.h) {
            if (this.c == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=").append(xv.a(new Date(this.c)));
            }
        }
        if (!this.i) {
            sb.append("; domain=");
            sb.append(this.d);
        }
        sb.append("; path=").append(this.e);
        if (this.f) {
            sb.append("; secure");
        }
        if (this.g) {
            sb.append("; httponly");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private ls(String str, String str2, long j2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f9564a = str;
        this.b = str2;
        this.c = j2;
        this.d = str3;
        this.e = str4;
        this.f = z;
        this.g = z2;
        this.h = z3;
        this.i = z4;
    }

    public final String e() {
        return this.f9564a;
    }

    public final String f() {
        return this.b;
    }

    public /* synthetic */ ls(String str, String str2, long j2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4, int i) {
        this(str, str2, j2, str3, str4, z, z2, z3, z4);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ls) {
            ls lsVar = (ls) obj;
            if (Intrinsics.areEqual(lsVar.f9564a, this.f9564a) && Intrinsics.areEqual(lsVar.b, this.b) && lsVar.c == this.c && Intrinsics.areEqual(lsVar.d, this.d) && Intrinsics.areEqual(lsVar.e, this.e) && lsVar.f == this.f && lsVar.g == this.g && lsVar.h == this.h && lsVar.i == this.i) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.i) + a7.a(this.h, a7.a(this.g, a7.a(this.f, v3.a(this.e, v3.a(this.d, (Long.hashCode(this.c) + v3.a(this.b, v3.a(this.f9564a, IronSourceError.ERROR_NON_EXISTENT_INSTANCE, 31), 31)) * 31, 31), 31), 31), 31), 31);
    }
}
