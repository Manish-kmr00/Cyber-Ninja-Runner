package com.yandex.mobile.ads.impl;

import android.view.View;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import net.pubnative.lite.sdk.vpaid.enums.EventConstants;

/* JADX INFO: loaded from: classes13.dex */
public final class av implements eg2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ru f8440a;
    private final cg2 b;
    private final je2 c;
    private final ko0 d;
    private boolean e;

    public av(ru creative, cg2 eventsTracker, je2 videoEventUrlsTracker) {
        Intrinsics.checkNotNullParameter(creative, "creative");
        Intrinsics.checkNotNullParameter(eventsTracker, "eventsTracker");
        Intrinsics.checkNotNullParameter(videoEventUrlsTracker, "videoEventUrlsTracker");
        this.f8440a = creative;
        this.b = eventsTracker;
        this.c = videoEventUrlsTracker;
        this.d = new ko0(new su());
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void a(float f) {
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
    public final void n() {
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void a(View view, List<pb2> friendlyOverlays) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(friendlyOverlays, "friendlyOverlays");
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void m() {
        if (!this.e) {
            this.e = true;
            this.b.a(this.f8440a, "start");
        }
        this.b.a(this.f8440a, "clickTracking");
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void a(String assetName) {
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        if (!this.e) {
            this.e = true;
            this.b.a(this.f8440a, "start");
        }
        this.c.a(this.d.a(this.f8440a, assetName).b(), null);
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void a(pc2 error) {
        Intrinsics.checkNotNullParameter(error, "error");
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void a(eg2.a quartile) {
        String str;
        Intrinsics.checkNotNullParameter(quartile, "quartile");
        int iOrdinal = quartile.ordinal();
        if (iOrdinal == 0) {
            str = EventConstants.FIRST_QUARTILE;
        } else if (iOrdinal == 1) {
            str = "midpoint";
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            str = EventConstants.THIRD_QUARTILE;
        }
        this.b.a(this.f8440a, str);
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void i() {
        ru creative = this.f8440a;
        Intrinsics.checkNotNullParameter(creative, "creative");
        this.b.a(new wu(creative), "creativeRenderingStart");
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void h() {
        this.b.a(this.f8440a, EventConstants.CREATIVE_VIEW);
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void d() {
        this.b.a(this.f8440a, "pause");
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void c() {
        this.b.a(this.f8440a, "resume");
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void l() {
        this.b.a(this.f8440a, "mute");
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void b() {
        this.b.a(this.f8440a, "complete");
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void e() {
        this.b.a(this.f8440a, EventConstants.SKIP);
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void a(float f, long j) {
        if (this.e) {
            return;
        }
        this.e = true;
        this.b.a(this.f8440a, "start");
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void k() {
        this.e = false;
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void a() {
        this.b.a(this.f8440a, "unmute");
    }
}
