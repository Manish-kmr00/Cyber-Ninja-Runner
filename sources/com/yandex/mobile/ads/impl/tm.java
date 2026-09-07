package com.yandex.mobile.ads.impl;

import com.google.common.net.HttpHeaders;
import io.ktor.client.utils.CacheControl;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class tm {
    public static final /* synthetic */ int n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f10316a;
    private final boolean b;
    private final int c;
    private final int d;
    private final boolean e;
    private final boolean f;
    private final boolean g;
    private final int h;
    private final int i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private String m;

    public static final class a {
        public final a a() {
            return this;
        }

        public final a a(TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
            timeUnit.toSeconds(Integer.MAX_VALUE);
            return this;
        }

        public final a b() {
            return this;
        }
    }

    public static final class b {
        /* JADX WARN: Code duplicated, block: B:108:0x0071 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:109:0x007b A[EDGE_INSN: B:109:0x007b->B:23:0x007b BREAK  A[LOOP:2: B:16:0x004c->B:21:0x0066], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:15:0x0047  */
        /* JADX WARN: Code duplicated, block: B:18:0x004f  */
        /* JADX WARN: Code duplicated, block: B:21:0x0066 A[LOOP:2: B:16:0x004c->B:21:0x0066, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:52:0x0139  */
        /* JADX WARN: Code duplicated, block: B:55:0x014c  */
        /* JADX WARN: Code duplicated, block: B:59:0x015b  */
        /* JADX WARN: Code duplicated, block: B:61:0x0163  */
        /* JADX WARN: Code duplicated, block: B:62:0x0167  */
        /* JADX WARN: Code duplicated, block: B:64:0x016f  */
        /* JADX WARN: Code duplicated, block: B:66:0x0177  */
        /* JADX WARN: Code duplicated, block: B:68:0x0180  */
        /* JADX WARN: Code duplicated, block: B:69:0x0185  */
        /* JADX WARN: Code duplicated, block: B:71:0x018d  */
        /* JADX WARN: Code duplicated, block: B:72:0x0191  */
        /* JADX WARN: Code duplicated, block: B:74:0x0199  */
        /* JADX WARN: Code duplicated, block: B:75:0x019f  */
        /* JADX WARN: Code duplicated, block: B:77:0x01a7  */
        /* JADX WARN: Code duplicated, block: B:78:0x01ab  */
        /* JADX WARN: Code duplicated, block: B:80:0x01b3  */
        /* JADX WARN: Code duplicated, block: B:81:0x01bb  */
        /* JADX WARN: Code duplicated, block: B:83:0x01c3  */
        /* JADX WARN: Code duplicated, block: B:84:0x01c9  */
        /* JADX WARN: Code duplicated, block: B:86:0x01d2  */
        /* JADX WARN: Code duplicated, block: B:87:0x01d8  */
        /* JADX WARN: Code duplicated, block: B:89:0x01e0  */
        /* JADX WARN: Code duplicated, block: B:90:0x01e6  */
        /* JADX WARN: Code duplicated, block: B:92:0x01f0  */
        @JvmStatic
        public static tm a(nf0 nf0Var) {
            int i;
            boolean z;
            boolean z2;
            int i2;
            int length;
            int length2;
            int i3;
            boolean z3;
            String str;
            String string;
            boolean z4;
            boolean z5;
            String string2;
            int i4;
            nf0 headers = nf0Var;
            Intrinsics.checkNotNullParameter(headers, "headers");
            int size = nf0Var.size();
            boolean z6 = true;
            boolean z7 = true;
            int i5 = 0;
            String str2 = null;
            boolean z8 = false;
            boolean z9 = false;
            int iA = -1;
            int iA2 = -1;
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            int iA3 = -1;
            int iA4 = -1;
            boolean z13 = false;
            boolean z14 = false;
            boolean z15 = false;
            while (i5 < size) {
                String strA = headers.a(i5);
                String strB = headers.b(i5);
                if (StringsKt.equals(strA, "Cache-Control", z6)) {
                    if (str2 == null) {
                        str2 = strB;
                    }
                    i2 = 0;
                    while (i2 < strB.length()) {
                        length = strB.length();
                        length2 = i2;
                        while (true) {
                            if (length2 < length) {
                                i3 = size;
                                z3 = z7;
                                str = str2;
                                length2 = strB.length();
                                break;
                            }
                            i3 = size;
                            i4 = length;
                            z3 = z7;
                            str = str2;
                            if (StringsKt.contains$default((CharSequence) "=,;", strB.charAt(length2), false, 2, (Object) null)) {
                                break;
                            }
                            length2++;
                            length = i4;
                            size = i3;
                            z7 = z3;
                            str2 = str;
                        }
                        String strSubstring = strB.substring(i2, length2);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                        string = StringsKt.trim((CharSequence) strSubstring).toString();
                        if (length2 != strB.length() || strB.charAt(length2) == ',' || strB.charAt(length2) == ';') {
                            z4 = z11;
                            z5 = z12;
                            i2 = length2 + 1;
                            string2 = null;
                        } else {
                            int length3 = length2 + 1;
                            byte[] bArr = y82.f10712a;
                            Intrinsics.checkNotNullParameter(strB, "<this>");
                            int length4 = strB.length();
                            while (true) {
                                if (length3 < length4) {
                                    char cCharAt = strB.charAt(length3);
                                    if (cCharAt != ' ' && cCharAt != '\t') {
                                        break;
                                    }
                                    length3++;
                                } else {
                                    length3 = strB.length();
                                    break;
                                }
                            }
                            if (length3 >= strB.length() || strB.charAt(length3) != '\"') {
                                int length5 = strB.length();
                                int length6 = length3;
                                while (true) {
                                    if (length6 >= length5) {
                                        z4 = z11;
                                        z5 = z12;
                                        length6 = strB.length();
                                        break;
                                    }
                                    int i6 = length5;
                                    z4 = z11;
                                    z5 = z12;
                                    if (StringsKt.contains$default((CharSequence) ",;", strB.charAt(length6), false, 2, (Object) null)) {
                                        break;
                                    }
                                    length6++;
                                    length5 = i6;
                                    z12 = z5;
                                    z11 = z4;
                                }
                                String strSubstring2 = strB.substring(length3, length6);
                                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                                string2 = StringsKt.trim((CharSequence) strSubstring2).toString();
                                i2 = length6;
                            } else {
                                int i7 = length3 + 1;
                                int iIndexOf$default = StringsKt.indexOf$default((CharSequence) strB, '\"', i7, false, 4, (Object) null);
                                string2 = strB.substring(i7, iIndexOf$default);
                                Intrinsics.checkNotNullExpressionValue(string2, "substring(...)");
                                i2 = iIndexOf$default + 1;
                                z4 = z11;
                                z5 = z12;
                            }
                        }
                        z6 = true;
                        if (StringsKt.equals(CacheControl.NO_CACHE, string, true)) {
                            z8 = true;
                        } else if (StringsKt.equals(CacheControl.NO_STORE, string, true)) {
                            z9 = true;
                        } else if (StringsKt.equals(CacheControl.MAX_AGE, string, true)) {
                            iA = y82.a(-1, string2);
                        } else if (StringsKt.equals(CacheControl.S_MAX_AGE, string, true)) {
                            iA2 = y82.a(-1, string2);
                        } else if (StringsKt.equals(CacheControl.PRIVATE, string, true)) {
                            z10 = true;
                        } else {
                            if (StringsKt.equals("public", string, true)) {
                                z11 = true;
                                z12 = z5;
                            } else {
                                if (StringsKt.equals(CacheControl.MUST_REVALIDATE, string, true)) {
                                    z12 = true;
                                } else if (StringsKt.equals(CacheControl.MAX_STALE, string, true)) {
                                    iA3 = y82.a(Integer.MAX_VALUE, string2);
                                } else if (StringsKt.equals(CacheControl.MIN_FRESH, string, true)) {
                                    iA4 = y82.a(-1, string2);
                                } else if (StringsKt.equals(CacheControl.ONLY_IF_CACHED, string, true)) {
                                    z13 = true;
                                } else if (StringsKt.equals(CacheControl.NO_TRANSFORM, string, true)) {
                                    z14 = true;
                                } else if (StringsKt.equals("immutable", string, true)) {
                                    z15 = true;
                                }
                                z11 = z4;
                            }
                            size = i3;
                            z7 = z3;
                            str2 = str;
                        }
                        z12 = z5;
                        z11 = z4;
                        size = i3;
                        z7 = z3;
                        str2 = str;
                    }
                    i = size;
                    z2 = z12;
                    z = z11;
                    i5++;
                    headers = nf0Var;
                    z12 = z2;
                    z11 = z;
                    size = i;
                } else {
                    if (!StringsKt.equals(strA, HttpHeaders.PRAGMA, z6)) {
                        i = size;
                        z = z11;
                        z2 = z12;
                    }
                    i5++;
                    headers = nf0Var;
                    z12 = z2;
                    z11 = z;
                    size = i;
                }
                z7 = false;
                i2 = 0;
                while (i2 < strB.length()) {
                    length = strB.length();
                    length2 = i2;
                    while (true) {
                        if (length2 < length) {
                            i3 = size;
                            z3 = z7;
                            str = str2;
                            length2 = strB.length();
                            break;
                        }
                        i3 = size;
                        i4 = length;
                        z3 = z7;
                        str = str2;
                        if (StringsKt.contains$default((CharSequence) "=,;", strB.charAt(length2), false, 2, (Object) null)) {
                            break;
                            break;
                        }
                        length2++;
                        length = i4;
                        size = i3;
                        z7 = z3;
                        str2 = str;
                    }
                    String strSubstring3 = strB.substring(i2, length2);
                    Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
                    string = StringsKt.trim((CharSequence) strSubstring3).toString();
                    if (length2 != strB.length()) {
                        z4 = z11;
                        z5 = z12;
                        i2 = length2 + 1;
                        string2 = null;
                    } else {
                        z4 = z11;
                        z5 = z12;
                        i2 = length2 + 1;
                        string2 = null;
                    }
                    z6 = true;
                    if (StringsKt.equals(CacheControl.NO_CACHE, string, true)) {
                        z8 = true;
                    } else if (StringsKt.equals(CacheControl.NO_STORE, string, true)) {
                        z9 = true;
                    } else if (StringsKt.equals(CacheControl.MAX_AGE, string, true)) {
                        iA = y82.a(-1, string2);
                    } else if (StringsKt.equals(CacheControl.S_MAX_AGE, string, true)) {
                        iA2 = y82.a(-1, string2);
                    } else if (StringsKt.equals(CacheControl.PRIVATE, string, true)) {
                        z10 = true;
                    } else {
                        if (StringsKt.equals("public", string, true)) {
                            z11 = true;
                            z12 = z5;
                        } else {
                            if (StringsKt.equals(CacheControl.MUST_REVALIDATE, string, true)) {
                                z12 = true;
                            } else if (StringsKt.equals(CacheControl.MAX_STALE, string, true)) {
                                iA3 = y82.a(Integer.MAX_VALUE, string2);
                            } else if (StringsKt.equals(CacheControl.MIN_FRESH, string, true)) {
                                iA4 = y82.a(-1, string2);
                            } else if (StringsKt.equals(CacheControl.ONLY_IF_CACHED, string, true)) {
                                z13 = true;
                            } else if (StringsKt.equals(CacheControl.NO_TRANSFORM, string, true)) {
                                z14 = true;
                            } else if (StringsKt.equals("immutable", string, true)) {
                                z15 = true;
                            }
                            z11 = z4;
                        }
                        size = i3;
                        z7 = z3;
                        str2 = str;
                    }
                    z12 = z5;
                    z11 = z4;
                    size = i3;
                    z7 = z3;
                    str2 = str;
                }
                i = size;
                z2 = z12;
                z = z11;
                i5++;
                headers = nf0Var;
                z12 = z2;
                z11 = z;
                size = i;
            }
            return new tm(z8, z9, iA, iA2, z10, z11, z12, iA3, iA4, z13, z14, z15, !z7 ? null : str2, 0);
        }
    }

    static {
        new a().a();
        new a().b().a(TimeUnit.SECONDS);
    }

    private tm(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str) {
        this.f10316a = z;
        this.b = z2;
        this.c = i;
        this.d = i2;
        this.e = z3;
        this.f = z4;
        this.g = z5;
        this.h = i3;
        this.i = i4;
        this.j = z6;
        this.k = z7;
        this.l = z8;
        this.m = str;
    }

    public final boolean a() {
        return this.j;
    }

    public /* synthetic */ tm(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str, int i5) {
        this(z, z2, i, i2, z3, z4, z5, i3, i4, z6, z7, z8, str);
    }

    public final String toString() {
        String str = this.m;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.f10316a) {
            sb.append("no-cache, ");
        }
        if (this.b) {
            sb.append("no-store, ");
        }
        if (this.c != -1) {
            sb.append("max-age=").append(this.c).append(", ");
        }
        if (this.d != -1) {
            sb.append("s-maxage=").append(this.d).append(", ");
        }
        if (this.e) {
            sb.append("private, ");
        }
        if (this.f) {
            sb.append("public, ");
        }
        if (this.g) {
            sb.append("must-revalidate, ");
        }
        if (this.h != -1) {
            sb.append("max-stale=").append(this.h).append(", ");
        }
        if (this.i != -1) {
            sb.append("min-fresh=").append(this.i).append(", ");
        }
        if (this.j) {
            sb.append("only-if-cached, ");
        }
        if (this.k) {
            sb.append("no-transform, ");
        }
        if (this.l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        this.m = string;
        return string;
    }
}
