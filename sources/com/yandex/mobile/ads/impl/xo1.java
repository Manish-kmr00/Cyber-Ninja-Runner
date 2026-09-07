package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class xo1 {
    public static void a(ub1 nativeVideoView, ap1 replayActionView, Bitmap background) {
        Intrinsics.checkNotNullParameter(nativeVideoView, "nativeVideoView");
        Intrinsics.checkNotNullParameter(replayActionView, "replayActionView");
        Intrinsics.checkNotNullParameter(background, "background");
        replayActionView.setAlpha(0.0f);
        replayActionView.animate().alpha(1.0f).setDuration(700L).withStartAction(new b(replayActionView, background)).withEndAction(new a(nativeVideoView, replayActionView)).start();
    }

    private static final class b implements Runnable {
        private final ap1 b;
        private final Bitmap c;

        public b(ap1 replayActionView, Bitmap background) {
            Intrinsics.checkNotNullParameter(replayActionView, "replayActionView");
            Intrinsics.checkNotNullParameter(background, "background");
            this.b = replayActionView;
            this.c = background;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.b.setBackground(new BitmapDrawable(this.b.getResources(), this.c));
            this.b.setVisibility(0);
        }
    }

    private static final class a implements Runnable {
        private final ub1 b;
        private final ap1 c;

        public a(ub1 nativeVideoView, ap1 replayActionView) {
            Intrinsics.checkNotNullParameter(nativeVideoView, "nativeVideoView");
            Intrinsics.checkNotNullParameter(replayActionView, "replayActionView");
            this.b = nativeVideoView;
            this.c = replayActionView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.b.c().setVisibility(4);
            this.c.a().setVisibility(0);
        }
    }
}
