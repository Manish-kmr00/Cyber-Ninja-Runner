package com.inmobi.media;

import android.content.Context;
import com.inmobi.commons.core.configs.AdConfig;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class J2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C3389h f3103a;
    public final long b;
    public final String c = "J2";
    public final N2 d = new N2();
    public long e = -1;
    public final AtomicBoolean f = new AtomicBoolean();
    public final AtomicBoolean g = new AtomicBoolean();

    public J2(C3389h c3389h, long j) {
        this.f3103a = c3389h;
        this.b = j;
    }

    public final void a() {
        C3389h c3389h;
        C3389h c3389h2;
        Long lM;
        String strH;
        Boolean boolC;
        Intrinsics.checkNotNull(this.c);
        C3389h c3389h3 = this.f3103a;
        if (c3389h3 != null && (boolC = c3389h3.C()) != null) {
            boolean zBooleanValue = boolC.booleanValue();
            M2 m2 = M2.f3131a;
            Context contextD = C3517pb.d();
            if (contextD != null) {
                Intrinsics.checkNotNull("M2");
                if (zBooleanValue != M2.c()) {
                    Intrinsics.checkNotNull("M2");
                    ConcurrentHashMap concurrentHashMap = K5.b;
                    J5.a(contextD, "c_data_store").a("isEnabled", zBooleanValue);
                    if (!zBooleanValue) {
                        m2.d();
                    }
                }
            }
        }
        M2 m3 = M2.f3131a;
        if (M2.c() && !this.f.getAndSet(true)) {
            this.e = System.currentTimeMillis();
            if (!this.g.get()) {
                C3389h c3389h4 = this.f3103a;
                if ((c3389h4 != null ? c3389h4.h() : null) != null && (strH = this.f3103a.h()) != null) {
                    N2 n2 = this.d;
                    n2.getClass();
                    Intrinsics.checkNotNullParameter(strH, "<set-?>");
                    n2.f3142a = strH;
                    Intrinsics.checkNotNull(this.c);
                }
            }
            if (!this.g.get() && (c3389h2 = this.f3103a) != null && (lM = c3389h2.m()) != null) {
                this.d.b = lM.longValue();
                Intrinsics.checkNotNull(this.c);
            }
            if (!this.g.get()) {
                this.d.e = this.b;
                Intrinsics.checkNotNull(this.c);
            }
            if (!this.g.get() && (c3389h = this.f3103a) != null) {
                this.d.f = c3389h.n();
                Intrinsics.checkNotNull(this.c);
            }
            long j = this.e / ((long) 1000);
            if (this.g.get()) {
                return;
            }
            this.d.c = j;
            Intrinsics.checkNotNull(this.c);
        }
    }

    public final void b() {
        M2 m2 = M2.f3131a;
        if (!M2.c()) {
            Intrinsics.checkNotNull(this.c);
            return;
        }
        if (!this.f.get()) {
            Intrinsics.checkNotNull(this.c);
            return;
        }
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() - this.e);
        if (!this.g.get()) {
            this.d.d = iCurrentTimeMillis;
            Intrinsics.checkNotNull(this.c);
        }
        if (this.g.getAndSet(true)) {
            Intrinsics.checkNotNull(this.c);
        } else {
            Intrinsics.checkNotNull(this.c);
            C3517pb.a(new Runnable() { // from class: com.inmobi.media.J2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    J2.a(this.f$0);
                }
            });
        }
    }

    public static final void a(J2 this$0) {
        List<String> listEmptyList;
        AdConfig.ContextualDataConfig contextualData;
        AdConfig.ContextualDataConfig contextualData2;
        AdConfig.ContextualDataConfig contextualData3;
        AdConfig.ContextualDataConfig contextualData4;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        M2 m2 = M2.f3131a;
        N2 contextualDataModel = this$0.d;
        Intrinsics.checkNotNullParameter(contextualDataModel, "contextualDataModel");
        synchronized (m2) {
            Intrinsics.checkNotNull("M2");
            long jCurrentTimeMillis = System.currentTimeMillis();
            AdConfig adConfig = M2.e;
            int maxAdRecords = 0;
            long expiryTime = jCurrentTimeMillis - ((long) (((adConfig == null || (contextualData4 = adConfig.getContextualData()) == null) ? 0 : contextualData4.getExpiryTime()) * 1000));
            AdConfig adConfig2 = M2.e;
            M2.a(expiryTime, ((adConfig2 == null || (contextualData3 = adConfig2.getContextualData()) == null) ? 0 : contextualData3.getMaxAdRecords()) - 1);
            AdConfig adConfig3 = M2.e;
            if (adConfig3 == null || (contextualData2 = adConfig3.getContextualData()) == null || (listEmptyList = contextualData2.getSkipFields()) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            String string = O2.a(contextualDataModel, listEmptyList).toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            F3 f3 = new F3(G3.a(string, M2.f), jCurrentTimeMillis);
            M2.b.add(f3);
            Object objClone = M2.b.clone();
            Intrinsics.checkNotNull(objClone, "null cannot be cast to non-null type java.util.LinkedList<com.inmobi.signals.contextualdata.EncryptedContextualData>");
            M2.c = (LinkedList) objClone;
            AdConfig adConfig4 = M2.e;
            if (adConfig4 != null && (contextualData = adConfig4.getContextualData()) != null) {
                maxAdRecords = contextualData.getMaxAdRecords();
            }
            Intrinsics.checkNotNull("M2");
            I2 i2 = (I2) AbstractC3415ib.d.getValue();
            i2.getClass();
            Objects.toString(f3);
            i2.a(f3);
            i2.a("id NOT IN (SELECT id FROM ( SELECT id FROM c_data WHERE timestamp > " + expiryTime + " ORDER BY timestamp DESC LIMIT " + maxAdRecords + ") foo);", null);
            Unit unit = Unit.INSTANCE;
        }
    }
}
