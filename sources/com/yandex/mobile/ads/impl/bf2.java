package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes13.dex */
public final class bf2 implements ku {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ku f8506a;

    public final void a(df2 df2Var) {
        this.f8506a = df2Var;
    }

    @Override // com.yandex.mobile.ads.impl.ku
    public final void onVideoPrepared() {
        ku kuVar = this.f8506a;
        if (kuVar != null) {
            kuVar.onVideoPrepared();
        }
    }

    @Override // com.yandex.mobile.ads.impl.ku
    public final void onVideoCompleted() {
        ku kuVar = this.f8506a;
        if (kuVar != null) {
            kuVar.onVideoCompleted();
        }
    }

    @Override // com.yandex.mobile.ads.impl.ku
    public final void onVideoResumed() {
        ku kuVar = this.f8506a;
        if (kuVar != null) {
            kuVar.onVideoResumed();
        }
    }

    @Override // com.yandex.mobile.ads.impl.ku
    public final void onVideoPaused() {
        ku kuVar = this.f8506a;
        if (kuVar != null) {
            kuVar.onVideoPaused();
        }
    }

    @Override // com.yandex.mobile.ads.impl.ku
    public final void onVideoError() {
        ku kuVar = this.f8506a;
        if (kuVar != null) {
            kuVar.onVideoError();
        }
    }
}
