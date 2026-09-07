package com.five_corp.ad.internal;

import com.five_corp.ad.FiveAdCustomLayout;
import com.five_corp.ad.FiveAdCustomLayoutEventListener;
import com.five_corp.ad.FiveAdErrorCode;

/* JADX INFO: renamed from: com.five_corp.ad.internal.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C2976c implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FiveAdCustomLayoutEventListener f1335a;
    public final /* synthetic */ FiveAdCustomLayout b;

    public C2976c(FiveAdCustomLayoutEventListener fiveAdCustomLayoutEventListener, FiveAdCustomLayout fiveAdCustomLayout) {
        this.f1335a = fiveAdCustomLayoutEventListener;
        this.b = fiveAdCustomLayout;
    }

    @Override // com.five_corp.ad.internal.g
    public final void a() {
        this.f1335a.onPlay(this.b);
    }

    @Override // com.five_corp.ad.internal.g
    public final void b() {
        this.f1335a.onViewThrough(this.b);
    }

    @Override // com.five_corp.ad.internal.g
    public final void c() {
        this.f1335a.onPause(this.b);
    }

    @Override // com.five_corp.ad.internal.g
    public final void d() {
        this.f1335a.onClick(this.b);
    }

    @Override // com.five_corp.ad.internal.g
    public final void e() {
        this.f1335a.onImpression(this.b);
    }

    @Override // com.five_corp.ad.internal.g
    public final void a(FiveAdErrorCode fiveAdErrorCode) {
        this.f1335a.onViewError(this.b, fiveAdErrorCode);
    }
}
