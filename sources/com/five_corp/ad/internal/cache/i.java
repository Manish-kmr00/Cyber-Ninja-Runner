package com.five_corp.ad.internal.cache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes13.dex */
public final class i implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f1343a;
    public final String b;
    public final Handler c;
    public final Object d = new Object();
    public boolean e = false;
    public WeakReference f = null;
    public com.five_corp.ad.internal.util.h g = new com.five_corp.ad.internal.util.h();

    public i(o oVar, String str, Handler handler) {
        this.f1343a = oVar;
        this.b = str;
        this.c = handler;
    }

    public final void a(e eVar) {
        synchronized (this.d) {
            if (this.e) {
                this.g.f1561a.add(new WeakReference(eVar));
                return;
            }
            WeakReference weakReference = this.f;
            Bitmap bitmap = weakReference != null ? (Bitmap) weakReference.get() : null;
            if (bitmap == null) {
                this.g.f1561a.add(new WeakReference(eVar));
                this.f = null;
                this.e = true;
            }
            if (bitmap != null) {
                this.c.post(new h(eVar, bitmap));
            } else {
                this.f1343a.a(this);
            }
        }
    }

    public final void b(com.five_corp.ad.internal.o oVar) {
        ArrayList arrayList;
        synchronized (this.d) {
            this.e = false;
            com.five_corp.ad.internal.util.h hVar = this.g;
            hVar.getClass();
            arrayList = new ArrayList();
            hVar.a(arrayList);
            this.g = new com.five_corp.ad.internal.util.h();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.c.post(new g((e) it.next(), oVar));
        }
    }

    @Override // com.five_corp.ad.internal.cache.m
    public final void a(com.five_corp.ad.internal.o oVar) {
        b(oVar);
    }

    @Override // com.five_corp.ad.internal.cache.m
    public final void a(String str) {
        com.five_corp.ad.internal.util.f fVar;
        ArrayList arrayList;
        try {
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str);
            if (bitmapDecodeFile == null) {
                fVar = new com.five_corp.ad.internal.util.f(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.L, "BitmapFactory.decodeFile return null: URL: " + this.b + ".", null, null), null);
            } else {
                fVar = new com.five_corp.ad.internal.util.f(true, null, bitmapDecodeFile);
            }
        } catch (OutOfMemoryError e) {
            fVar = new com.five_corp.ad.internal.util.f(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.M, "BitmapFactory.decodeFile raise OutOfMemoryError: URL: " + this.b + ".", e, null), null);
        }
        if (!fVar.f1560a) {
            b(fVar.b);
            return;
        }
        synchronized (this.d) {
            this.e = false;
            this.f = new WeakReference((Bitmap) fVar.c);
            com.five_corp.ad.internal.util.h hVar = this.g;
            hVar.getClass();
            arrayList = new ArrayList();
            hVar.a(arrayList);
            this.g = new com.five_corp.ad.internal.util.h();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.c.post(new h((e) it.next(), (Bitmap) fVar.c));
        }
    }
}
