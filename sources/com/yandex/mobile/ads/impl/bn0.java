package com.yandex.mobile.ads.impl;

import android.view.View;
import android.view.ViewGroup;
import androidx.media3.common.AdOverlayInfo;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.AdViewProvider;
import androidx.media3.common.Player;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.ads.AdsLoader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class bn0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q5 f8521a;
    private final ml b;
    private final ol c;
    private final hs0 d;
    private final l60 e;
    private final pj1 f;
    private final Player.Listener g;
    private final fb2 h;
    private final q9 i;
    private final o5 j;
    private final x60 k;
    private final qi1 l;
    private bt m;
    private Player n;
    private Object o;
    private boolean p;
    private boolean q;

    public bn0(o9 adStateDataController, q5 adPlaybackStateCreator, ml bindingControllerCreator, ol bindingControllerHolder, hs0 loadingController, oi1 playerStateController, l60 exoPlayerAdPrepareHandler, pj1 positionProviderHolder, s60 playerListener, fb2 videoAdCreativePlaybackProxyListener, q9 adStateHolder, o5 adPlaybackStateController, x60 currentExoPlayerProvider, qi1 playerStateHolder) {
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
        this.f8521a = adPlaybackStateCreator;
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

    public static final void b(bn0 bn0Var, bt btVar) {
        bn0Var.j.a(bn0Var.f8521a.a(btVar, bn0Var.o));
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

    private final class a implements hs0.b {
        @Override // com.yandex.mobile.ads.impl.hs0.b
        public final void a(ViewGroup viewGroup, List<pb2> friendlyOverlays, bt loadedInstreamAd) {
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            Intrinsics.checkNotNullParameter(friendlyOverlays, "friendlyOverlays");
            Intrinsics.checkNotNullParameter(loadedInstreamAd, "loadedInstreamAd");
            bn0.this.q = false;
            bn0.this.m = loadedInstreamAd;
            bt btVar = bn0.this.m;
            if (btVar != null) {
                bn0.this.getClass();
                btVar.b();
            }
            kl klVarA = bn0.this.b.a(viewGroup, friendlyOverlays, loadedInstreamAd);
            bn0.this.c.a(klVarA);
            klVarA.a(bn0.this.h);
            klVarA.c();
            klVarA.d();
            if (bn0.this.k.b()) {
                bn0.this.p = true;
                bn0.b(bn0.this, loadedInstreamAd);
            }
        }

        public a() {
        }

        @Override // com.yandex.mobile.ads.impl.hs0.b
        public final void a(String reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            bn0.this.q = false;
            o5 o5Var = bn0.this.j;
            AdPlaybackState NONE = AdPlaybackState.NONE;
            Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
            o5Var.a(NONE);
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
        this.f.a((ki1) null);
        this.i.a();
        this.i.a((xi1) null);
        this.c.c();
        this.j.b();
        this.d.a();
        this.h.a((io0) null);
        kl klVarA = this.c.a();
        if (klVarA != null) {
            klVarA.c();
        }
        kl klVarA2 = this.c.a();
        if (klVarA2 != null) {
            klVarA2.d();
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
            this.f.a(new ki1(player, this.l));
            if (this.p) {
                this.j.a(this.j.a());
                kl klVarA = this.c.a();
                if (klVarA != null) {
                    klVarA.a();
                    return;
                }
                return;
            }
            bt btVar = this.m;
            if (btVar != null) {
                this.j.a(this.f8521a.a(btVar, this.o));
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
