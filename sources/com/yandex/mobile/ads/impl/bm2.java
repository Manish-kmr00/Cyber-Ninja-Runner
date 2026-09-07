package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.instream.player.ad.InstreamAdPlayerListener;
import com.yandex.mobile.ads.instream.player.ad.error.InstreamAdPlayerError;
import com.yandex.mobile.ads.video.playback.model.VideoAd;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class bm2 implements InstreamAdPlayerListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ht f8519a;
    private final dm2 b;
    private final am2 c;

    public bm2(hm0 coreInstreamAdPlayerListener, dm2 videoAdCache, am2 adPlayerErrorAdapter) {
        Intrinsics.checkNotNullParameter(coreInstreamAdPlayerListener, "coreInstreamAdPlayerListener");
        Intrinsics.checkNotNullParameter(videoAdCache, "videoAdCache");
        Intrinsics.checkNotNullParameter(adPlayerErrorAdapter, "adPlayerErrorAdapter");
        this.f8519a = coreInstreamAdPlayerListener;
        this.b = videoAdCache;
        this.c = adPlayerErrorAdapter;
    }

    @Override // com.yandex.mobile.ads.instream.player.ad.InstreamAdPlayerListener
    public final void onAdBufferingFinished(VideoAd videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        do0 do0VarA = this.b.a(videoAd);
        if (do0VarA != null) {
            this.f8519a.h(do0VarA);
        }
    }

    @Override // com.yandex.mobile.ads.instream.player.ad.InstreamAdPlayerListener
    public final void onAdBufferingStarted(VideoAd videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        do0 do0VarA = this.b.a(videoAd);
        if (do0VarA != null) {
            this.f8519a.i(do0VarA);
        }
    }

    @Override // com.yandex.mobile.ads.instream.player.ad.InstreamAdPlayerListener
    public final void onAdCompleted(VideoAd videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        do0 do0VarA = this.b.a(videoAd);
        if (do0VarA != null) {
            this.f8519a.g(do0VarA);
        }
    }

    @Override // com.yandex.mobile.ads.instream.player.ad.InstreamAdPlayerListener
    public final void onAdPaused(VideoAd videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        do0 do0VarA = this.b.a(videoAd);
        if (do0VarA != null) {
            this.f8519a.c(do0VarA);
        }
    }

    @Override // com.yandex.mobile.ads.instream.player.ad.InstreamAdPlayerListener
    public final void onAdPrepared(VideoAd videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        do0 do0VarA = this.b.a(videoAd);
        if (do0VarA != null) {
            this.f8519a.b(do0VarA);
        }
    }

    @Override // com.yandex.mobile.ads.instream.player.ad.InstreamAdPlayerListener
    public final void onAdResumed(VideoAd videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        do0 do0VarA = this.b.a(videoAd);
        if (do0VarA != null) {
            this.f8519a.e(do0VarA);
        }
    }

    @Override // com.yandex.mobile.ads.instream.player.ad.InstreamAdPlayerListener
    public final void onAdSkipped(VideoAd videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        do0 do0VarA = this.b.a(videoAd);
        if (do0VarA != null) {
            this.f8519a.a(do0VarA);
            this.b.b(videoAd);
        }
    }

    @Override // com.yandex.mobile.ads.instream.player.ad.InstreamAdPlayerListener
    public final void onAdStarted(VideoAd videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        do0 do0VarA = this.b.a(videoAd);
        if (do0VarA != null) {
            this.f8519a.d(do0VarA);
        }
    }

    @Override // com.yandex.mobile.ads.instream.player.ad.InstreamAdPlayerListener
    public final void onAdStopped(VideoAd videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        do0 do0VarA = this.b.a(videoAd);
        if (do0VarA != null) {
            this.f8519a.f(do0VarA);
            this.b.b(videoAd);
        }
    }

    @Override // com.yandex.mobile.ads.instream.player.ad.InstreamAdPlayerListener
    public final void onError(VideoAd videoAd, InstreamAdPlayerError instreamAdPlayerError) {
        pc2.a aVar;
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        Intrinsics.checkNotNullParameter(instreamAdPlayerError, "error");
        do0 do0VarA = this.b.a(videoAd);
        if (do0VarA != null) {
            this.c.getClass();
            Intrinsics.checkNotNullParameter(instreamAdPlayerError, "instreamAdPlayerError");
            switch (am2.a.f8423a[instreamAdPlayerError.getReason().ordinal()]) {
                case 1:
                    aVar = pc2.a.b;
                    break;
                case 2:
                    aVar = pc2.a.c;
                    break;
                case 3:
                    aVar = pc2.a.d;
                    break;
                case 4:
                    aVar = pc2.a.e;
                    break;
                case 5:
                    aVar = pc2.a.f;
                    break;
                case 6:
                    aVar = pc2.a.g;
                    break;
                case 7:
                    aVar = pc2.a.h;
                    break;
                case 8:
                    aVar = pc2.a.i;
                    break;
                case 9:
                    aVar = pc2.a.j;
                    break;
                case 10:
                    aVar = pc2.a.k;
                    break;
                case 11:
                    aVar = pc2.a.l;
                    break;
                case 12:
                    aVar = pc2.a.m;
                    break;
                case 13:
                    aVar = pc2.a.n;
                    break;
                case 14:
                    aVar = pc2.a.o;
                    break;
                case 15:
                    aVar = pc2.a.p;
                    break;
                case 16:
                    aVar = pc2.a.q;
                    break;
                case 17:
                    aVar = pc2.a.r;
                    break;
                case 18:
                    aVar = pc2.a.s;
                    break;
                case 19:
                    aVar = pc2.a.t;
                    break;
                case 20:
                    aVar = pc2.a.u;
                    break;
                case 21:
                    aVar = pc2.a.v;
                    break;
                case 22:
                    aVar = pc2.a.w;
                    break;
                case 23:
                    aVar = pc2.a.x;
                    break;
                case 24:
                    aVar = pc2.a.y;
                    break;
                case 25:
                    aVar = pc2.a.z;
                    break;
                case 26:
                    aVar = pc2.a.A;
                    break;
                case 27:
                    aVar = pc2.a.B;
                    break;
                case 28:
                    aVar = pc2.a.C;
                    break;
                case 29:
                    aVar = pc2.a.D;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            this.f8519a.a(do0VarA, new pc2(aVar, instreamAdPlayerError.getUnderlyingError()));
            this.b.b(videoAd);
        }
    }

    @Override // com.yandex.mobile.ads.instream.player.ad.InstreamAdPlayerListener
    public final void onVolumeChanged(VideoAd videoAd, float f) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        do0 do0VarA = this.b.a(videoAd);
        if (do0VarA != null) {
            this.f8519a.a(do0VarA, f);
        }
    }
}
