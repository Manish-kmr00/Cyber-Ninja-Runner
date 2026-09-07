package com.yandex.mobile.ads.impl;

import android.view.View;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class kd2 implements eg2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final eb2 f9406a;
    private final cg2 b;

    public kd2(eb2 videoAd, cg2 eventsTracker) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        Intrinsics.checkNotNullParameter(eventsTracker, "eventsTracker");
        this.f9406a = videoAd;
        this.b = eventsTracker;
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void a() {
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void a(float f) {
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void a(float f, long j) {
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void b() {
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void c() {
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void d() {
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void e() {
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void f() {
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void g() {
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void j() {
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void k() {
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void l() {
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void m() {
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void a(View view, List<pb2> friendlyOverlays) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(friendlyOverlays, "friendlyOverlays");
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void a(String assetName) {
        Intrinsics.checkNotNullParameter(assetName, "assetName");
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void a(pc2 error) {
        int i;
        Intrinsics.checkNotNullParameter(error, "error");
        switch (error.a().ordinal()) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 9:
            case 10:
            case 11:
            case 25:
            case 26:
                i = 405;
                break;
            case 7:
                i = 402;
                break;
            case 8:
            case 12:
            case 28:
                i = 900;
                break;
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 20:
            case 21:
            case 22:
            case 24:
            case 27:
                i = 400;
                break;
            case 19:
                i = 401;
                break;
            case 23:
                i = 403;
                break;
            case 29:
                i = 901;
                break;
            case 30:
                i = 902;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        this.b.a(this.f9406a, "error", MapsKt.mapOf(TuplesKt.to("[ERRORCODE]", String.valueOf(i))));
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void i() {
        eb2 videoAd = this.f9406a;
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        this.b.a(new ob2(videoAd), "renderingStart");
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void h() {
        this.b.a(this.f9406a, "render_impression");
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void n() {
        this.b.a(this.f9406a, "impression");
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void a(eg2.a quartile) {
        Intrinsics.checkNotNullParameter(quartile, "quartile");
    }
}
