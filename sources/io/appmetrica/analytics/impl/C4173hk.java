package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.collections.CollectionsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.hk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4173hk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4282m5 f11587a;
    public final C4596yk b;
    public final C4247kk c;
    public long d;
    public long e;
    public AtomicLong f;
    public boolean g;
    public volatile C4546wk h;
    public long i;
    public long j;
    public final SystemTimeProvider k;

    public C4173hk(C4282m5 c4282m5, C4596yk c4596yk, C4247kk c4247kk, SystemTimeProvider systemTimeProvider) {
        this.f11587a = c4282m5;
        this.b = c4596yk;
        this.c = c4247kk;
        this.k = systemTimeProvider;
        a();
    }

    public final void a() {
        C4247kk c4247kk = this.c;
        long jElapsedRealtime = this.k.elapsedRealtime();
        Long l = c4247kk.c;
        if (l != null) {
            jElapsedRealtime = l.longValue();
        }
        this.e = jElapsedRealtime;
        Long l2 = this.c.b;
        this.d = l2 == null ? -1L : l2.longValue();
        Long l3 = this.c.e;
        this.f = new AtomicLong(l3 == null ? 0L : l3.longValue());
        Boolean bool = this.c.f;
        this.g = bool == null ? true : bool.booleanValue();
        Long l4 = this.c.g;
        long jLongValue = l4 != null ? l4.longValue() : 0L;
        this.i = jLongValue;
        C4247kk c4247kk2 = this.c;
        long jLongValue2 = jLongValue - this.e;
        Long l5 = c4247kk2.h;
        if (l5 != null) {
            jLongValue2 = l5.longValue();
        }
        this.j = jLongValue2;
    }

    public final String toString() {
        return "Session{id=" + this.d + ", creationTime=" + this.e + ", currentReportId=" + this.f + ", sessionRequestParams=" + this.h + ", sleepStart=" + this.i + AbstractJsonLexerKt.END_OBJ;
    }

    /* JADX WARN: Code duplicated, block: B:58:0x0135  */
    public final boolean a(long j) {
        boolean z;
        boolean z2;
        boolean z3 = this.d >= 0;
        if (this.h == null) {
            synchronized (this) {
                if (this.h == null) {
                    try {
                        String asString = this.f11587a.e.a(this.d, this.c.f11639a).getAsString("report_request_parameters");
                        if (!TextUtils.isEmpty(asString)) {
                            this.h = new C4546wk(new JSONObject(asString));
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        C4546wk c4546wk = this.h;
        if (c4546wk != null) {
            C4045ch c4045ch = (C4045ch) this.f11587a.k.a();
            Boolean[] boolArr = new Boolean[7];
            boolArr[0] = Boolean.valueOf(TextUtils.equals(c4045ch.getAnalyticsSdkVersionName(), c4546wk.f11833a));
            boolArr[1] = Boolean.valueOf(TextUtils.equals(c4045ch.getAnalyticsSdkBuildNumber(), c4546wk.b));
            boolArr[2] = Boolean.valueOf(TextUtils.equals(c4045ch.getAppVersion(), c4546wk.c));
            boolArr[3] = Boolean.valueOf(TextUtils.equals(c4045ch.getAppBuildNumber(), c4546wk.d));
            boolArr[4] = Boolean.valueOf(TextUtils.equals(c4045ch.getOsVersion(), c4546wk.e));
            boolArr[5] = Boolean.valueOf(c4546wk.f == c4045ch.getOsApiLevel());
            boolArr[6] = Boolean.valueOf(c4546wk.g == c4045ch.r);
            List listListOf = CollectionsKt.listOf((Object[]) boolArr);
            if (!(listListOf instanceof Collection) || !listListOf.isEmpty()) {
                Iterator it = listListOf.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!((Boolean) it.next()).booleanValue()) {
                            z = false;
                        }
                    }
                }
            }
            z = true;
        } else {
            z = false;
        }
        long jElapsedRealtime = this.k.elapsedRealtime();
        long j2 = this.i;
        boolean z4 = jElapsedRealtime < j2;
        long j3 = j - j2;
        long j4 = j - this.e;
        if (z4) {
            z2 = true;
        } else {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            C4247kk c4247kk = this.c;
            int iIntValue = ((C4045ch) this.f11587a.k.a()).f;
            Integer num = c4247kk.d;
            if (num != null) {
                iIntValue = num.intValue();
            }
            if (j3 >= timeUnit.toMillis(iIntValue) || j4 >= timeUnit.toMillis(AbstractC4272lk.f11657a)) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        return z3 && z && !z2;
    }
}
