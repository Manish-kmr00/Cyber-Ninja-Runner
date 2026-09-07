package com.yandex.mobile.ads.impl;

import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class th1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final jg2 f10301a;
    private final fc2 b;
    private final wb1 c;
    private final gf2 d;
    private final a e;

    public th1(jg2 videoViewAdapter, fc2 playbackController, wb1 controlsConfigurator, jl1 progressBarConfigurator) {
        Intrinsics.checkNotNullParameter(videoViewAdapter, "videoViewAdapter");
        Intrinsics.checkNotNullParameter(playbackController, "playbackController");
        Intrinsics.checkNotNullParameter(controlsConfigurator, "controlsConfigurator");
        Intrinsics.checkNotNullParameter(progressBarConfigurator, "progressBarConfigurator");
        this.f10301a = videoViewAdapter;
        this.b = playbackController;
        this.c = controlsConfigurator;
        this.d = new gf2(controlsConfigurator, progressBarConfigurator);
        this.e = new a();
    }

    private final class a implements lc2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private lc2 f10302a;

        public a() {
        }

        @Override // com.yandex.mobile.ads.impl.lc2
        public final void c() {
            ub1 ub1VarB = th1.this.f10301a.b();
            if (ub1VarB != null) {
                th1.this.d.a(ub1VarB);
            }
            lc2 lc2Var = this.f10302a;
            if (lc2Var != null) {
                lc2Var.c();
            }
        }

        @Override // com.yandex.mobile.ads.impl.lc2
        public final void b() {
            ub1 ub1VarB = th1.this.f10301a.b();
            if (ub1VarB != null) {
                ma1 ma1VarA = ub1VarB.a();
                wb1 wb1Var = th1.this.c;
                wv0 wv0VarA = ma1VarA.a();
                wb1Var.getClass();
                if (wv0VarA != null) {
                    CheckBox muteControl = wv0VarA.getMuteControl();
                    if (muteControl != null) {
                        muteControl.setOnClickListener(null);
                        muteControl.setVisibility(8);
                    }
                    ProgressBar videoProgress = wv0VarA.getVideoProgress();
                    if (videoProgress != null) {
                        videoProgress.setProgress(0);
                        videoProgress.setVisibility(8);
                    }
                    TextView countDownProgress = wv0VarA.getCountDownProgress();
                    if (countDownProgress != null) {
                        countDownProgress.setText("");
                        countDownProgress.setVisibility(8);
                    }
                }
            }
            lc2 lc2Var = this.f10302a;
            if (lc2Var != null) {
                lc2Var.b();
            }
        }

        @Override // com.yandex.mobile.ads.impl.lc2
        public final void a() {
            lc2 lc2Var = this.f10302a;
            if (lc2Var != null) {
                lc2Var.a();
            }
        }

        public final void a(lc2 lc2Var) {
            this.f10302a = lc2Var;
        }
    }

    public final void a(lc2 lc2Var) {
        this.e.a(lc2Var);
    }

    public final void a() {
        this.b.a(this.e);
        this.b.play();
    }

    public final void a(ub1 videoView) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        this.b.stop();
        ma1 ma1VarA = videoView.a();
        wb1 wb1Var = this.c;
        wv0 wv0VarA = ma1VarA.a();
        wb1Var.getClass();
        if (wv0VarA != null) {
            CheckBox muteControl = wv0VarA.getMuteControl();
            if (muteControl != null) {
                muteControl.setOnClickListener(null);
                muteControl.setVisibility(8);
            }
            ProgressBar videoProgress = wv0VarA.getVideoProgress();
            if (videoProgress != null) {
                videoProgress.setProgress(0);
                videoProgress.setVisibility(8);
            }
            TextView countDownProgress = wv0VarA.getCountDownProgress();
            if (countDownProgress != null) {
                countDownProgress.setText("");
                countDownProgress.setVisibility(8);
            }
        }
    }
}
