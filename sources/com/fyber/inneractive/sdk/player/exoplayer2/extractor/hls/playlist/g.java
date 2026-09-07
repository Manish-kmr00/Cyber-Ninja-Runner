package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.player.exoplayer2.o;
import com.fyber.inneractive.sdk.player.exoplayer2.r;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.C;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public final class g implements C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f2020a = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
    public static final Pattern b = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
    public static final Pattern c = Pattern.compile("CODECS=\"(.+?)\"");
    public static final Pattern d = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    public static final Pattern e = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    public static final Pattern f = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    public static final Pattern g = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
    public static final Pattern h = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    public static final Pattern i = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    public static final Pattern j = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    public static final Pattern k = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    public static final Pattern l = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    public static final Pattern m = Pattern.compile("METHOD=(NONE|AES-128)");
    public static final Pattern n = Pattern.compile("URI=\"(.+?)\"");
    public static final Pattern o = Pattern.compile("IV=([^,.*]+)");
    public static final Pattern p = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    public static final Pattern q = Pattern.compile("LANGUAGE=\"(.+?)\"");
    public static final Pattern r = Pattern.compile("NAME=\"(.+?)\"");
    public static final Pattern s = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    public static final Pattern t = Pattern.compile("AUTOSELECT".concat("=(NO|YES)"));
    public static final Pattern u = Pattern.compile("DEFAULT".concat("=(NO|YES)"));
    public static final Pattern v = Pattern.compile("FORCED".concat("=(NO|YES)"));

    /* JADX WARN: Multi-variable type inference failed */
    public static d b(f fVar, String str) throws r {
        String str2;
        int i2;
        String hexString;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i3 = 0;
        int i4 = 1;
        String str3 = null;
        long j2 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        boolean z = false;
        int i9 = 0;
        int i10 = 0;
        boolean zEquals = false;
        int i11 = 1;
        c cVar = null;
        String strA = null;
        String strB = null;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        long j7 = -9223372036854775807L;
        long j8 = -9223372036854775807L;
        while (true) {
            long j9 = -1;
            while (true) {
                if (!fVar.a()) {
                    return new d(i5, str, j7, j3, i6, i7, i8, i11, j8, z, j3 != 0, cVar, arrayList, arrayList2);
                }
                if (fVar.a()) {
                    str2 = fVar.c;
                    fVar.c = str3;
                } else {
                    str2 = str3;
                }
                if (str2.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                    String strB2 = b(str2, g);
                    if ("VOD".equals(strB2)) {
                        i5 = i4;
                    } else if ("EVENT".equals(strB2)) {
                        i5 = 2;
                    } else {
                        i3 = 0;
                        i4 = 1;
                        str3 = null;
                        j2 = 0;
                    }
                    str3 = null;
                } else {
                    if (str2.startsWith("#EXT-X-START")) {
                        j7 = (long) (Double.parseDouble(b(str2, j)) * 1000000.0d);
                    } else {
                        if (str2.startsWith("#EXT-X-MAP")) {
                            break;
                        }
                        if (str2.startsWith("#EXT-X-TARGETDURATION")) {
                            j8 = ((long) Integer.parseInt(b(str2, e))) * 1000000;
                        } else if (str2.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                            i9 = Integer.parseInt(b(str2, h));
                            i8 = i9;
                        } else if (str2.startsWith("#EXT-X-VERSION")) {
                            i11 = Integer.parseInt(b(str2, f));
                        } else if (str2.startsWith("#EXTINF")) {
                            j6 = (long) (Double.parseDouble(b(str2, i)) * 1000000.0d);
                        } else if (str2.startsWith("#EXT-X-KEY")) {
                            zEquals = "AES-128".equals(b(str2, m));
                            if (zEquals) {
                                strB = b(str2, n);
                                strA = a(str2, o);
                            } else {
                                str3 = null;
                                strA = null;
                                strB = null;
                            }
                        } else if (str2.startsWith("#EXT-X-BYTERANGE")) {
                            String[] strArrSplit = b(str2, k).split("@");
                            j9 = Long.parseLong(strArrSplit[i3]);
                            if (strArrSplit.length > i4) {
                                j4 = Long.parseLong(strArrSplit[i4]);
                            }
                        } else if (str2.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                            i7 = Integer.parseInt(str2.substring(str2.indexOf(58) + i4));
                            i6 = i4;
                        } else if (str2.equals("#EXT-X-DISCONTINUITY")) {
                            i10++;
                        } else {
                            if (str2.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                                if (j3 == j2) {
                                    String strSubstring = str2.substring(str2.indexOf(58) + i4);
                                    Matcher matcher = z.f.matcher(strSubstring);
                                    if (!matcher.matches()) {
                                        throw new r("Invalid date/time format: " + strSubstring);
                                    }
                                    if (matcher.group(9) == null || matcher.group(9).equalsIgnoreCase("Z")) {
                                        i2 = i3;
                                    } else {
                                        i2 = Integer.parseInt(matcher.group(13)) + (Integer.parseInt(matcher.group(12)) * 60);
                                        if (matcher.group(11).equals("-")) {
                                            i2 *= -1;
                                        }
                                    }
                                    GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
                                    gregorianCalendar.clear();
                                    gregorianCalendar.set(Integer.parseInt(matcher.group(i4)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
                                    if (!TextUtils.isEmpty(matcher.group(8))) {
                                        gregorianCalendar.set(14, new BigDecimal("0." + matcher.group(8)).movePointRight(3).intValue());
                                    }
                                    long timeInMillis = gregorianCalendar.getTimeInMillis();
                                    if (i2 != 0) {
                                        timeInMillis -= (long) (i2 * 60000);
                                    }
                                    int i12 = com.fyber.inneractive.sdk.player.exoplayer2.b.f1989a;
                                    j3 = (timeInMillis == -9223372036854775807L ? -9223372036854775807L : timeInMillis * 1000) - j5;
                                }
                            } else if (str2.startsWith("#EXT-X-DATERANGE")) {
                                arrayList2.add(str2);
                            } else if (!str2.startsWith("#")) {
                                if (zEquals) {
                                    hexString = strA != null ? strA : Integer.toHexString(i9);
                                } else {
                                    hexString = null;
                                }
                                int i13 = i9 + 1;
                                if (j9 == -1) {
                                    j4 = 0;
                                }
                                arrayList.add(new c(str2, j6, i10, j5, zEquals, strB, hexString, j4, j9));
                                j5 += j6;
                                if (j9 != -1) {
                                    j4 += j9;
                                }
                                i9 = i13;
                                j9 = -1;
                                i3 = 0;
                                i4 = 1;
                                str3 = null;
                                j2 = 0;
                                j6 = 0;
                            } else if (str2.equals("#EXT-X-ENDLIST")) {
                                i3 = 0;
                                i4 = 1;
                                str3 = null;
                                j2 = 0;
                                z = true;
                            }
                            i3 = 0;
                            i4 = 1;
                            str3 = null;
                            j2 = 0;
                        }
                    }
                    str3 = null;
                }
            }
            String strB3 = b(str2, n);
            String strA2 = a(str2, l);
            if (strA2 != null) {
                String[] strArrSplit2 = strA2.split("@");
                j9 = Long.parseLong(strArrSplit2[i3]);
                if (strArrSplit2.length > i4) {
                    j4 = Long.parseLong(strArrSplit2[i4]);
                }
            }
            cVar = new c(strB3, 0L, -1, -9223372036854775807L, false, null, null, j4, j9);
            j4 = j2;
            str3 = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003d A[Catch: all -> 0x0101, TryCatch #0 {all -> 0x0101, blocks: (B:3:0x000f, B:5:0x0017, B:7:0x001f, B:9:0x0027, B:34:0x006b, B:35:0x0072, B:12:0x002e, B:14:0x0034, B:18:0x003d, B:20:0x0045, B:23:0x0052, B:25:0x0058, B:29:0x005f, B:30:0x0064, B:36:0x0073, B:38:0x0079, B:41:0x0084, B:43:0x008c, B:44:0x009d, B:46:0x00a5, B:48:0x00ad, B:50:0x00b5, B:52:0x00bd, B:54:0x00c5, B:56:0x00cd, B:58:0x00d5, B:61:0x00de, B:62:0x00e2), top: B:70:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0045 A[Catch: all -> 0x0101, LOOP:1: B:16:0x003a->B:20:0x0045, LOOP_END, TryCatch #0 {all -> 0x0101, blocks: (B:3:0x000f, B:5:0x0017, B:7:0x001f, B:9:0x0027, B:34:0x006b, B:35:0x0072, B:12:0x002e, B:14:0x0034, B:18:0x003d, B:20:0x0045, B:23:0x0052, B:25:0x0058, B:29:0x005f, B:30:0x0064, B:36:0x0073, B:38:0x0079, B:41:0x0084, B:43:0x008c, B:44:0x009d, B:46:0x00a5, B:48:0x00ad, B:50:0x00b5, B:52:0x00bd, B:54:0x00c5, B:56:0x00cd, B:58:0x00d5, B:61:0x00de, B:62:0x00e2), top: B:70:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:75:0x006b A[SYNTHETIC] */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:22:0x0050
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e a(android.net.Uri r7, com.fyber.inneractive.sdk.player.exoplayer2.upstream.j r8) {
        /*
            Method dump skipped, instruction units count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.g.a(android.net.Uri, com.fyber.inneractive.sdk.player.exoplayer2.upstream.j):com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:32:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:72:0x021b  */
    /* JADX WARN: Multi-variable type inference failed */
    public static b a(f fVar, String str) throws r {
        String str2;
        int i2;
        String str3;
        int i3;
        int i4;
        String str4;
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        o oVar = null;
        ArrayList arrayList4 = null;
        boolean zContains = false;
        while (fVar.a()) {
            if (fVar.a()) {
                str2 = fVar.c;
                fVar.c = null;
            } else {
                str2 = null;
            }
            if (str2.startsWith("#EXT-X-MEDIA")) {
                Matcher matcher = u.matcher(str2);
                boolean zEquals = matcher.find() ? matcher.group(1).equals("YES") : 0;
                Matcher matcher2 = v.matcher(str2);
                int i5 = zEquals | (matcher2.find() ? matcher2.group(1).equals("YES") : false ? 2 : 0);
                Matcher matcher3 = t.matcher(str2);
                int i6 = i5 | (matcher3.find() ? matcher3.group(1).equals("YES") : false ? 4 : 0);
                String strA = a(str2, n);
                String strB = b(str2, r);
                String strA2 = a(str2, q);
                String strB2 = b(str2, p);
                strB2.getClass();
                strB2.hashCode();
                switch (strB2) {
                    case "SUBTITLES":
                        arrayList3.add(new a(strA, new o(strB, "application/x-mpegURL", "text/vtt", null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i6, strA2, -1, Long.MAX_VALUE, null, null, null)));
                        break;
                    case "CLOSED-CAPTIONS":
                        String strB3 = b(str2, s);
                        if (strB3.startsWith("CC")) {
                            i2 = Integer.parseInt(strB3.substring(2));
                            str3 = "application/cea-608";
                        } else {
                            i2 = Integer.parseInt(strB3.substring(7));
                            str3 = "application/cea-708";
                        }
                        int i7 = i2;
                        String str5 = str3;
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList();
                        }
                        arrayList4.add(new o(strB, null, str5, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i6, strA2, i7, Long.MAX_VALUE, null, null, null));
                        break;
                    case "AUDIO":
                        o oVar2 = new o(strB, "application/x-mpegURL", null, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i6, strA2, -1, Long.MAX_VALUE, null, null, null);
                        if (strA != null) {
                            arrayList2.add(new a(strA, oVar2));
                            break;
                        } else {
                            oVar = oVar2;
                            break;
                        }
                        break;
                }
            } else if (str2.startsWith("#EXT-X-STREAM-INF")) {
                int i8 = Integer.parseInt(b(str2, b));
                String strA3 = a(str2, f2020a);
                if (strA3 != null) {
                    i8 = Integer.parseInt(strA3);
                }
                int i9 = i8;
                String strA4 = a(str2, c);
                String strA5 = a(str2, d);
                zContains |= str2.contains("CLOSED-CAPTIONS=NONE");
                if (strA5 != null) {
                    String[] strArrSplit = strA5.split(VastAttributes.HORIZONTAL_POSITION);
                    int i10 = Integer.parseInt(strArrSplit[0]);
                    int i11 = Integer.parseInt(strArrSplit[1]);
                    if (i10 <= 0 || i11 <= 0) {
                        i3 = -1;
                        i4 = -1;
                    } else {
                        i4 = i11;
                        i3 = i10;
                    }
                } else {
                    i3 = -1;
                    i4 = -1;
                }
                if (fVar.a()) {
                    str4 = fVar.c;
                    fVar.c = null;
                } else {
                    str4 = null;
                }
                if (hashSet.add(str4)) {
                    arrayList.add(new a(str4, new o(Integer.toString(arrayList.size()), "application/x-mpegURL", null, strA4, i9, -1, i3, i4, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, null, null)));
                }
            }
        }
        return new b(str, arrayList, arrayList2, arrayList3, oVar, zContains ? Collections.emptyList() : arrayList4);
    }

    public static String b(String str, Pattern pattern) throws r {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find() && matcher.groupCount() == 1) {
            return matcher.group(1);
        }
        throw new r("Couldn't match " + pattern.pattern() + " in " + str);
    }

    public static String a(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}
