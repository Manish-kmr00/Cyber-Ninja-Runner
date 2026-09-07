package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class bj1 implements vl1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final jf2 f8513a;
    private final rn1 b;
    private final qn1 c;
    private final dj1 d;
    private boolean e;

    public bj1(jf2 videoProgressMonitoringManager, rn1 readyToPrepareProvider, qn1 readyToPlayProvider, dj1 playlistSchedulerListener) {
        Intrinsics.checkNotNullParameter(videoProgressMonitoringManager, "videoProgressMonitoringManager");
        Intrinsics.checkNotNullParameter(readyToPrepareProvider, "readyToPrepareProvider");
        Intrinsics.checkNotNullParameter(readyToPlayProvider, "readyToPlayProvider");
        Intrinsics.checkNotNullParameter(playlistSchedulerListener, "playlistSchedulerListener");
        this.f8513a = videoProgressMonitoringManager;
        this.b = readyToPrepareProvider;
        this.c = readyToPlayProvider;
        this.d = playlistSchedulerListener;
    }

    public final void b() {
        if (this.e) {
            this.f8513a.a((vl1) null);
            this.f8513a.b();
            this.e = false;
        }
    }

    @Override // com.yandex.mobile.ads.impl.vl1
    public final void a(long j) {
        dt dtVarA = this.c.a(j);
        if (dtVarA != null) {
            this.d.a(dtVarA);
            return;
        }
        dt dtVarA2 = this.b.a(j);
        if (dtVarA2 != null) {
            this.d.b(dtVarA2);
        }
    }

    public final void a() {
        if (this.e) {
            return;
        }
        this.e = true;
        this.f8513a.a(this);
        this.f8513a.a();
    }
}
