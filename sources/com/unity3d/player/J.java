package com.unity3d.player;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes12.dex */
final class J implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ K f8225a;

    J(K k) {
        this.f8225a = k;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f8225a.b.setBackground(new LayerDrawable(new Drawable[]{new ColorDrawable(ViewCompat.MEASURED_STATE_MASK), new BitmapDrawable(this.f8225a.b.getResources(), this.f8225a.b.f8231a)}));
    }
}
