package com.inmobi.media;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.ktor.client.utils.CacheControl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: renamed from: com.inmobi.media.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C3403i {
    public int b;
    public String c;
    public String d;
    public long g;
    public long h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3336a = new Random().nextInt() & Integer.MAX_VALUE;
    public final long e = System.currentTimeMillis();
    public final long f = System.currentTimeMillis();

    public final C3403i a(String url, String locationOnDisk, T8 response, int i, long j) {
        List list;
        boolean z;
        long j2;
        boolean z2;
        long j3;
        long j4;
        long j5;
        String[] strArr;
        int i2;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(locationOnDisk, "locationOnDisk");
        Intrinsics.checkNotNullParameter(response, "response");
        Map map = response.e;
        long jCurrentTimeMillis = System.currentTimeMillis();
        List list2 = map != null ? (List) map.get("Date") : null;
        int i3 = 0;
        long jA = (list2 == null || list2.isEmpty()) ? 0L : a((String) list2.get(0));
        List list3 = map != null ? (List) map.get("Cache-Control") : null;
        if (list3 == null || list3.isEmpty()) {
            list = null;
            z = false;
            j2 = 0;
            z2 = false;
            j3 = 0;
        } else {
            String str = (String) list3.get(0);
            int i4 = 1;
            String[] strArr2 = (String[]) StringsKt.split$default((CharSequence) str, new String[]{StringUtils.COMMA}, false, 0, 6, (Object) null).toArray(new String[0]);
            int length = strArr2.length;
            int i5 = 0;
            z2 = false;
            j2 = 0;
            j3 = 0;
            while (i5 < length) {
                String str2 = strArr2[i5];
                int length2 = str2.length() - i4;
                int i6 = i3;
                int i7 = i6;
                while (i6 <= length2) {
                    boolean z3 = Intrinsics.compare((int) str2.charAt(i7 == 0 ? i6 : length2), 32) <= 0;
                    if (i7 == 0) {
                        if (z3) {
                            i6++;
                        } else {
                            i4 = 1;
                            i7 = 1;
                        }
                    } else {
                        if (!z3) {
                            i4 = 1;
                            break;
                        }
                        length2--;
                    }
                    i4 = 1;
                }
                String strA = Q6.a(length2, i4, str2, i6);
                if (Intrinsics.areEqual(CacheControl.NO_CACHE, strA) || Intrinsics.areEqual(CacheControl.NO_STORE, strA)) {
                    strArr = strArr2;
                    i2 = length;
                } else if (StringsKt.startsWith$default(strA, "max-age=", false, 2, (Object) null)) {
                    try {
                        String strSubstring = strA.substring(8);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                        j2 = Long.parseLong(strSubstring);
                    } catch (Exception unused) {
                        Intrinsics.checkNotNullExpressionValue("j", "access$getTAG$cp(...)");
                    }
                    strArr = strArr2;
                    i2 = length;
                } else {
                    strArr = strArr2;
                    i2 = length;
                    if (StringsKt.startsWith$default(strA, "stale-while-revalidate=", false, 2, (Object) null)) {
                        try {
                            String strSubstring2 = strA.substring(23);
                            Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
                            j3 = Long.parseLong(strSubstring2);
                        } catch (Exception unused2) {
                            Intrinsics.checkNotNullExpressionValue("j", "access$getTAG$cp(...)");
                        }
                    } else if (Intrinsics.areEqual(CacheControl.MUST_REVALIDATE, strA) || Intrinsics.areEqual(CacheControl.PROXY_REVALIDATE, strA)) {
                        z2 = true;
                    }
                }
                i5++;
                length = i2;
                strArr2 = strArr;
                i4 = 1;
                i3 = 0;
            }
            list = null;
            z = true;
        }
        List list4 = map != null ? (List) map.get("Expires") : list;
        long jA2 = (list4 == null || list4.isEmpty()) ? 0L : a((String) list4.get(0));
        if (z) {
            long j6 = 1000;
            j5 = (j2 * j6) + jCurrentTimeMillis;
            if (z2) {
                j4 = j5;
            } else {
                long j7 = (j3 * j6) + j5;
                j4 = j5;
                j5 = j7;
            }
        } else if (1 > jA || jA > jA2) {
            j4 = 0;
            j5 = 0;
        } else {
            j5 = (jA2 - jA) + jCurrentTimeMillis;
            j4 = j5;
        }
        this.c = url;
        this.d = locationOnDisk;
        this.b = i;
        long j8 = (((long) 1000) * j) + jCurrentTimeMillis;
        this.g = j8;
        this.h = j4;
        this.g = Math.min(j8, j5);
        return this;
    }

    public static long a(String str) {
        try {
            Date date = new SimpleDateFormat("EEE,dd MMM yyyy HH:mm:ss z", Locale.ENGLISH).parse(str);
            if (date != null) {
                return date.getTime();
            }
            return 0L;
        } catch (ParseException e) {
            C3339d5 c3339d5 = C3339d5.f3292a;
            P1 event = new P1(e);
            Intrinsics.checkNotNullParameter(event, "event");
            C3339d5.c.a(event);
            return 0L;
        }
    }
}
