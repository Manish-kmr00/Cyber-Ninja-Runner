package com.yandex.mobile.ads.impl;

import android.widget.ProgressBar;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class if2 implements uc2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final jg2 f9212a;
    private final yd b;
    private final qu c;

    public /* synthetic */ if2(jg2 jg2Var) {
        this(jg2Var, new yd(), new qu());
    }

    public if2(jg2 videoViewAdapter, yd animatedProgressBarController, qu countDownProgressController) {
        Intrinsics.checkNotNullParameter(videoViewAdapter, "videoViewAdapter");
        Intrinsics.checkNotNullParameter(animatedProgressBarController, "animatedProgressBarController");
        Intrinsics.checkNotNullParameter(countDownProgressController, "countDownProgressController");
        this.f9212a = videoViewAdapter;
        this.b = animatedProgressBarController;
        this.c = countDownProgressController;
    }

    @Override // com.yandex.mobile.ads.impl.uc2
    public final void a(long j, long j2) {
        ub1 ub1VarB = this.f9212a.b();
        if (ub1VarB != null) {
            wv0 wv0VarA = ub1VarB.a().a();
            ProgressBar videoProgress = wv0VarA != null ? wv0VarA.getVideoProgress() : null;
            if (videoProgress != null) {
                this.b.getClass();
                yd.a(videoProgress, j, j2);
            }
            wv0 wv0VarA2 = ub1VarB.a().a();
            TextView countDownProgress = wv0VarA2 != null ? wv0VarA2.getCountDownProgress() : null;
            if (countDownProgress != null) {
                this.c.a(countDownProgress, j, j2);
            }
        }
    }
}
