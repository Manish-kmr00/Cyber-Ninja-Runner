package com.five_corp.ad.internal.view;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes10.dex */
public final class C implements com.five_corp.ad.internal.cache.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ D f1564a;

    public C(D d) {
        this.f1564a = d;
    }

    @Override // com.five_corp.ad.internal.cache.e
    public final void a(com.five_corp.ad.internal.o oVar) {
        this.f1564a.d.a(0, oVar);
    }

    @Override // com.five_corp.ad.internal.cache.e
    public final void a(Bitmap bitmap) {
        this.f1564a.l = new ImageView(this.f1564a.f1566a);
        this.f1564a.l.setImageBitmap(bitmap);
        D d = this.f1564a;
        C3050h c3050h = d.c;
        c3050h.addView(d.l, c3050h.f1571a);
        com.five_corp.ad.f fVar = this.f1564a.d;
        fVar.r = true;
        fVar.k = Long.MAX_VALUE;
        com.five_corp.ad.internal.w wVar = fVar.o;
        if (wVar.m) {
            return;
        }
        wVar.m = true;
        if (wVar.g.d.b.g) {
            wVar.a(16, 0L, 0.0d, null, null);
        }
    }
}
