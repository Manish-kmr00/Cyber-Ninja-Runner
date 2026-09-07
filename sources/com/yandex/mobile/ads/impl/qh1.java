package com.yandex.mobile.ads.impl;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class qh1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final pl f10019a;
    private final n3 b;
    private final m5 c;
    private final p5 d;
    private final a5 e;
    private final ri1 f;
    private final y60 g;
    private final wf2 h;
    private int i;
    private int j;

    public qh1(pl bindingControllerHolder, pi1 playerStateController, p9 adStateDataController, ee2 videoCompletedNotifier, g80 fakePositionConfigurator, n3 adCompletionListener, m5 adPlaybackConsistencyManager, p5 adPlaybackStateController, a5 adInfoStorage, ri1 playerStateHolder, y60 playerProvider, wf2 videoStateUpdateController) {
        Intrinsics.checkNotNullParameter(bindingControllerHolder, "bindingControllerHolder");
        Intrinsics.checkNotNullParameter(playerStateController, "playerStateController");
        Intrinsics.checkNotNullParameter(adStateDataController, "adStateDataController");
        Intrinsics.checkNotNullParameter(videoCompletedNotifier, "videoCompletedNotifier");
        Intrinsics.checkNotNullParameter(fakePositionConfigurator, "fakePositionConfigurator");
        Intrinsics.checkNotNullParameter(adCompletionListener, "adCompletionListener");
        Intrinsics.checkNotNullParameter(adPlaybackConsistencyManager, "adPlaybackConsistencyManager");
        Intrinsics.checkNotNullParameter(adPlaybackStateController, "adPlaybackStateController");
        Intrinsics.checkNotNullParameter(adInfoStorage, "adInfoStorage");
        Intrinsics.checkNotNullParameter(playerStateHolder, "playerStateHolder");
        Intrinsics.checkNotNullParameter(playerProvider, "playerProvider");
        Intrinsics.checkNotNullParameter(videoStateUpdateController, "videoStateUpdateController");
        this.f10019a = bindingControllerHolder;
        this.b = adCompletionListener;
        this.c = adPlaybackConsistencyManager;
        this.d = adPlaybackStateController;
        this.e = adInfoStorage;
        this.f = playerStateHolder;
        this.g = playerProvider;
        this.h = videoStateUpdateController;
        this.i = -1;
        this.j = -1;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x006a  */
    public final void a() {
        boolean z;
        Player playerA = this.g.a();
        if (!this.f10019a.b() || playerA == null) {
            return;
        }
        this.h.a(playerA);
        boolean zC = this.f.c();
        boolean zIsPlayingAd = playerA.isPlayingAd();
        int currentAdGroupIndex = playerA.getCurrentAdGroupIndex();
        int currentAdIndexInAdGroup = playerA.getCurrentAdIndexInAdGroup();
        this.f.a(zIsPlayingAd);
        int i = zIsPlayingAd ? currentAdGroupIndex : this.i;
        int i2 = this.j;
        this.j = currentAdIndexInAdGroup;
        this.i = currentAdGroupIndex;
        v4 v4Var = new v4(i, i2);
        do0 do0VarA = this.e.a(v4Var);
        if (zC) {
            AdPlaybackState adPlaybackStateA = this.d.a();
            if ((adPlaybackStateA.adGroupCount <= i || i == -1 || adPlaybackStateA.getAdGroup(i).timeUs != Long.MIN_VALUE || playerA.isPlaying()) && (currentAdIndexInAdGroup == -1 || i2 < currentAdIndexInAdGroup)) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        if (do0VarA != null && z) {
            this.b.a(v4Var, do0VarA);
        }
        this.c.a(playerA, zC);
    }
}
