package com.inmobi.media;

import android.os.SystemClock;
import io.ktor.http.ContentDisposition;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: renamed from: com.inmobi.media.a1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C3292a1 implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CountDownLatch f3261a;
    public final String b;
    public final long c;
    public final String d;

    public C3292a1(CountDownLatch countDownLatch, String remoteUrl, long j, String assetAdType) {
        Intrinsics.checkNotNullParameter(countDownLatch, "countDownLatch");
        Intrinsics.checkNotNullParameter(remoteUrl, "remoteUrl");
        Intrinsics.checkNotNullParameter(assetAdType, "assetAdType");
        this.f3261a = countDownLatch;
        this.b = remoteUrl;
        this.c = j;
        this.d = assetAdType;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object proxy, Method method, Object[] args) {
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        Intrinsics.checkNotNullParameter(args, "args");
        C3335d1 c3335d1 = C3335d1.f3289a;
        Intrinsics.checkNotNullExpressionValue("d1", "access$getTAG$p(...)");
        Objects.toString(method);
        if (method == null) {
            return null;
        }
        if (!StringsKt.equals("onSuccess", method.getName(), true)) {
            if (!StringsKt.equals("onError", method.getName(), true)) {
                return null;
            }
            C3335d1.f3289a.c(this.b);
            this.f3261a.countDown();
            return null;
        }
        HashMap mapHashMapOf = MapsKt.hashMapOf(TuplesKt.to("latency", Long.valueOf(SystemClock.elapsedRealtime() - this.c)), TuplesKt.to(ContentDisposition.Parameters.Size, 0), TuplesKt.to("assetType", "image"), TuplesKt.to("networkType", C3435k3.q()), TuplesKt.to(com.smaato.sdk.video.vast.model.Ad.AD_TYPE, this.d));
        Ob ob = Ob.f3160a;
        Ob.b("AssetDownloaded", mapHashMapOf, Sb.SDK);
        C3335d1.f3289a.d(this.b);
        this.f3261a.countDown();
        return null;
    }
}
