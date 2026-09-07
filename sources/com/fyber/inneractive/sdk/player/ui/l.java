package com.fyber.inneractive.sdk.player.ui;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.T;
import com.fyber.inneractive.sdk.flow.C3102g;
import com.fyber.inneractive.sdk.model.vast.C3117a;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.h0;
import com.fyber.inneractive.sdk.util.i0;
import com.fyber.inneractive.sdk.util.v0;
import com.fyber.inneractive.sdk.util.x0;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes13.dex */
public abstract class l extends t {
    public static final h0 K;
    public final a A;
    public final LayoutInflater B;
    public final C3102g C;
    public boolean D;
    public x0 E;
    public k F;
    public int G;
    public int H;
    public View I;
    public boolean J;

    static {
        h0 h0Var = new h0();
        h0Var.c = true;
        K = h0Var;
    }

    public l(Context context, C3102g c3102g, a aVar, com.fyber.inneractive.sdk.config.global.r rVar, String str) {
        super(context, rVar, str);
        this.D = false;
        this.J = true;
        this.C = c3102g;
        this.B = LayoutInflater.from(context);
        this.A = aVar;
    }

    public abstract void a(int i);

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void a(com.fyber.inneractive.sdk.flow.endcard.b bVar, b bVar2) {
        Integer num;
        this.I = bVar2.e;
        ViewGroup viewGroup = this.r;
        if (viewGroup != null) {
            bVar.a(viewGroup, bVar2);
            a(bVar2);
            com.fyber.inneractive.sdk.model.vast.i iVar = bVar2.f;
            com.fyber.inneractive.sdk.model.vast.i iVar2 = com.fyber.inneractive.sdk.model.vast.i.Static;
            if (iVar2 == iVar) {
                a(getEndCardView(), 4);
            }
            if ((iVar2 == iVar || iVar == com.fyber.inneractive.sdk.model.vast.i.FMP_End_Card) && (num = bVar2.d) != null) {
                int i = iVar != iVar2 ? 8 : 4;
                int iIntValue = num.intValue();
                if (this.D || this.E != null) {
                    return;
                }
                IAlog.a("Start Autoclick timer - %d seconds", num);
                x0 x0Var = new x0(TimeUnit.SECONDS, iIntValue);
                this.E = x0Var;
                x0Var.e = new j(this, i);
                v0 v0Var = new v0(x0Var);
                x0Var.c = v0Var;
                x0Var.d = false;
                v0Var.sendEmptyMessage(1932593528);
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t, com.fyber.inneractive.sdk.player.ui.e, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.p, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void e() {
        p();
        this.D = true;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public View getEndCardView() {
        return this.I;
    }

    public String getLocalizedCtaButtonText() {
        com.fyber.inneractive.sdk.config.global.r rVar = this.v;
        com.fyber.inneractive.sdk.config.global.features.d dVar = rVar != null ? (com.fyber.inneractive.sdk.config.global.features.d) rVar.a(com.fyber.inneractive.sdk.config.global.features.d.class) : null;
        if (dVar == null) {
            return null;
        }
        dVar.d(IAConfigManager.O.o);
        C3117a c3117a = dVar.e;
        if (c3117a == null || !c3117a.d) {
            return null;
        }
        return c3117a.f1873a;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public int getMaxTickFactor() {
        return 1000;
    }

    public int getSingleTickTime() {
        return 1000 / getTickFraction();
    }

    public int getTickFraction() {
        return 5;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void j() {
        if (this.E != null) {
            IAlog.a("Autoclick paused", new Object[0]);
            x0 x0Var = this.E;
            x0Var.d = true;
            v0 v0Var = x0Var.c;
            if (v0Var != null) {
                v0Var.removeMessages(1932593528);
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void k() {
        if (this.E != null) {
            IAlog.a("Autoclick resumed", new Object[0]);
            x0 x0Var = this.E;
            x0Var.d = false;
            x0Var.a(SystemClock.uptimeMillis());
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void o() {
        this.t = this.A.a(this.d, this.n, this.o, this.s, this.b, this.l);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.e, android.view.View
    public final void onWindowFocusChanged(boolean z) {
    }

    public final void p() {
        if (this.E != null) {
            IAlog.a("Autoclick is removed ", new Object[0]);
            this.E.e = null;
            this.E = null;
        }
    }

    public void setEndCardView(View view) {
        this.I = view;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.e
    public final void a(i0 i0Var, int i, int i2) {
        this.A.a(this.d, this.n, this.o, this.p, i0Var, i, i2, this.b, ((T) this.c).f.f.intValue());
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public void a(int i, int i2) {
        Runnable runnable = this.F;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.F = null;
        }
        this.H = getMaxTickFactor() + i2;
        int maxTickFactor = (getMaxTickFactor() / getTickFractions()) + i2;
        int i3 = this.H;
        if (i3 <= 0 || i3 > i) {
            return;
        }
        int i4 = this.G;
        if (maxTickFactor < i4 && i4 > 0) {
            a(i3);
            return;
        }
        this.G = maxTickFactor;
        a(maxTickFactor);
        k kVar = new k(this);
        this.F = kVar;
        postDelayed(kVar, this.k);
    }
}
