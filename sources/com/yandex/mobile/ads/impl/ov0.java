package com.yandex.mobile.ads.impl;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.google.common.base.Ascii;
import com.smaato.sdk.core.dns.DnsName;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import net.pubnative.lite.sdk.models.Protocol;

/* JADX INFO: loaded from: classes13.dex */
public final class ov0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final pv0 f9861a;
    private static final Pattern b;
    private static final HashMap<a, List<gv0>> c;
    private static final String d;
    private static final String e;
    private static final String f;
    private static final String g;
    private static final String h;
    private static final String i;
    private static final String j;
    private static int k;

    public static class b extends Exception {
        private b(Exception exc) {
            super("Failed to query underlying media codecs", exc);
        }
    }

    private interface c {
        int a();

        MediaCodecInfo a(int i);

        boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean b();
    }

    private static final class e implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f9863a;
        private MediaCodecInfo[] b;

        @Override // com.yandex.mobile.ads.impl.ov0.c
        public final boolean b() {
            return true;
        }

        @Override // com.yandex.mobile.ads.impl.ov0.c
        public final int a() {
            if (this.b == null) {
                this.b = new MediaCodecList(this.f9863a).getCodecInfos();
            }
            return this.b.length;
        }

        @Override // com.yandex.mobile.ads.impl.ov0.c
        public final MediaCodecInfo a(int i) {
            if (this.b == null) {
                this.b = new MediaCodecList(this.f9863a).getCodecInfos();
            }
            return this.b[i];
        }

        @Override // com.yandex.mobile.ads.impl.ov0.c
        public final boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureRequired(str);
        }

        public e(boolean z, boolean z2) {
            this.f9863a = (z || z2) ? 1 : 0;
        }

        @Override // com.yandex.mobile.ads.impl.ov0.c
        public final boolean a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    interface f<T> {
        int a(T t);
    }

    static {
        pv0 pv0VarG = jm1.g();
        f9861a = pv0VarG;
        b = Pattern.compile("^\\D?(\\d+)$");
        c = new HashMap<>();
        d = pv0VarG.b();
        e = pv0VarG.c();
        f = pv0VarG.O();
        g = pv0VarG.q();
        h = pv0VarG.r();
        i = pv0VarG.a();
        j = pv0VarG.F();
        k = -1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:134:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:19:0x0064  */
    /* JADX WARN: Code duplicated, block: B:314:0x042d A[Catch: NumberFormatException -> 0x043d, TRY_LEAVE, TryCatch #1 {NumberFormatException -> 0x043d, blocks: (B:284:0x03d4, B:286:0x03e6, B:298:0x0404, B:314:0x042d), top: B:487:0x03d4 }] */
    /* JADX WARN: Code duplicated, block: B:415:0x0645  */
    /* JADX WARN: Code duplicated, block: B:454:0x06d7  */
    /* JADX WARN: Code duplicated, block: B:455:0x06dd  */
    /* JADX WARN: Code duplicated, block: B:456:0x06e0  */
    /* JADX WARN: Code duplicated, block: B:457:0x06e3  */
    /* JADX WARN: Code duplicated, block: B:458:0x06e6  */
    /* JADX WARN: Code duplicated, block: B:459:0x06e9  */
    /* JADX WARN: Code duplicated, block: B:460:0x06ec  */
    /* JADX WARN: Code duplicated, block: B:461:0x06ee  */
    /* JADX WARN: Code duplicated, block: B:462:0x06f1  */
    /* JADX WARN: Code duplicated, block: B:463:0x06f5  */
    /* JADX WARN: Code duplicated, block: B:464:0x06f8  */
    /* JADX WARN: Code duplicated, block: B:465:0x06fb  */
    /* JADX WARN: Code duplicated, block: B:466:0x06fd  */
    /* JADX WARN: Code duplicated, block: B:467:0x0700  */
    /* JADX WARN: Code duplicated, block: B:468:0x0702  */
    /* JADX WARN: Code duplicated, block: B:469:0x0705  */
    /* JADX WARN: Code duplicated, block: B:470:0x0707  */
    /* JADX WARN: Code duplicated, block: B:471:0x0709  */
    /* JADX WARN: Code duplicated, block: B:472:0x070b  */
    /* JADX WARN: Code duplicated, block: B:473:0x070d  */
    /* JADX WARN: Code duplicated, block: B:474:0x070f  */
    /* JADX WARN: Code duplicated, block: B:475:0x0712  */
    /* JADX WARN: Code duplicated, block: B:476:0x0714  */
    /* JADX WARN: Code duplicated, block: B:479:0x0718  */
    /* JADX WARN: Code duplicated, block: B:480:0x071f  */
    /* JADX WARN: Code duplicated, block: B:61:0x00da  */
    /* JADX WARN: Code duplicated, block: B:79:0x0129  */
    public static Pair<Integer, Integer> b(gc0 gc0Var) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Integer num;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Integer num2;
        Integer num3;
        byte b2;
        byte b3;
        String str = gc0Var.j;
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split(DnsName.ESCAPED_DOT);
        int i14 = 2;
        int i15 = 1;
        if ("video/dolby-vision".equals(gc0Var.m)) {
            String str2 = gc0Var.j;
            if (strArrSplit.length < 3) {
                nv0.a("Ignoring malformed Dolby Vision codec string: ", str2, "MediaCodecUtil");
            } else {
                Matcher matcher = b.matcher(strArrSplit[1]);
                if (!matcher.matches()) {
                    nv0.a("Ignoring malformed Dolby Vision codec string: ", str2, "MediaCodecUtil");
                } else {
                    String strGroup = matcher.group(1);
                    if (strGroup != null) {
                        strGroup.hashCode();
                        strGroup.hashCode();
                        switch (strGroup) {
                            case "00":
                                num2 = 1;
                                break;
                            case "01":
                                num2 = 2;
                                break;
                            case "02":
                                num2 = 4;
                                break;
                            case "03":
                                num2 = 8;
                                break;
                            case "04":
                                num2 = 16;
                                break;
                            case "05":
                                num2 = 32;
                                break;
                            case "06":
                                num2 = 64;
                                break;
                            case "07":
                                num2 = 128;
                                break;
                            case "08":
                                num2 = 256;
                                break;
                            case "09":
                                num2 = 512;
                                break;
                            default:
                                num2 = null;
                                break;
                        }
                    } else {
                        num2 = null;
                    }
                    if (num2 == null) {
                        nv0.a("Unknown Dolby Vision profile string: ", strGroup, "MediaCodecUtil");
                    } else {
                        String str3 = strArrSplit[2];
                        if (str3 != null) {
                            str3.hashCode();
                            str3.hashCode();
                            switch (str3.hashCode()) {
                                case 1537:
                                    if (!str3.equals("01")) {
                                        b2 = -1;
                                    } else {
                                        b2 = 0;
                                    }
                                    break;
                                case 1538:
                                    if (!str3.equals("02")) {
                                        b2 = -1;
                                    } else {
                                        b2 = 1;
                                    }
                                    break;
                                case 1539:
                                    if (!str3.equals("03")) {
                                        b2 = -1;
                                    } else {
                                        b2 = 2;
                                    }
                                    break;
                                case 1540:
                                    if (!str3.equals("04")) {
                                        b2 = -1;
                                    } else {
                                        b2 = 3;
                                    }
                                    break;
                                case 1541:
                                    if (!str3.equals("05")) {
                                        b2 = -1;
                                    } else {
                                        b2 = 4;
                                    }
                                    break;
                                case 1542:
                                    if (!str3.equals("06")) {
                                        b2 = -1;
                                    } else {
                                        b2 = 5;
                                    }
                                    break;
                                case 1543:
                                    if (!str3.equals("07")) {
                                        b2 = -1;
                                    } else {
                                        b2 = 6;
                                    }
                                    break;
                                case 1544:
                                    if (!str3.equals("08")) {
                                        b2 = -1;
                                    } else {
                                        b3 = 7;
                                        b2 = b3;
                                    }
                                    break;
                                case 1545:
                                    if (!str3.equals("09")) {
                                        b2 = -1;
                                    } else {
                                        b2 = 8;
                                    }
                                    break;
                                case 1567:
                                    if (!str3.equals("10")) {
                                        b2 = -1;
                                    } else {
                                        b3 = 9;
                                        b2 = b3;
                                    }
                                    break;
                                case 1568:
                                    if (!str3.equals(Protocol.VAST_4_1)) {
                                        b2 = -1;
                                    } else {
                                        b3 = 10;
                                        b2 = b3;
                                    }
                                    break;
                                case 1569:
                                    if (!str3.equals(Protocol.VAST_4_1_WRAPPER)) {
                                        b2 = -1;
                                    } else {
                                        b3 = Ascii.VT;
                                        b2 = b3;
                                    }
                                    break;
                                case 1570:
                                    if (!str3.equals(Protocol.VAST_4_2)) {
                                        b2 = -1;
                                    } else {
                                        b3 = Ascii.FF;
                                        b2 = b3;
                                    }
                                    break;
                                default:
                                    b2 = -1;
                                    break;
                            }
                            switch (b2) {
                                case 0:
                                    num3 = 1;
                                    break;
                                case 1:
                                    num3 = 2;
                                    break;
                                case 2:
                                    num3 = 4;
                                    break;
                                case 3:
                                    num3 = 8;
                                    break;
                                case 4:
                                    num3 = 16;
                                    break;
                                case 5:
                                    num3 = 32;
                                    break;
                                case 6:
                                    num3 = 64;
                                    break;
                                case 7:
                                    num3 = 128;
                                    break;
                                case 8:
                                    num3 = 256;
                                    break;
                                case 9:
                                    num3 = 512;
                                    break;
                                case 10:
                                    num3 = 1024;
                                    break;
                                case 11:
                                    num3 = 2048;
                                    break;
                                case 12:
                                    num3 = 4096;
                                    break;
                                default:
                                    num3 = null;
                                    break;
                            }
                        } else {
                            num3 = null;
                        }
                        if (num3 == null) {
                            nv0.a("Unknown Dolby Vision level string: ", str3, "MediaCodecUtil");
                        } else {
                            return new Pair<>(num2, num3);
                        }
                    }
                }
            }
            return null;
        }
        if (!d.equals(strArrSplit[0]) && !e.equals(strArrSplit[0])) {
            if (f.equals(strArrSplit[0])) {
                String str4 = gc0Var.j;
                if (strArrSplit.length < 3) {
                    nv0.a("Ignoring malformed VP9 codec string: ", str4, "MediaCodecUtil");
                } else {
                    try {
                        int i16 = Integer.parseInt(strArrSplit[1]);
                        int i17 = Integer.parseInt(strArrSplit[2]);
                        if (i16 == 0) {
                            i12 = 1;
                        } else if (i16 == 1) {
                            i12 = 2;
                        } else if (i16 != 2) {
                            i12 = i16 != 3 ? -1 : 8;
                        } else {
                            i12 = 4;
                        }
                        if (i12 == -1) {
                            tr0.a("Unknown VP9 profile: ", i16, "MediaCodecUtil");
                        } else {
                            if (i17 == 10) {
                                i13 = -1;
                            } else {
                                if (i17 == 11) {
                                    i15 = 2;
                                } else if (i17 == 20) {
                                    i15 = 4;
                                } else if (i17 == 21) {
                                    i15 = 8;
                                } else if (i17 == 30) {
                                    i15 = 16;
                                } else if (i17 == 31) {
                                    i15 = 32;
                                } else if (i17 == 40) {
                                    i15 = 64;
                                } else if (i17 == 41) {
                                    i15 = 128;
                                } else if (i17 == 50) {
                                    i15 = 256;
                                } else if (i17 != 51) {
                                    switch (i17) {
                                        case 60:
                                            i13 = -1;
                                            i15 = 2048;
                                            break;
                                        case 61:
                                            i15 = 4096;
                                            break;
                                        case 62:
                                            i13 = -1;
                                            i15 = 8192;
                                            break;
                                        default:
                                            i13 = -1;
                                            i15 = -1;
                                            break;
                                    }
                                } else {
                                    i13 = -1;
                                    i15 = 512;
                                }
                                i13 = -1;
                            }
                            if (i15 == i13) {
                                tr0.a("Unknown VP9 level: ", i17, "MediaCodecUtil");
                            } else {
                                return new Pair<>(Integer.valueOf(i12), Integer.valueOf(i15));
                            }
                        }
                    } catch (NumberFormatException unused) {
                        nv0.a("Ignoring malformed VP9 codec string: ", str4, "MediaCodecUtil");
                    }
                }
                return null;
            }
            if (!g.equals(strArrSplit[0]) && !h.equals(strArrSplit[0])) {
                if (i.equals(strArrSplit[0])) {
                    String str5 = gc0Var.j;
                    pq pqVar = gc0Var.y;
                    if (strArrSplit.length < 4) {
                        nv0.a("Ignoring malformed AV1 codec string: ", str5, "MediaCodecUtil");
                    } else {
                        try {
                            int i18 = Integer.parseInt(strArrSplit[1]);
                            int i19 = Integer.parseInt(strArrSplit[2].substring(0, 2));
                            int i20 = Integer.parseInt(strArrSplit[3]);
                            if (i18 != 0) {
                                tr0.a("Unknown AV1 profile: ", i18, "MediaCodecUtil");
                            } else if (i20 == 8 || i20 == 10) {
                                if (i20 == 8) {
                                    i9 = 1;
                                } else {
                                    i9 = (pqVar == null || !(pqVar.e != null || (i10 = pqVar.d) == 7 || i10 == 6)) ? 2 : 4096;
                                }
                                switch (i19) {
                                    case 0:
                                        i11 = 1;
                                        break;
                                    case 1:
                                        i11 = 2;
                                        break;
                                    case 2:
                                        i11 = 4;
                                        break;
                                    case 3:
                                        i11 = 8;
                                        break;
                                    case 4:
                                        i11 = 16;
                                        break;
                                    case 5:
                                        i11 = 32;
                                        break;
                                    case 6:
                                        i11 = 64;
                                        break;
                                    case 7:
                                        i11 = 128;
                                        break;
                                    case 8:
                                        i11 = 256;
                                        break;
                                    case 9:
                                        i11 = 512;
                                        break;
                                    case 10:
                                        i11 = 1024;
                                        break;
                                    case 11:
                                        i11 = 2048;
                                        break;
                                    case 12:
                                        i11 = 4096;
                                        break;
                                    case 13:
                                        i11 = 8192;
                                        break;
                                    case 14:
                                        i11 = 16384;
                                        break;
                                    case 15:
                                        i11 = 32768;
                                        break;
                                    case 16:
                                        i11 = 65536;
                                        break;
                                    case 17:
                                        i11 = 131072;
                                        break;
                                    case 18:
                                        i11 = 262144;
                                        break;
                                    case 19:
                                        i11 = 524288;
                                        break;
                                    case 20:
                                        i11 = 1048576;
                                        break;
                                    case 21:
                                        i11 = 2097152;
                                        break;
                                    case 22:
                                        i11 = 4194304;
                                        break;
                                    case 23:
                                        i11 = 8388608;
                                        break;
                                    default:
                                        i11 = -1;
                                        break;
                                }
                                if (i11 == -1) {
                                    tr0.a("Unknown AV1 level: ", i19, "MediaCodecUtil");
                                } else {
                                    return new Pair<>(Integer.valueOf(i9), Integer.valueOf(i11));
                                }
                            } else {
                                tr0.a("Unknown AV1 bit depth: ", i20, "MediaCodecUtil");
                            }
                        } catch (NumberFormatException unused2) {
                            nv0.a("Ignoring malformed AV1 codec string: ", str5, "MediaCodecUtil");
                        }
                    }
                    return null;
                }
                if (!j.equals(strArrSplit[0])) {
                    return null;
                }
                String str6 = gc0Var.j;
                if (strArrSplit.length != 3) {
                    nv0.a("Ignoring malformed MP4A codec string: ", str6, "MediaCodecUtil");
                } else {
                    try {
                        if ("audio/mp4a-latm".equals(s01.a(Integer.parseInt(strArrSplit[1], 16)))) {
                            int i21 = Integer.parseInt(strArrSplit[2]);
                            if (i21 == 17) {
                                i7 = 17;
                            } else if (i21 == 20) {
                                i7 = 20;
                            } else if (i21 == 23) {
                                i7 = 23;
                            } else if (i21 == 29) {
                                i7 = 29;
                            } else if (i21 == 39) {
                                i7 = 39;
                            } else if (i21 != 42) {
                                switch (i21) {
                                    case 1:
                                        i7 = 1;
                                        break;
                                    case 2:
                                        i7 = 2;
                                        break;
                                    case 3:
                                        i8 = -1;
                                        i7 = 3;
                                        break;
                                    case 4:
                                        i7 = 4;
                                        break;
                                    case 5:
                                        i8 = -1;
                                        i7 = 5;
                                        break;
                                    case 6:
                                        i8 = -1;
                                        i7 = 6;
                                        break;
                                    default:
                                        i8 = -1;
                                        i7 = -1;
                                        break;
                                }
                                if (i7 != i8) {
                                    return new Pair<>(Integer.valueOf(i7), 0);
                                }
                            } else {
                                i7 = 42;
                            }
                            i8 = -1;
                            if (i7 != i8) {
                                return new Pair<>(Integer.valueOf(i7), 0);
                            }
                        }
                    } catch (NumberFormatException unused3) {
                        nv0.a("Ignoring malformed MP4A codec string: ", str6, "MediaCodecUtil");
                    }
                }
                return null;
            }
            String str7 = gc0Var.j;
            if (strArrSplit.length < 4) {
                nv0.a("Ignoring malformed HEVC codec string: ", str7, "MediaCodecUtil");
            } else {
                Matcher matcher2 = b.matcher(strArrSplit[1]);
                if (!matcher2.matches()) {
                    nv0.a("Ignoring malformed HEVC codec string: ", str7, "MediaCodecUtil");
                } else {
                    String strGroup2 = matcher2.group(1);
                    if ("1".equals(strGroup2)) {
                        i6 = 1;
                    } else if ("2".equals(strGroup2)) {
                        i6 = 2;
                    } else {
                        nv0.a("Unknown HEVC profile string: ", strGroup2, "MediaCodecUtil");
                    }
                    String str8 = strArrSplit[3];
                    if (str8 == null) {
                        num = null;
                    } else {
                        pv0 pv0Var = f9861a;
                        if (pv0Var.A().equals(str8)) {
                            num = 1;
                        } else if (pv0Var.B().equals(str8)) {
                            num = 4;
                        } else if (pv0Var.C().equals(str8)) {
                            num = 16;
                        } else if (pv0Var.D().equals(str8)) {
                            num = 64;
                        } else if (pv0Var.E().equals(str8)) {
                            num = 256;
                        } else if (pv0Var.s().equals(str8)) {
                            num = 1024;
                        } else if (pv0Var.t().equals(str8)) {
                            num = 4096;
                        } else if (pv0Var.u().equals(str8)) {
                            num = 16384;
                        } else if (pv0Var.v().equals(str8)) {
                            num = 65536;
                        } else if (pv0Var.w().equals(str8)) {
                            num = 262144;
                        } else if (pv0Var.x().equals(str8)) {
                            num = 1048576;
                        } else if (pv0Var.y().equals(str8)) {
                            num = 4194304;
                        } else if (pv0Var.z().equals(str8)) {
                            num = 16777216;
                        } else if (pv0Var.l().equals(str8)) {
                            num = 2;
                        } else if (pv0Var.m().equals(str8)) {
                            num = 8;
                        } else if (pv0Var.n().equals(str8)) {
                            num = 32;
                        } else if (pv0Var.o().equals(str8)) {
                            num = 128;
                        } else if (pv0Var.p().equals(str8)) {
                            num = 512;
                        } else if (pv0Var.d().equals(str8)) {
                            num = 2048;
                        } else if (pv0Var.e().equals(str8)) {
                            num = 8192;
                        } else if (pv0Var.f().equals(str8)) {
                            num = 32768;
                        } else if (pv0Var.g().equals(str8)) {
                            num = 131072;
                        } else if (pv0Var.h().equals(str8)) {
                            num = 524288;
                        } else if (pv0Var.i().equals(str8)) {
                            num = 2097152;
                        } else if (pv0Var.j().equals(str8)) {
                            num = 8388608;
                        } else if (pv0Var.k().equals(str8)) {
                            num = 33554432;
                        } else {
                            num = null;
                        }
                    }
                    if (num == null) {
                        nv0.a("Unknown HEVC level string: ", str8, "MediaCodecUtil");
                    } else {
                        return new Pair<>(Integer.valueOf(i6), num);
                    }
                }
            }
            return null;
        }
        String str9 = gc0Var.j;
        if (strArrSplit.length < 2) {
            nv0.a("Ignoring malformed AVC codec string: ", str9, "MediaCodecUtil");
        } else {
            try {
                if (strArrSplit[1].length() == 6) {
                    i2 = Integer.parseInt(strArrSplit[1].substring(0, 2), 16);
                    i3 = Integer.parseInt(strArrSplit[1].substring(4), 16);
                } else if (strArrSplit.length >= 3) {
                    i2 = Integer.parseInt(strArrSplit[1]);
                    i3 = Integer.parseInt(strArrSplit[2]);
                } else {
                    at0.d("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str9);
                }
                if (i2 != 66) {
                    if (i2 != 77) {
                        if (i2 == 88) {
                            i14 = 4;
                        } else if (i2 == 100) {
                            i4 = -1;
                            i14 = 8;
                        } else if (i2 == 110) {
                            i14 = 16;
                        } else if (i2 == 122) {
                            i14 = 32;
                        } else if (i2 != 244) {
                            i4 = -1;
                            i14 = -1;
                        } else {
                            i14 = 64;
                        }
                    }
                    if (i14 == i4) {
                        tr0.a("Unknown AVC profile: ", i2, "MediaCodecUtil");
                    } else {
                        switch (i3) {
                            case 10:
                                i5 = 1;
                                break;
                            case 11:
                                i5 = 4;
                                break;
                            case 12:
                                i5 = 8;
                                break;
                            case 13:
                                i5 = 16;
                                break;
                            default:
                                switch (i3) {
                                    case 20:
                                        i5 = 32;
                                        break;
                                    case 21:
                                        i5 = 64;
                                        break;
                                    case 22:
                                        i5 = 128;
                                        break;
                                    default:
                                        switch (i3) {
                                            case 30:
                                                i5 = 256;
                                                break;
                                            case 31:
                                                i5 = 512;
                                                break;
                                            case 32:
                                                i5 = 1024;
                                                break;
                                            default:
                                                switch (i3) {
                                                    case 40:
                                                        i5 = 2048;
                                                        break;
                                                    case 41:
                                                        i5 = 4096;
                                                        break;
                                                    case 42:
                                                        i5 = 8192;
                                                        break;
                                                    default:
                                                        switch (i3) {
                                                            case 50:
                                                                i5 = 16384;
                                                                break;
                                                            case 51:
                                                                i5 = 32768;
                                                                break;
                                                            case 52:
                                                                i5 = 65536;
                                                                break;
                                                            default:
                                                                i5 = -1;
                                                                break;
                                                        }
                                                        break;
                                                }
                                                break;
                                        }
                                        break;
                                }
                                break;
                        }
                        if (i5 == -1) {
                            tr0.a("Unknown AVC level: ", i3, "MediaCodecUtil");
                        } else {
                            return new Pair<>(Integer.valueOf(i14), Integer.valueOf(i5));
                        }
                    }
                } else {
                    i14 = 1;
                }
                i4 = -1;
                if (i14 == i4) {
                    tr0.a("Unknown AVC profile: ", i2, "MediaCodecUtil");
                } else {
                    switch (i3) {
                        case 10:
                            i5 = 1;
                            break;
                        case 11:
                            i5 = 4;
                            break;
                        case 12:
                            i5 = 8;
                            break;
                        case 13:
                            i5 = 16;
                            break;
                        default:
                            switch (i3) {
                                case 20:
                                    i5 = 32;
                                    break;
                                case 21:
                                    i5 = 64;
                                    break;
                                case 22:
                                    i5 = 128;
                                    break;
                                default:
                                    switch (i3) {
                                        case 30:
                                            i5 = 256;
                                            break;
                                        case 31:
                                            i5 = 512;
                                            break;
                                        case 32:
                                            i5 = 1024;
                                            break;
                                        default:
                                            switch (i3) {
                                                case 40:
                                                    i5 = 2048;
                                                    break;
                                                case 41:
                                                    i5 = 4096;
                                                    break;
                                                case 42:
                                                    i5 = 8192;
                                                    break;
                                                default:
                                                    switch (i3) {
                                                        case 50:
                                                            i5 = 16384;
                                                            break;
                                                        case 51:
                                                            i5 = 32768;
                                                            break;
                                                        case 52:
                                                            i5 = 65536;
                                                            break;
                                                        default:
                                                            i5 = -1;
                                                            break;
                                                    }
                                                    break;
                                            }
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                    if (i5 == -1) {
                        tr0.a("Unknown AVC level: ", i3, "MediaCodecUtil");
                    } else {
                        return new Pair<>(Integer.valueOf(i14), Integer.valueOf(i5));
                    }
                }
            } catch (NumberFormatException unused4) {
                nv0.a("Ignoring malformed AVC codec string: ", str9, "MediaCodecUtil");
            }
        }
        return null;
    }

    public static String a(gc0 gc0Var) {
        Pair<Integer, Integer> pairB;
        if ("audio/eac3-joc".equals(gc0Var.m)) {
            return "audio/eac3";
        }
        if (!"video/dolby-vision".equals(gc0Var.m) || (pairB = b(gc0Var)) == null) {
            return null;
        }
        int iIntValue = ((Integer) pairB.first).intValue();
        if (iIntValue == 16 || iIntValue == 256) {
            return "video/hevc";
        }
        if (iIntValue == 512) {
            return "video/avc";
        }
        return null;
    }

    private static String a(MediaCodecInfo mediaCodecInfo, String str, String str2) {
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals("video/dolby-vision")) {
            pv0 pv0Var = f9861a;
            byte[] bArrA = mv0.a(pv0Var, "T01YLk1TLkhFVkNEVi5EZWNvZGVy", 0, "decode(...)");
            Charset charset = Charsets.UTF_8;
            if (new String(bArrA, charset).equals(str)) {
                return new String(mv0.a(pv0Var, "dmlkZW8vaGV2Y2R2", 0, "decode(...)"), charset);
            }
            if (lv0.a(mv0.a(pv0Var, "T01YLlJUSy52aWRlby5kZWNvZGVy", 0, "decode(...)"), charset, str) || lv0.a(mv0.a(pv0Var, "T01YLnJlYWx0ZWsudmlkZW8uZGVjb2Rlci50dW5uZWxlZA==", 0, "decode(...)"), charset, str)) {
                return new String(mv0.a(pv0Var, "dmlkZW8vZHZfaGV2Yw==", 0, "decode(...)"), charset);
            }
            return null;
        }
        if (str2.equals("audio/alac") && new String(mv0.a(f9861a, "T01YLmxnZS5hbGFjLmRlY29kZXI=", 0, "decode(...)"), Charsets.UTF_8).equals(str)) {
            return "audio/x-lg-alac";
        }
        if (str2.equals("audio/flac") && new String(mv0.a(f9861a, "T01YLmxnZS5mbGFjLmRlY29kZXI=", 0, "decode(...)"), Charsets.UTF_8).equals(str)) {
            return "audio/x-lg-flac";
        }
        if (str2.equals("audio/ac3") && new String(mv0.a(f9861a, "T01YLmxnZS5hYzMuZGVjb2Rlcg==", 0, "decode(...)"), Charsets.UTF_8).equals(str)) {
            return "audio/lg-ac3";
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0192 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:79:0x0166 A[Catch: Exception -> 0x01bc, TRY_ENTER, TryCatch #1 {Exception -> 0x01bc, blocks: (B:3:0x0008, B:5:0x001a, B:7:0x0024, B:82:0x0188, B:10:0x0032, B:13:0x003d, B:76:0x015e, B:79:0x0166, B:81:0x016c, B:83:0x0192, B:84:0x01ba), top: B:91:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:9:0x002a  */
    private static ArrayList<gv0> a(a aVar, c cVar) throws b {
        String strA;
        String str;
        String str2;
        int i2;
        boolean z;
        boolean z2;
        boolean zIsHardwareAccelerated;
        boolean zIsVendor;
        String str3;
        a aVar2 = aVar;
        try {
            ArrayList<gv0> arrayList = new ArrayList<>();
            String str4 = aVar2.f9862a;
            int iA = cVar.a();
            boolean zB = cVar.b();
            int i3 = 0;
            while (i3 < iA) {
                MediaCodecInfo mediaCodecInfoA = cVar.a(i3);
                int i4 = x82.f10629a;
                if (i4 < 29 || !mediaCodecInfoA.isAlias()) {
                    String name = mediaCodecInfoA.getName();
                    if (a(mediaCodecInfoA, name, zB, str4) && (strA = a(mediaCodecInfoA, name, str4)) != null) {
                        try {
                            MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfoA.getCapabilitiesForType(strA);
                            boolean zA = cVar.a("tunneled-playback", strA, capabilitiesForType);
                            boolean zA2 = cVar.a("tunneled-playback", capabilitiesForType);
                            boolean z3 = aVar2.c;
                            if ((z3 || !zA2) && (!z3 || zA)) {
                                boolean zA3 = cVar.a("secure-playback", strA, capabilitiesForType);
                                boolean zA4 = cVar.a("secure-playback", capabilitiesForType);
                                boolean z4 = aVar2.b;
                                if ((z4 || !zA4) && (!z4 || zA3)) {
                                    if (i4 >= 29) {
                                        zIsHardwareAccelerated = mediaCodecInfoA.isHardwareAccelerated();
                                        z2 = true;
                                    } else {
                                        z2 = true;
                                        zIsHardwareAccelerated = !a(mediaCodecInfoA, str4);
                                    }
                                    boolean zA5 = a(mediaCodecInfoA, str4);
                                    if (i4 >= 29) {
                                        zIsVendor = mediaCodecInfoA.isVendor();
                                    } else {
                                        String strB = fg.b(mediaCodecInfoA.getName());
                                        f9861a.getClass();
                                        try {
                                            byte[] bArrDecode = Base64.decode("b214Lmdvb2dsZS4=", 0);
                                            Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
                                            zIsVendor = (strB.startsWith(new String(bArrDecode, Charsets.UTF_8)) || strB.startsWith("c2.android.") || strB.startsWith("c2.google.")) ? false : z2;
                                        } catch (Exception e2) {
                                            e = e2;
                                            str = strA;
                                            str2 = name;
                                            i2 = i3;
                                            z = zB;
                                            if (x82.f10629a > 23) {
                                            }
                                            at0.b("MediaCodecUtil", "Failed to query codec " + str2 + " (" + str + ")");
                                            throw e;
                                        }
                                    }
                                    if (zB && aVar2.b == zA3) {
                                        str = strA;
                                        str3 = name;
                                        i2 = i3;
                                        z = zB;
                                        arrayList.add(gv0.a(name, str4, strA, capabilitiesForType, zIsHardwareAccelerated, zA5, zIsVendor, false));
                                    } else {
                                        if (!zB) {
                                            try {
                                                if (!aVar2.b) {
                                                    str = strA;
                                                    str3 = name;
                                                    i2 = i3;
                                                    z = zB;
                                                    try {
                                                        arrayList.add(gv0.a(name, str4, strA, capabilitiesForType, zIsHardwareAccelerated, zA5, zIsVendor, false));
                                                    } catch (Exception e3) {
                                                        e = e3;
                                                        str2 = str3;
                                                        if (x82.f10629a > 23) {
                                                        }
                                                        at0.b("MediaCodecUtil", "Failed to query codec " + str2 + " (" + str + ")");
                                                        throw e;
                                                    }
                                                }
                                            } catch (Exception e4) {
                                                e = e4;
                                                str = strA;
                                                str3 = name;
                                                i2 = i3;
                                                z = zB;
                                                str2 = str3;
                                                if (x82.f10629a > 23 && !arrayList.isEmpty()) {
                                                    at0.b("MediaCodecUtil", "Skipping codec " + str2 + " (failed to query capabilities)");
                                                    i3 = i2 + 1;
                                                    aVar2 = aVar;
                                                    zB = z;
                                                } else {
                                                    at0.b("MediaCodecUtil", "Failed to query codec " + str2 + " (" + str + ")");
                                                    throw e;
                                                }
                                            }
                                        }
                                        str = strA;
                                        str3 = name;
                                        i2 = i3;
                                        z = zB;
                                        if (!z && zA3) {
                                            try {
                                                str2 = str3;
                                                try {
                                                    arrayList.add(gv0.a(str3 + ".secure", str4, str, capabilitiesForType, zIsHardwareAccelerated, zA5, zIsVendor, true));
                                                    return arrayList;
                                                } catch (Exception e5) {
                                                    e = e5;
                                                    if (x82.f10629a > 23) {
                                                    }
                                                    at0.b("MediaCodecUtil", "Failed to query codec " + str2 + " (" + str + ")");
                                                    throw e;
                                                }
                                            } catch (Exception e6) {
                                                e = e6;
                                                str2 = str3;
                                            }
                                        }
                                    }
                                } else {
                                    i2 = i3;
                                    z = zB;
                                }
                            } else {
                                i2 = i3;
                                z = zB;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            str = strA;
                            str2 = name;
                            i2 = i3;
                            z = zB;
                        }
                    } else {
                        i2 = i3;
                        z = zB;
                    }
                } else {
                    i2 = i3;
                    z = zB;
                }
                i3 = i2 + 1;
                aVar2 = aVar;
                zB = z;
            }
            return arrayList;
        } catch (Exception e8) {
            throw new b(e8);
        }
    }

    private static final class d implements c {
        @Override // com.yandex.mobile.ads.impl.ov0.c
        public final boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return false;
        }

        @Override // com.yandex.mobile.ads.impl.ov0.c
        public final boolean b() {
            return false;
        }

        private d() {
        }

        @Override // com.yandex.mobile.ads.impl.ov0.c
        public final MediaCodecInfo a(int i) {
            return MediaCodecList.getCodecInfoAt(i);
        }

        @Override // com.yandex.mobile.ads.impl.ov0.c
        public final int a() {
            return MediaCodecList.getCodecCount();
        }

        @Override // com.yandex.mobile.ads.impl.ov0.c
        public final boolean a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "secure-playback".equals(str) && "video/avc".equals(str2);
        }
    }

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f9862a;
        public final boolean b;
        public final boolean c;

        public a(String str, boolean z, boolean z2) {
            this.f9862a = str;
            this.b = z;
            this.c = z2;
        }

        public final int hashCode() {
            return ((v3.a(this.f9862a, 31, 31) + (this.b ? 1231 : 1237)) * 31) + (this.c ? 1231 : 1237);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != a.class) {
                return false;
            }
            a aVar = (a) obj;
            return TextUtils.equals(this.f9862a, aVar.f9862a) && this.b == aVar.b && this.c == aVar.c;
        }
    }

    private static boolean a(MediaCodecInfo mediaCodecInfo, String str, boolean z, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z && str.endsWith(".secure"))) {
            return false;
        }
        int i2 = x82.f10629a;
        if (i2 < 21) {
            pv0 pv0Var = f9861a;
            byte[] bArrA = mv0.a(pv0Var, "Q0lQQUFDRGVjb2Rlcg==", 0, "decode(...)");
            Charset charset = Charsets.UTF_8;
            if (new String(bArrA, charset).equals(str) || lv0.a(mv0.a(pv0Var, "Q0lQTVAzRGVjb2Rlcg==", 0, "decode(...)"), charset, str) || lv0.a(mv0.a(pv0Var, "Q0lQVm9yYmlzRGVjb2Rlcg==", 0, "decode(...)"), charset, str) || lv0.a(mv0.a(pv0Var, "Q0lQQU1STkJEZWNvZGVy", 0, "decode(...)"), charset, str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str)) {
                return false;
            }
        }
        if (i2 < 18) {
            pv0 pv0Var2 = f9861a;
            byte[] bArrA2 = mv0.a(pv0Var2, "T01YLk1USy5BVURJTy5ERUNPREVSLkFBQw==", 0, "decode(...)");
            Charset charset2 = Charsets.UTF_8;
            if (new String(bArrA2, charset2).equals(str)) {
                String str3 = new String(mv0.a(pv0Var2, "YTcw", 0, "decode(...)"), charset2);
                String str4 = x82.b;
                if (str3.equals(str4) || (new String(mv0.a(pv0Var2, "WGlhb21p", 0, "decode(...)"), charset2).equals(x82.c) && str4.startsWith(new String(mv0.a(pv0Var2, "SE0=", 0, "decode(...)"), charset2)))) {
                    return false;
                }
            }
        }
        if (i2 == 16) {
            pv0 pv0Var3 = f9861a;
            byte[] bArrA3 = mv0.a(pv0Var3, "T01YLnFjb20uYXVkaW8uZGVjb2Rlci5tcDM=", 0, "decode(...)");
            Charset charset3 = Charsets.UTF_8;
            if (new String(bArrA3, charset3).equals(str)) {
                String str5 = new String(mv0.a(pv0Var3, "ZGx4dQ==", 0, "decode(...)"), charset3);
                String str6 = x82.b;
                if (str5.equals(str6) || lv0.a(mv0.a(pv0Var3, "cHJvdG91", 0, "decode(...)"), charset3, str6) || lv0.a(mv0.a(pv0Var3, "dmlsbGU=", 0, "decode(...)"), charset3, str6) || lv0.a(mv0.a(pv0Var3, "dmlsbGVwbHVz", 0, "decode(...)"), charset3, str6) || lv0.a(mv0.a(pv0Var3, "dmlsbGVjMg==", 0, "decode(...)"), charset3, str6) || str6.startsWith(new String(mv0.a(pv0Var3, "Z2Vl", 0, "decode(...)"), charset3)) || lv0.a(mv0.a(pv0Var3, "QzY2MDI=", 0, "decode(...)"), charset3, str6) || lv0.a(mv0.a(pv0Var3, "QzY2MDM=", 0, "decode(...)"), charset3, str6) || lv0.a(mv0.a(pv0Var3, "QzY2MDY=", 0, "decode(...)"), charset3, str6) || lv0.a(mv0.a(pv0Var3, "QzY2MTY=", 0, "decode(...)"), charset3, str6) || lv0.a(mv0.a(pv0Var3, "TDM2aA==", 0, "decode(...)"), charset3, str6) || lv0.a(mv0.a(pv0Var3, "U08tMDJF", 0, "decode(...)"), charset3, str6)) {
                    return false;
                }
            }
        }
        if (i2 == 16) {
            pv0 pv0Var4 = f9861a;
            byte[] bArrA4 = mv0.a(pv0Var4, "T01YLnFjb20uYXVkaW8uZGVjb2Rlci5hYWM=", 0, "decode(...)");
            Charset charset4 = Charsets.UTF_8;
            if (new String(bArrA4, charset4).equals(str)) {
                String str7 = new String(mv0.a(pv0Var4, "QzE1MDQ=", 0, "decode(...)"), charset4);
                String str8 = x82.b;
                if (str7.equals(str8) || lv0.a(mv0.a(pv0Var4, "QzE1MDU=", 0, "decode(...)"), charset4, str8) || lv0.a(mv0.a(pv0Var4, "QzE2MDQ=", 0, "decode(...)"), charset4, str8) || lv0.a(mv0.a(pv0Var4, "QzE2MDU=", 0, "decode(...)"), charset4, str8)) {
                    return false;
                }
            }
        }
        if (i2 < 24) {
            pv0 pv0Var5 = f9861a;
            byte[] bArrA5 = mv0.a(pv0Var5, "T01YLlNFQy5hYWMuZGVj", 0, "decode(...)");
            Charset charset5 = Charsets.UTF_8;
            if ((new String(bArrA5, charset5).equals(str) || lv0.a(mv0.a(pv0Var5, "T01YLkV4eW5vcy5BQUMuRGVjb2Rlcg==", 0, "decode(...)"), charset5, str)) && new String(mv0.a(pv0Var5, "c2Ftc3VuZw==", 0, "decode(...)"), charset5).equals(x82.c)) {
                String str9 = x82.b;
                if (str9.startsWith(new String(mv0.a(pv0Var5, "emVyb2ZsdGU=", 0, "decode(...)"), charset5)) || str9.startsWith(new String(mv0.a(pv0Var5, "emVyb2x0ZQ==", 0, "decode(...)"), charset5)) || str9.startsWith(new String(mv0.a(pv0Var5, "emVubHRl", 0, "decode(...)"), charset5)) || lv0.a(mv0.a(pv0Var5, "U0MtMDVH", 0, "decode(...)"), charset5, str9) || lv0.a(mv0.a(pv0Var5, "bWFyaW5lbHRlYXR0", 0, "decode(...)"), charset5, str9) || lv0.a(mv0.a(pv0Var5, "NDA0U0M=", 0, "decode(...)"), charset5, str9) || lv0.a(mv0.a(pv0Var5, "U0MtMDRH", 0, "decode(...)"), charset5, str9) || lv0.a(mv0.a(pv0Var5, "U0NWMzE=", 0, "decode(...)"), charset5, str9)) {
                    return false;
                }
            }
        }
        if (i2 <= 19) {
            pv0 pv0Var6 = f9861a;
            byte[] bArrA6 = mv0.a(pv0Var6, "T01YLlNFQy52cDguZGVj", 0, "decode(...)");
            Charset charset6 = Charsets.UTF_8;
            if (new String(bArrA6, charset6).equals(str) && new String(mv0.a(pv0Var6, "c2Ftc3VuZw==", 0, "decode(...)"), charset6).equals(x82.c)) {
                String str10 = x82.b;
                if (str10.startsWith("d2") || str10.startsWith(new String(mv0.a(pv0Var6, "c2VycmFubw==", 0, "decode(...)"), charset6)) || str10.startsWith(new String(mv0.a(pv0Var6, "amZsdGU=", 0, "decode(...)"), charset6)) || str10.startsWith(new String(mv0.a(pv0Var6, "c2FudG9z", 0, "decode(...)"), charset6)) || str10.startsWith(new String(mv0.a(pv0Var6, "dDA=", 0, "decode(...)"), charset6))) {
                    return false;
                }
            }
        }
        if (i2 <= 19) {
            String str11 = x82.b;
            pv0 pv0Var7 = f9861a;
            byte[] bArrA7 = mv0.a(pv0Var7, "amZsdGU=", 0, "decode(...)");
            Charset charset7 = Charsets.UTF_8;
            if (str11.startsWith(new String(bArrA7, charset7)) && lv0.a(mv0.a(pv0Var7, "T01YLnFjb20udmlkZW8uZGVjb2Rlci52cDg=", 0, "decode(...)"), charset7, str)) {
                return false;
            }
        }
        return (i2 <= 23 && "audio/eac3-joc".equals(str2) && new String(mv0.a(f9861a, "T01YLk1USy5BVURJTy5ERUNPREVSLkRTUEFDMw==", 0, "decode(...)"), Charsets.UTF_8).equals(str)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int b(gv0 gv0Var) {
        return gv0Var.f9037a.startsWith(f9861a.K()) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(gv0 gv0Var) {
        String str = gv0Var.f9037a;
        pv0 pv0Var = f9861a;
        if (str.startsWith(pv0Var.K()) || str.startsWith("c2.android")) {
            return 1;
        }
        return (x82.f10629a >= 26 || !str.equals(pv0Var.G())) ? 0 : -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(gc0 gc0Var, gv0 gv0Var) {
        try {
            return gv0Var.a(gc0Var) ? 1 : 0;
        } catch (b unused) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(f fVar, Object obj, Object obj2) {
        return fVar.a(obj2) - fVar.a(obj);
    }

    private static void a(ArrayList arrayList, final f fVar) {
        Collections.sort(arrayList, new Comparator() { // from class: com.yandex.mobile.ads.impl.ov0$$ExternalSyntheticLambda3
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ov0.a(fVar, obj, obj2);
            }
        });
    }

    public static synchronized List<gv0> a(String str, boolean z, boolean z2) throws b {
        c dVar;
        a aVar = new a(str, z, z2);
        HashMap<a, List<gv0>> map = c;
        List<gv0> list = map.get(aVar);
        if (list != null) {
            return list;
        }
        int i2 = x82.f10629a;
        if (i2 >= 21) {
            dVar = new e(z, z2);
        } else {
            dVar = new d();
        }
        ArrayList<gv0> arrayListA = a(aVar, dVar);
        if (z && arrayListA.isEmpty() && 21 <= i2 && i2 <= 23) {
            arrayListA = a(aVar, new d());
            if (!arrayListA.isEmpty()) {
                at0.d("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + arrayListA.get(0).f9037a);
            }
        }
        a(str, arrayListA);
        hk0 hk0VarA = hk0.a((Collection) arrayListA);
        map.put(aVar, hk0VarA);
        return hk0VarA;
    }

    public static ArrayList a(hk0 hk0Var, final gc0 gc0Var) {
        ArrayList arrayList = new ArrayList(hk0Var);
        a(arrayList, new f() { // from class: com.yandex.mobile.ads.impl.ov0$$ExternalSyntheticLambda2
            @Override // com.yandex.mobile.ads.impl.ov0.f
            public final int a(Object obj) {
                return ov0.a(gc0Var, (gv0) obj);
            }
        });
        return arrayList;
    }

    public static int a() throws b {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        int i2;
        if (k == -1) {
            int iMax = 0;
            List<gv0> listA = a("video/avc", false, false);
            gv0 gv0Var = listA.isEmpty() ? null : listA.get(0);
            if (gv0Var != null) {
                MediaCodecInfo.CodecCapabilities codecCapabilities = gv0Var.d;
                if (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) {
                    codecProfileLevelArr = new MediaCodecInfo.CodecProfileLevel[0];
                }
                int length = codecProfileLevelArr.length;
                int iMax2 = 0;
                while (iMax < length) {
                    int i3 = codecProfileLevelArr[iMax].level;
                    if (i3 != 1 && i3 != 2) {
                        switch (i3) {
                            case 8:
                            case 16:
                            case 32:
                                i2 = 101376;
                                break;
                            case 64:
                                i2 = 202752;
                                break;
                            case 128:
                            case 256:
                                i2 = 414720;
                                break;
                            case 512:
                                i2 = 921600;
                                break;
                            case 1024:
                                i2 = 1310720;
                                break;
                            case 2048:
                            case 4096:
                                i2 = 2097152;
                                break;
                            case 8192:
                                i2 = 2228224;
                                break;
                            case 16384:
                                i2 = 5652480;
                                break;
                            case 32768:
                            case 65536:
                                i2 = 9437184;
                                break;
                            case 131072:
                            case 262144:
                            case 524288:
                                i2 = 35651584;
                                break;
                            default:
                                i2 = -1;
                                break;
                        }
                    } else {
                        i2 = 25344;
                    }
                    iMax2 = Math.max(i2, iMax2);
                    iMax++;
                }
                iMax = Math.max(iMax2, x82.f10629a >= 21 ? 345600 : 172800);
            }
            k = iMax;
        }
        return k;
    }

    private static void a(String str, ArrayList arrayList) {
        if ("audio/raw".equals(str)) {
            if (x82.f10629a < 26) {
                String str2 = x82.b;
                pv0 pv0Var = f9861a;
                if (str2.equals(pv0Var.N()) && arrayList.size() == 1 && ((gv0) arrayList.get(0)).f9037a.equals(pv0Var.G())) {
                    arrayList.add(gv0.a(pv0Var.L(), "audio/raw", "audio/raw", null, false, true, false, false));
                }
            }
            a(arrayList, new f() { // from class: com.yandex.mobile.ads.impl.ov0$$ExternalSyntheticLambda0
                @Override // com.yandex.mobile.ads.impl.ov0.f
                public final int a(Object obj) {
                    return ov0.a((gv0) obj);
                }
            });
        }
        int i2 = x82.f10629a;
        if (i2 < 21 && arrayList.size() > 1) {
            String str3 = ((gv0) arrayList.get(0)).f9037a;
            pv0 pv0Var2 = f9861a;
            if (pv0Var2.I().equals(str3) || pv0Var2.H().equals(str3) || pv0Var2.J().equals(str3)) {
                a(arrayList, new f() { // from class: com.yandex.mobile.ads.impl.ov0$$ExternalSyntheticLambda1
                    @Override // com.yandex.mobile.ads.impl.ov0.f
                    public final int a(Object obj) {
                        return ov0.b((gv0) obj);
                    }
                });
            }
        }
        if (i2 >= 32 || arrayList.size() <= 1) {
            return;
        }
        if (f9861a.M().equals(((gv0) arrayList.get(0)).f9037a)) {
            arrayList.add((gv0) arrayList.remove(0));
        }
    }

    private static boolean a(MediaCodecInfo mediaCodecInfo, String str) {
        if (x82.f10629a >= 29) {
            return mediaCodecInfo.isSoftwareOnly();
        }
        if (s01.d(str)) {
            return true;
        }
        String strB = fg.b(mediaCodecInfo.getName());
        if (strB.startsWith("arc.")) {
            return false;
        }
        pv0 pv0Var = f9861a;
        byte[] bArrA = mv0.a(pv0Var, "b214Lmdvb2dsZS4=", 0, "decode(...)");
        Charset charset = Charsets.UTF_8;
        if (strB.startsWith(new String(bArrA, charset)) || strB.startsWith(new String(mv0.a(pv0Var, "b214LmZmbXBlZy4=", 0, "decode(...)"), charset))) {
            return true;
        }
        if ((strB.startsWith(new String(mv0.a(pv0Var, "b214LnNlYy4=", 0, "decode(...)"), charset)) && strB.contains(".sw.")) || strB.equals(new String(mv0.a(pv0Var, "b214LnFjb20udmlkZW8uZGVjb2Rlci5oZXZjc3d2ZGVj", 0, "decode(...)"), charset)) || strB.startsWith("c2.android.") || strB.startsWith("c2.google.")) {
            return true;
        }
        return (strB.startsWith(new String(mv0.a(pv0Var, "b214Lg==", 0, "decode(...)"), charset)) || strB.startsWith("c2.")) ? false : true;
    }
}
