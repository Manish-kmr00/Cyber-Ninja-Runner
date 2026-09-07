package com.yandex.mobile.ads.impl;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class q02 implements z<p02> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ay1 f9970a;
    private final y02 b;

    public q02(ay1 showSocialActionsReporter, y02 socialActionRenderer) {
        Intrinsics.checkNotNullParameter(showSocialActionsReporter, "showSocialActionsReporter");
        Intrinsics.checkNotNullParameter(socialActionRenderer, "socialActionRenderer");
        this.f9970a = showSocialActionsReporter;
        this.b = socialActionRenderer;
    }

    @Override // com.yandex.mobile.ads.impl.z
    public final df0 a(View view, x xVar) {
        p02 action = (p02) xVar;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(action, "action");
        this.f9970a.a(action.c());
        this.b.a(view, action);
        return new df0(false);
    }
}
