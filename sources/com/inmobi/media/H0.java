package com.inmobi.media;

import android.graphics.Canvas;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class H0 implements Z3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnimatedImageDrawable f3086a;

    public H0(String filePath) throws IOException {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(new File(filePath)));
        Intrinsics.checkNotNull(drawableDecodeDrawable, "null cannot be cast to non-null type android.graphics.drawable.AnimatedImageDrawable");
        this.f3086a = (AnimatedImageDrawable) drawableDecodeDrawable;
    }

    @Override // com.inmobi.media.Z3
    public final void a(C3310b4 c3310b4) {
    }

    @Override // com.inmobi.media.Z3
    public final void a(boolean z) {
    }

    @Override // com.inmobi.media.Z3
    public final void b() {
    }

    @Override // com.inmobi.media.Z3
    public final boolean c() {
        return this.f3086a.isRunning();
    }

    @Override // com.inmobi.media.Z3
    public final int d() {
        return this.f3086a.getIntrinsicWidth();
    }

    public final void e() {
        this.f3086a.start();
    }

    @Override // com.inmobi.media.Z3
    public final void start() {
        this.f3086a.registerAnimationCallback(new G0(this));
        this.f3086a.start();
    }

    @Override // com.inmobi.media.Z3
    public final int a() {
        return this.f3086a.getIntrinsicHeight();
    }

    @Override // com.inmobi.media.Z3
    public final void a(Canvas canvas, float f, float f2) {
        Intrinsics.checkNotNull(canvas);
        canvas.translate(f, f2);
        this.f3086a.draw(canvas);
    }
}
