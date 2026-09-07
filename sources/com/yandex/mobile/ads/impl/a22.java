package com.yandex.mobile.ads.impl;

import android.graphics.Color;
import android.graphics.PointF;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes8.dex */
final class a22 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8354a;
    public final int b;
    public final Integer c;
    public final Integer d;
    public final float e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final int j;

    private a22(String str, int i, Integer num, Integer num2, float f, boolean z, boolean z2, boolean z3, boolean z4, int i2) {
        this.f8354a = str;
        this.b = i;
        this.c = num;
        this.d = num2;
        this.e = f;
        this.f = z;
        this.g = z2;
        this.h = z3;
        this.i = z4;
        this.j = i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x0133, code lost:
    
        if (r3 != 3) goto L63;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x0068. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.yandex.mobile.ads.impl.a22 a(java.lang.String r20, com.yandex.mobile.ads.impl.a22.a r21) {
        /*
            Method dump skipped, instruction units count: 394
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.mobile.ads.impl.a22.a(java.lang.String, com.yandex.mobile.ads.impl.a22$a):com.yandex.mobile.ads.impl.a22");
    }

    public static Integer b(String str) {
        long j;
        try {
            if (str.startsWith("&H")) {
                j = Long.parseLong(str.substring(2), 16);
            } else {
                j = Long.parseLong(str);
            }
            if (j <= 4294967295L) {
                return Integer.valueOf(Color.argb(dq0.a(((j >> 24) & 255) ^ 255), dq0.a(j & 255), dq0.a((j >> 8) & 255), dq0.a((j >> 16) & 255)));
            }
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            at0.b("SsaStyle", "Failed to parse color expression: '" + str + "'", e);
            return null;
        }
    }

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8355a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final int i;
        public final int j;
        public final int k;

        private a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
            this.f8355a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = i7;
            this.h = i8;
            this.i = i9;
            this.j = i10;
            this.k = i11;
        }

        public static a a(String str) {
            String[] strArrSplit = TextUtils.split(str.substring(7), StringUtils.COMMA);
            int i = -1;
            int i2 = -1;
            int i3 = -1;
            int i4 = -1;
            int i5 = -1;
            int i6 = -1;
            int i7 = -1;
            int i8 = -1;
            int i9 = -1;
            int i10 = -1;
            for (int i11 = 0; i11 < strArrSplit.length; i11++) {
                String strB = fg.b(strArrSplit[i11].trim());
                strB.getClass();
                strB.hashCode();
                switch (strB) {
                    case "italic":
                        i7 = i11;
                        break;
                    case "underline":
                        i8 = i11;
                        break;
                    case "strikeout":
                        i9 = i11;
                        break;
                    case "primarycolour":
                        i3 = i11;
                        break;
                    case "bold":
                        i6 = i11;
                        break;
                    case "name":
                        i = i11;
                        break;
                    case "fontsize":
                        i5 = i11;
                        break;
                    case "borderstyle":
                        i10 = i11;
                        break;
                    case "alignment":
                        i2 = i11;
                        break;
                    case "outlinecolour":
                        i4 = i11;
                        break;
                }
            }
            if (i != -1) {
                return new a(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, strArrSplit.length);
            }
            return null;
        }
    }

    static final class b {
        private static final Pattern c = Pattern.compile("\\{([^}]*)\\}");
        private static final Pattern d;
        private static final Pattern e;
        private static final Pattern f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8356a;
        public final PointF b;

        static {
            int i = x82.f10629a;
            Locale locale = Locale.US;
            d = Pattern.compile(String.format(locale, "\\\\pos\\((%1$s),(%1$s)\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));
            e = Pattern.compile(String.format(locale, "\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));
            f = Pattern.compile("\\\\an(\\d+)");
        }

        private static PointF b(String str) {
            String strGroup;
            String strGroup2;
            Matcher matcher = d.matcher(str);
            Matcher matcher2 = e.matcher(str);
            boolean zFind = matcher.find();
            boolean zFind2 = matcher2.find();
            if (zFind) {
                if (zFind2) {
                    at0.c("SsaStyle.Overrides", "Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='" + str + "'");
                }
                strGroup = matcher.group(1);
                strGroup2 = matcher.group(2);
            } else {
                if (!zFind2) {
                    return null;
                }
                strGroup = matcher2.group(1);
                strGroup2 = matcher2.group(2);
            }
            strGroup.getClass();
            float f2 = Float.parseFloat(strGroup.trim());
            strGroup2.getClass();
            return new PointF(f2, Float.parseFloat(strGroup2.trim()));
        }

        public static String c(String str) {
            return c.matcher(str).replaceAll("");
        }

        private b(int i, PointF pointF) {
            this.f8356a = i;
            this.b = pointF;
        }

        public static b a(String str) {
            int i;
            Matcher matcher = c.matcher(str);
            PointF pointF = null;
            int i2 = -1;
            while (matcher.find()) {
                String strGroup = matcher.group(1);
                strGroup.getClass();
                try {
                    PointF pointFB = b(strGroup);
                    if (pointFB != null) {
                        pointF = pointFB;
                    }
                } catch (RuntimeException unused) {
                }
                try {
                    Matcher matcher2 = f.matcher(strGroup);
                    if (matcher2.find()) {
                        String strGroup2 = matcher2.group(1);
                        strGroup2.getClass();
                        try {
                            i = Integer.parseInt(strGroup2.trim());
                            switch (i) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                    break;
                                default:
                                    at0.d("SsaStyle", "Ignoring unknown alignment: " + strGroup2);
                                    break;
                            }
                        } catch (NumberFormatException unused2) {
                        }
                        i = -1;
                    } else {
                        i = -1;
                    }
                    if (i != -1) {
                        i2 = i;
                    } else {
                        continue;
                    }
                } catch (RuntimeException unused3) {
                }
            }
            return new b(i2, pointF);
        }
    }

    private static boolean a(String str) {
        try {
            int i = Integer.parseInt(str);
            return i == 1 || i == -1;
        } catch (NumberFormatException e) {
            at0.b("SsaStyle", "Failed to parse boolean value: '" + str + "'", e);
            return false;
        }
    }
}
