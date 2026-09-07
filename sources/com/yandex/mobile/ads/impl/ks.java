package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class ks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final eg2 f9445a;
    private final x31 b;
    private final hz1 c;
    private final kl1 d;
    private final gn0 e;

    public final void a(gb2 uiElements, in0 controlsState) {
        Intrinsics.checkNotNullParameter(uiElements, "uiElements");
        Intrinsics.checkNotNullParameter(controlsState, "controlsState");
        this.e.a(uiElements);
        this.b.a(uiElements, controlsState);
        View viewL = uiElements.l();
        if (viewL != null) {
            this.c.a(viewL, controlsState);
        }
        ProgressBar progressBar = uiElements.j();
        if (progressBar != null) {
            this.d.getClass();
            Intrinsics.checkNotNullParameter(progressBar, "progressBar");
            Intrinsics.checkNotNullParameter(controlsState, "controlsState");
            progressBar.setProgress((int) (progressBar.getMax() * controlsState.b()));
        }
    }

    public /* synthetic */ ks(Context context, zn0 zn0Var, dt dtVar, rb2 rb2Var, eg2 eg2Var, fb2 fb2Var) {
        this(context, zn0Var, dtVar, rb2Var, eg2Var, fb2Var, new x31(zn0Var), new hz1(zn0Var, (do0) rb2Var.d()), new kl1(), new gn0(dtVar, rb2Var));
    }

    public ks(Context context, zn0 instreamVastAdPlayer, dt adBreak, rb2 videoAdInfo, eg2 videoTracker, fb2 playbackListener, x31 muteControlConfigurator, hz1 skipControlConfigurator, kl1 progressBarConfigurator, gn0 instreamContainerTagConfigurator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(instreamVastAdPlayer, "instreamVastAdPlayer");
        Intrinsics.checkNotNullParameter(adBreak, "adBreak");
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        Intrinsics.checkNotNullParameter(videoTracker, "videoTracker");
        Intrinsics.checkNotNullParameter(playbackListener, "playbackListener");
        Intrinsics.checkNotNullParameter(muteControlConfigurator, "muteControlConfigurator");
        Intrinsics.checkNotNullParameter(skipControlConfigurator, "skipControlConfigurator");
        Intrinsics.checkNotNullParameter(progressBarConfigurator, "progressBarConfigurator");
        Intrinsics.checkNotNullParameter(instreamContainerTagConfigurator, "instreamContainerTagConfigurator");
        this.f9445a = videoTracker;
        this.b = muteControlConfigurator;
        this.c = skipControlConfigurator;
        this.d = progressBarConfigurator;
        this.e = instreamContainerTagConfigurator;
    }
}
