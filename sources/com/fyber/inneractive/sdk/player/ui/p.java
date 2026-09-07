package com.fyber.inneractive.sdk.player.ui;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fyber.inneractive.sdk.util.IAlog;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes13.dex */
public final class p extends l {
    public int L;
    public com.fyber.inneractive.sdk.player.ui.remote.f M;
    public final com.fyber.inneractive.sdk.player.ui.remote.d N;

    public p(Context context, a aVar, com.fyber.inneractive.sdk.player.ui.remote.d dVar, o oVar) {
        super(context, null, aVar, null, null);
        this.L = 0;
        com.fyber.inneractive.sdk.player.ui.remote.f fVar = new com.fyber.inneractive.sdk.player.ui.remote.f(oVar);
        this.M = fVar;
        this.N = dVar;
        dVar.f2243a = fVar;
        attachViewToParent(dVar.b, getChildCount() - 1, new RelativeLayout.LayoutParams(-1, -1));
        setBackgroundColor(0);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.e, com.fyber.inneractive.sdk.player.ui.m
    public final boolean a() {
        return this.N.b.j;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void b(boolean z) {
        com.fyber.inneractive.sdk.player.ui.remote.f fVar = this.M;
        if (fVar != null) {
            fVar.g = z;
        }
        com.fyber.inneractive.sdk.player.ui.remote.d dVar = this.N;
        dVar.getClass();
        dVar.d.a("FyberRemoteUiBridge.showCountdownText(%s)", "FyberRemoteUiBridge.showCountdownText(" + z + ")", dVar.b.j);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void c(boolean z) {
        com.fyber.inneractive.sdk.player.ui.remote.f fVar = this.M;
        if (fVar != null) {
            fVar.h = z;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void d(boolean z) {
        com.fyber.inneractive.sdk.player.ui.remote.f fVar = this.M;
        if (fVar != null) {
            fVar.i = z;
        }
        com.fyber.inneractive.sdk.player.ui.remote.d dVar = this.N;
        dVar.getClass();
        String str = z ? "FyberRemoteUiBridge.showMuteButton()" : "FyberRemoteUiBridge.hideMuteButton()";
        dVar.d.a(str, str, dVar.b.j);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t, com.fyber.inneractive.sdk.player.ui.m
    public final void destroy() {
        IAlog.a("%s: destroy() : destroying remote UI", "IAVideoViewRemote");
        removeView(this.N.b);
        this.N.a();
        com.fyber.inneractive.sdk.player.ui.remote.f fVar = this.M;
        if (fVar != null) {
            fVar.f2245a = null;
            this.M = null;
        }
        super.destroy();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.l, com.fyber.inneractive.sdk.player.ui.t, com.fyber.inneractive.sdk.player.ui.e, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.p, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void e(boolean z) {
        com.fyber.inneractive.sdk.player.ui.remote.f fVar = this.M;
        if (fVar != null) {
            fVar.c = z;
        }
        com.fyber.inneractive.sdk.player.ui.remote.d dVar = this.N;
        dVar.getClass();
        dVar.d.a("FyberRemoteUiBridge.showPlayOverlay(%s)", "FyberRemoteUiBridge.showPlayOverlay(" + z + ")", dVar.b.j);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void f(boolean z) {
        com.fyber.inneractive.sdk.player.ui.remote.f fVar = this.M;
        if (fVar != null) {
            fVar.f = z;
        }
        com.fyber.inneractive.sdk.player.ui.remote.d dVar = this.N;
        dVar.getClass();
        dVar.d.a("FyberRemoteUiBridge.showProgressBar(%s)", "FyberRemoteUiBridge.showProgressBar(" + z + ")", dVar.b.j);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void g(boolean z) {
        com.fyber.inneractive.sdk.player.ui.remote.f fVar = this.M;
        if (fVar != null) {
            fVar.b = z;
        }
        com.fyber.inneractive.sdk.player.ui.remote.d dVar = this.N;
        dVar.getClass();
        dVar.d.a("FyberRemoteUiBridge.showSkipLayout(%s)", "FyberRemoteUiBridge.showSkipLayout(" + z + ")", dVar.b.j);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public int getTickFractions() {
        return 15;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public View[] getTrackingFriendlyView() {
        return new View[]{this.N.b};
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public View[] getTrackingFriendlyViewObstructionPurposeOther() {
        return new View[0];
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final boolean i() {
        return this.N.n;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final boolean l() {
        return this.N.m;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void m() {
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void n() {
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public void setAppInfoButtonRound(TextView textView) {
    }

    public void setIsSkipEnabled(boolean z) {
        this.N.n = z;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.e
    public void setListener(n nVar) {
        super.setListener(nVar);
        this.N.e = nVar;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public void setMuteButtonState(boolean z) {
        com.fyber.inneractive.sdk.player.ui.remote.d dVar = this.N;
        dVar.getClass();
        String str = z ? "FyberRemoteUiBridge.setMute()" : "FyberRemoteUiBridge.setUnmute()";
        com.fyber.inneractive.sdk.player.ui.remote.e eVar = dVar.d;
        eVar.c = z;
        com.fyber.inneractive.sdk.player.ui.remote.d dVar2 = eVar.f2244a;
        if (dVar2 != null) {
            dVar2.b.a(str);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public void setRemainingTime(String str) {
        com.fyber.inneractive.sdk.player.ui.remote.d dVar = this.N;
        dVar.getClass();
        dVar.d.a("FyberRemoteUiBridge.setRemainingTime(\"%s\")", "FyberRemoteUiBridge.setRemainingTime(\"" + str + "\")", dVar.b.j);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public void setSkipText(String str) {
        com.fyber.inneractive.sdk.player.ui.remote.d dVar = this.N;
        dVar.getClass();
        dVar.d.a("FyberRemoteUiBridge.setSkipText(\"%s\")", "FyberRemoteUiBridge.setSkipText(\"" + str + "\")", dVar.b.j);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void a(com.fyber.inneractive.sdk.flow.endcard.d dVar, b bVar) {
        super.a(dVar, bVar);
        ViewGroup viewGroup = this.q;
        if (viewGroup == null || viewGroup.getVisibility() != 0) {
            return;
        }
        this.N.a();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void a(boolean z, com.fyber.inneractive.sdk.ignite.m mVar) {
        com.fyber.inneractive.sdk.player.ui.remote.f fVar = this.M;
        if (fVar != null) {
            fVar.e = z;
            fVar.k = mVar;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void f() {
        com.fyber.inneractive.sdk.player.ui.remote.d dVar = this.N;
        dVar.d.a("FyberRemoteUiBridge.enableSkip()", "FyberRemoteUiBridge.enableSkip()", dVar.b.j);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void g() {
        com.fyber.inneractive.sdk.player.ui.remote.d dVar = this.N;
        dVar.d.a("FyberRemoteUiBridge.hideOverlays()", "FyberRemoteUiBridge.hideOverlays()", dVar.b.j);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void a(boolean z, String str) {
        com.fyber.inneractive.sdk.player.ui.remote.f fVar = this.M;
        if (fVar != null) {
            fVar.j = z;
            fVar.l = str;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.t
    public final void a(boolean z) {
        com.fyber.inneractive.sdk.player.ui.remote.f fVar = this.M;
        if (fVar != null) {
            fVar.d = z;
        }
        com.fyber.inneractive.sdk.player.ui.remote.d dVar = this.N;
        dVar.getClass();
        dVar.d.a("FyberRemoteUiBridge.showBufferingOverlay(%s)", "FyberRemoteUiBridge.showBufferingOverlay(" + z + ")", dVar.b.j);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.l, com.fyber.inneractive.sdk.player.ui.t
    public final void a(int i, int i2) {
        this.L = i;
        super.a(i, i2);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.l
    public final void a(int i) {
        int i2 = this.L;
        com.fyber.inneractive.sdk.player.ui.remote.d dVar = this.N;
        dVar.getClass();
        dVar.d.a("FyberRemoteUiBridge.updateProgressBar(%d, %.2f)", String.format(Locale.US, "FyberRemoteUiBridge.updateProgressBar(%d, %.2f)", Integer.valueOf(i2), Float.valueOf((i / i2) * 100.0f)), dVar.b.j);
    }
}
