package com.five_corp.ad.internal;

import com.five_corp.ad.FiveAdErrorCode;
import com.five_corp.ad.FiveAdNative;
import com.five_corp.ad.FiveAdNativeEventListener;

/* JADX INFO: loaded from: classes10.dex */
public final class f implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FiveAdNativeEventListener f1374a;
    public final /* synthetic */ FiveAdNative b;

    public f(FiveAdNativeEventListener fiveAdNativeEventListener, FiveAdNative fiveAdNative) {
        this.f1374a = fiveAdNativeEventListener;
        this.b = fiveAdNative;
    }

    @Override // com.five_corp.ad.internal.g
    public final void a() {
        this.f1374a.onPlay(this.b);
    }

    @Override // com.five_corp.ad.internal.g
    public final void b() {
        this.f1374a.onViewThrough(this.b);
    }

    @Override // com.five_corp.ad.internal.g
    public final void c() {
        this.f1374a.onPause(this.b);
    }

    @Override // com.five_corp.ad.internal.g
    public final void d() {
        this.f1374a.onClick(this.b);
    }

    @Override // com.five_corp.ad.internal.g
    public final void e() {
        this.f1374a.onImpression(this.b);
    }

    @Override // com.five_corp.ad.internal.g
    public final void a(FiveAdErrorCode fiveAdErrorCode) {
        this.f1374a.onViewError(this.b, fiveAdErrorCode);
    }
}
