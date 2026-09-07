package com.yandex.mobile.ads.impl;

import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.Player;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class ph1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ol f9927a;
    private final m3 b;
    private final l5 c;
    private final o5 d;
    private final z4 e;
    private final qi1 f;
    private final x60 g;
    private final vf2 h;
    private int i;
    private int j;

    public ph1(ol bindingControllerHolder, oi1 playerStateController, o9 adStateDataController, de2 videoCompletedNotifier, f80 fakePositionConfigurator, m3 adCompletionListener, l5 adPlaybackConsistencyManager, o5 adPlaybackStateController, z4 adInfoStorage, qi1 playerStateHolder, x60 playerProvider, vf2 videoStateUpdateController) {
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
        this.f9927a = bindingControllerHolder;
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
        if (!this.f9927a.b() || playerA == null) {
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
        u4 u4Var = new u4(i, i2);
        do0 do0VarA = this.e.a(u4Var);
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
            this.b.a(u4Var, do0VarA);
        }
        this.c.a(playerA, zC);
    }
}
