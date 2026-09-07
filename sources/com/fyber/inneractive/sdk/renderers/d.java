package com.fyber.inneractive.sdk.renderers;

import android.graphics.Rect;
import android.os.Handler;
import android.widget.RelativeLayout;
import com.fyber.inneractive.sdk.flow.O;
import com.fyber.inneractive.sdk.flow.x;
import com.fyber.inneractive.sdk.network.Z;
import com.fyber.inneractive.sdk.util.C3246j;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes11.dex */
public final class d {
    public final RelativeLayout b;
    public final f i;
    public float c = 0.0f;
    public int d = 1;
    public float e = 0.0f;
    public long f = 0;
    public boolean g = false;
    public boolean h = false;
    public final b j = new b(this);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C3246j f2308a = new C3246j(4, new c());

    public d(com.fyber.inneractive.sdk.response.f fVar, RelativeLayout relativeLayout, f fVar2) {
        this.b = relativeLayout;
        this.i = fVar2;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0078  */
    public final void a() {
        boolean z;
        String str;
        IAlog.a("IAVisibilityTracker: onCheckVisibility", new Object[0]);
        float f = this.d / 100.0f;
        C3246j c3246j = this.f2308a;
        Object objPoll = c3246j.f2366a.poll();
        if (objPoll == null) {
            objPoll = c3246j.b.a();
        }
        Rect rect = (Rect) objPoll;
        RelativeLayout relativeLayout = this.b;
        float fWidth = (relativeLayout.getParent() != null && relativeLayout.isShown() && relativeLayout.hasWindowFocus() && relativeLayout.getGlobalVisibleRect(rect)) ? (rect.width() * rect.height()) / (relativeLayout.getWidth() * relativeLayout.getHeight()) : 0.0f;
        this.f2308a.f2366a.offer(rect);
        this.c = fWidth;
        if (fWidth >= f) {
            float f2 = this.e * 1000.0f;
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.f;
            if (f2 >= jCurrentTimeMillis - j || j == 0) {
                z = false;
            } else {
                z = true;
            }
        } else {
            z = false;
        }
        IAlog.a("BannerVisibilityTracker | visible = %s, minVis = %f", Boolean.valueOf(z), Float.valueOf(f));
        if (!z || !this.g) {
            if (this.g) {
                float f3 = this.c;
                if (f3 < f) {
                    this.f = 0L;
                } else if (f3 >= f && this.f == 0) {
                    this.f = System.currentTimeMillis();
                }
                Handler handler = com.fyber.inneractive.sdk.util.r.b;
                handler.removeCallbacks(this.j);
                handler.postDelayed(this.j, 50L);
                return;
            }
            return;
        }
        if (this.i == null || this.h) {
            return;
        }
        this.h = true;
        IAlog.a("BannerVisibilityTracker | firing viewable", new Object[0]);
        k kVar = this.i.f2309a;
        kVar.getClass();
        try {
            x xVar = kVar.b;
            if (xVar == null || ((O) xVar).b == null || (str = ((com.fyber.inneractive.sdk.response.f) ((O) xVar).b).x) == null || str.trim().length() <= 0) {
                return;
            }
            IAlog.e("%sfiring banner mrc visibility impression!", IAlog.a(kVar));
            IAlog.d("MRC_VISIBILITY_IMPRESSION", new Object[0]);
            Z.b(str);
        } catch (Exception unused) {
        }
    }
}
