package com.unity3d.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.PixelCopy;
import android.view.SurfaceView;
import android.view.View;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes12.dex */
final class L extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Bitmap f8231a;
    final /* synthetic */ M b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    L(M m, Context context) {
        super(context);
        this.b = m;
    }

    public final void a(SurfaceView surfaceView) {
        this.f8231a = Bitmap.createBitmap(surfaceView.getWidth(), surfaceView.getHeight(), Bitmap.Config.ARGB_8888);
        HandlerThread handlerThread = new HandlerThread("PlaceHolderView");
        handlerThread.start();
        Semaphore semaphore = new Semaphore(0);
        PixelCopy.request(surfaceView, this.f8231a, new K(this, semaphore), new Handler(handlerThread.getLooper()));
        try {
            if (!semaphore.tryAcquire(2000L, TimeUnit.MILLISECONDS)) {
                B.Log(5, "Timeout while copying surface view.");
            }
        } catch (InterruptedException e) {
            B.Log(6, e.getMessage());
        }
        handlerThread.quitSafely();
    }
}
