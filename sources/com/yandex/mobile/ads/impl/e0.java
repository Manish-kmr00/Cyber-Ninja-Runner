package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final cp1 f8747a;
    private final vv0 b;
    private final d0 c;

    public final ma1 a(Context context, pe2 videoOptions, wv0 customControls, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(videoOptions, "videoOptions");
        Intrinsics.checkNotNullParameter(customControls, "customControls");
        ma1 actionViewsContainer = new ma1(context, this.f8747a.a(context), this.b.a(context, i, customControls));
        this.c.getClass();
        Intrinsics.checkNotNullParameter(actionViewsContainer, "actionViewsContainer");
        Intrinsics.checkNotNullParameter(videoOptions, "videoOptions");
        wv0 wv0VarA = actionViewsContainer.a();
        actionViewsContainer.b().setVisibility(8);
        CheckBox muteControl = wv0VarA != null ? wv0VarA.getMuteControl() : null;
        if (muteControl != null) {
            muteControl.setVisibility(8);
        }
        ProgressBar videoProgress = wv0VarA != null ? wv0VarA.getVideoProgress() : null;
        if (videoProgress != null) {
            videoProgress.setVisibility(8);
        }
        TextView countDownProgress = wv0VarA != null ? wv0VarA.getCountDownProgress() : null;
        if (countDownProgress != null) {
            countDownProgress.setVisibility(8);
        }
        CheckBox muteControl2 = wv0VarA != null ? wv0VarA.getMuteControl() : null;
        if (muteControl2 != null) {
            muteControl2.setChecked(videoOptions.e());
        }
        return actionViewsContainer;
    }

    public /* synthetic */ e0() {
        this(new cp1(), new vv0(), new d0());
    }

    public e0(cp1 replayActionViewCreator, vv0 controlsContainerCreator, d0 mediaControlsContainerConfigurator) {
        Intrinsics.checkNotNullParameter(replayActionViewCreator, "replayActionViewCreator");
        Intrinsics.checkNotNullParameter(controlsContainerCreator, "controlsContainerCreator");
        Intrinsics.checkNotNullParameter(mediaControlsContainerConfigurator, "mediaControlsContainerConfigurator");
        this.f8747a = replayActionViewCreator;
        this.b = controlsContainerCreator;
        this.c = mediaControlsContainerConfigurator;
    }
}
