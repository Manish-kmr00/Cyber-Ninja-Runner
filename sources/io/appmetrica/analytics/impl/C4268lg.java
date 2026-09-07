package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.adjust.sdk.Constants;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.math.MathKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.lg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4268lg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11653a;
    public final SafePackageManager b;
    public final Ya c;
    public final Jc d;
    public final long e;
    public final String f;
    public final String g;

    public C4268lg(Context context, SafePackageManager safePackageManager, Ya ya) {
        this.f11653a = context;
        this.b = safePackageManager;
        this.c = ya;
        Jc jc = new Jc(0);
        jc.a(EnumC4019bg.d, 1);
        jc.a(EnumC4019bg.c, 2);
        this.d = jc;
        this.e = TimeUnit.DAYS.toSeconds(1L);
        this.f = "com.android.vending";
        this.g = "com.huawei.appmarket";
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0098  */
    public final C4044cg a(List list) {
        C4044cg c4044cg;
        if (list.isEmpty()) {
            return null;
        }
        if (list.size() == 1) {
            return (C4044cg) list.get(0);
        }
        SafePackageManager safePackageManager = this.b;
        Context context = this.f11653a;
        PackageInfo packageInfo = safePackageManager.getPackageInfo(context, context.getPackageName(), 0);
        if (packageInfo != null) {
            long seconds = TimeUnit.MILLISECONDS.toSeconds(packageInfo.firstInstallTime);
            Iterator it = list.iterator();
            if (!it.hasNext()) {
                throw new NoSuchElementException();
            }
            C4044cg c4044cg2 = (C4044cg) it.next();
            Pair pair = TuplesKt.to(c4044cg2, Long.valueOf(Math.abs(c4044cg2.c - seconds)));
            while (it.hasNext()) {
                C4044cg c4044cg3 = (C4044cg) it.next();
                Pair pair2 = TuplesKt.to(c4044cg3, Long.valueOf(Math.abs(c4044cg3.c - seconds)));
                if (ComparisonsKt.compareValues((Comparable) pair.getSecond(), (Comparable) pair2.getSecond()) > 0) {
                    pair = pair2;
                }
            }
            c4044cg = (C4044cg) pair.component1();
            if (((Number) pair.component2()).longValue() >= this.e) {
                c4044cg = null;
            }
        } else {
            c4044cg = null;
        }
        if (c4044cg == null) {
            Comparator comparator = new Comparator() { // from class: io.appmetrica.analytics.impl.lg$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return C4268lg.a(this.f$0, (C4044cg) obj, (C4044cg) obj2);
                }
            };
            Iterator it2 = list.iterator();
            if (!it2.hasNext()) {
                throw new NoSuchElementException();
            }
            C4044cg c4044cg4 = (C4044cg) it2.next();
            while (it2.hasNext()) {
                C4044cg c4044cg5 = (C4044cg) it2.next();
                if (comparator.compare(c4044cg4, c4044cg5) < 0) {
                    c4044cg4 = c4044cg5;
                }
            }
            c4044cg = c4044cg4;
        }
        Ya ya = this.c;
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            C4044cg c4044cg6 = (C4044cg) it3.next();
            arrayList.add(new JSONObject().put(Constants.REFERRER, c4044cg6.f11496a).put("install_timestamp_seconds", c4044cg6.c).put("click_timestamp_seconds", c4044cg6.b).put("source", c4044cg6.d.f11480a));
        }
        ya.reportEvent("several_filled_referrers", jSONObject.put("candidates", In.a((Collection) arrayList) ? null : new JSONArray((Collection) arrayList)).put("chosen", new JSONObject().put(Constants.REFERRER, c4044cg.f11496a).put("install_timestamp_seconds", c4044cg.c).put("click_timestamp_seconds", c4044cg.b).put("source", c4044cg.d.f11480a)).putOpt("install_time", packageInfo != null ? Long.valueOf(packageInfo.firstInstallTime) : null).toString());
        return c4044cg;
    }

    public /* synthetic */ C4268lg(Context context) {
        this(context, new SafePackageManager(), AbstractC4378q1.a());
    }

    public static final int a(C4268lg c4268lg, C4044cg c4044cg, C4044cg c4044cg2) {
        int sign = MathKt.getSign(c4044cg.c - c4044cg2.c);
        return sign == 0 ? ((Number) c4268lg.d.a(c4044cg.d)).intValue() - ((Number) c4268lg.d.a(c4044cg2.d)).intValue() : sign;
    }
}
