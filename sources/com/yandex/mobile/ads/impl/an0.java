package com.yandex.mobile.ads.impl;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.source.ads.AdsLoader;
import com.google.android.exoplayer2.ui.AdOverlayInfo;
import com.google.android.exoplayer2.ui.AdViewProvider;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class an0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r5 f8425a;
    private final nl b;
    private final pl c;
    private final gs0 d;
    private final m60 e;
    private final qj1 f;
    private final Player.Listener g;
    private final fb2 h;
    private final r9 i;
    private final p5 j;
    private final y60 k;
    private final ri1 l;
    private bt m;
    private Player n;
    private Object o;
    private boolean p;
    private boolean q;

    public an0(p9 adStateDataController, r5 adPlaybackStateCreator, nl bindingControllerCreator, pl bindingControllerHolder, gs0 loadingController, pi1 playerStateController, m60 exoPlayerAdPrepareHandler, qj1 positionProviderHolder, t60 playerListener, fb2 videoAdCreativePlaybackProxyListener, r9 adStateHolder, p5 adPlaybackStateController, y60 currentExoPlayerProvider, ri1 playerStateHolder) {
        Intrinsics.checkNotNullParameter(adStateDataController, "adStateDataController");
        Intrinsics.checkNotNullParameter(adPlaybackStateCreator, "adPlaybackStateCreator");
        Intrinsics.checkNotNullParameter(bindingControllerCreator, "bindingControllerCreator");
        Intrinsics.checkNotNullParameter(bindingControllerHolder, "bindingControllerHolder");
        Intrinsics.checkNotNullParameter(loadingController, "loadingController");
        Intrinsics.checkNotNullParameter(playerStateController, "playerStateController");
        Intrinsics.checkNotNullParameter(exoPlayerAdPrepareHandler, "exoPlayerAdPrepareHandler");
        Intrinsics.checkNotNullParameter(positionProviderHolder, "positionProviderHolder");
        Intrinsics.checkNotNullParameter(playerListener, "playerListener");
        Intrinsics.checkNotNullParameter(videoAdCreativePlaybackProxyListener, "videoAdCreativePlaybackProxyListener");
        Intrinsics.checkNotNullParameter(adStateHolder, "adStateHolder");
        Intrinsics.checkNotNullParameter(adPlaybackStateController, "adPlaybackStateController");
        Intrinsics.checkNotNullParameter(currentExoPlayerProvider, "currentExoPlayerProvider");
        Intrinsics.checkNotNullParameter(playerStateHolder, "playerStateHolder");
        this.f8425a = adPlaybackStateCreator;
        this.b = bindingControllerCreator;
        this.c = bindingControllerHolder;
        this.d = loadingController;
        this.e = exoPlayerAdPrepareHandler;
        this.f = positionProviderHolder;
        this.g = playerListener;
        this.h = videoAdCreativePlaybackProxyListener;
        this.i = adStateHolder;
        this.j = adPlaybackStateController;
        this.k = currentExoPlayerProvider;
        this.l = playerStateHolder;
    }

    public static final void b(an0 an0Var, bt btVar) {
        an0Var.j.a(an0Var.f8425a.a(btVar, an0Var.o));
    }

    public final void b() {
        Player playerA = this.k.a();
        if (playerA != null) {
            if (this.m != null) {
                long jMsToUs = Util.msToUs(playerA.getCurrentPosition());
                if (!playerA.isPlayingAd()) {
                    jMsToUs = 0;
                }
                AdPlaybackState adPlaybackStateWithAdResumePositionUs = this.j.a().withAdResumePositionUs(jMsToUs);
                Intrinsics.checkNotNullExpressionValue(adPlaybackStateWithAdResumePositionUs, "withAdResumePositionUs(...)");
                this.j.a(adPlaybackStateWithAdResumePositionUs);
            }
            playerA.removeListener(this.g);
            this.j.a((AdsLoader.EventListener) null);
            this.k.a((Player) null);
            this.p = true;
        }
    }

    private final class a implements gs0.b {
        @Override // com.yandex.mobile.ads.impl.gs0.b
        public final void a(ViewGroup viewGroup, List<pb2> friendlyOverlays, bt loadedInstreamAd) {
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            Intrinsics.checkNotNullParameter(friendlyOverlays, "friendlyOverlays");
            Intrinsics.checkNotNullParameter(loadedInstreamAd, "loadedInstreamAd");
            an0.this.q = false;
            an0.this.m = loadedInstreamAd;
            bt btVar = an0.this.m;
            if (btVar != null) {
                an0.this.getClass();
                btVar.b();
            }
            ll llVarA = an0.this.b.a(viewGroup, friendlyOverlays, loadedInstreamAd);
            an0.this.c.a(llVarA);
            llVarA.a(an0.this.h);
            llVarA.c();
            llVarA.d();
            if (an0.this.k.b()) {
                an0.this.p = true;
                an0.b(an0.this, loadedInstreamAd);
            }
        }

        public a() {
        }

        @Override // com.yandex.mobile.ads.impl.gs0.b
        public final void a(String reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            an0.this.q = false;
            p5 p5Var = an0.this.j;
            AdPlaybackState NONE = AdPlaybackState.NONE;
            Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
            p5Var.a(NONE);
        }
    }

    public final void a(int i, int i2) {
        this.e.a(i, i2);
    }

    public final void a(int i, int i2, IOException exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        this.e.b(i, i2, exception);
    }

    public final void a(ViewGroup viewGroup, List<pb2> list) {
        if (this.q || this.m != null || viewGroup == null) {
            return;
        }
        this.q = true;
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        this.d.a(viewGroup, list, new a());
    }

    public final void a() {
        this.q = false;
        this.p = false;
        this.m = null;
        this.f.a((li1) null);
        this.i.a();
        this.i.a((yi1) null);
        this.c.c();
        this.j.b();
        this.d.a();
        this.h.a((io0) null);
        ll llVarA = this.c.a();
        if (llVarA != null) {
            llVarA.c();
        }
        ll llVarA2 = this.c.a();
        if (llVarA2 != null) {
            llVarA2.d();
        }
    }

    public final void a(in2 in2Var) {
        this.h.a(in2Var);
    }

    public final void a(Player player) {
        this.n = player;
    }

    public final void a(AdsLoader.EventListener eventListener, AdViewProvider adViewProvider, Object obj) {
        pb2.a aVar;
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        Player player = this.n;
        this.k.a(player);
        this.o = obj;
        if (player != null) {
            player.addListener(this.g);
            this.j.a(eventListener);
            this.f.a(new li1(player, this.l));
            if (this.p) {
                this.j.a(this.j.a());
                ll llVarA = this.c.a();
                if (llVarA != null) {
                    llVarA.a();
                    return;
                }
                return;
            }
            bt btVar = this.m;
            if (btVar != null) {
                this.j.a(this.f8425a.a(btVar, this.o));
                return;
            }
            if (adViewProvider != null) {
                ViewGroup adViewGroup = adViewProvider.getAdViewGroup();
                ArrayList arrayList = new ArrayList();
                for (AdOverlayInfo adOverlayInfo : adViewProvider.getAdOverlayInfos()) {
                    Intrinsics.checkNotNull(adOverlayInfo);
                    Intrinsics.checkNotNullParameter(adOverlayInfo, "adOverlayInfo");
                    View view = adOverlayInfo.view;
                    Intrinsics.checkNotNullExpressionValue(view, "view");
                    int i = adOverlayInfo.purpose;
                    if (i == 1) {
                        aVar = pb2.a.b;
                    } else if (i == 2) {
                        aVar = pb2.a.c;
                    } else if (i != 4) {
                        aVar = pb2.a.e;
                    } else {
                        aVar = pb2.a.d;
                    }
                    arrayList.add(new pb2(view, aVar, adOverlayInfo.reasonDetail));
                }
                a(adViewGroup, arrayList);
            }
        }
    }
}
