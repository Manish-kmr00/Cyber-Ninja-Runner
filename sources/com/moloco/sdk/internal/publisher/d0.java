package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.publisher.AdLoad;
import com.moloco.sdk.publisher.FullscreenAd;
import com.moloco.sdk.publisher.InterstitialAd;
import com.moloco.sdk.publisher.InterstitialAdShowListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class d0 implements InterstitialAd, r, FullscreenAd<InterstitialAdShowListener> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u<InterstitialAdShowListener> f6185a;

    /* JADX WARN: Multi-variable type inference failed */
    public d0(u<? super InterstitialAdShowListener> fullscreenAd) {
        Intrinsics.checkNotNullParameter(fullscreenAd, "fullscreenAd");
        this.f6185a = fullscreenAd;
    }

    @Override // com.moloco.sdk.publisher.FullscreenAd
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void show(InterstitialAdShowListener interstitialAdShowListener) {
        this.f6185a.show(e0.a(interstitialAdShowListener));
    }

    @Override // com.moloco.sdk.publisher.Destroyable
    public void destroy() {
        this.f6185a.destroy();
    }

    @Override // com.moloco.sdk.internal.publisher.r
    public long getCreateAdObjectStartTime() {
        return this.f6185a.getCreateAdObjectStartTime();
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public boolean isLoaded() {
        return this.f6185a.isLoaded();
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public void load(String bidResponseJson, AdLoad.Listener listener) {
        Intrinsics.checkNotNullParameter(bidResponseJson, "bidResponseJson");
        this.f6185a.load(bidResponseJson, listener);
    }

    @Override // com.moloco.sdk.internal.publisher.r
    public void setCreateAdObjectStartTime(long j) {
        this.f6185a.setCreateAdObjectStartTime(j);
    }
}
