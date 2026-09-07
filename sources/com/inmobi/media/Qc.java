package com.inmobi.media;

import com.inmobi.commons.core.configs.AdConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes7.dex */
public final class Qc implements Rc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AdConfig.VastVideoConfig f3177a;
    public final int b;
    public final int c;
    public final int d;
    public final ArrayList e;
    public String f;
    public String g;
    public final ArrayList h;
    public final ArrayList i;
    public Hc j;
    public String k;
    public int l;

    public Qc(List trackers, AdConfig.VastVideoConfig vastVideoConfig) {
        Intrinsics.checkNotNullParameter(trackers, "trackers");
        Intrinsics.checkNotNullParameter(vastVideoConfig, "vastVideoConfig");
        this.f3177a = vastVideoConfig;
        this.b = 1048576;
        this.c = 8192;
        this.d = 60;
        ArrayList arrayList = new ArrayList();
        this.h = arrayList;
        arrayList.addAll(trackers);
        this.e = new ArrayList();
        this.i = new ArrayList();
        this.l = 0;
    }

    public static boolean a(double d, double d2, double d3) {
        return d3 > d && d3 <= d2;
    }

    public final int a() {
        List<String> listSplit;
        String[] strArr;
        String str = this.g;
        if (str != null && (listSplit = new Regex(":").split(str, 0)) != null && (strArr = (String[]) listSplit.toArray(new String[0])) != null && strArr.length > 2) {
            try {
                return (Integer.parseInt(strArr[1]) * this.d) + ((int) Float.parseFloat(strArr[2]));
            } catch (NumberFormatException unused) {
            }
        }
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01db A[PHI: r4
  0x01db: PHI (r4v10 com.inmobi.media.Ic) = (r4v7 com.inmobi.media.Ic), (r4v11 com.inmobi.media.Ic) binds: [B:101:0x01d9, B:78:0x0186] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:104:0x01e2 A[PHI: r3
  0x01e2: PHI (r3v13 com.inmobi.media.Ic) = (r3v10 com.inmobi.media.Ic), (r3v14 com.inmobi.media.Ic) binds: [B:103:0x01e0, B:80:0x0189] A[DONT_GENERATE, DONT_INLINE]] */
    public final String b() {
        Ic ic;
        int iA;
        String str = this.f;
        if (str != null) {
            return str;
        }
        W0 w0A = AbstractC3415ib.a();
        w0A.getClass();
        ArrayList<C3417j> arrayListA = D1.a(w0A, null, null, null, null, "created_ts DESC ", null, 47);
        ArrayList arrayList = new ArrayList();
        for (C3417j c3417j : arrayListA) {
            if (c3417j != null) {
                arrayList.add(c3417j);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((C3417j) it.next()).b);
        }
        Ic ic2 = null;
        if (arrayList2.isEmpty()) {
            ic = null;
            break;
        }
        Iterator it2 = this.e.iterator();
        do {
            if (!it2.hasNext()) {
                ic = null;
                break;
            }
            ic = (Ic) it2.next();
        } while (!arrayList2.contains(ic.f3100a));
        if (ic != null) {
            String str2 = ic.f3100a;
            this.f = str2;
            return str2;
        }
        double optimalVastVideoSize = (this.f3177a.getOptimalVastVideoSize() * 2.0d) / ((double) this.b);
        double vastMaxAssetSize = (this.f3177a.getVastMaxAssetSize() * 1.0d) / ((double) this.b);
        for (Ic ic3 : this.e) {
            try {
                iA = a();
            } catch (ArrayIndexOutOfBoundsException e) {
                C3339d5 c3339d5 = C3339d5.f3292a;
                P1 event = new P1(e);
                Intrinsics.checkNotNullParameter(event, "event");
                C3339d5.c.a(event);
                iA = 0;
            }
            double d = ((((double) ic3.b) * 1.0d) * ((double) iA)) / ((double) this.c);
            ic3.c = d;
            if (a(0.0d, optimalVastVideoSize, d)) {
                if (ic == null || d > ic.c) {
                    ic = ic3;
                }
            } else if (a(optimalVastVideoSize, vastMaxAssetSize, d) && (ic2 == null || d < ic2.c)) {
                ic2 = ic3;
            }
        }
        if (ic != null) {
            this.f = ic.f3100a;
        } else if (ic2 != null) {
            this.f = ic2.f3100a;
        }
        String str3 = this.f;
        if (str3 == null || str3.length() == 0) {
            AdConfig.BitRateConfig bitRate = this.f3177a.getBitRate();
            if (bitRate.getBitrate_mandatory() || this.e.size() == 0) {
                return this.f;
            }
            CountDownLatch countDownLatch = new CountDownLatch(this.e.size());
            try {
                try {
                    a(bitRate, countDownLatch);
                    countDownLatch.await(bitRate.getHeaderTimeout(), TimeUnit.MILLISECONDS);
                    for (Ic ic4 : this.e) {
                        double d2 = ic4.c;
                        if (a(0.0d, optimalVastVideoSize, d2)) {
                            if (ic == null || d2 > ic.c) {
                                ic = ic4;
                            }
                        } else if (a(optimalVastVideoSize, vastMaxAssetSize, d2) && (ic2 == null || d2 < ic2.c)) {
                            ic2 = ic4;
                        }
                    }
                    if (ic != null) {
                        this.f = ic.f3100a;
                    } else if (ic2 != null) {
                        this.f = ic2.f3100a;
                    }
                } catch (Throwable th) {
                    for (Ic ic5 : this.e) {
                        double d3 = ic5.c;
                        if (a(0.0d, optimalVastVideoSize, d3)) {
                            if (ic == null || d3 > ic.c) {
                                ic = ic5;
                            }
                        } else if (a(optimalVastVideoSize, vastMaxAssetSize, d3) && (ic2 == null || d3 < ic2.c)) {
                            ic2 = ic5;
                        }
                    }
                    if (ic != null) {
                        this.f = ic.f3100a;
                    } else if (ic2 != null) {
                        this.f = ic2.f3100a;
                    }
                    throw th;
                }
            } catch (Exception e2) {
                C3339d5 c3339d6 = C3339d5.f3292a;
                P1 event2 = new P1(e2);
                Intrinsics.checkNotNullParameter(event2, "event");
                C3339d5.c.a(event2);
                for (Ic ic6 : this.e) {
                    double d4 = ic6.c;
                    if (a(0.0d, optimalVastVideoSize, d4)) {
                        if (ic == null || d4 > ic.c) {
                            ic = ic6;
                        }
                    } else if (a(optimalVastVideoSize, vastMaxAssetSize, d4) && (ic2 == null || d4 < ic2.c)) {
                        ic2 = ic6;
                    }
                }
                if (ic != null) {
                    this.f = ic.f3100a;
                } else if (ic2 != null) {
                    this.f = ic2.f3100a;
                }
            }
        }
        return this.f;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Qc(String str, String str2, String str3, ArrayList trackers, ArrayList companionAds, AdConfig.VastVideoConfig vastVideoConfig) {
        this(trackers, vastVideoConfig);
        Intrinsics.checkNotNullParameter(trackers, "trackers");
        Intrinsics.checkNotNullParameter(companionAds, "companionAds");
        Intrinsics.checkNotNullParameter(vastVideoConfig, "vastVideoConfig");
        if (!companionAds.isEmpty()) {
            this.i = new ArrayList(companionAds);
        }
        if (str != null) {
            this.e.add(new Ic(str, 1000));
        }
        this.f = str;
        this.g = str2;
        this.k = str3;
    }

    public final void a(AdConfig.BitRateConfig bitRateConfig, CountDownLatch countDownLatch) {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            new Kc((Ic) it.next(), bitRateConfig.getHeaderTimeout(), countDownLatch).a();
        }
    }
}
