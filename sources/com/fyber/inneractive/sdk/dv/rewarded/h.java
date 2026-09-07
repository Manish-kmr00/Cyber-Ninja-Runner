package com.fyber.inneractive.sdk.dv.rewarded;

import android.app.Activity;
import com.fyber.inneractive.sdk.dv.i;
import com.fyber.inneractive.sdk.external.InneractiveFullScreenAdRewardedListener;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.flow.A;
import com.fyber.inneractive.sdk.flow.G;
import com.fyber.inneractive.sdk.flow.N;
import com.fyber.inneractive.sdk.flow.Q;
import com.fyber.inneractive.sdk.flow.x;
import com.fyber.inneractive.sdk.util.AbstractC3256u;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends N implements com.fyber.inneractive.sdk.dv.interstitial.a {
    public com.fyber.inneractive.sdk.external.g w;
    public boolean x = false;

    @Override // com.fyber.inneractive.sdk.flow.N
    public final boolean G() {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.flow.N
    public final int I() {
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.flow.N
    public final int J() {
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.flow.N
    public final long K() {
        return 0L;
    }

    @Override // com.fyber.inneractive.sdk.flow.N
    public final boolean L() {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.flow.N
    public final long a(long j) {
        return 0L;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final void a() {
    }

    @Override // com.fyber.inneractive.sdk.flow.N
    public final /* bridge */ /* synthetic */ boolean b(x xVar) {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.dv.interstitial.a
    public final void g() {
        InneractiveUnitController.EventsListener eventsListener;
        if (this.x || (eventsListener = this.c) == null) {
            return;
        }
        this.x = true;
        ((InneractiveFullscreenAdEventsListener) eventsListener).onAdDismissed(this.f1772a);
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final void k() {
    }

    @Override // com.fyber.inneractive.sdk.dv.interstitial.a
    public final void onReward() {
        com.fyber.inneractive.sdk.external.g gVar = this.w;
        if (gVar != null) {
            G g = (G) AbstractC3256u.a(((Q) gVar.f1765a).mAdSpot);
            InneractiveFullScreenAdRewardedListener inneractiveFullScreenAdRewardedListener = gVar.f1765a.b;
            if (inneractiveFullScreenAdRewardedListener != null && g != null) {
                inneractiveFullScreenAdRewardedListener.onAdRewarded(g);
            }
            F();
        }
        A.a(com.fyber.inneractive.sdk.cache.session.enums.a.COMPLETION, com.fyber.inneractive.sdk.cache.session.enums.c.REWARDED_VIDEO);
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final boolean t() {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.dv.interstitial.a
    public final void u() {
        x xVar = this.b;
        if (xVar != null) {
            b((i) ((com.fyber.inneractive.sdk.a) xVar).b);
        }
        A.a(com.fyber.inneractive.sdk.cache.session.enums.a.IMPRESSION, com.fyber.inneractive.sdk.cache.session.enums.c.REWARDED_VIDEO);
        C();
    }

    @Override // com.fyber.inneractive.sdk.dv.interstitial.a
    public final void b() {
        i iVar;
        x xVar = this.b;
        if (xVar != null && (iVar = (i) ((com.fyber.inneractive.sdk.a) xVar).b) != null) {
            A.a(iVar);
        }
        A.a(com.fyber.inneractive.sdk.cache.session.enums.a.CLICK, com.fyber.inneractive.sdk.cache.session.enums.c.REWARDED_VIDEO);
        a(w(), Float.NaN, Float.NaN);
    }

    @Override // com.fyber.inneractive.sdk.flow.N, com.fyber.inneractive.sdk.interfaces.f
    public final void a(com.fyber.inneractive.sdk.interfaces.e eVar, Activity activity) throws InneractiveUnitController.AdDisplayError {
        super.a(eVar, activity);
        if (activity != null) {
            x xVar = this.b;
            if (xVar != null) {
                com.fyber.inneractive.sdk.a aVar = (com.fyber.inneractive.sdk.a) xVar;
                if (aVar.i != null) {
                    aVar.a(this, activity);
                    return;
                }
            }
            IAlog.f("%sad content is null aborting", IAlog.a(this));
            throw new InneractiveUnitController.AdDisplayError("Ad content is null");
        }
        IAlog.f("%sYou must pass activity in order to show rewarded", IAlog.a(this));
        throw new InneractiveUnitController.AdDisplayError("No activity context");
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final void a(com.fyber.inneractive.sdk.external.g gVar) {
        this.w = gVar;
    }
}
