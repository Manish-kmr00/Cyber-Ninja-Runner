package com.five_corp.ad.internal.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.TextureView;
import android.view.ViewGroup;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes10.dex */
public final class B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final E f1563a;
    public final E b;
    public final ViewGroup c;
    public final TextureView d;
    public final Handler e;
    public final s f;
    public final ImageView g;

    public B(Context context, E e, E e2, ViewGroup viewGroup, com.five_corp.ad.internal.cache.f fVar, com.five_corp.ad.internal.ad.s sVar, TextureView textureView) {
        System.identityHashCode(this);
        this.f1563a = e;
        this.b = e2;
        this.c = viewGroup;
        this.d = textureView;
        Handler handler = new Handler(Looper.getMainLooper());
        this.e = handler;
        ImageView imageView = new ImageView(context);
        this.g = imageView;
        imageView.setVisibility(8);
        s sVar2 = new s(context);
        this.f = sVar2;
        sVar2.setVisibility(8);
        if (sVar != null) {
            handler.post(new t(this, fVar.a(context, sVar)));
        }
        handler.post(new t(this, textureView));
        handler.post(new t(this, imageView));
        handler.post(new t(this, sVar2));
    }

    public static void a(B b) {
        com.five_corp.ad.internal.util.f fVar;
        com.five_corp.ad.internal.util.f fVar2;
        b.getClass();
        try {
            Bitmap bitmap = b.d.getBitmap(Bitmap.createBitmap(b.d.getWidth(), b.d.getHeight(), Bitmap.Config.RGB_565));
            fVar2 = bitmap == null ? new com.five_corp.ad.internal.util.f(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.D3, null, null, null), null) : new com.five_corp.ad.internal.util.f(true, null, bitmap);
        } catch (Exception e) {
            fVar = new com.five_corp.ad.internal.util.f(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.F3, null, e, null), null);
            fVar2 = fVar;
        } catch (OutOfMemoryError e2) {
            fVar = new com.five_corp.ad.internal.util.f(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.E3, null, e2, null), null);
            fVar2 = fVar;
        }
        if (!fVar2.f1560a) {
            b.f1563a.a(fVar2.b);
        } else {
            b.g.setImageBitmap((Bitmap) fVar2.c);
            b.g.setVisibility(0);
        }
    }
}
