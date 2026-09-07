package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes11.dex */
public class lj0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bq1 f9528a;
    private final b b;
    private final HashMap<String, a> c = new HashMap<>();
    private final HashMap<String, a> d = new HashMap<>();
    private final Handler e = new Handler(Looper.getMainLooper());
    private Runnable f;

    /* JADX INFO: Access modifiers changed from: private */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final np1<?> f9529a;
        private Bitmap b;
        private ki2 c;
        private final ArrayList d;

        public a(qj0 qj0Var, c cVar) {
            ArrayList arrayList = new ArrayList();
            this.d = arrayList;
            this.f9529a = qj0Var;
            arrayList.add(cVar);
        }
    }

    public interface b {
        Bitmap a(String str);

        void a(String str, Bitmap bitmap);
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Bitmap f9530a;
        private final d b;
        private final String c;

        public final void a() {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                throw new IllegalStateException("Must be invoked from the main thread.");
            }
            if (this.b == null) {
                return;
            }
            a aVar = (a) lj0.this.c.get(this.c);
            if (aVar != null) {
                aVar.d.remove(this);
                if (aVar.d.size() == 0) {
                    aVar.f9529a.a();
                    lj0.this.c.remove(this.c);
                    return;
                }
                return;
            }
            a aVar2 = (a) lj0.this.d.get(this.c);
            if (aVar2 != null) {
                aVar2.d.remove(this);
                if (aVar2.d.size() == 0) {
                    aVar2.f9529a.a();
                }
                if (aVar2.d.size() == 0) {
                    lj0.this.d.remove(this.c);
                }
            }
        }

        public c(Bitmap bitmap, String str, d dVar) {
            this.f9530a = bitmap;
            this.c = str;
            this.b = dVar;
        }

        public final Bitmap b() {
            return this.f9530a;
        }
    }

    public interface d extends qq1.a {
        void a(c cVar, boolean z);
    }

    public final c a(String str, d dVar, int i, int i2) {
        ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER_INSIDE;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("Must be invoked from the main thread.");
        }
        String strA = a(str, i, i2, scaleType);
        Bitmap bitmapA = this.b.a(strA);
        if (bitmapA != null) {
            c cVar = new c(bitmapA, null, null);
            dVar.a(cVar, true);
            return cVar;
        }
        c cVar2 = new c(null, strA, dVar);
        dVar.a(cVar2, true);
        a aVar = this.c.get(strA);
        if (aVar == null) {
            aVar = this.d.get(strA);
        }
        if (aVar != null) {
            aVar.d.add(cVar2);
        } else {
            qj0 qj0Var = new qj0(str, new ij0(this, strA), i, i2, scaleType, Bitmap.Config.RGB_565, new jj0(this, strA));
            this.f9528a.a(qj0Var);
            this.c.put(strA, new a(qj0Var, cVar2));
        }
        return cVar2;
    }

    public String a(String str, int i, int i2, ImageView.ScaleType scaleType) {
        throw null;
    }

    public lj0(bq1 bq1Var, ed1.b bVar) {
        this.f9528a = bq1Var;
        this.b = bVar;
    }
}
