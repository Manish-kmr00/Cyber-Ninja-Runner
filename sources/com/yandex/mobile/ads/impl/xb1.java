package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.TextureView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class xb1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e0 f10638a;
    private final te2 b;

    public final ub1 a(Context context, pe2 videoOptions, wv0 customControls, db2 db2Var, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(videoOptions, "videoOptions");
        Intrinsics.checkNotNullParameter(customControls, "customControls");
        TextureView textureView = new TextureView(context);
        textureView.setVisibility(8);
        ma1 ma1VarA = this.f10638a.a(context, videoOptions, customControls, i);
        ma1VarA.setVisibility(8);
        se2 se2VarA = this.b.a(context, db2Var);
        se2VarA.setVisibility(8);
        ub1 ub1Var = new ub1(context, se2VarA, textureView, ma1VarA);
        ub1Var.addView(se2VarA);
        ub1Var.addView(textureView);
        ub1Var.addView(ma1VarA);
        ub1Var.setTag(mh2.a("native_video_view"));
        return ub1Var;
    }

    public /* synthetic */ xb1() {
        this(new e0(), new te2());
    }

    public xb1(e0 actionViewsContainerCreator, te2 placeholderViewCreator) {
        Intrinsics.checkNotNullParameter(actionViewsContainerCreator, "actionViewsContainerCreator");
        Intrinsics.checkNotNullParameter(placeholderViewCreator, "placeholderViewCreator");
        this.f10638a = actionViewsContainerCreator;
        this.b = placeholderViewCreator;
    }
}
