package com.fyber.inneractive.sdk.web;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes12.dex */
public abstract class j0 extends AbstractC3270i {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public final C G;
    public com.fyber.inneractive.sdk.measurement.e H;
    public com.fyber.inneractive.sdk.measurement.tracker.f I;
    public final f0 J;
    public final g0 K;
    public final h0 L;
    public final i0 M;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    public j0(boolean z, C c, com.fyber.inneractive.sdk.config.global.r rVar) {
        super(z, rVar);
        this.u = -1;
        this.v = -1;
        this.w = -1;
        this.x = -1;
        this.y = -1;
        this.z = -1;
        this.A = false;
        this.B = true;
        this.C = false;
        this.D = false;
        this.E = false;
        this.I = null;
        this.J = new f0(this);
        this.K = new g0(this);
        this.L = new h0(this);
        this.M = new i0(this);
        this.G = c;
    }

    public final void a(ArrayList arrayList) {
        if (this.b != null) {
            String string = arrayList.toString();
            if (string.length() < 2) {
                return;
            }
            String str = "{" + string.substring(1, string.length() - 1) + "}";
            this.b.a("window.mraidbridge.fireChangeEvent(" + str + ");");
            IAlog.e("Fire changes: %s", str);
        }
    }

    public void j() {
        C3274m c3274m = this.b;
        if (c3274m != null) {
            c3274m.a("window.mraidbridge.fireReadyEvent();");
        }
    }

    public void k() {
        ArrayList arrayList = new ArrayList();
        C3274m c3274m = this.b;
        if (c3274m == null || c3274m.getScaleX() == 1.0f || this.b.getScaleY() == 1.0f) {
            arrayList.add(new com.fyber.inneractive.sdk.mraid.C(this.w, this.x));
            arrayList.add(new com.fyber.inneractive.sdk.mraid.A(this.u, this.v));
        } else {
            int widthDp = this.b.getWidthDp();
            int heightDp = this.b.getHeightDp();
            arrayList.add(new com.fyber.inneractive.sdk.mraid.C(widthDp, heightDp));
            arrayList.add(new com.fyber.inneractive.sdk.mraid.A(widthDp, heightDp));
        }
        C3274m c3274m2 = this.b;
        int iB = AbstractC3251o.b(c3274m2 != null ? c3274m2.getWidth() : this.u);
        C3274m c3274m3 = this.b;
        arrayList.add(new com.fyber.inneractive.sdk.mraid.z(iB, AbstractC3251o.b(c3274m3 != null ? c3274m3.getHeight() : this.v)));
        a(arrayList);
        a(new com.fyber.inneractive.sdk.mraid.D(com.fyber.inneractive.sdk.mraid.F.DEFAULT));
    }

    public final void l() {
        C3274m c3274m = this.b;
        if (c3274m != null) {
            this.C = true;
            if (this.A) {
                c3274m.getSettings().setMediaPlaybackRequiresUserGesture(false);
            }
            com.fyber.inneractive.sdk.util.r.b.postDelayed(this.J, 0L);
        }
    }

    public boolean m() {
        C c = this.G;
        return c != null && c.equals(C.INTERSTITIAL);
    }

    public void n() {
        C3274m c3274m;
        if (this.C && this.D && this.A && (c3274m = this.b) != null) {
            c3274m.a("FyberMraidVideoController.play()");
            i0 i0Var = this.M;
            if (i0Var != null) {
                com.fyber.inneractive.sdk.util.r.b.postDelayed(i0Var, 5000L);
            }
            if (this.E) {
                this.b.a("FyberMraidVideoController.mute(true)");
            }
        }
    }

    public void setAdDefaultSize(int i, int i2) {
        this.y = i;
        this.z = i2;
    }

    public void setAutoplayMRAIDVideos(boolean z) {
        this.A = z;
    }

    public void setCenteringTagsRequired(boolean z) {
        this.B = z;
    }

    public final void a(com.fyber.inneractive.sdk.mraid.y yVar) {
        if (this.b != null) {
            String str = "{" + yVar.toString() + "}";
            this.b.a("window.mraidbridge.fireChangeEvent(" + str + ");");
            IAlog.e("Fire changes: %s", str);
        }
    }

    public void a(Context context, boolean z) {
        Window window;
        Window window2;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (context != null) {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        }
        Rect rect = new Rect();
        boolean z2 = context instanceof Activity;
        if (z2 && (window2 = ((Activity) context).getWindow()) != null) {
            window2.getDecorView().getWindowVisibleDisplayFrame(rect);
        }
        int i = rect.top;
        View viewFindViewById = (!z2 || (window = ((Activity) context).getWindow()) == null) ? null : window.findViewById(R.id.content);
        int top = viewFindViewById != null ? viewFindViewById.getTop() - i : 0;
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        double d = i2;
        double d2 = 160.0d / ((double) displayMetrics.densityDpi);
        int widthDp = (int) (d2 * d);
        int heightDp = (int) (d2 * ((double) i3));
        int iA = (i3 - i) - top;
        C3274m c3274m = this.b;
        if (c3274m != null && c3274m.getScaleX() != 1.0f && this.b.getScaleY() != 1.0f) {
            widthDp = this.b.getWidthDp();
            heightDp = this.b.getHeightDp();
            iA = (AbstractC3251o.a(this.b.getHeightDp()) - i) - top;
            this.u = this.w;
        } else {
            this.u = (int) ((160.0d / ((double) displayMetrics.densityDpi)) * d);
        }
        this.v = (int) ((160.0d / ((double) displayMetrics.densityDpi)) * ((double) iA));
        if (this.w == widthDp && this.x == heightDp) {
            return;
        }
        this.w = widthDp;
        this.x = heightDp;
        a(new com.fyber.inneractive.sdk.mraid.C(widthDp, heightDp));
        a(new com.fyber.inneractive.sdk.mraid.A(this.u, this.v));
        a(new com.fyber.inneractive.sdk.mraid.z(this.u, this.v));
        int i4 = this.y;
        if (i4 > 0 && this.z > 0) {
            a(new com.fyber.inneractive.sdk.mraid.x(AbstractC3251o.b(i4), AbstractC3251o.b(this.z)));
            return;
        }
        C3274m c3274m2 = this.b;
        if (c3274m2 == null || c3274m2.getWidth() <= 0 || this.b.getHeight() <= 0) {
            return;
        }
        a(new com.fyber.inneractive.sdk.mraid.x(AbstractC3251o.b(this.b.getWidth()), AbstractC3251o.b(this.b.getHeight())));
    }
}
