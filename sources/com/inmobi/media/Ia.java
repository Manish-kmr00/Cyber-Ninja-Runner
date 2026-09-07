package com.inmobi.media;

import android.os.SystemClock;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class Ia {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Ea f3098a;
    public long b;
    public int c;
    public int d;
    public final AtomicInteger e;
    public final AtomicBoolean f;

    public Ia(Ea renderViewMetaData) {
        Intrinsics.checkNotNullParameter(renderViewMetaData, "renderViewMetaData");
        this.f3098a = renderViewMetaData;
        this.e = new AtomicInteger(renderViewMetaData.j.f3090a);
        this.f = new AtomicBoolean(false);
    }

    public final Map a() {
        Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("plType", String.valueOf(this.f3098a.f3060a.m())), TuplesKt.to("plId", String.valueOf(this.f3098a.f3060a.l())), TuplesKt.to(com.smaato.sdk.video.vast.model.Ad.AD_TYPE, String.valueOf(this.f3098a.f3060a.b())), TuplesKt.to("markupType", this.f3098a.b), TuplesKt.to("networkType", C3435k3.q()), TuplesKt.to("retryCount", String.valueOf(this.f3098a.d)), TuplesKt.to("creativeType", this.f3098a.e), TuplesKt.to("adPosition", String.valueOf(this.f3098a.h)), TuplesKt.to("isRewarded", String.valueOf(this.f3098a.g)));
        if (this.f3098a.c.length() > 0) {
            mapMutableMapOf.put("metadataBlob", this.f3098a.c);
        }
        return mapMutableMapOf;
    }

    public final void b() {
        this.b = SystemClock.elapsedRealtime();
        Map mapA = a();
        long j = this.f3098a.i.f3044a.c;
        ScheduledExecutorService scheduledExecutorService = Ec.f3062a;
        mapA.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - j));
        mapA.put("creativeId", this.f3098a.f);
        Ob ob = Ob.f3160a;
        Ob.b("WebViewLoadCalled", mapA, Sb.SDK);
    }
}
