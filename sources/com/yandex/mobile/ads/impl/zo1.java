package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class zo1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final jg2 f10841a;
    private final rl b;
    private final bp1 c;
    private final xo1 d;

    public zo1(jg2 videoViewAdapter, fp1 replayController) {
        Intrinsics.checkNotNullParameter(videoViewAdapter, "videoViewAdapter");
        Intrinsics.checkNotNullParameter(replayController, "replayController");
        this.f10841a = videoViewAdapter;
        this.b = new rl();
        this.c = new bp1(videoViewAdapter, replayController);
        this.d = new xo1();
    }

    public final void a() {
        ub1 ub1VarB = this.f10841a.b();
        if (ub1VarB != null) {
            ap1 ap1VarB = ub1VarB.a().b();
            this.c.a(ap1VarB);
            Bitmap bitmap = ub1VarB.c().getBitmap();
            if (bitmap != null) {
                this.b.a(bitmap, new yo1(this, ub1VarB, ap1VarB));
            }
        }
    }
}
