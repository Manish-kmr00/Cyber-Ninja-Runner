package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.widget.Button;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class cp1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ep1 f8632a;

    public final ap1 a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Button buttonA = this.f8632a.a(context);
        buttonA.setTag(mh2.a("replay_button"));
        buttonA.setVisibility(8);
        ap1 ap1Var = new ap1(context, buttonA);
        ap1Var.addView(buttonA);
        return ap1Var;
    }

    public /* synthetic */ cp1() {
        this(new ep1());
    }

    public cp1(ep1 replayButtonCreator) {
        Intrinsics.checkNotNullParameter(replayButtonCreator, "replayButtonCreator");
        this.f8632a = replayButtonCreator;
    }
}
