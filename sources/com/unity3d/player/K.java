package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.view.PixelCopy;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes12.dex */
final class K implements PixelCopy.OnPixelCopyFinishedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Semaphore f8228a;
    final /* synthetic */ L b;

    K(L l, Semaphore semaphore) {
        this.b = l;
        this.f8228a = semaphore;
    }

    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
    public final void onPixelCopyFinished(int i) {
        this.f8228a.release();
        if (i == 0) {
            Context context = this.b.b.f8233a;
            if (context instanceof Activity) {
                ((Activity) context).runOnUiThread(new J(this));
            }
        }
    }
}
