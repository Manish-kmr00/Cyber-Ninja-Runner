package com.fyber.inneractive.sdk.external;

import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.activities.InneractiveFullscreenAdActivity;
import com.fyber.inneractive.sdk.config.M;
import com.fyber.inneractive.sdk.config.T;
import com.fyber.inneractive.sdk.config.V;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.factories.h;
import com.fyber.inneractive.sdk.flow.A;
import com.fyber.inneractive.sdk.flow.E;
import com.fyber.inneractive.sdk.flow.F;
import com.fyber.inneractive.sdk.flow.G;
import com.fyber.inneractive.sdk.flow.P;
import com.fyber.inneractive.sdk.flow.Q;
import com.fyber.inneractive.sdk.util.AbstractC3256u;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.r;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes8.dex */
public class InneractiveAdViewUnitController extends Q implements E, InneractiveFullscreenAdActivity.FullScreenRendererProvider {
    public static final int DISABLED_REFRESH_INTERVAL = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet f1754a;
    public boolean b;
    public ViewGroup c;
    public final int d;
    protected int mAdContentHeight;
    protected int mAdContentWidth;

    public InneractiveAdViewUnitController() {
        this.b = false;
        this.mAdContentWidth = -1;
        this.mAdContentHeight = -1;
        this.d = 0;
        this.f1754a = new HashSet();
    }

    public final void a() {
        this.b = true;
        Iterator it = new HashSet(this.f1754a).iterator();
        while (it.hasNext()) {
            ((InneractiveAdRenderer) it.next()).destroy();
        }
        this.f1754a.clear();
        this.c = null;
        super.destroy();
    }

    public void bindView(ViewGroup viewGroup) {
        com.fyber.inneractive.sdk.interfaces.d dVarA;
        IAlog.a("%sPPPP bindView called with parent: %s", logPrefix(), viewGroup);
        InneractiveAdSpot adSpot = getAdSpot();
        if (adSpot == null) {
            IAlog.f("InneractiveFullscreenUnitController was not attached to an ad spot", new Object[0]);
            return;
        }
        IAlog.a("%sPPPP bindView spot is %s", logPrefix(), adSpot);
        for (InneractiveAdRenderer inneractiveAdRenderer : new HashSet(this.f1754a)) {
            if (inneractiveAdRenderer instanceof com.fyber.inneractive.sdk.interfaces.d) {
                com.fyber.inneractive.sdk.interfaces.d dVar = (com.fyber.inneractive.sdk.interfaces.d) inneractiveAdRenderer;
                if (dVar.b(viewGroup)) {
                    dVar.l();
                    IAlog.a("%sPPPP bindAdToRenderer returning an already attached renderer %s", logPrefix(), dVar);
                    return;
                }
            }
        }
        this.c = viewGroup;
        Iterator it = com.fyber.inneractive.sdk.factories.b.f1766a.f1767a.iterator();
        while (true) {
            if (!it.hasNext()) {
                dVarA = null;
                break;
            }
            com.fyber.inneractive.sdk.factories.a aVar = (com.fyber.inneractive.sdk.factories.a) it.next();
            if (aVar.a(adSpot)) {
                dVarA = aVar.a();
                break;
            }
        }
        int i = this.d;
        if (i != 0) {
            dVarA.a(i);
        }
        if (dVarA == null) {
            IAlog.f("%sCould not find a renderer for the given spot! Did you add the appropriate module to your project?", logPrefix());
            return;
        }
        ((A) dVarA).initialize(adSpot);
        selectContentController();
        dVarA.a(viewGroup);
        this.f1754a.add(dVarA);
        IAlog.a("%sPPPP bindView created renderer %s", logPrefix(), dVarA);
    }

