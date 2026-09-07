package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.zxing.client.result.ExpandedProductParsedResult;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import com.smaato.sdk.core.mvvm.model.imagead.Extension;
import java.util.HashMap;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: classes3.dex */
public final class gz implements vi, w62 {
    public static final hk0<Long> n = hk0.a(4800000L, 3100000L, 2100000L, 1500000L, 800000L);
    public static final hk0<Long> o = hk0.a(1500000L, 1000000L, 730000L, 440000L, 170000L);
    public static final hk0<Long> p = hk0.a(2200000L, 1400000L, 1100000L, 910000L, 620000L);
    public static final hk0<Long> q = hk0.a(3000000L, 1900000L, 1400000L, 1000000L, 660000L);
    public static final hk0<Long> r = hk0.a(6000000L, 4100000L, 3200000L, 1800000L, 1000000L);
    public static final hk0<Long> s = hk0.a(2800000L, 2400000L, 1600000L, 1100000L, 950000L);
    private static gz t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ik0<Integer, Long> f9045a;
    private final vi.a.C0758a b = new vi.a.C0758a();
    private final a02 c;
    private final hp d;
    private final boolean e;
    private int f;
    private long g;
    private long h;
    private int i;
    private long j;
    private long k;
    private long l;
    private long m;

    public static final class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static HashMap a(String str) {
            int[] iArrA = gz.a(str);
            HashMap map = new HashMap(8);
            map.put(0, 1000000L);
            hk0<Long> hk0Var = gz.n;
            map.put(2, hk0Var.get(iArrA[0]));
            map.put(3, gz.o.get(iArrA[1]));
            map.put(4, gz.p.get(iArrA[2]));
            map.put(5, gz.q.get(iArrA[3]));
            map.put(10, gz.r.get(iArrA[4]));
            map.put(9, gz.s.get(iArrA[5]));
            map.put(7, hk0Var.get(iArrA[0]));
            return map;
        }
    }

    @Override // com.yandex.mobile.ads.impl.vi
    public final gz a() {
        return this;
    }

    private gz(Context context, HashMap map, int i, r32 r32Var, boolean z) {
        this.f9045a = ik0.a(map);
        this.c = new a02(i);
        this.d = r32Var;
        this.e = z;
        if (context == null) {
            this.i = 0;
            this.l = a(0);
            return;
        }
        ad1 ad1VarA = ad1.a(context);
        int iA = ad1VarA.a();
        this.i = iA;
        this.l = a(iA);
        ad1VarA.b(new ad1.b() { // from class: com.yandex.mobile.ads.impl.gz$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.ad1.b
            public final void a(int i2) {
                this.f$0.b(i2);
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.vi
    public final void a(Handler handler, ed edVar) {
        edVar.getClass();
        this.b.a(handler, edVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(int i) {
        int i2 = this.i;
        if (i2 == 0 || this.e) {
            if (i2 == i) {
                return;
            }
            this.i = i;
            if (i != 1 && i != 0 && i != 8) {
                this.l = a(i);
                long jB = this.d.b();
                int i3 = this.f > 0 ? (int) (jB - this.g) : 0;
                long j = this.h;
                long j2 = this.l;
                if (i3 != 0 || j != 0 || j2 != this.m) {
                    this.m = j2;
                    this.b.a(i3, j, j2);
                }
                this.g = jB;
                this.h = 0L;
                this.k = 0L;
                this.j = 0L;
                this.c.b();
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.w62
    public final synchronized void b(uv uvVar, boolean z) {
        if (z) {
            if ((uvVar.i & 8) != 8) {
                if (this.f == 0) {
                    this.g = this.d.b();
                }
                this.f++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static int[] a(String str) {
        str.getClass();
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case 2083:
                if (str.equals("AD")) {
                    b = 0;
                }
                break;
            case 2084:
                if (str.equals("AE")) {
                    b = 1;
                }
                break;
            case 2085:
                if (str.equals("AF")) {
                    b = 2;
                }
                break;
            case 2086:
                if (str.equals("AG")) {
                    b = 3;
                }
                break;
            case 2088:
                if (str.equals("AI")) {
                    b = 4;
                }
                break;
            case 2091:
                if (str.equals("AL")) {
                    b = 5;
                }
                break;
            case 2092:
                if (str.equals("AM")) {
                    b = 6;
                }
                break;
            case 2094:
                if (str.equals("AO")) {
                    b = 7;
                }
                break;
            case 2096:
                if (str.equals("AQ")) {
                    b = 8;
                }
                break;
            case 2097:
                if (str.equals("AR")) {
                    b = 9;
                }
                break;
            case 2098:
                if (str.equals("AS")) {
                    b = 10;
                }
                break;
            case 2099:
                if (str.equals("AT")) {
                    b = Ascii.VT;
                }
                break;
            case 2100:
                if (str.equals("AU")) {
                    b = Ascii.FF;
                }
                break;
            case 2102:
                if (str.equals("AW")) {
                    b = Ascii.CR;
                }
                break;
            case 2103:
                if (str.equals("AX")) {
                    b = Ascii.SO;
                }
                break;
            case 2105:
                if (str.equals("AZ")) {
                    b = Ascii.SI;
                }
                break;
            case IronSourceConstants.IS_CALLBACK_AD_SHOW_ERROR /* 2111 */:
                if (str.equals("BA")) {
                    b = Ascii.DLE;
                }
                break;
            case IronSourceConstants.IS_CALLBACK_AD_DISPLAYED /* 2112 */:
                if (str.equals("BB")) {
                    b = 17;
                }
                break;
            case IronSourceConstants.IS_CALLBACK_AD_CLICKED /* 2114 */:
                if (str.equals("BD")) {
                    b = Ascii.DC2;
                }
                break;
            case IronSourceConstants.IS_CALLBACK_AD_INFO_CHANGED /* 2115 */:
                if (str.equals("BE")) {
                    b = 19;
                }
                break;
            case 2116:
                if (str.equals("BF")) {
                    b = Ascii.DC4;
                }
                break;
            case 2117:
                if (str.equals("BG")) {
                    b = Ascii.NAK;
                }
                break;
            case 2118:
                if (str.equals("BH")) {
                    b = Ascii.SYN;
                }
                break;
            case 2119:
                if (str.equals("BI")) {
                    b = Ascii.ETB;
                }
                break;
            case 2120:
                if (str.equals("BJ")) {
                    b = Ascii.CAN;
                }
                break;
            case 2122:
                if (str.equals("BL")) {
                    b = Ascii.EM;
                }
                break;
            case 2123:
                if (str.equals("BM")) {
                    b = Ascii.SUB;
                }
                break;
            case 2124:
                if (str.equals("BN")) {
                    b = Ascii.ESC;
                }
                break;
            case 2125:
                if (str.equals("BO")) {
                    b = Ascii.FS;
                }
                break;
            case 2127:
                if (str.equals("BQ")) {
                    b = Ascii.GS;
                }
                break;
            case 2129:
                if (str.equals("BS")) {
                    b = Ascii.RS;
                }
                break;
            case 2130:
                if (str.equals("BT")) {
                    b = Ascii.US;
                }
                break;
            case 2133:
                if (str.equals("BW")) {
                    b = 32;
                }
                break;
            case 2135:
                if (str.equals("BY")) {
                    b = 33;
                }
                break;
            case 2136:
                if (str.equals("BZ")) {
                    b = 34;
                }
                break;
            case 2142:
                if (str.equals("CA")) {
                    b = 35;
                }
                break;
            case 2145:
                if (str.equals("CD")) {
                    b = 36;
                }
                break;
            case 2147:
                if (str.equals("CF")) {
                    b = 37;
                }
                break;
            case 2148:
                if (str.equals("CG")) {
                    b = 38;
                }
                break;
            case 2149:
                if (str.equals("CH")) {
                    b = 39;
                }
                break;
            case 2150:
                if (str.equals("CI")) {
                    b = 40;
                }
                break;
            case 2152:
                if (str.equals("CK")) {
                    b = 41;
                }
                break;
            case 2153:
                if (str.equals("CL")) {
                    b = 42;
                }
                break;
            case 2154:
                if (str.equals("CM")) {
                    b = 43;
                }
                break;
            case 2155:
                if (str.equals("CN")) {
                    b = 44;
                }
                break;
            case 2156:
                if (str.equals("CO")) {
                    b = 45;
                }
                break;
            case 2159:
                if (str.equals("CR")) {
                    b = 46;
                }
                break;
            case 2162:
                if (str.equals("CU")) {
                    b = 47;
                }
                break;
            case 2163:
                if (str.equals("CV")) {
                    b = 48;
                }
                break;
            case 2164:
                if (str.equals("CW")) {
                    b = 49;
                }
                break;
            case 2165:
                if (str.equals("CX")) {
                    b = 50;
                }
                break;
            case 2166:
                if (str.equals("CY")) {
                    b = 51;
                }
                break;
            case 2167:
                if (str.equals("CZ")) {
                    b = 52;
                }
                break;
            case 2177:
                if (str.equals("DE")) {
                    b = 53;
                }
                break;
            case 2182:
                if (str.equals("DJ")) {
                    b = 54;
                }
                break;
            case 2183:
                if (str.equals("DK")) {
                    b = 55;
                }
                break;
            case 2185:
                if (str.equals("DM")) {
                    b = 56;
                }
                break;
            case 2187:
                if (str.equals("DO")) {
                    b = 57;
                }
                break;
            case 2198:
                if (str.equals("DZ")) {
                    b = 58;
                }
                break;
            case IronSourceConstants.IS_INSTANCE_INIT_FAILED /* 2206 */:
                if (str.equals("EC")) {
                    b = 59;
                }
                break;
            case 2208:
                if (str.equals("EE")) {
                    b = 60;
                }
                break;
            case 2210:
                if (str.equals("EG")) {
                    b = Base64.padSymbol;
                }
                break;
            case 2221:
                if (str.equals("ER")) {
                    b = 62;
                }
                break;
            case 2222:
                if (str.equals("ES")) {
                    b = 63;
                }
                break;
            case 2223:
                if (str.equals("ET")) {
                    b = SignedBytes.MAX_POWER_OF_TWO;
                }
                break;
            case 2243:
                if (str.equals("FI")) {
                    b = 65;
                }
                break;
            case 2244:
                if (str.equals("FJ")) {
                    b = 66;
                }
                break;
            case 2245:
                if (str.equals("FK")) {
                    b = 67;
                }
                break;
            case 2247:
                if (str.equals("FM")) {
                    b = 68;
                }
                break;
            case 2249:
                if (str.equals("FO")) {
                    b = 69;
                }
                break;
            case 2252:
                if (str.equals("FR")) {
                    b = 70;
                }
                break;
            case 2266:
                if (str.equals("GA")) {
                    b = 71;
                }
                break;
            case 2267:
                if (str.equals("GB")) {
                    b = 72;
                }
                break;
            case 2269:
                if (str.equals("GD")) {
                    b = 73;
                }
                break;
            case 2270:
                if (str.equals("GE")) {
                    b = 74;
                }
                break;
            case 2271:
                if (str.equals("GF")) {
                    b = 75;
                }
                break;
            case 2272:
                if (str.equals("GG")) {
                    b = 76;
                }
                break;
            case 2273:
                if (str.equals("GH")) {
                    b = 77;
                }
                break;
            case 2274:
                if (str.equals("GI")) {
                    b = 78;
                }
                break;
            case 2277:
                if (str.equals("GL")) {
                    b = 79;
                }
                break;
            case 2278:
                if (str.equals("GM")) {
                    b = 80;
                }
                break;
            case 2279:
                if (str.equals("GN")) {
                    b = 81;
                }
                break;
            case 2281:
                if (str.equals("GP")) {
                    b = 82;
                }
                break;
            case 2282:
                if (str.equals("GQ")) {
                    b = 83;
                }
                break;
            case 2283:
                if (str.equals("GR")) {
                    b = 84;
                }
                break;
            case 2285:
                if (str.equals("GT")) {
                    b = 85;
                }
                break;
            case 2286:
                if (str.equals("GU")) {
                    b = 86;
                }
                break;
            case 2288:
                if (str.equals("GW")) {
                    b = 87;
                }
                break;
            case 2290:
                if (str.equals("GY")) {
                    b = 88;
                }
                break;
            case 2307:
                if (str.equals("HK")) {
                    b = 89;
                }
                break;
            case 2314:
                if (str.equals("HR")) {
                    b = 90;
                }
                break;
            case 2316:
                if (str.equals("HT")) {
                    b = 91;
                }
                break;
            case 2317:
                if (str.equals("HU")) {
                    b = 92;
                }
                break;
            case 2331:
                if (str.equals("ID")) {
                    b = 93;
                }
                break;
            case 2332:
                if (str.equals("IE")) {
                    b = 94;
                }
                break;
            case 2339:
                if (str.equals("IL")) {
                    b = 95;
                }
                break;
            case 2340:
                if (str.equals("IM")) {
                    b = 96;
                }
                break;
            case 2341:
                if (str.equals("IN")) {
                    b = 97;
                }
                break;
            case 2342:
                if (str.equals("IO")) {
                    b = 98;
                }
                break;
            case 2344:
                if (str.equals("IQ")) {
                    b = 99;
                }
                break;
            case 2345:
                if (str.equals("IR")) {
                    b = 100;
                }
                break;
            case 2346:
                if (str.equals(IronSourceConstants.INTERSTITIAL_EVENT_TYPE)) {
                    b = 101;
                }
                break;
            case 2347:
                if (str.equals("IT")) {
                    b = 102;
                }
                break;
            case 2363:
                if (str.equals("JE")) {
                    b = 103;
                }
                break;
            case 2371:
                if (str.equals("JM")) {
                    b = 104;
                }
                break;
            case 2373:
                if (str.equals("JO")) {
                    b = 105;
                }
                break;
            case 2374:
                if (str.equals("JP")) {
                    b = 106;
                }
                break;
            case 2394:
                if (str.equals("KE")) {
                    b = 107;
                }
                break;
            case 2396:
                if (str.equals(ExpandedProductParsedResult.KILOGRAM)) {
                    b = 108;
                }
                break;
            case 2397:
                if (str.equals("KH")) {
                    b = 109;
                }
                break;
            case 2398:
                if (str.equals("KI")) {
                    b = 110;
                }
                break;
            case 2402:
                if (str.equals("KM")) {
                    b = 111;
                }
                break;
            case 2403:
                if (str.equals("KN")) {
                    b = 112;
                }
                break;
            case 2405:
                if (str.equals("KP")) {
                    b = 113;
                }
                break;
            case 2407:
                if (str.equals("KR")) {
                    b = 114;
                }
                break;
            case 2412:
                if (str.equals("KW")) {
                    b = 115;
                }
                break;
            case 2414:
                if (str.equals("KY")) {
                    b = 116;
                }
                break;
            case 2415:
                if (str.equals("KZ")) {
                    b = 117;
                }
                break;
            case 2421:
                if (str.equals("LA")) {
                    b = 118;
                }
                break;
            case 2422:
                if (str.equals(ExpandedProductParsedResult.POUND)) {
                    b = 119;
                }
                break;
            case 2423:
                if (str.equals("LC")) {
                    b = 120;
                }
                break;
            case 2429:
                if (str.equals("LI")) {
                    b = 121;
                }
                break;
            case 2431:
                if (str.equals("LK")) {
                    b = 122;
                }
                break;
            case 2438:
                if (str.equals("LR")) {
                    b = 123;
                }
                break;
            case 2439:
                if (str.equals("LS")) {
                    b = 124;
                }
                break;
            case 2440:
                if (str.equals("LT")) {
                    b = 125;
                }
                break;
            case 2441:
                if (str.equals("LU")) {
                    b = 126;
                }
                break;
            case 2442:
                if (str.equals("LV")) {
                    b = 127;
                }
                break;
            case 2445:
                if (str.equals("LY")) {
                    b = 128;
                }
                break;
            case 2452:
                if (str.equals("MA")) {
                    b = 129;
                }
                break;
            case 2454:
                if (str.equals("MC")) {
                    b = 130;
                }
                break;
            case 2455:
                if (str.equals("MD")) {
                    b = 131;
                }
                break;
            case 2456:
                if (str.equals("ME")) {
                    b = 132;
                }
                break;
            case 2457:
                if (str.equals("MF")) {
                    b = 133;
                }
                break;
            case 2458:
                if (str.equals("MG")) {
                    b = 134;
                }
                break;
            case 2459:
                if (str.equals("MH")) {
                    b = 135;
                }
                break;
            case 2462:
                if (str.equals("MK")) {
                    b = 136;
                }
                break;
            case 2463:
                if (str.equals("ML")) {
                    b = 137;
                }
                break;
            case 2464:
                if (str.equals("MM")) {
                    b = 138;
                }
                break;
            case 2465:
                if (str.equals("MN")) {
                    b = 139;
                }
                break;
            case 2466:
                if (str.equals("MO")) {
                    b = 140;
                }
                break;
            case 2467:
                if (str.equals("MP")) {
                    b = 141;
                }
                break;
            case 2468:
                if (str.equals("MQ")) {
                    b = 142;
                }
                break;
            case 2469:
                if (str.equals("MR")) {
                    b = 143;
                }
                break;
            case 2470:
                if (str.equals("MS")) {
                    b = 144;
                }
                break;
            case 2471:
                if (str.equals("MT")) {
                    b = 145;
                }
                break;
            case 2472:
                if (str.equals("MU")) {
                    b = 146;
                }
                break;
            case 2473:
                if (str.equals("MV")) {
                    b = 147;
                }
                break;
            case 2474:
                if (str.equals("MW")) {
                    b = 148;
                }
                break;
            case 2475:
                if (str.equals("MX")) {
                    b = 149;
                }
                break;
            case 2476:
                if (str.equals("MY")) {
                    b = 150;
                }
                break;
            case 2477:
                if (str.equals("MZ")) {
                    b = 151;
                }
                break;
            case 2483:
                if (str.equals("NA")) {
                    b = 152;
                }
                break;
            case 2485:
                if (str.equals("NC")) {
                    b = 153;
                }
                break;
            case 2487:
                if (str.equals("NE")) {
                    b = 154;
                }
                break;
            case 2489:
                if (str.equals("NG")) {
                    b = 155;
                }
                break;
            case 2491:
                if (str.equals("NI")) {
                    b = 156;
                }
                break;
            case 2494:
                if (str.equals("NL")) {
                    b = 157;
                }
                break;
            case 2497:
                if (str.equals("NO")) {
                    b = 158;
                }
                break;
            case 2498:
                if (str.equals("NP")) {
                    b = 159;
                }
                break;
            case 2500:
                if (str.equals("NR")) {
                    b = 160;
                }
                break;
            case 2503:
                if (str.equals("NU")) {
                    b = 161;
                }
                break;
            case 2508:
                if (str.equals("NZ")) {
                    b = 162;
                }
                break;
            case 2526:
                if (str.equals(Extension.OM)) {
                    b = 163;
                }
                break;
            case 2545:
                if (str.equals("PA")) {
                    b = 164;
                }
                break;
            case 2549:
                if (str.equals("PE")) {
                    b = 165;
                }
                break;
            case 2550:
                if (str.equals("PF")) {
                    b = 166;
                }
                break;
            case 2551:
                if (str.equals("PG")) {
                    b = 167;
                }
                break;
            case 2552:
                if (str.equals("PH")) {
                    b = 168;
                }
                break;
            case 2555:
                if (str.equals("PK")) {
                    b = 169;
                }
                break;
            case 2556:
                if (str.equals("PL")) {
                    b = 170;
                }
                break;
            case 2557:
                if (str.equals("PM")) {
                    b = 171;
                }
                break;
            case 2562:
                if (str.equals("PR")) {
                    b = 172;
                }
                break;
            case 2563:
                if (str.equals("PS")) {
                    b = 173;
                }
                break;
            case 2564:
                if (str.equals("PT")) {
                    b = 174;
                }
                break;
            case 2567:
                if (str.equals("PW")) {
                    b = 175;
                }
                break;
            case 2576:
                if (str.equals("QA")) {
                    b = 176;
                }
                break;
            case 2611:
                if (str.equals("RE")) {
                    b = 177;
                }
                break;
            case 2621:
                if (str.equals("RO")) {
                    b = 178;
                }
                break;
            case 2625:
                if (str.equals("RS")) {
                    b = 179;
                }
                break;
            case 2627:
                if (str.equals("RU")) {
                    b = 180;
                }
                break;
            case 2629:
                if (str.equals("RW")) {
                    b = 181;
                }
                break;
            case 2638:
                if (str.equals("SA")) {
                    b = 182;
                }
                break;
            case 2639:
                if (str.equals("SB")) {
                    b = 183;
                }
                break;
            case 2640:
                if (str.equals("SC")) {
                    b = 184;
                }
                break;
            case 2641:
                if (str.equals("SD")) {
                    b = 185;
                }
                break;
            case 2642:
                if (str.equals("SE")) {
                    b = 186;
                }
                break;
            case 2644:
                if (str.equals("SG")) {
                    b = 187;
                }
                break;
            case 2645:
                if (str.equals("SH")) {
                    b = 188;
                }
                break;
            case 2646:
                if (str.equals("SI")) {
                    b = 189;
                }
                break;
            case 2648:
                if (str.equals("SK")) {
                    b = 190;
                }
                break;
            case 2649:
                if (str.equals("SL")) {
                    b = 191;
                }
                break;
            case 2650:
                if (str.equals("SM")) {
                    b = 192;
                }
                break;
            case 2651:
                if (str.equals("SN")) {
                    b = 193;
                }
                break;
            case 2652:
                if (str.equals("SO")) {
                    b = 194;
                }
                break;
            case 2655:
                if (str.equals("SR")) {
                    b = 195;
                }
                break;
            case 2656:
                if (str.equals("SS")) {
                    b = 196;
                }
                break;
            case 2657:
                if (str.equals("ST")) {
                    b = 197;
                }
                break;
            case 2659:
                if (str.equals("SV")) {
                    b = 198;
                }
                break;
            case 2661:
                if (str.equals("SX")) {
                    b = 199;
                }
                break;
            case 2662:
                if (str.equals("SY")) {
                    b = 200;
                }
                break;
            case 2663:
                if (str.equals("SZ")) {
                    b = 201;
                }
                break;
            case 2671:
                if (str.equals("TC")) {
                    b = 202;
                }
                break;
            case 2672:
                if (str.equals("TD")) {
                    b = 203;
                }
                break;
            case 2675:
                if (str.equals("TG")) {
                    b = 204;
                }
                break;
            case 2676:
                if (str.equals("TH")) {
                    b = 205;
                }
                break;
            case 2678:
                if (str.equals("TJ")) {
                    b = 206;
                }
                break;
            case 2679:
                if (str.equals("TK")) {
                    b = 207;
                }
                break;
            case 2680:
                if (str.equals("TL")) {
                    b = 208;
                }
                break;
            case 2681:
                if (str.equals("TM")) {
                    b = 209;
                }
                break;
            case 2682:
                if (str.equals("TN")) {
                    b = 210;
                }
                break;
            case 2683:
                if (str.equals("TO")) {
                    b = 211;
                }
                break;
            case 2686:
                if (str.equals("TR")) {
                    b = 212;
                }
                break;
            case 2688:
                if (str.equals("TT")) {
                    b = 213;
                }
                break;
            case 2690:
                if (str.equals("TV")) {
                    b = 214;
                }
                break;
            case 2691:
                if (str.equals("TW")) {
                    b = 215;
                }
                break;
            case 2694:
                if (str.equals("TZ")) {
                    b = 216;
                }
                break;
            case 2700:
                if (str.equals("UA")) {
                    b = 217;
                }
                break;
            case 2706:
                if (str.equals("UG")) {
                    b = 218;
                }
                break;
            case 2718:
                if (str.equals("US")) {
                    b = 219;
                }
                break;
            case 2724:
                if (str.equals("UY")) {
                    b = 220;
                }
                break;
            case 2725:
                if (str.equals("UZ")) {
                    b = 221;
                }
                break;
            case 2731:
                if (str.equals("VA")) {
                    b = 222;
                }
                break;
            case 2733:
                if (str.equals("VC")) {
                    b = 223;
                }
                break;
            case 2735:
                if (str.equals("VE")) {
                    b = 224;
                }
                break;
            case 2737:
                if (str.equals("VG")) {
                    b = 225;
                }
                break;
            case 2739:
                if (str.equals("VI")) {
                    b = 226;
                }
                break;
            case 2744:
                if (str.equals("VN")) {
                    b = 227;
                }
                break;
            case 2751:
                if (str.equals("VU")) {
                    b = 228;
                }
                break;
            case 2767:
                if (str.equals("WF")) {
                    b = 229;
                }
                break;
            case 2780:
                if (str.equals("WS")) {
                    b = 230;
                }
                break;
            case 2803:
                if (str.equals("XK")) {
                    b = 231;
                }
                break;
            case 2828:
                if (str.equals("YE")) {
                    b = 232;
                }
                break;
            case 2843:
                if (str.equals("YT")) {
                    b = 233;
                }
                break;
            case 2855:
                if (str.equals("ZA")) {
                    b = 234;
                }
                break;
            case 2867:
                if (str.equals("ZM")) {
                    b = 235;
                }
                break;
            case 2877:
                if (str.equals("ZW")) {
                    b = 236;
                }
                break;
        }
        switch (b) {
            case 0:
            case 26:
            case 29:
            case 73:
            case 79:
            case 112:
            case 116:
            case 120:
            case STALE_CACHED_RESPONSE_VALUE:
                return new int[]{1, 2, 0, 0, 2, 2};
            case 1:
                return new int[]{1, 4, 4, 4, 4, 0};
            case 2:
            case 80:
                return new int[]{4, 3, 3, 4, 2, 2};
            case 3:
                return new int[]{2, 4, 1, 2, 2, 2};
            case 4:
                return new int[]{0, 2, 0, 3, 2, 2};
            case 5:
            case 231:
                return new int[]{1, 1, 1, 1, 2, 2};
            case 6:
                return new int[]{2, 3, 2, 3, 2, 2};
            case 7:
                return new int[]{4, 4, 3, 2, 2, 2};
            case 8:
            case 62:
            case 188:
                return new int[]{4, 2, 2, 2, 2, 2};
            case 9:
            case 108:
            case 210:
            case AD_RESPONSE_RETRY_AFTER_VALUE:
                return new int[]{2, 1, 1, 1, 2, 2};
            case 10:
                return new int[]{2, 2, 3, 3, 2, 2};
            case 11:
                return new int[]{1, 0, 1, 1, 0, 0};
            case 12:
                return new int[]{0, 1, 1, 1, 2, 0};
            case 13:
                return new int[]{1, 3, 4, 4, 2, 2};
            case 14:
            case TPAT_ERROR_VALUE:
            case 144:
            case 171:
            case 192:
                return new int[]{0, 2, 2, 2, 2, 2};
            case 15:
            case 75:
            case 128:
            case 169:
            case 194:
            case 211:
                return new int[]{3, 2, 3, 3, 2, 2};
            case 16:
                return new int[]{1, 2, 1, 1, 2, 2};
            case 17:
            case 56:
            case TokenParametersOuterClass$TokenParameters.CHILDMODE_FIELD_NUMBER /* 69 */:
            case 78:
                return new int[]{0, 2, 0, 0, 2, 2};
            case 18:
                return new int[]{2, 1, 3, 3, 2, 2};
            case 19:
                return new int[]{0, 1, 4, 4, 3, 2};
            case 20:
                return new int[]{4, 3, 4, 3, 2, 2};
            case 21:
            case 145:
            case FacebookRequestErrorClassification.EC_INVALID_TOKEN /* 190 */:
                return new int[]{0, 0, 0, 0, 1, 2};
            case 22:
                return new int[]{1, 2, 1, 3, 4, 2};
            case 23:
            case 91:
            case 111:
            case 134:
            case 154:
            case 185:
            case 203:
            case 224:
            case 232:
                return new int[]{4, 4, 4, 4, 2, 2};
            case 24:
                return new int[]{4, 4, 3, 3, 2, 2};
            case 25:
            case 50:
            case INVALID_WATERFALL_PLACEMENT_ID_VALUE:
                return new int[]{1, 2, 2, 2, 2, 2};
            case 27:
            case 49:
                return new int[]{2, 2, 0, 0, 2, 2};
            case 28:
                return new int[]{1, 2, 3, 2, 2, 2};
            case 30:
                return new int[]{4, 4, 2, 2, 2, 2};
            case 31:
                return new int[]{3, 1, 3, 2, 2, 2};
            case 32:
                return new int[]{3, 2, 1, 0, 2, 2};
            case 33:
                return new int[]{0, 1, 2, 3, 2, 2};
            case 34:
                return new int[]{2, 4, 2, 1, 2, 2};
            case 35:
                return new int[]{0, 2, 2, 2, 3, 2};
            case 36:
                return new int[]{4, 2, 3, 2, 2, 2};
            case 37:
            case 110:
                return new int[]{4, 2, 4, 2, 2, 2};
            case 38:
            case 61:
            case 87:
                return new int[]{3, 4, 3, 3, 2, 2};
            case 39:
                return new int[]{0, 0, 0, 1, 0, 2};
            case 40:
            case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
            case INVALID_RI_ENDPOINT_VALUE:
                return new int[]{3, 4, 4, 4, 2, 2};
            case 41:
            case 166:
                return new int[]{2, 2, 2, 1, 2, 2};
            case 42:
            case 95:
                return new int[]{1, 2, 2, 2, 3, 2};
            case 43:
                return new int[]{3, 3, 3, 3, 2, 2};
            case 44:
                return new int[]{2, 0, 1, 1, 3, 2};
            case 45:
                return new int[]{2, 3, 4, 3, 2, 2};
            case 46:
                return new int[]{2, 3, 4, 4, 2, 2};
            case 47:
            case 54:
            case 200:
            case 206:
            case 208:
                return new int[]{4, 3, 4, 4, 2, 2};
            case 48:
                return new int[]{2, 1, 0, 0, 2, 2};
            case 51:
            case 115:
                return new int[]{1, 0, 0, 0, 0, 2};
            case 52:
            case 158:
                return new int[]{0, 0, 2, 0, 1, 2};
            case 53:
                return new int[]{0, 1, 2, 2, 2, 3};
            case 55:
                return new int[]{0, 0, 3, 2, 0, 2};
            case 57:
                return new int[]{3, 4, 4, 4, 4, 2};
            case TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER /* 59 */:
                return new int[]{2, 3, 2, 1, 2, 2};
            case 60:
            case 101:
            case 127:
            case 174:
            case 186:
            case AD_RESPONSE_EMPTY_VALUE:
                return new int[]{0, 0, 0, 0, 0, 2};
            case 63:
            case 94:
                return new int[]{0, 1, 1, 1, 2, 2};
            case 64:
                return new int[]{4, 3, 3, 1, 2, 2};
            case 65:
                return new int[]{0, 0, 0, 3, 0, 2};
            case 66:
                return new int[]{3, 1, 2, 2, 2, 2};
            case 67:
            case 107:
            case 113:
                return new int[]{3, 2, 2, 2, 2, 2};
            case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                return new int[]{4, 2, 4, 1, 2, 2};
            case 70:
                return new int[]{1, 2, 3, 1, 0, 2};
            case 71:
            case 204:
                return new int[]{3, 4, 1, 0, 2, 2};
            case 72:
                return new int[]{0, 0, 1, 1, 1, 1};
            case 74:
                return new int[]{1, 1, 1, 2, 2, 2};
            case 76:
            case 226:
                return new int[]{0, 2, 0, 1, 2, 2};
            case 77:
            case 152:
            case 228:
                return new int[]{3, 3, 3, 2, 2, 2};
            case IronSourceConstants.TROUBLESHOOTING_AD_QUALITY_SDK_INITIALIZED_SUCCESSFULLY_EVENT /* 81 */:
                return new int[]{4, 3, 4, 2, 2, 2};
            case IronSourceConstants.TROUBLESHOOTING_AD_QUALITY_SDK_WAS_ALREADY_INITIALIZED_EVENT /* 82 */:
            case 142:
                return new int[]{2, 1, 2, 3, 2, 2};
            case IronSourceConstants.TROUBLESHOOTING_AD_QUALITY_SDK_FAILED_TO_INITIALIZE_EVENT /* 83 */:
                return new int[]{4, 2, 1, 4, 2, 2};
            case IronSourceConstants.TROUBLESHOOTING_AD_QUALITY_SDK_NOT_EXIST /* 84 */:
            case 90:
            case 189:
                return new int[]{1, 0, 0, 0, 1, 2};
            case 85:
                return new int[]{2, 3, 2, 2, 2, 2};
            case 86:
            case 165:
                return new int[]{1, 2, 4, 4, 4, 2};
            case 88:
                return new int[]{3, 2, 2, 1, 2, 2};
            case 89:
                return new int[]{0, 1, 2, 3, 2, 0};
            case 92:
                return new int[]{0, 0, 0, 1, 3, 2};
            case 93:
                return new int[]{3, 1, 2, 2, 3, 2};
            case 96:
            case AD_RESPONSE_TIMED_OUT_VALUE:
                return new int[]{0, 2, 1, 1, 2, 2};
            case 97:
                return new int[]{1, 1, 3, 2, 3, 3};
            case 98:
            case 135:
            case INVALID_GZIP_BID_PAYLOAD_VALUE:
            case 229:
                return new int[]{4, 2, 2, 4, 2, 2};
            case 99:
                return new int[]{3, 2, 2, 3, 2, 2};
            case 100:
                return new int[]{3, 0, 1, 1, 4, 1};
            case 102:
                return new int[]{0, 0, 0, 1, 1, 2};
            case 103:
            case 233:
                return new int[]{4, 2, 2, 3, 2, 2};
            case 104:
                return new int[]{2, 4, 3, 2, 2, 2};
            case 105:
                return new int[]{2, 1, 1, 2, 2, 2};
            case 106:
                return new int[]{0, 1, 1, 2, 2, 4};
            case 109:
                return new int[]{2, 1, 4, 2, 2, 2};
            case 114:
                return new int[]{0, 1, 1, 3, 4, 4};
            case 117:
                return new int[]{2, 1, 2, 2, 2, 2};
            case PROTOBUF_SERIALIZATION_ERROR_VALUE:
                return new int[]{1, 2, 1, 3, 2, 2};
            case JSON_ENCODE_ERROR_VALUE:
                return new int[]{3, 3, 2, 4, 2, 2};
            case INVALID_ADS_ENDPOINT_VALUE:
                return new int[]{3, 1, 3, 3, 4, 2};
            case INVALID_LOG_ERROR_ENDPOINT_VALUE:
                return new int[]{3, 3, 2, 2, 2, 2};
            case INVALID_METRICS_ENDPOINT_VALUE:
                return new int[]{0, 0, 0, 0, 2, 2};
            case 126:
                return new int[]{1, 0, 3, 2, 1, 4};
            case 129:
                return new int[]{3, 3, 1, 1, 2, 2};
            case 130:
                return new int[]{0, 2, 2, 0, 2, 2};
            case MRAID_JS_WRITE_FAILED_VALUE:
            case 179:
                return new int[]{1, 0, 0, 0, 2, 2};
            case OMSDK_DOWNLOAD_JS_ERROR_VALUE:
                return new int[]{2, 0, 0, 1, 2, 2};
            case OMSDK_JS_WRITE_FAILED_VALUE:
            case 177:
                return new int[]{1, 2, 1, 2, 2, 2};
            case 136:
                return new int[]{1, 0, 0, 1, 3, 2};
            case TPAT_RETRY_FAILED_VALUE:
            case 167:
                return new int[]{4, 3, 3, 2, 2, 2};
            case 138:
                return new int[]{2, 4, 2, 3, 2, 2};
            case 139:
                return new int[]{2, 0, 1, 2, 2, 2};
            case IronSourceConstants.USING_CACHE_FOR_INIT_EVENT /* 140 */:
            case 141:
                return new int[]{0, 2, 4, 4, 2, 2};
            case 143:
            case 236:
                return new int[]{4, 2, 4, 4, 2, 2};
            case POBNativeConstants.POB_NATIVE_MAIN_IMG_H /* 146 */:
                return new int[]{3, 1, 1, 2, 2, 2};
            case 147:
                return new int[]{3, 4, 1, 4, 2, 2};
            case 148:
                return new int[]{4, 2, 3, 3, 2, 2};
            case 149:
                return new int[]{2, 4, 3, 4, 2, 2};
            case 150:
                return new int[]{1, 0, 3, 1, 3, 2};
            case 151:
                return new int[]{3, 1, 2, 1, 2, 2};
            case 153:
                return new int[]{3, 3, 4, 4, 2, 2};
            case 155:
                return new int[]{3, 4, 2, 1, 2, 2};
            case 156:
            case 164:
            case 198:
                return new int[]{2, 3, 3, 3, 2, 2};
            case 157:
                return new int[]{0, 2, 2, 3, 0, 3};
            case 159:
                return new int[]{2, 2, 4, 3, 2, 2};
            case 160:
            case 161:
                return new int[]{4, 2, 2, 1, 2, 2};
            case 162:
            case 170:
                return new int[]{1, 1, 2, 2, 4, 2};
            case 163:
                return new int[]{2, 3, 1, 3, 4, 2};
            case 168:
                return new int[]{2, 1, 3, 3, 3, 0};
            case 172:
                return new int[]{2, 0, 2, 1, 2, 1};
            case 173:
                return new int[]{3, 4, 1, 2, 2, 2};
            case 175:
                return new int[]{2, 2, 4, 1, 2, 2};
            case 176:
                return new int[]{2, 4, 4, 4, 4, 2};
            case 178:
                return new int[]{0, 0, 1, 2, 1, 2};
            case 180:
                return new int[]{1, 0, 0, 0, 4, 3};
            case 181:
                return new int[]{3, 4, 2, 0, 2, 2};
            case 182:
                return new int[]{3, 1, 1, 1, 2, 2};
            case 183:
                return new int[]{4, 2, 4, 3, 2, 2};
            case 184:
            case 209:
                return new int[]{4, 2, 1, 1, 2, 2};
            case 187:
                return new int[]{1, 1, 2, 2, 2, 1};
            case 191:
            case MRAID_JS_DOES_NOT_EXIST_VALUE:
                return new int[]{3, 3, 4, 3, 2, 2};
            case 193:
                return new int[]{4, 4, 4, 3, 2, 2};
            case 195:
                return new int[]{2, 4, 3, 0, 2, 2};
            case 196:
                return new int[]{4, 3, 2, 3, 2, 2};
            case 197:
                return new int[]{2, 2, 1, 2, 2, 2};
            case 199:
            case 202:
                return new int[]{1, 2, 1, 0, 2, 2};
            case 201:
                return new int[]{3, 3, 3, 4, 2, 2};
            case 205:
                return new int[]{0, 2, 2, 3, 3, 4};
            case 207:
                return new int[]{2, 2, 2, 4, 2, 2};
            case 212:
                return new int[]{1, 1, 0, 0, 2, 2};
            case INVALID_ADUNIT_BID_PAYLOAD_VALUE:
                return new int[]{1, 4, 1, 3, 2, 2};
            case AD_RESPONSE_INVALID_TEMPLATE_TYPE_VALUE:
                return new int[]{3, 4, 3, 2, 2, 2};
            case MRAID_JS_COPY_FAILED_VALUE:
                return new int[]{1, 0, 2, 2, 3, 1};
            case AD_LOAD_FAIL_RETRY_AFTER_VALUE:
                return new int[]{2, 2, 3, 4, 2, 2};
            case 225:
                return new int[]{2, 2, 1, 1, 2, 2};
            case 227:
                return new int[]{0, 3, 3, 4, 2, 2};
            case 230:
                return new int[]{3, 1, 3, 1, 2, 2};
            case 234:
                return new int[]{3, 2, 2, 1, 1, 2};
            case 235:
                return new int[]{3, 3, 4, 2, 2, 2};
            default:
                return new int[]{2, 2, 2, 2, 2, 2};
        }
    }

    private long a(int i) {
        Long l = this.f9045a.get(Integer.valueOf(i));
        if (l == null) {
            l = this.f9045a.get(0);
        }
        if (l == null) {
            l = 1000000L;
        }
        return l.longValue();
    }

    @Override // com.yandex.mobile.ads.impl.w62
    public final synchronized void a(uv uvVar, boolean z, int i) {
        if (z) {
            if ((uvVar.i & 8) != 8) {
                this.h += (long) i;
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.w62
    public final synchronized void a(uv uvVar, boolean z) {
        if (z) {
            if ((uvVar.i & 8) != 8) {
                if (this.f > 0) {
                    long jB = this.d.b();
                    int i = (int) (jB - this.g);
                    this.j += (long) i;
                    long j = this.k;
                    long j2 = this.h;
                    this.k = j + j2;
                    if (i > 0) {
                        this.c.a((int) Math.sqrt(j2), (j2 * 8000.0f) / i);
                        if (this.j >= 2000 || this.k >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                            this.l = (long) this.c.a();
                        }
                        long j3 = this.h;
                        long j4 = this.l;
                        if (i != 0 || j3 != 0 || j4 != this.m) {
                            this.m = j4;
                            this.b.a(i, j3, j4);
                        }
                        this.g = jB;
                        this.h = 0L;
                    }
                    this.f--;
                    return;
                }
                throw new IllegalStateException();
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.vi
    public final void a(ed edVar) {
        this.b.a(edVar);
    }

    public static synchronized gz a(Context context) {
        if (t == null) {
            t = new gz(context == null ? null : context.getApplicationContext(), a.a(x82.b(context)), 2000, hp.f9123a, true);
        }
        return t;
    }
}
