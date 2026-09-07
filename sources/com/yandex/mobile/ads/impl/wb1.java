package com.yandex.mobile.ads.impl;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class wb1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final pe2 f10552a;
    private final sa1 b;
    private final double c;

    public /* synthetic */ wb1(oa1 oa1Var, pe2 pe2Var) {
        this(oa1Var, pe2Var, new sa1(oa1Var));
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0034  */
    public wb1(oa1 nativeVideoAdPlayer, pe2 videoOptions, sa1 playerVolumeManager) {
        double dDoubleValue;
        Intrinsics.checkNotNullParameter(nativeVideoAdPlayer, "nativeVideoAdPlayer");
        Intrinsics.checkNotNullParameter(videoOptions, "videoOptions");
        Intrinsics.checkNotNullParameter(playerVolumeManager, "playerVolumeManager");
        this.f10552a = videoOptions;
        this.b = playerVolumeManager;
        Double dA = videoOptions.a();
        if (dA == null) {
            dDoubleValue = 1.0d;
        } else {
            dA = (dA.doubleValue() > 0.0d ? 1 : (dA.doubleValue() == 0.0d ? 0 : -1)) == 0 ? null : dA;
            if (dA != null) {
                dDoubleValue = dA.doubleValue();
            } else {
                dDoubleValue = 1.0d;
            }
        }
        this.c = dDoubleValue;
    }

    public final void a(wv0 wv0Var) {
        if (wv0Var != null) {
            final CheckBox muteControl = wv0Var.getMuteControl();
            if (muteControl != null) {
                muteControl.setOnClickListener(new View.OnClickListener() { // from class: com.yandex.mobile.ads.impl.wb1$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        wb1.a(this.f$0, muteControl, view);
                    }
                });
                muteControl.setVisibility(this.f10552a.d() ? 0 : 8);
            }
            ProgressBar videoProgress = wv0Var.getVideoProgress();
            if (videoProgress != null) {
                videoProgress.setVisibility(this.f10552a.b() ? 8 : 0);
            }
            TextView countDownProgress = wv0Var.getCountDownProgress();
            if (countDownProgress != null) {
                countDownProgress.setText("");
                countDownProgress.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(wb1 this$0, CheckBox checkBox, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b.a(Double.valueOf(!checkBox.isChecked() ? this$0.c : 0.0d));
    }
}