    @Override // com.fyber.inneractive.sdk.flow.Q
    public boolean canRefreshAd() {
        if (!supportsRefresh()) {
            return false;
        }
        Iterator it = this.f1754a.iterator();
        while (it.hasNext()) {
            if (!((InneractiveAdRenderer) it.next()).canRefreshAd()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.fyber.inneractive.sdk.flow.Q, com.fyber.inneractive.sdk.external.InneractiveUnitController
    public void destroy() {
        if (Looper.myLooper() == null || Looper.getMainLooper() != Looper.myLooper()) {
            r.b.post(new f(this));
        } else {
            a();
        }
    }

    public int getAdContentHeight() {
        int iN;
        for (InneractiveAdRenderer inneractiveAdRenderer : this.f1754a) {
            if ((inneractiveAdRenderer instanceof com.fyber.inneractive.sdk.interfaces.d) && (iN = ((com.fyber.inneractive.sdk.interfaces.d) inneractiveAdRenderer).n()) > 0) {
                return iN;
            }
        }
        return this.mAdContentHeight;
    }

    public int getAdContentWidth() {
        int iD;
        for (InneractiveAdRenderer inneractiveAdRenderer : this.f1754a) {
            if ((inneractiveAdRenderer instanceof com.fyber.inneractive.sdk.interfaces.d) && (iD = ((com.fyber.inneractive.sdk.interfaces.d) inneractiveAdRenderer).d()) > 0) {
                return iD;
            }
        }
        return this.mAdContentWidth;
    }

    @Override // com.fyber.inneractive.sdk.activities.InneractiveFullscreenAdActivity.FullScreenRendererProvider
    public com.fyber.inneractive.sdk.interfaces.f getFullscreenRenderer() {
        com.fyber.inneractive.sdk.interfaces.f fVarB;
        InneractiveAdSpot inneractiveAdSpot = (InneractiveAdSpot) AbstractC3256u.a(this.mAdSpot);
        for (com.fyber.inneractive.sdk.factories.g gVar : h.f1770a.f1771a) {
            if (gVar.a(inneractiveAdSpot)) {
                fVarB = gVar.b(inneractiveAdSpot);
                this.f1754a.add(fVarB);
                return fVarB;
            }
        }
        fVarB = null;
        this.f1754a.add(fVarB);
        return fVarB;
    }

    @Override // com.fyber.inneractive.sdk.flow.Q, com.fyber.inneractive.sdk.external.InneractiveUnitController
    public InneractiveContentController getSelectedContentController() {
        return this.mSelectedContentController;
    }

    @Override // com.fyber.inneractive.sdk.flow.E
    public void onAdRefreshFailed(InneractiveAdSpot inneractiveAdSpot, InneractiveErrorCode inneractiveErrorCode) {
        for (InneractiveAdRenderer inneractiveAdRenderer : new HashSet(this.f1754a)) {
            if (inneractiveAdRenderer instanceof com.fyber.inneractive.sdk.interfaces.d) {
                ((com.fyber.inneractive.sdk.interfaces.d) inneractiveAdRenderer).p();
                return;
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.E
    public void onAdRefreshed(InneractiveAdSpot inneractiveAdSpot) {
        com.fyber.inneractive.sdk.interfaces.d dVar;
        Iterator it = new HashSet(this.f1754a).iterator();
        while (true) {
            if (!it.hasNext()) {
                dVar = null;
                break;
            }
            InneractiveAdRenderer inneractiveAdRenderer = (InneractiveAdRenderer) it.next();
            if (inneractiveAdRenderer instanceof com.fyber.inneractive.sdk.interfaces.d) {
                dVar = (com.fyber.inneractive.sdk.interfaces.d) inneractiveAdRenderer;
                if (dVar.a(inneractiveAdSpot.getAdContent())) {
                    break;
                }
            }
        }
        if (dVar != null) {
            dVar.a((ViewGroup) null);
        } else {
            onAdRefreshFailed(inneractiveAdSpot, InneractiveErrorCode.SDK_INTERNAL_ERROR);
        }
        try {
            if (inneractiveAdSpot instanceof F) {
                int i = IAlog.f2345a;
                IAlog.d("%s %s", "AD_REFRESH", ((F) inneractiveAdSpot).h.d.b());
            }
        } catch (Exception unused) {
        }
        IAlog.a("InneractiveFullscreenUnitController onAdRefreshed called", new Object[0]);
    }

    public void refreshAd() {
        IAlog.a("InneractiveFullscreenUnitController refreshAd called", new Object[0]);
        InneractiveAdSpot inneractiveAdSpot = (InneractiveAdSpot) AbstractC3256u.a(this.mAdSpot);
        if (inneractiveAdSpot == null || !(inneractiveAdSpot instanceof P)) {
            return;
        }
        ((P) inneractiveAdSpot).a(this);
    }

    @Override // com.fyber.inneractive.sdk.flow.Q
    public boolean supports(InneractiveAdSpot inneractiveAdSpot) {
        T t = (T) inneractiveAdSpot.getAdContent().d;
        if (t.e != null) {
            return false;
        }
        M m = t.c;
        if (m != null) {
            if (UnitDisplayType.BANNER.equals(m.b) || UnitDisplayType.MRECT.equals(m.b)) {
                return true;
            }
            if (UnitDisplayType.INTERSTITIAL.equals(m.b)) {
                return inneractiveAdSpot.getCurrentProcessedRequest() != null && inneractiveAdSpot.getCurrentProcessedRequest().getAllowFullscreen();
            }
        }
        V v = t.f;
        return v != null && (UnitDisplayType.LANDSCAPE.equals(v.j) || UnitDisplayType.SQUARE.equals(v.j) || UnitDisplayType.MRECT.equals(v.j));
    }

    @Override // com.fyber.inneractive.sdk.flow.Q
    public boolean supportsRefresh() {
        return true;
    }

    public void unbindFullscreenRenderer(com.fyber.inneractive.sdk.interfaces.f fVar) {
        WeakReference<G> weakReference;
        IAlog.a("%sremoving full screen ad renderer %s", logPrefix(), fVar);
        HashSet hashSet = this.f1754a;
        if (hashSet != null) {
            hashSet.remove(fVar);
        }
        if (this.b) {
            return;
        }
        for (InneractiveAdRenderer inneractiveAdRenderer : new HashSet(this.f1754a)) {
            if (inneractiveAdRenderer instanceof com.fyber.inneractive.sdk.interfaces.d) {
                ((com.fyber.inneractive.sdk.interfaces.d) inneractiveAdRenderer).q();
                if (this.mEventsListener != null && (weakReference = this.mAdSpot) != null && weakReference.get() != null) {
                    ((InneractiveAdViewEventsListener) this.mEventsListener).onAdCollapsed(this.mAdSpot.get());
                }
            }
        }
    }

    public void unbindView(View view) {
        if (this.c != view) {
            IAlog.f("%s unbindView invoked with incorrect view, was - %s received - %s", logPrefix(), this.c, view);
        } else {
            this.c = null;
        }
        IAlog.a("%sPPPP unbindView called with %s", logPrefix(), view);
        IAlog.a("%sPPPP spot is %s", logPrefix(), this.mAdSpot);
        for (InneractiveAdRenderer inneractiveAdRenderer : new HashSet(this.f1754a)) {
            if (inneractiveAdRenderer instanceof com.fyber.inneractive.sdk.interfaces.d) {
                com.fyber.inneractive.sdk.interfaces.d dVar = (com.fyber.inneractive.sdk.interfaces.d) inneractiveAdRenderer;
                if (dVar.b(view)) {
                    IAlog.a("%sPPPP unbindView unbinding renderer %s", logPrefix(), inneractiveAdRenderer);
                    dVar.s();
                    this.f1754a.remove(dVar);
                    return;
                }
            }
        }
    }

    public InneractiveAdViewUnitController(int i) {
        this();
        if (i >= 30) {
            IAlog.a("InneractiveAdViewUnitController: Overriding remote config refresh interval to: %d", Integer.valueOf(i));
            this.d = i;
        } else {
            IAlog.a("InneractiveAdViewUnitController: Overriding remote config refresh interval - value too low. Setting to default: %d -> %d", Integer.valueOf(i), 30);
            this.d = 30;
        }
    }

    public InneractiveAdViewUnitController(boolean z) {
        this();
        if (z) {
            this.d = -1;
        }
    }
}
