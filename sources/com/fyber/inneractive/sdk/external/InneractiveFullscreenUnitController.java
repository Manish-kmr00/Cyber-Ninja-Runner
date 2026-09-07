package com.fyber.inneractive.sdk.external;

import android.app.Activity;
import com.fyber.inneractive.sdk.activities.InneractiveFullscreenAdActivity;
import com.fyber.inneractive.sdk.config.M;
import com.fyber.inneractive.sdk.config.T;
import com.fyber.inneractive.sdk.config.V;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.factories.h;
import com.fyber.inneractive.sdk.factories.i;
import com.fyber.inneractive.sdk.flow.G;
import com.fyber.inneractive.sdk.flow.Q;
import com.fyber.inneractive.sdk.flow.x;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.EnumC3144u;
import com.fyber.inneractive.sdk.util.AbstractC3256u;
import com.fyber.inneractive.sdk.util.IAlog;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes11.dex */
public class InneractiveFullscreenUnitController extends Q implements InneractiveFullscreenAdActivity.FullScreenRendererProvider, InneractiveFullscreenAdActivity.OnInneractiveFullscreenAdDestroyListener {
    public InneractiveFullScreenAdRewardedListener b;
    protected com.fyber.inneractive.sdk.interfaces.f mRenderer;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1755a = false;
    public final g c = new g(this);

    public static class AdExpiredError extends InneractiveUnitController.AdDisplayError {
        public AdExpiredError() {
            super("Ad Expired");
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.Q, com.fyber.inneractive.sdk.external.InneractiveUnitController
    public void destroy() {
        com.fyber.inneractive.sdk.interfaces.f fVar = this.mRenderer;
        if (fVar != null) {
            fVar.destroy();
            this.mRenderer = null;
        }
        super.destroy();
    }

    @Override // com.fyber.inneractive.sdk.activities.InneractiveFullscreenAdActivity.FullScreenRendererProvider
    public com.fyber.inneractive.sdk.interfaces.f getFullscreenRenderer() {
        return this.mRenderer;
    }

    public InneractiveFullScreenAdRewardedListener getRewardedListener() {
        return this.b;
    }

    public boolean isAvailable() {
        G g = (G) AbstractC3256u.a(this.mAdSpot);
        return g != null && g.isReady();
    }

    @Override // com.fyber.inneractive.sdk.activities.InneractiveFullscreenAdActivity.OnInneractiveFullscreenAdDestroyListener
    public void onActivityDestroyed(InneractiveFullscreenAdActivity inneractiveFullscreenAdActivity) {
        this.f1755a = false;
    }

    public void setRewardedListener(InneractiveFullScreenAdRewardedListener inneractiveFullScreenAdRewardedListener) {
        this.b = inneractiveFullScreenAdRewardedListener;
    }

    public void show(Activity activity) {
        if (activity == null) {
            IAlog.f("show() called with a null activity", new Object[0]);
            return;
        }
        if (this.f1755a) {
            IAlog.f("InneractiveFullscreenUnitController->show(android.content.Context) called while an ad is already showing", new Object[0]);
            return;
        }
        InneractiveAdSpot adSpot = getAdSpot();
        if (adSpot == null) {
            IAlog.f("InneractiveFullscreenUnitController was not attached to an ad spot", new Object[0]);
            return;
        }
        x adContent = adSpot.getAdContent();
        com.fyber.inneractive.sdk.interfaces.f fVarB = null;
        if (adContent != null) {
            EnumC3144u enumC3144u = EnumC3144u.IA_PUBLISHER_REQUESTED_SHOW;
            InneractiveAdRequest inneractiveAdRequest = adContent.f1840a;
            com.fyber.inneractive.sdk.response.e eVarC = adContent.c();
            JSONArray jSONArrayB = adContent.c.b();
            C3146w c3146w = new C3146w(eVarC);
            c3146w.c = enumC3144u;
            c3146w.f1934a = inneractiveAdRequest;
            c3146w.d = jSONArrayB;
            c3146w.a((String) null);
        }
        if (!adSpot.isReady()) {
            InneractiveUnitController.EventsListener eventsListener = this.mEventsListener;
            if (eventsListener != null) {
                ((InneractiveFullscreenAdEventsListener) eventsListener).onAdEnteredErrorState(adSpot, new AdExpiredError());
                return;
            }
            return;
        }
        if (this.mRenderer == null) {
            i iVar = h.f1770a;
            InneractiveAdSpot adSpot2 = getAdSpot();
            for (com.fyber.inneractive.sdk.factories.g gVar : iVar.f1771a) {
                if (gVar.a(adSpot2)) {
                    fVarB = gVar.b(adSpot2);
                    break;
                }
            }
            this.mRenderer = fVarB;
        }
        selectContentController();
        (adContent instanceof com.fyber.inneractive.sdk.dv.a ? new com.fyber.inneractive.sdk.display.b() : new com.fyber.inneractive.sdk.display.c()).a(activity, adSpot, adSpot.getLocalUniqueId());
        this.f1755a = true;
        com.fyber.inneractive.sdk.interfaces.f fVar = this.mRenderer;
        if (fVar != null) {
            fVar.a(this.c);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.Q
    public boolean supports(InneractiveAdSpot inneractiveAdSpot) {
        T t = (T) inneractiveAdSpot.getAdContent().d;
        if (t.e != null) {
            return false;
        }
        M m = t.c;
        if (m != null && UnitDisplayType.INTERSTITIAL.equals(m.b)) {
            return true;
        }
        V v = t.f;
        return v != null && (UnitDisplayType.REWARDED.equals(v.j) || UnitDisplayType.INTERSTITIAL.equals(v.j) || UnitDisplayType.VERTICAL.equals(v.j));
    }

    @Override // com.fyber.inneractive.sdk.flow.Q
    public boolean supportsRefresh() {
        return false;
    }
}
