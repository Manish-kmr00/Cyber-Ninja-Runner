package com.inmobi.media;

import android.content.Context;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.v8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class RunnableC3598v8 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f3458a;
    public final WeakReference b;

    public RunnableC3598v8(Context context, ImageView imageView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        this.f3458a = new WeakReference(context);
        this.b = new WeakReference(imageView);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context = (Context) this.f3458a.get();
        ImageView imageView = (ImageView) this.b.get();
        if (context == null || imageView == null) {
            return;
        }
        HashMap map = K8.c;
        C3584u8.a(context, imageView);
    }
}
