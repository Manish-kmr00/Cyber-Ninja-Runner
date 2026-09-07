package com.five_corp.ad.internal.fullscreen;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.five_corp.ad.AdActivity;
import com.five_corp.ad.e;
import com.five_corp.ad.f;
import com.five_corp.ad.internal.E;
import com.five_corp.ad.internal.ad.fullscreen.j;
import com.five_corp.ad.internal.context.l;
import com.five_corp.ad.internal.o;
import com.five_corp.ad.internal.p;
import com.five_corp.ad.internal.view.G;
import com.five_corp.ad.internal.view.J;
import com.five_corp.ad.internal.view.m;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AdActivity f1377a;
    public final G b;
    public final l c;
    public final j d;
    public final E e;
    public final com.five_corp.ad.internal.logger.a f;
    public final FrameLayout g;
    public final Handler h;
    public final f i;
    public final com.five_corp.ad.internal.viewability.a j;
    public m k;
    public m l;
    public final AtomicBoolean m = new AtomicBoolean(false);
    public final com.five_corp.ad.internal.layouter.j n;

    public c(AdActivity adActivity, G g, l lVar, j jVar, f fVar, E e, com.five_corp.ad.internal.logger.a aVar, com.five_corp.ad.internal.viewability.a aVar2, com.five_corp.ad.internal.layouter.j jVar2) {
        this.f1377a = adActivity;
        this.b = g;
        this.c = lVar;
        this.d = jVar;
        this.i = fVar;
        this.e = e;
        this.f = aVar;
        this.j = aVar2;
        int iA = J.a(jVar.d);
        FrameLayout frameLayout = new FrameLayout(adActivity);
        this.g = frameLayout;
        frameLayout.setBackgroundColor(iA);
        this.h = new Handler(Looper.getMainLooper());
        this.n = jVar2;
    }

    public static int a(Activity activity, int i) {
        int rotation = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay().getRotation();
        int iA = e.a(i);
        if (iA != 0) {
            if (iA == 1) {
                return rotation != 3 ? 0 : 8;
            }
            if (iA != 2) {
                return -1;
            }
            return rotation != 2 ? 1 : 9;
        }
        if (rotation == 1) {
            return 0;
        }
        if (rotation != 2) {
            return rotation != 3 ? 1 : 8;
        }
        return 9;
    }

    public final void b() {
        try {
            this.l.a();
            this.g.addView(this.l);
        } catch (Exception e) {
            o oVar = new o(p.S6, null, e, null);
            f fVar = this.i;
            fVar.a(fVar.h.getCurrentPositionMs(), oVar);
        }
    }

    public final void c() {
        this.g.removeAllViews();
        this.l = null;
        this.k = new m(this.f1377a, this.e, this.f, this.b, this.c, new com.five_corp.ad.internal.layouter.f(this.d.b.f1295a), this, this.j, this.n);
        AdActivity adActivity = this.f1377a;
        j jVar = this.d;
        int i = jVar.f1297a;
        if (i == 0) {
            i = jVar.b.f1295a.f1296a;
        }
        this.f1377a.setRequestedOrientation(a(adActivity, i));
        this.h.post(new Runnable() { // from class: com.five_corp.ad.internal.fullscreen.c$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a();
            }
        });
    }

    public final void d() {
        this.g.removeAllViews();
        this.k = null;
        this.l = new m(this.f1377a, this.e, this.f, this.b, this.c, new com.five_corp.ad.internal.layouter.f(this.d.c.f1298a), this, this.j, this.n);
        AdActivity adActivity = this.f1377a;
        j jVar = this.d;
        int i = jVar.f1297a;
        if (i == 0) {
            i = jVar.b.f1295a.f1296a;
        }
        this.f1377a.setRequestedOrientation(a(adActivity, i));
        this.h.post(new Runnable() { // from class: com.five_corp.ad.internal.fullscreen.c$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b();
            }
        });
    }

    public final void a() {
        try {
            this.k.a();
            this.g.addView(this.k);
        } catch (Exception e) {
            o oVar = new o(p.R6, null, e, null);
            f fVar = this.i;
            fVar.a(fVar.h.getCurrentPositionMs(), oVar);
        }
    }
}
